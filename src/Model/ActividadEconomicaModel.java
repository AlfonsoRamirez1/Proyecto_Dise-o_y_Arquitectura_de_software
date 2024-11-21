package Model;

import Clases_de_objetos.ActividadEconomica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActividadEconomicaModel {
    private static final String DB_URL = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

    public boolean registrarActividadEconomica(ActividadEconomica actividad) {
        String sql = "INSERT INTO ActividadesEconomicas(nombre_actividad) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, actividad.getNombreActividad());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ActividadEconomica obtenerActividadEconomicaPorId(int id) {
        String sql = "SELECT * FROM ActividadesEconomicas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new ActividadEconomica(rs.getInt("id"), rs.getString("nombre_actividad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ActividadEconomica> obtenerTodasLasActividadesEconomicas() {
        List<ActividadEconomica> actividades = new ArrayList<>();
        String sql = "SELECT * FROM ActividadesEconomicas";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ActividadEconomica actividad = new ActividadEconomica(rs.getInt("id"), rs.getString("nombre_actividad"));
                actividades.add(actividad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actividades;
    }

    // NUEVO MÉTODO: Obtener actividad económica por nombre
    public ActividadEconomica obtenerActividadEconomicaPorNombre(String nombre) {
        String sql = "SELECT * FROM ActividadesEconomicas WHERE nombre_actividad = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new ActividadEconomica(rs.getInt("id"), rs.getString("nombre_actividad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // AJUSTADO: Método actualizar actividad económica
    public boolean actualizarActividadEconomica(ActividadEconomica actividad) {
        String sql = "UPDATE ActividadesEconomicas SET nombre_actividad = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, actividad.getNombreActividad());
            pstmt.setInt(2, actividad.getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // NUEVO MÉTODO: Eliminar actividad económica por nombre
    public boolean eliminarActividadEconomica(ActividadEconomica actividad) {
        String sql = "DELETE FROM ActividadesEconomicas WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, actividad.getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}