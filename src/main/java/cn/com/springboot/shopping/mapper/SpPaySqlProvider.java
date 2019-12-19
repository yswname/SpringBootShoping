package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpPay;

public class SpPaySqlProvider {

    public String insertSelective(SpPay record) {
        BEGIN();
        INSERT_INTO("sp_pay");
        
        if (record.getPyId() != null) {
            VALUES("py_id", "#{pyId,jdbcType=INTEGER}");
        }
        
        if (record.getPyName() != null) {
            VALUES("py_name", "#{pyName,jdbcType=VARCHAR}");
        }
        
        if (record.getPyImg() != null) {
            VALUES("py_img", "#{pyImg,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpPay record) {
        BEGIN();
        UPDATE("sp_pay");
        
        if (record.getPyName() != null) {
            SET("py_name = #{pyName,jdbcType=VARCHAR}");
        }
        
        if (record.getPyImg() != null) {
            SET("py_img = #{pyImg,jdbcType=VARCHAR}");
        }
        
        WHERE("py_id = #{pyId,jdbcType=INTEGER}");
        
        return SQL();
    }
}