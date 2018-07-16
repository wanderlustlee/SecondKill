package com.scut.seckill.web.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecKillRequest {

    private Integer userId;

    private Integer productId;

    public Integer getUserId() {
        return userId;
    }

    public Integer getProductId() {
        return productId;
    }
}
