import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataRepository {


    public final String MEMBER_FILE = "src/main/resources/member.csv";
    private final String LOGO_FILE = "src/main/resources/logo.txt";

    private List<Member> members = new ArrayList<>();

    public void readMember() throws FileNotFoundException {
        Scanner s = new Scanner(new File(MEMBER_FILE));
        while (s.hasNext()) {
            String[] line = s.nextLine().split(",");
            members.add(new Member(line[0], line[1]));
        }
        s.close();
    }

    public String loadLogo() throws FileNotFoundException {
        Scanner s = new Scanner(new File(LOGO_FILE));
        String logo = "";
        while (s.hasNext()) {
            String l = s.nextLine();
            System.out.println(l);
            logo += l + "\n";
        }
        s.close();
        return logo;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void mixMember() {
        Collections.shuffle(members);
    }
}
