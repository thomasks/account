DROP TABLE IF EXISTS `tb_business`;
CREATE TABLE `tb_business` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `partner` bigint(64) NOT NULL,
  `event_type` varchar(128) NOT NULL,
  `create_time` datetime NOT NULL,
  `logic_delete` bit(1) DEFAULT 0,
  `update_time` datetime NOT NULL,
  `opr_type` varchar(128) NOT NULL,
  `name` varchar(255) NOT NULL,
  `memo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tb_business` ADD UNIQUE INDEX `UNQ_PAR_EVENTTYPE` (`partner`, `event_type`);


DROP TABLE IF EXISTS `tb_account_type`;
CREATE TABLE `tb_account_type` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `partner` bigint(64) NOT NULL,
  `account_type` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `logic_delete` bit(1) DEFAULT 0,
  `update_time` datetime NOT NULL,
  `account_type_name` varchar(128) NOT NULL,
  `category` varchar(255) NOT NULL,
  `subject_code` varchar(255),
  `balance_by` bigint(20) NOT NULL,
  `acct_content` bigint(20) NOT NULL,
  `acct_seq` varchar(255),
  `cust_view` bit(1) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tb_account_type` ADD UNIQUE INDEX `UNQ_PAR_ACCOUNTTYPE` (`partner`, `account_type_id`) ;



DROP TABLE IF EXISTS `tb_business_account_type`;
CREATE TABLE `tb_business_account_type` (
  `business_id` bigint(20) NOT NULL,
  `account_type_id` bigint(20) NOT NULL,
  `memo` varchar(255),
  PRIMARY KEY (`business_id`,`account_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `partner` bigint(64) NOT NULL,
  `open_id` bigint(64) NOT NULL,
  `account_type_id` bigint(20) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `account_no` varchar(255),
  `balance` bigint(20) NOT NULL,
  `credit_balance` bigint(20) NOT NULL,
  `debit_balance` bigint(20) NOT NULL,
  `balance_auth` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `logic_delete` bit(1) DEFAULT 0,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4;


ALTER TABLE `tb_account` ADD UNIQUE INDEX `UNQ_OPENID_ACCTTYPE` (`open_id`, `account_type_id`);




