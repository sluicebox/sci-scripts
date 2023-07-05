;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use pawnShopGenie)
(use KQ6Room)
(use n913)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm280 0
	map 1
	shopOwner 2
	shopDoor 3
	smBird 4
	smTinderBox 5
	smFlute 6
	smPBrush 7
	proc280_8 8
	shopOwnerScr 9
	proc280_10 10
)

(local
	local0
	local1 = -1
	local2 = -1
	local3
	[local4 32] = [22 129 22 157 217 157 250 157 241 148 214 148 184 127 210 127 210 121 188 121 160 121 139 133 88 133 61 133 57 120 40 120]
	[local36 30] = [22 129 22 157 217 157 250 157 241 148 214 148 184 127 210 127 210 121 188 121 160 121 141 131 86 131 78 122 40 120]
	local66
	[local67 13] = [51 152 135 150 255 133 311 165 202 157 235 154 -1]
	local80
)

(procedure (proc280_10 param1)
	(cond
		((shopOwner cycler:)
			(removeOwnerScr client: removeOwnerScr register: param1)
			((shopOwner cycler:) caller: removeOwnerScr)
		)
		((== (shopOwnerScr state:) 5)
			(removeOwnerScr client: removeOwnerScr register: param1)
			(shopOwnerScr register: removeOwnerScr seconds: 0 ticks: 1)
		)
		(else
			(shopOwner setScript: 0)
			(param1 cue:)
		)
	)
)

(procedure (proc280_8 param1)
	(if param1
		(gCurRoom
			addObstacle: (roomPoly type: PContainedAccess points: @local4 size: 16 yourself:)
		)
	else
		(gCurRoom
			addObstacle: (roomPoly type: PContainedAccess points: @local36 size: 15 yourself:)
		)
	)
)

(instance rm280 of KQ6Room
	(properties
		noun 3
		picture 280
		autoLoad 0
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 240)
			(shopDoor cel: 5 init: setScript: doorScr)
		else
			(shopDoor init:)
		)
		(if (and (== gPrevRoomNum 145) (IsFlag 41))
			(gEgo posn: 190 138)
		else
			(gEgo posn: 51 121)
		)
		(gEgo init: reset: loop: 9 cel: 0 setScale: Scaler 105 90 139 121)
		(shopOwner init:)
		(mints init:)
		(if (== ((gInventory at: 48) owner:) gCurRoomNum) ; tinderBox
			(smTinderBox init:)
		)
		(if (== ((gInventory at: 3) owner:) gCurRoomNum) ; brush
			(smPBrush init:)
		)
		(if (== ((gInventory at: 27) owner:) gCurRoomNum) ; nightingale
			(smBird init:)
		)
		(if (== ((gInventory at: 14) owner:) gCurRoomNum) ; flute
			(smFlute init:)
		)
		(if (and (IsFlag 29) (IsFlag 30) (not (gEgo has: 0))) ; map
			(map init:)
		)
		(cond
			((and (== gPrevRoomNum 145) (IsFlag 41))
				(gGlobalSound number: 240 loop: -1 play: 70)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 145)
				(gCurRoom setScript: (ScriptID 282 0)) ; reanimationScr
			)
			(
				(or
					(and (IsFlag 17) (not (gEgo has: 0))) ; map
					(and
						(not (IsFlag 82))
						(not (IsFlag 28))
						(OneOf gAct 4 5)
					)
					(and
						(not (IsFlag 82))
						(== gAct 5)
						(IsFlag 15)
						(not (SetFlag 158))
					)
				)
				(if (and (not (IsFlag 158)) (== gAct 5) (IsFlag 15))
					(SetFlag 158)
				)
				(SetFlag 28)
				((ScriptID 281 0) init: 1) ; pawnShopGenie
				(= local66 1)
			)
			((and (not (IsFlag 28)) (== gAct 3))
				(SetFlag 28)
				((ScriptID 281 0) init: 0) ; pawnShopGenie
				(= local66 1)
			)
		)
		(gFeatures
			add: genericFeatures eastShelf northShelf
			eachElementDo: #init
		)
		(if (not (gCurRoom script:))
			(= local80 1)
			(shopOwner
				setScript: shopOwnerScr 0 (if (== gPrevRoomNum 145) 0 else 1)
			)
		)
		(proc280_8 local66)
	)

	(method (scriptCheck param1 &tmp temp0)
		(= temp0 1)
		(if (== param1 87)
			(if (gCast contains: (ScriptID 281 0)) ; pawnShopGenie
				(gCurRoom setScript: (ScriptID 282 1)) ; drinkPotionGenieScr
			else
				(gCurRoom setScript: (ScriptID 282 5)) ; drinkPotionNoGenieScr
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (dispose)
		(if (== gNewRoomNum 240)
			(gGlobalSound fade: 127 15 15 0)
			((ScriptID 10 0) setIt: 512) ; rgCrown
		else
			(gGlobalSound fade:)
		)
		((ScriptID 281 0) dispose:) ; pawnShopGenie
		(DisposeScript 969)
		(DisposeScript 923)
		(DisposeScript 283)
		(DisposeScript 282)
		(ClearFlag 49)
		(super dispose:)
	)
)

(instance exitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					setSpeed: 6
					normal: 0
					setPri: 1
					view: 2812
					loop: 0
					cel: 0
					posn: 47 125
					setScale: 0
					scaleX: 117
					scaleY: 117
					scaleSignal: 1
					setCycle: CT 2 1 self
				)
			)
			(3
				(gGlobalSound4 number: 901 loop: 1 play:)
				(shopDoor setCycle: End self)
				(gEgo setCycle: End self)
			)
			(4 0)
			(5
				(proc281_1)
				(= cycles 1)
			)
			(6
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance doorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 45)
			)
			(1
				(client cycleSpeed: 8 setCycle: Beg self)
			)
			(2
				(= cycles 2)
			)
			(3
				(client stopUpd:)
				(gGlobalSound4 number: 902 loop: 1 play: self)
			)
			(4
				(= cycles 2)
			)
			(5
				(UnLoad 132 902)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance removeOwnerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheDoits add: self)
				(= cycles 2)
			)
			(1
				(= client 0)
				(gTheDoits delete: self)
				(proc280_10 register)
				(= state -1)
			)
		)
	)
)

