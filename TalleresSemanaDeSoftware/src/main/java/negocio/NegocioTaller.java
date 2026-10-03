/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dayanara Peralta G
 */
public class NegocioTaller {
    private List<Taller> talleres = new ArrayList<>();
    private Map<String, Alumno> alumnos = new HashMap<>();
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private int numInscripcion = 1;
    
    public NegocioTaller(){
        talleres.add(new Taller("T1", "CiberSeguridad", "Ing. Carlos Gonzales", 
                "Mie 30 sep, 2026", "10:00 - 12:30"));
        talleres.add(new Taller("T2", "Bases de datos", "Ing. Gibran Durán Solano", 
                "lun 28 sep, 2026", "10:00 - 12:30"));
        talleres.add(new Taller("T3", "IA", "Ing. Omar Chaparro", 
                "Mie 30 sep, 2026", "12:30 - 03:00"));
        talleres.add(new Taller("T4", "Sitios web", "Ing. Ana Gamez", 
                "Mar 06 oct, 2026", "10:00 - 12:30"));
        
        alumnos.put("262788", new Alumno("262788", "Aaron Burciaga", "7", "ISW"));
        alumnos.put("262775", new Alumno("262775", "Maria Valdez", "5", "ISW"));
    }
    
    public List<Taller> obtenerTalleres(){
        return talleres;
    }
    
    public Taller obtenerDetalles(String idTaller){
        for(Taller t: talleres){
            if(t.getIdTaller().equals(idTaller)){
                return t;
            }
        }
        return null;
    }
    
    public Alumno buscarAlumno(String idAlumno){
        Alumno alumno = alumnos.get(idAlumno);
        if(alumno == null){
            alumno = new Alumno(idAlumno, "Alumno 1", "1", "ISW");
        }
        return alumno;
    }
    
    public Inscripcion crearInscripcion(String idAlumno, String idTaller){
        Alumno alumno = buscarAlumno(idAlumno);
        Taller taller = obtenerDetalles(idTaller);
        Inscripcion inscripcion = new Inscripcion("N."+(numInscripcion++), "Hoy",
                "vigente", taller, alumno);
        inscripciones.add(inscripcion);
        return inscripcion;
    }
    
}
