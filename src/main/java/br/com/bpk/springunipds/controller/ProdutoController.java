package br.com.bpk.springunipds.controller;

import br.com.bpk.springunipds.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class ProdutoController {

    private ArrayList<Produto> database;

    public ProdutoController() {
        database = new ArrayList<>() {{
            add(new Produto(1, "Computador", 1500.0));
            add(new Produto(2, "Mouse", 120.0));
            add(new Produto(3, "Monitor", 600.0));
            add(new Produto(4, "Teclado", 190.0));
        }};
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getProdutos() {
        return ResponseEntity.ok(database);
    }

    @GetMapping("/produtos/sort")
    public ResponseEntity<List<Produto>> getProdutosOrdenados(
            @RequestParam(defaultValue = "nome") String sortField,
            @RequestParam(defaultValue = "asc") String order) {

        if (!order.equals("asc") && !order.equals("desc")) {
            return ResponseEntity.badRequest().build();
        }

        Comparator<Produto> comparator;

        if (sortField.equals("preco")) {
            comparator = Comparator.comparing(Produto::getPreco);
        } else if (sortField.equals("nome")) {
            comparator = Comparator.comparing(Produto::getNome);
        } else {
            return ResponseEntity.badRequest().build();
        }

        if (order.equals("desc")) {
            comparator = comparator.reversed();
        }

        return ResponseEntity.ok(database.stream().sorted(comparator).toList());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable int id) {
        return database.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> addNewProduto(@RequestBody Produto p) {
        database.add(p);
        return ResponseEntity.status(201).body(p);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable int id, @RequestBody Produto p) {
        int posicao = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        if (posicao >= 0) {
            p.setId(id);
            database.set(posicao, p);
            return ResponseEntity.ok(p);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable int id) {
        int posicao = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        if (posicao >= 0) {
            Produto removido = database.get(posicao);
            database.remove(posicao);
            return ResponseEntity.ok(removido);
        }

        return ResponseEntity.notFound().build();
    }
}