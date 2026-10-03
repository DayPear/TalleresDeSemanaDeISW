/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.talleressemanadesoftware;

import negocio.NegocioTaller;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dayanara Peralta G
 */
public class TalleresSemanaDeSoftware {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaTaller vista = new VistaTaller();
            NegocioTaller negocio = new NegocioTaller();
            ModeloTaller modelo = new ModeloTaller(vista, negocio);
            ControlTaller controlador = new ControlTaller(vista, modelo);
            vista.setControl(controlador);
 
            vista.setVisible(true);
            vista.solicitarTalleres();
        });
    }
}
