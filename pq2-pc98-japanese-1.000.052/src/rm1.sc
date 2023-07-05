;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use AutoDoor)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm1 0
)

(synonyms
	(door japanesedoor)
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
)

(procedure (localproc_0)
	(cond
		((gEgo inRect: 93 144 114 154)
			(cond
				((== global133 1)
					(Print 1 78) ; "Your car door is locked."
				)
				(global135
					(Print 1 79) ; "Close the trunk first."
				)
				((gEgo has: 10) ; field_kit
					(Print 1 80) ; "You should put your field kit in the trunk first."
				)
				(else
					(= global131 13)
					(rm1 setScript: enterScript)
				)
			)
		)
		((gEgo inRect: 259 140 279 148)
			(if (== global136 1)
				(Print 1 81) ; "Your car door is locked"
			else
				(= global131 33)
				(rm1 setScript: enterScript)
			)
		)
		(else
			(proc0_7) ; "You're not close enough."
		)
	)
)

(instance carDoor of Prop
	(properties)
)

(instance unTrunk of Prop
	(properties)
)

(instance flag of Prop
	(properties)
)

(instance egosCar of View
	(properties)
)

(instance unmarked of View
	(properties)
)

(instance ourCar of Act
	(properties)
)

(instance car1Block of Blk
	(properties
		top 131
		left 54
		bottom 147
		right 165
	)
)

(instance car2Block of Blk
	(properties
		top 151
		left 46
		bottom 161
		right 129
	)
)

(instance car3Block of Blk
	(properties
		top 169
		left 29
		bottom 184
		right 117
	)
)

(instance car4Block of Blk
	(properties
		top 133
		left 216
		bottom 139
		right 288
	)
)

(instance car6Block of Blk
	(properties
		top 172
		left 228
		bottom 181
		right 316
	)
)

