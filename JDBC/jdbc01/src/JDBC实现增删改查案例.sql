-- 删除tb_brand表
DROP TABLE IF EXISTS tb_brand;

-- 创建tb_brand表
CREATE TABLE tb_brand(
	# 主键
	id int PRIMARY KEY auto_increment,
	# 品牌名称
	brand_name VARCHAR(20),
	# 企业名称
	company_name VARCHAR(20),
	# 排序字段
	ordered int,
	# 描述信息
	description varchar(100),
	# 状态：0--禁用，1--启用
	status int
);

-- 添加数据
INSERT INTO 
	tb_brand ( brand_name, company_name, ordered, description, STATUS )
VALUES
	( '三只松鼠', '三只松鼠股份有限公司', 5, '好吃不上火', 0 ),
	( '华为', '华为技术有限公司', 100, '华为致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世 界', 1 ),
	( '小米', '小米科技有限公司', 50, 'are you ok', 1 );
	

# 查询表
SELECT * from tb_brand;
	