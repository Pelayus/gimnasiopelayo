package com.gimnasio.gimnasiopelayo.servicios;

import com.gimnasio.gimnasiopelayo.modelo.Cliente;

import java.util.List;

public interface ServicioCliente {
    public List<Cliente> listarClientes();

    public Cliente bucarClientePorId(int idCliente);

    public void guardarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

    public List<Cliente> buscarPorDni(String dni);
}

