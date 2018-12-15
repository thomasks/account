package cn.freeexchange.account.dto;

import cn.freeexchange.common.base.utils.AmountUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDto {
	
	
	private String accountId;
	
	
	private String accountTypeId;
	
	private String accountName;
	
	private String balance;
	
	
	protected AccountDto() {
		
	}


	protected AccountDto(String accountId, String accountTypeId, String accountName, String balance) {
		this.accountId = accountId;
		this.accountTypeId = accountTypeId;
		this.accountName = accountName;
		this.balance = balance;
	}
	
	
	public static AccountDto makeAccountDto(Long id,Long accountType,String accountName,Long balance) {
		String accountId = id.toString();
		String accountTypeId = accountType.toString();
		String amt = AmountUtils.toAmount(balance);
		return new AccountDto(accountId, accountTypeId, accountName, amt);
	}
	

}
