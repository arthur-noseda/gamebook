package com.ingeniouscontraptions.games.gamebook.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.AttackRoundState;

import java.io.IOException;

public class AttackRoundStateSerializer extends StdSerializer<AttackRoundState> {

    public AttackRoundStateSerializer(Class<AttackRoundState> t) {
        super(t);
    }

    @Override
    public void serialize(AttackRoundState value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getMessage());
    }

}
