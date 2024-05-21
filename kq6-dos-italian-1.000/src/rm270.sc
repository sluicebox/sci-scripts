;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use KQ6Print)
(use KQ6Room)
(use CartoonScript)
(use n913)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
	bookStand 1
	shopOwner 2
	clownBook 3
	shopDoor 4
	clownChair 5
	spellBook 6
	proc270_7 7
)

(local
	[local0 32] = [268 160 -4095 4 151 168 -4095 6 141 164 -4095 4 -4094 133 160 43 152 -4095 6 -4094 37 148 34 116 -4095 4 -4094 29 110 -7 114 -4092]
	[local32 13] = [182 28 -4095 8 160 14 -4088 -4094 171 18 101 -4 -4092]
	[local45 15] = [16 36 -4095 7 14 72 -4095 5 48 69 -4095 4 -5 69 -4092]
	[local60 10] = [64 -4 -4095 9 96 17 128 -4 -4092 0]
	[local70 32] = [129 123 119 133 102 133 85 138 59 148 84 165 112 178 315 178 303 166 254 166 286 132 314 132 314 121 207 119 168 119 152 114]
	[local102 30] = [129 123 119 133 102 133 85 138 59 148 84 165 112 178 315 178 303 166 254 166 286 132 314 132 314 121 207 119 152 114]
	local132
	local133 = -1
	local134
)

(procedure (localproc_0 param1)
	(if param1
		(gCurRoom
			addObstacle: (roomPoly type: PContainedAccess points: @local70 size: 16 yourself:)
		)
	else
		(gCurRoom
			addObstacle: (roomPoly type: PContainedAccess points: @local102 size: 15 yourself:)
		)
	)
)

(procedure (proc270_7 param1)
	(if (shopOwner script:)
		(shopOwnerScr caller: param1)
		(if (== (shopOwnerScr state:) 0)
			(shopOwnerScr dispose:)
		)
	else
		(param1 cue:)
	)
)

(instance rm270 of KQ6Room
	(properties
		noun 15
		picture 270
		autoLoad 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 231 124 247 129 197 136 180 132 180 123
					yourself:
				)
		)
		(super init: &rest)
		(gEgo init: posn: 92 144 reset: 0 setScale: Scaler 108 83 170 113)
		(gFeatures
			add:
				genericFeatures
				poemShelf
				clownChair
				readingTable
				bookStand
				shelfFeatures
				frontCounter
			eachElementDo: #init
		)
		(fire setCycle: Fwd init:)
		(shopDoor init: setCycle: Beg shopDoor)
		(if (== ((gInventory at: 45) owner:) gCurRoomNum) ; spellBook
			(spellBook init:)
		)
		(if (not (OneOf ((gInventory at: 1) owner:) gEgo -1)) ; boringBook
			((ScriptID 273 0) init:) ; boringBook
		)
		(shopOwner init:)
		(if (not (IsFlag 27))
			(ClearFlag 54)
			(SetFlag 53)
		)
		(cond
			((not (IsFlag 16))
				(SetFlag 27)
				((ScriptID 271 0) init:) ; bookShopGenie
				(= local132 1)
				(clownBook init:)
			)
			(
				(and
					(IsFlag 16)
					(== gAct 1)
					(not (IsFlag 26))
					(IsFlag 54)
				)
				(SetFlag 26)
				((ScriptID 274 0) init:) ; clown
				(ClearFlag 54)
				(SetFlag 53)
			)
			(
				(or
					(and
						(== gAct 1)
						(IsFlag 26)
						(IsFlag 53)
						(not (IsFlag 54))
					)
					(and
						(== gAct 2)
						(not (IsFlag 54))
						(not (IsFlag 10))
					)
					(and (not (IsFlag 54)) (OneOf gAct 3 4))
				)
				((ScriptID 274 0) init:) ; clown
				(if (and (IsFlag 10) (OneOf gAct 3 4))
					(gCurRoom setScript: (ScriptID 277 1)) ; talkClownFriendScr
				)
			)
			(else
				(clownBook init:)
			)
		)
		(if (not (gCurRoom script:))
			(if (not ((ScriptID 10 0) isSet: 64)) ; rgCrown
				((ScriptID 10 0) setIt: 64) ; rgCrown
				(gCurRoom setScript: ownerFromCounterScr)
			else
				(gCurRoom setScript: ownerNotAtCounterScr)
			)
		)
		(if (not (gCast contains: clownBook))
			(gGlobalSound number: 780 loop: -1 play:)
		)
		(SetFlag 27)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
		(localproc_0 local132)
	)

	(method (scriptCheck param1 &tmp temp0)
		(= temp0 1)
		(if ((ScriptID 10 0) isSet: 2) ; rgCrown
			((ScriptID 10 0) clrIt: 2) ; rgCrown
		)
		(switch param1
			(87
				(gMessager say: 0 0 14 0 0 899) ; "Alexander doesn't know what that potion might do, and the book shop owner seems a bit timid for a fright!"
				(= temp0 0)
			)
			(190
				(= temp0 1)
			)
		)
		(return temp0)
	)

	(method (dispose)
		(if (== (gGlobalSound number:) 240)
			((ScriptID 10 0) setIt: 512) ; rgCrown
			(gGlobalSound fade: 127 15 15 0)
		else
			(gGlobalSound fade:)
		)
		(super dispose:)
		(DisposeScript 923)
		(DisposeScript 11)
		(DisposeScript 271)
		(DisposeScript 272)
		(DisposeScript 273)
		(DisposeScript 274)
		(DisposeScript 276)
	)
)

