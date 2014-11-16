package org.goja.tracker.service;

import java.util.List;

import org.goja.tracker.dto.SummaryDto;
import org.goja.tracker.model.Ticket;

public interface TicketService {

	List<Ticket> findAll();

	void save(Ticket ticket);

	List<SummaryDto> displaySummary();

	void deleteAll();

	void delete(Long id);

	Ticket findOne(Long id);
}
