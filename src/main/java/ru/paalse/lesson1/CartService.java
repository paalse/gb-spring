package ru.paalse.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("cartService")
@Scope("prototype")
public class CartService {
    private ProductRepository productRepository;

    private List<Product> cartList = new ArrayList<>();

    public CartService() {
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Добавление продукта в корзину
     * @param id
     */
    public void addProductToCart(Long id){
        cartList.add(productRepository.findProductById(id));
    }

    /**
     * Удаление продукта из корзины
     * @param id
     */
    public void deleteProductFromCart(Long id){
        cartList.remove(id);
    }

    @Override
    public String toString() {
        return "CartService{" +
                "cartList=" + cartList +
                '}';
    }
}