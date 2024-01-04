-- liquibase formatted sql
-- changeset pete:1
CREATE SEQUENCE asset_id_seq;
CREATE TABLE IF NOT EXISTS asset (
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('asset_id_seq'),
    geom GEOMETRY(Point, 4326)
    );
INSERT INTO asset(geom) VALUES(ST_GeomFromText('POINT(-71.060316 48.432044)', 4326));