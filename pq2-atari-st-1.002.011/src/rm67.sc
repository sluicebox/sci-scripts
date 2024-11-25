;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm67 0
)

(local
	local0
	local1
	local2
	[local3 4]
	[local7 2]
	[local9 2]
	[local11 4]
	[local15 4]
	[local19 4]
)

(procedure (localproc_0)
	(switch global131
		(13
			(cond
				(
					(not
						(gEgo
							inRect:
								[local11 0]
								[local11 1]
								[local11 2]
								[local11 3]
						)
					)
					(Print 67 67) ; "You're not close enough to your car's door."
				)
				((== global133 1)
					(Print 67 68) ; "Your car door is locked."
					(return 0)
				)
				(global135
					(Print 67 69) ; "Close the trunk first."
					(return 0)
				)
				((gEgo has: 10) ; field_kit
					(Print 67 70) ; "You should put your field kit in the trunk first."
					(return 0)
				)
				(else
					(gCurRoom setScript: startEnter)
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
								[local11 0]
								[local11 1]
								[local11 2]
								[local11 3]
						)
					)
					(Print 67 67) ; "You're not close enough to your car's door."
				)
				((== global136 1)
					(Print 67 68) ; "Your car door is locked."
				)
				(else
					(gCurRoom setScript: startEnter)
				)
			)
		)
	)
)

(instance carBlock of Blk
	(properties)
)

(instance jBlock of Blk
	(properties)
)

(instance unTrunk of Prop
	(properties)

	(method (cue)
		(self stopUpd:)
	)
)

(instance jailerdoor of Prop
	(properties)
)

(instance plight of Prop
	(properties)
)

(instance carDoor of Prop
	(properties)
)

(instance haines of Act
	(properties)
)

(instance shopwoman of Act
	(properties)
)

(instance ourCar of Act
	(properties)
)

