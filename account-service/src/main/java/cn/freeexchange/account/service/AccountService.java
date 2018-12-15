package cn.freeexchange.account.service;

import java.util.List;

import cn.freeexchange.account.dto.AccountDto;

public interface AccountService {
	
	public void openAccount(Long partner,Long openId,String eventType);
	
	
	public List<AccountDto> accountOverview(Long partner,Long openId);
}
