package org.goja.tracker.service.impl;

import javax.inject.Inject;

import org.goja.tracker.model.Note;
import org.goja.tracker.repository.NoteRepository;
import org.goja.tracker.service.NoteService;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

	@Inject
	private NoteRepository noteRepository;

	@Override
	public void save(Note note) {
		noteRepository.saveAndFlush(note);
	}

}
