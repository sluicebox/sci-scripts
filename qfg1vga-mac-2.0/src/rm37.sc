;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm37 0
	karlTalker 1
)

(local
	[local0 7] = [0 24 -11 -29 -10 -26 999]
	[local7 6] = [0 18 27 -8 15 999]
	[local13 4] = [0 23 -14 999]
	[local17 6] = [0 -21 7 -9 -13 999]
	[local23 5] = [0 20 22 28 999]
	[local28 5] = [0 20 22 16 999]
	[local33 4] = [0 25 -6 999]
	[local37 6] = [0 -13 -9 -6 12 999]
	[local43 4] = [0 26 16 999]
	[local47 6] = [0 17 7 30 -6 999]
	[local53 4] = [0 12 17 999]
	[local57 20]
	[local77 12] = [0 -11 -29 -8 -10 -26 -14 -21 -9 -13 -6 999]
	local89
	local90
	local91
	local92
	local93
	local94
	local95
	local96
	local97
	local98
	local99
	local100
	local101
	local102
	local103
	local104
	local105
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(cond
		((not local90)
			(karl setScript: karlStopToTalk)
			(= temp0 0)
		)
		(local93
			(= temp0 1)
		)
		(1
			(= local93 1)
			(= temp0 1)
		)
		(else
			(karl setLoop: 2)
			(gMessager say: 4 0 5) ; "Please step where I can see you."
			(= temp0 0)
		)
	)
	(return temp0)
)

(instance rm37 of Rm
	(properties
		noun 7
		picture 37
		style 0
		north 39
	)

	(method (dispose)
		(castleGate setCycle: 0)
		(karl setCycle: 0)
		(= gUseSortedFeatures local102)
		(super dispose:)
	)

	(method (init)
		(= [local57 0] @local0)
		(= [local57 1] @local7)
		(= [local57 2] @local13)
		(= [local57 3] @local17)
		(= [local57 4] @local23)
		(= [local57 5] @local28)
		(= [local57 6] @local33)
		(= [local57 7] @local37)
		(= [local57 8] @local43)
		(= [local57 9] @local47)
		(= [local57 10] @local53)
		(= [local57 11] 999)
		(super init:)
		(= local104 (gEgo moveSpeed:))
		(= local105 (gEgo cycleSpeed:))
		(if gNight
			(LoadMany rsVIEW 503 517)
		)
		(Load rsVIEW 37)
		(Load rsSOUND 2090)
		(= local102 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 41 189 0 189 0 0 141 0 142 149 125 172 71 172
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 274 189 246 168 190 168 178 148 176 0 319 0 319 189
					yourself:
				)
		)
		(if (not (IsFlag 27))
			(SetFlag 27)
			(oneTime init: play:)
		)
		(portSound number: 2090 init:)
		(theSky init: setOnMeCheck: 1 2)
		(mountain init: setOnMeCheck: 1 4)
		(castle init: setOnMeCheck: 1 8)
		(gateHouse init: setOnMeCheck: 1 16)
		(tower init: setOnMeCheck: 1 32)
		(bush init: setOnMeCheck: 1 64)
		(wall init: setOnMeCheck: 1 128)
		(wWindow init: setOnMeCheck: 1 256)
		(NormalEgo)
		(HandsOn)
		(karlTeller init: karl @local0 @local57 @local77)
		(switch gPrevRoomNum
			(39
				(if gNight
					(castleGate init: stopUpd:)
					(gEgo setScript: egoClimbsDown)
				else
					(castleBars
						x: 162
						y: 98
						setLoop: 7
						setCel: 0
						init:
						stopUpd:
					)
					(= local89 1)
					(= local92 4)
					(karl
						loop: 4
						cel: 1
						actions: karlTeller
						illegalBits: 0
						x: 158
						y: 74
						init:
					)
					(HandsOff)
					(gEgo setScript: egoLeavesCastle)
				)
			)
			(else
				(if gNight
					(castleGate init: stopUpd:)
					0
				else
					(if
						(or
							(and (IsFlag 170) (not (IsFlag 189)))
							(IsFlag 273)
						)
						(= local101 1)
						(karl init: actions: karlTeller setScript: karlGreets)
						(SetFlag 189)
					else
						(HandsOn)
						(karl init: actions: karlTeller setScript: karlPatrols)
					)
					(castleBars init: stopUpd:)
				)
				(if (OneOf gPrevRoomNum 38 39 41)
					(gEgo loop: 2 posn: 161 175 init:)
				else
					(gEgo setScript: egoEnters)
				)
			)
		)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((== (gEgo edgeHit:) 3)
				(gEgo setScript: egoExits)
			)
			((and (IsFlag 273) local89 (< (gEgo y:) 140))
				(gCurRoom newRoom: 600) ; EndGame
			)
		)
		(if (== gNight 1)
			(karl actions: 0)
			(castleGate stopUpd:)
		else
			(karl actions: karlTeller)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 7 1) ; "The gate guard keeps a vigilant eye out for trouble as he paces back and forth on the castle parapet. He walks with the easy stride of a veteran soldier."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance karl of Actor
	(properties
		x 68
		y 74
		noun 4
		view 37
		priority 10
		cycleSpeed 12
	)

	(method (init)
		(self setStep: 2 2 signal: 24592)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 4 1) ; "You can't see much of the gatekeeper over the battlements."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance karlTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (not (== (karl loop:) local92))
				(karl setScript: karlStopToTalk)
			)
			(SolvePuzzle 735 5)
		)
		(super doVerb: theVerb &rest)
		(return 1)
	)
)

