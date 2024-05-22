package com.uni_eventos.dao.cupon;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.uni_eventos.dto.CuponDto;
import com.uni_eventos.models.cupon.Cupon;
import com.uni_eventos.models.cupon.CuponManager;

public class CuponDaoImpl implements CuponDao {

    public CuponDaoImpl() {
        CuponManager.cargarDatos();
    }

    @Override
    public Cupon crearCupon(CuponDto cuponDto) {
        Cupon cupon = Cupon.builder().id(0).descuento(cuponDto.descuento()).disponible(cuponDto.disponible()).build();
        List<Cupon> cupones = CuponManager.getCupones();
        cupones.add(cupon);
        CuponManager.setCupones(cupones);
        return cupon;
    }

    @Override
    public boolean eliminarCupon(int idCupon) {
        boolean eliminado = false;
        Optional<Cupon> cupon = filtrarId(idCupon);
        if (cupon.isPresent()) {
            Predicate<Cupon> condicion = c -> c.getId() == idCupon;
            List<Cupon> cupones = CuponManager.getCupones();
            eliminado = cupones.removeIf(condicion);
            CuponManager.setCupones(cupones);
        }
        return eliminado;
    }

    @Override
    public Cupon getCupon(int idCupon) {

        return filtrarId(idCupon).get();
    }

    @Override
    public List<Cupon> listarCupones() {
        return CuponManager.getCupones();
    }

    private Optional<Cupon> filtrarId(int idCupon) {
        Predicate<Cupon> condicion = c -> c.getId() == idCupon;
        return CuponManager.getCupones().stream().filter(condicion).findFirst();
    }
}
