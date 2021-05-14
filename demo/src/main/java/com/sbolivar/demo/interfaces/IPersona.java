package com.sbolivar.demo.interfaces;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sbolivar.demo.modelo.Persona;

@Repository //Esta anotación se utiliza en clases Java que acceden directamente a la base de datos
public interface IPersona extends CrudRepository<Persona, Integer>{

}
