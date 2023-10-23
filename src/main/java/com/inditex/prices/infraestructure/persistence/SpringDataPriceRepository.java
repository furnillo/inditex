package com.inditex.prices.infraestructure.persistence;

import com.inditex.prices.infraestructure.entity.PriceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Integer> {
    List<PriceEntity> findByProductId(Integer id);
}
