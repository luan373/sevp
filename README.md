# sevp

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.0
-- Dumped by pg_dump version 9.5.0

-- Started on 2016-07-15 09:56:38

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 192 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 192
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 181 (class 1259 OID 26982)
-- Name: CLIENTE; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE CLIENTE (
    IDCLIENTE bigint NOT NULL,
    NOMERAZAO character varying(50) NOT NULL,
    TIPOPESSOA character(2) NOT NULL,
    CPFCNPJ character varying(15) NOT NULL,
    DATANASCIMENTO date,
    LOGRADOURO character varying(250) NOT NULL,
    NUMERO character varying(10) NOT NULL,
    COMPLEMENTO character varying(20),
    BAIRRO character varying(50) NOT NULL,
    CIDADE character varying(150) NOT NULL,
    UF character varying(2) NOT NULL,
    CEP character varying(9) NOT NULL,
    TELEFONE character varying(20) NOT NULL,
    EMAIL character varying(50) NOT NULL
);


ALTER TABLE CLIENTE OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 26980)
-- Name: CLIENTE_IDCLIENTE_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE CLIENTE_IDCLIENTE_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE CLIENTE_IDCLIENTE_seq OWNER TO postgres;

--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 180
-- Name: CLIENTE_IDCLIENTE_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE CLIENTE_IDCLIENTE_seq OWNED BY CLIENTE.IDCLIENTE;


--
-- TOC entry 189 (class 1259 OID 27025)
-- Name: PEDIDO; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE PEDIDO (
    IDPEDIDO bigint NOT NULL,
    IDCLIENTE bigint NOT NULL,
    DATAPEDIDO date NOT NULL,
    IDSITUACAO integer NOT NULL,
    IDUSUARIO bigint NOT NULL,
    LOGRADOURO character varying(250) NOT NULL,
    NUMERO character varying(10) NOT NULL,
    COMPLEMENTO character varying(20),
    BAIRRO character varying(50) NOT NULL,
    CIDADE character varying(150) NOT NULL,
    UF character varying(2) NOT NULL,
    CEP character varying(9) NOT NULL,
    TELEFONE character varying(20) NOT NULL
);


ALTER TABLE PEDIDO OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 27023)
-- Name: PEDIDO_IDPEDIDO_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE PEDIDO_IDPEDIDO_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE PEDIDO_IDPEDIDO_seq OWNER TO postgres;

--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 188
-- Name: PEDIDO_IDPEDIDO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE PEDIDO_IDPEDIDO_seq OWNED BY PEDIDO.IDPEDIDO;


--
-- TOC entry 187 (class 1259 OID 27009)
-- Name: PRODUTO; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE PRODUTO (
    IDPRODUTO bigint NOT NULL,
    IDTIPOPRODUTO bigint NOT NULL,
    NOMEPRODUTO character varying(50) NOT NULL,
    DESCRICAOPRODUTO character varying(500) NOT NULL,
    VALORUNITARIO numeric NOT NULL,
    CUSTOUNITARIO numeric NOT NULL
);


ALTER TABLE PRODUTO OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 27046)
-- Name: PRODUTOPEDIDO; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE PRODUTOPEDIDO (
    IDPRODUTOPEDIDO bigint NOT NULL,
    IDPEDIDO bigint NOT NULL,
    IDPRODUTO bigint NOT NULL,
    QUANTIDADE integer,
    VALORUNITARIO numeric NOT NULL
);


ALTER TABLE PRODUTOPEDIDO OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 27044)
-- Name: PRODUTOPEDIDO_IDPRODUTOPEDIDO_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE PRODUTOPEDIDO_IDPRODUTOPEDIDO_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE PRODUTOPEDIDO_IDPRODUTOPEDIDO_seq OWNER TO postgres;

--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 190
-- Name: PRODUTOPEDIDO_IDPRODUTOPEDIDO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE PRODUTOPEDIDO_IDPRODUTOPEDIDO_seq OWNED BY PRODUTOPEDIDO.IDPRODUTOPEDIDO;


--
-- TOC entry 186 (class 1259 OID 27007)
-- Name: PRODUTO_IDPRODUTO_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE PRODUTO_IDPRODUTO_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE PRODUTO_IDPRODUTO_seq OWNER TO postgres;

--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 186
-- Name: PRODUTO_IDPRODUTO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE PRODUTO_IDPRODUTO_seq OWNED BY PRODUTO.IDPRODUTO;


--
-- TOC entry 183 (class 1259 OID 26993)
-- Name: TIPOPRODUTO; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE TIPOPRODUTO (
    IDTIPOPRODUTO bigint NOT NULL,
    DESCRICAOTIPOPRODUTO character varying(50) NOT NULL
);


ALTER TABLE TIPOPRODUTO OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 26991)
-- Name: TIPOPRODUTO_IDTIPOPRODUTO_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE TIPOPRODUTO_IDTIPOPRODUTO_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE TIPOPRODUTO_IDTIPOPRODUTO_seq OWNER TO postgres;

--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 182
-- Name: TIPOPRODUTO_IDTIPOPRODUTO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE TIPOPRODUTO_IDTIPOPRODUTO_seq OWNED BY TIPOPRODUTO.IDTIPOPRODUTO;


