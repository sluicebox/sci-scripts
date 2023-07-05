;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQCursor)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm024 0
)

(local
	local0
	local1
	local2
	local3
	[local4 8] = [99 189 115 177 319 177 319 189]
	[local12 12] = [0 189 0 136 86 136 59 150 85 156 13 189]
	[local24 16] = [0 0 319 0 319 102 219 109 204 128 153 128 141 121 0 121]
	[local40 20] = [0 189 0 0 319 0 319 101 253 102 166 121 109 121 60 149 86 154 12 189]
)

(procedure (localproc_0)
	(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
		(17
			(SetScore 4)
			(gEgo put: 17 24) ; Honeycomb
			(HandsOff)
			(gEgo get: 18) ; Beeswax
			(gCurRoom setScript: squeeze)
			(return 1)
		)
		(14
			(if (not (gCurRoom script:))
				(SetScore 2)
				(gCurRoom setScript: throwEmerald)
			)
			(return 1)
		)
		(28
			(return 0)
		)
		(else
			(if (and (== ((gInventory at: 6) owner:) 200) (not (IsFlag 56))) ; Brass_Bottle
				(PrintDC 24 0) ; "This situation seems to require very careful thought. Graham needs to spend more time on this."
				(return 1)
			)
		)
	)
)

(instance rm024 of KQ5Room
	(properties
		picture 24
		east 22
		south 25
		west 81
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 315 108)
			)
			(west
				(gEgo posn: 20 123)
			)
			(208 ; releaseGenie
				(gEgo posn: global110 global111 view: 0)
				(NormalEgo 0 0)
			)
			(else
				(gEgo posn: 83 187)
			)
		)
		(self setFeatures: path24 forest setRegions: 200 551 552) ; witchRegion, toadRegion, spiderRegion
		(if (== ((gInventory at: 17) owner:) 24) ; Honeycomb
			(puddle posn: 138 126 init: stopUpd:)
		)
		(if (IsFlag 56)
			(jinx posn: 176 126 init: stopUpd:)
			(self addObstacle: poly1 poly2 poly3)
		else
			(jinx init: stopUpd:)
			(self addObstacle: poly1 poly4)
		)
		(gEgo view: 0 init:)
		((= local2 (Clone elf)) posn: 56 77 init:)
		((= local3 (Clone elf)) posn: 175 81 init:)
		(elf init: setScript: blink)
		(if (or (!= ((gInventory at: 6) owner:) 200) (IsFlag 56)) ; Brass_Bottle
			(elf hide:)
			(local2 hide:)
			(local3 hide:)
		)
		(poly1 points: @local4 size: 4)
		(poly2 points: @local12 size: 6)
		(poly3 points: @local24 size: 8)
		(poly4 points: @local40 size: 10)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(if local0
					(SetFlag 13)
				)
				((ScriptID 200 1) register: temp0) ; poofOutScript
				(self setScript: (ScriptID 200 1) 0 (gEgo edgeHit:)) ; poofOutScript
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
			(
				(and
					(== (event type:) evVERB)
					(MousedOn gEgo event)
					(== (event message:) 4) ; Inventory
				)
				(event claimed: (localproc_0))
			)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(DisposeScript 982)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gGlobalSound2 fade:)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elf setCycle: End)
				(= seconds (Random 2 4))
			)
			(1
				(local2 setCycle: End)
				(= seconds (Random 2 4))
			)
			(2
				(local3 setCycle: End)
				(= seconds (Random 2 4))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance squeeze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 125 126 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 469
					loop: 0
					cel: 0
					x: (+ (gEgo x:) 5)
					cycleSpeed: 1
					setCycle: End self
				)
				(gGlobalSound3 number: 77 priority: 15 loop: 1 vol: 127 play:)
			)
			(2
				(puddle posn: (+ (gEgo x:) 13) (gEgo y:) init:)
				(= cycles 5)
			)
			(3
				(PrintDC 24 1) ; "Squeezing the honeycomb as hard as he can, Graham causes the honey to drip out of it onto the ground creating a little "puddle" of honey at his feet. Now all that's left of the honeycomb is a piece of beeswax, which Graham pockets."
				(gEgo
					normal: 1
					view: 0
					illegalBits: -32768
					loop: 0
					x: (- (gEgo x:) 5)
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance throwEmerald of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (> state 32) (== (gEgo x:) 81))
			(proc0_7 gEgo jinx 5)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 122 126 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 469
					cel: 0
					cycleSpeed: 1
					x: (+ (gEgo x:) 8)
				)
				(if (== global312 1)
					(gEgo loop: 2 setCycle: End self)
				else
					(gEgo loop: 1 setCycle: CT 5 1 self)
				)
			)
			(2
				(if (== global312 1)
					(self cue:)
				else
					(gEgo setCycle: End)
					(gem x: 145 y: 107 init:)
					(if (== global312 2)
						(gem setMotion: JumpTo 164 120 self)
					else
						(gem setMotion: JumpTo 184 120 self)
					)
				)
			)
			(3
				(if (== global312 1)
					(self cue:)
				else
					(gem setMotion: JumpTo (+ (gem x:) 5) 120 self)
					(gGlobalSound3 number: 85 loop: 1 vol: 127 play:)
				)
			)
			(4
				(if (== (-- global312) 0)
					(gem init: x: 140 y: 124 setPri: (+ (puddle priority:) 1))
					(HandsOn)
					(gEgo put: 14 24) ; Emeralds
					(HandsOff)
					(gGlobalSound3 number: 105 loop: 1 vol: 127 play:)
				else
					((gInventory at: 14) cel: (+ (- global312 1) 4)) ; Emeralds
				)
				(gem setScript: glintScript)
				(= cycles 30)
			)
			(5
				(elf
					loop: 2
					cel: 0
					setStep: 2 4
					setCycle: End
					cycleSpeed: 4
					setMotion: MoveTo 214 113 self
					setScript: 0
				)
				(gGlobalSound2 number: 88 loop: 1 vol: 127 play:)
			)
			(6
				(elf
					setLoop: 10
					cel: 0
					setStep: 2 2
					setCycle: Walk
					cycleSpeed: 1
					ignoreActors: 1
					setMotion: MoveTo (+ (gem x:) 7) (+ (gem y:) 3) self
				)
				(if (and (== global312 0) (== ((gInventory at: 17) owner:) 24)) ; Honeycomb
					(= state 12)
				)
			)
			(7
				(elf setLoop: 3 cel: 0 setCycle: CT 5 1 self)
			)
			(8
				(gem dispose:)
				(gEgo loop: 3 cel: 0 setCycle: CT 1 1)
				(elf setCycle: End self)
			)
			(9
				(if (== global312 0)
					(PrintDC 24 2 #dispose) ; "Drat! Just missed him!"
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(10
				(cls)
				(gEgo setCycle: Beg)
				(elf
					setLoop: 4
					cel: 0
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 214 113 self
				)
				(gGlobalSound2 number: 89 loop: 1 vol: 127 play:)
			)
			(11
				(elf
					setLoop: 12
					cel: 0
					setCycle: End
					setMotion: MoveTo 222 76 self
				)
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					loop: 0
					x: (- (gEgo x:) 8)
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
			)
			(12
				(elf view: 468 loop: 1 posn: 222 76 setScript: blink)
				(HandsOn)
				(client setScript: 0)
			)
			(13
				(elf loop: 14 cel: 0 setCycle: CT 5 1 self)
				(gGlobalSound3 number: 84 loop: -1 vol: 127 play:)
			)
			(14
				(gem dispose:)
				(elf setCycle: End self)
			)
			(15
				(elf cel: 0 setCycle: End self)
				(gEgo cycleSpeed: 0)
			)
			(16
				(gGlobalSound3 stop:)
				(gGlobalSound2 number: 86 loop: -1 vol: 127 play:)
				(gEgo loop: 3 cel: 0 setCycle: CT 1 1 self)
			)
			(17
				(elf hide:)
				(gEgo setCycle: CT 4 1 self)
			)
			(18
				(gEgo setCycle: End)
				(elf show: loop: 5 posn: 140 110 setMotion: 0 setCycle: Fwd)
				(local2 dispose:)
				(local3 dispose:)
				(= cycles 30)
			)
			(19
				(proc0_28 79 24 3 67 60 100 25 5) ; "Please! Let me go...I beg of you!"
				(RedrawCast)
				(= cycles 1)
			)
			(20
				(proc0_28 160 24 4 67 8 100 25 7) ; "Why should I do that? What will you do for me?"
				(RedrawCast)
				(= cycles 1)
			)
			(21
				(proc0_28 79 24 5 67 60 100 25 7) ; "I'll show you the way out of the forest...if you let me go!"
				(RedrawCast)
				(= cycles 1)
			)
			(22
				(proc0_28 160 24 6 67 8 100 25 6) ; "How do I know I can trust you?"
				(RedrawCast)
				(= cycles 1)
			)
			(23
				(proc0_28 79 24 7 67 60 100 25 7) ; "I give you my word. An elf NEVER breaks his word!"
				(RedrawCast)
				(= cycles 1)
			)
			(24
				(proc0_28 160 24 8 67 8 100 25 6) ; "Well...it's against my better judgement, but...okay."
				(RedrawCast)
				(= cycles 1)
			)
			(25
				(elf hide:)
				(gEgo setPri: -1 loop: 4 cel: 0 setCycle: CT 3 1 self)
				(gGlobalSound2 stop:)
			)
			(26
				(gEgo setPri: -1 cel: (gEgo lastCel:))
				(elf
					posn: (+ (gEgo x:) 14) (gEgo y:)
					setLoop: 5
					cel: 0
					show:
				)
				(= cycles 1)
			)
			(27
				(elf
					setLoop: 10
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo 111 130 self
				)
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					loop: 0
					setStep: 3 2
					ignoreControl: 16384
				)
				((gEgo head:) show:)
			)
			(28
				(proc0_7 gEgo jinx)
				(jinx setCycle: End)
				(Print 24 9 #at 110 140 #dispose) ; "Move over, Rocky. You're in our way!"
				(= seconds 7)
			)
			(29
				(elf view: 469 setLoop: 6 cel: 0 setCycle: CT 6 1 self)
			)
			(30
				(gem
					init:
					loop: 15
					x: 98
					y: 115
					setScript: 0
					setMotion: JumpTo 67 (gem y:)
				)
				(elf setCycle: End)
				(jinx loop: 13)
				(jinxHead
					setPri: (+ (jinx priority:) 1)
					init:
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(31
				(cls)
				(jinxHead dispose:)
				(Print 24 10 #at 30 30 #dispose) ; "Uh...sorry."
				(gem dispose:)
				(jinx
					setLoop: 9
					cel: 0
					setCycle: Walk
					cycleSpeed: 2
					setMotion: MoveTo 176 126
				)
				(= cycles 10)
			)
			(32
				(gEgo
					setCycle: KQ5SyncWalk
					setLoop: -1
					moveSpeed: 0
					setMotion: MoveTo 81 144
				)
				(= cycles 25)
			)
			(33
				(cls)
				(jinx
					setLoop: 9
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 176 126 self
				)
			)
			(34
				(jinx setLoop: 10 cel: 0 setCycle: CT 4 1 self)
			)
			(35
				(jinx setCycle: Beg self)
			)
			(36
				(jinx setCycle: End self)
			)
			(37
				(= cycles 10)
			)
			(38
				(jinx setLoop: 7)
				(jinx cel: (jinx lastCel:) setCycle: Beg self)
			)
			(39
				(SetFlag 56)
				(jinx loop: 7 cel: 0)
				((gCurRoom obstacles:) delete: poly4)
				(gCurRoom addObstacle: poly2 poly3)
				(= cycles 1)
			)
			(40
				(elf
					view: 468
					setLoop: 10
					setCycle: Walk
					setMotion: MoveTo 58 120 self
				)
			)
			(41
				(HandsOn)
				(elf dispose:)
				(gEgo
					moveSpeed: (gGame egoMoveSpeed:)
					illegalBits: -32768
					setCycle: KQ5SyncWalk
					setLoop: -1
				)
				(client setScript: 0)
			)
		)
	)
)

(instance glintScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gem setCycle: End)
				(= cycles (Random 10 25))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance path24 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 24 11) ; "From here, the narrow rocky path leads east and south through the gloomy forest."
					(event claimed: 1)
				)
				(4 ; Inventory
					(event claimed: (localproc_0))
				)
			)
		)
	)
)

