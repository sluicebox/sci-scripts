;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	MapButton 0
)

(class MapButton of View
	(properties)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (draw)
		(DrawCel view loop cel nsLeft nsTop -1)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(if gModelessDialog
				0
			else
				(super onMe: temp0 temp1)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			(
				(or
					(not (== ((gTheIconBar curIcon:) message:) 11))
					(not (self onMe: event))
					(& (event modifiers:) emSHIFT)
					(& (event modifiers:) emCTRL)
				)
				(super handleEvent: event)
			)
			((& (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(self cel: 1 draw:)
				(while (and (= temp0 (Event new:)) (!= (temp0 type:) evMOUSERELEASE))
					(temp0 localize:)
					(cond
						((self onMe: temp0)
							(if (not cel)
								(self cel: 1 draw:)
							)
						)
						(cel
							(self cel: 0 draw:)
						)
					)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(if cel
					(self cel: 0 draw:)
					(gTheIconBar select: (gTheIconBar at: 0))
					(gCurRoom newRoom: heading)
				else
					(return 0)
				)
			)
			((and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(self cel: 1 draw:)
				(gTheIconBar select: (gTheIconBar at: 0))
				(gCurRoom newRoom: heading)
				(event claimed: 1)
				(return 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

