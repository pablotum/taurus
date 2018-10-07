insert into usuario (id_usuario, usuario, clave, nombre, apellido, correo) values (1, 'ptum', '123', 'Pablo', 'Tum', 'pablo.tum@gmail.com');
insert into usuario (id_usuario, usuario, clave, nombre, apellido, correo) values (2, 'ptum2', '123', 'Pablo', 'Tum', 'pablo.tum@gmail.com');

insert into pais (id_pais, pais, codigo) values (1, 'Perú', 'PE');
insert into pais (id_pais, pais, codigo) values (2, 'Guatemala', 'GT');
insert into pais (id_pais, pais, codigo) values (3, 'Estados Unidos', 'US');

insert into tipo_empresa (id_tipo_empresa, tipo_empresa) values (1, 'Juridica');

insert into moneda (id_moneda, moneda,simbolo, principal) values (1, 'Dolar','US$', true);
insert into moneda (id_moneda, moneda,simbolo, principal) values (2, 'Sol','S/', false);

insert into uso_cuenta(id_uso_cuenta, uso_cuenta) values (1, 'Consolidar');
insert into uso_cuenta(id_uso_cuenta, uso_cuenta) values (2, 'Operar');

insert into banco(id_banco, nombre, direccion, ciudad, id_pais, swift, aba) values (1, 'SCOTIABANK', 'AV. 28 DE JULIO # 623', 'LIMA', 1, 'BSUDPEPL', '009-210-000004393881-60');
insert into banco(id_banco, nombre, id_pais) values (2, 'CitiBank', 3);

insert into clasificacion_cuenta(id_clasificacion_cuenta, clasificacion_cuenta) values (1,'Caja');
insert into clasificacion_cuenta(id_clasificacion_cuenta, clasificacion_cuenta) values (2,'Cuentas por cobrar');
insert into clasificacion_cuenta(id_clasificacion_cuenta, clasificacion_cuenta) values (3,'Inventario');
insert into clasificacion_cuenta(id_clasificacion_cuenta, clasificacion_cuenta) values (4,'Activos fijos');

insert into flujo_cuenta(id_flujo_cuenta, flujo_cuenta) values (1, 'Efectivo');
insert into flujo_cuenta(id_flujo_cuenta, flujo_cuenta) values (2, 'Operacion');
insert into flujo_cuenta(id_flujo_cuenta, flujo_cuenta) values (3, 'Inversion');
insert into flujo_cuenta(id_flujo_cuenta, flujo_cuenta) values (4, 'Gastos no monetarios');

insert into cuenta_contable(id_cuenta_contable, cuenta_contable, descripcion, id_flujo_cuenta, id_uso_cuenta, id_clasificacion_cuenta) values (1,'001-0000', 'activos', 1, 1, 1);
insert into cuenta_contable(id_cuenta_contable, cuenta_contable, descripcion, id_flujo_cuenta, id_uso_cuenta, id_clasificacion_cuenta) values (2,'001-1000', 'caja', 1, 1, 1);
insert into cuenta_contable(id_cuenta_contable, cuenta_contable, descripcion, id_flujo_cuenta, id_uso_cuenta, id_clasificacion_cuenta) values (3,'001-2000', 'Cheques', 1, 1, 2);

insert into tipo_cuenta (id_tipo_cuenta,tipo_cuenta) values (1, 'Monetaria');
insert into tipo_cuenta (id_tipo_cuenta,tipo_cuenta) values (2, 'Ahorro');

insert into cuenta_bancaria (id_cuenta_bancaria, cuenta_bancaria, descripcion, estado, id_tipo_cuenta, id_banco, id_moneda) values (1, '4393881', 'Cuenta principal', true, 1, 1, 1);

insert into periodo (id_periodo, anio, descripcion, tasa) values (1,2018,'anio 2018', 1.12);
insert into periodo_detalle (id_periodo_detalle, id_periodo, descripcion, inicia, estado) values (1,1, 'detalle',now(),1);

insert into donante (id_donante, codigo, nombre) values (1,'001', 'Mama Cash');

insert into rubro (id_rubro, codigo, rubro) values (1,'001','Salarios de personal y cargos relacionados');
insert into rubro (id_rubro, codigo, rubro) values (2,'002','Dirección de apoyo a la población objetivo');
insert into rubro (id_rubro, codigo, rubro) values (3,'003','Consultores y otros servicios contratados');
insert into rubro (id_rubro, codigo, rubro) values (4,'004','Viajes y conferencias');


insert into convenio(id_convenio, codigo, nombre, id_donante, id_moneda, monto) values (1,'001', 'convenio 1', 1,2, 1000000);
insert into convenio(id_convenio, codigo, nombre, id_donante, id_moneda, monto) values (2,'002', 'convenio 1', 1,2, 1000000);
insert into convenio(id_convenio, codigo, nombre, id_donante, id_moneda, monto) values (3,'003', 'convenio 1', 1,2, 1000000);
insert into convenio(id_convenio, codigo, nombre, id_donante, id_moneda, monto) values (4,'004', 'convenio 1', 1,2, 1000000);
insert into convenio(id_convenio, codigo, nombre, id_donante, id_moneda, monto) values (5,'005', 'convenio 1', 1,2, 1000000);
insert into convenio(id_convenio, codigo, nombre, id_donante, id_moneda, monto) values (6,'006', 'convenio 1', 1,2, 1000000);
insert into convenio_actividad (id_convenio_actividad, id_convenio, actividad, inicio, fin, fecha, estado) values (1, 1, 'prueba', now(), now(), now(), 1);
insert into convenio_archivo( id_convenio_archivo, id_convenio, nombre) values (1,1,'prueba');
insert into convenio_rubro(id_convenio_rubro, id_convenio, id_rubro , descripcion, monto) values (1,1,1,'salarios',1000);

insert into empresa (id_empresa, nombre, razon, codigo, nit, direccion, estado, id_pais, id_tipo_empresa) values (1, 'FIMI', 'FIMI', '001', '234', 'Guatemala, guatemala', true, 1, 1);


insert into sexo (id_sexo, codigo, sexo) values (1, 'H', 'Hombre');
insert into sexo (id_sexo, codigo, sexo) values (2, 'M', 'Mujer');

insert into estado_civil (id_estado_civil, estado_civil, codigo) values (1, 'Soltero/a', 'S');
insert into estado_civil (id_estado_civil, estado_civil, codigo) values (2, 'Casado/a', 'C');

insert into profesion (id_profesion, codigo, profesion) values (1, '001', 'Auditor');
insert into profesion (id_profesion, codigo, profesion) values (2, '002', 'Ingeniero en Sistemas');


