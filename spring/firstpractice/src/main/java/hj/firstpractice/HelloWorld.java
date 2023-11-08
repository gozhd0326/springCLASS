package hj.firstpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {
@GetMapping("/hello")
public String hello() {
	return "redirect:hello2.html";
}
}
