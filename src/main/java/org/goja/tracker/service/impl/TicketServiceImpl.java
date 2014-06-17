package org.goja.tracker.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.goja.tracker.dto.SummaryDto;
import org.goja.tracker.model.Ticket;
import org.goja.tracker.repository.TicketRepository;
import org.goja.tracker.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

	@Inject
	private TicketRepository ticketRepository;

	@PersistenceContext
	private EntityManager em;

	private final String query = "select new org.goja.tracker.dto.SummaryDto "
			+ "(t.priority, t.status, t.summary, t.reporter.name, t.assignee.name) from Ticket t";

	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	public void save(Ticket ticket) {
		ticketRepository.saveAndFlush(ticket);
	}

	@Override
	public List<SummaryDto> displaySummary() {
		return em.createQuery(query).getResultList();
	}

}
