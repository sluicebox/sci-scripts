;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use n100)
(use n105)
(use n106)
(use Interface)
(use Door)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm82 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 8]
	[local14 8]
	[local22 4]
	[local26 4] = [200 225 219 251]
	[local30 4] = [-5 25 55 85]
	[local34 2] = [211 232]
	[local36 2] = [25 85]
	[local38 8] = [200 219 225 251 225 251 200 219]
	[local46 8] = [-5 25 55 85 -5 25 55 85]
	local54
	local55
	local56
	local57
)

(procedure (localproc_0 param1)
	(if (IsFlag 272)
		(HighPrint 82 0) ; "You'll have to climb down to do that."
	else
		(gEgo setScript: getWater 0 param1)
	)
)

(procedure (localproc_1 &tmp [temp0 200])
	(Format @temp0 &rest)
	(Print @temp0 #at 120 10)
)

(procedure (localproc_2)
	(= [local22 0] (Clone aRipple))
	(= [local22 1] (Clone aRipple))
	([local22 0]
		setLoop: 4
		ignoreActors:
		init:
		cycleSpeed: (if (== gHowFast 3) 2 else 1)
		setCycle: Fwd
		setScript: (Clone aRippleScript)
	)
	([local22 1]
		setLoop: 4
		ignoreActors:
		posn: 150 200
		init:
		cycleSpeed: (if (== gHowFast 3) 2 else 1)
		setCycle: Fwd
	)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 2) ((++ temp0))
		(= [local6 temp0] (Clone waterFalling))
		(= [local14 temp0] (Clone aFallScript))
		([local6 temp0]
			setLoop: 0
			ignoreActors:
			x: [local34 temp0]
			y: [local36 temp0]
			init:
			setPri: 1
			cycleSpeed: 3
			setScript: [local14 temp0] 0 temp0
		)
	)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= [local6 temp0] (Clone waterFalling))
		(= [local14 temp0] (Clone aFallScript))
		([local6 temp0]
			setLoop: 0
			ignoreActors:
			x: [local26 temp0]
			y: [local30 temp0]
			init:
			setPri: 1
			cycleSpeed: 3
			setScript: [local14 temp0] 0 temp0
		)
	)
)

(procedure (localproc_5 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(= [local6 temp0] (Clone waterFalling))
		(= [local14 temp0] (Clone aFallScript))
		([local6 temp0]
			setLoop: 0
			ignoreActors:
			x: [local38 temp0]
			y: [local46 temp0]
			init:
			setPri: 1
			cycleSpeed: 3
			setScript: [local14 temp0] 0 temp0
		)
	)
)

(instance Magic of Prop
	(properties
		view 531
		cycleSpeed 2
	)
)

(instance rock of Act
	(properties
		view 510
		illegalBits 0
	)
)

(instance rm82Sound of Sound
	(properties
		number 28
		priority 4
	)
)

(instance splashSound of Sound
	(properties
		number 72
		priority 2
		loop -1
	)
)

(instance hermitDoor of Door
	(properties
		y 49
		x 53
		view 82
		loop 2
		entranceTo 83
		locked 1
		doorControl 4096
	)
)

(instance hermitHead of View
	(properties
		view 81
		loop 4
	)
)

(instance hermit of Act
	(properties
		y 50
		x 88
		view 81
		illegalBits 0
	)
)

(instance ladder of Prop
	(properties
		y 141
		x 87
		view 82
		loop 5
	)
)

(instance spray of Prop
	(properties
		y 121
		x 182
		view 82
		loop 1
		cel 2
		cycleSpeed 2
	)
)

(instance wave of Prop
	(properties
		y 139
		x 254
		view 82
		loop 3
		cycleSpeed 2
	)
)

(instance aRipple of Act
	(properties
		y 150
		x 216
		yStep 1
		view 82
		illegalBits 0
		xStep 1
	)
)

(instance waterFalling of Prop
	(properties
		view 82
	)
)

