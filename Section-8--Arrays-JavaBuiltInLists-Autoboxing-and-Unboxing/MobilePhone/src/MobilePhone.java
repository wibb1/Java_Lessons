import java.util.ArrayList;

public class MobilePhone {
  private String myNumber;
  private ArrayList<Contact> myContacts;

  public MobilePhone(String myNumber) {
    this.myNumber = myNumber;
    this.myContacts = new ArrayList<Contact>();
  }

  public boolean addNewContact(Contact contact) {
    boolean answer = findContact(contact.getName()) >= 0;
    if (!answer) {
      myContacts.add(contact);
    }
    return !answer;
  }

  public boolean updateContact(Contact oldContact, Contact newContact) {
    int position = findContact(oldContact);
    boolean answer = position>=0;
    if (answer) {
      myContacts.set(position, newContact);
    }
    return answer;
  }

  public boolean removeContact(Contact contact) {
    boolean answer = (findContact(queryContact(contact.getName())) >= 0);
    if (answer) {
      myContacts.remove(contact);
    }
    return answer;
  }

  private int findContact(Contact contact) {
    return myContacts.indexOf(contact);
  }

  private int findContact(String name) {
    for(int i=0; i<this.myContacts.size(); i++) {
      Contact contact = this.myContacts.get(i);
      if(contact.getName().equals(name)) {
          return i;
      }
  }
  return -1;
  }

  public Contact queryContact(String name) {
    int position = findContact(name);
    if (position >= 0){
      return this.myContacts.get(position);
    }
    return null;
  }

  public void printContacts() {
    System.out.println("Contact List:");
    for (int i = 0; i < myContacts.size(); i++) {
      System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
    }
  }
}