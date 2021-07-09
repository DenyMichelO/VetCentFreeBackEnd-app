package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.RazaDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.RazaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionRazaBl {
    @Autowired
    RazaDao razaDao;

    public List<RazaDto> razas() throws SQLException {
        return razaDao.razas();
    }
}
