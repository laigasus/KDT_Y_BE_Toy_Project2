package com.example.kdt_y_be_toy_project2.domain.itinerary.dto.sub;

import com.example.kdt_y_be_toy_project2.domain.itinerary.entity.Residence;
import com.example.kdt_y_be_toy_project2.global.util.TimeUtils;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ResidenceDTO(
        @Schema(example = "속초")
        String residenceName,
        @Schema(example = "2023-11-11-00:00")
        String stayTime,
        @Schema(example = "2023-11-12-00:00")
        String leaveTime

) {
    private static ResidenceDTO fromEntity(Residence residence) {
        return new ResidenceDTO(
                residence.getResidenceName(),
                TimeUtils.formatDateTime(residence.getResidenceTimeSchedule().getStartTime()),
                TimeUtils.formatDateTime(residence.getResidenceTimeSchedule().getEndTime())
        );
    }

    public static List<ResidenceDTO> fromEntities(List<Residence> residences) {
        return residences.stream().map(ResidenceDTO::fromEntity).toList();
    }
}