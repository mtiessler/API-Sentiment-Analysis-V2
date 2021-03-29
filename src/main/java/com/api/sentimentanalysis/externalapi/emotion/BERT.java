package com.api.sentimentanalysis.externalapi.emotion;

import okhttp3.*;
import org.json.simple.JSONObject;

import java.io.IOException;

/** This class contains a method to execute the sentiment analysis with BERT model.
 *
 * @author Ariadna de Arriba
 */
public class BERT implements EmotionAnalysisAPI
{
    private String apiKey;
    private String host = "http://127.0.0.1:5000/api/v1/";

    /**
     * Constructor.
     * @param apiKey Api-key to authorize the method.
     */
    public BERT(String apiKey)
    {
        this.apiKey = apiKey;
    }

    /** Make a request to BERT for sentiment analysis.
     *
     * @param text Text to analyze.
     * @return Returns a string that contains a json with each of six emotions weighted.
     * @throws NullPointerException {@link NullPointerException caused by an error during a call to the API and returns nothing.}
     * @throws IOException {@link IOException caused by an error in the API call. }
     */
    public String getEmotion(String text) throws NullPointerException, IOException
    {
        if (this.apiKey != null)
        {
            String url = host + "emotion";
            OkHttpClient client = new OkHttpClient();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("text", text);
            String json = jsonObject.toString();

            RequestBody requestBody = RequestBody.create(
                    json,
                    MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("x-api-key", apiKey)
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } else
        {
            throw new NullPointerException("No api-key provided");
        }
    }
}