(instance forest of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 24 12) ; "Strange plants and animals inhabit this dark and dreary place while thin rays of sunlight barely break the surface of the forest's thick foliage."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance elf of Actor
	(properties
		x 222
		y 76
		view 468
		loop 1
		signal 16384
		cycleSpeed 4
		illegalBits 0
	)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
				(!= ((gInventory at: 6) owner:) 200) ; Brass_Bottle
				(IsFlag 56)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 24 13) ; "Peering curiously at him through the heavy foliage of the dark forest, Graham notices several pairs of bright, blinking eyes."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local1)
						(PrintDC 24 14) ; "Graham can SEE the eyes, but he can't quite reach them."
					)
					(event claimed: 1)
				)
				(5 ; Talk
					(cond
						((not (IsFlag 13))
							(event claimed: 1)
							(if (not local0)
								(++ local0)
								(proc0_28 160 24 15 67 8 100 25 4) ; "Hello? Who's there?"
								(proc0_28 160 24 16 67 8 100 25 5) ; "I say...who's there? Please help me."
								(proc0_28 160 24 17 67 8 100 25 4) ; "Please...oh, never mind."
							else
								(PrintDC 24 18) ; "No answer."
							)
						)
						((not local0)
							(++ local0)
							(PrintDC 24 19) ; "It appears that whomever is watching Graham is unwilling to indulge in conversation."
						)
						(else
							(PrintDC 24 18) ; "No answer."
						)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(14
							(if (!= ((gInventory at: 6) owner:) 200) ; Brass_Bottle
								(PrintDC 24 20) ; "Graham decides to wait until he sees a good reason to toss away these fine emeralds."
								(event claimed: 1)
							else
								(if (not (gCurRoom script:))
									(SetScore 2)
									(gCurRoom setScript: throwEmerald)
								)
								(event claimed: 1)
							)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 24 21) ; "The small creatures, whoever they are, don't seem to be interested in it."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance puddle of Prop
	(properties
		x 138
		y 126
		view 469
		loop 12
		priority 1
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 24 22) ; "A sticky mess of honey lies on the ground."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance jinx of Actor
	(properties
		x 71
		y 126
		view 469
		loop 7
		signal 16384
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (< (self x:) 100)
						(PrintDC 24 23) ; "A large rock-like creature blocks further passage to the west."
					else
						(PrintDC 24 24) ; "Rocky has moved aside to allow Graham passage through the forest."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (> (self x:) 100)
						(PrintDC 24 25) ; "The creature is not inclined to move further."
						(event claimed: 1)
					)
				)
				(5 ; Talk
					(if (> (self x:) 100)
						(PrintDC 24 26) ; "Rocky isn't talking."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance jinxHead of Prop
	(properties
		x 75
		y 126
		z 8
		view 469
		loop 8
		signal 16385
		cycleSpeed 3
	)
)

(instance gem of Actor
	(properties
		view 469
		loop 14
		signal 16384
		illegalBits 0
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance oneEmeraldCursor of KQCursor ; UNUSED
	(properties
		number 27
	)

	(method (init)
		(if global400
			(self number: 27 yourself:)
		)
		(super init: &rest)
	)
)

(instance twoEmeraldCursor of KQCursor ; UNUSED
	(properties
		number 27
	)

	(method (init)
		(if global400
			(self number: 27 yourself:)
		)
		(super init: &rest)
	)
)

(instance threeEmeraldCursor of KQCursor ; UNUSED
	(properties
		number 27
	)

	(method (init)
		(if global400
			(self number: 27 yourself:)
		)
		(super init: &rest)
	)
)

(instance arrowCursor of KQCursor ; UNUSED
	(properties
		number 999
	)

	(method (init)
		(if global400
			(self number: 999 yourself:)
		)
		(super init: &rest)
	)
)

