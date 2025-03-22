package ru.ystu.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ystu.eshop.model.Category;
import ru.ystu.eshop.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service // часть Spring Framework, внедрение класса в другие части приложения
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository; // внедрение зависимости для поля
    public List<Category> getAllCategory() {return categoryRepository.findAll();} // список всех категорий
    public void addCategory(Category category) {categoryRepository.save(category);} // добавление
    public void removeCategoryById(int id) {categoryRepository.deleteById(id);} // удаление
    public Optional<Category> getCategoryById(int id) {return categoryRepository.findById(id);} // поиск по ID
}
