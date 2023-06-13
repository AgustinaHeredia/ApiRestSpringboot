package cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.repository.FrutaRepository;

public class FrutaServiceImpl implements FrutaService {
    private FrutaRepository frutaRepository;

    public FrutaServiceImpl(FrutaRepository frutaRepository) {
        this.frutaRepository = frutaRepository;
    }

    @Override
    public Fruta add(Fruta fruta) {
        return frutaRepository.save(fruta);
    }

    @Override
    public Fruta upd(Fruta fruta) {
        return frutaRepository.save(fruta);
    }

    @Override
    public void delete(int id) {
        frutaRepository.deleteById(id);
    }

    @Override
    public Fruta getOne(int id) {
        return frutaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Fruta> getAll() {
        return frutaRepository.findAll();
    }
}