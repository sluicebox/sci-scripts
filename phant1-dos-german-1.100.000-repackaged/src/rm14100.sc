;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Actor)
(use System)

(public
	rm14100 0
)

(local
	local0
)

(instance rm14100 of ScaryRoom
	(properties
		picture 14260
		stepSound 4
		baseView 6000
	)

	(method (init)
		(gEgo init: setScaler: Scaler 77 43 130 105 normalize:)
		(if (not (gEgo has: 19)) ; invCutter
			(glass init:)
			(if (== gChapter 7)
				(glass approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
			else
				(glass view: 14261 posn: 55 33 setPri: 100)
			)
		)
		(teddy init:)
		(switch gPrevRoomNum
			(14200
				(gEgo normalize: 613 posn: 118 135)
				(if (== global125 9)
					(gCurRoom setScript: sRipOffTeddyHead)
				)
			)
			(else
				(gEgo normalize: 612 heading: 180 posn: 118 120)
				(= global125 0)
			)
		)
		(if (and (< gChapter 6) (not (IsFlag 312)))
			(teddy approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(southExit init: 3)
		(door init: 1)
		(super init: &rest)
		(if (not script)
			(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not script)
				(not (event claimed:))
				(<= gChapter 6)
				(glass onMe: gMouseX gMouseY)
				(== (++ local0) 4)
			)
			(gCurRoom setScript: sBabyLaughs)
		)
		(super handleEvent: event)
	)
)

(instance sDoShard of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gEgo has: 10) ; invBrooch
						(proc1111_7 5890 19 18)
					else
						(glass dispose:)
						(proc1111_7 5880 19 18)
					)
					(teddy posn: 194 48)
					(glass posn: 49 124)
					(gCurRoom drawPic: 14200)
				)
				(1
					(gCurRoom drawPic: 14260)
					(glass posn: 59 111)
					(teddy posn: 174 52)
					(gEgo normalize: 614 posn: 118 120)
					(if (not (gEgo has: 10)) ; invBrooch
						(gEgo get: 19) ; invCutter
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (not (gEgo has: 10)) ; invBrooch
						(gEgo get: 19) ; invCutter
					)
					(proc1111_6)
					(= global115 0)
					(teddy posn: 174 52)
					(gCurRoom drawPic: 14260)
					(glass posn: 59 111)
					(gEgo normalize: 614 posn: 118 120)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBabyLaughs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= ticks 10)
				)
				(1
					(glass cel: 1)
					(= ticks 10)
				)
				(2
					(glass cel: 2)
					(gGDacSound loop: 1 setLoop: 1 number: 14010 play: 127 self)
				)
				(3
					(glass cel: 1)
					(= ticks 10)
				)
				(4
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(gGDacSound stop:)
		(glass cel: 0)
		(= global115 0)
		(= local0 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sRipOffTeddyHead of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 312)
					(if (and (== gPrevRoomNum 14200) global125)
						(gCurRoom picture: 14200)
					else
						(gCurRoom drawPic: 14200)
					)
					(teddy hide:)
					(= global125 0)
					(proc1111_7 1260 149 32)
					(if (== gChapter 7)
						(glass posn: 49 124)
					else
						(glass view: 14204 posn: 40 21)
					)
				)
				(1
					(global114 pause:)
					(if (gCast contains: glass)
						(glass hide:)
					)
					(proc1111_7 1261 23 -4)
					(gCurRoom drawPic: 14270)
				)
				(2
					(if (gCast contains: glass)
						(glass show:)
					)
					(gCurRoom drawPic: 14200)
					(proc1111_7 1262 116 23)
				)
				(3
					(global114 endPause:)
					(gEgo normalize: 614 posn: 149 110)
					(gCurRoom drawPic: 14260)
					(if (== gChapter 7)
						(glass posn: 59 111)
					else
						(glass view: 14261 posn: 55 33)
					)
					(teddy show: setHotspot: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(global114 endPause: 1)
					(gEgo normalize: 614 posn: 149 110)
					(if (gCast contains: glass)
						(if (== gChapter 7)
							(glass show: posn: 59 111)
						else
							(glass show: view: 14261 posn: 55 33)
						)
					)
					(gCurRoom drawPic: 14260)
					(teddy show: setHotspot: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance glass of View
	(properties
		x 59
		y 111
		view 14203
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sDoShard)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 94
		nsTop 31
		nsRight 128
		nsBottom 102
		approachX 114
		approachY 100
		x 111
		y 66
		nextRoom 15100
	)
)

(instance teddy of View
	(properties
		approachX 206
		approachY 130
		x 174
		y 52
		view 14201
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sRipOffTeddyHead)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 14
		nsTop 126
		nsRight 306
		x 160
		y 145
		nextRoom 14200
		appYOffset 20
	)

	(method (handleEvent)
		(= approachX (gEgo x:))
		(super handleEvent: &rest)
	)
)

