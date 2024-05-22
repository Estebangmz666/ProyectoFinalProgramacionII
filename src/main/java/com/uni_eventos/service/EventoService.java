package com.uni_eventos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.uni_eventos.dao.evento.EventoDao;
import com.uni_eventos.dao.evento.EventoDaoImpl;
import com.uni_eventos.dto.EventoDto;
import com.uni_eventos.models.evento.Ciudad;
import com.uni_eventos.models.evento.Evento;
import com.uni_eventos.models.evento.EventoManager;
import com.uni_eventos.models.evento.TipoEvento;

public class EventoService {
    EventoDao eventoDao = new EventoDaoImpl();

    public EventoDto agregarEvento(
            String nombre, Ciudad ciudad, TipoEvento tipoEvento, LocalDateTime fecha, int costoEntrada,
            int entradasDisponibles, String imagenPath) {
        Evento evento = eventoDao.agregarEvento(
                convertirADto(0, nombre, ciudad, tipoEvento, fecha, costoEntrada, entradasDisponibles, imagenPath));

        return convertirADto(evento);
    }

    public boolean removerEvento(int idEvento) {
        return eventoDao.removerEvento(idEvento);
    }

    public List<EventoDto> getAll() {
        return convertirADto(eventoDao.getAll());
    }

    public List<EventoDto> filtrarTipo(TipoEvento tipo) {
        Predicate<Evento> byTipo = evento -> evento.getTipoEvento().equals(tipo);
        List<EventoDto> eventos = filtrar(byTipo);
        return eventos;
    }

    public List<EventoDto> filtrarCiudad(Ciudad ciudad) {
        Predicate<Evento> byCiudad = evento -> evento.getCiudad().equals(ciudad);
        List<EventoDto> eventos = filtrar(byCiudad);
        return eventos;
    }

    public List<EventoDto> filtrarNombre(String nombre) {
        Predicate<Evento> byNombre = evento -> evento.getNombre().equalsIgnoreCase(nombre);
        List<EventoDto> eventos = filtrar(byNombre);
        return eventos;
    }

    private List<EventoDto> filtrar(Predicate<Evento> predicate) {
        List<Evento> eventos = EventoManager.getEventos().stream().filter(null).collect(Collectors.toList());
        List<EventoDto> eventoDtos = convertirADto(eventos);
        return eventoDtos;
    }

    public List<EventoDto> convertirADto(List<Evento> eventos) {
        return eventos.stream()
                .map(evento -> new EventoDto(evento.getId(),
                        evento.getNombre(),
                        evento.getCiudad(),
                        evento.getTipoEvento(),
                        evento.getFecha(),
                        evento.getCostoEntrada(),
                        evento.getEntradasDisponibles(),
                        evento.getImagenPath()))
                .collect(Collectors.toList());
    }

    public EventoDto convertirADto(Evento evento) {
        EventoDto eventoDto = new EventoDto(evento.getId(),
                evento.getNombre(),
                evento.getCiudad(),
                evento.getTipoEvento(),
                evento.getFecha(),
                evento.getCostoEntrada(),
                evento.getEntradasDisponibles(),
                evento.getImagenPath());
        return eventoDto;
    }

    public EventoDto convertirADto(int id, String nombre, Ciudad ciudad, TipoEvento tipoEvento, LocalDateTime fecha,
            int costoEntrada,
            int entradasDisponibles, String imagenPath) {
        EventoDto eventoDto = new EventoDto(
                id,
                nombre,
                ciudad,
                tipoEvento,
                fecha,
                costoEntrada,
                entradasDisponibles,
                imagenPath);
        return eventoDto;
    }

    public Evento convertirAEvento(EventoDto evento) {
        Evento evento2 = Evento.builder()
                .id(evento.id())
                .nombre(evento.nombre())
                .ciudad(evento.ciudad())
                .tipoEvento(evento.tipoEvento())
                .fecha(evento.fecha())
                .costoEntrada(evento.costoEntrada())
                .entradasDisponibles(evento.entradasDisponibles())
                .imagenPath(evento.imagenPath())
                .build();
        return evento2;
    }

}
