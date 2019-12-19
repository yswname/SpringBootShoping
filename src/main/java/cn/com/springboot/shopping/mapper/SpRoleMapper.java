package cn.com.springboot.shopping.mapper;

import cn.com.springboot.shopping.entity.SpRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpRoleMapper {
    @Delete({
        "delete from sp_role",
        "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rlId);

    @Insert({
        "insert into sp_role (rl_id, rl_name)",
        "values (#{rlId,jdbcType=INTEGER}, #{rlName,jdbcType=VARCHAR})"
    })
    int insert(SpRole record);

    @InsertProvider(type=SpRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SpRole record);

    @Select({
        "select",
        "rl_id, rl_name",
        "from sp_role",
        "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="rl_id", property="rlId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rl_name", property="rlName", jdbcType=JdbcType.VARCHAR)
    })
    SpRole selectByPrimaryKey(Integer rlId);

    @UpdateProvider(type=SpRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpRole record);

    @Update({
        "update sp_role",
        "set rl_name = #{rlName,jdbcType=VARCHAR}",
        "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpRole record);
}