package Model;

import Clases_de_objetos.Vivienda;
import Clases_de_objetos.TipoVivienda;
import Clases_de_objetos.Localidad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViviendaModel {
    private static final String DB_URL = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

    public boolean registrarVivienda(Vivienda vivienda) {
        String sql = "INSERT INTO Viviendas(direccion, tipo_vivienda_id, numero_habitantes, actividades_economicas, localidad_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vivienda.getDireccion());
            pstmt.setInt(2, vivienda.getTipoVivienda().getId());
            pstmt.setInt(3, vivienda.getNumeroHabitantes());
            pstmt.setString(4, vivienda.getActividadesEconomicas());
            //pstmt.setInt(5, vivienda.getLocalidad().getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Vivienda obtenerViviendaPorId(int id) {
        String sql = "SELECT * FROM Viviendas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Crear objetos simplificados de TipoVivienda y Localidad usando los IDs
                TipoVivienda tipoVivienda = new TipoVivienda(rs.getInt("tipo_vivienda_id"), null);
                Localidad localidad = new Localidad(rs.getInt("localidad_id"), null, null);
                return new Vivienda(rs.getInt("id"), rs.getString("direccion"), tipoVivienda, rs.getInt("numero_habitantes"), rs.getString("actividades_economicas"), localidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Vivienda> obtenerTodasLasViviendas() {
        List<Vivienda> viviendas = new ArrayList<>();
        String sql = "SELECT * FROM Viviendas";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                // Crear objetos simplificados de TipoVivienda y Localidad usando los IDs
                TipoVivienda tipoVivienda = new TipoVivienda(rs.getInt("tipo_vivienda_id"), null);
                Localidad localidad = new Localidad(rs.getInt("localidad_id"), null, null);
                Vivienda vivienda = new Vivienda(rs.getInt("id"), rs.getString("direccion"), tipoVivienda, rs.getInt("numero_habitantes"), rs.getString("actividades_economicas"), localidad);
                viviendas.add(vivienda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viviendas;
    }

    public boolean actualizarVivienda(Vivienda vivienda) {
        String sql = "UPDATE Viviendas SET direccion = ?, tipo_vivienda_id = ?, numero_habitantes = ?, actividades_economicas = ?, localidad_id = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vivienda.getDireccion());
            pstmt.setInt(2, vivienda.getTipoVivienda().getId());
            pstmt.setInt(3, vivienda.getNumeroHabitantes());
            pstmt.setString(4, vivienda.getActividadesEconomicas());
            pstmt.setInt(5, vivienda.getLocalidad().getId());
            pstmt.setInt(6, vivienda.getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarVivienda(int id) {
        String sql = "DELETE FROM Viviendas WHERE id = ?";

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