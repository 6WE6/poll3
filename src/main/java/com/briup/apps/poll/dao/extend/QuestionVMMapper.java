package com.briup.apps.poll.dao.extend;

import java.util.List;
import com.briup.apps.poll.bean.extend.QuestionVM;

/**
 * 数据访问中间层
 * @author WE
 *
 */
public interface QuestionVMMapper {
	/**
	 * 查询所有题库信息
	 * @return
	 */
	List<QuestionVM> selectAllQuestion();
	

}