(instance shopOwnerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(client view: 2841 loop: 1 cel: 0)
				)
				(= seconds 2)
			)
			(1
				(if register
					(client setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(2
				(client view: 280 loop: 8 posn: 236 127 cel: 0)
				(if (and local80 register)
					(= local80 0)
					(gGame handsOn:)
					(gMessager say: 1 0 (if (> gAct 1) 67 else 66))
				)
				(client stopUpd:)
				(= seconds (Random 10 20))
			)
			(3
				(= state (- (Random 4 5) 1))
				(= cycles 1)
			)
			(4
				(client view: 285 loop: 0 cel: 0 setCycle: End self)
				(= state 1)
			)
			(5
				(client view: 2852 loop: 0 cel: 0 setCycle: End)
				(= seconds 10)
			)
			(6
				(client
					view: 2853
					loop: 0
					cel: 0
					setCycle: End (if register register else removeOwnerScr)
				)
				(= state 1)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance genericTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(gMessager say: 4 2 register 0 self)
			)
			(3
				(gEgo reset: 0)
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shopOwner of Actor
	(properties
		x 236
		y 127
		noun 4
		approachX 192
		approachY 133
		view 2841
		signal 20481
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 70) ; Talk, royalRing
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(cond
					((> gAct 1)
						(gCurRoom setScript: (ScriptID 284 5)) ; talkAfterActI
					)
					((not (SetFlag 64))
						(gCurRoom setScript: genericTalkScr 0 61)
					)
					((and (not (IsFlag 29)) (not (SetFlag 30)))
						(gCurRoom setScript: genericTalkScr 0 11)
					)
					((not (IsFlag 29))
						(gCurRoom setScript: genericTalkScr 0 12)
					)
					((not (SetFlag 30))
						(gCurRoom setScript: (ScriptID 284 0)) ; ownerTalkScr
					)
					(else
						(gCurRoom setScript: genericTalkScr 0 14)
					)
				)
			)
			((== theVerb 70) ; royalRing
				(cond
					((and (== gAct 1) (not (gCast contains: map)))
						(gCurRoom setScript: (ScriptID 284 1) self) ; ringMapNotOutScr
					)
					((== gAct 1)
						(gCurRoom setScript: (ScriptID 284 2)) ; ringForMapActIScr
					)
					((and (!= gAct 1) (gEgo has: 0)) ; map
						(gCurRoom setScript: (ScriptID 284 3)) ; ringForPearlScr
					)
					(else
						(gCurRoom setScript: (ScriptID 284 4)) ; ringForMapNotActIScr
					)
				)
			)
			((== theVerb 40) ; coin
				(if (gCast contains: map)
					(gCurRoom setScript: (ScriptID 283 3)) ; offerCoinForMapScr
				else
					(gCurRoom setScript: (ScriptID 283 1)) ; buyItemWithCoinScr
				)
			)
			((OneOf theVerb 37 20 29 31) ; nightingale, tinderBox, brush, flute
				(gCurRoom setScript: (ScriptID 283 2) 0 theVerb) ; genericExchangeScr
			)
			((== theVerb 66) ; pearl
				(if (gEgo has: 0) ; map
					(gCurRoom setScript: (ScriptID 285 0) 0 (IsFlag 36)) ; pearlForRingScr
				else
					(gCurRoom setScript: (ScriptID 285 1) 0 (IsFlag 36)) ; pearlForMapScr
				)
				(SetFlag 36)
			)
			((== theVerb 12) ; map
				(gCurRoom setScript: (ScriptID 285 2)) ; mapForPearlOrRingScr
			)
			((OneOf theVerb 13 42 27 28 39 45 7 83) ; mirror, boringBook, riddleBook, spellBook, brick, clothes, deadMansCoin, ink
				(if (OneOf theVerb 27 28) ; riddleBook, spellBook
					(= theVerb 42) ; boringBook
				)
				(gCurRoom setScript: (ScriptID 286 5) 0 theVerb) ; fullMsgShowScr
			)
			(
				(or
					(OneOf theVerb 8 30 47 48 52 68 38 16) ; dagger, feather, flower, gauntlet, lettuce, rabbitFoot, ???, scythe
					(OneOf theVerb 85 17 35 51 32) ; sentence, shield, skeletonKey, skull, poem
					(and
						(OneOf theVerb 92 43 57 58 59 60 96 56) ; realLamp, huntersLamp, fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, fakeLamp1, fakeLamp5
						(= theVerb 92) ; realLamp
					)
				)
				(if (== theVerb 17) ; shield
					(= theVerb 48) ; gauntlet
				)
				(gCurRoom setScript: (ScriptID 286 4) 0 theVerb) ; genericShowScr
			)
			(
				(or
					(OneOf theVerb 5 1 49 15 18 50 54) ; Do, Look, ticket, hair, cassimaHair, handkerchief, lettuce (melted)
					(OneOf theVerb 63 65 33 69 25 94 34 24) ; mint, note, ribbon, ring, holeInTheWall, participle, tomato, sacredWater
				)
				(if (== theVerb 50) ; handkerchief
					(= theVerb 49) ; ticket
				)
				(if (== theVerb 18) ; cassimaHair
					(= theVerb 15) ; hair
				)
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom setScript: (ScriptID 286 4)) ; genericShowScr
			)
		)
	)
)

