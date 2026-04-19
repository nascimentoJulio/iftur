package br.com.ifsul.iftur.controller;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.IDestinationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IFturController {


    private final IDestinationService destinationService;

    public IFturController(IDestinationService destinationService) {
        this.destinationService = destinationService;
    }


    @GetMapping
    public String home(Model model) {
        model.addAttribute("titulo", "Explore o mundo com a IFTur");
        model.addAttribute("subtitulo", "Os melhores destinos com os melhores preços");
        List<Destination> destinations = destinationService.getAll();
        model.addAttribute("destinations", destinations);

        return "home";
    }
}
