;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	playLute 0
)

(local
	local0
	local1
)

(instance playLute of Script
	(properties)

	(method (init)
		(Load rsVIEW 54)
		(= global204 1)
		(super init:)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (Prop new:))
				(if (== (gEgo view:) 2)
					(local0
						view: 888
						ignoreActors:
						setPri: (gEgo priority:)
						cycleSpeed: 1
						setCycle: Fwd
						posn: (+ (gEgo x:) 13) (- (gEgo y:) 27)
						init:
					)
				else
					(local0
						view: 888
						ignoreActors:
						setPri: (gEgo priority:)
						cycleSpeed: 1
						setCycle: Fwd
						posn: (+ (gEgo x:) 15) (- (gEgo y:) 37)
						init:
					)
				)
				(gSounds eachElementDo: #dispose)
				((Sound new:) number: 54 play: self)
				(= local1 (gEgo viewer:))
				(gEgo
					viewer: 0
					view: 54
					setMotion: 0
					loop: (if (== (gEgo view:) 2) 0 else 1)
					cycleSpeed: 2
					setCycle: Fwd
				)
			)
			(1
				(gEgo
					viewer: local1
					view: (if (== (gEgo loop:) 0) 2 else 4)
				)
				(local0 dispose:)
				(gEgo
					viewer: local1
					script: global164
					cycleSpeed: 0
					loop: 2
					setCycle: Walk
				)
				(HandsOn)
				(DisposeScript 303)
			)
		)
	)
)

