;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 561)
(include sci.sh)
(use Main)
(use n013)
(use TheDungeon)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use FlipPoly)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	tunnel2 0
)

(local
	[local0 7] = [1561 0 1 2 1 1 0]
	[local7 4] = [1561 4 1 0]
	[local11 5] = [1561 5 1 2 0]
	[local16 4] = [1561 7 1 0]
	[local20 4] = [1561 8 1 0]
	[local24 6] = [1561 25 1 2 1 0]
	[local30 9] = [1561 28 1 2 1 1 2 1 0]
	local39
	local40
	local41
	local42
	[local43 3] = [-1 {Hal} 11]
	[local46 3] = [-1 {Hob} 12]
	[local49 3] = [-1 {Dicken} 13]
)

(procedure (localproc_0)
	(SetMessageColor 11)
	(Say &rest 80 {Hal})
)

(procedure (localproc_1)
	(SetMessageColor 12)
	(Say &rest 80 {Hob})
)

(procedure (localproc_2)
	(SetMessageColor 13)
	(Say &rest 80 {Dicken})
)

(instance tunnel2 of Rm
	(properties
		picture 561
		style -32758
	)

	(method (init)
		(gTheIconBar disable: 5)
		(= local42 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(= local39 1)
		(DoSound sndGLOBAL_REVERB 20)
		(if (== gDisguiseNum 5) ; abbey monk
			(NormalEgo 2 23 24)
		else
			(NormalEgo)
		)
		(HandsOn)
		(if (or (== gPrevRoomNum 562) (== gPrevRoomNum 460)) ; tunnel3
			(= style -16374)
			(= local41 1)
			(SetFlag 105)
			(if (and (!= gDay 10) (or (IsFlag 125) (IsFlag 56)))
				(sonHal setLoop: 4 posn: 18 175 init:)
				(sonHob setLoop: 2 posn: 77 167 init:)
				(sonDicken setLoop: 0 posn: 130 155 init:)
			)
			(switch gPrevRoomNum
				(562 ; tunnel3
					(if (or (IsFlag 125) (IsFlag 56))
						(gEgo posn: 130 166 init: setHeading: 180 self)
					else
						(gEgo loop: 3 posn: 90 170 init:)
					)
				)
				(460
					(gEgo loop: 2 posn: 237 134 init:)
				)
				(else
					(gEgo posn: 235 130 init:)
				)
			)
			(theTapestry approachVerbs: 3 init: stopUpd:) ; Do
		else
			(= local40 1)
			(SetFlag 106)
			(if (and (!= gDay 10) (or (IsFlag 125) (IsFlag 56)))
				(sonHal loop: 3 posn: 159 178 init: setCycle: Walk)
				(sonHob loop: 1 posn: 190 179 init: setCycle: Walk)
				(sonDicken loop: 1 posn: 223 185 init: setCycle: Walk)
			)
			(switch gPrevRoomNum
				(570
					(gEgo posn: 175 155 init:)
					(if (or (IsFlag 125) (IsFlag 56))
						(TheDungeon timerHasFired: 1)
						(TheDungeon longTimerGone: 1)
						(TheDungeon guardsGone: 0)
					else
						((ScriptID 564 1) seconds: 0 state: 1) ; shortTimer
						((ScriptID 564 3) seconds: 0 state: 1) ; warningTimer
						(if (not ((ScriptID 564 2) seconds:)) ; longTimer
							(TheDungeon guardsGone: 0)
						)
					)
					(gCurRoom setScript: call565Scpt)
				)
				(560 ; tunnel1
					(gGame setCursor: 0 1 10 25)
					(if (or (IsFlag 125) (IsFlag 56))
						(gEgo
							posn: 200 170
							init:
							setMotion: PolyPath 150 160 self
						)
					else
						(gEgo posn: 247 180 init:)
					)
				)
				(else
					(gGame setCursor: 0 1 10 25)
					(gEgo posn: 166 165 init:)
				)
			)
			(theDoor approachVerbs: 3 init: stopUpd:) ; Do
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 180 258 169 224 162 217 157 202 156 167 151 159 144 157 145 135 143 102 133 67 133 78 146 102 164 122 164 154 178 179 181 212 189 0 189
					yourself:
				)
		)
		(AddToFeatures westWallArea eastWallArea endWallArea floorArea)
		(if (or (== gPrevRoomNum 562) (== gPrevRoomNum 460)) ; tunnel3
			(FlipFeature)
			(FlipPoly)
		)
		(if (or (== gPrevRoomNum 560) (== gPrevRoomNum 570)) ; tunnel1
			(cond
				((or (== gDay 5) (== gDay 6))
					(if (or (IsFlag 125) (IsFlag 56))
						(gCurRoom setScript: westTunnelDay5_6)
					)
				)
				(
					(and
						(or (== gDay 5) (== gDay 6))
						(or (IsFlag 125) (IsFlag 56))
						(== gPrevRoomNum 570)
					)
					(cond
						((TheDungeon coinsLeft:)
							(gCurRoom setScript: afterCoinLeft)
						)
						((or (IsFlag 125) (IsFlag 56))
							(gCurRoom setScript: comeWithSons570)
						)
					)
				)
			)
		)
		(if (or (== gPrevRoomNum 562) (== gPrevRoomNum 460)) ; tunnel3
			(cond
				((and (== gPrevRoomNum 460) (IsFlag 114))
					(cond
						((or (IsFlag 125) (IsFlag 56))
							(gCurRoom setScript: hurryFrom460)
						)
						((or (== gDay 5) (== gDay 6))
							(Say 1561 10 1) ; "Methinks the Abbey is no longer a wise place to visit."
						)
					)
				)
				(
					(and
						(or (== gDay 5) (== gDay 6))
						(or (IsFlag 125) (IsFlag 56))
					)
					(gCurRoom setScript: mirrorTunnelDay5_6)
				)
			)
		)
		(if (!= (gRgnMusic number:) 560)
			(gRgnMusic number: 560 loop: -1 play:)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local42)
		(super dispose:)
		(DoSound sndGLOBAL_REVERB 0)
		(DisposeScript 971)
	)

	(method (doit)
		(if
			(and
				(or
					(>= (gEgo y:) 189)
					(<= (gEgo x:) 0)
					(>= (gEgo x:) 319)
				)
				(not (gEgo script:))
			)
			(gEgo setScript: goToTunnels)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Say 1561 11 1) ; "It would serve no purpose to loose an arrow here."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonHal of Actor
	(properties
		view 434
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1561 34 1) ; "They're good, brave lads, all three."
			)
			(3 ; Do
				(Say 1561 47 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(5 ; Talk
				(localproc_0 1561 12 self) ; "Even in whispers, it's not a safe place for talk."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_0 1561 13 self) ; "We could never repay what we owe you now. I couldn't accept any more."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_0 1561 14 self) ; "You've freed us from the dungeon, Robin.  We're too deeply in your debt to accept gifts."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_0 1561 14 self) ; "You've freed us from the dungeon, Robin.  We're too deeply in your debt to accept gifts."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(localproc_0 1561 15 self) ; "Nay, I could not take it."
						(SetMessageColor 0)
					)
					(18 ; waterRing
						(localproc_0 1561 16 self) ; "Please, I owe you too much to take gifts."
						(SetMessageColor 0)
					)
					(10 ; fireRing
						(localproc_0 1561 16 self) ; "Please, I owe you too much to take gifts."
						(SetMessageColor 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonHob of Actor
	(properties
		view 434
		loop 1
		cel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1561 34 1) ; "They're good, brave lads, all three."
			)
			(3 ; Do
				(Say 1561 47 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(5 ; Talk
				(localproc_1 1561 17 self) ; "We'd best keep quiet."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_1 1561 18 self) ; "Nay, you've done enough for us."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_1 1561 19 self) ; "I couldn't accept it."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_1 1561 19 self) ; "I couldn't accept it."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(localproc_1 1561 20 self) ; "I've no idea how to open such a thing."
						(SetMessageColor 0)
					)
					(18 ; waterRing
						(localproc_1 1561 21 self) ; "This is too fine for me. I owe you too much already."
						(SetMessageColor 0)
					)
					(10 ; fireRing
						(localproc_1 1561 21 self) ; "This is too fine for me. I owe you too much already."
						(SetMessageColor 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonDicken of Actor
	(properties
		view 434
		cel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1561 34 1) ; "They're good, brave lads, all three."
			)
			(3 ; Do
				(Say 1561 47 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(5 ; Talk
				(localproc_2 1561 22 self) ; "I won't make a sound."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_2 1561 23 self) ; "Thank you, but Hal will wallop me if I take it."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_2 1561 24 self) ; "Thank you, but Mum would wallop me for taking something I haven't earned."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_2 1561 24 self) ; "Thank you, but Mum would wallop me for taking something I haven't earned."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(gCurRoom setScript: dickenPuzBoxTalk)
					)
					(18 ; waterRing
						(gCurRoom setScript: waterOrFireRingTalk)
					)
					(10 ; fireRing
						(gCurRoom setScript: waterOrFireRingTalk)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cannotUsePuzbox of SpecialDoVerb ; UNUSED
	(properties)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(1 ; horn
					(Say 1561 46 1) ; "I dare not wind my horn here."
				)
			)
		)
	)
)

