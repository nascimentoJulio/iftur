package br.com.ifsul.iftur.services;

import br.com.ifsul.iftur.domains.Destination;

import java.util.ArrayList;

public interface IDestinationService {
	ArrayList<Destination> getAll();

	Destination getById(Long id);

    void save(Destination destination);

    void delete(Long id);

}
