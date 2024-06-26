package com.hana.custAddr;
import com.hana.app.data.entity.CartEntity;
import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.data.entity.ItemEntity;
import com.hana.app.repository.CustAddrRepository;
import com.hana.app.service.CartService;
import com.hana.app.service.CustAddrService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class InsertTests {
    @Autowired
    CustAddrService service;
    @Test
    void contextLoads() {
        CustEntity cust = CustEntity.builder()
                .id("wonpil")
                .build();
        CustAddrEntity custAddr = CustAddrEntity.builder()
                .cust(cust)
                .addr("인천시 원필이고향이구")
                .build();
        service.insert(custAddr);
        log.info("OK");
    }

}