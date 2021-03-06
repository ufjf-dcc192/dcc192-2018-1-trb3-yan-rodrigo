CREATE TABLE USUARIO(
    ID INTEGER  PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
    NOME VARCHAR (150)  NOT NULL, 
    EMAIL VARCHAR (150)  NOT NULL, 
    SENHA VARCHAR (150)  NOT NULL, 
    NOMEUSUARIO VARCHAR (150) NOT NULL  
);


CREATE TABLE ITEM(
    ID INTEGER PRIMARY KEY GENERATED by default AS IDENTITY, 
    TITULO VARCHAR (150)  NOT NULL, 
    DESCRICAO VARCHAR (150)  NOT NULL, 
    LINKS VARCHAR (150)  NOT NULL, 
    DATACRIACAO DATE NOT NULL,
    DATAATUALIZACAO DATE NOT NULL,
    IDUSUARIO INTEGER NOT NULL,
    FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(ID)
);

CREATE TABLE COMENTARIO(
    ID INTEGER  PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    TEXTO VARCHAR (2000),
    DATACRIACAO DATE NOT NULL,
    DATAATUALIZACAO DATE NOT NULL,
    IDUSUARIO INTEGER NOT NULL,
    IDITEM INTEGER NOT NULL,
    FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(ID),
    FOREIGN KEY (IDITEM) REFERENCES ITEM(ID)
    
);

CREATE TABLE AVALIACAO(
    ID INTEGER  PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    CURTI INTEGER,
    DISLIKE INTEGER,
    IDUSUARIO INTEGER NOT NULL,
    IDITEM INTEGER,
    IDCOMENTARIO INTEGER,
    FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(ID),
    FOREIGN KEY (IDITEM) REFERENCES ITEM(ID),
    FOREIGN KEY (IDCOMENTARIO) REFERENCES COMENTARIO(ID)
);
