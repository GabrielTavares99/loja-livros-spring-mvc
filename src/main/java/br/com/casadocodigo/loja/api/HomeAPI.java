package br.com.casadocodigo.loja.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/mobile")
public class HomeAPI {

    @RequestMapping(method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity home(){

        Map<String, String> map = new HashMap<>();
        map.put("acao", "sucesso");
        return new ResponseEntity(map, HttpStatus.OK);
    }

}
