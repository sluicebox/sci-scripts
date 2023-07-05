;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use PPath)
(use Polygon)
(use Feature)
(use Rev)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm550 0
)

(local
	[local0 9] = [535 0 2 4 26 38 22 26 27]
	[local9 3] = [-1 {Hal} 11]
	[local12 3] = [-1 {Dicken} 13]
	local15
	[local16 4] = [1550 59 1 0]
	[local20 5] = [1550 60 1 1 0]
	[local25 4] = [1550 0 1 0]
	[local29 9] = [1550 1 2 2 1 2 1 3 0]
	[local38 8] = [1550 7 1 1 1 1 1 0]
	[local46 5] = [1550 12 1 1 0]
	[local51 7] = [1550 19 2 2 2 1 0]
	[local58 5] = [1550 23 1 2 0]
	[local63 5] = [1550 25 1 1 0]
	[local68 4] = [1550 27 1 0]
	[local72 4] = [1550 42 1 0]
	[local76 4] = [1550 56 1 0]
	[local80 4] = [1550 68 1 0]
	[local84 4] = [1550 14 1 0]
	[local88 7] = [1550 15 1 1 1 1 0]
	[local95 5] = [93 129 40 84 -32768]
)

(instance rm550 of Rm
	(properties
		picture 550
		north 530
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(HandsOff)
		(self
			setScript:
				(cond
					((IsFlag 125) resc)
					((== gPrevRoomNum 530) gateIn)
					(else barrelIn)
				)
		)
		(gEgo init:)
		(sDoor init:)
		(if (== gDay 10)
			(gate init: approachVerbs: 3) ; Do
		else
			(gate init: approachVerbs: 5 3) ; Talk, Do
		)
		(if (!= script resc)
			(tap4 init: approachVerbs: 3) ; Do
		)
		(AddToAddToPics tap3 tap5 tap6)
		(tap3 approachVerbs: 3) ; Do
		(tap5 approachVerbs: 3) ; Do
		(tap6 approachVerbs: 3) ; Do
		(csk1 init: approachVerbs: 3) ; Do
		(csk2 init: approachVerbs: 3) ; Do
		(csk3 init: approachVerbs: 3) ; Do
		(csk4 init: approachVerbs: 3) ; Do
		(csk5 init: approachVerbs: 3) ; Do
		(csk6 init: approachVerbs: 3) ; Do
		(csk7 init: approachVerbs: 3) ; Do
		(csk8 init: approachVerbs: 3) ; Do
		(csk9 init: approachVerbs: 3) ; Do
		(base init:)
		(sacks init:)
		(walls init:)
		(floor init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 58 118 26 118 25 124 76 124 89 134 91 151 55 151 105 154 108 171 185 187 273 187 185 109 227 102 224 98 147 105 140 116 101 123 80 106 58 106
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 10) ; Longbow
			(Say 1550 66 1) ; "It would serve no purpose."
		)
	)
)

(instance sDoor of Prop
	(properties
		x 215
		y 102
		view 550
		loop 1
		priority 9
		signal 26897
		cycleSpeed 18
	)

	(method (onMe)
		(return 0)
	)
)