(instance castleBars of Actor
	(properties
		x 162
		y 150
		noun 6
		view 37
		loop 7
		priority 9
		signal 10256
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gNight 0)
					(cond
						(local89
							(gMessager say: 4 4 31) ; "Very well."
							(karl setScript: closeGate)
						)
						(local91
							(gMessager say: 4 4 32) ; "Just a minute while I raise the gate."
						)
						(else
							(gMessager say: 4 4 32) ; "Just a minute while I raise the gate."
							(karl setScript: openGate)
						)
					)
				)
			)
			(1 ; Look
				(cond
					(gNight
						(gMessager say: 6 1 34) ; "The castle is securely locked for the night."
					)
					(local89
						(gMessager say: 6 1 31) ; "The portcullis has been raised, and the way to the castle is clear."
					)
					(else
						(gMessager say: 6 1 33) ; "The portcullis presents a severe obstacle for entry to the castle."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance castleGate of Actor
	(properties
		x 162
		y 150
		noun 3
		view 37
		loop 7
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if gNight
					(if (< [gEgoStats 11] 10) ; climbing
						(gMessager say: 10 4 48) ; "Leave the climbing to those who know how."
					else
						(= local97 0)
						(gEgo setScript: egoClimbsWall)
					)
				else
					(gMessager say: 3 1) ; "Nobody is here to open the portcullis."
				)
			)
			(1 ; Look
				(cond
					(gNight
						(gMessager say: 6 1 34) ; "The castle is securely locked for the night."
					)
					(local89
						(gMessager say: 6 1 31) ; "The portcullis has been raised, and the way to the castle is clear."
					)
					(else
						(gMessager say: 6 1 33) ; "The portcullis presents a severe obstacle for entry to the castle."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSky of Feature
	(properties
		y 164
		noun 8
	)
)

(instance mountain of Feature
	(properties
		y 165
		noun 5
	)
)

(instance castle of Feature
	(properties
		y 167
		noun 2
	)
)

(instance gateHouse of Feature
	(properties
		y 71
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(wall doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tower of Feature
	(properties
		y 62
		noun 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1 45) ; "The towers stand out above the castle walls."
			)
			(4 ; Do
				(wall doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush of Feature
	(properties
		y 156
		noun 1
	)
)

(instance wall of Feature
	(properties
		y 105
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 10 1 49) ; "The gatehouse is a massive structure with a portcullis closing off access to the castle."
			)
			(4 ; Do
				(if gNight
					(if (< [gEgoStats 11] 10) ; climbing
						(gMessager say: 10 4 48) ; "Leave the climbing to those who know how."
					else
						(= local97 0)
						(gEgo setScript: egoClimbsWall)
					)
				else
					(gMessager say: 10 4 46) ; "The guards won't allow you to do that."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wWindow of Feature
	(properties
		y 105
		noun 11
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 170 245 init: setMotion: MoveTo 170 180 self)
			)
			(1
				(if (and (or (IsFlag 170) (IsFlag 273)) (not gNight))
					(self cue:)
				else
					(HandsOn)
					(self cue:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance karlPatrols of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local90 0)
				(karl
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: Fwd
					illegalBits: 0
					setMotion: MoveTo 223 74 self
				)
				(= local92 4)
			)
			(1
				(= ticks 12)
			)
			(2
				(karl loop: 2 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(3
				(HandsOn)
				(= ticks 12)
			)
			(4
				(karl
					loop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 68 74 self
				)
				(= local92 5)
			)
			(5
				(= ticks 24)
			)
			(6
				(karl loop: 2 cel: 2 cycleSpeed: 6 setCycle: Beg self)
			)
			(7
				(= ticks 12)
			)
			(8
				(self changeState: 0)
			)
		)
	)
)

(instance karlGreets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(= local92 4)
				(karl
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: Fwd
					illegalBits: 0
					setMotion: MoveTo 161 74 self
				)
			)
			(2
				(karl setMotion: 0 setCycle: 0)
				(= ticks 18)
			)
			(3
				(karl loop: local92 cel: 0 cycleSpeed: 6 setCycle: End self)
				(= local90 1)
			)
			(4
				(gMessager say: 4 0 1 1 self) ; "Come in. Come in. You have been expected. Baron von Spielburg awaits you in the castle."
			)
			(5
				(castleBars
					ignoreActors: 1
					setLoop: 7
					startUpd:
					setScript: unknown_37_26
					setMotion: MoveTo 162 98 self
				)
			)
			(6
				(portSound stop:)
				(castleBars stopUpd: setScript: 0)
				(= local89 1)
				(= ticks 12)
			)
			(7
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 20) self
				)
			)
			(8
				(if (IsFlag 273)
					(gCurRoom newRoom: 600) ; EndGame
				else
					(gEgo setScript: goTo39)
					(karl setScript: timeout)
					(self dispose:)
				)
			)
		)
	)
)

(instance karlStopToTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(karl setMotion: 0 setCycle: 0)
				(= ticks 24)
			)
			(1
				(karl loop: local92 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(2
				(= ticks 12)
			)
			(3
				(Face gEgo karl)
				(= local90 1)
				(client setScript: timeout)
			)
		)
	)
)

(instance timeout of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local91 (> (gEgo y:) 172))
			(client setScript: karlStopToTalk)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 12)
			)
			(1
				(= local91 0)
				(if local93
					(= local93 0)
					(self changeState: 0)
				else
					(self cue:)
				)
			)
			(2
				(if local89
					(gMessager say: 4 0 2) ; "Well, enter the castle grounds!"
					(= local94 1)
					(= seconds 5)
				else
					(client setScript: karlResumesPatrol)
				)
			)
			(3
				(if local93
					(= local93 0)
					(self changeState: 0)
				else
					(= local94 1)
					(HandsOff)
					(gEgo setMotion: 0)
					(client setScript: karlResumesPatrol)
				)
			)
		)
	)
)

