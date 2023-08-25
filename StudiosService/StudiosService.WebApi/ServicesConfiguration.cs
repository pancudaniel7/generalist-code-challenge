using Microsoft.EntityFrameworkCore;
using StudiosService.Business.Services;
using StudiosService.Data;
using StudiosService.Data.Repositories;

namespace StudiosService.WebApi
{
    public static class ServicesConfiguration
    {
        public static void ConfigureServices(this IServiceCollection services, IConfiguration configuration)
        {
            services.ConfigureInfrastructure(configuration);
            services.ConfigureBusinessServices();
        }

        private static void ConfigureInfrastructure(this IServiceCollection services, IConfiguration configuration)
        {
            var mySqlConnectionStr = configuration.GetConnectionString("DefaultConnection");
            services.AddDbContext<DataContext>(options => options.UseMySQL(mySqlConnectionStr!));
            services.AddTransient<GamesRepository>();
            services.AddTransient<StudiosRepository>();
        }

        private static void ConfigureBusinessServices(this IServiceCollection services)
        {

            services.AddScoped<GamesService>();
            services.AddScoped<Business.Services.StudiosService>();
        }
    }
}
