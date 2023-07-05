;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 521)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	meanWhile 0
)

(instance meanWhile of LBRoom
	(properties)

	(method (init)
		(self setRegions: 90) ; MuseumRgn
		(super init: &rest)
		(self setScript: sMeanWhile)
	)
)

(instance rosettaCloth of View
	(properties
		x 223
		y 105
		view 521
		loop 13
		priority 9
		signal 16
	)
)

(instance snakeOil of View
	(properties
		x 113
		y 94
		view 520
		loop 3
		priority 8
		signal 16
	)
)

(instance secretDoor of View
	(properties
		x 294
		y 159
		view 524
		loop 1
	)
)

(instance sMeanWhile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 780)
				(DrawPic 780 9)
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(DrawPic 780 11)
				(Display {Meanwhile...} dsCOORD 100 85 dsCOLOR 14 dsFONT 0)
				(= seconds 5)
			)
			(2
				(DrawPic 780 11)
				(= cycles 1)
			)
			(3
				(SetFlag 92)
				(gCurRoom picture: 520 curPic: 520)
				(gCurRoom picture: 520)
				(DrawPic 520 9)
				(WrapMusic pause: 1)
				(gGameMusic2 number: 520 flags: 1 loop: -1 play:)
				(if (not (IsFlag 49))
					(rosettaCloth init: approachVerbs: 4 1 8) ; Do, Look, magnifier
				)
				(if (not (IsFlag 48))
					(snakeOil init: approachVerbs: 1 8) ; Look, magnifier
				)
				(deadCountess init: addToPic:)
				(secretDoor init: addToPic:)
				(gEgo hide:)
				(olympia
					init:
					setCycle: Walk
					setScale: Scaler 140 90 190 0
					setMotion: MoveTo 161 163 self
				)
			)
			(4
				(olympia setCycle: StopWalk -1)
				(= ticks 60)
			)
			(5
				(olympia view: 523 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(6
				(gMessager say: 55 0 1 1 self 520) ; "Countess? Why are you tied up on my desk?"
			)
			(7
				(olympia
					view: 820
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 181 120 self
				)
			)
			(8
				(olympia setCycle: StopWalk -1 setHeading: 270)
				(= ticks 60)
			)
			(9
				(gMessager say: 55 0 1 2 self 520) ; "Your face has certainly changed to an attractive pale color, my dear."
			)
			(10
				(olympia view: 523 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(11
				(= ticks 60)
			)
			(12
				(gMessager say: 55 0 4 0 self 520) ; "You seem a little under the weather. Are you okay?"
			)
			(13
				(olympia
					view: 820
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 170 250 self
				)
			)
			(14
				(olympia dispose:)
				(gGameMusic2 fade: self)
				(= seconds 10)
			)
			(15
				(if seconds
					(= seconds 0)
				)
				(WrapMusic pause: 0)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance olympia of Actor
	(properties
		x 170
		y 250
		view 820
		loop 2
		priority 13
		signal 16
	)
)

(instance deadCountess of View
	(properties
		x 111
		y 89
		approachX 147
		approachY 145
		view 524
		priority 8
		signal 16400
	)
)

