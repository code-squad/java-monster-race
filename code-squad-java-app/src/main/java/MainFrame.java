import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.List;

public class MainFrame {

    private final Dimension frameSize = new Dimension(640, 300);

    //Design
    private Frame f = new Frame("코드스쿼드");
    private TextArea memberArea = new TextArea("멤버 영역", 30, 20);
    private ScrollPane mainScrollPane = new ScrollPane();
    private Button mixButton = new Button("섞기");

    //Data
    private DataRepository repository = new DataRepository();

    public void init() {
        setLayout();
        addHandler();
        loadData();
    }

    private void setLayout() {
        f.setSize(frameSize);
        f.setLocation(getCenter(Toolkit.getDefaultToolkit().getScreenSize(), frameSize));
        f.setLayout(new FlowLayout());

        mainScrollPane.setSize(520, 260);
        mainScrollPane.setWheelScrollingEnabled(true);
        memberArea.setFont(new Font(Font.MONOSPACED,Font.PLAIN, 14));
        mainScrollPane.add(memberArea);
        f.add(mainScrollPane);
        f.add(mixButton);

    }

    private void loadData() {
        //TODO: 나중에 로딩 상태바 추가하기
        try {
            repository.readMember();
            memberArea.setText(repository.loadLogo());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("멤버 파일 읽기 오류");
        }
    }

    private void addHandler() {
        addWindowHandler();
        mixButton.addActionListener((event)->{
           repository.mixMember();
           memberArea.setText(getTablePositionText());
        });
    }

    private String getTablePositionText() {
        Table[] all = {Table.LEFT, Table.MIDDLE, Table.RIGHT};

        String ret = "";
        int idx = 0;
        for(Table table: all) {
            ret += getSomeMembers(table, idx);
            idx += table.capacity();
        }
        System.out.println(ret);
        return ret;
    }

    private String getSomeMembers(Table table, int startIdx) {
        String ret = table.getPosition();
        List<Member> members = repository.getMembers();

        for(int i = startIdx; i < startIdx + table.capacity(); i++) {
            ret += members.get(i).getName() +"\n";
        }
        return ret;
    }

    private void addWindowHandler() {
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.setVisible(false);
                f.dispose();
                System.out.println("프로그램 종료");
                System.exit(0);
            }

            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }

    public void display() {
        f.setVisible(true);
    }

    private Point getCenter(Dimension outside, Dimension inside) {
        return new Point((outside.width - inside.width) / 2, (outside.height - inside.height) / 2);
    }
}
