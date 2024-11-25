;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm64 0
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
)

(procedure (localproc_0)
	(Print &rest #at -1 40)
)

(instance bubble of Act
	(properties)
)

(instance carp of Act
	(properties)
)

(instance knife of View
	(properties)
)

(instance weed1 of Extra
	(properties)
)

(instance weed2 of Extra
	(properties)
)

(instance weed3 of Extra
	(properties)
)

(instance weed4 of Extra
	(properties)
)

(instance theWaves of Prop
	(properties)
)

(instance waterFall of Prop
	(properties)
)

(instance bubbles of Prop
	(properties)
)

(instance rm64 of Rm
	(properties
		picture 64
		style 8
	)

	(method (dispose)
		(carpScript dispose:)
		(airScript dispose:)
		(DisposeScript 988)
		(super dispose:)
	)

	(method (init)
		(User canInput: 1)
		(Load rsVIEW 12)
		(Load rsVIEW 91)
		(Load rsVIEW 161)
		(= local106 (if (IsFlag 7) 6 else 2))
		(theWaves
			view: 91
			loop: 1
			cel: 0
			posn: 58 17
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 1
			init:
		)
		(waterFall
			view: 91
			loop: 0
			cel: 1
			posn: 27 23
			setPri: 15
			init:
			setCycle: Fwd
		)
		(bubbles
			view: 91
			loop: 8
			cel: 0
			posn: 5 35
			setPri: 15
			init:
			setCycle: Fwd
		)
		(if (< global110 30)
			(theWaves stopUpd:)
			(waterFall stopUpd:)
			(bubbles stopUpd:)
		)
		(weed1
			pauseCel: -1
			minPause: 10
			maxPause: 40
			minCycles: 6
			maxCycles: 12
			isExtra: 1
			view: 91
			loop: 7
			cel: 3
			posn: 284 94
			init:
			ignoreActors:
		)
		(weed2
			pauseCel: -1
			minPause: 10
			maxPause: 40
			minCycles: 6
			maxCycles: 12
			isExtra: 1
			view: 91
			loop: 4
			cel: 3
			posn: 297 181
			init:
		)
		(weed3
			pauseCel: -1
			minPause: 10
			maxPause: 30
			minCycles: 6
			maxCycles: 12
			isExtra: 1
			view: 91
			loop: 6
			cel: 2
			posn: 12 135 12
			init:
		)
		(weed4
			pauseCel: -1
			minPause: 10
			maxPause: 30
			minCycles: 6
			maxCycles: 12
			isExtra: 1
			view: 91
			loop: 7
			cel: 0
			posn: 262 95
			init:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 0
			posn: 168 124
			setPri: 8
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 1
			posn: 138 108
			setPri: 7
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 4
			posn: 256 111
			setPri: 7
			init:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 3
			posn: 76 130
			setPri: 8
			init:
			ignoreActors:
			addToPic:
		)
		(if (IsItemAt 14) ; makeshift_knife
			(knife
				view: 91
				loop: 3
				cel: 8
				posn: 142 146
				setPri: 10
				init:
				ignoreActors:
			)
		)
		(carp
			view: 165
			setCycle: 0
			posn: 355 175
			setPri: 13
			illegalBits: 0
			init:
			ignoreActors:
			setScript: carpScript
		)
		(super init:)
		(self setScript: rm64Script)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (= temp0 (event message:)) KEY_F6)
						(== temp0 KEY_F8)
						(== temp0 KEY_F10)
					)
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			(evSAID
				(cond
					((Said '/briefcase')
						(Print 64 0) ; "You don't have your field kit."
					)
					(
						(Said
							'remove,(get<off)/belt,bcv,tank,fin,mask,suit,equipment'
						)
						(Print 64 1) ; "Taking off your scuba equipment is not a good idea."
					)
					(
						(Said
							'[check]/air,pressure,(supply[<air]),(tank[<air]),(gauge[<air,pressure])'
						)
						(airScript changeState: 0)
					)
					((Said 'swim/waterfall')
						(Print 64 2) ; "You don't need to."
					)
					((or (Said '<up') (Said '/rise,lid') (Said 'rise'))
						(rm64Script changeState: 3)
					)
					((Said 'look>')
						(cond
							((Said '/waterfall')
								(localproc_0 64 3) ; "It's just a small waterfall."
							)
							(
								(Said
									'/air,pressure,(supply[<air]),(tank[<air]),(gauge[<air,pressure])'
								)
								(airScript changeState: 0)
							)
							(
								(Said
									'[<at,around][/!*,clearwater,water,garbage,crud]'
								)
								(localproc_0 64 4) ; "Gazing into inner space, you see various items of junk scattered along the river bottom. You see huge boulders upriver, and a perpendicular wall on the far side."
							)
							((Said '<up')
								(localproc_0 64 5) ; "You see sunlight rippling through from the surface."
							)
							(
								(or
									(Said '/bottom,muck,bed[<clearwater]')
									(Said '<down,ahead')
									(Said '/object,dirt')
								)
								(cond
									((gEgo inRect: 106 94 165 124)
										(localproc_0 64 6) ; "Its just a waterlogged piece of paper."
									)
									((gEgo inRect: 240 94 284 122)
										(localproc_0 64 6) ; "Its just a waterlogged piece of paper."
									)
									(
										(and
											(IsItemAt 14) ; makeshift_knife
											(or
												(and
													(gEgo
														inRect: 92 128 150 152
													)
													(== (gEgo loop:) 0)
												)
												(and
													(gEgo
														inRect: 150 128 184 152
													)
													(== (gEgo loop:) 1)
												)
												(and
													(gEgo
														inRect: 120 133 160 139
													)
													(== (gEgo loop:) 2)
												)
												(and
													(gEgo
														inRect: 120 135 160 165
													)
													(== (gEgo loop:) 3)
												)
											)
										)
										(localproc_0 64 7) ; "You notice a glint of light reflecting off of an object."
									)
									((gEgo inRect: 155 105 193 141)
										(localproc_0 64 8) ; "You see an old rusted-out can."
									)
									((gEgo inRect: 50 107 106 132)
										(localproc_0 64 9) ; "It's just a good-for-nothing piece of metal."
									)
									((gEgo inRect: 193 134 240 164)
										(localproc_0 64 10) ; "The bottle is just part of the junk. It has no value."
									)
									(else
										(localproc_0 64 11) ; "There is a lot of mud and trash on the river bottom. You will have to search it for clues or evidence."
									)
								)
							)
							((Said '/newspaper')
								(if
									(or
										(gEgo inRect: 106 94 165 124)
										(gEgo inRect: 240 94 284 122)
									)
									(localproc_0 64 12) ; "It's too wet to read. It's of no use."
								else
									(localproc_0 64 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/can[<beer,coca]')
								(if (gEgo inRect: 155 105 193 141)
									(localproc_0 64 8) ; "You see an old rusted-out can."
								else
									(localproc_0 64 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/metal,scrap')
								(if (gEgo inRect: 50 107 106 132)
									(localproc_0 64 9) ; "It's just a good-for-nothing piece of metal."
								else
									(localproc_0 64 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/light,metal,glint,knife')
								(if (IsItemAt 14) ; makeshift_knife
									(if
										(or
											(and
												(gEgo inRect: 92 128 150 152)
												(== (gEgo loop:) 0)
											)
											(and
												(gEgo
													inRect: 150 128 184 152
												)
												(== (gEgo loop:) 1)
											)
											(and
												(gEgo
													inRect: 120 133 160 139
												)
												(== (gEgo loop:) 2)
											)
											(and
												(gEgo
													inRect: 120 135 160 165
												)
												(== (gEgo loop:) 3)
											)
										)
										(localproc_0 64 14) ; "You need to get it first."
									else
										(localproc_0 64 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
									)
								else
									(event claimed: 0)
								)
							)
							((Said '/bottle,glass')
								(if (gEgo inRect: 193 134 240 164)
									(localproc_0 64 10) ; "The bottle is just part of the junk. It has no value."
								else
									(localproc_0 64 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/cave')
								(localproc_0 64 15) ; "Although it looks like there's a cave, there really isn't."
							)
							((Said '/rock,boulder')
								(localproc_0 64 16) ; "You see large and small rocks. You see nothing of interest yet."
							)
							((Said '/plant,bush,grass')
								(localproc_0 64 17) ; "A common variety of river bottom plant."
							)
							((Said '<behind/rock')
								(localproc_0 64 18) ; "You find nothing behind any of the rocks."
							)
							(
								(or
									(Said '/fish,carp,sucker')
									(Said '/school[<fish,carp,sucker]')
								)
								(localproc_0 64 19) ; "You look at a small school of "scaly-skinned" sucker fish, otherwise known as "carp". They are incompatible with the gullet, due to the numerous amount of bones."
							)
						)
					)
					((Said 'move/rock')
						(localproc_0 64 20) ; "If you could move any of these rocks, you wouldn't need to pack a gun."
					)
					((Said '[get]/shit')
						(localproc_0 64 21) ; "As your wet suit fills, you think to yourself... "Why did I do that?""
					)
					((Said '[get]/leak')
						(localproc_0 64 22) ; "A warm feeling comes over you."
					)
					((Said 'get,move,pull,hoist,remove>')
						(cond
							((Said '/muck,garbage')
								(localproc_0 64 23) ; "What for??"
							)
							((Said '/grass,plant')
								(localproc_0 64 24) ; "Why tear up the natural habitat of the "scaly-skinned" sucker fish?"
							)
							((Said '/fish,carp,sucker')
								(localproc_0 64 25) ; "They taste terrible, and besides...they're NOT evidence!"
							)
							((Said '/newspaper')
								(if
									(or
										(gEgo inRect: 106 94 165 124)
										(gEgo inRect: 240 94 284 122)
									)
									(localproc_0 64 12) ; "It's too wet to read. It's of no use."
								else
									(localproc_0 64 26) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/can[<beer,coca]')
								(if (gEgo inRect: 155 105 193 141)
									(localproc_0 64 27) ; "You take the can, look at it, and discard it."
								else
									(localproc_0 64 26) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/metal,scrap')
								(if (gEgo inRect: 50 107 106 132)
									(localproc_0 64 28) ; "You don't need it."
								else
									(localproc_0 64 26) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/bottle')
								(if (gEgo inRect: 193 134 240 164)
									(localproc_0 64 29) ; "It's broken and worthless."
								else
									(localproc_0 64 26) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/knife')
								(if (IsItemAt 14) ; makeshift_knife
									(if
										(or
											(and
												(gEgo inRect: 92 128 150 152)
												(== (gEgo loop:) 0)
											)
											(and
												(gEgo
													inRect: 150 128 184 152
												)
												(== (gEgo loop:) 1)
											)
											(and
												(gEgo
													inRect: 120 133 160 139
												)
												(== (gEgo loop:) 2)
											)
											(and
												(gEgo
													inRect: 120 135 160 165
												)
												(== (gEgo loop:) 3)
											)
										)
										(knife posn: 0 0)
										(gEgo get: 14) ; makeshift_knife
										(SetScore 2)
										(localproc_0 64 30 83) ; "After picking it up, you look at the object, which is sharpened to a point. All of a sudden, in your head, a light comes on."
										(localproc_0 64 31 83) ; "You remember what the prisoner said; how the suspect held a makeshift knife on the jailer during the escape."
										(localproc_0 64 32 83) ; "You slip the knife into your belt and keep it as evidence."
									else
										(Print 64 33) ; "You see nothing like that. But then, you must be close to objects to see them underwater."
									)
								else
									(proc0_8) ; "You already took it."
								)
							)
							((Said '/object')
								(cond
									(
										(or
											(gEgo inRect: 106 94 165 124)
											(gEgo inRect: 240 94 284 122)
										)
										(localproc_0 64 12) ; "It's too wet to read. It's of no use."
									)
									((gEgo inRect: 155 105 193 141)
										(localproc_0 64 27) ; "You take the can, look at it, and discard it."
									)
									((gEgo inRect: 50 107 106 132)
										(localproc_0 64 28) ; "You don't need it."
									)
									((gEgo inRect: 193 134 240 164)
										(localproc_0 64 29) ; "It's broken and worthless."
									)
									(
										(and
											(IsItemAt 14) ; makeshift_knife
											(or
												(and
													(gEgo
														inRect: 92 128 150 152
													)
													(== (gEgo loop:) 0)
												)
												(and
													(gEgo
														inRect: 150 128 184 152
													)
													(== (gEgo loop:) 1)
												)
												(and
													(gEgo
														inRect: 120 133 160 139
													)
													(== (gEgo loop:) 2)
												)
												(and
													(gEgo
														inRect: 120 135 160 165
													)
													(== (gEgo loop:) 3)
												)
											)
										)
										(knife posn: 0 0)
										(gEgo get: 14) ; makeshift_knife
										(SetScore 2)
										(localproc_0 64 30 83) ; "After picking it up, you look at the object, which is sharpened to a point. All of a sudden, in your head, a light comes on."
										(localproc_0 64 31 83) ; "You remember what the prisoner said; how the suspect held a makeshift knife on the jailer during the escape."
										(localproc_0 64 32 83) ; "You slip the knife into your belt and keep it as evidence."
									)
									(else
										(localproc_0 64 26 83) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
									)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance rm64Script of Script
	(properties)

	(method (doit)
		(if (> local108 1)
			(-- local108)
		)
		(if (== local108 1)
			(= local108 0)
			(if (== local109 1)
				(carpScript changeState: 0)
			else
				(carpScript changeState: 1)
			)
		)
		(if (not local103)
			(gEgo x: (+ 1 (gEgo x:)))
			(if (> local102 1)
				(-- local102)
			)
			(if (== local102 1)
				(= local102 0)
				(rm64Script changeState: 1)
			)
			(cond
				((== (gEgo edgeHit:) EDGE_RIGHT)
					(gCurRoom newRoom: 63)
				)
				(
					(and
						(or
							(and (< (gEgo x:) 83) (< (gEgo y:) 92))
							(and (> (gEgo x:) 285) (< (gEgo y:) 92))
						)
						(== local107 0)
					)
					(localproc_0 64 34) ; "It's a real tight fit back here, and you can't see a thing."
					(= local107 1)
				)
				((and (> (gEgo x:) 105) (< (gEgo x:) 265))
					(= local107 0)
				)
			)
		)
		(if (and (> global191 0) (>= local105 0))
			(-= global191 2)
			(= local105 local106)
		)
		(if (> local105 0)
			(-- local105)
		)
		(cond
			((and (or (<= 0 global191 6) (> global191 2300)) (not local103))
				(localproc_0 64 35) ; ""ARRGGGHH!!!"....This is your final word as blackness overcomes you. Next time, be more aware of the requirements of diving."
				(if (IsFlag 7)
					(EgoDead
						{As you fight for air, blackness overcomes you. Next time, be more aware of your air tank's reserve.}
					)
				else
					(EgoDead
						{As you fight for air, blackness overcomes you. Next time, try using the bouyancy control vest to conserve air.}
					)
				)
			)
			((and (<= 8 global191 15) (not local103))
				(airScript changeState: 2)
				(= global191 7)
				(localproc_0 64 36) ; "Your mind is starting to go hazy as you realize that your air supply is gone."
			)
			((and (<= 40 global191 50) (not local103))
				(airScript changeState: 2)
				(= global191 39)
				(localproc_0 64 37) ; "You are having trouble getting enough air."
			)
		)
		(if (> local104 1)
			(-- local104)
		)
		(if (== local104 1)
			(= local104 0)
			(airScript changeState: 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 12
					setStep: 3 2
					posn: 290 (gEgo y:)
					setCycle: Walk
					setMotion: MoveTo -10 (gEgo y:)
					illegalBits: $8000
					init:
				)
				(bubble
					view: 12
					setLoop: 4
					xStep: 4
					setCycle: Walk
					setPri: 14
					ignoreActors:
					illegalBits: 0
					init:
					stopUpd:
				)
				(= local102 (Random 18 26))
			)
			(1
				(switch (gEgo loop:)
					(0
						(= local100 (+ (gEgo x:) 21))
					)
					(1
						(= local100 (- (gEgo x:) 21))
					)
					(2
						(= local100 (gEgo x:))
					)
					(3
						(= local100 (gEgo x:))
					)
				)
				(bubble
					posn: local100 (gEgo y:)
					startUpd:
					setPri: (gEgo priority:)
					setMotion: MoveTo (+ local100 30) 15 self
				)
			)
			(2
				(bubble stopUpd:)
				(= local102 (Random 24 36))
			)
			(3
				(User canControl: 0 canInput: 0)
				(= local103 1)
				(gEgo
					view: 489
					setLoop: 3
					cycleSpeed: 2
					illegalBits: 0
					ignoreActors:
					setCycle: End self
				)
			)
			(4
				(= global189 16)
				(gEgo
					setLoop: 5
					setStep: 5 3
					setPri: 15
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo (+ (gEgo x:) 90) 55 self
				)
			)
			(5
				(DisposeScript 988)
				(gContinuousMusic stop:)
				(gCurRoom newRoom: 62)
			)
		)
	)
)

(instance airScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawCel 161 4 0 40 16 1)
				(= local104 15)
				(self cue:)
			)
			(1
				(Format @local0 64 38 global191) ; "%u"
				(Display @local0 dsCOORD 54 30 dsCOLOR 14 dsBACKGROUND 1)
			)
			(2
				(DrawCel 161 4 1 40 16 1)
				(Display @local0 dsCOORD 54 30 dsCOLOR 1 dsBACKGROUND 1)
			)
		)
	)
)

(instance carpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carp setLoop: 1 setCel: 1 setMotion: MoveTo 65 191 setCycle: 0)
				(= local109 0)
				(= local108 100)
			)
			(1
				(carp
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 355 175
					setCycle: 0
				)
				(= local109 1)
				(= local108 150)
			)
		)
	)
)

