package com.padma.service;

import com.padma.grpc.service.Person;
import com.padma.grpc.service.PersonInput;
import com.padma.grpc.service.PersonServiceGrpc.PersonServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PersonService  extends PersonServiceImplBase{

	@Override
	public void getAllPersons(PersonInput request, StreamObserver<Person> responseObserver) {
		// TODO Auto-generated method stub
		super.getAllPersons(request, responseObserver);
	}

	@Override
	public void savePerson(Person request, StreamObserver<Person> responseObserver) {
		// TODO Auto-generated method stub
		super.savePerson(request, responseObserver);
	}

	@Override
	public void getPerson(PersonInput request, StreamObserver<Person> responseObserver) {
		// TODO Auto-generated method stub
		super.getPerson(request, responseObserver);
	}
	
	

}
