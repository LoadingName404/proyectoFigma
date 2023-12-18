package inacap2023.figma;

import java.io.Serializable;

public class plan implements Serializable {
    private String id;
    private String nombre;
    private String descripcion;

    public plan(String id, String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String toString() {
        return this.nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
}
