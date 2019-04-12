package com.hero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hero.entity.Hero;
import com.hero.repository.HeroRepository;

@Service
public class HeroService {
	@Autowired
	private HeroRepository heroRepository;
	
	public List<Hero> getAll(){
		return heroRepository.findAll();		
	}
	
	public Hero saveHero(Hero hero) {
		return heroRepository.save(hero);
	}
	
	public void deleteHero(Long id) {
		heroRepository.deleteById(id);
	}
	
	public List<Hero> findHeroByName(String name) {
		return heroRepository.findByName(name);
	}
	/*
	public Hero getHeroById(Long id) {
        return heroRepository.findById(id);
    }
	*/

}
