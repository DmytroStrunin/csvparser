package com.example.csvparser.util;

import com.example.csvparser.entity.Dummy;
import com.example.csvparser.repository.DummyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import javax.annotation.PostConstruct;
import java.io.*;

@Slf4j
public class ReadFile {

    private final DummyRepository repository;

    public ReadFile(DummyRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void read() {

        ICsvBeanReader csvReader = null;
        try (FileReader fileReader = new FileReader("CoinKeeper.csv")) {
            csvReader = new CsvBeanReader(fileReader, CsvPreference.STANDARD_PREFERENCE);
            // указываем как будем мапить
            String[] mapping = new String[]{"data", "type", "fromField", "to", "tags", "amount",
                    "currency", "amountConverted", "currencyOfConversion", "recurrence", "note"};
            // получаем обработчики
            CellProcessor[] procs = getProcessors();
            Dummy dummy;
            // обходим весь csv файлик до конца
            while ((dummy = csvReader.read(Dummy.class, mapping, procs)) != null) {
                if (!dummy.getData().contains("Data"))
                    repository.save(dummy);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(MultipartFile file1) {
        System.out.println("**IN_READ_FILE**");
        Reader reader;
        try {
            reader = new InputStreamReader(file1.getInputStream());
            ICsvBeanReader csvReader = new CsvBeanReader(reader, CsvPreference.STANDARD_PREFERENCE);
            // указываем как будем мапить
            String[] mapping = new String[]{"data", "type", "fromField", "to", "tags", "amount",
                    "currency", "amountConverted", "currencyOfConversion", "recurrence", "note"};
            // получаем обработчики
            CellProcessor[] procs = getProcessors();
            Dummy dummy;
            // обходим весь csv файлик до конца
            while ((dummy = csvReader.read(Dummy.class, mapping, procs)) != null) {
                if (!dummy.getData().contains("Data"))
                    repository.save(dummy);
            }
        } catch (IOException e) {
            e.printStackTrace();
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



