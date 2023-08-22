using StudiosService.Business.Services;
using StudiosService.Data.Repositories;

namespace StudiosService.WebApi
{
    public static class ServicesConfiguration
    {
        public static void ConfigureServices(this IServiceCollection services)
        {
            services.AddTransient<GamesRepository>();
            services.AddScoped<GamesService>();
        }
    }
}
