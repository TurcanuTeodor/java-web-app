package ro.app.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.app.model.ClientTable;
import ro.app.model.ContTable;
import ro.app.model.TranzactiiTable;
import ro.app.model.ContactInfoTable;
import ro.app.model.ViewClient;
import ro.app.model.ViewCont;
import ro.app.model.ViewTranzactii;

import ro.app.service.ClientTableService;
import ro.app.service.ContTableService;
import ro.app.service.ReportService;
import ro.app.service.TranzactiiTableService;
import ro.app.service.ViewClientService;
import ro.app.service.ViewContService;
import ro.app.service.ViewTranzactiiService;
import ro.app.service.ContactInfoService;

@Controller
public class ViewController {

    // ==========================
    // Clients
    // ==========================
    @Autowired
    private ViewClientService viewClientService;

    @Autowired
    private ClientTableService clientTableService;

    @GetMapping("/clients")
    @ResponseBody
    public List<ViewClient> getClients() {
        return viewClientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    @ResponseBody
    public ViewClient getClientById(@PathVariable Long id) {
        return viewClientService.getClientById(id);
    }

    @PostMapping("/clients")
    @ResponseBody
    public ResponseEntity<String> addClient(@Validated @RequestBody ClientTable client) {
        clientTableService.addClient(client);
        return ResponseEntity.ok("Clientul a fost adaugat cu succes!");
    }

    @PutMapping("/clients")
    @ResponseBody
    public ResponseEntity<String> updateClient(@Validated @RequestBody ClientTable client) {
        clientTableService.updateClient(client);
        return ResponseEntity.ok("Clientul a fost actualizat cu succes!");
    }

    @DeleteMapping("/clients/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientTableService.deleteClient(id);
        return ResponseEntity.ok("Clientul a fost sters cu succes!");
    }

    @GetMapping("/clients/count")
    @ResponseBody
    public Long getClientCount() { 
        return viewClientService.getClientCount();
    }

    @GetMapping("/clients/most-accounts")
    @ResponseBody
    public List<Object[]> getClientsWithMostAccounts() {
        return viewClientService.getClientsWithMostAccounts();
    }

    @GetMapping("/clients/{id}/contact")
    @ResponseBody
    public Map<String, Object> getClientContactDetails(@PathVariable Long id) {
        return viewClientService.getClientContactDetails(id);
    }

    // ==========================
    // Accounts
    // ==========================
    @Autowired
    private ViewContService viewContService;

    @Autowired
    private ContTableService contTableService;

    @GetMapping("/accounts")
    @ResponseBody
    public List<ViewCont> getAccounts() {
        return viewContService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    @ResponseBody
    public ViewCont getAccountById(@PathVariable Long id) {
        return viewContService.getAccountById(id);
    }

    @PostMapping("/accounts")
    @ResponseBody
    public ResponseEntity<String> addAccount(@Validated @RequestBody ContTable cont) {
        contTableService.addAccount(cont);
        return ResponseEntity.ok("Contul a fost adaugat cu succes!");
    }

    @PutMapping("/accounts")
    @ResponseBody
    public ResponseEntity<String> updateAccount(@Validated @RequestBody ContTable cont) {
        contTableService.updateAccount(cont);
        return ResponseEntity.ok("Contul a fost actualizat cu succes!");
    }

    @DeleteMapping("/accounts/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        contTableService.deleteAccount(id);
        return ResponseEntity.ok("Contul a fost sters cu succes!");
    }

    @GetMapping("/accounts/count")
    @ResponseBody
    public Long getAccountCount() {
        return viewContService.getAccountCount();
    }

    @GetMapping("/accounts/total-balance")
    @ResponseBody
    public Double getTotalBalance() {
        return viewContService.getTotalBalance();
    }

    // ==========================
    // Transactions
    // ==========================
    @Autowired
    private ViewTranzactiiService viewTranzactiiService;

    @Autowired
    private TranzactiiTableService tranzactiiTableService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/transactions")
    @ResponseBody
    public List<ViewTranzactii> getTransactions() {
        return viewTranzactiiService.getAllTransactions();
    }

    @GetMapping("/transactions/filter")
    @ResponseBody
    public List<ViewTranzactii> getTransactionsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return viewTranzactiiService.getTransactionsByDateRange(startDate, endDate);
    }

    @PostMapping("/transactions")
    @ResponseBody
    public ResponseEntity<String> addTransaction(@Validated @RequestBody TranzactiiTable tranzactie) {
        tranzactiiTableService.addTransaction(tranzactie);
        return ResponseEntity.ok("Tranzactia a fost adaugata cu succes!");
    }

    @PutMapping("/transactions")
    @ResponseBody
    public ResponseEntity<String> updateTransaction(@Validated @RequestBody TranzactiiTable tranzactie) {
        tranzactiiTableService.updateTransaction(tranzactie);
        return ResponseEntity.ok("Tranzactia a fost actualizata cu succes!");
    }

    @DeleteMapping("/transactions/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        tranzactiiTableService.deleteTransaction(id);
        return ResponseEntity.ok("Tranzactia a fost stearsa cu succes!");
    }

    @GetMapping("/transactions/count")
    @ResponseBody
    public Long getTransactionCount() {
        return viewTranzactiiService.getTransactionCount();
    }

    @GetMapping("/transactions/grouped-by-type")
    @ResponseBody
    public List<Object[]> getTransactionsGroupedByType() {
        return viewTranzactiiService.getTransactionsGroupedByType();
    }

    @GetMapping("/transactions/above-amount")
    @ResponseBody
    public List<ViewTranzactii> getTransactionsAboveAmount(@RequestParam("amount") Double amount) {
        return viewTranzactiiService.getTransactionsAboveAmount(amount);
    }

    @GetMapping("/transactions/summary")
    @ResponseBody
    public List<Object[]> getTransactionSummary() {
        return reportService.getTransactionSummary();
    }

    @GetMapping("/transactions/summary-by-date")
    @ResponseBody
    public List<Object[]> getTransactionSummaryByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return reportService.getTransactionSummaryByDateRange(startDate, endDate);
    }

    // ==========================
    // Contact Info
    // ==========================
    @Autowired
    private ContactInfoService contactInfoService;

    @PostMapping("/contacts")
    @ResponseBody
    public ContactInfoTable addContact(@Validated @RequestBody ContactInfoTable contact) {
        return contactInfoService.addContact(contact);
    }

}