package ru.ystu.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ystu.eshop.model.Product;
import ru.ystu.eshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct() {return productRepository.findAll();} // возвращаем список всех товаров
    public void addProduct(Product product) {productRepository.save(product);} // добавляем новый товар
    public void removeProductById(long id) {productRepository.deleteById(id);} // удаляем товар по айди
    public Optional<Product> getProductById(long id) {return productRepository.findById(id);} // поиск товара по айди
    public List<Product> getAllProductsByCategoryId(int id) { // поиск товара по айди категории
        return productRepository.findAllByCategory_Id(id);
    }


}
