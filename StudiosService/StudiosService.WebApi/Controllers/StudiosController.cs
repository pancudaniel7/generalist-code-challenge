using Microsoft.AspNetCore.Mvc;

namespace StudiosService.WebApi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class StudiosController : ControllerBase
    {
        private readonly Business.Services.StudiosService _studiosService;

        public StudiosController(Business.Services.StudiosService studiosService)
        {
            _studiosService = studiosService;
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteStudioAsync(int id)
        {
            await _studiosService.DeleteStudioAsync(id);
            return NoContent();
        }
    }
}
