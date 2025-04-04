/*

    Copyright (c) 2001-2002. Department of Family Medicine, McMaster University. All Rights Reserved.
    This software is published under the GPL GNU General Public License.
    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.

    This software was written for the
    Department of Family Medicine
    McMaster University
    Hamilton
    Ontario, Canada

*/
angular.module("noteServices", [])
	.service("noteService", function ($http,$q,$log) {
		return {
		apiPath:'../ws/rs/notes',
		configHeaders: {headers: {"Content-Type": "application/json","Accept":"application/json"}},
		configHeadersWithCache: {headers: {"Content-Type": "application/json","Accept":"application/json"},cache: true},
        getNotesFrom: function(demographicNo,offset,numberToReturn,noteConfig){
        	var deferred = $q.defer();
       	 $http.post(this.apiPath+'/'+demographicNo+'/all?offset='+offset+'&numToReturn='+numberToReturn,noteConfig,this.configHeaders).then(function (response){
           	console.log(response.data);
           	deferred.resolve(response.data);
           },function(){
           	console.log("error fetching forms");
           	deferred.reject("An error occured while fetching items");
           });
    
         return deferred.promise;
       },
       saveNote: function(demographicNo,notea){
       	var deferred = $q.defer();
       	console.log("sending to server ",notea);
       	$http.post(this.apiPath+'/'+demographicNo+'/save',JSON.stringify(notea)).then(function (response){
           	console.log("returned from /save",response.data);
           	deferred.resolve(response.data);
           },function(){
           	console.log("error saving notes");
           	deferred.reject("An error occured while trying to save note");
           });
    
         return deferred.promise;
       },
       saveIssueNote: function(demographicNo,notea){
       	var deferred = $q.defer();
       	console.log("sending to server -------------------note" + notea);
       	$http.post(this.apiPath+'/'+demographicNo+'/saveIssueNote',notea).then(function (response){
           	console.log("returned from /save",response.data);
           	deferred.resolve(response.data);
           },function(){
           	console.log("error saving Issuenotes");
           	deferred.reject("An error occured while trying to save Issuenote");
           });
    
         return deferred.promise;
       },
       getCurrentNote: function(demographicNo,config){
    	   var deferred = $q.defer();
          	 $http.post(this.apiPath+'/'+demographicNo+'/getCurrentNote',config).then(function (response){
              	console.log("returned from /getCurrentNote",response.data);
              	deferred.resolve(response.data);
              },function(){
              	console.log("error getting current note");
              	deferred.reject("An error occured while fetching items");
              });
            return deferred.promise;
       },
       tmpSave: function(demographicNo,notea){
          	var deferred = $q.defer();
           	 $http.post(this.apiPath+'/'+demographicNo+'/tmpSave',notea).then(function (response){
               	console.log("returned from /tmpSave",response.data);
               	deferred.resolve(response.data);
               },function(){
               	console.log("error tmp saving");
               	deferred.reject("An error occured while fetching items");
               });
        
             return deferred.promise;
       },
       getNoteExt: function(noteId){
    	   var deferred = $q.defer();
          	 $http.post(this.apiPath+'/getGroupNoteExt/'+noteId).then(function (response){
              	console.log("returned from /getGroupNoteExt",response.data);
              	deferred.resolve(response.data);
              },function(){
              	console.log("error getting note ext");
              	deferred.reject("An error occured while fetching note ext");
              });
            return deferred.promise;
       },

       getIssueNote: function(noteId){
    	   var deferred = $q.defer();
          	 $http.post(this.apiPath+'/getIssueNote/'+noteId).then(function (response){
              	console.log("returned from /getIssueNote",response.data);
              	deferred.resolve(response.data);
              },function(){
              	console.log("error getting getIssueNote");
              	deferred.reject("An error occured while fetching getIssueNote");
              });
            return deferred.promise;
       },
       getIssueId: function(issueCode){
    	   var deferred = $q.defer();
          	 $http.post(this.apiPath+'/getIssueId/'+issueCode).then(function (response){
              	console.log("returned from /getIssueId",response.data);
              	deferred.resolve(response.data);
              },function(){
              	console.log("error getting issue id");
              	deferred.reject("An error occured while fetching issue id");
              });
            return deferred.promise;
       },
       getTicklerNote: function (ticklerId) {
           var deferred = $q.defer();
           $http.get(this.apiPath + '/ticklerGetNote/'+ticklerId,{headers: {"Content-Type": "application/json","Accept":"application/json"}}).then(function (response){
           	deferred.resolve(response.data);
           },function(){
           	deferred.reject("An error occured while fetching tickler note");
           });
    
         return deferred.promise;
       },
       saveTicklerNote: function (ticklerNote) {
       	var deferred = $q.defer();
       	$http({
               url: this.apiPath+'/ticklerSaveNote',
               method: "POST",
               data: JSON.stringify(ticklerNote),
               headers: {'Content-Type': 'application/json'}
             }).then(function (response){
           	  deferred.resolve(response.data);
               },function (data, status, headers, config) {
               	deferred.reject("An error occured while setting saving tickler note");
               });
          return deferred.promise;
       },
       searchIssues: function(search,startIndex,itemsToReturn){
       	var deferred = $q.defer();
       	$http.post(this.apiPath+'/searchIssues?startIndex='+startIndex + "&itemsToReturn="+itemsToReturn,search).then(function (response){
       		deferred.resolve(response.data);
           },function(){
         	  console.log("error fetching items");
             deferred.reject("An error occured while fetching items");
           });
      
           return deferred.promise;
       },
       getIssue: function(issueId){
    	   var deferred = $q.defer();
          	 $http.post(this.apiPath+'/getIssueById/'+issueId).then(function (response){
              	console.log("returned from /getIssueById",response.data);
              	deferred.resolve(response.data);
              },function(){
              	console.log("error getting issue");
              	deferred.reject("An error occured while fetching issue");
              });
            return deferred.promise;
       },
       setEditingNoteFlag: function(noteUUID, userId){
    	   var deferred = $q.defer();
    	   $http.post(this.apiPath+'/setEditingNoteFlag?noteUUID='+noteUUID+"&userId="+userId).then(function (response){
    		   console.log("returned from /setEditingNoteFlag",response.data);
    		   deferred.resolve(response.data);
		   },function(){
			   console.log("error setting EditingNoteFlag");
			   deferred.reject("An error occured while setting EditingNoteFlag");
		   });
    	   return deferred.promise;
       },
       checkEditNoteNew: function(noteUUID, userId){
    	   var deferred = $q.defer();
    	   $http.post(this.apiPath+'/checkEditNoteNew?noteUUID='+noteUUID+"&userId="+userId).then(function (response){
    		   console.log("returned from /checkEditNoteNew",response.data);
    		   deferred.resolve(response.data);
		   },function(){
			   console.log("error checking EditNoteNew");
			   deferred.reject("An error occured while checking EditNoteNew");
		   });
    	   return deferred.promise;
       },
       removeEditingNoteFlag: function(noteUUID, userId){
    	   $http.post(this.apiPath+'/removeEditingNoteFlag?noteUUID='+noteUUID+"&userId="+userId);
       }
    };
});