(instance gate of Prop
	(properties
		x 84
		y 101
		approachX 65
		approachY 106
		view 550
		loop 2
		signal 26881
		cycleSpeed 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if cel
					(Say 1550 38) ; "I'm lucky to find this door open."
				else
					(Say 1550 39) ; "This door can't be opened from the inside."
				)
			)
			(3 ; Do
				(if cel
					(Say 1550 40) ; "It would be foolish to lock this behind me."
				else
					(Say 1550 41) ; "The door is locked."
				)
			)
			(5 ; Talk
				(if (!= gDay 10)
					(self setScript: screwUp)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tap3 of PicView
	(properties
		x 204
		y 121
		z 4
		approachX 187
		approachY 130
		lookStr 32 ; "It's the tap for drawing ale from this cask."
		view 550
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: turnTap self)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tap4 of Feature
	(properties
		x 218
		y 135
		z 4
		nsTop 115
		nsLeft 214
		nsBottom 127
		nsRight 222
		approachX 201
		approachY 144
		lookStr 32 ; "It's the tap for drawing ale from this cask."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: barrelOut)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tap5 of PicView
	(properties
		x 237
		y 147
		z 4
		approachX 220
		approachY 156
		lookStr 32 ; "It's the tap for drawing ale from this cask."
		view 550
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: turnTap self)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tap6 of PicView
	(properties
		x 257
		y 166
		z 4
		approachX 240
		approachY 175
		lookStr 32 ; "It's the tap for drawing ale from this cask."
		view 550
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: turnTap self)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance turnTap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: (if (!= gDisguiseNum 0) 28 else 550) ; outlaw
					loop: (if (!= gDisguiseNum 0) 11 else 8) ; outlaw
					x: (+ -17 (caller x:))
					y: (+ 13 (caller y:))
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(spigotSound play:)
				((= register (Prop new:))
					view: 550
					loop: 3
					ignoreActors: 1
					x: (caller x:)
					y: (caller y:)
					z: 4
					init:
					setCycle: Fwd
				)
				(= ticks 30)
			)
			(2
				(gEgo setCycle: Beg self)
				(spigotSound play:)
				(= ticks 9)
			)
			(3
				(register dispose:)
			)
			(4
				(Say 1550 49 self) ; "I hate to waste good ale."
			)
			(5
				(NormalEgo 4)
				(HandsOn)
				(= caller 0)
				(self dispose:)
			)
		)
	)
)

(instance guardX of Actor
	(properties
		x 58
		y 88
		view 753
	)
)

(instance keeper of Actor
	(properties
		view 533
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1550 29 1) ; "He waits for me to leave and stands in the door to hide me should anyone enter his pub."
			)
			(5 ; Talk
				(Converse 1 @local76 @local0 0) ; "Hurry, use the tunnel. There's still the danger of discovery here."
			)
			(3 ; Do
				(Converse 1 @local72 @local0 0) ; "Nay, it's no use coming back this way. Use the tunnels. Hurry, before someone comes."
			)
			(10 ; Longbow
				(Say 1550 67 1) ; "Threaten him after he's helped me? That would be madness."
			)
			(4 ; Inventory
				(Converse 1 @local80 @local0 0) ; "I don't want anything except to have you leave quickly."
			)
		)
	)
)

