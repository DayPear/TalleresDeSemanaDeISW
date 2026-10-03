/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;


/**
 *
 * @author Dayanara Peralta G
 */
public class Inscripcion {
    private String idInscripcion;
    private String fecha;
    private String estado;
    private Taller taller;
    private Alumno alumno;

    public Inscripcion() {
    }

    public Inscripcion(String idInscripcion, String fecha, String estado, Taller taller, Alumno alumno) {
        this.idInscripcion = idInscripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.taller = taller;
        this.alumno = alumno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
}
