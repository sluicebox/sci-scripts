;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5014)
(include sci.sh)
(use Location)
(use n1111)
(use VMDMovie)
(use Feature)

(public
	NYAvian14 0
)

(instance NYAvian14 of CloseupLocation
	(properties
		noun 2
		heading 90
	)

	(method (init)
		(super init: (if (IsFlag 223) 5102 else 5052))
		(self edgeN: 0 edgeE: 0 edgeW: 0)
		(doorHandleFeat init:)
	)
)

(instance doorHandleFeat of Feature
	(properties
		noun 32
		nsBottom 161
		nsLeft 187
		nsRight 279
		nsTop 112
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 223)
					(ClearFlag 223)
					(closeTetraDoor play:)
				else
					(SetFlag 223)
					(openTetraDoor play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openTetraDoor of VMDMovie
	(properties
		movieName 5052
		endPic 5102
	)
)

(instance closeTetraDoor of VMDMovie
	(properties
		movieName 5053
		endPic 5052
	)
)

