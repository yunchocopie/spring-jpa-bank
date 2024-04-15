package com.example.bank.history;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class HistoryRepositoryTest {
    @Autowired
    private HistoryRepository historyRepository;

    private ObjectMapper om;

    @BeforeEach // 모든 테스트 메서드가 실행되기 직전마다 실행됨.
    public void setUp(){
        om = new ObjectMapper();
        // 빈 객체가 있어도 json 변환할 때 오류 안나게 도와줌
        om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    @Test
    public void findBySenderOrReceiver_test() throws JsonProcessingException {
        // given
        int number = 1111;

        // when
        List<History> historyList =
                historyRepository.findBySenderOrReceiver(number);

        // eye
        String respBody = om.writeValueAsString(historyList);
        System.out.println(respBody);


        // then
    }
}