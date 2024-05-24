package com.hugodev.com.microservico.consumidorestoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.librabbitmq.constantes.RabbitmqConstantes;
import org.librabbitmq.dto.PrecoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class PrecoConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitmqConstantes.FILA_PRECO)
    public void consumidor(Message mensagem){

        try {
            PrecoDto precoDto =  this.objectMapper.readValue(mensagem.getPayload().toString(), PrecoDto.class);
            System.out.println(precoDto.codigoProduto);
            System.out.println(precoDto.preco);
            System.out.println("-------------------------------");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
