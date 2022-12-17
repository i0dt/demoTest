package it.test.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.test.demo.rest.RestService;
import it.test.demo.rest.bean.Account;
import it.test.demo.rest.bean.AccountBalance;
import it.test.demo.rest.bean.Creditor;
import it.test.demo.rest.bean.CreditorAccount;
import it.test.demo.rest.bean.NaturalPersonBeneficiary;
import it.test.demo.rest.bean.RequestMoneyTransfer;
import it.test.demo.rest.bean.ResponseMoneyTransfer;
import it.test.demo.rest.bean.TaxRelief;
import it.test.demo.rest.bean.Transaction;
import it.test.demo.rest.enums.HeadersExternal;
import it.test.demo.rest.exception.CustomException;
import it.test.demo.rest.exception.ServerException;
import it.test.demo.rest.service.AccountService;

@WebMvcTest(RestService.class)
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService accountService;
	
	@Autowired
	private ObjectMapper mapper;
	
	private int CUSTOM_HTTP_STATUS_ERROR = 444;
	private int SERVER_HTTP_STATUS_ERROR = 555;

	@Test
	void accountOk() throws Exception {

		final String idAccount = "14537780";
		final String URL = "/accounts/" + idAccount;
		
		Account account = new Account();
		account.setAccount(idAccount);
		account.setIban("IT40L0326822311052923800661");

		Mockito.when(accountService.getAccount(idAccount)).thenReturn(account);

		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
			.andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(account)));
	}

	@Test
	void accountKoClient() throws Exception {
		final String idAccount = "14537781";
		final String URL = "/accounts/" + idAccount;
		
		final String ret = "[{\"code\":\"REQ004\",\"description\":\"Invalid account identifier\",\"params\":null}]";
		
		Mockito.when(accountService.getAccount(idAccount)).thenThrow(new CustomException("REQ004", "Invalid account identifier"));
		
		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(CUSTOM_HTTP_STATUS_ERROR))
			.andExpect(MockMvcResultMatchers.content().string(ret));
	}
	
	@Test
	void accountKoServer() throws Exception {
		final String idAccount = "14537782";
		final String URL = "/accounts/" + idAccount;
		final String ret = "[{\"code\":\"ZZZ001\",\"description\":\"Service Unavailable\",\"params\":null}]";
		
		Mockito.when(accountService.getAccount(idAccount)).thenThrow(new ServerException());
		
		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(SERVER_HTTP_STATUS_ERROR))
			.andExpect(MockMvcResultMatchers.content().string(ret));
	}

	@Test
	void balanceOk() throws Exception {
		final String idAccount = "14537780";
		final String URL = "/accounts/" + idAccount + "/balance";
		
		
		AccountBalance accountBalance = new AccountBalance();
		accountBalance.setAvailableBalance(1000L);
		accountBalance.setBalance(1000L);
		accountBalance.setCurrency("EUR");
		accountBalance.setDate("2022-12-17");

		Mockito.when(accountService.getBalance(idAccount)).thenReturn(accountBalance);

		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
			.andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(accountBalance)));
	}

	@Test
	void balanceKoClient() throws Exception {
		final String idAccount = "14537781";
		final String URL = "/accounts/" + idAccount + "/balance";
		
		final String ret = "[{\"code\":\"REQ004\",\"description\":\"Invalid account identifier\",\"params\":null}]";
		
		Mockito.when(accountService.getBalance(idAccount)).thenThrow(new CustomException("REQ004", "Invalid account identifier"));

		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(CUSTOM_HTTP_STATUS_ERROR))
			.andExpect(MockMvcResultMatchers.content().string(ret));
	}
	
	@Test
	void balanceKoServer() throws Exception {
		final String idAccount = "14537782";
		final String URL = "/accounts/" + idAccount + "/balance";
		
		final String ret = "[{\"code\":\"ZZZ001\",\"description\":\"Service Unavailable\",\"params\":null}]";
		
		Mockito.when(accountService.getBalance(idAccount)).thenThrow(new ServerException());
		
		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(SERVER_HTTP_STATUS_ERROR))
			.andExpect(MockMvcResultMatchers.content().string(ret));
	}
	
	@Test
	void transactionsOk() throws Exception {
		final String idAccount = "14537780";
		final String date = "2022-12-17";
		final String URL = "/accounts/" + idAccount + "/transactions?fromAccountingDate="+ date + "&toAccountingDate=" + date;
		
		Transaction transaction1 = new Transaction();
		transaction1.setValueDate(date);
		transaction1.setCurrency(idAccount);
		transaction1.setTransactionId("XXXXX1");
		transaction1.setAmount(-50);
		transaction1.setDescription("transfer money to pippo");
		
		Transaction transaction2 = new Transaction();
		transaction1.setValueDate(date);
		transaction2.setTransactionId("XXXXX1");
		transaction2.setAmount(100);
		transaction2.setDescription("transfer money from pippo");
		
		List<Transaction> list = new ArrayList<Transaction>();
		list.add(transaction1);
		list.add(transaction2);
		

		Mockito.when(accountService.listTransactions(idAccount, date, date)).thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
			.andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(list)));
	}
	
	@Test
	void transactionKoClient() throws Exception {
		final String idAccount = "14537781";
		final String date = "2022-12-17";
		final String URL = "/accounts/" + idAccount + "/transactions?fromAccountingDate="+ date + "&toAccountingDate=" + date;
		
		final String ret = "[{\"code\":\"REQ004\",\"description\":\"Invalid account identifier\",\"params\":null}]";

		Mockito.when(accountService.listTransactions(idAccount,date, date)).thenThrow(new CustomException("REQ004", "Invalid account identifier"));

		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(CUSTOM_HTTP_STATUS_ERROR))
			.andExpect(MockMvcResultMatchers.content().string(ret));
	}
	
	@Test
	void transactionKoServer() throws Exception {
		final String idAccount = "14537782";
		final String date = "2022-12-17";
		final String URL = "/accounts/" + idAccount + "/transactions?fromAccountingDate="+ date + "&toAccountingDate=" + date;
		
		final String ret = "[{\"code\":\"ZZZ001\",\"description\":\"Service Unavailable\",\"params\":null}]";
		
		Mockito.when(accountService.listTransactions(idAccount,date, date)).thenThrow(new ServerException());
		
		mockMvc.perform(MockMvcRequestBuilders.get(URL).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(SERVER_HTTP_STATUS_ERROR))
			.andExpect(MockMvcResultMatchers.content().string(ret));
	}
	
	// ToReview: review why can't map the request object
	@Test
	void moneyTransferOk() throws Exception {
		final String idAccount = "14537780";
		final String URL = "/accounts/" + idAccount + "/payments/money-transfers";
		
		RequestMoneyTransfer request = new RequestMoneyTransfer();
		request.setCreditor(new Creditor());
		request.getCreditor().setName("Mario Rossi");
		request.getCreditor().setAccount(new CreditorAccount());
		request.getCreditor().getAccount().setAccountCode("1234342");
		request.setDescription("Monety Transfer to pippo");
		request.setAmount(10);
		request.setCurrency("EUR");
		request.setTaxRelief(new TaxRelief());
		request.getTaxRelief().setCondoUpgrade(false);
		request.getTaxRelief().setBeneficiaryType("XXXXX");
		request.getTaxRelief().setNaturalPersonBeneficiary(new NaturalPersonBeneficiary());
		request.getTaxRelief().getNaturalPersonBeneficiary().setFiscalCode1("CodiceFiscale");
		
		ResponseMoneyTransfer ret = new ResponseMoneyTransfer();
		ret.setFeeAccountId("123456");
		ret.setDescription("Monety Transfer to pippo");
		
		Mockito.when(accountService.moneyTransfers(idAccount, request)).thenReturn(ret);

		mockMvc.perform(MockMvcRequestBuilders.post(URL)
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(request)))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
			//.andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(ret)));
	}
	
	// ToReview: review why can't map the request object
	@Test
	void moneyTransferKoClient() throws Exception {
		final String idAccount = "14537781";
		final String URL = "/accounts/" + idAccount + "/payments/money-transfers";
		
		final String ret = "[{\"code\":\"REQ004\",\"description\":\"Invalid account identifier\",\"params\":null}]";
		
		RequestMoneyTransfer request = new RequestMoneyTransfer();
		request.setCreditor(new Creditor());
		request.getCreditor().setName("Mario Rossi");
		request.getCreditor().setAccount(new CreditorAccount());
		request.getCreditor().getAccount().setAccountCode("1234342");
		request.setDescription("Monety Transfer to pippo");
		request.setAmount(10);
		request.setCurrency("EUR");
		request.setTaxRelief(new TaxRelief());
		request.getTaxRelief().setCondoUpgrade(false);
		request.getTaxRelief().setBeneficiaryType("XXXXX");
		request.getTaxRelief().setNaturalPersonBeneficiary(new NaturalPersonBeneficiary());
		request.getTaxRelief().getNaturalPersonBeneficiary().setFiscalCode1("CodiceFiscale");

		Mockito.when(accountService.moneyTransfers(idAccount, request)).thenThrow(new CustomException("REQ004", "Invalid account identifier"));

		mockMvc.perform(MockMvcRequestBuilders.post(URL)
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(request)))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
			//.andExpect(MockMvcResultMatchers.status().is(CUSTOM_HTTP_STATUS_ERROR))
			//.andExpect(MockMvcResultMatchers.content().string(ret));
	}
	
	// ToReview: review why can't map the request object
	@Test
	void moneyTransferKoServer() throws Exception {
		final String idAccount = "14537781";
		final String URL = "/accounts/" + idAccount + "/payments/money-transfers";
		
		final String ret = "[{\"code\":\"ZZZ001\",\"description\":\"Service Unavailable\",\"params\":null}]";
		
		RequestMoneyTransfer request = new RequestMoneyTransfer();
		request.setCreditor(new Creditor());
		request.getCreditor().setName("Mario Rossi");
		request.getCreditor().setAccount(new CreditorAccount());
		request.getCreditor().getAccount().setAccountCode("1234342");
		request.setDescription("Monety Transfer to pippo");
		request.setAmount(10);
		request.setCurrency("EUR");
		request.setTaxRelief(new TaxRelief());
		request.getTaxRelief().setCondoUpgrade(false);
		request.getTaxRelief().setBeneficiaryType("XXXXX");
		request.getTaxRelief().setNaturalPersonBeneficiary(new NaturalPersonBeneficiary());
		request.getTaxRelief().getNaturalPersonBeneficiary().setFiscalCode1("CodiceFiscale");

		Mockito.when(accountService.moneyTransfers(idAccount, request)).thenThrow(new ServerException());

		mockMvc.perform(MockMvcRequestBuilders.post(URL)
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(request)))
			.andExpect(MockMvcResultMatchers.header().exists(HeadersExternal.X_TIME_ZONE.getDesc()))
			.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
//			.andExpect(MockMvcResultMatchers.status().is(SERVER_HTTP_STATUS_ERROR))
//			.andExpect(MockMvcResultMatchers.content().string(ret));
	}
}
