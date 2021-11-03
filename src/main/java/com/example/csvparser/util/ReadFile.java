package com.example.csvparser.util;

import com.example.csvparser.entity.Dummy;
import com.example.csvparser.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private final DummyRepository repository;

    public ReadFile(DummyRepository repository) {
        this.repository = repository;
    }

//    @PostConstruct
    public void read(){
//    public static void main(String[] args) throws IOException {

        List<Dummy> dummies= new ArrayList<>();
        try {

        ICsvBeanReader csvReader = new CsvBeanReader(new FileReader("CoinKeeper.csv"),
                CsvPreference.STANDARD_PREFERENCE);

        // указываем как будем мапить
        String[] mapping = new String[]{"data","type","fromField","to","tags","amount",
                "currency","amountConverted","currencyOfConversion","recurrence","note"};

        // получаем обработчики
        CellProcessor[] procs = getProcessors();
        Dummy dummy;
        // обходим весь csv файлик до конца
        while ((dummy = csvReader.read(Dummy.class, mapping, procs)) != null) {
            dummies.add(dummy);
            repository.save(dummy);

        }
        csvReader.close();
        for (Dummy dummy1 : dummies) {
            System.out.println(dummy1);
        }
        }catch (IOException e){

        }
    }

    /**
     * Задаем обработчики ячеек
     */
    private static CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),

        };
    }
}



