package com.hero.controller;

import com.hero.dao.HeroDao;
import com.hero.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {

    @Autowired
    HeroDao heroDao;

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getAll() {
        return ResponseEntity.ok().body(heroDao.findAll());
    }

    @GetMapping("/heroes/{id}")
    public ResponseEntity<Hero> get(@PathVariable("id") Long id) {
        Optional<Hero> hero = heroDao.findByID(id);
        if(hero.isPresent()) {
            return ResponseEntity.ok().body(hero.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/heroes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> save(@RequestBody Hero hero) {
        return ResponseEntity.ok().body(this.heroDao.save(hero));
    }

    @PutMapping(value = "/heroes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> update(@RequestBody Hero newHero) {
        final Optional<Hero> hero = this.heroDao.findByID(newHero.getId());
        if(hero.isPresent()) {
            hero.get().setName(newHero.getName());
            Hero savedHero = this.heroDao.save(hero.get());
            return ResponseEntity.ok().body(savedHero);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/heroes/{id}")
    public ResponseEntity<Hero> delete(@PathVariable("id") Long id) {
        Optional<Hero> heroByID = this.heroDao.findByID(id);
        if(heroByID.isPresent()) {
            Hero hero = heroByID.get();
            this.heroDao.delete(id);
            return ResponseEntity.ok().body(hero);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/searchHeroes")
    public ResponseEntity<List<Hero>> searchHeroes(@RequestParam("name") String name) {
        List<Hero> heroList = this.heroDao.findByName(name);
        return ResponseEntity.ok().body(heroList);
    }

}