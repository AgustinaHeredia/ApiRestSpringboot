package cat.itacademy.barcelonactiva.herediamarengo.agustina.s04.t02.n01.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int cantidadQuilos;
    
    // Constructor sin argumentos (necesario para JPA)
    public Fruta() {
    }

    public Fruta(String nombre, int cantidadQuilos) {
        this.nombre = nombre;
        this.cantidadQuilos = cantidadQuilos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadQuilos() {
        return cantidadQuilos;
    }

    public void setCantidadQuilos(int cantidadQuilos) {
        this.cantidadQuilos = cantidadQuilos;
    }
}
