package org.goja.tracker.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.goja.tracker.model.Ticket;
import org.goja.tracker.repository.TicketRepository;
import org.goja.tracker.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

	@Inject
	private TicketRepository ticketRepository;

	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	public void save(Ticket ticket) {
		ticketRepository.saveAndFlush(ticket);
	}

}
