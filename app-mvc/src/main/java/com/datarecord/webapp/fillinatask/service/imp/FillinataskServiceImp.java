package com.datarecord.webapp.fillinatask.service.imp;

import com.datarecord.webapp.datadictionary.service.imp.DataDictionaryServiceImp;
import com.datarecord.webapp.fillinatask.bean.Fillinatask;
import com.datarecord.webapp.fillinatask.bean.RcdJobPersonAssign;
import com.datarecord.webapp.fillinatask.bean.RcdJobUnitConfig;
import com.datarecord.webapp.fillinatask.dao.FillinataskDao;
import com.datarecord.webapp.fillinatask.service.FillinataskService;
import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fillinataskService")
public class FillinataskServiceImp implements FillinataskService {

    private Logger logger = LoggerFactory.getLogger(DataDictionaryServiceImp.class);

    @Autowired
    private FillinataskDao fillinataskDao;

    @Override
    public PageResult rcdjobconfiglist(int currPage, int pageSize, String job_name, String job_status) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<Fillinatask> contactPageDatas = fillinataskDao.rcdjobconfiglist(currPage, pageSize,job_name,job_status);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public void insertrcdjobconfig(String job_name, String job_start_dt, String job_end_dt) {
        fillinataskDao.insertrcdjobconfig(job_name,job_start_dt,job_end_dt);
    }

    @Override
    public void insertrcdjobpersonassign(String job_id, String userid) {
       /* userid.substring(1);
        userid.substring(0,userid.length()-1);*/
        String[] split = userid.split(",");
        for (String user_id : split){
            fillinataskDao.insertrcdjobpersonassign(job_id,user_id);
        }
    }

    @Override
    public void deletercdjobpersonassign(String job_id) {
        fillinataskDao.deletercdjobpersonassign(job_id);
    }

    @Override
    public void updatercdjobconfig(String job_id,String job_name, String job_start_dt, String job_end_dt) {
        fillinataskDao.updatercdjobconfig(job_id,job_name,job_start_dt,job_end_dt);
    }

    @Override
    public List<RcdJobUnitConfig> selectRcdJobUnitConfig(String job_id) {
        return fillinataskDao.selectRcdJobUnitConfig(job_id);
    }

    @Override
    public List<RcdJobUnitConfig> selectRcdJobUnitConfigyi(String job_id) {
        return fillinataskDao.selectRcdJobUnitConfigyi(job_id);
    }

    @Override
    public void updateRcdJobUnitConfigyi(String jobunitid,String job_id) {
        /*jobunitid.substring(1);
        jobunitid.substring(0,jobunitid.length()-1);*/
        String[] split = jobunitid.split(",");
        for (String job_unit_id : split){
            fillinataskDao.updateRcdJobUnitConfigyi(job_unit_id,job_id);
        }
    }

    @Override
    public void updateRcdJobUnitConfigsuo(String job_id) {
        fillinataskDao.updateRcdJobUnitConfigsuo(job_id);
    }

    @Override
    public List<RcdJobPersonAssign> huixianrcdjobpersonassign(String job_id) {
        return fillinataskDao.huixianrcdjobpersonassign(job_id);
    }
}
