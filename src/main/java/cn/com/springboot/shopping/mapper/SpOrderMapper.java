package cn.com.springboot.shopping.mapper;

import cn.com.springboot.shopping.entity.SpOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpOrderMapper {
    @Delete({
        "delete from sp_order",
        "where od_id = #{odId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer odId);

    @Insert({
        "insert into sp_order (od_id, od_code, ",
        "od_create_time, od_ur_id, ",
        "od_address_id, od_status, ",
        "od_py_id)",
        "values (#{odId,jdbcType=INTEGER}, #{odCode,jdbcType=VARCHAR}, ",
        "#{odCreateTime,jdbcType=TIMESTAMP}, #{odUrId,jdbcType=INTEGER}, ",
        "#{odAddressId,jdbcType=INTEGER}, #{odStatus,jdbcType=INTEGER}, ",
        "#{odPyId,jdbcType=INTEGER})"
    })
    int insert(SpOrder record);

    @InsertProvider(type=SpOrderSqlProvider.class, method="insertSelective")
    int insertSelective(SpOrder record);

    @Select({
        "select",
        "od_id, od_code, od_create_time, od_ur_id, od_address_id, od_status, od_py_id",
        "from sp_order",
        "where od_id = #{odId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="od_id", property="odId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="od_code", property="odCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="od_create_time", property="odCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="od_ur_id", property="odUrId", jdbcType=JdbcType.INTEGER),
        @Result(column="od_address_id", property="odAddressId", jdbcType=JdbcType.INTEGER),
        @Result(column="od_status", property="odStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="od_py_id", property="odPyId", jdbcType=JdbcType.INTEGER)
    })
    SpOrder selectByPrimaryKey(Integer odId);

    @UpdateProvider(type=SpOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpOrder record);

    @Update({
        "update sp_order",
        "set od_code = #{odCode,jdbcType=VARCHAR},",
          "od_create_time = #{odCreateTime,jdbcType=TIMESTAMP},",
          "od_ur_id = #{odUrId,jdbcType=INTEGER},",
          "od_address_id = #{odAddressId,jdbcType=INTEGER},",
          "od_status = #{odStatus,jdbcType=INTEGER},",
          "od_py_id = #{odPyId,jdbcType=INTEGER}",
        "where od_id = #{odId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpOrder record);
}