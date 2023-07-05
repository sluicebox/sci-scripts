;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use n913)
(use Inset)
(use Motion)
(use Actor)
(use System)

(public
	keyHoleScr 0
	keyHoleView 1
)

(local
	local0
)

(instance keyHoleScr of Script
	(properties)

	(method (init)
		(SetFlag 49)
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 49)
		(= register 0)
		(super dispose:)
		(gGame handsOn:)
		(DisposeScript 82)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo loop:))
				(gEgo
					view: 701
					normal: 0
					cycleSpeed: 8
					loop:
						(cond
							((<= 225 (gEgo heading:) 315) 1)
							((<= 45 (gEgo heading:) 135) 0)
							(else 2)
						)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 3 4 5 6)
				(keyHole init: 0 gCurRoom)
				(if register
					(self setScript: register self)
				else
					(= seconds 5)
				)
			)
			(2
				(gGame handsOff:)
				(if (not register)
					(keyHole dispose:)
				)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(gTheIconBar enable: 6)
				(gEgo reset: local0)
				(self dispose:)
			)
		)
	)
)

(instance keyHole of Inset
	(properties
		view 796
		priority 15
		disposeNotOnMe 1
	)

	(method (init)
		(gEgo stopUpd:)
		(= x (- 160 (/ (CelWide view loop cel) 2)))
		(= y (- 100 (/ (CelHigh view loop cel) 2)))
		(super init: &rest)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose)
		(keyHoleView dispose:)
		((keyHoleScr script:) dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if
			(not
				(and
					(keyHoleView actions:)
					((keyHoleView actions:) doVerb: theVerb)
				)
			)
			(super doVerb: theVerb)
		)
	)
)

(instance keyHoleView of View
	(properties)

	(method (init param1)
		(= x (+ (keyHole x:) 92))
		(= y (+ (keyHole y:) 54))
		(= view [param1 (= loop (= cel 0))])
		(if (> argc 1)
			(= loop [param1 1])
			(if (> argc 2)
				(= cel [param1 2])
				(if (> argc 3)
					(= x (+ [param1 3] (keyHole x:)))
					(if (> argc 4)
						(= y (+ [param1 4] (keyHole y:)))
					)
				)
			)
		)
		(super init: &rest)
		(keyHole noun: noun)
		(self setPri: 13 sightAngle: 180 stopUpd:)
	)
)

