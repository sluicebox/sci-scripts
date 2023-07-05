;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm610 0
)

(instance rm610 of FPRoom
	(properties
		noun 1
		picture 610
		style 10
		south 600
	)

	(method (init)
		(gEgo init: setScale: Scaler 116 86 155 128 normalize:)
		(switch gPrevRoomNum
			(south
				(gCurRoom setScript: sEnterFrom600)
			)
			(620
				(gEgo x: 163 y: 136 setHeading: 180)
				(gGame handsOn:)
			)
			(630
				(gEgo x: 264 y: 117)
				(gCurRoom setScript: sEnterFrom630)
			)
			(200
				(gEgo x: 187 y: 148 setHeading: 270)
				(if (== gCurPuzzle 12)
					(srini
						init:
						setCycle: StopWalk -1
						setScale: Scaler 116 86 155 128
					)
					(gCurRoom style: 7 setScript: sBriefSrini)
				else
					(gGame handsOn:)
				)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 160 y: 150)
				(gGame handsOn:)
			)
		)
		(if (and (!= gPrevRoomNum 200) (!= gCurPuzzle 12) (!= gCurPuzzle 14))
			(gGameMusic1 number: 610 loop: -1 play:)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 225 144 226 136 116 136 75 174 0 175 0 189 319 189 319 174 247 174
					yourself:
				)
		)
		(stairs init: setOnMeCheck: 1 2)
		(lamp init: setOnMeCheck: 1 8)
		(leftPicture init: setOnMeCheck: 1 16)
		(rightPicture init: setOnMeCheck: 1 32)
		(bookShelf init: setOnMeCheck: 1 64)
		(carpet init: setOnMeCheck: 1 128)
		(chair init: setOnMeCheck: 1 256)
		(pitcher init: setOnMeCheck: 1 512)
		(desk init: setOnMeCheck: 1 1024)
		(closet init: setOnMeCheck: 1 2048)
		(table init: setOnMeCheck: 1 4096)
		(labScreen init: setOnMeCheck: 26505)
		(deskDrawer
			setCel:
				(if (IsFlag 49)
					(deskDrawer lastCel:)
				else
					0
				)
			init:
			approachVerbs: 4 45 1 ; Do, Desk_Key, Look
		)
		(deskRollTop
			setCel:
				(if (IsFlag 48)
					(deskRollTop lastCel:)
				else
					0
				)
			init:
			approachVerbs: 4 45 1 ; Do, Desk_Key, Look
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((proc0_1 gEgo 4)
				(gCurRoom setScript: sExitTo600)
			)
		)
	)

	(method (dispose)
		(if (!= gCurPuzzle 14)
			(gGameMusic1 fade:)
		)
		(gWalkHandler delete: stairs)
		(gWalkHandler delete: closet)
		(super dispose:)
	)
)

