package net.arccode.wechat.pay.api.common.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author http://arccode.net
 * @since 2015-11-24
 */
public class RandomUtilsTest {


    private static final Logger LOG = LoggerFactory.getLogger(RandomUtilsTest.class);

    @Test
    public void randomStr() {

        LOG.info(SDKUtils.genRandomStringByLength(32));
    }
}
