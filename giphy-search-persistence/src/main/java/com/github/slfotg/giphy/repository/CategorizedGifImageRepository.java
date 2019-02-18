package com.github.slfotg.giphy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.slfotg.giphy.domain.CategorizedGifImage;

public interface CategorizedGifImageRepository extends JpaRepository<CategorizedGifImage, Long> {

}
