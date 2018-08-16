package dao;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportEmpleadoDao extends DAO {

    public void exportarPDF(Map parameters) throws JRException, IOException, Exception {
        this.Conexion();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("Vistas/REPORTES/FORMULARIO_EMPLEADOS.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=FICHA DEL TRABAJADOR.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

//    public void exportarPDF2(Map parameters2) throws JRException, IOException, Exception {
//        this.Conexion();
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("vistas/REPORTE/FORMULARIOLEGAJO_02.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters2, this.getCn());
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=Empleado.pdf");
//        ServletOutputStream stream = response.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
}
