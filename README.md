# Tugas_2_PBO

## Nama Kelompok :
- Steven Satyam Wijanarko (2405551036)
- I Gede Pradiva Yoga Krisnanda (2405551099)
- Marcell Christian Santoso (2405551153)

## Cara Menjalankan Kode Program

## Screenshot Postman
  Untuk memastikan bahwa setiap endpoint dapat berfungsi dengan semestinya, kami melakukan pengujian secara menyeluruh menggunakan Postman, sebuah aplikasi yang sering dimanfaatkan oleh pengembang untuk mengirim request HTTP dan mengevaluasi tanggapan dari server. Melalui penggunaan Postman ini, kami dapat melakukan simulasi berbagai jenis permintaan seperti GET, POST, PUT, dan DELETE terhadap endpoint yang telah dibuat. Selain itu, kami juga memverifikasi apakah data yang dikembalikan oleh server telah sesuai dengan format JSON yang diharapkan serta memeriksa apakah kode status HTTP yang diterima sesuai dengan hasil dari proses yang terjadi pada server.
  Note: Format untuk memasukkan gambar: ![image alt](Perma Link).

### Villa
  Villa merupakan entitas utama yang menjadi pusat dari seluruh sistem. Setiap villa mewakili properti akomodasi yang dapat disewa oleh pelanggan, dan memiliki atribut penting seperti nama villa, deskripsi, serta alamat lokasi. Data villa disimpan dalam tabel villas di dalam database SQLite, dan menjadi titik awal untuk entitas lainnya.

#### GET
##### GET Semua Data Villa
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/URL.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/SS%201.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/SS%202.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa/SS%203.png).

##### GET Villa Berdasarkan Id
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20id/URL.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20id/SS.png).

##### GET Villa Berdasarkan Room
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/URL.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/SS%201.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/SS%202.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20room/SS%203.png).

##### GET Villa Berdasarkan Booking
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20booking/URL.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20booking/SS.png).

##### GET Villa Berdasarkan Review
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20review/URL.png).

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/68a323b82184672c41a8d80c33be1cb894b87dae/SS%20Tugas%202/Villa/GET/GET%20villa%20by%20review/SS.png).

##### GET Villa Berdasarkan Ketersediaan Room



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

#### PUT
##### PUT Update Kamar Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/URL%20dan%20Body.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/SS.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/Headers.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20kamar%20villa/Bukti%20db.png)

##### PUT Update Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/URL%20dan%20Body.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/SS.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/Headers.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/PUT/PUT%20update%20villa/Bukti%20db.png)

#### DELETE

##### DELETE Kamar Suatu Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20room/URL.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20room/SS.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20room/Bukti%20db.png)


##### DELETE Data Villa

![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20villa/URL.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20villa/SS.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Villa/DEL/DEL%20villa/Bukti%20db.png)




### Customer
  Customer atau pelanggan merupakan entitas penting yang merepresentasikan pengguna akhir dari sistem, yaitu orang yang melakukan pemesanan villa. Data customer disimpan dalam tabel customers di database, dan mencakup informasi pribadi seperti nama, alamat email, dan nomor telepon.

#### GET

##### GET Semua Data Customer
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/URL.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/SS%201.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/SS%202.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20all%20cust/SS%203.png)

##### GET Customer Berdasarkan Booking
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20booking/URL.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20booking/SS.png)

##### GET Customer Berdasarkan Id
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20id/URL.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20id/SS.png)

##### GET Customer Berdasarkan Review
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20review/URL.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/GET/GET%20cust%20by%20review/SS.png)



#### POST
##### POST Data Customer Baru
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/URL.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/SS.png)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/Headers.jpg)
![image alt](https://github.com/Steven1395/Tugas_2_PBO/blob/003cf3c5abe94cc9046a342a62b1efba8ea214a4/SS%20Tugas%202/Customer/POST/Add%20Cust/Bukti%20DB.png)

#### PUT


#### DELETE


### Voucher
  Voucher merupakan entitas yang berfungsi sebagai media pemberian potongan harga atau diskon kepada pelanggan saat melakukan pemesanan. Data voucher disimpan dalam tabel vouchers di database dan berisi informasi penting seperti kode voucher, deskripsi, nilai diskon (dalam bentuk persentase atau nominal), serta tanggal mulai dan berakhirnya masa berlaku voucher.

#### GET

#### POST


#### PUT


#### DELETE


