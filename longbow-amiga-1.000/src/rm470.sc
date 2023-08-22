;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use StdRoom)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm470 0
)

(local
	[local0 4] = [1470 26 1 0]
	[local4 12] = [1470 33 1 2 1 2 1 2 1 2 1 0]
	[local16 6] = [1470 43 1 1 1 0]
	[local22 5] = [1470 56 1 1 0]
	[local27 8] = [113 117 213 137 94 168 8 139]
	[local35 12] = [5 164 7 146 17 143 47 153 47 172 28 176]
	[local47 18] = [138 126 136 114 129 113 126 103 153 93 158 107 173 109 173 126 154 129]
	[local65 14] = [295 117 294 155 277 161 277 151 253 150 248 133 265 114]
	[local79 8] = [261 123 284 125 278 135 252 133]
	[local87 22] = [102 122 83 120 105 113 145 120 139 125 151 130 148 141 143 132 128 127 104 130 91 129]
	local109
	local110
)

(instance rm470 of StdRoom
	(properties
		picture 470
		south 450
	)

	(method (init)
		(= local109 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(if (== gPrevRoomNum 450)
			(gEgo x: 70)
			(gEgo edgeHit: EDGE_TOP)
		)
		(super init: 0 3)
		(if (and script (not (IsFlag 202)))
			(script next: firstMess)
		)
		(fireSound play:)
		(fire init: setCycle: Fwd)
		(pillow init:)
		(pillowL init:)
		(pillowM init:)
		(rugPol points: @local27)
		(lChstPol points: @local35)
		(rChstPol points: @local47)
		(DeskPol points: @local65)
		(BookPol points: @local79)
		(SkinPol points: @local87)
		(rope init:)
		(bCurtains init:)
		(bTape init:)
		(table init:)
		(chair init:)
		(windows init:)
		(fTape init:)
		(skin onMeCheck: SkinPol init:)
		(bed init: approachVerbs: 3) ; Do
		(rug onMeCheck: rugPol init:)
		(lChest onMeCheck: lChstPol init: approachVerbs: 3) ; Do
		(rChest onMeCheck: rChstPol init: approachVerbs: 3) ; Do
		(book onMeCheck: BookPol init:)
		(desk onMeCheck: DeskPol init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 308 152 307 157 254 173 222 162 222 157 260 141
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 313 137 156 117 151 118 187 125 158 131 111 121 108 122 191 139 115 161 34 136 0 152 0 163 24 159 60 171 29 179 6 173 6 189 84 189 87 186 229 186 237 189 289 189 313 169
					yourself:
				)
		)
		(gEgo actions: (ScriptID 452 3)) ; noBlow
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (gEgo edgeHit:))
				(if (== temp0 4)
					(self setScript: chkPriv)
				else
					(super doit:)
				)
			)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local109)
		(super dispose:)
	)
)

(instance firstMess of Script
	(properties)

	(method (changeState newState)
		(if (< (= state newState) 3)
			(HandsOff)
			(Say 1470 (+ 0 state) self)
		else
			(SetFlag 202)
			(HandsOn)
			(self dispose:)
		)
	)
)

(instance pillow of Actor
	(properties
		x 92
		y 117
		description {the right pillow}
		view 470
		loop 2
		priority 7
		signal 26897
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					(local110
						(gCurRoom setScript: putBack)
					)
					((== ((Inv at: 12) owner:) gCurRoomNum) ; puzzleBox
						(gCurRoom setScript: getBox)
					)
					(else
						(Say 1470 28) ; "That's enough of that pillow."
					)
				)
			)
			(2 ; Look
				(if (AvoidPath (gEgo x:) (gEgo y:) rugPol)
					(Say 1470 9) ; "Aye, those pillows do look VERY freshly plumped up."
				else
					(Say 1470 8) ; "His soft pillows look to be freshly plumped up. They'd be softer than the table on which he snores now, I reckon."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(super onMe: temp0 temp1)
				(& (OnControl PRIORITY temp0 temp1) (<< $0001 priority))
			)
		)
	)
)

(instance pillowL of Actor
	(properties
		x 60
		y 122
		view 470
		loop 2
		priority 9
		signal 26897
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: checkL)
			)
			(2 ; Look
				(pillow doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(and
				(super onMe: temp0 temp1)
				(& (OnControl PRIORITY temp0 temp1) (<< $0001 priority))
			)
		)
	)
)

