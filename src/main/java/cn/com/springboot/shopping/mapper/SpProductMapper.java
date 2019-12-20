package cn.com.springboot.shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import cn.com.springboot.shopping.entity.SpProduct;

public interface SpProductMapper {
    @Delete({
        "delete from sp_product",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer prId);
    @Select("select * from sp_product where pr_ct_id=#{cataId} order by pr_id")
    @ResultMap("SpProductMap")
    List<SpProduct> findProListByCataId(int cataId);

    @Insert({
        "insert into sp_product (pr_id, pr_price, ",
        "pr_title, pr_simple_desc, ",
        "pr_ct_id, pr_attrs, ",
        "pr_detail_desc)",
        "values (#{prId,jdbcType=INTEGER}, #{prPrice,jdbcType=DOUBLE}, ",
        "#{prTitle,jdbcType=VARCHAR}, #{prSimpleDesc,jdbcType=VARCHAR}, ",
        "#{prCtId,jdbcType=INTEGER}, #{prAttrs,jdbcType=LONGVARCHAR}, ",
        "#{prDetailDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(SpProduct record);

    @InsertProvider(type=SpProductSqlProvider.class, method="insertSelective")
    int insertSelective(SpProduct record);

    @Select({
        "select",
        "pr_id, pr_price, pr_title, pr_simple_desc, pr_ct_id, pr_attrs, pr_detail_desc",
        "from sp_product",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    @Results(id="SpProductMap", value={
        @Result(column="pr_id", property="prId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pr_price", property="prPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="pr_title", property="prTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="pr_simple_desc", property="prSimpleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="pr_ct_id", property="prCtId", jdbcType=JdbcType.INTEGER),
        @Result(column="pr_attrs", property="prAttrs", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="pr_detail_desc", property="prDetailDesc", jdbcType=JdbcType.LONGVARCHAR),
        
        @Result(column="pr_id", property="listPic", one=@One(select="cn.com.springboot.shopping.mapper.SpImagesMapper.findListPicByPrId", fetchType=FetchType.EAGER))
        
        
    })
    SpProduct selectByPrimaryKey(Integer prId);

    @UpdateProvider(type=SpProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpProduct record);

    @Update({
        "update sp_product",
        "set pr_price = #{prPrice,jdbcType=DOUBLE},",
          "pr_title = #{prTitle,jdbcType=VARCHAR},",
          "pr_simple_desc = #{prSimpleDesc,jdbcType=VARCHAR},",
          "pr_ct_id = #{prCtId,jdbcType=INTEGER},",
          "pr_attrs = #{prAttrs,jdbcType=LONGVARCHAR},",
          "pr_detail_desc = #{prDetailDesc,jdbcType=LONGVARCHAR}",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SpProduct record);

    @Update({
        "update sp_product",
        "set pr_price = #{prPrice,jdbcType=DOUBLE},",
          "pr_title = #{prTitle,jdbcType=VARCHAR},",
          "pr_simple_desc = #{prSimpleDesc,jdbcType=VARCHAR},",
          "pr_ct_id = #{prCtId,jdbcType=INTEGER}",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpProduct record);
}