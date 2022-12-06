using Microsoft.AspNetCore.Mvc;
using Shared.DTOs.User;

namespace Logic.LogicInterfaces;

public interface IAuthService
{
    Task<ActionResult> ValidateUser(UserLoginDto user);
}