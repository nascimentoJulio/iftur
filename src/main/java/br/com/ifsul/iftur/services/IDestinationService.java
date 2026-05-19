package br.com.ifsul.iftur.services;

import br.com.ifsul.iftur.domains.Destination;

import java.util.List;

public interface IDestinationService {
    List<Destination> getAll();
    void addDestination(int id);
    Destination getById(int id);
    List<Destination> getMyDestinations();
    void deleteById(int id);
}
