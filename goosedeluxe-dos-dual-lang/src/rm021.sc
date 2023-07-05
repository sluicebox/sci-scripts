;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use PAvoider)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	local0
	local1
	local2
)

(instance rm021 of MGRoom
	(properties
		picture 21
		south 28
		edgeN -1
		edgeE 320
		edgeW -1
	)

	(method (init)
		(= global305 outCode)
		(= local0 0)
		(Load rsVIEW 128)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 52 139 38 155 38 196 -1 196 0 0 315 0 315 196 258 196 257 156 215 124 225 111 211 99 186 93 176 93 177 95 180 95 179 114 179 115 155 108 109 119 44 108 47 93 39 93 17 120 17 127
					yourself:
				)
		)
		(gCurRoom
			addObstacle:
				(= local2
					((Polygon new:)
						type: PBarredAccess
						init: 63 112 63 126 29 126 30 112
						yourself:
					)
				)
		)
		(gCurRoom
			addObstacle:
				(= local1
					((Polygon new:)
						type: PBarredAccess
						init: 80 139 93 137 95 150 56 150 56 137
						yourself:
					)
				)
		)
		(proc0_1)
		(if (not ((gGoals at: 11) egoReturned:))
			(mother init:)
			(kid0 init:)
			(kid1 init:)
			(kid2 init:)
			(kid3 init:)
			(kid4 init:)
			(= global301 converse)
		)
		(if (and global130 (<= global130 47) (== gPrevRoomNum 44))
			(global129 posn: 189 116)
		)
		(door init:)
		(switch gPrevRoomNum
			(south
				(gEgo
					posn: (proc0_13 54 (gEgo x:) 249) 139
					ignoreBlocks: 1
				)
				(self setScript: gStdWalkIn)
				(if (not ((gGoals at: 11) egoReturned:))
					(playSound play:)
				)
			)
			(44
				(gEgo posn: 182 95 init:)
				(self setScript: closeDoorScript)
			)
			(45 ; mapRoom
				(if (not ((gGoals at: 11) egoReturned:))
					(playSound play:)
				)
				(if global172
					(gEgo posn: 193 136 init:)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 193 136 init:)
				(if (not ((gGoals at: 11) egoReturned:))
					(playSound play:)
				)
				(gGame handsOn:)
			)
		)
		(proc0_8)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 173 77 190 100)
				(self setScript: openDoorScript)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(playSound stop:)
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 321)
		(super dispose: &rest)
	)
)

(instance playSound of Sound
	(properties
		flags 1
		number 18
		loop -1
	)

	(method (stop)
		(if handle
			(super stop: &rest)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 182 98 self)
				(gEgo loop: 3)
			)
			(1
				(door setCycle: End self)
				(gSfx number: 38 play:)
			)
			(2
				(gEgo setMotion: MoveTo 182 92 self)
			)
			(3
				(gGame handsOn:)
				(gCurRoom newRoom: 44)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 186 101 self)
				(door cycleSpeed: 5 setCycle: Beg self)
				(= ticks 30)
			)
			(1
				(gSfx number: 36 play:)
				(if (not ((gGoals at: 11) egoReturned:))
					(playSound play:)
				)
			)
			(2
				(gEgo setMotion: MoveTo 183 125 self)
			)
			(3
				(gGame handsOn:)
				(if (not ((gGoals at: 11) egoReturned:))
					(gCurRoom cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					observeControl: 4
					setAvoider: PAvoider
					setMotion: PolyPath 194 132 self
				)
			)
			(1
				(gEgo setAvoider: 0 ignoreControl: 4)
				(proc0_7 gEgo mother)
				(mother setLoop: 6)
				(motherHead
					init:
						mother
						(CelHigh (mother view:) (mother loop:) (mother cel:))
				)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance atEaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(motherHead dispose:)
				(mother setLoop: 5)
				(if (<= global170 110)
					(mother setCel: 3)
				)
				(= cycles 2)
			)
			(1
				(gCurRoom cue:)
				(self dispose:)
			)
		)
	)
)

(instance mother of Actor
	(properties
		x 231
		y 125
		view 79
		loop 5
		cel 3
		yStep 1
		cycleSpeed 12
		illegalBits 0
		xStep 1
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
		(= global109 self)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)
)

