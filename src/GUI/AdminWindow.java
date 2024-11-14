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
    private JComboBox<String> entitySelector;
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

        // Configurar selector de entidad
        entitySelector = new JComboBox<>(new String[]{
                "Seleccione una opción", "Actividad Económica", "Habitante",
                "Vivienda", "Localidad", "Municipio", "Tipo de Vivienda", "Reporte"
        });
        entitySelector.addActionListener(e -> changeState((String) entitySelector.getSelectedItem()));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(entitySelector, gbc);

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
        gbc.gridy = 1;
        currentState = null;
    }

    // Método para cambiar el estado
    private void changeState(String entity) {
        FormState newState = stateMap.get(entity);
        if (newState != null) {
            currentState = newState;
            currentState.setupForm(this, new GridBagConstraints());
        } else {
            clearForm();
        }
    }

    // Método para limpiar el formulario
    public void clearForm() {
        getContentPane().removeAll();
        revalidate();
        repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(entitySelector, gbc);
    }

    // Método para mostrar un mensaje de éxito o error
    public void mostrarMensaje(boolean exito, String entidad) {
        String mensaje = exito ? entidad + " registrado correctamente." : "Error al registrar " + entidad + ".";
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