(instance rm82 of Rm
	(properties
		picture 82
		style 8
		west 81
	)

	(method (dispose)
		(ClearFlag 352)
		(SetFlag 72)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 82 510 81 537 538)
		(LoadMany rsSCRIPT 991 103)
		137
		138
		139
		(LoadMany rsSOUND (SoundFX 78) (SoundFX 9) (SoundFX 10) (SoundFX 84))
		(Load rsSOUND 72)
		(if (IsFlag 241)
			(Load rsVIEW 531)
		)
		(super init: &rest)
		(gContMusic stop:)
		(splashSound number: 72 init: play:)
		(rm82Sound number: (SoundFX 78) init:)
		(SL enable:)
		(hermitDoor init: stopUpd:)
		(ladder
			setPri: 1
			ignoreActors:
			init:
			cycleSpeed:
				(switch gHowFast
					(0 0)
					(1 1)
					(else 2)
				)
			stopUpd:
		)
		(if (> gHowFast 0)
			(spray init: setScript: sprayScript)
		)
		(switch gHowFast
			(0
				(localproc_3)
				(spray init: stopUpd: addToPic:)
				(wave init: setCel: 2 stopUpd: addToPic:)
			)
			(1
				(localproc_4)
				(wave init: setCel: 2 stopUpd: addToPic:)
			)
			(else
				(localproc_5)
				(wave init: setCycle: Fwd startUpd:)
			)
		)
		(localproc_2)
		(NormalEgo)
		(gEgo init:)
		(if (== gPrevRoomNum 83)
			(cond
				((IsFlag 240)
					(gEgo
						view: 81
						illegalBits: 0
						setPri: 1
						setLoop: 5
						cel: 0
						posn: 219 55
						setScript: deadlyTP
					)
					(hermitDoor setCel: 0 doorState: 0 stopUpd:)
				)
				((IsFlag 241)
					(gEgo
						posn: 75 155
						loop: 2
						cel: 1
						hide:
						setScript: safeTP
					)
					(hermitDoor setCel: 0 doorState: 0 stopUpd:)
				)
				(else
					(gEgo posn: 88 50 setMotion: MoveTo 88 57)
					(SetFlag 272)
				)
			)
		else
			(gEgo posn: 0 140 setMotion: MoveTo 35 140)
		)
		(if (or (IsFlag 240) (IsFlag 241))
			(Magic
				posn: (gEgo x:) (gEgo y:)
				setPri: (+ (gEgo priority:) 1)
				ignoreActors:
				init:
			)
		)
		(if (not (IsFlag 72))
			(self setScript: firstMsg)
		)
	)

	(method (doit)
		(cond
			((and (> ([local22 0] y:) 165) (> ([local22 1] y:) 190))
				([local22 1] setScript: (Clone aRippleScript))
			)
			((and (> ([local22 1] y:) 165) (> ([local22 0] y:) 190))
				([local22 0] setScript: (Clone aRippleScript))
			)
		)
		(if
			(and
				(IsFlag 272)
				(not (IsFlag 274))
				(== (gEgo onControl: 1) 8192)
			)
			(ClearFlag 272)
			(ClearFlag 276)
			(gEgo setScript: waHooHooHooey)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look>')
						(cond
							((Said '[<at,around,up][/area,scenery,cliff,north]')
								(HighPrint 82 1) ; "A river plunges for more than a hundred feet down the face of a cliff. A doorway has been built into the side of the cliff."
							)
							((Said '/water,fall,fall,cascade')
								(HighPrint 82 2) ; "The water seems to be trying to fly as it leaps from the mountain above."
							)
							((Said '/east')
								(HighPrint 82 3) ; "You see slick, vertical cliff walls."
							)
							((Said '/west,tree,forest')
								(HighPrint 82 4) ; "You see the forest."
							)
							((Said '/south,river,boulder')
								(HighPrint 82 5) ; "The water is white as it splashes against the rocks with great force and purpose and disappears into a narrow canyon to the south."
							)
							((or (Said '<down') (Said '/ground'))
								(HighPrint 82 6) ; "The grass is green with the freshness of new spring."
							)
							((Said '/ledge,shelf')
								(HighPrint 82 7) ; "There is a narrow ledge in front of the wide door."
							)
							((Said '/ladder')
								(if (IsFlag 236)
									(HighPrint 82 8) ; "You can't see it."
								else
									(HighPrint 82 9) ; "You don't see a ladder here."
								)
							)
							((Said '/door')
								(HighPrint 82 10) ; "The door is built into the face of the mountainside. You suspect that the person who lives behind it treasures privacy."
								(if (not local5)
									(= local5 1)
									(HighPrint 82 11) ; "It's a large door. It must open pretty wide."
								)
							)
						)
					)
					((Said 'pick,lockpick[<up]/boulder,brick')
						(gEgo setScript: getRock)
					)
					((Said 'drink,drink[/water]')
						(localproc_0 0)
					)
					((or (Said 'put/water/bottle') (Said 'fill/bottle'))
						(if (gEgo has: 26) ; empty bottle
							(localproc_0 1)
						else
							(HighPrint 82 12) ; "you don't have a flask"
						)
					)
					((Said 'get,get>')
						(cond
							((or (Said '/water') (Said 'bottle/water'))
								(if [gInvDropped 29] ; water
									(event claimed: 0)
								else
									(localproc_0 1)
								)
							)
							((Said '/boulder,brick')
								(gEgo setScript: getRock)
							)
						)
					)
					((Said 'throw/boulder,brick')
						(if (gEgo has: 21) ; boulder
							(gEgo setScript: throwIt)
						else
							(HighPrint 82 13) ; "You don't have a rock to throw."
						)
					)
					((or (Said 'swim') (Said 'go/swim'))
						(HighPrint 82 14) ; "The water comes from melting snow. This early in the season, it's much too cold to swim."
					)
					((Said 'open,open,open/door')
						(if (IsFlag 272)
							(HighPrint 82 15) ; "The door is securely locked."
						else
							(event claimed: 0)
						)
					)
					((Said 'pick,lockpick,unlock/hasp,hasp,lock,door')
						(if (IsFlag 272)
							(HighPrint 82 16) ; "The door is so securely locked that it defies your abilities to unlock it."
						else
							(event claimed: 0)
						)
					)
					((Said 'knock')
						(if (IsFlag 272)
							(self setScript: knockScript)
							(SolvePuzzle 697 1)
						else
							(HighPrint 82 17) ; "It's a little hard to knock on the door from where you're standing."
						)
					)
					(
						(Said
							'climb,climb,japaneseclimbup,japaneseclimbdown/ladder'
						)
						(cond
							((IsFlag 272)
								(gEgo setScript: climbDown)
							)
							((IsFlag 236)
								(gEgo setScript: goodClimb)
							)
							(else
								(HighPrint 82 9) ; "You don't see a ladder here."
							)
						)
					)
					(
						(or
							(Said 'climb,climb>')
							(Said 'japaneseclimbup>')
							(Said 'japaneseclimbdown>')
						)
						(cond
							(
								(or
									(Said '<up[/boulder,cliff]')
									(Said '[<up]/boulder,cliff')
									(Said 'japaneseclimbup')
								)
								(cond
									((IsFlag 272)
										(Print 82 18 #mode 1) ; "You're in front of the door already. You don't need to climb any farther."
									)
									((IsFlag 236)
										(gEgo setScript: goodClimb)
									)
									((TrySkill 11 30) ; climbing
										(gEgo setScript: goodClimb)
									)
									(else
										(gEgo setScript: badClimb)
									)
								)
							)
							(
								(or
									(Said '<down[/boulder,cliff]')
									(Said '[<down]/boulder,cliff')
									(Said 'japaneseclimbdown')
								)
								(if (IsFlag 272)
									(gEgo setScript: climbDown)
								else
									(HighPrint 82 19) ; "Huh?"
								)
							)
							(else
								(event claimed: 1)
								(HighPrint 82 20) ; "Climb what?"
							)
						)
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(SetFlag 236)
									(ladder setCycle: End)
								)
								(19
									(SetFlag 236)
									(ladder setCycle: End)
								)
								(17
									(cond
										((IsFlag 352)
											(HighPrint 82 21) ; "The door is already open."
										)
										(
											(and
												(IsFlag 272)
												(> [gEgoStats 17] 5) ; openSpell
											)
											(LowPrint 82 22) ; "As you prepare your spell..."
											(gEgo
												setMotion:
													MoveTo
													(gEgo x:)
													60
											)
											(hermitDoor
												setScript: openFromBelow
											)
										)
										((TrySkill 12 45) ; magic
											(CastOpen gEgo)
											(hermitDoor
												setScript: openFromBelow
											)
										)
										(else
											(HighPrint 82 23) ; "The only thing you can open here is the door, and you're not skilled enough to do that."
										)
									)
								)
								(23
									(CastDart 0)
									(HighPrint 82 24) ; "Wheeee!"
								)
								(20
									(CastDazzle gEgo)
									(HighPrint 82 25) ; "Wow!"
								)
								(else
									(event claimed: 0)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance aFallScript of Script
	(properties)

	(method (doit)
		(if (>= (client y:) 115)
			(client y: -5)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					x: (client x:)
					y:
						(+
							(client y:)
							(switch gHowFast
								(0 30)
								(1 20)
								(else 15)
							)
						)
				)
				(= cycles 2)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sprayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					posn: (Random 180 205) (Random 118 126)
					setCycle: End self
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance aRippleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					show:
					posn: 232 142
					setMotion: MoveTo (Random 83 127) 195
				)
			)
		)
	)
)

