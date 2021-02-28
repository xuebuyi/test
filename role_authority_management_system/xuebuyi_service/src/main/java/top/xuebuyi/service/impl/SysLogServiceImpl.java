package top.xuebuyi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xuebuyi.dao.SysLogDao;
import top.xuebuyi.domain.SysLog;
import top.xuebuyi.service.SysLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-02-02 22:05
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
