package com.uurl.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.uurl.model.UrlTag;
import com.uurl.service.UrlTagService;

@Controller
public class UrlTagViewController {
	
	@Autowired
	private UrlTagService service;
	
	public String save(@RequestBody UrlTag urlTag, Model model) {
		model.addAttribute("url", service.save(urlTag));
		return "urlshortener";
	}

}
