;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm65 0
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
)

(procedure (localproc_0)
	(Print &rest #at -1 40)
)

(instance carp of Act
	(properties)
)

(instance hand of View
	(properties)
)

(instance body of View
	(properties)
)

(instance divers of View
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

(instance weed5 of Extra
	(properties)
)

(instance weed6 of Extra
	(properties)
)

(instance weed7 of Extra
	(properties)
)

(instance can of View
	(properties)
)

(instance paper of View
	(properties)
)

(instance bottle of View
	(properties)
)

(instance metal of View
	(properties)
)

(instance findMusic of Sound
	(properties
		number 19
		priority 12
	)
)

(instance sweepMusic of Sound
	(properties
		number 37
		priority 12
	)
)

(instance rm65 of Rm
	(properties
		picture 65
		style 8
	)

	(method (dispose)
		(carpScript dispose:)
		(bodyScript dispose:)
		(airScript dispose:)
		(DisposeScript 988)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 12)
		(Load rsVIEW 91)
		(Load rsVIEW 161)
		(= local109 (if (IsFlag 7) 5 else 2))
		(weed1
			pauseCel: -1
			minPause: 8
			maxPause: 30
			minCycles: 10
			maxCycles: 20
			isExtra: 1
			view: 91
			loop: 5
			cel: 0
			posn: 304 173
			init:
			ignoreActors:
		)
		(weed2
			pauseCel: -1
			minPause: 8
			maxPause: 30
			minCycles: 10
			maxCycles: 20
			isExtra: 1
			view: 91
			loop: 5
			cel: 0
			posn: 253 94
			init:
			ignoreActors:
		)
		(weed3
			pauseCel: -1
			minPause: 10
			maxPause: 22
			minCycles: 10
			maxCycles: 20
			isExtra: 1
			view: 91
			loop: 5
			cel: 0
			posn: 282 109
			init:
			ignoreActors:
		)
		(weed4
			pauseCel: -1
			minPause: 12
			maxPause: 40
			minCycles: 10
			maxCycles: 20
			isExtra: 1
			view: 91
			loop: 6
			cel: 3
			posn: 3 149
			init:
			ignoreActors:
		)
		(weed5
			pauseCel: -1
			minPause: 14
			maxPause: 30
			minCycles: 6
			maxCycles: 18
			view: 91
			loop: 7
			cel: 0
			posn: 47 90
			init:
			ignoreActors:
			isExtra: 1
		)
		(weed6
			pauseCel: -1
			minPause: 14
			maxPause: 30
			minCycles: 6
			maxCycles: 20
			view: 91
			loop: 6
			cel: 0
			posn: 32 101
			init:
			ignoreActors:
			isExtra: 1
		)
		(weed7
			pauseCel: -1
			minPause: 12
			maxPause: 20
			minCycles: 12
			maxCycles: 20
			view: 91
			loop: 5
			cel: 0
			posn: 262 124
			init:
			ignoreActors:
			isExtra: 1
		)
		(can
			view: 91
			loop: 3
			cel: 9
			posn: 194 174
			init:
			ignoreActors:
			addToPic:
		)
		(paper
			view: 91
			loop: 3
			cel: 1
			posn: 106 163
			init:
			ignoreActors:
			addToPic:
		)
		(bottle
			view: 91
			loop: 3
			cel: 2
			posn: 45 116
			init:
			ignoreActors:
			addToPic:
		)
		(metal
			view: 91
			loop: 3
			cel: 3
			posn: 202 140
			init:
			ignoreActors:
			addToPic:
		)
		(hand
			view: 91
			loop: 3
			cel: (if (IsFlag 108) 11 else 10)
			posn: 296 129
			init:
			ignoreActors:
		)
		(body view: 91 loop: 9 cel: 0 posn: 0 0 init: setPri: 15 ignoreActors:)
		(carp
			view: 165
			setCycle: 0
			posn: 0 169
			setPri: 13
			illegalBits: 0
			init:
			ignoreActors:
			setScript: carpScript
		)
		(super init:)
		(self setScript: rm65Script)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(if (> local103 0)
					(= local103 3)
				)
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
				(event claimed: global184)
			)
			(evSAID
				(cond
					((or (Said '<up') (Said '/rise,lid') (Said 'rise'))
						(rm65Script changeState: 3)
					)
					((Said '/briefcase')
						(Print 65 0) ; "You don't have your field kit."
					)
					(
						(Said
							'remove,(get<off)/belt,bcv,tank,fin,mask,suit,equipment'
						)
						(Print 65 1) ; "Taking off your scuba equipment is not a good idea."
					)
					(
						(Said
							'[check]/air,pressure,(supply[<air]),(tank[<air]),(gauge[<air,pressure])'
						)
						(airScript changeState: 0)
					)
					((Said 'frisk/body')
						(Print 65 2) ; "You'd better get the body out of the river first."
					)
					((Said 'look>')
						(cond
							(
								(Said
									'[<at,around][/!*,clearwater,water,garbage,crud]'
								)
								(localproc_0 65 3) ; "Along with the river bottom vegetation, you see many large boulders. An old tire is half buried in the mud. The wreck of a small rowboat lies against the rocks."
							)
							(
								(Said
									'/air,pressure,(supply[<air]),(tank[<air]),(gauge[<air,pressure])'
								)
								(airScript changeState: 0)
							)
							((Said '/hand')
								(cond
									(
										(and
											(gEgo inRect: 244 125 319 145)
											(IsFlag 108)
										)
										(gContinuousMusic stop:)
										(findMusic play:)
										(bodyScript changeState: 2)
									)
									((IsFlag 108)
										(localproc_0 65 4) ; "You're not close enough."
									)
									(else
										(localproc_0 65 5) ; "Huh??"
									)
								)
							)
							((Said '/rock,boulder')
								(if
									(and
										(not (IsFlag 108))
										(gEgo inRect: 244 125 319 145)
										(or
											(== (gEgo loop:) 0)
											(== (gEgo loop:) 3)
										)
									)
									(localproc_0 65 6) ; "You notice something apparently hidden behind some rocks."
								else
									(localproc_0 65 7) ; "You see nothing unusual. You're getting pretty tired of looking at rocks."
								)
							)
							((Said '/fish,carp,sucker')
								(localproc_0 65 8) ; "You look at a small school of the "scaly-skinned" sucker fish, otherwise known as "carp". They are incompatible with the gullet due to the numerous amount of bones."
							)
							((Said '<up')
								(localproc_0 65 9) ; "You see sunlight rippling through from the surface."
							)
							((Said '/boat')
								(localproc_0 65 10) ; "It's a WRECK! No way to bail out of this baby!"
							)
							((Said '/grass,plant,bush')
								(localproc_0 65 11) ; "A common variety of river bottom plant."
							)
							((Said '/bottle[<beer]')
								(if (gEgo inRect: 0 90 87 130)
									(localproc_0 65 12) ; "Looks like an old wine bottle."
								else
									(localproc_0 65 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/newspaper,wrapper')
								(if (gEgo inRect: 0 130 110 189)
									(localproc_0 65 14) ; "It's just a water-logged candy wrapper."
								else
									(localproc_0 65 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/metal')
								(if (gEgo inRect: 174 111 226 150)
									(localproc_0 65 15) ; "It's metal, but you can't make out what it is."
								else
									(localproc_0 65 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/can[<coca,beer]')
								(if (gEgo inRect: 179 150 226 189)
									(localproc_0 65 16) ; "Just a discarded, rusty old can."
								else
									(localproc_0 65 13) ; "You can't see it clearly from where you are. As a matter of fact, you have to be pretty close to see most objects underwater."
								)
							)
							((Said '/tire')
								(localproc_0 65 17) ; "You see a half buried old tire next to the rock face."
							)
							((Said '/body,luis,body')
								(cond
									(
										(and
											(gEgo inRect: 244 125 319 145)
											(IsFlag 109)
										)
										(Print 65 18 #at -1 145) ; "It would be better to remove the body from the river first."
									)
									(
										(and
											(gEgo inRect: 244 125 319 145)
											(IsFlag 108)
											(not (IsFlag 109))
										)
										(bodyScript changeState: 2)
									)
									((IsFlag 108)
										(localproc_0 65 4) ; "You're not close enough."
									)
									(else
										(localproc_0 65 5) ; "Huh??"
									)
								)
							)
							(
								(or
									(Said '/bottom,muck,bed[<clearwater]')
									(Said '<down,ahead')
									(Said '/object,dirt')
								)
								(cond
									(
										(and
											(not (IsFlag 108))
											(gEgo inRect: 244 125 319 145)
											(or
												(== (gEgo loop:) 0)
												(== (gEgo loop:) 3)
											)
										)
										(localproc_0 65 6) ; "You notice something apparently hidden behind some rocks."
									)
									((gEgo inRect: 179 150 226 189)
										(localproc_0 65 16) ; "Just a discarded, rusty old can."
									)
									((gEgo inRect: 0 130 110 189)
										(localproc_0 65 14) ; "It's just a water-logged candy wrapper."
									)
									((gEgo inRect: 174 111 226 150)
										(localproc_0 65 15) ; "It's metal, but you can't make out what it is."
									)
									((gEgo inRect: 0 90 87 130)
										(localproc_0 65 12) ; "Looks like an old wine bottle."
									)
									((gEgo inRect: 87 115 180 130)
										(localproc_0 65 10) ; "It's a WRECK! No way to bail out of this baby!"
									)
									(else
										(localproc_0 65 19) ; "There is a lot of mud and trash on the river bottom. You will have to search it for clues or evidence."
									)
								)
							)
						)
					)
					((Said 'move,hoist,remove/rock')
						(if (gEgo inRect: 244 125 319 145)
							(if (not (IsFlag 108))
								(bodyScript changeState: 0)
							else
								(localproc_0 65 20) ; "The rock has been moved."
							)
						else
							(Print 65 21 #at -1 145 #draw) ; "In general, moving the rocks down here would stir up a lot of mud."
						)
					)
					((Said 'get,remove,hoist/body,luis,body')
						(if (IsFlag 109)
							(bodyScript changeState: 3)
						else
							(Print 65 22 #at -1 145) ; "What body? Where?"
						)
					)
					((Said 'get,move,pull,hoist,remove>')
						(cond
							((Said '/grass,plant,bush')
								(localproc_0 65 23) ; "You have more important things to do."
							)
							((Said '/tire')
								(localproc_0 65 24) ; "You would consume all your air digging that tire out. It wouldn't fit in the patrol car, anyway."
							)
							((Said '/fish,carp,sucker')
								(localproc_0 65 25) ; "They taste terrible, and besides...they're NOT evidence!"
							)
							((Said '/boat')
								(localproc_0 65 26) ; "You could dry it out and use it for firewood. It's worthless for anything else."
							)
							((Said '/bottle[<beer]')
								(if (gEgo inRect: 0 90 87 130)
									(localproc_0 65 27) ; "It's of no use to you...the wine is long gone."
								else
									(localproc_0 65 28) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/can[<coca,beer]')
								(if (gEgo inRect: 179 150 226 189)
									(localproc_0 65 29) ; "It's of no use to you...the beer that was in it is long gone."
								else
									(localproc_0 65 28) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/newspaper,wrapper')
								(if (gEgo inRect: 0 130 110 189)
									(localproc_0 65 30) ; "You don't need it...the candy that was in it is long gone."
								else
									(localproc_0 65 28) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/metal')
								(if (gEgo inRect: 174 111 226 150)
									(localproc_0 65 31) ; "It's a worthless piece of junk and of no value to you."
								else
									(localproc_0 65 28) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
								)
							)
							((Said '/hand,arm')
								(if (IsFlag 108)
									(if (gEgo inRect: 244 125 319 145)
										(Print 65 32 #at -1 145) ; "No matter how hard you pull, it doesn't budge."
									else
										(Print 65 28 #at -1 145) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
									)
								else
									(localproc_0 65 33) ; "Huh?"
								)
							)
							(else
								(event claimed: 1)
								(localproc_0 65 28) ; "You know it's there somewhere, but you can't seem to lay your hands on it."
							)
						)
					)
				)
			)
		)
	)
)

(instance rm65Script of Script
	(properties)

	(method (doit)
		(cond
			((> local103 1)
				(-- local103)
			)
			((== local103 1)
				(= local103 0)
				(bodyScript changeState: 5)
			)
			((> local104 1)
				(-- local104)
			)
			((== local104 1)
				(= local104 0)
				(bodyScript changeState: 4)
			)
			((> local111 1)
				(-- local111)
			)
			((== local111 1)
				(= local111 0)
			)
			((== local112 1)
				(carpScript changeState: 0)
			)
			((== local112 0)
				(carpScript changeState: 1)
			)
		)
		(if (not local105)
			(cond
				((gEgo inRect: 226 85 319 125)
					(gEgo posn: (+ (gEgo x:) 4) (gEgo y:))
				)
				((< (gEgo x:) 100)
					(gEgo posn: (+ (gEgo x:) 1) (gEgo y:))
				)
				(else
					(gEgo posn: (+ (gEgo x:) 2) (gEgo y:))
				)
			)
		)
		(cond
			((and local113 (> (gEgo x:) 320))
				(EgoDead
					{You are carried away and battered into unconsciousness on the rocks.}
				)
			)
			(
				(and
					(not local113)
					(or
						(gEgo inRect: 265 75 319 102)
						(gEgo inRect: 295 103 319 115)
					)
				)
				(= local113 1)
				(gContinuousMusic stop:)
				(sweepMusic play:)
				(localproc_0 65 34) ; ""OH NO!" you think..."I'm caught in the current!". You realize...too late!...that the current through the rocks on this side of the river is much too strong!"
			)
		)
		(cond
			((> local103 0) 0)
			((and (> global191 0) (== local108 0))
				(-= global191 4)
				(= local108 local109)
			)
			((> local108 0)
				(-- local108)
			)
		)
		(cond
			((and (== (gEgo edgeHit:) EDGE_LEFT) local105)
				(DisposeScript 988)
				(gContinuousMusic stop:)
				(gCurRoom newRoom: 62)
			)
			((< (gEgo x:) 0)
				(gCurRoom newRoom: 63)
			)
		)
		(cond
			((and (or (> global191 2300) (<= 0 global191 10)) (not local105))
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
			((and (<= 17 global191 27) (not local105))
				(airScript changeState: 2)
				(= global191 13)
				(localproc_0 65 35) ; "Your mind is starting to go hazy as you realize that your air supply is gone."
			)
			((and (<= 50 global191 60) (not local105))
				(airScript changeState: 2)
				(= global191 49)
				(localproc_0 65 36) ; "You are having trouble getting enough air."
			)
		)
		(cond
			((> local107 1)
				(-- local107)
			)
			((== local107 1)
				(= local107 0)
				(airScript changeState: 2)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 12
					setStep: 3 2
					posn: 1 (gEgo y:)
					setCycle: Walk
					setMotion: MoveTo 350 (gEgo y:)
					illegalBits: $8000
					init:
				)
				((= local100 (Act new:))
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
				(self cue:)
			)
			(1
				(switch (gEgo loop:)
					(0
						(= local101 (+ (gEgo x:) 21))
					)
					(1
						(= local101 (- (gEgo x:) 21))
					)
					(2
						(= local101 (gEgo x:))
					)
					(3
						(= local101 (gEgo x:))
					)
				)
				(local100
					posn: local101 (gEgo y:)
					setPri: (gEgo priority:)
					setMotion: MoveTo (+ local101 70) 15 self
				)
			)
			(2
				(self changeState: 1)
			)
			(3
				(HandsOff)
				(= local105 1)
				(gEgo
					view: 489
					setLoop: 2
					cycleSpeed: 2
					illegalBits: 0
					ignoreActors:
					setCycle: End self
				)
			)
			(4
				(= global189 16)
				(gEgo
					setLoop: 4
					setStep: 5 3
					setPri: 15
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo (- (gEgo x:) 80) 55 self
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
				(DrawCel 161 0 0 154 22 1)
				(= local107 15)
				(self cue:)
			)
			(1
				(Format @local0 65 37 global191) ; "%u"
				(Display @local0 dsCOORD 168 36 dsCOLOR 14 dsBACKGROUND 1)
			)
			(2
				(DrawCel 161 0 1 154 22 1)
				(Display @local0 dsCOORD 168 36 dsCOLOR 1 dsBACKGROUND 1)
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
					setLoop: 1
					setCel: 0
					setMotion: MoveTo 319 189
					setCycle: 0
				)
				(= local112 0)
				(= local111 150)
			)
			(1
				(carp setLoop: 1 setCel: 1 setMotion: MoveTo 0 169 setCycle: 0)
				(= local112 1)
				(= local111 150)
			)
		)
	)
)

(instance bodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 108)
				(hand setCel: 11)
				(localproc_0 65 38 83) ; "You move the rocks, exposing a human hand..."
				(self cue:)
			)
			(1
				(gEgo x: (- (gEgo x:) 4))
				(localproc_0 65 39 83) ; "Startled, you jerk backwards!"
			)
			(2
				(body posn: 270 56)
				(Print 65 40 #at -1 145 #draw) ; "Regaining your composure, you take a closer look. It appears a body is wedged into the rocks."
				(SetFlag 109)
			)
			(3
				(HandsOff)
				(User canInput: 1)
				(= global184 1)
				(SetScore 5)
				(airScript changeState: 2)
				(gCurRoom drawPic: 104 7)
				(gCast eachElementDo: #dispose)
				(= local104 5)
				(= global189 15)
			)
			(4
				(Display 65 41 dsCOORD 20 100 dsWIDTH 200 dsFONT 0 dsCOLOR 15) ; "Your diving partner notices you have found something, and he swims over to you. You take one side and your partner the other. Together you pull the body from the river."
				(divers view: 12 posn: 200 95 setLoop: 7 init:)
				(= local103 1000)
			)
			(5
				(divers dispose:)
				(gContinuousMusic stop:)
				(gCurRoom newRoom: 62)
			)
		)
	)
)

