package com.yuan.atfu.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品型号
     */
    private String no;

    /**
     * 产品类别
     */
    private String type;

    /**
     * 所属品牌
     */
    private String brand;

    /**
     * 封装类型
     */
    private String packageType;

    /**
     * 批次
     */
    private String batch;

    /**
     * 库存数量
     */
    private Long inventory;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    @TableLogic
    private Integer deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
