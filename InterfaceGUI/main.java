import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

// Classe para Paciente
class Paciente {
    private String nome;
    private String cpf;

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
}

// Classe para Médico
class Medico {
    private String nome;
    private String especialidade;
    private List<Integer> avaliacoes = new ArrayList<>();
    private int atendimentosRealizados = 0;

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public void adicionarAvaliacao(int estrelas) {
        avaliacoes.add(estrelas);
        atendimentosRealizados++;
    }
    public double calcularMediaAvaliacoes() {
        return avaliacoes.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}

// Classe para Atendimento
class Atendimento {
    private Paciente paciente;
    private Medico medico;
    private String dataHora;

    public Atendimento(Paciente paciente, Medico medico, String dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }

    @Override
    public String toString() {
        return "Atendimento: " + paciente.getNome() + " com " + medico.getNome() + " em " + dataHora;
    }
}

// Classe para gerenciar o consultório
class ConsultorioManager {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();

    public ConsultorioManager() {
        medicos.add(new Medico("Drauzio Varella", "Clínico Geral"));
        medicos.add(new Medico("Dr. House", "Diagnóstico Diferencial"));
        medicos.add(new Medico("Alice", "Pediatra"));
        medicos.add(new Medico("Bob", "Dermatologista"));
        medicos.add(new Medico("Carlos", "Cardiologista"));
    }

    public void agendarAtendimento(Paciente paciente, Medico medico, String dataHora) {
        atendimentos.add(new Atendimento(paciente, medico, dataHora));
        medico.adicionarAvaliacao(5); // Avaliação fictícia
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}

// Classe principal para a GUI
public class SistemaClinicaApp extends JFrame {
    private ConsultorioManager consultorioManager;
    private JTextArea textArea;

    public SistemaClinicaApp() {
        consultorioManager = new ConsultorioManager();
        setTitle("Sistema de Clínica Médica");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        JButton agendarButton = createRoundedButton("Agendar Atendimento", new Color(173, 216, 230)); // Azul pastel
        JButton buscarButton = createRoundedButton("Buscar Paciente", new Color(255, 182, 193)); // Rosa pastel
        JButton relatorioButton = createRoundedButton("Relatório de Atendimentos", new Color(144, 238, 144)); // Verde pastel
        JButton avaliarButton = createRoundedButton("Avaliar Atendimento", new Color(255, 255, 224)); // Amarelo pastel
        JButton sairButton = createRoundedButton("Sair", new Color(255, 99, 71)); // Tomate

        agendarButton.addActionListener(e -> agendarAtendimento());
        buscarButton.addActionListener(e -> buscarPaciente());
        relatorioButton.addActionListener(e -> relatorioAtendimentos());
        avaliarButton.addActionListener(e -> avaliarAtendimento());
        sairButton.addActionListener(e -> System.exit(0));

        addMouseHoverEffect(agendarButton);
        addMouseHoverEffect(buscarButton);
        addMouseHoverEffect(relatorioButton);
        addMouseHoverEffect(avaliarButton);
        addMouseHoverEffect(sairButton);

        buttonPanel.add(agendarButton);
        buttonPanel.add(buscarButton);
        buttonPanel.add(relatorioButton);
        buttonPanel.add(avaliarButton);
        buttonPanel.add(sairButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createRoundedButton(String text, Color background) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(background);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private void addMouseHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(button.getFont().deriveFont(button.getFont().getSize() + 4f));
                button.setPreferredSize(new Dimension(button.getWidth() + 10, button.getHeight() + 10));
                button.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(button.getFont().deriveFont(button.getFont().getSize() - 4f));
                button.setPreferredSize(new Dimension(button.getWidth() - 10, button.getHeight() - 10));
                button.revalidate();
            }
        });
    }

    private void agendarAtendimento() {
        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        Paciente paciente = new Paciente(nome, cpf);
        consultorioManager.adicionarPaciente(paciente);

        StringBuilder medicosDisponiveis = new StringBuilder();
        for (int i = 0; i < consultorioManager.getMedicos().size(); i++) {
            medicosDisponiveis.append((i + 1) + ". " + consultorioManager.getMedicos().get(i).getNome() + "\n");
        }
        int medicoEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Escolha um médico:\n" + medicosDisponiveis));
        String horario = JOptionPane.showInputDialog("Escolha um horário (ex: 09:00):");
        consultorioManager.agendarAtendimento(paciente, consultorioManager.getMedicos().get(medicoEscolhido - 1), "Hoje " + horario);
        JOptionPane.showMessageDialog(this, "Atendimento agendado com sucesso!");
    }

    private void buscarPaciente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        boolean encontrado = false;
        StringBuilder resultado = new StringBuilder();

        for (Paciente paciente : consultorioManager.getPacientes()) {
            if (paciente.getCpf().equals(cpf)) {
                resultado.append("Paciente encontrado: " + paciente.getNome() + "\n");
                encontrado = true;
                for (Atendimento atendimento : consultorioManager.getAtendimentos()) {
                    if (atendimento.getPaciente().getCpf().equals(cpf)) {
                        resultado.append(atendimento.toString() + "\n");
                    }
                }
                break;
            }
        }

        if (!encontrado) {
            resultado.append("Paciente não encontrado.");
        }
        textArea.setText(resultado.toString());
    }

    private void relatorioAtendimentos() {
        StringBuilder resultado = new StringBuilder("Relatório de Atendimentos:\n");
        for (Atendimento atendimento : consultorioManager.getAtendimentos()) {
            resultado.append(atendimento.toString() + "\n");
        }
        textArea.setText(resultado.toString());
    }

    private void avaliarAtendimento() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        for (Atendimento atendimento : consultorioManager.getAtendimentos()) {
            if (atendimento.getPaciente().getCpf().equals(cpf)) {
                int estrelas = Integer.parseInt(JOptionPane.showInputDialog("Avalie o atendimento com estrelas (1 a 5):"));
                atendimento.getMedico().adicionarAvaliacao(estrelas);
                JOptionPane.showMessageDialog(this, "Avaliação registrada com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Atendimento não encontrado para o CPF informado.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaClinicaApp app = new SistemaClinicaApp();
            app.setVisible(true);
        });
    }
}
