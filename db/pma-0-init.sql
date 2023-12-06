CREATE SCHEMA pma

CREATE TABLE pma.Property_Type(
	property_type_id smallserial UNIQUE NOT NULL,
	type_name varchar(40) NOT NULL
);

CREATE TABLE pma.Payment_Type(
	payment_type_id smallserial UNIQUE NOT NULL,
	type_name varchar(40) NOT NULL
);

CREATE TABLE pma.C_Bank(
	bank_id smallserial UNIQUE NOT NULL,
	b_code varchar(10),
	b_name varchar(100),
	b_swift varchar(15)
);

CREATE TABLE pma.Person(
	person_id smallserial PRIMARY KEY,
	first_name varchar(20),
	surname varchar(20),
	phoneNumber varchar(20),
	email varchar(50)
);

CREATE TABLE pma.Bank_Account(
	bank_account_id smallserial PRIMARY KEY,
	bank INT,
	iban varchar(30) NOT NULL,
	name varchar(50),
	CONSTRAINT fk_ba_bank FOREIGN KEY(bank) REFERENCES pma.C_Bank(bank_id)
);

CREATE TABLE pma.Property(
	property_id smallserial PRIMARY KEY,
	property_type INT,
	name varchar(16) NOT NULL,
	description varchar(100),
	street varchar(50) NOT NULL,
	street_number integer NOT NULL,
	zip integer NOT NULL,
	city varchar(50),
	region varchar(50),
	country varchar(50),
	rooms_num smallint,
	living_area decimal(6,2),
	CONSTRAINT fk_property_type FOREIGN KEY(property_type) REFERENCES pma.Property_Type(property_type_id)
);

CREATE TABLE pma.Contract(
	contract_id smallserial PRIMARY KEY,
	date_from DATE NOT NULL,
	date_to DATE, 
	rent_price decimal(6,2),
	rent_services decimal(6,2),
	property INT,
	CONSTRAINT fk_contract_property FOREIGN KEY(property) REFERENCES pma.Property(property_id)
);

CREATE TABLE pma.Payment(
	payment_id serial PRIMARY KEY,
	p_date DATE,
	iban varchar(30),
	amount decimal(6,2),
	currency varchar(5),
	detail varchar(100),
	payment_type smallint,
	bank_transaction_identifier bigint,
	contract INT,
	CONSTRAINT fk_payment_type FOREIGN KEY(payment_type) REFERENCES pma.Payment_Type(payment_type_id),
	CONSTRAINT fk_payment_contract FOREIGN KEY(contract) REFERENCES pma.Contract(contract_id)
);

CREATE TABLE pma.Property_Payment(
	property_payment_id serial PRIMARY KEY,
	due_date DATE NOT NULL,
	amount decimal(6,2) NOT NULL,
	variable_symbol integer,
	detail varchar(30),
	iban varchar(30),
	payment_type smallint,
	property_id INT,
	CONSTRAINT fk_property_payment_payment_type FOREIGN KEY(payment_type) REFERENCES pma.Payment_Type(payment_type_id),
	CONSTRAINT fk_property_payment_property FOREIGN KEY(property_id) REFERENCES pma.Property(property_id)
);

CREATE TABLE pma.Contract_Person(
	contract_id INT,
	person_id INT,
	CONSTRAINT fk_cp_contract_id FOREIGN KEY(contract_id) REFERENCES pma.Contract(contract_id),
	CONSTRAINT fk_cp_person_id FOREIGN KEY(person_id) REFERENCES pma.Person(person_id)
);

CREATE TABLE pma.Contract_Bank_Account(
	contract_id INT,
	bank_account_id INT,
	valid_from DATE NOT NULL,
	valid_to DATE,
	PRIMARY KEY (contract_id, bank_account_id)
);

CREATE TABLE pma.Measure_Type(
	mt_id smallserial PRIMARY KEY,
	mt_name varchar(30),
	mt_code varchar(10)	
);

CREATE TABLE pma.Measure(
	measure_id smallserial PRIMARY KEY,
	measure_type INT,
	serial_number varchar(30),
	initial_value decimal(12,3),
	valid_from DATE,
	valid_to DATE,
	property INT,
	CONSTRAINT fk_m_mt_id FOREIGN KEY(measure_type) REFERENCES pma.Measure_Type(mt_id),
	CONSTRAINT fk_m_property FOREIGN KEY(property) REFERENCES pma.Property(property_id)
);

CREATE TABLE pma.Deduction_Consumption(
	dc_id smallint PRIMARY KEY,
	dc_date DATE,
	dc_value decimal(12,3),
	property INT,
	measure INT, 
	CONSTRAINT fk_dc_property FOREIGN KEY(property) REFERENCES pma.Property(property_id),
	CONSTRAINT fk_dc_measure FOREIGN KEY(measure) REFERENCES pma.Measure(measure_id)
);