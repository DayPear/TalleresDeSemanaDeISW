/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.talleressemanadesoftware;

import interfaz.IVistaTaller;
import negocio.Taller;
import negocio.Inscripcion;
import negocio.Alumno;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Dayanara Peralta G
 */
public class VistaTaller extends JFrame implements IVistaTaller{
    private static Color[] PALETA = {
        new Color(0x4F8FEA), new Color(0x34A853), new Color(0x8C6FF7), 
        new Color(0xE8607A)
    };
    
    private static final Color AZUL = new Color(0x3B82F6);
    private static final Color GRIS = new Color(0xF2F2F2);
    
    private ControlTaller control;
    
    private final JPanel listaPanel = new JPanel();
    private final JPanel detallesPanel = new JPanel();
    private final JPanel formaArea = new JPanel();
    
    private List<Taller> talleresActuales;
    private String idTallerSeleccionado;
    private int filaSeleccionada = -1;
    private JTextField campoId;

    public VistaTaller() {
        super("Inscripcion a Talleres semana ISW - ITSON");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);
        setLocationRelativeTo(null);
        construirInterfaz();
    }
    
    public void setControl(ControlTaller control){
        this.control = control;
    }
    
    private void construirInterfaz(){
        setLayout(new BorderLayout());
        
        JLabel header = new JLabel("ITSON");
        header.setOpaque(true);
        header.setBackground(AZUL);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 28));
        header.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        add(header, BorderLayout.NORTH);
        
        JPanel body = new JPanel(new BorderLayout());
        body.setBackground(GRIS);
        body.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titulo = new JLabel("Talleres disponibles");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        body.add(titulo, BorderLayout.NORTH);
        
        listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));
        listaPanel.setBackground(GRIS);
        listaPanel.setPreferredSize(new Dimension(260, 0));
        
        JPanel derPanel = new JPanel();
        derPanel.setLayout(new BoxLayout(derPanel, BoxLayout.Y_AXIS));
        derPanel.setBackground(Color.WHITE);
        derPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        detallesPanel.setLayout(new BoxLayout(detallesPanel, BoxLayout.Y_AXIS));
        detallesPanel.setBackground(Color.WHITE);
        detallesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        derPanel.add(detallesPanel);
        derPanel.add(Box.createVerticalStrut(15));
        derPanel.add(formaArea);
        
        JPanel contenido = new JPanel(new BorderLayout(15, 0));
        contenido.setBackground(GRIS);
        contenido.add(listaPanel, BorderLayout.WEST);
        contenido.add(new JScrollPane(derPanel), BorderLayout.CENTER);
        
        body.add(contenido, BorderLayout.CENTER);
        add(body, BorderLayout.CENTER);
    }
    
    public void solicitarTalleres(){
        control.obtenerTalleres();
    }
    
    public void seleccionaTaller(String id){
        this.idTallerSeleccionado = id;
        control.seleccionarTaller(id);
    }
    
    public void solicitarInscripcion(){
        control.solicitarInscripcion(idTallerSeleccionado);
    }
    
    public void ingresarID(String idAlumno){
        control.buscarAlumno(idAlumno);
    }
    
    public void confirmarInscripcion(String idAlumno){
        control.confirmarInscripcion(idAlumno, idTallerSeleccionado);
    }
    
    @Override
    public void mostrarTalleres(List<Taller> listaTalleres){
        this.talleresActuales = listaTalleres;
        listaPanel.removeAll();
        for(int i = 0; i<listaTalleres.size(); i++){
            listaPanel.add(crearFilaTaller(listaTalleres.get(i), i));
            listaPanel.add(Box.createVerticalStrut(8));
        }
        listaPanel.revalidate();
        listaPanel.repaint();
    }
    
    @Override
    public void mostrarDetalles(Taller taller){
        detallesPanel.removeAll();
        formaArea.removeAll();
        
        JPanel encabezado = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        encabezado.setBackground(Color.WHITE);
        JPanel color = new JPanel();
        color.setBackground(PALETA[Math.floorMod(talleresActuales.indexOf(taller), PALETA.length)]);
        color.setPreferredSize(new Dimension(40, 40));
        JLabel nombre = new JLabel(taller.getNombre());
        nombre.setFont(new Font("SansSerif", Font.BOLD, 20));
        encabezado.add(color);
        encabezado.add(nombre);
        encabezado.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JPanel datos = new JPanel(new GridLayout(1, 3, 20, 0));
        datos.setBackground(Color.WHITE);
        datos.setAlignmentX(Component.LEFT_ALIGNMENT);
        datos.add(crearCampoInfo("Instructor", taller.getInstructor()));
        datos.add(crearCampoInfo("Fecha", taller.getFecha()));
        datos.add(crearCampoInfo("Horario", taller.getHorario()));
        
        JButton btnInscribirse = new JButton("Inscribirse");
        btnInscribirse.setBackground(AZUL);
        btnInscribirse.setForeground(Color.WHITE);
        btnInscribirse.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnInscribirse.addActionListener(e -> solicitarInscripcion());
        
        JPanel wBoton = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 12));
        wBoton.setBackground(Color.WHITE);
        wBoton.setAlignmentX(Component.LEFT_ALIGNMENT);
        wBoton.add(btnInscribirse);
        
        detallesPanel.add(encabezado);
        detallesPanel.add(datos);
        detallesPanel.add(wBoton);
        
        detallesPanel.revalidate();
        detallesPanel.repaint();
        formaArea.revalidate();
        formaArea.repaint();
    }
    
    @Override
    public void solicitarIDAlumno(){
        formaArea.removeAll();
        
        JLabel titulo = new JLabel("Alumno");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        campoId = new JTextField(10);
        campoId.setEditable(true);
        JButton btnAeptar = new JButton("Aceptar");
        btnAeptar.setBackground(AZUL);
        btnAeptar.setForeground(Color.WHITE);
        btnAeptar.addActionListener(e -> ingresarID(campoId.getText().trim()));
        
        JPanel filaID = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        filaID.setBackground(GRIS);
        filaID.setAlignmentX(Component.LEFT_ALIGNMENT);
        filaID.add(new JLabel("ID"));
        filaID.add(campoId);
        filaID.add(btnAeptar);
        
        formaArea.add(titulo);
        formaArea.add(filaID);
        formaArea.revalidate();
        formaArea.repaint();
    }
    
    @Override
    public void mostrarDetallesAlumno(Alumno alumno){
        JPanel datosAlumno = new JPanel(new GridLayout(2, 4, 10, 8));
        datosAlumno.setBackground(GRIS);
        datosAlumno.setAlignmentX(Component.LEFT_ALIGNMENT);
        datosAlumno.add(new JLabel("ID"));
        datosAlumno.add(soloLectura(alumno.getIdAlumno()));
        datosAlumno.add(new JLabel("nombre"));
        datosAlumno.add(soloLectura(alumno.getNombre()));
        datosAlumno.add(new JLabel("Semestre"));
        datosAlumno.add(soloLectura(alumno.getSemestre()));
        datosAlumno.add(new JLabel("Carrera"));
        datosAlumno.add(soloLectura(alumno.getCarrera()));
        
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBackground(AZUL);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.addActionListener(e -> confirmarInscripcion(alumno.getIdAlumno()));
        
        JPanel wrapperBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        wrapperBoton.setBackground(GRIS);
        wrapperBoton.setAlignmentX(Component.LEFT_ALIGNMENT);
        wrapperBoton.add(btnConfirmar);
 
        formaArea.add(datosAlumno);
        formaArea.add(wrapperBoton);
        formaArea.revalidate();
        formaArea.repaint();
    }
    
    @Override
    public void generarTicket(Inscripcion inscripcion) {
        formaArea.removeAll();
 
        JLabel titulo = new JLabel("Ticket");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        Alumno alumno = inscripcion.getAlumno();
        Taller taller = inscripcion.getTaller();
 
        JPanel grid = new JPanel(new GridLayout(4, 4, 10, 8));
        grid.setBackground(GRIS);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.add(new JLabel("ID"));
        grid.add(soloLectura(alumno.getIdAlumno()));
        grid.add(new JLabel("Taller"));
        grid.add(soloLectura(taller.getNombre()));
        grid.add(new JLabel("Nombre"));
        grid.add(soloLectura(alumno.getNombre()));
        grid.add(new JLabel("Instructor"));
        grid.add(soloLectura(taller.getInstructor()));
        grid.add(new JLabel("Semestre"));
        grid.add(soloLectura(alumno.getSemestre()));
        grid.add(new JLabel("Fecha"));
        grid.add(soloLectura(taller.getFecha()));
        grid.add(new JLabel("Carrera"));
        grid.add(soloLectura(alumno.getCarrera()));
        grid.add(new JLabel("Hora"));
        grid.add(soloLectura(taller.getHorario()));
 
        formaArea.add(titulo);
        formaArea.add(grid);
        formaArea.revalidate();
        formaArea.repaint();
    }
    
    private JPanel crearCampoInfo(String etiqueta, String valor) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBackground(Color.WHITE);
        JLabel lbl = new JLabel(etiqueta);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lbl.setForeground(Color.GRAY);
        JLabel val = new JLabel(valor);
        val.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(lbl);
        panel.add(val);
        return panel;
    }
    
    private JPanel crearFilaTaller(Taller taller, int indice){
        JPanel fila = new JPanel(new BorderLayout(10, 0));
        fila.setMaximumSize(new Dimension(260, 55));
        fila.setPreferredSize(new Dimension(260, 55));
        fila.setBackground(indice == filaSeleccionada ? new Color(0xDCEBFF) : Color.WHITE);
        fila.setBorder(BorderFactory.createLineBorder(new Color(0xE0E0E0)));
        fila.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JPanel color = new JPanel();
        color.setBackground(PALETA[indice % PALETA.length]);
        color.setPreferredSize(new Dimension(36, 36));
        JPanel wColor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wColor.setOpaque(false);
        wColor.add(color);
        
        JLabel nombre = new JLabel(taller.getNombre());
        nombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        fila.add(wColor, BorderLayout.WEST);
        fila.add(nombre, BorderLayout.CENTER);
        
        MouseAdapter clic = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            filaSeleccionada = indice;
            seleccionaTaller(taller.getIdTaller());
            mostrarTalleres(talleresActuales);
        }
    };
        fila.addMouseListener(clic);
        wColor.addMouseListener(clic);
        color.addMouseListener(clic);
        nombre.addMouseListener(clic);
        return fila;
    }
    
    private JTextField soloLectura(String valor) {
        JTextField campo = new JTextField(valor);
        campo.setEditable(false);
        return campo;
    }
}