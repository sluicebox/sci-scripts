;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6910)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	poolControlsCloseUp 0
)

(instance poolControlsCloseUp of CloseupLocation
	(properties
		noun 54
		heading 0
	)

	(method (init)
		(if (IsFlag 144)
			(= picture 6966)
		else
			(= picture 6965)
		)
		(super init: picture)
		(Load rsAUDIO 6900)
		(if (not (IsFlag 145))
			(Load rsAUDIO 6910)
			(pool_0 noun: 49)
		)
		(poolControls init: global117 show:)
		(if (IsFlag 146)
			(northLeverUp init:)
			(northLeverDown init:)
			(southEastLeverUp init:)
			(southEastLeverDown init:)
			(southWestLeverUp init:)
			(southWestLeverDown init:)
			(poolPointer init:)
		else
			(stuckLever init:)
			(rust init: global117)
		)
		(poolPointerButton init:)
		(pool_0 init:)
	)
)

(instance poolControls of View
	(properties
		x 152
		y 79
		z 10
	)

	(method (init)
		(if (IsFlag 144)
			(self view: 6902)
		else
			(self view: 6900)
		)
		(super init: &rest)
	)

	(method (show)
		(switch global232
			(0
				(= loop 0)
				(= cel 2)
			)
			(4
				(= loop 1)
				(= cel 2)
			)
			(1
				(= loop 0)
				(= cel 1)
			)
			(5
				(= cel (= loop 1))
			)
			(2
				(= cel (= loop 0))
			)
			(3
				(= loop 1)
				(= cel 0)
			)
		)
		(super show: &rest)
	)
)

(instance rust of View
	(properties
		x 278
		y 184
		view 6903
		loop 1
		cel 1
	)
)

(instance northLeverUp of Feature
	(properties
		nsLeft 286
		nsTop 82
		nsRight 322
		nsBottom 112
	)

	(method (init)
		(= plane global116)
		(if (== global232 2)
			(self setHotspot: 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(= global232 3)
				(self deleteHotspot:)
				(poolPointerButton deleteHotspot:)
				(northLeverDown setHotspot: 2)
				(poolPointer setHotspot: 2)
				(leverDown play:)
				(poolControls show:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northLeverDown of Feature
	(properties
		nsLeft 290
		nsTop 193
		nsRight 335
		nsBottom 241
	)

	(method (init)
		(= plane global116)
		(if (== global232 3)
			(self setHotspot: 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(= global232 2)
			(self deleteHotspot:)
			(poolPointer deleteHotspot:)
			(poolPointerButton setHotspot: 2)
			(northLeverUp setHotspot: 2)
			(leverUp play:)
			(poolControls show:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southWestLeverUp of Feature
	(properties
		nsLeft 298
		nsTop 68
		nsRight 335
		nsBottom 94
	)

	(method (init)
		(= plane global116)
		(if (== global232 1)
			(self setHotspot: 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(= global232 5)
			(self deleteHotspot:)
			(poolPointerButton deleteHotspot:)
			(southWestLeverDown setHotspot: 2)
			(poolPointer setHotspot: 2)
			(leverDown play:)
			(poolControls show:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southWestLeverDown of Feature
	(properties
		nsLeft 372
		nsTop 120
		nsRight 393
		nsBottom 156
	)

	(method (init)
		(= plane global116)
		(if (== global232 5)
			(self setHotspot: 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(= global232 1)
			(self deleteHotspot:)
			(poolPointer deleteHotspot:)
			(poolPointerButton setHotspot: 2)
			(southWestLeverUp setHotspot: 2)
			(leverUp play:)
			(poolControls show:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southEastLeverDown of Feature
	(properties
		nsLeft 160
		nsTop 120
		nsRight 192
		nsBottom 156
	)

	(method (init)
		(= plane global116)
		(if (== global232 4)
			(self setHotspot: 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(= global232 0)
			(self deleteHotspot:)
			(poolPointer deleteHotspot:)
			(poolPointerButton setHotspot: 2)
			(southEastLeverUp setHotspot: 2)
			(leverUp play:)
			(poolControls show:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southEastLeverUp of Feature
	(properties
		nsLeft 229
		nsTop 69
		nsRight 272
		nsBottom 102
	)

	(method (init)
		(= plane global116)
		(if (== global232 0)
			(self setHotspot: 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(= global232 4)
			(self deleteHotspot:)
			(poolPointerButton deleteHotspot:)
			(southEastLeverDown setHotspot: 2)
			(poolPointer setHotspot: 2)
			(leverDown play:)
			(poolControls show:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance poolPointer of Feature
	(properties
		nsLeft 228
		nsTop 121
		nsRight 358
		nsBottom 187
	)

	(method (init)
		(= plane global116)
		(if (OneOf global232 3 4 5)
			(self setHotspot: 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(buttonClick play:)
				(switch global232
					(4
						(= global232 5)
						(southWestLeverDown setHotspot: 2)
						(southEastLeverDown deleteHotspot:)
						(poolControls show:)
					)
					(5
						(= global232 3)
						(northLeverDown setHotspot: 2)
						(southWestLeverDown deleteHotspot:)
						(poolControls show:)
					)
					(3
						(= global232 4)
						(southEastLeverDown setHotspot: 2)
						(northLeverDown deleteHotspot:)
						(poolControls show:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poolPointerButton of Feature
	(properties
		nsLeft 269
		nsTop 136
		nsRight 306
		nsBottom 153
	)

	(method (init)
		(= plane global116)
		(switch global232
			(2
				(self setHotspot: 2)
			)
			(1
				(self setHotspot: 2)
			)
			(0
				(self setHotspot: 2)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(buttonClick play:)
				(switch global232
					(2
						(if (not (IsFlag 144))
							(SetFlag 144)
							(poolControls view: 6902)
							(poolDraining play:)
						)
					)
					(1
						(if (not (SetFlag 145))
							(poolDrainingSound play:)
						)
					)
				)
			)
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stuckLever of Feature
	(properties
		noun 51
		nsLeft 287
		nsTop 114
		nsRight 331
		nsBottom 205
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 21 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21
				(meltingRust play:)
				((gTheCursor invItem:) doVerb: 21)
				(northLeverUp init:)
				(northLeverDown init:)
				(southEastLeverUp init:)
				(southEastLeverDown init:)
				(southWestLeverUp init:)
				(southWestLeverDown init:)
				(poolPointer init:)
				(poolPointerButton init:)
				(SetFlag 146)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poolDraining of VMDMovie
	(properties
		movieName 6900
		endPic 6966
	)

	(method (play)
		(if (IsFlag 146)
			(= movieName 6901)
		)
		(super play:)
	)
)

(instance meltingRust of VMDMovie
	(properties
		movieName 6902
	)

	(method (play)
		(if (IsFlag 144)
			(= movieName 6903)
		)
		(super play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(rust dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonClick of Sound
	(properties
		flags 5
		number 6900
	)
)

(instance poolDrainingSound of Sound
	(properties
		flags 5
		number 6910
	)
)

(instance leverUp of Sound
	(properties
		flags 5
		number 6920
	)
)

(instance leverDown of Sound
	(properties
		flags 5
		number 6921
	)
)

(instance pool_0 of Feature
	(properties
		noun 50
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 147 85 141 108 167 116 203 121 249 118 258 98 281 99 328 100 351 103 359 112 362 120 425 117 453 101 395 78 328 70 264 72 195 78 160 86
					yourself:
				)
		)
	)
)

