package org.mmf.webpagescraperapi.controller;

import org.mmf.webpagescraperapi.services.EscapeRoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/escapeRoom")
public class EscapeRoomController {
    private final EscapeRoomService escapeRoomService;

    public EscapeRoomController(EscapeRoomService escapeRoomService) {
        this.escapeRoomService = escapeRoomService;
    }

    @PostMapping
    public void fetchScenariosFromWebSite() throws IOException, InterruptedException {
        escapeRoomService.fetchAll();
    }
}
