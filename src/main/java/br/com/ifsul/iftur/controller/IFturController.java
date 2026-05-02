package br.com.ifsul.iftur.controller;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.DestinationService;
// import br.com.ifsul.iftur.services.IDestinationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IFturController {

    private final DestinationService service;

    public IFturController(DestinationService service) {
        this.service = service;
    }

    // private final IDestinationService destinationService;

    // public IFturController(IDestinationService destinationService) {
    // this.destinationService = destinationService;
    // }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Explore o mundo com a IFTur");
        model.addAttribute("subtitulo", "Os melhores destinos com os melhores preços");
        List<Destination> destinations = service.getAll();
        model.addAttribute("destinations", destinations);

        return "home";
    }

    // Cadastro
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Destination destino) {
        service.cadastrar(destino);
        return "redirect:/";
    }

    // Detalhes
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("destino", service.buscarPorId(id));
        return "detalhes";
    }

    // Delete
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        service.deletar(id);
        return "redirect:/";
    }

    // Busca
    @GetMapping("/buscar")
    public String buscar(@RequestParam String name, Model model) {
        List<Destination> filtrados = service.getAll()
                .stream()
                .filter(d -> d.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

        model.addAttribute("destinations", filtrados);
        return "home";
    }
}
