;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use Teller)
(use OccasionalCycle)
(use Vendor)
(use bazaarR)
(use GloryTalker)
(use n233)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Chase)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm230 0
	tMoneyChangerTalker 1
	wondering 2
	spBurst 3
	aFruitBasket 4
	aMoneyChanger 5
	aFruitMerchant 6
	aLeatherMerchant 7
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
	local8 = 4103
	local9
	local10 = 2
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	[local20 8] = [0 1 0 2 0 3 2 1]
	[local28 8] = [2 3 0 3 0 1 2 3]
	[local36 15] = [0 -20 -23 -21 -22 -26 -57 -34 999 0 20 23 24 25 999]
	[local51 7] = [0 -2 1 5 -12 -73 999]
	[local58 4] = [0 3 4 999]
	[local62 6] = [0 50 29 -12 -75 999]
	[local68 6] = [0 28 29 12 30 999]
	[local74 5]
	[local79 5]
	[local84 4]
	[local88 4]
	[local92 8] = [0 1 2 3 2 3 0 1]
	[local100 3] = [0 -2 999]
)

(class Spell of Actor
	(properties
		yStep 10
		signal 16384
		scaleSignal 1
		scaleX 96
		scaleY 96
		cycleSpeed 0
		xStep 15
		moveSpeed 0
	)

	(method (init param1 &tmp temp0)
		(super init: &rest)
		(switch param1
			(20
				(= temp0 2)
			)
			(81
				(= temp0 0)
			)
			(83
				(= temp0 4)
			)
		)
		(self setLoop: temp0 setMotion: MoveTo global386 global387 self)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(> y (- (aHarami y:) 50))
				(< y (+ (aHarami y:) 1))
				(> x (- (aHarami x:) 21))
				(< x (+ (aHarami x:) 12))
			)
			(self setMotion: 0)
			(= local10 1)
			(gCurRoom setScript: onHisButt 0 (+ (self loop:) 1))
			(self dispose:)
		)
	)

	(method (cue)
		(if
			(and
				(> global387 (- (aHarami y:) 50))
				(< global387 (+ (aHarami y:) 1))
				(> global386 (- (aHarami x:) 21))
				(< global386 (+ (aHarami x:) 12))
			)
			(= local10 1)
			(gCurRoom setScript: onHisButt 0 (+ (self loop:) 1))
		else
			(self dispose:)
			(if local16
				(sfx number: 930 play:)
				(spBurst
					x: global386
					y: global387
					init:
					setLoop: 9
					setCycle: End spBurst
				)
			)
			(HandsOn)
		)
	)
)

(instance rm230 of Rm
	(properties
		noun 7
		picture 230
		vanishingY -300
	)

	(method (init)
		(gEgo init: normalize: setScale: 0 noun: 2)
		(if (or gNight (IsFlag 135))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 156 0 0 319 0 319 115 302 115 275 126 229 111 178 121 161 103 105 97 82 103
						yourself:
					)
			)
		else
			(gLongSong fade: 40 10 5 0)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 65 108 0 142 0 0 319 0 319 141 279 135 240 116 198 111 182 120 170 114 158 125 72 118
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 100 189 95 176 106 150 157 154 151 163 169 170 184 167 208 181 222 177 251 176 260 189
						yourself:
					)
			)
			(= [local74 0] @local36)
			(= [local79 0] @local51)
			(= [local79 1] @local58)
			(= [local88 0] @local62)
			(= [local84 0] @local68)
			(aFruitBasket init:)
			(aLeatherMerchant
				setPri: 3
				setCycle: OccasionalCycle self 1 30 110
				init:
			)
			(aMoneyChanger setPri: 1 init:)
			(aFruitMerchant init: setCycle: OccasionalCycle self 1 25 81)
			(if (== gDay 5)
				(SetFlag 22)
			)
			(if
				(and
					(not (IsFlag 22))
					(< gDay 5)
					(not gNight)
					(not (IsFlag 135))
				)
				(aHarami init:)
				(LoadMany rsMESSAGE 230)
				(LoadMany rsVIEW 233)
				(aMoneyChanger setCycle: OccasionalCycle self 1 20 150)
			else
				(self setRegions: 51) ; bazaarR
			)
			(leatherA init: addToPic:)
			(leatherB init: addToPic:)
			(fruitA init: addToPic:)
			(bananas init:)
			(fruit init:)
			(hides init:)
			(belts init:)
			(skinrugs init:)
			(zebrarug init:)
			(giraffe init:)
			(leopardskin init:)
			(money_sign init:)
			(hideracks init:)
			(watermelon init:)
			(basket init:)
			(pitcher init:)
			(roundtray init:)
			(peppers init:)
			(rectangletray init:)
			(redplate init:)
			(brassvase init:)
			(shoes init:)
		)
		(super init: &rest)
		(self setScript: from240)
		(if
			(and
				(not (IsFlag 22))
				(< gDay 5)
				(not gNight)
				(not (IsFlag 135))
			)
			(gGame save: 1)
			(HandsOff)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Rest
				(if (IsFlag 22)
					((ScriptID 7 5) init: global455) ; egoRests
				else
					(gMessager say: 0 0 84) ; "You can't sleep now."
				)
			)
			(1 ; Look
				(gMessager say: 7 1 0 (if gNight 0 else 1))
			)
			(20 ; theDaggers
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 66) ; "This is not an ideal place to practice dagger throwing."
				else
					(gEgo drop: 10 1) ; theDaggers
					(= local3 theVerb)
					(= global386 ((gUser curEvent:) x:))
					(= global387 ((gUser curEvent:) y:))
					(gEgo setScript: castFlameDart 0 theVerb)
				)
			)
			(80 ; calmSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(= local3 theVerb)
					(gEgo setScript: calmCast)
				)
			)
			(81 ; flameDartSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(= global386 ((gUser curEvent:) x:))
					(= global387 ((gUser curEvent:) y:))
					(= local3 theVerb)
					(gEgo setScript: castFlameDart 0 theVerb)
				)
			)
			(83 ; forceBoltSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(= global386 ((gUser curEvent:) x:))
					(= global387 ((gUser curEvent:) y:))
					(= local3 theVerb)
					(gEgo setScript: castFlameDart 0 theVerb)
				)
			)
			(86 ; jugglingLightsSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(gEgo setScript: (ScriptID 62 0)) ; castJuggle
				)
			)
			(76 ; detectMagicSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(gEgo setScript: (ScriptID 12) 0 76) ; castAreaScript
				)
			)
			(82 ; fetchSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(gMessager say: 25 6 85) ; "That spell will not help you catch the thief."
				)
			)
			(75 ; openSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(gEgo setScript: (ScriptID 13)) ; castOpenScript
				)
			)
			(77 ; triggerSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(gEgo setScript: (ScriptID 12) 0 77) ; castAreaScript
				)
			)
			(88 ; lightningBallSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				)
			)
			(78 ; dazzleSpell
				(if (or (IsFlag 22) gNight)
					(gMessager say: 25 6 65) ; "This is not a good time to use your spells."
				else
					(gEgo setScript: (ScriptID 12) 0 78) ; castAreaScript
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if local6
			(local6 dispose:)
		)
		(if local7
			(local7 dispose:)
		)
		(if local5
			(local5 dispose:)
		)
		(UnLoad 143 230)
		(UnLoad 128 233)
		(LoadMany 0 47 55 40 231 232 233 234 235)
		(super dispose:)
	)
)

