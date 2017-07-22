package org.frameworkset.plugin.kafka;

public class TestKafkaProducer {

	public static void main(String[]args){
		KafkaProductor productor = KafkaUtil.getKafkaProductor("kafkaproductor");
		productor.send("blackcat",//kafka topic
				1l, //message key
				"aaa");//message
		productor.send("blackcat", //kafka topic
				"bbb"); //message
	}
}
