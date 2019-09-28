package main;

import java.sql.SQLException;

import entidades.Producto;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NonExistingUserException;
import servicios.ProductoService;
import servicios.ProductoServiceImpl;
import servicios.UsuarioService;
import servicios.UsuarioServiceImpl;
import utils.Dentre;

public class Main {

	private static UsuarioService usuarioService = new UsuarioServiceImpl();
	private static ProductoService productoService = new ProductoServiceImpl();
	
	private static Producto producto = new Producto();

	public static void main(String[] args) {
		deleteProducto(); //VER PORQUE NO ANDA
	}
	
	public static void deleteProducto() {
		try {
			System.out.println("---------------");
			System.out.println("BAJA DE PRODUCTO");
			System.out.println("---------------");
			productoService.deleteProducto(Dentre.entero("Ingrese el código del producto que desea eliminar"));
			
			System.out.println("El próducto fue eliminado con exito");
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(NonExistingUserException e) {
			System.out.println("El producto que desea eliminar no existe");
		}
	}
	
	public static void consultaProducto() {
		try {
			producto = productoService.selectProducto(Dentre.entero("Ingrese el codigo del producto que quiere buscar"));
			System.out.println(producto.toString());
		}catch(SQLException sqle) {
			System.out.println(sqle);
		}catch(NonExistingUserException e) {
			System.out.println("El producto que esta buscando no existe");
		}
	}

	public static void altaProducto() {
		try {
			System.out.println("---------------");
			System.out.println("ALTA DE USUARIO");
			System.out.println("---------------");
			producto.setCodigoProducto(Dentre.entero("Ingrese el codigo del producto"));
			producto.setDescripcion(Dentre.texto("Ingrese la descriptcion del producto"));
			producto.setCantidad(Dentre.entero("Ingrese la cantiodad de unidades disponibles"));
			producto.setPrecioUnitario(Dentre.doble("Ingrese el precio del producto"));

			productoService.insertProducto(producto);
			
			System.out.println("El producto fue dado de alta con exito");

		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (ExistingUserException e) {
			System.out.println("El producto ingresado ya existe");
		}
	}

	public static void altaUsuario() {
		try {
			Usuario usuario = new Usuario();
			System.out.println("---------------");
			System.out.println("ALTA DE USUARIO");
			System.out.println("---------------");
			usuario.setUsuario(Dentre.texto("Ingrese el nombre de usuario"));
			usuario.setPassword(Dentre.texto("Ingrese la contraseña"));

			usuarioService.insertUsuario(usuario);

			System.out.println("El usuario fue dado de alta con exito");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println(sqle);
		} catch (ExistingUserException e) {
			System.out.println("El usuario ingresado ya existe");
		}
	}

}
