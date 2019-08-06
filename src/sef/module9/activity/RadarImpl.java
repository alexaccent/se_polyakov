package sef.module9.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import sef.module9.activity.RadarContactImpl;

/**
 * Implementation of a Radar 
 * 
 *
 */
public class RadarImpl implements Radar{

	private List<RadarContact> radarContacts;
	
	/**
	 *  Constructs a new Radar 
	 */
	public RadarImpl() {
		radarContacts = new ArrayList<>();
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
	 */
	public RadarContact addContact(RadarContact contact) {

		if (radarContacts.contains(contact.getContactID())) {

			int contactIndex = radarContacts.indexOf(contact);
			radarContacts.set(contactIndex, contact);

			return  contact;
		}

		radarContacts.add(contact);
		return contact;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContact(java.lang.String)
	 */
	public RadarContact getContact(String id) {

		if (id != "0") {
			for(RadarContact  radarContact : radarContacts) {

				if(radarContact.getContactID().equals(id)) {
					return radarContact;
				}
			}
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContactCount()
	 */
	public int getContactCount() {
		int contactCount = radarContacts.size();

		return contactCount;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#removeContact(java.lang.String)
	 */
	public RadarContact removeContact(String id) {

		if (id != "0") {

			for (RadarContact radarContact : radarContacts) {

				if(radarContact.getContactID().equals(id)) {
					radarContacts.remove(radarContact);
					return radarContact;
				}
			}
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts()
	 */
	public List<RadarContact> returnContacts() {
		return new ArrayList<>(radarContacts);
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
	 */

	public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {

		List<RadarContact> compareRadarContacts = new ArrayList<>(radarContacts);
		Collections.sort(compareRadarContacts, comparator);

		return compareRadarContacts;
	}

}
