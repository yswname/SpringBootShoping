package cn.com.springboot.shopping.mapper;

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

import cn.com.springboot.shopping.entity.SpImages;

public interface SpImagesMapper {
	@Select("select * from sp_images where img_type=1 and img_pr_id=#{prId}")
	@ResultMap("SpImagesMap")
	public SpImages findListPicByPrId(int prId);
	
    @Delete({
        "delete from sp_images",
        "where img_id = #{imgId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer imgId);

    @Insert({
        "insert into sp_images (img_id, img_title, ",
        "img_url, img_type, ",
        "img_pr_id)",
        "values (#{imgId,jdbcType=INTEGER}, #{imgTitle,jdbcType=VARCHAR}, ",
        "#{imgUrl,jdbcType=VARCHAR}, #{imgType,jdbcType=INTEGER}, ",
        "#{imgPrId,jdbcType=INTEGER})"
    })
    int insert(SpImages record);

    @InsertProvider(type=SpImagesSqlProvider.class, method="insertSelective")
    int insertSelective(SpImages record);

    @Select({
        "select",
        "img_id, img_title, img_url, img_type, img_pr_id",
        "from sp_images",
        "where img_id = #{imgId,jdbcType=INTEGER}"
    })
    @Results(id="SpImagesMap", value={
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="img_title", property="imgTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_url", property="imgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_type", property="imgType", jdbcType=JdbcType.INTEGER),
        @Result(column="img_pr_id", property="imgPrId", jdbcType=JdbcType.INTEGER)
    })
    SpImages selectByPrimaryKey(Integer imgId);

    @UpdateProvider(type=SpImagesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpImages record);

    @Update({
        "update sp_images",
        "set img_title = #{imgTitle,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR},",
          "img_type = #{imgType,jdbcType=INTEGER},",
          "img_pr_id = #{imgPrId,jdbcType=INTEGER}",
        "where img_id = #{imgId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpImages record);
}