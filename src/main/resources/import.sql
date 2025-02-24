INSERT INTO nit (nit_documento, nit_nombre, nit_cupo, nit_plazo) VALUES('123456789', 'Distribuidora XYZ', 50000, 30);
INSERT INTO nit (nit_documento, nit_nombre, nit_cupo, nit_plazo) VALUES('987654321', 'Farmacia ABC', 30000, 45);
INSERT INTO nit (nit_documento, nit_nombre, nit_cupo, nit_plazo) VALUES('555888777', 'Droguería Salud', 40000, 60);
INSERT INTO nit (nit_documento, nit_nombre, nit_cupo, nit_plazo) VALUES('111222333', 'Medicamentos Rápidos', 25000, 15);
INSERT INTO nit (nit_documento, nit_nombre, nit_cupo, nit_plazo) VALUES('444555666', 'Clinica Santa Fe', 60000, 90);


INSERT INTO laboratorio (lab_cod, lab_nombre) VALUES (1, 'LabGenéricos');
INSERT INTO laboratorio (lab_cod, lab_nombre) VALUES (2, 'BioFarma');
INSERT INTO laboratorio (lab_cod, lab_nombre) VALUES (3, 'MediCorp');
INSERT INTO laboratorio (lab_cod, lab_nombre) VALUES (4, 'Salud Pharma');
INSERT INTO laboratorio (lab_cod, lab_nombre) VALUES (5, 'Farmacéutica Nacional');


INSERT INTO articulo (art_cod, art_nombre, lab_cod, art_saldo, art_costo, art_preciov) VALUES (1, 'Paracetamol 500mg', 1, 100, 500.00, 800.00);
INSERT INTO articulo (art_cod, art_nombre, lab_cod, art_saldo, art_costo, art_preciov) VALUES (2, 'Ibuprofeno 400mg', 2, 150, 700.00, 1100.00);
INSERT INTO articulo (art_cod, art_nombre, lab_cod, art_saldo, art_costo, art_preciov) VALUES (3, 'Amoxicilina 500mg', 3, 80, 1200.00, 1800.00);
INSERT INTO articulo (art_cod, art_nombre, lab_cod, art_saldo, art_costo, art_preciov) VALUES (4, 'Omeprazol 20mg', 4, 200, 400.00, 700.00);
INSERT INTO articulo (art_cod, art_nombre, lab_cod, art_saldo, art_costo, art_preciov) VALUES (5, 'Losartán 50mg', 5, 120, 900.00, 1400.00);


INSERT INTO factura (factu_cod, factu_total, factu_fecha, factu_vence, nit_documento) VALUES (1, 4000.00, '2024-02-18 10:30:00', '2024-03-18', '123456789');
INSERT INTO factura (factu_cod, factu_total, factu_fecha, factu_vence, nit_documento) VALUES (2, 5500.00, '2024-02-17 14:20:00', '2024-03-17', '987654321');
INSERT INTO factura (factu_cod, factu_total, factu_fecha, factu_vence, nit_documento) VALUES (3, 3200.00, '2024-02-16 09:10:00', '2024-03-16', '555888777');
INSERT INTO factura (factu_cod, factu_total, factu_fecha, factu_vence, nit_documento) VALUES (4, 7800.00, '2024-02-15 11:45:00', '2024-03-15', '111222333');
INSERT INTO factura (factu_cod, factu_total, factu_fecha, factu_vence, nit_documento) VALUES (5, 6200.00, '2024-02-14 16:05:00', '2024-03-14', '444555666');



INSERT INTO kardex (kardex_cod, kardex_fecha, kardex_natu, kardex_saldo_antes, kardex_saldo_despues, kardex_und, art_cod) VALUES (1, '2024-02-18 10:30:00', TRUE, 100, 90, 10, 1);
INSERT INTO kardex (kardex_cod, kardex_fecha, kardex_natu, kardex_saldo_antes, kardex_saldo_despues, kardex_und, art_cod) VALUES (2, '2024-02-17 14:20:00', TRUE, 150, 135, 15, 2);
INSERT INTO kardex (kardex_cod, kardex_fecha, kardex_natu, kardex_saldo_antes, kardex_saldo_despues, kardex_und, art_cod) VALUES (3, '2024-02-16 09:10:00', TRUE, 80, 72, 8, 3);
INSERT INTO kardex (kardex_cod, kardex_fecha, kardex_natu, kardex_saldo_antes, kardex_saldo_despues, kardex_und, art_cod) VALUES (4, '2024-02-15 11:45:00', FALSE, 200, 220, 20, 4);
INSERT INTO kardex (kardex_cod, kardex_fecha, kardex_natu, kardex_saldo_antes, kardex_saldo_despues, kardex_und, art_cod) VALUES (5, '2024-02-14 16:05:00', TRUE, 120, 108, 12, 5);


INSERT INTO factura_kardex (factu_kardex_cod, factu_cod, kardex_cod) VALUES (1, 1, 1);
INSERT INTO factura_kardex (factu_kardex_cod, factu_cod, kardex_cod) VALUES (2, 2, 2);
INSERT INTO factura_kardex (factu_kardex_cod, factu_cod, kardex_cod) VALUES (3, 3, 3);
INSERT INTO factura_kardex (factu_kardex_cod, factu_cod, kardex_cod) VALUES (4, 4, 4);
INSERT INTO factura_kardex (factu_kardex_cod, factu_cod, kardex_cod) VALUES (5, 5, 5);



