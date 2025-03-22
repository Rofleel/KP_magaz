package ru.ystu.eshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity// сущность
@Data // Lombok

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Hibernate автоматически выбирает стратегию генерации ID
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // подгрузка категории только по запросу
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    private double price;
    private String description;
    private String imageName;
}
