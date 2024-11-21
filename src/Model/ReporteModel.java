package Model;

import Clases_de_objetos.Reporte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteModel {
    private static final String DB_URL = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

    public boolean registrarReporte(Reporte reporte) {
        String sql = "INSERT INTO Reportes(tipo_reporte, fecha_generacion, datos) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, reporte.getTipoReporte());
            pstmt.setString(2, reporte.getFechaGeneracion());
            pstmt.setString(3, reporte.getDatos());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Reporte obtenerReportePorId(int id) {
        String sql = "SELECT * FROM Reportes WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Reporte.Builder()
                        .setId(rs.getInt("id"))
                        .setTipoReporte(rs.getString("tipo_reporte"))
                        .setFechaGeneracion(rs.getString("fecha_generacion"))
                        .setDatos(rs.getString("datos"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reporte> obtenerTodosLosReportes() {
        List<Reporte> reportes = new ArrayList<>();
        String sql = "SELECT * FROM Reportes";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Reporte reporte = new Reporte.Builder()
                        .setId(rs.getInt("id"))
                        .setTipoReporte(rs.getString("tipo_reporte"))
                        .setFechaGeneracion(rs.getString("fecha_generacion"))
                        .setDatos(rs.getString("datos"))
                        .build();
                reportes.add(reporte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportes;
    }

    public boolean actualizarReporte(Reporte reporte) {
        String sql = "UPDATE Reportes SET tipo_reporte = ?, fecha_generacion = ?, datos = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, reporte.getTipoReporte());
            pstmt.setString(2, reporte.getFechaGeneracion());
            pstmt.setString(3, reporte.getDatos());
            pstmt.setInt(4, reporte.getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarReporte(int id) {
        String sql = "DELETE FROM Reportes WHERE id = ?";

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