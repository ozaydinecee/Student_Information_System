package com.company;

public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;

    boolean isPass;


    public Student(String name, String stuNo, int classes, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }

    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }
        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }

    public void addBulkVerbalNote(int verbalMat, int verbalFizik, int verbalTarih){
        if(verbalMat >=0 && verbalMat <=100){
            this.mat.verbalGrade = verbalMat;
        }
        if(verbalFizik >=0 && verbalFizik <=100){
            this.fizik.verbalGrade = verbalFizik;
        }
        if(verbalTarih >=0 && verbalTarih <=100){
            this.kimya.verbalGrade = verbalTarih;
        }
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0 || this.fizik.verbalGrade == 0 || this.kimya.verbalGrade == 0 || this.mat.verbalGrade == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    void calcAvarage() {
        double matAverage=(this.mat.note*0.8)+(this.mat.verbalGrade*0.2);
        double fizikAverage=(this.fizik.note*0.8)+(this.fizik.verbalGrade*0.2);
        double kimyaAverage=(this.kimya.note*0.8)+(this.kimya.verbalGrade*0.2);

        this.avarage=(matAverage+fizikAverage+kimyaAverage)/3.0;
    }


    public void printNote(){
        System.out.println("==================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik---> Sınav Notu : " + this.mat.note +    " / Sözlü Notu : "+this.mat.verbalGrade);
        System.out.println("Fizik--->     Sınav Notu : " + this.fizik.note +  " / Sözlü Notu : "+this.fizik.verbalGrade);
        System.out.println("Tarih--->     Sınav Notu : " + this.kimya.note +" / Sözlü Notu : "+this.kimya.verbalGrade);
    }

}