(instance haramiHeadsOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 25 6 80 0 self) ; "You enter the north end of the bazaar and witness a dispute."
			)
			(1
				(SetFlag 159)
				(SetFlag 119)
				(if (!= global209 3)
					(= local18 (gEgo cycleSpeed:))
					(= local19 (gEgo moveSpeed:))
					(gEgo moveSpeed: 6 cycleSpeed: 6)
				)
				(aFruitMerchant setCycle: 0 stopUpd:)
				(aLeatherMerchant setCycle: 0 stopUpd:)
				(aHarami setCycle: Beg self)
			)
			(2
				(aMoneyChanger setLoop: 0 setCycle: Fwd)
				(= cycles 5)
			)
			(3
				(aHarami
					view: 953
					loop: 0
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					origStep: (if (== global209 3) 3076 else 2563)
					setStep: (if (== global209 3) 12 else 10) 3
					setCycle: Walk
					setMotion: PolyPath 55 120 self
				)
				(gLongSong number: 230 setLoop: 1 nextSong: 340 play:)
			)
			(4
				(gMessager say: 1 6 60 0 self) ; "Stop him! Thief! Thief!"
			)
			(5
				(HandsOn)
				(if local9
					(self cue:)
				else
					(aHarami setMotion: PolyPath 170 140 self)
				)
			)
			(6
				(aHarami
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PolyPath 350 160 self
				)
			)
			(7
				(if (== gEgoGait 1) ; running
					(SetFlag 23)
					(= local3 0)
					(gEgo solvePuzzle: 216 8 addHonor: 40)
				else
					(SetFlag 28)
					(gEgo addHonor: -100)
					(SetFlag 19)
				)
				(SetFlag 22)
				(aHarami hide:)
				(aMoneyChanger setCycle: End)
				(ClearFlag 119)
				(= cycles 3)
			)
			(8
				(gCurRoom setScript: wondering)
			)
		)
	)
)

(instance spEffect of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(aHarami setMotion: 0)
				(if local16
					(sfx number: 930 play:)
				)
				(if (!= register 5)
					(= temp0 9)
				else
					(= temp0 10)
				)
				((= local15 (Prop new:))
					view: 21
					loop: temp0
					x: (aHarami x:)
					y: (- (aHarami y:) 30)
					cycleSpeed: 1
					init:
					setPri: 15
					setCycle: End self
				)
			)
			(1
				(local15 dispose:)
				(Palette palSET_INTENSITY 0 255 1000)
				(Palette palSET_INTENSITY 0 255 100)
				(self dispose:)
			)
		)
	)
)

