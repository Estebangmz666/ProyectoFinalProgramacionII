package com.uni_eventos.dao.evento;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.uni_eventos.dto.EventoDto;
import com.uni_eventos.models.evento.Evento;
import com.uni_eventos.models.evento.EventoManager;

public class EventoDaoImpl implements EventoDao {

    public EventoDaoImpl() {
        EventoManager.cargarDatos();
    }

    @Override
    public Evento agregarEvento(EventoDto eventoDto) {
        Evento eventoNuevo = null;
        // Obtener los eventos creados
        List<Evento> eventos = EventoManager.getEventos();
        Predicate<Evento> iguales = e -> e.getFecha().equals(eventoDto.fecha())
                && e.getCiudad().equals(eventoDto.ciudad())
                && e.getNombre().equals(eventoDto.nombre()); // si evento con el mismo: nombre, fecha y ciudad ->
                                                             // duplicado
        Optional<Evento> evento = eventos.stream().filter(iguales).findFirst();

        if (evento.isEmpty()) {// Si no hay coincidencia
            eventoNuevo = Evento.builder().nombre(eventoDto.nombre())
                    .ciudad(eventoDto.ciudad())
                    .tipoEvento(eventoDto.tipoEvento())
                    .fecha(eventoDto.fecha())
                    .costoEntrada(eventoDto.costoEntrada())
                    .entradasDisponibles(eventoDto.entradasDisponibles())
                    .imagenPath(eventoDto.imagenPath())
                    .build(); // cree nuevo evento
            eventos.add(eventoNuevo);// añadalo a la lista
            EventoManager.setEventos(eventos); // guardelo para persistencia
        }

        return eventoNuevo;// si es nulo se encontro coincidencia en la db
    }

    @Override
    public List<Evento> getAll() {
        return EventoManager.getEventos();
    }

    @Override
    public Evento getEvento(int idEvento) {
        Evento evento = null;
        Optional<Evento> opcional = filtrarId(idEvento);
        if (opcional.isPresent()) {
            evento = opcional.get();
        }
        return evento;
    }

    @Override
    public boolean removerEvento(int idEvento) {
        boolean eliminado = false;
        Optional<Evento> opcional = filtrarId(idEvento); // filtrar para obtener
        List<Evento> lista = EventoManager.getEventos();
        if (opcional.isPresent()) { // si se encutra
            Predicate<Evento> condicion = e -> e.getId() == opcional.get().getId(); // el objeto con el mismo id
            eliminado = lista.removeIf(condicion); // aplicar condicion y remover dato
            EventoManager.setEventos(lista); // guardar la lista nueva sin el dato
        }
        return eliminado;
    }

    private Optional<Evento> filtrarId(int idEvento) {
        Predicate<Evento> condicion = e -> e.getId() == idEvento;
        return EventoManager.getEventos().stream().filter(condicion).findFirst();
    }

}
