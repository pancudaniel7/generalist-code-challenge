using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace StudiosService.WebApi.IntegrationTests.Models
{
    public class GameEntityConfiguration : IEntityTypeConfiguration<Game>
    {
        public void Configure(EntityTypeBuilder<Game> builder)
        {
            builder.ToTable("game");

            builder.Property(e => e.Id)
                .IsRequired()
                .HasColumnName("id");

            builder.Property(e => e.Name)
                .IsRequired()
                .HasColumnName("name");

            builder.Property(e => e.Rating)
                .IsRequired()
                .HasColumnName("rating");

            builder.Property(e => e.StudioKey)
                .IsRequired()
                .HasColumnName("studio_key");

            builder.Property(e => e.Content)
                .IsRequired()
                .HasColumnName("content");
        }
    }
}
