package br.com.ifsul.iftur.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.IDestinationService;

@RestController
@RequestMapping("/api/destinations")
public class DestinationRestController {

private final IDestinationService destinationService;

    public DestinationRestController(IDestinationService destinationService) {
        this.destinationService = destinationService;
    }

    // listar todos
    @GetMapping
    public ArrayList<Destination> getAll() {
        return destinationService.getAll();
    }

    // buscar pelo id
    @GetMapping("/{id}")
    public Destination getById(@PathVariable Long id) {
        return destinationService.getById(id);
    }

    // cadastrar
    @PostMapping
    public void save(@RequestBody Destination destination) {
        // gera o id random
        Random rr = new Random(System.currentTimeMillis());
        destination.setId((long) rr.nextInt(1000));

        destinationService.save(destination);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        destinationService.delete(id);
    }

}
