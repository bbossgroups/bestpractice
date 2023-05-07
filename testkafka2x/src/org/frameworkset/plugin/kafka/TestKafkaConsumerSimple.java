package org.frameworkset.plugin.kafka;

public class TestKafkaConsumerSimple {

	public static void main(String[] args) {

        //启动ioc配置对应的容器中管理的kafka消费程序，自动注册消费程序销毁hook，以便在jvm退出时自动关闭消费程序
		KafkaConsumersStarter.startConsumers("kafka_2.12-2.3.0/kafkaconfumersimple.xml");

        //启动ioc配置对应的容器中管理的kafka消费程序，通过addShutdownHook控制是否注册消费程序销毁hook，以便在jvm退出时自动关闭消费程序 true 注册，false不注册
        //false 情况下需要手动调用shutdownConsumers(String applicationContextIOC)方法或者shutdownAllConsumers()方法销毁对应的消费程序
//        KafkaConsumersStarter.startConsumers("kafka_2.12-2.3.0/kafkaconfumersimple.xml",false);

        //手动销毁ioc配置对应的容器中管理的kafka消费程序
//        KafkaConsumersStarter.shutdownConsumers("kafka_2.12-2.3.0/kafkaconfumersimple.xml");


        //手动销毁所有容器中管理的kafka消费程序
//        KafkaConsumersStarter.shutdownAllConsumers();

        KafkaUtil kafkaUtil = new KafkaUtil("kafka_2.12-2.3.0/kafkaconfumersimple.xml");
        BaseKafkaConsumer kafkaConsumer = kafkaUtil.getKafkaConsumer("kafkabatchconsumerstore");
        //增加给定数量的消费线程
        kafkaConsumer.increamentConsumerThead(2);
        //消减给定数量的消费线程
        kafkaConsumer.decreamentConsumerThead(2);

	}

}
