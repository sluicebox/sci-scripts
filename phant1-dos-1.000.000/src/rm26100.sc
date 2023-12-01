;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	rm26100 0
)

(instance rm26100 of ScaryRoom
	(properties
		picture 26140
		stepSound 4
		baseView 6000
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
		(if (gCast contains: book)
			(switch param1
				(26100
					(book view: 26100 posn: 220 73)
				)
				(26140
					(book view: 26140 posn: 168 74)
				)
				(26200
					(book view: 26200 posn: 45 75)
				)
			)
		)
		(if (gCast contains: doorView)
			(switch param1
				(26100
					(if (== gChapter 5)
						(doorView view: 26102 posn: 38 134 show:)
					else
						(doorView view: 26101 posn: 38 134 show:)
					)
				)
				(else
					(doorView hide:)
				)
			)
		)
	)

	(method (notify)
		(gGame handsOff:)
		(windowScr cue:)
	)

	(method (init)
		(if (== gChapter 5)
			(= picture 26141)
		)
		(gEgo init: setScaler: Scaler 86 54 134 114 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo normalize: 614 posn: 108 127)
				(if (not (IsFlag 267))
					(= picture 26100)
					(self setScript: enterScr)
				else
					(= picture 26140)
					(gEgo normalize: 614 posn: 65 122)
					(self setScript: (ScriptID 0 5)) ; takeLastStep
				)
			)
		)
		(if (not (IsFlag 171))
			(book init: setHotspot: 4 3 approachVerbs: 4) ; Do, Move, Do
			(bookFeat init: setHotspot: 4 3 approachVerbs: 4) ; Do, Move, Do
		)
		(doorView init:)
		(door init: 4)
		(bed init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
		(theWindow init: setHotspot: 4 3 approachVerbs: 4) ; Do, Move, Do
		(super init: &rest)
	)
)

(instance doorView of View
	(properties
		view 26101
	)
)

(instance door of ExitFeature
	(properties
		approachX 14
		approachY 117
		nextRoom 15500
	)

	(method (init)
		(self createPoly: 0 27 5 23 22 43 26 53 26 111 0 116)
		(super init: &rest)
	)
)

(instance bed of Feature
	(properties
		nsLeft 254
		nsTop 106
		nsRight 293
		nsBottom 129
		approachX 120
		approachY 155
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(= global163 self)
				(gCurRoom setScript: bedScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance book of View
	(properties
		approachX 160
		approachY 115
		view 26100
	)

	(method (doVerb theVerb)
		(bookFeat doVerb: theVerb)
	)
)

(instance bookFeat of Feature
	(properties
		nsLeft 165
		nsTop 65
		nsRight 183
		nsBottom 77
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: getBookScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		approachX 241
		approachY 124
		x 241
		y 124
	)

	(method (init)
		(self createPoly: 286 -1 291 17 290 85 269 83 268 18 271 4 274 -2)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(= global163 0)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: windowScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 267)
					(DoRobot 3690 -12 19)
				)
				(1
					(gEgo normalize: 614 posn: 65 122)
					(gCurRoom drawPic: 26140)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 267)
					(gEgo normalize: 614 posn: 65 122)
					(gCurRoom drawPic: 26140)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance windowScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3700 66 13)
					(SetFlag 248)
					(gEgo normalize: 611 posn: 224 124)
					(gCurRoom drawPic: 26200)
				)
				(1
					(SetFlag 121)
					(SetFlag 176)
					(proc1111_8)
					(gCurRoom drawPic: 26210)
					(gGame handsOn:)
					(gUser canControl: 0)
					((ScriptID 0 14) init:) ; exitButt
				)
				(2
					(ClearFlag 121)
					(ClearFlag 248)
					(DoRobot 3701 66 13)
					(gCurRoom drawPic: 26200)
				)
				(3
					(proc1111_9)
					(gEgo normalize: 611 posn: 224 124)
					(gCurRoom drawPic: 26140)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(ClearFlag 121)
					(ClearFlag 248)
					(proc1111_9)
					(gEgo normalize: 611 posn: 224 124)
					(gCurRoom drawPic: 26140)
					(= global115 0)
					(SetFlag 176)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getBookScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(book dispose:)
					(bookFeat dispose:)
					(DoRobot 3770 131 25)
					(gCurRoom drawPic: 26100)
				)
				(1
					(gEgo hide:)
					(DoRobot 3771 -6 -40)
					(gCurRoom drawPic: 26120)
				)
				(2
					(DoRobot 3772 131 25)
					(gCurRoom drawPic: 26100)
				)
				(3
					(gEgo
						normalize: 616
						posn: 142 118
						show:
						setScaler: Scaler 86 54 134 114
						get: 7 ; invVampBook
					)
					(gCurRoom drawPic: 26140)
					(SetFlag 171)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo
						normalize: 616
						posn: 142 118
						show:
						setScaler: Scaler 86 54 134 114
						get: 7 ; invVampBook
					)
					(book dispose:)
					(bookFeat dispose:)
					(gCurRoom drawPic: 26140)
					(SetFlag 171)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance bedScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(if (not global115)
			(switch (= state newState)
				(0
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
					(cond
						((and (== temp0 65) (== temp1 122))
							(gEgo setHeading: 135 self)
						)
						((and (== temp0 142) (== temp1 118))
							(gEgo setHeading: 135 self)
						)
						((and (== temp0 224) (== temp1 124))
							(gEgo setHeading: 180 self)
						)
						((and (== temp0 160) (== temp1 127))
							(gEgo setHeading: 135 self)
						)
					)
				)
				(1
					(DoRobot 3720 97 19)
					(gCurRoom drawPic: 26200)
				)
				(2
					(gEgo normalize: 611 posn: 160 127)
					(gCurRoom drawPic: 26140)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 611 posn: 160 127)
					(gCurRoom drawPic: 26140)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

