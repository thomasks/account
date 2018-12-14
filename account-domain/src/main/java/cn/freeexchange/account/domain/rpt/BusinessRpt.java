package cn.freeexchange.account.domain.rpt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.freeexchange.account.domain.Business;

public interface BusinessRpt extends JpaRepository<Business, Long>, JpaSpecificationExecutor<Business>{
	
	@Query("from Business where partner=?1 and eventType=?2")
	Business findBusiness(Long partner, String eventType);
}
