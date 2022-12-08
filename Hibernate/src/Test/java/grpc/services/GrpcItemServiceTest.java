package grpc.services;

import GRPC.proto.File;
import database.daoInterfaces.IDbDao;
import database.daos.DbDao;
import database.orm.DbConnection;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;
import grpc.converter.ItemConverter;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GrpcItemServiceTest {

	IDbDao<Item> dao;
	File.ItemCreation request;

	@BeforeEach
	void setUp() {
		dao = new DbDao<Item>(new DbConnection<Item>());
		request = File.ItemCreation.newBuilder()
				.setItemTypeID(1)
				.setOwnerID(1)
				.setShelfID(1)
				.build();
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void create() {
		Item item = dao.Create(ItemConverter.CONVERT.toItemFromCreation(request));

		File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(item);

		System.out.println(item.toString() + " " + proto.toString());

		a
	}

	@Test
	void read() {
	}

	@Test
	void readAll() {
	}

	@Test
	void delete() {
	}
}