package org.mmf.webpagescraperapi.services;

import org.mmf.webpagescraperapi.domain.EscapeRoomScenario;

import java.io.IOException;
import java.util.List;

public interface FileService {
    void writeToFile(List<EscapeRoomScenario> scenarios) throws IOException;
}
