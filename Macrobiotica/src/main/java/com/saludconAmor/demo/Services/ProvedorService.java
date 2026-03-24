package com.saludconAmor.demo.Services;

import com.saludconAmor.demo.Models.Provedor;
import com.saludconAmor.demo.Repository.ProvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvedorService {

    @Autowired
    private ProvedorRepository repository;

    public List<Provedor> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Provedor provedor) {
        repository.save(provedor);
    }

    public Optional<Provedor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
