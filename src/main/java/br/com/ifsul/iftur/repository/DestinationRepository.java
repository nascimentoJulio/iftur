package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DestinationRepository implements IDestinationRepository {

    private static final List<Destination> destinations = List.of(
            new Destination("Rio de Janeiro","Praias, sol e muita cultura", "https://media.staticontent.com/media/pictures/0ecdf6e6-cf35-4a97-9d44-0d66ca0ac808","Brasil", 1),
            new Destination("Paris", "A cidade do amor", "https://www.melhoresdestinos.com.br/wp-content/uploads/2019/02/passagens-aereas-paris-capa2019-02.jpg", "França", 2),
            new Destination("Maldivas","Paraíso tropical","https://www.melhoresdestinos.com.br/wp-content/uploads/2023/06/maldivas-capa.jpg", "Maldivas", 3)
    );

    private static final List<Destination> myDestinations = new ArrayList<>();


    @Override
    public List<Destination> getAll() {
        return  destinations;
    }


    @Override
    public void save(Destination destino) {
        // int id = destinations.getLast().getId() + 1;
        destino.setId(4);
        destinations.add(destino);
    }


    @Override
    public Destination findById(int id) {
        return destinations.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Destination> findByName(String name) {
        return destinations.stream()
                .filter(d -> d.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }


    @Override
    public void deleteById(int id) {
        destinations.removeIf(d -> d.getId() == id);
    }
}
