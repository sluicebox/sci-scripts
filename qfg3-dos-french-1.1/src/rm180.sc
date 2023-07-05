;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
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
	rm180 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0)
	(switch local1
		(0
			(gMessager say: 1 6 10) ; "You like. You see. You stay. Be happy monkey."
		)
		(1
			(gMessager say: 1 6 11) ; "Manu teach you. You be monkey man. You be hero of monkeys."
		)
	)
	(++ local1)
	(= local0 0)
)

(instance rm180 of PanoRoom
	(properties
		noun 2
		picture 180
		west 170
	)

	(method (init)
		(SetFlag 63)
		(self setRegions: 50) ; panorama
		(gEgo solvePuzzle: 211 8)
		(switch gPrevRoomNum
			(400
				(gEgo posn: global363 global364)
				(HandsOn 6 3)
			)
			(800
				(gCurRoom setScript: fromLostCity)
			)
			(700
				(gEgo x: global363 y: global364)
				(cond
					((IsFlag 93)
						(SetFlag 88)
						(gEgo view: 154)
						(= local7
							(/ (GetDistance (gEgo x:) (gEgo y:) 162 72) 3)
						)
						(HandsOff)
						(gCurRoom setScript: goVillage)
					)
					((IsFlag 134)
						(ClearFlag 134)
						(HandsOff)
						(SetFlag 88)
						(gEgo view: 154)
						(gCurRoom setScript: leadEgo)
					)
					(else
						(HandsOn 6 3)
					)
				)
			)
			(740
				(gEgo x: 175 y: 112)
				(gEgo view: 154)
				(gCurRoom setScript: afterWater)
			)
			(west
				(= style 12)
				(gCurRoom setScript: fromTreePanorama)
			)
			(else
				(gEgo x: 158 y: 75)
				(gEgo view: 154)
				(gCurRoom setScript: fromMonkeys)
			)
		)
		(wtrfll_1 init: setCycle: Fwd)
		(wtrfll_2 init: setCycle: Fwd)
		(wtrfll_3 init: setCycle: Fwd)
		(wtrfll_4 init: setCycle: Fwd)
		(lostCity init:)
		(upperWaterfall init:)
		(pool init:)
		(mountains init:)
		(lowerCut init:)
		(eastCut init:)
		(lowerWaterfall init:)
		(lowerPool init:)
		(upperWaterfall init:)
		(upperCut init:)
		(if (IsFlag 88)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 157 92 136 142 121 153 113 162 114 168 109 141 111 84 115 77 105 122 99 115 88 162 76 161 71 105 88 0 69 0 0 319 0 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 56 121 80 114 87 126
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 47 103 72 104 73 110 52 114 41 118
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 157 92 136 142 121 153 113 162 114 168 109 141 111 84 115 77 105 142 96 103 89 0 69 0 0 319 0 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 56 121 80 114 87 126
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 47 103 72 104 73 110 52 114 41 118
						yourself:
					)
			)
		)
		(super init: &rest)
		(gLongSong number: 180 setLoop: -1 play:)
	)

	(method (doit)
		(super doit: &rest)
		(if (> (Abs (- gGameTime local5)) 10)
			(= local5 gGameTime)
			(Palette palANIMATE 232 235 -1)
		)
	)

	(method (cue)
		(cond
			((gEgo inRect: 146 69 181 93)
				(self newRoom: 720)
			)
			((gEgo inRect: 246 99 284 118)
				(self newRoom: 800)
			)
			((< (gEgo x:) 5)
				(self setScript: toJungle)
			)
			(else
				(self newRoom: 0)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 41)
	)
)

(instance toJungle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 1 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 170)
			)
		)
	)
)

