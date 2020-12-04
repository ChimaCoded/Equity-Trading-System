package com.alpha.client.Client.repo;

//import com.alpha.client.model.Client;
//import org.springframework.data.repository.CrudRepository;
//
//public interface ClientRepository extends CrudRepository<Client, Long> {
//}
//


import com.alpha.client.Client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long>{
List<Client> findByFirstName(String FirstName);
List<Client> findAll();
}