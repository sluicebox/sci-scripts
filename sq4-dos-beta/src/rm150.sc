;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use SQRoom)
(use Osc)
(use MCyc)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Rev)
(use Sound)
(use Motion)
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
	local2
	local3 = 10
	local4 = 15
	[local5 8] = [161 189 186 154 120 91 87 118]
	[local13 8] = [119 107 80 67 61 79 107 126]
	[local21 37] = [2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 -32768]
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

(procedure (localproc_1 param1 param2)
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
			(if (== param1 0) global135 else global153)
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

	(method (init)
		(LoadMany rsVIEW 522)
		(if (== gPrevRoomNum 355)
			(LoadMany rsVIEW 520 521)
		else
			(LoadMany rsVIEW 150 523 524 525 526 527 528 550 551)
		)
		(LoadMany rsSOUND 49 118 119 120 121)
		(if (< (gEgo x:) 160)
			(gEgo x: 170 y: 250 init:)
		else
			(gEgo x: 325 y: 235 init:)
		)
		(if (not (== gPrevRoomNum 355))
			(self setRegions: 704) ; brain
		else
			(DisposeScript 704)
		)
		(super init:)
		(if (not (== gPrevRoomNum 355))
			(brain
				makePolygon: 194 189 199 181 210 176 221 174 233 174 249 178 272 189
				makePolygon: 116 189 138 159 155 159 151 189
				makePolygon: 319 165 220 145 216 140 231 136 319 153
			)
			(diskDrive init: stopUpd:)
			(ladder init:)
		)
		(lOrb init:)
		(rOrb init:)
		(if (== gPrevRoomNum 355)
			(self setScript: captiveScript)
		else
			(self setScript: rescueScript)
		)
	)

	(method (dispose)
		(DisposeScript 151)
		(DisposeScript 152)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (not local2) (== (gLongSong prevSignal:) 10))
			(= local2 1)
		)
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
		(= local1 param1)
	)
)

(instance captiveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong number: 49 playBed:)
				(vohaul init:)
				(police init: setCycle: Walk setMotion: MoveTo 200 158 self)
			)
			(1
				(mouth init: setCycle: ForwardCounter 7)
				(eyes init: setCycle: ForwardCounter 4)
				(localproc_1 0 {Well... what have we here?})
				(= seconds 4)
			)
			(2
				(mouth hide:)
				(eyes hide:)
				(= cycles 1)
			)
			(3
				(localproc_1
					1
					{This is the rebel scum we captured\nin the SQ4 time sector.}
				)
				(= seconds 5)
			)
			(4
				(localproc_1 1 {He had just aided Wilco in escaping.})
				(= seconds 5)
			)
			(5
				(localproc_1
					1
					{The readout on his time gun indicates\nthat Wilco was successfully transported...}
				)
				(= seconds 6)
			)
			(6
				(localproc_1 1 {...into this time sector as you feared.})
				(= seconds 5)
			)
			(7
				(mouth setCel: 0 show: setCycle: ForwardCounter 5)
				(eyes show: setCycle: ForwardCounter 3)
				(localproc_1 0 {That is no longer a concern.})
				(= seconds 4)
			)
			(8
				(mouth setCycle: ForwardCounter 9)
				(eyes setCycle: ForwardCounter 6)
				(localproc_1
					0
					{Wilco will surrender to us once he\nhas learned we have captured his SON!}
				)
				(= seconds 6)
			)
			(9
				(mouth setCycle: ForwardCounter 9)
				(eyes setCycle: ForwardCounter 6)
				(localproc_1
					0
					{Then he will be destroyed once and\nfor all. Ha ha ha....}
				)
				(= seconds 4)
			)
			(10
				(eyes dispose:)
				(mouth setCycle: MCyc @local21 self)
			)
			(11
				(mouth dispose:)
				(= cycles 1)
			)
			(12
				(proc0_12 local0)
				(DrawPic 803 6 9)
				(gCurRoom newRoom: 365)
			)
		)
	)
)

(instance rescueScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(((ScriptID 704 1) body:) dispose:) ; droid1
				(((ScriptID 704 2) body:) dispose:) ; droid2
				((ScriptID 704 1) dispose:) ; droid1
				((ScriptID 704 2) dispose:) ; droid2
				(RogerJr init: setCycle: Fwd)
				(= local2 1)
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
					(RogerJr
						posn: 133 94
						setLoop: 1
						setCel: 0
						cycleSpeed: 1
						setCycle: End
					)
					(bridge init: setMotion: MoveTo 180 153 self)
				)
			)
			(2
				(brain
					makePolygon: 123 159 123 127 166 127 180 150 155 159
					makePolygon: 218 145 195 148 175 124 202 109 228 135 216 140
				)
				(gEgo setMotion: PolyPath 156 118 self)
			)
			(3
				(bridge setMotion: MoveTo 193 176 self)
			)
			(4
				(bridge dispose:)
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
					setCycle: CT 6 1 self
				)
			)
			(7
				(RogerJr setCycle: End self)
				(disk
					init:
					setCycle: Fwd
					setMotion: DPath 88 61 53 65 20 98 -5 133 disk
				)
			)
			(8
				(RogHead posn: (RogerJr x:) (RogerJr y:) init: setCycle: Fwd)
				(Print 150 0) ; "Hi there. I'm Vohaul/Roger Jr., and you're not."
				(= cycles 10)
			)
			(9
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
			(10)
			(11
				(RogerJr view: 527 setCycle: Walk)
				(gEgo view: 526 setCycle: Walk)
				(self setScript: (ScriptID 151 0) self) ; fightScript
			)
			(12
				(self setScript: (ScriptID 151 1) self) ; endFightScript
			)
			(13
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
				(localproc_0 lOrb 173 159)
				(= cycles 20)
			)
			(2
				(localproc_0 rOrb 297 143)
				(= cycles 20)
			)
			(3
				(localproc_0 lOrb 190 161)
				(= cycles 20)
			)
			(4
				(localproc_0 rOrb 278 150)
				(= cycles 20)
			)
			(5
				(localproc_0 lOrb 206 160)
				(= cycles 20)
			)
			(6
				(localproc_0 rOrb 257 158)
				(= cycles 20)
			)
			(7
				(localproc_0 lOrb (gEgo x:) (- (gEgo y:) 15))
				(EgoDead)
			)
		)
	)
)

