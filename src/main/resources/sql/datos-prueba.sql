-- Insertar seguros
INSERT INTO seguros (id_seguro, nif, nombre, ape1, ape2, edad, num_hijos, fecha_creacion, sexo, casado, embarazada)
VALUES
    (1, '12345678A', 'Juan', 'Pérez', 'García', 35, 2, '2024-11-01 10:00:00', 'Hombre', TRUE, FALSE),(2, '87654321B', 'María', 'López', NULL, 28, 1, '2024-10-20 14:30:00', 'Mujer', TRUE, TRUE),(3, '45612378C', 'Carlos', 'Martínez', 'Hernández', 40, 0, '2024-09-15 09:45:00', 'Hombre', FALSE, FALSE),(4, '78945612D', 'Laura', 'Sánchez', 'Díaz', 30, 3, '2024-10-05 08:15:00', 'Mujer', TRUE, FALSE),(5, '12378945E', 'Ana', 'Fernández', NULL, 17, 0, '2024-11-10 12:00:00', 'Mujer', FALSE, FALSE),(6, '95175342F', 'Pedro', 'Gómez', 'Ruiz', 29, 0, '2024-08-21 16:20:00', 'Hombre', FALSE, FALSE),(7, '85214796G', 'Marta', 'Jiménez', 'Ortiz', 22, 0, '2024-07-15 10:10:00', 'Mujer', FALSE, TRUE);

-- Insertar asistencias médicas
INSERT INTO asistencias_medicas (id_asistencia_medica, id_seguro, breve_descripcion, lugar, explicacion, tipo_asistencia, fecha, hora, importe)
VALUES
    (1, 1, 'Consulta médica general', 'Madrid', 'Consulta por síntomas leves', 'Consulta', '2024-11-02', '09:30:00', 50.00),
    (2, 1, 'Urgencia médica', 'Barcelona', 'Dolor abdominal intenso', 'Urgencia', '2024-11-03', '12:15:00', 150.00),
    (3, 2, 'Revisión ginecológica', 'Sevilla', 'Control durante embarazo', 'Consulta', '2024-11-04', '10:00:00', 70.00);