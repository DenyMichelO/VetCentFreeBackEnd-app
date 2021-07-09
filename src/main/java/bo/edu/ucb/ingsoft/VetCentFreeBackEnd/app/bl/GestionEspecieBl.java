package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.EspecieDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.EspecieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionEspecieBl {
    @Autowired
    EspecieDao especieDao;

    public List<EspecieDto> especies() throws SQLException {
        return especieDao.especies();
    }
}