(instance climbScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 15) ; diskette
					(Print 150 1) ; "*** You don't really want to go down there AGAIN..."
					(self dispose:)
				else
					(HandsOff)
					(gEgo setMotion: MoveTo 84 115 self)
				)
			)
			(1
				(gEgo setHeading: 270 self)
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
				(gEgo get: 15) ; diskette
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
				(self dispose:)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveFwd 20 self)
			)
			(1
				(gEgo setHeading: 180)
				(= cycles 8)
			)
			(2
				(gEgo
					setCycle: 0
					setStep: (gEgo xStep:) 19
					setPri: 3
					setMotion: MoveTo (gEgo x:) 300 self
				)
			)
			(3
				(EgoDead)
			)
		)
	)
)

(instance jrFreeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
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
			)
			(3
				(Print 150 2) ; "Hi, Dad. Let's go somewhere near a dangerous, mind-boggling drop to certain death and exchange insults about each other's looks."
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
				((ScriptID 152 0) init: addToPic:) ; driveCloseUp
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
		lookStr {*** It's Roger Jr!}
		view 522
		priority 4
		signal 16400
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
		loop 2
		priority 14
		signal 16400
	)
)

(instance police of Actor
	(properties
		x 349
		y 218
		view 521
		loop 1
		priority 6
		signal 16
	)
)

(instance vohaul of Prop
	(properties
		x 121
		y 84
		view 520
		priority 10
		signal 16
	)
)

(instance eyes of Prop
	(properties
		x 132
		y 69
		view 520
		loop 1
		cel 1
		priority 12
		signal 16
		cycleSpeed 2
	)
)

(instance mouth of Prop
	(properties
		x 122
		y 99
		view 520
		loop 2
		priority 11
		signal 16
	)
)

(instance diskDrive of Actor
	(properties
		x 120
		y 110
		description {disk drive}
		lookStr {It's a disk drive.}
		view 522
		loop 7
		priority 5
		signal 18448
		illegalBits 0
	)

	(method (cue)
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
			(6 ; Inventory
				(if (gAddToPics size:)
					((ScriptID 152 0) doVerb: theVerb invItem &rest) ; driveCloseUp
				else
					(if (== invItem 15) ; diskette
						((gInventory at: 15) owner: self) ; diskette
						(gEgo put: 15 gCurRoomNum) ; diskette
					)
					(self setScript: driveScript)
				)
			)
			(1 ; Look
				(if (not (gAddToPics contains: (ScriptID 152 0))) ; driveCloseUp
					(self setScript: driveScript)
				)
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
		lookStr {The ladder leads down to the floor far below.}
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

(instance bridge of Actor
	(properties
		x 193
		y 176
		view 522
		loop 8
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
		lookStr {The strange orbs crackle and sizzle with raw energy.}
		view 522
		loop 3
		priority 8
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and local3 (not (-- local3)))
			(if (= temp0 (< (Random 1 10) 5))
				(= loop 3)
			else
				(= loop 5)
			)
			(if temp0
				(if local2
					(lOrbZap number: 118 play:)
				)
				(self setCycle: Osc 1 self)
			else
				(if local2
					(lOrbZap number: 120 play:)
				)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(= local3 (Random 20 50))
		(lOrbZap stop:)
		(self stopUpd:)
		(super cue:)
	)
)

(instance rOrb of Prop
	(properties
		x 230
		y 87
		description {right orb}
		lookStr {The strange orbs crackle and sizzle with raw energy.}
		view 522
		loop 4
		priority 8
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and local4 (not (-- local4)))
			(if (= temp0 (< (Random 1 10) 5))
				(= loop 4)
			else
				(= loop 6)
			)
			(if temp0
				(if local2
					(rOrbZap number: 119 play:)
				)
				(self setCycle: Osc 1 self)
			else
				(if local2
					(rOrbZap number: 121 play:)
				)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(= local4 (Random 20 50))
		(rOrbZap stop:)
		(self stopUpd:)
		(super cue:)
	)
)

