package Bad;

public class Battle {

    private Entity player = new Player();
    private Entity enemy = new Enemy();
    private Entity sourceEntity = player;
    private Entity targetEntity = enemy;
    private boolean isBattleActive = true;

    public boolean isBattleActive(){
        return isBattleActive;
    }

    public void executeNextTurn(String command){

        switch (command) {
            case "attack":
                targetEntity.damage(sourceEntity.getStrength());
                if(targetEntity.getHealth() > 0){
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

    public int getPlayerHealth(){
        return player.getHealth();
    }

    public int getEnemyHealth(){
        return enemy.getHealth();
    }

    private void endTurn(){
        final Entity origSource = sourceEntity;
        sourceEntity = targetEntity;
        targetEntity = origSource;
    }

    private void endBattle(){
        isBattleActive = false;
    }
}
