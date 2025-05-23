;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Feature)
(use LoadMany)
(use Wander)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm85 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm85 of EncRoom
	(properties
		picture 701
		style 8
		encChance 30
		entrances 10
		illBits -28672
	)

	(method (dispose)
		(SetFlag 75)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (IsFlag 204) (> (gEgo x:) 160))
			(ClearFlag 204)
			(gCurRoom setScript: antwerped)
		)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(Load rsVIEW 700)
		(if (IsFlag 204)
			(Load rsSCRIPT 970)
			(gCurRoom encChance: 0)
			(LoadMany rsVIEW 590 85)
			(LoadMany rsSOUND 2009 2010 2011)
			(antFalls number: 2009 loop: 1 init:)
			(antSplats number: 2010 loop: 1 init:)
			(babyBoing number: 2011 loop: 1 init:)
		)
		(NormalEgo)
		(= local3 (gEgo cycleSpeed:))
		(northBush addToPic:)
		(northBush2 addToPic:)
		(southBush addToPic:)
		(if
			(not
				(OneOf gPrevRoomNum 420 480 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)
)

(instance northBush of View
	(properties
		x 120
		y 51
		noun 4
		view 700
	)
)

(instance northBush2 of View
	(properties
		x 105
		y 73
		noun 3
		view 700
		loop 1
	)
)

(instance southBush of View
	(properties
		x 58
		y 167
		noun 5
		view 700
		loop 3
		priority 15
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
		xStep 4
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
					(= local0 1)
					(gCurRoom setScript: splat)
				)
			)
			(16 ; dagger
				(if (> (antwerped state:) 1)
					(HandsOff)
					(gMessager say: 2 12) ; "Too late!"
				else
					(= local0 1)
					(gCurRoom setScript: splat)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
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

(instance antFalls of Sound
	(properties
		number 2009
	)
)

(instance antSplats of Sound
	(properties
		number 2010
	)
)

(instance babyBoing of Sound
	(properties
		number 2011
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

(instance antwerped of Script
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
					setMotion: 0
					setLoop: 1
					cel: 0
					cycleSpeed: 12
					actions: egoActions
					setCycle: End self
				)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 1 2 3 4 5 6)
				(User canControl: 0)
				(unknown_85_16 init:)
				(antFalls play:)
				(= ticks 40)
			)
			(3
				(antwerp
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 1
					setCel: 0
					setCycle: 0
					posn: (gEgo x:) -30
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 48) self
				)
			)
			(4
				(antwerp setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 4) self)
			)
			(5
				(unknown_85_16 dispose:)
				(antFalls stop:)
				(antSplats play:)
				(gEgo view: 85 cel: 0 setLoop: 2 setCel: 0 setCycle: Fwd)
				(antwerp setCycle: End self)
			)
			(6
				(antwerp setCycle: Beg setMotion: MoveTo 270 0)
				(= cycles 80)
			)
			(7
				(EgoDead 5 6) ; "You're obviously in no shape to continue the game."
			)
		)
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
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(antwerp dispose:)
				(a1
					setLoop: 7
					posn: local1 local2
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (+ local1 16) (+ local2 22) self
				)
				(a2
					setLoop: 8
					posn: local1 local2
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (- local1 10) (- local2 10)
				)
				(a3
					setLoop: 7
					posn: local1 local2
					ignoreActors:
					init:
					setCycle: Fwd
					setMotion: MoveTo (+ local1 8) (+ local2 15)
				)
				(if (> gHowFast 0)
					(a4
						setLoop: 7
						posn: local1 local2
						ignoreActors:
						init:
						setCycle: Fwd
						setMotion: MoveTo (- local1 14) (- local2 5)
					)
					(a5
						setLoop: 8
						posn: local1 local2
						ignoreActors:
						init:
						setCycle: Fwd
						setMotion: MoveTo (+ local1 16) (- local2 10)
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
				(gEgo cycleSpeed: local3)
				(client setScript: 0)
			)
		)
	)
)

(instance unknown_85_16 of Feature
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

