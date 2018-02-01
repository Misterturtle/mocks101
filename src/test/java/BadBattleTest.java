import Bad.Battle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BadBattleTest {

    Battle battle;

    @Before
    public void setup(){
        battle = new Battle();
    }


    @Test
    public void givenAPlayerWith10StrengthAndEnemyWith100HealthWhenExecutingAnAttackTheEnemysHealthShouldBe90(){
        battle.executeNextTurn("attack");

        Assert.assertEquals(90, battle.getEnemyHealth());
    }

    @Test
    public void givenAnEnemyWith10StrengthAndAPlayerWith100HealthWhenExecutingAnAttackThePlayersHealthShouldBe90(){
        //Has side effect
        battle.executeNextTurn("attack");

        battle.executeNextTurn("attack");

        Assert.assertEquals(90, battle.getPlayerHealth());
    }

    @Test
    public void givenAPlayerWith10StrengthAndEnemyWith70HealthWhenExecutingAnAttackTheEnemysHealthShouldBe60(){
        //YUCK!!!!

        //Player health: 100, enemy health:100
        battle.executeNextTurn("attack");

        //Player health: 100, enemy health:90
        battle.executeNextTurn("attack");

        //Player health: 90, enemy health:90
        battle.executeNextTurn("attack");

        //Player health: 90, enemy health:80
        battle.executeNextTurn("attack");

        //Player health: 80, enemy health:80
        battle.executeNextTurn("attack");

        //Player health: 80, enemy health:70
        battle.executeNextTurn("attack");


        //Finally to the state we want
        battle.executeNextTurn("attack");

        Assert.assertEquals(60, battle.getEnemyHealth());
    }

    @Test
    public void givenAnEnemyWith10StrengthAndAPlayerWith70HealthWhenExecutingAnAttackCommandThePlayersHealthShouldBe60(){
        //YUCK!!!



        //Player health: 100, enemy health:100
        battle.executeNextTurn("attack");

        //Player health: 100, enemy health:90
        battle.executeNextTurn("attack");

        //Player health: 90, enemy health:90
        battle.executeNextTurn("attack");

        //Player health: 90, enemy health:80
        battle.executeNextTurn("attack");

        //Player health: 80, enemy health:80
        battle.executeNextTurn("attack");

        //Player health: 80, enemy health:70
        battle.executeNextTurn("attack");

        //Player health: 70, enemy health:70
        battle.executeNextTurn("attack");


        //Finally to the state we want
        battle.executeNextTurn("attack");

        Assert.assertEquals(60, battle.getPlayerHealth());
    }


    @Test
    public void whenAPlayersHealthReaches0TheBattleShouldEnd(){
        //OMG I HATE MY JOB

        //Player health: 100, enemy health:100
        battle.executeNextTurn("attack");
        //Player health: 100, enemy health:90
        battle.executeNextTurn("attack");
        //Player health: 90, enemy health:90
        battle.executeNextTurn("attack");
        //Player health: 90, enemy health:80
        battle.executeNextTurn("attack");
        //Player health: 80, enemy health:80
        battle.executeNextTurn("attack");
        //Player health: 80, enemy health:70
        battle.executeNextTurn("attack");
        //Player health: 70, enemy health:70
        battle.executeNextTurn("attack");
        //Player health: 70, enemy health:60
        battle.executeNextTurn("attack");
        //Player health: 60, enemy health:60
        battle.executeNextTurn("attack");
        //Player health: 60, enemy health:50
        battle.executeNextTurn("attack");
        //Player health: 50, enemy health:50
        battle.executeNextTurn("attack");
        //Player health: 50, enemy health:40
        battle.executeNextTurn("attack");
        //Player health: 40, enemy health:40
        battle.executeNextTurn("attack");
        //Player health: 40, enemy health:30
        battle.executeNextTurn("attack");
        //Player health: 30, enemy health:30
        battle.executeNextTurn("attack");
        //Player health: 30, enemy health:20
        battle.executeNextTurn("attack");
        //Player health: 20, enemy health:20
        battle.executeNextTurn("attack");
        //Player health: 20, enemy health:10
        battle.executeNextTurn("attack");

        //PROBLEM! Enemy health would be 0 next player attack!
        //Have to be creative to set up the state

        //Enrage the player in order to not do damage
        battle.executeNextTurn("enrage");

        //Finally at the state we want
        //Player health: 10, enemy health:10
        battle.executeNextTurn("attack");

        Assert.assertEquals(false, battle.isBattleActive());
    }

    @Test
    public void whenAnEnemysHealthReaches0TheBattleShouldEnd(){
        //Again?..... UGH....

        //Player health: 100, enemy health:100
        battle.executeNextTurn("attack");
        //Player health: 100, enemy health:90
        battle.executeNextTurn("attack");
        //Player health: 90, enemy health:90
        battle.executeNextTurn("attack");
        //Player health: 90, enemy health:80
        battle.executeNextTurn("attack");
        //Player health: 80, enemy health:80
        battle.executeNextTurn("attack");
        //Player health: 80, enemy health:70
        battle.executeNextTurn("attack");
        //Player health: 70, enemy health:70
        battle.executeNextTurn("attack");
        //Player health: 70, enemy health:60
        battle.executeNextTurn("attack");
        //Player health: 60, enemy health:60
        battle.executeNextTurn("attack");
        //Player health: 60, enemy health:50
        battle.executeNextTurn("attack");
        //Player health: 50, enemy health:50
        battle.executeNextTurn("attack");
        //Player health: 50, enemy health:40
        battle.executeNextTurn("attack");
        //Player health: 40, enemy health:40
        battle.executeNextTurn("attack");
        //Player health: 40, enemy health:30
        battle.executeNextTurn("attack");
        //Player health: 30, enemy health:30
        battle.executeNextTurn("attack");
        //Player health: 30, enemy health:20
        battle.executeNextTurn("attack");
        //Player health: 20, enemy health:20
        battle.executeNextTurn("attack");
        //Player health: 20, enemy health:10
        battle.executeNextTurn("attack");

        //Finally at the state we want
        //Player health: 10, enemy health:10
        battle.executeNextTurn("attack");

        Assert.assertEquals(false, battle.isBattleActive());
    }
}
