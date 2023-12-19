package com.exam.pairidentifier.services;

import com.exam.pairidentifier.exceptions.UnsupportedDateFormatException;
import com.exam.pairidentifier.repositories.DateFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DateFormatService {
    private final DateFormatRepository dateFormatRepository;

    @Autowired
    public DateFormatService(DateFormatRepository dateFormatRepository) {
        this.dateFormatRepository = dateFormatRepository;
    }

    public Date parseDate(String token) {
        List<String> supportedFormats = dateFormatRepository.getSupportedFormats();

        for (String format : supportedFormats) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(format);

                formatter.setLenient(false);

                return formatter.parse(token);
            } catch (ParseException e) {
                //todo -> continue to parse
            }
        }
        //todo handle missing date formats somehow
//        throw new UnsupportedDateFormatException("The date format is unfortunately unknown to us." +
//                "Please add this new format or correct the data.");
        return null;
    }

    public long getSupportedFormatsCount() {
        return dateFormatRepository.getFormatsCount();
    }

    public void saveFormats(List<String> formats) {
        for (String format : formats) {
            dateFormatRepository.save(format);
        }
    }
}
