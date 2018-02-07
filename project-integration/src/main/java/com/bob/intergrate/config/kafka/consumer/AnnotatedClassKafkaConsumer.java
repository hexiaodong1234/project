/**
 * Copyright(C) 2017 MassBot Co. Ltd. All rights reserved.
 *
 */
package com.bob.intergrate.config.kafka.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;

import com.bob.intergrate.config.kafka.constant.KafkaContextConstant;
import com.bob.intergrate.config.kafka.entity.KafkaMessageEntity;

/**
 * @since 2017年7月1日 上午11:13:25
 * @version $Id$
 * @author JiangJibo
 *
 */
// @Component
@KafkaListener(group = "lanboal", topics = KafkaContextConstant.KAFKA_TOPIC)
public class AnnotatedClassKafkaConsumer {

	@KafkaHandler
	public void consume(Message<KafkaMessageEntity> message) {

	}

}