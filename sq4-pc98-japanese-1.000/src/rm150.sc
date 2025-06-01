;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use eRS)
(use Osc)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Rev)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm150 0
	RogerJr 1
	diskDrive 2
)

(local
	local0
	local1
	local2 = 10
	local3 = 15
	local4
	[local5 8] = [161 189 186 154 120 91 87 118]
	[local13 45] = [119 107 80 67 61 79 107 126 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 -32768]
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(laserSound play:)
	(= temp0 (param1 x:))
	(= temp1 (- (param1 y:) 10))
	(= temp2 (- (Min temp1 param3) 1))
	(= temp3 (+ (Max temp1 param3) 1))
	(= temp4 (- (Min temp0 param2) 1))
	(= temp5 (+ (Max temp0 param2) 1))
	(= temp6 (Graph grSAVE_BOX temp2 temp4 temp3 temp5 1))
	(Graph grDRAW_LINE temp1 temp0 param3 param2 global143 -1 -1)
	(Graph grREDRAW_BOX temp2 temp4 temp3 temp5 1)
	(Wait 1)
	(Wait 5)
	(Graph grRESTORE_BOX temp6)
	(Graph grREDRAW_BOX temp2 temp4 temp3 temp5 1)
	(if (or (!= param2 (gEgo x:)) (!= param3 (- (gEgo y:) 15)))
		(blast x: param2 y: param3 init: setCycle: End blast)
	)
)

(procedure (localproc_1 param1 param2) ; UNUSED
	(if local0
		(proc0_12 local0)
	)
	(= local0
		(proc0_12
			param2
			67
			10
			(if (== param1 0) 10 else 160)
			28
			(if (== param1 0)
				global135
			else
				(proc0_18 global153 global152)
			)
			29
			global129
		)
	)
)

(instance rm150 of SQRoom
	(properties
		picture 150
		south 505
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 150 0) ; "This is Vohaul's chamber, where his dirtiest of deeds are set into motion. The lit pedestal in the center towers jillions of feet above the floor. Though relatively dark you can sense that this place is alive with raw energy."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(LoadMany rsVIEW 522)
		(LoadMany rsVIEW 150 550)
		(Load rsSCRIPT 151)
		(if (not (brain formatting:))
			(LoadMany rsSOUND 118 120 119 121)
		else
			(LoadMany rsSOUND 152)
		)
		(if (< (gEgo x:) 160)
			(gEgo x: 170 y: 250 init:)
		else
			(gEgo x: 325 y: 235 init:)
		)
		(self setRegions: 704) ; brain
		(super init:)
		(brain
			makePolygon: 194 189 199 181 210 176 221 174 233 174 249 178 272 189
			makePolygon: 116 189 138 159 155 159 151 189
			makePolygon: 319 189 314 189 314 162 220 145 216 140 231 136 319 153
		)
		(diskDrive init: stopUpd:)
		(ladder init:)
		(overhang init:)
		(pedestal init:)
		(lOrb init:)
		(rOrb init:)
		(if (brain formatting:)
			(lOrb addToPic:)
			(rOrb addToPic:)
		)
		(gLongSong fade:)
		(self setScript: rescueScript)
	)

	(method (dispose)
		(DisposeScript 151)
		(DisposeScript 152)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 4)
				(self setScript: fallScript)
			)
			((StepOn gEgo 2)
				(self setScript: climbScript)
			)
		)
	)

	(method (notify param1)
		(switch param1
			(-1
				(= local4 1)
			)
			(else
				(= local1 param1)
			)
		)
	)
)

