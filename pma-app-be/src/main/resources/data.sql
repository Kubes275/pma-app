INSERT INTO PMA.PERSON (person_id, first_name, surname, phonenumber, email)
VALUES (1, 'John', 'Doe', '123456789', 'john.doe@example.com');

-- property types
INSERT INTO PMA.PROPERTY_TYPE (type_id, type_name)
VALUES (1, 'Byt'),
       (2, 'Dom');

-- properties
INSERT INTO PMA.PROPERTIES (property_id, address, city, state, zip_code, price, description, property_type, num_bedrooms, num_bathrooms, square_feet, lot_size, year_built, listing_date, status, agent_id)
VALUES (1, 'Ruzova', 'Springfield', 'IL', '62701', 250000.00, 'Charming 3-bedroom home in a great neighborhood.', '