DROP TABLE IF EXISTS `tb_business`;
CREATE TABLE `tb_business` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `partner` bigint(64) NOT NULL,
  `event_type` varchar(128) NOT NULL,
  `create_time` datetime NOT NULL,
  `logic_delete` bit(1) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `opr_type` varchar(128) NOT NULL,
  `name` varchar(255) NOT NULL,
  `memo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `tb_subject`;
CREATE TABLE `tb_subject` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `partner` bigint(64) NOT NULL,
  `event_type` varchar(128) NOT NULL,
  `create_time` datetime NOT NULL,
  `logic_delete` bit(1) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `opr_type` varchar(128) NOT NULL,
  `name` varchar(255) NOT NULL,
  `memo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


create table SEASHELL.SUBJECT
(
  acctcode              NUMBER(20) not null,
  acctname              VARCHAR2(60) not null,
  accttype              NUMBER(1) not null,
  acctlevel             NUMBER(1) not null,
  balanceby             NUMBER(1) not null,
  acctcontent           NUMBER(1) not null,
  noncurrencyunit       VARCHAR2(10),
  currencycode          VARCHAR2(10),
  precision             NUMBER(1) not null,
  referable             NUMBER(1) not null,
  orgtype               NUMBER(1) not null,
  orgcode               NUMBER(11),
  childbeorg            NUMBER(1) not null,
  childorgtype          NUMBER(2),
  ismemberacct          NUMBER(1) not null,
  describe              VARCHAR2(300),
  summarizeto           NUMBER(20),
  negativebalance       NUMBER(1) default 0 not null,
  acctdiaryupdatemethod NUMBER(1) default 2 not null,
  sumacctupdatemethod   NUMBER(1) default 2 not null,
  status                NUMBER(1) default 0,
  accountbook           NUMBER(15),
  totalcheck            NUMBER(2)
)
tablespace SEASHELL
  pctfree 30
  initrans 30
  maxtrans 255
  storage
  (
    initial 1M
    next 1M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
comment on table SEASHELL.SUBJECT
  is '帐户科目表';
comment on column SEASHELL.SUBJECT.acctname
  is '账户的名称';
comment on column SEASHELL.SUBJECT.accttype
  is '1-资产类;2-负债类;3-所有者权益类;4-损益类;5-资产负债共同类';
comment on column SEASHELL.SUBJECT.acctlevel
  is '1-总帐;2-明细账;3-明细账子目';
comment on column SEASHELL.SUBJECT.balanceby
  is '1-借方;2-贷方';
comment on column SEASHELL.SUBJECT.acctcontent
  is '账户管理内容的类型，如货币，神州行充值卡，积分等，不需要单独的表来管理这些类型';
comment on column SEASHELL.SUBJECT.noncurrencyunit
  is '如果账户对象为非货币类，账户对象的单位';
comment on column SEASHELL.SUBJECT.currencycode
  is '如果账户对象为货币，货币的单位';
comment on column SEASHELL.SUBJECT.precision
  is '允许小数的位数,0-3';
comment on column SEASHELL.SUBJECT.referable
  is '是否允许被业务系统引用';
comment on column SEASHELL.SUBJECT.orgtype
  is '机构的类型';
comment on column SEASHELL.SUBJECT.orgcode
  is '机构代码';
comment on column SEASHELL.SUBJECT.childbeorg
  is '子目是否由机构构成';
comment on column SEASHELL.SUBJECT.childorgtype
  is '如果子目由机构构成，子目对应的机构类型';
comment on column SEASHELL.SUBJECT.ismemberacct
  is '是否属于会员账户';
comment on column SEASHELL.SUBJECT.describe
  is '描述';
comment on column SEASHELL.SUBJECT.summarizeto
  is '汇总帐户的科目';
comment on column SEASHELL.SUBJECT.negativebalance
  is '余额允许负数 	0-不允许;1－允许';
comment on column SEASHELL.SUBJECT.acctdiaryupdatemethod
  is '日记账更新方式 	1-延时;2-即时';
comment on column SEASHELL.SUBJECT.sumacctupdatemethod
  is '汇总账更新方式 	1-延时;2-即时';
comment on column SEASHELL.SUBJECT.status
  is '科目状态: 0未审核1已生效2已禁用';
comment on column SEASHELL.SUBJECT.accountbook
  is '账套';
comment on column SEASHELL.SUBJECT.totalcheck
  is '总分核对标志 0-不核对 1核对';