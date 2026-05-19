package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DestinationRepository implements IDestinationRepository {

    private static final List<Destination> destinations = List.of(
            new Destination(1L,"Rio de Janeiro","Praias, sol e muita cultura", "https://media.staticontent.com/media/pictures/0ecdf6e6-cf35-4a97-9d44-0d66ca0ac808","Brasil" ),
            new Destination(2L,"Paris", "A cidade do amor", "https://www.melhoresdestinos.com.br/wp-content/uploads/2019/02/passagens-aereas-paris-capa2019-02.jpg", "França" ),
            new Destination(3L,"Maldivas","Paraíso tropical","https://www.melhoresdestinos.com.br/wp-content/uploads/2023/06/maldivas-capa.jpg", "Maldivas" )
    );

    private static final List<Destination> myDestinations = new ArrayList<>();


    @Override
    public List<Destination> getAll() {
        return  destinations;
    }


    @Override
    public void save(Destination destino) {
        destino.setId(myDestinations.size() + 1L);
        myDestinations.add(destino);
    }


    @Override
    public Destination findById(int id) {
        return destinations.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Destination> getMyDestination() {
        return myDestinations;
    }


    @Override
    public List<Destination> findByName(String name) {
        return destinations.stream()
                .filter(d -> d.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }


    @Override
    public void deleteById(int id) {
        myDestinations.removeIf(d -> d.getId() == id);
    }
}
