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
 * 商品表
 * @TableName goods
 */
@TableName(value ="goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods implements Serializable {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商家id
     */
    private Integer businesses_id;

    /**
     * 种类id
     */
    private Integer category_id;

    /**
     * 上架时间
     */
    private Date listing_time;

    /**
     * 价格
     */
    private String price;

    /**
     * 商品状态
     */
    private Integer status;

    /**
     * 商品备注
     */
    private String remark;

    /**
     * 发货地
     */
    private String shippingOrigin;

    /**
     * 商品编号
     */
    private String number;

    /**
     * 头像
     */
    private String avatar;

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
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBusinesses_id() == null ? other.getBusinesses_id() == null : this.getBusinesses_id().equals(other.getBusinesses_id()))
            && (this.getCategory_id() == null ? other.getCategory_id() == null : this.getCategory_id().equals(other.getCategory_id()))
            && (this.getListing_time() == null ? other.getListing_time() == null : this.getListing_time().equals(other.getListing_time()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getShippingOrigin() == null ? other.getShippingOrigin() == null : this.getShippingOrigin().equals(other.getShippingOrigin()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBusinesses_id() == null) ? 0 : getBusinesses_id().hashCode());
        result = prime * result + ((getCategory_id() == null) ? 0 : getCategory_id().hashCode());
        result = prime * result + ((getListing_time() == null) ? 0 : getListing_time().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getShippingOrigin() == null) ? 0 : getShippingOrigin().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", businesses_id=").append(businesses_id);
        sb.append(", category_id=").append(category_id);
        sb.append(", listing_time=").append(listing_time);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", shippingOrigin=").append(shippingOrigin);
        sb.append(", number=").append(number);
        sb.append(", avatar=").append(avatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}