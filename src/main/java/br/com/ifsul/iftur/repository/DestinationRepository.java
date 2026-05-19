package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DestinationRepository implements IDestinationRepository {

    private static final List<Destination> destinations =  List.of(
            new Destination(1L, "Rio de Janeiro", "Praias, sol e muita cultura",
                    "https://media.staticontent.com/media/pictures/0ecdf6e6-cf35-4a97-9d44-0d66ca0ac808",
                    "Brasil", "5 dias", 2500.0),

            new Destination(2L, "Paris", "A cidade do amor",
                    "https://www.melhoresdestinos.com.br/wp-content/uploads/2019/02/passagens-aereas-paris-capa2019-02.jpg",
                    "França", "7 dias", 8500.0),

            new Destination(3L, "Maldivas", "Paraíso tropical",
                    "https://www.melhoresdestinos.com.br/wp-content/uploads/2023/06/maldivas-capa.jpg",
                    "Maldivas", "6 dias", 12000.0),

            new Destination(4L, "Nova York", "A cidade que nunca dorme",
                    "https://images.unsplash.com/photo-1549921296-3a6b5b52b2b6",
                    "EUA", "5 dias", 7000.0),

            new Destination(5L, "Tóquio", "Tecnologia e tradição",
                    "https://images.unsplash.com/photo-1549692520-acc6669e2f0c",
                    "Japão", "8 dias", 11000.0),

            new Destination(6L, "Roma", "História e arquitetura incrível",
                    "https://images.unsplash.com/photo-1529260830199-42c24126f198",
                    "Itália", "6 dias", 7800.0),

            new Destination(7L, "Barcelona", "Praia e cultura vibrante",
                    "https://images.unsplash.com/photo-1505731132164-cca8b5b43b2d",
                    "Espanha", "5 dias", 7200.0),

            new Destination(8L, "Dubai", "Luxo e modernidade",
                    "https://images.unsplash.com/photo-1504274066651-8d31a536b11a",
                    "Emirados Árabes", "5 dias", 9500.0),

            new Destination(9L, "Cancún", "Praias e resorts paradisíacos",
                    "https://images.unsplash.com/photo-1507525428034-b723cf961d3e",
                    "México", "6 dias", 6800.0),

            new Destination(10L, "Lisboa", "Charme europeu e gastronomia",
                    "https://images.unsplash.com/photo-1507089947368-19c1da9775ae",
                    "Portugal", "5 dias", 6000.0),

            new Destination(11L, "Sydney", "Cidade costeira icônica",
                    "https://images.unsplash.com/photo-1506973035872-a4ec16b8e8d9",
                    "Austrália", "7 dias", 13000.0),

            new Destination(12L, "Cidade do Cabo", "Natureza e paisagens incríveis",
                    "https://images.unsplash.com/photo-1526318472351-c75fcf070305",
                    "África do Sul", "6 dias", 9000.0),

            new Destination(13L, "Bangkok", "Cultura exótica e templos",
                    "https://images.unsplash.com/photo-1508009603885-50cf7c579365",
                    "Tailândia", "6 dias", 6500.0),

            new Destination(14L, "Istambul", "Encontro entre Europa e Ásia",
                    "https://images.unsplash.com/photo-1527838832700-5059252407fa",
                    "Turquia", "5 dias", 6700.0),

            new Destination(15L, "Toronto", "Cidade moderna e multicultural",
                    "https://images.unsplash.com/photo-1505761671935-60b3a7427bad",
                    "Canadá", "5 dias", 8800.0)
    );

    private static final List<Destination> myDestinations = new ArrayList<>();


    @Override
    public List<Destination> getAll() {
        return  destinations;
    }

    @Override
    public Destination getById(int id) {
        return destinations.get(id -1);
    }

    @Override
    public void save(int id) {
        boolean exists = myDestinations.stream().anyMatch(destination -> destination.getId() == id);
        if (!exists) {
            myDestinations.add(getById(id));
        }
    }

    @Override
    public List<Destination> getMyDestinations() {
        return myDestinations;
    }

    @Override
    public void deleteById(int id) {
        myDestinations.removeIf(destination -> destination.getId() == id);
    }
}
