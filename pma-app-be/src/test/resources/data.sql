CREATE SCHEMA IF NOT EXISTS pma;

INSERT INTO pma.Property_Type(type_name) VALUES('PT_1');
INSERT INTO pma.Property_Type(type_name) VALUES('PT_2');
INSERT INTO pma.Property_Type(type_name) VALUES('PT_3');
INSERT INTO pma.Property_Type(type_name) VALUES('PT_4');


INSERT INTO pma.Property(name, street, street_number, zip, city, region, country, rooms_num, property_type, living_area) VALUES ('P1', 'Ulica1', 6, '01001', 'Zilina', 'Zilina', 'Slovakia', 2, 1, 62.0);
INSERT INTO pma.Property(name, street, street_number, zip, city, region, country, rooms_num, property_type, living_area) VALUES ('P2', 'Ulica2', 42, '01002', 'Zilina', 'Zilina', 'Slovakia', 3, 1, 83.0);
INSERT INTO pma.Property(name, street, street_number, zip, city, region, country, rooms_num, property_type, living_area) VALUES ('P3', 'Ulica3', 59, '01003', 'Zilina', 'Zilina', 'Slovakia', 3, 1, 93.3);
