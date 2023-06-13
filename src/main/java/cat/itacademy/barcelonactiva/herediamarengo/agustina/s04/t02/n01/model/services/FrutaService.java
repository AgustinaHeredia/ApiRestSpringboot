package cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.domain.Fruta;

public interface FrutaService {

	Fruta add(Fruta fruta);
    Fruta upd(Fruta fruta);
    void delete(int id);
    Fruta getOne(int id);
    List<Fruta> getAll();
}
