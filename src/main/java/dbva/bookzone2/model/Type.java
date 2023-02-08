package dbva.bookzone2.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "tip", schema = "project")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id")
    private Integer id;
    @Column(name = "tip_ime")
    private String typeName;
}