(instance rescueScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: (ScriptID 704 1)) ; droid1
					(((ScriptID 704 1) body:) dispose:) ; droid1
					((ScriptID 704 1) dispose:) ; droid1
				)
				(if (gCast contains: (ScriptID 704 2)) ; droid2
					(((ScriptID 704 2) body:) dispose:) ; droid2
					((ScriptID 704 2) dispose:) ; droid2
				)
				(gLongSong2 number: 848 vol: 127 loop: 1 play:)
				(RogerJr init: setCycle: Fwd)
				(gEgo setPri: -1 setLoop: -1)
				(if (== (gEgo x:) 170)
					(gEgo setMotion: PolyPath 170 170 self)
				else
					(gEgo setMotion: PolyPath 260 170 self)
				)
			)
			(1
				(if (not (brain formatting:))
					(lOrb setScript: laserScript)
					(self dispose:)
				else
					(SetScore 79 5)
					(gLongSong2 stop:)
					(RogerJr
						posn: 133 94
						setLoop: 1
						setCel: 0
						cycleSpeed: 1
						setCycle: End
					)
					(bridge init: setMotion: MoveTo 180 153 self)
					(bridgeSound play:)
				)
			)
			(2
				(bridgeSound stop:)
				(brain
					makePolygon: 123 159 123 127 166 127 180 150 155 159
					makePolygon: 218 145 195 148 175 124 202 109 228 135 216 140
				)
				(gEgo setMotion: PolyPath 156 118 self)
			)
			(3
				(bridge setMotion: MoveTo 193 176 self)
				(bridgeSound play:)
			)
			(4
				(bridge dispose:)
				(bridgeSound stop:)
				(RogerJr setLoop: 2 setCel: 0 setCycle: End self)
				(diskDrive setMotion: MoveTo 120 98 diskDrive)
			)
			(5)
			(6
				(RogerJr
					view: 550
					setLoop: 0
					setCel: 0
					setPri: 9
					posn: 125 94
					setCycle: CT 4 1 self
				)
			)
			(7
				(= seconds 2)
			)
			(8
				(Print 150 1) ; "Hee, hee, hee! Hello again, Roger. It's me - your old friend Sludge Vohaul. I've taken the liberty of borrowing your son's body. I had to remove him first to make room for my mental self. His is on this disk. I must say, it is most enjoyable to be in a young, healthy body - even if it is from YOUR blood line."
				(Print 150 2) ; "In fact, I like it so much I think I'll keep it. I guess we'll have no use for this anymore."
				(= seconds 2)
			)
			(9
				(RogerJr setCycle: End self)
				(disk
					init:
					setCycle: Fwd
					setMotion: DPath 88 61 53 65 20 98 -5 133 disk
				)
			)
			(10
				(RogHead
					posn: (+ (RogerJr x:) 8) (- (RogerJr y:) 31)
					init:
					setCycle: Fwd
				)
				(= cycles 10)
			)
			(11
				(RogHead dispose:)
				(RogerJr
					view: 525
					setLoop: 0
					setPri: -1
					cycleSpeed: 0
					setCycle: Rev
					setMotion: MoveTo [local5 4] [local13 4] self
				)
				(diskDrive setMotion: MoveTo 120 110 diskDrive)
			)
			(12)
			(13
				(Print 150 3) ; "Now it's time to settle things once and for all. You'd better be careful, though. Keep this in mind - if I die while in this body, that disk will be useless. Your son will NEVER draw another breath and, if you don't defend yourself you will never live to buff another helmet!"
				(Print 150 4) ; "Come on - show me what you've got, mop jockey!"
				(Animate (gCast elements:) 0)
				(RogerJr view: 527 setCycle: Walk)
				(gEgo view: 526 setCycle: Walk)
				(gGame setCursor: 6)
				(self setScript: (ScriptID 151 0) self) ; fightScript
			)
			(14
				(self setScript: (ScriptID 151 1) self) ; endFightScript
			)
			(15
				(self dispose:)
			)
		)
	)
)

(instance laserSound of Sound
	(properties
		number 106
	)
)

(instance laserScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(= seconds 5)
			)
			(1
				(localproc_0 lOrb (- (gEgo x:) 25) 159)
				(= cycles 20)
			)
			(2
				(localproc_0 rOrb (+ (gEgo x:) 25) 143)
				(= cycles 20)
			)
			(3
				(localproc_0 lOrb (- (gEgo x:) 15) 161)
				(= cycles 20)
			)
			(4
				(localproc_0 rOrb (+ (gEgo x:) 15) 150)
				(= cycles 20)
			)
			(5
				(localproc_0 lOrb (- (gEgo x:) 5) 160)
				(= cycles 20)
			)
			(6
				(localproc_0 rOrb (+ (gEgo x:) 5) 158)
				(= cycles 20)
			)
			(7
				(localproc_0 lOrb (gEgo x:) (- (gEgo y:) 15))
				(= cycles 1)
			)
			(8
				(gEgo view: 511 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(9
				(EgoDead 8 30) ; "The word "Laser" came to mind after each of the first six shots, but only after the seventh blast were you convinced."
			)
		)
	)
)

