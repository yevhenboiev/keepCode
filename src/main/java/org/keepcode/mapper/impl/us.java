//package org.keepcode.mapper.impl;
//
//import org.keepcode.dto.UserAuthDto;
//import org.keepcode.dto.UserDTO;
//import org.keepcode.entity.User;
//import org.keepcode.mapper.UserMapper;
//
//public class UserMapperImpl implements UserMapper {
//
//    @Override
//    public User toEntity(UserDTO userDto) {
//        if (userDto == null) {
//            return null;
//        }
//
//        User user = new User();
//
//        user.setId(userDto.getId());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setRole(userDto.getRole());
//        user.setDate_creation(userDto.getDate_creation());
//
//        return user;
//    }
//
//    @Override
//    public User toEntity(UserAuthDto userDto) {
//        if (userDto == null) {
//            return null;
//        }
//
//        User user = new User();
//
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//
//        return user;
//    }
//
//    @Override
//    public UserDTO toDto(User user) {
//        if (user == null) {
//            return null;
//        }
//
//        UserDTO userDTO = new UserDTO();
//
//        userDTO.setId(user.getId());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setRole(user.getRole());
//        userDTO.setDate_creation(user.getDate_creation());
//
//        return userDTO;
//    }
//}
