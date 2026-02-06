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
@RequiredArgsConstructor
public class Player {
    @Id
    private String id;

    @NonNull
    @NotBlank
    private String name;

    @NonNull
    @NotBlank
    private String nation;

    @NonNull
    @NotBlank
    private String team;

    @NonNull
    @NotBlank
    private String role;

    @NonNull
    @NotNull
    @Min(value = 18)
    private Integer age;

    @NonNull
    @NotNull
    private Boolean active;

    private Integer jerseyNumber;

//    @Min(0)
    private Integer centuries;

  //  @Min(0)
    private Integer fifties;

  //  @Min(0)
    private Integer wickets;

    private String bestScore;
}
