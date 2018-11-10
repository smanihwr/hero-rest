package com.hero.repository;

import com.hero.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findByNameIsContaining(String name);
}
