Database bug reproduction for PostGIS and Spring Data R2DBC

Dependencies

Install postgres and postgis.

Create a database and grant access to a test user. Put those creds in application.yml.

```postgresql
CREATE DATABASE repro;
CREATE USER postgispoc WITH PASSWORD 'changemeforprod';
GRANT ALL PRIVILEGES ON DATABASE repro TO postgispoc;
```

Once created, add the postgis extention.

```postgresql
CREATE EXTENSION postgis;
```
