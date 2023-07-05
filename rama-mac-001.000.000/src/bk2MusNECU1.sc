;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4115)
(include sci.sh)
(use Main)
(use Location)
(use SoundManager)
(use RobotPlayer)
(use Feature)
(use Sound)

(public
	bk2MusNECU1 0
)

(instance bk2MusNECU1 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4148)
		(= plane global116)
		(SoundManager pauseMusic: 1 10 20)
		(self edgeW: 0 edgeE: 0)
		(exhibit29Butn init: global117)
		(INSTRUMENT_45 init:)
	)

	(method (pitch param1)
		(SoundManager pauseMusic: 0 10 20)
		(super pitch: param1 &rest)
	)
)

(instance exhibit29Butn of ExhibitButton
	(properties
		x 205
		y 254
		view 4156
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(instrumentSnd play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance instrumentSnd of Sound
	(properties
		flags 5
		number 4123
	)
)

(instance INSTRUMENT_45 of Feature
	(properties
		noun 31
		nsLeft 261
		nsTop 101
		nsRight 330
		nsBottom 248
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

