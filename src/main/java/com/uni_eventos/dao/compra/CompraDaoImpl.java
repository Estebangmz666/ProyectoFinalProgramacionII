package com.uni_eventos.dao.compra;

import java.util.List;
import java.util.Optional;

import java.util.function.Predicate;

import com.uni_eventos.dto.CompraDto;
import com.uni_eventos.models.compra.Compra;
import com.uni_eventos.models.compra.CompraManager;

public class CompraDaoImpl implements CompraDao {
    public CompraDaoImpl() {
        CompraManager.cargarDatos();
    }

    @Override
    public Compra crearCompra(CompraDto compraDto) {
        Compra compraNueva = Compra.builder()
                .usuarioId(0)
                .eventoId(compraDto.eventoId())
                .cantidad(compraDto.cantidad())
                .cuponId(compraDto.cuponId())
                .codigoFactura(compraDto.codigoFactura()).build();

        List<Compra> compras = CompraManager.getCompras();
        compras.add(compraNueva);
        CompraManager.setCompras(compras);
        return compraNueva;
    }

    @Override
    public boolean eliminarCompra(int idCompra) {
        boolean eliminado = false;
        Optional<Compra> compra = filtrarId(idCompra);
        List<Compra> compras = CompraManager.getCompras();
        if (compra.isPresent()) {
            Predicate<Compra> condicion = c -> c.getId() == idCompra;
            compras.removeIf(condicion);
            CompraManager.setCompras(compras);
        }

        return eliminado;
    }

    @Override
    public Compra getCompra(int idCompra) {
        return filtrarId(idCompra).get();
    }

    @Override
    public List<Compra> listarCompras() {
        return CompraManager.getCompras();
    }

    private Optional<Compra> filtrarId(int id) {
        Predicate<Compra> condicion = c -> c.getId() == id;
        return CompraManager.getCompras().stream().filter(condicion).findFirst();
    }

}
