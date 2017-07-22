package org.frameworkset.plugin.kafka;

public class TestKafkaProducer {

	public static void main(String[]args){
		KafkaProductor productor = KafkaUtil.getKafkaProductor("kafkaproductor");
		productor.send("blackcat",1l,"aaa");
		productor.send("blackcat",2l,"bbb");
	}
}
