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
	local21
	local22
	local23
	[local24 2]
	[local26 2]
	[local28 4]
	[local32 5]
	local37
	local38
	local39
	local40
	local41
)

(procedure (localproc_0)
	(switch global131
		(13
			(cond
				(
					(not
						(gEgo
							inRect:
								[local28 0]
								[local28 1]
								[local28 2]
								[local28 3]
						)
					)
					(Print 25 67) ; "You're not close enough to your car's door."
				)
				((== global133 1)
					(Print 25 68) ; "Your car door is locked."
					(return 0)
				)
				(global135
					(Print 25 69) ; "Close the trunk first."
					(return 0)
				)
				((gEgo has: 10) ; field_kit
					(Print 25 70) ; "You should put your field kit in the trunk first."
					(return 0)
				)
				(else
					(rm25 setScript: (ScriptID 227)) ; carScript
					((rm25 script:) changeState: 4)
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
								[local28 0]
								[local28 1]
								[local28 2]
								[local28 3]
						)
					)
					(Print 25 67) ; "You're not close enough to your car's door."
				)
				((== global136 1)
					(Print 25 68) ; "Your car door is locked."
				)
				(else
					(rm25 setScript: (ScriptID 227)) ; carScript
					((rm25 script:) changeState: 4)
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

(instance unknown_25_3 of PV
	(properties
		y 72
		x 104
		view 251
		loop 2
		priority 7
	)
)

(instance unknown_25_4 of PV
	(properties
		y 138
		x 167
		view 251
		cel 2
		priority 10
		signal 16384
	)
)

(instance unknown_25_5 of PV
	(properties
		y 7
		x 67
		view 251
		priority 0
	)
)

(instance unknown_25_6 of PV
	(properties
		y 110
		x 104
		view 251
		loop 6
		priority 3
		signal 16384
	)
)

(instance unknown_25_7 of PV
	(properties
		y 121
		x 229
		view 251
		cel 1
		priority 9
	)
)

(instance keithFollow of Follow
	(properties)
)

(instance rm25 of Rm
	(properties
		picture 25
		style 0
	)

	(method (notify param1)
		(switch param1
			(0
				(= local9 0)
			)
			(1
				(global112 setMotion: keithFollow gEgo 500)
			)
			(2
				(global112 setAvoider: Avoid)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(cond
				((& $0040 (gEgo onControl:))
					(gCurRoom setScript: enterMotel)
				)
				(
					(or
						(gEgo inRect: 152 77 176 109)
						(gEgo inRect: 159 109 184 142)
					)
					(gEgo setPri: 10 illegalBits: 8192)
					(if (== global131 13)
						(global112 stopUpd:)
					)
				)
				((< (gEgo y:) 83)
					(gEgo setPri: 7 illegalBits: -32768)
					(if (== global131 13)
						(global112 stopUpd:)
					)
				)
				(else
					(if (== global131 13)
						(global112 startUpd:)
					)
					(if (> (gEgo y:) 183)
						(gEgo setPri: 15)
					else
						(gEgo setPri: -1)
					)
					(gEgo illegalBits: -32768)
				)
			)
			(if (== global100 12)
				(gEgo ignoreControl: 2)
			else
				(gEgo observeControl: 2)
			)
			(cond
				(local39
					(self setScript: warrantLeaves)
					(= local39 0)
				)
				((== (gEgo onControl: 1) 4096)
					(self setScript: (ScriptID 226)) ; talkWindow
				)
				((== global132 local9 1)
					(if (not (gCast contains: local3))
						(= global132 0)
						(self setScript: (ScriptID 227)) ; carScript
						((self script:) changeState: 1)
					)
				)
				((== global132 (not local9) 1)
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
		(= local37 (& (gEgo onControl: 1) $0f00))
		(if
			(and
				(<= (gEgo y:) 130)
				(or (< (gEgo x:) 0) (> (gEgo x:) 320))
			)
			(gEgo y: 132)
		)
		(if (== global131 13)
			(cond
				((== (global112 priority:) 15)
					(if (<= (global112 y:) 183)
						(global112 setPri: -1)
					)
				)
				((> (global112 priority:) 183)
					(global112 setPri: 15)
				)
			)
		)
		(if (> local2 1)
			(-- local2)
		)
		(if (== local2 1)
			(-- local2)
			(local18 dispose:)
			(Print 25 0 #draw) ; "The gas has cleared. It appears that you can enter the motel room."
		)
		(if (and (== local9 0) (not (gEgo onControl: 1)))
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
					((not local37)
						(proc0_7) ; "You're not close enough."
					)
					((gEgo inRect: 80 70 140 77)
						(Print 25 2) ; "This is Room 206."
					)
					((gEgo inRect: 168 70 210 76)
						(Print 25 3) ; "This is Room 207."
					)
					((gEgo inRect: 233 70 286 81)
						(Print 25 4) ; "This is Room 208."
					)
					(else
						(Print 25 5) ; "This is Room 108."
					)
				)
			)
			((Said 'go/pane')
				(Print 25 6) ; "The best way to enter any of these rooms is through their doors."
			)
			((Said 'look,smell/cigarette,gas')
				(if local2
					(Print 25 7) ; "The acrid tear gas streaming from the broken window stings your eyes."
				else
					(event claimed: 0)
				)
			)
			((Said 'look>')
				(cond
					((Said '[<around,at][/building,chamber]')
						(Print 25 8) ; "You are in the parking lot at the Snuggler's Inn"
					)
					((Said '/pane')
						(cond
							((!= (gEgo onControl: 1) 16384)
								(Print 25 9) ; "You aren't close to a window."
							)
							((and local16 (gEgo inRect: 197 130 243 143))
								(Print 25 10) ; "You are looking at a broken window."
							)
							(else
								(Print 25 11) ; "Someone's going to call the cops if you keep looking through the windows like that!"
							)
						)
					)
					((Said '/door')
						(cond
							((not local37)
								(Print 25 12) ; "You aren't close enough to a door."
							)
							((!= (gEgo onControl: 1) 256)
								(Print 25 13) ; "There's nothing special about this door."
							)
							((== global100 12)
								(Print 25 14) ; "The door to room 108 is in sad shape."
							)
							(else
								(Print 25 5) ; "This is Room 108."
							)
						)
					)
					((Said '/briefcase')
						(if (gEgo has: 10) ; field_kit
							(Print 25 15) ; "You don't need to look now!"
						else
							(proc0_9) ; "You don't have it."
						)
					)
					((Said '/trunk')
						(if (== global131 13)
							(if
								(and
									(gEgo
										inRect:
											[local32 0]
											[local32 1]
											[local32 2]
											[local32 3]
									)
									(gCast contains: local5)
								)
								(gInventory
									carrying:
										{The car's trunk contains:}
									empty:
										{The car's trunk is empty.}
									showSelf: 13
								)
							else
								(Print 25 16) ; "You're not close enough to an open trunk."
							)
						else
							(Print 25 17) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
				)
			)
			((Said 'open/briefcase')
				(if (gEgo has: 10) ; field_kit
					(Print 25 18) ; "You don't need to open it now!"
				else
					(proc0_9) ; "You don't have it."
				)
			)
			((or (Said 'go<in') (Said 'enter/chamber,inn'))
				(cond
					((not local37)
						(Print 25 19) ; "You are not close enough to a door."
					)
					((!= (gEgo onControl: 1) 256)
						(Print 25 20) ; "You have no reason to go into this room."
					)
					((< global100 12)
						(Print 25 21) ; "This door is locked."
					)
					((gCurRoom script:)
						(Print 25 22) ; "Not now."
					)
					(else
						(gCurRoom setScript: enterMotel)
					)
				)
			)
			(
				(and
					(gEgo
						inRect: [local28 0] [local28 1] [local28 2] [local28 3]
					)
					(or (Said 'unlock/door') (Said 'use/key'))
				)
				(cond
					((== global131 13)
						(cond
							((not (gEgo has: 3)) ; unmarked_car_keys
								(Print 25 23) ; "You need the correct key."
							)
							(global133
								(= global133 0)
								(Print 25 24) ; "OK. It's unlocked."
							)
							(else
								(Print 25 25) ; "The door is already unlocked."
							)
						)
					)
					((not (gEgo has: 2)) ; key_ring
						(Print 25 23) ; "You need the correct key."
					)
					(global136
						(= global136 0)
						(Print 25 24) ; "OK. It's unlocked."
					)
					(else
						(Print 25 25) ; "The door is already unlocked."
					)
				)
			)
			((or (Said 'press,unlock,open/door') (Said 'use/key'))
				(cond
					(
						(gEgo
							inRect:
								[local28 0]
								[local28 1]
								[local28 2]
								[local28 3]
						)
						(localproc_0)
					)
					((not local37)
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
					((== local37 256)
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
						(if (> (gEgo distanceTo: local23) 30)
							(proc0_7) ; "You're not close enough."
						else
							(= local39 1)
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
			((Said 'look,look/warrant')
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
								[local28 0]
								[local28 1]
								[local28 2]
								[local28 3]
						)
						(gEgo inRect: 180 187 200 197)
					)
					(if (== global131 13)
						(if (== global133 0)
							(= global133 1)
							(Print 25 36) ; "OK. It's locked."
						else
							(Print 25 37) ; "The door is already locked."
						)
					)
					(if (== global131 33)
						(if (== global136 0)
							(= global136 1)
							(Print 25 36) ; "OK. It's locked."
						else
							(Print 25 37) ; "The door is already locked."
						)
					)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said 'knock[/door]')
				(if local37
					(Print 25 38) ; "You knock, but no one responds."
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said '[open]/police')
				(if local37
					(Print 25 39) ; "In a commanding voice you yell, "Open up, in the name of the police!""
					(Print 25 40) ; "You listen carefully but are unable to hear anything."
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said 'open,unlock/trunk')
				(if (== global131 13)
					(if
						(gEgo
							inRect:
								[local32 0]
								[local32 1]
								[local32 2]
								[local32 3]
						)
						(cond
							(global135
								(Print 25 41) ; "It's already open."
							)
							((gEgo has: 3) ; unmarked_car_keys
								(= global135 1)
								(trunkScript changeState: 0)
							)
							(else
								(Print 25 42) ; "You need a key to open this trunk."
							)
						)
					else
						(proc0_7) ; "You're not close enough."
					)
				else
					(Print 25 17) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
				)
			)
			((Said 'close,lock/trunk')
				(if (== global131 13)
					(if
						(gEgo
							inRect:
								[local32 0]
								[local32 1]
								[local32 2]
								[local32 3]
						)
						(if global135
							(= global135 0)
							(trunkScript changeState: 2)
						else
							(Print 25 43) ; "It's already closed."
						)
					else
						(proc0_7) ; "You're not close enough."
					)
				else
					(Print 25 17) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
				)
			)
			((Said 'talk,ask/friend')
				(if (== global131 13)
					(global112 setMotion: Follow gEgo 500)
					(Print 25 44) ; ""I'm right behind you, partner!" Keith says..."
				else
					(Print 25 45) ; "You came here alone. Keith is not with you."
				)
			)
			((Said 'talk>')
				(event claimed: 1)
				(cond
					((and (IsFlag 14) (<= (gEgo distanceTo: local20) 30))
						(cond
							((IsFlag 0)
								(Print 25 46) ; "You tell Chuck that the room is secure."
								(Print 25 47) ; "Chuck responds, "Ok, Sonny. We'll wrap things up here.""
							)
							((== global100 12)
								(Print 25 48) ; "Chuck says, "You go ahead and do your thing. We'll stay here.""
							)
							(local41
								(Print 25 49) ; "We're ready, Sonny."
							)
							(else
								(= local41 1)
								(Print 25 50) ; "You explain the situation to Chuck and request that he and his partner get into position next to their car."
								(gEgo setMotion: 0)
								(local20
									view: 268
									setLoop: 1
									setCel: 0
									setCycle: End
								)
								(Print 25 51) ; "You got it, Sonny!" says Chuck. "That's what we're here for."
								(Print 25 52) ; ""Did you find out which room this dirtbag is in?" Chuck asks."
								(Print 25 53) ; "Yes," you reply, "Room 108."
							)
						)
					)
					((and (IsFlag 29) (<= (gEgo distanceTo: local23) 30))
						(Print 25 54) ; "I've got that warrant you requested, Sonny."
					)
					((and global112 (Said '/friend'))
						(event claimed: 0)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'break,hit/door')
				(cond
					((not local37)
						(Print 25 55) ; "You aren't close enough to the door."
					)
					(
						(or
							(not (& (gEgo onControl: 1) $0100))
							(!= global100 11)
						)
						(Print 25 56) ; "Being a macho type, you kick in the door, making a fool out of yourself."
						(Print 25 57) ; "You quickly close the door."
					)
					((== global100 12)
						(Print 25 58) ; "What do you think you are doing? The door is already open!"
					)
					(else
						(= local21 1)
						(self setScript: kickInDoor)
					)
				)
			)
			((Said 'drop,location/briefcase')
				(if
					(gEgo
						inRect: [local32 0] [local32 1] [local32 2] [local32 3]
					)
					(if global135
						(if (gEgo has: 10) ; field_kit
							(Print 25 59) ; "You place your field kit inside the trunk."
							(PutItem 10 13) ; field_kit
							(if (IsObject gFKit)
								(gFKit dispose:)
							)
							(= global240 0)
						else
							(proc0_9) ; "You don't have it."
						)
					else
						(Print 25 60) ; "Open the trunk first."
					)
				else
					(Print 25 61) ; "You're not close enough to your car's trunk."
				)
			)
			((Said 'japaneseopen,get/briefcase')
				(if
					(gEgo
						inRect: [local32 0] [local32 1] [local32 2] [local32 3]
					)
					(if global135
						(if (IsItemAt 10 13) ; field_kit
							(Print 25 62) ; "You take your field kit from the trunk."
							(gEgo get: 10) ; field_kit
						else
							(Print 25 63) ; "The field kit is not in the trunk."
						)
					else
						(Print 25 64) ; "Open the trunk first."
					)
				else
					(Print 25 61) ; "You're not close enough to your car's trunk."
				)
			)
			((Said 'get/browning')
				(if
					(gEgo
						inRect: [local32 0] [local32 1] [local32 2] [local32 3]
					)
					(if 1
						(Print 25 65) ; "You don't need to take it out of the trunk."
					else
						(Print 25 66) ; "There is no shotgun."
					)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
		)
	)

	(method (dispose)
		(trunkScript dispose:)
		(super dispose:)
	)

	(method (init)
		(if (== global100 11)
			(= global158 0)
			(= global159 0)
		)
		(super init:)
		(= global112 0)
		(= global211 1)
		(= global212 3)
		(= local1 (< global100 11))
		(= [local26 0] 142)
		(= [local26 1] 193)
		(cond
			((= local9 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13)))
				(= global135 0)
			)
			(global135
				((= local5 (Prop new:))
					view: 51
					loop: 5
					cel: 2
					posn: [local26 0] [local26 1]
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
			(= local7 180)
			(= local8 189)
			(= [local24 0] 197)
			(= [local24 1] 184)
			(= [local28 0] 156)
			(= [local28 1] 140)
			(= [local28 2] 180)
			(= [local28 3] 193)
			(= [local32 0] 106)
			(= [local32 1] 174)
			(= [local32 2] 140)
			(= [local32 3] 190)
			(= local13 165)
		else
			(= local7 192)
			(= local8 189)
			(= [local28 0] 170)
			(= [local28 1] 165)
			(= [local28 2] 195)
			(= [local28 3] 179)
			(= [local24 0] (- local7 1))
			(= [local24 1] (- local8 2))
			(= local13 175)
		)
		(= local21 0)
		(= local11 (- local7 10))
		(= local12 local7)
		(= local14 26)
		(= local10 (and (== global130 gCurRoomNum) (!= gPrevRoomNum local14)))
		(if (!= gPrevRoomNum local14)
			(= local9 1)
			(HandsOff)
		else
			(= local9 0)
			(HandsOn)
		)
		(if (or global170 (IsFlag 13))
			(= global178 1)
		)
		((= local3 (Act new:))
			view: 54
			setStep: 3 3
			setLoop: 1
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			setMotion: 0
			posn:
				(if (and (or (== gPrevRoomNum 13) (== gPrevRoomNum 33)) (not local10))
					local11
				else
					local12
				)
				local8
			init:
			illegalBits: 0
		)
		((= local15 (Prop new:))
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
		(if (< global100 11)
			(unknown_25_6 y: 123)
		)
		(gAddToPics add: unknown_25_3 unknown_25_4 unknown_25_5 unknown_25_6)
		(if (and (IsFlag 14) (== global100 12))
			(gAddToPics add: unknown_25_7)
		)
		(gAddToPics doit:)
		(gEgo
			view: 0
			posn:
				(if (== gPrevRoomNum 26) 256 else 340)
				(if (== gPrevRoomNum 26) 154 else 300)
			init:
			loop: 1
			setMotion: 0
		)
		(cond
			((!= global130 gCurRoomNum)
				(= global130 gCurRoomNum)
			)
			((== local9 1)
				(= global132 1)
			)
		)
		(= global112 0)
		(if (== global131 13)
			((= global112 keithAct)
				view: 20
				illegalBits: -32768
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
				(if (< global110 30)
					(global112 setMotion: 0 stopUpd:)
				)
				(global112 posn: 340 1000 init: stopUpd:)
			)
		)
		(if (!= gPrevRoomNum 26)
			(= global132 1)
			(gEgo stopUpd:)
			(if (== global131 13)
				(global112 stopUpd:)
			)
		)
		(local3 posn: local12 local8 ignoreActors: 0 addToPic:)
		(if (IsFlag 29)
			(self setScript: warrantArrives)
		)
		(if (IsFlag 14)
			(self setScript: swatArrives)
		)
		(HandsOn)
	)
)

(instance trunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local5 (Prop new:))
					view: 51
					loop: 5
					cel: 0
					posn: [local26 0] [local26 1]
					setPri: 14
					init:
					setCycle: End self
				)
			)
			(1
				(local5 stopUpd:)
			)
			(2
				(local5 startUpd: setCycle: Beg self)
			)
			(3
				(local5 dispose:)
			)
		)
	)
)

(instance pLight of Prop
	(properties)

	(method (doit)
		(self posn: (+ (local6 x:) 4) (- (local6 y:) 29))
		(super doit:)
	)
)

(instance swatArrives of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global211 0)
				((= local6 (Act new:))
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
				((= local19 (Prop new:))
					view: 268
					loop: 0
					cel: 2
					posn: 48 144
					setPri: 10
					ignoreActors: 0
					init:
					hide:
				)
				((= local20 (Act new:))
					view: 30
					posn: 73 164
					setPri: 12
					setCycle: Walk
					init:
					hide:
				)
				((= local22 (Prop new:))
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
					(local6 stopUpd:)
					(local22 stopUpd: show:)
					(local19 stopUpd: show:)
					(local20 stopUpd: show:)
					(client setScript: 0)
					(return)
				)
				(swatSound play:)
				(local6 posn: -60 157)
				(HandsOff)
				(cond
					((& (gEgo onControl: 1) $1000)
						(gEgo setMotion: MoveTo 80 (gEgo y:) self)
					)
					((gEgo inRect: 0 130 135 170)
						(if (< (= temp0 (gEgo x:)) 10)
							(= temp0 10)
						)
						(gEgo setMotion: MoveTo temp0 170 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (>= (gEgo y:) 168)
					(gEgo loop: 3)
				else
					(gEgo loop: 2)
				)
				(gEgo stopUpd:)
				(local6 posn: -60 157 setMotion: MoveTo 64 157 self)
				(SetFlag 14)
			)
			(2
				(gEgo setMotion: 0 startUpd:)
				(local22 show: setCel: 0 setCycle: End self)
			)
			(3
				(local22 stopUpd:)
				(local20 show:)
				(local19 show:)
				(= cycles 1)
			)
			(4
				(local19 stopUpd:)
				(local6 stopUpd:)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance warrantArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 stopUpd:)
				((= local23 (Act new:))
					setAvoider: Avoid
					view: 50
					setCycle: Walk
					posn: 85 180
					init:
				)
				(if (IsFlag 29)
					(client setScript: 0)
				else
					(SetFlag 29)
					(local23 posn: -10 180)
					(cond
						((not (gEgo inRect: 0 170 95 200))
							(local23 setMotion: MoveTo 85 180 self)
						)
						((>= (gEgo x:) 30)
							(local23
								setMotion:
									MoveTo
									(- (gEgo x:) 20)
									(gEgo y:)
									self
							)
						)
						((and (<= (gEgo y:) 182) (>= (gEgo y:) 178))
							(local23
								posn: -10 172
								setMotion: MoveTo 15 172 self
							)
						)
						(else
							(local23
								posn: -10 180
								setMotion: MoveTo 15 185 self
							)
						)
					)
				)
			)
			(1
				(local23 setMotion: 0)
				(Print 25 71) ; "The officer says... "Here's the search warrant, Sonny.""
				(gEgo setMotion: 0 startUpd:)
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
				(Print 25 72) ; "You say..."Thanks""
				(SetFlag 13)
				(ClearFlag 29)
				(local23
					setAvoider: Avoid
					setMotion: MoveTo -10 (local23 y:) self
				)
			)
			(1
				(HandsOn)
				(local23 dispose:)
				(client setScript: 0)
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
				(local15 setLoop: 7 posn: 252 158 setCel: 0 setCycle: End self)
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
				(Print 25 73) ; "Your last act in life is kicking the door in as you're blasted into an unknown dimension."
				(Print 25 74) ; "Because of your improper positioning, you have been blasted into oblivion."
				(EgoDead 25 75)
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
					(Print 25 76 #draw) ; "Keith says... "Sonny! Be careful now.""
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
				(Print 25 77) ; "As the door opens, you are startled by a sudden explosion."
				(swatSound number: 41 play:)
				(local15 setLoop: 7 setCel: 0 posn: 252 156 setCycle: End)
				(if (gEgo inRect: 220 151 280 156)
					(= local38 1)
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
				(if (not local38)
					(Print 25 78) ; "Trained reflexes throw you back, slamming your gun hand against the wall. "That was TOO close for comfort!" you say to yourself."
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
						(= local40 1)
						(client setScript: 0)
						(HandsOn)
					)
				else
					(Print 25 79 #draw) ; "Because of your improper positioning, you have been blasted into oblivion."
					(EgoDead 25 75)
				)
			)
			(3
				(Print 25 80 #at -1 20) ; "You watch as the "SWAT team" unloads tear gas into the room."
				(local20
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
				(local20
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
				(gEgo stopUpd:)
				(global112 stopUpd:)
			)
			(5
				(gasBomb dispose:)
				(= local16 1)
				(local20
					view: 30
					posn: 73 164
					setLoop: 0
					setCel: 0
					cycleSpeed: 0
					stopUpd:
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
				((= local18 (Prop new:))
					view: 251
					setLoop: 8
					setCel: 0
					posn: 229 115
					setPri: 10
					init:
					setCycle: Fwd
				)
				(= seconds 3)
				(if (< global110 30)
					(= local2 100)
				else
					(= local2 200)
				)
				(gEgo
					view: (if global204 6 else 0)
					setLoop: -1
					setCycle: Walk
				)
				(if global112
					(global112 view: 20 setMotion: Follow gEgo 40)
				)
				(= local40 1)
				(gEgo setMotion: 0 startUpd:)
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
				(if (and global112 local2)
					(Print 25 81) ; "Just before you enter the gas filled room, Keith says: "Better stay put, Sonny.""
				)
				(gEgo
					ignoreControl: -1
					setLoop: -1
					setMotion: MoveTo 278 151 self
				)
			)
			(1
				(if local2
					(Print 25 82) ; "You enter into the motel room, but in a short time, you are overcome by the gas and fall unconscious to the floor."
					(= seconds 2)
				else
					(HandsOn)
					(if local40
						(gContinuousMusic stop: loop: 1 number: 35 play:)
					)
					(gCurRoom newRoom: 26)
				)
			)
			(2
				(HandsOff)
				(EgoDead 25 75)
			)
		)
	)
)

(instance keithScript of Script
	(properties)

	(method (cue)
		(global112 setMotion: Follow gEgo 500)
		(if (< global110 30)
			(global112 stopUpd:)
		)
	)
)

