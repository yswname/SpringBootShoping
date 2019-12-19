package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpProAttr;

public class SpProAttrSqlProvider {

    public String insertSelective(SpProAttr record) {
        BEGIN();
        INSERT_INTO("sp_pro_attr");
        
        if (record.getProAttrId() != null) {
            VALUES("pro_attr_id", "#{proAttrId,jdbcType=INTEGER}");
        }
        
        if (record.getProAttrName() != null) {
            VALUES("pro_attr_name", "#{proAttrName,jdbcType=VARCHAR}");
        }
        
        if (record.getProAttrCode() != null) {
            VALUES("pro_attr_code", "#{proAttrCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProAttrCtId() != null) {
            VALUES("pro_attr_ct_id", "#{proAttrCtId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpProAttr record) {
        BEGIN();
        UPDATE("sp_pro_attr");
        
        if (record.getProAttrName() != null) {
            SET("pro_attr_name = #{proAttrName,jdbcType=VARCHAR}");
        }
        
        if (record.getProAttrCode() != null) {
            SET("pro_attr_code = #{proAttrCode,jdbcType=VARCHAR}");
        }
        
        if (record.getProAttrCtId() != null) {
            SET("pro_attr_ct_id = #{proAttrCtId,jdbcType=INTEGER}");
        }
        
        WHERE("pro_attr_id = #{proAttrId,jdbcType=INTEGER}");
        
        return SQL();
    }
}