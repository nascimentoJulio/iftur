package br.com.ifsul.iftur.repository;

import br.com.ifsul.iftur.domains.Destination;

import java.util.List;

public interface IDestinationRepository {
    public List<Destination> getAll();
}
