;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
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
	rm63 0
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
)

(procedure (localproc_0)
	(Print &rest #at -1 40)
)

(instance bubble of Act
	(properties)
)

(instance mooreBubble of Act
	(properties)
)

(instance badge of View
	(properties)
)

(instance carp of Act
	(properties)
)

(instance weed0 of Extra
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

(instance frogLegs of Prop
	(properties)
)

(instance moore of View
	(properties)
)

(instance rm63 of Rm
	(properties
		picture 63
		style 8
	)

	(method (dispose)
		(mooreScript dispose:)
		(carpScript dispose:)
		(airScript dispose:)
		(bubScript dispose:)
		(DisposeScript 988)
		(super dispose:)
	)

	(method (init)
		(User canInput: 1)
		(User canControl: 1)
		(Load rsSCRIPT 988)
		(Load rsVIEW 12)
		(Load rsVIEW 165)
		(Load rsVIEW 91)
		(Load rsVIEW 161)
		(mooreScript changeState: 0)
		(weed0
			pauseCel: -1
			minPause: 10
			maxPause: 30
			minCycles: 8
			maxCycles: 18
			isExtra: 1
			view: 91
			posn: 7 163
			loop: 4
			cel: 0
			setPri: 12
			init:
		)
		(weed1
			pauseCel: -1
			minPause: 10
			maxPause: 30
			minCycles: 8
			maxCycles: 18
			isExtra: 1
			view: 91
			loop: 6
			cel: 2
			posn: 14 171
			setPri: 13
			init:
		)
		(weed2
			pauseCel: -1
			minPause: 10
			maxPause: 30
			minCycles: 8
			maxCycles: 18
			isExtra: 1
			view: 91
			loop: 6
			cel: 2
			posn: 102 95
			setPri: 6
			init:
		)
		(weed3
			pauseCel: -1
			minPause: 10
			maxPause: 20
			minCycles: 10
			maxCycles: 18
			isExtra: 1
			view: 91
			loop: 6
			cel: 2
			posn: 267 118
			setPri: 8
			init:
		)
		(weed4
			pauseCel: -1
			minPause: 10
			maxPause: 30
			minCycles: 8
			maxCycles: 18
			isExtra: 1
			view: 91
			loop: 7
			cel: 2
			posn: 37 123
			setPri: 8
			init:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 5
			posn: 70 179
			setPri: 12
			init:
			addToPic:
			ignoreActors:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 6
			posn: 39 108
			setPri: 7
			init:
			addToPic:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 4
			posn: 278 154
			setPri: 11
			init:
			addToPic:
			ignoreActors:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 0
			posn: 143 167
			setPri: 12
			init:
			addToPic:
			ignoreActors:
		)
		((View new:)
			view: 91
			loop: 3
			cel: 3
			posn: 240 122
			setPri: 8
			init:
			addToPic:
			ignoreActors:
		)
		(if (IsItemAt 18) ; lost_badge
			(badge view: 91 loop: 3 cel: 7 posn: 197 153 init: ignoreActors:)
		)
		(if (not (< global110 30))
			(carp
				view: 165
				setCycle: 0
				posn: -25 154
				setPri: 12
				illegalBits: 0
				init:
				ignoreActors:
				setScript: carpScript
			)
		)
		(= local108 (if (IsFlag 7) 6 else 2))
		(= local102 (Random 1 7))
		(moore
			view: 12
			loop: 5
			posn:
				(switch local102
					(1 158)
					(2 150)
					(3 286)
					(4 275)
					(5 236)
					(6 95)
					(7 198)
				)
				(switch local102
					(1 93)
					(2 186)
					(3 95)
					(4 121)
					(5 145)
					(6 124)
					(7 162)
				)
			init:
			addToPic:
		)
		(frogLegs
			view: 12
			loop: 6
			posn: (moore x:) (moore y:)
			setCycle: Fwd
			cycleSpeed: 2
			init:
		)
		(bubble
			view: 12
			setLoop: 4
			xStep: 4
			setCycle: Walk
			setPri: 12
			ignoreActors:
			illegalBits: 0
			init:
			stopUpd:
			setScript: bubScript
		)
		(mooreBubble
			view: 12
			setLoop: 4
			xStep: 4
			setCycle: Fwd
			setPri: 12
			ignoreActors:
			illegalBits: 0
			init:
			stopUpd:
			setScript: mooreScript
		)
		(gEgo init:)
		(super init:)
		(self setScript: rm63Script)
	)
)

(instance rm63Script of Script
	(properties)

	(method (doit)
		(if (and (== (self state:) 2) (not local109))
			(gEgo x: (+ (gEgo x:) 1))
			(if (> local103 1)
				(-- local103)
			)
			(if (== local103 1)
				(= local103 0)
				(bubScript changeState: 1)
			)
		)
		(if (> local104 1)
			(-- local104)
		)
		(if (== local104 1)
			(= local104 0)
			(mooreScript changeState: 1)
		)
		(if (> local105 1)
			(-- local105)
		)
		(if (== local105 1)
			(= local105 0)
			(if (== local110 1)
				(carpScript changeState: 0)
			else
				(carpScript changeState: 1)
			)
		)
		(if (and (> global191 0) (>= local107 0))
			(-= global191 2)
			(= local107 local108)
		)
		(if (> local107 0)
			(-- local107)
		)
		(cond
			((and (or (<= 0 global191 6) (> global191 2300)) (not local109))
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
			((and (<= 8 global191 15) (not local109))
				(airScript changeState: 2)
				(= global191 7)
				(localproc_0 63 0) ; "Your mind is starting to go hazy as you realize that your air supply is gone."
			)
			((and (<= 40 global191 50) (not local109))
				(airScript changeState: 2)
				(= global191 39)
				(localproc_0 63 1) ; "You are having trouble getting enough air."
			)
		)
		(if (> local106 1)
			(-- local106)
		)
		(if (== local106 1)
			(= local106 0)
			(airScript changeState: 2)
		)
		(cond
			((== (gEgo edgeHit:) EDGE_LEFT)
				(gCurRoom
					newRoom:
						(if local109
							(gContinuousMusic stop:)
							(DisposeScript 988)
							62
						else
							64
						)
				)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(gCurRoom newRoom: 65)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 60)
					(= local109 1)
					(HandsOff)
					(gEgo
						view: 489
						setStep: 2 2
						setLoop: 0
						posn: 30 50
						setPri: 15
						illegalBits: 0
						ignoreActors: 1
						setMotion: MoveTo 110 130 self
					)
					(= global189 16)
				else
					(gEgo
						posn:
							(switch gPrevRoomNum
								(64 30)
								(65 290)
							)
							(gEgo y:)
						setMotion:
							MoveTo
							(if (== gPrevRoomNum 65) -10 else 350)
							(gEgo y:)
					)
					(self changeState: 2)
				)
			)
			(1
				(gEgo
					setLoop: 1
					setPri: 15
					setMotion: MoveTo 400 134
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(= local109 0)
				(gEgo
					cycleSpeed: 0
					view: 12
					setCycle: Walk
					setStep: 3 2
					setLoop: -1
					setPri: -1
					illegalBits: $8000
					ignoreActors: 0
				)
				(if (== gPrevRoomNum 60)
					(if (not (IsFlag 6))
						(localproc_0 63 2) ; "Without the weight belt, you struggle to stay down."
						(= local109 1)
						(gEgo
							setStep: 2 2
							illegalBits: 0
							ignoreActors:
							setMotion: MoveTo 225 132 self
						)
					else
						(gEgo setMotion: MoveTo 400 134)
						(HandsOn)
					)
				)
			)
			(3
				(localproc_0 63 3) ; "Exhausted from the effort, you decide to surface."
				(self cue:)
			)
			(4
				(User canControl: 0 canInput: 0)
				(= local109 1)
				(gEgo
					view: 489
					setLoop: 2
					cycleSpeed: 2
					illegalBits: 0
					ignoreActors:
					setCycle: End self
				)
			)
			(5
				(gEgo
					setLoop: 4
					setStep: 5 3
					setPri: 15
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo (- (gEgo x:) 90) 55 self
				)
			)
			(6
				(DisposeScript 988)
				(gContinuousMusic stop:)
				(gCurRoom newRoom: 62)
			)
		)
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
					((Said 'talk')
						(Print 63 4) ; "You can't talk NOW!"
					)
					((Said '/briefcase')
						(Print 63 5) ; "You don't have your field kit."
					)
					(
						(Said
							'remove,(get<off)/belt,bcv,tank,fin,mask,suit,equipment'
						)
						(Print 63 6) ; "Taking off your scuba equipment is not a good idea."
					)
					(
						(Said
							'[check]/air,pressure,(supply[<air]),(tank[<air]),(gauge[<air,pressure])'
						)
						(airScript changeState: 0)
					)
					((or (Said '<up') (Said '/rise,lid') (Said 'rise'))
						(rm63Script changeState: 4)
					)
					((Said 'look>')
						(cond
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
								(localproc_0 63 7) ; "Along with the junk, you see an old car on the bottom. There are huge boulders on the far side."
							)
							((Said '<up')
								(localproc_0 63 8) ; "You see sunlight rippling through from the surface."
							)
							(
								(or
									(Said '/bottom,muck,bed[<clearwater]')
									(Said '<down,ahead')
									(Said '/object,dirt')
								)
								(cond
									((gEgo inRect: 0 147 110 191)
										(localproc_0 63 9) ; "You find an old discarded wallet. Endless volumes of water have rendered it worthless."
									)
									((gEgo inRect: 239 129 319 191)
										(localproc_0 63 10) ; "Its just a waterlogged piece of paper."
									)
									((gEgo inRect: 0 95 118 112)
										(localproc_0 63 11) ; "The old car has been sitting here rusting away for a long time now."
									)
									(
										(and
											(IsItemAt 18) ; lost_badge
											(or
												(and
													(gEgo
														inRect: 146 141 186 158
													)
													(== (gEgo loop:) 0)
												)
												(and
													(gEgo
														inRect: 213 143 245 158
													)
													(== (gEgo loop:) 1)
												)
												(and
													(gEgo
														inRect: 184 137 205 149
													)
													(== (gEgo loop:) 2)
												)
												(and
													(gEgo
														inRect: 184 155 206 169
													)
													(== (gEgo loop:) 3)
												)
											)
										)
										(localproc_0 63 12) ; "You see a flicker of gold from the corner of your eye."
										(localproc_0 63 13) ; "You are amazed at what you think this object could be."
									)
									((gEgo inRect: 108 139 189 189)
										(localproc_0 63 14) ; "Nothing but a rusted-out old beer can. You can tell it's an oldie by the fact that someone had to use a 'church key' on it. No 'pop-tops' in those days."
									)
									((gEgo inRect: 200 100 319 129)
										(localproc_0 63 15) ; "It's metal, but you can't make out what it is."
									)
									((gEgo inRect: 105 109 159 139)
										(localproc_0 63 16) ; "It's a pair of algae-covered underwater goggles, lost by a swimmer in the murky past."
									)
									((gEgo inRect: 0 112 108 139)
										(localproc_0 63 17) ; "There's a bald truck tire nestled deep in the mud next to a 55-gallon oil drum."
									)
									(else
										(localproc_0 63 18) ; "There is a lot of mud and trash on the river bottom. You will have to search it for clues or evidence."
									)
								)
							)
							((Said '/auto')
								(if (< (gEgo x:) 160)
									(localproc_0 63 11) ; "The old car has been sitting here rusting away for a long time now."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/number,license')
								(if (gEgo inRect: 0 95 118 112)
									(localproc_0 63 20) ; "The numbers have rusted and deteriorated to the point that you can't make them out."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/newspaper')
								(if (gEgo inRect: 239 129 319 191)
									(localproc_0 63 10) ; "Its just a waterlogged piece of paper."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/billfold')
								(if (gEgo inRect: 0 147 110 191)
									(localproc_0 63 9) ; "You find an old discarded wallet. Endless volumes of water have rendered it worthless."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/can[<beer,coca]')
								(if (gEgo inRect: 108 139 189 189)
									(localproc_0 63 14) ; "Nothing but a rusted-out old beer can. You can tell it's an oldie by the fact that someone had to use a 'church key' on it. No 'pop-tops' in those days."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/metal,scrap')
								(if (gEgo inRect: 200 100 319 129)
									(localproc_0 63 21) ; "It's just a twisted scrap of metal, useless to you."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/gold,metal,flicker,badge')
								(cond
									((gEgo has: 18) ; lost_badge
										(event claimed: 0)
									)
									(
										(or
											(and
												(gEgo
													inRect: 146 141 186 158
												)
												(== (gEgo loop:) 0)
											)
											(and
												(gEgo
													inRect: 213 143 245 158
												)
												(== (gEgo loop:) 1)
											)
											(and
												(gEgo
													inRect: 184 137 205 149
												)
												(== (gEgo loop:) 2)
											)
											(and
												(gEgo
													inRect: 184 155 206 169
												)
												(== (gEgo loop:) 3)
											)
										)
										(localproc_0 63 12) ; "You see a flicker of gold from the corner of your eye."
										(localproc_0 63 13) ; "You are amazed at what you think this object could be."
									)
									(else
										(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
									)
								)
							)
							((Said '/glasses,glass')
								(if (gEgo inRect: 105 109 159 139)
									(localproc_0 63 16) ; "It's a pair of algae-covered underwater goggles, lost by a swimmer in the murky past."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/tire,drum[<oil]')
								(if (gEgo inRect: 0 112 108 139)
									(localproc_0 63 17) ; "There's a bald truck tire nestled deep in the mud next to a 55-gallon oil drum."
								else
									(localproc_0 63 19) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/cave')
								(localproc_0 63 22) ; "Although it looks like there's a cave, there really isn't."
							)
							((Said '/rock,boulder')
								(localproc_0 63 23) ; "You see nothing unusual. In fact, these rocks are downright boring."
							)
							((Said '/plant,bush,grass')
								(localproc_0 63 24) ; "A common variety of river bottom plant."
							)
							(
								(or
									(Said '/fish,carp,sucker')
									(Said '/school[<fish,carp,sucker]')
								)
								(localproc_0 63 25) ; "You look at a small school of "scaly-skinned" sucker fish, otherwise known as "carp". They are incompatible with the gullet, due to the numerous amount of bones."
							)
							((Said '/crawfish')
								(localproc_0 63 26) ; "Man, can they scuttle!"
							)
							((Said '/diver')
								(localproc_0 63 27) ; "He's exploring the flora, fauna, and garbage....looking for evidence."
							)
						)
					)
					((Said 'check,frisk/auto')
						(localproc_0 63 28) ; "You see mud, rust, and a couple of crawfish."
					)
					((Said '[get]/shit')
						(localproc_0 63 29) ; "As your wet suit fills, you think to yourself... "Why did I do that?""
					)
					((Said '[get]/leak')
						(localproc_0 63 30) ; "A warm feeling comes over you."
					)
					((or (Said 'remove,recover,tow/auto') (Said 'call/tow'))
						(localproc_0 63 31) ; "Forget it! Nothing about this car will help you. The fish need it more than anyone else."
					)
					((Said 'move/rock')
						(localproc_0 63 32) ; "There is no need to move this rock."
					)
					((Said 'get,move,pull,hoist,remove>')
						(cond
							((Said '/crawfish')
								(localproc_0 63 33) ; "They're a little too fast for you."
							)
							((Said '/muck,garbage')
								(localproc_0 63 34) ; "It would just cloud the water."
							)
							((Said '/grass,plant')
								(localproc_0 63 35) ; "Why tear up the natural habitat of the "scaly-skinned" sucker fish?"
							)
							((Said '/fish,carp,sucker')
								(localproc_0 63 36) ; "They taste terrible, and besides...they're NOT evidence!"
							)
							((Said '/auto')
								(localproc_0 63 31) ; "Forget it! Nothing about this car will help you. The fish need it more than anyone else."
							)
							((Said '/newspaper')
								(if (gEgo inRect: 239 129 319 191)
									(localproc_0 63 37) ; "It wouldn't help you."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/billfold')
								(if (gEgo inRect: 0 147 110 191)
									(localproc_0 63 38) ; "You don't need it; you already have a much nicer wallet."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/can[<beer,coca]')
								(if (gEgo inRect: 108 139 189 189)
									(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/glasses')
								(if (gEgo inRect: 105 109 159 139)
									(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/tire,drum[<oil]')
								(if (gEgo inRect: 0 112 108 139)
									(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/badge,gold,flicker')
								(cond
									((not (IsItemAt 18)) ; lost_badge
										(proc0_8) ; "You already took it."
									)
									(
										(or
											(and
												(gEgo
													inRect: 146 141 186 158
												)
												(== (gEgo loop:) 0)
											)
											(and
												(gEgo
													inRect: 213 143 245 158
												)
												(== (gEgo loop:) 1)
											)
											(and
												(gEgo
													inRect: 184 137 205 149
												)
												(== (gEgo loop:) 2)
											)
											(and
												(gEgo
													inRect: 184 155 206 169
												)
												(== (gEgo loop:) 3)
											)
										)
										(badge posn: 0 0)
										(gEgo get: 18) ; lost_badge
										(SetScore 2)
										(localproc_0 63 40 83) ; "You brush the mud off of an object that appears to be a badge."
										(localproc_0 63 41 83) ; "You look at the badge and think to yourself, "This is like finding a needle in a haystack.""
									)
									(else
										(proc0_7) ; "You're not close enough."
									)
								)
							)
							((Said '/scrap')
								(if (gEgo inRect: 200 100 319 129)
									(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/object,metal')
								(cond
									(
										(or
											(and
												(gEgo
													inRect: 146 141 186 158
												)
												(== (gEgo loop:) 0)
											)
											(and
												(gEgo
													inRect: 213 143 245 158
												)
												(== (gEgo loop:) 1)
											)
											(and
												(gEgo
													inRect: 184 137 205 149
												)
												(== (gEgo loop:) 2)
											)
											(and
												(gEgo
													inRect: 184 155 206 169
												)
												(== (gEgo loop:) 3)
											)
										)
										(if (IsItemAt 18) ; lost_badge
											(badge posn: 0 0)
											(gEgo get: 18) ; lost_badge
											(SetScore 2)
											(localproc_0 63 40 83) ; "You brush the mud off of an object that appears to be a badge."
											(localproc_0 63 41 83) ; "You look at the badge and think to yourself, "This is like finding a needle in a haystack.""
										else
											(proc0_8) ; "You already took it."
										)
									)
									((gEgo inRect: 239 129 319 191)
										(localproc_0 63 37) ; "It wouldn't help you."
									)
									((gEgo inRect: 0 147 110 191)
										(localproc_0 63 38) ; "You don't need it; you already have a much nicer wallet."
									)
									((gEgo inRect: 108 139 189 189)
										(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
									)
									((gEgo inRect: 200 100 319 129)
										(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
									)
									((gEgo inRect: 105 109 159 139)
										(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
									)
									((gEgo inRect: 0 112 108 139)
										(localproc_0 63 39) ; "You don't need it, and besides...it's too slimy and old."
									)
									(else
										(localproc_0 63 42 83) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
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

(instance carpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carp
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 365 148
					setCycle: 0
				)
				(= local110 0)
				(= local105 150)
			)
			(1
				(carp
					setLoop: 0
					setCel: 1
					setMotion: MoveTo -25 154
					setCycle: 0
				)
				(= local110 1)
				(= local105 150)
			)
		)
	)
)

(instance mooreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local104 (Random 4 8))
				(if (== gPrevRoomNum 60)
					(gContinuousMusic number: 17 loop: -1 play:)
				)
			)
			(1
				(= local101 (- (frogLegs x:) 20))
				(mooreBubble
					posn: local101 (moore y:)
					startUpd:
					setPri: (frogLegs priority:)
					setMotion: MoveTo (+ local101 50) 15 self
				)
			)
			(2
				(mooreBubble stopUpd:)
				(= local104 (Random 20 26))
			)
		)
	)
)

(instance airScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawCel 161 0 0 227 16 1)
				(= local106 15)
				(self cue:)
			)
			(1
				(Format @local0 63 43 global191) ; "%u"
				(Display @local0 dsCOORD 244 30 dsCOLOR 14 dsBACKGROUND 1)
			)
			(2
				(DrawCel 161 0 1 227 16 1)
				(Display @local0 dsCOORD 244 30 dsCOLOR 1 dsBACKGROUND 1)
			)
		)
	)
)

(instance bubScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local103 (Random 18 26))
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
					setMotion: MoveTo (+ local100 50) 15 self
				)
			)
			(2
				(bubble stopUpd:)
				(= local103 (Random 22 32))
			)
		)
	)
)

