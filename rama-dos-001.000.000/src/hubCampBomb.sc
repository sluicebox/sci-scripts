;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1014)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	hubCampBomb 0
)

(instance hubCampBomb of CloseupLocation
	(properties
		noun 20
	)

	(method (init)
		(self heading: 135)
		(if (IsFlag 80)
			(super init: 1193)
		else
			(super init: 1093)
		)
		(gCurRoom setScript: blinking_Light)
		(sabatinis_Key_Ring init:)
		(bomb_135 init:)
	)

	(method (dispose)
		(blinking_Light dispose:)
		(super dispose: &rest)
	)
)

(instance bombLight of View
	(properties
		view 1093
	)

	(method (init)
		(if (IsFlag 80)
			(self x: 288 y: 120 cel: 2)
			(super init: global117)
		else
			(self x: 280 y: 110 cel: 5)
			(super init: global117)
		)
	)
)

(instance blinking_Light of Script
	(properties)

	(method (init)
		(bombLight init:)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bombLight show:)
				(= seconds 1)
			)
			(1
				(bombLight hide:)
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance bomb_135 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 96 63 509 62 586 122 583 287 158 284 29 227 30 126
					yourself:
				)
		)
	)
)

(instance sabatinis_Key_Ring of View
	(properties
		x 519
		y 131
		loop 1
		view 1093
	)

	(method (init)
		(if (== (proc70_9 44) 1008)
			(if (IsFlag 80)
				(= cel 0)
			else
				(= cel 1)
			)
			(super init: global117 setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 44)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

