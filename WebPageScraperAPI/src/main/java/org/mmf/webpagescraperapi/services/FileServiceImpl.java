package org.mmf.webpagescraperapi.services;

import org.mmf.webpagescraperapi.domain.EscapeRoomScenario;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void writeToFile(List<EscapeRoomScenario> scenarios) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("t4f_scenarios.txt"), StandardCharsets.UTF_8))) {
            writer.write("Title,City,Difficulty,Scare Level,Link");
            writer.newLine();

            for (EscapeRoomScenario scenario : scenarios) {
                writer.write(scenario.toString());
                writer.newLine();
            }
        }
    }
}