(instance gateIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(keeper x: 58 y: 90 loop: 2 init: setCycle: Walk)
				(gate cel: (gate lastCel:))
				(if (IsFlag 140)
					(gEgo x: 197 y: 140 loop: 1)
					(= cycles 2)
					(HandsOn)
				else
					(gEgo x: 63 y: 104 loop: 2 setMotion: MoveTo 67 110 self)
				)
			)
			(1
				(cond
					((or (!= gDay 10) (IsFlag 141))
						(keeper setScript: openGate self)
					)
					((IsFlag 140)
						(Converse @local58 999 @local0) ; "I'll not forget your help this day."
						(HandsOn)
						(self dispose:)
					)
					(else
						(Converse @local51 999 @local0) ; "Go to that cask before you, second from the left, and twist the tap."
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(2
				(gate signal: (| (gate signal:) $0100) stopUpd:)
				(if (== gDay 10)
					(Converse @local63 @local0 0 self) ; "Hah! You'll not come back out this way, outlaw!"
				else
					(= cycles 1)
				)
			)
			(3
				(keeper setMotion: MoveTo 38 88 self)
			)
			(4
				(keeper dispose:)
				(if (== gDay 10)
					(Converse 1 @local68 999 3 self) ; "Wait! Let me explain!"
				else
					(= cycles 1)
					(++ state)
				)
			)
			(5
				(Say 1550 28 self) ; "It's no use. He's run out of the pub and left this door locked."
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance barrelIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 550
					loop: (if (== gDisguiseNum 0) 6 else 4) ; outlaw
					cel: 0
					posn: 193 138
					setPri: 8
				)
				(sDoor signal: 26640)
				(if (== gDay 10)
					(++ state)
					(= cycles 1)
					(return)
				)
				((= register (Actor new:))
					view: 753
					loop: 1
					posn: 58 88
					init:
					setCycle: Fwd
					setMotion: MoveTo 37 78 self
				)
			)
			(1
				(register dispose:)
				(= ticks 45)
			)
			(2
				(caskSound play:)
				(sDoor setCycle: End self)
			)
			(3
				(sDoor priority: 8)
				(gEgo setCycle: End self)
			)
			(4
				(NormalEgo)
				(gEgo posn: 199 137 setMotion: MoveTo 189 141 self)
			)
			(5
				(gEgo setHeading: 80 self)
			)
			(6
				(sDoor priority: 9 setCycle: Beg self)
			)
			(7
				(caskCloseSound play:)
				(sDoor signal: (| (sDoor signal:) $0100) stopUpd:)
				(gEgo setHeading: 260 self)
			)
			(8
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance barrelOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: (if (!= gDisguiseNum 0) 28 else 550) ; outlaw
					loop: (if (!= gDisguiseNum 0) 11 else 8) ; outlaw
					cel: 0
					setCycle: End self
				)
			)
			(1
				(= ticks (+ 1 (* 2 (gEgo cycleSpeed:))))
				(if (IsFlag 140)
					(++ state)
				)
			)
			(2
				(Say 1550 (= register 50) self)
			)
			(3
				(sDoor
					signal: (& (sDoor signal:) $feff)
					startUpd:
					priority: 8
					setCycle: End self
				)
				(caskSound play:)
				(NormalEgo)
				(gEgo
					setLoop: 6
					setCycle: Rev
					setMotion: MoveTo 190 152 self
				)
			)
			(4
				(if (IsFlag 140)
					(++ state)
				)
				(if (not (gEgo mover:))
					(gEgo setCycle: 0)
				)
			)
			(5
				(gEgo setCycle: 0)
				(Say 1550 (++ register) self)
			)
			(6
				(NormalEgo)
				(gEgo setMotion: MoveTo 213 133 self)
			)
			(7
				(gEgo
					view: 550
					loop: (if (== gDisguiseNum 0) 7 else 5) ; outlaw
					cel: 0
					setPri: 8
				)
				(= ticks (+ 1 (* 2 (gEgo cycleSpeed:))))
			)
			(8
				(gEgo setCycle: CT 1 1 self)
				(if (IsFlag 140)
					(++ state)
				)
			)
			(9
				(Say 1550 (++ register) self)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(= ticks (+ (gEgo cycleSpeed:) 1))
			)
			(12
				(gEgo dispose:)
				(= cycles 2)
			)
			(13
				(SetScore 100 140)
				(gCurRoom newRoom: 560) ; tunnel1
			)
		)
	)
)

(instance series of Script
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(= start param4)
		(super init: param1 param2 param3)
		(= start param5)
	)

	(method (changeState newState)
		(if (<= (= state newState) start)
			(if local15
				(SetMessageColor 19)
				(Say register state self 80 local15)
				(SetMessageColor 0)
			else
				(Say register state self)
			)
		else
			(self dispose:)
		)
	)

	(method (cue param1)
		(if (not param1)
			(= start state)
		)
		(super cue:)
	)
)

