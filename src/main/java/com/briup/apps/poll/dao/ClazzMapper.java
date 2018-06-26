package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClazzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    long countByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int deleteByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int insert(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int insertSelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    List<Clazz> selectByExampleWithBLOBs(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    List<Clazz> selectByExample(ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    Clazz selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int updateByExampleSelective(@Param("record") Clazz record, @Param("example") ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Clazz record, @Param("example") ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int updateByExample(@Param("record") Clazz record, @Param("example") ClazzExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int updateByPrimaryKeySelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_clazz
     *
     * @mbg.generated Tue Jun 26 22:35:03 CST 2018
     */
    int updateByPrimaryKey(Clazz record);
}