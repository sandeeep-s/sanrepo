/**
 * 
 */
package com.etyre.home.controller;


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
	
}
