package dev.fiasco.ShortLink.controller;

import dev.fiasco.ShortLink.Links.Link;
import dev.fiasco.ShortLink.Links.LinkResponse;
import dev.fiasco.ShortLink.service.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;



@RestController
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/shortlink")
    public ResponseEntity<LinkResponse> gerarUrlShort(@RequestBody Map<String, String> request) {
        String urlOriginal = request.get("urlOriginal");
        Link link = linkService.encurtarUrl(urlOriginal);

        String gerarUrlDirecionamento = "http://localhost:8080/r/" + link.getUrlShort();

        LinkResponse response = new LinkResponse(
                link.getId(),
                link.getUrlLong(),
                gerarUrlDirecionamento,
                link.getUrlCriadaEm()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/r/{urlEncurtada}")
    public void redirecionarLink(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException{
        Link link = linkService.obterUrlOriginal(urlEncurtada);

        if (link != null){
            response.sendRedirect(link.getUrlLong());
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
