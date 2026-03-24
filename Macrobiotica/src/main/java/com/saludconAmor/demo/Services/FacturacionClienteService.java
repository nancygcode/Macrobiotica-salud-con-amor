package com.saludconAmor.demo.Services;

import com.saludconAmor.demo.Models.FacturacionCliente;
import com.saludconAmor.demo.Repository.FacturacionClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturacionClienteService {

    @Autowired
    private FacturacionClienteRepository repository;

    public List<FacturacionCliente> listarTodas() {
        return repository.findAll();
    }

    public void guardar(FacturacionCliente factura) {
        repository.save(factura);
    }

    public Optional<FacturacionCliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public java.math.BigDecimal obtenerTotalVentas() {
        return repository.obtenerTotalVentas();
    }

    public long obtenerCantidadFacturas() {
        return repository.obtenerCantidadFacturas();
    }

    public List<Object[]> obtenerVentasPorVendedor() {
        return repository.obtenerVentasPorVendedor();
    }

    public List<Object[]> obtenerProductosMasVendidos() {
        return repository.obtenerProductosMasVendidos();
    }

    public List<FacturacionCliente> buscarPorVendedor(Long cedula) {
        return repository.findByCedulaVendedor(cedula);
    }

    public List<FacturacionCliente> buscarPorEstado(Long idEstado) {
        return repository.findByIdEstado(idEstado);
    }
}
