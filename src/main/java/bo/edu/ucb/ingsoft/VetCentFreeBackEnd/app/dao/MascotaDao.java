package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.MascotaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class MascotaDao {
    /**
     * Inicializamos sequenceDao para simular el "AUTO INCREMENT" de las llaves PRIMARIAS requeridas"
     **/

    @Autowired
    private SequenceDao sequenceDao;

    /**
     * Inicializamos datasource para la conexión a la base de datos
     **/

    @Autowired
    public DataSource dataSource;


    public MascotaDto registrar(MascotaDto ob){
        ob.setMascota_id(sequenceDao.getLLaveprincipal("mascota"));

        Connection con=null;
        Calendar fecha = new GregorianCalendar();

        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fecha_actual="";
        fecha_actual=año+"-"+mes+"-"+dia;

        ob.setFecha_registro(fecha_actual);
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("insert into mascota (mascota_id, especie_id, raza_id, dueño_id, color_id, genero_id, nombre_mascota, tamaño, fecha_registro) values (?,?,?,?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD')) ");
            preesta.setInt(1, ob.getMascota_id());
            preesta.setInt(2, ob.getEspecie_id());
            preesta.setInt(3, ob.getRaza_id());
            preesta.setInt(4, ob.getDueno_id());
            preesta.setInt(5, ob.getColor_id());
            preesta.setInt(6, ob.getGenero_id());
            preesta.setString(7, ob.getNombre());
            preesta.setString(8, ob.getTamano());
            preesta.setString(9, ob.getFecha_registro());


            preesta.executeUpdate();

            String pal="";
            for (int i=0;i<ob.getImagenId().length;i++){
                if(i==0){
                    pal="PRINCIPAL";
                }else{
                    pal="SECUNDARIO";
                }

                PreparedStatement preesta1;
                preesta1 = con.prepareStatement("insert into imagen_mascota  (imagen_id,mascota_id) VALUES (?,?)");
                preesta1.setInt(1, ob.getImagenId()[i]);
                preesta1.setInt(2,ob.getMascota_id());

                preesta1.executeUpdate();
            }







        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {}
            }
        }
        return ob;
    }

}
