;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use panorama)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm160 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(switch gHeroType
		(0 ; Fighter
			(switch (++ local1)
				(1
					(return 20)
				)
				(2
					(return 17)
				)
				(3
					(return 18)
				)
				(4
					(return 19)
				)
				(else
					(return 16)
				)
			)
		)
		(1 ; Magic User
			(switch (++ local1)
				(1
					(return 11)
				)
				(2
					(return 12)
				)
				(3
					(return 13)
				)
				(4
					(return 14)
				)
				(else
					(return 15)
				)
			)
		)
		(2 ; Thief
			(switch (++ local1)
				(1
					(return 6)
				)
				(2
					(return 7)
				)
				(3
					(return 8)
				)
				(4
					(return 9)
				)
				(else
					(return 10)
				)
			)
		)
		(else
			(switch (++ local1)
				(1
					(return 1)
				)
				(2
					(return 2)
				)
				(3
					(return 3)
				)
				(4
					(return 4)
				)
				(else
					(return 5)
				)
			)
		)
	)
)

(instance rm160 of PanoRoom
	(properties
		noun 9
		picture 160
		east 170
		west 150
	)

	(method (init)
		(self
			setRegions: 50 ; panorama
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 122 89 124 99 64 99 64 89
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 177 91 185 105 179 117 153 117 168 101 150 100 141 91
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 176 177 319 156 319 189 0 189 0 159 54 159
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 251 80 251 87 213 87 205 80
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 42 262 42 173 39 152 46 112 52 0 53 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 171 72 171 76 148 76 148 72
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 102 127 142 121 148 130 125 139
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 109 149 124 145 142 151 159 143 190 143 189 154 159 166 124 162
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 194 101 185 93 198 81 214 90 214 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 214 140 238 140 238 145 214 145
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 220 95 223 91 239 89 248 90 251 94 231 100
					yourself:
				)
			setScript:
				(switch gPrevRoomNum
					(400
						(gEgo posn: global363 global364)
						0
					)
					(700
						(gEgo posn: global363 global364)
						0
					)
					(410 fromSimbani)
					(east
						(= style 11)
						fromTreePanorama
					)
					(west
						(= style 12)
						fromTarnaPanorama
					)
					(else fromSprings)
				)
		)
		(poolOfPeace init:)
		(simbaniVillage init:)
		(bluffs init:)
		(highHill init:)
		(leapFrogRocks init:)
		(miscRocks init:)
		(gEgo solvePuzzle: 209 3)
		(if (and (IsFlag 99) (== global468 gCurRoomNum))
			(honeyTree x: global422 y: global423 init: stopUpd:)
		)
		(HandsOn 6 3)
		(super init: &rest)
		(if (not (IsFlag 88))
			(gEgo code: whereIsHe)
			(if (!= (gLongSong number:) 160)
				(gLongSong number: 160 setLoop: -1 play:)
			)
		)
	)

	(method (cue)
		(cond
			((gEgo inRect: 208 82 250 97)
				(if (IsFlag 43)
					(self setScript: tellScript)
				else
					(gCurRoom newRoom: 410)
				)
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
			((gEgo inRect: 128 153 162 174)
				(gCurRoom newRoom: 390)
			)
			((> (gEgo x:) 315)
				(gCurRoom setScript: toJungle)
			)
			((< (gEgo x:) 5)
				(gCurRoom setScript: toTarna)
			)
			(else
				(gCurRoom newRoom: 0)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 35)
	)
)

(instance tellScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 3 6 21 0 self) ; "You are no longer welcome in the Simbani village."
			)
			(1
				(HandsOff)
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance toTarna of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 1 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance toJungle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 319 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 170)
			)
		)
	)
)

