package com.uni_eventos.dao.cupon;

import java.util.List;

import com.uni_eventos.dto.CuponDto;
import com.uni_eventos.models.cupon.Cupon;

public interface CuponDao {
    Cupon crearCupon(CuponDto cuponDto);

    boolean eliminarCupon(int idCupon);

    Cupon getCupon(int idCupon);

    List<Cupon> listarCupones();
}