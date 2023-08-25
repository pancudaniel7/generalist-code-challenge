using Microsoft.EntityFrameworkCore;
using StudiosService.Data.Models;

namespace StudiosService.Data.Repositories
{
    public class StudiosRepository
    {
        private readonly DataContext _dataContext;

        public StudiosRepository(DataContext dataContext)
        {
            _dataContext = dataContext;
        }

        public async Task DeleteStudioAsync(int id)
        {
            var studioToDelete = await _dataContext.Set<Studio>().SingleOrDefaultAsync(studio => studio.Id == id);
            if (studioToDelete != null)
            {
                _dataContext.Remove(studioToDelete);
                await _dataContext.SaveChangesAsync();
            }
        }
    }
}
