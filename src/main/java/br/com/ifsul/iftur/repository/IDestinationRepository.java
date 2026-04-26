package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;

import java.util.ArrayList;

public interface IDestinationRepository {

    ArrayList<Destination> getAll();
    

    Destination findById(Long id);

    void save(Destination destination);

    void delete(Long id);

}
