package cn.freeexchange.account.listener;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.freeexchange.account.api.AccountEventTypeEnum;
import cn.freeexchange.account.service.AccountService;
import cn.freeexchange.common.base.Constants;
import cn.freeexchange.common.base.event.Event;
import lombok.extern.slf4j.Slf4j;

@Component
@RabbitListener(queues = "ACCOUNT_EVENT_SOURCING")
@Slf4j
public class AccountEventListener {
	
	@Autowired
	private AccountService accountService;
	
	
	@RabbitHandler
	@SuppressWarnings("rawtypes")
	@Transactional
	public void process(String dataStr) throws Exception {
		log.info("@@AccountEventListener capture msg:{}",dataStr);
		Event event = JSON.parseObject(dataStr, Event.class);
		String eventType = event.getEventType();
		if(eventType.equalsIgnoreCase(AccountEventTypeEnum.OPEN_ACCOUNT.getCode())) {
			Map content = event.getContent();
			Long partner = Long.parseLong(content.get(Constants.PARTNER).toString());
			Long openId =  Long.parseLong(content.get(Constants.OPEN_ID).toString());
			try {
				accountService.openAccount(partner, openId, eventType);
			} catch (Throwable t) {
				log.error("@@OPEN_ACCOUNT meet unexpected exception",t);
			}
		}
	}
	
	
	
}
