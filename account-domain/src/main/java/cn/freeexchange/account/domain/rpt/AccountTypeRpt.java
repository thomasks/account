package cn.freeexchange.account.domain.rpt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.freeexchange.account.domain.AccountType;

public interface AccountTypeRpt extends JpaRepository<AccountType, Long>, JpaSpecificationExecutor<AccountType>{
	
}
