import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DataRepositoryTest {

    private DataRepository repo;

    @BeforeEach
    void setup() {
        repo = new DataRepository();
    }

    @Test
    void FileLocationTest() {
        File f = new File(repo.MEMBER_FILE);
        System.out.println(f.getAbsolutePath());
        assertThat(f.exists()).isTrue();
    }

    @Test
    void readMember() throws FileNotFoundException {
        repo.readMember();
        List<Member> members = repo.getMembers();
        assertThat(members.get(members.size() - 1).getName()).isEqualTo("Honux");
        assertThat(members.get(members.size() - 1).getGithubId()).isEqualTo("honux77");

    }
}