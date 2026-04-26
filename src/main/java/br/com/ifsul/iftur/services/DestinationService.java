package br.com.ifsul.iftur.services;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.repository.IDestinationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service // camada intermedíaria recebe as chamadas dos controllers e delega as ´operações ao respositories
public class DestinationService implements IDestinationService {

    private final IDestinationRepository  destinationRepository;

    public DestinationService(IDestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public ArrayList<Destination> getAll() {
        return destinationRepository.getAll();
    }
    

    @Override
    public Destination getById(Long id) {
        return destinationRepository.findById(id);
    }
    

    @Override
    public void save(Destination destination) {
        destinationRepository.save(destination);
    }
    

    @Override
    public void delete(Long id) {
        destinationRepository.delete(id);
    }



}
