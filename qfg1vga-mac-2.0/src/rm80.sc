;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use PolyPath)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm80 0
)

(local
	local0
)

(instance rm80 of EncRoom
	(properties
		picture 701
		style 8
		horizon 57
		encChance 20
		entrances 11
		illBits -28672
	)

	(method (dispose)
		(SetFlag 70)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(NormalEgo)
		(southBush addToPic:)
		(if
			(not
				(OneOf gPrevRoomNum 420 480 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(if (> global281 260)
			(self encChance: 0)
			(= global280 (= global279 0))
			(User canInput: 0)
			(EgoGait 0 0) ; walking
			(switch gPrevRoomNum
				(79
					(gEgo setScript: egoDiesFrom79)
				)
				(81
					(gEgo setScript: egoDiesFrom81)
				)
				(else
					(gEgo setScript: egoLoses)
				)
			)
		)
		(self setRegions: 210) ; Encounter
	)
)

(instance bruno of Actor
	(properties
		x -7
		y 114
		noun 1
		view 65
	)
)

(instance knife1 of Actor
	(properties
		view 65
	)
)

(instance knife2 of Actor
	(properties
		view 65
	)
)

(instance southBush of View
	(properties
		x 58
		y 167
		noun 2
		view 700
		loop 3
		priority 15
	)
)

(instance egoLoses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bruno init: loop: 0)
				(gEgo setMotion: PolyPath 160 80 self)
			)
			(1
				(bruno setLoop: 5 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setCycle: 0 setMotion: 0)
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					moveSpeed: 1
					cycleSpeed: 4
					setCycle: Fwd
					setPri: (+ (gEgo priority:) 1)
					posn: (+ (bruno x:) (* local0 41)) (- (bruno y:) 24)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 22) self
				)
				(bruno
					setLoop: 0
					setCel: 0
					posn: 11 114
					setCycle: Walk
					setMotion: PolyPath 31 131
				)
			)
			(3
				(knife1 setCycle: 0 setCel: 3 setMotion: 0)
				(bruno posn: 31 131 cel: 0 setLoop: 5 setCycle: End)
				(knife2
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					moveSpeed: 1
					cycleSpeed: 4
					setCycle: Fwd
					setPri: (+ (gEgo priority:) 1)
					posn: (+ (bruno x:) (* 41 local0)) (- (bruno y:) 27)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 25) self
				)
			)
			(4
				(bruno
					setLoop: 0
					setCel: 0
					posn: 49 130
					setCycle: Walk
					setMotion: PolyPath 118 116
				)
				(knife1 dispose:)
				(knife2 setCycle: 0 setCel: 3 setMotion: 0)
				(= ticks 60)
			)
			(5
				(knife2 dispose:)
				(gEgo
					view: 516
					setLoop: 3
					cycleSpeed: 1
					setMotion: 0
					setCycle: End
				)
				(= ticks 240)
			)
			(6
				(bruno setMotion: 0 setCel: 0)
				(EgoDead 31 32) ; "Done in by poisoned daggers and desperate desperadoes! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

(instance egoDiesFrom79 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bruno
					init:
					posn: 140 128
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 122 125
				)
				(gEgo setMotion: MoveTo 54 128 self)
			)
			(1
				(bruno setMotion: PolyPath 118 125 self)
			)
			(2
				(knife1
					illegalBits: 0
					setLoop: 7
					setCel: 1
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					moveSpeed: 1
					cycleSpeed: 4
					posn: 88 90
					setMotion: MoveTo 61 96 self
				)
			)
			(3
				(EgoDead 31 32) ; "Done in by poisoned daggers and desperate desperadoes! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

(instance egoDiesFrom81 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bruno init: posn: 8 114 loop: 0)
				(gEgo setMotion: PolyPath 236 115 self)
			)
			(1
				(bruno setLoop: 5 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setCycle: 0 setMotion: 0)
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					moveSpeed: 1
					cycleSpeed: 4
					setCycle: Fwd
					setPri: (+ (gEgo priority:) 1)
					posn: 14 90
					setMotion: MoveTo 229 82 self
				)
				(bruno
					setLoop: 0
					setCel: 0
					posn: 11 114
					setCycle: Walk
					setMotion: PolyPath 31 131
				)
			)
			(3
				(knife1 setCycle: 0 setCel: 0 setMotion: 0 posn: 233 82)
				(bruno posn: 31 131 cel: 0 setLoop: 5 setCycle: End)
				(knife2
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					moveSpeed: 1
					cycleSpeed: 4
					setCycle: Fwd
					setPri: (+ (gEgo priority:) 1)
					posn: 34 90
					setMotion: MoveTo 229 82 self
				)
			)
			(4
				(bruno
					setLoop: 0
					setCel: 0
					posn: 49 130
					setCycle: Walk
					setMotion: PolyPath 118 116
				)
				(knife1 dispose:)
				(knife2 setCycle: 0 setCel: 0 setMotion: 0 posn: 233 84)
				(= ticks 60)
			)
			(5
				(knife2 dispose:)
				(gEgo
					view: 516
					setLoop: 3
					cycleSpeed: 1
					setMotion: 0
					setCycle: End
				)
				(= ticks 240)
			)
			(6
				(bruno setMotion: 0 setCel: 0)
				(EgoDead 31 32) ; "Done in by poisoned daggers and desperate desperadoes! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

