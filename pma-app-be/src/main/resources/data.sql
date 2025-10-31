INSERT INTO pma.PERSON (person_id, first_name, surname, phonenumber, email)
VALUES (1, 'John', 'Doe', '123456789', 'john.doe@example.com');

-- property types
INSERT INTO pma.PROPERTY_TYPE (property_type_id, type_name)
VALUES (1, 'Byt'),
       (2, 'Dom');

-- properties
INSERT INTO pma.properties (property_id, property_type, name, description, street, street_number, zip, city, region, country, rooms_num, living_area) VALUES (1, 1, 'RZV', 'Byt Ruzova 42', 'Ruzova', 42, '01001', 'Zilina', 'Žilina', 'Slovensko', 3, 83);
INSERT INTO pma.properties (property_id, property_type, name, description, street, street_number, zip, city, region, country, rooms_num, living_area) VALUES (2, 1, 'BYT1', 'Byt 1', 'Hlavna', 15, '90001', 'Modra', 'Bratislava', 'Slovensko', 5, 150);