package dbva.bookzone2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "kniga",schema = "project")
public class Book {

    @Id
    @Column(name = "isbn", nullable = false, length = 17)
    private String id;
    @Column(name = "naslov", nullable = false)
    private String title;
    @Column(name = "rejting", nullable = true)
    private Integer rating;
    @Column(name = "dali_se_prodava", nullable = false)
    private Boolean forSale;
    @Column(name = "cena", nullable = false)
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "izd_id")
    private PublishingHouse publishingHouse;
//    @ManyToOne
//    private ShoppingCart shoppingCart;
    public Book(String isbn, String title, Integer rating, Boolean forSale, Integer price) {
        this.id = isbn;
        this.title = title;
        this.rating = rating;
        this.forSale = forSale;
        this.price = price;
    }

    public Book() {

    }





}
