package com.hero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hero.entity.Hero;
import com.hero.service.HeroService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)//(value = "{api.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeroController {
	@Autowired
	private HeroService heroService;

	/*
	 * @GetMapping("heroes/{id}") public Hero getHeroById(@PathVariable("id") Long
	 * id) { return heroService. }
	 */
	@GetMapping("/heroes")
	public List<Hero> getHeroes() {
		return heroService.getAll();
	}

	@GetMapping("/heroes/")
	public List<Hero> searchHeroes(@RequestParam("name") String name) {
		return heroService.findHeroByName(name);
	}
	
	@PostMapping("/heroes")
    public Hero addHero(@RequestBody Hero hero) {
        return heroService.saveHero(hero);
    }

    @PutMapping("/heroes")
    public Hero updateHero(@RequestBody Hero hero) {
        return heroService.saveHero(hero);
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHero(@PathVariable("id") Long id) {
    	heroService.deleteHero(id);
    }
}
