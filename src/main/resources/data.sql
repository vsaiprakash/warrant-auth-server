-- CREATE TABLE oauth_clients (
--   client_id             VARCHAR(80)   NOT NULL,
--   client_secret         VARCHAR(80),
--   redirect_uri          VARCHAR(2000),
--   grant_types           VARCHAR(80),
--   scope                 VARCHAR(4000),
--   user_id               VARCHAR(80),
--   PRIMARY KEY (client_id)
-- );

INSERT INTO oauth_clients VALUES ('clientId1', 'secret1', 'http://', 'grantTypes', 'scopes', 'userId');

-- insert into oauth_scopes values('read', true);
-- insert into oauth_scopes values('write', false);

-- insert into oauth_jwt values ('asd','asd','asd');