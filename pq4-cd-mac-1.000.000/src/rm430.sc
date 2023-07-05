;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm430 0
)

(instance rm430 of Room
	(properties
		picture 430
		style 0
	)

	(method (doRemap)
		(gGame doRemap: 2 243 70)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(proc0_4 1)
		(self setScript: runScr)
		(super init: &rest)
	)
)

(instance dog of Actor
	(properties)
)

(instance runScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo
					view: 430
					init:
					setCycle: Walk
					setSpeed: 4
					setStep: 9 2
					posn: -200 150 0
					setPri: 10
				)
				(gEgo setMotion: MoveTo 420 (gEgo y:) self)
				(dog
					view: 4201
					init:
					ignoreActors: 1
					setCycle: Walk
					setSpeed: 4
					setStep: 9 2
					x: (+ (gEgo x:) 97)
					y: (gEgo y:)
					setPri: 11
				)
				(dog setMotion: MoveTo 520 (dog y:))
			)
			(2
				(gCurRoom newRoom: 431)
			)
		)
	)
)