(instance fromLostCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 251 y: 111 setMotion: PolyPath 239 110 self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fromMonkeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 95)
					(ClearFlag 95)
					(SetFlag 88)
					(HandsOff)
					(gCurRoom setScript: toWaterFall)
				else
					(gEgo x: 164 y: 75 setMotion: PolyPath 138 82 self)
				)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance toWaterFall of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (> gClock 2750) (IsFlag 81) (not local0))
			(= local0 1)
			(gEgo setMotion: 0)
			(= local4 1)
			(gCurRoom setScript: campOutManu 0 state)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: PolyPath 110 98 self
				)
			)
			(2
				(gMessager say: 1 6 1 0 self) ; "Bad place, Lost City. Maybe we go back to monkey village, maybe no?"
			)
			(3
				(gEgo setMotion: PolyPath 77 110 self)
			)
			(4
				(gMessager say: 1 6 2 0 self) ; "You see very bad place, then we go home?"
			)
			(5
				(gEgo setMotion: PolyPath 120 117 self)
			)
			(6
				(gMessager say: 1 6 3 0 self) ; "Monkeys not forget very bad place. You see. Then we go home."
			)
			(7
				(gEgo setMotion: PolyPath 165 112 self)
			)
			(8
				(= local0 1)
				(gMessager say: 1 6 6 0 self) ; "Place of big water. Monkeys remember place to cross. Many bad things on other side. Go home now."
			)
			(9
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance afterWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 88)
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo (+ (gEgo x:) 7) (gEgo y:) self
				)
			)
			(1
				(gMessager say: 1 6 7 0 self) ; "Very bad place. No good. Manu not happy."
			)
			(2
				(gEgo setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self)
			)
			(3
				(= global365 590)
				(SetFlag 143)
				(SetFlag 96)
				(SetFlag 134)
				(gCurRoom newRoom: 700)
			)
		)
	)
)

(instance leadEgo of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (> gClock 2750) (IsFlag 81))
			(= local0 1)
			(gEgo setMotion: 0)
			(= local4 0)
			(gCurRoom setScript: campOutManu 0 state)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 88)
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 193 113 self
				)
			)
			(1
				(gMessager say: 1 6 4 0 self) ; "Long time, men lived in Lost City. Now only bad things. Monkeys remember."
			)
			(2
				(gEgo setMotion: MoveTo 232 108 self)
			)
			(3
				(gMessager say: 1 6 5 0 self) ; "We see bad things, we run away, yes? Go home."
			)
			(4
				(gEgo setMotion: MoveTo 260 112 self)
			)
			(5
				(gMessager say: 1 6 8 0 self) ; "Bad thing. Bad thing. Very bad thing. We go home now. Not go Lost City."
			)
			(6
				(ClearFlag 88)
				(gCurRoom newRoom: 800)
			)
		)
	)
)

(instance campOutManu of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gMessager say: 1 6 14 0 self) ; "Sun not up. Manu go sleep now. Night-night."
			)
			(1
				(PalVary pvCHANGE_TICKS 3)
				(fire x: (+ (gEgo x:) 5) y: (gEgo y:) init: setCycle: Fwd)
				(= cycles 5)
			)
			(2
				(= seconds 9)
			)
			(3
				(PalVary pvREVERSE 5)
				(ClearFlag 81)
				(fire dispose:)
				(= gClock 800)
				(++ gDay)
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(gEgo takeDamage: -16 useMana: -16)
				(= cycles 5)
			)
			(4
				(= seconds 7)
			)
			(5
				(gMessager say: 1 6 13 0 self) ; "Sun up. Manu up. Man-friend go back to monkey village now? Manu very sad. Manu go to bad city with man-friend."
			)
			(6
				(= local0 0)
				(if (> register 0)
					(= temp0 (- register 1))
				else
					(= temp0 0)
				)
				(if local4
					(toWaterFall start: temp0)
					(gCurRoom setScript: toWaterFall)
				else
					(leadEgo start: temp0)
					(gCurRoom setScript: leadEgo)
				)
			)
		)
	)
)

(instance fromTreePanorama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 2 setMotion: PolyPath 10 (gEgo y:) self)
			)
			(1
				(if (IsFlag 88)
					(gEgo view: 154)
					(gCurRoom setScript: manuWalk)
				else
					(HandsOn 6 3)
					(self dispose:)
				)
			)
		)
	)
)

