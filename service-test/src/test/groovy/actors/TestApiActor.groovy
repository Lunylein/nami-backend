package actors

import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.Request

class TestApiActor {
    private final OkHttpClient client

    TestApiActor(OkHttpClient client){
        this.client = client
    }

    Response getAllTests() {
        Request request = new Request.Builder()
                .url("https://localhost:8080/api/tests")
                .build();

        return client.newCall(request).execute()
    }
}
