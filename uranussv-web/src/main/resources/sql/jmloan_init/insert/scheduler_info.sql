/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.7.17 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('11','还款日前2天发送消息','0 0 15 * * ?','http://loan.juhexinyong.cn/api/task/userOrderSendMsg/?beforeDays=2','每天9点开启任务','0','0');
insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('12','还款日前1天发送消息','0 0 18 * * ?','http://loan.juhexinyong.cn/api/task/userOrderSendMsg/?beforeDays=1','每天18点开启任务','0','0');
insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('13','还款日当天发送消息','0 0 9 * * ?','http://loan.juhexinyong.cn/api/task/userOrderSendMsg/','每天9点开启任务','0','0');
insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('14','还款日当天发起代扣','0 0 8 * * ?','http://loan.juhexinyong.cn/api/task/userOrderRepay/','每天8点开启任务','0','0');
insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('16','还款日当天发起代扣','0 0 20 * * ?','http://loan.juhexinyong.cn/api/task/userOrderRepay/','每天20点开启任务','0','0');
insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('17','处理逾期订单','0 0 0 * * ?','http://loan.juhexinyong.cn/api/task/setOrderOvd/','每天0点开启任务','0','0');
insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('18','逾期订单每天发起代扣','0 0 8 * * ?','http://loan.juhexinyong.cn/api/task/userOveOrderRepay/','每天8点开启任务','0','0');
insert into `scheduler_info` (`id`, `taskName`, `taskCronExp`, `apiUrl`, `remark`, `addTime`, `updateTime`) values('19','逾期订单每天发起代扣','0 0 20 * * ?','http://loan.juhexinyong.cn/api/task/userOveOrderRepay/','每天20点开启任务','0','0');
