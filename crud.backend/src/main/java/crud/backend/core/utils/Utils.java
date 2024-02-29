package crud.backend.core.utils;

import crud.backend.core.entities.ManufactureEntity;
import crud.backend.dto.ManufactureDTO;

public class Utils {

    private static ManufactureDTO entityToDTO(ManufactureEntity entity) {
        return new ManufactureDTO(entity);
    }

    private static ManufactureEntity toEntity (ManufactureDTO dto) {
        ManufactureEntity entity = new ManufactureEntity();
        entity.setManufactureId(dto.getManufactureId());
        entity.setManufacturerActive(dto.getManufacturerActive());
        entity.setManufactureNeighbourhood(dto.getManufactureNeighbourhood());
        return entity;
    }

    public static boolean validateDto(ManufactureDTO dto) {
        if (dto.getManufacturerCNPJ() == null || dto.getManufacturerCNPJ().isEmpty() || dto.getManufacturerCNPJ().isBlank())
            return false;

       return true;

    }
}
