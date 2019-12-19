package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpShopCarItem;

public class SpShopCarItemSqlProvider {

    public String insertSelective(SpShopCarItem record) {
        BEGIN();
        INSERT_INTO("sp_shoper_car_item");
        
        if (record.getCarItId() != null) {
            VALUES("car_it_id", "#{carItId,jdbcType=INTEGER}");
        }
        
        if (record.getCarItPrId() != null) {
            VALUES("car_it_pr_id", "#{carItPrId,jdbcType=INTEGER}");
        }
        
        if (record.getCarItNumber() != null) {
            VALUES("car_it_number", "#{carItNumber,jdbcType=INTEGER}");
        }
        
        if (record.getCarItUrId() != null) {
            VALUES("car_it_ur_id", "#{carItUrId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpShopCarItem record) {
        BEGIN();
        UPDATE("sp_shoper_car_item");
        
        if (record.getCarItPrId() != null) {
            SET("car_it_pr_id = #{carItPrId,jdbcType=INTEGER}");
        }
        
        if (record.getCarItNumber() != null) {
            SET("car_it_number = #{carItNumber,jdbcType=INTEGER}");
        }
        
        if (record.getCarItUrId() != null) {
            SET("car_it_ur_id = #{carItUrId,jdbcType=INTEGER}");
        }
        
        WHERE("car_it_id = #{carItId,jdbcType=INTEGER}");
        
        return SQL();
    }
}