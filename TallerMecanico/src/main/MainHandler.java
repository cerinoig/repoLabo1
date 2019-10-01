package main;

import java.sql.SQLException;

import entidades.Producto;
import entidades.Usuario;
import excepciones.ExistingUserException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingProductException;
import excepciones.NonExistingUserException;
import servicios.ProductoBusinessObject;
import servicios.ProductoBusinessObjectImpl;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;
import utils.Dentre;

public class MainHandler {

	private static UsuarioBusinessObject usuarioBusinessObject = new UsuarioBusinessObjectImpl();
	private static ProductoBusinessObject productoBusinessObject = new ProductoBusinessObjectImpl();

	private static Producto producto = new Producto();
	private static Usuario usuario = new Usuario();

	public static void main(String[] args) {
//		deleteProducto(); //VER PORQUE NO ELIMINA
//		altaUsuario();
//		deleteUsuario();//VER PORQUE NO ELIMINA
//		consultaUsuario();
	}

	public static void deleteProducto() {
		try {
			System.out.println("---------------");
			System.out.println("BAJA DE PRODUCTO");
			System.out.println("---------------");
			productoBusinessObject.deleteProducto(Dentre.entero("Ingrese el código del producto que desea eliminar"));

			System.out.println("El próducto fue eliminado con exito");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NonExistingProductException e) {
			System.out.println("El producto que desea eliminar no existe");
		}
	}

	public static void consultaProducto() {
		try {
			producto = productoBusinessObject.selectProducto(Dentre.entero("Ingrese el codigo del producto que quiere buscar"));
			System.out.println(producto.toString());
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (NonExistingProductException e) {
			System.out.println("El producto que esta buscando no existe");
		}
	}

	public static void altaProducto() {
//		try {
//			System.out.println("---------------");
//			System.out.println("ALTA DE USUARIO");
//			System.out.println("---------------");
//			producto.setCodigoProducto(Dentre.entero("Ingrese el codigo del producto"));
//			producto.setDescripcion(Dentre.texto("Ingrese la descriptcion del producto"));
//			producto.setCantidad(Dentre.entero("Ingrese la cantiodad de unidades disponibles"));
//			producto.setPrecioUnitario(Dentre.doble("Ingrese el precio del producto"));
//
//			productoService.insertProducto(producto);
//			
//			System.out.println("El producto fue dado de alta con exito");
//
//		} catch (SQLException sqle) {
//			System.out.println(sqle);
//		} catch (ExistingUserException e) {
//			System.out.println("El producto ingresado ya existe");
//		}
	}

	public static void altaUsuario() {
		try {
			Usuario usuario = new Usuario();
			System.out.println("---------------");
			System.out.println("ALTA DE USUARIO");
			System.out.println("---------------");
			usuario.setUsuario(Dentre.texto("Ingrese el nombre de usuario"));
			usuario.setPassword(Dentre.texto("Ingrese la contraseña"));

			usuarioBusinessObject.insertUsuario(usuario);

			System.out.println("El usuario fue dado de alta con exito");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println(sqle);
		} catch (ExistingUserException e) {
			System.out.println("El usuario ingresado ya existe");
		} catch (NoIdObtainedException e) {
			System.out.println("Error al crear el usuario, no se pudo obntener el ID.");
			e.printStackTrace();
		}
	}

	public static void deleteUsuario() {
		try {
			System.out.println("---------------");
			System.out.println("BAJA DE USUARIO	");
			System.out.println("---------------");
			usuarioBusinessObject.deleteUsuario(Dentre.texto("Ingrese el usuario que desea eliminar"));

			System.out.println("El usuario fue eliminado con exito");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NonExistingUserException e) {
			System.out.println("El usuario que desea eliminar no existe");
		}
	}

	public static void consultaUsuario() {
		try {
			usuario = usuarioBusinessObject.selectUsuario(Dentre.texto("Ingrese el usuario que quiere buscar"));
			System.out.println(usuario.toString());
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (NonExistingUserException e) {
			System.out.println("El usuario que esta buscando no existe");
		}
	}

}
