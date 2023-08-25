using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace StudiosService.Data.Models
{
    public class StudioEntityConfiguration : IEntityTypeConfiguration<Studio>
    {
        public void Configure(EntityTypeBuilder<Studio> builder)
        {
            builder.ToTable("studio");

            builder.Property(e => e.Id)
                .IsRequired()
                .HasColumnName("id");

            builder.Property(e => e.Name)
                .IsRequired()
                .HasColumnName("name");

            builder.Property(e => e.City)
                .IsRequired()
                .HasColumnName("city");
        }
    }
}
