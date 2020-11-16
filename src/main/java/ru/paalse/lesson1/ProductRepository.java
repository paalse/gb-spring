package ru.paalse.lesson1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
    }

    @PostConstruct
    public void init(){
        productList.add(new Product(1l, "apple", 50.0));
        productList.add(new Product(2l, "lemon", 75.0));
        productList.add(new Product(3l, "orange", 100.0));
        productList.add(new Product(4l, "carrot", 125.0));
        productList.add(new Product(5l, "potato", 150.0));
    }

    /**
     * Получение списка продуктов
     * @return
     */
    public List<Product> findAll(){
        return Collections.unmodifiableList(productList); // Возвращает список который нельзя изменить
    }

    /**
     * Получение одного продука по id
     * @param id
     * @return
     */
    public Product findProductById(Long id) {
        return productList.get(id.byteValue());
    }

    /**
     * Добавить продукт
     * @param product
     */
    public void addProduct(Product product){
        productList.add(product);
    }
}
