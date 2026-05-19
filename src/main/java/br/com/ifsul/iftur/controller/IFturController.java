package br.com.ifsul.iftur.controller;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.DestinationService;
// import br.com.ifsul.iftur.services.IDestinationService;

import br.com.ifsul.iftur.services.IDestinationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IFturController {

     private final IDestinationService destinationService;

     public IFturController(IDestinationService destinationService) {
     this.destinationService = destinationService;
     }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Explore o mundo com a IFTur");
        model.addAttribute("subtitulo", "Os melhores destinos com os melhores preços");
        List<Destination> destinations = destinationService.getAll();
        List<Destination> myDestinations = destinationService.getMyDestinations();
        model.addAttribute("destinations", destinations);
        model.addAttribute("myDestinations", myDestinations);

        return "home";
    }

    @PostMapping("/cadastrar/{id}")
    public String cadastrar(@PathVariable int id) {
        destinationService.addDestination(id);
        return "redirect:/";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable int id, Model model) {
        model.addAttribute("destination", destinationService.getById(id));
        return "detalhes";
    }


    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id) {
         destinationService.deleteById(id);
        return "redirect:/";
    }
}