(instance firstMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 8)
			)
			(1
				(HighPrint 82 26) ; "The roar of the waterfall fills your ears, and the cold spray dampens your face as you approach."
				(client setScript: 0)
			)
		)
	)
)

(instance goOnIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 84 54 self)
			)
			(1
				(gEgo setMotion: MoveTo 84 48 self)
			)
			(2
				(hermitHead dispose:)
				(gEgo hide:)
				(hermitDoor setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 83)
			)
		)
	)
)

(instance throwIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) 90)
					(gEgo illegalBits: 0 setMotion: MoveTo 18 155 self)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 162 145 self)
				)
			)
			(1
				(gEgo
					view: 510
					cycleSpeed: 1
					setLoop: (if (< (gEgo x:) 90) 3 else 2)
					cel: 0
				)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: CT 4 1 self)
			)
			(3
				(rock
					setLoop: 4
					setPri: 15
					setStep: 35 20
					ignoreActors:
					ignoreHorizon:
					setCycle: Fwd
					posn:
						(if (< (gEgo x:) 90)
							(+ (gEgo x:) 13)
						else
							(- (gEgo x:) 13)
						)
						(- (gEgo y:) 34)
					init:
				)
				(if (and (TrySkill 10 25) (not (IsFlag 352))) ; throwing
					(++ local4)
					(= local1 1)
					(rock
						setMotion:
							MoveTo
							(+ (hermitDoor x:) (Random 20 30))
							(- (hermitDoor y:) (Random 20 30))
							self
					)
				else
					(rock
						setMotion:
							MoveTo
							(if (< (gEgo x:) 90)
								(+ (hermitDoor x:) (Random 60 85))
							else
								(- (hermitDoor x:) (Random 25 50))
							)
							(- (hermitDoor y:) (Random 20 30))
							self
					)
				)
				(gEgo setCycle: End)
			)
			(4
				(if local1
					(if local2
						(TimePrint 2 82 27) ; "RAP!"
					else
						(= local2 1)
						(HighPrint 82 28) ; "The rock makes a sharp sound as it hits the door."
					)
				)
				(rock
					setMotion:
						JumpTo
						(cond
							((< (gEgo x:) 90)
								(if local1 40 else 225)
							)
							(local1 140)
							(else 0)
						)
						(if (< (gEgo x:) 90) 145 else 140)
						self
				)
			)
			(5
				(if (not local1)
					(Print 82 29) ; "Missed"
				else
					(= local1 0)
				)
				(if (== local4 3)
					(= local4 0)
					(if local3
						(HighPrint 82 30) ; "All right, already!"
					else
						(HighPrint 82 31) ; "Is someone there?"
					)
					(hermitDoor setScript: answerKnock)
				else
					(HandsOn)
				)
				(rock dispose:)
				(NormalEgo)
				(gEgo
					use: 21 1 ; boulder
					loop: (if (< (gEgo x:) 90) 0 else 1)
					setScript: 0
				)
			)
		)
	)
)

