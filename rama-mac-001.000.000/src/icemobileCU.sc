;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2109)
(include sci.sh)
(use Main)
(use Location)
(use SoundManager)
(use n1111)
(use VMDMovie)
(use Osc)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	icemobileCU 0
)

(instance icemobileCU of CloseupLocation
	(properties
		picture 2437
		heading 270
	)

	(method (init)
		(if (IsFlag 72)
			(= picture 61)
		)
		(super init: picture)
		(if (IsFlag 72)
			(enterBuggy init:)
			(self setScript: nicoleScript)
		)
		(icemobile_270 init:)
	)
)

(instance enterBuggy of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 164 98 299 98 299 215 148 215 148 126 164 115
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(SoundManager fadeMusic: 0 20 10 1)
				(gCurRoom newRoom: 5700) ; NYPort
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nicoleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(nicole init: global117)
				(nicoleBeckons play: self)
			)
			(2
				(nicole setCycle: Osc -1)
				(self dispose:)
			)
		)
	)
)

(instance nicoleBeckons of VMDMovie
	(properties
		movieName 38181
		endPic 38189
	)
)

(instance nicole of Prop
	(properties
		x 303
		y 230
		view 2107
	)
)

(instance icemobile_270 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 72)
			(= case 1)
		else
			(= case 2)
		)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 33 47 32 131 46 209 70 300 105 375 145 437 192 472 229 485 253 487 270 471 292 -4 293
					yourself:
				)
		)
	)
)

