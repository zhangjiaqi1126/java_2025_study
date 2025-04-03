-- 创建用户表
CREATE TABLE USER(
	uid VARCHAR(50) PRIMARY KEY,	-- 用户id
	ucode VARCHAR(50),		-- 用户标识
	loginname VARCHAR(100),		-- 登录用户名
	PASSWORD VARCHAR(100),		-- 登录密码
	username VARCHAR(100),		-- 用户名
	gender VARCHAR(10),		-- 用户性别
	birthday DATE,			-- 出生日期
	dutydate DATE                   -- 入职日期
);

-- 添加一条测试数据
INSERT INTO USER VALUES ('11111111', 'zhangsan001', 'zhangsan', '1234', '张三', '男', '2008-10-28', '2018-10-28');
