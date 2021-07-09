package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.RazaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class RazaDao {

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


    public List<RazaDto> razas() throws SQLException {
        List<RazaDto> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select raza_id, nombre_raza from raza");
            while(res.next()){
                RazaDto ob = new RazaDto();
                ob.setRaza(res.getString("nombre_raza"));
                ob.setRazaId(res.getInt("raza_id"));
                array.add(ob);
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
        return array;
    }

}
