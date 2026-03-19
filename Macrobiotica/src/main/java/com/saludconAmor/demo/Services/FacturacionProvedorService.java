package com.saludconAmor.demo.Services;

import com.saludconAmor.demo.Models.FacturacionProvedor;
import com.saludconAmor.demo.Repository.FacturacionProvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionProvedorService {

    @Autowired
    private FacturacionProvedorRepository repository;

    public List<FacturacionProvedor> listarTodas() {
        return repository.findAll();
    }

    public void guardar(FacturacionProvedor facturacion) {
        repository.save(facturacion);
    }

    public Optional<FacturacionProvedor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
