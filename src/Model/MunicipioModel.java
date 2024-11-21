package Model;

import Clases_de_objetos.Municipio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipioModel {
    private static final String DB_URL = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

    public boolean registrarMunicipio(Municipio municipio) {
        String sql = "INSERT INTO Municipios(nombre) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, municipio.getNombre());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Municipio obtenerMunicipioPorId(int id) {
        String sql = "SELECT * FROM Municipios WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Municipio(rs.getInt("id"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Municipio> obtenerTodosLosMunicipios() {
        List<Municipio> municipios = new ArrayList<>();
        String sql = "SELECT * FROM Municipios";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Municipio municipio = new Municipio(rs.getInt("id"), rs.getString("nombre"));
                municipios.add(municipio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return municipios;
    }

    public boolean actualizarMunicipio(Municipio municipio) {
        String sql = "UPDATE Municipios SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, municipio.getNombre());
            //pstmt.setInt(2, municipio.getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMunicipio(int id) {
        String sql = "DELETE FROM Municipios WHERE id = ?";

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