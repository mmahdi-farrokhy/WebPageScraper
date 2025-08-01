package org.mmf.webpagescraperapi.services;

import org.mmf.webpagescraperapi.domain.EscapeRoomScenario;
import org.mmf.webpagescraperapi.repositories.EscapeRoomScenarioRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Time4FunEscapeRoomServiceImpl implements EscapeRoomService {
    private final FileService fileService;
    private final WebScraper webScraper;
    private final EscapeRoomScenarioRepository escapeRoomScenarioRepository;

    public Time4FunEscapeRoomServiceImpl(FileService fileService, WebScraper webScraper, EscapeRoomScenarioRepository escapeRoomScenarioRepository) {
        this.fileService = fileService;
        this.webScraper = webScraper;
        this.escapeRoomScenarioRepository = escapeRoomScenarioRepository;
    }

    @Override
    public void fetchAll() throws InterruptedException, IOException {
        List<EscapeRoomScenario> scenarios = webScraper.getEscapeRoomScenarios();
        escapeRoomScenarioRepository.saveAll(scenarios);
    }
}
