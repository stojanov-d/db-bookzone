package dbva.bookzone2.model.primarykeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class IntoShoppingCartID implements Serializable {

    private static final long serialVersionUID = 2844920835203496833L;
    @Column(name = "id_kniga" , nullable = false)
    private String bookId;
    @Column(name = "id_kosnicka", nullable = false)
    private Integer shoppingCartId;

    public IntoShoppingCartID(String bookId, Integer shoppingCartId) {
        this.bookId = bookId;
        this.shoppingCartId = shoppingCartId;
    }

    public IntoShoppingCartID() {

    }
}
