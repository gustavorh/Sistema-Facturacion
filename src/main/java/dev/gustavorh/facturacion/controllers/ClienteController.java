package dev.gustavorh.facturacion.controllers;

import dev.gustavorh.facturacion.models.dao.IClienteDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
