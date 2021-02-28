package top.xuebuyi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.xuebuyi.domain.SysLog;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-02-02 22:06
 */
public interface SysLogDao {

    @Insert("insert into SysLog(username, ip, url, method, visitTime, executionTime) values(#{username}, #{ip}, #{url}, #{method}, #{visitTime}, #{executionTime})")
    void save(SysLog sysLog);

    @Select("select * from sysLog")
    List<SysLog> findAll();
}
