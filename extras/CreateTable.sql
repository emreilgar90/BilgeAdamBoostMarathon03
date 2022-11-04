-- Table: public.account

-- DROP TABLE IF EXISTS public.account;

CREATE TABLE IF NOT EXISTS public.account
(
    id bigint NOT NULL DEFAULT nextval('account_id_seq'::regclass),
    accounttype character varying(255) COLLATE pg_catalog."default",
    account_type_number bigint,
    branches_id bigint,
    customer_id bigint,
    CONSTRAINT account_pkey PRIMARY KEY (id),
    CONSTRAINT fkfhh6otya6l3sdh1v6jut588tf FOREIGN KEY (customer_id)
        REFERENCES public.customer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkms11875ig6trvy9lyphenn4ig FOREIGN KEY (branches_id)
        REFERENCES public.branch (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account
    OWNER to postgres;

--------------------------------------------------------------------------------------------------
-- Table: public.branch

-- DROP TABLE IF EXISTS public.branch;

CREATE TABLE IF NOT EXISTS public.branch
(
    id bigint NOT NULL DEFAULT nextval('branch_id_seq'::regclass),
    branch_name character varying(255) COLLATE pg_catalog."default",
    branch_number bigint,
    CONSTRAINT branch_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.branch
    OWNER to postgres;
------------------------------------------------------------------------------------------------
-- Table: public.customer

-- DROP TABLE IF EXISTS public.customer;

CREATE TABLE IF NOT EXISTS public.customer
(
    id bigint NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
    customer_number bigint,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;
------------------------------------------------------------------------------------------
-- Table: public.process

-- DROP TABLE IF EXISTS public.process;

CREATE TABLE IF NOT EXISTS public.process
(
    id bigint NOT NULL DEFAULT nextval('process_id_seq'::regclass),
    operationtype character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT process_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.process
    OWNER to postgres;
-----------------------------------------------------------------------------------------
-- Table: public.transactions

-- DROP TABLE IF EXISTS public.transactions;

CREATE TABLE IF NOT EXISTS public.transactions
(
    id bigint NOT NULL DEFAULT nextval('transactions_id_seq'::regclass),
    accounttype character varying(255) COLLATE pg_catalog."default",
    operation_amount double precision NOT NULL,
    operation_date date NOT NULL,
    transaction_number bigint NOT NULL,
    process_id bigint,
    CONSTRAINT transactions_pkey PRIMARY KEY (id),
    CONSTRAINT fkbmxn6pxgmu027lfraairv4d3x FOREIGN KEY (process_id)
        REFERENCES public.process (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transactions
    OWNER to postgres;