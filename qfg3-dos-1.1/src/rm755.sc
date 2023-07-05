;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use Polygon)
(use Motion)
(use Game)
(use System)

(public
	rm755 0
)

(instance rm755 of Rm
	(properties
		noun 1
		picture 755
		vanishingY -60
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 164 211 164 185 152 159 128 215 116 247 88 142 54 120 56 117 47 48 47 10 43 0 37
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 44 40 55 50 60 106 64 144 57 243 89 215 110 143 126 32 91 0 86
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 96 34 94 141 133 206 168 196 174 124 183 103 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 53 58 53 51 113 51 113 58
					yourself:
				)
		)
		(if (== gPrevRoomNum 750)
			(= style 12)
			(if (< (gEgo y:) 70)
				(self setScript: enterTop)
			else
				(self setScript: enterBottom)
			)
		else
			(gEgo setScale: 190 normalize: x: 300 y: 180 init:)
		)
		(super init:)
	)

	(method (doit)
		(if (GameIsRestarting)
			(gLongSong number: 750 setLoop: -1 play: 127)
			(gLongSong2 number: 391 setLoop: -1 play: 90)
		)
		(cond
			(script 0)
			((<= (gEgo x:) 5)
				(gCurRoom setScript: exitWest)
			)
			((or (>= (gEgo x:) 315) (>= (gEgo y:) 183))
				(gCurRoom setScript: exitEast)
			)
		)
		(super doit:)
	)
)

(instance enterTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScale: 190 x: 0 normalize: init:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 45 55 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScale: 190 x: 0 normalize: init:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 10 93 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 0 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 750)
				(self dispose:)
			)
		)
	)
)

(instance exitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (>= (gEgo x:) 310)
					(gEgo setMotion: MoveTo 340 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 200 self)
				)
			)
			(1
				(gCurRoom newRoom: 170)
			)
		)
	)
)

