;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6104)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	avianSecurity4 0
)

(procedure (localproc_0)
	(switch global234
		(2
			(screenView posn: 233 120)
			(schoolUpperRamp init: global117)
			(schoolLowerRamp init: global117)
		)
		(3
			(schoolLowerRamp dispose:)
			(schoolUpperRamp dispose:)
			(screenView posn: 297 120)
		)
		(4
			(schoolLowerRamp dispose:)
			(schoolUpperRamp dispose:)
			(screenView posn: 289 114)
		)
		(5
			(schoolLowerRamp dispose:)
			(schoolUpperRamp dispose:)
			(screenView posn: 243 120)
		)
		(7
			(schoolLowerRamp dispose:)
			(schoolUpperRamp dispose:)
			(screenView posn: 252 120)
		)
		(1
			(schoolLowerRamp dispose:)
			(schoolUpperRamp dispose:)
			(screenView posn: 316 92)
		)
	)
)

(instance avianSecurity4 of Location
	(properties)

	(method (init)
		(super init:)
		(Load rsAUDIO 6101)
		(Load rsAUDIO 6103)
		(Load rsAUDIO 6105)
		(self addPicObj: faceN faceS faceN)
		(if (IsFlag 123)
			(ClearFlag 123)
			(doorMoving play:)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6132
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6103 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(if (and (== global233 2) (== global234 1))
			(if (staticSound handle:)
				(staticSound setVol: 95)
			else
				(staticSound play:)
			)
		)
		(securityDoor_180 init:)
		(doorNumbers_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6131
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(screenTrail init: global117 hide:)
		(controlKnob init: global117)
		(sliderControl init: global117)
		(keypad init:)
		(screen init:)
		(screenView init: global117)
		(avianNum1 init: global117)
		(avianNum2 init: global117)
		(avianNum3 init: global117)
		(cond
			((!= global233 2)
				(screenView hide:)
				(avianNum1 hide:)
				(avianNum2 hide:)
				(avianNum3 hide:)
			)
			((== global234 1)
				(if (staticSound handle:)
					(staticSound setVol: 127)
				else
					(staticSound play:)
				)
			)
		)
		(console_0 init:)
		(monitors_0 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance controlKnob of View
	(properties
		x 101
		y 272
		view 6102
		loop 8
	)

	(method (init)
		(if (== (= cel global233) 2)
			(screenTrail init: global117)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(= temp0 cel)
				(= cel (mod (+ cel 1) 4))
				(if (== (= global233 cel) 2)
					(sliderControl loop: 10)
					(UpdateScreenItem sliderControl)
					(screenTrail init: global117)
					(if (not global234)
						(= global234 1)
					)
					(controlSound number: 6105 loop: 1 play:)
					(screenView show:)
					(if (== global234 1)
						(staticSound play:)
					)
					(avianNum1 show:)
					(avianNum2 show:)
					(avianNum3 show:)
				else
					(sliderControl loop: 9)
					(UpdateScreenItem sliderControl)
					(screenTrail dispose:)
					(controlSound number: 6101 loop: 1 play:)
					(if (== temp0 2)
						(schoolLowerRamp dispose:)
						(schoolUpperRamp dispose:)
						(screenView hide:)
						(if (== global234 1)
							(staticSound stop:)
						)
						(avianNum1 hide:)
						(avianNum2 hide:)
						(avianNum3 hide:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sliderControl of View
	(properties
		x 480
		y 248
		view 6102
		loop 9
	)

	(method (init)
		(= cel (Max 0 [global235 (- global234 1)]))
		(if (== global233 2)
			(= loop 10)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(= cel (mod (+ cel 1) 4))
				(= [global235 (Max 0 (- global234 1))] cel)
				(controlSound number: 6103 loop: 1 play:)
				(if (and (== global233 2) (== global234 2))
					(switch cel
						(0
							(if (schoolUpperRamp cel:)
								(schoolUpperRamp setCycle: Beg)
							)
							(if (schoolLowerRamp cel:)
								(schoolLowerRamp setCycle: Beg)
							)
						)
						(1
							(if (!= (schoolUpperRamp cel:) 6)
								(schoolUpperRamp setCycle: End)
							)
							(if (schoolLowerRamp cel:)
								(schoolLowerRamp setCycle: Beg)
							)
						)
						(2
							(if (schoolUpperRamp cel:)
								(schoolUpperRamp setCycle: Beg)
							)
							(if (!= (schoolLowerRamp cel:) 5)
								(schoolLowerRamp setCycle: End)
							)
						)
						(3
							(if (!= (schoolUpperRamp cel:) 6)
								(schoolUpperRamp setCycle: End)
							)
							(if (!= (schoolLowerRamp cel:) 5)
								(schoolLowerRamp setCycle: End)
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keypad of Feature
	(properties
		nsLeft 380
		nsTop 171
		nsRight 504
		nsBottom 257
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6110) ; securityKeypad
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen of Feature
	(properties
		nsLeft 292
		nsTop 12
		nsRight 397
		nsBottom 111
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6109) ; securityScreen
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screenView of Prop
	(properties
		view 6102
	)

	(method (init)
		(self setPri: 0)
		(= loop (- global234 1))
		(screen setHotspot: 2)
		(self setCycle: 0)
		(switch global234
			(2
				(= cel 0)
				(schoolUpperRamp init: global117)
				(schoolLowerRamp init: global117)
			)
			(5
				(cond
					((and (not (IsFlag 144)) (not (IsFlag 145)))
						(= cel 0)
					)
					((and (IsFlag 144) (not (IsFlag 145)))
						(= cel 1)
					)
					((and (not (IsFlag 144)) (IsFlag 145))
						(= cel 2)
					)
					(else
						(= cel 3)
					)
				)
			)
			(1
				(staticSound play:)
				(screen deleteHotspot: 2)
				(= loop 14)
				(= cel 0)
				(self setCycle: Fwd)
			)
			(else
				(= cel 0)
				(if (!= global233 2)
					(screen deleteHotspot:)
				)
			)
		)
		(localproc_0)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(if (== global234 2)
			(schoolUpperRamp init: global117)
			(schoolLowerRamp init: global117)
		)
	)
)

(instance screenTrail of View
	(properties
		x 117
		y 253
		view 6102
		loop 7
	)
)

(instance avianNum1 of View
	(properties
		x 396
		y 9
		view 6102
		loop 11
	)

	(method (init)
		(self setPri: 300)
		(= cel (& (>> global242 $0008) $000f))
		(super init: &rest)
	)
)

(instance avianNum2 of View
	(properties
		x 428
		y 9
		view 6102
		loop 11
	)

	(method (init &tmp temp0)
		(self setPri: 300)
		(= cel (& (>> global242 $0004) $000f))
		(super init: &rest)
	)
)

(instance avianNum3 of View
	(properties
		x 459
		y 9
		view 6102
		loop 11
	)

	(method (init &tmp temp0)
		(self setPri: 300)
		(= cel (& global242 $000f))
		(super init: &rest)
	)
)

(instance schoolLowerRamp of Prop
	(properties
		x 366
		y 90
		view 6102
		loop 13
	)

	(method (init)
		(= cel (if (OneOf [global235 1] 2 3) 5 else 0))
		(super init: &rest)
	)
)

(instance schoolUpperRamp of Prop
	(properties
		x 348
		y 70
		view 6102
		loop 12
	)

	(method (init)
		(= cel (if (OneOf [global235 1] 1 3) 6 else 0))
		(super init: &rest)
	)
)

(instance controlSound of Sound
	(properties
		flags 5
	)
)

(instance doorMoving of Sound
	(properties
		flags 5
		number 6104
	)
)

(instance staticSound of Sound
	(properties
		flags 5
		number 6109
		loop -1
	)
)

(instance console_0 of Feature
	(properties
		noun 56
		nsTop -2
		nsRight 588
		nsBottom 289
		x 294
		y 143
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance securityDoor_180 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 275 285 52 420 26 489 288 421 292 221 277
					yourself:
				)
		)
	)
)

(instance doorNumbers_180 of Feature
	(properties
		noun 55
		nsLeft 290
		nsTop 14
		nsRight 402
		nsBottom 30
		x 346
		y 22
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance monitors_0 of Feature
	(properties
		noun 57
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 28 22 15 106 101 107 yourself:)
				((Polygon new:) type: PTotalAccess init: 176 20 147 107 230 107 yourself:)
				((Polygon new:) type: PTotalAccess init: 349 19 300 110 386 109 yourself:)
				((Polygon new:) type: PTotalAccess init: 496 23 431 108 520 108 yourself:)
		)
	)
)

