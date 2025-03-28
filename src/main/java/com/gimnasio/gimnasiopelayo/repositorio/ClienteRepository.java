package com.gimnasio.gimnasiopelayo.repositorio;

import com.gimnasio.gimnasiopelayo.modelo.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    @Query("SELECT e FROM Cliente e WHERE e.dni=:dni")
    List<Cliente> findByDni(String dni);
}
