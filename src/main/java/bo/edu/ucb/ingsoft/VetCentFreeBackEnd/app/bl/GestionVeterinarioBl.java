package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;


import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.VeterinarioDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.VeterinarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionVeterinarioBl {

    @Autowired
    VeterinarioDao veterinarioDao;

    public List<VeterinarioDto> SelectAllVeterinarios(int limit, int offset, String ciudad, String especialidad) {
        return veterinarioDao.SelectAllVeterinarios(limit,offset,ciudad,especialidad);
    }

}
