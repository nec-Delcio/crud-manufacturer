package crud.backend.core.repositories;

import crud.backend.core.entities.ManufactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository <ManufactureEntity, Long> {


    // @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM manufacturer_base m WHERE m.manufacturerCnpj = :cnpj")
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM manufacturer_base WHERE manufacturer_cnpj = :cnpj", nativeQuery = true)
    boolean findCnpj(String cnpj);
}