(instance screwUp of Script
	(properties)

	(method (changeState newState)
		(= state newState)
		(switch register
			(0
				(gCurRoom setScript: series 0 1550 57 58)
				(++ register)
			)
			(1
				(switch newState
					(0
						(HandsOff)
						(Converse @local16 999 0 self) ; "INNKEEPER!"
					)
					(1
						(keeper
							view: 533
							loop: 0
							cel: 0
							posn: 50 76
							init:
							setCycle: Walk
							setMotion: MoveTo 69 76 self
						)
					)
					(2
						(Converse @local20 @local0 0 self) ; "Are you a complete dolt? Do you want every Sheriff's man in the pub to hear you?"
					)
					(3
						(keeper setMotion: MoveTo 50 76 self)
					)
					(4
						(keeper hide: stopUpd:)
						(HandsOn)
						(++ register)
					)
				)
			)
			(2
				(switch newState
					(0
						(HandsOff)
						(Converse @local16 999 0 self) ; "INNKEEPER!"
					)
					(1
						(guardX
							loop: 0
							init:
							setCycle: Walk
							setMotion: MoveTo 65 88 self
						)
					)
					(2
						(= local15 {Roger})
						(gCurRoom setScript: series self 1550 62 65)
					)
					(3
						(= gDeathNum 30)
						(gCurRoom newRoom: 170) ; robinDeath
					)
				)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gate
					signal: (& (sDoor signal:) $feff)
					startUpd:
					setCycle: Beg self
				)
			)
			(1
				(gateSound play:)
				(self dispose:)
			)
		)
	)
)

(instance resc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gRgnMusic number: 530 loop: -1 play:)
				(sDoor cel: (sDoor lastCel:) priority: 8 stopUpd:)
				(gate cel: (gate lastCel:))
				(gEgo
					view: 550
					loop: 4
					cel: 0
					posn: 193 138
					setPri: 8
					setCycle: End self
				)
				(hal init:)
				(hob init:)
				(dick init:)
				(= cycles 1)
			)
			(1
				(gate addToPic:)
			)
			(2
				(NormalEgo 1)
				(= cycles 2)
			)
			(3
				(if (IsFlag 211)
					(Converse 1 @local84 @local9 1 self) ; "I see nothing for it but to take our chances."
				else
					(Converse 1 @local25 999 3 self) ; "What's all the noise, Hal?"
				)
			)
			(4
				(hal setHeading: 110 self)
			)
			(5
				(if (IsFlag 211)
					(Converse 1 @local88 999 3 self) ; "I fear you're right. Very well, listen carefully."
				else
					(Converse 3 @local29 999 3 @local9 1 @local12 0 self) ; "It's the Sheriff with his men and some wenches!"
				)
			)
			(6
				(cond
					((IsFlag 211)
						(= cycles 1)
					)
					((AyeOrNay)
						(SetScore 50)
						(Converse 1 @local38 999 3 self) ; "Aye, we must dare it. The pub's outside the town walls and closer to the forest."
					)
					(else
						(+= state 3)
						(Converse 1 @local46 999 3 self) ; "Nay, I don't like the sound of it out there."
					)
				)
				(hal setCycle: Walk setLoop: Grooper)
				(hob setCycle: Walk setLoop: Grooper)
				(dick setCycle: Walk setLoop: Grooper)
			)
			(7
				(hal setMotion: PPath @local95)
				(hob setMotion: PPath @local95)
				(dick setMotion: PPath @local95)
				(gEgo setHeading: 90 self)
			)
			(8
				(sDoor signal: (& (sDoor signal:) $feff) setCycle: Beg)
				(gEgo setMotion: MoveTo 110 130 self)
			)
			(9
				(gCurRoom newRoom: 530)
				(hal setMotion: 0)
				(hob setMotion: 0)
				(dick setMotion: 0)
				(DisposeScript 852)
			)
			(10
				(SetFlag 211)
				(gEgo setMotion: MoveTo 213 133 self)
			)
			(11
				(gEgo view: 550 loop: 5 cel: 0 setPri: 8 setCycle: End self)
				(hal setMotion: MoveTo 193 138)
				(hob setMotion: MoveTo 193 138)
				(dick setMotion: MoveTo 193 138)
			)
			(12
				(= ticks (gEgo cycleSpeed:))
			)
			(13
				(gEgo dispose:)
				(= cycles 2)
			)
			(14
				(gRgnMusic fade: 0 30 8 1)
				(gCurRoom newRoom: 560) ; tunnel1
			)
		)
	)
)

(instance hal of Actor
	(properties
		x 110
		y 130
		view 23
		loop 7
		cel 5
		signal 24576
	)
)

