package com.hugodev.com.microservico.consumidorestoque.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.librabbitmq.constantes.RabbitmqConstantes;
import org.librabbitmq.dto.EstoqueDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EstoqueConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
    private void consumidor(Message mensagem){

        try {
            EstoqueDto estoqueDTO = this.objectMapper.readValue(mensagem.getPayload().toString(),EstoqueDto.class);
            System.out.println(estoqueDTO.getCodigoProduto());
            System.out.println(estoqueDTO.getQuantidade());
            System.out.println("--------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
