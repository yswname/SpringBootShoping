package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpOrderItem;

public class SpOrderItemSqlProvider {

    public String insertSelective(SpOrderItem record) {
        BEGIN();
        INSERT_INTO("sp_order_item");
        
        if (record.getOdItId() != null) {
            VALUES("od_it_id", "#{odItId,jdbcType=INTEGER}");
        }
        
        if (record.getOdItPrId() != null) {
            VALUES("od_it_pr_id", "#{odItPrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdItNumber() != null) {
            VALUES("od_it_number", "#{odItNumber,jdbcType=INTEGER}");
        }
        
        if (record.getOdItPrice() != null) {
            VALUES("od_it_price", "#{odItPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getOdItOdId() != null) {
            VALUES("od_it_od_id", "#{odItOdId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpOrderItem record) {
        BEGIN();
        UPDATE("sp_order_item");
        
        if (record.getOdItPrId() != null) {
            SET("od_it_pr_id = #{odItPrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdItNumber() != null) {
            SET("od_it_number = #{odItNumber,jdbcType=INTEGER}");
        }
        
        if (record.getOdItPrice() != null) {
            SET("od_it_price = #{odItPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getOdItOdId() != null) {
            SET("od_it_od_id = #{odItOdId,jdbcType=INTEGER}");
        }
        
        WHERE("od_it_id = #{odItId,jdbcType=INTEGER}");
        
        return SQL();
    }
}