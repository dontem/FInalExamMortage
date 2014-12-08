import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Mortage extends JFrame {

	private static final int WIDTH = 450;
	private static final int HEIGHT = 350;

	private static JLabel totalGrossIncomeLabel, totalMonthlyDebtLabel,
			mortgageInterestRateLabel, termLabel, downPaymentLabel,
			housingPaymentLabel, housingPaymentOtherObligationsLabel,
			maximumPaymentAllowedLabel, mortgageLabel;

	private static JTextField totalGrossIncomeTField, totalMonthlyDebtTField,
			mortgageInterestRateTField, termTField, downPaymentTField,
			housingPaymentOtherObligationsTField, maximumPaymentAllowedTField,
			mortageTField;

	private static JButton calculateB, exitB;

	private static CalculateButtonHandler cbHandler;
	private static ExitButtonHandler ebHandler;

	public static void Mortgage() {

		totalGrossIncomeLabel = new JLabel("Total Gross Income: ",
				SwingConstants.RIGHT);
		totalMonthlyDebtLabel = new JLabel("Total Monthly Debt: ",
				SwingConstants.RIGHT);
		mortgageInterestRateLabel = new JLabel("Mortgage Interest Rate: ",
				SwingConstants.RIGHT);
		termLabel = new JLabel("Term: ", SwingConstants.RIGHT);
		downPaymentLabel = new JLabel("Down Payment: ", SwingConstants.RIGHT);
		housingPaymentLabel = new JLabel("Housing Payment Only: ",
				SwingConstants.RIGHT);
		housingPaymentOtherObligationsLabel = new JLabel(
				"Housing Payment + Other Obligations: ", SwingConstants.RIGHT);
		maximumPaymentAllowedLabel = new JLabel("Maximum Payment allowed: ",
				SwingConstants.RIGHT);
		mortgageLabel = new JLabel("Mortgage that can be financed: ",
				SwingConstants.RIGHT);

		totalGrossIncomeTField = new JTextField(10);
		totalMonthlyDebtTField = new JTextField(10);
		mortgageInterestRateTField = new JTextField(10);
		termTField = new JTextField(10);
		downPaymentTField = new JTextField(10);
		housingPaymentOtherObligationsTField = new JTextField(10);
		maximumPaymentAllowedTField = new JTextField(10);
		mortageTField = new JTextField(10);

		calculateB = new JButton("Calculate");
		cbHandler = new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);

		JFrame frame = new JFrame();
		frame.setBounds(WIDTH, WIDTH, HEIGHT, HEIGHT);
		frame.setTitle("Mortgage");
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(5, 2));

		pane.add(totalGrossIncomeLabel);
		pane.add(totalGrossIncomeTField);
		pane.add(totalMonthlyDebtLabel);
		pane.add(totalMonthlyDebtTField);
		pane.add(mortgageInterestRateLabel);
		pane.add(mortgageInterestRateTField);
		pane.add(termLabel);
		pane.add(termTField);
		pane.add(downPaymentLabel);
		pane.add(downPaymentTField);
		pane.add(housingPaymentLabel);
		pane.add(housingPaymentOtherObligationsLabel);
		pane.add(housingPaymentOtherObligationsTField);
		pane.add(maximumPaymentAllowedLabel);
		pane.add(maximumPaymentAllowedTField);
		pane.add(mortgageLabel);
		pane.add(mortageTField);
		pane.add(calculateB);
		pane.add(exitB);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private static class CalculateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double totalGrossIncome, housingPayment, housingPaymentOtherObligations, maximumPaymentAllowed, term, mortgage, mortgageInterestRate;
			totalGrossIncome = Double.parseDouble(totalGrossIncomeTField
					.getText());
			housingPayment = 0.18 * totalGrossIncome;
			housingPaymentOtherObligations = 0.36 * totalGrossIncome;
			housingPaymentOtherObligationsTField.setText(""
					+ housingPaymentOtherObligations);
			maximumPaymentAllowed = housingPayment;
			maximumPaymentAllowedTField.setText("" + maximumPaymentAllowed);
			mortgageInterestRate = Double
					.parseDouble(mortgageInterestRateTField.getText());
			term = Double.parseDouble(termTField.getText());
			mortgage = (housingPayment / (mortgageInterestRate * (1 - (Math
					.pow(1 + mortgageInterestRate, -(term * 12))))));
			mortageTField.setText("" + mortgage);

		}
	}

	private static class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mortgage();

	}

}