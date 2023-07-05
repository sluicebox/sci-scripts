;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
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
		(= global451 0)
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
			(LoadMany rsSOUND 9 10 11)
			(antFalls number: (SoundFX 9) loop: 1 init:)
			(antSplats number: (SoundFX 10) loop: 1 init:)
			(babyBoing number: (SoundFX 11) loop: 1 init:)
		)
		(NormalEgo)
		(= local3 (gEgo cycleSpeed:))
		(northBush addToPic:)
		(northBush2 addToPic:)
		(southBush addToPic:)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
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
		noun 2
		yStep 6
		view 590
		xStep 4
	)

	(method (init)
		(= global451 1590)
		(PalVary pvCHANGE_TARGET 1590)
		(AssertPalette 590)
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
		number 9
	)
)

(instance antSplats of Sound
	(properties
		number 10
	)
)

(instance babyBoing of Sound
	(properties
		number 11
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
				(antFalls play:)
				(User canControl: 0)
				(gEgo
					setMotion: 0
					view: 85
					setLoop: 1
					cycleSpeed: 12
					actions: egoActions
					setCycle: End self
				)
			)
			(1
				(User canControl: 0)
				(antwerp
					init:
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 2
					cel: 0
					setCycle: 0
					posn: (gEgo x:) -30
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 48) self
				)
			)
			(2
				(User canControl: 0)
				(antwerp setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 4) self)
			)
			(3
				(HandsOff)
				(antFalls stop:)
				(antSplats play:)
				(gEgo view: 85 cel: 0 setLoop: 2 setCel: 0 setCycle: Fwd)
				(antwerp setCycle: End self)
			)
			(4
				(antwerp setCycle: Beg setMotion: MoveTo 270 0)
				(= cycles 80)
			)
			(5
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
				(antFalls stop:)
				(User canControl: 0 canInput: 0)
				(gEgo
					view: 85
					setLoop: 0
					cycleSpeed: 0
					actions: 0
					setCycle: End self
				)
			)
			(1
				(antwerp
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 2
					cel: 0
					setCycle: 0
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 47) self
				)
			)
			(2
				(antSplats play:)
				(gEgo setCycle: Beg self)
				(SetFlag 206)
				(antwerp setLoop: 5 setCycle: End)
			)
			(3
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(antwerp
					setLoop: 5
					cel: 0
					setStep: 4 4
					posn: local1 local2
					setMotion: MoveTo local1 (+ local2 16)
					cycleSpeed: 1
					setCycle: End
				)
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
			(4
				(a1 ignoreActors: 0 illegalBits: -2 setMotion: Wander)
				(a2 ignoreActors: 0 illegalBits: -2 setMotion: Wander)
				(a3 ignoreActors: 0 illegalBits: -2 setMotion: Wander)
				(if (> gHowFast 0)
					(a4 ignoreActors: 0 illegalBits: -2 setMotion: Wander)
					(a5 ignoreActors: 0 illegalBits: -2 setMotion: Wander)
				)
				(NormalEgo)
				(User canControl: 1 canInput: 1)
				(gEgo cycleSpeed: local3)
				(client setScript: 0)
			)
		)
	)
)

