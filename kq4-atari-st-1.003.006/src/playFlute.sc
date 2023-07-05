;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 304)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	playFlute 0
)

(local
	local0
	local1
)

(instance fluteMusic of Sound
	(properties)
)

(instance playFlute of Script
	(properties)

	(method (init)
		(= global204 1)
		(Load rsVIEW 55)
		(super init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 (Prop new:))
				(local1
					view: 888
					ignoreActors:
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 1
					setCycle: Fwd
					posn: (+ (gEgo x:) 10) (- (gEgo y:) 27)
					init:
				)
				(= local0 (gEgo viewer:))
				(gEgo
					viewer: 0
					view: 55
					loop: (if (== (gEgo view:) 2) 0 else 1)
					setMotion: 0
					cycleSpeed: 2
					setCycle: Fwd
				)
				(gSounds eachElementDo: #stop 0)
				(fluteMusic number: 77 play: self)
			)
			(1
				(gEgo
					viewer: local0
					view: (if (== (gEgo loop:) 0) 2 else 4)
				)
				(gEgo script: global164 cycleSpeed: 0 loop: 2 setCycle: Walk)
				(local1 dispose:)
				(HandsOn)
				(fluteMusic dispose:)
				(DisposeScript 304)
			)
		)
	)
)

