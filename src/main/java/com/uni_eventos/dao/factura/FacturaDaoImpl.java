package com.uni_eventos.dao.factura;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

import com.uni_eventos.dto.FacturaDto;
import com.uni_eventos.models.compra.Factura;
import com.uni_eventos.models.compra.FacturaManager;

public class FacturaDaoImpl implements FacturaDao {

    public FacturaDaoImpl() {
        FacturaManager.cargarDatos();
    }

    @Override
    public Factura crearFactura(FacturaDto facturaDto) {
        Factura nuevFactura = Factura.builder().codigo(facturaDto.codigo())
                .fecha(facturaDto.fecha())
                .total(facturaDto.total())
                .subTotal(facturaDto.subTotal())
                .build();
        List<Factura> facturas = FacturaManager.getFacturas();
        facturas.add(nuevFactura);
        FacturaManager.setFacturas(facturas);
        return nuevFactura;
    }

    @Override
    public boolean eliminarFactura(UUID uuid) {
        boolean eliminado = false;
        Optional<Factura> factura = filtrarCodigo(uuid);
        if (factura.isPresent()) {
            List<Factura> facturas = FacturaManager.getFacturas();
            Predicate<Factura> condicion = f -> f.getCodigo().equals(uuid);
            eliminado = facturas.removeIf(condicion);
            FacturaManager.setFacturas(facturas);
        }
        return eliminado;
    }

    @Override
    public Factura getFactura(UUID uuid) {
        return filtrarCodigo(uuid).get();
    }

    @Override
    public List<Factura> listarFacturas() {
        return FacturaManager.getFacturas();
    }

    private Optional<Factura> filtrarCodigo(UUID uuid) {
        Predicate<Factura> condicion = f -> f.getCodigo().equals(uuid);
        return FacturaManager.getFacturas().stream().filter(condicion).findFirst();
    }

}
