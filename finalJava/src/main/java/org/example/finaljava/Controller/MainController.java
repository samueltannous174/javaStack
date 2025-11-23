package org.example.finaljava.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.finaljava.Models.LoginUser;
import org.example.finaljava.Models.Tag;
import org.example.finaljava.Models.Task;
import org.example.finaljava.Models.User;
import org.example.finaljava.Services.TagService;
import org.example.finaljava.Services.TaskServices;
import org.example.finaljava.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Controller
public class MainController {

    private  final UserService userService;
    private final TaskServices taskServices;
    private final TagService tagService;

    public MainController(UserService userService, TaskServices taskServices, TagService tagService) {
        this.userService = userService;
        this.taskServices = taskServices;
        this.tagService = tagService;
    }

    @RequestMapping ("/**")
    public String Error404(@ModelAttribute("newUser") User newUser, @ModelAttribute("user") LoginUser user){
        return "error404";
    }


    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model, @RequestParam("type") String type){
        Long loggedId = (Long) session.getAttribute("id");
        if (loggedId == null) {
            return "redirect:/";
        }
        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);



        if (type.equals("all")  ){
            List<Task> tasks = taskServices.findAllByUser(logged);
            model.addAttribute("tasks",tasks);

            List<Task> importantTasks = taskServices.findAllByTypeAndUser("Important", logged);
            model.addAttribute("importantTasks",importantTasks);

        } else if (type.contains("Tag")) {
            List<Task> tasks = taskServices.findAll();
            model.addAttribute("tasks",tasks);

            List<Task> importantTasks = taskServices.findAllByUser( logged);
            model.addAttribute("importantTasks",importantTasks);


            if (session.getAttribute("tags") == null){
                List<Tag> tagObjects = Arrays.asList(
                        new Tag("Brainstorm"),
                        new Tag("Personal Growth"),
                        new Tag("Review"),
                        new Tag("Inspiration")
                );


                session.setAttribute("tags", tagObjects);
                tagObjects.forEach(tag -> {
                    if (!tagService.existsByName(tag.getName())){
                        tagService.createTag(tag);
                    }});

            }

            List<Tag> tagObjects = (List<Tag>) session.getAttribute("tags");
            model.addAttribute("tags", tagObjects);

        } else {
            List<Task> tasks = taskServices.findAllByTypeAndUser(type, logged);
            model.addAttribute("tasks",tasks);
            System.out.println(tasks);

            List<Task> importantTasks = taskServices.findAllByTypeAndUser("Important", logged);
            model.addAttribute("importantTasks",importantTasks);

        }

        return "dashboard";
    }



    @GetMapping("/")
    public String showAuth(
            @ModelAttribute("newUser") User newUser,
            @ModelAttribute("user") LoginUser user,
            HttpSession session,
            Model model) {

        Long loggedId = (Long) session.getAttribute("id");
        System.out.println(loggedId);
        if (loggedId != null) {
            return "redirect:/dashboard?type=all";
        }

        return "auth";
    }

    @PostMapping  ("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, @ModelAttribute("user") LoginUser user2, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");
        System.out.println("entered1");
        System.out.println(newUser);


        if (loggedId != null) {
            return "redirect:/dashboard?type=all";
        }
        System.out.println("entered2");

        if (result.hasErrors()) {
            return "auth";
        }

        User user= userService.register(newUser,result);
        System.out.println(user);
        if (result.hasErrors()) {
            return "auth";
        }

        if (session.getAttribute("id") == null){
            session.setAttribute("id", user.getId());
        }


        return "redirect:/dashboard?type=all";
    }



    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") LoginUser user, BindingResult result, @ModelAttribute("newUser") User newUser, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId != null) {
            return "redirect:/dashboard?type=all";
        }

        if(result.hasErrors()){
            return "auth";
        }
        User loggedUser=userService.login(user, result);

        if(result.hasErrors()){
            return "auth";
        }
        if (session.getAttribute("id") == null){
            session.setAttribute("id", loggedUser.getId());
        }
        return "redirect:/dashboard?type=all";
    }
    @PostMapping("/logout")
    public String logout(HttpSession session){
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }


    @GetMapping("/newTask")
    public String showNewTaskForm(@ModelAttribute("task") Task task, HttpSession session, Model model) {
        Long loggedId = (Long) session.getAttribute("id");
        if (loggedId == null) {
            return "redirect:/";
        }

        User logged = userService.findUser(loggedId);
        if (logged == null) {
            session.invalidate();
            return "redirect:/";
        }


        if (session.getAttribute("tags") == null){
            List<Tag> tagObjects = Arrays.asList(
                    new Tag("Brainstorm"),
                    new Tag("Personal Growth"),
                    new Tag("Review"),
                    new Tag("Inspiration")
            );
            session.setAttribute("tags", tagObjects);
            tagObjects.forEach(tag -> {
                    tagService.createTag(tag);
                });

        }
        List<Tag> tagObjects = (List<Tag>) session.getAttribute("tags");
        System.out.println(tagObjects);
        model.addAttribute("tags", tagObjects);



        model.addAttribute("logged", logged);
        return "createTask";
    }


    @PostMapping("/create_task")
    public String createBook(@Valid @ModelAttribute("task") Task task, BindingResult result, @RequestParam("user_id") Long user_id, HttpSession session , Model model, @RequestParam("selectedTag") List<Long> selectedOptions){
        Long loggedId = (Long) session.getAttribute("id");
        System.out.println("selectedOptions");

        System.out.println(selectedOptions);
        if (loggedId == null){
            return "redirect:/";
        }


        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);

        System.out.println("entered3");
        if (result.hasErrors()){
            model.addAttribute("tags", session.getAttribute("tags"));
            return "createTask";
        }
        System.out.println("entered4");

        if (selectedOptions.contains(-1L)) {
            selectedOptions.remove(-1L);
        }
        System.out.println(selectedOptions);
        if (selectedOptions != null){
            selectedOptions.stream().map(option -> tagService.findTag(option))
                    .filter(Objects::nonNull)
                    .forEach(tag -> taskServices.addTag(tag, task));
        }


        System.out.println("entered4");
        Task createdTask = taskServices.createTask(task);
        System.out.println("entered5");

        createdTask.setType("Inprogress");
        createdTask.setUser(logged);
        taskServices.save(createdTask);

        return "redirect:/dashboard?type=all";
    }

    @GetMapping("task/{id}")
    public String showBook(@PathVariable("id") Long id,Model model ,HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/";
        }

        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);


        Task task = taskServices.findTask(id);

        if (task == null){
            return "redirect:/dashboard?type=all";
        }
        model.addAttribute("task",task);
        return "showTask";
    }

    @GetMapping("/edit/{id}")
    public String showEditBook( @PathVariable("id") Long id,Model model, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/";
        }
        User logged = userService.findUser(loggedId);
        model.addAttribute("logged",logged);

        Task task = taskServices.findTask(id);


        if (task == null){
            return "redirect:/dashboard?type=all";
        }

        if (task.getUser().getId() != loggedId){
            return "redirect:/dashboard?type=all";
        }
        model.addAttribute("tags", session.getAttribute("tags"));

        model.addAttribute("task",task);

        return "editTask";
    }

    @PutMapping ("/edit_task")
    public String editBook(@Valid @ModelAttribute ("task") Task task , BindingResult result , HttpSession session, Model model){

        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/";
        }


        if (result.hasErrors()){
            return "editTask";
        }

        taskServices.save(task);

        return "redirect:/dashboard?type=all";
    }


    @PostMapping("/important")
    public String important(@RequestParam("id") Long id, HttpSession session){
        System.out.println("printed");
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/";
        }

        User logged = userService.findUser(loggedId);
        Task task = taskServices.findTask(id);

        if (task.getType().equals("Important")){
            task.setType("Inprogress");
        }else if (task.getType().equals("Inprogress")){
            task.setType("Important");
        }
        taskServices.save(task);



        return "redirect:/dashboard?type=all";
    }

    @DeleteMapping("delete_task")
    public String deleteBook(HttpSession session, Model model, @RequestParam("id") Long id){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/auth";
        }

        taskServices.deleteTask(id);

        return "redirect:/";
    }

    @PostMapping("/change_type")
    public String changeType(@RequestParam("id") Long id, @RequestParam("type") String type, HttpSession session){
        Long loggedId = (Long) session.getAttribute("id");

        if (loggedId == null){
            return "redirect:/";
        }

        User logged = userService.findUser(loggedId);
        Task task = taskServices.findTask(id);

        task.setType(type);
        taskServices.save(task);

        return "redirect:/dashboard?type=all";
    }





}
