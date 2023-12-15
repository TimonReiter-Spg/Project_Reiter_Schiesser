package com.example.project_reiter_schiesser.service;

import java.util.List;
import java.util.UUID;

public record LehrerDTO(UUID id, String name, List<FachDTO> faecher) {
}