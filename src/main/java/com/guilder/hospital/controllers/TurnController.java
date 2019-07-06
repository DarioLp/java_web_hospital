package com.guilder.hospital.controllers;

import com.guilder.hospital.exceptions.InvalidTurnDateException;
import com.guilder.hospital.exceptions.TurnNotFoundException;
import com.guilder.hospital.exceptions.UserBloquedException;
import com.guilder.hospital.exceptions.UserNotFoundException;
import com.guilder.hospital.models.Doctor;
import com.guilder.hospital.models.Schedule;
import com.guilder.hospital.models.Turn;
import com.guilder.hospital.models.User;
import com.guilder.hospital.repositories.DoctorRepository;
import com.guilder.hospital.repositories.TurnRepository;
import com.guilder.hospital.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


@RestController
public class TurnController {

    private final int duracion = 15;
    private final TurnRepository turnRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    public TurnController(TurnRepository turnRepository){
        this.turnRepository = turnRepository;
    }


    @GetMapping ("/api/v1/turns")
    List <Turn> all(){
        List<Turn> turns = turnRepository.findAll();
        System.out.println(turns);
        return turns;
    }

/*
    @GetMapping ("/api/v1/turns_available_specialty")
    List <Turn> availableTurnsBySpecialty(@RequestParam long idSpecialty , @RequestParam String dia) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(dia);

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String stDate = simpleDateFormat.format(date);

        List <Turn> ocupados = turnRepository.findTurnsReserved(idSpecialty, stDate);
        if (ocupados == null) return null;
        if (ocupados.isEmpty()) return null;
        List <Turn> disponibles = new ArrayList<Turn>();
        List <List<Turn>> turnsByDoctor = new ArrayList<>();

        ocupados.sort(Comparator.comparing(a -> a.getDoctor().getId()));
        Doctor aux= disponibles.get(0).getDoctor();
        List <Turn> auxList = new ArrayList<Turn>();
        for (Turn t :ocupados){
            if (t.getDoctor() != aux){
                turnsByDoctor.add(auxList);
                auxList = new ArrayList<Turn>();
            }
            auxList.add(t);
        }


        int i =0;
        for ( List<Turn> docs : turnsByDoctor){

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 1) dayOfWeek =8; //Si es domingo
            dayOfWeek --;

            List<Schedule> shedules= (docs.get(i)).getDoctor().getSchedules();
            Schedule s = new Schedule();
            for ( Schedule sche : shedules){
                if(sche.getDay().getId()== dayOfWeek){
                    s = sche;
                    break;
                }
            }

            if (s.getHour_since() == null) break; // si no se encontro un shedule para ese dia
            Date time = this.addGMT(s.getHour_since());

            for ( Turn t  : docs){
                while ( time.compareTo(t.getHour()) < 0){
                    Turn newTurn = new Turn();
                    newTurn.setDoctor(s.getDoctor());
                    newTurn.setDate(date);
                    newTurn.setAttended(false);
                    newTurn.setHour(new Time(time.getTime()));
                    disponibles.add(newTurn);

                    time = this.addMinutes(time, this.duracion);
                }
                time = this.addMinutes(time, this.duracion);
                i++;
            }

            Date timeFin =addGMT(s.getHour_to());
            while (time.compareTo(timeFin)<0){
                Turn newTurn = new Turn();
                newTurn.setDoctor(s.getDoctor());
                newTurn.setDate(date);
                newTurn.setAttended(false);
                newTurn.setHour(new Time(time.getTime()));
                disponibles.add(newTurn);

                time =this.addMinutes(time, this.duracion);
            }

        }

        return disponibles;

    }
*/
    @GetMapping ("/api/v1/turns_available_by_doctor")
    List <Turn> availableTurnsByDoctor(@RequestParam Long idDoctor, @RequestParam String dia) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(dia);

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String stDate = simpleDateFormat.format(date);

        List <Turn> ocupados = turnRepository.findTurnsReservedWithDoctor(idDoctor, stDate);
        List <Turn> disponibles = new ArrayList<Turn>();

