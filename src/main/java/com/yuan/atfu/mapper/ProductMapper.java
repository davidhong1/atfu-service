package com.yuan.atfu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuan.atfu.domain.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    @Select("select * from product where no like #{content} or type like #{content} or brand like #{content} or package_type like #{content} order by gmt_create desc")
    public IPage<Product> search(IPage<Product> page, String content);

}
