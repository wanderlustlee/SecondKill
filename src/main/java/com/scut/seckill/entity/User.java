package com.scut.seckill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author twc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 创建时间
	 */
	private Date createTime;

    public User(Integer id) {
    	this.id = id;
    }

    public String getUsername() {
        return username;
    }

	public Integer getId() {
		return id;
	}
}
