import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class listaDeTarefasGUI extends JFrame implements ActionListener {

    //Painel de tarefas
    private JPanel taskPanel, taskComponentPanel;


    public listaDeTarefasGUI() {
        super("Lista de tarefas Aplicacao");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(constantes.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponente();
    }

    private void addGuiComponente() {
        //texto do banner

        JLabel bannerLabel = new JLabel("Lista de tarefas");
        bannerLabel.setFont(createFont("resources/LEMONMILK-Light.otf", 36f));
        bannerLabel.setBounds(
                (constantes.GUI_SIZE.width - bannerLabel.getPreferredSize().width) / 2,
                15,
                constantes.BANNER_SIZE.width,
                constantes.BANNER_SIZE.height

        );

        // taskPanel
        taskPanel = new JPanel();

        //TaskcomponentPanel
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        //adiociona o scroll no painel das task
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, constantes.TASKPANEL_SIZE.width, constantes.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(constantes.TASKPANEL_SIZE);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //altera a velocidade do scroll
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);

        //Aadiciona o botao das task
        JButton addTaskButton = new JButton("Adicionar Tarefa");
        addTaskButton.setFont(createFont("resources/LEMONMILK-Light.otf", 17f)); //fonte e tamanho
        addTaskButton.setBounds(-5, constantes.GUI_SIZE.height - 88,
                constantes.ADDTASK_BUTTON_SIZE.width, constantes.ADDTASK_BUTTON_SIZE.height);
        addTaskButton.addActionListener(this);


        //adiciona no frame
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);
    }

    private Font createFont(String resource, float size) {
        //pega o arquivo da fonte
        String filePath = getClass().getClassLoader().getResource(resource).getPath();
        //confere se o path contem uma pasta com espacos
        if (filePath.contains("%20")) {
            filePath = getClass().getClassLoader().getResource(resource).getPath().replaceAll("%20", " ");
        }

        //cria a fonte

        try{
        File customFontFile = new File(filePath);
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, customFontFile).deriveFont(size);
        return customFont;
        }catch (Exception e){
            System.out.println("ERROR: "+e);
        }
        return null;

}

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Adicionar Tarefa")){
            //cria uma task component
            TaskComponentes taskComponentes = new TaskComponentes(taskComponentPanel);
            taskComponentPanel.add(taskComponentes);

            //make the task field request focus after creation
            taskComponentes.getTaskField().requestFocus();
            repaint();
            revalidate();
        }

    }
}
