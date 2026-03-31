package com.ivr.ivrcardbin.repository;

import com.ivr.ivrcardbin.entity.CardBin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardBinRepository extends JpaRepository<CardBin, Long> {
    @Override
    Optional<CardBin> findById(Long aLong);

    Optional<CardBin> findBybin(String bin);

}