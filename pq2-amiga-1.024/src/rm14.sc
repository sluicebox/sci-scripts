;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm14 0
)

(local
	local0
	local1
	local2
	local3
	[local4 4]
	local8
	local9
	local10
	[local11 2]
	local13
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(procedure (localproc_1)
	(cond
		((and (!= global169 0) (gEgo inRect: 240 180 287 192))
			(if (>= global169 2)
				(localproc_0 14 63) ; "You open the car door and look inside."
				(= gPerspective 0)
				(gCurRoom newRoom: 104)
			else
				(Print 14 73) ; "Opening another car's door without probable cause would be breaking and entering."
			)
		)
		((and (!= global169 0) (gEgo inRect: 223 156 291 190))
			(if (>= global169 2)
				(localproc_0 14 64) ; "The driver's door appears to be jammed shut. The passenger door might work."
			else
				(Print 14 73) ; "Opening another car's door without probable cause would be breaking and entering."
			)
		)
		(else
			(switch global131
				(13
					(cond
						(
							(not
								(gEgo
									inRect:
										[local4 0]
										[local4 1]
										[local4 2]
										[local4 3]
								)
							)
							(localproc_0 14 74) ; "You're not close enough to your car door."
						)
						(global133
							(localproc_0 14 75) ; "Your car door is locked"
						)
						(global135
							(localproc_0 14 76) ; "Close the trunk first."
						)
						((gEgo has: 10) ; field_kit
							(localproc_0 14 77) ; "You should put your field kit in the trunk first."
						)
						(else
							(= global131 13)
							(carScript changeState: 4)
						)
					)
				)
				(33
					(cond
						(
							(not
								(gEgo
									inRect:
										[local4 0]
										[local4 1]
										[local4 2]
										[local4 3]
								)
							)
							(localproc_0 14 74) ; "You're not close enough to your car door."
						)
						((== global136 1)
							(localproc_0 14 75) ; "Your car door is locked"
						)
						(else
							(carScript changeState: 4)
						)
					)
				)
			)
		)
	)
)

(instance ourCarBlock of Blk
	(properties
		top 133
		left 162
		bottom 143
		right 256
	)
)

(instance nose of Act
	(properties)
)

(instance tail of Act
	(properties)
)

(instance plane of Act
	(properties)
)

(instance lax of View
	(properties)
)

(instance door of View
	(properties)
)

(instance SIGN of View
	(properties)
)

(instance bench of View
	(properties)
)

(instance smallGuy4 of View
	(properties)
)

(instance smallGuy5 of View
	(properties)
)

(instance windSock of Prop
	(properties)
)

(instance littleCarParked of View
	(properties)
)

(instance smallGuy1 of Act
	(properties)
)

(instance smallGuy2 of Act
	(properties)
)

(instance smallGuy3 of Act
	(properties)
)

(instance ourCar of Act
	(properties)
)

(instance carDoor of Prop
	(properties)
)

(instance unTrunk of Prop
	(properties)
)

(instance rm14 of Rm
	(properties
		picture 14
		style 1
	)

	(method (dispose)
		(ourCarBlock dispose:)
		(carScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= gPerspective 70)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 74)
		(Load rsVIEW 75)
		(Load rsVIEW 54)
		(Load rsVIEW 51)
		(= global211 1)
		(= global212 3)
		(self setLocales: 153)
		(= local0 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13)))
		(if (== gPrevRoomNum 33)
			(ClearFlag 40)
		)
		(= local10
			(if
				(and
					(> global169 0)
					(!= gPrevRoomNum 13)
					(!= gPrevRoomNum 104)
					(== global131 13)
				)
				(IsFlag 118)
			)
		)
		(= local13 global169)
		(if (or (>= global100 8) local10)
			(= global169 0)
		)
		(if local0
			(HandsOff)
		else
			(HandsOn)
		)
		(if (!= global169 0)
			((View new:)
				view: 94
				loop: 1
				cel: 0
				posn: 248 186
				init:
				stopUpd:
				addToPic:
			)
		)
		(if local0
			(= global135 0)
		else
			(gEgo observeBlocks: ourCarBlock)
			(if (and global135 (== global131 13))
				(unTrunk view: 51 loop: 5 cel: 2 setPri: 10 posn: 178 144 init:)
			)
		)
		(windSock
			view: 74
			setLoop: 7
			posn: 174 43
			cycleSpeed: 3
			setCycle: Fwd
			setPri: 6
			init:
			setScript: backScript
		)
		(if (and (or (== global100 6) (== global100 7)) (!= gPrevRoomNum 15))
			(ClearFlag 40)
			(= global111 1)
		else
			(= global111 0)
		)
		(= [local4 1] 128)
		(= [local4 3] 136)
		(switch global131
			(33
				(ourCarBlock left: 180)
				(= [local4 0] 176)
				(= [local4 2] 213)
			)
			(13
				(= [local4 0] 200)
				(= [local4 2] 215)
			)
		)
		(= local8 340)
		(= local2 198)
		(= local3 216)
		(= local9 15)
		((View new:)
			view: 75
			loop: 1
			cel: 2
			posn: 32 141
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 54
			loop: 0
			cel: 4
			posn: 14 186
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 75
			loop: 2
			cel: 0
			posn: 233 162
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 54
			loop: 1
			cel: 2
			posn: 308 126
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 75
			loop: 2
			cel: 1
			posn: 323 141
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 75
			loop: 2
			cel: 2
			posn: 341 162
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 54
			loop: 0
			cel: 0
			posn: 357 184
			init:
			stopUpd:
			addToPic:
		)
		(= local1
			(if (== global130 gCurRoomNum)
				(or (== gPrevRoomNum 33) (== gPrevRoomNum 13))
			)
		)
		(if local0
			(= global132 1)
		)
		(ourCar
			view: 54
			setStep: 2
			setLoop: 1
			setCel: (if (== global131 13) 1 else 5)
			setCycle: 0
			posn:
				(if (and (or (== gPrevRoomNum 13) (== gPrevRoomNum 33)) (not local1))
					local2
				else
					local3
				)
				140
			illegalBits: 0
			ignoreActors:
			init:
		)
		(self setScript: rm14Script)
	)
)

