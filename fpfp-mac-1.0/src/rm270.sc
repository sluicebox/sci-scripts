;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
)

(local
	local0
)

(instance rm270 of FPRoom
	(properties
		noun 5
		picture 270
		west 260
	)

	(method (init)
		(if (IsFlag 1)
			(= west 265)
		else
			(= west 260)
		)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(= style 100)
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(macView init: hide: stopUpd:)
		(super init:)
		(if (!= gCurPuzzle 14)
			(gGameMusic2 fade: 20 30 12 0)
		)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 0 189 0 135 119 148 169 186 236 186 278 157 269 153 240 163 201 75 56 75 0 85
					yourself:
				)
		)
		(mine init: setOnMeCheck: 1 2)
		(house1 init: setOnMeCheck: 1 4)
		(house2 init: setOnMeCheck: 1 8)
		(tracks init: setOnMeCheck: 1 16)
		(waterTower init: setOnMeCheck: 1 128)
		(train init: setOnMeCheck: 1 512)
		(swamp init: setOnMeCheck: 1 1024)
		(swampLine init: setOnMeCheck: 1 2048)
		(upperRightShrub stopUpd: init:)
		(upperLeftShrub stopUpd: init:)
		(leftShrub stopUpd: init:)
		(rightShrub stopUpd: init:)
		(if (> (gGame detailLevel:) 2)
			(bubbles init: hide:)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((proc0_1 gEgo 1024)
				(gCurRoom setScript: sDieInSwamp)
			)
			((proc0_1 gEgo 2048)
				(gCurRoom setScript: sDieInSwamp)
			)
		)
	)

	(method (dispose)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sBubbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= seconds (Random 7 15))
			)
			(2
				(client loop: 0 cel: 3 show: setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(= seconds (Random 5 10))
			)
			(4
				(client setCycle: End self)
			)
			(5
				(client hide:)
				(self changeState: 1)
			)
		)
	)
)

(instance sDieInSwamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bubbles dispose:)
				(= cycles 1)
			)
			(1
				(gMessager say: 9 0 0 0 self) ; "The swamp seems thick enough to hold your weight!"
			)
			(2
				(gEgo setMotion: PolyPath 193 105 self)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(= cycles 3)
			)
			(5
				(gMessager say: 8 0 1 0 self) ; "Guess I misjudged the surface tension."
			)
			(6
				(gEgo
					view: 271
					setLoop: 0
					setCel: 0
					moveSpeed: 12
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(7
				(= global122 7)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sBreezeShrubs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(client setCycle: Fwd)
				(= seconds (Random 1 5))
			)
			(2
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance bubbles of Prop
	(properties
		x 186
		y 119
		noun 16
		view 270
		cel 3
		cycleSpeed 10
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: sBubbles)
		)
	)
)

(instance upperLeftShrub of Prop
	(properties
		noun 12
		view 270
		loop 1
		cycleSpeed 10
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: sBreezeShrubs)
		)
	)
)

(instance leftShrub of Prop
	(properties
		y 197
		z 51
		noun 10
		view 270
		loop 3
		priority 14
		signal 16
		cycleSpeed 10
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: (sBreezeShrubs new:))
		)
	)
)

(instance rightShrub of Prop
	(properties
		x 319
		y 189
		noun 11
		view 270
		loop 4
		cycleSpeed 10
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: (sBreezeShrubs new:))
		)
	)
)

(instance upperRightShrub of Prop
	(properties
		x 260
		noun 13
		view 270
		loop 2
		cycleSpeed 10
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: (sBreezeShrubs new:))
		)
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance macView of Prop
	(properties
		x 205
		y 101
		view 275
		cel 2
		priority 13
	)
)

(instance waterTower of Feature
	(properties
		x 100
		y 195
		noun 1
	)
)

(instance train of Feature
	(properties
		x 300
		y 198
		noun 3
	)
)

(instance swamp of Feature
	(properties
		x 1
		y 1
		noun 4
	)
)

(instance swampLine of Feature
	(properties
		x 115
		y 189
		noun 1
		nsTop 78
		nsLeft 71
		nsBottom 143
		nsRight 160
	)
)

(instance mine of Feature
	(properties
		x 300
		y 20
		noun 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: macThing)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance house1 of Feature
	(properties
		x 100
		y 20
		noun 2
	)
)

(instance house2 of Feature
	(properties
		x 100
		y 20
		noun 14
	)
)

(instance tracks of Feature
	(properties
		x 100
		y 20
		noun 15
	)
)

(instance macSound of FPSound
	(properties
		number 2953
		loop -1
	)
)

(instance macThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bubbles dispose:)
				(gMessager say: 6 2 0 0 self 270) ; "Howdy, ye mighty hermits in that mountain. What words have you to put a light on my fate?"
			)
			(1
				(gMessager say: 6 0 7 0 self 270) ; "Jason, keeper of the tooth, says..."
			)
			(2
				(macSound number: 2998 play: self)
			)
			(3
				(gMessager say: 6 0 8 0 self) ; "Keith, keeper of the eye, says..."
			)
			(4
				(macSound number: 2999 play: self)
			)
			(5
				(gMessager say: 6 0 9 0 self) ; "Kris, keeper of the hair piece, cannot take your call right now, but if you leave a message, he will answer in the sequel."
			)
			(6
				(gMessager say: 6 0 10 0 self) ; "Behold the Lady of the Swamp as she offers her gift; EXCAL... uh, MACINTOSH!"
			)
			(7
				(macView show: setCycle: End self)
			)
			(8
				(macView loop: 0 cel: 15 setCycle: Beg self)
			)
			(9
				(macView hide:)
				(= seconds 2)
			)
			(10
				(gMessager say: 6 0 11 0 self) ; "Oh, sorry... I see you already have one."
			)
			(11
				(gGame handsOn:)
				(= cycles 1)
			)
			(12
				(bubbles init: hide:)
				(self dispose:)
			)
		)
	)
)

