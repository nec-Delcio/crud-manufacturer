package crud.backend.resources;

import crud.backend.dto.ManufactureDTO;
import crud.backend.services.ManufactureServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufactureResource {

    @Autowired
    private ManufactureServices services;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<ManufactureDTO>> findAll() {
        return ResponseEntity.ok(services.manufactureFindAll());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ManufactureDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(services.manufactureFindById(id));
    }


    @PostMapping(value = "/create")
    public void create (@RequestBody ManufactureDTO dto){
        services.manufactureSave(dto);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> update (@PathVariable Long id, @RequestBody ManufactureDTO dto) {
        return ResponseEntity.ok(services.manufactureUpdate(id, dto));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        return ResponseEntity.ok(services.manufactureDelete(id));
    }
}
