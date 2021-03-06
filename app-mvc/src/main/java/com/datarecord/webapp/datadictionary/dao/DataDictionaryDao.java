package com.datarecord.webapp.datadictionary.dao;

import com.datarecord.webapp.datadictionary.bean.DataDictionary;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DataDictionaryDao {

    //新增数据字典类型
    @Insert("INSERT INTO rcd_dt_dict (dict_name) VALUES(#{dict_name}) ")
    void insertDataDictionary(@Param("dict_name") String dict_name);

    @Select("<script>SELECT\n" +
            "\tr.dict_id,\n" +
            "\tr.dict_name  dict_name,\n" +
            "\tc.dict_content_id,\n" +
            "\tc.dict_content_name,\n" +
            "\tc.dict_content_value\n" +
            "FROM\n" +
            "\trcd_dt_dict r\n" +
            "INNER JOIN rcd_dt_dict_content c ON r.dict_id = c.dict_id\n" +
            "  where 1=1   " +
            "<if test = \"dict_id != null and dict_id != ''\">  AND  r.dict_id = #{dict_id} </if>" +
            "</script>")
    Page<DataDictionary> selectDataDictionary(@Param("currPage") int currPage, @Param("pageSize") int pageSize, @Param("dict_id") String dict_id);

    @Insert("INSERT INTO rcd_dt_dict_content (dict_id,dict_content_name,dict_content_value) VALUES(#{dict_id},#{dict_content_name},#{dict_content_value}) ")
    void inserttypeDataDictionary(@Param("dict_id") String dict_id, @Param("dict_content_name") String dict_content_name, @Param("dict_content_value") String dict_content_value);

    @Update("UPDATE rcd_dt_dict_content SET dict_id=#{dict_id}, dict_content_name =#{dict_content_name}, dict_content_value=#{dict_content_value} WHERE  dict_content_id = #{dict_content_id}")
    void updateDataDictionary(@Param("dict_content_id") String dict_content_id, @Param("dict_id") String dict_id, @Param("dict_content_name") String dict_content_name, @Param("dict_content_value") String dict_content_value);

    @Select("SELECT dict_id,dict_name FROM rcd_dt_dict")
    List<DataDictionary>  selectleftDataDictionary();

    @Update("UPDATE rcd_dt_dict SET dict_name=#{dict_name} WHERE  dict_id = #{dict_id}")
    void updateDataDictionarybydictid(@Param("dict_id") String dict_id, @Param("dict_name") String dict_name);

    @Select("SELECT dict_id,dict_name FROM  rcd_dt_dict")
    Page<DataDictionary> dataDictionarylist(@Param("currPage") int currPage, @Param("pageSize") int pageSize);
}
