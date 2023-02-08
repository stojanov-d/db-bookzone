package dbva.bookzone2.repository;

import dbva.bookzone2.model.primarykeys.WroteID;
import dbva.bookzone2.model.relations.WroteRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WroteRepository extends JpaRepository<WroteRelation, WroteID> {

    WroteRelation findByWroteID(WroteID wroteID);
}
