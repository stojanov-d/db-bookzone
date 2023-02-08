package dbva.bookzone2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "kosnicka", schema = "project")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kosnicka_id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "klient_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "kniga_id")
    private Book book;

    public ShoppingCart(User user){
        this.user = user;
    }

    public ShoppingCart() {

    }
}