(instance pillowM of Actor
	(properties
		x 76
		y 119
		yStep 3
		view 470
		loop 2
		priority 8
		signal 26897
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: checkM)
			)
			(2 ; Look
				(pillow doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance putBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1470 27 self) ; "I'd better not make my theft too obvious."
			)
			(1
				(Load rsVIEW 28)
				(pillow startUpd:)
				(gEgo setMotion: PolyPath 123 125 self)
			)
			(2
				(gEgo
					setPri: (gEgo priority:)
					setCycle: 0
					setMotion: MoveTo 117 128 self
				)
			)
			(3
				(gEgo
					yStep: (+ (gEgo yStep:) 1)
					setMotion: MoveTo 111 138 self
				)
			)
			(4
				(gEgo
					view: 28
					setLoop: 4
					setCel: 0
					yStep: (- (gEgo yStep:) 1)
					cycleSpeed: 6
					setCycle: End
				)
				(pillow
					signal: (& $feff (pillow signal:))
					setMotion: MoveTo 92 117 self
				)
			)
			(5
				(gEgo view: 23 setLoop: 5 setMotion: MoveTo 117 128 self)
			)
			(6
				(gEgo setMotion: MoveTo 123 125 self)
			)
			(7
				(= local110 0)
				(NormalEgo 5)
				(pillow signal: (| $0100 (pillow signal:)) stopUpd:)
				(SetScore 10)
				(if (HaveMouse)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 163 131 self)
				)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 28)
				(pillow startUpd:)
				(gEgo setMotion: PolyPath 123 125 self)
			)
			(1
				(gEgo
					setPri: (gEgo priority:)
					setCycle: 0
					setMotion: MoveTo 117 128 self
				)
			)
			(2
				(gEgo
					yStep: (+ (gEgo yStep:) 1)
					setMotion: MoveTo 111 138 self
				)
			)
			(3
				(gEgo
					view: 28
					setLoop: 4
					setCel: 0
					yStep: (- (gEgo yStep:) 1)
					cycleSpeed: 6
					setCycle: End
				)
				(pillow
					signal: (& $feff (pillow signal:))
					setMotion: MoveTo 102 120 self
				)
			)
			(4
				(= local110 1)
				(Say 1470 26 self) ; "I've found it!"
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo view: 23 setLoop: 5 setMotion: MoveTo 117 128 self)
			)
			(7
				(gEgo setMotion: MoveTo 123 125 self)
			)
			(8
				(NormalEgo 5)
				(gEgo get: 12) ; puzzleBox
				(SetScore 25)
				(pillow signal: (| $0100 (pillow signal:)) stopUpd:)
				(if (HaveMouse)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 163 131 self)
				)
			)
			(9
				(HandsOn)
				(bed approachVerbs:)
				(self dispose:)
			)
		)
	)
)

