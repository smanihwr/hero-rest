package com.hero.dao;

import com.hero.model.Hero;
import com.hero.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroDao {

    @Autowired
    HeroRepository heroRepository;

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public Optional<Hero> findByID(Long id) {
        return heroRepository.findById(id);
    }

    public Hero save(Hero hero) {
        return this.heroRepository.save(hero);
    }

    public void delete(Long id) {
        this.heroRepository.deleteById(id);
    }

    public List<Hero> findByName(String name) {
        return this.heroRepository.findByNameIsContaining(name);
    }
}
