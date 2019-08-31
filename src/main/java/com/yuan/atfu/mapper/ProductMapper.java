package com.yuan.atfu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.atfu.domain.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * MySQL like 查询
     *
     * @param page
     * @param content
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yuan.atfu.domain.entity.Product>
     * @author David Hong
     */
    @Select("select * from product where no like #{content} or type like #{content} or brand like #{content} or package_type like #{content} order by gmt_create desc")
    IPage<Product> search(IPage<Product> page, String content);

}
