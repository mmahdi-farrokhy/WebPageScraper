package org.mmf.webpagescraperapi.services;

import org.mmf.webpagescraperapi.domain.EscapeRoomScenario;

import java.util.List;

public interface WebScraper {
    List<EscapeRoomScenario> getEscapeRoomScenarios() throws InterruptedException;
}
