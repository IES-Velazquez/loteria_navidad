CREATE OR REPLACE TRIGGER loteria_navidad.tr_update_solo_20_decimos
    BEFORE UPDATE
    ON loteria_navidad.Decimos
    FOR EACH ROW
    BEGIN
        DECLARE v_cantidad INT;

        SELECT SUM(cantidad) + NEW.cantidad
            INTO v_cantidad
            FROM Decimos
            WHERE numero = NEW.numero;

        IF v_cantidad > 20 THEN
            SIGNAL SQLSTATE '45000'
            SET MYSQL_ERRNO=30001,
                MESSAGE_TEXT='No puede comprarse más de 20 décimos del mismo número';
        END IF;
    END;

CREATE OR REPLACE TRIGGER loteria_navidad.tr_insert_solo_20_decimos
    BEFORE INSERT
    ON loteria_navidad.Decimos
    FOR EACH ROW
BEGIN
    DECLARE v_cantidad INT;

    SELECT SUM(cantidad) + NEW.cantidad
    INTO v_cantidad
    FROM Decimos
    WHERE numero = NEW.numero;

    IF v_cantidad > 20 THEN
        SIGNAL SQLSTATE '45000'
        SET MYSQL_ERRNO=30001,
            MESSAGE_TEXT='No puede comprarse más de 20 décimos del mismo número';
    END IF;
END;

INSERT INTO loteria_navidad.Usuarios VALUES ('Johnny', 'Johnny', 'user', 'Johnny');
INSERT INTO loteria_navidad.Decimos VALUES (1, 'Wololo', 21, 1, 1, 'Johnny');