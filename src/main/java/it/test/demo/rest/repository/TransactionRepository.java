package it.test.demo.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.test.demo.rest.model.TransactionDb;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionDb, String> {
}
