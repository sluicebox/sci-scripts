;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5326)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	NY_Octospider_Plaza_26 0
)

(instance NY_Octospider_Plaza_26 of CloseupLocation
	(properties
		noun 15
		picture 15300
		heading 180
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 15301)
		)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(prismInHole init:)
	)
)

(instance prismHole of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 117
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 319 85 335 109 303 109 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(117
				(proc201_1 5)
				(proc70_3 113)
				(proc70_10 113 gCurRoomNum)
				(prismInHole init:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance prismInHole of View
	(properties
		x 301
		y 122
		view 15300
	)

	(method (init)
		(if (!= (proc70_9 113) gCurRoomNum)
			(prismHole init:)
			(return)
		)
		(super init: global117 &rest)
		(self setHotspot: 2 136)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 113 0)
				(prismHole init:)
				(self dispose:)
			)
			(136
				(if (not (SetFlag 239))
					(octohedron_Opens play:)
				else
					(ClearFlag 239)
					(octohedron_Closes play:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance octohedron_Opens of VMDMovie
	(properties
		movieName 5326
		frameRate 15
		endPic 15301
	)
)

(instance octohedron_Closes of VMDMovie
	(properties
		movieName 5327
		frameRate 15
		endPic 15300
	)
)

