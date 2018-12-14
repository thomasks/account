package cn.freeexchange.account.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	//id无意义
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "partner")
	private Long partner;
	
	@Column(name = "open_id")
	private Long openId;
	
	@Column(name = "account_type_id")
	private Long accountTypeId;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_no")
	private String accountNo;
	
	@Column(name = "balance")
	private BigDecimal balance;
	
	@Column(name = "credit_balance")
	private BigDecimal creditBalance;
	
	@Column(name = "debit_balance")
	private BigDecimal debitBalance;
	
	@Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @Column(name = "update_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();

    @Column(name = "logic_delete")
    private Boolean logicDelete = false;
	
}