(instance climbScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (OneOf ((Inv at: 14) owner:) gEgo gCurRoomNum diskDrive) ; diskette
					(Print 150 5) ; "You don't really want to go down there AGAIN..."
					(= register 1)
					(gEgo setMotion: MoveTo 100 115 self)
				else
					(gEgo setMotion: MoveTo 84 115 self)
				)
			)
			(1
				(if register
					(HandsOn)
					(self dispose:)
				else
					(gEgo setHeading: 270 self)
				)
			)
			(2
				(gEgo
					view: 551
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo
					posn: 77 144
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 98 245 self
				)
			)
			(4
				(gEgo get: 14) ; diskette
				(= seconds 5)
			)
			(5
				(gEgo setCycle: Rev setMotion: MoveTo 77 144 self)
			)
			(6
				(gEgo posn: 84 115 setLoop: 2 setCel: 2 setCycle: Beg self)
			)
			(7
				(gEgo
					view: 3
					setLoop: -1
					cycleSpeed: 0
					setCycle: StopWalk 510
					setMotion: MoveTo 100 115 self
				)
			)
			(8
				(HandsOn)
				(SetScore 64 5)
				(self dispose:)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (lOrb script:) laserScript)
					(lOrb setScript: 0)
				)
				(gEgo setMotion: MoveFwd 12 self)
			)
			(1
				(gEgo setHeading: 180)
				(= cycles 8)
			)
			(2
				(Print 150 6) ; "Dang!"
				(cond
					((< (gEgo y:) 95)
						(= temp0 1)
					)
					((< (gEgo x:) 95)
						(= temp0 12)
					)
					(else
						(= temp0 3)
					)
				)
				(gEgo
					setCycle: 0
					setStep: (gEgo xStep:) 19
					setPri: temp0
					setMotion: MoveTo (gEgo x:) 300 self
				)
			)
			(3
				(EgoDead) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
		)
	)
)

(instance jrFreeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(brain formatting: 0)
				(RogerJr
					posn: 133 91
					setLoop: 1
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(RogerJr setLoop: 2 setCel: 0 setCycle: End self)
				(gLongSong stop:)
			)
			(3
				(if local4
					(EgoDead 0 11) ; "Well, that's just great! Now Vohaul's on the loose again, disguised as your SON! You lose 3 out of 2."
				else
					(gLongSong number: 870 vol: 127 loop: -1 flags: 1 playBed:)
					(= cycles 2)
				)
			)
			(4
				(Print 150 7) ; "Thanks for saving me. I thought I was a goner."
				(Print 150 8) ; "Follow me. There are many things we need to talk about."
				(gCurRoom newRoom: 556)
			)
		)
	)
)

(instance driveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 111 99 self)
			)
			(1
				((ScriptID 152 0) init:) ; driveCloseUp
				(self dispose:)
			)
		)
	)
)

(instance RogerJr of Actor
	(properties
		x 127
		y 39
		description {Roger Jr.}
		view 522
		priority 4
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 150 9) ; "It's Roger Jr!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and local1 (MousedOn self event))
			((ScriptID 151 0) handleEvent: (event type: $0040 message: JOY_UP)) ; fightScript, direction
		else
			(super handleEvent: event)
		)
	)
)

(instance RogHead of Prop
	(properties
		view 550
		loop 1
		priority 14
		signal 16400
	)
)

(instance driveSound of Sound
	(properties)
)

