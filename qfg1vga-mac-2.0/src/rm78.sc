;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use dartScript)
(use n101)
(use n102)
(use TargActor)
(use n814)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Wander)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm78 0
)

(local
	[local0 4]
	local4
	local5
	local6
	local7
	local8
)

(instance rm78 of Rm
	(properties
		noun 3
		picture 700
		style 8
		horizon 63
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(SL enable:)
		(NormalEgo)
		(= local8 (gEgo cycleSpeed:))
		(cond
			((and (not (IsFlag 197)) (not global279))
				(SetFlag 202)
				(= global279 0)
			)
			((and (IsFlag 198) (not global279))
				(switch (Random 0 1)
					(0
						(ClearFlag 202)
					)
					(1
						(SetFlag 202)
					)
				)
			)
		)
		(if (IsFlag 204)
			(Load rsSCRIPT 970)
			(LoadMany rsVIEW 590 85)
			(LoadMany rsSOUND 2009 2010 2011)
			(antFalls number: 2009 loop: 1 init:)
			(antSplats number: 2010 loop: 1 init:)
			(babyBoing number: 2011 loop: 1 init:)
		)
		(if
			(and
				(not gNight)
				(not (IsFlag 204))
				(!= gPrevRoomNum 77)
				(IsFlag 202)
			)
			(Load rsVIEW 78)
			(= [local0 0] 89)
			(= [local0 1] 123)
			(= [local0 2] 0)
			(= [local0 3] (Random 5 30))
			(stag view: 78 x: 166 y: 133 setScript: stagScript init:)
		else
			(ClearFlag 202)
		)
		(= local5 0)
	)

	(method (doit)
		(cond
			(script)
			((and (IsFlag 204) (< (gEgo y:) 140))
				(gCurRoom setScript: antwerped)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(SetFlag 68)
		(super dispose:)
	)
)

(instance stag of TargActor
	(properties
		noun 4
		view 78
	)

	(method (init)
		(HandsOff)
		(gEgo setScript: stagWalkIn)
		(super init:)
	)

	(method (getHurt)
		(+= global250 global251)
		(= global251 0)
		(SetFlag 203)
		(if (and (!= script stagBolts) (!= script stagHurt))
			(self setScript: stagHurt)
		)
	)

	(method (doit)
		(= local4 (gEgo distanceTo: self))
		(if (!= script stagBolts)
			(cond
				([local0 2]
					(if (< local4 100)
						(self setScript: stagBolts)
					)
				)
				((< local4 75)
					(self setScript: stagBolts)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; rock
				(ThrowRock self)
			)
			(16 ; dagger
				(ThrowKnife self)
			)
			(81 ; flameDartSpell
				(CastDart self)
			)
			(12 ; sword
				(self setScript: stagBolts)
			)
			(else
				(switch local5
					(0
						(gMessager say: 4 1 1) ; "The beautiful white stag is foraging for food."
					)
					(5
						(gMessager say: 4 1 2) ; "The white stag takes a mighty leap."
					)
					(else
						(gMessager say: 4 1) ; "You seem to have startled the white stag."
					)
				)
			)
		)
	)
)

(instance stagHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 4 81 0 0 self) ; "The stag looks more surprised than injured."
			)
			(1
				(client setScript: stagBolts)
			)
		)
	)
)

