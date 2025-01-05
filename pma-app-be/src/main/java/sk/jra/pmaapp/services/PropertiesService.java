package sk.jra.pmaapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.jra.pmaapp.common.exceptions.ResourceNotFoundException;
import sk.jra.pmaapp.data.entities.PropertyEntity;
import sk.jra.pmaapp.data.mappers.PropertiesMapper;
import sk.jra.pmaapp.data.models.PropertyModel;
import sk.jra.pmaapp.repositories.PropertiesRepository;

import java.util.List;
import java.util.Optional;

import static sk.jra.pmaapp.common.utils.Utils.ERROR_PROPERTY_WITH_ID_NOT_FOUND;
import static sk.jra.pmaapp.common.utils.Utils.ERROR_PROPERTY_WITH_ID_NOT_FOUND_DESC;

@Service
public class PropertiesService {

  Logger log = LoggerFactory.getLogger(PropertiesService.class);

  // repositories
  @Autowired(required = false)
  PropertiesRepository propertiesRepository;

  @Autowired
  PropertiesMapper propertiesMapper;

  public List<PropertyModel> getAllProperties(Integer page, Integer limit, final String order) {
    log.debug("getAllProperties - page: {}, limit: {}, order: {}, filter: {}", page, limit, order, null);
    return propertiesMapper.mapPropertyEntityListToPropertyModelList(propertiesRepository.findAllByOrderById());
  }
  
  public PropertyModel getPropertyById(Long id) {
    Optional<PropertyEntity> byId = propertiesRepository.findById(id);

    if (byId.isEmpty()) {
      throw new ResourceNotFoundException(ERROR_PROPERTY_WITH_ID_NOT_FOUND, ERROR_PROPERTY_WITH_ID_NOT_FOUND_DESC, String.valueOf(id));
    }
    return propertiesMapper.mapPropertyEntityToPropertyModel(byId.get());
  }
}
