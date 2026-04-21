package br.com.bpk.springunipds.controller;

import br.com.bpk.springunipds.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/produtos")
    public Produto getProduto() {
        Produto p = new Produto();
        p.setId(1);
        p.setNome("Produto 1");
        p.setPreco(10.0);
        return p;
    }

    @PostMapping("/produtos")
    public String addNewProduto(@RequestBody Produto p) {
        System.out.println("Produto recebido");
        System.out.println(p.getId()+"/"+p.getNome()+"/"+p.getPreco());
        return "ok";
    }
}
