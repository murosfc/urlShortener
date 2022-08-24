package com.uurl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uurl.model.UrlTag;
import com.uurl.repository.UrlTagRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class MicroUrlApplication implements CommandLineRunner{
	
    @Autowired
    private UrlTagRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(MicroUrlApplication.class, args);		
	}
	
        @Override
	 public void run(String... args) throws Exception {
		 UrlTag url = new UrlTag("MINIURL", "http://www.google.com");
		 repo.save(url);
		 
	 }
	 

}
