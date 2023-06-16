INSERT INTO personasroger.personas(fecha_nacimiento, create_at, apellido, nombre, telefono, email)VALUES('1997-04-02', NOW(), 'Lopez', 'Roger', '5559301577', 'rogelio.020496@gmail.com');
INSERT INTO personasroger.personas(fecha_nacimiento, create_at, apellido, nombre, telefono, email)VALUES('1996-04-02', NOW(), 'Lopez', 'Rogelio', '5559301577', 'rogelio.020496@hotmail.com');

INSERT INTO personasroger.telefonos(numero, create_at)VALUES('5559301577', NOW());
INSERT INTO personasroger.telefonos(numero, create_at)VALUES('5559301578', NOW());

INSERT INTO personasroger.direcciones(calle, municipio, create_at)VALUES('Tortolas', 'Tultitlán', NOW())
INSERT INTO personasroger.direcciones(calle, municipio, create_at)VALUES('Quintana Roo', 'Coacalco', NOW())