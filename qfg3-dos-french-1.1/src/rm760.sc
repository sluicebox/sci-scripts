;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 760)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm760 0
)

(instance rm760 of Rm
	(properties
		noun 1
		picture 760
		vanishingY -200
	)

	(method (init)
		(if (not (== (gLongSong number:) 750))
			(gLongSong number: 750 setLoop: -1 play:)
		)
		(if (not (== (gLongSong2 number:) 391))
			(gLongSong2 number: 391 setLoop: -1 play: 90)
		)
		(gEgo normalize: setScale: Scaler 40 25 190 0)
		(switch gPrevRoomNum
			(750
				(gCurRoom setScript: enterFr750)
			)
			(770
				(gCurRoom setScript: enterFr770)
			)
			(else
				(gCurRoom setScript: enterFr780)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 276 189 237 164 192 149 174 134 145 129 119 132 76 132 63 115 45 112 70 105 80 95 97 91 113 89 141 82 168 99 194 99 187 92 170 97 141 79 115 85 120 76 127 73 139 70 156 56 190 46 190 44 164 36 180 34 186 31 181 25 118 25 118 31 128 27 179 27 182 31 167 34 151 35 186 45 157 53 140 67 123 72 117 76 111 87 99 87 76 94 68 104 45 109 41 114 61 117 74 134 100 134 117 134 143 132 173 136 191 152 239 168 270 189
					yourself:
				)
		)
		(super init:)
		(falls init:)
		(leftTree init:)
		(littleTree init:)
		(lowerCave init:)
		(upperCave init:)
		(theExit init:)
		(waterFall init: cycleSpeed: 7 setCycle: Fwd)
	)
)

(instance enterFr750 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 266 y: 185 code: outCheck init:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFr780 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 124 y: 25 init: setMotion: PolyPath 130 25 self)
			)
			(1
				(gEgo code: outCheck)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFr770 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					x: 179
					y: 97
					init:
					setPri: 8
					setMotion: MoveTo 181 98 self
				)
			)
			(1
				(gEgo code: outCheck)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance waterFall of Prop
	(properties
		x 87
		y 100
		view 760
		priority 9
		signal 16400
	)
)

(instance falls of Feature
	(properties
		x 107
		y 64
		noun 7
		nsTop 31
		nsLeft 100
		nsBottom 97
		nsRight 114
		sightAngle 180
	)
)

(instance leftTree of Feature
	(properties
		x 21
		y 74
		noun 2
		nsTop 37
		nsLeft 2
		nsBottom 111
		nsRight 40
		sightAngle 180
	)
)

(instance littleTree of Feature
	(properties
		x 151
		y 109
		noun 3
		nsTop 91
		nsLeft 138
		nsBottom 128
		nsRight 165
		sightAngle 180
	)
)

(instance lowerCave of Feature
	(properties
		x 186
		y 87
		noun 4
		nsTop 76
		nsLeft 170
		nsBottom 98
		nsRight 203
		sightAngle 180
	)
)

(instance upperCave of Feature
	(properties
		x 123
		y 17
		noun 5
		nsTop 2
		nsLeft 111
		nsBottom 32
		nsRight 135
		sightAngle 180
	)
)

(instance theExit of Feature
	(properties
		x 283
		y 177
		noun 6
		nsTop 166
		nsLeft 259
		nsBottom 189
		nsRight 308
		sightAngle 180
	)
)

(instance outCheck of Code
	(properties)

	(method (doit &tmp temp0)
		(if (GameIsRestarting)
			(gLongSong number: 750 setLoop: -1 play: 127)
			(gLongSong2 number: 391 setLoop: -1 play: 90)
		)
		(cond
			((== (= temp0 (gEgo onControl: 1)) 4)
				(gCurRoom newRoom: 750)
			)
			((== temp0 8)
				(gCurRoom newRoom: 780)
			)
			((== temp0 16)
				(gCurRoom newRoom: 770)
			)
			((and (== temp0 64) (not (& (gEgo signal:) $0010)))
				(gEgo setPri: 7)
			)
			((== temp0 32)
				(gEgo setPri: -1)
			)
			((and (== temp0 32) (not (== (gEgo priority:) 8)))
				(gEgo setPri: 8)
			)
		)
	)
)

