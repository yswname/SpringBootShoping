package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpCatalogue;

public class SpCatalogueSqlProvider {

    public String insertSelective(SpCatalogue record) {
        BEGIN();
        INSERT_INTO("sp_catalogue");
        
        if (record.getCtId() != null) {
            VALUES("ct_id", "#{ctId,jdbcType=INTEGER}");
        }
        
        if (record.getCtName() != null) {
            VALUES("ct_name", "#{ctName,jdbcType=VARCHAR}");
        }
        
        if (record.getCtParentId() != null) {
            VALUES("ct_parent_id", "#{ctParentId,jdbcType=INTEGER}");
        }
        
        if (record.getCtRemark() != null) {
            VALUES("ct_remark", "#{ctRemark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpCatalogue record) {
        BEGIN();
        UPDATE("sp_catalogue");
        
        if (record.getCtName() != null) {
            SET("ct_name = #{ctName,jdbcType=VARCHAR}");
        }
        
        if (record.getCtParentId() != null) {
            SET("ct_parent_id = #{ctParentId,jdbcType=INTEGER}");
        }
        
        if (record.getCtRemark() != null) {
            SET("ct_remark = #{ctRemark,jdbcType=VARCHAR}");
        }
        
        WHERE("ct_id = #{ctId,jdbcType=INTEGER}");
        
        return SQL();
    }
}