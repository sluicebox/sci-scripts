;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm5200 0
)

(instance rm5200 of ScaryRoom
	(properties
		baseView 6000
	)

	(method (drawPic param1)
		(super drawPic: param1)
		(if (gCast contains: figurine)
			(switch param1
				(5202
					(figurine
						view: 5202
						posn: 114 82
						setPri: 115
						cel: 1
						setHotspot: 4 3 ; Do, Move
						show:
					)
				)
				(5203
					(figurine
						view: 5203
						posn: 193 90
						setPri: 165
						cel: 2
						setHotspot: 4 3 ; Do, Move
						show:
					)
				)
				(else
					(figurine hide:)
				)
			)
		)
	)

	(method (notify)
		(ClearFlag 248)
		((ScriptID 0 14) dispose:) ; exitButt
		(theDrawerScr cue:)
	)

	(method (init)
		(if (== gPrevRoomNum 900)
			(bigExitFeat init: 1)
			(= picture 5203)
		else
			(= picture 5202)
		)
		(drawer init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(gEgo init: setScale: 0 hide:)
		(if
			(or
				(== ((gInventory at: 21) owner:) gCurRoomNum) ; invFigurine
				(and (not (gEgo has: 21)) (not (IsFlag 159))) ; invFigurine
			)
			(figurine
				view: 5203
				posn: 193 90
				setPri: 115
				cel: 2
				setHotspot: 4 3 ; Do, Move
				init:
			)
		)
		(super init:)
		(if (== gPrevRoomNum 900)
			(gEgo
				posn: 163 133
				show:
				setScaler: Scaler 75 30 131 85
				normalize: 615
			)
			(gCurRoom drawPic: 5203)
			(gGame handsOn:)
		else
			(self setScript: enterRoom)
		)
	)
)

(instance figurine of View
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sGetFigurine)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bigExitFeat of ExitFeature
	(properties
		nsLeft 45
		nsTop 12
		nsRight 236
		nsBottom 82
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: leaveRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance drawer of Feature
	(properties
		nsLeft 155
		nsTop 104
		nsRight 186
		nsBottom 123
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: toDrawerScr)
			(bigExitFeat dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 2002 -14 -27 gEgo -1 1)
					(gCurRoom drawPic: 5202)
				)
				(1
					(gEgo hide:)
					(gCurRoom newRoom: 5100)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo hide:)
					(gCurRoom newRoom: 5100)
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (dispose)
		(KillRobot)
		(= global115 0)
		(gCurRoom drawPic: 5203)
		(gEgo
			posn: 163 133
			init:
			setScaler: Scaler 75 30 131 85
			normalize: 615
		)
		(bigExitFeat init: 1)
		(gGame handsOn:)
		(gUser canControl: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 2000 140 -23)
				)
				(1
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGetFigurine of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(bigExitFeat dispose:)
					(DoRobot 2001 97 -4 gEgo 200)
					(figurine dispose:)
					(gCurRoom drawPic: 5202)
				)
				(1
					(= global169 (GetTime 1)) ; SysTime12
					(gEgo get: 21) ; invFigurine
					(bigExitFeat init: 1)
					(gCurRoom drawPic: 5203)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(KillRobot)
					(= global115 0)
					(bigExitFeat init: 1)
					(gCurRoom drawPic: 5203)
					(= global169 (GetTime 1)) ; SysTime12
					(gEgo get: 21) ; invFigurine
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance toDrawerScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 2020 19 27)
					(gCurRoom drawPic: 5202)
				)
				(1
					(gEgo hide:)
					(gCurRoom setScript: theDrawerScr)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo hide:)
					(gCurRoom setScript: theDrawerScr)
				)
			)
		)
	)
)

