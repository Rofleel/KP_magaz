package ru.ystu.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ystu.eshop.model.Product;
import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> { // предоставление бд с помощию Spring Data JPA
    List<Product> findAllByCategory_Id(int id); // все продукты, принадлежащие категории с заданным ID
}
