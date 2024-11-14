package com.practica1;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practica1.entity.Categoria;
import com.practica1.entity.Cliente;
import com.practica1.entity.Local;
import com.practica1.entity.Trabajador;
import com.practica1.repository.ClienteRepository;
import com.practica1.repository.LocalRepository;
import com.practica1.repository.TrabajadorRepository;


@SpringBootApplication
public class Practica1Application implements CommandLineRunner {
	@Autowired
	private ClienteRepository clientesRepo; //imp encapsular con el private
	@Autowired
	private LocalRepository localRepo;
	@Autowired
	private TrabajadorRepository trabajadorRepo;
	public static void main(String[] args) {
		SpringApplication.run(Practica1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//System.out.println(buscarClientesVip());
		
		//buscarClientesVipvoid();
		//System.out.println(clientesRepo.findByCategoria(Categoria.VIP));
		//mayor20Vip();
		//betweenAforo();
		//buscarClienteId()
		//TrabajadoresQueTieneUnLocal();
		//trabajadorQueTrabajaLocal();

		//7 insertar usuario
	 	/* insertarCliente(new Cliente("pedrito", 
		"Lopez", "Castillo",  LocalDate.of(1990, 5, 15), "612345678", Categoria.VIP )); */

		//8 y 9 actualizar usuario
		//actualizarCliente();

		//deleteCliente();



	} 

	
/* 
	private List<Cliente> buscarClientesVip() {
		List<Cliente> listaClientes= clientesRepo.findByCategoria(Categoria.VIP);
		return  listaClientes;

	} */

	

	//1
	private void buscarClientesVipvoid() {
		System.out.println(clientesRepo.findByCategoria(Categoria.VIP));

	}

	//2
	private void mayor20Vip(){

		LocalDate fechaResta = LocalDate.now().minusYears(20);

		System.out.println(clientesRepo.findByFechaNacimientoBeforeAndCategoria(fechaResta,Categoria.VIP));
	}

	//3
	private void betweenAforo(){
		System.out.println(localRepo.findByAforoMaxBetween(20, 100));

	}
	//4
	private void buscarClienteId(){
		
		Optional<Cliente>clienteId = clientesRepo.findById(1);
		if (clienteId.isPresent()) {
			Cliente clienteExistente = clienteId.get();
			System.out.println(clienteExistente/* .getId() esto seria solo para que me muestre el id de los clientes en vez de toda la info*/ + " " + clienteExistente.getListaLocales());

			//para filtrar solo el nombre de los locales
			List<Local> listaLocales = clienteExistente.getListaLocales(); //guardando la info de los locates de donde estuvo el cliente
			for(Local elemento: listaLocales){
				System.out.println(elemento.getNombre());
			}
		}else{
			System.out.println("cliente con ese id no existe");
		}
	}


	//5
	private void TrabajadoresQueTieneUnLocal(){
		Local localNombre = localRepo.findByNombre("Bar Luna");

		if (localNombre != null) {
		System.out.println(localNombre + " " + localNombre.getListaTrabajadores());
			
		}else{
			System.out.println("local no encontrado");
		}
	}

	//6
	 private void trabajadorQueTrabajaLocal(){

		Trabajador trabajadorNombre = trabajadorRepo.findByNombre("Ana");
	
		if (trabajadorNombre != null) {
			
			System.out.println(trabajadorNombre + " " + trabajadorNombre.getIdLocal());

		}else{
			System.out.println("Trabajador no encontrado");
		}

	} 
	//7 crear cliente nuevos
	private void insertarCliente(Cliente pedrito){
	System.out.println(clientesRepo.save(pedrito));  
	}   


	//8 y 9
	private void actualizarCliente() {
		Optional<Cliente>clienteId = clientesRepo.findById(6);
		if (clienteId.isPresent()) {
			Cliente clienteExistente = clienteId.get();
			clienteExistente.setNombre("Ricolinho");
			clienteExistente.setApellido1("Pequeninho");
			System.out.println(clientesRepo.save(clienteExistente) + " cliente actualizado");
		}else{
			System.out.println("No existe un cliente con ese ID");
		}	
	}	

	//10
	private void deleteCliente(){
		Cliente apellidoUnoCliente = clientesRepo.findByApellido1("Pequeninho");

		if (apellidoUnoCliente != null) {
			clientesRepo.delete(apellidoUnoCliente);
			System.out.println("Cliente borrado con exito");
				
			}else{
				System.out.println("Error 404 Not Found");
			}
		}

	}



















