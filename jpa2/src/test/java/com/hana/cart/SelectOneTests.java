package com.hana.cart;

import com.hana.app.data.entity.CartEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.service.CartService;
import com.hana.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class SelectOneTests {
    @Autowired
    CustService service;
    @Autowired
    CartService cartService;

    @Test
    void contextLoads() {
        // id wonpil의 장바구니(들) 출력
        Optional<CustEntity> op = service.get("wonpil");
        if (op.isPresent()) {
            CustEntity cust = op.get();
            log.info(cust.toString());
            cartService.findByCustId(cust.getId()).forEach(c -> log.info(c.toString()));
        }
    }
}
