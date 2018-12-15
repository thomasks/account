package cn.freeexchange.account.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import cn.freeexchange.account.dto.AccountDto;
import cn.freeexchange.common.base.utils.AccountnoUtils;
import cn.freeexchange.common.base.utils.BalanceUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//账户
@Entity
@Table(name = "tb_account", schema = "account")
@Getter
@Setter
@ToString
public class Account {
	
	@Value("${acct.balance.salt}")
	@Transient
	private String salt = "ABC#$20160126&&*%%7788@EJU+520!$";
	
	//id无意义
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "partner")
	private Long partner;
	
	@Column(name = "open_id")
	private Long openId;
	
	@ManyToOne
    @JoinColumn(name = "account_type_id")
	private AccountType accountType;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_no")
	private String accountNo;
	
	@Column(name = "balance")
	private Long balance = BigDecimal.ZERO.longValue();
	
	@Column(name = "credit_balance")
	private Long creditBalance = BigDecimal.ZERO.longValue();
	
	@Column(name = "debit_balance")
	private Long debitBalance = BigDecimal.ZERO.longValue();
	
	@Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @Column(name = "update_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();

    @Column(name = "logic_delete")
    private Boolean logicDelete = false;
    
    @Column(name = "balance_auth")
    private String balanceAuth;
    
    protected Account() {
    	
    }
    
    protected Account(AccountType accountType,Long openId) {
    	this.partner = accountType.getPartner();
    	this.accountType = accountType;
    	this.openId = openId;
    	this.accountName = accountType.getAccountTypeName();
    	if(StringUtils.isNotBlank(accountType.getSubjectCode()) 
    			&& StringUtils.isNotBlank(accountType.getAccountSeq())
    			&& accountType.getLevel().equals(2L)) {
    		this.accountNo = AccountnoUtils.makeL2AccountNo(accountType.getSubjectCode(), openId.toString(), accountType.getAccountSeq());
    	}
    	if(StringUtils.isNotBlank(accountType.getSubjectCode()) 
    			&& accountType.getLevel().equals(1L)) {
    		this.accountNo = AccountnoUtils.makeL1AccountNo(accountType.getSubjectCode());
    	}
    	String acctId= openId.toString() + accountType.getId();
    	this.balanceAuth = BalanceUtils.calcBalanceAuth(acctId, this.getBalance(), salt);
    }
    
    
    public static Account makeAccount(AccountType accountType,Long openId) {
    	Account acct = new Account(accountType, openId);
    	return acct;
    }
    
    public AccountDto makeDto() {
    	AccountDto accountDto = AccountDto.makeAccountDto(id, 
    			accountType.getAccountType(), accountName, balance);
    	return accountDto;
    }
    
    
    public boolean isCustView() {
    	return accountType.getCustView();
    }
    
    
	
}
