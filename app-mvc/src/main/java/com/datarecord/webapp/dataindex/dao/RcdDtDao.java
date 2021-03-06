package com.datarecord.webapp.dataindex.dao;

import com.datarecord.webapp.datadictionary.bean.DataDictionary;
import com.datarecord.webapp.dataindex.bean.*;
import com.datarecord.webapp.process.entity.ReportFldConfig;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RcdDtDao {

    @Insert("INSERT INTO rcd_dt_proj (proj_name,is_actived) VALUES(#{proj_name},#{is_actived}) ")
    void insertrcddtproj(@Param("proj_name") String proj_name, @Param("is_actived") String is_actived);

    @Select("select proj_id,proj_name,is_actived from rcd_dt_proj")
    Page<DataDictionary> selectrcddtproj(@Param("currPage") int currPage, @Param("pageSize") int pageSize);


    @Update("UPDATE rcd_dt_proj SET proj_name=#{proj_name}, is_actived =#{is_actived}  WHERE  proj_id = #{proj_id}")
    void updatercddtproj(@Param("proj_name") String proj_name, @Param("is_actived") String is_actived, @Param("proj_id") String proj_id);


    @Select("<script>SELECT\n" +
            "\ta.fld_id,\n" +
            "\ta.fld_name,\n" +
            "  b.catg_id,\n" +
            "\tb.catg_name,\n" +
            "  c.proj_id,\n" +
            "  c.proj_name,\n" +
            "  a.fld_data_type,\n" +
            "  a.fld_is_null\n" +
            "FROM\n" +
            "\trcd_dt_fld a\n" +
            "INNER JOIN rcd_dt_catg b ON a.catg_id = b.catg_id\n" +
            "INNER JOIN rcd_dt_proj c ON c.proj_id = b.proj_id\n" +
            " where 1=1 " +
            "<if test = \"catg_id != null and catg_id != ''\">  and b.catg_id = #{catg_id} </if>" +
            "</script>")
    Page<RcdDt> selecttixircddtproj(@Param("currPage") int currPage, @Param("pageSize") int pageSize, @Param("catg_id") String catg_id);


    @Insert("INSERT INTO rcd_dt_fld (catg_id,fld_name,fld_data_type,fld_is_null,fld_type) VALUES(#{catg_id},#{fld_name},#{fld_data_type},#{fld_is_null},#{fld_type})")
    void insertrcddtfld(@Param("catg_id") String catg_id, @Param("fld_name") String fld_name, @Param("fld_data_type") String fld_data_type, @Param("fld_is_null") String fld_is_null,@Param("fld_type") String fld_type);


    @Insert("INSERT INTO rcd_dt_fld_ct_assign (fld_id,dict_content_id) VALUES(#{fld_id},#{dict_contentid})")
    void insertrcddtfldctassign(@Param("fld_id") String fld_id, @Param("dict_contentid") String dict_contentid);

    @Update("UPDATE rcd_dt_dict_content SET is_actived = 0  where dict_content_id = #{dict_content_id}")
    void updatercddtdict(@Param("dict_content_id") String dict_content_id);

    @Delete("delete from rcd_dt_fld_ct_assign where  fld_id = #{fld_id}")
    void deletercddtfldctassign(@Param("fld_id") String fld_id);


    @Update("UPDATE rcd_dt_fld set catg_id =#{catg_id},fld_name =#{fld_name},fld_data_type =#{fld_data_type},fld_is_null =#{fld_is_null},fld_type = #{fld_type} where fld_id =#{fld_id}")
    void updatercddtfld(@Param("fld_id") String fld_id, @Param("catg_id") String catg_id, @Param("fld_name") String fld_name, @Param("fld_data_type") String fld_data_type, @Param("fld_is_null") String fld_is_null,@Param("fld_type") String fld_type);

    @Select("SELECT proj_id,proj_name FROM rcd_dt_proj ")
    List<Rcddtproj> leftrcddtprojjblx();

    @Select("SELECT catg_id,catg_name FROM rcd_dt_catg  where  proj_id = #{proj_id}")
    List<RcddtCatg> leftrcddtcatglx(@Param("proj_id") String proj_id);

    @Select("SELECT fld_id,fld_name FROM rcd_dt_fld  where  catg_id = #{catg_id}")
    List<RcdDtFld> leftrcddtfld(@Param("catg_id") String catg_id);


    @Select("SELECT  a.catg_id,b.proj_name,a.catg_name FROM rcd_dt_catg a    left JOIN rcd_dt_proj  b on a.proj_id  = b.proj_id  where  a.proj_id =#{proj_id}\n")
    Page<DataDictionary> selecttixircddtprojer(@Param("currPage")int currPage, @Param("pageSize")int pageSize,@Param("proj_id") String proj_id);

    @Select("select  MAX(fld_id) from  rcd_dt_fld")
    int selectmax();

    @Insert("insert into rcd_dt_catg (catg_name,proj_id) values(#{catg_name},#{proj_id})")
    void inserttixircddtprojer(@Param("catg_name")String catg_name, @Param("proj_id")String proj_id);

    @Update("update rcd_dt_catg set catg_name = #{catg_name},proj_id =#{proj_id} where  catg_id =#{catg_id}")
    void updatetixircddtprojer(@Param("catg_id")String catg_id, @Param("catg_name")String catg_name, @Param("proj_id")String proj_id);

    @Select("SELECT dict_content_id  FROM rcd_dt_fld_ct_assign WHERE fld_id = #{fld_id} ")
    List<RcdDtFldCtAssign> updatehuixianrcddtfldctassign(@Param("fld_id")String fld_id);
}
