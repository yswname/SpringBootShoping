package cn.com.springboot.shopping.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import cn.com.springboot.shopping.entity.SpProAttr;

public interface SpProAttrMapper {
    @Delete({
        "delete from sp_pro_attr",
        "where pro_attr_id = #{proAttrId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer proAttrId);

    @Insert({
        "insert into sp_pro_attr (pro_attr_id, pro_attr_name, ",
        "pro_attr_code, pro_attr_ct_id)",
        "values (#{proAttrId,jdbcType=INTEGER}, #{proAttrName,jdbcType=VARCHAR}, ",
        "#{proAttrCode,jdbcType=VARCHAR}, #{proAttrCtId,jdbcType=INTEGER})"
    })
    int insert(SpProAttr record);

    @InsertProvider(type=SpProAttrSqlProvider.class, method="insertSelective")
    int insertSelective(SpProAttr record);

    @Select({
        "select",
        "pro_attr_id, pro_attr_name, pro_attr_code, pro_attr_ct_id",
        "from sp_pro_attr",
        "where pro_attr_id = #{proAttrId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="pro_attr_id", property="proAttrId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pro_attr_name", property="proAttrName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_attr_code", property="proAttrCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_attr_ct_id", property="proAttrCtId", jdbcType=JdbcType.INTEGER)
    })
    SpProAttr selectByPrimaryKey(Integer proAttrId);

    @UpdateProvider(type=SpProAttrSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpProAttr record);

    @Update({
        "update sp_pro_attr",
        "set pro_attr_name = #{proAttrName,jdbcType=VARCHAR},",
          "pro_attr_code = #{proAttrCode,jdbcType=VARCHAR},",
          "pro_attr_ct_id = #{proAttrCtId,jdbcType=INTEGER}",
        "where pro_attr_id = #{proAttrId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpProAttr record);
}