package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpReceiveAddress;

public class SpReceiveAddressSqlProvider {

    public String insertSelective(SpReceiveAddress record) {
        BEGIN();
        INSERT_INTO("sp_receive_address");
        
        if (record.getReAdrId() != null) {
            VALUES("re_adr_id", "#{reAdrId,jdbcType=INTEGER}");
        }
        
        if (record.getReAdrAddress() != null) {
            VALUES("re_adr_address", "#{reAdrAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getReAdrName() != null) {
            VALUES("re_adr_name", "#{reAdrName,jdbcType=VARCHAR}");
        }
        
        if (record.getReAdrPhone() != null) {
            VALUES("re_adr_phone", "#{reAdrPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReAdrUrId() != null) {
            VALUES("re_adr_ur_id", "#{reAdrUrId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpReceiveAddress record) {
        BEGIN();
        UPDATE("sp_receive_address");
        
        if (record.getReAdrAddress() != null) {
            SET("re_adr_address = #{reAdrAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getReAdrName() != null) {
            SET("re_adr_name = #{reAdrName,jdbcType=VARCHAR}");
        }
        
        if (record.getReAdrPhone() != null) {
            SET("re_adr_phone = #{reAdrPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getReAdrUrId() != null) {
            SET("re_adr_ur_id = #{reAdrUrId,jdbcType=INTEGER}");
        }
        
        WHERE("re_adr_id = #{reAdrId,jdbcType=INTEGER}");
        
        return SQL();
    }
}