/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.talleressemanadesoftware;

import interfaz.IVistaTaller;
import negocio.NegocioTaller;
import negocio.Taller;
import negocio.Inscripcion;
import negocio.Alumno;
import java.util.List;

/**
 *
 * @author Dayanara Peralta G
 */
public class ModeloTaller {
    private IVistaTaller vista;
    private NegocioTaller negocio;

    public ModeloTaller(VistaTaller vista, NegocioTaller negocio) {
        this.vista = vista;
        this.negocio = negocio;
    }
    
    public void consultarTalleres(){
        List<Taller> listaTalleres = negocio.obtenerTalleres();
        vista.mostrarTalleres(listaTalleres);
    }
    
    public void obtenerDetalles(String idTaller){
        Taller detallesTaller = negocio.obtenerDetalles(idTaller);
        vista.mostrarDetalles(detallesTaller);
    }
    
    public void buscarAlumno(String idAlumno){
        Alumno detalleAlumno = negocio.buscarAlumno(idAlumno);
        vista.mostrarDetallesAlumno(detalleAlumno);
    }
    
    public void registrarInscripcion(String idAlumno, String idTaller){
        Inscripcion detallesInscripcion = negocio.crearInscripcion(idAlumno, idTaller);
        vista.generarTicket(detallesInscripcion);
    }
}

