package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.api;


import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl.GestionRazaBl;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RazaController {
    @Autowired
    GestionRazaBl gestionRazaBl;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path= "/raza")
    public ResponseDto razas() throws SQLException {
        return new ResponseDto(true,gestionRazaBl.razas(), "Lista de razas");
    }
}
