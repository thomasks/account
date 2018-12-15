package cn.freeexchange.account.crtl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.freeexchange.account.dto.AccountDto;
import cn.freeexchange.account.service.AccountService;
import cn.freeexchange.common.base.ApiResponse;
import cn.freeexchange.common.base.exception.BusinessException;
import cn.freeexchange.common.base.identity.IdentityDto;
import cn.freeexchange.common.base.service.TokenService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/account/api")
@Slf4j
public class AccountCtrl {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value = "/view", method = {RequestMethod.POST,RequestMethod.GET})
	public ApiResponse<AccountDto> view(@RequestHeader(value="token",defaultValue="") String token) {
		log.info("@@account overview arrived...");
		if(StringUtils.isBlank(token)) {
			return ApiResponse.failure("用户未登入");
		}
		try {
			IdentityDto identityDto = tokenService.getTokenIdentity(token);
			List<AccountDto> acctList = accountService.accountOverview(identityDto.getPartner(), identityDto.getOpenId());
			return ApiResponse.success(acctList);
		} catch (BusinessException e) {
			return ApiResponse.failure(e.getBusinessCode(), e.getMessage());
		} catch (Throwable t) {
			return ApiResponse.failure(ApiResponse.CODE_ERROR,ApiResponse.MSG_ERROR);
		}
		
	}
	
}
