package com.appiCorp.controller;

import com.appiCorp.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class MovieController {

    @Autowired
    private  MovieService movieService;

    @Operation(summary = "Get directors with a minimum number of movies",
            description = "Returns a list of directors who have directed at least the specified number of movies.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of directors retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid request parameters",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<?> getDirectors(@RequestParam("threshold") int threshold) {

        List<String> directors = movieService.findDirectorsWithMovies(threshold).stream()
                .map(d ->  (String) d[0])
                .toList();

        return new ResponseEntity<>(directors, HttpStatus.OK);
    }
}
