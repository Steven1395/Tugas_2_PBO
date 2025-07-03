    ![image](https://github.com/user-attachments/assets/b9cf3244-1a91-4309-a8c9-8b56c57ab603)# Tugas_2_PBO

## Nama Kelompok :
- Steven Satyam Wijanarko (2405551036)
- I Gede Pradiva Yoga Krisnanda (2405551099)
- Marcell Christian Santoso (2405551153)


## DAFTAR ISI
1. [Cara Menjalankan Kode Program](#Cara-Menjalankan-Kode-Program)
   - [Clone Repo Github](#Clone-Repository-Github)
   - [Masuk ke Dalam Terminal](#Masuk-ke-Dalam-Terminal)
   - [Postman](#Postman)

2. [Screnshot Postman](#Screenshot-Postman)
    - [Villa](#Villa)
    - [Customer](#Customer)
    - [Voucher](#Voucher)
    

=====================================================================================

## Cara Menjalankan Kode Program
Sebuah REST API sederhana untuk sistem villa, dibangun dengan Java native dan dengan database menggunakan SQLite. API ini menyediakan fitur CRUD (Create, Read, Update, Delete) untuk villa, room, customer, booking, dan review. Berikut merupakan langkah-langkah dalam menjalankan program API ini.

### Clone Repository Github
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/8bd5a19d37886b956a18d1b9ef76ff25012737ab/SS%20Tugas%202/SS%20menjelaskan%20alur%20kode%20program/Git%20clone.png)
Pertama terlebih dahulu dilakukan clone github repository seperti pada gambar di atas. Jika clone berhasil, buka folder menggunakan aplikasi seperti VSCode, Intellij atau IDE java lainnya.

### Masuk ke Dalam Terminal 
(Misalnya Dalam Contoh Ini Menggunakan Terminal VSCode):
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/8bd5a19d37886b956a18d1b9ef76ff25012737ab/SS%20Tugas%202/SS%20menjelaskan%20alur%20kode%20program/Compile.png)
Berdasarkan gambar di atas hal yang harus dilakukan adalah:
#### Masuk ke direktori utama program:
cd tugas2/tugas2APIVilla
-	pastikan sudah masuk ke dalam folder di atas. Jika belum masuk ke dalam folder dapat melakukan perintah di atas.

#### Compile program java
javac -d bin -cp "lib/*" src/tugas2/*.java src/controllers/*.java src/models/*.java src/services/*.java src/repositories/*.java src/Tugas2.java
-	Perintah di atas akan meng-compile semua file dan memanggil semua package Java ke dalam folder bin/ serta menggunakan semua library di folder lib/.

#### Jalankan program java
java --% -Djava.net.preferIPv4Stack=true -cp "bin;lib/*" Tugas2
-	Setelah di compile, program dapat dijalankan dengan menggunakan perintah di atas. Jika berhasil, akan muncul output seperti berikut:
  
Listening on port: 8080…
-	Artinya server sudah berjalan dan siap menerima request dari Postman.

### Postman
Postman merupakan suatu platform yang digunakan oleh pengembang untuk membangun, menguji, dan mendokumentasikan API. Postman memungkinkan pengembang membuat permintaan HTTP, mengelola berbagai aspek API seperti header dan parameter, dan menguji request dan respons API. 

#### Pilih Request
Request dapat berupa GET (Read atau membaca data), POST (Create atau menambahkan data), PUT(Update atau memperbaharui data), DELETE(Delete atau menghapus data) sesuai dengan metode yang dibutuhkan pengguna, berikut merupakan daftar dari endpoint yang tersedia dalam API ini:
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/8bd5a19d37886b956a18d1b9ef76ff25012737ab/SS%20Tugas%202/SS%20menjelaskan%20alur%20kode%20program/Seluruh%20endpoint.png)

#### Contoh Request Melalui Postman
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/8bd5a19d37886b956a18d1b9ef76ff25012737ab/SS%20Tugas%202/SS%20menjelaskan%20alur%20kode%20program/Contoh%20endpoint.png)
Endpoint di atas digunakan untuk menampilkan semua data villa dalam format JSON. Untuk endpoint lain seperti POST atau PUT, pastikan menggunakan header Content-Type: application/json dan isi body JSON sesuai struktur data.

=====================================================================================

## Screenshot Postman
  Untuk memastikan bahwa setiap endpoint dapat berfungsi dengan semestinya, kami melakukan pengujian secara menyeluruh menggunakan Postman, sebuah aplikasi yang sering dimanfaatkan oleh pengembang untuk mengirim request HTTP dan mengevaluasi tanggapan dari server. Melalui penggunaan Postman ini, kami dapat melakukan simulasi berbagai jenis permintaan seperti GET, POST, PUT, dan DELETE terhadap endpoint yang telah dibuat. Selain itu, kami juga memverifikasi apakah data yang dikembalikan oleh server telah sesuai dengan format JSON yang diharapkan serta memeriksa apakah kode status HTTP yang diterima sesuai dengan hasil dari proses yang terjadi pada server.
  Note: Format untuk memasukkan gambar: ![image alt](Perma Link).
  
### Villa
  Villa merupakan entitas utama yang menjadi pusat dari seluruh sistem. Setiap villa mewakili properti akomodasi yang dapat disewa oleh pelanggan, dan memiliki atribut penting seperti nama villa, deskripsi, serta alamat lokasi. Data villa disimpan dalam tabel villas di dalam database SQLite, dan menjadi titik awal untuk entitas lainnya.

#### GET
  

##### GET Semua Data Villa
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/URL.png).
  Gambar screenshot tersebut menunjukkan interface aplikasi Postman saat melakukan pengujian terhadap endpoint API GET /villas. Pada kolom URL terlihat bahwa permintaan dikirim ke http://localhost:8080/villas, yang berarti Postman melakukan pengambilan data daftar semua vila dari server yang berjalan secara lokal di port 8080. Metode HTTP yang digunakan disini adalah GET untuk mendapatkan semua data villa. Permintaan GET tidak memerlukan body, karena tujuannya adalah hanya untuk mengambil data dari server, bukan untuk mengirimkan atau memodifikasi informasi.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/SS%201.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/SS%202.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/SS%203.png).
  Gambar-gambar screenshot di atas menampilkan response yang diterima dari server setelah request GET berhasil diproses. Status code 200 OK menunjukkan bahwa permintaan diproses dengan baik tanpa error. Postman menampilkan seluruh informasi mengenai semua villa dalam database.

##### GET Villa Berdasarkan Id
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20id/URL.png).
  Gambar di atas menunjukkan request yang dikirim melalui Postman untuk endpoint GET /villas/3. Dalam permintaan ini, method yang digunakan adalah GET, yang bertujuan untuk mengambil data detail dari vila dengan Id 3, yaitu Villa Steve.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20id/SS.png).
  Gambar screenshot di atas memperlihatkan hasil dari server setelah permintaan GET dijalankan dengan sukses. Status 200 OK mengindikasikan bahwa server dapat menangani permintaan tersebut dengan lancar dan tidak menemui kendala apa pun. Postman menampilkan seluruh informasi mengenai vila dengan Id 3 dalam database.

##### GET Villa Berdasarkan Room
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/URL.png).
  Gambar di atas memperlihatkan permintaan yang dilakukan melalui Postman ke endpoint GET /villas/3/rooms. Pada permintaan ini digunakan metode GET, yang digunakan untuk mengambil informasi lengkap mengenai kamar yang dimiliki vila dengan Id 3, yaitu Villa Steve.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/SS%201.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/SS%202.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/SS%203.png).
  Gambar screenshot di atas memperlihatkan respons dari server setelah permintaan GET dijalankan dengan sukses. Kode status 200 OK menandakan bahwa permintaan berhasil ditangani tanpa masalah. Postman kemudian menampilkan data lengkap dari kamar yang dimiliki vila dengan Id 3, yaitu Villa Steve yang terdapat dalam database.

##### GET Villa Berdasarkan Booking
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20booking/URL.png).
  Gambar di atas menunjukkan request yang dikirim melalui Postman untuk endpoint GET /villas/3/bookings. Tujuan dari permintaan ini adalah untuk mengambil seluruh data booking yang berkaitan dengan vila dengan Id 3, yaitu Villa Steve. Permintaan dikirim menggunakan metode HTTP GET agar dapat mengambil seluruh data booking.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20booking/SS.png).
  Gambar screenshot di atas memperlihatkan hasil dari server setelah permintaan GET dijalankan dengan sukses. Status 200 OK mengindikasikan bahwa server dapat menangani permintaan tersebut dengan lancar dan tidak menemui kendala apa pun. Postman menampilkan seluruh informasi mengenai booking pada vila dengan Id 3, yaitu Villa Steve.

##### GET Villa Berdasarkan Review
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20review/URL.png).
  Gambar di atas menunjukkan proses pengujian endpoint GET /villas/5/reviews menggunakan aplikasi Postman. Tujuan dari permintaan ini adalah untuk mengambil seluruh data review yang terkait dengan vila dengan Id 5. Permintaan dikirim dengan metode GET, yang artinya klien hanya ingin membaca atau mengambil data dari server tanpa mengubahnya.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20review/SS.png).
  Gambar screenshot di atas menampilkan response yang diterima dari server setelah request GET berhasil diproses. Status code 200 OK menunjukkan bahwa permintaan diproses dengan baik tanpa error. Postman menampilkan seluruh informasi mengenai review yang dimiliki vila dengan Id 5 dalam database.

##### GET Villa Berdasarkan Ketersediaan Room


=====================================================================================

#### POST

##### POST Data Villa Baru
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20villa/URL%20beserta%20Body.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20villa/Headers.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20villa/SS.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20villa/Bukti%20db.png).

##### POST Data Room Baru
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20rooms%20villa/URL%20dan%20Body.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20rooms%20villa/Headers.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20rooms%20villa/SS.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/POST/POST%20insert%20rooms%20villa/Bukti%20db.png).

=====================================================================================

#### PUT
##### PUT Update Kamar Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/URL%20dan%20Body.png)
Gambar di atas menunjukkan bagaimana endpoint dipanggil menggunakan Postman. Method yang digunakan adalah PUT dengan URL lengkap http://localhost:8080/villas/11/rooms/36. Di tab Body, dipilih raw JSON dan diisi dengan data kamar baru yang akan diperbarui yakni: id, name, quantity, capacity, dan price.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/Headers.png)
Gambar di atas menunjukkan header yang digunakan dalam request PUT. Yang terpenting adalah Content-Type: application/json, yang memberi tahu server bahwa body yang dikirim adalah format JSON. Tanpa header ini, server kemungkinan gagal membaca isi data JSON. Header lain seperti Accept dan Connection adalah default dari Postman, tidak wajib diatur manual.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/SS.png)
Gambar di atas menunjukkan hasil response dari server setelah request dikirim. Response menunjukkan status 200 OK dan pesan JSON berupa "Kamar berhasil diperbarui." Ini menunjukkan bahwa server berhasil menerima dan memproses data sesuai logika program (controller dan repository). Status code dan pesan ini penting untuk memastikan bahwa request valid dan diterima oleh backend.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/Bukti%20db.png)
Gambar di atas menunjukkan tampilan isi tabel room_types di database SQLite setelah update berhasil dilakukan. Baris dengan id = 36 berhasil ditambahkan, artinya data kamar tersebut sukses dimasukkan ke database. Sehingga hal ini membuktikan bahwa integrasi antara endpoint, controller, repository, dan database berjalan dengan sukses.

##### PUT Update Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/URL%20dan%20Body.png)
Gambar di atas menunjukkan bagaimana endpoint dipanggil menggunakan Postman. Method yang digunakan adalah PUT dengan URL lengkap http://localhost:8080/villas/11. Di tab Body, dipilih raw JSON dan diisi dengan data kamar baru yang akan diperbarui yakni: name, description, dan address.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/Headers.png)
Gambar di atas menunjukkan header yang digunakan dalam request PUT untuk update villa. Yang terpenting adalah Content-Type: application/json, yang memberi tahu server bahwa body yang dikirim adalah format JSON. Tanpa header ini, server kemungkinan gagal membaca isi data JSON. Header lain seperti Accept dan Connection adalah default dari Postman, tidak wajib diatur manual.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/SS.png)
Gambar di atas menunjukkan hasil response dari server setelah request dikirim. Response menunjukkan status 200 OK dan pesan JSON berupa "Villa berhasil diperbarui." Ini menunjukkan bahwa server berhasil menerima dan memproses data sesuai logika program (controller dan repository). Status code dan pesan ini penting untuk memastikan bahwa request valid dan diterima oleh backend.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/Bukti%20db.png)
Gambar di atas menunjukkan tampilan isi tabel villas di database SQLite setelah update berhasil dilakukan. Baris dengan id = 11 berhasil ditambahkan, artinya data villa tersebut sukses dimasukkan ke database. Sehingga hal ini membuktikan bahwa integrasi antara endpoint, controller, repository, dan database berjalan dengan sukses.

=====================================================================================

#### DELETE

##### DELETE Kamar Suatu Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20room/URL.png)
Gambar di atas menunjukkan penggunaan method DELETE pada endpoint http://localhost:8080/villas/11/rooms/36. Secara otomatis header Content-Type application/json diterapkan oleh Postman, meskipun tidak wajib untuk DELETE terutama DELETE tanpa body. Endpoint ini menargetkan penghapusan kamar dengan ID 36 yang termasuk dalam villa dengan ID 11.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20room/SS.png)
Setelah permintaan DELETE dikirim, server merespons dengan status code 200 OK, yang berarti permintaan berhasil diproses. Body response berisi JSON dengan pesan: "Kamar berhasil dihapus.", yang merupakan konfirmasi bahwa kamar dengan ID tersebut sudah dihapus dari database. Ini menunjukkan bahwa server menjalankan proses DELETE sesuai logika di controller dan repository.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20room/Bukti%20db.png)
Gambar di atas menunjukkan tampilan isi tabel room_types di database SQLite setelah penghapusan berhasil dilakukan. Baris dengan id = 36 sudah tidak ada, artinya kamar tersebut benar-benar telah dihapus dari basis data. Ini membuktikan bahwa integrasi antara endpoint, controller, repository, dan database berjalan dengan sukses.


##### DELETE Data Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20villa/URL.png)
Gambar di atas menunjukkan penggunaan method DELETE pada endpoint http://localhost:8080/villas/11. Secara otomatis header Content-Type application/json diterapkan oleh Postman, meskipun tidak wajib untuk DELETE terutama DELETE tanpa body. Endpoint ini menargetkan penghapusan villa dengan ID = 11.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20villa/SS.png)
Setelah permintaan DELETE dikirim, server merespons dengan status code 200 OK, yang berarti permintaan berhasil diproses. Body response berisi JSON dengan pesan: "Villa berhasil dihapus.", yang merupakan konfirmasi bahwa Villa dengan ID = 11 sudah dihapus dari database. Ini menunjukkan bahwa server menjalankan proses DELETE sesuai logika di controller dan repository.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20villa/Bukti%20db.png)
Gambar di atas menunjukkan tampilan isi tabel villas di database SQLite setelah penghapusan berhasil dilakukan. Baris dengan id = 11 sudah tidak ada, artinya villa tersebut benar-benar telah dihapus dari database. Ini membuktikan bahwa integrasi antara endpoint, controller, repository, dan database berjalan dengan sukses

=====================================================================================

### Customer
  Customer atau pelanggan merupakan entitas penting yang merepresentasikan pengguna akhir dari sistem, yaitu orang yang melakukan pemesanan villa. Data customer disimpan dalam tabel customers di database, dan mencakup informasi pribadi seperti nama, alamat email, dan nomor telepon.

#### GET

##### GET Semua Data Customer
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/URL.png)
Gambar di atas menunjukkan proses pengiriman permintaan menggunakan metode HTTP GET pada URL http://localhost:8080/customers. Permintaan GET ini bertujuan untuk mengambil data dari server tanpa mengubah data di sisi server. Dalam kasus ini, pengguna cukup memasukkan URL lengkap ke dalam kolom alamat di Postman dan memilih metode GET tanpa perlu mengisi bagian body. Endpoint ini dapat digunakan untuk menampilkan seluruh data customer.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/SS%201.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/SS%202.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/SS%203.png)
Gambar di atas menampilkan hasil respons dari server setelah permintaan GET dikirim. Data ditampilkan dalam format JSON yang berisi informasi yang diminta dari database. Jika permintaan berhasil diproses, server akan mengembalikan status HTTP 200 OK disertai dengan konten data yang sesuai, berupa JSON. Sesuai dengan gambar di atas, ditampilkan data dari semua customer.

##### GET Customer Berdasarkan Booking
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20booking/URL.png)
Gambar di atas menunjukkan proses pengiriman permintaan menggunakan metode HTTP GET pada URL http://localhost:8080/customers/3/bookings. Permintaan GET ini bertujuan untuk mengambil data dari server tanpa mengubah data di sisi server. Dalam kasus ini, pengguna cukup memasukkan URL lengkap ke dalam kolom alamat di Postman dan memilih metode GET tanpa perlu mengisi bagian body. Endpoint ini dapat digunakan untuk menampilkan booking yang dilakukan oleh seorang customer berdasarkan ID-nya, dalam contoh di atas ID customer = 3.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20booking/SS.png)
Gambar di atas menampilkan hasil respons dari server setelah permintaan GET dikirim. Data ditampilkan dalam format JSON yang berisi informasi yang diminta dari database. Jika permintaan berhasil diproses, server akan mengembalikan status HTTP 200 OK disertai dengan konten data yang sesuai, berupa JSON. Sesuai dengan gambar di atas, ditampilkan data booking yang telah dilakukan oleh customer dengan ID = 3.

##### GET Customer Berdasarkan Id
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20id/URL.png)
Gambar di atas menunjukkan proses pengiriman permintaan menggunakan metode HTTP GET pada URL http://localhost:8080/customers/3. Permintaan GET ini bertujuan untuk mengambil data dari server tanpa mengubah data di sisi server. Dalam kasus ini, pengguna cukup memasukkan URL lengkap ke dalam kolom alamat di Postman dan memilih metode GET tanpa perlu mengisi bagian body. Endpoint ini dapat digunakan untuk menampilkan data seorang customer berdasarkan ID-nya, pada contoh ID customer = 3.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20id/SS.png)
Gambar di atas menampilkan hasil respons dari server setelah permintaan GET dikirim. Data ditampilkan dalam format JSON yang berisi informasi yang diminta dari database. Jika permintaan berhasil diproses, server akan mengembalikan status HTTP 200 OK disertai dengan konten data yang sesuai, berupa JSON. Sesuai dengan gambar di atas, ditampilkan data dari salah satu customer yang memiliki ID = 3.

##### GET Customer Berdasarkan Review
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20review/URL.png)
Gambar di atas menunjukkan proses pengiriman permintaan menggunakan metode HTTP GET pada URL http://localhost:8080/customers/1/reviews. Permintaan GET ini bertujuan untuk mengambil data dari server tanpa mengubah data di sisi server. Dalam kasus ini, pengguna cukup memasukkan URL lengkap ke dalam kolom alamat di Postman dan memilih metode GET tanpa perlu mengisi bagian body. Endpoint ini dapat digunakan untuk menampilkan suatu review yang dilakukan oleh seorang customer berdasarkan ID yan customer tersebut. Dalam contoh ini dicari review apa saja yang telah diberikan oleh customer dengan ID = 1.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20review/SS.png)
Gambar di atas menampilkan hasil respons dari server setelah permintaan GET dikirim. Data ditampilkan dalam format JSON yang berisi informasi yang diminta dari database. Jika permintaan berhasil diproses, server akan mengembalikan status HTTP 200 OK disertai dengan konten data yang sesuai, berupa JSON. Sesuai dengan gambar di atas, ditampilkan data review yang telah dilakukan oleh customer dengan ID = 1.

=====================================================================================

#### POST
##### POST Data Customer Baru
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/URL.png)
Gambar di atas menunjukkan penggunaan method POST pada endpoint http://localhost:8080/customers. Pada bagian Body, data dikirim dalam format JSON dan memuat atribut id, name, email, dan phone. Ini adalah data customer baru yang ingin ditambahkan ke sistem. Tab raw dan format JSON harus dipilih agar server dapat membaca datanya dengan benar.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/Headers.jpg)
Gambar ini memperlihatkan semua header yang dikirim bersamaan dengan request POST. Yang paling penting adalah Content-Type: application/json yang menandakan bahwa body dikirim dalam bentuk JSON. Header lainnya seperti Host, User-Agent, dan Accept biasanya diisi otomatis oleh Postman.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/SS.png)
Gambar tersebut menampilkan response dari server setelah menerima permintaan POST. Status 201 Created menunjukkan bahwa customer berhasil ditambahkan ke database. Pesan JSON "Customer berhasil ditambahkan" dikembalikan dari controller sebagai tanda bahwa proses insert berhasil dijalankan melalui service dan repository.

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/Bukti%20DB.png)
Gambar di atas menunjukkan isi tabel customers dalam database setelah data ditambahkan. Customer baru dengan id = 13 dan nama "Angela Abigail Seubelan" kini tercatat di database, membuktikan bahwa data dari Postman berhasil disimpan ke database villa.db.

.
##### POST Data Bookings Customer Baru
![image alt](https://github.com/user-attachments/assets/7e8326e9-fe11-43d8-97d6-9f7e26d97be9)
.
![image alt](https://github.com/user-attachments/assets/e101b632-52c5-4b3d-8211-599dbd053ed8)
.
![image alt](https://github.com/user-attachments/assets/32d62dc6-b13b-4fea-86fb-0bd8651edae3)
.
![image alt](https://github.com/user-attachments/assets/378d91f0-12dd-4ac5-9d1d-98479e5bd1cb)

##### POST Data Review Customers
![image alt](https://github.com/user-attachments/assets/d8db0127-a8fb-4588-9db5-280a362da821)
.
![image alt](https://github.com/user-attachments/assets/f06fcc44-46f7-425e-911f-242d663827f2)
.
![image alt](https://github.com/user-attachments/assets/9518bc1c-298c-4c35-ace4-99f0d3736c45)
.
![image alt](https://github.com/user-attachments/assets/17e23fa7-4c0b-448e-928f-c5f78528f4b2)

=====================================================================================

#### PUT

##### PUT Mengubah Data Customer
![image alt](https://github.com/user-attachments/assets/7c5776c3-64c3-4fb8-8ec2-e3131cd7fc7a)
.
![image alt](https://github.com/user-attachments/assets/0984c0c1-3ea3-48b4-a525-e07b94dbf61c)
.
![image alt](https://github.com/user-attachments/assets/7c29c2e5-f7b1-468b-8643-8acf962a819f)
.
![image alt](https://github.com/user-attachments/assets/1f7aa074-8f3e-4a38-9160-09b326f627df)

=====================================================================================

#### DELETE


=====================================================================================

### Voucher
  Voucher merupakan entitas yang berfungsi sebagai media pemberian potongan harga atau diskon kepada pelanggan saat melakukan pemesanan. Data voucher disimpan dalam tabel vouchers di database dan berisi informasi penting seperti kode voucher, deskripsi, nilai diskon (dalam bentuk persentase atau nominal), serta tanggal mulai dan berakhirnya masa berlaku voucher.

#### GET

##### GET Semua Data Vouchers
![image alt](https://github.com/user-attachments/assets/9e27dcc9-9fbe-4f13-8155-e11f6f1f552f)
.
![image alt](https://github.com/user-attachments/assets/a30589e5-7b39-4618-b08b-7766f3428a07)
.
![image alt](https://github.com/user-attachments/assets/31e46d65-19d3-406b-bb89-0c59c55c126c)
.
![image alt](https://github.com/user-attachments/assets/aa3d77b2-6d13-42c2-815f-28245ae9a7ef)


##### GET Vouchers by ID
![image](https://github.com/user-attachments/assets/593a0822-3aac-4e1a-8983-2560024b84ad)
.
![image](https://github.com/user-attachments/assets/46210fa1-a0e5-4ee2-a981-557c34d4c438)
.

=====================================================================================

#### POST

##### POST Membuat Voucher Baru
![image alt](https://github.com/user-attachments/assets/f1c08ab0-3563-4fc6-8531-5cb8487f0b41)
.
![image alt](https://github.com/user-attachments/assets/daf68476-e974-41ae-a930-f9385b72ea3f)
.
![image alt](https://github.com/user-attachments/assets/2d7fc11c-794b-47dc-a110-bd7adc22cd92)
.
![image alt](https://github.com/user-attachments/assets/c5a14807-fbb5-406f-ae92-fac857150fef)

=====================================================================================

#### PUT

##### PUT Update Vouchers
![image alt](https://github.com/user-attachments/assets/bc633345-f657-4653-851a-83077edfea91)
.
![image alt](https://github.com/user-attachments/assets/427251e0-e0a6-4a5c-a04d-93796fcdffdb)
.
![image alt](https://github.com/user-attachments/assets/909b6c36-bcd6-437a-92ab-3386d65473b9)
.
![image alt](https://github.com/user-attachments/assets/95795526-b385-4bb7-bcb6-462dbac17120)

=====================================================================================

#### DELETE

##### DELETE Menghapus Voucher
![image alt](https://github.com/user-attachments/assets/d1c2ecbd-7bf9-4c99-9902-3c222b803152)
.
![image alt](https://github.com/user-attachments/assets/2e12ab7a-2dd2-4748-8105-71c2fb5f2c76)
.
![image alt](https://github.com/user-attachments/assets/5115b2b4-ceec-471a-a01d-9ba21e68883d)

=====================================================================================


