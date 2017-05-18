package com.optimus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.optimus.common.PageModel;
import com.optimus.entity.Operator;
import com.optimus.vo.OperatorBankInfo;
import com.optimus.vo.OperatorVo;


@Repository(value = "operatorMapper")
@Transactional
public interface OperatorMapper  {
	
	void insertOperator(Operator operator) ;
	
	List<OperatorVo> getOperatorsByMerNo(@Param("merchantno")String merchantno) ;
	
	int updateDaprate(@Param("daprate")String daprate,@Param("useruuid")String useruuid) ;

	int updateDaprateMsgCode(@Param("msgcode")String msgcode,@Param("useruuid")String useruuid) ;
	
	int updateBankInfo(OperatorBankInfo operatorBankInfo) ;
	
	OperatorBankInfo getOperatorBankInfo(@Param("useruuid")String useruuid) ;

	/**
	 * 分页查询
	 * @param pageModel
	 * @return
	 */
	List<Operator> selectByPage(PageModel<Operator> pageModel);
	
	
	/**
	 * 根据id删除
	 * @param useruuid
	 * @throws BaseDaoException
	 */
	void deleteOperator(String useruuid) ;
	
	/**
	 * 统计
	 * @param pageModel
	 * @return
	 */
	int count(PageModel<Operator> pageModel);
	
	/**
	 * 根据id查询
	 * @param useruuid
	 * @return
	 */
	Operator selectById(String useruuid);
	
	/**
	 * 根据id更新
	 */
	void updateOperator(Operator operator);
	
	/**
	 * 根据手机号查询
	 * @param userphone
	 * @return
	 */
	Operator selectByPhone(@Param("userphone")String userphone,@Param("type")String type);
	/**
	 * 根据手机号和商户号查询
	 * @param userphone
	 * @return
	 */
	Operator selectByPhoneAndMerchantID(@Param("userphone")String userphone,@Param("merchantno")String merchantno);
	
	/**
	 * 根据id修改密码
	 * @param passwd
	 */
	void updateOperatorByPw(@Param("passwd")String passwd,@Param("useruuid")String useruuid);
	
	/**
	 * 根据商户id更新操作员
	 */
	void updateOperatorMer(Operator operator);
	//删除操作员
	void deleteOperatorById(String useruuid);
	//根据id更新操作员权限
	void updateOperatorById(Operator operator);
	
	/**
	 * 根据商户号查询所有商户管理
	 * @param merchantno
	 * @return
	 * @throws BaseDaoException
	 */
	List<Operator> selectOperatorsByMerNo(@Param("merchantno")String merchantno);
	/**
	 * 商户后台招生老师信息查询
	 * @param pageModel
	 * @return
	 */
	List<Operator> selectByPageMerOperator(PageModel<Operator> pageModel);

	int countMerOperator(PageModel<Operator> pageModel);

	List<Operator> selectOperators(PageModel<Operator> pageModel);
	/**
	 * 配置IRR计算器使用权限码
	 * @param msgcode
	 * @param useruuid
	 * @return
	 * @throws BaseDaoException
	 * @date 创建时间：2017年1月15日 上午11:58:17
	 */
	int updateIrrCode(@Param("msgcode")String msgcode,@Param("useruuid")String useruuid) ;
	/**
	 * 根据权限码查询用户
	 * @param msgcode
	 * @return
	 * @date 创建时间：2017年1月15日 上午11:58:39
	 */
	Operator selectByIrrCode(@Param("msgcode")String msgcode);
	/**
	 * 更新老师权限
	 * @param id
	 * @param roletype
	 */
	 
	void updateOpEditTeacher(@Param("useruuid")String useruuid,@Param("roletype")String roletype);
}