        Doctor doctor;
        if (ocupados.isEmpty()){
            doctor = doctorRepository.findById(idDoctor).get();
            if (doctor == null) return null;
        }
        else{
            doctor = ocupados.get(0).getDoctor();
        }
        List<Schedule> shedules= doctor.getSchedules();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) dayOfWeek =8; //Si es domingo
        dayOfWeek --;

        Schedule s = new Schedule();
        for ( Schedule aux : shedules){
            if(aux.getDay().getId()== dayOfWeek){
                s = aux;
                break;
            }
        }

        if (s.getHour_since() ==null) return null; // si no se encontro un shedule para ese dia
        Date time = this.addGMT(s.getHour_since());
        for ( Turn t : ocupados){
            while ( time.compareTo(t.getHour()) < 0){
                Turn newTurn = new Turn();
                newTurn.setDoctor(s.getDoctor());
                newTurn.setDate(new java.sql.Date(date.getTime()));
                newTurn.setAttended(false);
                newTurn.setHour(new Time(time.getTime()));
                disponibles.add(newTurn);

                time = this.addMinutes(time, this.duracion);
            }
            time = this.addMinutes(time, this.duracion);
        }

        Date timeFin =addGMT(s.getHour_to());
        while (time.compareTo(timeFin)<0){
            Turn newTurn = new Turn();
            newTurn.setDoctor(s.getDoctor());
            newTurn.setDate(new java.sql.Date(date.getTime()));
            newTurn.setAttended(false);
            newTurn.setHour(new Time(time.getTime()));
            disponibles.add(newTurn);

            time =this.addMinutes(time, this.duracion);
        }

        return disponibles;

    }

    @PostMapping("/api/v1/turns")
    Turn newTurn(@RequestBody Turn newTurn) {

        try{
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = principal instanceof UserDetails? ((UserDetails)principal).getUsername():principal.toString();
            User user = userRepository.findByDni(username);
            if(user == null){
                throw new UserNotFoundException(username);
            }
            if(user.isBloqued()){
                throw new UserBloquedException();
            }

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String dateString = dateFormat.format(date);
            String timeString = timeFormat.format(date);

            int count = userRepository.countDidNotAttendByDni(username,dateString,timeString);
            if(count >= 3){
                user.setBloqued(true);
                user.setDateBloqued(new java.sql.Date(date.getTime()));
                userRepository.save(user);
                throw new UserBloquedException();
            }

            Date now = new Date();
            Date date_turn = this.addGMT(newTurn.getDate());

            if(now.compareTo(date_turn) > 0){
                throw new InvalidTurnDateException();
            }
            newTurn.setDate(new java.sql.Date(date_turn.getTime()));
            return turnRepository.save(newTurn);
        }catch (Exception e){
            throw e;
        }

    }


    @GetMapping("/api/v1/turns/{id}")
    Turn one(@PathVariable Long id) {

        return turnRepository.findById(id)
                .orElseThrow(() -> new TurnNotFoundException(id));
    }

    @PutMapping("/api/v1/turns/{id}")
    Turn replaceTurn(@RequestBody Turn newTurn, @PathVariable Long id) {

        return turnRepository.findById(id)
                .map(turn -> {
                    turn.setAttended(newTurn.isAttended());
                    if (newTurn.getDate() != null) turn.setDate(newTurn.getDate());
                    if (newTurn.getDoctor() !=null) turn.setDoctor(newTurn.getDoctor());
                    if (newTurn.getUser() != null) turn.setUser(newTurn.getUser());
                    return turnRepository.save(turn);
                })
                .orElseGet(() -> {
                    newTurn.setId(id);
                    return turnRepository.save(newTurn);
                });
    }

    @DeleteMapping("/api/v1/turns/{id}")
    void deleteTurn(@PathVariable Long id) {
        turnRepository.deleteById(id);
    }


    private Date addMinutes(Date hour, int minutos){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hour);
        calendar.add(Calendar.MINUTE, this.duracion); //minutosASumar es int.
        hour = calendar.getTime();
        return hour;
    }

    private Date addGMT(Date hour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hour);
        calendar.add(Calendar.HOUR, 3);
        hour = calendar.getTime();
        return hour;
    }

}
