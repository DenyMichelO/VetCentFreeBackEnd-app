package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.Especie;
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
public class EspeciaDao {

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


    public List<Especie> especies() throws SQLException {
        List<Especie> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select especie_id, nombre_especie from especie");
            while(res.next()){
                Especie ob = new Especie();
                ob.setEspecie(res.getString("nombre_especie"));
                ob.setEspecieId(res.getInt("especie_id"));
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
