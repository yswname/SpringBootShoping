package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpOrder;

public class SpOrderSqlProvider {

    public String insertSelective(SpOrder record) {
        BEGIN();
        INSERT_INTO("sp_order");
        
        if (record.getOdId() != null) {
            VALUES("od_id", "#{odId,jdbcType=INTEGER}");
        }
        
        if (record.getOdCode() != null) {
            VALUES("od_code", "#{odCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOdCreateTime() != null) {
            VALUES("od_create_time", "#{odCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOdUrId() != null) {
            VALUES("od_ur_id", "#{odUrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdAddressId() != null) {
            VALUES("od_address_id", "#{odAddressId,jdbcType=INTEGER}");
        }
        
        if (record.getOdStatus() != null) {
            VALUES("od_status", "#{odStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOdPyId() != null) {
            VALUES("od_py_id", "#{odPyId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpOrder record) {
        BEGIN();
        UPDATE("sp_order");
        
        if (record.getOdCode() != null) {
            SET("od_code = #{odCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOdCreateTime() != null) {
            SET("od_create_time = #{odCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOdUrId() != null) {
            SET("od_ur_id = #{odUrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdAddressId() != null) {
            SET("od_address_id = #{odAddressId,jdbcType=INTEGER}");
        }
        
        if (record.getOdStatus() != null) {
            SET("od_status = #{odStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOdPyId() != null) {
            SET("od_py_id = #{odPyId,jdbcType=INTEGER}");
        }
        
        WHERE("od_id = #{odId,jdbcType=INTEGER}");
        
        return SQL();
    }
}