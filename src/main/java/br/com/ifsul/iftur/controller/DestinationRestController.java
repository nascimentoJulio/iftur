package br.com.ifsul.iftur.controller;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.DestinationService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinationRestController {

    private final DestinationService service;

    public DestinationRestController(DestinationService service) {
        this.service = service;
    }


    //Listar
    @GetMapping
    public List<Destination> listar() {
        return service.getAll();
    }

    //Busca
    @GetMapping("/{id}")
    public Destination buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    //Cadastrar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Destination cadastrar(@RequestBody Destination destino) {
        return service.cadastrar(destino);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        service.deletar(id);
    }
}