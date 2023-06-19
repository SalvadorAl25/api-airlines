package com.airline.checkin.services;

import com.airline.checkin.models.*;
import com.airline.checkin.repositories.BoardingPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BoardingPassService {

    @Autowired
    BoardingPassRepository boardingPassRepository;

    @Autowired
    SeatService seatService;

    //lista global de asientos no disponibles
    List<Integer> seatsNotAvailable = new ArrayList<>();

    CheckInEntity checkIn = new CheckInEntity();

    public Iterable<BoardingPassEntity> findAll() {
        return boardingPassRepository.findAll();
    }

    public Optional<BoardingPassEntity> findById(Integer boardingPassId) {
        return boardingPassRepository.findById(boardingPassId);
    }

    public List<BoardingPassEntity> findByFlightId(Integer flightId) {
        return boardingPassRepository.findByFlightId(flightId);
    }

    //este metodo busca si hay un asiento disponible buscando en los pases de abordar,
    //si hay un pase al cual no ha sido asignado un asiento, esta disponible y retornara un True
    public Boolean findIfTheSeatIsFree(Integer seatId, Integer flightId) {
        if(boardingPassRepository.findIfTheSeatIsFree(seatId, flightId) == null)
            return true;
        else
            return false;
    }

    private List<Integer> availableSeats(SeatEntity seat,Integer passNotSet, Integer airplaneId){
        List<Integer> seatsIds = new ArrayList<>();
        int oneSeat = 0;
        int seatRow = seat.getSeatRow();
        Boolean occupied1 = false;
        Boolean occupied2 = false;
        Boolean backSeats = false;
        //filas de avión 1
        List<String> col1a1 = Arrays.asList("A","B","C");
        List<String> col2a1 = Arrays.asList("E","F","G");

        List<String> col1a2 = Arrays.asList("A","B");
        List<String> col2a2 = Arrays.asList("D","E","F");
        List<String> col3a2 = Arrays.asList("I","H");



        //verifica cual de los 2 casos de vuelo es, si es el que tiene 3 lineas o el de 2 y los compara por medio del ID
        if (airplaneId == 1) {
            if (col1a1.contains(seat.getSeatColumn())) {  //en base a las letras A, B y C comenzaremos a buscar
                if (seat.getSeatColumn().equals("C")){
                    backSeats = true;
                    do {
                        for (int col = 2; col > -1; col--) {
                            oneSeat = seatService.findSeatByColumnAndRow(col1a1.get(col), seatRow, airplaneId);
                            if (seatsIds.size() != passNotSet){
                                if(!seatsNotAvailable.contains(oneSeat)) {
                                    if (findIfTheSeatIsFree(oneSeat, seat.getAirplane().getAirplaneId()) && oneSeat != seat.getSeatId())
                                        seatsIds.add(oneSeat);
                                    if (!findIfTheSeatIsFree(oneSeat, seat.getAirplane().getAirplaneId()) && col == 0) {
                                        backSeats = false;
                                    }
                                }
                            }
                        }
                        if (backSeats) seatRow--;
                        else seatRow ++;
                    }
                    while (seatsIds.size()<passNotSet);
                }
                else {
                    do { //realizara la accion de buscar por fila la cantidad de asientos disponibles para los pasajeros faltantes
                        for (int col = 0; col < col1a1.size(); col++) {
                            oneSeat = seatService.findSeatByColumnAndRow(col1a1.get(col), seatRow, airplaneId);
                            if (seatsIds.size() != passNotSet){
                                if(!seatsNotAvailable.contains(oneSeat)) {
                                    if (!findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat == seat.getSeatId() && col == 0)
                                        occupied1 = true;
                                    else if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 0)
                                        seatsIds.add(oneSeat);
                                    if (!findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 1)
                                        occupied2 = true;
                                    else if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 1)
                                        seatsIds.add(oneSeat);
                                    if (occupied1 && occupied2) {
                                        col++;
                                        backSeats = true;
                                        occupied1 = false;
                                        occupied2 = false;
                                    } else {
                                        Boolean res = findIfTheSeatIsFree(oneSeat, seat.getAirplane().getAirplaneId());
                                        if (findIfTheSeatIsFree(oneSeat, airplaneId) && col == 2)
                                            seatsIds.add(oneSeat);
                                    }
                                }
                            }
                        }
                        if (backSeats) {
                            seatRow--;
                        }
                        else
                            seatRow++;
                    }
                    while (seatsIds.size()<passNotSet);
                }
            }
            if (col2a1.contains(seat.getSeatColumn())){
                if (!seat.getSeatColumn().equals("G")) {
                    do {
                        for (int col = 0; col < col2a1.size(); col++) {
                            oneSeat = seatService.findSeatByColumnAndRow(col2a1.get(col), seatRow, airplaneId);
                            if (seatsIds.size() != passNotSet){
                                if(!seatsNotAvailable.contains(oneSeat)) {
                                    if (!findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 0)
                                        occupied1 = true;
                                    else if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 0)
                                        seatsIds.add(oneSeat);
                                    if (!findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat == seat.getSeatId() && col == 1)
                                        occupied2 = true;
                                    else if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 1)
                                        seatsIds.add(oneSeat);
                                    if (occupied1 && occupied2) {
                                        if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 2) {
                                            seatsIds.add(oneSeat);
                                        }
                                    } else if (occupied2)
                                        if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId() && col == 2) {
                                            seatsIds.add(oneSeat);
                                        }
                                }
                            }
                        }
                        if (occupied1 && occupied2)
                            seatRow--;
                        else
                            seatRow++;
                    }
                    while (seatsIds.size() < passNotSet);
                }
                else {             //hay casos donde se compro el par de boletos comenzando desde la ventana
                    do {           //esto hace que comienze a asignar desde esa letra hacia atras
                        for (int col = 2; col > -1; col--){
                            oneSeat = seatService.findSeatByColumnAndRow(col2a1.get(col), seatRow, airplaneId);
                            if (seatsIds.size() != passNotSet)
                                if(!seatsNotAvailable.contains(oneSeat))
                                    if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId())
                                        seatsIds.add(oneSeat);
                        }
                        seatRow--;
                    }
                    while (seatsIds.size()<passNotSet);
                }
            }
        }
        if (airplaneId == 2) {
            if (col1a2.contains(seat.getSeatColumn())) {
                do {
                    for (int col = 0; col < col1a2.size(); col++) {  //A,B
                        oneSeat = seatService.findSeatByColumnAndRow(col1a2.get(col), seatRow, airplaneId);
                        if (seatsIds.size() != passNotSet){
                            if(!seatsNotAvailable.contains(oneSeat))
                                if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId())
                                    seatsIds.add(oneSeat);
                        }
                    }
                        seatRow++;
                }
                while (seatsIds.size() < passNotSet);
            }
            if (col2a2.contains(seat.getSeatColumn())){
                do {
                    for (int col = 0; col < col2a2.size(); col++) {   //D,E,F
                        oneSeat = seatService.findSeatByColumnAndRow(col2a2.get(col), seatRow, airplaneId);
                        if (seatsIds.size() != passNotSet){
                            if(!seatsNotAvailable.contains(oneSeat))
                                if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId())
                                    seatsIds.add(oneSeat);
                        }
                    }
                    seatRow++;
                }
                while (seatsIds.size() < passNotSet);
            }
            if (col3a2.contains(seat.getSeatColumn())){
                do {
                    for (int col = 0; col < col3a2.size(); col++) {    //H,I
                        oneSeat = seatService.findSeatByColumnAndRow(col3a2.get(col), seatRow, airplaneId);
                        if (seatsIds.size() != passNotSet){
                            if(!seatsNotAvailable.contains(oneSeat))
                                if (findIfTheSeatIsFree(oneSeat, airplaneId) && oneSeat != seat.getSeatId())
                                    seatsIds.add(oneSeat);
                        }
                    }
                    seatRow++;
                }
                while (seatsIds.size() < passNotSet);
            }
        }
        return seatsIds;
    }

    private List<Integer> availableSeats2(Integer seatTypeId, Integer passNotSeat, Integer airplaneId){
        List<Integer> siast = seatService.allSeatsForType(seatTypeId, airplaneId);  //seatsInAirplaneAndSeatType trae todos los asientos de la clase del avion
        List<Integer> aux = new ArrayList<>();                  //se usa un arreglo auxiliar para agregar los Ids de los posibles asientos consecutivos
        Integer column = 1;                         //esta variable aportara a identificar en que columna vamos apartir del primero de la clase
        List<Integer> seatsIds = new ArrayList<>();             //asientos disponibles a retornar
        Integer prevI = 0;
        Boolean doNotCycle = false;

            if (airplaneId == 1){
                for(int i = 0; i<siast.size() && aux.size() != passNotSeat; i++){
                    if(!seatsNotAvailable.contains(siast.get(i))){
                        if(findIfTheSeatIsFree(siast.get(i),airplaneId)) {
                            aux.add(siast.get(i));
                            if(i%6 ==0){                   //el avion 1 tiene columnas de 6 asientos
                                column++;
                            }
                        }
                        else{
                            if(prevI != i) {
                                prevI = i;
                                i = (column * 6) - 1;
                                aux = new ArrayList<>();
                            }
                            else {
                                column++;
                                i = (column * 6) - 1;
                            }
                        }
                    }
                }
            }
            if (airplaneId == 2){
                for(int i = 0; i<siast.size() && aux.size() != passNotSeat; i++){
                    if(!seatsNotAvailable.contains(siast.get(i))){
                        if(findIfTheSeatIsFree(siast.get(i),airplaneId)) {
                            aux.add(siast.get(i));
                            if(i%7 ==0){            //el avion 2 tiene columnas de 7 asientos
                                column++;
                            }
                        }
                        else{
                            if(prevI != i) {
                                prevI = i;
                                i = (column * 7) - 1;
                                aux = new ArrayList<>();
                            }
                            else {
                                column++;
                                i = (column * 7) - 1;
                            }
                        }
                    }
                    else
                        if(i%7 ==0)            //el indice seguira incrementandose si el asiento no esta disponible
                            column++;          // para este caso, seguira contando en que columna no es posible setear
                }                               // los asientos
            }
            seatsIds.addAll(aux);
            seatsNotAvailable.addAll(aux);

        return seatsIds;
    }

    private List<Integer> setSeatsByAvailability(Integer seatTypeId, Integer passNotSeat, Integer airplaneId){
        List<Integer> seatsIds = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();
        List<Integer> siast = seatService.allSeatsForType(seatTypeId, airplaneId);
        for (int i = 0; i< siast.size() && seatsIds.size()!= passNotSeat; i++){
            if (!seatsNotAvailable.contains(siast.get(i)))
                seatsIds.add(siast.get(i));
        }
        seatsNotAvailable.addAll(seatsIds);

        return seatsIds;
    }


    private List<ManyPassengersEntity> findSeatToAssign(List<ManyPassengersEntity> groupPassengers, Integer airplaneId) {
        int seatIdByGroup = 0;
        int passNotSeat = 0;
        List<Integer> seatsIds = new ArrayList<>();
        for (int i = 0; i < groupPassengers.size(); i++) {
            if (groupPassengers.get(i).getSeatId() != null) {
                seatIdByGroup = groupPassengers.get(i).getSeatId();
            } else
                passNotSeat++;
        }
        Optional<SeatEntity> seatEntity = seatService.findById(seatIdByGroup);
        if (passNotSeat == 0 && seatIdByGroup != 0)           //esta condicion controla el caso en que solo se compro 1 boleto
            seatsNotAvailable.add(seatIdByGroup);
        if (passNotSeat != 0 && seatIdByGroup != 0) {
            seatsIds = availableSeats(seatEntity.get(), passNotSeat, airplaneId);
            seatsNotAvailable.add(seatIdByGroup);
            seatsNotAvailable.addAll(seatsIds);
        } else {
            seatsIds = availableSeats2(groupPassengers.get(0).getSeatTypeId(), passNotSeat, airplaneId);
        }

        int s = 0;
        // setear los ids disponibles
        if (seatsIds.size() == passNotSeat) {
            for (int i = 0; i < groupPassengers.size(); i++) {
                if (groupPassengers.get(i).getSeatId() == null) {
                    groupPassengers.get(i).setSeatId(seatsIds.get(s));
                    s++;
                }
            }
        } else {     // si no encuentra asientos consecutivos, buscara por disponivilidad
            if (seatsIds.size() < passNotSeat) {
                seatsIds = setSeatsByAvailability(groupPassengers.get(0).getSeatTypeId(), passNotSeat, airplaneId);
                for (int i = 0; i < groupPassengers.size(); i++) {
                    if (groupPassengers.get(i).getSeatId() == null) {
                        groupPassengers.get(i).setSeatId(seatsIds.get(s));
                        s++;
                    }
                }
            }
        }
        return groupPassengers;
    }

    private List<ManyPassengersEntity> setSeatsByGroup(List<ManyPassengersEntity> manyPassengers, Integer airplaneId){
        List<ManyPassengersEntity> groupPassengers = new ArrayList<>();
        List<ManyPassengersEntity> passGroupWithSeat = new ArrayList<>();
        Integer lastId = manyPassengers.get(0).getPurchaseId();
        for (int i = 0; i<manyPassengers.size(); i++ ){
            if (i != 0){ // verifica si es parte del grupo del anterior pasajero
                if (manyPassengers.get(i).getPurchaseId() == lastId){
                    groupPassengers.add(manyPassengers.get(i));
                }
                else{
                    passGroupWithSeat.addAll(findSeatToAssign(groupPassengers, airplaneId));
                    groupPassengers = new ArrayList<>();
                    groupPassengers.add(manyPassengers.get(i));
                    lastId = manyPassengers.get(i).getPurchaseId();
                }
            }
            else{   //agrega el primer pasajero
                groupPassengers.add(manyPassengers.get(i));
            }
        }
        lastId = 0;
        return passGroupWithSeat;
    }
    
    private List<ManyPassengersEntity> findAllPassengers(List<BoardingPassEntity> boardings, Integer airplaneId){
        List<ManyPassengersEntity> manyPassengers = new ArrayList<>();
        for(int i=0; i<boardings.size(); i++){
            ManyPassengersEntity passengerCheckIn = new ManyPassengersEntity();
            passengerCheckIn.setPassengerId(boardings.get(i).getPassenger().getPassengerId());
            passengerCheckIn.setDni(Integer.parseInt(boardings.get(i).getPassenger().getDni()));
            passengerCheckIn.setName(boardings.get(i).getPassenger().getName());
            passengerCheckIn.setAge(boardings.get(i).getPassenger().getAge());
            passengerCheckIn.setCountry(boardings.get(i).getPassenger().getCountry());
            passengerCheckIn.setBoardingPassId(boardings.get(i).getBoardingPassId());
            passengerCheckIn.setPurchaseId(boardings.get(i).getPurchase().getPurchaseId());
            passengerCheckIn.setSeatTypeId(boardings.get(i).getSeatType().getSeatTypeId());
            if (boardings.get(i).getSeat() != null)
                passengerCheckIn.setSeatId(boardings.get(i).getSeat().getSeatId());
            manyPassengers.add(passengerCheckIn);
        }
        manyPassengers.sort(Comparator.comparing(ManyPassengersEntity::getPurchaseId));  //ordena los pasajeros por el Id de Compra
        manyPassengers = setSeatsByGroup(manyPassengers, airplaneId);
        seatsNotAvailable = new ArrayList<>();
        return manyPassengers;
    }

    private CheckInEntity findTheFlight(Integer flightId){
        List<BoardingPassEntity> boardings = boardingPassRepository.findByFlightId(flightId);
        checkIn.setFlightId(boardings.get(0).getFlight().getFlightId());
        checkIn.setTakeoffDateTime(boardings.get(0).getFlight().getTakeoffDateTime());
        checkIn.setTakeoffAirport(boardings.get(0).getFlight().getTakeoffAirport());
        checkIn.setLandingDateTime(boardings.get(0).getFlight().getLandingDateTime());
        checkIn.setLandingAirport(boardings.get(0).getFlight().getLandingAirport());
        checkIn.setAirlineId(boardings.get(0).getFlight().getAirline().getAirplaneId());
        checkIn.setPassengers(findAllPassengers(boardings, boardings.get(0).getFlight().getAirline().getAirplaneId()));
        return checkIn;
    }

    public CheckInEntity checkIn(Integer flightId){
        return findTheFlight(flightId);
    }

    public void save(BoardingPassEntity boardingPass) {
        boardingPassRepository.save(boardingPass);
    }

    public void delete(BoardingPassEntity boardingPass) {
        boardingPassRepository.delete(boardingPass);
    }
}