(instance diskDrive of Actor
	(properties
		x 120
		y 110
		description {disk drive}
		view 522
		loop 3
		priority 5
		signal 18448
		illegalBits 0
	)

	(method (setMotion)
		(driveSound number: 876 play:)
		(super setMotion: &rest)
	)

	(method (cue)
		(driveSound number: 877 play:)
		(if (== y 98)
			(self setCycle: Fwd)
		else
			(self stopUpd:)
		)
		(cond
			((not (gCurRoom script:))
				(gCurRoom setScript: jrFreeScript)
			)
			((rescueScript script:)
				((rescueScript script:) cue:)
			)
			(else
				(rescueScript cue:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(cond
					((!= invItem 14) 0) ; diskette
					((gCast contains: (ScriptID 152 0)) ; driveCloseUp
						((ScriptID 152 0) doVerb: theVerb invItem &rest) ; driveCloseUp
					)
					(else
						((gInventory at: 14) owner: self) ; diskette
						(gEgo put: 14 gCurRoomNum) ; diskette
						(SetScore 65 5)
						(self setScript: driveScript)
					)
				)
			)
			(2 ; Look
				(Print 150 10) ; "It's a disk drive unit."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ladder of Feature
	(properties
		x 83
		y 149
		nsTop 109
		nsLeft 66
		nsBottom 189
		nsRight 100
		description {ladder}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 150 11) ; "The ladder leads down to the floor far below."
			)
			(3 ; Do
				(gEgo setMotion: PolyPath 90 115)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance disk of Actor
	(properties
		x 88
		y 61
		yStep 7
		view 550
		loop 2
		priority 14
		signal 2064
		xStep 7
	)

	(method (cue)
		(self dispose:)
	)
)

(instance bridgeSound of Sound
	(properties
		number 152
	)
)

(instance bridge of Actor
	(properties
		x 193
		y 176
		view 522
		loop 4
		priority 2
		signal 18448
		illegalBits 0
	)
)

(instance blast of Prop
	(properties
		view 28
		signal 24576
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance lOrbZap of Sound
	(properties)
)

(instance rOrbZap of Sound
	(properties)
)

(instance lOrb of Prop
	(properties
		x 47
		y 123
		description {left orb}
		sightAngle 90
		view 151
		priority 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if cycler
					(Print 150 12) ; "The orbs of fury crackle and sizzle with raw energy."
				else
					(Print 150 13) ; "The orbs just seem to hover alongside the platform."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and local2 (not (-- local2)))
			(= loop (if (< (Random 1 10) 5) 0 else 2))
			(if (< (Random 1 10) 5)
				(lOrbZap number: (if loop 120 else 118) play:)
				(self setCycle: Osc 1 self)
			else
				(lOrbZap number: (if loop 120 else 118) play:)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(= local2 (Random 20 50))
		(lOrbZap stop:)
		(self stopUpd:)
	)
)

(instance rOrb of Prop
	(properties
		x 230
		y 87
		description {right orb}
		sightAngle 90
		view 151
		loop 1
		priority 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if cycler
					(Print 150 12) ; "The orbs of fury crackle and sizzle with raw energy."
				else
					(Print 150 13) ; "The orbs just seem to hover alongside the platform."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and local3 (not (-- local3)))
			(= loop (if (< (Random 1 10) 5) 1 else 3))
			(if (< (Random 1 10) 5)
				(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				(self setCycle: Osc 1 self)
			else
				(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(= local3 (Random 20 50))
		(rOrbZap stop:)
		(self stopUpd:)
	)
)

(instance overhang of Feature
	(properties
		description {overhang}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 150 14) ; "This is the top half of an odd I/O unit. It also provides lighting for the area."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1)
		(return (== (OnControl PRIORITY (param1 x:) (param1 y:)) 16384))
	)
)

(instance pedestal of Feature
	(properties
		description {pedestal}
	)

	(method (onMe param1)
		(return (== (OnControl PRIORITY (param1 x:) (param1 y:)) 4))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 150 15) ; "The large pedestal standing in the center of this chamber seems to be some sort of huge I/O unit for the Super Computer."
			)
			(10 ; Taste
				(Print 150 16) ; "Even standing on your tiptoes, you'd never be able to reach that with your tongue."
			)
			(11 ; Smell
				(Print 150 17) ; "It smells like a desperate, sweaty maintenance engineer has been walking around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

