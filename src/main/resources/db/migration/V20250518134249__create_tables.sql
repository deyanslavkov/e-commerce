CREATE TABLE public.product
(
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    price numeric(38,2) NOT NULL,
    quantity integer NOT NULL,
    updated_at timestamp(6) without time zone,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);

ALTER TABLE public.product
    OWNER to myshop_user;



CREATE TABLE public."user"
(
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

ALTER TABLE public."user"
    OWNER to myshop_user;



CREATE TABLE public.cart
(
    id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    quantity integer NOT NULL,
    updated_at timestamp(6) without time zone,
    product_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT cart_pkey PRIMARY KEY (id),
    CONSTRAINT uc_user_id_product_id UNIQUE (user_id, product_id),
    CONSTRAINT fk_product_id FOREIGN KEY (product_id)
        REFERENCES public.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE public.cart
    OWNER to myshop_user;



CREATE TABLE public."order"
(
    id bigint NOT NULL,
    amount numeric(38,2) NOT NULL,
    created_at timestamp(6) without time zone,
    status character varying(255) COLLATE pg_catalog."default",
    updated_at timestamp(6) without time zone,
    user_id bigint NOT NULL,
    CONSTRAINT order_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT order_status_check CHECK (status::text = ANY (ARRAY['PENDING'::character varying, 'PAID'::character varying, 'CANCELLED'::character varying]::text[]))
);

ALTER TABLE public."order"
    OWNER to myshop_user;