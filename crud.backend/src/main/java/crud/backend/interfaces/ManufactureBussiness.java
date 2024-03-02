package crud.backend.interfaces;

import crud.backend.dto.ManufactureDTO;

import java.util.List;

public interface ManufactureBussiness {

    ManufactureDTO manufactureSave(ManufactureDTO dto);

    List<ManufactureDTO> manufactureFindAll();

    ManufactureDTO manufactureFindById(Long id);

    String manufactureUpdate(Long id, ManufactureDTO dto);

    String manufactureDelete(Long id);

}