(instance answerKnock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitDoor
					view: 82
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
			)
			(1
				(HandsOff)
				(hermitDoor setCycle: End self)
				(hermit
					setLoop: 0
					init:
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 88 57
				)
			)
			(2
				(if local3
					(localproc_1 82 32)
					(self cue:)
				else
					(= local3 1)
					(localproc_1 82 33)
					(localproc_1 82 34)
					(ladder setCycle: End self)
					(SetFlag 236)
				)
			)
			(3
				(hermitDoor setCycle: CT 4 -1 self)
			)
			(4
				(hermitDoor setCycle: Beg)
				(hermit setLoop: 1 setMotion: MoveTo 88 50 self)
			)
			(5
				(HandsOn)
				(hermit dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance getWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo x:) 90)
					(gEgo setMotion: MoveTo 95 150 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 169 150 self)
			)
			(2
				(gEgo view: 510 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(if (or (not register) (not (gEgo has: 26))) ; empty bottle
					(switch local0
						(0
							(HighPrint 82 35) ; "You take a drink of water from the icy mountain river. It refreshes you."
						)
						(1
							(HighPrint 82 36) ; "You take another drink of water. You were thirsty!"
						)
						(else
							(HighPrint 82 37) ; "BOY! You must have really been thirsty!"
						)
					)
					(++ local0)
				else
					(gEgo get: 29 use: 26 1) ; water, empty bottle
					(SetFlag 329)
					(SolvePuzzle 698 3)
					(HighPrint 82 38) ; "You fill an empty flask with crystal-clear water from the waterfall."
				)
				(= cycles 5)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo)
				(gEgo illegalBits: 0 setMotion: MoveTo 150 150 self)
			)
			(6
				(gEgo illegalBits: -32768)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance squashed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo cycleSpeed: 3 setCycle: End self)
			)
			(1
				(HighPrint 82 39) ; "Flat...you feel very, very flat."
				(if (TakeDamage 10)
					(= cycles 5)
				else
					(EgoDead ; "And dead...you feel dead, too. In your weakened condition, you succumbed to a mild-mannered hermit's propensity for Tarzan imitations. Back up and play it again, Sam."
						82
						40
						82
						538
						0
						0
						80
						{...and thin...}
					)
				)
			)
			(2
				(gEgo
					view: 503
					setLoop: 4
					cel: 0
					x: (- (gEgo x:) 4)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(ClearFlag 276)
				(NormalEgo)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance safeTP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Magic setCycle: CT 6 1 self)
			)
			(1
				(gEgo show:)
				(Magic setCycle: End self)
			)
			(2
				(ClearFlag 241)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance deadlyTP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo cycleSpeed: 2 setCycle: End)
				(= cycles 20)
			)
			(1
				(gEgo view: 537 setLoop: 0 setCycle: End)
				(= cycles 12)
			)
			(2
				(gEgo yStep: 20 setMotion: MoveTo (gEgo x:) 200 self)
			)
			(3
				(EgoDead ; "That hermit seems to know his "Trigger" spells pretty well. He sure pulled the trigger on you (not to mention the plug) by teleporting you to the top of the falls without a barrel."
					82
					41
					80
					{You're all wet}
					82
					537
					0
					2
				)
			)
		)
	)
)

