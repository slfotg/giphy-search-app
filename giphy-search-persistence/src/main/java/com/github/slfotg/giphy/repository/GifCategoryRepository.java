package com.github.slfotg.giphy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.slfotg.giphy.domain.GifCategory;

public interface GifCategoryRepository extends JpaRepository<GifCategory, Long> {

}
