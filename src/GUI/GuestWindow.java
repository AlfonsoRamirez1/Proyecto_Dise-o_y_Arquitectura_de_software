package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GuestWindow extends JFrame {
    private JComboBox<String> tableComboBox;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private JPanel tablePanel;

    public GuestWindow() {
        // Configuración de la ventana
        setTitle("Consulta de Tablas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Mensaje superior
        JLabel messageLabel = new JLabel("Seleccione la tabla que desea consultar", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        // Panel central para el menú desplegable y la tabla
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Menú desplegable para seleccionar la tabla
        String[] tables = {"Usuarios", "Municipios", "Localidades", "TiposVivienda", "ActividadesEconomicas", "Viviendas", "Habitantes", "Reportes"};
        tableComboBox = new JComboBox<>(tables);
        tableComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTable = (String) tableComboBox.getSelectedItem();
                mostrarDatosTabla(selectedTable);
            }
        });

        JPanel comboPanel = new JPanel();
        comboPanel.add(tableComboBox);
        centerPanel.add(comboPanel, BorderLayout.NORTH);

        // Panel para mostrar los datos de la tabla
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Añadir el panel de la tabla al centro
        centerPanel.add(tablePanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
    }

    // Método para mostrar datos de la tabla seleccionada
    private void mostrarDatosTabla(String tableName) {
        // Limpiar modelo de la tabla
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        String url = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

        String query = "SELECT * FROM " + tableName;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Obtener nombres de columnas
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Agregar nombres de columnas al modelo de tabla
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Agregar filas al modelo de tabla
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
