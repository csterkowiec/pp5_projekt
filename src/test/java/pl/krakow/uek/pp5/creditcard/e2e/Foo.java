package pl.krakow.uek.pp5.creditcard.e2e;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.krakow.uek.pp5.creditcard.model.CreditCardFacade;
import pl.krakow.uek.pp5.creditcard.model.dto.CardBlanceDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class Foo {
    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    CreditCardFacade creditCardFacade;
    @LocalServerPort
    private int port;


    @Test
    public void itListCardBalances(){
        ResponseEntity re = restTemplate.getForEntity(getURL("/api/cards/balances"), CardBlanceDto[].class);

        assertThat(re.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private String getURL(String URI) {
        String url= String.format( "http://localhost:%s%s", port, URI);
        return url;
    }
}
