package cn.com.springboot.shopping.mapper;

import cn.com.springboot.shopping.entity.SpShopCarItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpShopCarItemMapper {
    @Delete({
        "delete from sp_shoper_car_item",
        "where car_it_id = #{carItId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer carItId);

    @Insert({
        "insert into sp_shoper_car_item (car_it_id, car_it_pr_id, ",
        "car_it_number, car_it_ur_id)",
        "values (#{carItId,jdbcType=INTEGER}, #{carItPrId,jdbcType=INTEGER}, ",
        "#{carItNumber,jdbcType=INTEGER}, #{carItUrId,jdbcType=INTEGER})"
    })
    int insert(SpShopCarItem record);

    @InsertProvider(type=SpShopCarItemSqlProvider.class, method="insertSelective")
    int insertSelective(SpShopCarItem record);

    @Select({
        "select",
        "car_it_id, car_it_pr_id, car_it_number, car_it_ur_id",
        "from sp_shoper_car_item",
        "where car_it_id = #{carItId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="car_it_id", property="carItId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="car_it_pr_id", property="carItPrId", jdbcType=JdbcType.INTEGER),
        @Result(column="car_it_number", property="carItNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="car_it_ur_id", property="carItUrId", jdbcType=JdbcType.INTEGER)
    })
    SpShopCarItem selectByPrimaryKey(Integer carItId);

    @UpdateProvider(type=SpShopCarItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpShopCarItem record);

    @Update({
        "update sp_shoper_car_item",
        "set car_it_pr_id = #{carItPrId,jdbcType=INTEGER},",
          "car_it_number = #{carItNumber,jdbcType=INTEGER},",
          "car_it_ur_id = #{carItUrId,jdbcType=INTEGER}",
        "where car_it_id = #{carItId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpShopCarItem record);
}