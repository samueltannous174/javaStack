package org.example.human;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {


    @RequestMapping("/")
    public String index2(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "last", required = false) String last,  @RequestParam(value = "times", required = false) String times) {
        if (name == null && last == null) {
            return "Hello Human";
        }
        if (name != null && last != null) {
            return "Hello   " + name+ " " + last;

        }

        return "Hello    " + name ;
    }

    @RequestMapping("/h")
    public StringBuilder index3(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "times", required = false) String times) {
        StringBuilder text= new StringBuilder("hello"+"  "+name+"  ");
        if (times  != null){
            for (int i = 0; i < Integer.parseInt(times); i++) {
                text.append("hello").append("  ").append(name).append("  ");}

            return text;
        }
        StringBuilder text2= new StringBuilder("name ");

        return text2 ;
    }



}