(instance karlResumesPatrol of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local89
					(karl setScript: closeGate)
				else
					(self cue:)
				)
			)
			(1
				(= local95 local92)
				(karl loop: local95 cel: 1 cycleSpeed: 6 setCycle: Beg self)
			)
			(2
				(if (== local95 4)
					(karl
						loop: 0
						cel: 0
						cycleSpeed: 12
						setCycle: Fwd
						illegalBits: 0
						setMotion: MoveTo 277 74 self
					)
					(= local92 4)
				else
					(karl
						loop: 1
						cel: 0
						cycleSpeed: 12
						setCycle: Fwd
						setMotion: MoveTo 43 74 self
					)
					(= local92 5)
				)
				(= local90 0)
				(HandsOn)
			)
			(3
				(= ticks 12)
			)
			(4
				(if (== local95 4)
					(karl loop: 2 cel: 0 cycleSpeed: 6 setCycle: End self)
				else
					(karl loop: 2 cel: 2 cycleSpeed: 6 setCycle: Beg self)
				)
			)
			(5
				(= ticks 6)
			)
			(6
				(if (== local95 4)
					(karl
						loop: 1
						cel: 0
						cycleSpeed: 12
						setCycle: Fwd
						setMotion: MoveTo 43 74 self
					)
					(= local92 5)
				else
					(client setScript: karlPatrols)
				)
			)
			(7
				(= ticks 12)
			)
			(8
				(karl loop: 2 cel: 2 cycleSpeed: 6 setCycle: Beg self)
			)
			(9
				(= ticks 6)
			)
			(10
				(client setScript: karlPatrols)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (timeout seconds:)
					(timeout seconds: 12)
				)
				(if (< (karl x:) 160)
					(karl loop: 4 cel: 1 cycleSpeed: 6 setCycle: Beg self)
				else
					(karl loop: 5 cel: 1 cycleSpeed: 6 setCycle: Beg self)
				)
			)
			(1
				(if (< (karl x:) 160)
					(karl
						loop: 0
						cel: 0
						cycleSpeed: 12
						setCycle: Fwd
						illegalBits: 0
						setMotion: MoveTo 160 74 self
					)
					(= local92 4)
				else
					(karl
						loop: 1
						cel: 0
						cycleSpeed: 12
						setCycle: Fwd
						setMotion: MoveTo 160 74 self
					)
					(= local92 5)
				)
			)
			(2
				(karl loop: local92 cel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(3
				(= ticks 12)
			)
			(4
				(castleBars
					ignoreActors: 1
					startUpd:
					setLoop: 7
					setMotion: MoveTo 162 98 self
					setScript: unknown_37_26
				)
			)
			(5
				(portSound stop:)
				(gCurRoom horizon: 120)
				(= local89 1)
				(castleBars setLoop: 7 stopUpd: setScript: 0)
				(HandsOn)
				(client setScript: timeout)
			)
		)
	)
)

