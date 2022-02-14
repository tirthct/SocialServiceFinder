export interface User{
    id: number;
	name: string;
	email: string;
	dob: Date;
	phoneNo: string;
	address: string;
	city: string;
	pinCode: number;
    preferences: string[];
}