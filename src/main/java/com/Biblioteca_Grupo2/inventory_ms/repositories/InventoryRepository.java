package com.Biblioteca_Grupo2.inventory_ms.repositories;

import com.Biblioteca_Grupo2.inventory_ms.models.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    /*Inventory delete(String idbook);*/
}
