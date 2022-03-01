package com.ingeniouscontraptions.games.gamebook.domain.encounter;

import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.notNull;

import com.ingeniouscontraptions.games.gamebook.domain.AttackStrength;
import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;
import com.ingeniouscontraptions.games.gamebook.domain.commons.MathUtils;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import com.ingeniouscontraptions.games.gamebook.domain.die.RecordingDie;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome.HeroWound;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome.MonsterWound;

public class AttackRoundStarted extends AttackRoundStateAdapter {

    private final AttackRound attackRound;

    public AttackRoundStarted(AttackRound attackRound) {
        this.attackRound = notNull(attackRound, "attackRound");
    }

    @Override
    public boolean canRollAttackStrengths() {
        return true;
    }

    @Override
    public void rollAttackStrengths(Die die) {
        RecordingDie recordingDie = new RecordingDie(die);
        Monster monster = attackRound.getMonster();
        AttackStrength monsterAttackStrength = monster.attackRoll(recordingDie);
        // List<Integer> monsterDice = recordingDie.getRolls();
        recordingDie.reset();
        Hero hero = attackRound.getHero();
        AttackStrength heroAttackStrength = hero.attackRoll(recordingDie);
        // List<Integer> heroDice = recordingDie.getRolls();
        if (MathUtils.greaterThan(heroAttackStrength, monsterAttackStrength)) {
            attackRound.setState(new AttackStrengthsRolled(attackRound, new MonsterWound()));
        } else if (MathUtils.lessThan(heroAttackStrength, monsterAttackStrength)) {
            attackRound.setState(new AttackStrengthsRolled(attackRound, new HeroWound()));
        } else {
            attackRound.setState(new Draw());
        }
    }

    @Override
    public String getMessage() {
        return "The round has started.";
    }

}
