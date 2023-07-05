;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use n011)
(use Str)
(use Game)
(use System)

(class GK2Room of Room
	(properties)

	(method (init)
		(super init: &rest)
		(self overlay:)
		(self setText:)
		((gUser hotCursor:) curHotObject: 0 show: update:)
		(Palette 2 0 255 100) ; PalIntensity
	)

	(method (doVerb)
		(return 0)
	)

	(method (newRoom newRoomNumber)
		(= global249 0)
		((gUser hotCursor:) showWait:)
		(super newRoom: newRoomNumber)
	)

	(method (overlay)
		(SetFlag 1)
		(gThePlane setRect: 12 15 627 349 priority: 1)
		(UpdatePlane gThePlane)
		(gGame
			handsOn:
				(OneOf
					number
					700
					400
					840
					10102
					420
					42201
					320
					3210
					4020
					330
					10102
					300
					542
					5211
				)
		)
	)

	(method (setText &tmp temp0 temp1)
		(if noun
			(= temp0 (if (!= modNum -1) modNum else gCurRoomNum))
			(= temp1 (Str new:))
			(if (Message msgGET temp0 noun 0 0 1 (temp1 data:))
				(gTopMessage newText: temp1)
				(gTopMessage save:)
			)
			(temp1 dispose:)
		)
	)
)