(instance stagWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 90)
			)
			(1
				(HandsOff)
				(switch gPrevRoomNum
					(71
						(gEgo setMotion: PolyPath 160 70 self)
					)
					(79
						(gEgo setMotion: PolyPath 260 155 self)
					)
					(84
						(gEgo setMotion: PolyPath 160 165 self)
					)
					(else
						(gEgo setMotion: PolyPath 80 100 self)
					)
				)
			)
			(2
				(HandsOff)
				(switch gPrevRoomNum
					(71
						(gEgo loop: 2)
					)
					(84
						(gEgo loop: 3)
					)
					(77
						(gEgo loop: 0)
					)
					(else
						(gEgo loop: 1)
					)
				)
				(= ticks 30)
			)
			(3
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance stagScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoGait 0 0) ; walking
				(User canControl: 0)
				(if [local0 3]
					(= local5 0)
					(if [local0 2]
						(stag
							loop: 6
							cycleSpeed: 12
							moveSpeed: 12
							setCycle: Fwd
						)
					else
						(stag
							loop: 7
							cycleSpeed: 12
							moveSpeed: 12
							setCycle: Fwd
						)
					)
					(= seconds [local0 3])
				else
					(self cue:)
				)
			)
			(1
				(if [local0 3]
					(stag setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if [local0 3]
					(= local5 2)
					(if [local0 2]
						(stag
							loop: 4
							cel: 7
							cycleSpeed: 6
							moveSpeed: 6
							setCycle: Beg self
						)
					else
						(stag
							loop: 5
							cel: 7
							cycleSpeed: 6
							moveSpeed: 6
							setCycle: Beg self
						)
					)
				else
					(self cue:)
				)
			)
			(3
				(if [local0 2]
					(= local5 4)
					(stag
						loop: 2
						cel: 0
						cycleSpeed: 6
						moveSpeed: 6
						xStep: 5
						yStep: 3
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(User canControl: 1)
				(= local5 6)
				(stag
					loop: 1
					cel: 0
					setCycle: Fwd
					setMotion: PolyPath -40 (stag y:) self
				)
			)
			(5
				(stag posn: -250 (stag y:))
				(self cue:)
			)
			(6
				(User canControl: 1)
				(ClearFlag 202)
				(stag dispose:)
			)
		)
	)
)

(instance stagBolts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (== (gEgo script:) stagWalkIn))
					(HandsOff)
					(gEgo setCycle: 0 setMotion: 0)
				)
				(if (== local5 0)
					(= local5 1)
					(stag setCycle: End)
				else
					(self cue:)
				)
				(gMessager say: 4 1 0 0 self) ; "You seem to have startled the white stag."
			)
			(1
				(stag cycleSpeed: 4 moveSpeed: 4)
				(cond
					((== local5 1)
						(= local5 3)
						(if [local0 2]
							(stag loop: 4 cel: 7 setCycle: Beg self)
						else
							(stag loop: 5 cel: 7 setCycle: Beg self)
						)
					)
					((== local5 2)
						(= local5 3)
						(stag setCycle: Beg self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(cond
					([local0 2]
						(cond
							((== local5 3)
								(= local5 5)
								(stag
									loop: 2
									cel: 0
									xStep: 5
									setCycle: End self
								)
							)
							((== local5 4)
								(= local5 5)
								(stag setCycle: End self)
							)
							(else
								(self cue:)
							)
						)
					)
					((== local5 3)
						(= local5 5)
						(self cue:)
					)
				)
			)
			(3
				(if (== local5 5)
					(stag setLoop: 9 cel: 0 setStep: 2 2 setCycle: CT 2 1 self)
				else
					(self cue:)
				)
			)
			(4
				(User canControl: 1)
				(if (== local5 5)
					(stag
						setStep: 12 9
						setCycle: Fwd
						setMotion: MoveTo -50 (stag y:) self
					)
				else
					(self cue:)
				)
			)
			(5
				(if (< (stag x:) -30)
					(self cue:)
				else
					(stag
						setStep: 12 9
						setLoop: 9
						setCycle: Fwd
						setMotion: MoveTo -50 (stag y:) self
					)
				)
			)
			(6
				(stag dispose:)
				(NormalEgo)
				(HandsOn)
				(if (== (gEgo script:) (ScriptID 804 1)) ; walkIn
					((ScriptID 804 1) changeState: 4) ; walkIn
				else
					(gEgo setMotion: PolyPath 160 140 setScript: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (or (== theVerb 16) (== theVerb 12)) ; dagger, sword
			0
			(return 1)
		else
			(return 0)
		)
	)
)

(instance antwerp of Actor
	(properties
		x 150
		y -30
		noun 2
		sightAngle 360
		yStep 6
		view 590
		xStep 2
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(12 ; sword
				(if (> (antwerped state:) 1)
					(HandsOff)
					(gMessager say: 2 12) ; "Too late!"
				else
					(gCurRoom setScript: splat)
				)
			)
			(16 ; dagger
				(if (> (antwerped state:) 1)
					(HandsOff)
					(gMessager say: 2 12) ; "Too late!"
				else
					(gCurRoom setScript: splat)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance antwerped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 85
					setMotion: 0
					setLoop: 1
					cel: 0
					cycleSpeed: 12
					actions: egoActions
					setCycle: End self
				)
			)
			(1
				(User canControl: 0)
				(gTheIconBar disable: 1 2 3 4 5 6)
				(unknown_78_18 init:)
				(antFalls play:)
				(= ticks 40)
			)
			(2
				(antwerp
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 1
					cel: 0
					setCycle: 0
					posn: (gEgo x:) -30
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 48) self
				)
			)
			(3
				(antwerp setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 4) self)
			)
			(4
				(HandsOff)
				(unknown_78_18 dispose:)
				(antFalls stop:)
				(antSplats play:)
				(gEgo view: 85 cel: 0 setLoop: 2 setCel: 0 setCycle: Fwd)
				(antwerp setCycle: End self)
			)
			(5
				(antwerp setCycle: Beg setMotion: MoveTo 270 0)
				(= cycles 80)
			)
			(6
				(EgoDead 5 6) ; "You're obviously in no shape to continue the game."
			)
		)
	)
)

