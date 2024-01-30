import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponentes extends JPanel implements ActionListener {

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
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskField.setPreferredSize(constantes.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        //checkbox
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(constantes.CHECKBOX_SIZE);
        checkBox.addActionListener(this);

        //deleta botao
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(constantes.DELETE_BUTTON_SIZE);
        deleteButton.addActionListener(this);

        //adiciona taskcompoonents
        add(checkBox);
        add(taskField);
        add(deleteButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            // substitui todos os "botao" html por uma string vazia para poder criar a funcao deletar
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            //add texto taxado
            taskField.setText("<html><s>" + taskText + "</s></html>");
        }else if (!checkBox.isSelected()){
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText(taskText);
        }

        if (e.getActionCommand().equalsIgnoreCase("X")){
            // deleta esse componente do painel principal
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    }
}
