/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2018年02月23日 16:37
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */

package com.suixingpay.datas.common.statistics;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * 统计信息
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2018年02月23日 16:37
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2018年02月23日 16:37
 */

public abstract class StatisticData {
    @Setter @Getter private String nodeId;

    @JSONField(serialize = false, deserialize = false)
    public abstract String getCategory();

    @JSONField(serialize = false, deserialize = false)
    public String getId() {
        return UUID.randomUUID().toString();
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String toPrintln() {
        JSONObject jsonObject = JSONObject.parseObject(toString());
        StringBuilder sb = new StringBuilder();
        jsonObject.entrySet().forEach(p -> {
            sb.append(p.getKey()).append(":").append("      ").append((null != p.getValue() ? p.getValue() : ""))
                    .append(System.lineSeparator());
        });
        return sb.toString();
    }
}
