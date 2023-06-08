package cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruta")
public class FruitaController {

    private final FrutaRepository frutaRepository;

    @Autowired
    public FruitaController(FrutaRepository frutaRepository) {
        this.frutaRepository = frutaRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruta> addFruta(@RequestBody Fruta fruta) {
        if (fruta.getId() != 0 && frutaRepository.existsById(fruta.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fruta nuevaFruta = frutaRepository.save(fruta);
        return new ResponseEntity<>(nuevaFruta, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruta> updateFruta(@RequestBody Fruta fruta) {
        if (fruta.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Fruta> frutaExistente = frutaRepository.findById(fruta.getId());
        if (frutaExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Fruta frutaExistenteActualizada = frutaExistente.get();
        frutaExistenteActualizada.setNombre(fruta.getNombre());
        frutaExistenteActualizada.setCantidadQuilos(fruta.getCantidadQuilos());
        Fruta frutaActualizada = frutaRepository.save(frutaExistenteActualizada);

        return new ResponseEntity<>(frutaActualizada, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruta(@PathVariable int id) {
        Optional<Fruta> frutaExistente = frutaRepository.findById(id);
        if (frutaExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        frutaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta> getFruta(@PathVariable int id) {
        Optional<Fruta> frutaExistente = frutaRepository.findById(id);
        if (frutaExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(frutaExistente.get(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAllFrutas() {
        List<Fruta> frutas = frutaRepository.findAll();
        return new ResponseEntity<>(frutas, HttpStatus.OK);
    }
}
