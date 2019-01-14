# homework4
Tạo project Java sử dụng Maven với yêu cầu sau:
-	Cấu trúc DB của dự án bao gồm: 
o	Bảng Product
	ID – int, khóa chính tự tăng,
	 Name – varchar, not null
	 Description, varchar, not null
	Price double, not null
o	Bảng Order
	ID – int, khóa chính tự tăng
	DateCreate date time, not null
	Customer Name varchar, default ‘anyone’
	Status enum ( open, cancel, complete)
o	Bảng OrderDetail
	IDProduct – int khóa ngoại liên kết đến Product
	IDOrder – int khóa ngoại liên kết đến Order
	Quantity int ( check > 0) not null
	Price double ( check >0) not null
-	Dùng liquibase để setup cấu trúc DB trên. Đảm bảo khi chạy chương trình ( console) thì liquibase sẽ tạo thành DB có cấu trúc trên trong DB server. Chú ý: vừa làm vừa đọc doc của liquibase sẽ làm đc :D. Còn tư tưởng và các bước cơ bản của liquibase hôm trước thầy đã hướng dẫn.
-	Tạo thêm changeset trong liquibase để tạo khóa chính cho bảng OrderDeteail bao gồm 2 cột (IDProduct, IDOrder) kết hợp với nhau thành khóa chính. 
-	Sau khi chạy thành công liquibase xây dựng 2 tầng Model(entity, dao) và Controller – Service ( DTO, Controller) cho project trên. Chú ý: quan hệ giữa Product và Order là quan hệ  nhiều nhiều thông qua bảng OrderDetail. -> Phải xây dựng cấu trúc entity cho phù hợp
-	Có thể xem video JPA để xây dựng với JPA
-	Đẩy code (java và liquibase) lên git và gửi link cho thầy và cả lớp.
