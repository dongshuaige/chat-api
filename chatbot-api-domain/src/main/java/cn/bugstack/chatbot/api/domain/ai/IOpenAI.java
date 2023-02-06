package cn.bugstack.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @description: ChatGPT open ai 接口：https://beta.openai.com/account/api-keys
 * @author：hgd
 * @date: 2023-02-05
 */
public interface IOpenAI {

    String doChatGPT(String openAiKey,String question) throws IOException;
}