(instance castFlameDart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo aHarami self)
				(if (== register 20)
					(SetFlag 25)
				else
					(SetFlag 26)
				)
			)
			(1
				(= local13 (gEgo loop:))
				(gEgo
					view: (if (!= register 20) 14 else 9)
					loop: [local20 local13]
					cel: 0
					setCycle: CT 2 1 self
				)
				(if (!= register 20)
					(sfx number: 13 play:)
					(= local16 1)
				else
					(sfx number: 916 play:)
				)
			)
			(2
				(gEgo setCycle: End self)
				((= local14 (Spell new:))
					view: (if (!= register 20) 21 else 46)
					x: (+ (gEgo x:) 20)
					y: (- (gEgo y:) 35)
					origStep: 6922
					init: register
					setCycle: Fwd
				)
			)
			(3
				(gEgo normalize: local13 addHonor: -50)
				(= cycles (+ (gEgo cycleSpeed:) 5))
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance knockFruitOver of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (not (IsFlag 80)) (== local9 1) (< 135 (aHarami x:) 223))
			(aHarami setCycle: 0 stopUpd:)
			(SetFlag 80)
			(= local10 2)
			(= local3 0)
			(gEgo solvePuzzle: 218 5 13)
			(gCurRoom setScript: onHisButt)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (= temp0 (- (gEgo moveSpeed:) 1)) 0)
					(= temp0 0)
				)
				(if (< (= temp1 (- (gEgo moveSpeed:) 1)) 0)
					(= temp1 0)
				)
				(if (!= gEgoGait 1) ; running
					(gEgo
						view: 1
						moveSpeed: temp0
						cycleSpeed: temp1
						setStep: 6 4
						setCycle: StopWalk 5
					)
				)
				(if (< (gEgo x:) 108)
					(= local11 -1)
					(gEgo setMotion: PolyPath 88 175 self)
				else
					(= local11 1)
					(gEgo setMotion: PolyPath 135 160 self)
				)
			)
			(1
				(gEgo view: 14)
				(SetFlag 24)
				(sfx number: 922 play:)
				(if (== local11 -1)
					(gEgo setLoop: 2 cel: 0 setCycle: End)
				else
					(gEgo setLoop: 3 cel: 6 x: 134 y: 158 setCycle: End)
				)
				(aFruitBasket setCycle: CT 2 1 self)
				(= local9 1)
			)
			(2
				(aFruitBasket setCycle: CT 4 1 self)
			)
			(3
				((= local2 (View new:))
					view: 231
					loop: 1
					cel: 0
					x: 113
					y: 162
					signal: 16385
					noun: 33
					init:
					setPri: 1
				)
				(= cycles 3)
			)
			(4
				(if (== local11 -1)
					(gEgo setCycle: Beg self)
				else
					(gEgo setCycle: CT 6 -1 self)
				)
			)
			(5
				(aFruitBasket noun: 34 setPri: 14)
				(aFruitMerchant setLoop: 2 setCycle: Fwd)
				(if (== local11 -1)
					(gEgo loop: 6 cel: 2)
				else
					(gEgo loop: 7 cel: 2 x: 135 y: 160)
				)
				(gEgo view: 0 xStep: 3 yStep: 2 normalize: addHonor: 40)
				(= ticks 4)
			)
			(6
				(if (< (onHisButt state:) 0)
					(ClearFlag 123)
					(HandsOn)
				)
				(aFruitBasket stopUpd:)
				(local2 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance onHisButt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch local3
					(0 0)
					(20
						(gEgo solvePuzzle: 217 5 4)
					)
					(else
						(gEgo solvePuzzle: 215 7)
					)
				)
				(ClearFlag 119)
				(if (and (!= register 0) (!= register 3))
					(self setScript: spEffect self register)
				else
					(= cycles 1)
				)
			)
			(1
				(aHarami
					view: 953
					setLoop: local10
					cel: 0
					x: (- (aHarami x:) 25)
					cycleSpeed: (if (== (gEgo script:) calmCast) 15 else 12)
					moveSpeed: (aHarami cycleSpeed:)
					setCycle: End self
					setMotion: MoveTo (+ (aHarami x:) 15) (+ (aHarami y:) 2)
				)
			)
			(2
				(aMoneyChanger setCycle: End self)
			)
			(3
				(aHarami ignoreActors: 1 stopUpd:)
				(= seconds 2)
			)
			(4
				(if (aFruitMerchant cycler:)
					(aFruitMerchant setCycle: End self)
				else
					(self cue:)
				)
			)
			(5
				(aGuard1 init: setCycle: Walk)
				(if (< (aHarami x:) 270)
					(aGuard1
						setMotion:
							PolyPath
							(+ (aHarami x:) 50)
							(+ (aHarami y:) 15)
							self
					)
				else
					(aGuard1 setMotion: PolyPath 300 (+ (aHarami y:) 15) self)
				)
			)
			(6
				(gMessager say: 5 6 60 0 self) ; "The matter is under control. This man is to be taken before the Hall of Judgement. All wrongs will be righted."
			)
			(7
				(SetFlag 22)
				(ClearFlag 80)
				(gLongSong2 fade:)
				(gLongSong3 fade:)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance seekNkill of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo aHarami self)
				(if (== register 20)
					(SetFlag 25)
				else
					(SetFlag 26)
				)
			)
			(1
				(= local13 (gEgo loop:))
				(gEgo
					view: (if (!= register 20) 14 else 9)
					loop: [local20 local13]
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(switch register
					(20
						(= temp0 2)
					)
					(81
						(= temp0 0)
					)
					(83
						(= temp0 4)
					)
				)
				(gEgo setCycle: End self)
				((= local14 (Actor new:))
					view: (if (!= register 20) 21 else 46)
					x: (+ (gEgo x:) 20)
					y: (- (gEgo y:) 35)
					z: 30
					moveSpeed: 0
					cycleSpeed: 0
					origStep: 6922
					scaleSignal: 1
					scaleX: 96
					scaleY: 96
					init:
					setLoop: temp0
					setCycle: Fwd
					setMotion: Chase aHarami 1 self
				)
			)
			(3
				(gEgo normalize: local13)
				(= local10 1)
				(gCurRoom setScript: onHisButt 0 (+ (local14 loop:) 1))
				(local14 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance calmCast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Face gEgo aHarami self)
				(SetFlag 27)
				(= local13 (gEgo loop:))
			)
			(1
				(gEgo
					view: 15
					loop: [local28 local13]
					cel: 0
					addHonor: 50
					setCycle: End self
				)
				(sfx number: 900 play:)
			)
			(2
				(if (and (gEgo castSpell: 24) (< (aHarami x:) 300))
					(= local10 1)
					(gCurRoom setScript: onHisButt)
				)
				(if (< (onHisButt state:) 0)
					(HandsOn)
				)
				(gEgo normalize: local13)
				(self dispose:)
			)
		)
	)
)

