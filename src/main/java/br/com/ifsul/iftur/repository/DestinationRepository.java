package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DestinationRepository implements IDestinationRepository {

    private static final List<Destination> destinations = List.of(
            new Destination("Rio de Janeiro","Praias, sol e muita cultura", "https://media.staticontent.com/media/pictures/0ecdf6e6-cf35-4a97-9d44-0d66ca0ac808", 1),
            new Destination("Paris", "A cidade do amor", "https://www.melhoresdestinos.com.br/wp-content/uploads/2019/02/passagens-aereas-paris-capa2019-02.jpg", 2),
            new Destination("Maldivas","Paraíso tropical","https://www.melhoresdestinos.com.br/wp-content/uploads/2023/06/maldivas-capa.jpg", 3)
    );


    @Override
    public List<Destination> getAll() {
        return  destinations;
    }
}
