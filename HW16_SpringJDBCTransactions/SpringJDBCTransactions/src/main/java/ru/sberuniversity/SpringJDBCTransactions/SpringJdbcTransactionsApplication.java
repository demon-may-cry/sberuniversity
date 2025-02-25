package ru.sberuniversity.SpringJDBCTransactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sberuniversity.SpringJDBCTransactions.config.InitDB;

@SpringBootApplication
public class SpringJdbcTransactionsApplication {

	public static void main(String[] args) {
		new InitDB();
		SpringApplication.run(SpringJdbcTransactionsApplication.class, args);
	}

}
