package hj.firstpractice.simpleRestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestAPIController {

	
	@GetMapping("/restAPI")
	public Number getNumber() {
		return new Numbmer(1234,5678);
	}
}
