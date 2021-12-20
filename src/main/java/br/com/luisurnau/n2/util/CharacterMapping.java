package br.com.luisurnau.n2.util;

import br.com.luisurnau.n2.model.Character;
import br.com.luisurnau.n2.model.dto.CharacterDTO;

public class CharacterMapping {

    private CharacterMapping() {
    }

    public static CharacterDTO fromCharacter(Character character) {
        return new CharacterDTO(character.getId(), character.getName(), character.getElement(), character.getCity(), character.getWeapon());
    }

    public static Character toCharacter(CharacterDTO characterDTO) {
        return new Character(characterDTO.getId(), characterDTO.getName(), characterDTO.getElement(), characterDTO.getCity(), characterDTO.getWeapon());
    }
}