;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use n007)
(use n105)
(use n814)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm10 0
)

(local
	local0
	local1
	[local2 16] = [153 164 153 176 139 181 73 181 73 175 33 175 33 157 135 157]
	local18
	local19
	local20
	local21 = 4
	local22
	local23
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(Platform 0 4 3 -1)
	(= global247 0)
	(= temp1 gClock)
	(switch argc
		(0
			(FixTime 5)
		)
		(1
			(FixTime param1)
		)
		(else
			(FixTime param1 param2)
		)
	)
	(= temp0 (/ (mod (- (+ gClock 3600) temp1) 3600) 150))
	(= [gEgoStats 15] (MaxStamina)) ; stamina
	(if (== gCurRoomNum 10)
		(= [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 16] (MaxMana)) ; mana
	else
		(TakeDamage (- (* temp0 2)))
		(UseMana (- (* temp0 2)))
	)
	(if (> temp1 gClock)
		(NextDay)
	)
	(if (not (OneOf gCurRoomNum 300 302 310 320 330))
		(Print addText: 1 0 0 7 0 0 7 ticks: 5 y: 10 init:) ; "You awake as the sun begins to rise."
	)
	(Platform 0 4 2 -1)
	(Print ticks: -1)
)

(instance rm10 of Rm
	(properties
		noun 6
		picture 10
		style 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 229 189 271 167 297 118 213 104 115 101 115 127 78 127 78 151 26 151 26 186 90 186 90 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 161 125 231 125 256 140 234 146 161 146 120 138
					yourself:
				)
				(rockPoly type: PBarredAccess init: 155 163 154 178 72 178 72 163 yourself:)
		)
		(EgoGait 0 0) ; walking
		(= global425 (| (|= global425 $0002) $0004))
		(Load rsVIEW 10)
		(gLongSong stop: number: 24 loop: -1 play:)
		(super init:)
		(magicStone init: approachVerbs: 4) ; Do
		(fruit init: approachVerbs: 4) ; Do
		(sky init: setOnMeCheck: 1 4)
		(tree init: approachVerbs: 4 setOnMeCheck: 1 2) ; Do
		(meadow init: setOnMeCheck: 1 8)
		(trunk init: setOnMeCheck: 1 16)
		(snow init:)
		(self setScript: sEnterFromSouth)
	)

	(method (cue)
		(switch local1
			(7
				(if gNight
					(gMessager say: 7 1 14) ; "The fruit glows and shimmers in the moonlight. It produces a fragrance like a sun-ripened strawberry."
				else
					(gMessager say: 7 1 13) ; "The fruit sparkles in the sunlight, yet it appears soft and fuzzy."
				)
			)
			(4
				(if gNight
					(gMessager say: 4 1 14) ; "The stars shine."
				else
					(gMessager say: 4 1 13) ; "The sun feels warm."
				)
			)
			(2
				(if (not (IsFlag 141))
					(gMessager say: 2 1 3 1) ; "In a hole, hidden beneath the ancient stone, someone has placed a scroll."
				else
					(gMessager say: 2 1 3 2) ; "You took the scroll."
				)
			)
		)
		(super cue:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(SetFlag 0)
		(super dispose:)
		(= global425 0)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gNight 0)
				(> gClock 1200)
				(< gClock 2550)
				(not (-- local21))
			)
			(= local21 10)
			(if (not (IsFlag 360))
				(Palette palANIMATE 232 237 1)
				(Palette palANIMATE 238 243 -1)
				(Palette palANIMATE 244 250 1)
			)
		)
		(cond
			(script)
			((>= (gEgo y:) 187)
				(gCurRoom setScript: sExitSouth)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; detectMagicSpell
				(gCurRoom setScript: unknown_10_3)
			)
			(52 ; Sleep
				(if (not (CanSleep))
					(gMessager say: 6 52) ; "You just can't sleep during the daytime."
				else
					(SolvePuzzle 615 5 1)
					(gEgo setScript: goToSleep)
				)
			)
			(51 ; openSpell
				(if local19
					(self setScript: unknown_10_1)
				else
					(self setScript: moveStoneAway)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(80 ; calmSpell
				(gCurRoom setScript: unknown_10_2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance unknown_10_1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 6 51 0 1 self) ; "There is no further purpose in casting the Open spell."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance unknown_10_2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 3 80 9 1 self) ; "The very air in this meadow radiates feelings of calmness and peace. You wouldn't be able to tell if the spell worked here."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance unknown_10_3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 3 50 0 1 self) ; "This entire area is magical. In particular, the fruit on the tree radiates magic, and you sense that a spell has been placed on the large stone. All of the magic has a warm, nurturing feel to it."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sky of Feature
	(properties
		x 146
		y 24
		noun 4
		nsLeft 23
		nsBottom 48
		nsRight 269
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(1 ; Look
				(= local1 noun)
				(gMessager say: 4 1 0 0 gCurRoom) ; "The sky is clear."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 194
		y 91
		noun 7
		nsTop 33
		nsLeft 101
		nsBottom 150
		nsRight 287
		approachX 262
		approachY 142
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local1 noun)
				(gMessager say: 7 1 0 0 gCurRoom) ; "The tree's blossoms are soft, green and fragrant."
			)
			(4 ; Do
				(fruit doVerb: 4)
			)
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance meadow of Feature
	(properties
		x 164
		y 126
		noun 3
		nsTop 63
		nsLeft 13
		nsBottom 189
		nsRight 315
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch (Random 1 3)
					(1
						(gMessager say: 3 0 6) ; "The grasses in the meadow are covered over with flowers."
					)
					(2
						(gMessager say: 3 0 8) ; "The meadow is an oasis at the edge of the snowline. The rocky hillside looks very steep and slippery."
					)
					(3
						(gMessager say: 3 0 7) ; "All kinds of colorful and fragrant flowers and grasses cover the meadow."
					)
				)
			)
			(4 ; Do
				(if (>= (gEgo has: 26) 10) ; flowers
					(gMessager say: 3 4 10) ; "You have all the flowers you need."
				else
					(gCurRoom setScript: sPickFlowers)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trunk of Feature
	(properties
		x 195
		y 112
		noun 8
		nsTop 81
		nsLeft 164
		nsBottom 143
		nsRight 227
		approachX 196
		approachY 151
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance snow of Feature
	(properties
		x 159
		y 1
		noun 5
		nsBottom 189
		nsRight 319
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(1 ; Look
				(if
					(or
						(and (> gMouseY 51) (> gMouseX 234))
						(and (> gMouseY 85) (< gMouseX 107))
					)
					(gMessager say: 5 1 16) ; "You are at the snowline. All around you, except for the forest, the rocks and mountains glisten with slippery snow."
				else
					(gMessager say: 5 1 15) ; "To the north, the high, snowy peaks of the Dragon Smoke mountains are clearly visible."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fruit of Prop
	(properties
		x 262
		y 91
		noun 1
		approachX 262
		approachY 142
		view 10
		priority 11
		signal 26640
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (> gFreeMeals 2)
					(if local23
						(gMessager say: 1 4 0 2) ; "The fruit is very soft and juicy. It would be impossible to keep in your pack."
					else
						(gMessager say: 1 4 0 1) ; "Your hunger has been totally satisfied. You don't need another piece of fruit."
						(= local23 1)
					)
				else
					(gCurRoom setScript: sTakeAFruit)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll of Prop
	(properties
		x 131
		y 168
		noun 2
		view 10
		loop 3
		priority 13
		signal 26640
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTakeScroll)
			)
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magicStone of Prop
	(properties
		x 83
		y 175
		noun 2
		approachX 149
		approachY 166
		approachDist 5
		view 10
		loop 2
		priority 12
		signal 26640
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local19
					(= local1 noun)
					(gMessager say: 2 1 1 0 gCurRoom) ; "The stone has been moved."
				else
					(switch (++ local18)
						(1
							(gMessager say: 2 1 2) ; "The large stone appears to be ancient and deliberately placed. Marks carved into the stone almost look like writing."
						)
						(2
							(gMessager say: 2 1 4) ; "The stone has the words "Erana's Peace" carved upon the top. There are some runes carved along the side."
						)
						(3
							(gMessager say: 2 1 4) ; "The stone has the words "Erana's Peace" carved upon the top. There are some runes carved along the side."
						)
						(4
							(gMessager say: 2 1 4) ; "The stone has the words "Erana's Peace" carved upon the top. There are some runes carved along the side."
						)
						(else
							(gMessager say: 2 1 5) ; "It reads: "If thy Will is Magic, so shall I share. Open this Stone and claim what is there.""
						)
					)
				)
			)
			(4 ; Do
				(cond
					((and local19 (not (IsFlag 141)))
						(scroll doVerb: theVerb)
					)
					(local19
						(gMessager say: 2 4 1) ; "The hole that was beneath the stone is empty."
					)
					(else
						(gMessager say: 2 4 2) ; "No amount of physical effort will be able to move this stone."
					)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 3 81 9) ; "You can't imagine hurting anything in this meadow."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance moveStoneAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(CastOpen self self 150 154)
			)
			(2
				(magicStone setCycle: CT 1 1 self)
				(rockPoly dispose:)
			)
			(3
				(if (not (IsFlag 141))
					(scroll init:)
				)
				(Face gEgo scroll)
				(magicStone setCycle: End self)
			)
			(4
				(= local19 1)
				(rockPoly
					type: PBarredAccess
					init: 153 164 153 176 139 181 73 181 73 175 33 175 33 157 135 157
					yourself:
				)
				(HandsOn)
				(magicStone stopUpd:)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: PolyPath (gEgo x:) 245 self)
			)
			(2
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance goToSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gEgo
					view: 10
					setLoop: 4
					setCel: 0
					posn: (- (gEgo x:) 3) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(4
				(if (== gNight 0)
					(FixTime 20)
				)
				(= ticks 12)
			)
			(5
				(gEgo
					setLoop: 5
					setCel: 0
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(6
				(= ticks 180)
			)
			(7
				(Print addText: 6 0 0 1 0 0 10 ticks: 5 y: 10 init:) ; "You sleep comfortably among the fragrant flowers."
				(self cue:)
			)
			(8
				(= seconds 2)
			)
			(9
				(localproc_0 5 0)
				(= ticks 60)
			)
			(10
				(gCurRoom setScript: unknown_10_15)
				(= cycles 1)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo
					setLoop: 4
					setCel: 6
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 1)
					setCycle: Beg self
				)
			)
			(13
				(gEgo posn: (+ (gEgo x:) 3) (- (gEgo y:) 2))
				(NormalEgo)
				(= cycles 1)
			)
			(14
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance unknown_10_15 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PalVary pvUNINIT)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sTakeScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(SetFlag 141)
				(gEgo learn: 22 10) ; calmSpell
				(SolvePuzzle 614 4 1)
				(gEgo view: 510 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(scroll hide:)
				(= ticks 12)
			)
			(3
				(gEgo setCel: 5 setCycle: Beg self)
			)
			(4
				(gMessager say: 6 0 0 3 self) ; "The scroll vanishes even as you read the magical runes upon it. You now have the knowledge to cast a "Calm" spell."
			)
			(5
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rockPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance sPickFlowers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(= local0 (gEgo cycleSpeed:))
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath 193 163 self
				)
			)
			(2
				(= register (Random 0 1))
				(gEgo
					view: 510
					setLoop: register
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(3
				(if (gEgo has: 26) ; flowers
					(gMessager say: 3 4 12 0 self) ; "You take another handful of the lovely, fragrant flowers."
				else
					(gMessager say: 3 4 11 0 self) ; "As you pick a variety of the sweet-smelling flowers, they seem to glow in your hands. You put them safely away."
				)
			)
			(4
				(gEgo get: 26 5 setCycle: Beg self) ; flowers
			)
			(5
				(NormalEgo)
				(if register
					(gEgo cycleSpeed: local0 setHeading: 270 self)
				else
					(gEgo cycleSpeed: local0 setHeading: 90 self)
				)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Platform 0 4 3 -1)
				(= ticks 10)
			)
			(1
				(HandsOff)
				(= ticks 10)
			)
			(2
				(gEgo
					init:
					posn: 160 245
					setLoop: -1
					setMotion: MoveTo 160 183 self
				)
			)
			(3
				(= ticks 12)
			)
			(4
				(if (not (IsFlag 0))
					(gMessager say: 6 0 17) ; "The meadow lies covered with a blanket of flowers, unusual for this early in the spring. It is warm, even though surrounded by the late snows of winter."
				)
				(= cycles 1)
			)
			(5
				(Platform 0 4 3 -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sTakeAFruit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gEgo setMotion: MoveTo 260 150 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo view: 10 setLoop: 6 setCel: 0 setCycle: 0)
				(= ticks 30)
			)
			(5
				(gEgo setCel: 1)
				(= ticks 30)
			)
			(6
				(fruit hide:)
				(gEgo setCel: 0)
				(= ticks 30)
			)
			(7
				(gMessager say: 6 0 0 2 self) ; "The sweet, juicy fruit of the tree is amazingly satisfying and refreshing."
			)
			(8
				(= gFreeMeals 4)
				(ClearFlag 124)
				(ClearFlag 125)
				(NormalEgo 7)
				(HandsOn)
				(fruit approachVerbs: 0)
				(tree approachVerbs: 0)
				(SolvePuzzle 645 2)
				(self dispose:)
			)
		)
	)
)

