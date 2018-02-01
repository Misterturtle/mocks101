import Fake.Battle;
import Fake.FakeEnemy;
import Fake.FakePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FakeBattleTest {

    Battle battle;
    FakePlayer player;
    FakeEnemy enemy;


    @Before
    public void setup(){
        player = new FakePlayer();
        enemy = new FakeEnemy();
        battle = new Battle(player, enemy);
    }


    @Test
    public void givenAPlayerWith10StrengthAndEnemyWith100HealthWhenExecutingAnAttackTheEnemysHealthShouldBe90(){

        battle.executeNextTurn("attack");

        Assert.assertEquals(90, enemy.getHealth());
    }

    @Test
    public void givenAnEnemyWith10StrengthAndAPlayerWith100HealthWhenExecutingAnAttackThePlayersHealthShouldBe90(){
        //Has side effect
        battle.executeNextTurn("attack");

        battle.executeNextTurn("attack");

        Assert.assertEquals(90, player.getHealth());
    }

    @Test
    public void givenAPlayerWith10StrengthAndEnemyWith70HealthWhenExecutingAnAttackTheEnemysHealthShouldBe60(){
        //Ahhh, much better
        enemy.setHealth(70);

        battle.executeNextTurn("attack");

        Assert.assertEquals(60, enemy.getHealth());
    }

    @Test
    public void givenAnEnemyWith10StrengthAndAPlayerWith70HealthWhenExecutingAnAttackCommandThePlayersHealthShouldBe60(){
        //Ahhh, much better
        battle.executeNextTurn("attack");
        player.setHealth(70);

        battle.executeNextTurn("attack");

        Assert.assertEquals(60, player.getHealth());
    }


    @Test
    public void whenAPlayersHealthReaches0TheBattleShouldEnd(){
        //Ya know, my job isn't bad...
        battle.executeNextTurn("attack");
        player.setHealth(10);

        battle.executeNextTurn("attack");

        Assert.assertEquals(false, battle.isBattleActive());
    }

    @Test
    public void whenAnEnemysHealthReaches0TheBattleShouldEnd(){
        //Writing a repetitive test doesn't make me wanna curl up in a blanket and hide from the world anymore...
        enemy.setHealth(10);

        battle.executeNextTurn("attack");

        Assert.assertEquals(false, battle.isBattleActive());
    }
}
