INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('malvarez@uma.es', 'Martina', 722108292, 'Calle Formentera, 2, 5ÃÂ°A', 'Fuengirola', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('aproinla@ong.es', 'Aproinla', 722108292, 'Calle Formentera, 2', 'Fuengirola', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('caritas@ong.es', 'Caritas', 693581986, 'Calle Formentera, 2', 'Benalmadena', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('honduras@ong.es', 'Honduras', 785, 'higbjk', 'Fuengirola', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('mjruiz@uma.es', 'Miguel José', 98231465, 'Calle Bruselas,11', 'Benalmadena', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('ajgarcia@uma.es', 'Antonio', 985232121, 'Calle Feria, 2', 'Fuengirola', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('rmlopez@uma.es', 'Rosa María', 64515145, 'Calle Lino, 3', 'Malaga', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('jmlupionc@uma.es', 'Juan Manuel', 722108292, 'Calle Formentera, 2, 5Â°A', 'Fuengirola', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('alvaroramos@uma.es', 'Álvaro', 693581990, 'Calle Bruselas,11', 'Benalmadena', true);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('fcarmona@uma.es', 'Francisco', 693581986, 'Calle Formentera, 2, 5Â°A', 'Benalmadena', false);
INSERT INTO ALGUSTO.USUARIO (CORREO, NOMBRE, TELEFONO, DIRECCION, LOCALIDAD, TURNOTARDE) 
	VALUES ('prueba@ong.es', 'Rellenar', NULL, NULL, NULL, NULL);



INSERT INTO ALGUSTO.PROFESOR (CORREO, FECHA_NACIMIENTO, APELLIDOS, GESTOR) 
	VALUES ('malvarez@uma.es', NULL, 'Álvarez Pérez', true);
INSERT INTO ALGUSTO.PROFESOR (CORREO, FECHA_NACIMIENTO, APELLIDOS, GESTOR) 
	VALUES ('mjruiz@uma.es', NULL, 'Ruiz Gómez', false);
INSERT INTO ALGUSTO.PROFESOR (CORREO, FECHA_NACIMIENTO, APELLIDOS, GESTOR) 
	VALUES ('ajgarcia@uma.es', NULL, 'García Ruiz', false);
INSERT INTO ALGUSTO.PROFESOR (CORREO, FECHA_NACIMIENTO, APELLIDOS, GESTOR) 
	VALUES ('rmlopez@uma.es', NULL, 'López Gigosos', false);


INSERT INTO ALGUSTO.PAS (CORREO, FECHA_NACIMIENTO, APELLIDOS) 
	VALUES ('jmlupionc@uma.es', NULL, 'Lupión Cobos');



INSERT INTO ALGUSTO.ESTUDIANTE (CORREO, APELLIDOS, FECHA_NACIMIENTO) 
	VALUES ('alvaroramos@uma.es', 'Ramos Luna', NULL);
INSERT INTO ALGUSTO.ESTUDIANTE (CORREO, APELLIDOS, FECHA_NACIMIENTO) 
	VALUES ('fcarmona@uma.es', 'Carmona Moreno', NULL);


INSERT INTO ALGUSTO.ONG (CORREO, CONTRASENA, WEB, CLAVE_REGISTRO, ACTIVA) 
	VALUES ('aproinla@ong.es', 'caridad', 'aproinla.com', 'apr0', true);
INSERT INTO ALGUSTO.ONG (CORREO, CONTRASENA, WEB, CLAVE_REGISTRO, ACTIVA) 
	VALUES ('caritas@ong.es', 'caridad', 'caritas.es', 'car1', true);
INSERT INTO ALGUSTO.ONG (CORREO, CONTRASENA, WEB, CLAVE_REGISTRO, ACTIVA) 
	VALUES ('honduras@ong.es', 'caridad', 'honduras.com', 'hon2', true);
INSERT INTO ALGUSTO.ONG (CORREO, CONTRASENA, WEB, CLAVE_REGISTRO, ACTIVA) 
	VALUES ('prueba@ong.es', 'rellenar', NULL, 'pru3', false);

INSERT INTO ALGUSTO.ETIQUETA (ETIQUETA, TIPO) 
	VALUES ('Pobreza', 1);
INSERT INTO ALGUSTO.ETIQUETA (ETIQUETA, TIPO) 
	VALUES ('Sanidad', 2);
INSERT INTO ALGUSTO.ETIQUETA (ETIQUETA, TIPO) 
	VALUES ('Educacion', 2);
INSERT INTO ALGUSTO.ETIQUETA (ETIQUETA, TIPO) 
	VALUES ('Sintecho', 1);
INSERT INTO ALGUSTO.ETIQUETA (ETIQUETA, TIPO) 
	VALUES ('Servicios Sociales', 2);
INSERT INTO ALGUSTO.ETIQUETA (ETIQUETA, TIPO) 
	VALUES ('Medio Ambiente', 1);


INSERT INTO ALGUSTO.ETIQUETAS_USUARIO (CORREO, ETIQUETA) 
	VALUES ('alvaroramos@uma.es', 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_USUARIO (CORREO, ETIQUETA) 
	VALUES ('alvaroramos@uma.es', 'Sanidad');
INSERT INTO ALGUSTO.ETIQUETAS_USUARIO (CORREO, ETIQUETA) 
	VALUES ('alvaroramos@uma.es', 'Sintecho');
INSERT INTO ALGUSTO.ETIQUETAS_USUARIO (CORREO, ETIQUETA) 
	VALUES ('mjruiz@uma.es', 'Medio Ambiente');
INSERT INTO ALGUSTO.ETIQUETAS_USUARIO (CORREO, ETIQUETA) 
	VALUES ('mjruiz@uma.es', 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_USUARIO (CORREO, ETIQUETA) 
	VALUES ('mjruiz@uma.es', 'Sanidad');
INSERT INTO ALGUSTO.ETIQUETAS_USUARIO (CORREO, ETIQUETA) 
	VALUES ('mjruiz@uma.es', 'Servicios Sociales');

INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (1, 'Aplicaciones de Técnicas Moleculares en Patología', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (2, 'Anatomía Topográfica y Aplicativa', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (3, 'Bases Neurofisiológicas de la Conducta Humana', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (4, 'Biomecánica Aplicada en Medicina y Práctica Deportiva', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (5, 'Farmacología Social', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (6, 'Salud Ambiental y Ecología', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (7, 'Arteriosclerosis y Factores de Riesgo Vascular', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (8, 'Avances en Neurofisiología del Sistema Nervioso Autónomo', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (9, 'Habilidades Básicas en Cirugía Laparoscópica', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (10, 'Medicina Transfusional Perioperatoria', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (11, 'Avances en Ciencias Forenses', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (12, 'Los Medicamentos en los Niños', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (13, 'Patología Quirúrgica Oral y Maxilofacial', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (14, 'Urgencias en Patología del Aparato Locomotor en el Niño', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (15, 'Bases Microbiológicas para Tratamiento Antimicrobiano y Vacunología', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (16, 'Farmacología de las Drogas de Abuso: Toxicomanías', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (17, 'Rehabilitación y Medicina Física', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (18, 'Farmacoterapéutica en Entornos Desfavorecidos', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (19, 'Técnicas de Evaluación de la Composición Corporal', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (20, 'Medicina del Deporte', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (21, 'Fundamentos de la Investigación en Medicina', 6);
INSERT INTO ALGUSTO.ASIGNATURA (COD_ASIGNATURA, NOMBRE_ASIGNATURA, N_CREDITOS) 
	VALUES (22, 'Gestión Sanitaria', 6);


INSERT INTO ALGUSTO.IMPARTE (CORREO_PROFESOR, COD_ASIGNATURA) 
	VALUES ('ajgarcia@uma.es', 5);
INSERT INTO ALGUSTO.IMPARTE (CORREO_PROFESOR, COD_ASIGNATURA) 
	VALUES ('ajgarcia@uma.es', 22);
INSERT INTO ALGUSTO.IMPARTE (CORREO_PROFESOR, COD_ASIGNATURA) 
	VALUES ('malvarez@uma.es', 1);
INSERT INTO ALGUSTO.IMPARTE (CORREO_PROFESOR, COD_ASIGNATURA) 
	VALUES ('mjruiz@uma.es', 4);
INSERT INTO ALGUSTO.IMPARTE (CORREO_PROFESOR, COD_ASIGNATURA) 
	VALUES ('rmlopez@uma.es', 6);



INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (0, NULL, NULL, 'Voluntariado', true, 'aproinla@ong.es', 'Capturar pokemon', 'Catch''em all', '2020-01-22', '2020-01-23', 3, 'Galar', false);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (1, NULL, NULL, 'Voluntariado', true, 'aproinla@ong.es', 'Ganar la liga', 'te vas a enterar Lionel', '2020-01-22', '2020-01-31', 1, 'Benalmadena', true);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (2, 'mjruiz@uma.es', NULL, 'Investigación', true, 'aproinla@ong.es', 'aaa', 'Ayuda a los sintecho', '2020-01-27', '2020-02-21', 1, 'n', false);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (3, 'mjruiz@uma.es', 4, 'Aprendizaje-Servicio', true, 'caritas@ong.es', 'Seguir siendo el campeÃ³n', 'jamÃ¡s me quitareis mi tiulo', '2020-01-28', '2020-01-31', 1, 'Galar', true);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (4, 'ajgarcia@uma.es', 5, 'Aprendizaje-Servicio', true, 'caritas@ong.es', 'aprobar requisitos', 'Las princesas pato estan aprobadas', '2020-01-28', '2020-01-31', 5, 'UMA', true);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (5, 'malvarez@uma.es', NULL, 'Investigación', true, 'caritas@ong.es', 'Visita hospital', 'Visita a los ninyos del hospital', '2020-01-21', '2020-01-23', 4, 'Carlos Haya', true);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (6, NULL, NULL, 'Voluntariado', true, 'caritas@ong.es', 'Jubilados Ronda', 'Llevar comida a los jubilados de Ronda', '2020-01-28', '2020-01-27', 5, 'Ronda', false);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (7, 'ajgarcia@uma.es', 5, 'Aprendizaje-Servicio', true, 'caritas@ong.es', 'Medicina en Honduras', 'Analisis medico en Honduras', '2020-01-10', '2020-01-11', 6, 'Honduras', false);
INSERT INTO ALGUSTO.ACTIVIDAD (NACTIVIDAD, CORREO_PROFESOR, ASIGNATURA_ASOCIADA, TIPO_ACTIVIDAD, VALIDADA, ONG, TITULO, DESCRIPCION, FECHA_INICIO, FECHA_FIN, NPERSONAS, LUGAR, TURNOTARDE) 
	VALUES (8, NULL, NULL, NULL, NULL, 'aproinla@ong.es', 'Aprobar', 'Aprobar requisitos', '2020-01-22', '2020-01-23', 2, 'Malaga', false);


INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 1);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 2);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 3);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 4);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 5);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 6);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 7);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 8);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('alvaroramos@uma.es', 9);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 8);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 9);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 10);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 11);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 12);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 13);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 14);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 15);
INSERT INTO ALGUSTO.ESTUDIOS (CORREO_ESTUDIANTE, COD_ASIGNATURA) 
	VALUES ('fcarmona@uma.es', 16);


INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (0, 'Educacion');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (0, 'Medio Ambiente');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (0, 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (0, 'Sanidad');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (1, 'Educacion');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (1, 'Medio Ambiente');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (2, 'Educacion');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (2, 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (3, 'Educacion');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (3, 'Medio Ambiente');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (3, 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (4, 'Educacion');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (4, 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (5, 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (5, 'Sanidad');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (6, 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (6, 'Servicios Sociales');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (7, 'Pobreza');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (7, 'Sanidad');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (8, 'Educacion');
INSERT INTO ALGUSTO.ETIQUETAS_ACTIVIDAD (ACTIVIDAD, ETIQUETA) 
	VALUES (8, 'Pobreza');


INSERT INTO ALGUSTO.PARTICIPACION (NACTIVIDAD, USUARIO) 
	VALUES (6, 'fcarmona@uma.es');
INSERT INTO ALGUSTO.PARTICIPACION (NACTIVIDAD, USUARIO) 
	VALUES (7, 'alvaroramos@uma.es');
INSERT INTO ALGUSTO.PARTICIPACION (NACTIVIDAD, USUARIO) 
	VALUES (7, 'fcarmona@uma.es');
INSERT INTO ALGUSTO.PARTICIPACION (NACTIVIDAD, USUARIO) 
	VALUES (7, 'jmlupionc@uma.es');



INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (0, 'malvarez@uma.es', 'aproinla@ong.es', true, 'La ONG Aproinla ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=0''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (1, 'malvarez@uma.es', 'aproinla@ong.es', true, 'La ONG Aproinla ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=1''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (2, 'malvarez@uma.es', 'aproinla@ong.es', true, 'La ONG Aproinla ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=2''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (3, 'malvarez@uma.es', 'caritas@ong.es', true, 'La ONG Caritas ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=3''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (4, 'malvarez@uma.es', 'caritas@ong.es', true, 'La ONG Caritas ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=4''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (5, 'malvarez@uma.es', 'caritas@ong.es', true, 'La ONG Caritas ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=5''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (6, 'malvarez@uma.es', 'caritas@ong.es', true, 'La ONG Caritas ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=6''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (7, 'malvarez@uma.es', 'caritas@ong.es', true, 'La ONG Caritas ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=7''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (8, 'malvarez@uma.es', 'malvarez@uma.es', true, 'Se ha asignado una nueva actividad a la asignatura Aplicaciones de Técnicas Moleculares en Patología. <a href="ValidarActividadServlet?a=7">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (9, 'malvarez@uma.es', 'malvarez@uma.es', true, 'Se ha asignado una nueva actividad a la asignatura Aplicaciones de Técnicas Moleculares en Patología. <a href="ValidarActividadServlet?a=7">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (10, 'malvarez@uma.es', 'malvarez@uma.es', true, 'Le ha sido asignada una nueva actividad de investigación. <a href="ValidarActividadServlet?a=7">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (11, 'malvarez@uma.es', 'malvarez@uma.es', true, 'Se ha asignado una nueva actividad a la asignatura Aplicaciones de Técnicas Moleculares en Patología. <a href="ValidarActividadServlet?a=7">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (12, 'malvarez@uma.es', 'malvarez@uma.es', true, 'Se ha asignado una nueva actividad a la asignatura Aplicaciones de Técnicas Moleculares en Patología. <a href="ValidarActividadServlet?a=7">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (13, 'aproinla@ong.es', 'malvarez@uma.es', true, 'La actividad Capturar pokemon ha sido aceptada y clasificada como voluntariado');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (14, 'aproinla@ong.es', 'malvarez@uma.es', true, 'La actividad Ganar la liga ha sido aceptada y clasificada como voluntariado');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (15, 'mjruiz@uma.es', 'malvarez@uma.es', true, 'Le ha sido asignada una nueva actividad de investigación. <a href="ValidarActividadServlet?a=2">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (16, 'mjruiz@uma.es', 'malvarez@uma.es', true, 'Se ha asignado una nueva actividad a la asignatura Biomecánica Aplicada en Medicina y Práctica Deportiva. <a href="ValidarActividadServlet?a=3">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (17, 'ajgarcia@uma.es', 'malvarez@uma.es', true, 'Se ha asignado una nueva actividad a la asignatura Farmacología Social. <a href="ValidarActividadServlet?a=4">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (18, 'malvarez@uma.es', 'malvarez@uma.es', true, 'Le ha sido asignada una nueva actividad de investigación. <a href="ValidarActividadServlet?a=5">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (19, 'caritas@ong.es', 'malvarez@uma.es', true, 'La actividad Jubilados Ronda ha sido aceptada y clasificada como voluntariado');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (20, 'ajgarcia@uma.es', 'malvarez@uma.es', true, 'Se ha asignado una nueva actividad a la asignatura Farmacología Social. <a href="ValidarActividadServlet?a=7">Pulse para validarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (21, 'caritas@ong.es', 'malvarez@uma.es', true, 'La actividad Medicina en Honduras ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (22, 'caritas@ong.es', 'malvarez@uma.es', true, 'La actividad Medicina en Honduras ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (23, 'caritas@ong.es', 'malvarez@uma.es', true, 'La actividad Medicina en Honduras ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (24, 'caritas@ong.es', 'malvarez@uma.es', true, 'La actividad Medicina en Honduras ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (25, 'caritas@ong.es', 'malvarez@uma.es', true, 'La actividad Medicina en Honduras ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (26, 'caritas@ong.es', 'malvarez@uma.es', true, 'La actividad Visita hospital ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (29, 'caritas@ong.es', 'jmlupionc@uma.es', true, 'Una persona quiere participar en una actividad, consulte el resto de la informacion aqui<form action="RevisionServlet" method="post">
<input type="hidden" value="6" name="actividad"/>
<input type="hidden" value="jmlupionc@uma.es" name="solicitante"/>
<input type="hidden" value="29" name="notificacion"/>
<input type="submit" name="boton" value="Revisar">
</form>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (32, 'caritas@ong.es', 'mjruiz@uma.es', true, 'La actividad Seguir siendo el campeÃ³n ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (33, 'aproinla@ong.es', 'mjruiz@uma.es', true, 'La actividad aaa ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (34, 'caritas@ong.es', 'ajgarcia@uma.es', true, 'La actividad aprobar requisitos ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (35, 'caritas@ong.es', 'ajgarcia@uma.es', true, 'La actividad Medicina en Honduras ha sido aceptada por el profesor correspondiente y pronto estará disponible en el sistema.');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (39, 'fcarmona@uma.es', 'caritas@ong.es', false, 'Has sido aceptado en la actividad Jubilados Ronda de la ONG Caritas');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (40, 'fcarmona@uma.es', 'caritas@ong.es', false, 'Has sido aceptado en la actividad Medicina en Honduras de la ONG Caritas');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (41, 'jmlupionc@uma.es', 'caritas@ong.es', false, 'Has sido aceptado en la actividad Medicina en Honduras de la ONG Caritas');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (42, 'alvaroramos@uma.es', 'caritas@ong.es', true, 'Has sido aceptado en la actividad Medicina en Honduras de la ONG Caritas');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (45, 'alvaroramos@uma.es', 'caritas@ong.es', true, 'Has sido aceptado en la actividad Medicina en Honduras de la ONG Caritas');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (46, 'malvarez@uma.es', 'aproinla@ong.es', false, 'La ONG Aproinla ha propuesto una nueva actividad. Pulsa <a href=''ClasificarActividadServlet?act=8''> aquí para clasificarla</a>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (47, 'ajgarcia@uma.es', 'caritas@ong.es', false, 'La ONG Caritas ha realizado un informe. Puede evaluar al alumno aquí: <form action="EvaluarActividadServlet"><input type="submit" name="boton" value="Evaluar">
<input type="hidden" value="7" name="actividad"/>
</form>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (48, 'alvaroramos@uma.es', 'caritas@ong.es', false, 'La ONG Caritas le ha evaluado. Puede verlo aquí: <form action="VerEvaluacionServlet"><input type="submit" name="boton" value="Consultar">
<input type="hidden" value="7" name="actividad"/>
</form>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (49, 'mjruiz@uma.es', 'alvaroramos@uma.es', false, 'El usuario Álvaro quiere participar en una actividad, consulte el resto de la informacion aqui<form action="RevisionServlet" method="post">
<input type="hidden" value="2" name="actividad"/>
<input type="hidden" value="alvaroramos@uma.es" name="solicitante"/>
<input type="hidden" value="49" name="notificacion"/>
<input type="submit" name="boton" value="Revisar">
</form>');
INSERT INTO ALGUSTO.NOTIFICACION (IDNOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO) 
	VALUES (50, 'caritas@ong.es', 'alvaroramos@uma.es', false, 'El usuario Álvaro ha valorado su actividad Medicina en Honduras. Puede leerla aquí: <form action="VerActividadServlet"><input type="submit" name="boton" value="Consultar">
<input type="hidden" value="7" name="actividad"/>
</form>');


INSERT INTO ALGUSTO.INFORME (IDINFORME, PROFESOR, PARTICIPANTE, ACTIVIDAD, NOTAONG, NOTAPARTICIPANTE, COMENTARIOONG, COMENTARIOPROFESOR, COMENTARIOPARTICIPANTE, NOTAPROFESOR, FECHAINFORME, FECHAEVALUACION, FECHAOPINION, NHORAS) 
	VALUES (1, 'ajgarcia@uma.es', 'alvaroramos@uma.es', 7, 4, 5, 'Muy bien', 'Solo son 4 horas vago, pero eres guapete', 'wow so cool', 9, '2020-01-22', '2020-01-22', '2020-01-22', 4);



INSERT INTO ALGUSTO.MENSAJE (IDMENSAJENOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO, TITULO, FECHA) 
	VALUES (0, 'malvarez@uma.es', 'aproinla@ong.es', true, 'Gracias por aceptarnos en su prestigioso servicio', 'Gracias', '2020-01-22');
INSERT INTO ALGUSTO.MENSAJE (IDMENSAJENOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO, TITULO, FECHA) 
	VALUES (1, 'aproinla@ong.es', 'caritas@ong.es', false, 'Hola compaÃ±era ONG! A hacer el bien!', 'Buenas!', '2020-01-22');
INSERT INTO ALGUSTO.MENSAJE (IDMENSAJENOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO, TITULO, FECHA) 
	VALUES (2, 'malvarez@uma.es', 'caritas@ong.es', false, 'Gracias por aceptarnos!!!', 'Gracias', '2020-01-22');
INSERT INTO ALGUSTO.MENSAJE (IDMENSAJENOTIFICACION, RECEPTOR, EMISOR, LEIDO, CONTENIDO, TITULO, FECHA) 
	VALUES (3, 'malvarez@uma.es', 'caritas@ong.es', false, 'Gracias por la confianza', 'Gracias', '2020-01-22');
