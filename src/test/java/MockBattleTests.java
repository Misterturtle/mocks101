import Mock.Battle;
import Mock.Entity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MockBattleTests {
    Battle battle;
    Entity player;
    Entity enemy;

    final int ALIVE = 1;
    final int ANY_STRENGTH = 0;

    @Before
    public void setup(){
        player = mock(Entity.class);
        enemy = mock(Entity.class);
        battle = new Battle(player, enemy);
    }


    @Test
    public void givenAPlayerWith10StrengthAttackingAnEnemyShouldDamageHimBy10(){
        when(player.getStrength()).thenReturn(10);
        when(enemy.getHealth()).thenReturn(ALIVE);
        battle.executeNextTurn("attack");


        verify(enemy).damage(10);
    }

    @Test
    public void givenAnEnemyWith10StrengthAttackingThePlayerShouldDamageHimBy10(){
        //State setup is a bit more extensive than fake, but more controlled and exact.
        skipPlayerTurn(battle);

        when(enemy.getStrength()).thenReturn(10);
        when(player.getHealth()).thenReturn(ALIVE);
        battle.executeNextTurn("attack");

        verify(player).damage(10);
    }

    @Test
    public void whenAnEnemysHealthReaches0TheBattleShouldEnd(){
        when(player.getStrength()).thenReturn(ANY_STRENGTH);
        when(enemy.getHealth()).thenReturn(0);

        battle.executeNextTurn("attack");

        Assert.assertEquals(false, battle.isBattleActive());
    }

    @Test
    public void whenAPlayersHealthReaches0TheBattleShouldEnd(){
        skipPlayerTurn(battle);

        when(enemy.getStrength()).thenReturn(ANY_STRENGTH);
        when(player.getHealth()).thenReturn(0);
        battle.executeNextTurn("attack");

        Assert.assertEquals(false, battle.isBattleActive());
    }


    private void skipPlayerTurn(Battle battle){
        when(player.getStrength()).thenReturn(ANY_STRENGTH);
        when(enemy.getHealth()).thenReturn(ALIVE);
        battle.executeNextTurn("attack");
    }
}
