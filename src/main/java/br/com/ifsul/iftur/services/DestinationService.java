package br.com.ifsul.iftur.services;

import br.com.ifsul.iftur.domains.Destination;
// import br.com.ifsul.iftur.repository.IDestinationRepository;
import br.com.ifsul.iftur.repository.IDestinationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DestinationService implements IDestinationService {

    private final IDestinationRepository destinationRepository;

    public DestinationService(IDestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public List<Destination> getAll() {
        return destinationRepository.getAll();
    }

    @Override
    public void addDestination(int id) {
        destinationRepository.save(id);
    }

    @Override
    public Destination getById(int id) {
        return destinationRepository.getById(id);
    }

    @Override
    public List<Destination> getMyDestinations() {
        return destinationRepository.getMyDestinations();
    }

    @Override
    public void deleteById(int id) {
        destinationRepository.deleteById(id);
    }

}
