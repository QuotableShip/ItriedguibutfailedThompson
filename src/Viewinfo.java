import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @version (yehhhhhh im so close to done, but bet its gonna take my 3 days)
 */
public class Viewinfo extends JFrame {
    private static JFrame Vframe;
    private static JLabel vlabel;
    private static ArrayList<String> nameList;
    private static JLabel studentname_label;
    private static JButton vis_button;
    private static JButton back_button;
    private static JButton viback_button;
    private static JLabel sn_label;
    private static JLabel Name;
    private static JLabel oa_label;
    private static JLabel oatten;
    private static JLabel og_label;
    private static JLabel ogra;

    public Viewinfo() {
        JPanel Vpanel = new JPanel();
        Vframe = new JFrame();
        Vframe.setSize(330, 200);
        Vframe.setVisible(true);
        Vframe.add(Vpanel);

        Vpanel.setLayout(null);
        Color green = new Color(123, 171, 29);
        Vpanel.setBackground(green);

        vlabel = new JLabel("View student info: ");
        vlabel.setBounds(10, 20, 350, 25);
        vlabel.setFont(new Font("Serif", Font.BOLD, 13));
        Vpanel.add(vlabel);

        studentname_label = new JLabel("Student name:");
        studentname_label.setBounds(10, 60, 400, 25);
        Vpanel.add(studentname_label);

        JComboBox<String> Studentname = new JComboBox<>();
        Studentname.setBounds(120, 60, 200, 25);
        Vpanel.add(Studentname);

        try (BufferedReader reader = new BufferedReader(new FileReader("Student_names.txt"))) {
            String line;
            nameList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] splitNames = line.split(",");
                nameList.addAll(Arrays.asList(splitNames));
            }
            for (String name : nameList) {
                Studentname.addItem(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        vis_button = new JButton("View student info");
        vis_button.setBounds(120, 120, 180, 25);
        Vpanel.add(vis_button);

        back_button = new JButton("Back");
        back_button.setBounds(10, 120, 75, 25);
        back_button.setVisible(true);
        Vpanel.add(back_button);

        JPanel vipanel = new JPanel();
        vipanel.setLayout(null);
        vipanel.setVisible(false);

        viback_button = new JButton("Back to other students");
        viback_button.setBounds(5, 120, 180, 25);
        viback_button.setVisible(true);
        vipanel.add(viback_button);

        String studentName = (String) Studentname.getSelectedItem();
        back_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                Vframe.setSize(340, 340);
                Vframe.dispose();
            }
        });

        viback_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Vpanel.setVisible(true);
                vipanel.setVisible(false);
            }
        });

        vis_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Vframe.add(vipanel);
                Vframe.setSize(330, 200);
                vipanel.setVisible(true);
                Vpanel.setVisible(false);

                sn_label = new JLabel("Student name:");
                sn_label.setBounds(10, 20, 400, 25);
                vipanel.add(sn_label);

                String name = (String) Studentname.getSelectedItem();
                Name = new JLabel(name);
                Name.setBounds(150, 20, 400, 25);
                vipanel.add(Name);

                ArrayList<String> attendance = new ArrayList<>();
                String filePath = "Atten.txt";
                int alength = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String firstPart;
                        if (line.contains(",")) {
                            int commaIndex = line.indexOf(',');
                            firstPart = line.substring(0, commaIndex);
                            if (firstPart.equals(name)) {
                                System.out.println(line);
                                attendance.add(line);
                                alength++;
                            }
                        }
                    }
                } catch (IOException m) {
                    m.printStackTrace();
                }
                int counter = 0;
                for (String line : attendance) {
                    String fp = line.substring(7, 11);
                    if (fp.equals("Pres")) {
                        counter++;
                    }
                }
                int OA = (int) ((double)counter/alength * 100);

                System.out.println(alength);
                System.out.println(counter);
                System.out.println("Overall Attendance: " + OA + "%");

                oa_label = new JLabel("Overall attendance:");
                oa_label.setBounds(10, 50, 400, 25);
                vipanel.add(oa_label);

                oatten = new JLabel(String.valueOf(OA)+ "%");
                oatten.setBounds(150, 50, 400, 25);
                vipanel.add(oatten);

                ArrayList<String> grade = new ArrayList<>();
                String fp = "Grades.txt";
                int glength = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(fp))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String firstPart;
                        if (line.contains(",")) {
                            int commaIndex = line.indexOf(',');
                            firstPart = line.substring(0, commaIndex);
                            if (firstPart.equals(name)) {
                                System.out.println(line);
                                grade.add(line);
                                glength++;
                            }
                        }
                    }
                } catch (IOException m) {
                    m.printStackTrace();
                }
                int gcounter = 0;
                for (String line : grade) {
                    String x = line.substring(4, 5);
                    double d = Double.parseDouble(x);
                    gcounter += d;
                }

                double OG = gcounter / glength;  // Calculate the average

                int overallGrade = (int) (OG);  // Calculate the percent

                System.out.println(glength);
                System.out.println(gcounter);
                System.out.println(OG);
                System.out.println(overallGrade);
                System.out.println("Overall Grade: " + overallGrade );


                og_label = new JLabel("Overall grade:");
                og_label.setBounds(10, 80, 400, 25);
                vipanel.add(og_label);

                ogra = new JLabel(String.valueOf(overallGrade));
                ogra.setBounds(150, 80, 400, 25);
                vipanel.add(ogra);

            }
        });
    }
}