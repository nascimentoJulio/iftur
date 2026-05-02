package br.com.ifsul.iftur.services;

import br.com.ifsul.iftur.domains.Destination;
// import br.com.ifsul.iftur.repository.IDestinationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DestinationService implements IDestinationService {

    // private final IDestinationRepository destinationRepository;

    // public DestinationService(IDestinationRepository destinationRepository) {
    // this.destinationRepository = destinationRepository;
    // }

    private List<Destination> destinos = new ArrayList<>();
    private int contador = 1;
    // Cadastrar
    public Destination cadastrar(Destination destino) {
        destino.setId(contador++);
        destinos.add(destino);
        return destino;
    }

    // Listar
    @Override
    public List<Destination> getAll() {
        return destinos;
    }

    // Busca
    public Destination buscarPorId(int id) {
        for (Destination d : destinos) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    // Deletar
    public void deletar(int id) {
        destinos.removeIf(d -> d.getId() == id);
    }

    public DestinationService() {
    destinos.add(new Destination(
        "Paris",
        "A cidade luz da França",
        "https://images.pexels.com/photos/338515/pexels-photo-338515.jpeg",
        contador++
    ));

    destinos.add(new Destination(
        "Maldivas",
        "Praias paradisíacas com água cristalina",
        "https://images.pexels.com/photos/1287460/pexels-photo-1287460.jpeg",
        contador++
    ));

    destinos.add(new Destination(
        "Nova York",
        "A cidade que nunca dorme",
        "https://images.pexels.com/photos/466685/pexels-photo-466685.jpeg",
        contador++
    ));
}
}
