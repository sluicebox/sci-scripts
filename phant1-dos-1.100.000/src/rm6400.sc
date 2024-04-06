;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6400)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6400 0
)

(instance rm6400 of ScaryRoom
	(properties
		picture 6401
		south 6500
		stepSound 4
	)

	(method (init)
		(gEgo init: setScaler: Scaler 103 53 129 89 normalize: 0)
		(if (!= gPrevRoomNum 6500)
			(global114 stop: 1 play: 6005)
		)
		(switch gPrevRoomNum
			(35150
				(gEgo normalize: 2 posn: 210 82 hide:)
				(KillRobot)
				(Load 140 6021) ; WAVE
				(cryptDoor cel: 100 init: setPri: 90)
				(WalkieTalkie showFrame: 6581 0 68 -20 12)
				(if (== gChapter 5)
					(= picture 6585)
				else
					(= picture 6580)
				)
				(self setScript: fromPassageScr)
			)
			(else
				(gEgo
					posn: 150 90
					normalize: 0
					setScript: (ScriptID 0 5) 0 10 ; takeLastStep
				)
				(if (IsFlag 206)
					(chest init: setPri: 300)
				)
			)
		)
		(firePlace init: 1)
		(westExit init: 4)
		(if (IsFlag 215)
			(secDoor init: setHotspot: 4 3) ; Do, Move
		)
		(super init: &rest)
	)
)

(instance chest of View
	(properties
		x 280
		y 123
		view 64001
	)
)

(instance sToLib of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(= global125 9)
				(gCurRoom newRoom: 6500)
			)
		)
	)
)

(instance toPassageScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 90 self)
				)
				(1
					(gEgo hide:)
					(if (gCast contains: chest)
						(chest dispose:)
					)
					(cryptDoor cel: 100 init: setPri: 90)
					(if (== gChapter 5)
						(gCurRoom drawPic: 6585)
					else
						(gCurRoom drawPic: 6580)
					)
					(DoRobot 6580 104 -6 gEgo 120 1)
				)
				(2
					(sOpen setLoop: 1 play:)
					(cryptDoor setCycle: Beg self)
				)
				(3)
				(4
					(sOpen setLoop: 1 play:)
					(cryptDoor setPri: 130 setCycle: End self)
				)
				(5)
				(6
					(sClose stop:)
					(sOpen stop:)
					(gCurRoom newRoom: 35150)
				)
			)
		else
			(switch (= state newState)
				(0
					(sClose stop:)
					(sOpen stop:)
					(= global115 0)
					(gCurRoom newRoom: 35150)
				)
			)
		)
	)
)

(instance fromPassageScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(if (== gChapter 5)
						(Load rsVIEW 6585)
					else
						(Load rsVIEW 6580)
					)
					(= cycles 2)
				)
				(1
					(sOpen setLoop: 1 setVol: 127 play:)
					(cryptDoor setCycle: Beg self)
				)
				(2
					(sOpen stop:)
					(KillRobot)
					(DoRobot 6581 68 -20 gEgo 120 1)
				)
				(3
					(sOpen setLoop: 1 play:)
					(cryptDoor setCycle: End self)
				)
				(4)
				(5
					(sOpen stop:)
					(sClose stop:)
					(cryptDoor dispose:)
					(KillRobot)
					(gEgo
						posn: 150 90
						show:
						setScaler: Scaler 103 53 129 89
						normalize: 1
						cel: 0
						setCycle: End self
					)
					(if (IsFlag 206)
						(chest init: setPri: 300)
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 6405)
					else
						(gCurRoom drawPic: 6400)
					)
				)
				(6
					(gEgo setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(sOpen stop:)
					(sClose stop:)
					(if (gCast contains: cryptDoor)
						(cryptDoor dispose:)
					)
					(sClose stop:)
					(sOpen stop:)
					(gEgo
						posn: 150 90
						show:
						setScaler: Scaler 103 53 129 89
						normalize: 1
						setCycle: 0
					)
					(if (IsFlag 206)
						(chest init: setPri: 300)
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 6405)
					else
						(gCurRoom drawPic: 6400)
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance cryptDoor of Prop
	(properties
		x 146
		y 103
		view 6580
	)

	(method (init)
		(if (== gChapter 5)
			(self view: 6585 posn: 146 100)
		)
		(super init: &rest)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 79
		nsRight 130
		x 99
		y 81
		nextRoom 6500
	)
)

(instance southExit of ExitFeature ; UNUSED
	(properties
		nsLeft 131
		nsTop 100
		nextRoom 6500
	)
)

(instance secDoor of Feature
	(properties
		nsLeft 175
		nsTop 45
		nsRight 208
		nsBottom 72
		approachX 191
		approachY 58
		x 191
		y 58
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: toPassageScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance firePlace of ExitFeature
	(properties
		nsLeft 78
		nsTop 49
		nsRight 115
		nsBottom 78
		approachX 96
		approachY 63
		x 96
		y 63
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(= global125 9)
			(gCurRoom setScript: sToLib)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sOpen of Sound
	(properties
		number 6021
	)
)

(instance sClose of Sound
	(properties
		number 6022
	)
)

(instance sPush of Sound ; UNUSED
	(properties
		number 6020
	)
)

