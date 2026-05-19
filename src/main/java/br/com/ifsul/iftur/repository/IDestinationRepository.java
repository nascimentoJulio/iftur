package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;

import java.util.List;

public interface IDestinationRepository {
    List<Destination> getAll();
    Destination getById(int id);
    void save(int id);
    List<Destination> getMyDestinations();
    void deleteById(int id);
}
