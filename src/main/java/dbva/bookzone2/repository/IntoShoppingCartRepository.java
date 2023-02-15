package dbva.bookzone2.repository;

import dbva.bookzone2.model.primarykeys.IntoShoppingCartID;
import dbva.bookzone2.model.relations.IntoShoppingCartRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntoShoppingCartRepository extends JpaRepository<IntoShoppingCartRelation, IntoShoppingCartID> {

    List<IntoShoppingCartRelation> findAllById_ShoppingCartId(Integer id);
}
