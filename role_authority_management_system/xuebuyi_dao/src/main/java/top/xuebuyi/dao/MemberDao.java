package top.xuebuyi.dao;

import org.apache.ibatis.annotations.Select;
import top.xuebuyi.domain.Member;

/**
 * @author xuebuyi
 * @date 2021-01-27 15:50
 */
public interface MemberDao {

    //根据Id查询会员
    @Select("select * from member where id=#{id}")
    public Member findById(String id);
}
