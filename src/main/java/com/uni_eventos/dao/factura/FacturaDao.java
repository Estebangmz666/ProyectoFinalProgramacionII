package com.uni_eventos.dao.factura;

import java.util.List;
import java.util.UUID;

import com.uni_eventos.dto.FacturaDto;
import com.uni_eventos.models.compra.Factura;

public interface FacturaDao {
    Factura crearFactura(FacturaDto facturaDto);

    boolean eliminarFactura(UUID uuid);

    Factura getFactura(UUID uuid);

    List<Factura> listarFacturas();
}
