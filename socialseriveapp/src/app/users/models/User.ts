export interface User {
	name: string;
	email: string;
	dob: Date;
	phoneNo: string;
	address: string;
	city: string;
	pinCode: number;
	password: string;
	preferences: string[];
	rewards: number;
	deleted: boolean;
}