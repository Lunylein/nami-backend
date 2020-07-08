import actors.TestApiActor
import okhttp3.OkHttpClient
import okhttp3.Response

import static data.TestFixture.*

class TestSpec extends AbstractServiceSpec {
    static TestApiActor testApiActor = new TestApiActor(new OkHttpClient())

    def "can get all saved test entities"() {
        given:
        databaseActor.insert(TEST_ENTITY_1, TEST_ENTITY_2)

        when:
        Response response = testApiActor.getAllTests()

        then:
        response.successful
    }
}