(instance from240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: -10 y: 200 setMotion: PolyPath 50 175 self)
				(if
					(and
						(not (IsFlag 22))
						(< gDay 5)
						(not gNight)
						(not (IsFlag 135))
					)
					(aHarami setCycle: End)
				)
			)
			(1
				(if
					(and
						(not (IsFlag 22))
						(< gDay 5)
						(not gNight)
						(not (IsFlag 135))
					)
					(SetFlag 122)
					(Face gEgo aHarami self)
				else
					(self cue:)
				)
			)
			(2
				(if
					(and
						(not (IsFlag 22))
						(< gDay 5)
						(not gNight)
						(not (IsFlag 135))
					)
					(gEgo code: moneyCode)
					(gCurRoom setScript: haramiHeadsOut)
				else
					(HandsOn)
					(if (or gNight (IsFlag 135))
						(gEgo code: nightCode)
					else
						(gEgo code: bazCode)
					)
					(egoTell init: gEgo @local36 @local74)
					(moneyTell init: aMoneyChanger @local51 @local79 @local100)
					(leatherTell init: aLeatherMerchant @local68 @local84)
					(fruitTell init: aFruitMerchant @local62 @local88)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((<= (gEgo x:) 5)
						(gEgo setMotion: MoveTo -30 200 self)
					)
					((>= (gEgo x:) 315)
						(gEgo setMotion: MoveTo 335 177 self)
					)
					(else
						(gEgo setMotion: PolyPath (gEgo x:) 250 self)
					)
				)
			)
			(1
				(if
					(and
						(not
							(or
								(IsFlag 23)
								(IsFlag 24)
								(IsFlag 25)
								(IsFlag 26)
								(IsFlag 27)
							)
						)
						(== gEgoGait 1) ; running
					)
					(SetFlag 23)
				)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance wondering of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(if (or (== local3 0) (== local3 20))
					0
				else
					(gEgo solvePuzzle: 214 4)
				)
				(if (IsFlag 24)
					(gEgo code: fruitCode)
				else
					(gEgo code: bazCode)
				)
				(egoTell init: gEgo @local36 @local74)
				(moneyTell init: aMoneyChanger @local51 @local79 @local100)
				(moneyTell init: aMoneyChanger @local51 @local79 @local100)
				(leatherTell init: aLeatherMerchant @local68 @local84)
				(fruitTell init: aFruitMerchant @local62 @local88)
				(aFruitBasket stopUpd:)
				(aMoneyChanger stopUpd:)
				(= seconds 14)
			)
			(1
				(HandsOff)
				(gEgo setMotion: 0 code: 0)
				(= cycles 3)
			)
			(2
				((Actor new:)
					view: 190
					loop: 1
					cel: 0
					x: 360
					y: 163
					xStep: 3
					yStep: 3
					init:
					setAvoider: PAvoider
					setCycle: Walk
					setMotion: PolyPath 285 163 self
				)
			)
			(3
				(gMessager say: 5 6 68 0 self) ; "Come with me to the Hall of Judgement, immediately."
			)
			(4
				(gLongSong2 fade:)
				(gLongSong3 fade:)
				(if (!= global209 3)
					(gEgo moveSpeed: local19 cycleSpeed: local18)
				)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance egoFell of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo loop:))
				(gEgo
					view: 6
					cel: 0
					setMotion: 0
					setLoop: [local92 temp0]
					setCycle: End self
				)
			)
			(1
				(if (mod (gEgo loop:) 2)
					(= temp1 -30)
					(= temp0 5)
				else
					(= temp1 30)
					(= temp0 4)
				)
				(gEgo
					view: 35
					x: (+ (gEgo x:) temp1)
					cel: 0
					setLoop: temp0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 25 6 76 0 self) ; "Why did I want to run on these fruit?, you ask yourself."
			)
			(3
				(if (mod (gEgo loop:) 2)
					(= temp1 16)
				else
					(= temp1 -16)
				)
				(gEgo x: (+ (gEgo x:) temp1) normalize: changeGait: 0 0) ; walking
				(= cycles 5)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance bazCode of Code
	(properties)

	(method (doit)
		(cond
			((and (< (gEgo distanceTo: aMoneyChanger) 40) (& local8 $0001))
				(gEgo setMotion: 0)
				(if (not (IsFlag 41))
					(SetFlag 41)
					(&= local8 $fffe)
					(gMessager say: 1 6 5) ; "Nharak sa'id, effendi, good day. I am the money changer, Dahab Khalis. Do you wish to exchange some foreign coin for the money of Tarna?"
				else
					(&= local8 $fffe)
					(gMessager say: 1 6 20) ; "Nharak sa'id, effendi. How may I be of service to you today?"
				)
			)
			((and (< (gEgo distanceTo: aFruitMerchant) 50) (& local8 $0002))
				(&= local8 $fffd)
				(aFruitMerchant newGreeting:)
			)
			(
				(and
					(< (gEgo distanceTo: aLeatherMerchant) 20)
					(& local8 $0004)
				)
				(gEgo setMotion: 0)
				(&= local8 $fffb)
				(gMessager say: 3 6 27) ; "Hujambo, bwana."
			)
			((not (< 5 (gEgo x:) 315))
				(if
					(or
						(== (gCurRoom script:) wondering)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: sExit)
				)
			)
			(
				(and
					(> (gEgo y:) 183)
					(or
						(== (gCurRoom script:) wondering)
						(not (gCurRoom script:))
					)
				)
				(gCurRoom setScript: sExit)
			)
		)
	)
)

