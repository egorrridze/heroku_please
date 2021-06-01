package my.egorrridze.trppconverter1;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
//import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
public class Restfull {

    @Autowired
    private ValueList values;

    @Autowired
    public Restfull(ValueList values){
        this.values = values;
    }


    void PostNote(String message){
        Note n = new Note();
        n.setMessage(message);
        n.setTime(new Date());
        String txt = ClientBuilder.newBuilder()
                .register(JacksonJsonProvider.class)
                .build()
                .target("http://localhost:8081")
                .path("/NotificationDesk/Notes")
                .request("application/json")
                .header("Content-Type", "application/json")
                .post(Entity.entity(n, MediaType.APPLICATION_JSON), String.class);
        System.out.println(txt);
    }


    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public ValueList AsIs() {
        return values;
    }


    @RequestMapping(
            value = "/convert",
            method = RequestMethod.GET)
    public double convert(@RequestParam String from, double num, String to) {
        for (Value v : values.values) {
            if (v.getName().equalsIgnoreCase(from)) {
                for (Value v1 : values.values) {
                    if (v1.getName().equalsIgnoreCase(to))
                        return num * v.coefficient / v1.coefficient;
                }
            }
        }
        return 404;
    }

    @RequestMapping(
            value = "/getValues",
            method = RequestMethod.GET
    )
    public List<String> getValues(@RequestParam String type){
        List<String> arr = new ArrayList<>();
        if (type.equals("масса")){
            for (Value v : values.massValue)
                arr.add(v.name);
        }
        else if (type.equals("длина")){
            for (Value v : values.lengthValue)
                arr.add(v.name);
        }

        return arr;
    }
}
