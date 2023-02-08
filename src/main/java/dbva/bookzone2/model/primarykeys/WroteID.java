package dbva.bookzone2.model.primarykeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class WroteID implements Serializable {

    @Column(name = "id_kniga" , nullable = false)
    private String bookId;
    @Column(name = "id_avtor", nullable = false)
    private Integer authorId;

    public WroteID(String bookId, Integer authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public WroteID() {

    }
}