package dbva.bookzone2.repository;

import dbva.bookzone2.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {

    ShoppingCart findShoppingCartByUser_Name(String name);
}
