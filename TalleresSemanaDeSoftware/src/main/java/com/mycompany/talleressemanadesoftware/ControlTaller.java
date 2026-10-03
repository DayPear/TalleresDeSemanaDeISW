/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.talleressemanadesoftware;

import interfaz.IVistaTaller;

/**
 *
 * @author Dayanara Peralta G
 */
public class ControlTaller {
    private IVistaTaller vista;
    private ModeloTaller modelo;

    public ControlTaller(VistaTaller vista, ModeloTaller modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void obtenerTalleres(){
        modelo.consultarTalleres();
    }
    
    public void seleccionarTaller(String idTaller){
        modelo.obtenerDetalles(idTaller);
    }
    
    public void solicitarInscripcion(String idTaller){
        vista.solicitarIDAlumno();
    }
    
    public void buscarAlumno(String idAlumno){
        modelo.buscarAlumno(idAlumno);
    }
    
    public void confirmarInscripcion(String idAlumno, String idTaller){
        modelo.registrarInscripcion(idAlumno, idTaller);
    }
    
}
