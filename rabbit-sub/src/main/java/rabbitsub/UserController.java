package rabbitsub;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final MessageSubscriber subscriber;

    public UserController(MessageSubscriber subscriber) {
        this.subscriber = subscriber;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getAll() {
        var user = subscriber.getUser();
        return ResponseEntity.ok(user);
    }
}
