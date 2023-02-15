package dbva.bookzone2.model.relations;

import dbva.bookzone2.model.primarykeys.IntoShoppingCartID;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pripaga_vo", schema = "project")
public class IntoShoppingCartRelation {

    @EmbeddedId
    private IntoShoppingCartID id;

    public IntoShoppingCartRelation(IntoShoppingCartID id) {
        this.id = id;
    }

    public IntoShoppingCartRelation() {

    }
}