(instance unknown_37_21 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom horizon: 0)
				(= cycles 8)
			)
			(1
				(castleBars
					setLoop: 7
					ignoreActors: 0
					setMotion: MoveTo 162 150 self
				)
				(gEgo setScript: unknown_37_26)
			)
			(2
				(portSound stop:)
				(castleBars stopUpd:)
				(gEgo setScript: 0)
				(= local89 0)
				(HandsOn)
				(if (not (karl script:))
					(karl setScript: karlResumesPatrol)
				)
				(self dispose:)
			)
		)
	)
)

(instance closeGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(castleGate ignoreActors: 1 cycleSpeed: 18 startUpd:)
				(if (and (< 125 (gEgo x:) 195) (< 0 (gEgo y:) 160))
					(= local89 0)
					(gEgo setMotion: MoveTo 160 155 self)
				else
					(client setScript: unknown_37_21)
				)
			)
			(1
				(NormalEgo)
				(HandsOff)
				(= ticks 12)
			)
			(2
				(gEgo
					view: 529
					setLoop: 1
					cel: 0
					posn: (- (gEgo x:) 5) (gEgo y:)
					cycleSpeed: 36
					setCycle: End
				)
				(castleBars
					setLoop: 7
					setMotion: MoveTo 162 150 self
					setScript: unknown_37_26
				)
			)
			(3
				(EgoDead 43 44 0 0) ; "You're not a quick learner. Now you know why the grass grows so well around the porticullis."
			)
			(4
				(castleBars setLoop: 7 setMotion: MoveTo 162 98 self)
			)
			(5
				(portSound stop:)
				(castleBars setScript: 0)
				(= local89 1)
				(= seconds 3)
			)
			(6
				(if local96
					(EgoDead 43 44 0 0) ; "You're not a quick learner. Now you know why the grass grows so well around the porticullis."
				else
					(gEgo
						posn: (+ (gEgo x:) 1) (gEgo y:)
						loop: 1
						cycleSpeed: 6
						setCycle: Beg self
					)
					(= local96 1)
				)
			)
			(7
				(gMessager say: 7 0 37 1 self) ; "That smarts. Maybe you should move a little more quickly."
				(NormalEgo 2)
				(HandsOn)
			)
			(8
				(gEgo moveSpeed: local104 cycleSpeed: local105)
				(= seconds 3)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance egoClimbsWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local104 (gEgo moveSpeed:))
				(= local105 (gEgo cycleSpeed:))
				(HandsOff)
				(gEgo
					signal: 8192
					setCycle: Walk
					setMotion: MoveTo 85 171 self
				)
				(gCurRoom north: 0)
			)
			(1
				(gEgo
					view: 517
					setLoop: 0
					cel: 0
					setPri: 13
					xStep: 0
					yStep: 8
					cycleSpeed: 12
					moveSpeed: 12
					posn: 85 125
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) 59 self
				)
			)
			(2
				(gEgo
					view: 517
					setLoop: 1
					cel: 0
					setPri: 13
					posn: 85 50
					xStep: 0
					yStep: 4
					cycleSpeed: 18
					moveSpeed: 18
					setCycle: End self
				)
			)
			(3
				(= ticks 18)
			)
			(4
				(if local97
					(gEgo
						view: 517
						setLoop: 2
						cel: 0
						setPri: 13
						moveSpeed: local104
						cycleSpeed: local105
						illegalBits: 0
						xStep: 8
						yStep: 16
						ignoreActors: 1
						setCycle: End self
					)
				else
					(gEgo moveSpeed: local104 cycleSpeed: local105)
					(gCurRoom newRoom: 39)
				)
			)
			(5
				(gEgo setLoop: 4 posn: 106 55 setMotion: MoveTo 151 166 self)
			)
			(6
				(gEgo
					cel: 0
					moveSpeed: local104
					cycleSpeed: local105
					setCycle: End self
				)
			)
			(7
				(if (not (TakeDamage 10))
					(EgoDead 68 69 2 5 517) ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
				else
					(gEgo
						view: 503
						setLoop: 4
						cel: 0
						x: (+ (gEgo x:) 19)
						y: (+ (gEgo y:) 18)
						setPri: 13
						illegalBits: -32768
						setCycle: 0
					)
					(switch local99
						(0
							(gMessager say: 7 0 39 1 self) ; "Experience is the best teacher."
						)
						(1
							(gMessager say: 7 0 40 1 self) ; "Practice makes perfect."
						)
						(2
							(gMessager say: 7 0 41 1 self) ; "Try, try again etc..."
						)
						(3
							(gMessager say: 7 0 42 1 self) ; "Take a break. It's Mueller time."
						)
						(4
							(gMessager say: 7 0 43 1 self) ; "The gatehouse is more difficult to climb than it first appeared."
						)
						(else
							(gMessager say: 7 0 44 1 self) ; "Remember what happened to Humpty Dumpty."
						)
					)
					(++ local99)
				)
			)
			(8
				(gEgo
					moveSpeed: local104
					cycleSpeed: local105
					setCycle: End self
				)
			)
			(9
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance egoClimbsDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local104 (gEgo moveSpeed:))
				(= local105 (gEgo cycleSpeed:))
				(HandsOff)
				(gCurRoom north: 0)
				(gEgo
					view: 517
					setLoop: 8
					cel: 0
					setPri: 14
					posn: 85 56
					cycleSpeed: 10
					signal: (| (gEgo signal:) $2000)
					init:
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 0
					cel: 0
					posn: 85 68
					setPri: 14
					illegalBits: 0
					cycleSpeed: local105
					setCycle: Fwd
					setMotion: MoveTo 85 115 self
				)
			)
			(2
				(gEgo
					setLoop: 2
					cel: 0
					posn: 87 149
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gEgo
					setLoop: 4
					cel: 0
					posn: 106 150
					setStep: 6 12
					cycleSpeed: local105
					setCycle: Fwd
					setMotion: MoveTo 114 177 self
				)
			)
			(4
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(5
				(= ticks 18)
			)
			(6
				(gEgo
					view: 503
					loop: 4
					cel: 0
					posn: 113 163
					setCycle: End self
				)
			)
			(7
				(NormalEgo 2 0)
				(gGame setCursor: gWaitCursor)
				(gEgo cycleSpeed: 6 setMotion: MoveTo (gEgo x:) 180 self)
			)
			(8
				(= ticks 6)
			)
			(9
				(gEgo moveSpeed: local104 cycleSpeed: local105)
				(gMessager say: 7 0 35 1 self) ; "After climbing down the wall you says to yourself, "Self," you says, "that wasn't too bad.""
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoLeavesCastle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init: posn: 161 159)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 161 164 self)
				(castleGate startUpd: ignoreActors: 1 setMotion: MoveTo 162 150)
			)
			(2
				(HandsOn)
				(castleGate setMotion: 0 stopUpd: ignoreActors: 0)
				(karl setScript: karlResumesPatrol)
				(self dispose:)
			)
		)
	)
)

(instance unknown_37_26 of Script
	(properties)

	(method (init)
		(super init: &rest)
		(portSound loop: 1 play:)
		(= ticks 10)
	)

	(method (cue)
		(portSound loop: 1 play:)
		(= ticks 10)
	)
)

(instance goTo39 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 163 136 self)
			)
			(1
				(gCurRoom newRoom: 39)
			)
		)
	)
)

(instance oneTime of Sound
	(properties
		flags 1
		number 94
	)
)

(instance portSound of Sound
	(properties
		number 2090
		priority 8
		loop -1
	)
)

(instance karlTalker of Talker
	(properties
		x 10
		y 10
		view 1036
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: karlBust karlEye karlMouth &rest)
	)
)

(instance karlBust of Prop
	(properties
		view 1036
	)
)

(instance karlMouth of Prop
	(properties
		nsTop 49
		nsLeft 44
		view 1036
		loop 1
	)
)

(instance karlEye of Prop
	(properties
		nsTop 35
		nsLeft 45
		view 1036
		loop 2
	)
)

