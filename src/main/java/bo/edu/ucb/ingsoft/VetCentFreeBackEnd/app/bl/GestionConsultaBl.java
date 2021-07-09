package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.ConsultaDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionConsultaBl {

    @Autowired
    ConsultaDao consultaDao;

    public Consulta registrarConsulta(Consulta consulta){
        return consultaDao.registrar(consulta);
    }
}