(instance rm14Script of Script
	(properties)

	(method (doit)
		(cond
			((<= (gEgo y:) 116)
				(if (and (== global131 13) (> (global112 x:) 8))
					(switch global169
						(1
							(localproc_0 14 0) ; "If you're going to check the airport," Keith says to you, "I'll stay here and see what I can find."
						)
						(2
							(if (not (IsFlag 119))
								(localproc_0 14 1) ; ""I'll let dispatch know we've located the car, and have them send a tow truck," suggests Keith."
								(SetFlag 119)
							)
						)
					)
				)
				(cond
					((< (gEgo x:) 58)
						(= global108 -10)
					)
					((> (gEgo x:) 161)
						(= global108 327)
					)
					(else
						(= global108 (gEgo x:))
					)
				)
				(= gPerspective 0)
				(gCurRoom newRoom: local9)
			)
			((and (== global132 local0 1) (not (gCast contains: ourCar)))
				(= global132 0)
				(carScript changeState: 0)
			)
			((== global132 (not local0) 1)
				(= global132 0)
				(localproc_1)
			)
			((and (or (< (gEgo x:) -12) (> (gEgo x:) 332)) (not local0))
				(if (and (gCast contains: global112) (< (global112 x:) 10))
					(localproc_0 14 2) ; "You seem to have lost track of Keith, somehow."
				else
					(localproc_0 14 3) ; "You don't want to get lost in a sea of cars."
				)
				(gEgo setMotion: MoveTo 125 (gEgo y:))
			)
			((and (> (gEgo y:) 240) (not local0))
				(switch (Random 0 3)
					(0
						(localproc_0 14 4) ; "You can't seem to find any clues in this area."
					)
					(1
						(localproc_0 14 5) ; "Finding yourself lost in a sea of cars, you decide to make your way back...if you can!?"
					)
					(2
						(localproc_0 14 6) ; "We're about to file a missing person's report on you!"
					)
					(3
						(localproc_0 14 7) ; "Are you having fun? Send a post card - we miss you."
					)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 150)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: (if global204 6 else 0) init: setMotion: 0)
				(switch gPrevRoomNum
					(104
						(gEgo posn: 260 188 loop: 3)
						(= global169 2)
					)
					(15
						(gEgo posn: (+ (/ global108 3) 57) 124)
					)
					(13
						(gEgo posn: local8 239)
					)
					(33
						(gEgo posn: local8 239)
					)
				)
				(if (== global131 13)
					((= global112 (Act new:))
						view: 20
						posn: (- 38 (gEgo x:)) (gEgo y:)
						setCycle: Walk
						observeBlocks: ourCarBlock
						init:
					)
					(switch gPrevRoomNum
						(104
							(global112
								posn: 224 190
								setMotion: Follow gEgo 34
								setAvoider: (Avoid new:)
							)
						)
						(local9
							(cond
								((IsFlag 40)
									(global112
										posn:
											(- (gEgo x:) 32)
											(- (gEgo y:) 8)
										loop: 2
										setMotion: Follow gEgo 500
										setAvoider: (Avoid new:)
									)
								)
								((and (not (IsFlag 118)) (== global169 1))
									(global112 posn: -14 128)
								)
								(else
									(global112
										posn: 153 142
										loop: 3
										startUpd:
										setMotion: Follow gEgo 500
									)
								)
							)
						)
					)
				)
				(= global130 gCurRoomNum)
				(ourCar setMotion: MoveTo local3 140 self)
			)
			(1
				(ourCar ignoreActors: 0 addToPic:)
				(= cycles 1)
			)
			(2
				(if (== global131 13)
					(switch gPrevRoomNum
						(104
							(localproc_0 14 8 83) ; "Enthusiastically, Keith says "Yep, Sonny! We'll get that *#!*? Bains now!""
						)
						(local9
							(if (IsFlag 40)
								(localproc_0 14 9 83) ; "Keith suggests, "Sonny, we'd better get going!""
							else
								(switch local13
									(0
										(localproc_0 14 10 83) ; "Keith says, "Well, let's do something, Sonny.""
									)
									(1
										(if local10
											(localproc_0 14 11 83) ; "Keith snorts; "While you were wasting time in the airport, I located that car stolen from the shopping center.""
											(localproc_0 14 12) ; "Continuing, Keith says..."The tow truck has already come and towed it away.""
										else
											(localproc_0 14 13) ; "Keith must still be wandering around the parking lot looking for Bains' car."
										)
									)
									(2
										(if (not (IsFlag 118))
											(localproc_0 14 14) ; "Go on ahead," Keith says. "I'll take care of business here."
										else
											(localproc_0 14 15) ; "While you were gone, I had dispatch send a tow truck. It's already taken the stolen car away."
										)
									)
									(3
										(if (IsFlag 118)
											(localproc_0 14 16 83) ; ""While you were gone, they came and towed the stolen car away," Keith informs you."
										else
											(localproc_0 14 14) ; "Go on ahead," Keith says. "I'll take care of business here."
										)
									)
									(else
										(localproc_0 14 17 83) ; "Well it's about time you got back," Keith grunts. "Let's roll!"
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'close/door')
						(localproc_0 14 18) ; "All the doors here are closed."
					)
					(
						(or
							(Said 'enter/auto')
							(Said 'open/auto,door')
							(Said 'get,look<in,in[/auto]')
						)
						(localproc_1)
					)
					((or (Said 'look>') (Said 'check[<out]>'))
						(cond
							((Said '/trunk')
								(if
									(and
										(gEgo inRect: 146 132 172 142)
										(gCast contains: unTrunk)
									)
									(gInventory
										carrying: {The car's trunk contains }
										empty: {The car's trunk is empty.}
										showSelf: 13
									)
								else
									(localproc_0 14 19) ; "You're not close enough to an open trunk."
								)
							)
							((Said '/building,airport,terminal')
								(localproc_0 14 20) ; "You are just outside the new Lytton Airport. The hustle and bustle makes LAX look small-time."
							)
							((Said '/entrance')
								(localproc_0 14 21) ; "A short distance away you see the entrance to the airport."
							)
							((Said '/lot')
								(localproc_0 14 22) ; "You see a variety of automobiles parked in the lot."
							)
							((Said '[<at,around][/!*,chamber]')
								(localproc_0 14 23) ; "Looking around, you become alerted to the fact that you're standing in the parking lot of "Lytton Municipal Airport.""
							)
							((Said '/tower')
								(localproc_0 14 24) ; "In the tower, the air traffic controllers are busy directing airline traffic."
							)
							((Said '/sock,wind')
								(localproc_0 14 25) ; "The wind sock blows in the direction of the wind."
							)
							((Said '/airplane[<air]')
								(localproc_0 14 26) ; "You're definitely in the right place if you like to look at airplanes."
							)
							((or (Said '/air') (Said '<up'))
								(localproc_0 14 27) ; "You see blue sky with patchy clouds. Several planes circle, waiting to land."
							)
							((Said '/cloud')
								(localproc_0 14 28) ; "They're up there. all right!"
							)
							((Said '/man,woman,men,women,crowd')
								(localproc_0 14 29) ; "They're across the street, in front of the terminal."
							)
							((Said '/vin,badge')
								(localproc_0 14 30) ; "Vehicle identification numbers are usually found inside the vehicle."
							)
							((Said '<below/auto')
								(localproc_0 14 31) ; "You hate to get your clean pants greasy."
							)
							((or (Said '/dirt') (Said '<down,ave,bridge'))
								(localproc_0 14 32) ; "Nothing but pavement."
							)
							((Said '/auto')
								(if (!= global169 0)
									(cond
										((not (IsFlag 77))
											(cond
												(
													(gEgo
														inRect: 130 163 315 200
													)
													(localproc_0 14 33) ; "The black car appears to match the description of the stolen car."
													(= global169 2)
												)
												((== global169 2)
													(localproc_0 14 34) ; "Just another car."
												)
												(else
													(localproc_0 14 35) ; "So far, you don't see a car that matches the description of the stolen car."
												)
											)
										)
										((gEgo inRect: 130 163 315 200)
											(localproc_0 14 36) ; "You have identified the black car as the stolen car."
										)
										(else
											(localproc_0 14 34) ; "Just another car."
										)
									)
								else
									(localproc_0 14 37) ; "They're nice automobiles, all right."
								)
							)
							((Said '/license')
								(if (!= global169 0)
									(cond
										((gEgo inRect: 162 163 208 189)
											(localproc_0 14 38) ; "The black car's rear plate is missing."
										)
										((gEgo inRect: 295 159 322 190)
											(localproc_0 14 39) ; "As you look at black car's license plate number, "C035609", you think to yourself..."Man, this one rings a bell.""
											(= global169 2)
											(SetScore 1 77)
											(if
												(and
													(== global131 13)
													(gCast
														contains: global112
													)
													(< (global112 x:) 50)
												)
												(global112
													posn: 5 164
													setMotion: Follow gEgo 36
													setAvoider: (Avoid new:)
												)
												(localproc_0 14 40 83) ; "Hey!" Keith shouts. "That's the car! Bains has to be around here somewhere."
											)
										)
										(else
											(localproc_0 14 41) ; "From where you're standing, you see nothing out of the ordinary about the plates on the cars in the lot."
										)
									)
								else
									(localproc_0 14 42) ; "They're all from different states. None of the plate numbers or vehicles appear to offer a clue."
								)
							)
						)
					)
					((Said 'drive')
						(if local0
							(localproc_0 14 43) ; "Go on! Get out and look around first."
						else
							(localproc_0 14 44) ; "Get in your car first."
						)
					)
					((Said 'drop,place/briefcase')
						(if (gEgo inRect: 146 132 172 142)
							(if global135
								(if (gEgo has: 10) ; field_kit
									(localproc_0 14 45) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
									(if (IsObject gFKit)
										(gFKit dispose:)
									)
									(= global240 0)
								else
									(localproc_0 14 46) ; "You don't have the field kit."
								)
							else
								(localproc_0 14 47) ; "Open the trunk first."
							)
						else
							(localproc_0 14 48) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'remove,get/briefcase')
						(if (gEgo inRect: 146 132 172 142)
							(if global135
								(if (== ((gInventory at: 10) owner:) 13) ; field_kit
									(localproc_0 14 49) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(localproc_0 14 50) ; "The field kit is not in the trunk."
								)
							else
								(localproc_0 14 47) ; "Open the trunk first."
							)
						else
							(localproc_0 14 48) ; "You're not close enough to your car's trunk."
						)
					)
					((or (Said 'unlock/door,auto') (Said 'unlock/door<auto'))
						(if
							(gEgo
								inRect:
									[local4 0]
									[local4 1]
									[local4 2]
									[local4 3]
							)
							(cond
								((and (== global131 13) (gEgo has: 3)) ; unmarked_car_keys
									(if global133
										(= global133 0)
										(localproc_0 14 51) ; "OK. It's unlocked."
									else
										(localproc_0 14 52) ; "The door is already unlocked."
									)
								)
								((== global131 13)
									(localproc_0 14 53) ; "You need a key to unlock this door."
								)
							)
							(cond
								((and (== global131 33) (gEgo has: 2)) ; key_ring
									(if global136
										(= global136 0)
										(localproc_0 14 51) ; "OK. It's unlocked."
									else
										(localproc_0 14 52) ; "The door is already unlocked."
									)
								)
								((== global131 33)
									(localproc_0 14 53) ; "You need a key to unlock this door."
								)
							)
						else
							(localproc_0 14 54) ; "You're not close enough."
						)
					)
					((or (Said 'lock/door,auto') (Said 'lock/door<auto'))
						(if
							(gEgo
								inRect:
									[local4 0]
									[local4 1]
									[local4 2]
									[local4 3]
							)
							(if (== global131 13)
								(cond
									((not global133)
										(= global133 1)
										(localproc_0 14 55) ; "OK. It's locked."
									)
									((gEgo inRect: 223 156 291 190)
										(localproc_0 14 56) ; "You don't have the key."
									)
									(else
										(localproc_0 14 57) ; "The door is already locked."
									)
								)
							)
							(if (== global131 33)
								(if (not global136)
									(= global136 1)
									(localproc_0 14 55) ; "OK. It's locked."
								else
									(localproc_0 14 57) ; "The door is already locked."
								)
							)
						else
							(localproc_0 14 54) ; "You're not close enough."
						)
					)
					((Said 'open,unlock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 146 132 172 142)
								(if (gEgo has: 3) ; unmarked_car_keys
									(if global135
										(Print 14 58) ; "It's already open."
									else
										(carScript changeState: 10)
									)
								else
									(localproc_0 14 59) ; "You need a key to open this trunk."
								)
							else
								(localproc_0 14 60) ; "You'd better not open anybody else's trunk."
							)
						else
							(localproc_0 14 61) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					((Said 'close,lock/trunk')
						(if (== global131 13)
							(if (gEgo inRect: 146 132 172 142)
								(if global135
									(carScript changeState: 12)
								else
									(Print 14 62) ; "It's already closed."
								)
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(localproc_0 14 61) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
						)
					)
					((or (Said 'frisk/auto') (Said 'check[<out]/auto'))
						(cond
							(
								(and
									(!= global169 0)
									(gEgo inRect: 240 180 287 192)
								)
								(localproc_0 14 63 25 4) ; "You open the car door and look inside."
								(= gPerspective 0)
								(gCurRoom newRoom: 104)
							)
							(
								(and
									(!= global169 0)
									(gEgo inRect: 223 156 291 190)
								)
								(localproc_0 14 64) ; "The driver's door appears to be jammed shut. The passenger door might work."
							)
							(
								(gEgo
									inRect:
										[local4 0]
										[local4 1]
										[local4 2]
										[local4 3]
								)
								(localproc_0 14 65) ; "You begin to search frantically until you realize that you're searching your own vehicle!"
							)
							(else
								(localproc_0 14 66) ; "Without a warrant or probable cause, a vehicle search would be considered breaking and entering."
							)
						)
					)
				)
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
					posn: 206 142
					setPri: 9
					setLoop: 0
					setCycle: 0
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 203 132 self
				)
				(if (== global131 13)
					(global112 posn: 216 149 loop: 0 cel: 5 startUpd:)
					(carDoor
						view: 51
						loop: 3
						cel: 0
						posn: 230 135
						setPri: 10
						init:
						setCycle: End
					)
				)
			)
			(1
				(= local0 0)
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
					observeBlocks: ourCarBlock
				)
				(self cue:)
			)
			(2
				(HandsOn)
				(if (== global131 13)
					(carDoor dispose:)
					(if (== global169 1)
						(global112 setMotion: MoveTo -14 149)
						(localproc_0 14 67 25 7) ; "Keith says..."Let's check out the parking lot, Sonny.""
						(localproc_0 14 68 83 25 5) ; "I'll look over here."
					else
						(global112 setMotion: MoveTo 160 146 self)
					)
				)
			)
			(3
				(global112 cel: 0)
				(cond
					((and local1 (== global169 3))
						(localproc_0 14 69) ; "Why don't you go check out the terminal building? I'll wait here for the tow truck."
					)
					((== global100 13)
						(localproc_0 14 70) ; "Keith whines, "I forgot to pack my toothbrush!""
					)
					((not local1)
						(localproc_0 14 71) ; "Keith asks, "What are we doing here, anyway?""
					)
				)
			)
			(4
				(HandsOff)
				(if (== global131 13)
					(localproc_0 14 72) ; "Keith yells: "Hey, wait for me, Sonny!""
					(if (< (global112 y:) 134)
						(global112
							setAvoider: 0
							ignoreActors:
							illegalBits: 0
							setMotion: MoveTo 145 128 self
						)
					else
						(self cue:)
					)
				else
					(self changeState: 8)
				)
			)
			(5
				(global112
					setMotion:
						MoveTo
						(if (< (global112 x:) 145)
							145
						else
							(global112 x:)
						)
						145
						self
				)
			)
			(6
				(global112 setMotion: MoveTo 216 146 self)
			)
			(7
				(carDoor
					view: 51
					loop: 3
					cel: 0
					posn: 230 135
					setPri: 10
					init:
					setCycle: End self
				)
			)
			(8
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					ignoreBlocks: ourCarBlock
					setPri: 9
					setLoop: 0
					setCycle: 0
					setStep: 1 2
					setMotion: MoveTo 206 144 self
				)
			)
			(9
				(= gPerspective 0)
				(gCurRoom newRoom: global131)
			)
			(10
				(= global135 1)
				(unTrunk
					view: 51
					loop: 5
					cel: 0
					posn: 178 144
					setPri: 10
					init:
					setCycle: End self
				)
			)
			(11
				(unTrunk stopUpd:)
			)
			(12
				(= global135 0)
				(unTrunk
					view: 51
					loop: 5
					cel: 2
					posn: 178 144
					startUpd:
					setCycle: CT 0 -1 self
				)
			)
			(13
				(unTrunk dispose:)
			)
		)
	)
)

(instance backScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lax
					view: 75
					loop: 0
					cel: 0
					posn: 98 69
					setPri: 6
					init:
					addToPic:
				)
				(door view: 75 loop: 3 posn: 99 96 init: addToPic:)
				(SIGN
					view: 74
					loop: 0
					cel: 5
					posn: 140 98
					setPri: 7
					init:
					addToPic:
				)
				(bench
					view: 74
					loop: 0
					cel: 4
					posn: 127 98
					setPri: 7
					init:
					addToPic:
				)
				(littleCarParked
					view: 75
					loop: 4
					cel: 0
					posn: 63 104
					setPri: 7
					init:
					addToPic:
				)
				(smallGuy4
					view: 74
					loop: 8
					cel: 0
					posn: 132 98
					setPri: 8
					init:
					stopUpd:
					addToPic:
				)
				(smallGuy5
					view: 74
					loop: 8
					cel: 1
					posn: 125 98
					setPri: 8
					init:
					stopUpd:
					addToPic:
				)
				(smallGuy1
					view: 74
					posn: 210 98
					setLoop: 1
					setStep: 1
					setCycle: Walk
					setMotion: MoveTo 324 98
					ignoreActors:
					illegalBits: 0
					init:
				)
				(smallGuy3
					view: 74
					posn: 40 96
					setLoop: 5
					cel: 3
					setStep: 1
					setCycle: Walk
					ignoreActors:
					illegalBits: 0
					init:
					stopUpd:
				)
				(if (< global110 30)
					(smallGuy1 stopUpd:)
					(smallGuy2 stopUpd:)
					(smallGuy3 stopUpd:)
					(windSock stopUpd:)
					(client setScript: 0)
					(return)
				)
				(plane
					view: 74
					posn: 226 36
					setLoop: 0
					setCel: 0
					setPri: 1
					init:
					setCycle: 0
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 330 40 self
				)
			)
			(1
				(plane stopUpd:)
				(smallGuy1 setLoop: 2 setMotion: MoveTo 180 99)
				(smallGuy2
					view: 74
					posn: 324 99
					setLoop: 4
					xStep: 1
					setCycle: Walk
					setMotion: MoveTo 185 100
					ignoreActors:
					illegalBits: 0
					init:
				)
				(= cycles 80)
			)
			(2
				(plane
					setCel: 1
					posn: 335 20
					setMotion: MoveTo 90 70 self
					init:
					startUpd:
				)
				(smallGuy1 stopUpd:)
			)
			(3
				(= cycles 80)
				(smallGuy1 startUpd:)
				(plane stopUpd:)
			)
			(4
				(nose
					view: 74
					posn: 160 77
					setLoop: 0
					setCel: 3
					setPri: 4
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: 0
					setMotion: MoveTo 200 77
				)
				(tail
					view: 74
					setLoop: 0
					setCel: 2
					posn: -25 47
					setPri: 1
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: 0
					setMotion: MoveTo 15 47 self
				)
			)
			(5
				(tail addToPic:)
				(nose addToPic:)
				(smallGuy3 startUpd: setMotion: MoveTo 168 96 init:)
				(smallGuy1 startUpd: setLoop: 2 setMotion: MoveTo 175 99 init:)
				(smallGuy2 startUpd: setLoop: 4 setMotion: MoveTo 182 98)
			)
		)
	)
)

