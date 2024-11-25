;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm22 0
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
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
)

(procedure (localproc_0)
	(Print &rest #at -1 130)
)

(procedure (localproc_1)
	(switch global131
		(13
			(cond
				((not (gEgo inRect: 230 118 250 127))
					(localproc_0 22 103) ; "You're not close enough to the door."
				)
				((== global133 1)
					(localproc_0 22 104) ; "Your car door is locked."
					(return 0)
				)
				(global135
					(localproc_0 22 105) ; "Close the trunk first."
					(return 0)
				)
				((gEgo has: 10) ; field_kit
					(localproc_0 22 106) ; "You should put your field kit in the trunk first."
					(return 0)
				)
				(else
					(carScript changeState: 8)
					(return 1)
				)
			)
		)
		(33
			(cond
				((not (gEgo inRect: 230 118 250 127))
					(localproc_0 22 107) ; "You're not close enough to the door"
				)
				(global136
					(localproc_0 22 104) ; "Your car door is locked."
				)
				(else
					(carScript changeState: 8)
				)
			)
		)
	)
)

(instance unTrunk of Prop
	(properties)
)

(instance rm22 of Rm
	(properties
		picture 22
		style 8
	)

	(method (init)
		(super init:)
		(User canInput: 1 canControl: 1)
		(if (= local6 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13)))
			(HandsOff)
		else
			(HandsOn)
		)
		(if (== global131 13)
			(= global212 3)
		)
		(if global165
			(= local18 1)
		)
		(if (and global165 (== ((gInventory at: 0) owner:) 22)) ; hand_gun
			(= local18 1)
			((gInventory at: 0) moveTo: 0) ; hand_gun
			(= local14 1)
		)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(= [local4 0] 265)
		(= [local4 1] 129)
		(= local10 240)
		(= local8 238)
		(= local9 247)
		(= local11 23)
		((View new:)
			view: 54
			loop: 0
			cel: 3
			posn: 20 153
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 54
			loop: 0
			cel: 3
			posn: 35 135
			init:
			stopUpd:
			addToPic:
		)
		(if (== global131 33)
			((View new:)
				view: 54
				loop: 1
				cel: 3
				posn: 272 154
				init:
				stopUpd:
				addToPic:
			)
		)
		((View new:)
			view: 211
			loop: 3
			cel: 0
			posn: 159 66
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 211
			loop: 1
			cel: 0
			posn: 262 100
			init:
			stopUpd:
			addToPic:
		)
		((= local0 (Prop new:)) view: 211 posn: 178 99 init: stopUpd:)
		((= local1 (Prop new:))
			view: 211
			loop: 2
			cel: 0
			posn: 148 69
			cycleSpeed: 6
			init:
			startUpd:
		)
		(= local7 (and (== global130 gCurRoomNum) (!= gPrevRoomNum local11)))
		(if (!= gPrevRoomNum local11)
			(= local6 1)
			(User canControl: 0)
		else
			(= local6 0)
		)
		((= local2 (Act new:))
			view: 54
			setStep: 1
			setLoop: 1
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			setMotion: 0
			illegalBits: 0
			posn:
				(if (and (!= gPrevRoomNum local11) (not local7)) local8 else local9)
				134
			init:
		)
		(self setLocales: 153)
		(self setScript: rm22Script)
	)
)

