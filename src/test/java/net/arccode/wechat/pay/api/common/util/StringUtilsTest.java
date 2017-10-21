package net.arccode.wechat.pay.api.common.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author http://arccode.net
 * @since 2015-11-24
 */
public class StringUtilsTest {


    private static final Logger LOG = LoggerFactory.getLogger(StringUtilsTest.class);

    @Test
    public void regx() {
        String phone = "";

        boolean flag = StringUtils.isPhoneNum(phone);

        LOG.info(flag + "");
    }

}
