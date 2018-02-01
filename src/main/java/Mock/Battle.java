package Mock;

public class Battle {

    private Entity sourceEntity;
    private Entity targetEntity;

    public Battle(Entity player, Entity enemy) {
        sourceEntity = player;
        targetEntity = enemy;
    }



    private boolean isBattleActive = true;


    public boolean isBattleActive() {
        return isBattleActive;
    }

    public void executeNextTurn(String command) {
        switch (command) {
            case "attack":
                targetEntity.damage(sourceEntity.getStrength());
                if (targetEntity.getHealth() > 0) {
                    endTurn();
                } else {
                    endBattle();
                }
                break;

            case "enrage":
                sourceEntity.enrage();
                endTurn();
                break;
        }
    }

    private void endTurn() {
        Entity origSource = sourceEntity;
        sourceEntity = targetEntity;
        targetEntity = origSource;
    }

    private void endBattle() {
        isBattleActive = false;
    }
}
