CREATE TABLE CAD_USUARIO (
    ID INT PRIMARY KEY CHECK (ID BETWEEN 10000 AND 99999), 
    username VARCHAR(255) UNIQUE, 
    senha VARCHAR(255),  
    bloqueado BIT DEFAULT 0,  -- Indica se o usuário está bloqueado (0 = não, 1 = sim)
    tentativas_login INT DEFAULT 0,  
    ultimo_login DATE,  
    senha_expirada BIT DEFAULT 0,  -- Indica se a senha expirou (0 = não, 1 = sim)
    FOREIGN KEY (ID) REFERENCES CAD_CIDADAO(ID)
);