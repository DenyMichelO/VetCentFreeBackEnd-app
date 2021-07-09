package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;


import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.EspecialidadDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.EspecialidadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionEspecialidadesBl {
    @Autowired
    EspecialidadDao especialidadDao;

    public List<EspecialidadDto> SelectAllSpecialties() throws SQLException {
        return especialidadDao.SelectAllSpecialties();
    }
}
