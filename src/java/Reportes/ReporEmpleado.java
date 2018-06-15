package Reportes;

import java.sql.ResultSet;
import java.util.List;
import modelo.Empleado;

public class ReporEmpleado {
    
    public  List<Empleado> ListarActivos() throws Exception{
   List<Empleado> lista = null;
   ResultSet rs ;
        try {
        String sql = "select Empleado.idEmpl,Empleado.DNI,Empleado.Nom,Empleado.ApelPate,Empleado.ApelMate,Empleado.RUC,Empleado.Email,Empleado.Telf,Empleado.Cel,convert(varchar,Empleado.FecNac,105) as FecNac,Empleado.GrupSang,Empleado.EstCiv,Empleado.ConLab,Empleado.CarnAseg,Empleado.Refe,Empleado.Leye,convert(varchar,Empleado.FecIng,105) as FecIng,CONVERT(varchar,Empleado.FecNom,105) as FecNom,Empleado.DatCony,Empleado.UbigActu,Empleado.UbigOrig,Empleado.Est,\n"
            + " Familiar.NomFami as 'Nombre de Familiar', Familiar.Ape as 'Apellido del Familiar', Familiar.Par,Familiar.Ocu,convert(varchar,Familiar.FecNac,105) as FecNacFami,Familiar.Tel as 'Telefono del Celular',Familiar.CelularFami as 'Celular del Familiar', Familiar.EstCivFami,Familiar.vive,\n"
            + " Emergentes.NomEmer as 'Nombre del Contacto' , Emergentes.Ape as 'Apellidos del Contacto', Emergentes.Paren as 'Parentesto del Contacto', Emergentes.Tel as 'Telefono del Contacto', Emergentes.Celular as 'Celular del Contacto',\n"
            + " Dialecto.Lee, Dialecto.Habla, Dialecto.Escribe, Dialecto.Dialecto_IdDial as 'Dialecto',\n"
            + " EstudiosBasicos.Educ, EstudiosBasicos.Culmi, EstudiosBasicos.CentrEstuBasi, convert(varchar,EstudiosBasicos.DesdBasi,105) as DesdBasi, convert(varchar,EstudiosBasicos.HasBasi,105) as HasBasi,\n"
            + " EstudiosSuperiores.EduSuper, EstudiosSuperiores.Espe,EstudiosSuperiores.CentrEstu,convert(varchar,EstudiosSuperiores.Desd,105) as Desd,convert(varchar,EstudiosSuperiores.Hast,105) as Hast,EstudiosSuperiores.Culmi,EstudiosSuperiores.GradAcadObte,\n"
            + " Ubigeo.departamento,Ubigeo.provincia,Ubigeo.distrito \n"
            + " from Empleado\n"
            + " left outer join Familiares Familiar on Familiar.Empleado_idEmpl = Empleado.idEmpl\n"
            + " left outer join Emergencia Emergentes on Emergentes.Empleado_idEmpl = Empleado.idEmpl\n"
            + " left outer join DetalleDialecto Dialecto on Dialecto.Empleado_idEmpl = Empleado.idEmpl\n"
            + " left outer join EstudiosBasicos EstudiosBasicos on EstudiosBasicos.Empleado_idEmpl = Empleado.idEmpl\n"
            + " left outer join EstudiosSuperior EstudiosSuperiores on EstudiosSuperiores.Empleado_idEmpl = Empleado.idEmpl\n"
            + " left outer join Ubigeo Ubigeo on Ubigeo.Empleado_idEmpl = Empleado.idEmpl \n"
            + " where Est like 'Inactivo';\n"
            + " ";
        } catch (Exception e) {
        }
    return lista;
}

    
}
