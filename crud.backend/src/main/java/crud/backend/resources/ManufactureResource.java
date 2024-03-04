package crud.backend.resources;

import crud.backend.dto.ManufactureDTO;
import crud.backend.services.ManufactureServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ManufactureResource {

    @Autowired
    private ManufactureServices services;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "/create")
    public ResponseEntity<ManufactureDTO> create (@RequestBody ManufactureDTO dto){
        dto = services.manufactureSave(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/find/{id}")
                .buildAndExpand(dto.getManufactureId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // FindAll
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/find/all")
    public ResponseEntity<List<ManufactureDTO>> findAll() {
        return ResponseEntity.ok(services.manufactureFindAll());
    }

    // FindAll by Pages
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/find/allpages")
    public ResponseEntity<Page<ManufactureDTO>> pageFindAll(Pageable pageable) {
         return ResponseEntity.ok(services.manufacturePageFindAll(pageable));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ManufactureDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(services.manufactureFindById(id));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ManufactureDTO> update (@PathVariable Long id, @RequestBody ManufactureDTO dto) {
        return ResponseEntity.ok(services.manufactureUpdate(id, dto));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        return ResponseEntity.ok(services.manufactureDelete(id));
    }
}
