package net.arccode.wechat.pay.api.common.util.json;

public interface JSONErrorListener {
    void start(String text);

    void error(String message, int column);

    void end();
}
