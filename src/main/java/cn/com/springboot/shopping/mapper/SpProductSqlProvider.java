package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpProduct;

public class SpProductSqlProvider {

    public String insertSelective(SpProduct record) {
        BEGIN();
        INSERT_INTO("sp_product");
        
        if (record.getPrId() != null) {
            VALUES("pr_id", "#{prId,jdbcType=INTEGER}");
        }
        
        if (record.getPrPrice() != null) {
            VALUES("pr_price", "#{prPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getPrTitle() != null) {
            VALUES("pr_title", "#{prTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPrSimpleDesc() != null) {
            VALUES("pr_simple_desc", "#{prSimpleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getPrCtId() != null) {
            VALUES("pr_ct_id", "#{prCtId,jdbcType=INTEGER}");
        }
        
        if (record.getPrAttrs() != null) {
            VALUES("pr_attrs", "#{prAttrs,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPrDetailDesc() != null) {
            VALUES("pr_detail_desc", "#{prDetailDesc,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpProduct record) {
        BEGIN();
        UPDATE("sp_product");
        
        if (record.getPrPrice() != null) {
            SET("pr_price = #{prPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getPrTitle() != null) {
            SET("pr_title = #{prTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getPrSimpleDesc() != null) {
            SET("pr_simple_desc = #{prSimpleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getPrCtId() != null) {
            SET("pr_ct_id = #{prCtId,jdbcType=INTEGER}");
        }
        
        if (record.getPrAttrs() != null) {
            SET("pr_attrs = #{prAttrs,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPrDetailDesc() != null) {
            SET("pr_detail_desc = #{prDetailDesc,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("pr_id = #{prId,jdbcType=INTEGER}");
        
        return SQL();
    }
}