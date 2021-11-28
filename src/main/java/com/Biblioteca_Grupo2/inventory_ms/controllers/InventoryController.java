package com.Biblioteca_Grupo2.inventory_ms.controllers;

import com.Biblioteca_Grupo2.inventory_ms.exceptions.InventoryNotFoundException;
import com.Biblioteca_Grupo2.inventory_ms.models.Inventory;
import com.Biblioteca_Grupo2.inventory_ms.repositories.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class InventoryController {
    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/book/{idbook}")
    Inventory getInventory(@PathVariable String idbook) {
        return inventoryRepository.findById(idbook)
                .orElseThrow(() -> new InventoryNotFoundException("No se encontró un libro con el idbook: " + idbook));
    }

    @PostMapping("/book")
    Inventory newInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }


    @GetMapping("/books")
    public List<Inventory> getAllBooks() {
        return inventoryRepository.findAll();
    }

    @PutMapping("/book/update/{idbook}")
    Inventory upDate(@PathVariable String idbook, @RequestBody Inventory inventory) {
        Inventory book = inventoryRepository.findById(idbook).orElse(null);

        if (book == null) {
            throw new InventoryNotFoundException("No se encontró una libro con el idbook: " + idbook);
        }

        book.setTitle((inventory.getTitle()== null)? book.getTitle(): inventory.getTitle());
        book.setAuthor((inventory.getAuthor()== null)? book.getAuthor(): inventory.getAuthor());
        book.setYear((inventory.getYear()== null)? book.getYear(): inventory.getYear());
        book.setCategory((inventory.getCategory()== null)? book.getCategory(): inventory.getCategory());
        book.setEditorial((inventory.getEditorial()== null)? book.getEditorial(): inventory.getEditorial());
        book.setStatus((inventory.getStatus()== null)? book.getStatus(): inventory.getStatus());
        book.setISBN((inventory.getISBN()== null)? book.getISBN(): inventory.getISBN());
        book.setPoster((inventory.getPoster()== null)? book.getPoster(): inventory.getPoster());
        book.setResume((inventory.getResume()== null)? book.getResume(): inventory.getResume());

        return inventoryRepository.save(book);
    }

    @DeleteMapping("/book/delete/{idbook}")
    public String delete(@PathVariable String idbook) {
        Inventory book = inventoryRepository.findById(idbook).orElse(null);

        if (book == null) {
            throw new InventoryNotFoundException("No se encontró una libro con el idbook: " + idbook);
        }
        inventoryRepository.deleteById(idbook);

        return "Se ha eliminado el libro con id:" + idbook;
    }
}
