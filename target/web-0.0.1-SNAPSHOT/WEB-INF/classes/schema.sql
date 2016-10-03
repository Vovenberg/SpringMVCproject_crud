CREATE TABLE IF NOT EXISTS clients (
	id_client bigint NOT NULL PRIMARY KEY,
	surname varchar(20) NOT NULL,
	pasport_n bigint NOT NULL,
	pasport_s bigint NOT NULL,
	street varchar(20) NOT NULL,
	home int NOT NULL
	);
	
CREATE TABLE IF NOT EXISTS accounts (
	id_account bigint NOT NULL PRIMARY KEY,
	date_begin date NOT NULL,
	date_close date NOT NULL,
	id_client bigint NOT NULL,
	id_filial bigint NOT NULL,
	 Foreign key (id_client) references "clients" (id_client),
	 Foreign key (id_filial) references "filials" (id_filial)
);

CREATE TABLE IF NOT EXISTS operations (
	id_oper bigint NOT NULL PRIMARY KEY,
	date_oper date NOT NULL,
	type_oper varchar(20) NOT NULL,
	id_account bigint NOT NULL,
	Foreign key (id_account) references "accounts" (id_account)
);

CREATE TABLE IF NOT EXISTS filials (
	id_filial bigint NOT NULL PRIMARY KEY,
	region date NOT NULL,
	street varchar(20) NOT NULL,
	home int NOT NULL
);


CREATE TABLE IF NOT EXISTS cards (
	id_card bigint NOT NULL PRIMARY KEY,
	number_card bigint NOT NULL,
	vcc int NOT NULL,
	type varchar(20) NOT NULL,
	id_account bigint NOT NULL,
  Foreign key (id_account) references "accounts" (id_account)
);

	