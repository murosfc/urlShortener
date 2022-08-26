package com.uurl.service;

import com.uurl.model.UrlTag;
import com.uurl.repository.UrlTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UrlTagService {
	
	@Autowired
	private UrlTagRepository repo;
	
	public UrlTag getUrlByTag(String incomingTag) {
		return repo.getByTag(incomingTag);		
	}
	
	public UrlTag save (UrlTag urlTag) {
		if (urlTag.getTag() == null) {
			urlTag.generateAndSetTag();
		}
		try {
			return repo.save(urlTag);
		}
		catch (Exception e) {
			throw new RuntimeException("Erro ao salvar URL");
		}
	}

}
