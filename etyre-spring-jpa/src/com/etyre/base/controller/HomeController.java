/**
 * 
 */
package com.etyre.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ssd1kor
 *
 */
@Controller
public class HomeController {

	@RequestMapping({"/","/home"})
	public String showHomePage(){
		return "home";
	}
	
	@RequestMapping("/login")
	public String displayLoginForm(){
		return "login";
	}
}
