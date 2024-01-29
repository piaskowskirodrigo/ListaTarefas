import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listaDeTarefasGUI extends JFrame implements ActionListener{

    //Painel de tarefas
    private JPanel taskPanel, taskComponentPanel;


    public listaDeTarefasGUI(){
        super("Lista de tarefas Aplicacao");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(constantes.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponente();
    }
    private void addGuiComponente(){
        //texto do banner

        JLabel bannerLabel = new JLabel("Lista de tarefas");
        bannerLabel.setBounds(
                (constantes.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
                15,
                constantes.BANNER_SIZE.width,
                constantes.BANNER_SIZE.height

        );

        // taskPanel
        taskPanel = new JPanel();

        //TaskcomponentPanel
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        //adiociona o scroll no painel das task
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, constantes.TASKPANEL_SIZE.width, constantes.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(constantes.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        //Aadiciona o botao das task
        JButton addTaskButton = new JButton("Adicionar Tarefa");
        addTaskButton.setBounds(-5, constantes.GUI_SIZE.height - 88,
                constantes.ADDTASK_BUTTON_SIZE.width, constantes.ADDTASK_BUTTON_SIZE.height);
        addTaskButton.addActionListener(this);


        //adiciona no frame
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);
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
