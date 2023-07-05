;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4665)
(include sci.sh)
(use Main)
(use WynIniFile)
(use PolyEdit)

(public
	paulsOfficeRoomCH5SR6 0
)

(local
	local0
	local1 = 1
)

(instance paulsOfficeRoomCH5SR6 of WynDocuStore
	(properties
		exitRoom 4645
		whichComp 1
		postalWareRm 4675
		sysconRm 4685
	)

	(method (init)
		(super init: &rest)
		(= local0 (gWynNet findItem: 6301 7 0 107 1))
		(= local1 1)
		(gGame handsOn: 1)
	)

	(method (showDoco)
		(super showDoco: &rest)
		(if (and (not (gEgo has: 18)) (== curDoco local0)) ; printoutI
			(graphicButton new: docoTextPlane 0)
		)
	)

	(method (slideDoors)
		(if local1
			(super slideDoors: &rest)
		)
	)
)

(instance graphicButton of EmailThreadButton
	(properties
		x 117
		view 3040
		loop 2
	)

	(method (action &tmp temp0)
		(= temp0 (View new:))
		(temp0 view: 3040 loop: 6 cel: 0)
		((gCurRoom docoText:) dispose:)
		(if (gCurRoom docoScrollbar:)
			((gCurRoom docoScrollbar:) dispose:)
			(gCurRoom docoScrollbar: 0)
		)
		(gCurRoom docoPos: 0 curDoco: 0 docoText: temp0)
		(temp0 init: (gCurRoom docoTextPlane:) posn: 102 59)
		(printButton new: (gCurRoom docoTextPlane:) 0)
		(self dispose:)
	)
)

(instance printButton of EmailThreadButton
	(properties
		x 117
		view 3040
		loop 3
	)

	(method (action)
		(= local1 0)
		(gEgo get: 18) ; printoutI
		(= global209 6715)
		(gCurRoom newRoom: 4645) ; paulsOfficeRoomCH5SR4
	)
)

