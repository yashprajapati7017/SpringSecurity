package com.springsecurity.testing;

import com.springsecurity.testing.Server.LogicServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class serviceHandling {
    private int actualPrice;
    LogicServer logicServer = new LogicServer();

    @Test
    public void checkLogicServer(){

       actualPrice= logicServer.Per(1000,20);

       assertEquals(800,actualPrice);

    }

    @Test
    public void checkDiscount(){

        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        illegalArgumentException=assertThrows(IllegalArgumentException.class,
                () -> logicServer.Per(1000,120));

        assertEquals("Product discount must be between 0 and 100",illegalArgumentException.getMessage());

    }

}
