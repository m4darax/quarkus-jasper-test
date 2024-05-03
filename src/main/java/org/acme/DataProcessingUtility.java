package org.acme;

import com.google.gson.Gson;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

@Slf4j
@ApplicationScoped
public class DataProcessingUtility {

    public byte[] generateJasperReport() throws JRException {
        // Cargar el archivo .jasper
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(da);
        JSONObject test = this.test();
        Casa casa = new Casa();
        casa.setApellido("Rivera");
        casa.setNombre("Clever");
        casa.setP_UNIDAD_EJECUTORA_RUC("PROBANDO UNIDADDADAD");

        try {
            //ruta file
            InputStream path = DataProcessingUtility.class.getClassLoader().getResourceAsStream("report.jasper");

            // Generar el informe
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, test().toMap(), new JREmptyDataSource());

            // Exportar el informe a PDF
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return new byte[0];

    }


    public JSONObject test() {

        Casa casa = new Casa();
        casa.setApellido("Rivera");
        casa.setNombre("Clever");
        casa.setP_UNIDAD_EJECUTORA_RUC("PROBANDO UNIDADDADAD");
        casa.setCABECERA_I(List.of(new ListaDatos("hola20", "adios20"), new ListaDatos("hola2", "adios2"), new ListaDatos("hola3", "adios3"), new ListaDatos("hola3", "adios3"),new ListaDatos("hola3", "adios3"),new ListaDatos("hola3", "adios3")));
        casa.setDETALLES_I(List.of(new ListaDatos("hola20", "adios20"), new ListaDatos("hola2", "adios2"), new ListaDatos("hola3", "adios3"), new ListaDatos("hola3", "adios3"),new ListaDatos("hola3", "adios3"),new ListaDatos("hola3", "adios3")));

        Gson gson = new Gson();
        String jsonString = gson.toJson(casa);
        System.out.println("jsonString = " + jsonString);
        return new JSONObject(jsonString);
    }
}
