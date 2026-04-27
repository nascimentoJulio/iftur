package br.com.ifsul.iftur.controller;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.services.IDestinationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/destinations")
public class IFturController {


    private final IDestinationService destinationService;

    public IFturController(IDestinationService destinationService) {
        this.destinationService = destinationService;
    }

    // listagem
    @GetMapping
    public String list(Model model) {
        model.addAttribute("destinations", destinationService.getAll());
        return "home";
    }
    
    //abrir form
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("destination", new Destination());
        return "form";
    }

    // cadastrar
    @PostMapping
    public String save(@ModelAttribute Destination destination) {

        // geração simples de ID (igual ao exemplo do professor)
        Random rr = new Random(System.currentTimeMillis());
        destination.setId((long) rr.nextInt(1000));

        destinationService.save(destination);
        return "redirect:/destinations";
    }
    
    // exibir details
    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("destination", destinationService.getById(id));
        return "details";
    }
    
    //deletar
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        destinationService.delete(id);
        return "redirect:/destinations";
    }



    //@GetMapping
    //public String home(Model model) {
    //    model.addAttribute("titulo", "Explore o mundo com a IFTur");
    //    model.addAttribute("subtitulo", "Os melhores destinos com os melhores preços");
    //    List<Destination> destinations = destinationService.getAll();
    //    model.addAttribute("destinations", destinations);
    //
    //    return "home";
    //}
}
