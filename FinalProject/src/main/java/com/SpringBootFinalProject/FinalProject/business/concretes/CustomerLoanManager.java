package com.SpringBootFinalProject.FinalProject.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBootFinalProject.FinalProject.business.abstracts.ICustomerLoanService;
import com.SpringBootFinalProject.FinalProject.dataaccess.concretes.BlackListRepository;
import com.SpringBootFinalProject.FinalProject.dataaccess.concretes.CustomerLoanRepository;
import com.SpringBootFinalProject.FinalProject.dataaccess.concretes.CustomerRepository;
import com.SpringBootFinalProject.FinalProject.entities.concretes.BlackList;
import com.SpringBootFinalProject.FinalProject.entities.concretes.CustomerLoan;

@Transactional
@Service
public class CustomerLoanManager implements ICustomerLoanService {

	@Autowired
	CustomerLoanRepository customerloanrepo;

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	BlackListRepository blackListRepo;

	@Override
	public List<CustomerLoan> getAll() {

		return customerloanrepo.findAll();
	}

	@Override
	public CustomerLoan enteredCredit(CustomerLoan customerloan) throws Exception {

		String custTcNumber = customerloan.getTcNumber();
		List<String> list = customerRepo.findTcNumber();

		// ayda max 1 kredi cekilebilir
		Date enteredCreditDate = customerloan.getCreditDate();
		Date howManyDayPassed = customerloanrepo.checkNumberOfCredit(customerloan.getCustId());

		// 1 yilda kisinin cekebilecek oldugu max kredi tutari 2021 yili icin 500.000
		// olarak belirlenmistir
		Integer yearlyCreditAmount = customerloanrepo.checkAmount(customerloan.getCustId());

		if (howManyDayPassed == null && list.contains(custTcNumber) && (yearlyCreditAmount < 500000)) {
			customerloanrepo.save(customerloan);
			return customerloan;
		} else {
			long difference_In_Time = enteredCreditDate.getTime() - howManyDayPassed.getTime();

			int difference_In_Days = (int) (difference_In_Time / (24 * 60 * 60 * 1000));

			if (difference_In_Days >= 30) {
				customerloanrepo.save(customerloan);
				return customerloan;
			}

			throw new NoSuchElementException("Kredi sistemine eklenmek isteyen musteri kayit icin uygun degildir!");
		}

	}

	@Override
	public CustomerLoan checkCredit(CustomerLoan customerloan) {
		// musteri sisteme yeni eklenmis ise loyalty ve abonelik yili otomatik olarak 1
		// verilir
		// sistemde loyalty sayisi 1 ve 2 olan kullanicilar ancak salary miktarina gore
		// kredi alabilir
		// dolayisi ile sisteme yeni kayit olan musteriler maas durumlarina gore belirli
		// miktarlarda kredi alabilir
		// loan tablosunda istediklerini belirttikleri oran onaya duser

		int custId = customerloan.getCustId();

		int loanId = customerloan.getLoanId();
		int loyalty = customerloan.getLoyalty();
		int subscriptionYear = customerloan.getSubscriptionYear();
		String legProcess = customerloan.getLegProoceeding();
		int requestedCreditAmount = customerloan.getRequestedCreditAmount();

		List<BlackList> blacklist = blackListRepo.checkBlackList(custId);
		int takeSalary = customerRepo.getSalary(custId);

		if (legProcess.equals("exist") || !blacklist.isEmpty()) {

			System.out.println("Kredi alicak kosullari saglamamaktasiniz.");
			customerloanrepo.confirmOrNot("not checked", loanId);

		} else if (loyalty > 3 && subscriptionYear < 5) {

			System.out.print("50.000 tutarina kadar kredi cekilebilir ");
			if (requestedCreditAmount < 50000) {
				customerloanrepo.confirmOrNot("checked", loanId);
			} else {
				customerloanrepo.confirmOrNot("not checked", loanId);
			}

		} else if (loyalty > 3 && subscriptionYear >= 5) {

			System.out.print("500.000 tutarina kadar kredi cekilebilir ");
			if (requestedCreditAmount < 500000) {
				customerloanrepo.confirmOrNot("checked", loanId);
			} else {
				customerloanrepo.confirmOrNot("not checked", loanId);
			}
		} else {
			// loyalty <= 3
			if (takeSalary < 10000) {
				if (requestedCreditAmount > 50000) {
					System.out.print("Size uygun kredimiz bulunmamaktadir");
					customerloanrepo.confirmOrNot("not checked", loanId);
				} else {
					customerloanrepo.confirmOrNot("checked", loanId);
				}

			} else if (takeSalary >= 10000 && requestedCreditAmount < 500000) {
				System.out.print("500000 tutarina kadar kredi cekilebilir");
				customerloanrepo.confirmOrNot("checked", loanId);
			}
		}
		return customerloan;

	}
}
