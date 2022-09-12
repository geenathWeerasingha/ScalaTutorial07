
object main extends App{

  var bank:List[Account]=List(new Account("992111780V",45687952,450000),new Account("948756926V",41596952,785000),new Account("967854780V",51785952,750000),new Account("967854780V",51785952,-75),new Account("885954780V",55685952,-7000),new Account("89655780V",45875952,89000))

  class Account(id:String, n:Int, b:Double){

    var nic:String=id
    var acnumber:Int=n
    var balance:Double=b

    override def toString="["+nic+ ":" +acnumber+ ":" +balance+"]"

    def withdraw(a:Double)= this.balance = this.balance-a

    def deposit(a:Double)= this.balance = this.balance+a

    def transfer(a:Account,b:Double)= {
        this.withdraw(b);
        a.deposit(b)
    }

  }

  val negBalance=(b:List[Account])=> b.filter(x=>x.balance<0)

  val totBalance=(b:List[Account])=> b.reduce((x,y)=>new Account("Bank",1111,x.balance+y.balance))

  val interest=(b:List[Account])=>b.map(x=> if(x.balance>0){ x.balance=x.balance+x.balance*0.05 }
                                               else { x.balance=x.balance+x.balance*0.1 } )


  println("List of Accounts with negative balances " + negBalance(bank))
  println("sum of all account balances "+totBalance(bank))

  println("\nbalance of all account Before apply interest function "+bank)
  interest(bank)
  println("Final balance of all account after apply interest function "+bank)

}
