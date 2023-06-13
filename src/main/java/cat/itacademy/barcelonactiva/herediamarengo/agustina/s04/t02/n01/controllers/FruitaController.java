package cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruta")
public class FruitaController {

    private final FrutaService frutaService;

    @Autowired
    public FruitaController(FrutaService frutaService) {
        this.frutaService = frutaService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruta> addFruta(@RequestBody Fruta fruta) {
        if (fruta.getId() != 0 && frutaService.getOne(fruta.getId()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fruta nuevaFruta = frutaService.add(fruta);
        return new ResponseEntity<>(nuevaFruta, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruta> updateFruta(@RequestBody Fruta fruta) {
        if (fruta.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fruta frutaExistente = frutaService.getOne(fruta.getId());
        if (frutaExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        frutaExistente.setNombre(fruta.getNombre());
        frutaExistente.setCantidadQuilos(fruta.getCantidadQuilos());
        Fruta frutaActualizada = frutaService.upd(frutaExistente);

        return new ResponseEntity<>(frutaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruta(@PathVariable int id) {
        Fruta frutaExistente = frutaService.getOne(id);
        if (frutaExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        frutaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta> getFruta(@PathVariable int id) {
        Fruta frutaExistente = frutaService.getOne(id);
        if (frutaExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(frutaExistente, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAllFrutas() {
        List<Fruta> frutas = frutaService.getAll();
        return new ResponseEntity<>(frutas, HttpStatus.OK);
    }
}
