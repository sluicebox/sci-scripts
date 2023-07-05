;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7905)
(include sci.sh)
(use Main)
(use Location)
(use newYorkRegion)
(use n1111)
(use Feature)
(use Sound)
(use Motion)
(use Actor)

(public
	octoSubMapCU 0
)

(instance octoSubMapCU of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		(= picture 7923)
		(super init: 7923)
		(mapButton init:)
		(self edgeW: 0 edgeE: 0)
		(MAP_270 init:)
		(if (IsFlag 195)
			(mapLight init: global117)
		)
		(if (proc1111_24 220)
			(proc1111_31 30)
			(SetFlag 220)
		)
	)
)

(instance mapButton of Feature
	(properties
		nsLeft 229
		nsTop 119
		nsRight 246
		nsBottom 136
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (IsFlag 195)
					(ClearFlag 195)
					(mapLight dispose:)
				else
					(SetFlag 195)
					(butnSnd play:)
					(mapLight init: global117)
					(proc201_1 21)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mapLight of Prop
	(properties
		x 237
		y 105
		view 7916
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd cycleSpeed: 15)
	)
)

(instance MAP_270 of Feature
	(properties
		noun 62
		nsLeft 50
		nsTop 4
		nsRight 546
		nsBottom 285
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance butnSnd of Sound
	(properties
		flags 5
		number 7901
	)
)

