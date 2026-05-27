package HMS.controller;

import java.time.LocalDateTime;
import java.util.List;

import HMS.Entity.bills;
import HMS.View.BillView;
import HMS.dao.BillDAO;

public class BillController {

	private BillDAO dao;
	private BillView view;

	public BillController(BillDAO dao, BillView view) {

		this.dao = dao;
		this.view = view;
	}

	public void run() {

		while (true) {

			int choice = view.showMenu();

			switch (choice) {

			// ADD BILL
			case 1: {

				int patientId = view.getPatientId();

				int appointmentId = view.getAppointmentId();

				double amount = view.getTotalAmount();

				String paymentStatus = view.getPaymentStatus();

				LocalDateTime billDate = view.getBillDate();

				bills b = new bills(patientId, appointmentId, amount, paymentStatus, billDate);

				boolean check = dao.addBill(b);

				if (check) {

					System.out.println("Bill Added Successfully");
				}

				else {

					System.out.println("Bill Not Added");
				}

				break;
			}

			// UPDATE BILL
			case 2: {
				int billId = view.getBillId();
				int patientId = view.getPatientId();
				int appointmentId = view.getAppointmentId();
				double amount = view.getTotalAmount();
				String paymentStatus = view.getPaymentStatus();
				LocalDateTime billDate = view.getBillDate();
				bills b = new bills(patientId, appointmentId, amount, paymentStatus, billDate);
				b.setBillId(billId);
				boolean check = dao.updateBill(b);

				if (check) {

					System.out.println("Bill Updated Successfully");

				}

				else {

					System.out.println("Bill Not Updated");

				}

				break;
			}
			
			// DELETE BILL
			case 3: {
				
				int billId = view.getBillId();
				
				boolean check = dao.deleteBill(billId);
				
				if (check) {
					
					System.out.println("Bill Deleted Successfully");
				}
				
				else {
					
					System.out.println("Bill Not Deleted");
				}
				
				break;
			}
			
			// READ ALL BILLS
			case 4: {
				
				List<bills> billList = dao.readAll();
				
				if (billList.isEmpty()) {
					
					System.out.println("No Bills Found");
				}
				
				else {
					
					for (bills b : billList) {
						System.out.println("--------------------------------");
						System.out.println("Bill ID : " + b.getBillId());
						System.out.println("Patient ID : " + b.getPatient());
						System.out.println("Appointment ID : " + b.getAppointment());
						System.out.println("Total Amount : " + b.getTotalAmount());
						System.out.println("Payment Status : " + b.getPaymentStatus());
						System.out.println("Bill Date : " + b.getBillDate());
						System.out.println("--------------------------------");
						
					}
				}
				
				break;
			}
			
			// EXIT
			case 5: {
				
				System.out.println("Exiting Bill Management System...");
				return;
			}
			
			// INVALID CHOICE
			default:
				
				System.out.println("Invalid Choice");
			}
		}
	}
}












