package cn.com.springboot.shopping.mapper;

import cn.com.springboot.shopping.entity.SpPay;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpPayMapper {
    @Delete({
        "delete from sp_pay",
        "where py_id = #{pyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pyId);

    @Insert({
        "insert into sp_pay (py_id, py_name, ",
        "py_img)",
        "values (#{pyId,jdbcType=INTEGER}, #{pyName,jdbcType=VARCHAR}, ",
        "#{pyImg,jdbcType=VARCHAR})"
    })
    int insert(SpPay record);

    @InsertProvider(type=SpPaySqlProvider.class, method="insertSelective")
    int insertSelective(SpPay record);

    @Select({
        "select",
        "py_id, py_name, py_img",
        "from sp_pay",
        "where py_id = #{pyId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="py_id", property="pyId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="py_name", property="pyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="py_img", property="pyImg", jdbcType=JdbcType.VARCHAR)
    })
    SpPay selectByPrimaryKey(Integer pyId);

    @UpdateProvider(type=SpPaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpPay record);

    @Update({
        "update sp_pay",
        "set py_name = #{pyName,jdbcType=VARCHAR},",
          "py_img = #{pyImg,jdbcType=VARCHAR}",
        "where py_id = #{pyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpPay record);
}