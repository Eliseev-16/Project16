/*
 * @autor ������� �.�
 */
package rgr.gui;

import rgr.DataSource;
import rgr.calculations.ControlClass;
import rgr.gui.elements.*;
import rgr.gui.listeners.QuitListener;
import rgr.pdf.CreateDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class MainGUI.
 */
public final class MainGUI extends DataSource {

    /** The frame. */
    private MainFrame frame = new MainFrame();
    
    /** The panel. */
    private MainPanel panel = new MainPanel();

    /** The pay. */
    private FormatLabel pay = new FormatLabel("Итоговая зарплата",ZERO);
    
    /** The income tax. */
    private FormatLabel incomeTax = new FormatLabel("НДФЛ",ZERO);
    
    /** The pension tax. */
    private FormatLabel pensionTax = new FormatLabel("Пенсионное",ZERO);
    
    /** The medical tax. */
    private FormatLabel medicalTax = new FormatLabel("Медицинское",ZERO);
    
    /** The social tax. */
    private FormatLabel socialTax = new FormatLabel("Социальное",ZERO);
    
    /** The injury tax. */
    private FormatLabel injuryTax = new FormatLabel("Травматизм",ZERO);

    /** The salary. */
    private JTextField salary;
    
    /** The period. */
    private JTextField period;
    
    /** The combo box 1. */
    private PeriodComboBox comboBox1;
    
    /** The combo box 2. */
    private ResidentComboBox comboBox2;
    
    /** The quit. */
    private JButton quit;
    
    /** The report. */
    private JButton report;
    
    /** The calculate. */
    private JButton calculate;
    
    /** The menu. */
    private TrayMenu menu;
    
    /** The name of period. */
    private JLabel nameOfPeriod;

    /** The is clicked. */
    private boolean isClicked = false;
    
    /**
     * Instantiates a new main GUI.
     */
    public MainGUI(){

        fillPanel();
        frame.add(panel);
        frame.pack();
        zeroing();
        setListeners();

    }

    /**
     * Fill panel (all gui interface).
     */
    private void fillPanel(){

        salary = new JTextField(); salary.setColumns(10);
        period = new JTextField(); period.setColumns(10);
        comboBox1 = new PeriodComboBox();
        comboBox2 = new ResidentComboBox();

        quit = new JButton("Выход");
        report = new JButton("Отчет");
        calculate = new JButton("Рассчитать");
        menu = new TrayMenu();
        nameOfPeriod = new JLabel("Количество отработанных дней: ");


        panel.addOneElement(new JLabel("Тип периода оплаты:"));
        panel.addOneElement(comboBox1);

        panel.addOneElement(new JLabel("Тарифная ставка:"));
        panel.addSeveralElement(new Component[]{salary,new JLabel("Р")},"");

        panel.addOneElement(nameOfPeriod);
        panel.addOneElement(period);

        panel.addOneElement(new JLabel("Принадлежность к государству:"));
        panel.addOneElement(comboBox2);

        panel.addOneElement(pay);
        panel.addOneElement(new JLabel("Отчисления:"));
        panel.addOneElement(incomeTax);
        panel.addOneElement(pensionTax);
        panel.addOneElement(medicalTax);
        panel.addOneElement(socialTax);
        panel.addOneElement(injuryTax);

        panel.addSeveralElement(new Component[]{quit,report,calculate},"     ");
        frame.add(menu,BorderLayout.NORTH);



    }

    /**
     *
     * Функция проверки данных
     * @throws Exception the exception
     */
    @Override
    public void checkExeption() throws Exception {
        double salary = Double.parseDouble(this.salary.getText());
        int period = Integer.parseInt(this.period.getText());
    }

    /**
     * Call function set value.
     */
    @Override
    public void callSetValue() {
        setValues(salary,period,comboBox2,comboBox1,pay.getValue(),
                incomeTax.getValue(),pensionTax.getValue(),medicalTax.getValue(),
                socialTax.getValue(),injuryTax.getValue());
    }

    /**
     *
     * Получение поля с названием типа периода оплаты
     * @return the name of period
     */
    public JLabel getNameOfPeriod(){
        return nameOfPeriod;
    }

    /**
     *
     * Функция обновления значений на форме
     * @throws Exception the exception
     */
    private void update() throws Exception {
        ControlClass calculate = new ControlClass(this);
        pay.setValue(calculate.getSalary());
        incomeTax.setValue(calculate.getIncomeTax());
        pensionTax.setValue(calculate.getPensionTax());
        medicalTax.setValue(calculate.getMedicalTax());
        socialTax.setValue(calculate.getSocialTax());
        injuryTax.setValue(calculate.getInsurance());
        panel.revalidate();
    }

    /**
     * Creates the PDF.
     */
    private void createPDF() {
        new CreateDocument(this);
    }

    /**
     * Sets the listeners (calculate and quit button).
     */
    private void setListeners(){
        quit.addActionListener(new QuitListener());

        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isClicked){
                    createPDF();
                }
                else JOptionPane.showMessageDialog(null,"Сначала нужно рассчитать значения");
            }
        });

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    checkExeption();
                    callSetValue();
                    update();
                    isClicked = true;
                    callSetValue();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Ошибка в данных");
                    isClicked = false;
                }
            }
        });

    }

    /**
     * Gets the tariff rate text field.
     *
     * @return the tariff rate text field
     */
    public JTextField getTariffRateTextField(){
        return salary;
    }

    /**
     * Gets the period text field.
     *
     * @return the period text field
     */
    public JTextField getPeriodTextField(){
        return period;
    }

    /**
     * Gets the calculate button.
     *
     * @return the calculate button
     */
    public JButton getCalculateBut(){
        return calculate;
    }


}
