package cn.freeexchange.account.api;

import lombok.Getter;

@Getter
public enum AccountEventTypeEnum {
	
	
	OPEN_ACCOUNT(1,"OPEN_ACCOUNT","开设账户");
	
	private Integer id;
	private String code;
    private String name;
    
    private AccountEventTypeEnum(Integer id,String code,String name) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

}
