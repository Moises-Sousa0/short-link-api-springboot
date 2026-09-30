package dev.fiasco.ShortLink.service;

import dev.fiasco.ShortLink.Links.Link;
import dev.fiasco.ShortLink.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class LinkService {
    private LinkRepository linkRepository;


    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String gerarUrlAleatoria(){
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public Link encurtarUrl(String urlOriginal){
        Link link = new Link();
        link.setUrlLong(urlOriginal);
        link.setUrlShort(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());

        return linkRepository.save(link);
    }
    public Link obterUrlOriginal(String urlShort){
      try {
          return linkRepository.findByUrlShort(urlShort);
      }catch (Exception erro){
          throw new RuntimeException("Url nao exisite em nossos registros");
      }
    }

}
