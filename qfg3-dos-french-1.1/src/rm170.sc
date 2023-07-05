;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
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
	rm170 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(switch local1
		(0
			(gMessager say: 2 6 2) ; "You are one strange man, you know. Why you want peace for my people, but don't even know my people, I don't understand."
		)
		(1
			(gMessager say: 2 6 3) ; "Still, I think I trust you. The people of magic, my people, do not trust outsiders. They will be very mad that I bring you there. My father will be furious."
		)
		(2
			(gMessager say: 2 6 4) ; "You will have to prove yourself before the people of magic will listen to you. A strong show of big magic or the gift of the Drum of Magic will make them listen."
		)
		(3
			(gMessager say: 2 6 5) ; "Still, you are lucky if they do not kill you on sight. They may yet. They will kill that Yesufu fellow for sure. They know he's an enemy."
		)
		(4
			(gMessager say: 2 6 6) ; "If Yesufu had hair and skin like you, my people would not kill him right off. First they laugh very hard when they see him. Then they kill him. Maybe they will kill you, too. I will try to save you."
		)
	)
	(++ local1)
	(= local4 0)
)

(procedure (localproc_1)
	(switch local1
		(0
			(gMessager say: 3 6 8) ; "Man-friend like village. Good village. Just like man's village."
		)
		(1
			(gMessager say: 3 6 9) ; "Hurry, hurry. Man-friend see. Good village."
		)
		(2
			(gMessager say: 3 6 10) ; "Monkey folk live here alla time. Big village."
		)
	)
	(++ local1)
	(= local4 0)
)

(instance rm170 of PanoRoom
	(properties
		noun 1
		picture 170
		east 180
		west 160
	)

	(method (init)
		(HandsOff)
		(gLongSong2 stop:)
		(self
			setRegions: 50 ; panorama
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 139 66 139 114 153 207 156 219 168 290 179 319 158 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 212 67 212 73 196 73 196 67
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 49 278 47 248 42 59 42 0 42 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 124 133 111 142 77 134 75 127 93 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 292 138 292 131 314 132 311 143
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 261 108 289 108 289 121 266 121
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 267 142 281 138 293 141 296 149 267 149
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 203 97 225 97 225 104 203 104
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 261 89 276 89 276 94 261 94
					yourself:
				)
			setScript:
				(switch gPrevRoomNum
					(400
						(HandsOn 6 3)
						(gEgo posn: global363 global364)
						0
					)
					(600
						(SetFlag 94)
						fromLeopards
					)
					(630
						(SetFlag 94)
						fromLeopards
					)
					(700 fromJungle)
					(east
						(= style 11)
						fromLostCityPanorama
					)
					(west
						(= style 12)
						fromSimbaniPanorama
					)
					(else fromTree)
				)
		)
		(bigTree init:)
		(giantAntHill init:)
		(gorge init:)
		(mountains init:)
		(sky init:)
		(gEgo solvePuzzle: 210 3)
		(if (IsFlag 94)
			(leopardVillage init:)
		)
		(super init: &rest)
		(gLongSong number: 170 setLoop: -1 play:)
	)

	(method (cue)
		(cond
			((gEgo inRect: 191 35 214 75)
				(gCurRoom newRoom: 750)
			)
			((gEgo inRect: 246 104 294 131)
				(if (IsFlag 94)
					(if (== gHeroType 2) ; Thief
						(gCurRoom newRoom: 630)
					else
						(gCurRoom newRoom: 600)
					)
				else
					(gCurRoom newRoom: 0)
				)
			)
			((> (gEgo x:) 315)
				(self setScript: toLostCity)
			)
			((< (gEgo x:) 5)
				(self setScript: toSimbani)
			)
			(else
				(gCurRoom newRoom: 0)
			)
		)
	)

	(method (dispose)
		(DisposeScript 41)
		(DisposeScript 36)
		(super dispose:)
	)
)

