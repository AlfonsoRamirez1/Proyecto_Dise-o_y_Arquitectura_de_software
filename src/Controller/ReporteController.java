package Controller;

import Clases_de_objetos.Reporte;
import Model.ReporteModel;

public class ReporteController {
    private ReporteModel reporteModel;

    public ReporteController() {
        reporteModel = new ReporteModel();
    }

    public boolean registrarReporte(String descripcion, String fecha, int municipioId) {
        Reporte reporte = new Reporte.Builder()
                .setId(0) // o cualquier valor inicial apropiado
                .setTipoReporte(descripcion)
                .setFechaGeneracion(fecha)
                .build();
        return reporteModel.registrarReporte(reporte);
    }

    public Reporte obtenerReporte(int id) {
        return reporteModel.obtenerReportePorId(id);
    }
}