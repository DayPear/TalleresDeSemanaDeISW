/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author Dayanara Peralta G
 */
public class Alumno {
    private String idAlumno;
    private String nombre;
    private String semestre;
    private String carrera;

    public Alumno() {
    }

    public Alumno(String idAlumno, String nombre, String semestre, String carrera) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
}
