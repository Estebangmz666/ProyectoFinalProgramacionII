package com.uni_eventos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.uni_eventos.dao.factura.FacturaDao;
import com.uni_eventos.dao.factura.FacturaDaoImpl;
import com.uni_eventos.dto.FacturaDto;
import com.uni_eventos.models.compra.Factura;

public class FacturaService {
    FacturaDao facturaDao = new FacturaDaoImpl();

    public FacturaDto crearFactura(LocalDate fecha) {
        Factura factura = facturaDao.crearFactura(new FacturaDto(null, fecha, 0, 0));
        return convertirADto(factura);
    }

    public boolean eliminarFactura(UUID codigo) {
        return facturaDao.eliminarFactura(codigo);
    }

    public FacturaDto getFactura(UUID codigo) {
        Factura factura = facturaDao.getFactura(codigo);
        return convertirADto(factura);
    }

    public List<FacturaDto> getAll() {
        List<Factura> facturas = facturaDao.listarFacturas();
        return convertirADto(facturas);
    }

    public FacturaDto convertirADto(Factura factura) {
        return new FacturaDto(factura.getCodigo(), factura.getFecha(), factura.getTotal(), factura.getSubTotal());
    }

    public Factura convertirAFactura(FacturaDto facturaDto) {
        return Factura.builder()
                .codigo(facturaDto.codigo())
                .fecha(facturaDto.fecha())
                .total(facturaDto.total())
                .subTotal(facturaDto.subTotal())
                .build();
    }

    public FacturaDto convertirADto(UUID codigo, LocalDate fecha, int total, int subTotal) {
        return new FacturaDto(codigo, fecha, total, subTotal);
    }

    public Factura convertirAFactura(UUID codigo, LocalDate fecha, int total, int subTotal) {
        return Factura.builder()
                .codigo(codigo)
                .fecha(fecha)
                .total(total)
                .subTotal(subTotal)
                .build();
    }

    public List<FacturaDto> convertirADto(List<Factura> facturas) {
        return facturas.stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

}
