/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.marco.FastFuriosFood1.api.controller;

import br.dev.marco.FastFuriosFood1.domain.model.Pedido;
import br.dev.marco.FastFuriosFood1.domain.repository.PedidoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dib
 */
@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    //get pedido
    @GetMapping ("/pedido")
    public ResponseEntity<Pedido> buscar(@PathVariable Long pedidoID) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoID);

        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();

        }
            }
}
