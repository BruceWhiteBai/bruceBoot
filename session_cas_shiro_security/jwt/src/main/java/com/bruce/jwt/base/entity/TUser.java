package com.bruce.jwt.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "USER_ID", type = IdType.AUTO)
    private String userId;

    @TableField("USERNAME")
    private String username;

    @TableField("PASSWORD")
    private String password;

    @TableField("PHONE_NUM")
    private Integer phoneNum;

    @TableField("DELETE_FLAG")
    @TableLogic
    private Integer deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
