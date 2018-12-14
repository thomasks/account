package cn.freeexchange.account.domain;

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

//科目
@Entity
@Table(name = "tb_subject", schema = "account")
@Getter
@Setter
@ToString
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//余额登记方向 1--借方 2贷方
	@Column(name = "balance_by")
	private Long balanceBy;
	
	//科目编号
	@Column(name = "acct_code")
	private String acctcode;
	
	//'1-资产类;2-负债类;3-所有者权益类;4-损益类;5-资产负债共同类'
	@Column(name = "category")
	private String category;
	
	//货币,积分
	@Column(name = "acct_content")
	private Long acctContent;
	
	//非币种单位
	@Column(name = "non_currency_unit")
	private String nonCurrencyUnit;
	
	//币种
	@Column(name = "currency_code")
	private String	currencyCode;
	
	//余额是否可负
	@Column(name = "negative_balance")
    private Boolean negativeBalance = false;
	
	
	@Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @Column(name = "update_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();
    
    @Column(name = "logic_delete")
    private Boolean logicDelete = false;
    
    //合作方
	@Column(name = "partner")
	private Long partner;
	
	//账簿
	@Column(name = "account_book")
	private Long accountBook;
	
	//0未审核1已生效2已禁用
	@Column(name = "status")
	private Long status;
	
	//是否会员账户
	@Column(name = "is_member_acct")
	private Boolean isMemberAcct;
}
