package interfaces;

import java.util.ArrayList;

import entidades.Cliente;

public interface IDaoCliente {
	
	public ArrayList<Cliente> listar();
	
	public int agregarCliente(Cliente cliente);
}
