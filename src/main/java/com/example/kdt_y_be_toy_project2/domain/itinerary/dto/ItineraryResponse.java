package com.example.kdt_y_be_toy_project2.domain.itinerary.dto;

import com.example.kdt_y_be_toy_project2.domain.itinerary.entity.Accommodation;
import com.example.kdt_y_be_toy_project2.domain.itinerary.entity.Itinerary;
import com.example.kdt_y_be_toy_project2.domain.itinerary.entity.Residence;
import com.example.kdt_y_be_toy_project2.domain.itinerary.entity.Transport;
import com.example.kdt_y_be_toy_project2.global.entity.TimeSchedule;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record ItineraryResponse(
        @Min(1L)
        @Schema(name = "여정 아이디", example = "7")
        Long id,

        @NotNull
        @Schema(name = "여정 이름", example = "옥크나이트와 떠나는 코딩숙박")
        String itineraryName,

        Long trip_id,

        @Schema(name = "숙소", example = "호텔")
        List<Accommodation> accommodation,

        @Schema(name = "체류지", example = "속초")
        List<Residence> residence,

        @Schema(name = "교통수단", example = "버스")
        List<Transport> transport,
        @NotNull TimeSchedule timeSchedule,
        @NotNull LocalDateTime createdAt,
        @NotNull LocalDateTime updatedAt
) {
    public static ItineraryResponse fromEntity(Itinerary itinerary) {
        return new ItineraryResponse(
                itinerary.getItineraryId(),
                itinerary.getItineraryName(),
                itinerary.getTrip().getTripId(),
                itinerary.getAccommodation(),
                itinerary.getResidence(),
                itinerary.getTransport(),
                itinerary.getTimeSchedule(),
                itinerary.getCreatedAt(),
                itinerary.getUpdatedAt()
        );
    }
}