(class SmallItem of View
	(properties
		noun 9
		approachX 190
		approachY 138
		view 280
		loop 6
		signal 16401
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(self approachVerbs: 5 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 1) ; Do, Look
			(gCurRoom setScript: (ScriptID 283 4)) ; lookAtCounterScr
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance smPBrush of SmallItem
	(properties
		x 229
		y 117
		cel 5
		priority 12
	)
)

(instance smFlute of SmallItem
	(properties
		x 220
		y 111
		cel 2
		priority 10
	)
)

(instance smTinderBox of SmallItem
	(properties
		x 216
		y 115
		cel 4
		priority 12
	)
)

(instance smBird of SmallItem
	(properties
		x 213
		y 109
		cel 3
		priority 10
	)
)

(instance map of View
	(properties
		x 236
		y 127
		noun 6
		view 280
		loop 6
		priority 9
		signal 4113
	)
)

(instance shopDoor of Prop
	(properties
		x 39
		y 126
		noun 14
		approachX 56
		approachY 125
		view 280
		loop 2
		signal 20481
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(self setScript: exitScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance takeMintScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (SetFlag 90))
					(gGame givePoints: 1)
				)
				(gEgo
					setSpeed: 7
					normal: 0
					view: 2813
					loop: 0
					posn: 176 133
					get: 23 ; mint
					setCycle: End self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo reset: 0 posn: (mints approachX:) (mints approachY:))
				(= cycles 2)
			)
			(3
				(UnLoad 128 2813)
				(gMessager say: 7 5 34 1 self) ; "Alexander takes a mint."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mints of View
	(properties
		x 201
		y 110
		noun 7
		approachX 180
		approachY 131
		view 280
		loop 3
		priority 9
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (< gAct 3)
					(if (not (gEgo has: 23)) ; mint
						(gCurRoom setScript: takeMintScr)
					else
						(gMessager say: noun theVerb 35) ; "Alexander already has a mint. He'd prefer to leave some for the other customers."
					)
				else
					(gMessager say: 7 5 32) ; "The mint dish is empty."
				)
			)
			(1 ; Look
				(if (< gAct 3)
					(gMessager say: noun theVerb 33) ; "An elegant little glass dish decorates the counter top."
				else
					(gMessager say: noun theVerb 32) ; "The candy dish is empty."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance firstWallLookScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager
					say: register 1 (if (== register 17) 58 else 49) 0 self
				)
			)
			(1
				(gMessager say: register 1 50 0 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance northShelf of Feature
	(properties
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(= noun 17)
		(switch theVerb
			(1 ; Look
				(if (== (+ local1 1) 0)
					(gCurRoom setScript: firstWallLookScr 0 noun)
					(+= local1 2)
				else
					(gMessager
						say:
							noun
							theVerb
							(switch (++ local1)
								(0 0)
								(1 50)
								(2 51)
								(3 52)
								(4 53)
								(5 54)
								(6 55)
								(7 56)
								(8 57)
								(9 59)
								(10
									(= local1 0)
									60
								)
							)
					)
				)
			)
			(else
				(cond
					(
						(or
							(and
								(== (gKq6ApproachCode doit: theVerb) -32768)
								(or (= theVerb 0) 1)
							)
							(== theVerb 5) ; Do
						)
						(= noun 27)
					)
					((== theVerb 2) ; Talk
						(= noun 16)
					)
				)
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eastShelf of Feature
	(properties
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(= noun 16)
		(switch theVerb
			(1 ; Look
				(if (== (+ local2 1) 0)
					(gCurRoom setScript: firstWallLookScr 0 noun)
					(+= local2 2)
				else
					(gMessager
						say:
							noun
							theVerb
							(switch (++ local2)
								(0 50)
								(1 51)
								(2 52)
								(3 53)
								(4 54)
								(5 55)
								(6 56)
								(7
									(= local2 0)
									57
								)
							)
					)
				)
			)
			(else
				(if
					(or
						(and
							(== (gKq6ApproachCode doit: theVerb) -32768)
							(or (= theVerb 0) 1)
						)
						(== theVerb 5) ; Do
					)
					(= noun 27)
				)
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roomPoly of Polygon
	(properties)
)

(instance genericFeatures of Feature
	(properties)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(= local3 0)
		(= noun
			(switch temp0
				(2
					(if (> (param1 y:) 85) 8 else 15)
				)
				(4
					(if (> (param1 y:) 136)
						(= local3 2)
						23
					else
						(= local3 3)
						18
					)
				)
				(8
					(if (> (param1 y:) 146)
						(= local3 3)
						28
					else
						22
					)
				)
				(16 36)
				(32
					(= local3 3)
					20
				)
				(256
					(if (< (param1 x:) 120) 32 else 0)
				)
				(64
					(if (> (param1 y:) 131)
						29
					else
						(= local3 2)
						21
					)
				)
				(128
					(if (> (param1 y:) 131) 27 else 0)
				)
				(512
					(if (> (param1 x:) 176)
						(= local3 2)
						31
					else
						(= local3 2)
						24
					)
				)
				(1024
					(if (> (param1 x:) 98)
						(= local3 3)
						30
					else
						19
					)
				)
				(8192 19)
				(else 0)
			)
		)
		(return noun)
	)

	(method (doVerb theVerb &tmp [temp0 40])
		(if
			(or
				(and
					(== (gKq6ApproachCode doit: theVerb) -32768)
					(& local3 $0002)
					(or (= theVerb 0) 1)
				)
				(and (== theVerb 5) (& local3 $0001)) ; Do
			)
			(gMessager say: 27 theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

