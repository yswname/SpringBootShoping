package cn.com.springboot.shopping.mapper;

import cn.com.springboot.shopping.entity.SpIdCard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpIdCardMapper {
    @Delete({
        "delete from sp_id_card",
        "where ic_id = #{icId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer icId);

    @Insert({
        "insert into sp_id_card (ic_id, ic_code, ",
        "ic_name)",
        "values (#{icId,jdbcType=INTEGER}, #{icCode,jdbcType=CHAR}, ",
        "#{icName,jdbcType=VARCHAR})"
    })
    int insert(SpIdCard record);

    @InsertProvider(type=SpIdCardSqlProvider.class, method="insertSelective")
    int insertSelective(SpIdCard record);

    @Select({
        "select",
        "ic_id, ic_code, ic_name",
        "from sp_id_card",
        "where ic_id = #{icId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ic_id", property="icId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ic_code", property="icCode", jdbcType=JdbcType.CHAR),
        @Result(column="ic_name", property="icName", jdbcType=JdbcType.VARCHAR)
    })
    SpIdCard selectByPrimaryKey(Integer icId);

    @UpdateProvider(type=SpIdCardSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpIdCard record);

    @Update({
        "update sp_id_card",
        "set ic_code = #{icCode,jdbcType=CHAR},",
          "ic_name = #{icName,jdbcType=VARCHAR}",
        "where ic_id = #{icId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpIdCard record);
}