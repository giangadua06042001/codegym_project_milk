import dao.product.ProductDao;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletProduct", value = "/product")
public class ServletProduct extends HttpServlet {
    private ProductDao productDao;
    public void init(){
        this.productDao=new ProductDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String choice=request.getParameter("choice");
      if(choice==null){
          choice="";
      }
      try {
          switch (choice){
              case "createFrom":
                  showFromCreatProduct(request,response);
             break;
              case "edit":
                  showFormEdit(request,response);
                  break;
              case "delete":
                  deleteProduct(request,response);
                  break;
              case "sort":
                  sortPriceProduct(request,response);
                  break;
              default:
                  listProduct(request,response);
          }
      }catch (SQLException ex){
          throw new ServletException(ex);
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice=request.getParameter("choice");
        if(choice==null){
            choice="";
        }
        try {
            switch (choice){
                case "createProduct":
                    listProduct(request,response);
                  createProduct(request,response);
                    break;
                case "edit":
                    editProduct(request,response);
                    break;
                case "find":
                    findProduct(request,response);
                    break;
                default:

            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    private void listProduct(HttpServletRequest request,HttpServletResponse response)
        throws SQLException,ServletException,IOException{
        List<Product>listProduct=productDao.SelectAllProduct();
        request.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list.jsp");
        dispatcher.forward(request,response);
    }
    private void showFromCreatProduct(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
     RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/create.jsp");
     dispatcher.forward(request,response);
    }
    private void createProduct(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,SQLException,IOException{
        String name=request.getParameter("p_name");
        String price=request.getParameter("p_price");
        String weight=request.getParameter("p_weight");
        String unit=request.getParameter("unit");
        String right_alway= request.getParameter("right_alway");
        productDao.insert(new Product(name,price,weight,unit,right_alway));
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list.jsp");
        dispatcher.forward(request,response);
    }
    private void showFormEdit(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/view/edit.jsp");
        requestDispatcher.forward(request,response);
    }
    private void editProduct(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException,SQLException{
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String price=request.getParameter("price");
        String weight=request.getParameter("weight");
        String unit=request.getParameter("unit");
        String alway= request.getParameter("right_alway");
       productDao.update(new Product(id,name,price,weight,unit,alway)) ;
       RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list.jsp");
       dispatcher.forward(request,response);
    }
    private void findProduct(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        String name=request.getParameter("name");
        productDao.findByName(name);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list.jsp");
        dispatcher.forward(request,response);
    }
    private void deleteProduct(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id=request.getParameter("id");
        productDao.delete(id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/list.jsp");
        dispatcher.forward(request,response);
    }
    private void sortPriceProduct(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
    List<Product>list= productDao.sortProduct();
        request.setAttribute("listProduct",list);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/view/listSort.jsp");
        dispatcher.forward(request,response);
    }

}
