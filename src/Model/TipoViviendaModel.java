package Model;

import Clases_de_objetos.TipoVivienda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoViviendaModel {
    private static final String DB_URL = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

    public boolean registrarTipoVivienda(TipoVivienda tipo) {
        String sql = "INSERT INTO TiposVivienda(nombre) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipo.getNombre());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TipoVivienda obtenerTipoViviendaPorId(int id) {
        String sql = "SELECT * FROM TiposVivienda WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new TipoVivienda(rs.getInt("id"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}