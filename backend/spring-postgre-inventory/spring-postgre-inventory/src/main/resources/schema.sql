CREATE TABLE supplier
(
  supplierId SERIAL NOT NULL,
  supplierName varchar(100) NOT NULL,
  supplierAddress varchar(100) DEFAULT NULL,
 PRIMARY KEY (supplierId)
);

CREATE TABLE customer
(
  customerId SERIAL NOT NULL,
  customerName varchar(100) NOT NULL,
  customerAddress varchar(100) DEFAULT NULL,
 PRIMARY KEY (customerId)
);

CREATE TABLE orders
(
  orderId SERIAL,
  customerId integer NOT NULL,
PRIMARY KEY(orderId),
FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

CREATE TABLE orderitem
(
  orderitemId SERIAL,
  quantity integer,
  productId integer NOT NULL,
  orderId integer NOT NULL,
  PRIMARY KEY(orderitemId),
  FOREIGN KEY (productId) REFERENCES product(productId),
  FOREIGN KEY (orderId) REFERENCES orders(orderId)

);

CREATE TABLE product
(
  productId SERIAL NOT NULL,
  productName varchar(100) NOT NULL,
  inventoryReceived integer NOT NULL,
  inventoryShipped integer NOT NULL,
  inventoryOnHand integer NOT NULL,
  minInventoryReq integer NOT NULL,
  productDesc varchar(100) DEFAULT NULL,
  supplierID integer NOT NULL,
 PRIMARY KEY (productId),
 FOREIGN KEY (supplierID) REFERENCES supplier(supplierId)
);

CREATE TABLE supplying
(
  supplyingId SERIAL NOT NULL,
  productId integer NOT NULL,
  supplierId integer NOT NULL,
  quantity integer NOT NULL,
  orderedat date,
  arrivesat date,
  arrivedat date DEFAULT NULL,
  PRIMARY KEY (supplyingId),
  FOREIGN KEY (productId) REFERENCES product(productId),
  FOREIGN KEY (supplierId) REFERENCES supplier(supplierId)

)