(instance hob of Actor
	(properties
		x 128
		y 121
		view 23
		loop 5
		cel 1
		signal 24576
	)
)

(instance dick of Actor
	(properties
		x 144
		y 130
		view 23
		loop 1
		cel 5
		signal 24576
	)
)

(instance spigotSound of Sound
	(properties
		flags 1
		number 552
	)
)

(instance caskSound of Sound
	(properties
		flags 1
		number 551
	)
)

(instance caskCloseSound of Sound
	(properties
		flags 1
		number 553
	)
)

(instance gateSound of Sound
	(properties
		flags 1
		number 532
	)
)

(instance csk1 of Feature
	(properties
		x 157
		y 89
		onMeCheck 2
		approachX 163
		approachY 105
		lookStr 30 ; "It's a sturdy ale cask, not yet tapped for drinking."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 43) ; "The cask is solid and unmovable."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance csk2 of Feature
	(properties
		x 197
		y 85
		onMeCheck 4096
		approachX 201
		approachY 101
		lookStr 30 ; "It's a sturdy ale cask, not yet tapped for drinking."
	)

	(method (doVerb)
		(csk1 doVerb: &rest)
	)
)

(instance csk3 of Feature
	(properties
		x 220
		y 117
		onMeCheck 4
		approachX 187
		approachY 130
		lookStr 31 ; "It's a sturdy ale cask with a tap for drawing ale."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 44) ; "This cask is too full of ale to move."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance csk4 of Feature
	(properties
		x 231
		y 133
		onMeCheck 8
		approachX 201
		approachY 144
		lookStr 31 ; "It's a sturdy ale cask with a tap for drawing ale."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 45) ; "This cask doesn't feel nearly as heavy as the others, though it's still fixed solidly in place."
				(Say 1550 46) ; "I suppose the Innkeeper's been drawing ale from it and it's nearly empty."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance csk5 of Feature
	(properties
		x 252
		y 146
		onMeCheck 16
		approachX 220
		approachY 156
		lookStr 31 ; "It's a sturdy ale cask with a tap for drawing ale."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 47) ; "This cask feels full and heavy."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance csk6 of Feature
	(properties
		x 271
		y 165
		onMeCheck 32
		approachX 240
		approachY 175
		lookStr 31 ; "It's a sturdy ale cask with a tap for drawing ale."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 48) ; "This cask is almost as heavy as the others and too heavy to move."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance csk7 of Feature
	(properties
		x 100
		y 189
		onMeCheck 1024
		approachX 110
		approachY 170
		lookStr 34 ; "I can't tell what these barrels might contain."
	)

	(method (doVerb)
		(csk8 doVerb: &rest)
	)
)

(instance csk8 of Feature
	(properties
		x 30
		y 161
		onMeCheck 128
		approachX 55
		approachY 151
		lookStr 34 ; "I can't tell what these barrels might contain."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 54) ; "They're solidly filled with barley from the smell of it. No use to me, unless I plan to brew ale."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance csk9 of Feature
	(properties
		x 25
		y 134
		onMeCheck 2048
		approachX 38
		approachY 124
		lookStr 34 ; "I can't tell what these barrels might contain."
	)

	(method (doVerb)
		(csk8 doVerb: &rest)
	)
)

(instance base of Feature
	(properties
		onMeCheck 64
		lookStr 33 ; "The casks sit on a heavy wooden frame."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 53) ; "There's no way to move these boards with the heavy casks sitting upon them."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance sacks of Feature
	(properties
		onMeCheck 256
		lookStr 35 ; "They look to be sacks of sugar."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1550 55) ; "I can't see a need to carry sugar around."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance walls of Feature
	(properties
		onMeCheck 1
		lookStr 36 ; "The cellar has been left in its natural cave formation."
	)
)

(instance floor of Feature
	(properties
		onMeCheck 512
		lookStr 37 ; "The floor of this cellar is worn sandstone."
	)
)

