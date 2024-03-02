package crud.backend.services;

import crud.backend.core.entities.ManufactureEntity;
import crud.backend.core.repositories.ManufactureRepository;
import crud.backend.core.utils.Utils;
import crud.backend.dto.ManufactureDTO;
import crud.backend.interfaces.ManufactureBussiness;
import crud.backend.services.exceptions.ManufactureInvalidCNPJ;
import crud.backend.services.exceptions.ManufactureNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufactureServices implements ManufactureBussiness {

    @Autowired
    private ManufactureRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ManufactureDTO manufactureSave(ManufactureDTO dto) {
        ManufactureEntity entitySaved = new ManufactureEntity();
        if (Utils.validateDto(dto)) {
            if (!repository.findCnpj(dto.getManufacturerCNPJ())) {
                dto.setManufacturerCNPJ(Utils.unMaskCNPJ(dto.getManufacturerCNPJ()));
                entitySaved = repository.save(modelMapper.map(dto, ManufactureEntity.class));
            } else {
                throw new ManufactureInvalidCNPJ("Duplicated CNPJ");
            }
        } else {
            throw new ManufactureInvalidCNPJ("Not registered!!! CNPJ null");
        }
        return dto = modelMapper.map(entitySaved, ManufactureDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ManufactureDTO> manufactureFindAll() {
        List<ManufactureEntity> list = repository.findAll();
        return list.stream().map(ManufactureDTO::new).collect(Collectors.toList());
    }

    @Override
    public ManufactureDTO manufactureFindById(Long id) {
        Optional<ManufactureEntity> entity = repository.findById(id);
        entity.get().setManufacturerCNPJ(Utils.maskedCNPJ(entity.get().getManufacturerCNPJ()));
        return new ManufactureDTO(entity.orElseThrow(()-> new ManufactureNotFoundException("Manufacture Not Found")));
    }

    @Override
    @Transactional
    public String manufactureUpdate(Long id, ManufactureDTO dto) {
        repository.findById(id).orElseThrow(() -> new ManufactureNotFoundException("Manufacture Not Found"));
        try {
            ManufactureEntity entity = repository.getOne(id);
            entity.setManufacturerName(dto.getManufacturerName());
            entity.setManufacturerCNPJ(Utils.unMaskCNPJ(dto.getManufacturerCNPJ()));
            entity.setManufacturerFantasyName(dto.getManufacturerFantasyName());
            entity.setManufacturerSocialName(dto.getManufacturerSocialName());
            entity.setManufacturerActive(dto.getManufacturerActive());
            entity.setManufacturerSite(dto.getManufacturerSite());
            entity.setManufacturerCountry(dto.getManufacturerCountry());
            entity.setManufacturerCity(dto.getManufacturerCity());
            entity.setManufactureNeighbourhood(dto.getManufactureNeighbourhood());
            repository.save(entity);

            return "Successfully updated!";
        } catch (RuntimeException e) {
            return "The update was not performed! id: " + dto.getManufactureId() + " - " + dto.getManufacturerName();
        }
    }

    @Override
    public String manufactureDelete(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Deleted successfully";
        }
        throw new ManufactureNotFoundException("Manufacture Not Found");
    }
}
