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
    @OneToMany
    @JoinColumn(name = "isbn")
    @Column(name = "kniga_id")
    private List<Book> books;
}
