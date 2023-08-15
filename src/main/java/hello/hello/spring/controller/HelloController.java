package hello.hello.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //hello라고 들어오면 이 모델을 mapping해준다
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";

    }

    @GetMapping("hello-mvc")//Requestparam:외부에서 값을 입력받음
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);//파라미터로 넘어온 데이터의 속성, name= spring으로 입력을 받으면, 이 컨트롤러의 name이 모두 spring으로 인식
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody//http의 body에 내용을 직접 넣어주겠다.
    public String helloString(@RequestParam("name")String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName("")
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    }