(instance theDoor of Prop
	(properties
		x 97
		y 124
		approachX 80
		approachY 134
		view 561
		signal 16388
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Look
				(= temp0 (User curEvent:))
				(if (and (> 76 (temp0 x:) 60) (> 92 (temp0 y:) 76))
					(gCurRoom setScript: call565Scpt)
				else
					(gEgo setHeading: 0)
					(if (== local40 1)
						(Say 1561 35 1) ; "I see a tiny peephole in the center of the door."
						(= local40 0)
					else
						(Say 1561 36 1) ; "It's the secret door to the dungeon."
					)
				)
			)
			(3 ; Do
				(gEgo setMotion: PolyPath 80 134 self)
				(gCurRoom setScript: openDoorGoto570)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theTapestry of Prop
	(properties
		x 261
		y 122
		approachX 239
		approachY 134
		view 561
		loop 1
		priority 9
		signal 16404
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (and (== local41 1) (not (IsFlag 29)))
					(Say 1561 37 1) ; "A heavy tapestry covers this doorway upon the other side."
					(= local41 0)
				else
					(Say 1561 38 1) ; "It's the back of the Abbey tapestry."
				)
			)
			(3 ; Do
				(if (and (== gDisguiseNum 5) (or (IsFlag 125) (IsFlag 56))) ; abbey monk
					(self setScript: moveTapestryTo460)
				else
					(gRgnMusic fade: 0 20 12 1)
					(gCurRoom newRoom: 460)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westWallArea of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 0 86 0 86 36 56 38 45 45 33 61 31 80 33 94 37 101 37 115 37 123 62 133 73 147 75 152 88 158 96 167 102 169 119 167 136 172 165 184 189 181 214 189 0 189
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1561 39 1) ; "Sandstone, of course."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(DoSound sndGLOBAL_REVERB 0)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance eastWallArea of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 87 0 319 0 319 173 212 153 102 128 113 120 121 91 127 75 109 47 98 38 87 36
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1561 39 1) ; "Sandstone, of course."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance endWallArea of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 40 100 35 94 34 81 35 65 39 58 46 48 55 43 66 41 90 40 107 48 112 58 123 73 122 86 117 94 112 117 107 121 98 121 98 63 57 62 58 121 40 120
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== local39 1)
					(if (or (== gPrevRoomNum 560) (== gPrevRoomNum 570)) ; tunnel1
						(Say 1561 40) ; "After quite a climb upwards, the tunnel has ended at a stone wall with a door in it."
						(Say 1561 41 1) ; "Unless my reckoning fails me, this would be about the dungeon level of the castle."
					)
					(if (or (== gPrevRoomNum 562) (== gPrevRoomNum 460)) ; tunnel3
						(Say 1561 42 1) ; "The tunnel ends at a door-like opening covered by some kind of heavy material upon the other side."
					)
					(= local39 0)
				else
					(if (or (== gPrevRoomNum 560) (== gPrevRoomNum 570)) ; tunnel1
						(Say 1561 43 1) ; "It's the back of the dungeon wall."
					)
					(if (or (== gPrevRoomNum 562) (== gPrevRoomNum 460)) ; tunnel3
						(Say 1561 44 1) ; "It's the hidden entrance to the refectory"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance floorArea of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 66 133 101 131 132 139 159 144 193 152 231 160 266 169 319 178 319 189 221 189 190 180 166 182 133 169 120 165 101 167 86 153 75 149
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1561 45 1) ; "The floor of the tunnel is worn sandstone."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance call565Scpt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 70 133 self)
			)
			(2
				(gEgo setHeading: 0)
				(= ticks 12)
			)
			(3
				((ScriptID 565) doit:) ; peephole
				(self cue:)
			)
			(4
				(HandsOn)
				(gGame setCursor: 0 1 10 25)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance goToTunnels of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(if (< (gEgo x:) 160)
							(- (gEgo x:) 10)
						else
							(+ (gEgo x:) 10)
						)
						240
						self
				)
			)
			(1
				(if (< (gEgo x:) 160)
					(gCurRoom newRoom: 562) ; tunnel3
				else
					(gCurRoom newRoom: 560) ; tunnel1
				)
			)
		)
	)
)

