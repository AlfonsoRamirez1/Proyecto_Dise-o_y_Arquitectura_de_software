package GUI;

import Controller.*;
import GUI.State.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AdminWindow extends JFrame {
    // Controladores
    public ActividadEconomicaController actividadEconomicaController;
    public HabitanteController habitanteController;
    public ViviendaController viviendaController;
    public LocalidadController localidadController;
    public MunicipioController municipioController;
    public TipoViviendaController tipoViviendaController;
    public ReporteController reporteController;

    // Campos de texto compartidos por los diferentes formularios
    public JTextField actividadNombreField;
    public JTextField habitanteNombreField, habitanteApellidoField, habitanteEdadField, habitanteGeneroField;
    public JTextField viviendaDireccionField, viviendaNumHabitantesField, viviendaActividadesField;
    public JTextField localidadNombreField;
    public JTextField municipioNombreField;
    public JTextField tipoViviendaNombreField;
    public JTextField reporteDescripcionField;

    // Estado de la ventana
    private FormState currentState;
    private Map<String, FormState> stateMap;

    public AdminWindow() {
        setTitle("Administración");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Inicializar controladores
        actividadEconomicaController = new ActividadEconomicaController();
        habitanteController = new HabitanteController();
        viviendaController = new ViviendaController();
        localidadController = new LocalidadController();
        municipioController = new MunicipioController();
        tipoViviendaController = new TipoViviendaController();
        reporteController = new ReporteController();

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear el menú principal
        JMenu menu = new JMenu("Opciones");

        // Crear los ítems del menú
        JMenuItem actividadEconomicaItem = new JMenuItem("Actividad Económica");
        actividadEconomicaItem.addActionListener(e -> changeState("Actividad Económica"));

        JMenuItem habitanteItem = new JMenuItem("Habitante");
        habitanteItem.addActionListener(e -> changeState("Habitante"));

        JMenuItem viviendaItem = new JMenuItem("Vivienda");
        viviendaItem.addActionListener(e -> changeState("Vivienda"));

        JMenuItem localidadItem = new JMenuItem("Localidad");
        localidadItem.addActionListener(e -> changeState("Localidad"));

        JMenuItem municipioItem = new JMenuItem("Municipio");
        municipioItem.addActionListener(e -> changeState("Municipio"));

        JMenuItem tipoViviendaItem = new JMenuItem("Tipo de Vivienda");
        tipoViviendaItem.addActionListener(e -> changeState("Tipo de Vivienda"));

        JMenuItem reporteItem = new JMenuItem("Reporte");
        reporteItem.addActionListener(e -> changeState("Reporte"));

        // Añadir los ítems al menú
        menu.add(actividadEconomicaItem);
        menu.add(habitanteItem);
        menu.add(viviendaItem);
        menu.add(localidadItem);
        menu.add(municipioItem);
        menu.add(tipoViviendaItem);
        menu.add(reporteItem);

        // Añadir el menú a la barra de menú
        menuBar.add(menu);

        // Añadir la barra de menú al frame
        setJMenuBar(menuBar);

        // Inicializar mapa de estados
        stateMap = new HashMap<>();
        stateMap.put("Actividad Económica", new ActividadEconomicaState());
        stateMap.put("Habitante", new HabitanteState());
        stateMap.put("Vivienda", new ViviendaState());
        stateMap.put("Localidad", new LocalidadState());
        stateMap.put("Municipio", new MunicipioState());
        stateMap.put("Tipo de Vivienda", new TipoViviendaState());
        stateMap.put("Reporte", new ReporteState());

        // Configurar formulario inicial vacío
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        currentState = null;
    }

    // Método para cambiar el estado
    private void changeState(String entity) {
        FormState newState = stateMap.get(entity);
        if (newState != null) {
            getContentPane().removeAll(); // Limpiar el contenido actual

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Separación de 10px alrededor de los componentes

            // Configurar el nuevo formulario
            currentState = newState;
            gbc.gridx = 0;
            gbc.gridy = 0;
            currentState.setupForm(this, gbc);
        } else {
            clearForm(); // Limpiar el formulario si no hay estado asignado
        }
        revalidate();
        repaint();
    }

    // Método para limpiar el formulario
    public void clearForm() {
        getContentPane().removeAll();
        revalidate();
        repaint();
    }

    // Método para mostrar un mensaje de éxito o error
    public void mostrarMensaje(boolean exito, String entidad) {
        String mensaje = exito ? entidad + " registrado correctamente." : "Error al registrar " + entidad + ".";
        JOptionPane.showMessageDialog(this, mensaje);
    }
}