public class Member {

    private String name;
    private String githubId;

    public Member(String name, String githubId) {
        this.name = name;
        this.githubId = githubId;
    }

    public String getName() {
        return name;
    }

    public String getGithubId() {
        return githubId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", githubId='" + githubId + '\'' +
                '}';
    }
}
