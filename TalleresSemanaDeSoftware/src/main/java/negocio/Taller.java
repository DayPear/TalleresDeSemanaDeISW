/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author Dayanara Peralta G
 */
public class Taller {
    private String idTaller;
    private String nombre;
    private String fecha;
    private String horario;
    private String instructor;

    public Taller() {
    }

    public Taller(String idTaller, String nombre, String instructor, String fecha, String horario) {
        this.idTaller = idTaller;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horario = horario;
        this.instructor = instructor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String idTaller) {
        this.idTaller = idTaller;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
