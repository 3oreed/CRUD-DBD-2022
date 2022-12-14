create table if not exists Cliente(
	id_cliente serial primary key,
	nombre varchar(100),
	apellido varchar(100),
    clave varchar(100),
	email varchar(100),
	direccion varchar(100),
	fecha_nacimiento date,
	edad int GENERATED ALWAYS AS (2022 - date_part('year', fecha_nacimiento)) stored	
);

create table if not exists Administrador(
	id_admin serial primary key,
	clave varchar(100),
	email varchar(100),
	nombre varchar(100),
	apellido varchar(100)
);

create table if not exists Ranking(
	id_ranking serial primary key,
	nombre_empresa varchar(100),
	lugar int
);

create table if not exists Empresa(
	id_empresa serial primary key,
	nombre_empresa varchar(100),
	clave varchar(100),
	mail varchar(100),
	direccion text,
	id_ranking int,
	foreign key(id_ranking) references Ranking(id_ranking)
);

create table if not exists Tienda(
	id_tienda serial primary key,
	nombre varchar(100),
	edad_minima int,
	ciudad varchar(100),
	tipo_empresa varchar(100),
	id_empresa int,
	foreign key(id_empresa) references Empresa(id_empresa)
);

create table if not exists Cliente_Tienda(
	id_cliente_tienda serial primary key,
	id_cliente int,
	id_tienda int,
	edad_minima int,
	foreign key(id_cliente) references Cliente(id_cliente),
	foreign key(id_tienda) references Tienda(id_tienda)
);

create table if not exists Tienda_Admin(
	id_tienda_admin serial primary key,
	id_admin int,
	id_tienda int,
	foreign key(id_admin) references Administrador(id_admin),
	foreign key(id_tienda) references Tienda(id_tienda)
	
);

create table if not exists Empresa_administrador(
	id_empresa_administrador serial primary key,
	id_empresa int,
	id_administrador int,
	foreign key(id_empresa) references Empresa(id_empresa),
	foreign key(id_administrador) references Administrador(id_admin)
	
);

create table if not exists Valoracion(
	id_valoracion serial primary key,
	puntuacion int,
	opinion varchar (500),
	favoritos bool,
	id_cliente int,
	id_empresa int,
	foreign key(id_cliente) references Cliente(id_cliente),
	foreign key(id_empresa) references Empresa(id_empresa)
);

create table if not exists Categoria(
	id_categoria serial primary key,
	nombre varchar(100),
	descripcion text,
	id_tienda int,
	foreign key(id_tienda) references Tienda(id_tienda)
);

create table if not exists Administrador_Categoria_Empresa(
	id_admin_categoria_empresa serial primary key,
	id_admin int,
	id_categoria int,
	foreign key(id_admin) references Administrador(id_admin),
	foreign key(id_categoria) references Categoria(id_categoria)
);

create table if not exists ProductoCategoria(
	id_prod serial primary key,
	nombre varchar(100),
	descripcion text,
	precio int,
	stock_inicial int,
	stock_actual int,
	vendidos int generated always as (stock_inicial-stock_actual) stored,
	id_empresa int,
	id_categoria int,
	foreign key(id_empresa) references Empresa(id_empresa),
	foreign key(id_categoria) references Categoria(id_categoria)

);

create table if not exists Carrito(
	id_carrito serial primary key,
	cantidad_productos int,
	total int
);

create table if not exists ProductoCarrito(
	id_item_carrito serial primary key,
	nombre varchar(100),
	cantidad int,
	comentario text,
	precio int,
	subtotal int generated always as (cantidad * precio) stored,
	id_carrito int,
	id_prod int,
	foreign key(id_carrito) references Carrito(id_carrito),
	foreign key(id_prod) references ProductoCategoria(id_prod)

);

create table if not exists Carrito_ProductoCarrito(
	id_carrito_ProductoCarrito serial primary key,
	id_item_carrito int,
	id_carrito int,
	foreign key(id_item_carrito) references ProductoCarrito(id_item_carrito),
	foreign key(id_carrito) references Carrito(id_carrito)

);

create table if not exists Oferta(
	id_oferta serial primary key,
	Descripcion text,
	stock_oferta int,
	fecha_inicio date,
	fecha_final date,
	id_prod int,
	foreign key(id_prod) references ProductoCategoria(id_prod)

);

create table if not exists Cliente_ProductoCategoria(
	Cliente_ProductoCategoria serial primary key,
	id_cliente int,
	id_prod int,
	foreign key(id_cliente) references Cliente(id_cliente),
	foreign key(id_prod) references ProductoCategoria(id_prod)
	
);

create table if not exists Metodo_de_pago(
	id_tipopago serial primary key,
	nombre_metodo varchar(100)
);

create table if not exists Pago(
	id_pago serial primary key,
	monto money,
	id_tipopago int,
	id_empresa int,
	foreign key(id_tipopago) references Metodo_de_pago(id_tipopago),
	foreign key(id_empresa) references Empresa(id_empresa)

	
);

create table if not exists Boleta(
	id_boleta serial primary key,
	id_pago int,
	detalle_compra text,
	foreign key(id_pago) references Pago(id_pago)
);

create table if not exists Pedido(
	id_pedido serial primary key,
	subtotal money,
	tipo_entrega varchar(100),
	ubicacion varchar(100),
	id_pago int,
	id_cliente int,
	foreign key(id_pago) references Pago(id_pago),
	foreign key(id_cliente) references Cliente(id_cliente)

);

