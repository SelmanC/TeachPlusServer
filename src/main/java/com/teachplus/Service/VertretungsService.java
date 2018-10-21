package com.teachplus.Service;

import com.teachplus.Entity.Vertretung;
import com.teachplus.Repository.VertretungsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VertretungsService {
    @Autowired
    private VertretungsRepository vertretungsRepository;

    public Map<String, Map<String, List<Vertretung>>> getVertretungByGroupId(Long[] groupIds) {
        Collection<Vertretung> vertretungen = vertretungsRepository.findByGroupIdGroupByDate(groupIds, getDateWithTimeZero(new Date()));
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        return vertretungen
                .stream()
                .collect(Collectors.groupingBy(v -> ft.format(v.getDate()), Collectors.groupingBy(Vertretung::getGroupClassName)));
    }

    private Date getDateWithTimeZero(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public Vertretung addVertretung(Vertretung vertretung) {
        return vertretungsRepository.save(vertretung);
    }

    public void deleteVertretung(Long id) {
        vertretungsRepository.deleteById(id);
    }

}
