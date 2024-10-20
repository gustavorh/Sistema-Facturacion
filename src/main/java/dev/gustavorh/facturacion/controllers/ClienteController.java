package dev.gustavorh.facturacion.controllers;

import dev.gustavorh.facturacion.models.dao.IClienteDao;
import dev.gustavorh.facturacion.models.entities.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final IClienteDao clienteDao;

    public ClienteController(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("titulo", "Lista de clientes");
        model.addAttribute("clientes", clienteDao.findAll());
        return "clientes";
    }

    @GetMapping("/crear")
    public String create(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("titulo", "Crear cliente");
        model.addAttribute("cliente", cliente);
        return "crear";
    }

    @PostMapping("/crear")
    public String proccessCreate(Cliente cliente) {
        clienteDao.save(cliente);
        return "redirect:/clientes";
    }
}
