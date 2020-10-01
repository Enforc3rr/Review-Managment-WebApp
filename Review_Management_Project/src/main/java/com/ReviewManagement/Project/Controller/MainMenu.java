package com.ReviewManagement.Project.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainMenu {
	@GetMapping("/")
	public String mainMenuContoller() {
		return "RMA.";
	}
}