(instance theDrawerScr of Script
	(properties)

	(method (dispose)
		(ClearFlag 121)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 121)
					(letter init:)
					(letterFeat init: setHotspot: 4 3) ; Do, Move
					(drawerHandle init: setHotspot: 4 3) ; Do, Move
					((ScriptID 0 14) init:) ; exitButt
					(drawer dispose:)
					(gEgo hide:)
					(if (gCast contains: figurine)
						(figurine dispose:)
					)
					(SetFlag 248)
					(gCurRoom drawPic: 5204)
					(gGame handsOn:)
					(gUser canControl: 0)
				)
				(1
					(gGame handsOff:)
					(ClearFlag 248)
					(ClearFlag 121)
					((ScriptID 0 14) dispose:) ; exitButt
					(letter dispose:)
					(letterFeat dispose:)
					(drawerHandle dispose:)
					(if
						(or
							(== ((gInventory at: 21) owner:) gCurRoomNum) ; invFigurine
							(and (not (gEgo has: 21)) (not (IsFlag 159))) ; invFigurine
						)
						(figurine
							view: 5202
							posn: 141 75
							setPri: 115
							cel: 1
							setHotspot: 4 3 ; Do, Move
							init:
						)
					)
					(DoRobot 2023 34 25)
					(gCurRoom drawPic: 5202)
				)
				(2
					(bigExitFeat init: 1)
					(gEgo posn: 163 133 show: normalize: 615)
					(drawer init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					(gCurRoom drawPic: 5203)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: (ScriptID 0 14)) ; exitButt
						((ScriptID 0 14) dispose:) ; exitButt
					)
					(ClearFlag 248)
					(= global115 0)
					(letter dispose:)
					(letterFeat dispose:)
					(drawerHandle dispose:)
					(gEgo posn: 163 133 show: normalize: 615)
					(if
						(and
							(not (gCast contains: figurine))
							(not (gEgo has: 21)) ; invFigurine
							(not (IsFlag 159))
						)
						(figurine
							view: 5203
							posn: 155 85
							setPri: 115
							cel: 2
							init:
							setHotspot: 4 3 ; Do, Move
						)
					)
					(drawer init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					(bigExitFeat init: 1)
					(gCurRoom drawPic: 5203)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance letter of View
	(properties
		x 124
		y 116
		view 5205
	)

	(method (doVerb theVerb)
		(letterFeat doVerb: theVerb)
	)
)

(instance letterFeat of Feature
	(properties
		nsLeft 150
		nsTop 95
		nsRight 166
		nsBottom 111
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: letterScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance drawerHandle of Feature
	(properties
		nsLeft 143
		nsTop 121
		nsRight 194
		nsBottom 132
		x 168
		y 132
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(theDrawerScr cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bigLetter of View
	(properties
		x 1
		y 130
		view 5204
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0 setHotspot: 0)
	)
)

(instance voiceOver of Sound
	(properties)
)

(instance letterScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					((ScriptID 0 14) dispose:) ; exitButt
					(ClearFlag 248)
					(letter hide:)
					(if
						(or
							(== ((gInventory at: 21) owner:) gCurRoomNum) ; invFigurine
							(and (not (gEgo has: 21)) (not (IsFlag 159))) ; invFigurine
						)
						(figurine
							view: 5202
							posn: 141 75
							setPri: 115
							cel: 1
							init:
							setHotspot: 4 3 ; Do, Move
						)
					)
					(DoRobot 2021 60 31)
					(gCurRoom drawPic: 5202)
				)
				(1
					(figurine dispose:)
					(bigLetter view: 5204 posn: 1 130 init: show:)
					(gCurRoom drawPic: 5204)
					(global114 pause:)
					(voiceOver number: 5010 setLoop: 1 play: self)
				)
				(2
					(voiceOver dispose:)
					(global114 endPause:)
					(= seconds 2)
				)
				(3
					(bigLetter dispose:)
					(if
						(or
							(== ((gInventory at: 21) owner:) gCurRoomNum) ; invFigurine
							(and (not (gEgo has: 21)) (not (IsFlag 159))) ; invFigurine
						)
						(figurine
							view: 5202
							posn: 141 75
							setPri: 115
							cel: 1
							init:
						)
					)
					(DoRobot 2022 31 25)
					(gCurRoom drawPic: 5202)
				)
				(4
					(if
						(or
							(== ((gInventory at: 21) owner:) gCurRoomNum) ; invFigurine
							(and (not (gEgo has: 21)) (not (IsFlag 159))) ; invFigurine
						)
						(figurine view: 5203 posn: 155 85 setPri: 115 cel: 2)
					)
					(gCurRoom drawPic: 5203)
					(gEgo posn: 163 133 show: normalize: 615)
					(drawer init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					(letter dispose:)
					(bigExitFeat init: 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 248)
					(KillRobot)
					(global114 endPause: 1)
					(if
						(or
							(== ((gInventory at: 21) owner:) gCurRoomNum) ; invFigurine
							(and (not (gEgo has: 21)) (not (IsFlag 159))) ; invFigurine
						)
						(figurine
							view: 5203
							posn: 155 85
							setPri: 115
							cel: 2
							init:
							setHotspot: 4 3 ; Do, Move
						)
					)
					(if (gCast contains: bigLetter)
						(bigLetter dispose:)
					)
					(if (Sounds contains: voiceOver)
						(voiceOver dispose:)
					)
					(gCurRoom drawPic: 5203)
					(= global115 0)
					(gEgo posn: 163 133 show: normalize: 615)
					(drawer init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
					(letter dispose:)
					(letterFeat dispose:)
					(drawerHandle dispose:)
					(bigExitFeat init: 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

