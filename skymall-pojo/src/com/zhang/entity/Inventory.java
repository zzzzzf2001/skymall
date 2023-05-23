package com.zhang.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 库存表
 * @TableName inventory
 */
@TableName(value ="inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory implements Serializable {
    /**
     * 商品id
     */
    @TableId
    private Integer goods_id;

    /**
     * 库存id
     */
    private Integer id;

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 预警值
     */
    private Integer alert;

    /**
     * 更新时间
     */
    private  LocalDateTime update_time;

    /**
     * 商品销量
     */
    private Integer sales;

    /**
     * 修改人
     */
    private Integer updateUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Integer createUser;

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
        Inventory other = (Inventory) that;
        return (this.getGoods_id() == null ? other.getGoods_id() == null : this.getGoods_id().equals(other.getGoods_id()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
                && (this.getAlert() == null ? other.getAlert() == null : this.getAlert().equals(other.getAlert()))
                && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
                && (this.getSales() == null ? other.getSales() == null : this.getSales().equals(other.getSales()))
                && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoods_id() == null) ? 0 : getGoods_id().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getAlert() == null) ? 0 : getAlert().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getSales() == null) ? 0 : getSales().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goods_id=").append(goods_id);
        sb.append(", id=").append(id);
        sb.append(", stock=").append(stock);
        sb.append(", alert=").append(alert);
        sb.append(", update_time=").append(update_time);
        sb.append(", sales=").append(sales);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}