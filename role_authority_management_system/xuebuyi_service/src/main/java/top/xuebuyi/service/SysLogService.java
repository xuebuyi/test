package top.xuebuyi.service;

import top.xuebuyi.domain.SysLog;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-02-02 22:05
 */
public interface SysLogService {
    public void save(SysLog sysLog);

    List<SysLog> findAll();
}
