PGDMP                         z         
   FINANCIERO    14.1    14.1 .    #           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            $           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            %           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            &           1262    24713 
   FINANCIERO    DATABASE     q   CREATE DATABASE "FINANCIERO" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United Kingdom.1252';
    DROP DATABASE "FINANCIERO";
                postgres    false            ?            1259    33027    usuario    TABLE     ?   CREATE TABLE public.usuario (
    id integer NOT NULL,
    username character varying(50),
    password character varying(120)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            ?            1259    33026    Usuario_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Usuario_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public."Usuario_id_seq";
       public          postgres    false    218            '           0    0    Usuario_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public."Usuario_id_seq" OWNED BY public.usuario.id;
          public          postgres    false    217            ?            1259    24724    contacto    TABLE     ?   CREATE TABLE public.contacto (
    persona_id bigint,
    telefono character varying(20),
    email character varying(40),
    id integer NOT NULL
);
    DROP TABLE public.contacto;
       public         heap    postgres    false            ?            1259    32904    contacto_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.contacto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.contacto_id_seq;
       public          postgres    false    210            (           0    0    contacto_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.contacto_id_seq OWNED BY public.contacto.id;
          public          postgres    false    214            ?            1259    24734    cuenta    TABLE     f   CREATE TABLE public.cuenta (
    numero bigint NOT NULL,
    saldo bigint,
    fecha_creacion date
);
    DROP TABLE public.cuenta;
       public         heap    postgres    false            ?            1259    24729    cuenta_persona    TABLE     q   CREATE TABLE public.cuenta_persona (
    persona_id bigint,
    numero_cuenta bigint,
    id integer NOT NULL
);
 "   DROP TABLE public.cuenta_persona;
       public         heap    postgres    false            ?            1259    32913    cuenta_persona_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.cuenta_persona_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.cuenta_persona_id_seq;
       public          postgres    false    211            )           0    0    cuenta_persona_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.cuenta_persona_id_seq OWNED BY public.cuenta_persona.id;
          public          postgres    false    215            ?            1259    24719    persona    TABLE     ?   CREATE TABLE public.persona (
    id bigint NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    edad integer NOT NULL
);
    DROP TABLE public.persona;
       public         heap    postgres    false            ?            1259    24762    transaccion    TABLE     ~   CREATE TABLE public.transaccion (
    numero_cuenta bigint,
    movimiento bigint,
    fecha date,
    id integer NOT NULL
);
    DROP TABLE public.transaccion;
       public         heap    postgres    false            ?            1259    32921    transaccion_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.transaccion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.transaccion_id_seq;
       public          postgres    false    213            *           0    0    transaccion_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.transaccion_id_seq OWNED BY public.transaccion.id;
          public          postgres    false    216            s           2604    32905    contacto id    DEFAULT     j   ALTER TABLE ONLY public.contacto ALTER COLUMN id SET DEFAULT nextval('public.contacto_id_seq'::regclass);
 :   ALTER TABLE public.contacto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    210            t           2604    32937    cuenta_persona id    DEFAULT     v   ALTER TABLE ONLY public.cuenta_persona ALTER COLUMN id SET DEFAULT nextval('public.cuenta_persona_id_seq'::regclass);
 @   ALTER TABLE public.cuenta_persona ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    211            u           2604    32922    transaccion id    DEFAULT     p   ALTER TABLE ONLY public.transaccion ALTER COLUMN id SET DEFAULT nextval('public.transaccion_id_seq'::regclass);
 =   ALTER TABLE public.transaccion ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    213            v           2604    33030 
   usuario id    DEFAULT     j   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public."Usuario_id_seq"'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218                      0    24724    contacto 
   TABLE DATA           C   COPY public.contacto (persona_id, telefono, email, id) FROM stdin;
    public          postgres    false    210   ?1                 0    24734    cuenta 
   TABLE DATA           ?   COPY public.cuenta (numero, saldo, fecha_creacion) FROM stdin;
    public          postgres    false    212   72                 0    24729    cuenta_persona 
   TABLE DATA           G   COPY public.cuenta_persona (persona_id, numero_cuenta, id) FROM stdin;
    public          postgres    false    211   ?2                 0    24719    persona 
   TABLE DATA           =   COPY public.persona (id, nombre, apellido, edad) FROM stdin;
    public          postgres    false    209   ?2                 0    24762    transaccion 
   TABLE DATA           K   COPY public.transaccion (numero_cuenta, movimiento, fecha, id) FROM stdin;
    public          postgres    false    213   G3                  0    33027    usuario 
   TABLE DATA           9   COPY public.usuario (id, username, password) FROM stdin;
    public          postgres    false    218   ?3       +           0    0    Usuario_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public."Usuario_id_seq"', 1, false);
          public          postgres    false    217            ,           0    0    contacto_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.contacto_id_seq', 36, true);
          public          postgres    false    214            -           0    0    cuenta_persona_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.cuenta_persona_id_seq', 5, true);
          public          postgres    false    215            .           0    0    transaccion_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.transaccion_id_seq', 9, true);
          public          postgres    false    216            {           2606    24746    contacto CONTACTO_email_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT "CONTACTO_email_key" UNIQUE (email);
 G   ALTER TABLE ONLY public.contacto DROP CONSTRAINT "CONTACTO_email_key";
       public            postgres    false    210            ?           2606    32973    cuenta CUENTA_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT "CUENTA_pkey" PRIMARY KEY (numero);
 >   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT "CUENTA_pkey";
       public            postgres    false    212            x           2606    33000    persona PERSONA_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT "PERSONA_pkey" PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.persona DROP CONSTRAINT "PERSONA_pkey";
       public            postgres    false    209            ?           2606    33032    usuario Usuario_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "Usuario_pkey";
       public            postgres    false    218            }           2606    32907    contacto contacto_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT contacto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.contacto DROP CONSTRAINT contacto_pkey;
       public            postgres    false    210                       2606    32939 "   cuenta_persona cuenta_persona_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.cuenta_persona
    ADD CONSTRAINT cuenta_persona_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.cuenta_persona DROP CONSTRAINT cuenta_persona_pkey;
       public            postgres    false    211            ?           2606    32924    transaccion transaccion_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT transaccion_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT transaccion_pkey;
       public            postgres    false    213            ?           1259    24773 	   idx_fecha    INDEX     B   CREATE INDEX idx_fecha ON public.transaccion USING btree (fecha);
    DROP INDEX public.idx_fecha;
       public            postgres    false    213            ?           1259    24772    idx_fecha_creacion    INDEX     O   CREATE INDEX idx_fecha_creacion ON public.cuenta USING btree (fecha_creacion);
 &   DROP INDEX public.idx_fecha_creacion;
       public            postgres    false    212            y           1259    24744    idx_nombre_apellido    INDEX     S   CREATE INDEX idx_nombre_apellido ON public.persona USING btree (nombre, apellido);
 '   DROP INDEX public.idx_nombre_apellido;
       public            postgres    false    209    209            ?           2606    32974    transaccion fk_numero_cuenta    FK CONSTRAINT     ?   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT fk_numero_cuenta FOREIGN KEY (numero_cuenta) REFERENCES public.cuenta(numero);
 F   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT fk_numero_cuenta;
       public          postgres    false    213    3201    212            ?           2606    32979    cuenta_persona fk_numero_cuenta    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cuenta_persona
    ADD CONSTRAINT fk_numero_cuenta FOREIGN KEY (numero_cuenta) REFERENCES public.cuenta(numero);
 I   ALTER TABLE ONLY public.cuenta_persona DROP CONSTRAINT fk_numero_cuenta;
       public          postgres    false    3201    211    212            ?           2606    33001    cuenta_persona fk_persona_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cuenta_persona
    ADD CONSTRAINT fk_persona_id FOREIGN KEY (persona_id) REFERENCES public.persona(id);
 F   ALTER TABLE ONLY public.cuenta_persona DROP CONSTRAINT fk_persona_id;
       public          postgres    false    209    211    3192            ?           2606    33006    contacto fk_persona_id    FK CONSTRAINT     z   ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT fk_persona_id FOREIGN KEY (persona_id) REFERENCES public.persona(id);
 @   ALTER TABLE ONLY public.contacto DROP CONSTRAINT fk_persona_id;
       public          postgres    false    210    209    3192               ?   x?U?1?0???D?[??;^?Ҙ"?Ė ??&?)F??F#?L?{%?<(???|]???a????`?`????H%??3??Ԝ	h??bҞ?*?fI?w~?}??yA?sN΂????<T?1DJ?O]S?s?>?y??E6g         G   x?e˱?0?X?Ō??v/?_?!ŗ?DAU?61???Hz*K)?l?NpU?ԁS/`?Կ?\??h         2   x?3?0552233?4???,?9M???-M̌?9?L??)W? ???         g   x??A?@ ???F@6??^?n?6?Z?_?0?IfhRe.??????c?Ad???iq???xBR?T?6[z?k??ٷ?SX???5]k?2?H?x???\q?         P   x?}???0?7?B???.??<*???{?mD?1?$T?????????jؘ'k??????NW??ʝ*??#??N~f^/?          b   x?3?LL+??I??O?4uH?M???K???T1JT14R15(???.0.Ov̫(M?̋?v,-6??rL??t?Jv???J??2??(q)?prr-?.?????? &?     