package com.ingeniouscontraptions.games.gamebook.web;

import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/adventures")
@CrossOrigin("http://localhost:8080")
public class AdventureController {

    @Autowired
    private Adventure adventure;

    @Autowired
    private Die die;

    @GetMapping(produces = MediaTypes.HAL_FORMS_JSON_VALUE)
    public EntityModel<AdventureRepresentation> getAdventure() {
        Link linkToSelf = linkTo(methodOn(AdventureController.class).getAdventure()).withSelfRel();
        return EntityModel.of(new AdventureRepresentation(adventure),
                linkToSelf.andAffordance(afford(methodOn(AdventureController.class).act(null))));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_FORMS_JSON_VALUE)
    @ResponseBody
    public EntityModel<AdventureRepresentation> act(@RequestBody Action action) {
        adventure.getActions().stream()
                .filter(a -> a.hashCode() == action.getHash())
                .findFirst()
                .ifPresent(a -> a.resolve(adventure, die));
        return getAdventure();
    }

}
