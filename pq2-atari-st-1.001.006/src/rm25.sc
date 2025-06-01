;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm25 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	[local21 2]
	local23
	local24
	local25
	local26
	local27
	[local28 2]
	[local30 2]
	[local32 4]
	[local36 5]
	local41
	local42
	local43
	local44
	local45
)

(procedure (localproc_0)
	(switch global131
		(13
			(cond
				(
					(not
						(gEgo
							inRect:
								[local32 0]
								[local32 1]
								[local32 2]
								[local32 3]
						)
					)
					(Print 25 70) ; "You're not close enough to your car's door."
				)
				((== global133 1)
					(Print 25 71) ; "Your car door is locked."
					(return 0)
				)
				(global135
					(Print 25 72) ; "Close the trunk first."
					(return 0)
				)
				((gEgo has: 10) ; field_kit
					(Print 25 73) ; "You should put your field kit in the trunk first."
					(return 0)
				)
				(else
					(carScript changeState: 4)
					(return 1)
				)
			)
		)
		(33
			(cond
				(
					(not
						(gEgo
							inRect:
								[local32 0]
								[local32 1]
								[local32 2]
								[local32 3]
						)
					)
					(Print 25 70) ; "You're not close enough to your car's door."
				)
				((== global136 1)
					(Print 25 74) ; "Your car door is locked"
				)
				(else
					(carScript changeState: 4)
				)
			)
		)
	)
)

(instance swatSound of Sound
	(properties
		number 13
	)
)

(instance keithAct of Act
	(properties)
)

(instance gasBomb of Act
	(properties)
)

