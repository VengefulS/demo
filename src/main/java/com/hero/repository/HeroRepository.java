package com.hero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hero.entity.Hero;

@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroRepository extends JpaRepository<Hero, Long> {
	@Query("select h from Hero h where lower(h.name) like CONCAT('%', lower(:name), '%')")
	public List<Hero> findByName(@Param("name") String name);
}