package cn.freeexchange.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_account_type", schema = "account")
@Getter
@Setter
@ToString
//账户业务
public class AccountType {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "partner")
	private Long partner;
	
	//账户类别
	@Column(name = "account_type")
	private Long accountType;
	
	//账户类别名称
	@Column(name = "account_type_name")
	private String accountTypeName;
	
	//'1-资产类;2-负债类;3-所有者权益类;4-损益类;5-资产负债共同类'
	@Column(name = "category")
	private String category;
	
	//会计科目名称
	@Column(name = "subject_code")
	private String subjectCode;
	
	//余额登记方向 1--借方 2--贷方
	@Column(name = "balance_by")
	private String balanceBy;
	
	//账户内容:货币,积分
	//暂未启用,若需与会计系统集成则配置指定的账户
	@Column(name = "acct_content")
	private Long acctContent;
	
	//明细账户序列号
	@Column(name = "acct_seq")
	private String accountSeq;
	
	//客户是否可见
	@Column(name = "cust_view")
	private Boolean custView;
	
	//生成账户级别
	//1--总账,2--明细账户,3--明细账字目
	private Long level;
	
}
