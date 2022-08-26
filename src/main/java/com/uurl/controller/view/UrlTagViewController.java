package com.uurl.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.uurl.model.UrlTag;
import com.uurl.service.UrlTagService;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class UrlTagViewController {

    @Autowired
    private UrlTagService service;

    @GetMapping
    public String start(Model model) {
        model.addAttribute("urlshortener", new UrlTag());
        return "index";
    }

    @PostMapping(path = "/new")
    public String save(@ModelAttribute UrlTag urlTag, Model model, BindingResult result) {
        if (result.hasErrors()){            
            model.addAttribute("msgErros", result.getAllErrors());
            return "index";
        }
        try{ 
            UrlTag saved = service.save(urlTag);
            model.addAttribute("urlshortener", saved);
            String newUrl = "http:" + "//localhost:8080/" + saved.getTag();
            model.addAttribute("newUrl", newUrl);             
            model.addAttribute("msgSucesso", "URL gerada com sucesso");
            return "index";
        }catch (Exception e){            
            model.addAttribute("msgErros", List.of(new ObjectError("url", e.getMessage())));            
            return "index";
        }       
    }

}
