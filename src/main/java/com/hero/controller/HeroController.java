package com.hero.controller;

import com.hero.dao.HeroDao;
import com.hero.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeroController {

    @Autowired
    HeroDao heroDao;

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getHeroes() {
        return ResponseEntity.ok().body(heroDao.findAll());
    }
}