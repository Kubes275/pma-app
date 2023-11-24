package sk.jra.pmaapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.jra.pmaapp.data.entities.PropertyEntity;

import java.util.List;

@Repository
public interface PropertiesRepository extends JpaRepository<PropertyEntity, Long> {

  List<PropertyEntity> findAllByOrderById();

}