(instance motherHead of Head
	(properties
		view 79
		loop 7
	)

	(method (init)
		(super init: &rest)
		(= global133 motherHead)
		(= global152 self)
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self setPri: (client priority:))
			(= x (client x:))
			(= y (client y:))
			(= z
				(-
					(+
						(client z:)
						(CelHigh (client view:) (client loop:) (client cel:))
					)
					1
				)
			)
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) 20)) 8)
						((> (gEgo x:) (+ (client x:) 20)) 9)
						(else 7)
					)
			)
		)
		(super doit:)
	)
)

(instance kid0 of Actor
	(properties
		x 92
		y 68
		view 79
		cycleSpeed 9
		illegalBits 0
		moveSpeed 9
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
		(= global110 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance hole of View ; UNUSED
	(properties
		x 67
		y 148
		view 79
		loop 10
		signal 16385
	)
)

(instance kid1 of Actor
	(properties
		x 75
		y 148
		view 79
		loop 1
		cycleSpeed 9
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(= global111 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance kid2 of Actor
	(properties
		x 129
		y 69
		view 79
		loop 2
		signal 8193
		cycleSpeed 9
		illegalBits 0
		xStep 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
		(= global112 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance kid3 of Actor
	(properties
		x 45
		y 122
		priority 12
		view 79
		loop 3
		cycleSpeed 12
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(= global113 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance kid4 of Actor
	(properties
		x 180
		y 47
		priority 12
		view 79
		loop 4
		signal 8209
		cycleSpeed 9
		illegalBits 0
	)

	(method (init)
		(if (!= global130 54)
			(self setCycle: Fwd)
			(super init:)
		)
		(= global120 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door of Prop
	(properties
		x 193
		y 94
		priority 6
		view 128
		signal 16385
		cycleSpeed 12
	)

	(method (init)
		(self setCel: (if (== gPrevRoomNum 44) 5 else 0))
		(super init:)
		(= global122 self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(playSound fade: 0 4 4 1)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(gGame handsOff:)
			(= temp0 (gGoals at: 11))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 1)
						)
						(2
							(self setScript: converse4 self 1)
						)
						(else
							(self setScript: converse6 self 1)
						)
					)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 1)
					(temp0 egoReturned: 1)
					(= local0 3)
					(if (== global123 14)
						(= global123 0)
					)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 1)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 1)
					(temp0 egoTold: 1)
					(= local0 1)
				)
			)
		else
			(if (not ((gGoals at: 11) egoReturned:))
				(playSound play: setVol: 0 fade: 127 4 4 0)
			)
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(= gNarrator global516)
			(gGame handsOn:)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 11 1 2 0 self) ; "What's a mother to do!"
			)
			(2
				(= global131 (+ (mother x:) -20))
				(= global132 (- (mother y:) 72))
				(= global128 110)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global123 14)
				(self dispose:)
			)
		)
	)
)

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 11 1 3 0 self) ; "You're not helping me by standing around here! Go bring back a bowl of broth!"
			)
			(2
				(= global131 (+ (mother x:) -20))
				(= global132 (- (mother y:) 72))
				(= global128 110)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global123 14)
				(self dispose:)
			)
		)
	)
)

(instance converse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 11 1 4 0 self) ; "There you are again. Have you brought back a bowl of broth for me?"
			)
			(2
				(= global131 (+ (mother x:) -20))
				(= global132 (- (mother y:) 72))
				(= global128 110)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global123 14)
				(self dispose:)
			)
		)
	)
)

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 11 1 5 0 self) ; "Hurry up! Don't dilly-dally. I need a bowl of broth!"
			)
			(2
				(= global131 (+ (mother x:) -20))
				(= global132 (- (mother y:) 72))
				(= global128 110)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global123 14)
				(self dispose:)
			)
		)
	)
)

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(playSound stop:)
				(gLongSong fade:)
				(gMessager say: 11 1 6 0 self) ; "I found you a bowl of broth!"
			)
			(2
				(self setScript: (ScriptID 321) self) ; rhymeScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				((gCurRoom obstacles:) delete: local2)
				((gCurRoom obstacles:) delete: local1)
				(local2 dispose:)
				(local1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (Random 0 1)
					(gMessager say: 1 1 33 (Random 1 29) self 0)
				else
					(gMessager say: 1 1 34 (Random 1 21) self 0)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(25
				(motherHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(25
				(motherHead cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 35 (gEgo x:) 205))
				(= temp1 77)
			)
			(2
				(= temp0 253)
				(= temp1 (proc0_13 105 (gEgo y:) 151))
			)
			(3
				(= temp0 (proc0_13 38 (gEgo x:) 250))
				(= temp1 158)
			)
			(4
				(= temp0 8)
				(= temp1 (proc0_13 114 (gEgo y:) 140))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