(instance rm25 of Rm
	(properties
		picture 25
		style 0
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(if (& $0040 (gEgo onControl:))
				(gCurRoom setScript: enterMotel)
			)
			(if
				(or
					(gEgo inRect: 152 77 176 109)
					(gEgo inRect: 159 109 184 142)
				)
				(gEgo setPri: 10 illegalBits: $2000)
				(if (== global131 13)
					(global112 stopUpd:)
				)
			else
				(if (< (gEgo y:) 83)
					(gEgo setPri: 7)
					(if (== global131 13)
						(global112 stopUpd:)
					)
				else
					(if (== global131 13)
						(global112 startUpd:)
					)
					(if (> (gEgo y:) 183)
						(gEgo setPri: 15)
					else
						(gEgo setPri: -1)
					)
				)
				(gEgo xStep: 3 yStep: 2 illegalBits: $8000)
			)
			(if (== global100 12)
				(gEgo ignoreControl: 2)
			else
				(gEgo observeControl: 2)
			)
			(cond
				(local43
					(self setScript: warrantLeaves)
					(= local43 0)
				)
				((== (gEgo onControl: 1) 4096)
					(self setScript: talkWindow)
				)
				((== global132 local10 1)
					(if (not (gCast contains: local4))
						(= global132 0)
						(self setScript: exitCar)
					)
				)
				((== global132 (not local10) 1)
					(= global132 0)
					(localproc_0)
				)
				((== global171 1)
					(= global171 0)
					(self setScript: swatArrives)
				)
				((== global170 1)
					(= global170 0)
					(self setScript: warrantArrives)
				)
			)
		)
		(= local41 (& (gEgo onControl: 1) $0f00))
		(if
			(and
				(<= (gEgo y:) 130)
				(or (< (gEgo x:) 0) (> (gEgo x:) 320))
			)
			(gEgo y: 132)
		)
		(if (== global131 13)
			(if (> (global112 y:) 183)
				(global112 setPri: 15)
			else
				(global112 setPri: -1)
			)
		)
		(if (> local3 1)
			(-- local3)
		)
		(if (== local3 1)
			(-- local3)
			(local20 dispose:)
			(Print 25 0 #draw) ; "The gas has cleared. It appears that you can enter the motel room."
		)
		(if (and (== local10 0) (not (gEgo onControl: 1)))
			(Print 25 1) ; "You will need your car in order to leave the area."
			(cond
				((<= (gEgo x:) 0)
					(gEgo setMotion: MoveTo 10 (gEgo y:))
				)
				((>= (gEgo y:) 180)
					(gEgo setMotion: MoveTo (gEgo x:) 177)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'read/number,door')
				(cond
					((not local41)
						(Print 25 2) ; "You are not close enough to a door."
					)
					((gEgo inRect: 80 70 140 77)
						(Print 25 3) ; "This is room 206."
					)
					((gEgo inRect: 168 70 210 76)
						(Print 25 4) ; "This is room 207."
					)
					((gEgo inRect: 233 70 286 81)
						(Print 25 5) ; "This is room 208."
					)
					(else
						(Print 25 6) ; "This is Room 108."
					)
				)
			)
			((Said 'enter/pane')
				(Print 25 7) ; "The best way to enter any of these rooms is through their doors."
			)
			((Said 'look,smell/cigarette,gas')
				(if local3
					(Print 25 8) ; "The acrid tear gas streaming from the broken window stings your eyes."
				else
					(event claimed: 0)
				)
			)
			((Said 'look>')
				(cond
					((Said '[<around,at][/building,chamber]')
						(Print 25 9) ; "You are in the parking lot at the Snuggler's Inn"
					)
					((Said '/pane')
						(cond
							((!= (gEgo onControl: 1) 16384)
								(Print 25 10) ; "You aren't close to a window."
							)
							((and local17 (gEgo inRect: 197 130 243 143))
								(Print 25 11) ; "You are looking at a broken window."
							)
							(else
								(Print 25 12) ; "Someone's going to call the cops if you keep looking through the windows like that!"
							)
						)
					)
					((Said '/door')
						(cond
							((not local41)
								(Print 25 13) ; "You aren't close enough to a door."
							)
							((!= (gEgo onControl: 1) 256)
								(Print 25 14) ; "There's nothing special about this door."
							)
							((== global100 12)
								(Print 25 15) ; "The door to room 108 is in sad shape."
							)
							(else
								(Print 25 6) ; "This is Room 108."
							)
						)
					)
					((Said '/briefcase')
						(if (gEgo has: 10) ; field_kit
							(Print 25 16) ; "You don't need to look now!"
						else
							(Print 25 17) ; "You don't have it."
						)
					)
					((Said '/trunk')
						(if (== global131 13)
							(if
								(and
									(gEgo
										inRect:
											[local36 0]
											[local36 1]
											[local36 2]
											[local36 3]
									)
									(gCast contains: local6)
								)
								(gInventory
									carrying: {The car's trunk contains:}
									empty: {The car's trunk is empty.}
									showSelf: 13
								)
							else
								(Print 25 18) ; "You're not close enough to an open trunk."
							)
						else
							(Print 25 19) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
				)
			)
			((Said 'open/briefcase')
				(if (gEgo has: 10) ; field_kit
					(Print 25 20) ; "You don't need to open it now!"
				else
					(Print 25 17) ; "You don't have it."
				)
			)
			((or (Said 'enter/in') (Said 'enter<in'))
				(cond
					((not local41)
						(Print 25 2) ; "You are not close enough to a door."
					)
					((!= (gEgo onControl: 1) 256)
						(Print 25 21) ; "You have no reason to go into this room."
					)
					((< global100 12)
						(Print 25 22) ; "This door is locked."
					)
					((gCurRoom script:)
						(Print 25 23) ; "Not now."
					)
					(else
						(gCurRoom setScript: enterMotel)
					)
				)
			)
			((or (Said 'press,unlock,open/door') (Said 'use/key'))
				(cond
					(
						(gEgo
							inRect:
								[local32 0]
								[local32 1]
								[local32 2]
								[local32 3]
						)
						(cond
							((== global131 13)
								(if global133
									(= global133 0)
									(Print 25 24) ; "OK. It's unlocked."
									(localproc_0)
								else
									(Print 25 25) ; "The door is already unlocked."
								)
							)
							(global136
								(= global136 0)
								(Print 25 24) ; "OK. It's unlocked."
								(localproc_0)
							)
							(else
								(Print 25 25) ; "The door is already unlocked."
							)
						)
					)
					((not local41)
						(proc0_7) ; "You're not close enough."
					)
					((!= (gEgo onControl:) 256)
						(Print 25 26) ; "You don't have a key to this door."
					)
					((== global100 12)
						(Print 25 27) ; "The door is already open."
					)
					((not (gEgo has: 27)) ; motel_key
						(Print 25 28) ; "You don't have the key."
					)
					((== local41 256)
						(self setScript: enterRoom)
						(SetScore 3)
					)
				)
			)
			((Said 'extender,ask,get,call/warrant[<frisk]')
				(cond
					((IsFlag 13)
						(Print 25 29) ; "You already have it."
					)
					((> global170 1)
						(Print 25 30) ; "Your requested warrant has not arrived yet."
					)
					((IsFlag 29)
						(if (> (gEgo distanceTo: local27) 30)
							(proc0_7) ; "You're not close enough."
						else
							(= local43 1)
						)
					)
					(else
						(Print 25 31) ; "You should call dispatch."
					)
				)
			)
			((Said 'extender,call/dispatch')
				(Print 25 32) ; "Use your car's radio."
			)
			((Said 'look,look/warrant[<frisk]')
				(cond
					((IsFlag 13)
						(Print 25 33) ; "The search warrant authorizes you to legally search room 108 at the Snugglers Inn."
					)
					((> global170 1)
						(Print 25 30) ; "Your requested warrant has not arrived yet."
					)
					(else
						(Print 25 34) ; "You should call dispatch and request a warrant."
					)
				)
			)
			((Said 'extender,ask,call,get/backup,swat,team')
				(cond
					((IsFlag 14)
						(Print 25 29) ; "You already have it."
					)
					((> global171 1)
						(Print 25 35) ; "Your requested backup has not arrived yet."
					)
					(else
						(Print 25 31) ; "You should call dispatch."
					)
				)
			)
			((or (Said 'enter/chamber,inn') (Said 'enter<in'))
				(cond
					((not local41)
						(proc0_7) ; "You're not close enough."
					)
					((!= (gEgo onControl:) 256) 22)
					((!= global100 12)
						(Print 25 22) ; "This door is locked."
					)
					(else
						(Print 25 36) ; "Just walk in."
					)
				)
			)
			((Said 'enter/auto')
				(localproc_0)
			)
			((Said 'exit/auto')
				(= global132 1)
			)
			((Said 'lock/door')
				(if
					(or
						(gEgo
							inRect:
								[local32 0]
								[local32 1]
								[local32 2]
								[local32 3]
						)
						(gEgo inRect: 180 187 200 197)
					)
					(if (== global131 13)
						(if (== global133 0)
							(= global133 1)
							(Print 25 37) ; "OK. It's locked."
						else
							(Print 25 38) ; "The door is already locked."
						)
					)
					(if (== global131 33)
						(if (== global136 0)
							(= global136 1)
							(Print 25 37) ; "OK. It's locked."
						else
							(Print 25 38) ; "The door is already locked."
						)
					)
				else
					(Print 25 39) ; "You're not close enough."
				)
			)
			((Said 'knock[/door]')
				(if local41
					(Print 25 40) ; "You knock, but no one responds."
				else
					(Print 25 39) ; "You're not close enough."
				)
			)
			((Said '[open]/police')
				(if local41
					(Print 25 41) ; "In a commanding voice you yell, "Open up, in the name of the police!""
					(Print 25 42) ; "You listen carefully but are unable to hear anything."
				else
					(Print 25 43) ; "You aren't close enough to the door."
				)
			)
			((Said 'open,unlock/trunk')
				(if (== global131 13)
					(if
						(gEgo
							inRect:
								[local36 0]
								[local36 1]
								[local36 2]
								[local36 3]
						)
						(cond
							(global135
								(Print 25 44) ; "It's already open."
							)
							((gEgo has: 3) ; unmarked_car_keys
								(= global135 1)
								(carScript changeState: 9)
							)
							(else
								(Print 25 45) ; "You need a key to open this trunk."
							)
						)
					else
						(proc0_7) ; "You're not close enough."
					)
				else
					(Print 25 19) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
				)
			)
			((Said 'close,lock/trunk')
				(if (== global131 13)
					(if
						(gEgo
							inRect:
								[local36 0]
								[local36 1]
								[local36 2]
								[local36 3]
						)
						(if global135
							(= global135 0)
							(carScript changeState: 11)
						else
							(Print 25 46) ; "It's already closed."
						)
					else
						(proc0_7) ; "You're not close enough."
					)
				else
					(Print 25 19) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
				)
			)
			((Said 'talk,ask/friend')
				(if (== global131 13)
					(global112 setMotion: Follow gEgo 500)
					(Print 25 47) ; ""I'm right behind you, partner!" Keith says..."
				else
					(Print 25 48) ; "You came here alone. Keith is not with you."
				)
			)
			((Said 'talk>')
				(event claimed: 1)
				(cond
					((and (IsFlag 14) (<= (gEgo distanceTo: local24) 30))
						(cond
							((IsFlag 0)
								(Print 25 49) ; "You tell Chuck that the room is secure."
								(Print 25 50) ; "Chuck responds, "Ok, Sonny. We'll wrap things up here.""
							)
							((== global100 12)
								(Print 25 51) ; "Chuck says, "You go ahead and do your thing. We'll stay here.""
							)
							(else
								(Print 25 52) ; "You explain the situation to Chuck and request that he and his partner get into position next to their car."
								(local24
									view: 268
									setLoop: 1
									setCel: 0
									setCycle: End
								)
								(Print 25 53) ; "You got it, Sonny!" says Chuck. "That's what we're here for."
								(Print 25 54) ; ""Did you find out which room this dirtbag is in?" Chuck asks."
								(Print 25 55) ; "Yes," you reply, "Room 108."
							)
						)
					)
					((and (IsFlag 29) (<= (gEgo distanceTo: local27) 30))
						(Print 25 56) ; "I've got that warrant you requested, Sonny."
					)
					((and global112 (Said '/friend'))
						(event claimed: 0)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((or (Said 'break/door') (Said 'hit/door'))
				(cond
					((not local41)
						(Print 25 43) ; "You aren't close enough to the door."
					)
					(
						(or
							(not (& (gEgo onControl: 1) $0100))
							(!= global100 11)
						)
						(Print 25 57) ; "Being a macho type, you kick in the door, making a fool out of yourself."
						(Print 25 58) ; "You quickly close the door."
					)
					((== global100 12)
						(Print 25 59) ; "What do you think you are doing? The door is already open!"
					)
					(else
						(= local25 1)
						(self setScript: kickInDoor)
					)
				)
			)
			((Said 'drop,place/briefcase')
				(if
					(gEgo
						inRect: [local36 0] [local36 1] [local36 2] [local36 3]
					)
					(if global135
						(if (gEgo has: 10) ; field_kit
							(Print 25 60) ; "You place your field kit inside the trunk."
							(PutItem 10 13) ; field_kit
							(if (IsObject gFKit)
								(gFKit dispose:)
							)
							(= global240 0)
						else
							(Print 25 61) ; "You don't have the field kit."
						)
					else
						(Print 25 62) ; "Open the trunk first."
					)
				else
					(Print 25 63) ; "You're not close enough to your car's trunk."
				)
			)
			((Said 'remove,get/briefcase')
				(if
					(gEgo
						inRect: [local36 0] [local36 1] [local36 2] [local36 3]
					)
					(if global135
						(if (IsItemAt 10 13) ; field_kit
							(Print 25 64) ; "You take your field kit from the trunk."
							(gEgo get: 10) ; field_kit
						else
							(Print 25 65) ; "The field kit is not in the trunk."
						)
					else
						(Print 25 62) ; "Open the trunk first."
					)
				else
					(Print 25 63) ; "You're not close enough to your car's trunk."
				)
			)
			((Said 'get/browning')
				(if
					(gEgo
						inRect: [local36 0] [local36 1] [local36 2] [local36 3]
					)
					(if 1
						(Print 25 66) ; "You don't need to take it out of the trunk."
					else
						(Print 25 67) ; "There is no shotgun."
					)
				else
					(Print 25 68) ; "You aren't close enough."
				)
			)
		)
	)

	(method (dispose)
		(carScript dispose:)
		(super dispose:)
	)

	(method (init)
		(if (== gPrevRoomNum 0)
			(= gPrevRoomNum 13)
			(= global131 13)
			(= global100 11)
			(gEgo get: 0 1 2 3) ; hand_gun
		)
		(if (== global100 11)
			(= global158 0)
			(= global159 0)
		)
		(super init:)
		(= global112 0)
		(= global211 1)
		(= global212 3)
		(= local1 (< global100 11))
		(= [local30 0] 142)
		(= [local30 1] 193)
		(cond
			((= local10 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13)))
				(= global135 0)
			)
			(global135
				((= local6 (Prop new:))
					view: 51
					loop: 5
					cel: 2
					posn: [local30 0] [local30 1]
					setPri: 14
					init:
				)
			)
		)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(Load rsVIEW 251)
		(Load rsVIEW 30)
		(Load rsVIEW 999)
		(Load rsVIEW 123)
		(Load rsVIEW 112)
		(Load rsVIEW 268)
		(Load rsVIEW 97)
		(Load rsVIEW 286)
		(Load rsVIEW 50)
		(Load rsVIEW 53)
		(Load rsSOUND 41)
		(swatSound init:)
		(if (== global131 13)
			(= local8 180)
			(= local9 189)
			(= [local28 0] 197)
			(= [local28 1] 184)
			(= [local32 0] 156)
			(= [local32 1] 140)
			(= [local32 2] 180)
			(= [local32 3] 193)
			(= [local36 0] 106)
			(= [local36 1] 174)
			(= [local36 2] 140)
			(= [local36 3] 190)
			(= local14 165)
		else
			(= local8 192)
			(= local9 189)
			(= [local32 0] 170)
			(= [local32 1] 165)
			(= [local32 2] 195)
			(= [local32 3] 179)
			(= [local28 0] (- local8 1))
			(= [local28 1] (- local9 2))
			(= local14 175)
		)
		(= local25 0)
		(= local12 (- local8 10))
		(= local13 local8)
		(= local15 26)
		(= local11 (and (== global130 gCurRoomNum) (!= gPrevRoomNum local15)))
		(if (!= gPrevRoomNum local15)
			(= local10 1)
			(HandsOff)
		else
			(= local10 0)
			(HandsOn)
		)
		(if (or global170 (IsFlag 13))
			(= global178 1)
		)
		((= local4 (Act new:))
			view: 54
			setStep: 3 3
			setLoop: 1
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			setMotion: 0
			posn:
				(if (and (or (== gPrevRoomNum 13) (== gPrevRoomNum 33)) (not local11))
					local12
				else
					local13
				)
				local9
			init:
			illegalBits: 0
		)
		((= local16 (Prop new:))
			view: 251
			setLoop: (if (== global100 12) 7 else 1)
			setCel: (if (== global100 12) 255 else 0)
			setCycle: 0
			setPri: 9
			posn:
				(if (== global100 12) 252 else 261)
				(if (== global100 12) 156 else 155)
			init:
			ignoreActors:
			stopUpd:
		)
		((= local18 (Prop new:))
			view: 251
			setLoop: 2
			setCel: 0
			setCycle: 0
			setPri: 7
			posn: 104 72
			init:
			stopUpd:
		)
		((View new:)
			view: 251
			setLoop: 0
			setCel: 2
			setPri: 10
			posn: 167 138
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 251
			setLoop: 0
			setCel: 0
			setPri: 0
			posn: 67 7
			init:
			ignoreActors: 0
			addToPic:
		)
		((View new:)
			view: 251
			loop: 6
			cel: 0
			setPri: 3
			posn: 104 (if (not (< global100 11)) 110 else 123)
			ignoreActors:
			init:
			stopUpd:
		)
		(if (and (IsFlag 14) (== global100 12))
			((View new:)
				view: 251
				setLoop: 0
				setCel: 1
				setPri: 9
				posn: 229 121
				init:
				addToPic:
			)
		)
		(gEgo
			view: 0
			posn:
				(if (== gPrevRoomNum 26) 256 else 340)
				(if (== gPrevRoomNum 26) 154 else 300)
			init:
			loop: 1
			setMotion: 0
		)
		(= global112 0)
		(if (== global131 13)
			((= global112 keithAct)
				view: 20
				illegalBits: $8000
				setCycle: Walk
				setAvoider: (Avoid new:)
				setMotion: Follow gEgo 500
			)
			(if (== gPrevRoomNum 26)
				(gEgo setMotion: MoveTo 200 160)
				(global112
					loop: 1
					posn: 270 150
					init:
					setAvoider: Avoid
					setMotion: MoveTo 227 160 keithScript
				)
			else
				(global112 posn: 340 300 init: hide:)
			)
		)
		(cond
			((!= global130 gCurRoomNum)
				(= global130 gCurRoomNum)
			)
			((== local10 1)
				(= global132 1)
			)
		)
		(if (!= gPrevRoomNum 26)
			(= global132 1)
			(gEgo stopUpd:)
			(if (== global131 13)
				(global112 stopUpd:)
			)
		)
		(local4 posn: local13 local9 ignoreActors: 0 addToPic:)
		(if (IsFlag 29)
			(self setScript: warrantArrives)
		)
		(if (IsFlag 14)
			(self setScript: swatArrives)
		)
		(HandsOn)
	)
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 1 canControl: 1)
				(if (== global131 13)
					((= local5 (Prop new:))
						view: 51
						loop: 3
						cel: 0
						ignoreActors:
						posn: [local28 0] [local28 1]
						setPri: 14
						setCycle: End self
						init:
					)
				else
					(self cue:)
				)
			)
			(1
				(if (== global131 13)
					(global112
						startUpd:
						posn: 196 197
						setCycle: Walk
						setStep: 3 2
						setPri: 15
						setAvoider: (Avoid new:)
						init:
						show:
					)
				)
				(gEgo
					posn: local14 178
					loop: 0
					cel: 0
					setCycle: Walk
					setPri: 13
					startUpd:
				)
				(= local10 0)
				(if (== global131 13)
					(= global133 0)
				else
					(= global136 0)
				)
				(if (== global131 13)
					(local5 dispose:)
				)
				(User canInput: 1 canControl: 1)
				(self cue:)
			)
			(2
				(if (== global131 13)
					(global112
						posn: 193 197
						ignoreActors: 0
						illegalBits: $8000
						setMotion: MoveTo 190 200 self
					)
				)
			)
			(3
				(global112 setPri: -1 setMotion: Follow gEgo 500)
			)
			(4
				(HandsOff)
				(if (== global131 13)
					(Print 25 69) ; "Keith yells: "Geez, Sonny! Hold on a second, will ya?""
					(cond
						((> (global112 y:) 189)
							(global112
								ignoreActors:
								illegalBits: $8000
								setMotion: MoveTo 185 (global112 y:) self
							)
						)
						((< (global112 x:) 110)
							(global112
								ignoreActors:
								illegalBits: $8000
								setMotion: MoveTo 110 (global112 y:) self
							)
						)
						(else
							(global112
								ignoreActors:
								illegalBits: $8000
								setMotion: MoveTo 105 (global112 y:) self
							)
						)
					)
				else
					(self changeState: 7)
				)
			)
			(5
				(cond
					((== (global112 x:) 110)
						(global112
							ignoreActors:
							illegalBits: $8000
							setMotion: MoveTo 110 195 self
						)
					)
					((== (global112 x:) 105)
						(global112
							ignoreActors:
							illegalBits: $8000
							setMotion: MoveTo 105 195 self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(global112 setMotion: MoveTo 190 195 self)
			)
			(7
				(gEgo setPri: 12)
				(if (== global131 13)
					((= local5 (Prop new:))
						view: 51
						loop: (if (== global131 13) 3 else 0)
						cel: 0
						posn: [local28 0] [local28 1]
						setPri: 15
						init:
						setCycle: End self
					)
					(global112
						ignoreActors: 1
						illegalBits: 0
						setLoop: 0
						setStep: 1 2
						setPri: 15
						setMotion: MoveTo 190 195
					)
				else
					(self cue:)
				)
			)
			(8
				(= gNewRoomNum global131)
			)
			(9
				((= local6 (Prop new:))
					view: 51
					loop: 5
					cel: 0
					posn: [local30 0] [local30 1]
					setPri: 14
					init:
					setCycle: End self
				)
			)
			(10
				(local6 stopUpd:)
			)
			(11
				(local6 startUpd: setCycle: Beg self)
			)
			(12
				(local6 dispose:)
			)
		)
	)
)

(instance pLight of Prop
	(properties)

	(method (doit)
		(self posn: (+ (local7 x:) 4) (- (local7 y:) 29))
		(super doit:)
	)
)

(instance swatArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global211 0)
				((= local7 (Act new:))
					view: 54
					setLoop: 1
					setCel: 3
					posn: 64 156
					setPri: 11
					ignoreControl: -1
					init:
				)
				(pLight
					view: 54
					setLoop: 3
					setCel: 0
					setPri: 11
					setCycle: Fwd
					ignoreActors:
					doit:
					init:
				)
				((= local23 (Prop new:))
					view: 268
					loop: 0
					cel: 2
					posn: 48 144
					setPri: 10
					ignoreActors: 0
					init:
					hide:
				)
				((= local24 (Act new:))
					view: 30
					posn: 73 164
					setPri: 12
					setCycle: Walk
					init:
					hide:
				)
				((= local26 (Prop new:))
					view: 51
					setLoop: 8
					setCel: 255
					posn: 82 151
					setPri: 12
					ignoreActors: 0
					init:
					hide:
				)
				(if (IsFlag 14)
					(local7 stopUpd:)
					(local26 stopUpd: show:)
					(local23 stopUpd: show:)
					(local24 stopUpd: show:)
					(client setScript: 0)
					(return)
				)
				(swatSound play:)
				(local7 posn: -60 157)
				(if (< (gEgo y:) 168)
					(HandsOff)
					(= local45 1)
					(gEgo setMotion: MoveTo (gEgo x:) 168 self)
				else
					(self cue:)
				)
			)
			(1
				(if local45
					(gEgo loop: 3)
				)
				(local7 posn: -60 157 setMotion: MoveTo 64 157 self)
				(SetFlag 14)
			)
			(2
				(if local45
					(HandsOn)
					(= local45 0)
				)
				(local26 show: setCel: 0 setCycle: End self)
			)
			(3
				(local26 stopUpd:)
				(local24 show:)
				(local23 show:)
				(= cycles 1)
			)
			(4
				(local24 stopUpd:)
				(local23 stopUpd:)
				(local7 stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance warrantArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				((= local27 (Act new:))
					setAvoider: Avoid
					view: 50
					setCycle: Walk
					priority: -1
					posn: 85 180
					init:
				)
				(if (IsFlag 29)
					(HandsOn)
					(client setScript: 0)
				else
					(SetFlag 29)
					(local27 posn: -10 190 setMotion: MoveTo 85 180 self)
				)
			)
			(1
				(local27 setMotion: 0)
				(Print 25 75) ; "The officer says... "Here's the search warrant, Sonny.""
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance warrantLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 25 76) ; "You say..."Thanks""
				(SetFlag 13)
				(ClearFlag 29)
				(local27 setAvoider: Avoid setMotion: MoveTo -10 189 self)
			)
			(1
				(HandsOn)
				(local27 dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance exitCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== global131 13)
					((= local5 (Prop new:))
						view: 51
						loop: 3
						cel: 0
						posn: [local28 0] [local28 1]
						setPri: 14
						init:
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(= local10 0)
				(gEgo
					illegalBits: $8000
					posn: local14 175
					loop: 0
					cel: 0
					setCycle: Walk
					setPri: 13
				)
				(if global112
					(= global133 0)
					(local5 dispose:)
					(global112
						ignoreActors: 0
						illegalBits: $8000
						posn: 193 197
						setCycle: Walk
						setStep: 3 2
						setPri: 15
						setAvoider: Avoid
						setMotion: MoveTo 190 200 self
						show:
					)
				else
					(= global136 0)
					(self cue:)
				)
			)
			(2
				(if global112
					(global112 setPri: -1 setMotion: Follow gEgo 500)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance talkWindow of Script
	(properties)

	(method (doit)
		(if (not (& $1000 (gEgo onControl:)))
			(client setScript: 0)
		)
	)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 loop: 3)
				(cond
					((< global100 11)
						(Print 25 77) ; "The boy at the the window says, "Yes sir, what can I do for you?""
					)
					((== global100 11)
						(Print 25 78) ; "The man at the window says, "Yes sir, what can I do for you?""
					)
					(else
						(Print 25 79) ; "The motel manager is fuming when he says... "You dudes aren't gonna get away with this! You're gonna pay for that damage!!""
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'look/pane,man,boy')
				(if (< global100 11)
					(Print 25 80) ; "You see a small boy inside. Probably the manager's son."
				else
					(Print 25 81) ; "You see a man inside. You assume he is the manager."
				)
			)
			((Said 'give/cash')
				(if (< global100 11)
					(Print 25 82) ; "The boy says, "I don't think I should take your money.""
				else
					(Print 25 83) ; "The man says, "I don't need your money, buster.""
				)
			)
			((Said 'talk/man,boy')
				(cond
					((< global100 11)
						(Print 25 84) ; "Hello sir. My dad's not here right now, but maybe I can help you."
					)
					((== global100 12)
						(Print 25 85) ; "You guys did a bang-up job of ruining my day!" the manager says. "Now how about getting lost?"
					)
					(else
						(Print 25 86) ; "Yes sir, what can I do for you?"
					)
				)
			)
			((Said 'show/badge,badge')
				(if (gEgo has: 7) ; wallet
					(Print 25 87) ; "Yes, Officer, how can I help you?"
					(= global175 1)
				else
					(Print 25 88) ; "You don't have your wallet."
				)
			)
			((Said 'rent/chamber')
				(if (== global100 12)
					(switch (Random 0 2)
						(0
							(Print 25 89) ; "GET SERIOUS, MAC!" says the manager... "After the mess you made, you guys ain't rentin' nothing!"
						)
						(1
							(Print 25 90) ; "Slightly upset the manager says..."I only have four words for you jerks!...#$%* the b%& o&%!!!""
						)
						(2
							(Print 25 91) ; "The manager quickly says... "Why? So you can blow up another one?""
						)
					)
				else
					(Print 25 92) ; "I'm sorry, sir" he says, "but we don't have any vacancies."
				)
			)
			((Said 'show/painting,(shot<mug),mugshot')
				(cond
					((< global100 11)
						(Print 25 93) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((gEgo has: 12) ; new_mug_shot
						(Print 25 94 #icon 112) ; "Well," the manager says, "the photograph is vaguely familiar... I believe his name was William Cole. He has room 108."
						(if global112
							(Print 25 95) ; "Ah ha!" you think to yourself, "Bains is using the name `Cole'."
						)
						(if (not (IsFlag 88))
							(SetFlag 1)
							(SetFlag 2)
							(SetScore 3 88)
						)
					)
					((gEgo has: 23) ; old_mug_shot
						(Print 25 96 #icon 123) ; "Well," the manager says, "I don't remember seeing him."
					)
					(else
						(Print 25 17) ; "You don't have it."
					)
				)
			)
			((Said 'look,get,give,show,ask/list,guest,register')
				(cond
					((< global100 11)
						(Print 25 93) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((not global175)
						(Print 25 97) ; "The manager says, "Who do you think you are? My customers expect a little privacy when they stay here.""
					)
					(else
						(Print 25 98) ; "The manager says, "Who are you looking for?""
					)
				)
			)
			((or (Said '[ask]/bains') (Said '[ask]/man,boy/bains'))
				(if (< global100 11)
					(Print 25 99) ; "The boy says, "I don't know.""
				else
					(Print 25 100) ; "Scanning his guest book, he shakes his head and says... "I'm sorry. I don't have anyone listed by that name.""
				)
			)
			(
				(or
					(Said '[ask,get]/cole,chamber')
					(Said '[ask,get]/man,boy/bains')
				)
				(if (< global100 11)
					(Print 25 99) ; "The boy says, "I don't know.""
				else
					(= global178 1)
					(Print 25 101) ; "Scanning his guest book, he nods his head and says... "Yes, here we are: William Cole...Room 108.""
					(if (not (IsFlag 88))
						(SetFlag 1)
						(SetFlag 2)
						(SetScore 3 88)
					)
				)
			)
			((Said 'show/warrant[<frisk]')
				(cond
					((< global100 11)
						(Print 25 93) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((IsFlag 13)
						(Print 25 102) ; "You show the search warrant to the manager, and he says... "Ok, now what?""
						(= global174 1)
					)
					(else
						(Print 25 17) ; "You don't have it."
					)
				)
			)
			((or (Said 'replace/key') (Said 'give/key/manager,boy'))
				(if (gEgo has: 27) ; motel_key
					(Print 25 103) ; "OK"
					(PutItem 27) ; motel_key
				else
					(Print 25 104) ; "You don't have the key to any room here."
				)
			)
			((Said '[ask,get]/key')
				(cond
					((gEgo has: 27) ; motel_key
						(Print 25 29) ; "You already have it."
					)
					((< global100 11)
						(Print 25 93) ; "Well," the boy says, "I don't know... Maybe you'd better come back later. My dad isn't here right now."
					)
					((not global175)
						(Print 25 105) ; "You ask the manager for the key, and he answers... "Get serious, Mac! You rent a room...you get a key. Unfortunately for you," he says, "we don't have a vacancy.""
					)
					((not global174)
						(Print 25 106) ; "I don't care if you're the Queen of England!" he blurts out. "I have an obligation to my customers, and I know the law and there ain't nobody gettin' any key!"
					)
					((not global178)
						(Print 25 107) ; "The manager sounds like he'd really like to help as he says, "I don't know what room key you want! Besides, I've got paying customers in all of my rooms.""
					)
					(else
						(Print 25 108) ; ""Anything you say, Officer," the manager says, as he gives you the key to Room 108."
						(gEgo get: 27) ; motel_key
						(SetScore 3 162)
					)
				)
			)
			((Said 'arrest/man,boy')
				(Print 25 109) ; "You could, but it wouldn't get you anywhere."
			)
		)
	)
)

(instance kickInDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global100 12)
				(gEgo
					view: 286
					setLoop: 0
					setCel: 0
					posn: 251 155
					setPri: 11
					setCycle: End self
				)
			)
			(1
				(local16 setLoop: 7 posn: 252 158 setCel: 0 setCycle: End self)
			)
			(2
				(if global112
					(global112
						setLoop: -1
						startUpd:
						setCycle: Walk
						setMotion: Follow gEgo 15
					)
				)
				(gEgo
					view: 97
					setLoop: 2
					setCel: 0
					posn: 234 159
					setCycle: End self
				)
			)
			(3
				(Print 25 110) ; "Your last act in life is kicking the door in as you're blasted into an unknown dimension."
				(Print 25 111) ; "Because of your improper positioning, you have been blasted into oblivion."
				(EgoDead
					{Congratulations, you have been successful in taking yourself out of the game.}
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global100 12)
				(if global112
					(Print 25 112 #draw) ; "Keith says... "Sonny! Be careful now.""
					(global112
						view: 53
						setMotion: MoveTo 252 (global112 y:) keithScript
					)
				)
				(if (or global204 (not (gEgo has: 0))) ; hand_gun
					(= cycles 4)
				else
					(= global204 1)
					(gEgo view: 4 setLoop: 0 setCel: 0 setCycle: End self)
				)
			)
			(1
				(Print 25 113) ; "As the door opens, you are startled by a sudden explosion."
				(swatSound number: 41 play:)
				(local16 setLoop: 7 setCel: 0 posn: 252 156 setCycle: End)
				(if (gEgo inRect: 220 151 280 156)
					(= local42 1)
					(gEgo view: 97 setLoop: 2 setCel: 0 setCycle: End self)
				else
					(gEgo
						view: 557
						posn: 262 161
						setLoop: (if global204 0 else 1)
						setCel: 0
						setCycle: End self
					)
				)
			)
			(2
				(if (not local42)
					(Print 25 114) ; "Trained reflexes throw you back, slamming your gun hand against the wall. "That was TOO close for comfort!" you say to yourself."
					(if (gEgo has: 0) ; hand_gun
						(= global103
							(switch (Random 1 2)
								(1
									(Random 8 18)
								)
								(2
									(- 0 (Random 8 18))
								)
							)
						)
						(= global104
							(switch (Random 1 2)
								(1
									(Random 6 14)
								)
								(2
									(- 0 (Random 6 14))
								)
							)
						)
						(= global166 0)
					)
					(if (IsFlag 14)
						(= cycles 2)
					else
						(gEgo
							view: (if global204 6 else 0)
							setLoop: -1
							setCycle: Walk
						)
						(if global112
							(global112 view: 20)
						)
						(= local44 1)
						(client setScript: 0)
						(HandsOn)
					)
				else
					(Print 25 111 #draw) ; "Because of your improper positioning, you have been blasted into oblivion."
					(EgoDead 25 115) ; "Congratulations, you have been successful in taking yourself out of the game."
				)
			)
			(3
				(Print 25 116 #at -1 20 #width 280) ; "You watch as the "SWAT team" unloads tear gas into the room."
				(local24
					view: 268
					setLoop: 2
					posn: 73 164
					cycleSpeed: 1
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(swatSound number: 41 play:)
				(local24
					view: 268
					setLoop: 3
					cycleSpeed: 1
					setCel: 0
					setCycle: End
				)
				(gasBomb
					view: 268
					setLoop: 4
					setPri: 14
					setStep: 10 10
					setCycle: Fwd
					ignoreActors:
					ignoreControl: -1
					posn: 75 140
					setMotion: MoveTo 225 111 self
					init:
				)
			)
			(5
				(gasBomb dispose:)
				(= local17 1)
				(local24
					view: 30
					posn: 73 164
					setLoop: 0
					setCel: 0
					cycleSpeed: 0
				)
				((View new:)
					view: 251
					setLoop: 0
					setCel: 1
					setPri: 9
					posn: 229 121
					init:
					stopUpd:
					addToPic:
				)
				((= local20 (Prop new:))
					view: 251
					setLoop: 8
					setCel: 0
					posn: 229 115
					setPri: 10
					init:
					setCycle: Fwd
				)
				(= seconds 3)
				(= local3 300)
				(gEgo
					view: (if global204 6 else 0)
					setLoop: -1
					setCycle: Walk
				)
				(if global112
					(global112 view: 20 setMotion: Follow gEgo 40)
				)
				(= local44 1)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance enterMotel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and global112 local3)
					(Print 25 117) ; "Just before you enter the gas filled room, Keith says: "Better stay put, Sonny.""
				)
				(gEgo
					ignoreControl: -1
					setLoop: -1
					setMotion: MoveTo 278 151 self
				)
			)
			(1
				(if local3
					(Print 25 118) ; "You enter into the motel room, but in a short time, you are overcome by the gas and fall unconscious to the floor."
					(= seconds 2)
				else
					(HandsOn)
					(if local44
						(gContinuousMusic stop: loop: 1 number: 35 play:)
					)
					(gCurRoom newRoom: 26)
				)
			)
			(2
				(HandsOff)
				(EgoDead
					{Congratulations, you have been successful in taking yourself out of the game.}
				)
			)
		)
	)
)

(instance keithScript of Script
	(properties)

	(method (cue)
		(global112 setMotion: Follow gEgo 500)
	)
)

