package sk.jra.pmaapp.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;
import sk.jra.pmaapp.data.entities.PropertyEntity;
import sk.jra.pmaapp.services.PropertiesService;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureCache
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PropertiesControllerTest {

  @Autowired
  PropertiesService propertiesService;

  @Autowired
  private TestRestTemplate restTemplate;

  private static final String API_URL = "/properties";

  @Test
  @DisplayName("PropertiesControllerTest - getAllProperties")
  public void getAllProperties() {
    List<PropertyEntity> model;
    URI targetUrl;
    ResponseEntity<List<PropertyEntity>> response;

    targetUrl = UriComponentsBuilder
      .fromUriString(API_URL)
      .build().encode().toUri();

    response = restTemplate.exchange(targetUrl, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), new ParameterizedTypeReference<>(){});
    assertEquals(HttpStatus.OK, response.getStatusCode());
    model = response.getBody();
    assertNotNull(model);
  }

}
