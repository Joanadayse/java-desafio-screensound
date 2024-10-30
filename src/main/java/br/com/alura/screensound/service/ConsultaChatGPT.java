package br.com.alura.screensound.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obterInformacao(String texto){
        String apiKey = System.getenv("OPENAI_APIKEY");
        OpenAiService service = new OpenAiService(apiKey);

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct") // Use o novo modelo de linguagem
                .prompt("me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(request);
        return resposta.getChoices().get(0).getText();
    }
}
