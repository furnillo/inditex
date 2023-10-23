package com.inditex.prices.infraestructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "BRAND")
public class BrandEntity {

    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<PriceEntity> prices;
}
