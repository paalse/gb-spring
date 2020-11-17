package ru.paalse.lesson1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс описывающий репозиторий продуктов
 */

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
     * Получение всего списка продуктов из репозитория
     * @return
     */
    public List<Product> findAll(){
        return Collections.unmodifiableList(productList); // Возвращает список который нельзя изменить
    }

    /**
     * Получение одного продука по id из репозитория
     * @param id
     * @return
     */
    public Product findProductById(Long id) {
        Product result = null;

        for (Product p: productList) {
            if (p.getId() == id) {
                result = p;
                break;
            }
        }
        return result;
    }

    /**
     * Добавить продукт в репозиторий
     * @param product
     */
    public void addProduct(Product product){
        productList.add(product);
    }
}
