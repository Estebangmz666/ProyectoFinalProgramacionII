package com.uni_eventos.service;

import java.util.List;
import java.util.stream.Collectors;

import com.uni_eventos.dao.cupon.CuponDao;
import com.uni_eventos.dao.cupon.CuponDaoImpl;
import com.uni_eventos.dto.CuponDto;
import com.uni_eventos.models.cupon.Cupon;

public class CuponService {
    CuponDao cuponDao = new CuponDaoImpl();

    public CuponDto crearCupon(int descuento, boolean disponible) {
        Cupon cupon = cuponDao.crearCupon(convertirADto(0, descuento, disponible));
        return convertirADto(cupon);
    }

    public boolean eliminarCupon(int idCupon) {
        return cuponDao.eliminarCupon(idCupon);
    }

    public CuponDto getCupon(int id) {
        return convertirADto(cuponDao.getCupon(id));
    }

    public List<CuponDto> getCupones() {
        return convertirADto(cuponDao.listarCupones());
    }

    public CuponDto convertirADto(int id, int descuento, boolean disponible) {
        return new CuponDto(id, descuento, disponible);
    }

    public CuponDto convertirADto(Cupon cupon) {
        return new CuponDto(cupon.getId(), cupon.getDescuento(), cupon.isDisponible());
    }

    public Cupon convertirACupon(CuponDto cupon) {
        Cupon cupon2 = Cupon.builder().id(cupon.id()).descuento(cupon.descuento()).disponible(cupon.disponible())
                .build();
        return cupon2;
    }

    public Cupon convertirACupon(int id, int descuento, boolean disponible) {
        return Cupon.builder().id(id).descuento(descuento).disponible(disponible).build();
    }

    public List<CuponDto> convertirADto(List<Cupon> cupones) {
        return cupones.stream()
                .map(cupon -> new CuponDto(cupon.getId(), cupon.getDescuento(), cupon.isDisponible()))
                .collect(Collectors.toList());
    }

}
