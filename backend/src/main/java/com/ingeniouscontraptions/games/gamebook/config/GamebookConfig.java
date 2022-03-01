package com.ingeniouscontraptions.games.gamebook.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ingeniouscontraptions.games.gamebook.domain.GoldPieces;
import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.book.EntryNumber;
import com.ingeniouscontraptions.games.gamebook.domain.book.Gamebook;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.AttackRoundState;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;
import com.ingeniouscontraptions.games.gamebook.web.AttackRoundStateSerializer;
import com.ingeniouscontraptions.games.gamebook.web.EncounterSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.mediatype.hal.CurieProvider;
import org.springframework.hateoas.mediatype.hal.DefaultCurieProvider;

@Configuration
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL_FORMS)
class GamebookConfig {

    @Bean
    Adventure adventure(Die die, Gamebook gamebook) {
        return Adventure.start(Hero.warrior(die), gamebook);
    }

    @Bean
    @Primary
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        SimpleModule module = new SimpleModule();
        module.addSerializer(new EncounterSerializer(Encounter.class));
        module.addSerializer(new AttackRoundStateSerializer(AttackRoundState.class));
        mapper.registerModule(module);
        return mapper;
    }

    @Bean
    CurieProvider curieProvider() {
        return new DefaultCurieProvider("gamebook",
                UriTemplate.of("https://blog.ingeniouscontraptions.com/gamebook/rels/{rel}"));
    }

}