(instance rm1 of Rm
	(properties
		picture 1
		style 6
	)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(cond
			((gEgo inRect: 11 122 18 126)
				(Print 1 0) ; "The entrance to the station is the other way."
				(gEgo setMotion: MoveTo 38 124)
			)
			((and (< 188 (gEgo y:)) (>= 91 (gEgo x:)))
				(gEgo x: 91)
			)
			((and (< 189 (gEgo y:)) (<= 235 (gEgo x:)))
				(gEgo x: 235)
			)
			((== (local1 doorState:) 2)
				(gCurRoom newRoom: 2)
			)
			((and (== global158 450) (== global100 0) (not (gEgo has: 2))) ; key_ring
				(Print 1 1) ; "Feeling rather foolish, you think to yourself: "Now, where could my keys be? I just had them a few minutes ago in my car.""
				(= global158 700)
			)
		)
		(cond
			((and (<= 220 (gEgo y:)) (!= local0 1) (!= local0 2))
				(= local0 1)
				(Print 1 2) ; "You can walk 'til you drop, but you'll be late for work!"
			)
			((and (>= 210 (gEgo y:)) (== local0 1))
				(= local0 0)
				(Print 1 3) ; "So, the prodigal Sonny returns. Glad to see you came back before something terrible happened."
			)
			((and (<= 255 (gEgo y:)) (!= local0 2))
				(= local0 2)
				(Print 1 4) ; "SCREEEEEECH....."
				(= local10 (Print 1 5 --UNKNOWN-PROPERTY--)) ; "T*H*U*M*P!!!"
				(ShakeScreen 15)
				(clr)
				(gEgo dispose:)
				(Print 1 6) ; "No one will ever know why, upon arriving for work one day, Detective Sonny Bonds decided to take a walk down the center line of Lytton's busiest street."
				(EgoDead 1 7)
			)
			((== global132 local5 1)
				(if (not (gCast contains: ourCar))
					(= global132 0)
					(self setScript: exitScript)
				)
			)
			((== global132 (not local5) 1)
				(= global132 0)
				(localproc_0)
			)
		)
		(super doit:)
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 8)
		(Load rsVIEW 51)
		(Load rsVIEW 55)
		(Load rsVIEW 20)
		(Load rsVIEW 54)
		(super init:)
		(self setLocales: 153)
		(= global212 2)
		(User canInput: 1 canControl: 1)
		(gEgo view: (if (not global204) 0 else 6) posn: -100 0 init:)
		(if (== global100 7)
			(= global133 1)
		)
		((= global112 (Act new:))
			view: 20
			posn: -50 0
			setCycle: Walk
			setAvoider: (Avoid new:)
			init:
			stopUpd:
		)
		((= local1 (AutoDoor new:))
			entranceTo: 2
			facingLoop: -1
			locked: 1
			stopUpd:
			view: 8
			posn: 132 100
			init:
		)
		(flag view: 55 posn: 172 14 cycleSpeed: 2 setCycle: Fwd init:)
		(flag stopUpd:)
		(if global135
			(unTrunk
				view: 51
				loop: 4
				cel: 2
				posn: 148 148
				setPri: 10
				ignoreActors:
				init:
			)
		)
		(if (= local5 (or (== gPrevRoomNum 33) (== gPrevRoomNum 13) (== global160 0)))
			(HandsOff)
		else
			(HandsOn)
		)
		(= global132
			(if (= local6 (and (== global130 gCurRoomNum) (!= gPrevRoomNum 2))) local5)
		)
		(= local7 (if (== global131 13) 118 else 247))
		(= local8 (if (== global131 13) 110 else 257))
		(= local9 (if (== global131 13) 144 else 141))
		(if (or (== gPrevRoomNum 2) (== global131 33))
			(unmarked
				view: 54
				loop: 0
				setCel: 1
				posn: 110 144
				setPri: 10
				init:
				ignoreActors:
				addToPic:
			)
			(gEgo observeBlocks: car1Block)
		)
		(if (== (Random 0 3) 1)
			((View new:)
				view: 54
				loop: 0
				setCel: 4
				posn: 89 162
				setPri: 12
				init:
				ignoreActors:
				addToPic:
			)
			(= local3 1)
			(gEgo observeBlocks: car2Block)
		)
		(if (IsFlag 10)
			((View new:)
				view: 54
				loop: 0
				setCel: 3
				posn: 64 180
				setPri: 14
				init:
				ignoreActors:
				addToPic:
			)
			(gEgo observeBlocks: car3Block)
		)
		(if (or (== gPrevRoomNum 2) (== global131 13))
			(egosCar
				view: 54
				loop: 0
				cel: 0
				posn: 257 141
				ignoreActors:
				init:
				addToPic:
			)
			(gEgo observeBlocks: car4Block)
		)
		(if (!= (Random 0 3) 1)
			((View new:)
				view: 54
				loop: 1
				cel: 2
				posn: 278 182
				init:
				ignoreActors:
				addToPic:
			)
			(gEgo observeBlocks: car6Block)
			(= local2 1)
		)
		(= global130 gCurRoomNum)
		(if (!= gPrevRoomNum 2)
			(= local5 1)
			(ourCar
				view: 54
				setStep: 2
				setLoop: 0
				setCel: (if (== global131 13) 1 else 0)
				ignoreActors:
				illegalBits: 0
				setCycle: 0
				setMotion: 0
				posn: (if local6 local8 else local7) local9
				init:
			)
		else
			(= local5 0)
		)
		(if (== gPrevRoomNum 2)
			(gEgo posn: 131 110 setMotion: MoveTo 131 400)
		else
			(self setScript: driveUpScript)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(
						(or
							(Said 'japaneseopen/cloth')
							(Said 'get<[off]/cloth<[off]')
							(Said 'undress')
							(Said 'get/naked')
							(Said 'leak')
							(Said 'get/leak')
						)
						(Print 1 8) ; "In the POLICE PARKING LOT!? That may be a bad idea. I suggest you think this over! Perhaps the police psychiatrist could help."
					)
					((Said 'drive')
						(if local5
							(Print 1 9) ; "Go on! Get out and look around first."
						else
							(Print 1 10) ; "Get in your car first."
						)
					)
					((Said 'drop,japaneseput,location,drop/briefcase')
						(if (gEgo inRect: 151 129 182 148)
							(if global135
								(if (gEgo has: 10) ; field_kit
									(Print 1 11) ; "You place your field kit inside the trunk."
									(PutItem 10 13) ; field_kit
									(if (IsObject gFKit)
										(gFKit dispose:)
									)
									(= global240 0)
								else
									(Print 1 12) ; "You don't have the field kit."
								)
							else
								(Print 1 13) ; "Open the trunk, first."
							)
						else
							(Print 1 14) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'japaneseopen,get,unload/briefcase')
						(if (gEgo inRect: 151 129 182 148)
							(if global135
								(if (== ((gInventory at: 10) owner:) 13) ; field_kit
									(Print 1 15) ; "You take your field kit from the trunk."
									(gEgo get: 10) ; field_kit
								else
									(Print 1 16) ; "The field kit is not in the trunk."
								)
							else
								(Print 1 13) ; "Open the trunk, first."
							)
						else
							(Print 1 14) ; "You're not close enough to your car's trunk."
						)
					)
					((Said 'enter[/auto]')
						(localproc_0)
					)
					(
						(or
							(Said 'exit,japaneseclimbdown[/auto]')
							(Said '(get<out),exit')
						)
						(if (== local5 1)
							(= global132 1)
						else
							(Print 1 17) ; "You're not in anything you can exit."
						)
					)
					((or (Said 'enter,open[/door,door]') (Said 'get<in'))
						(cond
							(local5
								(= global132 1)
							)
							((gEgo inRect: 126 102 150 106)
								(if (not (gEgo has: 2)) ; key_ring
									(Print 1 18) ; "This door is kept locked for security reasons."
								else
									(Print 1 19) ; "You unlock and open the door."
									(local1 locked: 0)
								)
							)
							((gEgo inRect: 93 144 114 154)
								(if (not global133)
									(localproc_0)
								else
									(Print 1 20) ; "The door is locked."
								)
							)
							((gEgo inRect: 259 140 279 148)
								(if (not global136)
									(localproc_0)
								else
									(Print 1 20) ; "The door is locked."
								)
								(if (> (gEgo y:) 120)
									(if
										(or
											(gEgo inRect: 73 149 128 188)
											(gEgo inRect: 205 154 313 185)
										)
										(Print 1 21) ; "You're not close enough to your car door."
									)
								else
									(Print 1 22) ; "You're not close enough to the station's door."
								)
							)
							(else
								(proc0_7) ; "You're not close enough."
							)
						)
					)
					(
						(or
							(Said 'unlock,japaneseopen[/door,auto]')
							(Said 'use/key')
							(Said 'open/key')
						)
						(cond
							((gEgo inRect: 126 102 150 106)
								(if (not (gEgo has: 2)) ; key_ring
									(Print 1 23) ; "You need the correct key."
								else
									(Print 1 24 #at -1 45) ; "You unlock and open the door."
									(local1 locked: 0)
								)
							)
							((gEgo inRect: 93 144 114 154)
								(if (gEgo has: 3) ; unmarked_car_keys
									(if (== global133 1)
										(= global133 0)
										(Print 1 25) ; "OK. It's unlocked."
									else
										(Print 1 26) ; "The door is already unlocked."
									)
								else
									(Print 1 23) ; "You need the correct key."
								)
							)
							((gEgo inRect: 259 140 279 148)
								(if (gEgo has: 2) ; key_ring
									(if (== global136 1)
										(= global136 0)
										(Print 1 25) ; "OK. It's unlocked."
									else
										(Print 1 26) ; "The door is already unlocked."
									)
								else
									(Print 1 23) ; "You need the correct key."
								)
							)
							((gEgo inRect: 75 112 288 134)
								(Print 1 27) ; "This is the passenger's door. Try the other side."
							)
							(
								(or
									(and
										(gEgo inRect: 73 149 128 188)
										(or (IsFlag 10) local3)
									)
									(and
										(gEgo inRect: 205 154 313 185)
										local2
									)
								)
								(Print 1 28) ; "You shouldn't be opening that car door."
							)
							((> (gEgo y:) 120)
								(Print 1 29) ; "You're not close enough to your car's door."
							)
							(else
								(Print 1 30) ; "You're not close enough to the station's door."
							)
						)
					)
					((Said 'lock[/door,door,auto]')
						(cond
							((gEgo inRect: 126 102 150 106)
								(Print 1 31) ; "The Police Station's door automatically locks as it closes."
							)
							((gEgo inRect: 93 144 114 154)
								(if (== global133 0)
									(= global133 1)
									(Print 1 32) ; "OK. It's locked."
								else
									(Print 1 33) ; "The door is already locked."
								)
							)
							((gEgo inRect: 259 140 279 148)
								(if (== global136 0)
									(if (gEgo has: 2) ; key_ring
										(= global136 1)
										(Print 1 32) ; "OK. It's locked."
									else
										(Print 1 23) ; "You need the correct key."
									)
								else
									(Print 1 33) ; "The door is already locked."
								)
							)
							(else
								(proc0_7) ; "You're not close enough."
							)
						)
					)
					((Said 'open,japaneseopen,unlock/trunk')
						(cond
							((gEgo inRect: 151 129 182 148)
								(cond
									(global135
										(Print 1 34) ; "The trunk is already open."
									)
									((gEgo has: 3) ; unmarked_car_keys
										(= global135 1)
										(unTrunk
											view: 51
											loop: 4
											cel: 0
											posn: 148 148
											setPri: 10
											ignoreActors:
											init:
											setCycle: End
										)
									)
									(else
										(Print 1 23) ; "You need the correct key."
									)
								)
							)
							((gEgo inRect: 264 120 320 145)
								(Print 1 35) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
							)
							(else
								(Print 1 36) ; "You're not close enough to your own trunk, and you shouldn't mess around with anyone else's trunk."
							)
						)
					)
					((Said 'close,lock/trunk')
						(cond
							((gEgo inRect: 151 129 182 148)
								(if global135
									(self setScript: trunkScript)
									(= global135 0)
								else
									(Print 1 37) ; "The trunk is already closed"
								)
							)
							((gEgo inRect: 264 120 320 145)
								(Print 1 35) ; "Your car's "hatch-back" hasn't worked since its warranty expired."
							)
							(else
								(Print 1 38) ; "You'd better not mess around with anyone else's trunk."
							)
						)
					)
					((Said 'open,japaneseopen/hood')
						(if (!= global138 1)
							(Print 1 39) ; "You're not a mechanic, Sonny. You're a police detective with work to do."
						else
							(Print 1 40) ; "You have better things to do with your leisure time."
						)
					)
					((Said 'look,read/sign,letter,word')
						(Print 1 41) ; "The big letters say: 'LYTTON POLICE'. Above the door are the words: 'Detective Division'"
					)
					((Said 'japaneselookup')
						(Print 1 42) ; "You look at the sky and think, "What a beautiful day!""
					)
					((Said 'look,japaneselookdown,frisk>')
						(cond
							((and (not global160) (Said '/wrist,clock'))
								(Print 1 43) ; "Mickey's little hand is on Minnie's...uh.. Anyway, it's 7:29 on a fine spring morning."
							)
							((Said '/tire,tire')
								(Print 1 44) ; "You think to yourself..."Hmmm! This side looks OK!""
							)
							((Said '/auto<japanesemask')
								(Print 1 45) ; "There is nothing special about these unmarked cars. They're just painted-over, worn-out, old cruisers!"
							)
							((Said '/auto<blue')
								(Print 1 46) ; "The dark blue sedan is an unmarked police cruiser, assigned to you and your partner, Keith."
							)
							((Said '/auto,cruiser<red')
								(if local2
									(Print 1 47) ; "Nothing special. It's just another unmarked police cruiser."
								)
							)
							((Said '/auto,cruiser<patrol,police,marked')
								(if (IsFlag 10)
									(Print 1 48) ; "This cruiser has everything, including the latest in emission systems. It is capable of a blinding downhill speed of 100+ mph."
								else
									(Print 1 49) ; "There are no marked police cruisers here."
								)
							)
							((Said '<in/auto')
								(Print 1 50) ; "Looking into the car, you see nothing out of the ordinary."
							)
							((or (Said '/lot') (Said '/auto'))
								(Print 1 51) ; "Parked in the lot are unmarked cars, private cars, and sometimes a marked police cruiser."
							)
							((Said '/trunk<tree')
								(Print 1 52) ; "You're barking up the wrong tree trunk."
							)
							((Said '/trunk')
								(if
									(and
										(gEgo inRect: 151 129 182 148)
										(gCast contains: unTrunk)
									)
									(gInventory
										carrying:
											{The car's trunk contains:}
										empty:
											{The car's trunk is empty.}
										showSelf: 13
									)
								else
									(Print 1 53) ; "You have to open it first."
								)
							)
							(
								(or
									(Said 'japaneselookback')
									(Said '[<at,down,below][/dirt]')
								)
								(Print 1 54) ; "The parking lot has been freshly paved and painted."
							)
							((Said '[<at,up][/air,cloud]')
								(Print 1 42) ; "You look at the sky and think, "What a beautiful day!""
							)
							((Said '/ave')
								(Print 1 55) ; "You gaze out at Sixth Street; one of Lytton's busiest."
							)
							((Said '/sidewalk')
								(if (< (gEgo y:) 142)
									(Print 1 56) ; "Somebody tried to scratch their initials in the wet cement, but you can't read them."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/stair')
								(if (< (gEgo y:) 142)
									(Print 1 57) ; "Use the steps for walking to and from the building."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/tree')
								(Print 1 58) ; "Your eyes strain as you peer into the tree and see..."
								(Print 1 59) ; "Nothing."
							)
							((Said '/bush')
								(Print 1 60) ; "You see bird droppings and cobwebs in the bushes."
							)
							((Said '/fence')
								(Print 1 61) ; "It's just a normal chain link fence, used for security."
							)
							((Said '/flag')
								(Print 1 62) ; "You pause, briefly, to gaze at the U.S. flag flying overhead."
							)
							((Said '/pane')
								(if (> 128 (gEgo y:))
									(gEgo loop: 3 setMotion: 0)
									(Print 1 63 #draw) ; "Outside reflections and mini-blinds block your view into the windows."
									(Print 1 64) ; "You become embarrassed as you realize what your fellow officers must think of you now."
								else
									(Print 1 65) ; "Nothing of importance can be seen through the car's window."
								)
							)
							((Said '/door,door')
								(if (gEgo inRect: 126 102 150 106)
									(Print 1 66) ; "This door opens into the Detective Bureau."
								else
									(Print 1 67) ; "You're not close enough to the police station's door."
								)
							)
							((Said '/japanesemiller')
								(Print 1 68) ; "Why? Your face hasn't changed since you shaved it this morning."
							)
							(
								(Said
									'[<around,at][/(!*,area,chamber,building,barn)]'
								)
								(Print 1 69) ; "You are in the parking lot of Lytton's newly remodeled police station. This is the detective's entrance."
							)
						)
					)
					((Said 'salute/flag')
						(Print 1 70) ; "Giving a quick, smart, salute, your heart swells with pride."
					)
					((Said '/hello[/!*]')
						(if (> (global112 x:) 1)
							(Print 1 71) ; "Keith responds, "Hi.""
						else
							(Print 1 72) ; "No one responds to your greeting."
						)
					)
					((Said 'climb/auto')
						(Print 1 73) ; "Negative!"
					)
					((Said 'climb')
						(Print 1 74) ; "That would look a little silly."
					)
					((Said 'sat')
						(Print 1 74) ; "That would look a little silly."
					)
					((Said 'open,japaneseopen/pane')
						(if (> 128 (gEgo y:) 122)
							(gEgo loop: 3 setMotion: 0)
							(Print 1 75 #draw) ; "It would be easier to use the door."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
				)
			)
		)
	)
)

(instance trunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(unTrunk
					view: 51
					loop: 4
					cel: 2
					posn: 148 148
					setPri: 10
					ignoreActors:
					setCycle: CT 0 -1 self
				)
			)
			(1
				(unTrunk dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== global131 13) (!= gPrevRoomNum 2))
					(global112
						setStep: 1 3
						setPri: 7
						posn: 119 142
						setLoop: 1
						setCel: 1
						illegalBits: 0
						ignoreActors: 1
						startUpd:
						setMotion: MoveTo 122 134
					)
				)
				(gEgo setPri: -1)
				(carDoor
					view: 51
					loop: (if (== global131 13) 2 else 0)
					cel: 0
					ignoreActors:
					init:
					setPri: 10
					cycleSpeed: 2
					setCycle: End self
				)
				(if (== global131 13)
					(carDoor posn: 93 139)
				else
					(carDoor posn: 261 137)
				)
			)
			(1
				(gEgo
					posn:
						(if (== global131 13) 104 else 272)
						(if (== global131 13) 145 else 142)
					loop: 1
					cel: 1
					setPri: -1
				)
				(= local5 0)
				(if (== global131 13)
					(= global133 0)
				else
					(= global136 0)
				)
				(if (== global131 13)
					(global112
						setStep: 3 1
						setCycle: Walk
						setLoop: -1
						setPri: -1
						ignoreActors: 0
						illegalBits: -32768
					)
				)
				(carDoor dispose:)
				(if (== global131 33)
					(HandsOn)
				else
					(rm1 setScript: awayScript)
				)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo stopUpd:)
				(if (== global131 13)
					(if (< (global112 y:) 90)
						(Print 1 76 #at -1 35) ; "Keith yells: "Wait up, Sonny! What's the rush, anyway?""
						(global112 ignoreActors: illegalBits: 0 posn: 131 106)
						(local1 startUpd: setCycle: Beg)
					)
					(global112 setMotion: MoveTo 131 130 self)
				else
					(self changeState: 2)
				)
			)
			(1
				(global112 setMotion: MoveTo 121 134 self)
			)
			(2
				(local1 stopUpd:)
				(gEgo setPri: 11)
				(carDoor
					view: 51
					loop: (if (== global131 13) 2 else 0)
					cel: 0
					ignoreActors:
					init:
					setPri: 10
					setCycle: End self
				)
				(if (== global131 13)
					(carDoor posn: 93 139)
				else
					(carDoor posn: 261 137)
				)
			)
			(3
				(if (== global131 13)
					(global112
						ignoreActors: 1
						illegalBits: 0
						setPri: 8
						setLoop: 1
						setCycle: 0
						setStep: 1 2
						setMotion: MoveTo 118 142 self
					)
				else
					(self cue:)
				)
			)
			(4
				(if (and (== global100 6) (== global138 1))
					(= global126 0)
					(PutItem 2 0) ; key_ring
					(gCurRoom newRoom: 105)
				else
					(gCurRoom newRoom: global131)
				)
			)
		)
	)
)

(instance driveUpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: -100 0)
				(User canControl: 0)
				(if (== global131 13)
					(= global135 0)
				)
				(ourCar setMotion: MoveTo local8 local9 self)
			)
			(1
				(= global132 1)
				(User canControl: 1)
				(if global160
					(ourCar addToPic:)
					(gEgo observeBlocks: car1Block car4Block)
					(if local6
						(= global132 1)
					)
				else
					(= global160 1)
					(gCurRoom newRoom: 33)
				)
			)
		)
	)
)

(instance awayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(User canControl: 1)
				(Print 1 77 #draw #at -1 30) ; "After getting out of the car, Keith says... "Man! Am I glad to get out of there. It smells like a camel arena.""
				(global112 setMotion: MoveTo 131 110 self)
			)
			(1
				(local1 startUpd: setCycle: End self)
				(global112
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 131 108
				)
			)
			(2
				(local1 setCycle: Beg self)
				(global112 posn: 1000 0 stopUpd:)
			)
			(3
				(HandsOn)
				(local1 stopUpd:)
			)
		)
	)
)

