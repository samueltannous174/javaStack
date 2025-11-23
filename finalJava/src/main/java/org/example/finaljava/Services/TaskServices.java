package org.example.finaljava.Services;

import org.example.finaljava.Models.Tag;
import org.example.finaljava.Models.User;
import org.example.finaljava.Repositories.TaskRepository;
import org.example.finaljava.Models.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class TaskServices {
    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    public Task findTask(Long id){
        Optional optional = taskRepository.findById(id);
        if(optional.isPresent()){
            return (Task) optional.get();
        }
        return null;
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public void save(Task book){
        taskRepository.save(book);
    }

    public List<Task> findAllByType(String type){
        return taskRepository.findAllByType(type);
    }

    public List<Task> findAllByUser(User user){
        return taskRepository.findAllByUser(user);
    }

    public List<Task> findAllByTypeAndUser(String type, User user){
        return taskRepository.findAllByTypeAndUser(type, user);
    }


   public void addTag(Tag tag, Task task){
       task.addTag(tag);
    }
    public void deleteTask( Long id){
        taskRepository.deleteById(id);
    }






}