(instance sBriefSrini of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gMessager say: 19 0 0) ; "...so I've been thinking about hiring an assistant to help me around the store, clean up, y'know, the usual chores. Think you'd be interested?"
				(= cycles 1)
			)
			(2
				(srini setMotion: MoveTo 170 250 self)
				(gGameMusic1 fade: 0 30 12 1)
			)
			(3
				(gGameMusic1 number: 610 loop: -1 play:)
				(= global138 0)
				(= gCurPuzzle 13)
				(ClearFlag 84)
				((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo600 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 170 250 self)
			)
			(1
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance sEnterFrom600 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 170 y: 250 setMotion: MoveTo 170 150 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo620 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 163 136 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= cycles 5)
			)
			(3
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance sExitTo630 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 215 138 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 245 138 self)
			)
			(2
				(gEgo setMotion: MoveTo 261 126 self)
			)
			(3
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance sEnterFrom630 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 261 y: 126 setMotion: MoveTo 245 138 self)
			)
			(1
				(gEgo setMotion: MoveTo 215 138 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance srini of Actor
	(properties
		x 151
		y 148
		view 801
		loop 4
	)
)

(instance deskRollTop of Prop
	(properties
		x 62
		y 120
		z 21
		noun 20
		approachX 115
		approachY 155
		view 610
		loop 1
		priority 8
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 46)
					(if (IsFlag 48)
						(self setCycle: Beg self)
						(ClearFlag 48)
					else
						(self setCycle: End self)
						(SetFlag 48)
					)
					(rolltopSound play:)
				else
					(gMessager say: noun 4 1) ; "The desktop's locked. Damn this crude desktop interface!"
				)
			)
			(45 ; Desk_Key
				(if (== (deskRollTop cel:) 0)
					(if (IsFlag 46)
						(ClearFlag 46)
						(gMessager say: noun 45 2) ; "You lock the desktop. You never know who's gonna sneak in here and try to get their hands in your drawers."
					else
						(SetFlag 46)
						(gMessager say: noun 45 3) ; "You unlock the desktop."
					)
				else
					(gMessager say: noun 45 4) ; "Been out in the sun too long? You can't lock the desk until you close it."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance deskDrawer of Prop
	(properties
		x 85
		y 111
		noun 21
		approachX 115
		approachY 155
		view 610
		loop 2
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 47)
					(if (IsFlag 49)
						(self setCycle: Beg self)
						(ClearFlag 49)
					else
						(self setCycle: End self)
						(SetFlag 49)
					)
					(drawerSound play:)
				else
					(gMessager say: noun 4 1) ; "The drawer's locked."
				)
			)
			(1 ; Look
				(cond
					((and (not (gEgo has: 31)) (IsFlag 49)) ; Letter
						(gEgo stopUpd:)
						(gCurRoom setInset: inLetterInset)
					)
					((IsFlag 49)
						(gMessager say: noun 1 4) ; "As some of the ladies down at Madame's have told you: there isn't anything in those drawers worth looking at!"
					)
					(else
						(gMessager say: noun 1 0) ; "It's an interesting drawer."
					)
				)
			)
			(45 ; Desk_Key
				(if (== (deskDrawer cel:) 0)
					(if (IsFlag 47)
						(ClearFlag 47)
						(gMessager say: noun 45 2) ; "You lock the drawer."
					else
						(SetFlag 47)
						(gMessager say: noun 45 3) ; "You unlock the desk drawer."
					)
				else
					(gMessager say: noun 45 4) ; "Funny thing about drawers. You can't lock them when they're wide open."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance labScreen of Feature
	(properties
		x 161
		y 90
		noun 2
		nsTop 50
		nsLeft 133
		nsBottom 130
		nsRight 189
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sExitTo620)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		x 243
		y 116
		noun 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(gCurRoom setScript: sExitTo630)
			)
			(4 ; Do
				(gCurRoom setScript: sExitTo630)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(gWalkHandler add: stairs)
		(super init:)
	)
)

(instance lamp of Feature
	(properties
		x 53
		y 64
		noun 4
	)
)

(instance leftPicture of Feature
	(properties
		x 78
		y 70
		noun 5
	)
)

(instance rightPicture of Feature
	(properties
		x 218
		y 77
		noun 6
	)
)

(instance bookShelf of Feature
	(properties
		x 161
		y 50
		noun 7
	)
)

(instance carpet of Feature
	(properties
		x 168
		y 154
		noun 8
	)
)

(instance chair of Feature
	(properties
		x 116
		y 108
		noun 13
	)
)

(instance pitcher of Feature
	(properties
		x 219
		y 95
		noun 9
	)
)

(instance desk of Feature
	(properties
		x 101
		y 100
		noun 10
	)
)

(instance closet of Feature
	(properties
		x 276
		y 101
		noun 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(gCurRoom setScript: sExitTo630)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(gWalkHandler add: closet)
		(super init:)
	)
)

(instance table of Feature
	(properties
		x 219
		y 110
		noun 12
	)
)

(instance inLetterInset of Inset
	(properties
		view 610
		loop 3
		x 62
		y 87
		disposeNotOnMe 1
		noun 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 31 inLetterInset) ; Letter
				(gGame points: 1)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rolltopSound of FPSound
	(properties
		flags 1
		number 2611
	)
)

(instance drawerSound of FPSound
	(properties
		flags 1
		number 2126
	)
)