(instance nightCode of Code
	(properties)

	(method (doit)
		(cond
			((and (not (< 5 (gEgo x:) 315)) (not (gCurRoom script:)))
				(gCurRoom setScript: sExit)
			)
			((and (> (gEgo y:) 183) (not (gCurRoom script:)))
				(gCurRoom setScript: sExit)
			)
		)
	)
)

(instance fruitCode of Code
	(properties)

	(method (doit)
		(cond
			(
				(and
					(== gEgoGait 1) ; running
					(gEgo mover:)
					(& (gEgo onControl:) $0008)
					(not (gEgo script:))
				)
				(gEgo setScript: egoFell)
			)
			((and (< (gEgo distanceTo: aMoneyChanger) 40) (& local8 $0001))
				(gEgo setMotion: 0)
				(if (not (IsFlag 41))
					(SetFlag 41)
					(&= local8 $fffe)
					(gMessager say: 1 6 5) ; "Nharak sa'id, effendi, good day. I am the money changer, Dahab Khalis. Do you wish to exchange some foreign coin for the money of Tarna?"
				else
					(&= local8 $fffe)
					(gMessager say: 1 6 20) ; "Nharak sa'id, effendi. How may I be of service to you today?"
				)
			)
			((and (< (gEgo distanceTo: aFruitMerchant) 50) (& local8 $0002))
				(gEgo setMotion: 0)
				(&= local8 $fffd)
				(aFruitMerchant setCycle: Beg)
				(gMessager say: 4 6 77 0 wondering) ; "You! You owe me for the fruit you have destroyed!"
			)
			(
				(and
					(< (gEgo distanceTo: aLeatherMerchant) 20)
					(& local8 $0004)
				)
				(gEgo setMotion: 0)
				(&= local8 $fffb)
				(gMessager say: 3 6 27) ; "Hujambo, bwana."
			)
			((not (< 5 (gEgo x:) 315))
				(if
					(or
						(== (gCurRoom script:) wondering)
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: sExit)
				)
			)
			(
				(and
					(> (gEgo y:) 183)
					(or
						(== (gCurRoom script:) wondering)
						(not (gCurRoom script:))
					)
				)
				(gCurRoom setScript: sExit)
			)
		)
	)
)

(instance moneyCode of Code
	(properties)

	(method (doit)
		(if (and (< (gEgo distanceTo: aMoneyChanger) 40) (not local4))
			(= local4 1)
			(gEgo setMotion: 0)
			(gMessager say: 1 6 60) ; "Stop him! Thief! Thief!"
		)
	)
)