(instance fromJungle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 global363)
				(= local3 global364)
				(cond
					((IsFlag 93)
						(gEgo view: 154)
						(gEgo x: global363 y: global364)
						(ClearFlag 93)
						(SetFlag 88)
						(if
							(<
								(= local0
									(/
										(GetDistance
											(gEgo x:)
											(gEgo y:)
											319
											(gEgo y:)
										)
										4
									)
								)
								1
							)
							(gMessager say: 3 6 8) ; "Man-friend like village. Good village. Just like man's village."
							(gMessager say: 3 6 9) ; "Hurry, hurry. Man-friend see. Good village."
							(gMessager say: 3 6 10) ; "Monkey folk live here alla time. Big village."
						)
						(gCurRoom setScript: walkManu)
					)
					((IsFlag 92)
						(SetFlag 88)
						(gEgo view: 152)
						(gEgo x: global363 y: global364)
						(if
							(<
								(= local0
									(/
										(GetDistance
											(gEgo x:)
											(gEgo y:)
											260
											115
										)
										6
									)
								)
								1
							)
							(gMessager say: 2 6 2) ; "You are one strange man, you know. Why you want peace for my people, but don't even know my people, I don't understand."
							(gMessager say: 2 6 3) ; "Still, I think I trust you. The people of magic, my people, do not trust outsiders. They will be very mad that I bring you there. My father will be furious."
							(gMessager say: 2 6 4) ; "You will have to prove yourself before the people of magic will listen to you. A strong show of big magic or the gift of the Drum of Magic will make them listen."
							(gMessager say: 2 6 5) ; "Still, you are lucky if they do not kill you on sight. They may yet. They will kill that Yesufu fellow for sure. They know he's an enemy."
							(gMessager say: 2 6 6) ; "If Yesufu had hair and skin like you, my people would not kill him right off. First they laugh very hard when they see him. Then they kill him. Maybe they will kill you, too. I will try to save you."
						)
						(gCurRoom setScript: walkJohari)
					)
					(else
						(HandsOn 6 3)
						(gEgo x: global363 y: global364)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance walkManu of Script
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
							local0
						)
					)
					(not local4)
				)
				(= local4 1)
				(localproc_1)
			)
			((and (> gClock 2750) (IsFlag 81))
				(= local4 1)
				(gEgo setMotion: 0)
				(gCurRoom setScript: campOutManu)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					moveSpeed: 6
					cycleSpeed: 6
					setMotion: PolyPath 319 (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance campOutManu of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 6 14 0 self) ; "Dark. Manu go sleep now. Night-night."
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
				(gMessager say: 3 6 13 0 self) ; "Good sun. Manu happy. Time to go now. Go to monkey village. Man-friend happy."
			)
			(6
				(= local4 0)
				(gCurRoom setScript: walkManu)
			)
		)
	)
)

(instance walkJohari of Script
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
							local0
						)
					)
					(not local4)
				)
				(localproc_0)
				(= local4 0)
			)
			((and (> gClock 2750) (IsFlag 81) (not local4))
				(= local4 1)
				(gEgo setMotion: 0)
				(gCurRoom setScript: campOutJohari)
			)
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
					setMotion: PolyPath 260 115 self
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(gMessager say: 2 6 7 0 self) ; "You need to be very quiet, talk all the time. You do not want my people to see you before I talk about you, or you will be one dead man."
			)
			(4
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance campOutJohari of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 6 14 0 self) ; "You are very strange. You sleep at night like a cow person. Night is the time when the Leopard people are up."
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
				(gMessager say: 2 6 13 0 self) ; "Are you going to sleep all day? We need to go."
			)
			(6
				(= local4 0)
				(gCurRoom setScript: walkJohari)
			)
		)
	)
)

(instance toLostCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 319 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 180)
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
				(gEgo setMotion: PolyPath 1 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance fromSimbaniPanorama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 2
					setMotion:
						MoveTo
						(if (IsFlag 43) 15 else 10)
						(gEgo y:)
						self
				)
			)
			(1
				(if (IsFlag 43)
					(SetFlag 143)
					(= global365 9)
					(gCurRoom newRoom: 700)
				else
					(HandsOn 6 3)
					(self dispose:)
				)
			)
		)
	)
)

(instance fromLostCityPanorama of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 318 setMotion: PolyPath 310 (gEgo y:) self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fromLeopards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 92)
				(gEgo x: 269 y: 132 setMotion: PolyPath 254 142 self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance fromTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 205 y: 76 setMotion: PolyPath 200 82 self)
			)
			(1
				(HandsOn 6 3)
				(self dispose:)
			)
		)
	)
)

(instance leopardVillage of Prop
	(properties
		x 262
		y 129
		noun 10
		view 150
		loop 1
		cel 1
		signal 16384
	)

	(method (init)
		(super init:)
		(SetFlag 94)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setMotion: PolyPath 260 115 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 600)
	)
)

(instance fire of Prop
	(properties
		x 115
		y 113
		view 150
	)
)

(instance bigTree of Feature
	(properties
		x 202
		y 53
		noun 5
		nsTop 35
		nsLeft 184
		nsBottom 72
		nsRight 220
	)
)

(instance giantAntHill of Feature
	(properties
		x 98
		y 132
		noun 6
		nsTop 126
		nsLeft 77
		nsBottom 139
		nsRight 119
		sightAngle 180
	)
)

(instance gorge of Feature
	(properties
		x 159
		y 37
		noun 7
		nsTop 32
		nsBottom 42
		nsRight 319
	)
)

(instance mountains of Feature
	(properties
		x 159
		y 13
		noun 8
		nsTop 6
		nsBottom 20
		nsRight 319
	)
)

(instance sky of Feature
	(properties
		x 159
		y 3
		noun 9
		nsBottom 7
		nsRight 319
	)
)

