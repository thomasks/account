package cn.freeexchange.account.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.freeexchange.account.domain.Account;
import cn.freeexchange.account.domain.AccountType;
import cn.freeexchange.account.domain.Business;
import cn.freeexchange.account.domain.rpt.AccountRpt;
import cn.freeexchange.account.domain.rpt.BusinessRpt;
import cn.freeexchange.account.dto.AccountDto;
import cn.freeexchange.account.service.AccountService;
import cn.freeexchange.common.base.exception.BusinessException;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private BusinessRpt businessRpt;
	
	@Autowired
	private AccountRpt accountRpt;

	@Override
	@Transactional
	public void openAccount(Long partner,Long openId,String eventType) {
		//开设账户
		Business biz = businessRpt.findBusiness(partner, eventType);
		if(biz == null) {
			throw new BusinessException("acct02");
		}
		
		boolean canOpenAccount = biz.canOpenAccount();
		if(!canOpenAccount) {
			throw new BusinessException("acct03");
		}
		
		List<Account> accts = new ArrayList<>();
		Collection<AccountType> values = biz.getAccountTypes();
		for (AccountType accountType : values) {
			Account acct = Account.makeAccount(accountType, openId);
			accts.add(acct);
		}
		accountRpt.saveAll(accts);
	}

	@Override
	public List<AccountDto> accountOverview(Long partner, Long openId) {
		List<AccountDto> ret = new ArrayList<>();
		List<Account> accts = accountRpt.findAccountByPartnerAndOpenId(partner, openId);
		for (Account account : accts) {
			if(account.isCustView()) {
				AccountDto accountDto = account.makeDto();
				ret.add(accountDto);
			}
		}
		return ret;
	}

}
