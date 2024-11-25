;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use jet)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm42 0
)

(local
	[local0 100]
	local100
	local101
	local102
	local103
	local104
	local105
	local106
	local107
	local108
	local109
	local110
	local111
	local112
	local113
	local114
	local115
	local116
	local117
	local118
	local119
	local120
	local121
	local122
	local123
	local124
	local125
	local126
	local127
)

(procedure (localproc_0)
	((View new:)
		view: 84
		loop: 0
		cel: 3
		posn: 263 75
		ignoreActors:
		setPri: 1
		addToPic:
	)
	((View new:)
		view: 84
		loop: 1
		setCel: 255
		posn: 268 60
		ignoreActors:
		setPri: 2
		addToPic:
	)
	((= local109 (Prop new:))
		view: 82
		posn: 271 55
		loop: 8
		cel: 0
		setPri: 0
		ignoreActors:
		cycleSpeed: 2
		init:
		stopUpd:
	)
	((= local108 (Prop new:))
		view: 82
		posn: 51 191
		loop: 2
		cel: 0
		ignoreActors:
		setPri: 15
		init:
		stopUpd:
	)
	((= local107 (Prop new:))
		view: 82
		posn: 65 158
		loop: 5
		setCel: local106
		setPri: 10
		ignoreActors:
		init:
		stopUpd:
	)
	(if (== 0 (gEgo x:) (gEgo y:))
		(gEgo posn: 230 61)
	)
	(gEgo illegalBits: $8000 init:)
	(proc154_2)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(if (< (= temp0 (bombTimer seconds:)) 0)
		(= temp0 0)
	)
	(if (!= local111 temp0)
		(= local111 temp0)
		(= temp3 (mod temp0 10))
		(= temp2 (mod (/= temp0 10) 10))
		(if (not (= temp1 (mod (/= temp0 10) 10)))
			(= temp1 10)
			(if (not temp2)
				(= temp2 10)
			)
		)
		(local118 posn: 244 36 cel: temp1)
		(local119 posn: 254 36 cel: temp2)
		(local120 posn: 264 36 cel: temp3)
	)
)

(procedure (localproc_2)
	(Print &rest #at -1 150 #font gSmallFont)
)

(instance explosionSound of Sound
	(properties
		number 30
		priority 10
	)
)

(instance bombTimer of Timer
	(properties)
)

(instance Bathroom of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((not local101)
				(if (Said '/bracket,basin,garbage,crapper')
					(proc0_7) ; "You're not close enough."
				else
					(return)
				)
			)
			((Said '/garbage,can[<garbage]>')
				(cond
					((Said 'look')
						(if (not local100)
							(proc154_1 42 0)
						else
							(proc154_1 42 1)
						)
					)
					((Said 'frisk')
						(if (not local100)
							(proc154_1 42 2)
						else
							(proc154_1 42 1)
						)
					)
					((Said 'get')
						(proc154_1 42 3)
					)
					((Said 'read')
						(proc154_1 42 4)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'flush,use/crapper')
				(proc154_1 42 5)
			)
			((Said 'bath/hand')
				(proc154_1 42 6)
			)
			((Said 'turn/faucet,water')
				(proc154_1 42 7)
			)
			((Said 'open/bracket,lid')
				(cond
					((not local101)
						(proc154_1 42 8)
					)
					((== (gCurRoom script:) TowelDispenser)
						(event claimed: 0)
					)
					(else
						(= local103 1)
						(gCurRoom setScript: TowelDispenser)
					)
				)
			)
			((Said 'open/door')
				(Print 42 9) ; "Just walk to it and it will open automatically."
			)
			((Said '(look,frisk)>')
				(cond
					((Said '/wall')
						(proc154_1 42 10)
					)
					((Said '/mirror')
						(if (not local100)
							(proc154_1 42 11)
						else
							(proc154_1 42 12)
						)
					)
					((Said '/basin')
						(if (not local100)
							(proc154_1 42 13)
							(proc154_1 42 14)
						else
							(proc154_1 42 1)
						)
					)
					((Said '/crapper')
						(if (not local100)
							(proc154_1 42 15)
						else
							(proc154_1 42 1)
						)
					)
					((Said '/bracket[<towel]')
						(if (!= (gCurRoom script:) 0)
							(proc154_1 42 16)
						else
							(= local103 local121)
							(gCurRoom setScript: TowelDispenser)
						)
					)
					((Said '/pane')
						(proc154_1 42 17)
					)
					((Said '[<at,around][/!*,chamber,bathroom]')
						(proc154_1 42 18)
					)
				)
			)
		)
	)
)

