package com.gimnasio.gimnasiopelayo.servicios;

import com.gimnasio.gimnasiopelayo.modelo.Cliente;
import com.gimnasio.gimnasiopelayo.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ServicioClienteImpl implements ServicioCliente{

    @Autowired
    private ClienteRepository cliente_R;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) cliente_R.findAll();
    }

    @Override
    public Cliente bucarClientePorId(int idCliente) {
        return (cliente_R
                .findById(idCliente)
                .orElseThrow(() -> new NoSuchElementException("El cliente no existe")));
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        cliente_R.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        cliente_R.delete(cliente);
    }

    @Override
    public List<Cliente> buscarPorDni(String dni) {
        return cliente_R.findByDni(dni);
    }
}

