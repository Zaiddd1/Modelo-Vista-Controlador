<h1 align="center">🧩 Modelo, Vista, Controlador (MVC) en Java — Lenguajes de Programación III</h1>

<p align="center">
  <em>El patrón MVC aplicado a un sistema de pedidos de restaurante, un carrito de compras,
  un inventario y un combate entre jugador y enemigos.</em>
</p>

<p align="center">
  <img alt="Lenguaje" src="https://img.shields.io/badge/Java-8%2B-orange?logo=openjdk&logoColor=white">
  <img alt="Patrón" src="https://img.shields.io/badge/Patr%C3%B3n-MVC-blue">
  <img alt="Curso" src="https://img.shields.io/badge/Curso-LP%20III-6f42c1">
  <img alt="Sesión" src="https://img.shields.io/badge/Sesi%C3%B3n-06-brightgreen">
  <img alt="Estado" src="https://img.shields.io/badge/Compila-OK-success">
</p>

---

## 📌 Sobre este repositorio

Reúne el código de la **Sesión N.° 06** del curso **Lenguajes de Programación III**
(Escuela Profesional de Ingeniería de Sistemas — Universidad Católica de Santa María),
dedicada al patrón **Modelo–Vista–Controlador**:

- **Modelo:** los datos y las reglas del programa.
- **Vista:** lo que se muestra en consola y lo que se pide al usuario.
- **Controlador:** recibe las opciones del usuario y coordina el modelo con la vista.

Cada carpeta es un programa independiente. Todo el código **compila con JDK 21**.

---

## 🗂️ Estructura del repositorio

```
Modelo-Vista-Controlador/
├── actividades/
│   ├── actividad-01-pedidos/                 Pedidos de restaurante (agregar y mostrar)
│   ├── actividad-02-pedidos-tipo/            + tipo de plato, eliminar, actualizar, buscar y contar
│   └── actividad-03-pedidos-estado/          + estado completo/pendiente, filtros y contador
├── ejercicios/
│   ├── ejercicio-01-carrito-compras/         Carrito de compras
│   ├── ejercicio-02-inventario/              Gestión de inventario
│   └── ejercicio-03-jugador-enemigos/        Inventario + jugador, enemigos y combate
└── README.md
```

---

## 🍽️ Actividades — Sistema de pedidos

| # | Carpeta | Qué hace |
|---|---|---|
| 1 | [`actividad-01-pedidos`](actividades/actividad-01-pedidos) | `Pedido`, `PedidoModelo`, `PedidoVista`, `PedidoControlador` y `Main`: el usuario agrega pedidos y ve la lista. Incluye `salida-ejemplo.txt`. |
| 2 | [`actividad-02-pedidos-tipo`](actividades/actividad-02-pedidos-tipo) | Cada pedido tiene **nombre y tipo** (Entrada, Plato de fondo, Postre, Bebida). Se puede **eliminar**, **actualizar** el nombre, **buscar** por nombre o tipo y **contar** el total y por tipo. |
| 3 | [`actividad-03-pedidos-estado`](actividades/actividad-03-pedidos-estado) | Cada pedido tiene un **estado** (Pendiente, Completo o Eliminado). Se puede **marcar como completo**, **eliminar**, **mostrar por estado** (pendientes o completos), ver el **contador de pendientes** y el **historial** de pedidos completos y eliminados. Incluye `salida-ejemplo.txt`. |

> Las tres actividades usan los paquetes `modelo`, `vista`, `controlador` y `main`.

## 📝 Ejercicios

| # | Carpeta | Qué hace |
|---|---|---|
| 1 | [`ejercicio-01-carrito-compras`](ejercicios/ejercicio-01-carrito-compras) | Carrito de compras: agregar y listar productos, agregar o eliminar del carrito, aplicar descuentos, calcular envío, ver el historial y realizar la compra. |
| 2 | [`ejercicio-02-inventario`](ejercicios/ejercicio-02-inventario) | Inventario con `Item`: agregar, eliminar, ver, mostrar detalles, buscar y usar items. |
| 3 | [`ejercicio-03-jugador-enemigos`](ejercicios/ejercicio-03-jugador-enemigos) | Amplía el inventario con `Jugador`, `Enemigo`, `CombateModel`, `CombateView` y `CombateController`. El ataque depende del arma equipada y los enemigos actúan al azar. |

---

## ▶️ Cómo compilar y ejecutar

Necesitas un **JDK 8 o superior**. Cada carpeta se compila por separado.

Actividades (con paquetes):

```bash
cd actividades/actividad-03-pedidos-estado
javac -encoding UTF-8 -d out $(find . -name "*.java")
java -cp out main.Main
```

Ejercicios (paquete por defecto):

```bash
cd ejercicios/ejercicio-03-jugador-enemigos
javac -encoding UTF-8 -d out *.java
java -cp out Main
```

Los programas son **interactivos** (leen opciones desde la consola). Los archivos
`salida-ejemplo.txt` muestran una sesión de ejemplo; en el ejercicio 3 los enemigos actúan al azar,
por eso cada partida es distinta.

---

## 🧠 Conceptos cubiertos

`patrón MVC` · `separación de responsabilidades` · `Scanner` · `ArrayList` · `herencia y polimorfismo básicos` ·
`validación de datos` · `menús en consola`

---

<p align="center"><sub>
Material con fines educativos — Universidad Católica de Santa María · Ingeniería de Sistemas · Lenguajes de Programación III · Sesión N.° 06
</sub></p>
