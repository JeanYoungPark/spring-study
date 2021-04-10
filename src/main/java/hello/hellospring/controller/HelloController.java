package hello.hellospring.controller;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//test
@Controller
public class HelloController {
    
    @GetMapping("hello") // '/hello'라고 들어오면 이곳으로 이동
    public String hello(Model model){ //mvc중에 m을 의미
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,Model model) {
        model.addAttribute("name",name);
        return "hello-template"; //이 이름을 가지고 template을 찾는다.
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello "+name; //문자그대로 화면에 뿌려짐
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 넘겨줌
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
