package br.com.luisurnau.n2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luisurnau.n2.model.Character;
import br.com.luisurnau.n2.model.dto.CharacterDTO;
import br.com.luisurnau.n2.repository.CharacterRepository;
import br.com.luisurnau.n2.util.CharacterMapping;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO insertOrUpdate(CharacterDTO character) {
        var result = characterRepository.save(CharacterMapping.toCharacter(character));
        return CharacterMapping.fromCharacter(result);
    }

    public List<CharacterDTO> findAll() {
        return characterRepository.findAll().stream().map(character -> CharacterMapping.fromCharacter(character)).collect(Collectors.toList());
    }

    public CharacterDTO findById(int id) {
        var result = characterRepository.findById(id);

        if (result.isPresent())
            return CharacterMapping.fromCharacter(result.get());
        else
            return new CharacterDTO();
    }

    public boolean delete(int id) {
        var result = characterRepository.findById(id);
        if(result.isPresent()){
            characterRepository.deleteById(id);
            result = characterRepository.findById(id);
            return result.isEmpty();
        }
        else
            return false;
    }

}