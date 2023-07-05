;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use panorama)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm150 0
)

(local
	local0
)

(instance rm150 of PanoRoom
	(properties
		noun 7
		picture 150
	)

	(method (init)
		(if (== gPrevRoomNum 330)
			(fire init: hide:)
			(SetFlag 88)
			(gLongSong number: 285 setLoop: -1 play: 127)
		else
			(gLongSong number: 150 setLoop: -1 play: 127)
		)
		(if (or (IsFlag 85) (== gPrevRoomNum 160))
			(= east 160)
		)
		(HandsOff)
		(self
			setRegions: 50 ; panorama
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 0 319 0 319 54 139 49 79 59 65 74 125 69 156 78 99 86 121 95 116 113 129 134 170 141 238 173 319 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 284 118 284 126 255 126 244 126 244 118
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 262 75 264 85 204 85 194 75 238 69
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 184 52 225 56 225 61 184 61
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 142 101 169 101 226 115 206 122 220 128 187 138 170 128 189 120 169 112 128 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 141 119 159 118 159 126 141 126
					yourself:
				)
			setScript:
				(switch gPrevRoomNum
					(400
						(gEgo posn: global363 global364)
						fromSavanna
					)
					(380 fromVines)
					(east
						(= style 11)
						fromSimbaniPanorama
					)
					(else fromTarna)
				)
		)
		(river_1 init: setCycle: Rev)
		(river_2 init: setCycle: Rev)
		(river_3 init: setCycle: Rev)
		(river_4 init: setCycle: Rev)
		(tarna init:)
		(rockPile init:)
		(smallRockPile init:)
		(mountains init:)
		(if (and (IsFlag 99) (== global468 gCurRoomNum))
			(honeyTree x: global422 y: global423 init: stopUpd:)
		)
		(super init: &rest)
		(if (not (IsFlag 208))
			(gGame save: 1)
		)
		(gEgo solvePuzzle: 208 3)
	)

	(method (cue)
		(cond
			((& (gEgo onControl:) $0010)
				(gEgo setMotion: 0)
				(self newRoom: 200)
			)
			((gEgo inRect: 244 118 292 128)
				(self newRoom: 380)
			)
			((and (> (gEgo x:) 315) (== gPrevRoomNum 330))
				(self setScript: toSimbani)
			)
			(
				(and
					(IsFlag 99)
					(== global468 gCurRoomNum)
					(gEgo
						inRect:
							global422
							(- global423 20)
							(+ global422 20)
							global423
					)
				)
				(SetFlag 143)
				(= global365 2)
				(self newRoom: 400)
			)
			((& (gEgo onControl:) $0400)
				(SetFlag 143)
				(= global365 999)
				(self newRoom: 400)
			)
			(else
				(self newRoom: 0)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((& (gEgo onControl:) $0010)
				(gEgo setMotion: 0)
				(gCurRoom newRoom: 200)
			)
			((gEgo inRect: 244 118 292 128)
				(gEgo setMotion: 0)
				(self newRoom: 380)
			)
		)
	)

	(method (dispose)
		(DisposeScript 35)
		(super dispose:)
	)
)

(instance noEnterTarna of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 3 6 10 0 self) ; "The gates of Tarna are barred to you, and you cannot return."
			)
			(1
				(if (> (gEgo y:) (gEgo yLast:))
					(gEgo
						setMotion:
							PolyPath
							(+ (gEgo x:) 5)
							(- (gEgo y:) 5)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (gEgo x:) 5)
							(+ (gEgo y:) 5)
							self
					)
				)
			)
			(2
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance toSimbani of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 319 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance mustLeave of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo code: 0)
				(gMessager say: 3 6 1 0 self) ; "It is getting late, and you don't want to miss your morning meeting with Rakeesh in the Hall of Judgement. You return to Tarna."
			)
			(1
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance fromTarna of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 88)
					(gEgo view: 153)
				)
				(gEgo posn: 117 87 setMotion: PolyPath 131 91 self)
			)
			(1
				(if (IsFlag 88)
					(gCurRoom setScript: rakeeshWalk)
				else
					(self cue:)
				)
			)
			(2
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance rakeeshWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 150 95 self)
			)
			(1
				(gMessager say: 2 6 9 0 self) ; "It feels very good to be back in my homeland, my friend. This is the savanna, the high grasslands that teem with animals."
			)
			(2
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 170 91 self)
			)
			(3
				(gMessager say: 2 6 3 0 self) ; "There are few animals which will bother a traveler here. The zebras and other herd animals will avoid you. Even the tigers will seek other prey."
			)
			(4
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 205 95 self)
			)
			(5
				(gMessager say: 2 6 4 0 self) ; "However, there are things that are not quite animals. They have little fear of humans and may attack. The Field Guide to Eastern Fricana will help you, so study it well. I will be using my skills as a Paladin to avoid danger."
			)
			(6
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 240 93 self)
			)
			(7
				(gMessager say: 2 6 5 0 self) ; "As a Paladin becomes more in tune with the Essential Rightness of the Universe, he gains certain new abilities, such as healing. The more good one does, the more good things one can do."
			)
			(8
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 265 95 self)
			)
			(9
				(gMessager say: 2 6 6 0 self) ; "I have been a Paladin for a long time now, ever since the Demons last invaded this land. We must prevent this war between people, and drive any Demons back to the world from which they came."
			)
			(10
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 286 94 self)
			)
			(11
				(gEgo setMotion: PolyPath 290 94 self)
			)
			(12
				(gEgo setMotion: PolyPath 319 91 self)
			)
			(13
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance fromVines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 262 129 setMotion: PolyPath 258 140 self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fromSimbaniPanorama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn 6 3)
				(gEgo x: 318 setMotion: MoveTo 314 (gEgo y:))
				(self dispose:)
			)
		)
	)
)

(instance fromSavanna of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(= cycles 10)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 295
		y 94
		view 150
	)
)

(instance honeyTree of Prop
	(properties
		view 150
		loop 1
		cel 2
		signal 16384
	)
)

(instance tarna of Feature
	(properties
		x 114
		y 75
		noun 1
		onMeCheck 16
	)
)

(instance rockPile of Feature
	(properties
		x 230
		y 76
		noun 4
		nsTop 67
		nsLeft 201
		nsBottom 85
		nsRight 260
	)
)

(instance smallRockPile of Feature
	(properties
		x 264
		y 121
		noun 5
		nsTop 116
		nsLeft 245
		nsBottom 127
		nsRight 283
	)
)

(instance mountains of Feature
	(properties
		x 218
		y 16
		noun 6
		nsTop 6
		nsLeft 118
		nsBottom 26
		nsRight 319
	)
)

(instance river_1 of Prop
	(properties
		name {river#1}
		x 190
		y 189
		noun 8
		view 150
		loop 3
		cel 2
		priority 15
		signal 16
		cycleSpeed 7
	)
)

(instance river_2 of Prop
	(properties
		name {river#2}
		x 165
		y 167
		noun 9
		view 150
		loop 4
		cel 3
		priority 15
		signal 16
		cycleSpeed 7
	)
)

(instance river_3 of Prop
	(properties
		name {river#3}
		x 94
		y 114
		noun 10
		view 150
		loop 5
		cel 3
		priority 15
		signal 16
		cycleSpeed 10
	)
)

(instance river_4 of Prop
	(properties
		name {river#4}
		x 49
		y 75
		noun 11
		view 150
		loop 6
		cel 2
		priority 15
		signal 16
		cycleSpeed 11
	)
)

