package cn.com.springboot.shopping.mapper;

import cn.com.springboot.shopping.entity.SpReceiveAddress;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpReceiveAddressMapper {
    @Delete({
        "delete from sp_receive_address",
        "where re_adr_id = #{reAdrId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer reAdrId);

    @Insert({
        "insert into sp_receive_address (re_adr_id, re_adr_address, ",
        "re_adr_name, re_adr_phone, ",
        "re_adr_ur_id)",
        "values (#{reAdrId,jdbcType=INTEGER}, #{reAdrAddress,jdbcType=VARCHAR}, ",
        "#{reAdrName,jdbcType=VARCHAR}, #{reAdrPhone,jdbcType=VARCHAR}, ",
        "#{reAdrUrId,jdbcType=INTEGER})"
    })
    int insert(SpReceiveAddress record);

    @InsertProvider(type=SpReceiveAddressSqlProvider.class, method="insertSelective")
    int insertSelective(SpReceiveAddress record);

    @Select({
        "select",
        "re_adr_id, re_adr_address, re_adr_name, re_adr_phone, re_adr_ur_id",
        "from sp_receive_address",
        "where re_adr_id = #{reAdrId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="re_adr_id", property="reAdrId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="re_adr_address", property="reAdrAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="re_adr_name", property="reAdrName", jdbcType=JdbcType.VARCHAR),
        @Result(column="re_adr_phone", property="reAdrPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="re_adr_ur_id", property="reAdrUrId", jdbcType=JdbcType.INTEGER)
    })
    SpReceiveAddress selectByPrimaryKey(Integer reAdrId);

    @UpdateProvider(type=SpReceiveAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpReceiveAddress record);

    @Update({
        "update sp_receive_address",
        "set re_adr_address = #{reAdrAddress,jdbcType=VARCHAR},",
          "re_adr_name = #{reAdrName,jdbcType=VARCHAR},",
          "re_adr_phone = #{reAdrPhone,jdbcType=VARCHAR},",
          "re_adr_ur_id = #{reAdrUrId,jdbcType=INTEGER}",
        "where re_adr_id = #{reAdrId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpReceiveAddress record);
}