(instance aHarami of Actor
	(properties
		x 42
		y 106
		noun 26
		view 954
		loop 2
		priority 9
		signal 4112
	)

	(method (doVerb theVerb)
		(cond
			((and (== global209 1) (not (gEgo script:)))
				(cond
					((or (== theVerb 20) (== theVerb 81) (== theVerb 83)) ; theDaggers, flameDartSpell, forceBoltSpell
						(if (< x 260)
							(if (== theVerb 20) ; theDaggers
								(gEgo drop: 10 1) ; theDaggers
							)
							(gEgo setScript: seekNkill 0 theVerb)
						else
							(= global386 ((gUser curEvent:) x:))
							(= global387 ((gUser curEvent:) y:))
							(= local3 theVerb)
							(if (== theVerb 20) ; theDaggers
								(gEgo drop: 10 1) ; theDaggers
							)
							(gEgo setScript: castFlameDart 0 theVerb)
						)
					)
					((== theVerb 82) ; fetchSpell
						(gCurRoom doVerb: theVerb)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			((or (== theVerb 20) (== theVerb 81) (== theVerb 83)) ; theDaggers, flameDartSpell, forceBoltSpell
				(= local3 theVerb)
				(= global386 ((gUser curEvent:) x:))
				(= global387 ((gUser curEvent:) y:))
				(if (== theVerb 20) ; theDaggers
					(gEgo drop: 10 1) ; theDaggers
				)
				(gEgo setScript: castFlameDart 0 theVerb)
			)
			((== theVerb 82) ; fetchSpell
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aGuard1 of Actor
	(properties
		x 360
		y 163
		noun 5
		yStep 3
		view 190
		loop 1
	)
)

(instance aFruitMerchant of MerchantActor
	(properties
		x 143
		y 183
		noun 4
		approachX 149
		approachY 157
		view 234
		loop 3
		priority 14
		signal 16400
		cycleSpeed 11
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
	)

	(method (newGreeting)
		(switch (mod gDay 6)
			(0
				(gMessager say: noun 6 44) ; "Fruit, fruit the finest of fruit! Does your mouth not crave the sweet juices of a passion fruit, effendi?"
			)
			(1
				(gMessager say: noun 6 45) ; "Bananas, papayas, and pomegranates for sale! Will you not buy some fruit to fill your hunger, far-traveler?"
			)
			(2
				(gMessager say: noun 6 46) ; "Fruit, fruit, fine fruit! One bite will keep you in good health, effendi."
			)
			(3
				(gMessager say: noun 6 47) ; "Tomatoes and tamarinds, mangoes and manioc, pineapples and coconuts! How can you resist such temptations, oh best of buyers?"
			)
			(4
				(gMessager say: noun 6 48) ; "Sweet, ripe fruit! The very food of the fabled Houris of Paradise! Dare to eat a peach, sahib?"
			)
			(5
				(gMessager say: noun 6 49) ; "Healthy, healing fruit! You cannot be but happy when masticating mangoes, oh master."
			)
		)
	)
)

(instance aLeatherMerchant of MerchantActor
	(properties
		x 146
		y 121
		z 20
		noun 3
		approachDist 20
		view 236
		loop 2
		signal 20480
		cycleSpeed 13
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
	)
)

(instance aFruitBasket of Prop
	(properties
		x 122
		y 163
		noun 29
		approachX 106
		approachY 151
		view 231
		signal 20480
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (IsFlag 22)) (< gDay 5))
					(SetFlag 123)
					(gEgo setScript: knockFruitOver)
				else
					(gMessager say: 25 6 78) ; "You look through the basket of fruit, but don't see anything of interest."
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance aMoneyChanger of Actor
	(properties
		x 21
		y 103
		noun 1
		approachDist 40
		view 232
		priority 1
		signal 16400
		cycleSpeed 9
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 59 10) ; Talk, Do, theRoyals, Money
	)
)

(instance spBurst of Prop
	(properties
		view 21
		priority 15
		signal 16400
		cycleSpeed 0
	)

	(method (cue)
		(self dispose:)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(if (== (= local1 (proc51_1)) aFruitBasket)
			(= local1 aFruitMerchant)
		)
		(= temp0 (gEgo distanceTo: local1))
		(switch local1
			(aMoneyChanger
				(if (> temp0 40)
					(gMessager say: 2 5 83) ; "To which merchant you wish to speak?"
					(return -999)
				)
			)
			(aFruitMerchant
				(if (> temp0 60)
					(gMessager say: 2 5 83) ; "To which merchant you wish to speak?"
					(return -999)
				)
			)
			(else
				(if (> temp0 30)
					(gMessager say: 2 5 83) ; "To which merchant you wish to speak?"
					(return -999)
				)
			)
		)
		(if
			(!=
				(gEgo heading:)
				(GetAngle (gEgo x:) (gEgo y:) (local1 x:) (local1 y:))
			)
			(Face gEgo local1)
		)
		((Timer new:) setCycle: self (+ (gEgo cycleSpeed:) 10))
		(= iconValue 0)
		(return -999)
	)

	(method (doChild)
		(switch query
			(-21 ; "Say Yes"
				(SetFlag 171)
				(proc233_0)
				(return 0)
			)
			(-22 ; "Say No"
				(SetFlag 171)
				(= query 22) ; "Say No"
			)
			(-20 ; "Greet"
				(cond
					((== local1 aMoneyChanger)
						(= query 61)
					)
					((== local1 aFruitMerchant)
						(= query 58)
					)
					((== local1 aLeatherMerchant)
						(= query 31) ; "Greet"
					)
				)
			)
			(-23 ; "Say Good-bye"
				(cond
					((== local1 aMoneyChanger)
						(&= local8 $efff)
						(gEgo addHonor: 2)
						(= query 23) ; "Say Good-bye"
					)
					((== local1 aFruitMerchant)
						(= query 59) ; "Good-bye"
					)
					((== local1 aLeatherMerchant)
						(= query 32)
					)
				)
			)
			(-57 ; "Buy Fruit"
				(if global424
					(fruitTell doVerb: 59)
				else
					(fruitTell doVerb: 10)
				)
				(return 0)
			)
			(-34 ; "Make Purchase"
				(if global424
					(leatherTell doVerb: 59)
				else
					(leatherTell doVerb: 10)
				)
				(return 0)
			)
			(-26 ; "Tell about Shapeir"
				(= query 26) ; "Tell about Shapeir"
			)
		)
	)

	(method (cue)
		(= query
			(super
				showDialog:
					-21 ; "Say Yes"
					(and
						(== aMoneyChanger local1)
						(IsFlag 41)
						(not (IsFlag 171))
					)
					-22 ; "Say No"
					(and
						(== aMoneyChanger local1)
						(IsFlag 41)
						(not (IsFlag 171))
					)
					-23 ; "Say Good-bye"
					(or (!= aMoneyChanger local1) (& local8 $1000))
					-26 ; "Tell about Shapeir"
					(== aMoneyChanger local1)
					-57 ; "Buy Fruit"
					(== aFruitMerchant local1)
					-34 ; "Make Purchase"
					(== aLeatherMerchant local1)
			)
		)
		(= local0 1)
		(if iconValue
			(= query iconValue)
		)
		(egoTell respond:)
	)

	(method (respond)
		(if (not local0)
			(super respond:)
		else
			(= local0 0)
			(cond
				((not query)
					(return 1)
				)
				((== query -999)
					(return 1)
				)
				((== query 999)
					(self doParent:)
					(return 0)
				)
				((and (< query 0) (not (self doChild: query)))
					(return 1)
				)
			)
			(if (< query 0)
				(= query (- query))
			)
			(gMessager say: (client noun:) 5 query 0)
			(return 1)
		)
	)
)

(instance moneyTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog: 5 (not (IsFlag 41)) -12 (IsFlag 41) -73 (IsFlag 41) ; "Rumors", "Money Changer"
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(SetFlag 171)
				(proc233_0)
				(return 1)
			)
			(10 ; Money
				(if (< global410 100)
					(gMessager say: 1 6 72) ; "Forgive me, effendi, but you don't have enough commons to exchange for one royal."
				else
					(proc233_0)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doChild)
		(switch query
			(-12 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(gMessager say: 1 5 13) ; "Rumors, hmm, they say that there is tremendous inflation in Silmaria, and that the exchange rate has bottomed out for the Mordavian coinage, since no one can travel in or out of the country now."
					)
					(1
						(gMessager say: 1 5 14) ; "My wife has told me that her friend has said that she heard about somebody who saw someone with eyes that glowed red at night."
					)
					(2
						(gMessager say: 1 5 15) ; "I have heard that the common currency among the Simbani is a cow. I am glad that I do not have to exchange their money."
					)
					(3
						(gMessager say: 1 5 16) ; "There has been talk that Leopardmen have been sneaking around the city at night."
					)
					(4
						(gMessager say: 1 5 17) ; "They say that the Leopardmen use beads as their coinage."
					)
					(5
						(gMessager say: 1 5 18) ; "I have heard that a ghostly figure with a staff walks the middle plateau after noon of the night when the moon is full."
					)
				)
				(return 0)
			)
			(-73 ; "Money Changer"
				(switch (mod gDay 5)
					(0
						(gMessager say: 1 5 6) ; "I am most well, effendi, thank you. I was once the money changer of Raseir, but when Ad Avis took over, I moved with my family to Tarna. We are most happy here."
					)
					(1
						(gMessager say: 1 5 7) ; "I am well, and my daughter has recently gifted me with my first grandson, so I am happy also."
					)
					(2
						(gMessager say: 1 5 8) ; "It is most kind of you to speak with me. Business is slow when the caravans do not come. With all this talk of war, I do not know when the caravans will return."
					)
					(3
						(gMessager say: 1 5 9) ; "This talk of war disturbs me. I left Raseir to get away from such violence. I am too old to leave Tarna now."
					)
					(4
						(gMessager say: 1 5 10) ; "Alas, business has been slow, effendi. If you had not come to Tarna, I would have nothing to do now."
					)
				)
				(return 0)
			)
			(else
				(super doChild: query)
			)
		)
	)
)

(instance fruitTell of Teller
	(properties)

	(method (doVerb theVerb &tmp [temp0 20])
		(switch theVerb
			(59 ; theRoyals
				(gMessager say: 4 6 63) ; "I am so very sorry, effendi, but I cannot accept foreign coins. Please exchange them for royals at the moneychanger's stall right behind you; then you will be able to buy some of my fine fruit."
			)
			(10 ; Money
				(if (not local6)
					((ScriptID 232 0) ; fruitVendor
						goods:
							((List new:)
								add:
									((Class_47_1 new: 27)
										price: 50
										denomination: 1
										quantity: 40
									)
							)
					)
					(= local6 ((ScriptID 232 0) goods:)) ; fruitVendor
				else
					((ScriptID 232 0) goods: local6) ; fruitVendor
				)
				((ScriptID 232 0) init: purchase: dispose:) ; fruitVendor
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doChild)
		(switch query
			(-12 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(gMessager say: 4 5 13) ; "There has been talk that Tarna is going to war with the Simbani. Very bad for business, wars."
					)
					(1
						(gMessager say: 4 5 14) ; "I have heard tell from those who bring me fruit from the jungle that strange monsters now roam near the waterfall. Monsters even stranger than you can imagine!"
					)
					(2
						(gMessager say: 4 5 15) ; "A rhino with glowing red eyes ran through a pineapple plantation the other night, trampling all the fruit and several men as well."
					)
					(3
						(gMessager say: 4 5 16) ; "In the jungle there is supposed to be a magic tree which bears the fruit of kindness. How I would love to sell such fruit!"
					)
					(4
						(gMessager say: 4 5 17) ; "The date harvest in Shapeir will be particularly fine this season, I have heard."
					)
					(5
						(gMessager say: 4 5 18) ; "I have heard told that an elephant was found dead last week at the edge of a mango orchard. The elephant had been clawed to death, but not eaten. It had crushed many mango plants in its death. What a terrible loss."
					)
				)
				(return 0)
			)
			(-75 ; "Fruit Merchant"
				(switch (mod gDay 6)
					(0
						(gMessager say: 4 5 51) ; "I am Samra bin Balah, the seller of succulent sensations for the mouth."
					)
					(1
						(gMessager say: 4 5 52) ; "Alas, I am but a poor man today, for no one has had the pleasure of buying my fruit."
					)
					(2
						(gMessager say: 4 5 53) ; "I am most overjoyed today, for now I may share the finest of taste temptations with you, effendi. Surely you have come here to buy some fruit?"
					)
					(3
						(gMessager say: 4 5 54) ; "Most happy, I am. For today, I have sun-ripened, luscious watermelon to sell."
					)
					(4
						(gMessager say: 4 5 55) ; "Alas, my wife will scream at me tonight, for I have sold very little fruit for very little money today."
					)
					(5
						(gMessager say: 4 5 56) ; "I am well pleased, for you have come again to enjoy my fruit and enrich my purse, have you not?"
					)
				)
				(return 0)
			)
			(else
				(super doChild: query)
			)
		)
	)
)

