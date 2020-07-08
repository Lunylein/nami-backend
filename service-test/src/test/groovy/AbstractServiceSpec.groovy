import actors.DatabaseActor
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest()
class AbstractServiceSpec extends Specification{

    static DatabaseActor databaseActor = new DatabaseActor()

    def setup() {
        databaseActor.clearAll()
    }

    def cleanup(){
        databaseActor.clearAll()
    }
}
