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

import cn.com.springboot.shopping.entity.SpUser;

public interface SpUserMapper {
	@Select("select * from sp_user order by ur_id")
	@ResultMap("SpUserMap")
	List<SpUser> findAllUsers();
	
    @Delete({
        "delete from sp_user",
        "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer urId);

    @Insert({
        "insert into sp_user (ur_id, ur_user_name, ",
        "ur_password)",
        "values (#{urId,jdbcType=INTEGER}, #{urUserName,jdbcType=VARCHAR}, ",
        "#{urPassword,jdbcType=VARCHAR})"
    })
    int insert(SpUser record);

    @InsertProvider(type=SpUserSqlProvider.class, method="insertSelective")
    int insertSelective(SpUser record);

    @Select({
        "select",
        "ur_id, ur_user_name, ur_password",
        "from sp_user",
        "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    @Results(id="SpUserMap", value={
        @Result(column="ur_id", property="urId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ur_user_name", property="urUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ur_password", property="urPassword", jdbcType=JdbcType.VARCHAR)
    })
    SpUser selectByPrimaryKey(Integer urId);

    @UpdateProvider(type=SpUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpUser record);

    @Update({
        "update sp_user",
        "set ur_user_name = #{urUserName,jdbcType=VARCHAR},",
          "ur_password = #{urPassword,jdbcType=VARCHAR}",
        "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpUser record);
}