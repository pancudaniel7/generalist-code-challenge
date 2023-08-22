using Microsoft.AspNetCore.Mvc;
using StudiosService.Business.Parameters;
using StudiosService.Business.Services;

namespace StudiosService.WebApi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class GamesController : ControllerBase
    {
        private readonly GamesService _gamesService;

        public GamesController(GamesService gamesService)
        {
            _gamesService = gamesService;
        }

        [HttpPost]
        public async Task<IActionResult> AddGameAsync([FromBody] GameParameters gameParameters)
        {
            var addedGame = await _gamesService.AddGameAsync(gameParameters);
            return new ObjectResult(addedGame)
            {
                StatusCode = StatusCodes.Status201Created
            };
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteGameAsync(int id)
        {
            await _gamesService.DeleteGameAsync(id);
            return NoContent();
        }

        [HttpGet]
        public async Task<IActionResult> GetGamesAsync([FromQuery] int studioKey)
        {
            var games = await _gamesService.GetGamesAsync(studioKey);
            return Ok(games);
        }
    }
}
