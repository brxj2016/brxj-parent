package com.brxj.consumer.session;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * WEB会话
 *
 * @author qianrui
 */
public final class WebSession {

    /** WEB会话上下文 */
    private static final ThreadLocal<WebSession> WEB_SESSION_CONTEXT = new ThreadLocal<>();

    /** 内容 */
    private final Map<String, SessionContent> CONTENT;

    private WebSession() {
        this.CONTENT = new HashMap<>();
    }

    /** 会话 */
    public static WebSession session() {
        var session = WEB_SESSION_CONTEXT.get();

        if (Objects.isNull(session)) {
            session = new WebSession();
            WEB_SESSION_CONTEXT.set(session);
        }

        return session;
    }

    /**
     * 清理
     */
    public static void clear() {
        WEB_SESSION_CONTEXT.remove();
    }

    /**
     * 获取内容
     *
     * @param sessionName 内容名称
     *
     * @return {@link SessionContent} 内容
     */
    public SessionContent content(SessionName sessionName) {
        return CONTENT.get(sessionName.getName());
    }

    /**
     * 设置内容, 并返回会话
     *
     * @param content 内容
     *
     * @return {@link WebSession} 会话
     */
    public WebSession content(SessionContent content) {
        CONTENT.put(content.name(), content);

        return this;
    }
}
