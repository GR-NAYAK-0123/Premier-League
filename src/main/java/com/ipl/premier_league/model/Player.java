package com.ipl.premier_league.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Nation is required")
    private String nation;

    @NotBlank(message = "Team is required")
    private String team;

    @NotBlank(message = "Role is required")
    private String role;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotNull(message = "Active status is required")
    private Boolean active;

    private Integer jerseyNumber;

    private Integer centuries;

    private Integer fifties;

    private Integer wickets;

    private String bestScore;
}