(instance fromSimbani of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 233 87 setMotion: PolyPath 214 95 self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fromSprings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 140 165 setMotion: PolyPath 152 170 self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fromTreePanorama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 318 setMotion: PolyPath 314 (gEgo y:) self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fromTarnaPanorama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 88)
					(gEgo view: 153)
				)
				(gEgo x: 2 setMotion: PolyPath 6 (gEgo y:) self)
			)
			(1
				(if (IsFlag 88)
					(fire init: hide:)
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
				(HandsOff)
				(ClearFlag 6)
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: PolyPath 29 100 self
				)
			)
			(1
				(gMessager say: 1 6 (localproc_0) 0 self)
			)
			(2
				(ClearFlag 6)
				(PalVary pvINIT gCurRoomNum 3)
				(gEgo setMotion: PolyPath 30 103 self)
			)
			(3
				(self setScript: campOut self)
			)
			(4
				(gEgo setMotion: PolyPath 75 107 self)
			)
			(5
				(gMessager say: 1 6 (localproc_0) 0 self)
			)
			(6
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 107 133 self)
			)
			(7
				(gEgo setMotion: PolyPath 110 136 self)
			)
			(8
				(gEgo setMotion: PolyPath 140 130 self)
			)
			(9
				(gMessager say: 1 6 (localproc_0) 0 self)
			)
			(10
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 165 133 self)
			)
			(11
				(gMessager say: 1 6 (localproc_0) 0 self)
			)
			(12
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 207 101 self)
			)
			(13
				(gMessager say: 1 6 (localproc_0) 0 self)
			)
			(14
				(ClearFlag 6)
				(gEgo setMotion: PolyPath 217 94 self)
			)
			(15
				(SetFlag 85)
				(ClearFlag 88)
				(SetFlag 6)
				(= gClock 2600)
				(= gDay 3)
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance campOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 6 22 0 self) ; "It is getting dark, and this looks like a good place to camp for the night."
			)
			(1
				(ClearFlag 6)
				(fire x: (+ (gEgo x:) 5) y: (gEgo y:) show: setCycle: Fwd)
				(= cycles 5)
			)
			(2
				(= seconds 9)
			)
			(3
				(PalVary pvREVERSE 5)
				(fire dispose:)
				(++ gDay)
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(gEgo takeDamage: -16 useMana: -16)
				(= cycles 5)
			)
			(4
				(= seconds 7)
			)
			(5
				(gMessager say: 1 6 23 0 self) ; "Good morning, my friend. Let's continue our journey to the Simbani village."
			)
			(6
				(ClearFlag 6)
				(self dispose:)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 115
		y 113
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

(instance poolOfPeace of Feature
	(properties
		x 142
		y 158
		noun 2
		nsTop 152
		nsLeft 121
		nsBottom 164
		nsRight 163
		sightAngle 180
	)
)

(instance simbaniVillage of Feature
	(properties
		x 228
		y 83
		noun 4
		nsTop 79
		nsLeft 208
		nsBottom 87
		nsRight 248
		sightAngle 180
	)
)

(instance bluffs of Feature
	(properties
		x 219
		y 91
		noun 5
		nsTop 82
		nsLeft 190
		nsBottom 100
		nsRight 249
		sightAngle 180
	)
)

(instance highHill of Feature
	(properties
		x 162
		y 90
		noun 6
		nsTop 82
		nsLeft 148
		nsBottom 99
		nsRight 176
		sightAngle 180
	)
)

(instance leapFrogRocks of Feature
	(properties
		x 95
		y 93
		noun 7
		nsTop 89
		nsLeft 68
		nsBottom 98
		nsRight 122
		sightAngle 180
	)
)

(instance miscRocks of Feature
	(properties
		x 171
		y 149
		noun 8
		nsTop 144
		nsLeft 156
		nsBottom 155
		nsRight 186
		sightAngle 180
	)
)

(instance whereIsHe of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((gEgo inRect: 123 154 164 164)
				(gEgo setMotion: 0)
				(gCurRoom newRoom: 390)
			)
			((> (gEgo x:) 315)
				(gEgo setMotion: 0)
				(gCurRoom setScript: toJungle)
			)
			((< (gEgo x:) 5)
				(gCurRoom setScript: toTarna)
			)
			((and (not (IsFlag 43)) (gEgo inRect: 208 82 252 92))
				(gEgo setMotion: 0)
				(gCurRoom newRoom: 410)
			)
		)
	)
)

