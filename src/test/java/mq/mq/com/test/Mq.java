package mq.mq.com.test;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Mq {

    @Test
    public void testMq() throws IOException, TimeoutException {

        String exchangeName = "exchangeName";
        String queueName = "queueName";
        String routingKey = "routingKey";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("user");
        factory.setPassword("123");
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        //创建一个交换器
        channel.exchangeDeclare(exchangeName, "direct", true);

        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind(queueName, exchangeName, routingKey);

        //发送消息
        channel.basicPublish(exchangeName, routingKey, null, "hello rabbitmq".getBytes());


        connection.addShutdownListener(new ShutdownListener() {
            @Override
            public void shutdownCompleted(ShutdownSignalException cause) {
                if (cause.isHardError()) {
                    //获取异常信息
                    Connection reference = (Connection) cause.getReference();

                    if (!cause.isInitiatedByApplication()) {
                        Method reason = cause.getReason();
                    }

                } else {
                    Connection reference = (Connection)cause.getReference();
                }
            }
        });


        channel.close();
        connection.close();
    }

    @Test
    public void consumer() throws IOException, TimeoutException {
        String exchangeName = "exchangeName";
        String queueName = "queueName";
        String routingKey = "routingKey";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("user");

        factory.setPassword("123");
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.basicQos(60);

        channel.basicConsume(queueName, false, "myConsumerTag", new DefaultConsumer(channel){
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                long deliveryTag = envelope.getDeliveryTag();
//                channel.basicAck(deliveryTag, false);
                //拒绝接收消息 false：rabbitmq会将消息移除， true：会重新将这条消息存入队列中
//                channel.basicReject(1, false);
                channel.basicNack(deliveryTag, true, true);
            }
        });


    }
}
