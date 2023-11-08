package hj.firstpractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {
@GetMapping("/hi")
public String hi() {
	return "hi~~";
}
}
