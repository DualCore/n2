package br.com.luisurnau.n2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisurnau.n2.model.dto.CharacterDTO;
import br.com.luisurnau.n2.service.CharacterService;

@RestController
@RequestMapping("/personagens")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> insert(@RequestBody CharacterDTO characterDTO) {
        if (characterDTO != null) {
            var result = characterService.insertOrUpdate(characterDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new CharacterDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CharacterDTO(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<CharacterDTO> update(@RequestBody CharacterDTO characterDTO) {
        if (characterDTO != null) {
            var result = characterService.insertOrUpdate(characterDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new CharacterDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CharacterDTO(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> findAll() {
        var listOfCharacter = characterService.findAll();
        return new ResponseEntity<>(listOfCharacter, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CharacterDTO findById(@PathVariable int id) {
        return characterService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        var isSuccess = characterService.delete(id);
        if (isSuccess)
            return new ResponseEntity<>("Personagem removido com sucesso.", HttpStatus.OK);
        return new ResponseEntity<>("Não foi possível remover o personagem.", HttpStatus.NOT_FOUND);
    }
}