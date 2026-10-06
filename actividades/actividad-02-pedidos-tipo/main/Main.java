package main;
import controlador.*;
import modelo.*;
import vista.*;
public class Main
{
	public static void main(String[] args)
	{
		// CREA EL MODELO, LA VISTA Y EL CONTROLADOR
		PedidoModelo modelo = new PedidoModelo();
		PedidoVista vista = new PedidoVista();
		PedidoControlador controlador = new PedidoControlador(modelo, vista);
		// INICIA EL PROGRAMA
		controlador.iniciar();
	}
}
