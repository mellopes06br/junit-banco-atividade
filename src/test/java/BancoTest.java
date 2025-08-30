import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Banco;

public class BancoTest {

    Banco b;

   @BeforeEach
    public void setUp(){
        b = new Banco("666", 1000);
    }

    //se você declara no before each a conta, ele ja fica criado para todos os testes, pra 
    //não ter que criar sempre um objeto novo  

    @Test
    public void saldoNovaContaTest (){
       //Banco b = new Banco("666", 1000);
        assertEquals(1000, b.getBalance());   // comparando o mil com o dinheiro da conta
    }
    
    @Test
    public void depositoValidoTest(){
       //Banco b = new Banco("666", 1000);
        b.deposit(500); 
        assertEquals(1500, b.getBalance());  //comparando o valor esperado com o resultado 
    }

    @Test
    public void depoistoInvalidoTest(){
    // Banco b = new Banco("666", 1000);
        b.deposit(-100);
        assertEquals(1000, b.getBalance());
    }

    @Test
    public void saqueValidotest(){
        boolean ret = b.withdraw(100);  
        assertTrue(ret);
        assertEquals(900, b.getBalance());
    }

    // é usado o assert true pra saber se foi permitido e o
    // equals é para saber se o saque funcionou.
}
