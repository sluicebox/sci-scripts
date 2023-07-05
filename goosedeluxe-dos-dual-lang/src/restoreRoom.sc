;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Feature)
(use File)
(use Game)
(use Actor)
(use System)

(public
	restoreRoom 0
)

(local
	local0
	local1
	local2
	local3
)

(instance restoreRoom of Room
	(properties
		picture 512
	)

	(method (init &tmp temp0)
		(super init:)
		(= global511 pickegoButtonBar)
		(global511 init:)
		(global511 add: cancel)
		(global511 eachElementDo: #init)
		(gKeyDownHandler addToFront: self)
		(= local2 (List new:))
		(= local1 (IntArray new: 13))
		(= temp0 (Str new: 12))
		(= local0 (Save 5 (gGame name:) (temp0 data:) (local1 data:))) ; GetSaveFiles
		(temp0 dispose:)
		(if local0
			(kid1 init:)
			(if (>= local0 2)
				(kid2 init:)
				(if (>= local0 3)
					(kid3 init:)
					(if (>= local0 4)
						(kid4 init:)
						(if (>= local0 5)
							(kid5 init:)
							(if (>= local0 6)
								(kid6 init:)
								(if (>= local0 7)
									(kid7 init:)
									(if (>= local0 8)
										(kid8 init:)
										(if (>= local0 9)
											(kid9 init:)
											(if (>= local0 10)
												(kid10 init:)
												(if (>= local0 11)
													(kid11 init:)
													(if (>= local0 12)
														(kid12 init:)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(local1 dispose:)
		(backdrop init:)
		(gGame handsOn:)
		(self setScript: sPickGame)
	)

	(method (dispose)
		((global511 plane:) dispose:)
		(global511 dispose:)
		(= global511 0)
		(gKeyDownHandler delete: self)
		(local2 dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_ESCAPE)
			(gSfx stop: client: 0)
			(gCurRoom newRoom: 90) ; intro
			(event claimed: 1)
		else
			(event claimed: 1)
		)
	)
)

(instance sPickGame of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gSfx number: (+ (* gLanguage 1000) 503) play: self)
			)
			(1
				(gSfx stop:)
				(self dispose:)
			)
		)
	)
)

(instance pickSaveGameNum of Code
	(properties)

	(method (doit param1)
		(gGame handsOff:)
		((global511 plane:) dispose:)
		(global511 dispose:)
		(= global511 0)
		(gKeyDownHandler delete: self)
		(local2 dispose:)
		(= local3 param1)
		(gCurRoom setScript: restoreScript)
	)
)

(instance kidView1 of View
	(properties
		x 46
		y 35
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView2 of View
	(properties
		x 114
		y 35
		loop 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView3 of View
	(properties
		x 173
		y 35
		loop 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView4 of View
	(properties
		x 226
		y 33
		loop 4
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView5 of View
	(properties
		x 70
		y 77
		loop 5
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView6 of View
	(properties
		x 122
		y 86
		loop 6
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView7 of View
	(properties
		x 175
		y 80
		loop 7
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView8 of View
	(properties
		x 227
		y 85
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
		loop 9
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView10 of View
	(properties
		x 134
		y 130
		loop 10
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView11 of View
	(properties
		x 179
		y 122
		loop 11
	)

	(method (onMe)
		(return 0)
	)
)

(instance kidView12 of View
	(properties
		x 227
		y 130
		loop 12
	)

	(method (onMe)
		(return 0)
	)
)

(class MyDText of DText
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(class OldKid of Feature
	(properties
		fileNum 0
		relatedKid 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (Str format: {%s%d.DTA} gCurSaveDir fileNum))
		(= temp2 (File new:))
		(= temp1 (Str new: 200))
		(= temp3 (Str new: 3))
		(temp2
			name: (temp0 data:)
			open: 1
			readString: temp1 200
			read: temp3 3
			close:
		)
		(temp1 strip:)
		(if (>= (= temp4 (temp3 asInteger:)) 300)
			(-= temp4 300)
		)
		(relatedKid view: 200 loop: 1 cel: temp4 init:)
		((MyDText new:)
			font: 999
			setPri: 254
			text: (temp1 data:)
			fore: 24
			posn: (- (relatedKid x:) 20) (+ (relatedKid y:) 2)
			setSize: 250
			init:
			yourself:
		)
		(global511 add: self)
		(temp0 dispose:)
		(temp2 dispose:)
		(temp1 dispose:)
		(temp3 dispose:)
		(super init: &rest)
	)

	(method (doVerb)
		(pickSaveGameNum doit: fileNum)
	)
)

(instance kid1 of OldKid
	(properties
		nsLeft 26
		nsTop 8
		nsRight 67
		nsBottom 36
		x 46
		y 22
	)

	(method (init)
		(= fileNum (local1 at: 0))
		(= relatedKid kidView1)
		(super init: &rest)
	)

	(method (doVerb)
		(= global114 0)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid2 of OldKid
	(properties
		nsLeft 96
		nsTop 7
		nsRight 135
		nsBottom 37
		x 115
		y 22
	)

	(method (init)
		(= fileNum (local1 at: 1))
		(= relatedKid kidView2)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid3 of OldKid
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
		(= fileNum (local1 at: 2))
		(= relatedKid kidView3)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid4 of OldKid
	(properties
		nsLeft 204
		nsTop 3
		nsRight 245
		nsBottom 33
		x 224
		y 18
	)

	(method (init)
		(= fileNum (local1 at: 3))
		(= relatedKid kidView4)
		(super init: &rest)
	)

	(method (doVerb)
		(= global114 3)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid5 of OldKid
	(properties
		nsLeft 49
		nsTop 49
		nsRight 89
		nsBottom 77
		x 69
		y 63
	)

	(method (init)
		(= fileNum (local1 at: 4))
		(= relatedKid kidView5)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid6 of OldKid
	(properties
		nsLeft 100
		nsTop 59
		nsRight 142
		nsBottom 88
		x 121
		y 73
	)

	(method (init)
		(= fileNum (local1 at: 5))
		(= relatedKid kidView6)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid7 of OldKid
	(properties
		nsLeft 153
		nsTop 52
		nsRight 193
		nsBottom 81
		x 173
		y 66
	)

	(method (init)
		(= fileNum (local1 at: 6))
		(= relatedKid kidView7)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid8 of OldKid
	(properties
		nsLeft 206
		nsTop 57
		nsRight 245
		nsBottom 87
		x 225
		y 72
	)

	(method (init)
		(= fileNum (local1 at: 7))
		(= relatedKid kidView8)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid9 of OldKid
	(properties
		nsLeft 67
		nsTop 97
		nsRight 107
		nsBottom 125
		x 87
		y 111
	)

	(method (init)
		(= fileNum (local1 at: 8))
		(= relatedKid kidView9)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid10 of OldKid
	(properties
		nsLeft 113
		nsTop 103
		nsRight 154
		nsBottom 131
		x 133
		y 117
	)

	(method (init)
		(= fileNum (local1 at: 9))
		(= relatedKid kidView10)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid11 of OldKid
	(properties
		nsLeft 158
		nsTop 95
		nsRight 198
		nsBottom 123
		x 178
		y 109
	)

	(method (init)
		(= fileNum (local1 at: 10))
		(= relatedKid kidView11)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
	)
)

(instance kid12 of OldKid
	(properties
		nsLeft 206
		nsTop 103
		nsRight 246
		nsBottom 131
		x 226
		y 117
	)

	(method (init)
		(= fileNum (local1 at: 11))
		(= relatedKid kidView12)
		(super init: &rest)
	)

	(method (doVerb)
		(gSfx stop: client: 0)
		(gSfx number: (+ (Random 0 2) 802) play:)
		(super doVerb: &rest)
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
			(gSfx stop: client: 0)
			(gSfx number: 806 play:)
			(gCurRoom setScript: introScript)
		)
	)
)

(instance pickegoButtonBar of MgButtonBar
	(properties)

	(method (checkCursor param1 &tmp temp0)
		(if (!= (param1 plane:) plane)
			(param1 localize: plane)
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

(instance restoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gGame restore: local3)
			)
		)
	)
)

