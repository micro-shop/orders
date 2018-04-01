package cz.microshop.order.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xnovm on 01.04.2018.
 */
@Configuration
public class RabbitConfiguration {

    public static final String RABBIT_QUEUE = "rabbit-foo";

    @Bean
    Queue queue() {
        return new Queue(RABBIT_QUEUE, false);
    }


/*    @Bean
    public Exchange exchange() {
        return new FanoutExchange(RABBIT_THIRD_RABBIT_EXCHANGE);
    }

    @Bean
    public List<Binding> bind() {
        return Arrays.asList(
                new Binding(THIRD_RABBIT_QUEUE, DestinationType.QUEUE, RABBIT_THIRD_RABBIT_EXCHANGE, FANOUT_RK, null),
                new Binding(ANOTHER_RABBIT_QUEUE, DestinationType.QUEUE, RABBIT_THIRD_RABBIT_EXCHANGE, FANOUT_RK,
                        null));
    }*/

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    /*protected List<Queue> createQueueList(final String queueName) {
        return Arrays.asList(createQueue(queueName), createErrorQueue(queueName), createSkipQueue(queueName));
    }*/

    /*private Queue createQueue(final String queueName) {
        return new Queue(queueName.concat(QueueSuffixEnumeration.ERROR_SUFFIX.getSuffix()));
    }

    private Queue createErrorQueue(final String queueName) {
        return new Queue(queueName.concat(QueueSuffixEnumeration.ERROR_SUFFIX.getSuffix()));
    }

    private Queue createSkipQueue(final String queueName) {
        return new Queue(queueName.concat(QueueSuffixEnumeration.SKIP_SUFFIX.getSuffix()));
    }*/
}
