package com.github.slfotg.giphy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.slfotg.giphy.domain.GifCategory;

@Repository
public interface GifCategoryRepository extends JpaRepository<GifCategory, Long> {

}