(instance manuWalk of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== (PalVary pvGET_CURRENT_STEP) 20)
			(= local6 state)
			(gCurRoom setScript: campOut 0 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: PolyPath 50 92 self
				)
			)
			(1
				(gMessager say: 1 6 10 0 self) ; "You like. You see. You stay. Be happy monkey."
			)
			(2
				(gEgo setMotion: PolyPath 105 86 self)
			)
			(3
				(gMessager say: 1 6 11 0 self) ; "Manu teach you. You be monkey man. You be hero of monkeys."
			)
			(4
				(gEgo setMotion: PolyPath 160 72 self)
			)
			(5
				(gMessager say: 1 6 12 0 self) ; "See. There village. Big village. Very good, you no think?"
			)
			(6
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance campOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 6 14 0 self) ; "Sun not up. Manu go sleep now. Night-night."
			)
			(1
				(PalVary pvCHANGE_TICKS 2)
				(fire x: (+ (gEgo x:) 5) y: (gEgo y:) init: setCycle: Fwd)
				(= cycles 5)
			)
			(2
				(= seconds 9)
			)
			(3
				(PalVary pvREVERSE 5)
				(ClearFlag 81)
				(fire dispose:)
				(= gClock 800)
				(++ gDay)
				(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
				(gEgo takeDamage: -16 useMana: -16)
				(= cycles 5)
			)
			(4
				(= seconds 7)
			)
			(5
				(gMessager say: 1 6 13 0 self) ; "Sun up. Manu up. Man-friend go back to monkey village now? Manu very sad. Manu go to bad city with man-friend."
			)
			(6
				(if register
					(gCurRoom setScript: goVillage)
				else
					(gCurRoom setScript: manuWalk)
					(manuWalk changeState: local6)
				)
			)
		)
	)
)

(instance goVillage of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(not
						(mod
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								local2
								local3
							)
							local7
						)
					)
					(not local0)
				)
				(= local0 1)
				(localproc_0)
			)
			((== (PalVary pvGET_CURRENT_STEP) 20)
				(gEgo setMotion: 0)
				(gCurRoom setScript: campOut 0 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 72 self)
			)
			(1
				(gMessager say: 1 6 12 0 self) ; "See. There village. Big village. Very good, you no think?"
			)
			(2
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 115
		y 113
		view 986
		loop 4
	)
)

(instance wtrfll_1 of Prop
	(properties
		name {wtrfll#1}
		x 181
		y 95
		view 160
		cel 6
	)

	(method (doVerb theVerb)
		(upperWaterfall doVerb: theVerb)
	)
)

(instance wtrfll_2 of Prop
	(properties
		name {wtrfll#2}
		x 171
		y 110
		view 160
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(upperWaterfall doVerb: theVerb)
	)
)

(instance wtrfll_3 of Prop
	(properties
		name {wtrfll#3}
		x 166
		y 121
		view 160
		loop 2
		cel 2
	)

	(method (doVerb theVerb)
		(lowerWaterfall doVerb: theVerb)
	)
)

(instance wtrfll_4 of Prop
	(properties
		name {wtrfll#4}
		x 163
		y 157
		view 160
		loop 3
		cel 7
	)

	(method (doVerb theVerb)
		(lowerWaterfall doVerb: theVerb)
	)
)

(instance lostCity of Feature
	(properties
		x 259
		y 109
		noun 4
		nsTop 97
		nsLeft 241
		nsBottom 121
		nsRight 278
	)
)

(instance upperWaterfall of Feature
	(properties
		x 184
		y 88
		noun 5
		nsTop 80
		nsLeft 178
		nsBottom 97
		nsRight 190
	)
)

(instance pool of Feature
	(properties
		x 174
		y 98
		noun 7
		nsTop 93
		nsLeft 161
		nsBottom 104
		nsRight 188
	)
)

(instance lowerWaterfall of Feature
	(properties
		x 163
		y 132
		noun 6
		nsTop 104
		nsLeft 159
		nsBottom 160
		nsRight 168
	)
)

(instance lowerPool of Feature
	(properties
		x 147
		y 165
		noun 8
		nsTop 155
		nsLeft 116
		nsBottom 176
		nsRight 179
	)
)

(instance upperRiver of Feature ; UNUSED
	(properties
		x 207
		y 67
		noun 9
		nsTop 59
		nsLeft 180
		nsBottom 76
		nsRight 234
	)
)

(instance mountains of Feature
	(properties
		x 179
		y 8
		noun 10
		nsTop 3
		nsLeft 104
		nsBottom 14
		nsRight 254
	)
)

(instance lowerCut of Feature
	(properties
		x 96
		y 78
		noun 11
		nsTop 71
		nsLeft 37
		nsBottom 85
		nsRight 155
	)
)

(instance upperCut of Feature
	(properties
		x 76
		y 40
		noun 12
		nsTop 36
		nsBottom 44
		nsRight 153
	)
)

(instance eastCut of Feature
	(properties
		x 218
		y 93
		noun 13
		nsTop 86
		nsLeft 189
		nsBottom 100
		nsRight 248
	)
)

