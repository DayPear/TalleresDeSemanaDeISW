/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import java.util.List;
import negocio.Alumno;
import negocio.Inscripcion;
import negocio.Taller;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IVistaTaller {
    void mostrarTalleres(List<Taller> listaTalleres);
    void mostrarDetalles(Taller detallesTaller);
    void solicitarIDAlumno();
    void mostrarDetallesAlumno(Alumno detallesAlumno);
    void generarTicket(Inscripcion detallesInscripcion); 
}
