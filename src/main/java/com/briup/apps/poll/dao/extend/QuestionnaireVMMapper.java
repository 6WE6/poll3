package com.briup.apps.poll.dao.extend;

import com.briup.apps.poll.bean.extend.QuestionnaireVM;

/**
 * 数据访问中间层
 * @author WE
 *
 */
public interface QuestionnaireVMMapper {
	/**
	 * 通过id查询问卷模型
	 * @param id
	 * @return
	 */
	QuestionnaireVM selectQunById(long id);

}
