package garage.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexResource {

    @RequestMapping()
    public String index() {
        return "garage open!";
    }
}