(instance knockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 275)
				(rm82Sound number: (SoundFX 78) loop: 1 play: self)
			)
			(1
				(Print 82 42) ; "You knock three times."
				(localproc_1 82 43)
				(hermitDoor setScript: hermitHits)
				(self dispose:)
			)
		)
	)
)

(instance getRock of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local55 (gEgo signal:))
				(= local56 (gEgo priority:))
				(= local57 (gEgo illegalBits:))
				(HandsOff)
				(gEgo
					view: 510
					setLoop: (if (== (gEgo loop:) 0) 0 else 1)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(TimePrint 4 82 44) ; "You pick up a few small rocks."
				(gEgo get: 21 10 setCycle: Beg self) ; boulder
			)
			(2
				(NormalEgo)
				(HandsOn)
				(gEgo priority: local56 illegalBits: local57 signal: local55)
				(client setScript: 0)
			)
		)
	)
)

(instance goodClimb of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(if (> (gEgo y:) 142)
					(self cue:)
				else
					(HighPrint 82 45) ; "You look for a good place to climb."
					(gEgo setMotion: MoveTo (gEgo x:) 143 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 88 143 self)
			)
			(2
				(gEgo setLoop: 3)
				(= cycles 2)
			)
			(3
				(gEgo view: 517 setLoop: 0 setCel: 0 posn: 96 143)
				(= cycles 2)
			)
			(4
				(gEgo setCel: 1 y: 122)
				(= cycles 2)
			)
			(5
				(gEgo setCel: 2)
				(= cycles 2)
			)
			(6
				(gEgo setCel: 3 y: 101)
				(= cycles 2)
			)
			(7
				(gEgo setCel: 0)
				(= cycles 2)
			)
			(8
				(gEgo
					setLoop: 1
					posn: 84 68
					setCel: -1
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(9
				(if (not (IsFlag 236))
					(Print 82 46 #mode 1) ; "That was almost too easy...almost like climbing a ladder."
				)
				(= cycles 10)
			)
			(10
				(gEgo posn: 86 55 setLoop: 3)
				(NormalEgo)
				(HandsOn)
				(SetFlag 272)
				(client setScript: 0)
			)
		)
	)
)

(instance badClimb of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo x:) 90)
					(gEgo setMotion: MoveTo 47 134 self)
				else
					(gEgo setMotion: MoveTo 120 140 self)
				)
			)
			(1
				(gEgo
					view: 517
					x: (+ (gEgo x:) 10)
					y: (- (gEgo y:) 1)
					setLoop: 0
					cel: 0
					setCycle: Fwd
				)
				(= cycles 20)
			)
			(2
				(HighPrint 82 47) ; "The rocks are too slick from the spray of the waterfall for your limited climbing skill."
				(gEgo x: (- (gEgo x:) 10) y: (+ (gEgo y:) 1))
				(= cycles 2)
			)
			(3
				(gEgo setMotion: MoveTo (+ (gEgo x:) 6) (gEgo y:) self)
			)
			(4
				(NormalEgo)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 86 55 self)
			)
			(1
				(gEgo view: 517 setLoop: 1 cel: 6 posn: 84 68)
				(= cycles 2)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: Beg self)
			)
			(3
				(gEgo setLoop: 0 setCel: 0 posn: 96 101)
				(= cycles 2)
			)
			(4
				(gEgo setCel: 3)
				(= cycles 2)
			)
			(5
				(gEgo y: 122 setCel: 2)
				(= cycles 2)
			)
			(6
				(gEgo setCel: 1)
				(= cycles 2)
			)
			(7
				(gEgo posn: 96 143 setCel: 0)
				(= cycles 2)
			)
			(8
				(gEgo loop: 2)
				(NormalEgo)
				(HandsOn)
				(ClearFlag 272)
				(client setScript: 0)
			)
		)
	)
)

