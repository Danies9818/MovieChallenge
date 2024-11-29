package com.appiCorp.caller;

import com.appiCorp.dto.MovieResponse;
import com.appiCorp.service.MovieService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiCaller {

    private final RestTemplate restTemplate;
    private final MovieService movieService;

    public ApiCaller(RestTemplate restTemplate, MovieService movieService) {
        this.restTemplate = restTemplate;
        this.movieService = movieService;
    }

    public void callApi() {
        int currentPage = 1;
        int totalPages = 1;

        do {
            String apiUrl = String.format("https://eron-movies.wiremockapi.cloud/api/movies/search?page=%d", currentPage);

            try {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Accept", "application/json");
                HttpEntity<String> entity = new HttpEntity<>(headers);

                // Realizar la solicitud
                ResponseEntity<MovieResponse> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, MovieResponse.class);

                if (response != null) {

                    if (response.getBody().getData() != null) {
                        movieService.saveMovies(response.getBody().getData());
                        System.out.println("Page " + currentPage + " processed successfully.");
                    }

                    totalPages = response.getBody().getTotalPages();
                }

                currentPage++;
            } catch (Exception e) {
                System.err.println("Error while calling the API for page " + currentPage + ": " + e.getMessage());
                break;
            }
        } while (currentPage <= totalPages);

        System.out.println("API calls completed for all pages.");
    }
}

