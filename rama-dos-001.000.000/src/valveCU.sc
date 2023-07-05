;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2033)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	valveCU 0
)

(instance valveCU of CloseupLocation
	(properties
		noun 1
		heading 135
		picture 2198
	)

	(method (init)
		(super init: picture)
		(waterValve init: global117)
		(glassDome init: global117)
		(fermentationAgent init: global117)
		(fermentInputBox init:)
		(cornInputBox init:)
	)
)

(instance waterValve of Prop
	(properties
		x 52
		y 109
		cycleSpeed 14
		view 2198
	)

	(method (init)
		(if (IsFlag 60)
			(= cel 4)
		else
			(= cel 0)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (SetFlag 60)
					(ClearFlag 60)
					(valveSound play:)
					(self setCycle: Beg)
					(glassDome setCycle: Beg)
				else
					(gCurRoom setScript: turnOnWater)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glassDome of Prop
	(properties
		x 106
		y 30
		loop 1
		view 2198
	)

	(method (init)
		(if (not (IsFlag 60))
			(= cel 0)
		else
			(= cel 6)
		)
		(super init: &rest)
	)
)

(instance fermentationAgent of View
	(properties
		x 316
		y 173
		loop 3
		view 2198
	)

	(method (init)
		(if (!= (proc70_9 34) 2017)
			(return)
		)
		(super init: &rest)
	)
)

(instance placePieceSound of Sound
	(properties
		number 3500
		flags 5
	)
)

(instance fermentInputBox of Feature
	(properties)

	(method (init)
		(if (== (proc70_9 34) 2017)
			(return)
		)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 306 143 434 143 447 197 313 197 306 190
					yourself:
				)
			setHotspot: 57
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(57
				(proc70_3)
				(proc70_10 34 2017)
				(placePieceSound play:)
				(fermentationAgent init: global117)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cornInputBox of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 446 156 473 156 481 184 452 184
					yourself:
				)
			setHotspot: 79
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79
				(proc70_3)
				(+= global200 5)
				(gCurRoom setScript: insertCorn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance corn of Prop
	(properties
		x 462
		y 170
		loop 2
		view 2198
	)
)

(instance insertCorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cornGrindSound play:)
				(corn init: global117 cycleSpeed: 10 setCycle: CT 2 1 self)
			)
			(1
				(corn setCycle: CT 1 -1 self)
			)
			(2
				(corn setCycle: CT 3 1 self)
			)
			(3
				(corn setCycle: CT 2 -1 self)
			)
			(4
				(corn setCycle: CT 4 1 self)
			)
			(5
				(corn setCycle: CT 3 -1 self)
			)
			(6
				(corn setCycle: CT 5 1 self)
			)
			(7
				(corn setCycle: CT 4 -1 self)
			)
			(8
				(corn setCycle: CT 6 1 self)
			)
			(9
				(corn setCycle: CT 5 -1 self)
			)
			(10
				(corn setCycle: CT 6 1 self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cornGrindSound of Sound
	(properties
		number 2206
	)
)

(instance turnOnWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(valveSound play:)
				(waterValve cel: 0 setCycle: End self)
			)
			(1
				(waterSound play:)
				(glassDome cel: 0 setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valveSound of Sound
	(properties
		number 2205
		flags 5
	)
)

(instance waterSound of Sound
	(properties
		number 2204
		flags 5
	)
)

