package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpIdCard;

public class SpIdCardSqlProvider {

    public String insertSelective(SpIdCard record) {
        BEGIN();
        INSERT_INTO("sp_id_card");
        
        if (record.getIcId() != null) {
            VALUES("ic_id", "#{icId,jdbcType=INTEGER}");
        }
        
        if (record.getIcCode() != null) {
            VALUES("ic_code", "#{icCode,jdbcType=CHAR}");
        }
        
        if (record.getIcName() != null) {
            VALUES("ic_name", "#{icName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpIdCard record) {
        BEGIN();
        UPDATE("sp_id_card");
        
        if (record.getIcCode() != null) {
            SET("ic_code = #{icCode,jdbcType=CHAR}");
        }
        
        if (record.getIcName() != null) {
            SET("ic_name = #{icName,jdbcType=VARCHAR}");
        }
        
        WHERE("ic_id = #{icId,jdbcType=INTEGER}");
        
        return SQL();
    }
}