package com.yzit.plateform.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
	@RequestMapping("index.shtml")
	public String index( Model model ){
		model.addAttribute("name", "发大水范德萨范德萨范德萨范德萨");
		return "index";
	}
	@RequestMapping("test.shtml")
	public String test(){
		return "test";
	}
}
