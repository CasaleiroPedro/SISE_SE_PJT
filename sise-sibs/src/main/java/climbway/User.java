package climbway;

import java.util.ArrayList;
import java.util.HashMap;

import pt.ulisboa.tecnico.learnjava.bank.services.Services;
import pt.ulisboa.tecnico.learnjava.sibs.domain.Sibs;

// UserMBWay
public class User {
	String iban;
	String phoneNumber;
	Sibs sibs;
	Services services;
	
	ArrayList<String> list = new ArrayList();
	HashMap<String, ArrayList<String>> collection = new HashMap<String, ArrayList<String>>();
	ArrayList<String> listFriends = new ArrayList();
	
	public void exit() {
		System.out.println("You exit the app");
		return;
	}
	
	public void associateMBway(String iban, String phoneNumber) {
		int max = 999999;
		int min = 100000;
		int code =(int) (Math.random() * (max- min +1) +min );
		if(collection.containsKey(phoneNumber)) {
			System.out.println("Fail: Your phone number is already registered in MBWay");
		} else { 
			list.add(iban);
			list.add(String.valueOf(code));
			collection.put(phoneNumber, list);
			System.out.println("Your code: " + code + "(don´t share this with anyone)");
		}
	}

	public void confirmMbway(String code, String phoneNumber) {
		if(collection.get(phoneNumber).contains(code)) {
			System.out.println("MBWay association confirmed sucessfully!");
			collection.get(phoneNumber).remove(1);
		} else {
			System.out.println("Wrong confirmation code. Try association again.");
			collection.remove(phoneNumber, list);
		}
	}
	
	public void transferMBway (String sourcePhoneNumer, String targetPhoneNumaber, int amount) {
		if (collection.containsKey(sourcePhoneNumer) && collection.containsKey(targetPhoneNumaber)) {
			try {
			sibs.transfer(collection.get(sourcePhoneNumer).get(0), collection.get(targetPhoneNumaber).get(0), amount);
			System.out.println("Transfer performed successfully!");
			} catch (Exception e) {
				System.out.println("Not enough money on the source account.");
			}
		} else {
			System.out.println("Wrong phone number. This phone number isn't associated with MBWay");
		}
	}
	
	public void mbwayFriend(String friendPhoneNumber) {
		if(collection.containsKey(friendPhoneNumber)) {
			collection.get(phoneNumber).add(friendPhoneNumber);
		} else {
			System.out.println("You cant add this friend. This phone number isn't associated with MBWay");
		}
	}
	
	public void mbwaySplitBill(int numberFriends, int billAmount) {
		int i=0;
		ArrayList<String> list14Friends = new ArrayList();
		if (numberFriends>14) {
			System.out.println("Oh no! Too many friends.");
		} else {
			for() {
			
		}
		
		
		}else {
			System.out.println("Wrong phone number. This phone number isn't associated with MBWay");
		}
	}
//	• mbway-split-bill – splits the bill between friends.
//	– The operation needs to account the following:
//	1. The total bill value has to be the sum of the amounts payed by each friend.
//	2. The number of payments performed needs to be equal to the number of friends.
//	3. All friends must to have sufficient money in their bank accounts.
//	– After this command, the application should only accept friend commands until an end command
//	is issued. Each friend has to have an account. You should assume that the first friend is the
//	user.
//	– input format: friend <PHONE_NUMBER> <AMOUNT>
//	– error example output: Friend <PHONE_NUMBER> is not registered.
//	– example: mbway-split-bill <NUMBER_OF_FRIENDS> <AMOUNT>
//	– example output: Bill payed successfully!k
//	– error example output: Oh no! One friend does not have money to pay!
//	– error example output: Oh no! Too many friends.
//	– error example output: Oh no! One friend is missing.
//	– error example output: Something is wrong. Did you set the bill amount right?
//	public void 
	
	public String getIban() {
		return iban;
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public String getPhone_number() {
		return phoneNumber;
	}
	
	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}
//	public static  void main(String args[]) {
//		User user = new User();
//		user.associateMBway("123456789", "967440681");
//		
//	}
	
}
