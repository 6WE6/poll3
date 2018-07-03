package com.briup.apps.poll.service.impl;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;


/**
 * 业务逻辑处理接口   
 * @author WE
 */
@Service
public class SurveyServiceImpl implements ISurveyService{

	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired
	private SurveyVMMapper surveyVMMapper;

	/**
	 * 保存或更新课调信息
	 */
	@Override
	public void saveOrUpdateSurvey(Survey survey) throws Exception {
		if(survey.getId()!=null){
			//更新
			surveyMapper.updateByPrimaryKey(survey);
		}else{
			// status code surveyDate
			survey.setStatus(Survey.STATUS_INIT);
			survey.setCode("");
			//获取当前时间
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String surveydate = sdf.format(now);
			survey.setSurveydate(surveydate);  
			//插入
			surveyMapper.insert(survey);
		}
	}

	/**
	 * 查询所有课调信息
	 */
	@Override
	public List<SurveyVM> selectAllSurvey() throws Exception {
		return surveyVMMapper.selectAllSurvey();
	}

	/**
	 * 根据id查询课调信息
	 */
	@Override
	public SurveyVM selectSurveyById(long id) throws Exception {
		return surveyVMMapper.selectSurveyById(id);
	}

	/**
	 * 通过id删除课调
	 */
	@Override
	public void deleteSurveyById(long id) throws Exception {
		surveyMapper.deleteByPrimaryKey(id);
		
	}

	/**
	 * 批量删除课调
	 */
	@Override
	public void batchDeleteSurvey(long[] ids) throws Exception {
		for(long id : ids){
			surveyMapper.deleteByPrimaryKey(id);
		}	
	}

	/**
	 * 通过id查询课调(单表)
	 */
	@Override
	public Survey findSurveyById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyMapper.selectByPrimaryKey(id);
	}

}
