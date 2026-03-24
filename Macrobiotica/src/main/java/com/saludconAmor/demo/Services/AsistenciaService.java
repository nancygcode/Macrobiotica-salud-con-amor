package com.saludconAmor.demo.Services;

import com.saludconAmor.demo.Models.Asistencia;
import com.saludconAmor.demo.Repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> listarTodas() {
        return asistenciaRepository.findAll();
    }

    public List<Asistencia> buscarPorEmpleado(Long cedula) {
        return asistenciaRepository.findByCedula(cedula);
    }

    public List<Asistencia> buscarPorTipo(Long idTipo) {
        return asistenciaRepository.findByIdTipoAsistencia(idTipo);
    }

    public List<Asistencia> buscarPorEstado(Long idEstado) {
        return asistenciaRepository.findByIdEstado(idEstado);
    }

    public long obtenerTotalRegistros() {
        return asistenciaRepository.count();
    }

    public List<Object[]> obtenerRegistrosPorEmpleado() {
        return asistenciaRepository.obtenerRegistrosPorEmpleado();
    }

    public List<Object[]> obtenerRegistrosPorTipo() {
        return asistenciaRepository.obtenerRegistrosPorTipo();
    }
}
