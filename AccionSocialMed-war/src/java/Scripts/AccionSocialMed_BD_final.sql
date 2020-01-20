CREATE TABLE Asignatura(
	cod_asignatura int PRIMARY KEY,
	nombre_asignatura varchar(5000) NOT NULL,
	n_creditos int NOT NULL);

CREATE TABLE Usuario(
	correo varchar(50) PRIMARY KEY,
	nombre varchar(50) NOT NULL,
	telefono int,
	direccion varchar(50), 
	localidad varchar(50),
        turnoTarde boolean);

CREATE TABLE Estudiante(
	correo varchar(50) PRIMARY KEY,
	apellidos varchar(50),
	fecha_nacimiento date,
	FOREIGN KEY (correo) REFERENCES Usuario(correo));

CREATE TABLE Estudios(
	correo_estudiante varchar(50),
	cod_asignatura int,
	CONSTRAINT UC_Estudios UNIQUE (correo_estudiante, cod_asignatura),
	FOREIGN KEY (correo_estudiante) REFERENCES Estudiante(correo),
	FOREIGN KEY (cod_asignatura) REFERENCES Asignatura(cod_asignatura));

CREATE TABLE Profesor(
	correo varchar(50) PRIMARY KEY,
	fecha_nacimiento date,
	apellidos varchar(50),
	gestor boolean,
	FOREIGN KEY (correo) REFERENCES Usuario(correo));

CREATE TABLE Imparte(
	correo_profesor varchar(50),
	cod_asignatura int,
	CONSTRAINT UC_Imparte UNIQUE (correo_profesor, cod_asignatura),
	FOREIGN KEY (correo_profesor) REFERENCES Profesor(correo),
	FOREIGN KEY (cod_asignatura) REFERENCES Asignatura(cod_asignatura));


CREATE TABLE ONG(
	correo varchar(50) PRIMARY KEY,
	contrasena varchar(50) NOT NULL,
	web varchar(50),
	clave_registro varchar(50) NOT NULL,
	activa boolean,
	FOREIGN KEY (correo) REFERENCES Usuario(correo),
	UNIQUE (clave_registro));

CREATE TABLE Actividad(
	nActividad int PRIMARY KEY,
	correo_profesor varchar(50),
	asignatura_asociada int,
        tipo_actividad varchar(50) check (tipo_actividad in ('Aprendizaje-Servicio','Voluntariado','Investigación')),
        validada boolean,
	ong varchar(50) NOT NULL,
	titulo varchar(50) NOT NULL,
	descripcion varchar(5000) NOT NULL,
	fecha_inicio date NOT NULL,
	fecha_fin date,
	nPersonas int,
	lugar varchar(50),
        turnoTarde boolean,
	FOREIGN KEY (correo_profesor) REFERENCES Profesor(correo),
	FOREIGN KEY (asignatura_asociada) REFERENCES Asignatura(cod_asignatura),
	FOREIGN KEY (ong) REFERENCES ONG(correo));

CREATE TABLE Participacion(
	nActividad int,
	usuario varchar(50),
	FOREIGN KEY (nActividad) REFERENCES Actividad(nActividad),
	FOREIGN KEY (usuario) REFERENCES Usuario(correo),
	CONSTRAINT UC_Participacion UNIQUE (nActividad, usuario));


CREATE TABLE PAS(
	correo varchar(50) PRIMARY KEY,
	fecha_nacimiento date,
	apellidos varchar(50),
	FOREIGN KEY (correo) REFERENCES Usuario(correo));

CREATE TABLE Notificacion(
	idNotificacion int PRIMARY KEY,
	receptor varchar(50),
	emisor varchar(50),
	leido boolean,
        contenido varchar(2000),
	FOREIGN KEY (receptor) REFERENCES Usuario(correo),
	FOREIGN KEY (emisor) REFERENCES Usuario(correo));

CREATE TABLE Mensaje(
	idMensajeNotificacion int PRIMARY KEY,
	receptor varchar(50),
	emisor varchar(50),
	leido boolean,
        contenido varchar(2000),
        titulo varchar(50),
        fecha date,
	FOREIGN KEY (receptor) REFERENCES Usuario(correo),
	FOREIGN KEY (emisor) REFERENCES Usuario(correo));

CREATE TABLE Informe(
        idInforme int PRIMARY KEY,
        profesor varchar(50),
        participante varchar(50),
        actividad int,
        notaOng int,
        notaParticipante int,
        comentarioOng varchar(5000),
        comentarioProfesor varchar(5000),
        comentarioParticipante varchar(5000),
        notaProfesor int,
        fechaInforme date,
        fechaEvaluacion date,
        fechaOpinion date,
        nHoras int,
        FOREIGN KEY (profesor) REFERENCES Usuario(correo),
        FOREIGN KEY (participante) REFERENCES Usuario(correo),
        FOREIGN KEY (actividad) REFERENCES Actividad(nActividad));

CREATE TABLE Etiqueta(
	etiqueta varchar(50) PRIMARY KEY,
        tipo int);

CREATE TABLE Etiquetas_actividad(
	actividad int,
	etiqueta varchar(50),
	FOREIGN KEY (actividad) REFERENCES Actividad(nActividad),
	FOREIGN KEY (etiqueta) references Etiqueta(etiqueta),
	CONSTRAINT UC_EtAc UNIQUE (actividad, etiqueta));
	
CREATE TABLE Etiquetas_usuario(
	correo varchar(50),
	etiqueta varchar(50),
	FOREIGN KEY (correo) REFERENCES Usuario(correo),
	FOREIGN KEY (etiqueta) references Etiqueta(etiqueta),
	CONSTRAINT UC_EtUs UNIQUE (correo, etiqueta));

