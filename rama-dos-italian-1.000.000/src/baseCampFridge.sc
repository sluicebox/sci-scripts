;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2006)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	baseCampFridge 0
)

(local
	local0
	local1
)

(instance baseCampFridge of CloseupLocation
	(properties)

	(method (init)
		(self heading: 180)
		(if local1
			(super init: 2021)
			(openDoorHandle init:)
		else
			(super init: 2027)
			(closedDoorHandle init:)
		)
		(map_Pieces init:)
		(refridge_180 init:)
	)

	(method (newRoom)
		(if (!= curPic 2027)
			(gGame handsOff:)
			(self setScript: doorClose self)
		else
			(super newRoom: &rest)
		)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1)
			(= local1 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local1)
		)
	)
)

(instance closedDoorHandle of Feature
	(properties
		nsBottom 248
		nsLeft 275
		nsRight 320
		nsTop 164
	)

	(method (init)
		(super init:)
		(self setHotspot: 2)
		(= local1 0)
		(concave_Lense dispose:)
		(fermentation_Agent dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom drawPic: 2021)
				(self dispose:)
				(openDoorHandle init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openDoorHandle of Feature
	(properties
		nsBottom 285
		nsLeft 70
		nsRight 143
		nsTop 28
	)

	(method (init)
		(super init:)
		(self setHotspot: 2)
		(concave_Lense init:)
		(fermentation_Agent init:)
		(= local1 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom drawPic: 2027)
				(self dispose:)
				(closedDoorHandle init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fermentation_Agent of View
	(properties
		x 283
		y 212
		loop 4
		view 2101
	)

	(method (init)
		(if (== (proc70_9 34) 2006)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 34)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance concave_Lense of View
	(properties
		x 190
		y 189
		loop 3
		view 2101
	)

	(method (init)
		(if (== (proc70_9 107) 2006)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 107)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance map_Pieces of View
	(properties
		x 544
		y 67
		view 2101
	)

	(method (init)
		(= local0 0)
		(if (== (proc70_9 84) 2007)
			(++ local0)
		)
		(if (== (proc70_9 88) 2007)
			(++ local0)
		)
		(if (== (proc70_9 12) 2007)
			(++ local0)
		)
		(if local0
			(= loop (- local0 1))
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(switch local0
					(1
						(self deleteHotspot:)
						(self hide:)
					)
					(2
						(= loop 0)
						(FrameOut)
					)
					(3
						(= loop 1)
						(FrameOut)
					)
				)
				(cond
					((== (proc70_9 84) 2007)
						(proc70_1 84)
					)
					((== (proc70_9 88) 2007)
						(proc70_1 88)
					)
					((== (proc70_9 12) 2007)
						(proc70_1 12)
					)
				)
				(-- local0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(concave_Lense dispose:)
				(fermentation_Agent dispose:)
				(gCurRoom drawPic: 2027)
				(FrameOut)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance refridge_180 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 70 0 312 1 413 -2 400 148 365 221 368 277 348 291 120 287 70 4
					yourself:
				)
		)
	)
)

