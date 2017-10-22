## 背景

让使用微信支付的朋友最快速度接入微信支付.

## 核心

两行代码解决微信支付提供的各种服务, 开箱即用, 可扩展性超强(只需根据服务的上下行协议定义协议类后, 放入工厂即可获取调用结果).

## 最近发布

```
<dependency>
    <groupId>net.arccode</groupId>
    <artifactId>wechat-pay-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 架构图

![](http://www.arccode.net/images/wx-pay-sdk-2.jpg)

## 依赖

* JDK >= 1.7

目前发送`http`采用`okhttp`(更简洁, 更高效), 而`okhttp`依赖的JDK版本必须大于或等于`1.7`, 有需要兼容JDK 1.6的同学可以提`Issues`或`Pull requests`.

## 项目源代码

* 源码地址 [https://github.com/arccode/wechat-pay-sdk](https://github.com/arccode/wechat-pay-sdk)

## 目前支持的服务及调用示例

所有服务在单元测试类(WXPayClientTest.java)中均已测试通过, 下行参数`response.isSuccess == true`表示服务调用成功.

### 扫码支付

官方文档详见: [https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1](https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1)

```
String nonceStr = SDKUtils.genRandomStringByLength(32);
UnifiedOrderRequest request = new UnifiedOrderRequest("donate-899",SDKUtils.genOutTradeNo(),1, "192.168.1.1", asyncNotifyUrl, "NATIVE", nonceStr);
UnifiedOrderResponse response = wxPayClient.execute(request);
Assert.assertNotNull(response);
LOG.info(JSON.toJSONString(response));
// TODO 开发人员根据 response中的属性值处理业务逻辑, 此处可完美嵌入业务层(小型系统)或服务层(大型系统)
```

### 公众号支付

官方文档详见: [https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1](https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1)

```
String nonceStr = SDKUtils.genRandomStringByLength(32);
UnifiedOrderRequest request = new UnifiedOrderRequest("donate-899",SDKUtils.genOutTradeNo(),
                1, "192.168.1.1", asyncNotifyUrl, "JSAPI", nonceStr);
request.setOpenId("oKVmeuHht8J0Ni58CSNe474AHA3E");
UnifiedOrderResponse response = wxPayClient.execute(request);
Assert.assertNotNull(response);
LOG.info(JSON.toJSONString(response));
// TODO 开发人员根据 response中的属性值处理业务逻辑, 此处可完美嵌入业务层(小型系统)或服务层(大型系统)
```

### APP支付

官方文档详见: [https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1](https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1)

```
String nonceStr = SDKUtils.genRandomStringByLength(32);
UnifiedOrderRequest request = new UnifiedOrderRequest("donate-899",SDKUtils.genOutTradeNo(),
                1, "192.168.1.1", asyncNotifyUrl, "APP", nonceStr);
UnifiedOrderResponse response = wxPayClient.execute(request);
Assert.assertNotNull(response);
LOG.info(JSON.toJSONString(response));
// TODO 开发人员根据 response中的属性值处理业务逻辑, 此处可完美嵌入业务层(小型系统)或服务层(大型系统)
```

### 商家支付


官方文档详见: [https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2](https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2)

```
String nonceStr = SDKUtils.genRandomStringByLength(32);
String customerOpenId = "oKVmeuHht8J0Ni58CSNe474AHA3E";
MchPayRequest mchPayRequest = new MchPayRequest(SDKUtils.genOutTradeNo(),
                customerOpenId, "NO_CHECK", 100, "xxxx年xx月结算", "192.168.1.1", nonceStr);
MchPayResponse response = wxPayVIPClient.execute(mchPayRequest);
Assert.assertNotNull(response);
LOG.info(JSON.toJSONString(response));
// TODO 开发人员根据 response中的属性值处理业务逻辑, 此处可完美嵌入业务层(小型系统)或服务层(大型系统)
```

### 退款

官方文档详见: [https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4&index=6](https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4&index=6)

```
String nonceStr = SDKUtils.genRandomStringByLength(32);
RefundRequest request = new RefundRequest("T15121416014891124211768",
                SDKUtils.genOutRefundNo(), 1, 1, "112102020", nonceStr);
RefundResponse response = wxPayVIPClient.execute(request);
Assert.assertNotNull(response);
LOG.info(JSON.toJSONString(response));
// TODO 开发人员根据 response中的属性值处理业务逻辑, 此处可完美嵌入业务层(小型系统)或服务层(大型系统)
```

### 支付异步通知解析

官方文档详见: [https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_7](https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_7)

```
String notifyTxt = "<xml>\n" +
                "  <appid><![CDATA[wx2421b1c4370eccdcd]]></appid>\n" +
                "  <attach><![CDATA[支付测试]]></attach>\n" +
                "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
                "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n" +
                "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "  <total_fee>1</total_fee>\n" +
                "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml>";
PayNotifyResponse response = wxPayClient.parseNotify(notifyTxt, PayNotifyResponse.class);
Assert.assertNotNull(response);
LOG.info(JSON.toJSONString(response));
// TODO 开发人员根据 response中的属性值处理业务逻辑, 此处可完美嵌入业务层(小型系统)或服务层(大型系统)
```

### 刷卡支付

官方文档详见: [https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_10&index=1](https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_10&index=1)

目前未使用, 待续......

## 扩展

该SDK设计了一个服务工厂, 该工厂中包含HTTP执行器/返回数据解析方式(json/xml)/入参数据格式(json/xml)构造等, 开发人员需要增加服务仅需要根据服务协议文档编写上下行协议, 并在协议中指明API接口和返回数据类型, 再将上行协议放入工厂中执行即可; 可参考已完成的服务协议进行扩展编写.


## License

[MIT](http://opensource.org/licenses/MIT)

Copyright (c) 2017-present, arccode