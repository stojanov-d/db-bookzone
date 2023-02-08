package dbva.bookzone2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "izdavacka_kukja", schema = "project")
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "izd_id",nullable = false)
    private Integer id;
    @Column(name = "adresa",length = 50)
    private String address;
    @Column(name = "naziv",nullable = false,length = 50)
    private String name;
    @OneToMany(mappedBy = "publishingHouse")
    private List<Book> bookList;
}