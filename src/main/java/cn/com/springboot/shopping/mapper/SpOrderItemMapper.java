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

import cn.com.springboot.shopping.entity.SpOrderItem;

public interface SpOrderItemMapper {
    @Delete({
        "delete from sp_order_item",
        "where od_it_id = #{odItId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer odItId);

    @Insert({
        "insert into sp_order_item (od_it_id, od_it_pr_id, ",
        "od_it_number, od_it_price, ",
        "od_it_od_id)",
        "values (#{odItId,jdbcType=INTEGER}, #{odItPrId,jdbcType=INTEGER}, ",
        "#{odItNumber,jdbcType=INTEGER}, #{odItPrice,jdbcType=DOUBLE}, ",
        "#{odItOdId,jdbcType=INTEGER})"
    })
    int insert(SpOrderItem record);

    @InsertProvider(type=SpOrderItemSqlProvider.class, method="insertSelective")
    int insertSelective(SpOrderItem record);

    @Select({
        "select",
        "od_it_id, od_it_pr_id, od_it_number, od_it_price, od_it_od_id",
        "from sp_order_item",
        "where od_it_id = #{odItId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="od_it_id", property="odItId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="od_it_pr_id", property="odItPrId", jdbcType=JdbcType.INTEGER),
        @Result(column="od_it_number", property="odItNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="od_it_price", property="odItPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="od_it_od_id", property="odItOdId", jdbcType=JdbcType.INTEGER)
    })
    SpOrderItem selectByPrimaryKey(Integer odItId);

    @UpdateProvider(type=SpOrderItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpOrderItem record);

    @Update({
        "update sp_order_item",
        "set od_it_pr_id = #{odItPrId,jdbcType=INTEGER},",
          "od_it_number = #{odItNumber,jdbcType=INTEGER},",
          "od_it_price = #{odItPrice,jdbcType=DOUBLE},",
          "od_it_od_id = #{odItOdId,jdbcType=INTEGER}",
        "where od_it_id = #{odItId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpOrderItem record);
}