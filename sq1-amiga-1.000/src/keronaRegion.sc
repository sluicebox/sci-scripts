;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 704)
(include sci.sh)
(use Main)
(use Interface)
(use RegionPath)
(use PChase)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	keronaRegion 0
	plant 1
	plant2 2
	spider 3
	drinkScript 4
)

(local
	local0
	local1
	local2 = 7
	local3
	local4
	local5
	[local6 141] = [32767 26 350 175 162 155 82 -10 32767 23 82 220 95 169 157 132 248 167 34 95 108 -7 95 183 18 -10 32767 20 18 220 62 167 32767 19 350 167 278 220 32767 22 310 48 350 118 32767 23 -10 118 94 183 97 183 55 182 43 220 32767 26 43 -10 74 90 -10 127 32767 25 350 127 113 160 35 105 23 43 101 -10 32767 22 101 200 2 114 22 -10 32767 19 22 220 32 141 60 80 152 49 350 32 32767 20 -10 32 168 41 135 59 197 75 350 54 32767 21 -10 54 241 75 297 111 280 220 32767 24 280 -10 95 76 141 146 181 220 32767 27 167 -10 161 49 227 141 186 170 -10 175 -32768]
	[local147 24] = [-50 300 48 189 102 115 213 65 319 57 700 20 700 180 319 163 298 173 258 178 257 189 350 300]
	[local171 22] = [-450 3 0 53 163 88 800 40 800 140 319 99 319 181 208 175 149 153 0 158 -450 180]
	[local193 24] = [-250 50 0 103 127 96 217 118 295 140 287 172 169 175 134 189 62 189 41 176 0 181 -250 200]
	[local217 8] = [319 189 297 189 277 165 319 146]
	[local225 28] = [120 189 84 170 64 130 21 127 0 103 14 72 62 60 62 26 47 0 167 0 312 108 318 140 270 162 285 189]
	[local253 8] = [0 189 0 159 34 167 16 189]
	[local261 18] = [60 300 85 189 106 166 269 165 216 147 203 120 319 64 500 40 500 300]
	[local279 18] = [319 129 144 138 124 109 209 109 190 99 120 102 104 81 199 61 319 54]
	[local297 12] = [-250 300 -250 10 0 38 64 73 155 189 250 300]
	[local309 12] = [268 0 279 11 258 32 165 32 129 8 129 0]
	[local321 18] = [262 144 143 144 54 99 18 63 18 36 278 36 317 75 317 113 262 113]
	[local339 36] = [60 -80 400 -80 400 85 319 61 281 65 267 86 319 126 319 157 294 173 259 164 238 146 241 131 170 99 170 69 202 55 223 23 127 20 82 0]
	[local375 16] = [100 -80 123 0 219 146 115 165 34 135 0 53 -100 90 -100 -80]
	[local391 14] = [263 35 316 88 285 119 224 119 177 72 177 69 177 35]
)

(procedure (localproc_0 param1)
	(= local3
		(cond
			((OneOf param1 18 37 38 138 238 338) 401)
			((OneOf param1 19 20 21 22 23 24 25 26 27) 448)
			((OneOf param1 28)
				(if (IsFlag 59) 420 else 415)
			)
		)
	)
)

(procedure (localproc_1)
	(global112 release:)
	(switch gCurRoomNum
		(19
			(spiderPolyA points: @local147 size: 12)
			(global112 add: spiderPolyA)
		)
		(20
			(spiderPolyA points: @local171 size: 11)
			(global112 add: spiderPolyA)
		)
		(21
			(spiderPolyA points: @local193 size: 12)
			(global112 add: spiderPolyA)
		)
		(22
			(spiderPolyA points: @local217 size: 4)
			(spiderPolyB points: @local225 size: 14)
			(global112 add: spiderPolyA spiderPolyB)
		)
		(23
			(spiderPolyA points: @local253 size: 4)
			(spiderPolyB points: @local261 size: 9)
			(global112 add: spiderPolyA spiderPolyB)
		)
		(24
			(spiderPolyA points: @local279 size: 9)
			(spiderPolyB points: @local297 size: 6)
			(global112 add: spiderPolyA spiderPolyB)
		)
		(25
			(spiderPolyA points: @local309 size: 6)
			(spiderPolyB points: @local321 size: 9)
			(global112 add: spiderPolyA spiderPolyB)
		)
		(26
			(spiderPolyA points: @local339 size: 18)
			(global112 add: spiderPolyA)
		)
		(27
			(spiderPolyA points: @local375 size: 8)
			(spiderPolyB points: @local391 size: 7)
			(global112 add: spiderPolyA spiderPolyB)
		)
	)
)