(instance antFalls of Sound
	(properties
		priority 8
	)
)

(instance antSplats of Sound
	(properties
		priority 9
	)
)

(instance babyBoing of Sound
	(properties
		priority 12
	)
)

(instance a1 of Actor
	(properties
		noun 1
		yStep 4
		view 590
		xStep 4
	)

	(method (doit)
		(if (== (self cel:) 0)
			(babyBoing loop: 1 play:)
		)
		(super doit:)
	)
)

(instance a2 of Actor
	(properties
		noun 1
		yStep 4
		view 590
		xStep 4
	)
)

(instance a3 of Actor
	(properties
		noun 1
		yStep 4
		view 590
		xStep 4
	)
)

(instance a4 of Actor
	(properties
		noun 1
		yStep 4
		view 590
		xStep 4
	)
)

(instance a5 of Actor
	(properties
		noun 1
		yStep 4
		view 590
		xStep 4
	)
)

(instance splat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 85
					setLoop: 0
					cycleSpeed: 0
					actions: 0
					setCycle: End self
				)
			)
			(2
				(if (not (gCast contains: antwerp))
					(antwerp init:)
				)
				(antwerp
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 1
					cel: 0
					setCycle: 0
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 47) self
				)
			)
			(3
				(antSplats play:)
				(gEgo setCycle: Beg)
				(SetFlag 206)
				(antwerp setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(= local6 (gEgo x:))
				(= local7 (gEgo y:))
				(antwerp dispose:)
				(a1
					setLoop: 7
					posn: local6 local7
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (+ local6 16) (+ local7 22) self
				)
				(a2
					setLoop: 8
					posn: local6 local7
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (- local6 10) (- local7 10)
				)
				(a3
					setLoop: 7
					posn: local6 local7
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (+ local6 8) (+ local7 15)
				)
				(if (> gHowFast 0)
					(a4
						setLoop: 7
						posn: local6 local7
						ignoreActors:
						init:
						setCycle: Fwd
						setMotion: MoveTo (- local6 14) (- local7 5)
					)
					(a5
						setLoop: 8
						posn: local6 local7
						ignoreActors:
						init:
						setCycle: Fwd
						setMotion: MoveTo (+ local6 16) (- local7 10)
					)
				)
			)
			(5
				(a1 ignoreActors: 0 illegalBits: $fffe setMotion: Wander)
				(a2 ignoreActors: 0 illegalBits: $fffe setMotion: Wander)
				(a3 ignoreActors: 0 illegalBits: $fffe setMotion: Wander)
				(if (> gHowFast 0)
					(a4 ignoreActors: 0 illegalBits: $fffe setMotion: Wander)
					(a5 ignoreActors: 0 illegalBits: $fffe setMotion: Wander)
				)
				(NormalEgo)
				(HandsOn)
				(ClearFlag 204)
				(gEgo cycleSpeed: local8)
				(client setScript: 0)
			)
		)
	)
)

(instance unknown_78_18 of Feature
	(properties
		x 150
		y 190
		z 10
		sightAngle 360
	)

	(method (init)
		(= nsTop 1)
		(= nsLeft (- (gEgo x:) 20))
		(= nsBottom (gEgo y:))
		(= nsRight (+ (gEgo x:) 20))
		(gFeatures addToFront: self)
		(if gFtrInitializer
			(self perform: gFtrInitializer)
		)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 16) (== theVerb 12)) ; dagger, sword
			(gEgo setScript: splat)
		else
			(return 0)
		)
	)
)

