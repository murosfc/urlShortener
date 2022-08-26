package com.uurl.model;

import java.security.SecureRandom;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class UrlTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 10)
    private String tag;

    @Column
    @Lob
    @URL
    @NotNull
    private String URL;

    private final int tagLen = 8;
    private final String chars = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";

    public UrlTag() {        
        this.URL = "";        
    }

    public UrlTag(String tag, String uRL) {
        this.tag = tag;
        URL = uRL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }


    @Override
    public int hashCode() {
        return Objects.hash(URL, tag);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UrlTag other = (UrlTag) obj;
        return Objects.equals(URL, other.URL) && Objects.equals(tag, other.tag);
    }

    public void generateAndSetTag() {
        StringBuilder sb = new StringBuilder(tagLen);
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < tagLen; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        this.tag = sb.toString();
    }

}
