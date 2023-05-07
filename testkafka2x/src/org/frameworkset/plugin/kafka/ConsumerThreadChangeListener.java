package org.frameworkset.plugin.kafka;
/**
 * Copyright 2020 bboss
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.frameworkset.apollo.PropertiesChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * <p>Description: kafka消费线程数量变化监听器

 * </p>
 * <p></p>
 * <p>Copyright (c) 2020</p>
 * @Date 2020/8/9 23:10
 * @author biaoping.yin
 * @version 1.0
 */
public class ConsumerThreadChangeListener extends PropertiesChangeListener {
	private static Logger logger = LoggerFactory.getLogger(ConsumerThreadChangeListener.class);

	/**
	 * //模拟被动获取监听地址清单
	 * List<HttpHost> hosts = new ArrayList<HttpHost>();
	 * // https服务必须带https://协议头,例如https://192.168.137.1:808
	 * HttpHost host = new HttpHost("192.168.137.1:808");
	 * hosts.add(host);
	 *
	 *    host = new HttpHost("192.168.137.1:809");
	 *    hosts.add(host);
	 *
	 * host = new HttpHost("192.168.137.1:810");
	 * hosts.add(host);
	 * //将被动获取到的地址清单加入服务地址组report中
	 * HttpProxyUtil.handleDiscoverHosts("schedule",hosts);
	 */
	public void onChange(ConfigChangeEvent changeEvent) {
		if(logger.isInfoEnabled()) {
			logger.info("Changes for namespace {}", changeEvent.getNamespace());
		}
        Set<String> changedKeys = changeEvent.changedKeys();
        ConfigChange threadChange = null;

        String threadKey = "thread";

        for (String key : changedKeys) {
            if(key.equals(threadKey) ){
                threadChange = changeEvent.getChange(key);
                break;

            }
        }
        if(threadChange != null){
            String thread = threadChange.getNewValue();
            int i_thread = Integer.parseInt(thread);
            BaseKafkaConsumer kafkaConsumer = applicationContext.getTBeanObject("kafkabatchconsumerstore",BaseKafkaConsumer.class);
            //重置消费线程数量
            kafkaConsumer.resetConsumerThreads(i_thread);
        }


	}




	@Override
	public void completeLoaded() {

	}
}