(instance rm22Script of Script
	(properties)

	(method (doit)
		(cond
			((and (!= (mod (gEgo view:) 2) 0) (<= (gEgo y:) 122))
				(gEgo view: (- (gEgo view:) 1))
			)
			((and (!= (mod (gEgo view:) 2) 1) (> (gEgo y:) 122))
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(cond
			((and (== global132 local6 1) (not (gCast contains: local2)))
				(= global132 0)
				(carScript changeState: 0)
			)
			((== global132 (not local6) 1)
				(= global132 0)
				(localproc_1)
			)
		)
		(cond
			(
				(and
					(or (< (gEgo x:) 15) (> (gEgo x:) 296))
					(> (gEgo y:) 155)
					(not local13)
				)
				(localproc_0 22 0) ; "The corners of the garage are really dusty!"
				(= local13 1)
			)
			((and local13 (< (gEgo x:) 295) (> (gEgo x:) 16))
				(= local13 0)
			)
			((and (gEgo inRect: 145 99 210 108) local16)
				(cameraScript changeState: 4)
			)
			((and (not (gEgo inRect: 145 99 210 108)) (not local16))
				(cameraScript changeState: 0)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 0
					posn:
						(if (== gPrevRoomNum local11) 179 else 0)
						(if (== gPrevRoomNum local11) 106 else 0)
					init:
					setMotion: 0
				)
				(if (== global131 13)
					((= global112 (Act new:))
						view: 20
						illegalBits: $c000
						posn:
							(if (!= gPrevRoomNum local11)
								(- (gEgo x:) 4)
							else
								300
							)
							(if (!= gPrevRoomNum local11)
								(- (gEgo y:) 20)
							else
								157
							)
						setCycle: Walk
						init:
					)
				)
				(if (!= gPrevRoomNum local11)
					(= global135 0)
					(stopScript init:)
					(local2 setMotion: MoveTo local9 134 stopScript)
				else
					(if (and global135 (== global131 13))
						(unTrunk
							view: 51
							loop: 5
							cel: 2
							posn: 209 138
							setPri: 9
							init:
						)
					)
					(local2 addToPic:)
				)
				(cond
					((!= global130 gCurRoomNum)
						(ClearFlag 142)
						(= global130 gCurRoomNum)
					)
					(local6
						(= global132 1)
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/jailer')
								(localproc_0 22 1) ; "He's inside the jail. You can't see him from here."
							)
							((Said '/friend')
								(if
									(and
										(== global131 13)
										(< (global112 y:) 10)
									)
									(if (gEgo inRect: 235 102 300 158)
										(localproc_0 22 2) ; "He looks back at you from inside the car."
									else
										(localproc_0 22 3) ; "You can't see him from where you're standing. The garage is not well-lit."
									)
								else
									(event claimed: 0)
								)
							)
							((Said '[<at,around][/building,garage,chamber]')
								(Print 22 4 #width 260 #at -1 120) ; "This is the underground parking garage of the new Lytton City Jail. You are filled with pride as the memories of the dedication ceremonies return."
								(if (>= global100 1)
									(Print 22 5 #width 280 #at -1 120) ; "Following your heroic capture of Jessie Bains (aka: the Death Angel) you became an instant celebrity. But now, unless you recapture Bains, only the bitter memories of failure will remain..."
								)
							)
							((Said '[<at,up][/ceiling,roof]')
								(localproc_0 22 6) ; "Nothing of interest on the ceiling."
							)
							((Said '[<at,down][/floor,dirt]')
								(localproc_0 22 7) ; "Looks like a normal, oil-stained garage floor."
							)
							((Said '/auto<blue')
								(if (== global131 33)
									(localproc_0 22 8) ; "That's your personal car, all right."
								else
									(localproc_0 22 9) ; "That's your unmarked police car, all right."
								)
							)
							((Said '/key[<locker]')
								(if local18
									(localproc_0 22 10) ; "There is nothing special about the locker keys."
								else
									(localproc_0 22 11) ; "The keys are in the lockers."
								)
							)
							((Said '<below/auto')
								(localproc_0 22 12) ; "You'd like to, but you don't want to get down on your knees on the garage floor."
							)
							((Said '/auto')
								(if (gEgo inRect: 150 0 250 146)
									(if (== global131 13)
										(localproc_0 22 13) ; "It's your unmarked car, a trusty vehicle."
									else
										(localproc_0 22 14) ; "Someday, you'll get that hatchback fixed."
									)
								else
									(localproc_0 22 15) ; "Mostly police cruisers."
								)
							)
							((Said '/cruiser')
								(localproc_0 22 16) ; "If you've seen one, you've seen 'em all."
							)
							((Said '/trunk')
								(if
									(and
										(gEgo inRect: 176 123 206 135)
										(gCast contains: unTrunk)
									)
									(gInventory
										carrying: {The car's trunk contains:}
										empty: {The car's trunk is empty.}
										showSelf: 13
									)
								else
									(localproc_0 22 17) ; "You're not close enough to an open trunk."
								)
							)
							((Said '/sign,gate,fence')
								(if (> (gEgo x:) 235)
									(localproc_0 22 18) ; "It says: "CLOSED""
								else
									(localproc_0 22 19) ; "Walk closer to the sign"
								)
							)
							((Said '/wall')
								(localproc_0 22 20) ; "You see gun lockers built into the concrete wall, next to a heavy metal door."
								(localproc_0 22 21 70 260) ; "There appears to be a built-in video camera surveillance system and a speaker on the wall above the door. There is a button to the right of the door."
							)
							((Said '<in/locker')
								(if global165
									(if (gEgo inRect: 135 99 163 108)
										(if (!= ((gInventory at: 0) owner:) 22) ; hand_gun
											(localproc_0 22 22) ; "Empty."
										else
											(localproc_0 22 23) ; "Your gun's in it."
										)
									else
										(localproc_0 22 24) ; "You can't see into the locker."
									)
								else
									(localproc_0 22 25) ; "Open it, if you want to look inside."
								)
							)
							((Said '/locker')
								(localproc_0 22 26) ; "Just your basic gun lockers, usually found outside of most jails."
							)
							((Said '/button,button')
								(localproc_0 22 27) ; "The buzzer is used to alert the jailer."
							)
							((Said '/camera')
								(localproc_0 22 28) ; "The closed circuit camera allows the jailer to monitor anyone entering or leaving the jail."
							)
							((Said '/pa,pa')
								(localproc_0 22 29) ; "The speaker allows the jailer to communicate with those who wish to enter the jail."
							)
							((Said '/door')
								(localproc_0 22 30) ; "The jail door is made of very heavy metal."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'talk/friend')
						(if (and (== global131 13) (< (global112 y:) 10))
							(if (gEgo inRect: 235 102 300 158)
								(localproc_0 22 31) ; "From inside the car,Keith says: "Go on and take care of your business, partner. I'll just take a little nap out here.""
							else
								(localproc_0 22 32) ; "He can't hear you from inside the car."
							)
						else
							(event claimed: 0)
						)
					)
					((or (Said 'use/extender') (Said 'extender'))
						(if (== global131 13)
							(localproc_0 22 33) ; "Get into your car."
						else
							(localproc_0 22 34) ; "You don't have it."
						)
					)
					((Said 'drive')
						(if local6
							(localproc_0 22 35) ; "Go on! Get out and look around first."
						else
							(localproc_0 22 36) ; "Get in your car first."
						)
					)
					((Said 'enter/auto')
						(cond
							((gEgo inRect: 230 118 250 127)
								(localproc_1)
							)
							((gEgo inRect: 230 129 260 138)
								(localproc_0 22 37) ; "You don't want to get in on the passenger side."
							)
							(else
								(localproc_0 22 38) ; "You aren't close enough."
							)
						)
					)
					((Said 'knock')
						(if (gEgo inRect: 145 99 205 108)
							(localproc_0 22 39) ; "It only hurts your knuckles to bang on the jail door."
						else
							(localproc_0 22 40) ; "You hum a familiar tune..."Knock three times on the ceiling if you want me...""
						)
					)
					((Said 'open/auto')
						(localproc_1)
					)
					((Said 'unlock/gate')
						(localproc_0 22 41) ; "Don't waste your time."
					)
					(
						(or
							(Said 'unlock,open/locker')
							(Said 'unlock,open/(door<locker)')
						)
						(cond
							(global165
								(localproc_0 22 42) ; "The locker is already open."
							)
							((gEgo inRect: 135 99 163 108)
								(if (== ((gInventory at: 0) owner:) 22) ; hand_gun
									(localproc_0 22 43) ; "Using the locker key from your pocket, you open the locker."
								else
									(localproc_0 22 44) ; "Using the key found in the locker door, you open the locker."
								)
								(= global165 1)
								(= local18 1)
							)
							(else
								(localproc_0 22 45) ; "You're not close enough."
							)
						)
					)
					((Said 'enter,go[<in]/jail')
						(if (gEgo inRect: 145 99 205 108)
							(if (not local12)
								(localproc_0 22 46) ; "Only the jailer can let you in."
							else
								(localproc_0 22 47) ; "The jailer's voice booms through the speaker... "Please face the camera and show your identification.""
							)
						else
							(localproc_0 22 48) ; "Go over to the jail door."
						)
					)
					((Said 'exit,(get<out)[/auto]')
						(= global132 1)
					)
					(
						(or
							(Said 'press,use,ring/button,button,bell')
							(Said 'talk,signal,buzz,call/jailer')
						)
						(if (gEgo inRect: 185 99 210 108)
							(localproc_0 22 49) ; "You signal the jailer by pushing the buzzer."
							(if local12
								(localproc_0 22 50) ; "OK, OK..." the jailer says. "What do you want??"
							else
								(= local12 1)
								(localproc_0 22 51) ; "The jailer speaks to you through the PA system... "Booking desk... can I help you?""
							)
						else
							(localproc_0 22 52) ; "You must be close enough to push the button."
						)
					)
					((Said 'yes')
						(if (and local12 (gEgo inRect: 145 99 210 108))
							(localproc_0 22 53) ; "OK. I'm waiting."
						else
							(localproc_0 22 54) ; "Agreeable, aren't you?"
						)
					)
					((Said 'no')
						(if (and local12 (gEgo inRect: 145 99 210 108))
							(localproc_0 22 55) ; "Then don't bother me!"
						else
							(localproc_0 22 56) ; "Disgreeable, aren't you?"
						)
					)
					((Said 'show/badge,card,badge,billfold,painting')
						(if local12
							(if (gEgo inRect: 145 99 205 108)
								(if (gEgo has: 7) ; wallet
									(doorScript changeState: 0)
								else
									(localproc_0 22 57) ; "The jailer says... "Sorry chump! You don't have ID, you don't get in.""
								)
							else
								(localproc_0 22 58) ; "Get closer to the camera."
							)
						else
							(localproc_0 22 59) ; "You must contact the jailer before you show your ID"
						)
					)
					((Said 'call,yell/friend')
						(if (global112 inRect: 280 150 320 170)
							(localproc_0 22 60) ; "Go ahead, Sonny. I'm gonna finish my smoke."
						else
							(localproc_0 22 61) ; "You yell, and the reverberations in the underground garage make your words impossible to understand."
						)
					)
					((Said 'get,remove/9mm')
						(cond
							((gEgo has: 0) ; hand_gun
								(proc0_8) ; "You already took it."
							)
							((not (gEgo inRect: 135 99 163 108))
								(localproc_0 22 62) ; "You're too far away."
							)
							((not global165)
								(localproc_0 22 63) ; "You should open the locker first."
							)
							(local14
								(localproc_0 22 64) ; "Oh NO! You forgot to lock the gun locker!! Somebody has made off with your shiny new gun ...(ooooops)!"
								(EgoDead
									{Yes, even in peaceful Lytton, crimes of opportunity still occur. Next time, keep track of your piece.}
								)
							)
							((== ((gInventory at: 0) owner:) 22) ; hand_gun
								(localproc_0 22 65) ; "You take your gun, holster it, then close and lock the locker."
								(gEgo get: 0) ; hand_gun
								(= global165 0)
							)
							(else
								(localproc_0 22 66) ; "You don't see your gun in the locker."
							)
						)
					)
					((Said 'drop,place,replace,throw,exit/9mm')
						(cond
							((not (gEgo inRect: 135 99 163 108))
								(localproc_0 22 62) ; "You're too far away."
							)
							((not global165)
								(localproc_0 22 63) ; "You should open the locker first."
							)
							((not (gEgo has: 0)) ; hand_gun
								(localproc_0 22 67) ; "Whaddaya mean? You don't have your gun!"
							)
							(global204
								(localproc_0 22 68) ; "First, holster your gun."
							)
							(else
								(localproc_0 22 69) ; "You place your gun in the locker."
								(gEgo put: 0 22) ; hand_gun
							)
						)
					)
					((Said 'drop,place,replace,throw/key[<locker]')
						(if local18
							(localproc_0 22 70) ; "Don't do that."
						else
							(localproc_0 22 34) ; "You don't have it."
						)
					)
					((Said 'get/key<locker')
						(if local18
							(proc0_8) ; "You already took it."
						else
							(localproc_0 22 71) ; "You must close and lock the locker in order to get the key."
						)
					)
					((Said 'get/key')
						(if (and (gEgo inRect: 135 99 163 108) local18)
							(localproc_0 22 72) ; "You have the locker key."
						else
							(localproc_0 22 73) ; "You have the car keys."
						)
					)
					(
						(or
							(Said 'close,lock/locker')
							(Said 'close,lock/(door<locker)')
						)
						(if (gEgo inRect: 135 99 163 108)
							(if global165
								(= global165 0)
								(localproc_0 22 74) ; "You close and lock the locker."
								(if (== ((gInventory at: 0) owner:) 22) ; hand_gun
									(SetScore 3 115)
								)
							else
								(localproc_0 22 75) ; "The locker is already closed."
							)
						else
							(localproc_0 22 62) ; "You're too far away."
						)
					)
					((Said 'open,move/gate,fence')
						(localproc_0 22 76) ; "This area is under construction. There is no need to go past the gate."
					)
					((Said 'climb/gate,fence')
						(localproc_0 22 77) ; "You're wasting your time."
					)
					((Said 'unlock/door')
						(cond
							((gEgo inRect: 230 118 250 127)
								(cond
									((== global131 13)
										(if (gEgo has: 3) ; unmarked_car_keys
											(if global133
												(= global133 0)
												(localproc_0 22 78) ; "OK. It's unlocked."
											else
												(localproc_0 22 79) ; "The door is already unlocked."
											)
										else
											(localproc_0 22 80) ; "You need a key to unlock this door."
										)
									)
									((== global131 33)
										(if (gEgo has: 2) ; key_ring
											(if global136
												(= global136 0)
												(localproc_0 22 78) ; "OK. It's unlocked."
											else
												(localproc_0 22 79) ; "The door is already unlocked."
											)
										else
											(localproc_0 22 80) ; "You need a key to unlock this door."
										)
									)
								)
							)
							((gEgo inRect: 145 99 205 108)
								(if (not local12)
									(localproc_0 22 46) ; "Only the jailer can let you in."
								else
									(localproc_0 22 47) ; "The jailer's voice booms through the speaker... "Please face the camera and show your identification.""
								)
							)
							((gEgo inRect: 230 129 260 138)
								(localproc_0 22 81) ; "If you're getting into your car, go around to the driver's side."
							)
							(else
								(localproc_0 22 45) ; "You're not close enough."
							)
						)
					)
					((Said 'lock/door')
						(cond
							((gEgo inRect: 230 118 250 127)
								(if (== global131 13)
									(if (not global133)
										(= global133 1)
										(localproc_0 22 82) ; "OK. It's locked."
									else
										(localproc_0 22 83) ; "The door is already locked."
									)
								)
								(if (== global131 33)
									(if (not global136)
										(= global136 1)
										(localproc_0 22 82) ; "OK. It's locked."
									else
										(localproc_0 22 83) ; "The door is already locked."
									)
								)
							)
							((gEgo inRect: 230 129 260 138)
								(localproc_0 22 84) ; "Go around to the driver's side."
							)
							(else
								(localproc_0 22 45) ; "You're not close enough."
							)
						)
					)
					((Said 'open,unlock/trunk')
						(cond
							((== global131 13)
								(if (gEgo inRect: 176 123 206 135)
									(cond
										(global135
											(Print 22 85) ; "It's already open."
										)
										((gEgo has: 3) ; unmarked_car_keys
											(carScript changeState: 14)
										)
										(else
											(localproc_0 22 86) ; "You need a key to open this trunk."
										)
									)
								else
									(localproc_0 22 87) ; "You're not close enough to your trunk, and you shouldn't open anybody else's trunk!"
								)
							)
							((gEgo inRect: 176 123 206 135)
								(localproc_0 22 88) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
							)
							(else
								(localproc_0 22 87) ; "You're not close enough to your trunk, and you shouldn't open anybody else's trunk!"
							)
						)
					)
					((Said 'close,lock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 176 123 206 135)
								(if global135
									(carScript changeState: 16)
								else
									(Print 22 89) ; "It's already closed."
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(localproc_0 22 88) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					(
						(or
							(Said 'press,open/door')
							(Said 'let/me')
							(Said 'get<in')
						)
						(cond
							((gEgo inRect: 145 99 205 108)
								(if (not local12)
									(localproc_0 22 46) ; "Only the jailer can let you in."
								else
									(localproc_0 22 47) ; "The jailer's voice booms through the speaker... "Please face the camera and show your identification.""
								)
							)
							(local6
								(= global132 1)
							)
							((gEgo inRect: 230 129 260 138)
								(localproc_0 22 84) ; "Go around to the driver's side."
							)
							(else
								(localproc_1)
							)
						)
					)
					((Said 'close/door')
						(localproc_0 22 90) ; "The door is already closed."
					)
					((Said 'drop,place/briefcase')
						(if (gEgo inRect: 176 123 206 135)
							(if global135
								(if (gEgo has: 10) ; field_kit
									(localproc_0 22 91) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
									(if (IsObject gFKit)
										(gFKit dispose:)
									)
									(= global240 0)
								else
									(localproc_0 22 92) ; "You don't have the field kit."
								)
							else
								(localproc_0 22 93) ; "Open the trunk first."
							)
						else
							(localproc_0 22 94) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'remove,get/briefcase')
						(if (gEgo inRect: 176 123 206 135)
							(if global135
								(if (== ((gInventory at: 10) owner:) 13) ; field_kit
									(localproc_0 22 95) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(localproc_0 22 96) ; "The field kit is not in the trunk."
								)
							else
								(localproc_0 22 93) ; "Open the trunk first."
							)
						else
							(localproc_0 22 94) ; "You're not close enough to your car's trunk."
						)
					)
				)
			)
		)
	)
)

(instance cameraScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local16 1)
				(self cue:)
			)
			(1
				(= local17 1)
				(local1 setCycle: End self)
			)
			(2
				(= local17 0)
				(local1 setCycle: Beg self)
			)
			(3
				(self changeState: 1)
			)
			(4
				(= local16 0)
				(local1 setCycle: 0)
				(self cue:)
			)
			(5
				(local1 setCycle: CT 0 -1)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 22 97) ; "After showing your ID, you hear a loud metal "clank" as the jailer releases the door locks."
				(gEgo setMotion: MoveTo 180 101 self)
			)
			(1
				(gEgo setLoop: 3)
				(local0 setCycle: End self)
			)
			(2
				(gEgo setLoop: -1)
				(HandsOn)
				(gCurRoom newRoom: 23)
			)
		)
	)
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setStep: 1 2
					posn: 240 136
					setPri: 8
					setLoop: 0
					setCycle: 0
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 238 124 self
				)
				(if (and (== global131 13) (not local7))
					(global112 posn: 250 136 loop: 0 cel: 1 startUpd:)
					((= local3 (Prop new:))
						view: 51
						loop: 3
						cel: 0
						posn: [local4 0] [local4 1]
						setPri: 9
						init:
						setCycle: End
					)
				)
			)
			(1
				(= local6 0)
				(if (== global131 13)
					(= global133 0)
				else
					(= global136 0)
				)
				(gEgo
					setStep: 3 2
					setCycle: Walk
					setLoop: -1
					setPri: -1
					ignoreActors: 0
					illegalBits: $8000
				)
				(HandsOn)
				(if (== global131 13)
					(self cue:)
				)
			)
			(2
				(if (== global131 13)
					(if local7
						(localproc_0 22 98) ; "Gee, Sonny." Keith says. "I thought we were finished here."
						(localproc_0 22 99) ; "I'll just kick back in the car for a while if you have some business to take care of."
						(SetFlag 142)
					else
						(local3 dispose:)
						(global112
							illegalBits: 0
							setMotion: MoveTo 250 140 self
						)
					)
				)
			)
			(3
				(global112 illegalBits: $c000 setMotion: MoveTo 260 145 self)
				(localproc_0 22 100) ; "You go ahead, Sonny. I'll stay out here and have a smoke."
			)
			(4
				(global112 setMotion: MoveTo 300 157 self)
			)
			(5
				(global112 stopUpd:)
			)
			(8
				(HandsOff)
				(gEgo stopUpd:)
				(if (== global131 13)
					(if (IsFlag 142)
						(localproc_0 22 101) ; "Keith wakes up and says "Hi, Sonny.""
						(self changeState: 12)
					else
						(localproc_0 22 102) ; "Keith yells: "Wait up, Sonny! What's the rush, anyway?""
						(self cue:)
					)
				else
					(self changeState: 12)
				)
			)
			(9
				(global112
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 250 136 self
				)
			)
			(10
				(global112 setLoop: 0)
				(self cue:)
			)
			(11
				((= local3 (Prop new:))
					view: 51
					loop: 3
					cel: 0
					posn: [local4 0] [local4 1]
					setPri: 9
					init:
					setCycle: End self
				)
			)
			(12
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setPri: 8
					setLoop: 0
					setCycle: 0
					setStep: 1 2
					setMotion: MoveTo 240 134 self
				)
			)
			(13
				(gCurRoom newRoom: global131)
			)
			(14
				(= global135 1)
				(unTrunk
					view: 51
					loop: 5
					cel: 0
					posn: 209 138
					setPri: 9
					init:
					setCycle: End self
				)
			)
			(15
				(unTrunk stopUpd:)
			)
			(16
				(= global135 0)
				(unTrunk
					view: 51
					loop: 5
					cel: 2
					posn: 209 138
					setPri: 9
					startUpd:
					setCycle: CT 0 -1 self
				)
			)
			(17
				(unTrunk dispose:)
			)
		)
	)
)

(instance stopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(if (== global131 13)
					(global112 stopUpd:)
				)
			)
			(1
				(= global132 1)
				(local2 stopUpd: addToPic:)
			)
		)
	)
)

