;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use Feature)
(use StopWalk)
(use Motion)
(use System)

(public
	rm335 0
)

(instance rm335 of LBRoom
	(properties
		noun 5
		picture 335
		north 350
		south 330
	)

	(method (init)
		(gEgo
			init:
			normalize: (if (gEgo wearingGown:) 831 else 830)
			setScale: Scaler 100 75 190 160
		)
		(self setRegions: 90 93) ; MuseumRgn, RotundaRgn
		(switch gPrevRoomNum
			(north
				(Palette palSET_INTENSITY 0 255 60)
				(if (and (TimeCheck $0008) (not (IsFlag 133)))
					(frontDoor cel: 255 state: 2 enterType: 2 forceClose: 0)
					(self setScript: sOffToSmooch)
				else
					(frontDoor forceOpen: 1)
					(gEgo
						posn: (frontDoor moveToX:) (frontDoor moveToY:)
						edgeHit: EDGE_NONE
					)
				)
			)
			(south
				(self setScript: sEnterSouth)
				(cond
					((!= gAct 2))
					((IsFlag 25)
						(gGameMusic1 number: 335 flags: 1 setLoop: -1 play: 50)
					)
					(else
						(gGameMusic1 number: 19 flags: 1 setLoop: -1 play:)
					)
				)
			)
			(else
				(gEgo posn: 150 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(southExitFeature init:)
		(frontDoor init: setPri: 12)
		(otherDoor init:)
		(banner init: approachVerbs: 4 8) ; Do, magnifier
		(glass init:)
		(column init:)
		(if (and (== gAct 2) (not (IsFlag 25)))
			((ScriptID 32 0) ; aHeimlich
				init:
				view: 341
				room: gCurRoomNum
				posn: 131 173 0
				setLoop: 0
				actions: doorActions
				approachX: 137
				approachY: 180
				approachVerbs: 4 11 2 6 ; Do, pressPass, Talk, Ask
			)
		else
			(frontDoor locked: (!= gAct 2))
		)
	)

	(method (newRoom)
		(gGameMusic1 fade:)
		(super newRoom: &rest)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 165 240 setMotion: PolyPath 165 185 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(frontDoor caller: self open:)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(frontDoor moveToX:)
						(frontDoor moveToY:)
						self
				)
			)
			(2
				(DrawPic 780 10)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				((ScriptID 21 0) doit: 265) ; addCluesCode, Wolf Heimlich
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sGiveInvite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 32 0) setLoop: 0 cycleSpeed: 6 setCycle: CT 8 1 self) ; aHeimlich
			)
			(1
				(= ticks 15)
			)
			(2
				((ScriptID 32 0) setCycle: End self) ; aHeimlich
			)
			(3
				((ScriptID 32 0) setCel: 0) ; aHeimlich
				(= cycles 2)
			)
			(4
				(gMessager say: 6 11 0 0 self) ; "Danke, Fraulein. I'll return zis pass when you are leafink. Enjoy yourself zis evenink."
			)
			(5
				(SetFlag 23)
				(gEgo put: 6) ; pressPass
				((ScriptID 21 1) doit: 775) ; dropCluesCode, Press Pass
				((ScriptID 22 0) doit: $7001) ; triggerAndClock, 7:00 pm
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOffToSmooch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 153 160 setMotion: PolyPath 160 250 self)
				(= cycles 1)
			)
			(1
				(DrawPic 335)
				(Palette palSET_INTENSITY 0 255 60)
				(= ticks 15)
			)
			(2
				((ScriptID 93 8) ; Steve
					init:
					setCycle: StopWalk -1
					posn: 153 160
					setMotion: PolyPath 130 260
				)
			)
			(3
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance frontDoor of Door
	(properties
		x 164
		y 162
		noun 3
		approachX 152
		approachY 173
		view 336
		moveToX 152
		moveToY 152
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gEgo wearingGown:))
						(gMessager say: noun 4 6) ; "The door is locked."
					)
					((not (IsFlag 23))
						(gMessager say: noun 4 7) ; "Excuse me, Fraulein, but zis affair is by invitation only. Your papers please!"
					)
					(else
						(gCurRoom setScript: sExitNorth)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsLeft 80
		nsBottom 189
		nsRight 290
		cursor 11
		exitDir 3
		noun 4
	)
)

(instance banner of Feature
	(properties
		x 215
		y 123
		noun 1
		nsTop 80
		nsLeft 203
		nsBottom 137
		nsRight 258
		sightAngle 40
	)
)

(instance glass of Feature
	(properties
		x 140
		y 70
		noun 2
		sightAngle 40
		onMeCheck 8192
	)
)

(instance otherDoor of Feature
	(properties
		x 131
		y 141
		noun 16
		nsTop 115
		nsLeft 121
		nsBottom 167
		nsRight 142
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(frontDoor doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance column of Feature
	(properties
		x 30
		y 170
		noun 8
		sightAngle 40
		onMeCheck 16384
	)
)

(instance doorActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1) ; "There is a tall, imposing gentleman guarding the door. He appears to be wearing a German military uniform."
			)
			(4 ; Do
				(gMessager say: 6 4) ; "Please, Fraulein! Ve are barely knowink each other!"
			)
			(11 ; pressPass
				(gCurRoom setScript: sGiveInvite)
			)
			(2 ; Talk
				(if (gEgo has: 6) ; pressPass
					(gMessager say: 6 2 7) ; "Zis affair is by invitation only, Fraulein. Your papers, please."
				else
					(gMessager say: 6 2) ; "I am zorry, but I haf no time to talk, Fraulein. I am ze Chief of Security, you understand. I haf much responsibility."
				)
			)
			(6 ; Ask
				(gMessager say: 6 2) ; "I am zorry, but I haf no time to talk, Fraulein. I am ze Chief of Security, you understand. I haf much responsibility."
			)
			(else
				(return 0)
			)
		)
	)
)

