CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,
  password text NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
  user_id bigint(20) UNSIGNED NOT NULL,
  roles integer,
  CONSTRAINT user_user_id_fk FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS task (
  id SERIAL PRIMARY KEY,
  title varchar(100) NOT NULL,
  description varchar(255),
  status char(1) NOT NULL,
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  conclusion_date TIMESTAMP,
  CONSTRAINT status_chk CHECK (status = 'N' AND status = 'E' AND status = 'C')
);