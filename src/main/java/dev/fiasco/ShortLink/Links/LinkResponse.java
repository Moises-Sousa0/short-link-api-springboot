package dev.fiasco.ShortLink.Links;


import jakarta.persistence.*;

import java.time.LocalDateTime;


public class LinkResponse {
    private Long id;
    private String urlLong;
    private String urlShort;
    private LocalDateTime urlCriadaEm;


    public LinkResponse(Long id, String urlLong, String urlShort, LocalDateTime urlCriadaEm) {
        this.id = id;
        this.urlLong = urlLong;
        this.urlShort = urlShort;
        this.urlCriadaEm = urlCriadaEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public String getUrlShort() {
        return urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    public LocalDateTime getUrlCriadaEm() {
        return urlCriadaEm;
    }

    public void setUrlCriadaEm(LocalDateTime urlCriadaEm) {
        this.urlCriadaEm = urlCriadaEm;
    }


}
