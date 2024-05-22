package com.uni_eventos.dao.evento;

import java.util.List;

import com.uni_eventos.dto.EventoDto;
import com.uni_eventos.models.evento.Evento;

public interface EventoDao {
    Evento agregarEvento(EventoDto eventoDto);

    boolean removerEvento(int idEvento);

    Evento getEvento(int idEvento);

    List<Evento> getAll();
}