package com.kafkaStudy.ndj.global.handler;
// StockWebSocketHandler.java
import com.kafkaStudy.ndj.domain.stock.dao.Stock;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

@Component
public class StockWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<Stock> stockFlux = Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> new Stock("AAPL", generateRandomPrice()));

        return session.send(stockFlux.map(stock -> createWebSocketMessage(session, stock)));
    }

    private double generateRandomPrice() {
        // 간단한 랜덤 주식 가격 생성 로직
        return 100 + new Random().nextDouble() * 50;
    }

    private WebSocketMessage createWebSocketMessage(WebSocketSession session,Stock stock) {
        // 주식 데이터를 WebSocketMessage로 변환
        // 여기에서는 간단하게 텍스트로 변환하도록 합니다.
        return session.textMessage(String.format("%s: %.2f", stock.getSymbol(), stock.getPrice()));
    }
}
