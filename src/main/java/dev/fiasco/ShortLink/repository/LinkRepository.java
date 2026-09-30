package dev.fiasco.ShortLink.repository;

import dev.fiasco.ShortLink.Links.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByUrlShort(String urlShort);
}
