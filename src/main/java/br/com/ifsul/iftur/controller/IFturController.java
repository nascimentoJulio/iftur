package br.com.ifsul.iftur.controller;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.DestinationService;
// import br.com.ifsul.iftur.services.IDestinationService;
import br.com.ifsul.iftur.services.IDestinationService;

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
        model.addAttribute("destinations", destinations);

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

    // Deletar
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        service.deletar(id);
        return "redirect:/";
    }

    // Buscar
    // @GetMapping("/buscar")
    // public String buscar(@RequestParam String name, Model model) {
    // List<Destination> filtrados = service.getAll()
    // .stream()
    // .filter(d -> d.getName().toLowerCase().contains(name.toLowerCase()))
    // .toList();

    // model.addAttribute("destinations", filtrados);
    // return "home";
    // }
}
