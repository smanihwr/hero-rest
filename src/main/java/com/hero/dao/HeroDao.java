package com.hero.dao;

import com.hero.model.Hero;
import com.hero.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroDao {

    @Autowired
    HeroRepository heroRepository;

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }
}
