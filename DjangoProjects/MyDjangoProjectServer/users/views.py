from django.shortcuts import render
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework import status
from roles.models import Role
from roles.serializers import RoleSerializer
from users.models import User, UserHasRoles

@api_view(['PUT'])
def update(request, id_user):
    try:
        user = User.objects.get(id=id_user)
    except User.DoesNotExist:
        return Response(
            {
                "message": "el usuario no existe",
                "statusCode": status.HTTP_404_NOT_FOUND
            },
            status = status.HTTP_404_NOT_FOUND
        )
    name = request.data.get('name', None)
    lastname = request.data.get('lastname', None)
    phone = request.data.get('phone', None)
    
    if name is None and lastname is None and phone is None:
        return Response(
            {
                "message": "No se enviaron datos para actualizar",
                "statusCode": status.HTTP_400_BAD_REQUEST
            },
            status = status.HTTP_400_BAD_REQUEST
        )
    
    if name is not None:
        user.name = name
        
    if lastname is not None:
        user.lastname = lastname

    if phone is not None:
        user.phone = phone
    user.save()
    
    roles = Role.objects.filter(userhasroles__id_user=user) 
    roles_serializer = RoleSerializer(roles, many=True)
    user_data={
        "user":{
            "id": user.id,
            "name": user.name,
            "lastname": user.lastname,
            "email": user.email,
            "phone": user.phone,
            "image": user.image,
            "notification_token": user.notification_token,
            "roles": roles_serializer.data,
        },
    }
    return Response(user_data, status=status.HTTP_200_OK)