package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.api;


import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.ResponseMessage;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.service.keycloakService keycloakService;

    @PostMapping("/user")
    public ResponseEntity<ResponseMessage> create(@RequestBody User user){

        Object[] obj = keycloakService.createUser(user);
        int status = (int) obj[0];
        ResponseMessage message = (ResponseMessage) obj[1];
        return ResponseEntity.status(status).body(message);
    }
}
