;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm290 0
)

(local
	[local0 75]
	[local75 50]
)

(instance rm290 of LLRoom
	(properties
		picture 290
		north 310
		south 270
	)

	(method (init)
		(Load rsVIEW 291)
		(Load rsVIEW 550)
		(Load rsVIEW 291)
		(gEgo init: normalize:)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(north
				(gEgo view: 291 setLoop: 5 setCycle: 0 posn: 152 93)
				(door posn: 111 118)
				(SetupExit 0)
				(ClearFlag 32)
				(self setScript: sReturning)
			)
			(south
				(gEgo posn: 159 225)
				(self setScript: sEnter270)
			)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: EDGE_NONE)
			)
		)
		(super init:)
		(cond
			((not gPrevRoomNum)
				(Delay 90 0 gCurRoom)
			)
			((IsFlag 32)
				(boardingSign init:)
			)
			((and (gEgo has: 8) (IsFlag 8)) ; Boarding_Pass
				(Delay 90 0 gCurRoom)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 91 126 115 126 111 137 96 145 74 144 67 150 63 167 109 189 0 189 0 0 319 0 319 189 202 189 232 169 261 150 210 123 102 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 201 132 213 137 217 144 198 150 180 148 172 145 170 137
					yourself:
				)
		)
		(chair ignoreActors: 1 init: stopUpd: approachVerbs: 3) ; Do
		(ABM init:)
		(pot init: approachVerbs: 3) ; Do
		(cabinet init:)
		(light init:)
		(leftPainting init:)
		(rightPainting init:)
	)

	(method (newRoom newRoomNumber)
		(gTheTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb &tmp [tmpStr 150])
		(switch theVerb
			(2 ; Look
				(TPrint 290 0) ; "All your life you assumed those snooty, private airport waiting rooms were filled with luxurious appointments."
			)
			(2 ; Look
				(Format ; "All your life you assumed those snooty, private airport waiting rooms were filled with luxurious appointments. Once again, you were wrong! In fact, you'd swear that AeroDork installs that same folding chair in every terminal in every city they serve!"
					@tmpStr
					290
					1
					(switch gLarryLoc
						(0 {Los Angeles})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
				)
				(TPrint @tmpStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (self script:)
			(Delay 5 2 self)
		else
			(self setScript: sDoAnnouncement)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(HandsOff)
				(gCurRoom setScript: sExit270)
			)
		)
	)
)

(instance chair of Prop
	(properties
		x 190
		y 144
		description {the chair}
		sightAngle 90
		approachX 180
		approachY 143
		view 290
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 290 2) ; "How thoughtful! AeroDork has provided a comfortable metal folding chair for your sitting convenience!"
			)
			(3 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: sChair)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Actor
	(properties
		x 152
		y 118
		description {the jetway door}
		sightAngle 90
		view 290
		loop 1
		priority 3
		signal 26640
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 290 3) ; "The door to the jetway is firmly locked, and without protrusions of any kind."
			)
			(3 ; Do
				(TPrint 290 4) ; "You can only open this door by using the ABM to the right."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance boardingSign of Prop
	(properties
		x 153
		y 62
		description {the boarding sign}
		sightAngle 90
		view 290
		loop 2
		priority 5
		signal 18448
	)

	(method (init)
		(= view (proc0_28 290 290 290 2901 290))
		(super init:)
		(self cycleSpeed: 8 setCycle: Fwd)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 32)
					(TPrint 290 5) ; "The Boarding Pass sign is currently flashing. Are you going to miss the plane?"
				else
					(TPrint 290 6) ; "It appears to be a sign."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sExit270 of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 225 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sEnter270 of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 159 160 self)
			)
			(1
				(HandsOn)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance ABM of Feature
	(properties
		x 185
		y 98
		nsTop 92
		nsLeft 176
		nsBottom 105
		nsRight 194
		description {the Automatic Boarding Pass Machine}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(7 ; AeroDork_Gold_Card
						(TPrint 290 7) ; "Your AeroDork Gold Card will only work in the ATM outside the airport."
					)
					(8 ; Boarding_Pass
						(if (IsFlag 32)
							(gEgo put: 8 0) ; Boarding_Pass
							(gCurRoom setScript: sJetWay)
						else
							(TPrint 290 8) ; "You're a little early. That flight isn't due to board for another few minutes."
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(2 ; Look
				(TPrint 290 9) ; "Near the far door is one of AeroDork Airline's exclusive "ABMs.""
				(TPrint 290 10) ; "ABM is an acronym for "Automatic Boarding Pass Machine." So far, AeroDork is the only airline to have them."
				(TPrint 290 11 67 -1 185) ; "(You expect it to remain that way!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pot of Feature
	(properties
		x 91
		y 211
		z 100
		nsTop 107
		nsLeft 85
		nsBottom 116
		nsRight 97
		description {the coffee pot}
		sightAngle 40
		approachX 104
		approachY 136
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 290 12) ; "It's just another example of AeroDork's extravagant attitude towards its customers. Freshly brewed coffee just for you!"
			)
			(3 ; Do
				(TPrint 290 13) ; "YUCK! The pot has boiled dry! Nothing remains but the stench of burned coffee."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 85
		y 119
		nsTop 101
		nsLeft 68
		nsBottom 137
		nsRight 102
		description {the coffee cabinet}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 290 14) ; "The cabinet holds up the coffee maker."
			)
			(3 ; Do
				(TPrint 290 15) ; "There's nothing in the cabinet that you need."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 150
		y 35
		nsTop 26
		nsLeft 140
		nsBottom 45
		nsRight 161
		description {the light fixture}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 290 16) ; "Wouldn't you think the local transportation authorities would worry about exposed wiring?"
			)
			(3 ; Do
				(TPrint 290 17) ; "Right! Of course you can reach the ceiling in here!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftPainting of Feature
	(properties
		x 76
		y 81
		nsTop 67
		nsLeft 64
		nsBottom 96
		nsRight 89
		description {the lovely painting}
		sightAngle 40
		lookStr {You've always admired paintings on velvet!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 290 18) ; "There's nothing hidden behind the painting."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rightPainting of Feature
	(properties
		x 229
		y 94
		nsTop 84
		nsLeft 213
		nsBottom 105
		nsRight 246
		description {the beautiful painting}
		sightAngle 40
		lookStr {The last time you saw art this nice, you were in Tijuana.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 290 18) ; "There's nothing hidden behind the painting."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sDoAnnouncement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 32)
				(boardingSign init:)
				(= ticks 180)
			)
			(1
				(if (chair script:)
					(-- state)
				)
				(= ticks 60)
			)
			(2
				(gTheMusic number: 297 loop: 1 play:)
				(= ticks 300)
			)
			(3
				(TPrint 290 19) ; "A voice comes over the public address system, "AeroDork Airlines is proud to announce the departure of its Chartreuse Service to msdffft, wqpaffw, and paovnnq.""
				(TPrint 290 20) ; "Hmm. That speaker is none too clear."
				(= ticks 120)
			)
			(4
				(RestoreIB)
				(self dispose:)
			)
		)
	)
)

(instance sChair of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 291)
				(Load rsSOUND 295)
				(Load rsSOUND 296)
				(Load rsVIEW 291)
				(Load rsVIEW 291)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(chair hide:)
				(gEgo
					setPri: 14
					view: 291
					setLoop: 0
					posn: (+ (chair x:) 1) (chair y:)
					cycleSpeed: 6
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(3
				(gTheMusic2 number: 291 loop: 1 play:)
				(gEgo setCycle: CT 9 1 self)
			)
			(4
				(gTheMusic2 number: 295 play:)
				(gEgo setCycle: End self)
			)
			(5
				(chair show:)
				(gTheMusic2 number: 296 loop: 1 play:)
				(gEgo
					posn: (+ (chair x:) 44) (+ (chair y:) 3)
					setLoop: 1
					cycleSpeed: 4
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(6
				(gEgo setLoop: 2 cycleSpeed: 6 setCel: 0 setCycle: End self)
			)
			(7
				(gEgo posn: (- (gEgo x:) 12) (gEgo y:) normalize:)
				(RestoreIB)
				(self dispose:)
			)
		)
	)
)

(instance sReturning of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
			)
			(1
				(gEgo
					setCel: 0
					cycleSpeed: 12
					moveSpeed: 5
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize:
					posn: 152 123
					loop: 2
					cycleSpeed: 7
					moveSpeed: 7
					setMotion: MoveTo 152 131 self
				)
			)
			(3
				(gEgo normalize:)
				(gTheMusic2 number: 293 loop: -1 play:)
				(door setMotion: MoveTo 152 118 self)
			)
			(4
				(gTheMusic2 stop:)
				(= cycles 2)
			)
			(5
				(Format ; "Welcome to %s!"
					@local0
					290
					21
					(switch gLarryLoc
						(0 {Los Angeles, cheater})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
					(switch gLarryLoc
						(0 {Los Angeles, truffatore})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
				)
				(TPrint @local0)
				(= ticks 60)
			)
			(6
				(cond
					((IsFlag 9)
						(Format @local75 {New York})
					)
					((IsFlag 11)
						(Format @local75 {Miami})
					)
					((IsFlag 10)
						(Format @local75 {Atlantic City})
					)
					(else
						(Format @local75 {Los Angeles})
					)
				)
				(Format @local0 290 22 @local75 @local75) ; "This airport looks just like the one in %s!"
				(TPrint @local0)
				(= ticks 60)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sJetWay of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(User canInput: 0 canControl: 0)
				(gTheIconBar disable:)
				(gEgo setMotion: PolyPath 179 124 self)
			)
			(1
				(gEgo
					view: 291
					setLoop: 3
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(Points 7 97)
				(if (== gLarryLoc 0)
					(TPrint 290 23) ; "Your boarding pass is sucked..."
					(TPrint 290 24) ; "...into the slot of the ABM!"
				)
				(gTheMusic2 number: 292 loop: 1 play:)
				(= ticks 30)
			)
			(4
				(gEgo cycleSpeed: 8 setCycle: Beg)
				(gTheMusic2 number: 293 loop: -1 play:)
				(door setMotion: MoveTo 110 (door y:) self)
			)
			(5
				(gTheMusic2 stop:)
				(gEgo normalize: setMotion: PolyPath 154 124 self)
			)
			(6
				(gEgo
					view: 291
					setLoop: 4
					cycleSpeed: 8
					setCel: 0
					posn: 152 94
					setCycle: End self
				)
			)
			(7
				(= gQuarters 0)
				(gCurRoom newRoom: 310)
			)
		)
	)
)

