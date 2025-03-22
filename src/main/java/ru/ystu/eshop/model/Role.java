package ru.ystu.eshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data // Lombok
@Entity // Сущность
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // автоматическая генерация айди
    private Integer id;

    @Column(nullable = false, unique = true) // запрещаем null и дублирование
    @NotEmpty // проверка что поле не пустое
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users; // хранение всех пользователей с данной ролью

}