(instance rm42 of Rm
	(properties
		picture 40
		style 0
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 82)
		(Load rsVIEW 84)
		(Load rsPIC 300)
		(super init:)
		(self setLocales: 154)
		(self setFeatures: Bathroom)
		(= local106 3)
		(localproc_0)
		(= global202 0)
		(= global201 0)
		(= local123 1)
		(= local124 0)
		(= local125 0)
		(= local126 0)
		(= local127 0)
		(HandsOn)
		(bombTimer setReal: doBlowUp 120)
	)

	(method (dispose)
		(bombTimer dispose: delete:)
		(Bathroom dispose:)
		(egoSearch dispose:)
		(brDoor dispose:)
		(TowelDispenser dispose:)
		(super dispose:)
	)

	(method (doit)
		(if (not (self script:))
			(cond
				((and (& (gEgo onControl:) $2000) (not local101))
					(gCurRoom setScript: brDoor)
					(brDoor changeState: 10)
				)
				((and (& (gEgo onControl:) $0400) local101)
					(gCurRoom setScript: brDoor)
					(brDoor changeState: 1)
				)
				((and local100 (not local101))
					(gCurRoom newRoom: 43)
				)
			)
		)
		(if (& (gEgo onControl:) $4000)
			(if (not local105)
				(= local105 1)
				(Print 42 19) ; "It would not be a good idea to try to exit the plane at 25,000 feet."
			)
		else
			(= local105 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			((gEgo inRect: 255 50 300 75)
				(= local102 1)
			)
			((& (gEgo onControl:) $1800)
				(= local102 2)
			)
			((and (>= (gEgo y:) 57) (<= (gEgo y:) 143))
				(= local102 3)
			)
			(else
				(= local102 0)
			)
		)
		(cond
			(
				(or
					(Said '/*<(hijacker,man)<unmasked')
					(Said '//(hijacker,man)<unmasked')
					(Said '/<unmasked')
				)
				(if (!= local102 1)
					(proc0_7) ; "You're not close enough."
					(return)
				)
				(= local104 2)
				(event claimed: 0)
			)
			(
				(or
					(Said '/*<(hijacker,man)<masked')
					(Said '//(hijacker,man)<masked')
					(Said '/<masked')
				)
				(if (!= local102 1)
					(proc0_7) ; "You're not close enough."
					(return)
				)
				(= local104 1)
				(event claimed: 0)
			)
			((Said '/body,hijacker')
				(if (and (!= local102 1) (!= local102 2))
					(proc0_7) ; "You're not close enough."
					(return)
				)
				(event claimed: 0)
			)
		)
		(cond
			((Said 'sat[/*]')
				(if (not local100)
					(proc154_1 42 20)
				else
					(proc154_1 42 5)
				)
			)
			((Said '/9mm>')
				(cond
					((!= local102 1)
						(event claimed: 1)
						(proc0_7) ; "You're not close enough."
					)
					((Said 'get')
						(proc154_1 42 21)
					)
					((Said 'look')
						(proc154_1 42 22)
					)
				)
			)
			((Said '/(bench,baggage)')
				(if (== local102 3)
					(proc154_1 42 23)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said '/compartment,bin,cabinet')
				(if (== local102 3)
					(proc154_1 42 24)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((and (== local102 3) (Said '/passenger,man,woman>'))
				(cond
					((Said 'look')
						(proc154_1 42 25)
					)
					((Said 'talk')
						(switch (Random 0 2)
							(0
								(proc154_1 42 26)
							)
							(1
								(proc154_1 42 27)
							)
							(else
								(proc154_1 42 28)
							)
						)
					)
					(else
						(event claimed: 1)
						(proc154_1 42 29)
					)
				)
			)
			((Said '/passenger')
				(proc0_7) ; "You're not close enough."
			)
			((or (Said 'look/(hijacker,body,man)') (Said 'frisk/cloth'))
				(cond
					((and (!= local102 2) (!= local102 1))
						(proc0_7) ; "You're not close enough."
					)
					((== local104 2)
						(proc154_1 42 30)
					)
					(else
						(proc154_1 42 31)
					)
				)
			)
			((Said 'open/door')
				(cond
					((& (gEgo onControl:) $4000)
						(proc154_1 42 19)
					)
					((or (== local102 2) (== local102 1))
						(proc154_1 42 32)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'check/(hijacker,body,man)')
				(if (!= local102 1)
					(proc0_7) ; "You're not close enough."
				else
					(proc154_1 42 33)
				)
			)
			((Said 'frisk[<around][/!*,area]')
				(proc154_1 42 34)
			)
			((Said '(frisk,look)>')
				(cond
					(
						(or
							(Said '/unmasked')
							(Said '/(body,hijacker,man)<unmasked')
						)
						(= local104 2)
						(proc154_1 42 35)
					)
					((or (Said '/masked') (Said '/(body,hijacker,man)<masked'))
						(= local104 1)
						(proc154_1 42 36)
					)
					((Said '/(man,body,hijacker)')
						(proc154_1 42 37)
					)
					((Said '/pocket,coat')
						(cond
							((!= local102 1)
								(proc0_7) ; "You're not close enough."
							)
							((== local104 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 38)
							)
							((gEgo has: 9) ; wire_clippers
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 39)
							)
							(else
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 40)
								(gEgo get: 9) ; wire_clippers
								(SetScore 3)
							)
						)
					)
					((Said '/shirt')
						(if (!= local102 1)
							(proc0_7) ; "You're not close enough."
						else
							(proc0_19 gEgo egoSearch)
							(Print
								(Format ; "Looking through the shirt of the %s hijacker you find nothing."
									@local0
									42
									41
									(if (== local104 1)
										{masked}
									else
										{unmasked}
									)
								)
							)
						)
					)
					((Said '/jeans')
						(cond
							((!= local102 1)
								(proc0_7) ; "You're not close enough."
							)
							((== local104 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 42)
								(proc154_1 42 43)
								(proc154_1 42 44)
							)
							(else
								(proc0_19 gEgo egoSearch)
								(Print 42 45) ; "Looking through the pants of the masked hijacker you find nothing."
							)
						)
					)
					((Said '/turban')
						(cond
							((!= local102 1)
								(proc0_7) ; "You're not close enough."
							)
							((gEgo has: 33) ; bomb_instructions
								(= local104 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 46)
							)
							(else
								(= local104 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 47)
								(gEgo get: 33) ; bomb_instructions
								(SetScore 3)
							)
						)
					)
					((Said '/mask')
						(if (!= local102 1)
							(proc0_7) ; "You're not close enough."
						else
							(= local104 1)
							(proc154_1 42 48)
						)
					)
					((Said '/bomb')
						(proc154_1 42 49)
					)
				)
			)
			((Said '/unmasked')
				(if (= local102 1)
					(= local104 2)
					(proc154_1 42 50)
				else
					(Print 42 51) ; "What?"
				)
			)
			((Said '/masked')
				(if (= local102 1)
					(= local104 1)
					(proc154_1 42 52)
				else
					(Print 42 51) ; "What?"
				)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((and (== local104 2) (< (gEgo x:) 276))
						(gEgo illegalBits: 0 setMotion: MoveTo 276 61 self)
					)
					((and (== local104 1) (> (gEgo x:) 282))
						(gEgo illegalBits: 0 setMotion: MoveTo 282 65 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo
					view: 84
					setCel: 0
					cycleSpeed: 4
					setCycle: CT 7 1 self
					setLoop:
						(cond
							((== local104 2) 6)
							((>= (gEgo y:) 59) 7)
							((<= (gEgo x:) 270) 6)
							(else 5)
						)
				)
			)
			(2
				(gEgo setCel: 4 setCycle: CT 7 1 self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					illegalBits: $8000
				)
				(client setScript: 0)
			)
		)
	)
)

(instance brDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo setMotion: 0)
				(local107 setCycle: End self)
			)
			(2
				(gEgo setPri: -1 setMotion: MoveTo 69 155 self)
			)
			(3
				(local107 stopUpd:)
				(local108 posn: 51 191)
				(RedrawCast)
				(local108 stopUpd:)
				(gEgo setMotion: MoveTo 82 155 self)
			)
			(4
				(HandsOn)
				(gEgo loop: 0 setMotion: 0)
				(= local101 0)
				(gCurRoom setScript: 0)
			)
			(10
				(HandsOff)
				(local108 posn: 100 1000)
				(local107 startUpd:)
				(gEgo
					ignoreActors:
					posn: 69 155
					illegalBits: 0
					setMotion: MoveTo 55 162 self
				)
			)
			(11
				(local107 setCycle: Beg self)
			)
			(12
				(HandsOn)
				(local107 stopUpd:)
				(gEgo setPri: 13 ignoreActors: 0 illegalBits: $8000)
				(= local101 1)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance TowelDispenser of Script
	(properties)

	(method (doit)
		(if (== local110 1)
			(= local110 0)
			(HandsOff)
			(gContinuousMusic stop:)
			(gCurRoom setScript: doBoomScript)
		)
		(if (== local123 6)
			(localproc_2 42 53) ; "The timer stops. The bomb is disarmed!"
			(bombTimer seconds: -1)
			(gContinuousMusic stop:)
			(local118 posn: 244 36 cel: 10)
			(local119 posn: 254 36 cel: 10)
			(local120 posn: 264 36 cel: 10)
			(= local123 7)
			(= local100 1)
		)
		(if (and local121 (>= (bombTimer seconds:) 0))
			(localproc_1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(gCurRoom picture: 24)
				(gCurRoom drawPic: (gCurRoom picture:) style: 6)
				(HandsOff)
				(User canInput: 1)
				((= local113 (Prop new:))
					view: 250
					loop: 3
					cel: local124
					posn: 128 91
					setPri: 4
					init:
				)
				((= local114 (Prop new:))
					view: 250
					loop: 4
					cel: local125
					posn: 120 96
					setPri: 4
					init:
				)
				((= local115 (Prop new:))
					view: 250
					loop: 5
					cel: local126
					posn: 119 92
					setPri: 4
					init:
				)
				((= local116 (Prop new:))
					view: 250
					loop: 6
					cel: local127
					posn: 120 88
					setPri: 4
					init:
				)
				((= local122 (View new:))
					view: 250
					loop: 2
					cel: 0
					posn: 166 97
					setPri: 2
					init:
					stopUpd:
				)
				((= local112 (Prop new:))
					view: 250
					loop: 0
					cel: 0
					posn: 154 103
					setPri: 15
					init:
					stopUpd:
				)
				((= local118 (Prop new:))
					view: 250
					loop: 8
					cel: 0
					posn: 240 1000
					setPri: 15
					init:
				)
				((= local119 (Prop new:))
					view: 250
					loop: 8
					cel: 0
					posn: 240 1000
					setPri: 15
					init:
				)
				((= local120 (Prop new:))
					view: 250
					loop: 8
					cel: 0
					posn: 240 1000
					setPri: 15
					init:
				)
				((= local117 (View new:))
					view: 250
					loop: 7
					cel: 0
					posn: 235 1000
					setPri: 15
					init:
				)
				(if local103
					(self cue:)
				)
			)
			(1
				(local112 loop: 1 posn: 155 103)
				(local117 posn: 235 40)
				(localproc_1)
				(SetScore 2 99)
				(= local121 1)
			)
			(10
				(local112 setLoop: 0 posn: 154 103)
				(= seconds 2)
			)
			(11
				(= local121 0)
				(gCast eachElementDo: #dispose)
				(= local106 0)
				(localproc_0)
				(gCurRoom picture: 40)
				(gCurRoom drawPic: (gCurRoom picture:) style: 0)
				(proc154_2)
				(local108 posn: 50 1000)
				(gEgo posn: 46 165)
				(local107 stopUpd:)
				(local109 stopUpd:)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '(get,move,remove)/bomb')
						(cond
							((not local121)
								(proc0_10) ; "You can't do that now."
							)
							((> local123 5)
								(localproc_2 42 54) ; "You don't need the disarmed bomb."
							)
							(else
								(localproc_2 42 55) ; "Ok."
								(localproc_2 42 56) ; "As you take the bomb..."
								(= local110 1)
							)
						)
					)
					((Said 'disarm')
						(cond
							((not local121)
								(proc0_10) ; "You can't do that now."
							)
							((> local123 5)
								(localproc_2 42 57) ; "The bomb is already disarmed."
							)
							(else
								(localproc_2 42 58) ; "How do you propose to do that?"
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/wires')
								(if (not local121)
									(proc0_10) ; "You can't do that now."
								else
									(localproc_2 42 59) ; "There is a blue, white, yellow, and purple wire attached to the bomb."
								)
							)
							((Said '/cable>')
								(cond
									((not local121)
										(event claimed: 1)
										(proc0_10) ; "You can't do that now."
									)
									((Said '/!*')
										(localproc_2 42 60) ; "There are four wires: a blue, white, yellow, and purple one."
									)
									((Said '/(cable<blue)')
										(localproc_2
											(Format ; "The blue wire is %s."
												@local0
												42
												61
												(if (== local124 1)
													{cut}
												else
													{connected}
												)
											)
										)
									)
									((Said '/(cable<white)')
										(localproc_2
											(Format ; "The white wire is %s."
												@local0
												42
												62
												(if (== local125 1)
													{cut}
												else
													{connected}
												)
											)
										)
									)
									((Said '/(cable<yellow)')
										(localproc_2
											(Format ; "The yellow wire is %s."
												@local0
												42
												63
												(if (== local126 1)
													{cut}
												else
													{connected}
												)
											)
										)
									)
									((Said '/(cable<purple)')
										(localproc_2
											(Format ; "The purple wire is %s."
												@local0
												42
												64
												(if (== local127 1)
													{cut}
												else
													{connected}
												)
											)
										)
									)
									(else
										(event claimed: 1)
										(localproc_2 42 65) ; "Please specify either the blue, white, yellow, or purple wire."
									)
								)
							)
							((Said '/timer,(device[<timing])')
								(cond
									((not local121)
										(localproc_2 42 66) ; "You don't see a timing device here."
									)
									((> local123 5)
										(localproc_2 42 67) ; "The device is off."
									)
									(else
										(localproc_2 42 68) ; "The timing device quickly ticks down."
									)
								)
							)
							((Said '/bomb')
								(if local121
									(localproc_2 42 69) ; "The bomb has four wires and a timing device."
								else
									(localproc_2 42 70) ; "You don't see a bomb?"
								)
							)
							((Said '/bracket')
								(if local121
									(localproc_2 42 71) ; "In the towel dispenser is a bomb!"
								else
									(localproc_2 42 72) ; "You look at the paper towel dispenser, but you see nothing out of the ordinary."
								)
							)
							((Said '/dynamite')
								(localproc_2 42 73) ; "It looks like it could easily blow up this plane!"
							)
							((Said '[<at,around][/(!*,chamber,bathroom)]')
								(self changeState: 10)
							)
						)
					)
					((or (Said 'exit,exit') (Said 'look/chamber'))
						(self changeState: 10)
					)
					((Said 'open[/bracket,lid]')
						(if (not local121)
							(self changeState: 1)
						else
							(localproc_2 42 74) ; "It's already open."
						)
					)
					((Said 'close[/bracket,lid]')
						(if local121
							(= local121 0)
							(self changeState: 10)
						else
							(localproc_2 42 75) ; "It is not yet open."
						)
					)
					((or (Said 'get/towel') (Said 'use/bracket'))
						(localproc_2 42 76) ; "The towels seem to be stuck."
					)
					((Said 'pull,bite/cable,wires')
						(localproc_2 42 77) ; "That would not be a good idea."
					)
					((Said '(cut,clip,disconnect)/>')
						(cond
							((not (gEgo has: 9)) ; wire_clippers
								(localproc_2 42 78) ; "You'll need something to cut the wires apart."
								(event claimed: 1)
							)
							((> local123 5)
								(localproc_2 42 79) ; "Leave the bomb alone...it is disarmed."
								(event claimed: 1)
							)
							((not local121)
								(localproc_2 42 80) ; "You can't do that now."
								(event claimed: 1)
							)
							((or (Said '<blue') (Said '/cable<blue'))
								(if (== local124 1)
									(localproc_2 42 81) ; "It already is."
								else
									(localproc_2 42 82) ; "Snip."
									(local113 cel: 1)
									(= local124 1)
									(switch local123
										(2
											(SetScore 3)
											(if (== local127 1)
												(++ local123)
											)
										)
										(else
											(= local110 1)
										)
									)
								)
							)
							((or (Said '<white') (Said '/cable<white'))
								(if (== local125 1)
									(localproc_2 42 81) ; "It already is."
								else
									(localproc_2 42 82) ; "Snip."
									(local114 cel: 1)
									(= local125 1)
									(if (!= local123 4)
										(= local110 1)
									else
										(++ local123)
										(SetScore 3)
									)
								)
							)
							((or (Said '<yellow') (Said '/cable<yellow'))
								(if (== local126 1)
									(localproc_2 42 81) ; "It already is."
								else
									(localproc_2 42 82) ; "Snip."
									(local115 cel: 1)
									(= local126 1)
									(switch local123
										(1
											(++ local123)
											(SetScore 3)
										)
										(5
											(++ local123)
											(SetScore 3)
										)
										(else
											(= local110 1)
										)
									)
								)
							)
							((or (Said '<purple') (Said '/cable<purple'))
								(if (== local127 1)
									(localproc_2 42 81) ; "It already is."
								else
									(localproc_2 42 82) ; "Snip."
									(local116 cel: 1)
									(= local127 1)
									(if (!= local123 2)
										(= local110 1)
									else
										(SetScore 3)
										(if (== local124 1)
											(++ local123)
										)
									)
								)
							)
							(else
								(event claimed: 1)
								(localproc_2 42 65) ; "Please specify either the blue, white, yellow, or purple wire."
							)
						)
					)
					((Said 'attach,(drop<together)/>')
						(cond
							((not local121)
								(event claimed: 1)
								(Print 42 80) ; "You can't do that now."
							)
							((> local123 5)
								(localproc_2 42 79) ; "Leave the bomb alone...it is disarmed."
								(event claimed: 1)
							)
							((or (Said '<blue') (Said '/(cable<blue)'))
								(if (== local124 0)
									(localproc_2 42 83) ; "It is already connected."
								else
									(localproc_2 42 84) ; "You put the blue wire together."
									(local113 cel: 0)
									(= local110 1)
								)
							)
							((or (Said '<white') (Said '/(cable<white)'))
								(if (== local125 0)
									(localproc_2 42 83) ; "It is already connected."
								else
									(localproc_2 42 85) ; "You put the white wire together."
									(local114 cel: 0)
									(= local110 1)
								)
							)
							((or (Said '<yellow') (Said '/(cable<yellow)'))
								(if (== local126 0)
									(localproc_2 42 83) ; "It is already connected."
								else
									(localproc_2 42 86) ; "You put the yellow wire together."
									(local115 cel: 0)
									(if (!= local123 3)
										(= local110 1)
									else
										(= local126 0)
										(++ local123)
										(SetScore 3)
									)
								)
							)
							((or (Said '<purple') (Said '/(cable<purple)'))
								(if (== local127 0)
									(localproc_2 42 83) ; "It is already connected."
								else
									(localproc_2 42 87) ; "You put the purple wire together."
									(local116 cel: 0)
									(= local110 1)
								)
							)
							(else
								(event claimed: 1)
								(localproc_2 42 65) ; "Please specify either the blue, white, yellow, or purple wire."
							)
						)
					)
				)
			)
		)
	)
)

(instance doBoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(explosionSound play:)
				(SetMenu 513 112 0)
				(SetMenu 514 112 0)
				(gCurRoom drawPic: 300 style: 7)
				(gCast eachElementDo: #hide)
				(RedrawCast)
				(ShakeScreen 10)
				(= seconds 3)
			)
			(1
				(EgoDead
					{You and 49 other people are now dead...because YOU screwed up!}
				)
			)
		)
	)
)

(instance doBlowUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= local123 6)
					(gCurRoom newRoom: 44)
				)
			)
		)
	)
)

