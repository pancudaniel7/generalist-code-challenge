using Microsoft.EntityFrameworkCore;
using StudiosService.Business.Services;
using StudiosService.Data;
using StudiosService.Data.Repositories;

namespace StudiosService.WorkerService
{
    public static class ServicesConfiguration
    {
        public static void ConfigureWorkerServices(this IServiceCollection services, IConfiguration configuration)
        {
            var mySqlConnectionStr = configuration.GetConnectionString("DefaultConnection");
            services.AddDbContext<DataContext>(options => options.UseMySQL(mySqlConnectionStr!));
            services.AddTransient<GamesRepository>();
            services.AddScoped<GamesService>();
        }
    }
}