--
-- TOC entry 185 (class 1259 OID 27001)
-- Name: USUARIO; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE USUARIO (
    IDUSUARIO bigint NOT NULL,
    NOME character varying(50) NOT NULL,
    USUARIO character varying(50) NOT NULL,
    SENHA character varying(50) NOT NULL,
    ATIVO boolean NOT NULL
);


ALTER TABLE USUARIO OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 26999)
-- Name: USUARIO_IDUSUARIO_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE USUARIO_IDUSUARIO_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE USUARIO_IDUSUARIO_seq OWNER TO postgres;

--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 184
-- Name: USUARIO_IDUSUARIO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE USUARIO_IDUSUARIO_seq OWNED BY USUARIO.IDUSUARIO;


--
-- TOC entry 2015 (class 2604 OID 26985)
-- Name: IDCLIENTE; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY CLIENTE ALTER COLUMN IDCLIENTE SET DEFAULT nextval('CLIENTE_IDCLIENTE_seq'::regclass);


--
-- TOC entry 2019 (class 2604 OID 27028)
-- Name: IDPEDIDO; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PEDIDO ALTER COLUMN IDPEDIDO SET DEFAULT nextval('PEDIDO_IDPEDIDO_seq'::regclass);


--
-- TOC entry 2018 (class 2604 OID 27012)
-- Name: IDPRODUTO; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PRODUTO ALTER COLUMN IDPRODUTO SET DEFAULT nextval('PRODUTO_IDPRODUTO_seq'::regclass);


--
-- TOC entry 2020 (class 2604 OID 27049)
-- Name: IDPRODUTOPEDIDO; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PRODUTOPEDIDO ALTER COLUMN IDPRODUTOPEDIDO SET DEFAULT nextval('PRODUTOPEDIDO_IDPRODUTOPEDIDO_seq'::regclass);


--
-- TOC entry 2016 (class 2604 OID 26996)
-- Name: IDTIPOPRODUTO; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY TIPOPRODUTO ALTER COLUMN IDTIPOPRODUTO SET DEFAULT nextval('TIPOPRODUTO_IDTIPOPRODUTO_seq'::regclass);


--
-- TOC entry 2017 (class 2604 OID 27004)
-- Name: IDUSUARIO; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY USUARIO ALTER COLUMN IDUSUARIO SET DEFAULT nextval('USUARIO_IDUSUARIO_seq'::regclass);


--
-- TOC entry 2022 (class 2606 OID 26990)
-- Name: CLIENTE_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY CLIENTE
    ADD CONSTRAINT CLIENTE_pkey PRIMARY KEY (IDCLIENTE);


--
-- TOC entry 2030 (class 2606 OID 27033)
-- Name: PEDIDO_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PEDIDO
    ADD CONSTRAINT PEDIDO_pkey PRIMARY KEY (IDPEDIDO);


--
-- TOC entry 2032 (class 2606 OID 27054)
-- Name: PRODUTOPEDIDO_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PRODUTOPEDIDO
    ADD CONSTRAINT PRODUTOPEDIDO_pkey PRIMARY KEY (IDPRODUTOPEDIDO);


--
-- TOC entry 2028 (class 2606 OID 27017)
-- Name: PRODUTO_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PRODUTO
    ADD CONSTRAINT PRODUTO_pkey PRIMARY KEY (IDPRODUTO);


--
-- TOC entry 2024 (class 2606 OID 26998)
-- Name: TIPOPRODUTO_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY TIPOPRODUTO
    ADD CONSTRAINT TIPOPRODUTO_pkey PRIMARY KEY (IDTIPOPRODUTO);


--
-- TOC entry 2026 (class 2606 OID 27006)
-- Name: USUARIO_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY USUARIO
    ADD CONSTRAINT USUARIO_pkey PRIMARY KEY (IDUSUARIO);


--
-- TOC entry 2034 (class 2606 OID 27034)
-- Name: FK_PEDIDO_CLIENTE; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PEDIDO
    ADD CONSTRAINT FK_PEDIDO_CLIENTE FOREIGN KEY (IDCLIENTE) REFERENCES CLIENTE(IDCLIENTE);


--
-- TOC entry 2035 (class 2606 OID 27039)
-- Name: FK_PEDIDO_USUARIO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PEDIDO
    ADD CONSTRAINT FK_PEDIDO_USUARIO FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(IDUSUARIO);


--
-- TOC entry 2036 (class 2606 OID 27055)
-- Name: FK_PRODUTOPEDIDO_PEDIDO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PRODUTOPEDIDO
    ADD CONSTRAINT FK_PRODUTOPEDIDO_PEDIDO FOREIGN KEY (IDPEDIDO) REFERENCES PEDIDO(IDPEDIDO);


--
-- TOC entry 2037 (class 2606 OID 27060)
-- Name: FK_PRODUTOPEDIDO_PRODUTO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PRODUTOPEDIDO
    ADD CONSTRAINT FK_PRODUTOPEDIDO_PRODUTO FOREIGN KEY (IDPRODUTO) REFERENCES PRODUTO(IDPRODUTO);


--
-- TOC entry 2033 (class 2606 OID 27018)
-- Name: FK_PRODUTO_TIPOPRODUTO; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY PRODUTO
    ADD CONSTRAINT FK_PRODUTO_TIPOPRODUTO FOREIGN KEY (IDTIPOPRODUTO) REFERENCES TIPOPRODUTO(IDTIPOPRODUTO);


--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-07-15 09:56:38

--
-- PostgreSQL database dump complete
--