(instance spiderPolyA of Polygon
	(properties
		type PBarredAccess
	)
)

(instance spiderPolyB of Polygon
	(properties
		type PBarredAccess
	)
)

(instance keronaRegion of Rgn
	(properties)

	(method (init &tmp [temp0 3])
		(if (or (not (IsFlag 55)) (== global166 1) (!= gPrevRoomNum global181))
			(= global181 0)
		else
			(LoadMany rsSOUND 411 361)
			(= global181 gCurRoomNum)
		)
		(cond
			((not (<= 19 gCurRoomNum 27)) 0)
			(global181
				(localproc_1)
				(spider
					posn:
						(switch (gEgo edgeHit:)
							(EDGE_LEFT
								(+ global179 319)
							)
							(EDGE_RIGHT
								(- global179 319)
							)
							(else global163)
						)
						(switch (gEgo edgeHit:)
							(EDGE_BOTTOM
								(- global180 190)
							)
							(EDGE_TOP
								(+ global180 190)
							)
							(else global180)
						)
					init:
					show:
					moveSpeed: (+ gHowFast 2)
					cycleSpeed: (+ gHowFast 2)
					z: 0
					view: 422
					setCycle: Walk
					setLoop: -1
					setLoop: spiderGroop
					setMotion: PChase gEgo 24 spider global112
				)
			)
			((IsFlag 55)
				(spider
					view: 422
					setLoop: -1
					moveSpeed: (+ gHowFast 2)
					cycleSpeed: (+ gHowFast 2)
					setLoop: spiderGroop
					setCycle: Walk
					regionPathID: spiderRegionPather
					setMotion: spiderRegionPather
					init:
				)
			)
		)
		(if (not (gEgo has: 16)) ; Plant
			(Load rsVIEW 13)
		)
		(LoadMany rsVIEW 15 16)
		(if (or global181 global178 (IsFlag 55))
			(LoadMany rsVIEW 422 328 56)
			(LoadMany rsSOUND 403 404)
			(Load rsSCRIPT 930)
		)
		(super init: &rest)
		(mountains init:)
		(keronaSky init:)
		(moon init:)
		(farSand init:)
		(nearSand init:)
		(dune init:)
		(bones init:)
		(base init:)
		(plant init:)
		(if (== gCurRoomNum 22)
			(plant2 init:)
		)
		(if
			(and
				(!= (gLongSong number:) (localproc_0 gCurRoomNum))
				(not global181)
			)
			(gLongSong
				number: (if (spider inThisRoom:) 404 else local3)
				loop: -1
				play:
			)
		)
	)

	(method (doit)
		(if
			(and
				(== (gLongSong number:) local3)
				(or global181 (and (IsFlag 55) (spider inThisRoom:)))
			)
			(gLongSong number: 404 loop: -1 play:)
		)
		(if (and (== (gLongSong prevSignal:) -1) (== (gLongSong number:) 404))
			(gLongSong number: local3 loop: -1 play:)
		)
		(cond
			((gCurRoom script:) 0)
			(
				(and
					global181
					(not local4)
					(!= gCurRoomNum 27)
					(OneOf (gEgo loop:) 5 4)
					(& (gEgo onControl: 1) $0002)
				)
				(= local4 1)
				(gCurRoom setScript: egoFallDown 0 (== (gEgo loop:) 5))
			)
			(global178
				(if (and (<= 19 gCurRoomNum 27) (not (-- global178)))
					(if
						(or
							(== global166 1)
							(< (gEgo y:) 90)
							(and (OneOf 21 32) (< (gEgo x:) 160))
							(> (gEgo x:) 180)
						)
						(gCurRoom setScript: spiderFalls)
					else
						(= global178 40)
					)
				)
			)
			(global183
				(if (not (-- global183))
					(if
						(and
							(gEgo inRect: 40 30 180 190)
							(not (gCurRoom script:))
						)
						(gCurRoom setScript: egoDiesOfThirst)
					else
						(= global183 50)
					)
				else
					(switch global183
						(1200
							(Print 704 0) ; "A nice slug of water would sure hit the spot right about now."
						)
						(500
							(Print 704 1) ; "The heat of this place can sure dehydrate a person. You'd better get something to drink pretty darn soon."
						)
					)
				)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(global112 release:)
		(= keep (OneOf newRoomNumber 37 18 19 20 21 22 23 24 25 26 27))
		(= initialized 0)
		(if
			(and
				(not global181)
				(IsObject (spider regionPathID:))
				(!= ((spider regionPathID:) currentRoom:) newRoomNumber)
				(== (gLongSong number:) 404)
			)
			(gLongSong fade:)
		)
		(= local4 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(global112 dispose:)
		(super dispose: &rest)
	)
)

(instance mountains of Feature
	(properties
		description {mountains}
		onMeCheck 128
		lookStr {Mountains generously dappled with spires of unknown formational origin loom at your visual terminus.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance keronaSky of Feature
	(properties
		description {sky}
		onMeCheck 32
		lookStr {The lovely crisp green of the Keronian atmosphere reminds you that you'll need to do some laundry when (or if) you get back home.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance moon of Feature
	(properties
		description {big moon}
		onMeCheck 64
		lookStr {Loitering about the horizon is the second and closest moon of Kerona. It is much less hospitable than the sphere you presently roam.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance farSand of Feature
	(properties
		description {distant desert}
		onMeCheck 256
		lookStr {Spread before you is a seemingly endless expanse of sand.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance nearSand of Feature
	(properties
		description {sand}
		onMeCheck 512
		lookStr {The sand of Kerona has a reddish-orange color. Were you a geologist instead of a janitor, you might find this fact interesting.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance dune of Feature
	(properties
		description {small dune}
		onMeCheck 2
		lookStr {Nomads of the desert, dunes are spread about in nearly every direction.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance bones of Feature
	(properties
		description {bones}
		onMeCheck 16
		lookStr {A wide selection of skeletal accessories awaits your perusal. Vertebrae, ribs, and who knows what else rest upon the Keronian soil. The average height of this structure looks to be at least 7 meters. Good thing you didn't meet this thing in its heyday.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 704 2) ; "The bones, though utterly dehydrated, still bear too much mass for the puny likes of you to displace."
			)
			(11 ; Taste
				(Print 704 3) ; "While it might make one heck of a great soup bone, it bears no other appeal to your palate."
			)
			(5 ; Talk
				(Print 704 4) ; "Your words hitch a ride on the Keronian breeze never to be heard again."
			)
			(12 ; Smell
				(Print 704 5) ; "These bones have had the smell baked right out of them by centuries of relentless, Keronian sun. Any soft tissue was long ago ingested by the local parasites."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance base of Feature
	(properties
		description {sandy base}
		onMeCheck 8
		lookStr {Upon a very narrow width of Keronian soil, able to resist erosion through the eons, rests the skeletal remains of this mammoth has-been.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance plant of Feature
	(properties
		description {plant}
		onMeCheck 4
		lookStr {Oddly enough, a plant grows in isolated spots in this inhospitable environment.}
	)

	(method (init)
		(if (== global166 2)
			(self approachVerbs: 3) ; Do
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(cond
					((gEgo has: 16) ; Plant
						(Print 704 6) ; "You already have your allocation of adhesive herbs."
					)
					((or (== (gCurRoom script:) bigBang) (== global166 1))
						(super doVerb: theVerb &rest)
					)
					(else
						(gCurRoom setScript: pickPlant)
					)
				)
			)
			(12 ; Smell
				(Print 704 7) ; "You take a whiff of the plant and find it to be a regrettable experience. However, it does have an aroma reminiscent of a smell-a-vision movie production of 'Our Friend The Polymoss Shrub - Nature's Bondo'. You vaguely remember something about it having odd adhesive properties"
			)
			(11 ; Taste
				(Print 704 8) ; "Do that and you'll never utter another stupid syllable in your life. On second thought..."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant2 of Feature
	(properties
		description {plant}
		onMeCheck 16384
		lookStr {Oddly enough, a rather bright plant grows in this otherwise flora-free area.}
	)

	(method (init)
		(if (== global166 2)
			(self approachVerbs: 3) ; Do
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(cond
					((gEgo has: 16) ; Plant
						(Print 704 6) ; "You already have your allocation of adhesive herbs."
					)
					((or (== (gCurRoom script:) bigBang) (== global166 1))
						(super doVerb: theVerb &rest)
					)
					(else
						(gCurRoom setScript: pickPlant)
					)
				)
			)
			(12 ; Smell
				(Print 704 9) ; "You take a whiff of the plant and find it to be a regrettable experience. However, it does have an aroma reminiscent of a smell-a-vision movie production of 'Our Friend The Polymoss Shrub - Nature's Bondo'. You vaguely remember something about its having some incredible adhesive properties as well."
			)
			(11 ; Taste
				(Print 704 8) ; "Do that and you'll never utter another stupid syllable in your life. On second thought..."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pickPlant of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 1)
				(OneOf (gEgo cel:) 4 10)
				(!= local5 (gEgo cel:))
			)
			(if (== (gSoundEffects number:) 456)
				(gSoundEffects number: 457 loop: 1 play:)
			else
				(gSoundEffects number: 456 loop: 1 play:)
			)
		)
		(= local5 (gEgo cel:))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 13
					cel: 0
					loop: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(1
				(Print 704 10) ; "You snag a small cluster of leaves from the gooey plant."
				(gEgo loop: 1 cel: 0 cycleSpeed: 25 setCycle: End self)
			)
			(2
				(gEgo loop: 3 cel: 0 cycleSpeed: 15 setCycle: End self)
			)
			(3
				(if (== (gCurRoom script:) self)
					(NormalEgo 0 1 61)
					(gEgo loop: 0)
					(SetScore 2 142)
					(gEgo get: 16) ; Plant
					(Print 704 11) ; "That stuff sticks worse than fortnight-old undergarments. It's a good thing your gloves are tefloid-coated."
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoFallDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 56
					setLoop: register
					cel: 0
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(1
				(gSoundEffects number: 403 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(= cycles 14)
			)
			(3
				(gEgo
					x:
						(if register
							(- (gEgo x:) 33)
						else
							(+ (gEgo x:) 33)
						)
					y: (+ (gEgo y:) 11)
					setLoop: (+ register 2)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(if (== (gCurRoom script:) self)
					(NormalEgo 0 1 61)
					(gEgo loop: (if register 5 else 4))
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoDiesOfThirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: 0
					setHeading:
						(if (< 0 (gEgo heading:) 181) 90 else 270)
						self
				)
			)
			(1
				(Print 704 12) ; "Holy antiperspirant, dehydroman! The searing heat and dryness of this environment sucks the vital fluids from your body. Your mind begins to drift uncontrollably."
				(Print 704 13) ; "Mommy! Is that you? Mommy, how come all the other guys in class get new mops and I don't?"
				(Print 704 14) ; "Mercifully (for all of us), you die before the hallucinations get too hokey. It won't be long before you look like a scaled-down version of the skeletal structure occupying several hectares nearby."
				(= cycles 12)
			)
			(2
				(gEgo view: 15 cel: 0 cycleSpeed: 15 setCycle: End self)
			)
			(3
				(= cycles 12)
			)
			(4
				(EgoDead 948 0 0 704 15) ; "Within a few hours, your gaunt corpse will have dried to a crisp, your powdered remains evenly distributed across the parched terrain by a searing gust."
			)
		)
	)
)

(instance drinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global183 8000)
				(gEgo
					setMotion: 0
					setHeading:
						(if (< 0 (gEgo heading:) 181) 90 else 270)
						self
				)
			)
			(1
				(gEgo view: 16 cel: 0 cycleSpeed: 15 setCycle: End self)
			)
			(2
				(gEgo
					setLoop: (+ (gEgo loop:) 2)
					cel: 0
					setCycle: Osc 1 self
				)
			)
			(3
				(Print 704 16) ; "Mmmmm...That dehydrated water really hit the spot! That should keep you going a bit longer."
				(gEgo
					setLoop: (- (gEgo loop:) 2)
					cel: 9
					setCycle: Beg self
				)
			)
			(4
				(if (== (gCurRoom script:) self)
					(= register (gEgo loop:))
					(NormalEgo 0 1 61)
					(gEgo loop: register)
					(if (== global166 1)
						(gEgo setPri: 14)
					)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance spiderFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Print 704 17) ; "Out of the corner of your eye, you spot an object hurtling from the greenish atmosphere toward the parched surface you currently occupy."
				(spiderSound number: 470 loop: 1 play:)
				(switch gCurRoomNum
					(19
						(= local0 -20)
					)
					(20
						(= local1 40)
						(= local2 13)
					)
					(21
						(= local0 200)
						(= local1 -40)
						(= local2 5)
					)
					(22
						(= local1 20)
						(= local2 11)
					)
					(24
						(= local0 200)
						(= local1 30)
						(= local2 12)
					)
					(27
						(= local0 -20)
					)
				)
				(= seconds 2)
			)
			(1
				(spider init: hide:)
				(shadow
					posn: (+ local0 2) (+ local1 63)
					init:
					setPri: local2
					setMotion: MoveTo (+ 32 local0) (+ local1 80) self
				)
				(gEgo setMotion: 0)
				(Face gEgo shadow)
			)
			(2
				(spider setPri: local2 posn: (+ local0 41) (+ local1 62) show:)
				(shadow posn: (+ local0 41) (+ local1 118))
				(= cycles (+ 3 gHowFast))
			)
			(3
				(spider posn: (+ local0 66) (+ local1 114))
				(shadow cel: 1 posn: (+ local0 66) (+ local1 131))
				(= cycles (+ 3 gHowFast))
			)
			(4
				(spider hide:)
				(spiderSound number: 471 loop: 1 play:)
				(gEgo setMotion: 0)
				(Face gEgo shadow)
				(shadow cel: 2 cycleSpeed: 26 setCycle: End self)
			)
			(5
				(shadow dispose:)
				(spider
					posn: (+ local0 66) (+ local1 131)
					show:
					setLoop: 1
					cel: 0
					cycleSpeed: 26
					setCycle: End self
				)
				(SetFlag 55)
			)
			(6
				(Print 704 18) ; "Rats! If the eyes don't deceive, that's a Sarien Spider Droid. They must have detected the escape pod leaving the Arcada. The Spider Droid must have been sent along to settle any unfinished business."
				(Print 704 19) ; "After the jarring impact, small panels open through which legs sprout. You recall reading in an old issue of Space Piston magazine that this droid was designed to seek out organic life forms and self-destruct when close proximity to the target has been achieved."
				(spider
					view: 422
					setLoop: -1
					setLoop: spiderGroop
					loop: 2
					heading: 180
					cycleSpeed: (+ gHowFast 2)
					moveSpeed: (+ gHowFast 2)
					setPri: -1
					setCycle: Walk
				)
				(localproc_1)
				(if (== global166 2)
					(spider z: 0 setMotion: PChase gEgo 24 spider global112)
					(= global181 gCurRoomNum)
					(++ state)
					(self cue:)
				else
					(spider
						setMotion: PolyPath (spider x:) 240 self 1 global112
					)
					(= global181 0)
				)
			)
			(7
				(spider
					regionPathID: spiderRegionPather
					setMotion: spiderRegionPather
				)
				(= cycles 1)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bigBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong fade:)
				(gSoundEffects number: 411 loop: 1 play:)
				(spider
					view: 328
					setLoop: 0
					cel: 0
					setMotion: 0
					cycleSpeed: 16
					setCycle: CT 2 1 self
				)
				(if (== gCurRoomNum 27)
					(spider setPri: 14)
				)
			)
			(1
				(gEgo dispose:)
				(spider
					posn:
						(= global163 (gEgo x:))
						(= global164 (+ (gEgo y:) 1))
					setCycle: End self
				)
			)
			(2
				(= seconds 4)
			)
			(3
				(spider
					setPri: (spider priority:)
					view: 423
					posn: global163 -6
					setLoop: 6
					setStep: 1 10
					cycleSpeed: 7
					moveSpeed: 3
					setCycle: Fwd
					setMotion: MoveTo global163 (- global164 7) self
				)
			)
			(4
				(gSoundEffects number: 361 loop: 1 play:)
				(spider
					cycleSpeed: 5
					setCycle: Rev
					setStep: 1 3
					setMotion: MoveTo global163 (- global164 20) self
				)
			)
			(5
				(spider setMotion: MoveTo global163 (- global164 7) self)
			)
			(6
				(gSoundEffects number: 361 loop: 1 play:)
				(spider
					cycleSpeed: 14
					setCycle: Fwd
					setStep: 1 2
					setMotion: MoveTo global163 (- global164 15) self
				)
			)
			(7
				(spider setMotion: MoveTo global163 (- global164 7) self)
			)
			(8
				(gSoundEffects number: 361 loop: 1 play:)
				(spider cycleSpeed: 20 setCycle: CT 3 -1 self)
			)
			(9
				(= ticks 30)
			)
			(10
				(EgoDead 948 0 0 704 20) ; "How convenient! You've been blown into handy, bite-sized chunks. I guess that Space Piston article wasn't fiction. There's nothing quite like stretching out and enjoying the wide-open spaces."
			)
		)
	)
)

(class spiderRP of Actor
	(properties
		cycleSpeed 3
		moveSpeed 3
		regionPathID 0
	)

	(method (pushToNextRoom)
		(if regionPathID
			(while
				(and
					(!= (regionPathID at: (+ (regionPathID value:) 1)) 32767)
					(not (regionPathID atEnd:))
				)
				(regionPathID next:)
			)
			(regionPathID moveDone:)
		)
	)

	(method (inThisRoom)
		(if (IsObject regionPathID)
			(return (== gCurRoomNum (regionPathID currentRoom:)))
		else
			(return (gCast contains: self))
		)
	)
)

(instance spider of spiderRP
	(properties
		description {spider droid}
		lookStr {The spider is quite relentless in its pursuit of organic beings. Your quandry is that, to the best of your knowledge, you are the only one in the area fitting that description.}
		view 423
		cel 5
		signal 30720
		illegalBits 0
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((and (== global166 1) global181)
				(self setScript: moveToPath)
			)
			((and (not global181) (self inThisRoom:) (== global166 2))
				(= global181 gCurRoomNum)
				(localproc_1)
				(self z: 0 setMotion: PChase gEgo 24 spider global112)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(if (and global181 (<= (self distanceTo: gEgo) 25))
			(gCurRoom setScript: bigBang)
		else
			(super cue: &rest)
		)
	)

	(method (dispose)
		(= global179 x)
		(= global180 y)
		(super dispose: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 704 21) ; "Get closer."
			)
			(5 ; Talk
				(Print 704 22) ; "You greet the droid with a pleasant "Hello.""
				(Print 704 23) ; ""Say, I've got this annoying itch on the back of my sphere. Do you think you could scratch it for me? I'd be forever grateful." it responds."
			)
			(11 ; Taste
				(Print 704 24) ; "If you've got a taste for chrome, step on up and give it a try."
			)
			(12 ; Smell
				(Print 704 25) ; "You're not close enough to give it a good whiff if that's what you'd really like to do."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 704 26) ; "He seems unlikely to be willing to accept a bribe."
					)
					(0 ; Cartridge
						(Print 704 27) ; "If you let him eat the data cartridge, this is going to be a real short game."
					)
					(15 ; Widget
						(Print 704 28) ; "The good news is: the widget, being magnetic, will stick to the Spider Droid like ugly on an ape. The bad news is: The Spider Droid will have your widget and you won't."
					)
					(2 ; Gadget
						(Print 704 29) ; "Your attempts to translate the Spider Droid's clacking and whirring prove futile."
					)
					(3 ; Survival_Kit
						(Print 704 30) ; "Dropping your survival kit on the Spider Droid might prove hazardous to your survival."
					)
					(5 ; Dehydrated_Water
						(Print 704 31) ; "What a great idea! You could get him wet, then wait around for the next fifty years for him to rust out. On second thought, you decide to skip it."
					)
					(4 ; Knife
						(Print 704 32) ; "You couldn't even make a scratch on this guy."
					)
					(16 ; Plant
						(Print 704 33) ; "You attemp to drop the piece of plant down onto the Spider Droid, but it sticks to your fingers. Better try something else."
					)
					(8 ; Orat_Part
						(Print 704 34) ; "You find yourself reluctant to part with this dainty souvenir of the plant Kerona."
					)
					(else
						(Print 704 35) ; "If it could survive atmospheric entry and the jarring landing, you surely can't upset it."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance spiderGroop of Grooper
	(properties)
)

(instance spiderRegionPather of RegionPath
	(properties
		theRegion 704
	)

	(method (at param1)
		(return [local6 param1])
	)

	(method (nextRoom)
		(super nextRoom: &rest)
		(cond
			((== currentRoom gCurRoomNum)
				(gLongSong number: 404 loop: -1 play:)
			)
			((== (gLongSong number:) 404)
				(gLongSong fade:)
			)
		)
	)
)

(instance moveToPath of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= global181 0)
				(spider setMotion: PolyPath -10 180 self 1 global112)
			)
			(1
				(spider regionPathID: local6 setMotion: spiderRegionPather)
				(self dispose:)
			)
		)
	)
)

(instance shadow of Actor
	(properties
		yStep 6
		view 423
		signal 30720
		cycleSpeed 7
		xStep 6
		moveSpeed 7
	)
)

(instance spiderSound of Sound
	(properties)
)

