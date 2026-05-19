package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;

import java.util.List;

public interface IDestinationRepository {
    public List<Destination> getAll();
    public void save(Destination destino);
    public Destination findById(int id);
    public List<Destination> getMyDestination();
    public List<Destination> findByName(String name);
    public void deleteById(int id);
}