(instance rm67 of Rm
	(properties
		picture 67
		style 1
	)

	(method (dispose)
		(gContinuousMusic loop: 1 fade:)
		(super dispose:)
	)

	(method (init)
		(if (== gPrevRoomNum 0)
			(= gPrevRoomNum 13)
			(= global131 13)
			(= global100 3)
			(gEgo get: 0 1 2 3) ; hand_gun
		)
		(if (== global100 3)
			(SetFlag 152)
			(= global158 0)
			(= global159 0)
		)
		(Load rsPIC 67)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(Load rsVIEW 75)
		(Load rsVIEW 49)
		(Load rsVIEW 33)
		(Load rsVIEW 85)
		(Load rsVIEW 2)
		(Load rsVIEW 76)
		(Load rsSOUND 27)
		(super init:)
		(= global211 1)
		(= global212 3)
		(= [local9 0] 56)
		(= [local9 1] 159)
		(if (== global131 13)
			(= [local11 0] 7)
			(= [local11 1] 153)
			(= [local11 2] 19)
			(= [local11 3] 165)
			(= [local7 0] 1)
			(= [local7 1] 151)
			(= [local19 0] 23)
			(= [local19 1] 145)
			(= [local19 2] 41)
			(= [local19 3] 154)
			(= [local15 0] 54)
			(= [local15 1] 146)
			(= [local15 2] 91)
			(= [local15 3] 158)
		else
			(= [local11 0] 20)
			(= [local11 1] 155)
			(= [local11 2] 35)
			(= [local11 3] 165)
			(= [local7 0] 17)
			(= [local7 1] 152)
			(= [local19 0] 20)
			(= [local19 1] 145)
			(= [local19 2] 38)
			(= [local19 3] 154)
		)
		(= local1 60)
		(= local2 18)
		(carBlock top: 147 bottom: 158 left: -10 right: 75 init:)
		(jBlock top: 178 bottom: 193 left: 194 right: 285)
		((View new:)
			view: 76
			loop: 0
			setCel: 0
			posn: 303 64
			setPri: 3
			init:
			ignoreActors: 0
			addToPic:
		)
		((View new:)
			view: 54
			loop: 1
			setCel: 2
			posn: 206 156
			setPri: 11
			init:
			ignoreActors: 0
			addToPic:
		)
		((View new:)
			view: 75
			loop: 1
			setCel: 2
			posn: 26 177
			setPri: 13
			addToPic:
		)
		((View new:)
			view: 75
			loop: 1
			setCel: 1
			posn: 16 191
			setPri: 14
			init:
			ignoreActors: 0
			addToPic:
		)
		((View new:)
			view: 85
			loop: 0
			setCel: 0
			posn: 128 10
			setPri: 4
			init:
			ignoreActors: 0
			addToPic:
		)
		(ourCar
			view: 54
			setStep: 4 1
			setLoop: 0
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			setMotion: 0
			posn: local2 153
			init:
		)
		(gEgo
			view: 0
			setMotion: 0
			observeBlocks: carBlock
			observeBlocks: jBlock
			posn: 340 300
			init:
		)
		(if (== global131 13)
			((= global112 (Act new:))
				view: 20
				setAvoider: Avoid
				observeBlocks: carBlock
				observeBlocks: jBlock
				posn: 400 400
				setCycle: Walk
				init:
			)
		else
			(= global112 0)
		)
		(if (== global100 3)
			((View new:)
				view: 54
				loop: 1
				setCel: 3
				posn: 226 169
				setPri: 12
				init:
				ignoreActors: 0
				addToPic:
			)
			(plight
				view: 54
				loop: 3
				cel: 0
				posn: 231 140
				setPri: 13
				init:
				setCycle: Fwd
			)
			((View new:)
				view: 75
				loop: 6
				setCel: 0
				yStep: 8
				posn: 240 193
				setPri: 14
				ignoreActors: 0
				addToPic:
			)
			(jailerdoor
				view: 75
				setLoop: 5
				cel: 0
				posn: 240 193
				setPri: 14
				ignoreActors:
				stopUpd:
				init:
			)
			(haines
				view: 49
				loop: 1
				setStep: 3 2
				setCycle: Walk
				setPri: -1
				posn: 210 178
				setAvoider: (Avoid new:)
				init:
			)
			(shopwoman
				view: 2
				setCycle: Walk
				setPri: -1
				posn: -20 1020
				setStep: 3 2
				init:
				stopUpd:
			)
			(if (IsFlag 112)
				(haines stopUpd: x: -20 y: 500)
			)
			(if (IsFlag 35)
				(haines posn: 254 172 loop: 1 stopUpd:)
				(shopwoman posn: 225 172 loop: 0 stopUpd:)
			)
		)
		(if (== gPrevRoomNum 68)
			(gEgo posn: 230 200 setPri: -1 init: ignoreActors: 0)
		)
		(if (or (== gPrevRoomNum 33) (== gPrevRoomNum 13))
			(HandsOff)
			(self setScript: stopScript)
		else
			(HandsOn)
			(ourCar stopUpd:)
			(if (== global131 13)
				(unTrunk
					view: 51
					loop: 4
					cel: 0
					ignoreActors:
					setPri: 12
					x: (+ (ourCar x:) 38)
					y: (+ (ourCar y:) 4)
					setCel: (if global135 255 else 0)
					stopUpd:
					init:
				)
			)
		)
		(self setLocales: 153)
	)

	(method (doit)
		(if (not script)
			(cond
				((and (== gPrevRoomNum 68) (not (IsFlag 35)))
					(self setScript: afterSearch)
				)
				((== global132 (not local0) 1)
					(= global132 0)
					(localproc_0)
				)
				((and (== global100 3) (not (IsFlag 112)))
					(SetFlag 112)
					(self setScript: firstArrived)
				)
			)
			(if
				(and
					(not local0)
					(or
						(<= (gEgo x:) -10)
						(>= (gEgo x:) 330)
						(>= (gEgo y:) 230)
					)
				)
				(Print 67 0) ; "You will need your car in order to leave the area."
				(cond
					((<= (gEgo x:) 0)
						(gEgo setMotion: MoveTo 10 (gEgo y:))
					)
					((>= (gEgo x:) 320)
						(gEgo setMotion: MoveTo 310 (gEgo y:))
					)
					((>= (gEgo y:) 230)
						(gEgo setMotion: MoveTo (gEgo x:) 220)
					)
				)
			)
		)
		(if (<= (gEgo y:) 90)
			(Print 67 1) ; "You have no need to enter the mall."
			(gEgo setMotion: MoveTo (gEgo x:) 92)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			((Said 'talk/woman')
				(cond
					((not (== global100 3))
						(event claimed: 0)
					)
					((IsFlag 35)
						(Print 67 2) ; "The woman is busy giving Officer Haines her statement."
					)
					((== script afterSearch)
						(Print 67 3 #at -1 20) ; "What am I going to do now?" she says. "My husband is going to kill me when he finds out that the car was stolen!"
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'look/woman')
				(if (or (== script afterSearch) (IsFlag 35))
					(Print 67 4) ; "The lady looks very upset."
				else
					(event claimed: 0)
				)
			)
			((or (Said 'happen<what[<ask]') (Said 'interrogate/woman'))
				(cond
					((or (not (== global100 3)) (not (IsFlag 35)))
						(event claimed: 0)
					)
					((== script afterSearch)
						(Print 67 5 #at -1 20) ; "I was only in the mall for a minute, and when I came out it was GONE. Oh, what am I going to tell my husband?"
					)
					(else
						(Print 67 2) ; "The woman is busy giving Officer Haines her statement."
					)
				)
			)
			(
				(or
					(Said 'describe,ask/auto')
					(Said 'ask/woman/auto')
					(Said 'get[/auto]/description,info')
					(Said 'get/description,info[/auto]')
					(Said '[/auto]/description,info')
					(Said '/description,info[/auto]')
					(Said 'ask,interrogate,get/name,address,number,license')
					(Said
						'ask,interrogate,get/woman,witness[/number,badge,name,address]'
					)
				)
				(cond
					((not (== global100 3))
						(event claimed: 0)
					)
					((!= script afterSearch)
						(Print 67 2) ; "The woman is busy giving Officer Haines her statement."
					)
					((not (IsFlag 51))
						(Print 67 6 #at -1 20 #width 280) ; "You ask for the description of her car and she says... "Oh, yes! It's a 1986 compact Chevy station wagon. It's black, and the license number is...is... C035... Oh! That's all I can remember, Officer.""
						(SetScore 3)
						(SetFlag 51)
						(script seconds: 3)
					)
					(else
						(Print 67 7 #at -1 20) ; "That's all I can remember, Officer."
					)
				)
			)
			((Said 'talk/cop,calvin')
				(cond
					((or (< global100 3) (> global100 3))
						(Print 67 8) ; "Officer Haines is not here."
					)
					((== script afterSearch)
						(Print 67 9) ; "Haines says, "You'll need a description of the lady's car, Sonny.""
					)
					((IsFlag 35)
						(Print 67 10) ; "Officer Haines is busy taking the woman's statement."
					)
					((== global100 3)
						(Print 67 11) ; "Officer Haines is checking for possible witnesses."
					)
					(else
						(Print 67 12 #at -1 40 #width 280) ; "You know, Bonds," says Haines, " it's a good thing I had to pick up toothpaste for my wife, or we might not have found the jailer's car for a while."
					)
				)
			)
			((Said 'look/cop,calvin')
				(cond
					((or (< global100 3) (> global100 3))
						(Print 67 8) ; "Officer Haines is not here."
					)
					((== script afterSearch)
						(Print 67 13 #at -1 20) ; "Haines looks a bit dismayed by your clumsy attempts at extracting information from the lady."
					)
					((IsFlag 35)
						(Print 67 10) ; "Officer Haines is busy taking the woman's statement."
					)
					((== global100 3)
						(Print 67 11) ; "Officer Haines is checking for possible witnesses."
					)
					(else
						(Print 67 14) ; "Haines looks like he'll be glad to retire next year."
					)
				)
			)
			((Said 'look,frisk/trunk')
				(cond
					((!= global131 13)
						(Print 67 15) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
					)
					((not global135)
						(Print 67 16) ; "The trunk of the unmarked car is closed."
					)
					(
						(not
							(gEgo
								inRect:
									[local15 0]
									[local15 1]
									[local15 2]
									[local15 3]
							)
						)
						(Print 67 17) ; "The trunk of the unmarked car is open."
					)
					(else
						(gInventory
							carrying: {The car's trunk contains }
							empty: {The car's trunk is empty.}
							showSelf: 13
						)
					)
				)
			)
			((Said 'open/trunk')
				(cond
					((!= global131 13)
						(Print 67 15) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
					)
					(
						(not
							(gEgo
								inRect:
									[local15 0]
									[local15 1]
									[local15 2]
									[local15 3]
							)
						)
						(Print 67 18) ; "You are not close enough to a trunk that you can open."
					)
					(global135
						(Print 67 19) ; "The trunk of the unmarked car is already open."
					)
					(else
						(= global135 1)
						(unTrunk setCycle: End unTrunk)
					)
				)
			)
			((Said 'close/trunk')
				(cond
					((not global135)
						(Print 67 20) ; "The trunk is already closed."
					)
					(
						(not
							(gEgo
								inRect:
									[local15 0]
									[local15 1]
									[local15 2]
									[local15 3]
							)
						)
						(proc0_7) ; "You're not close enough."
					)
					(else
						(= global135 0)
						(unTrunk setCycle: Beg unTrunk)
					)
				)
			)
			((Said 'drop,place/briefcase[/trunk]')
				(cond
					((IsItemAt 10 13) ; field_kit
						(Print 67 21) ; "You already did."
					)
					((not (gEgo has: 10)) ; field_kit
						(Print 67 22) ; "You don't have it."
					)
					((!= global131 13)
						(Print 67 15) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
					)
					(
						(not
							(gEgo
								inRect:
									[local15 0]
									[local15 1]
									[local15 2]
									[local15 3]
							)
						)
						(proc0_7) ; "You're not close enough."
					)
					(global135
						(Print ; "Ok."
							67
							23
							(PutItem 10 13) ; field_kit
							(and (IsObject gFKit) (gFKit dispose:))
							(= global240 0)
						)
					)
					(script
						(Print 67 24) ; "Not now."
					)
					(else
						(self setScript: kitToTrunk)
						(PutItem 10 13) ; field_kit
						(if (IsObject gFKit)
							(gFKit dispose:)
						)
						(= global240 0)
					)
				)
			)
			((Said 'get,remove/briefcase[/trunk]')
				(cond
					((gEgo has: 10) ; field_kit
						(Print 67 25) ; "You already have it."
					)
					((not (IsItemAt 10 13)) ; field_kit
						(Print 67 26) ; "Your field kit is not in the trunk."
					)
					(
						(not
							(gEgo
								inRect:
									[local15 0]
									[local15 1]
									[local15 2]
									[local15 3]
							)
						)
						(proc0_7) ; "You're not close enough."
					)
					(global135
						(Print 67 23 (gEgo get: 10)) ; "Ok.", field_kit
					)
					(script
						(Print 67 24) ; "Not now."
					)
					(else
						(self setScript: kitToTrunk)
						(gEgo get: 10) ; field_kit
					)
				)
			)
			((Said 'look>')
				(cond
					((Said '[<at,around][/!*,building,mall,chamber]')
						(Print 67 27) ; "This is the main entrance to "Oak Tree Mall," the city's newest location for shopping convenience."
					)
					((Said '/tree,dirt,bush')
						(Print 67 28) ; "You look, but in vain. You find nothing."
					)
					((Said '/pane')
						(cond
							(
								(and
									(<= 58 (gEgo x:) 187)
									(<= (gEgo y:) 100)
								)
								(Print 67 29) ; "You can't see past the reflection."
							)
							(
								(or
									(gEgo inRect: -10 120 86 189)
									(gEgo inRect: 142 126 305 189)
								)
								(Print 67 30) ; "Just an ordinary car window."
							)
							(else
								(Print 67 31) ; "Window? What window?!!"
							)
						)
					)
					((Said '/door')
						(cond
							(
								(and
									(<= 58 (gEgo x:) 187)
									(<= (gEgo y:) 100)
								)
								(Print 67 29) ; "You can't see past the reflection."
							)
							(
								(or
									(gEgo inRect: -10 120 86 189)
									(gEgo inRect: 142 126 305 189)
								)
								(Print 67 32) ; "Just an ordinary car door."
							)
							(else
								(Print 67 33) ; "Door? What door?!!"
							)
						)
					)
					((Said '/lot')
						(Print 67 34) ; "This is the mall parking lot. There are many cars parked here."
					)
					((Said '/sign')
						(Print 67 35) ; ""Oak Tree Mall"...Yep, that's what it says."
					)
					((Said '/crowd')
						(Print 67 36) ; "There is no one in sight."
					)
					((Said '/auto,auto')
						(if (gEgo inRect: 151 173 304 210)
							(switch (Random 0 2)
								(0
									(Print 67 37) ; "You look at the jailer's car and think... "A well kept Vette. What a nice blue color!""
								)
								(1
									(Print 67 38) ; ""A fine looking machine!" you mumble to yourself."
								)
								(2
									(Print 67 39) ; "What a nice car!" you say, thinking out loud. "The guy must have put every nickel he made into it."
								)
							)
						else
							(Print 67 40) ; "Looking around, you find nothing."
						)
					)
					((or (Said '/plate[<license]') (Said '/license'))
						(cond
							((gEgo inRect: 151 176 206 210)
								(switch (Random 0 2)
									(0
										(Print 67 41) ; "You look and find the rear plate missing."
									)
									(1
										(Print 67 42) ; "You notice that the rear plate is missing."
									)
									(2
										(Print 67 43) ; "The rear plate is missing."
									)
								)
							)
							((gEgo inRect: 252 173 304 210)
								(switch (Random 0 2)
									(0
										(Print 67 44) ; "You make a mental note of the front plate... personalized letters "WOW.""
									)
									(1
										(Print 67 45) ; "You look at the front plate which reads... "WOW.""
									)
									(2
										(Print 67 46) ; "You find a personalized front plate that reads..."WOW." You think to yourself,"Quite fitting for such a sharp Vette!""
									)
								)
							)
							(else
								(Print 67 47) ; "You look at the license plate, but it doesn't ring a bell !"
							)
						)
					)
				)
			)
			((or (Said 'read/plate[<license]') (Said 'read/license'))
				(cond
					((gEgo inRect: 151 176 206 210)
						(switch (Random 0 2)
							(0
								(Print 67 41) ; "You look and find the rear plate missing."
							)
							(1
								(Print 67 42) ; "You notice that the rear plate is missing."
							)
							(2
								(Print 67 43) ; "The rear plate is missing."
							)
						)
					)
					((gEgo inRect: 252 173 304 210)
						(switch (Random 0 2)
							(0
								(Print 67 48) ; "You make a mental note of the front plate... personalized letters...."WOW""
							)
							(1
								(Print 67 49) ; "You look at the front plate which reads... "WOW""
							)
							(2
								(Print 67 50) ; "You find a personalized front plate that reads... "WOW" you think to yourself..." Quite fitting for such a sharp Vette!""
							)
						)
					)
					(else
						(Print 67 47) ; "You look at the license plate, but it doesn't ring a bell !"
					)
				)
			)
			((or (Said 'enter/auto') (Said 'open/door'))
				(cond
					((gEgo inRect: 224 191 246 210)
						(self newRoom: 68)
					)
					(
						(gEgo
							inRect:
								[local19 0]
								[local19 1]
								[local19 2]
								[local19 3]
						)
						(Print 67 51) ; "You don't need to open this door."
					)
					(
						(and
							(== (gEgo loop:) 2)
							(gEgo inRect: 220 170 240 180)
						)
						(Print 67 52) ; "This side is locked. Try the other side."
					)
					(
						(and
							(== (gEgo loop:) 3)
							(gEgo inRect: 220 170 240 180)
						)
						(Print 67 53) ; "You don't need anything from the police car."
					)
					((gEgo inRect: 220 170 240 180)
						(Print 67 54) ; "Which car?"
					)
					(else
						(localproc_0)
					)
				)
			)
			((Said 'exit/auto')
				(if script
					(Print 67 24) ; "Not now."
				else
					(self setScript: exitCar)
				)
			)
			((Said 'unlock/door')
				(cond
					(
						(gEgo
							inRect:
								[local11 0]
								[local11 1]
								[local11 2]
								[local11 3]
						)
						(cond
							((and (== global131 13) (gEgo has: 3)) ; unmarked_car_keys
								(if (== global133 1)
									(= global133 0)
									(Print 67 55) ; "OK. It's unlocked"
								else
									(Print 67 56) ; "The door is already unlocked."
								)
							)
							((== global131 13)
								(Print 67 57) ; "You need a key to unlock this door."
							)
						)
						(cond
							((and (== global131 33) (gEgo has: 2)) ; key_ring
								(if (== global136 1)
									(= global136 0)
									(Print 67 58) ; "OK. It's unlocked."
								else
									(Print 67 56) ; "The door is already unlocked."
								)
							)
							((== global131 33)
								(Print 67 57) ; "You need a key to unlock this door."
							)
						)
					)
					((== global131 13)
						(if (gEgo inRect: 22 148 40 152)
							(Print 67 59) ; "You don't need to do that."
						else
							(Print 67 60) ; "You're not close enough."
						)
					)
					((gEgo inRect: 16 148 40 152)
						(Print 67 59) ; "You don't need to do that."
					)
					(else
						(Print 67 60) ; "You're not close enough."
					)
				)
			)
			((Said 'lock/door')
				(cond
					(
						(gEgo
							inRect:
								[local11 0]
								[local11 1]
								[local11 2]
								[local11 3]
						)
						(cond
							((and (== global131 13) (gEgo has: 3)) ; unmarked_car_keys
								(if (== global133 0)
									(= global133 1)
									(Print 67 61) ; "OK. It's locked."
								else
									(Print 67 62) ; "The door is already locked."
								)
							)
							((== global131 13)
								(Print 67 63) ; "You need a key to lock this door."
							)
						)
						(cond
							((and (== global131 33) (gEgo has: 2)) ; key_ring
								(if (== global136 0)
									(= global136 1)
									(Print 67 61) ; "OK. It's locked."
								else
									(Print 67 62) ; "The door is already locked."
								)
							)
							((== global131 33)
								(Print 67 63) ; "You need a key to lock this door."
							)
						)
					)
					((== global131 13)
						(if (gEgo inRect: 22 148 40 152)
							(Print 67 59) ; "You don't need to do that."
						else
							(Print 67 60) ; "You're not close enough."
						)
					)
					((gEgo inRect: 16 148 40 152)
						(Print 67 59) ; "You don't need to do that."
					)
					(else
						(Print 67 60) ; "You're not close enough."
					)
				)
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
				(gEgo
					posn: (if (== global131 13) 12 else 28) 160
					loop: 0
					setPri: 12
					setStep: 3 2
					setCycle: Walk
					init:
					stopUpd:
				)
				(if global112
					(global112
						posn: 23 153
						setStep: 3 2
						setLoop: 0
						setCel: 0
						setPri: 10
						ignoreActors:
						illegalBits: 0
						setMotion: MoveTo 26 143
					)
				)
				(carDoor
					view: 51
					loop: (if (== global131 13) 2 else 0)
					cel: 0
					posn: [local7 0] [local7 1]
					setPri: 11
					init:
					setCycle: End self
				)
			)
			(1
				(= local0 0)
				(if (== global131 13)
					(= global133 0)
				else
					(= global136 0)
				)
				(carDoor dispose:)
				(gEgo setPri: -1)
				(if global112
					(global112
						setStep: 3 2
						setCycle: Walk
						setLoop: -1
						setPri: -1
						setMotion: MoveTo 56 143 self
					)
				else
					(self cue:)
				)
			)
			(2
				(if global112
					(global112
						illegalBits: $8000
						ignoreActors: 0
						setMotion: Follow gEgo 50
					)
				)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance startEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 12 stopUpd:)
				(cond
					((not global112)
						(self changeState: 4)
					)
					((not (global112 inRect: -10 0 330 240))
						(global112 posn: 330 125 setMotion: MoveTo 128 112 self)
						(Print 67 64) ; "Keith yells: "I'm coming, Sonny!""
					)
					(else
						(Print 67 65) ; "Keith says: "Wait up, Sonny!""
						(if (> (global112 y:) 158)
							(if (< (global112 x:) 102)
								(global112
									setMotion: MoveTo 102 (global112 y:) self
								)
							else
								(global112
									setMotion: MoveTo (global112 x:) 158 self
								)
							)
						else
							(self cue:)
						)
					)
				)
			)
			(1
				(global112 setPri: 10 setMotion: MoveTo (global112 x:) 140 self)
			)
			(2
				(global112 setPri: 10 setMotion: MoveTo 29 145 self)
			)
			(3
				(gEgo setPri: 12)
				(if (== global131 13)
					(global112 setMotion: MoveTo 30 140)
				)
				(carDoor
					view: 51
					loop: (if (== global131 13) 2 else 0)
					cel: 0
					posn: [local7 0] [local7 1]
					setPri: 11
					init:
					setCycle: End
				)
				(self cue:)
			)
			(4
				(if (== global131 13)
					(global112 setLoop: 2)
					(if
						(and
							(not (IsFlag 156))
							(or (IsFlag 50) (IsFlag 51))
						)
						(SetFlag 156)
						(Print 67 66) ; "As you get into the car, you fill Keith in on what you've discovered."
					)
				)
				(gCurRoom newRoom: global131)
			)
		)
	)
)

(instance kitToTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(unTrunk cel: 0 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(unTrunk setCycle: Beg self)
			)
			(3
				(unTrunk stopUpd:)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance stopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if global112
					(global112 posn: 0 400)
				)
				(= local0 1)
				(if (!= global130 gCurRoomNum)
					(= global130 gCurRoomNum)
					(= global135 0)
					(ourCar posn: local1 153 setMotion: MoveTo local2 153 self)
				else
					(ourCar posn: local2 153 addToPic:)
					(if (== global131 13)
						(unTrunk
							view: 51
							loop: 4
							cel: 0
							ignoreActors:
							setPri: 12
							x: (+ (ourCar x:) 38)
							y: (+ (ourCar y:) 4)
							stopUpd:
							init:
						)
					)
					(client setScript: exitCar)
				)
			)
			(1
				(ourCar ignoreActors: 0 addToPic:)
				(if (== global131 13)
					(unTrunk
						view: 51
						loop: 4
						cel: 0
						ignoreActors:
						setPri: 12
						x: (+ (ourCar x:) 38)
						y: (+ (ourCar y:) 4)
						stopUpd:
						init:
					)
				)
				(client setScript: exitCar)
			)
		)
	)
)

(instance firstArrived of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if global112
					(global112
						setAvoider: Avoid
						setMotion: MoveTo 110 (global112 y:)
					)
					(Print 67 71) ; "Keith says, "Look Sonny, there's Haines.""
				else
					(Print 67 72 #at -1 40) ; "You see Officer Haines approaching."
				)
				(gEgo setMotion: MoveTo 106 163)
				(haines loop: 1 setMotion: MoveTo 152 172 self)
			)
			(1
				(if global112
					(global112 setAvoider: Avoid setMotion: MoveTo 110 158)
				)
				(haines setMotion: MoveTo 134 164 self)
			)
			(2
				(gEgo stopUpd:)
				(haines loop: 1)
				(Print 67 73 #draw #at -1 40) ; ""This is definitely the Correctional Officer's car," Haines says..."
				(Print 67 74 #at -1 40) ; "It's been sitting here a while, though," he continues. "The engine is cold."
				(if global112
					(Print 67 75 #at -1 40) ; "Sonny, I'm going to take a look around," Keith says. "You go ahead and check out the car."
					(global112
						illegalBits: $8000
						setMotion: MoveTo 155 125 self
					)
				else
					(= seconds 3)
				)
			)
			(3
				(gContinuousMusic number: 27 loop: -1 play:)
				(if global112
					(global112 setMotion: MoveTo 400 100)
				)
				(Print 67 76 #at -1 40) ; "Haines says, "I think I'll go check around a little. There may be some witnesses.""
				(haines setAvoider: Avoid setMotion: MoveTo -20 100 self)
			)
			(4
				(haines posn: -20 1000 stopUpd:)
				(HandsOn)
				(gEgo startUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance afterSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo stopUpd:)
				(haines view: 49 posn: -15 119 setMotion: MoveTo 104 124 init:)
				(shopwoman
					view: 2
					setCycle: Walk
					posn: -20 114
					setMotion: MoveTo 115 122 self
					init:
				)
			)
			(1
				(jailerdoor stopUpd:)
				(haines loop: 2)
				(Print 67 77 #at -1 20 #draw) ; "Hey Sonny!" Haines shouts. "Looks like Bains may have taken another car. This lady says her car has been stolen."
				(self cue:)
			)
			(2
				(haines stopUpd:)
				(shopwoman stopUpd:)
				(gEgo setMotion: MoveTo 138 189 self)
			)
			(3
				(gEgo setMotion: MoveTo 138 125 self)
			)
			(4
				(gEgo loop: 1)
				(haines startUpd: loop: 0)
				(Print 67 78 #at -1 20 #draw) ; ""I figure you'll have some questions to ask her," says Haines."
				(User canInput: 1)
				(= seconds 60)
			)
			(5
				(HandsOff)
				(Print 67 79 #at -1 20 #draw) ; "I'll take it from here Sonny," Haines assures you. "You've got your work cut out for you."
				(haines setMotion: MoveTo (haines x:) 174 self)
				(shopwoman setMotion: Follow haines 5)
				(gEgo loop: 2 stopUpd:)
			)
			(6
				(haines setMotion: MoveTo 254 174)
				(shopwoman setMotion: MoveTo (shopwoman x:) 174 self)
			)
			(7
				(HandsOn)
				(shopwoman setMotion: MoveTo 225 174 self)
			)
			(8
				(haines loop: 1 stopUpd:)
				(shopwoman stopUpd:)
				(SetFlag 35)
				(client setScript: 0)
			)
		)
	)
)

