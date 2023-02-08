package dbva.bookzone2.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "klient", schema = "project")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clen")
    private Integer id;
    @Column(name = "ime", length = 50,nullable = false)
    private String name;
    @Column(name = "prezime", length = 50,nullable = false)
    private String surname;
    @Column(name = "telefonski_broj", length = 15,nullable = false)
    private String phoneNumber;
    @Column(name = "datum_zaclenuvanje", nullable = false)
    private LocalDate joinedDate;
    @Column(name = "lozinka", length = 20,nullable = false)
    private String password;
    @OneToOne
    @JoinColumn(name = "tip_id")
    private Type type;
    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;

    public User(String name, String surname, String phoneNumber, LocalDate joinedDate, String password, Type type) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.joinedDate = joinedDate;
        this.password = password;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
