package cat.itacademy.s04.t01.n01.S04T01N01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(defaultValue = "UNKNOWN")String nom) {
        return "Hola "+nom+" Estàs executant un projecte Maven";
    }
    @GetMapping({"/HelloWorld2", "/HelloWorld2/{nom}"})
    public String saluda2(@PathVariable(required = false) String nom){
        if (nom == null) {
            nom = "UNKNOWN";
        }
        return "Hola "+nom+" Estàs executant un projete Maven";
    }

}
