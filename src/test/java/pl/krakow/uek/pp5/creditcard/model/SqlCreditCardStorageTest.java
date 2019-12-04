package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SqlCreditCardStorageTest {

    public static final String CREDIT_CARD_NUMBER = "1234";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void itAllowToStoreCC(){
        SqlCreditCardStorage sqlCreditCardStorage = new SqlCreditCardStorage(jdbcTemplate);

        CreditCard creditCard = new CreditCard( "1234");
        creditCard.assignLimit;
        sqlCreditCardStorage.add(creditCard);

        CreditCard loaded = sqlCreditCardStorage.load("1234");

        assertThat(creditCard.getNumber()).isEqualTo(loaded.getNumber());
    }
}
