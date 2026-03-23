package com.saludconAmor.demo.Services;

import com.saludconAmor.demo.Models.FacturacionCliente;
import com.saludconAmor.demo.Repository.FacturacionClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class FacturacionClienteService {

    @Autowired
    private FacturacionClienteRepository repository;

    public List<FacturacionCliente> listarTodas() {
        return repository.findAll();
    }

    public Optional<FacturacionCliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<FacturacionCliente> buscarPorVendedor(Long cedula) {
        return repository.findByCedulaVendedor(cedula);
    }

    public List<FacturacionCliente> buscarPorCliente(Long cedula) {
        return repository.findByCedulaCliente(cedula);
    }

    public List<FacturacionCliente> buscarPorEstado(Long idEstado) {
        return repository.findByIdEstado(idEstado);
    }

    public BigDecimal obtenerTotalVentas() {
        BigDecimal total = repository.sumTotalVentas();
        return total != null ? total : BigDecimal.ZERO;
    }

    public long obtenerCantidadFacturas() {
        return repository.count();
    }

    public List<Object[]> obtenerVentasPorVendedor() {
        return repository.ventasPorVendedor();
    }

    public List<Object[]> obtenerProductosMasVendidos() {
        return repository.productosMasVendidos();
    }
}
