## 20180427更新

本次更新主要解决两个问题：

* 1、解决使用BaseRxLifePresenter的导致Contract中Presenter契约接口必须是抽象类问题——将BaseRxLifePresenter与Contract接口抽离开来，BaseRxLifePresenter单独实现Presenter生命周期操作，Contract的Presenter契约接口定义自身独有约束，从而达到面向接口编程的初衷；

* 2、同时解决View层直接持有Presenter层对象，导致除Contract接口约束的函数外，依旧可调用Presenter自身公共函数问题——仅让View层持有Contract中Prestener的接口引用。