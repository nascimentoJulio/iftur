package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.Random;



@Repository
public class DestinationRepository implements IDestinationRepository {

    private static ArrayList<Destination> destinations = new ArrayList<>();
    
    static {
    	Random rr = new Random(System.currentTimeMillis());
    	
    	Destination d1 = new Destination();
    	d1.setId((long) rr.nextInt(1000));
    	d1.setName("Rio de Janeiro");
    	d1.setDescription("A cidade maravilhosa");
    	d1.setImage("https://media.staticontent.com/media/pictures/0ecdf6e6-cf35-4a97-9d44-0d66ca0ac808");
    	d1.setPrice(2300.0);
    	destinations.add(d1);
    	
    	Destination d2 = new Destination();
    	d2.setId((long) rr.nextInt(1000));
    	d2.setName("Paris");
    	d2.setDescription("A cidade do amor");
    	d2.setImage("https://www.melhoresdestinos.com.br/wp-content/uploads/2019/02/passagens-aereas-paris-capa2019-02.jpg");
    	d2.setPrice(5350.0);
    	destinations.add(d2);
    	
    	Destination d3 = new Destination();
    	d3.setId((long) rr.nextInt(1000));
    	d3.setName("Malvidas");
    	d3.setDescription("Paraíso Tropical de Luxo");
    	d3.setImage("https://www.melhoresdestinos.com.br/wp-content/uploads/2023/06/maldivas-capa.jpg");
    	d3.setPrice(15100.0);
    	destinations.add(d3);
	
    }
    @Override
    public ArrayList<Destination> getAll() {
        return  destinations;
    }
    

    @Override
    public Destination findById(Long id) {
        for (Destination destination : destinations) {
            if (destination.getId().equals(id)) {
                return destination;
            }
        }
        return null;
    }

    @Override
    public void save(Destination destination) {
        destinations.add(destination);
    }

    @Override
    public void delete(Long id) {
        Destination destination = findById(id);
        if (destination != null) {
            destinations.remove(destination);
        }
    }

}