(instance spider of Actor
	(properties
		noun 22
		view 270
		loop 4
		priority 15
		signal 2064
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
	)
)

(instance spiderScr of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0 [temp1 40])
		(switch (= state newState)
			(0
				(= local133 -1)
				(= local134
					(switch (Random 0 3)
						(0 @local0)
						(1 @local32)
						(2 @local45)
						(3 @local60)
					)
				)
				(spider
					posn:
						(WordAt local134 (++ local133))
						(WordAt local134 (++ local133))
				)
				(= cycles 2)
			)
			(1
				(switch (= temp0 (WordAt local134 (++ local133)))
					(-4088
						(spider setScale: 0)
					)
					(-4095
						(spider setLoop: (WordAt local134 (++ local133)))
						(-- state)
						(= cycles 1)
					)
					(-4094
						(spider
							posn:
								(WordAt local134 (++ local133))
								(WordAt local134 (++ local133))
						)
						(-- state)
						(= cycles 1)
					)
					(-4092
						(++ state)
						(= ticks 1)
					)
					(else
						(spider
							cycleSpeed: (Random 3 8)
							moveSpeed: (Random 3 8)
							setMotion:
								MoveTo
								temp0
								(WordAt local134 (++ local133))
								self
						)
					)
				)
			)
			(2
				(= state 0)
				(if (not (Random 0 1))
					(= seconds (Random 3 5))
				else
					(= cycles 1)
				)
			)
			(3
				(spider hide:)
				(= seconds (Random 5 20))
			)
			(4
				(spider show:)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance exitShopScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setHeading: 315 self)
				(proc270_7 self)
			)
			(2 0)
			(3
				(if (not (< (shopOwner y:) 145))
					(shopOwner view: 277 loop: 2 cel: 0 setCycle: End)
				)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(shopDoor setCycle: End self)
			)
			(4
				(shopDoor setPri: 15)
				(gEgo setMotion: MoveTo 70 142 self)
			)
			(5
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance clownChairScr of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 6
					normal: 0
					posn: 205 133
					view: 2711
					loop: 0
					cel: 0
					scaleX: 128
					scaleY: 128
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(gMessager say: 14 5 20 1 self) ; "Alexander rests his feet for a moment."
			)
			(2
				(KQ6Print
					font: gUserFont
					modeless: 1
					ticks: 20
					posn: -1 10
					say: 0 14 5 20 2 ; "Alexander picks up and leafs idly through a book called "The Changing Role of Court Entertainers Through the Ages.""
					init: self
				)
				(= cycles 1)
			)
			(3
				(gEgo loop: 3 cel: 0 setCycle: CT 1 1 self)
			)
			(4
				(clownBook dispose:)
				(= cycles 2)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo setSpeed: 6 loop: 1 cel: 0 setCycle: End self)
			)
			(7
				(= seconds 4)
			)
			(8
				(gEgo cel: 0 setCycle: End self)
			)
			(9
				(= seconds 2)
			)
			(10
				(if gModelessDialog
					(KQ6Print caller: self)
				else
					(self cue:)
				)
			)
			(11
				(gEgo loop: 3 cel: 2 setCycle: CT 1 -1 self)
			)
			(12
				(clownBook init:)
				(= cycles 2)
			)
			(13
				(gEgo setCycle: Beg self)
			)
			(14
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(15
				(gEgo reset: 4 posn: 207 133 setScale: Scaler 108 83 170 113)
				(= cycles 2)
			)
			(16
				(gMessager say: 14 5 20 3 self) ; "Well, that was refreshing."
			)
			(17
				(UnLoad 128 2711)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance randomConvScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc270_7 self)
			)
			(1
				(gMessager say: 18 2 23 1 self) ; "How fare you, merchant?"
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 18 2 24 (Random 1 5) self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boringBookDoScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc270_7 self)
			)
			(1
				(gMessager say: 18 42 0 1 self) ; "Might I return this?"
			)
			(2
				(gMessager say: 18 register 0 0 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ownerNotAtCounterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (shopDoor cycler:)
					((shopDoor cycler:) caller: self)
				else
					(+= state 2)
					(self cue:)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(shopDoor stopUpd:)
				(gGlobalSound4 number: 902 loop: 1 play: self)
			)
			(4
				(gMessager say: 19 0 36 0 self) ; "Good day, again! How may I help you?"
			)
			(5
				(shopOwner setScript: shopOwnerScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ownerFromCounterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 270 2) ; shopOwner
					view: 276
					loop: 0
					cel: 0
					setPri: 1
					posn: 290 134
				)
				(= cycles 2)
			)
			(1
				(if (shopDoor cycler:)
					((shopDoor cycler:) caller: self)
				else
					(self cue:)
				)
			)
			(2
				(gGlobalSound4 number: 902 loop: 1 play:)
				((ScriptID 270 2) setCycle: End self) ; shopOwner
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 18 2 25 1 self) ; "Hello. I will be right up."
			)
			(5
				(= ticks 150)
			)
			(6
				((ScriptID 270 2) ; shopOwner
					posn: 290 138
					loop: 1
					cel: 0
					setPri: 8
					setCycle: End self
				)
			)
			(7
				((ScriptID 270 2) ; shopOwner
					posn: 288 140
					loop: 2
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(8
				((ScriptID 270 2) setPri: 12 setCycle: End self) ; shopOwner
			)
			(9
				(= cycles 2)
			)
			(10
				((ScriptID 270 2) ; shopOwner
					loop: 3
					cel: 0
					posn: 303 151
					setCycle: End self
				)
			)
			(11
				(= cycles 2)
			)
			(12
				((ScriptID 270 2) ; shopOwner
					view: 277
					loop: 2
					cel: 0
					setScript: shopOwnerScr
				)
				(= cycles 2)
			)
			(13
				(gMessager say: 18 2 25 2 self) ; "Now! What can I do for you?"
				(= cycles 1)
			)
			(14
				(UnLoad 128 276)
				((ScriptID 270 2) stopUpd:) ; shopOwner
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shopOwnerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(shopOwner
					view: 277
					loop: 0
					cel: 0
					posn: 297 159
					setCycle: End self
				)
			)
			(2
				(= ticks 20)
			)
			(3
				(shopOwner loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 20)
			)
			(5
				(shopOwner cel: 0 setCycle: End self)
			)
			(6
				(= ticks 20)
			)
			(7
				(shopOwner setCycle: Beg self)
			)
			(8
				(shopOwner loop: 1 cel: (shopOwner lastCel:) setCycle: Beg self)
			)
			(9
				(shopOwner view: 277 loop: 2 cel: 0 posn: 303 151)
				(= cycles 2)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance genericTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc270_7 self)
			)
			(1
				(gMessager say: 18 2 register 0 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shopOwner of Actor
	(properties
		x 303
		y 151
		noun 18
		sightAngle 40
		approachX 266
		approachY 151
		view 277
		loop 2
		priority 12
		signal 20497
	)

	(method (doVerb theVerb)
		(if ((ScriptID 10 0) isSet: 2) ; rgCrown
			((ScriptID 10 0) clrIt: 2) ; rgCrown
		)
		(switch theVerb
			(2 ; Talk
				(cond
					((not (IsFlag 64))
						(SetFlag 64)
						(SetFlag 73)
						(gCurRoom setScript: genericTalkScr 0 26)
					)
					((and (not (IsFlag 16)) (IsFlag 73))
						(gGame givePoints: 1)
						(SetFlag 16)
						(ClearFlag 54)
						(SetFlag 53)
						(gCurRoom setScript: (ScriptID 276 3)) ; talkAfterLLoc
					)
					((not (IsFlag 16))
						(SetFlag 16)
						(gGame givePoints: 1)
						(gCurRoom setScript: genericTalkScr 0 22)
					)
					(else
						(gCurRoom setScript: randomConvScr)
					)
				)
			)
			(27 ; riddleBook
				(gCurRoom setScript: (ScriptID 276 1)) ; giveRareBookScr
			)
			(else
				(if (OneOf theVerb 28 32) ; spellBook, poem
					(gCurRoom setScript: boringBookDoScr 0 theVerb)
				else
					(if (== theVerb 67) ; peppermint
						(= theVerb 63) ; mint
					)
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (init param1)
		(super init: &rest)
		(self approachVerbs: 2 27) ; Talk, riddleBook
	)
)

(instance shopDoor of Prop
	(properties
		x 69
		y 90
		noun 17
		approachX 80
		approachY 142
		view 270
		cel 4
	)

	(method (cue)
		(self stopUpd:)
		(gGlobalSound4 number: 902 loop: 1 play:)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: exitShopScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 225
		y 105
		noun 8
		view 270
		loop 1
		signal 16384
		detailLevel 1
	)
)

(instance bookStand of Feature
	(properties
		x 113
		y 131
		noun 2
		nsTop 116
		nsLeft 99
		nsBottom 132
		nsRight 123
		sightAngle 40
		approachX 112
		approachY 137
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(if (== (param1 message:) 1)
				(= approachX 134)
				(= approachY 129)
			else
				(= approachX 112)
				(= approachY 137)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== ((gInventory at: 1) owner:) gCurRoomNum) ; boringBook
					(gMessager say: 2 1 4) ; "There's a small table near the door that bears a sign. The sign has undergone a number of changes. It once read "10 pence," but that was crossed out and replaced with "5 pence," then "1 pence," then "free." The sign currently reads "Take one, PLEASE.""
				else
					(KQ6Print
						font: gUserFont
						posn: -1 10
						say: 0 noun theVerb 4 1 ; "There's a small table near the door that bears a sign. The sign has undergone a number of changes. It once read "10 pence," but that was crossed out and replaced with "5 pence," then "1 pence," then "free." The sign currently reads "Take one, PLEASE.""
						init:
					)
					(KQ6Print
						font: gUserFont
						posn: -1 10
						say: 0 noun theVerb 3 1 ; "The table is now empty."
						init:
					)
				)
			)
			(5 ; Do
				(if (!= ((gInventory at: 1) owner:) gCurRoomNum) ; boringBook
					(gMessager say: noun theVerb 3) ; "The table is empty."
				else
					(gCurRoom setScript: (ScriptID 273 1)) ; takeBoringBookScr
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 5) ; Look, Do
	)
)

(instance poemShelf of Feature
	(properties
		x 302
		y 90
		noun 13
		onMeCheck 4096
		approachX 302
		approachY 124
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: (ScriptID 272 0)) ; poemShelfScr
			)
			(else
				(if (or (== theVerb 2) (not (OneOf theVerb 5 1))) ; Talk, Do, Look
					(if (!= theVerb 2) ; Talk
						(= theVerb 0)
					)
					(gMessager say: 4 theVerb)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 1) ; Do, Look
	)
)

(instance shelfFeatures of Feature
	(properties
		sightAngle 40
	)

	(method (onMe param1)
		(if _approachVerbs
			(= _approachVerbs 0)
		)
		(return
			(= noun
				(switch (OnControl CONTROL (param1 x:) (param1 y:))
					(512
						(= x 162)
						(= y 113)
						(= approachX 159)
						(= approachY 119)
						(self approachVerbs: 5 1) ; Do, Look
						4
					)
					(1024
						(= x 186)
						(= y 110)
						(= approachX 192)
						(= approachY 121)
						(self approachVerbs: 5 1) ; Do, Look
						20
					)
					(2048
						(= x 265)
						(= y 116)
						(= approachX 266)
						(= approachY 121)
						(self approachVerbs: 5 1) ; Do, Look
						16
					)
					(256
						(= x 134)
						(= y 118)
						(= approachX 142)
						(= approachY 121)
						(self approachVerbs: 5 1) ; Do, Look
						11
					)
					(else 0)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 2) (not (OneOf theVerb 5 1))) ; Talk, Do, Look
			(= noun 4)
			(if (!= theVerb 2) ; Talk
				(= theVerb 0)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance genericFeatures of Feature
	(properties
		sightAngle 40
	)

	(method (onMe param1)
		(return
			(= noun
				(switch (OnControl CONTROL (param1 x:) (param1 y:))
					(32
						(= x 225)
						(= y 118)
						3
					)
					(64
						(= x 125)
						(= y 115)
						21
					)
					(4
						(= x 223)
						(= y 117)
						7
					)
					(128
						(= x 72)
						(= y 141)
						12
					)
					(else 0)
				)
			)
		)
	)
)

(instance frontCounter of Feature
	(properties
		x 281
		y 139
		z -10
		noun 5
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager
				say: 5 1 (if (== ((gInventory at: 45) owner:) gCurRoomNum) 6 else 5) ; spellBook
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance clownChair of Feature
	(properties
		x 215
		y 131
		noun 14
		sightAngle 40
		onMeCheck 16392
		approachX 217
		approachY 134
	)

	(method (onMe param1 &tmp temp0 temp1)
		(if (= temp0 (super onMe: param1 &rest))
			(= temp1 (OnControl CONTROL (param1 x:) (param1 y:)))
			(cond
				((and (== (param1 message:) 5) (== temp1 16384))
					(= temp0 0)
				)
				(
					(and
						(== (param1 message:) 5)
						(not (gCast contains: (ScriptID 274 0))) ; clown
						(== temp1 8)
					)
					(self approachVerbs: 5) ; Do
				)
				(else
					(= _approachVerbs 0)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(gCast contains: (ScriptID 274 0)) ; clown
						(not (gCast contains: clownBook))
					)
					(gMessager say: noun theVerb 19) ; "The chair is already occupied."
				else
					(gCurRoom setScript: clownChairScr)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

(instance clownBook of View
	(properties
		x 227
		y 129
		z 10
		approachX 227
		approachY 132
		view 270
		loop 2
		cel 2
		priority 9
		signal 16401
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(if
				(and
					(not (gCast contains: (ScriptID 274 0))) ; clown
					(or (== (param1 message:) 5) (== (param1 message:) 1))
				)
				(self approachVerbs: 5 1) ; Do, Look
				(if (== (param1 message:) 5)
					(= approachX 217)
					(= approachY 134)
				else
					(= approachX 227)
					(= approachY 132)
				)
			else
				(= _approachVerbs 0)
			)
		)
		(return temp0)
	)

	(method (doVerb)
		(readingTable doVerb: &rest)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1) ; Look
	)
)

(instance readingTable of Feature
	(properties
		x 227
		y 129
		noun 23
		onMeCheck 8192
		approachX 227
		approachY 132
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(if
				(and
					(not (gCast contains: (ScriptID 274 0))) ; clown
					(or (== (param1 message:) 5) (== (param1 message:) 1))
				)
				(self approachVerbs: 5 1) ; Do, Look
				(if (== (param1 message:) 5)
					(= approachX 217)
					(= approachY 134)
				else
					(= approachX 227)
					(= approachY 132)
				)
			else
				(= _approachVerbs 0)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gCast contains: (ScriptID 274 0)) ; clown
					(gMessager say: noun theVerb 37) ; "The small table in the reading area is currently empty."
				else
					(gMessager say: noun theVerb 38) ; "There's a book entitled "The Changing Role of Court Entertainers Through the Ages" on the small table in the reading area. It appears that some regular customer likes that book."
				)
			)
			(else
				(clownChair doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1) ; Look
	)
)

(instance spellBook of View
	(properties
		x 294
		y 150
		z 15
		noun 1
		view 270
		loop 3
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 7)
					(gMessager say: noun theVerb 2) ; "How might I obtain that spell book again?"
				else
					(SetFlag 7)
					(gGame givePoints: 2)
					(gMessager say: noun theVerb 1) ; "How much for that book on the counter, merchant?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			approachX: (shopOwner approachX:)
			approachY: (shopOwner approachY:)
			approachVerbs: 5 ; Do
		)
	)
)

(instance roomPoly of Polygon
	(properties)
)

