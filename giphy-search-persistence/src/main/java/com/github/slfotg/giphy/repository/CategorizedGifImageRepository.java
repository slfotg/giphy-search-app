package com.github.slfotg.giphy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.slfotg.giphy.domain.CategorizedGifImage;
import com.github.slfotg.giphy.domain.CategorizedGifImage.CategorizedGifImageId;

@Repository
public interface CategorizedGifImageRepository extends JpaRepository<CategorizedGifImage, CategorizedGifImageId> {

}
