package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpRole;

public class SpRoleSqlProvider {

    public String insertSelective(SpRole record) {
        BEGIN();
        INSERT_INTO("sp_role");
        
        if (record.getRlId() != null) {
            VALUES("rl_id", "#{rlId,jdbcType=INTEGER}");
        }
        
        if (record.getRlName() != null) {
            VALUES("rl_name", "#{rlName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpRole record) {
        BEGIN();
        UPDATE("sp_role");
        
        if (record.getRlName() != null) {
            SET("rl_name = #{rlName,jdbcType=VARCHAR}");
        }
        
        WHERE("rl_id = #{rlId,jdbcType=INTEGER}");
        
        return SQL();
    }
}