package Model;

import Clases_de_objetos.Habitante;
import Clases_de_objetos.Vivienda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitanteModel {
    private static final String DB_URL = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

    public boolean registrarHabitante(Habitante habitante) {
        String sql = "INSERT INTO Habitantes(nombre, apellido, edad, genero, vivienda_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, habitante.getNombre());
            pstmt.setString(2, habitante.getApellido());
            pstmt.setInt(3, habitante.getEdad());
            pstmt.setString(4, habitante.getGenero());
            //pstmt.setInt(5, habitante.getVivienda().getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Habitante obtenerHabitantePorId(int id) {
        String sql = "SELECT * FROM Habitantes WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Creamos una instancia simplificada de Vivienda usando el ID
                Vivienda vivienda = new Vivienda(rs.getInt("vivienda_id"), null, null, 0, null, null);
                return new Habitante(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"), rs.getString("genero"), vivienda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Habitante> obtenerTodosLosHabitantes() {
        List<Habitante> habitantes = new ArrayList<>();
        String sql = "SELECT * FROM Habitantes";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                // Creamos una instancia simplificada de Vivienda usando el ID
                Vivienda vivienda = new Vivienda(rs.getInt("vivienda_id"), null, null, 0, null, null);
                Habitante habitante = new Habitante(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"), rs.getString("genero"), vivienda);
                habitantes.add(habitante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitantes;
    }

    public boolean actualizarHabitante(Habitante habitante) {
        String sql = "UPDATE Habitantes SET nombre = ?, apellido = ?, edad = ?, genero = ?, vivienda_id = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, habitante.getNombre());
            pstmt.setString(2, habitante.getApellido());
            pstmt.setInt(3, habitante.getEdad());
            pstmt.setString(4, habitante.getGenero());
            pstmt.setInt(5, habitante.getVivienda().getId());
            pstmt.setInt(6, habitante.getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarHabitante(int id) {
        String sql = "DELETE FROM Habitantes WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}