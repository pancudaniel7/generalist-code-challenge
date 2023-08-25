using Microsoft.EntityFrameworkCore;
using System.Reflection;

namespace StudiosService.WebApi.IntegrationTests
{
    public class TestDataContext : DbContext
    {
        public TestDataContext(DbContextOptions options)
            : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.ApplyConfigurationsFromAssembly(Assembly.GetExecutingAssembly());
        }
    }
}
