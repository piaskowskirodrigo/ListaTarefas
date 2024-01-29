import javax.swing.*;

public class TaskComponentes extends JPanel {

    private JCheckBox checkBox;

    private JTextPane taskField;
    private JButton deleteButton;


    public JTextPane getTaskField() {
        return taskField;
    }

    //este painel é usado para que de para fazer atualizações no painel do componente de tarefas ao excluir tarefas
    private JPanel parentPanel;

    public  TaskComponentes(JPanel parentPanel){
        this.parentPanel = parentPanel;

        //fields
        taskField = new JTextPane();
        taskField.setPreferredSize(constantes.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        //checkbox
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(constantes.CHECKBOX_SIZE);

        //deleta botao
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(constantes.DELETE_BUTTON_SIZE);

        //adiciona taskcompoonents
        add(checkBox);
        add(taskField);
        add(deleteButton);
    }
}
