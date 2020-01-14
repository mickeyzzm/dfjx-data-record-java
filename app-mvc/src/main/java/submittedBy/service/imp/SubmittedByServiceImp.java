package submittedBy.service.imp;

import com.github.pagehelper.Page;
import com.webapp.support.page.PageResult;
import datadictionary.service.imp.DataDictionaryServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import submittedBy.bean.SubmittedBy;
import submittedBy.bean.Useroriginassign;
import submittedBy.dao.SubmittedByDao;
import submittedBy.service.SubmittedByService;
import utils.EntityTree;

import java.util.List;

@Service("submittedByService")
public class SubmittedByServiceImp  implements SubmittedByService {

    private Logger logger = LoggerFactory.getLogger(DataDictionaryServiceImp.class);

    @Autowired
    private SubmittedByDao submittedByDao;

    @Override
    public String selectOrgId(int user_id) {
        String orgId = submittedByDao.getOrgId(user_id);
        return orgId;
    }

    @Override
    public List<EntityTree> listOrgData(String orgId) {
        List<EntityTree> entityTrees = submittedByDao.listOrgData(orgId);
        return  entityTrees;
    }

    @Override
    public PageResult rcdpersonconfiglist(int currPage, int pageSize, String user_name) {
        logger.debug("当前页码:{},页面条数:{}",currPage,pageSize);
        Page<SubmittedBy> contactPageDatas = submittedByDao.rcdpersonconfiglist(currPage, pageSize,user_name);
        PageResult pageContactResult = PageResult.pageHelperList2PageResult(contactPageDatas);
        logger.debug("获取到的分页结果数据 --> {}",pageContactResult);
        return pageContactResult;
    }

    @Override
    public List<Useroriginassign> useroriginassignlist(String origin_id) {
        return submittedByDao.useroriginassignlist(origin_id);
    }

    @Override
    public void insertrcdpersonconfig(String origin_id, String[] userid) {
        for (int i= 0;i<userid.length;i++){
            submittedByDao.insertrcdpersonconfig(origin_id,userid[i]);
        }
    }

    @Override
    public List<Useroriginassign> selectrcdpersonconfig(String origin_id) {
        return submittedByDao.selectrcdpersonconfig(origin_id);
    }

    @Override
    public void deletercdpersonconfig(String origin_id) {
        submittedByDao.deletercdpersonconfig(origin_id);
    }

    @Override
    public void deletercdpersonconfigbyuserid(String user_id) {
        submittedByDao.deletercdpersonconfigbyuserid(user_id);
    }
}
