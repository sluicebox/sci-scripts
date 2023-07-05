;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use Array)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	pickEgo 0
)

(local
	local0
)

(instance pickEgo of Room
	(properties
		picture 512
	)

	(method (init &tmp temp0 temp1)
		(= local0 0)
		(= temp0 (IntArray new: 13))
		(= temp1 (Str new: 12))
		(= gMacSaveNumber (Save 5 (gGame name:) (temp1 data:) (temp0 data:))) ; GetSaveFiles
		(temp0 dispose:)
		(temp1 dispose:)
		(super init:)
		(= global511 pickegoButtonBar)
		(global511 init:)
		(global511 add: cancel)
		(global511 eachElementDo: #init)
		(gKeyDownHandler addToFront: self)
		(kidView1 init:)
		(kidView2 init:)
		(kidView3 init:)
		(kidView4 init:)
		(kidView5 init:)
		(kidView6 init:)
		(kidView7 init:)
		(kidView8 init:)
		(kidView9 init:)
		(kidView10 init:)
		(kidView11 init:)
		(kidView12 init:)
		(kid1 init:)
		(kid2 init:)
		(kid3 init:)
		(kid4 init:)
		(kid5 init:)
		(kid6 init:)
		(kid7 init:)
		(kid8 init:)
		(kid9 init:)
		(kid10 init:)
		(kid11 init:)
		(kid12 init:)
		(backdrop init:)
		(self setScript: sPickEgo)
		(gGame handsOn:)
	)

	(method (dispose)
		((global511 plane:) dispose:)
		(global511 dispose:)
		(= global511 0)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (and (== (event message:) KEY_ESCAPE) (gUser canControl:))
			(gSfx stop:)
			(event claimed: 1)
			(gCurRoom newRoom: 90) ; intro
		else
			(event claimed: 1)
		)
	)
)

(instance sPickEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (Random 1 100) 50)
					(gSfx number: (+ (* gLanguage 1000) 497) play: self)
				else
					(gSfx number: (+ (* gLanguage 1000) 498) play: self)
				)
			)
			(1
				(gSfx stop:)
				(self dispose:)
			)
		)
	)
)

(instance setEgoView of Code
	(properties)

	(method (doit param1)
		(gGame handsOff:)
		(= local0 1)
		(gGame setCursor: 8)
		(= global114 param1)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(gCurRoom setScript: pickNameScript)
	)
)

(instance pickNameScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: 116) ; pickName
			)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: 90) ; intro
			)
		)
	)
)

(instance kidView1 of View
	(properties
		x 46
		y 35
		view 200
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView2 of View
	(properties
		x 116
		y 40
		view 200
		loop 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView3 of View
	(properties
		x 173
		y 36
		view 200
		loop 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView4 of View
	(properties
		x 226
		y 36
		view 200
		loop 4
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView5 of View
	(properties
		x 70
		y 80
		view 200
		loop 5
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView6 of View
	(properties
		x 122
		y 87
		view 200
		loop 6
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView7 of View
	(properties
		x 173
		y 82
		view 200
		loop 7
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView8 of View
	(properties
		x 225
		y 87
		view 200
		loop 8
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView9 of View
	(properties
		x 87
		y 125
		view 200
		loop 9
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView10 of View
	(properties
		x 134
		y 133
		view 200
		loop 10
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView11 of View
	(properties
		x 178
		y 124
		view 200
		loop 11
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView12 of View
	(properties
		x 227
		y 131
		view 200
		loop 12
	)

	(method (onMe)
		(return 0)
	)
)

(instance kid1 of Feature
	(properties
		nsLeft 26
		nsTop 8
		nsRight 67
		nsBottom 36
		x 46
		y 22
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(= global114 0)
		(setEgoView doit: 0)
	)
)

(instance kid2 of Feature
	(properties
		nsLeft 96
		nsTop 7
		nsRight 135
		nsBottom 37
		x 115
		y 22
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 1)
	)
)

(instance kid3 of Feature
	(properties
		nsLeft 150
		nsTop 7
		nsRight 191
		nsBottom 35
		x 170
		y 31
		z 10
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 2)
	)
)

(instance kid4 of Feature
	(properties
		nsLeft 204
		nsTop 3
		nsRight 245
		nsBottom 33
		x 224
		y 18
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(= global114 3)
		(setEgoView doit: 3)
	)
)

(instance kid5 of Feature
	(properties
		nsLeft 49
		nsTop 49
		nsRight 89
		nsBottom 77
		x 69
		y 63
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 4)
	)
)

(instance kid6 of Feature
	(properties
		nsLeft 100
		nsTop 59
		nsRight 142
		nsBottom 88
		x 121
		y 73
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 5)
	)
)

(instance kid7 of Feature
	(properties
		nsLeft 153
		nsTop 52
		nsRight 193
		nsBottom 81
		x 173
		y 66
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 6)
	)
)

(instance kid8 of Feature
	(properties
		nsLeft 206
		nsTop 57
		nsRight 245
		nsBottom 87
		x 225
		y 72
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 7)
	)
)

(instance kid9 of Feature
	(properties
		nsLeft 67
		nsTop 97
		nsRight 107
		nsBottom 125
		x 87
		y 111
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 8)
	)
)

(instance kid10 of Feature
	(properties
		nsLeft 113
		nsTop 103
		nsRight 154
		nsBottom 131
		x 133
		y 117
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 9)
	)
)

(instance kid11 of Feature
	(properties
		nsLeft 158
		nsTop 95
		nsRight 198
		nsBottom 123
		x 178
		y 109
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 10)
	)
)

(instance kid12 of Feature
	(properties
		nsLeft 206
		nsTop 103
		nsRight 246
		nsBottom 131
		x 226
		y 117
	)

	(method (init)
		(global511 add: self)
		(super init: &rest)
	)

	(method (doVerb)
		(setEgoView doit: 11)
	)
)

(instance backdrop of Feature
	(properties
		nsRight 319
		nsBottom 199
	)

	(method (doVerb)
		(return 0)
	)
)

(instance cancel of MGIconItem
	(properties
		x 159
		y 148
		mainView 200
		mainLoop 13
	)

	(method (select)
		(if (super select: 1)
			(gCurRoom setScript: introScript)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (== (event type:) evMOUSEBUTTON) (gUser canControl:))
				(gSfx stop: client: 0)
				(gSfx number: 806 play:)
				(self select:)
			)
		)
	)
)

(instance pickegoButtonBar of MgButtonBar
	(properties)

	(method (checkCursor param1 &tmp temp0)
		(if (!= (param1 plane:) plane)
			(param1 localize: plane)
		)
		(if local0
			(return)
		)
		(cond
			((= temp0 (self firstTrue: #onMe param1))
				(if (!= gTheCursor 10)
					(gGame setCursor: 10)
				)
			)
			((!= gTheCursor 6)
				(gGame setCursor: 6)
				(= saveCursor 0)
			)
		)
	)

	(method (init)
		(if (not plane)
			(= plane (Plane new:))
		)
		(plane back: 0 priority: 1 init: 0 0 640 480 addCast: self)
		(plane setSize:)
	)

	(method (dispose)
		(if saveCursor
			(gGame setCursor: saveCursor 1)
			(= saveCursor 0)
		)
		(super dispose: &rest)
	)
)

