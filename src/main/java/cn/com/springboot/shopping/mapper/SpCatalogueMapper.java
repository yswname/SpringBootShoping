package cn.com.springboot.shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import cn.com.springboot.shopping.entity.SpCatalogue;

public interface SpCatalogueMapper {
	@Select("select * from sp_catalogue order by ct_id")
	@ResultMap("SpCatalogueMap")
	List<SpCatalogue> findAll();
    @Delete({
        "delete from sp_catalogue",
        "where ct_id = #{ctId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ctId);

    @Insert({
        "insert into sp_catalogue (ct_id, ct_name, ",
        "ct_parent_id, ct_remark)",
        "values (#{ctId,jdbcType=INTEGER}, #{ctName,jdbcType=VARCHAR}, ",
        "#{ctParentId,jdbcType=INTEGER}, #{ctRemark,jdbcType=VARCHAR})"
    })
    int insert(SpCatalogue record);

    @InsertProvider(type=SpCatalogueSqlProvider.class, method="insertSelective")
    int insertSelective(SpCatalogue record);

    @Select({
        "select",
        "ct_id, ct_name, ct_parent_id, ct_remark",
        "from sp_catalogue",
        "where ct_id = #{ctId,jdbcType=INTEGER}"
    })
    @Results(id="SpCatalogueMap",value={
        @Result(column="ct_id", property="ctId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ct_name", property="ctName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ct_parent_id", property="ctParentId", jdbcType=JdbcType.INTEGER),
        @Result(column="ct_remark", property="ctRemark", jdbcType=JdbcType.VARCHAR)
    })
    SpCatalogue selectByPrimaryKey(Integer ctId);

    @UpdateProvider(type=SpCatalogueSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpCatalogue record);

    @Update({
        "update sp_catalogue",
        "set ct_name = #{ctName,jdbcType=VARCHAR},",
          "ct_parent_id = #{ctParentId,jdbcType=INTEGER},",
          "ct_remark = #{ctRemark,jdbcType=VARCHAR}",
        "where ct_id = #{ctId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpCatalogue record);
}