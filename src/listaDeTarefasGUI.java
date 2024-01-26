import javax.swing.*;

public class listaDeTarefasGUI extends JFrame {

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

        //adiciona no frame
        this.getContentPane().add(bannerLabel);
    }
}
//2 min e 53