(instance checkM of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 28)
				(pillowM startUpd:)
				(gEgo setMotion: PolyPath 72 146 self)
			)
			(1
				(Face gEgo pillowM)
				(= cycles 2)
			)
			(2
				(gEgo
					view: 28
					setLoop: 6
					setCel: 6
					cycleSpeed: 16
					setCycle: CT 3 -1
				)
				(pillowM
					signal: (& $feff (pillowM signal:))
					setMotion: MoveTo 80 110 self
				)
			)
			(3
				(Say 1470 29 self) ; "Nothing under this pillow."
			)
			(4
				(gEgo cycleSpeed: 6 setCycle: CT 5 1)
				(pillowM setMotion: MoveTo 76 119 self)
			)
			(5
				(pillowM signal: (| (pillowM signal:) $0100) stopUpd:)
				(NormalEgo 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance checkL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 28)
				(pillowL startUpd:)
				(gEgo setMotion: PolyPath 47 141 self)
			)
			(1
				(Face gEgo pillowL)
				(= cycles 2)
			)
			(2
				(gEgo
					view: 28
					setLoop: 11
					setCel: 0
					cycleSpeed: 10
					setCycle: End
				)
				(pillowL
					signal: (& $feff (pillowL signal:))
					setMotion: MoveTo 65 120 self
				)
			)
			(3
				(Say 1470 29 self) ; "Nothing under this pillow."
			)
			(4
				(gEgo setCycle: Beg)
				(pillowL setMotion: MoveTo 60 122 self)
			)
			(5
				(pillowL signal: (| (pillowL signal:) $0100) stopUpd:)
				(NormalEgo 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chkPriv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(= seconds 4)
			)
			(2
				(gEgo setMotion: PolyPath 9 157 self)
			)
			(3
				(Say 1470 3 self) ; "Pheugh. That was the Abbot's private privy. Definitely NOT a means of escape."
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rope of Feature
	(properties
		x 33
		y 135
		onMeCheck 2
		lookStr 11 ; "The fat and lazy Abbot has even provided himself with a rope pull to call for a servant without leaving his bed."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: ropePull)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance ropePull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 36 139 self)
			)
			(1
				(Face gEgo rope)
				(= cycles 8)
			)
			(2
				(cond
					(((ScriptID 452 2) seconds:) ; regTimer
						(HandsOn)
						(self dispose:)
					)
					((IsFlag 100)
						(Say 1470 42 self) ; "I suspect I could pull this rope all day and never see that Monk again."
					)
					(else
						(Say 1470 32 self) ; "Hmmm...couldn't hear a bell from here, but I expect a Monk may arrive soon."
					)
				)
			)
			(3
				(if (not (IsFlag 100))
					((ScriptID 452 0) setScript: (ScriptID 452 2) 0 doMonk) ; abbey, regTimer
					(SetFlag 100)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doMonk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((= register ((ScriptID 452 1) new:)) ; aMonk
					posn: 70 230
					init:
					setCycle: Walk
					setMotion: MoveTo 74 188 self
				)
			)
			(1
				(Face gEgo register)
				(Face register gEgo)
				(= cycles 2)
			)
			(2
				(cond
					(local110
						(Converse @local16 10 0 self) ; "Aye, did you ring, Excellency? I--eh? What are you doing in the Abbot's room?"
					)
					((IsFlag 88)
						(Converse @local22 10 0 self) ; "Aha! I knew you were up to something!"
					)
					(else
						(++ state)
						(Converse @local4 10 9 self) ; "Aye, Your Excellency....eh? Where's the Abbot? What are you doing in here?"
					)
				)
			)
			(3
				(= gDeathNum 24)
				(gCurRoom newRoom: 170) ; robinDeath
			)
			(4
				(register setMotion: MoveTo 70 230 self)
			)
			(5
				(register dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bCurtains of Feature
	(properties
		x 156
		y 184
		onMeCheck 16
		lookStr 5 ; "They're bed curtains of heavy fabric."
	)
)

(instance bTape of Feature
	(properties
		x 74
		y 127
		onMeCheck 64
		lookStr 6 ; "It's a richly made tapestry, embroidered with gold."
	)
)

(instance bed of Feature
	(properties
		x 106
		y 129
		onMeCheck 512
		approachX 151
		approachY 150
		lookStr 7 ; "A most impressive bed."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== ((Inv at: 12) owner:) gCurRoomNum) ; puzzleBox
					(Say 1470 24 1) ; "My foot thumps up against solid wood, so he couldn't have put the box under the bed."
				else
					(Say 1470 25 1) ; "The bed looks tempting, but I'd be mad to take a nap here."
				)
			)
			(4 ; Inventory
				(cond
					((OneOf invItem 0 2 18) ; bucks, halfHeart, waterRing
						(Say 1470 62 1) ; "I see no reason to leave anything of value for the Abbot."
					)
					((== invItem 13) ; robes
						(Say 1470 63 1) ; "Other than annoying the Abbot, I can't see much benefit in leaving them here."
					)
					((== invItem 12) ; puzzleBox
						(Say 1470 64 1) ; "Now that I've found it, I'm keeping it."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance skin of Feature
	(properties
		x 117
		y 133
		description {the animal skin}
		lookStr 10 ; "That looks to be the skin of some exotic animal from the East."
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(Say 1470 31 1) ; "Might be a nice addition to my own bed, but I'd never walk out of here unnoticed with that!"
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance table of Feature
	(properties
		x 156
		y 200
		onMeCheck 128
		lookStr 12 ; "The table is beautifully carved, and upon it are fine pieces of glass and other odds and ends."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1470 58 1) ; "Some of these objects tempt me, but their absence might be too quickly noticed."
			)
			(4 ; Inventory
				(bed doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 272
		y 153
		lookStr 13 ; "I see the Abbot has a scribe's desk. I wonder if he makes much use of it."
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(bed doVerb: theVerb invItem)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance book of Feature
	(properties
		x 267
		y 155
		lookStr 14 ; "I see a holy book open upon the desk."
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 3) ; Do
				(Say 1470 59 1) ; "Nay, I'll not steal a holy book, not even the Abbot's."
			)
			((and (== theVerb 2) (< (gEgo distanceTo: self) 30)) ; Look
				(gCurRoom setScript: readBook)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance readBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1470 15 self) ; "Ah, he has it open to the Song of Solomon."
			)
			(1
				(Say 470 0 self) ; "Chapter 7--'How fair and pleasant you are, O loved one, delectable maiden. You are stately as a palm tree, and your breasts are like its clusters. I say I will climb the palm tree and lay hold of its branches."
			)
			(2
				(Say 470 1 self) ; "Oh, may your breasts be like clusters of the vine, and the scent of your breath like apples. And your kisses like the best wine that goes down smoothly, gliding over lips and teeth.'"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 253
		y 159
		onMeCheck 256
		lookStr 16 ; "There's a cushioned chair for the scribe's desk."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1470 60 1) ; "It wouldn't look good for me to be sitting in this chair if another Monk comes in. I risk enough as it is."
			)
			(4 ; Inventory
				(bed doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rug of Feature
	(properties
		lookStr 17 ; "A rich carpet from the East protects the Abbot's tender toes from the cold stone floor."
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 3) (== ((Inv at: 12) owner:) gCurRoomNum)) ; Do, puzzleBox
			(Say 1470 61 1) ; "Couldn't be anything under the rug."
		else
			(super doVerb: theVerb invItem)
		)
	)

	(method (onMe param1 param2 &tmp temp0)
		(= x gMouseX)
		(= y gMouseY)
		(return (super onMe: param1 param2))
	)
)

(instance windows of Feature
	(properties
		onMeCheck 32
		lookStr 18 ; "Even his windows are of the finest glass."
	)

	(method (onMe param1 param2)
		(= x (if (< gMouseX 228) 173 else 283))
		(= y (if (< gMouseX 228) 116 else 127))
		(return (super onMe: param1 param2))
	)
)

(instance fTape of Feature
	(properties
		x 222
		y 121
		onMeCheck 8
		lookStr 19 ; "That exquisite tapestry would have cost more than a mark or two."
	)
)

(instance rChest of Feature
	(properties
		x 159
		y 124
		approachX 173
		approachY 129
		lookStr 4 ; "It's a solidly-made chest."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1470 21 1) ; "It's filled with vestments."
			)
			(4 ; Inventory
				(bed doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lChest of View
	(properties
		x 28
		y 174
		approachX 61
		approachY 174
		lookStr 4 ; "It's a solidly-made chest."
		view 470
		loop 1
		signal 16641
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: openIt)
			)
			(4 ; Inventory
				(bed doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance openIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo view: 470 loop: 0 cel: 1)
				(= ticks 16)
			)
			(2
				(lChest setCel: 1)
				(gEgo cel: 0)
				(= ticks 10)
			)
			(3
				(Say 1470 22 self) ; "Delicate frilly things for ladies. Interesting, but of no use to me."
			)
			(4
				(lChest setCel: 0)
				(gEgo cel: 1)
				(= ticks 15)
			)
			(5
				(NormalEgo 5)
				(= cycles 2)
			)
			(6
				(Say 1470 23 self) ; "Though it leaves me to wonder to what use the Abbot puts them."
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fire of Actor
	(properties
		x 222
		y 124
		lookStr 20 ; "The fire keeps the room cozy. He must keep it going day and night for his comfort."
		view 470
		loop 3
		priority 2
		signal 24592
	)
)

(instance rugPol of Polygon
	(properties
		size 4
	)
)

(instance lChstPol of Polygon
	(properties
		size 6
	)
)

(instance rChstPol of Polygon
	(properties
		size 9
	)
)

(instance DeskPol of Polygon
	(properties
		size 7
	)
)

(instance BookPol of Polygon
	(properties
		size 4
	)
)

(instance SkinPol of Polygon
	(properties
		size 11
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 537
		loop -1
	)
)

