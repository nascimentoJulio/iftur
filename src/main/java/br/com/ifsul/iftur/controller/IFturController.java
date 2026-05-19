package br.com.ifsul.iftur.controller;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.DestinationService;
// import br.com.ifsul.iftur.services.IDestinationService;
import br.com.ifsul.iftur.services.IDestinationService;

import br.com.ifsul.iftur.services.IDestinationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IFturController {

    private final IDestinationService service;

    public IFturController(DestinationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(@RequestParam(required = false) String search, Model model) {

        model.addAttribute("titulo", "Explore o mundo com a IFTur");
        model.addAttribute("subtitulo", "Os melhores destinos com os melhores preços");

        List<Destination> destinations;

        if (search != null && !search.trim().isEmpty()) {
            destinations = service.buscarPorNome(search.trim());
        } else {
            destinations = service.getAll();
        }
        List<Destination> myDestinations = service.getMyDestinations();
        model.addAttribute("destinations", destinations);
        model.addAttribute("myDestinations", myDestinations);

        return "home";
    }

    // Cadastrar
    @PostMapping("/destinos")
    public String cadastrar(@ModelAttribute Destination destino) {
        service.cadastrar(destino);
        return "redirect:/";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    // Detalhes
    // @GetMapping("/detalhes/{id}")
    // public String detalhes(@PathVariable int id, Model model) {
    // model.addAttribute("destino", service.buscarPorId(id));
    // return "detalhes";
    // }
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {

        Destination destino = service.buscarPorId(id);

        if (destino == null) {
            return "redirect:/"; // evita erro 500
        }

        model.addAttribute("destino", destino);
        return "detalhes";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
         service.deletar(id);
        return "redirect:/";
    }

}
