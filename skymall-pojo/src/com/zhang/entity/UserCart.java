package com.zhang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车商品关系表
 * @TableName user_cart
 */
@TableName(value ="user_cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCart implements Serializable {
    /**
     * 购物车id
     */
    @TableId(type = IdType.AUTO)
    private Integer cart_id;

    /**
     * 用户id
     */
    private Integer user_id;

    /**
     * 商品id
     */
    private String goods_id;

    /**
     * 商品数量
     */
    private Integer goods_numb;

    /**
     * 创建时间
     */
    private Date create_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserCart other = (UserCart) that;
        return (this.getCart_id() == null ? other.getCart_id() == null : this.getCart_id().equals(other.getCart_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getGoods_id() == null ? other.getGoods_id() == null : this.getGoods_id().equals(other.getGoods_id()))
            && (this.getGoods_numb() == null ? other.getGoods_numb() == null : this.getGoods_numb().equals(other.getGoods_numb()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCart_id() == null) ? 0 : getCart_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getGoods_id() == null) ? 0 : getGoods_id().hashCode());
        result = prime * result + ((getGoods_numb() == null) ? 0 : getGoods_numb().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cart_id=").append(cart_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", goods_id=").append(goods_id);
        sb.append(", goods_numb=").append(goods_numb);
        sb.append(", create_time=").append(create_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}