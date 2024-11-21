package Model;

import Clases_de_objetos.Localidad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalidadModel {
    private static final String DB_URL = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

    public boolean registrarLocalidad(Localidad localidad) {
        String sql = "INSERT INTO Localidades(nombre, municipio_id) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, localidad.getNombre());
            //pstmt.setInt(2, localidad.getMunicipio().getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Localidad obtenerLocalidadPorId(int id) {
        String sql = "SELECT * FROM Localidades WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Adaptar para obtener el municipio desde su ID si es necesario
                return new Localidad(rs.getInt("id"), rs.getString("nombre"), null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}