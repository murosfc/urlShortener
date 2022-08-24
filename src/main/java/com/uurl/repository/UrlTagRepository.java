package com.uurl.repository;

import com.uurl.model.UrlTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlTagRepository extends JpaRepository<UrlTag, Long>{
	
	@Query("SELECT u FROM UrlTag u WHERE u.tag =:incomingTag")
	public UrlTag getByTag(String incomingTag);

}
