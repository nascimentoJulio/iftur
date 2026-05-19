package br.com.ifsul.iftur.services;

import br.com.ifsul.iftur.domains.Destination;

import java.util.List;

public interface IDestinationService {
    List<Destination> getAll();
    
    Destination cadastrar(Destination destino);

    Destination buscarPorId(int id);

    List<Destination> buscarPorNome(String nome);

    void deletar(int id);
}
