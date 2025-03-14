package sk.jra.pmaapp.controllers;

import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.jra.pmaapp.common.utils.RequestMappings;
import sk.jra.pmaapp.data.models.PropertyModel;
import sk.jra.pmaapp.services.PropertiesService;

import java.util.List;

@RestController
//@RequestMapping(value = "/properties")
@RequestMapping(RequestMappings.API_PROPERTIES_URL)
public class PropertiesController {

  Logger log = LoggerFactory.getLogger(PropertiesController.class);

  @Autowired
  PropertiesService propertiesService;

  @GetMapping("")
  @ResponseStatus(HttpStatus.OK)
  public List<PropertyModel> getAllProperties() {
    log.info("getAllProperties");
    return propertiesService.getAllProperties(null, null, null);
  }

  @GetMapping("/{propertyId}")
  @ResponseStatus(HttpStatus.OK)
  public PropertyModel getPropertyDetail(
    @PathVariable @NotNull Long propertyId) {

    return propertiesService.getPropertyById(propertyId);
  }

}
