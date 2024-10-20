package dev.gustavorh.facturacion.controllers;

import dev.gustavorh.facturacion.models.entities.Cliente;
import dev.gustavorh.facturacion.models.services.IClienteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/clientes")
@SessionAttributes("cliente")
public class ClienteController {
    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("titulo", "Lista de clientes");
        model.addAttribute("clientes", clienteService.findAll());
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
    public String processCreate(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Crear cliente");
            return "crear";
        }
        clienteService.save(cliente);
        status.setComplete();
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("titulo", "Editar cliente");
        model.addAttribute("cliente", cliente);
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String processEdit(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Editar cliente");
            return "editar";
        }
        clienteService.save(cliente);
        status.setComplete();
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            clienteService.delete(id);
        }
        return "redirect:/clientes";
    }
}
