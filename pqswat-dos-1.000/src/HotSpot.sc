;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Feature)
(use System)

(class HotSpot of Feature
	(properties
		type 0
		curView 0
		curLoop 0
		curCel 0
	)

	(method (init param1)
		(self initialize: (if argc param1 else 0))
		(gTheHotspotList add: self)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(self setPolygon: 0)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(gTheHotspotList delete: self)
		(gMouseDownHandler delete: self)
		(DisposeClone self)
	)

	(method (checkEvent param1)
		(if
			(and
				(not (IsFlag 70))
				(& type (gSwatInterface curModeType:))
				(or
					(and (& type $0008) 1)
					(and
						(not (& type $0008))
						(not (gCast firstTrue: #onMe param1))
					)
				)
				(self onMe: param1)
			)
			(gThePlane onMe: param1)
		)
	)

	(method (setType param1)
		(= type param1)
	)

	(method (setCursor param1 param2 param3)
		(if (< argc 2)
			(if param1
				(self setupCursor: (gSwatInterface curModeType:))
			)
			(gSwatInterface setCursor:)
		else
			(= curView param1)
			(= curLoop param2)
			(= curCel param3)
			(if (== global129 self)
				(self setupCursor: (gSwatInterface curModeType:))
				(gSwatInterface setCursor:)
			)
		)
	)

	(method (setupCursor param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (& type $f000))
		(= temp0 (= temp1 (= temp2 0)))
		(if (OneOf param1 1 8)
			(= temp0 986)
			(switch temp3
				(4096
					(= temp1 0)
				)
				(8192
					(= temp1 1)
				)
				(16384
					(= temp1 2)
				)
				(32768
					(= temp1 3)
				)
			)
		else
			(if (== param1 2)
				(= temp0 987)
			else
				(= temp0 999)
			)
			(switch temp3
				(8192
					(= temp1 0)
				)
				(32768
					(= temp1 1)
				)
			)
		)
		(gTheHotspotCursor view: temp0 loop: temp1 cel: temp2)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if
			(and
				(gUser input:)
				(& (event type:) evMOUSEBUTTON)
				(not (event modifiers:))
				(self checkEvent: event)
				(gThePlane onMe: event)
			)
			(= global137 (gSwatInterface curModeType:))
			(self doVerb: (gSwatInterface getCurrentVerb:))
			(event claimed: 1)
			(return)
		else
			(return 0)
		)
	)
)

