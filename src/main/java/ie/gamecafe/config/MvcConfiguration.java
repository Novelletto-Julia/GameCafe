package ie.gamecafe.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ie.gamecafe.dao.AddressDAO;
import ie.gamecafe.dao.AddressDAOImpl;
import ie.gamecafe.dao.BookingDAO;
import ie.gamecafe.dao.BookingDAOImpl;
import ie.gamecafe.dao.CategoryDAO;
import ie.gamecafe.dao.CategoryDAOImpl;
import ie.gamecafe.dao.CustomerDAO;
import ie.gamecafe.dao.CustomerDAOImpl;
import ie.gamecafe.dao.EircodeDAO;
import ie.gamecafe.dao.EircodeDAOImpl;
import ie.gamecafe.dao.ItemDAO;
import ie.gamecafe.dao.ItemDAOImpl;
import ie.gamecafe.dao.OrderLineDAO;
import ie.gamecafe.dao.OrderLineDAOImpl;
import ie.gamecafe.dao.PlacedOrderDAO;
import ie.gamecafe.dao.PlacedOrderDAOImpl;
import ie.gamecafe.dao.SlotDAO;
import ie.gamecafe.dao.SlotDAOImpl;
import ie.gamecafe.dao.StaffDAO;
import ie.gamecafe.dao.StaffDAOImpl;
import ie.gamecafe.dao.TableDAO;
import ie.gamecafe.dao.TableDAOImpl;

@Configuration
@ComponentScan(basePackages="ie.gamecafe.*")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://35.246.84.97:3306/GameCafe?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("gcpass");
         
        return dataSource;
    }
     
    @Bean
    public StaffDAO getStaffDAO() {
        return new StaffDAOImpl(getDataSource());
    }
    
    @Bean
    public CustomerDAO getCustomerDAO() {
    	return new CustomerDAOImpl(getDataSource());
    }
    
    @Bean
    public ItemDAO getItemDAO() {
    	return new ItemDAOImpl(getDataSource());
    }
    
    @Bean
    public BookingDAO getBookingDAO() {
    	return new BookingDAOImpl(getDataSource());
    }
    
    @Bean
    public AddressDAO getAddressDAO() {
    	return new AddressDAOImpl(getDataSource());
    }
    
    @Bean
    public EircodeDAO getEircodeDAO() {
    	return new EircodeDAOImpl(getDataSource());
    }
    
    @Bean
    public TableDAO getTableDAO() {
    	return new TableDAOImpl(getDataSource());
    }
    
    @Bean
    public CategoryDAO getCategoryDAO() {
    	return new CategoryDAOImpl(getDataSource());
    }
    
    @Bean
    public PlacedOrderDAO getPlacedOrderDAO() {
    	return new PlacedOrderDAOImpl(getDataSource());
    }
    
    @Bean
    public OrderLineDAO getOrderLineDAO() {
    	return new OrderLineDAOImpl(getDataSource());
    }
    
    @Bean
    public SlotDAO getSlotDAO() {
    	return new SlotDAOImpl(getDataSource());
    }
    
    
    
}
