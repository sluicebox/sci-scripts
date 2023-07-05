;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use LightRoom)
(use Feature)
(use Sound)
(use Motion)
(use Actor)

(public
	rm22 0
)

(instance rm22 of LightRoom
	(properties
		picture 22
		scene 22
	)

	(method (init)
		(Load rsSCRIPT 64946 1)
		(Load rsVIEW 3007)
		(Load rsVIEW 2007)
		(Lock rsAUDIO 34 1)
		(Lock rsAUDIO 35 1)
		(Lock rsAUDIO 36 1)
		(Lock rsAUDIO 37 1)
		(Lock rsAUDIO 38 1)
		(super init: &rest)
		(fPhone init:)
		(fPoster init:)
		(fBox init:)
		(if (not (IsFlag 29))
			((ScriptID 3 1) init: x: 260 y: 176 cycleSpeed: 24) ; pLittleLight
		)
		(if (IsFlag 14)
			(pChair cel: 12)
			(fDrawer init:)
		)
		(pChair init:)
		((ScriptID 1 4) newRoom: 20) ; exitRight
		(if (and (IsFlag 28) (IsFlag 29))
			((ScriptID 1 3) newRoom: 24) ; exitLeft
		)
		(if (IsFlag 12)
			(proc0_9 23 0 0)
		else
			(proc0_9 28 0 0)
		)
		(if (IsFlag 418)
			(ClearFlag 418)
			(pChair doVerb: 5)
		)
	)

	(method (newRoom newRoomNumber)
		(gGame handsOff:)
		(Lock rsAUDIO 34 0)
		(Lock rsAUDIO 37 0)
		(Lock rsAUDIO 38 0)
		(Lock rsAUDIO 17004 0)
		(if gPanels
			(if (gPanels contains: (ScriptID 3 5)) ; pplDeskDrawer
				((ScriptID 3 5) dispose:) ; pplDeskDrawer
			)
			(switch newRoomNumber
				(5
					(Lock rsMESSAGE 3 0)
					(Lock rsMESSAGE 330 0)
					(Lock rsSCRIPT 3 0)
					(Lock rsAUDIO 19 0)
					(Lock rsAUDIO 17 0)
					(Lock rsAUDIO 17001 0)
					(Lock rsAUDIO 17002 0)
					(Lock rsAUDIO 17003 0)
					(Lock rsAUDIO 17004 0)
					(Lock rsAUDIO 44 0)
					(Lock rsAUDIO 45 0)
					(Lock rsAUDIO 35 0)
					(Lock rsAUDIO 36 0)
					(gIRandomMusic fade:)
				)
				(20
					(if (gPanels contains: (ScriptID 3 3)) ; pplBox
						((ScriptID 3 3) dispose:) ; pplBox
					)
				)
				(24
					(Lock rsAUDIO 44 0)
					(Lock rsAUDIO 45 0)
					(if (gPanels contains: (ScriptID 3 2)) ; pplPoster
						((ScriptID 3 2) dispose:) ; pplPoster
					)
					(if (gPanels contains: (ScriptID 3 0)) ; pplPhone
						((ScriptID 3 0) dispose:) ; pplPhone
					)
				)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (gCast contains: (ScriptID 3 7)) ; pplJournal
			((ScriptID 3 7) dispose:) ; pplJournal
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance fDrawer of Feature
	(properties
		nsLeft 220
		nsTop 196
		nsRight 280
		nsBottom 219
		x 250
		y 240
	)

	(method (init param1)
		(self initialize: (if argc param1 else 0))
		(gFeatures addToFront: self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 5) init:) ; pplDeskDrawer
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pChair of Prop
	(properties
		x 129
		y 299
		view 31
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(if (self cel:)
				(ClearFlag 14)
				(fDrawer dispose:)
				(chairFX play:)
				(self setCycle: Beg self)
			else
				(SetFlag 14)
				(fDrawer init:)
				(chairFX play:)
				(self setCycle: End self)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance fPhone of Feature
	(properties
		nsLeft 230
		nsTop 155
		nsRight 280
		nsBottom 195
		x 260
		y 175
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 0) init:) ; pplPhone
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fPoster of Feature
	(properties
		nsLeft 267
		nsTop 32
		nsRight 387
		nsBottom 124
		x 327
		y 78
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 2) init:) ; pplPoster
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fBox of Feature
	(properties
		nsLeft 153
		nsTop 147
		nsRight 210
		nsBottom 180
		x 181
		y 163
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			((ScriptID 3 3) init:) ; pplBox
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance aSound of Sound ; UNUSED
	(properties)
)

(instance chairFX of Sound
	(properties
		number 34
	)
)

