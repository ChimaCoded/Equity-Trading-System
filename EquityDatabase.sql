CREATE SCHEMA EQUITY;





CREATE TABLE EQUITY.clients
(
                   clientId          numeric(40) CONSTRAINT UPKCL_clientsidind PRIMARY KEY ,
                   firstName       varchar(40)               NOT NULL,
                  lastName       varchar(20)                 NOT NULL,
                   password          varchar(12)                 NOT NULL DEFAULT ('UNKNOWN'),
                   emailAddress        varchar(40)           NUll,
                   bankBalance         numeric(40)            nullnumeric(40)
        );
        
       
       
       
       
        CREATE TABLE EQUITY.portfolios
        (
                   portfolioId                  char(4)           NOT NULL CONSTRAINT  UPK_portfolio_id PRIMARY KEY ,
                   portfolioName      varchar(40)       NOT NULL,                                                                                                                
                   stock1Id       varchar(11) NULL,
		   stock2Id      varchar(11) NULL,
		   stock3Id       varchar(11) NULL 
                   
        );
       

       
      
        CREATE TABLE EQUITY.stocks
        (
           stockId         varchar(11) 	NOT NULL CONSTRAINT UPK_stockid PRIMARY KEY,
		   quantity         varchar(80)       NOT NULL,
           ticker       	varchar(200)          NULL, 
  			portfolioId    varchar(11)  not NULL references portfolios(portfolio_id)
        );
       
       
       
        CREATE TABLE EQUITY.order_type
        (
                   orderId        char(4)           NOT NULL CONSTRAINT UPK_order_typeid PRIMARY KEY ,
                   orderName     varchar(40)           NULL
                  
        );

        CREATE TABLE EQUITY.status
        (
                   statusId        char(4)           NOT NULL  CONSTRAINT UPK_status_id PRIMARY KEY ,
                   statusName       varchar(20)       NOT NULL
                   
        );
 
       

        CREATE TABLE EQUITY.orders
        (
                  orderId       char(4) CONSTRAINT UPK_orders_id PRIMARY KEY ,
                  clientId 	numeric(40) not null REFERENCES clients(client_id),
                 	portfolioId    varchar(11)  not NULL references portfolios(portfolio_id),
                orderTypeId     varchar(11)  not NULL references orders(order_id),
                  quantity         varchar(80)       NOT NULL,
                 statusId             char(4)       NOT null references status(status_id),
                   tickerName          varchar(200)          NULL,
                   timeStamp           date                  NOT NULL DEFAULT current_timestamp,
                   priceValue             numeric(40)         not null
        );
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       