(instance openDoorGoto570 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(theDoor setCycle: End self)
			)
			(2
				(theDoor stopUpd:)
				(doorSound play:)
				(HandsOn)
				(gCurRoom newRoom: 570)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance moveTapestryTo460 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 7)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(Converse 1 @local20 9 0 self) ; "Wait here while I see how things are faring in the Abbey."
			)
			(3
				(gEgo setHeading: 0 self)
			)
			(4
				(HandsOn)
				(gRgnMusic fade: 0 20 12 1)
				(gCurRoom newRoom: 460)
				(self dispose:)
			)
		)
	)
)

(instance westTunnelDay5_6 of Script
	(properties
		name {westTunnelDay5&6}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 127 154 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(if (!= gPrevRoomNum 570)
					(Converse 2 @local11 @local46 1 9 0 self) ; "Your pardon, but we've no wish to go closer."
				else
					(= ticks 6)
				)
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance mirrorTunnelDay5_6 of Script
	(properties
		name {mirrorTunnelDay5&6}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 169 161 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(Converse 1 @local16 9 0 self) ; "Wait here. Make no sound."
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance comeWithSonsFrom560 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sonHal loop: 3 posn: 293 189 init: setCycle: Walk)
				(sonHob loop: 3 posn: 267 189 init: setCycle: Walk)
				(sonDicken loop: 3 posn: 241 188 init: setCycle: Walk)
			)
			(1
				(gEgo setMotion: PolyPath 142 157 self)
				(sonDicken setMotion: PolyPath 156 176)
				(sonHob setMotion: PolyPath 179 179)
				(sonHal setMotion: PolyPath 211 188)
			)
			(2
				(gEgo setHeading: 180 self)
				(sonDicken setHeading: 0)
				(sonHob setHeading: 0)
				(sonHal setHeading: 0)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance comeWithSons570 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 185 168 self)
			)
			(1
				(Converse 2 @local0 9 0 @local43 2 self) ; "With luck, it'll be some time before the guards discover your absence."
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance hurryFrom460 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor 1)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 120 170 self)
			)
			(2
				(localproc_0 1561 9 self) ; "What--"
				(SetMessageColor 0)
			)
			(3
				(Converse 1 @local7 9 0 self) ; "Shhhh! Follow me!"
			)
			(4
				(gEgo setMotion: PolyPath 50 195 self)
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 5)
				(gCurRoom newRoom: 562) ; tunnel3
			)
		)
	)
)

(instance afterCoinLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 80 134)
				(= cycles 10)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5)
				((ScriptID 565) doit:) ; peephole
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance dickenPuzBoxTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(Converse 2 @local24 @local49 0 @local43 1 self) ; "What a wondrous box! Hal,  may I?"
			)
			(2
				(HandsOn)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance waterOrFireRingTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(Converse 2 @local30 @local49 0 @local43 1 self) ; "I like rings--"
			)
			(2
				(HandsOn)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		flags 1
		number 503
	)
)

