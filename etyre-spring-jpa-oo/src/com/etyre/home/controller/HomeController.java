/**
 * 
 */
package com.etyre.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author ssd1kor
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showHomePage(){
		return "home";
	}
	
}
