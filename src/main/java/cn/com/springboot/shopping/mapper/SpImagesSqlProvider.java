package cn.com.springboot.shopping.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.springboot.shopping.entity.SpImages;

public class SpImagesSqlProvider {

    public String insertSelective(SpImages record) {
        BEGIN();
        INSERT_INTO("sp_images");
        
        if (record.getImgId() != null) {
            VALUES("img_id", "#{imgId,jdbcType=INTEGER}");
        }
        
        if (record.getImgTitle() != null) {
            VALUES("img_title", "#{imgTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            VALUES("img_url", "#{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getImgType() != null) {
            VALUES("img_type", "#{imgType,jdbcType=INTEGER}");
        }
        
        if (record.getImgPrId() != null) {
            VALUES("img_pr_id", "#{imgPrId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SpImages record) {
        BEGIN();
        UPDATE("sp_images");
        
        if (record.getImgTitle() != null) {
            SET("img_title = #{imgTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            SET("img_url = #{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getImgType() != null) {
            SET("img_type = #{imgType,jdbcType=INTEGER}");
        }
        
        if (record.getImgPrId() != null) {
            SET("img_pr_id = #{imgPrId,jdbcType=INTEGER}");
        }
        
        WHERE("img_id = #{imgId,jdbcType=INTEGER}");
        
        return SQL();
    }
}