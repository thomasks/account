package cn.freeexchange.account.domain.rpt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.freeexchange.account.domain.Account;

public interface AccountRpt extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account>{
	
	@Query("from Account where partner=?1 and openId=?2")
	List<Account> findAccountByPartnerAndOpenId(Long partner,Long openId);
}
