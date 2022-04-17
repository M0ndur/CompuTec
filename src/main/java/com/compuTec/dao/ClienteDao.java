
package com.compuTec.dao;

import com.compuTec.domain.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente,Long>{
    
}