(instance leatherTell of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(gMessager say: 3 6 63) ; "I am unable to accept your money. You must see first the money changer."
			)
			(10 ; Money
				(if (not local7)
					((ScriptID 235 0) ; leatherVendor
						goods:
							((List new:)
								add:
									((Class_47_1 new: 32)
										price: 200
										denomination: 1
										quantity: 70
									)
									((Class_47_1 new: 31) price: 5 quantity: 6)
							)
					)
					(= local7 ((ScriptID 235 0) goods:)) ; leatherVendor
				else
					((ScriptID 235 0) goods: local7) ; leatherVendor
				)
				((ScriptID 235 0) init: purchase: dispose:) ; leatherVendor
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tMoneyChangerTalker of GloryTalker
	(properties
		x 200
		y 2
		view 233
		loop 1
		talkWidth 260
		back 57
		textX -175
		textY 150
		backColor 48
	)

	(method (init)
		(super init: moneyChangerBust moneyChangerEyes moneyChangerMouth &rest)
	)
)

(instance moneyChangerBust of Prop
	(properties
		view 233
		loop 1
		cel 1
		signal 16384
	)
)

(instance moneyChangerEyes of Prop
	(properties
		nsTop 47
		nsLeft 34
		view 233
		loop 2
		priority 15
		signal 16400
	)
)

