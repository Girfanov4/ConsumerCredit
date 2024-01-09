import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.util.List;
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField loanAmount;
	private JTextField loanTermInYears;
	private JTextField annualInterestRate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
//		Шапка формы
		super("Калькулятор");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
//		Вертикальные строки
		Box boxV = Box.createVerticalBox();
		boxV.setLocation(10, 5);
		
//		Заголовок формы
		JLabel heading_1 = new JLabel("Параметры кредита");
		boxV.add(heading_1);
		
		JLabel heading_2 = new JLabel("Настройки калькулятора позволяют задавать дополнительные параметры кредита, но нужно");
		heading_2.setAlignmentY(Component.TOP_ALIGNMENT);
		boxV.add(heading_2);
		
		
		JLabel heading_3 = new JLabel("учитывать, что в каждом банке есть свои особенности расчетов");
		boxV.add(heading_3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		boxV.add(verticalStrut);
		
//		Горизонтальные строки 1
		Box boxH1 = Box.createHorizontalBox();
		boxH1.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel lblNewLabel = new JLabel("Сумма кредита:");
		
		boxH1.add(lblNewLabel);
		
		loanAmount = new JTextField();
		loanAmount.setColumns(10);
		boxH1.add(loanAmount);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"₽", "$", "€", "¥", "£"}));
		boxH1.add(comboBox);
		
//		1 Горизонтальная строка в вертикальной строке
		boxV.add(boxH1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		boxV.add(verticalStrut_1);
		
//		Горизонтальные строки 2
		Box boxH2 = Box.createHorizontalBox();
		boxH2.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel lblNewLabel_1 = new JLabel("Срок кредита:");
		boxH2.add(lblNewLabel_1);
		
		loanTermInYears = new JTextField();
		loanTermInYears.setColumns(10);
		boxH2.add(loanTermInYears);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"лет", "мес."}));
		boxH2.add(comboBox_1);
		
		boxV.add(boxH2);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		boxV.add(verticalStrut_2);
		
//		Горизонтальные строки 3
		Box boxH3 = Box.createHorizontalBox();
		boxH3.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		JLabel lblNewLabel_2 = new JLabel("Процентная ставка:");
		boxH3.add(lblNewLabel_2);
		
		annualInterestRate = new JTextField();
		annualInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		annualInterestRate.setColumns(10);
		boxH3.add(annualInterestRate);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"% в год", "% в мес", "% в день", ""}));
		boxH3.add(comboBox_2);
		
		boxV.add(boxH3);
		
		JButton btnNewButton = new JButton("Расчтитать");
		
		boxV.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("1");
		boxV.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("2");
		boxV.add(lblNewLabel_4);
		
		setContentPane(boxV);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		boxV.add(horizontalBox);
		
		JLabel lblNewLabel_6 = new JLabel("Сумма ежемесячного платежа:");
		horizontalBox.add(lblNewLabel_6);
		
		JLabel result_1 = new JLabel("");
		horizontalBox.add(result_1);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsumerCredit ConsumerCredit =new ConsumerCredit();
				Double _loanTermInYears = Double.parseDouble(loanTermInYears.getText());
				ConsumerCredit.numberOfPayments(_loanTermInYears);
				
				List<Object> Details =DevCalc.getDetails(loanAmount.getText(),annualInterestRate.getText(),loanTermInYears.getText());
				lblNewLabel_3.setText(Details.get(0).toString());
				lblNewLabel_4.setText(Details.get(1).toString());
				result_1.setText(Details.get(2).toString());
			}
		});
		
		setSize(500, 250);
		
	}

}
