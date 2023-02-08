package dbva.bookzone2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "avtor", schema = "project")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avtor",nullable = false)
    private Integer id;
    @Column(name = "ime",nullable = false, length = 50)
    private String name;
    @Column(name = "prezime",nullable = false, length = 50)
    private String surname;
}
