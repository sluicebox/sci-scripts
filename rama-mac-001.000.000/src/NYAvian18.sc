;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5018)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvian18 0
)

(instance NYAvian18 of CloseupLocation
	(properties
		heading 180
	)

	(method (init &tmp temp0)
		(= temp0 (if (IsFlag 224) 5101 else 5062))
		(super init: temp0)
		(self edgeE: 0 edgeN: 0 edgeW: 0)
		(pillar_180 init:)
		(cond
			((!= ((proc70_6 38) owner:) gCurRoomNum)
				(placeJackFeat plane: global116 init:)
			)
			((proc1111_24 224)
				(jack init: global117)
			)
		)
	)
)

(instance placeJackFeat of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 415 147 464 147 556 182 565 290 428 290 306 182 334 151
					yourself:
				)
		)
		(super init: &rest)
		(self setHotspot: 60)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60
				(jack init: global117)
				(proc70_3 38)
				((proc70_6 38) owner: gCurRoomNum)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jack of View
	(properties
		noun 29
		x 329
		y 170
		view 5003
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (proc1111_24 224)
					(SetFlag 224)
					(columnTipsOver play:)
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance columnTipsOver of VMDMovie
	(properties
		movieName 5001
		frameRate 15
		endPic 5101
	)
)

(instance pillar_180 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 161 249 142 294 125 310 120 310 4 392 6 384 125 428 129 474 175 396 267 269 258
					yourself:
				)
		)
	)
)