(instance waHooHooHooey of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 517
					illegalBits: 0
					setLoop: 2
					cel: 0
					x: (- (gEgo x:) 12)
					setStep: 0 4
					cycleSpeed: 1
					setCycle: End
					setMotion: MoveTo (gEgo x:) 106 self
				)
				(rm82Sound number: (SoundFX 9) loop: 1 play:)
			)
			(1
				(rm82Sound number: (SoundFX 10) loop: 1 play:)
				(if (not (TakeDamage 10))
					(EgoDead ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
						82
						48
						82
						517
						2
						5
						80
						{Your figure remains still and silent.}
					)
				else
					(gEgo
						view: 503
						setLoop: 4
						cel: 0
						x: (+ (gEgo x:) 11)
						y: (+ (gEgo y:) 36)
					)
					(self cue:)
				)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(ClearFlag 272)
				(if (IsFlag 274)
					(ClearFlag 274)
				else
					(HighPrint 82 49) ; "Man, that's a narrow ledge up there!"
				)
				(HandsOn)
				(gEgo setLoop: 2)
				(NormalEgo)
				(client setScript: 0)
			)
		)
	)
)

(instance hermitHits of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 275)
					(ClearFlag 275)
					(localproc_1 82 50)
					(User canControl: 1)
					(= cycles 15)
				else
					(self cue:)
				)
			)
			(1
				(if (not (gEgo script:))
					(HandsOff)
				)
				(SetFlag 352)
				(client
					view: 81
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: CT 4 1 self
				)
			)
			(2
				(cond
					((== (gEgo onControl: 1) 4096)
						(rm82Sound number: (SoundFX 84) loop: 1 play:)
						(SetFlag 274)
						(gEgo setScript: waHooHooHooey)
					)
					((== (gEgo onControl: 1) 16384)
						(SetFlag 276)
						(gEgo setPri: 0)
					)
				)
				(client setCycle: End self)
			)
			(3
				(if (IsFlag 276)
					(rm82Sound number: (SoundFX 84) loop: 1 play:)
					(gEgo hide:)
				)
				(hermitHead
					posn: (- (client x:) 26) (- (client y:) 16)
					setCel: 0
					setPri: 15
					init:
				)
				(= cycles 5)
			)
			(4
				(hermitHead setCel: 1)
				(= cycles 5)
			)
			(5
				(if
					(and
						(IsFlag 272)
						(not (IsFlag 274))
						(not (IsFlag 276))
					)
					(ClearFlag 272)
					(localproc_1 82 51)
					(gEgo setScript: goOnIn)
					(client setScript: 0)
				else
					(localproc_1
						82
						52
						80
						{the Hermit mutters...}
					)
					(= cycles 1)
				)
			)
			(6
				(++ local54)
				(hermitHead setCel: 0)
				(= cycles 3)
			)
			(7
				(hermitHead setCel: 1)
				(= cycles 3)
			)
			(8
				(if (< local54 4)
					(self changeState: 6)
				else
					(self cue:)
				)
			)
			(9
				(if (IsFlag 276)
					(gEgo
						view: 538
						setLoop: 0
						cel: 0
						x: (- (gEgo x:) 5)
						y: (- (gEgo y:) 3)
						stopUpd:
						show:
					)
				)
				(hermitHead dispose:)
				(client setLoop: 3 cel: 0 setCycle: End self)
			)
			(10
				(ClearFlag 352)
				(if (IsFlag 276)
					(gEgo setScript: squashed)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance openFromBelow of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 352)
				(client view: 82 loop: 2 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 20)
			)
			(1
				(localproc_1 82 53)
				(self cue:)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(ClearFlag 352)
				(client stopUpd: setScript: 0)
			)
		)
	)
)

