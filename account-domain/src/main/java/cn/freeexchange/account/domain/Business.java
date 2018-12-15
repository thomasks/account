package cn.freeexchange.account.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_business", schema = "account")
@Getter
@Setter
@ToString
//账户业务
public class Business {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "partner")
	private Long partner;
	
	
	@Column(name = "event_type")
	private String eventType;
	
	
	//开设账户,业务记账,注销账户,冻结账户
	@Column(name = "opr_type")
	private String oprType;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "memo")
	private String memo;
	
	@Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @Column(name = "update_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();

    @Column(name = "logic_delete")
    private Boolean logicDelete = false;
    
    @ManyToMany
    @JoinTable(name = "tb_business_account_type",schema="account",
    	joinColumns=@JoinColumn(name="business_id"),
    	inverseJoinColumns=@JoinColumn(name="account_type_id")
    )
    private List<AccountType> accountTypes;
    
    
    public boolean canOpenAccount() {
    	if(!oprType.equalsIgnoreCase("OPEN_ACCOUNT")) {
    		return false;
    	}
    	if(accountTypes == null || accountTypes.size() <1) {
    		return false;
    	}
    	return true;
    }
	

}
