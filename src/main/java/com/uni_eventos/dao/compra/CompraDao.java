package com.uni_eventos.dao.compra;

import java.util.List;

import com.uni_eventos.dto.CompraDto;
import com.uni_eventos.models.compra.Compra;

public interface CompraDao {
    Compra crearCompra(CompraDto compraDto);

    boolean eliminarCompra(int idCompra);

    Compra getCompra(int idCompra);

    List<Compra> listarCompras();
}
