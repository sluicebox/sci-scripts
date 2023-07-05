;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1020)
(include sci.sh)
(use Main)
(use Location)
(use SoundManager)
(use Button)
(use n1111)
(use VMDMovie)
(use Actor)

(public
	hubCableCar 0
)

(instance hubCableCar of CloseupLocation
	(properties
		noun 20
	)

	(method (init)
		(self heading: 0)
		(if (IsFlag 80)
			(super init: 1177 0 1 0 0)
		else
			(super init: 1077 0 1 0 0)
		)
		(number1 init:)
		(number2 init:)
		(number3 init:)
		(number4 init:)
		(button1 init:)
		(button2 init:)
		(button3 init:)
		(button4 init:)
		(startButton init:)
	)

	(method (yaw)
		(gCurRoom newRoom: 1007) ; hubCamp7
	)
)

(instance number1 of View
	(properties
		x 253
		y 195
		view 1077
	)

	(method (init)
		(= cel [global223 0])
		(super init: global117)
	)
)

(instance number2 of View
	(properties
		x 279
		y 195
		view 1077
	)

	(method (init)
		(= cel [global223 1])
		(super init: global117)
	)
)

(instance number3 of View
	(properties
		x 307
		y 195
		view 1077
	)

	(method (init)
		(= cel [global223 2])
		(super init: global117)
	)
)

(instance number4 of View
	(properties
		x 333
		y 195
		view 1077
	)

	(method (init)
		(= cel [global223 3])
		(super init: global117)
	)
)

(instance button1 of Button
	(properties
		x 240
		y 236
		loop 2
		view 1077
		doVerbCalled 1
	)

	(method (init)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(number1 cel: (mod (+ (number1 cel:) 1) 10))
				(= [global223 0] (number1 cel:))
				(UpdateScreenItem number1)
				(FrameOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance button2 of Button
	(properties
		x 270
		y 236
		loop 3
		view 1077
		doVerbCalled 1
	)

	(method (init)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(number2 cel: (mod (+ (number2 cel:) 1) 10))
				(= [global223 1] (number2 cel:))
				(UpdateScreenItem number2)
				(FrameOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance button3 of Button
	(properties
		x 296
		y 235
		loop 4
		view 1077
		doVerbCalled 1
	)

	(method (init)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(number3 cel: (mod (+ (number3 cel:) 1) 10))
				(= [global223 2] (number3 cel:))
				(UpdateScreenItem number3)
				(FrameOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance button4 of Button
	(properties
		x 323
		y 236
		loop 5
		view 1077
		doVerbCalled 1
	)

	(method (init)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(number4 cel: (mod (+ (number4 cel:) 1) 10))
				(= [global223 3] (number4 cel:))
				(UpdateScreenItem number4)
				(FrameOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance startButton of Button
	(properties
		x 352
		y 197
		loop 1
		view 1077
	)

	(method (init)
		(super init: global117)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if
					(and
						(== [global223 0] 4)
						(== [global223 1] 1)
						(== [global223 2] 4)
						(== [global223 3] 3)
					)
					(SoundManager fadeMusic: 0 10 8 1 stopSounds:)
					(gCurRoom newRoom: 2008) ; BCCableCar
					(if (proc1111_24 80)
						(if (global122 script:)
							((global122 script:) dispose:)
						)
						(SetFlag 80)
						(dawningInRama play:)
					else
						(gCurRoom exitStyle: 13)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dawningInRama of VMDMovie
	(properties
		movieName 1100
		endPic 61
	)
)