(instance moneyChangerMouth of Prop
	(properties
		nsTop 58
		nsLeft 35
		view 233
		signal 16384
	)
)

(instance moneyChangerBrow of Prop ; UNUSED
	(properties
		nsTop 26
		nsLeft 28
		view 233
		loop 3
		signal 16384
	)
)

(instance leatherA of View
	(properties
		x 132
		y 91
		z -30
		view 230
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(80 ; calmSpell
				(gCurRoom doVerb: theVerb)
			)
			(81 ; flameDartSpell
				(gCurRoom doVerb: theVerb)
			)
			(83 ; forceBoltSpell
				(gCurRoom doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance leatherB of View
	(properties
		x 253
		y 104
		z -30
		view 230
		cel 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(80 ; calmSpell
				(gCurRoom doVerb: theVerb)
			)
			(81 ; flameDartSpell
				(gCurRoom doVerb: theVerb)
			)
			(83 ; forceBoltSpell
				(gCurRoom doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance fruitA of View
	(properties
		x 157
		y 158
		z -30
		noun 30
		view 230
		loop 1
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance bananas of Feature
	(properties
		x 178
		y 180
		noun 6
		nsTop 172
		nsLeft 164
		nsBottom 189
		nsRight 192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance fruit of Feature
	(properties
		x 118
		y 204
		z 30
		noun 28
		nsTop 167
		nsLeft 106
		nsBottom 181
		nsRight 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance hides of Feature
	(properties
		x 64
		y 123
		z 60
		noun 8
		nsTop 41
		nsLeft 57
		nsBottom 85
		nsRight 71
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance belts of Feature
	(properties
		x 181
		y 103
		z 60
		noun 9
		nsTop 23
		nsLeft 171
		nsBottom 63
		nsRight 192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance skinrugs of Feature
	(properties
		x 93
		y 100
		noun 10
		nsTop 90
		nsLeft 78
		nsBottom 111
		nsRight 109
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance zebrarug of Feature
	(properties
		x 135
		y 102
		noun 11
		nsTop 90
		nsLeft 109
		nsBottom 115
		nsRight 162
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance giraffe of Feature
	(properties
		x 138
		y 115
		z 50
		noun 12
		nsTop 50
		nsLeft 112
		nsBottom 81
		nsRight 164
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance leopardskin of Feature
	(properties
		x 89
		y 98
		z 60
		noun 13
		nsTop 16
		nsLeft 78
		nsBottom 60
		nsRight 101
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance money_sign of Feature
	(properties
		x 17
		y 37
		noun 14
		nsTop 30
		nsBottom 45
		nsRight 34
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance hideracks of Feature
	(properties
		x 221
		y 114
		z 30
		noun 15
		nsTop 62
		nsLeft 197
		nsBottom 107
		nsRight 245
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance watermelon of Feature
	(properties
		x 237
		y 184
		noun 16
		nsTop 180
		nsLeft 222
		nsBottom 189
		nsRight 252
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance basket of Feature
	(properties
		x 242
		y 117
		z 60
		noun 17
		nsTop 47
		nsLeft 228
		nsBottom 68
		nsRight 256
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance pitcher of Feature
	(properties
		x 262
		y 116
		z 20
		noun 18
		nsTop 86
		nsLeft 254
		nsBottom 107
		nsRight 270
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance roundtray of Feature
	(properties
		x 271
		y 114
		z 60
		noun 19
		nsTop 42
		nsLeft 265
		nsBottom 67
		nsRight 277
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance peppers of Feature
	(properties
		x 284
		y 110
		z 50
		noun 20
		nsTop 45
		nsLeft 278
		nsBottom 76
		nsRight 290
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance rectangletray of Feature
	(properties
		x 296
		y 113
		z 60
		noun 21
		nsTop 39
		nsLeft 288
		nsBottom 67
		nsRight 304
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance redplate of Feature
	(properties
		x 262
		y 114
		noun 22
		nsTop 109
		nsLeft 251
		nsBottom 119
		nsRight 273
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance brassvase of Feature
	(properties
		x 284
		y 108
		noun 23
		nsTop 92
		nsLeft 276
		nsBottom 125
		nsRight 292
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance shoes of Feature
	(properties
		x 301
		y 126
		noun 24
		nsTop 120
		nsLeft 293
		nsBottom 133
		nsRight 309
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

