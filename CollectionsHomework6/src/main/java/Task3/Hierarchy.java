package Task3;

import java.util.ArrayList;
import java.util.List;

class MedicalStaff {
}

class Doctor extends MedicalStaff {
}

class Nurse extends MedicalStaff {
}

class HeadDoctor extends Doctor {
}

public class Hierarchy {


    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(); //корректно
//        Doctor doctor2 = new MedicalStaff(); некорректно, Doctor расширяет medicalStaff(), следовательно у объекта medicalStaff может не быть того, то есть у Doctor
        Doctor doctor3 = new HeadDoctor(); //корректно
        Object object1 = new HeadDoctor(); //корректно
//        HeadDoctor doctor5 = new Object(); некорректно, HeadDoctor наследуется от Object
//        Doctor doctor6  = new Nurse(); //некорректно, Doctor может содержать то, чего нет у Nurse
//        Nurse nurse = new Doctor(); //некорректно, Nurse и Doctor это MedicalStaff, однако Doctor не может быть Nurse
        Object object2 = new Nurse(); //корректно, Nurse наследуется от Object
        List<Doctor> list1= new ArrayList<Doctor>();
//        List<MedicalStaff> list2 = new ArrayList<Doctor>(); некорректны, так как дженерики в левой иправой части должны быть равны
//        List<Doctor> list3 = new ArrayList<MedicalStaff>();
//        List<Object> list4 = new ArrayList<Doctor>();
        List<Object> list5 = new ArrayList<Object>();


    }
}
