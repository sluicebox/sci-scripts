;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use n411)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm012 0
)

(local
	local0
	local1
)

(instance rm012 of MGRoom
	(properties
		picture 12
		south 19
		edgeN -1
		edgeE 320
		edgeW -1
	)

	(method (init)
		(= global305 outCode)
		(Load rsVIEW 125)
		(super init:)
		(if ((gGoals at: 10) egoReturned:)
			(peter setLoop: 8 1 cel: 5 posn: 107 114 init:)
			(wifeBareFoot init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 169 159 169 150 216 150 201 128 156 121 155 111 131 109 104 123 37 125 40 146 107 146 109 159
						yourself:
					)
			)
		else
			(peter init:)
			(gCurRoom
				addObstacle:
					(= local1
						((Polygon new:)
							type: PContainedAccess
							init: 169 159 170 151 215 150 202 129 159 129 157 88 133 88 132 112 107 114 101 120 36 125 40 147 107 147 108 159
							yourself:
						)
					)
			)
		)
		(proc0_1)
		(= global111 wifeBareFoot)
		(= global301 converse)
		(switch gPrevRoomNum
			(38
				(door cel: 5 init:)
				(gEgo posn: 144 117 init:)
				(self setScript: closeDoor)
			)
			(south
				(door init:)
				(if (== global130 41)
					(gEgo posn: 170 130)
				else
					(gEgo posn: 138 139)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(door init:)
				(if global172
					(gEgo posn: 168 147 init:)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(door init:)
				(gEgo posn: 168 147 init:)
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
			(
				(and
					(gEgo inRect: 125 96 161 116)
					(not ((gGoals at: 10) egoReturned:))
				)
				(self setScript: openDoor)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 312)
		(if ((gGoals at: 10) egoReturned:)
			(DisposeScript 601)
		)
		(super dispose: &rest)
	)
)

(instance doConverse of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 7)
			)
			(1
				(gCurRoom setScript: converse)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSfx number: 38 play:)
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 149 100 self)
			)
			(2
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(door setCycle: CT 2 -1 self)
			)
			(1
				(gSfx number: 36 play:)
				(door setCycle: Beg self)
			)
			(2
				(if global133
					(gCurRoom setScript: converse)
				else
					(gGame handsOn:)
					(gCurRoom setScript: 0)
				)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setCycle: CT 4 1 self)
			)
			(1
				(if (and (< (gEgo x:) 80) (> (gEgo y:) 120))
					(gEgo setMotion: MoveTo 168 147 self)
				else
					(self cue: self)
				)
			)
			(2
				(proc0_7 gEgo peter)
				(self cue: self)
			)
			(3
				(peter cel: 255)
				(= cycles 2)
				(peterHead
					init:
						peter
						(CelHigh (peter view:) (peter loop:) (peter cel:))
				)
				(= cycles 2)
			)
			(4
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
				(peterHead dispose:)
				(proc411_1)
				(peter cel: 4)
				(= cycles 2)
			)
			(1
				(peter setCycle: CT 0 -1 self)
			)
			(2
				(= global131 (+ (peter x:) 33))
				(= global132 (- (peter y:) 52))
				(= global128 97)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance atten2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setLoop: 11 1)
				(peterHead init: peter (- (CelHigh 77 11 0) 8))
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance atEase2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setLoop: 11 1)
				(peterHead init: peter (- (CelHigh 77 11 0) 8))
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance peter of Actor
	(properties
		x 174
		y 123
		view 77
		cycleSpeed 3
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(if ((gGoals at: 10) egoReturned:)
			(peter posn: 107 112 setLoop: 11 1 cel: 5)
			(peterHead
				init:
					peter
					(- (CelHigh (peter view:) (peter loop:) (peter cel:)) 8)
			)
		)
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

(instance peterHead of Head
	(properties
		view 77
		loop 1
	)

	(method (init)
		(super init: &rest)
		(= global152 self)
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

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 20)) 1)
					((> (gEgo x:) (+ (client x:) 10)) 3)
					(else 2)
				)
		)
		(super doit:)
	)
)

(instance door of Prop
	(properties
		x 127
		y 82
		view 125
		loop 1
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self cel: (if (== gPrevRoomNum 38) 255 else 0))
		(= global110 door)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance wifeBareFoot of Actor
	(properties
		x 149
		y 86
		view 77
		loop 10
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

(instance wifeLips of Head
	(properties
		view 77
		loop 12
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

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_7 gEgo peter)
			(= temp0 (gGoals at: 10))
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
				((temp0 egoReturned:)
					(self setScript: converse7 self 1)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 1)
					((gGoals at: 18) egoReturned: 1)
					(temp0 egoReturned: 1)
					(if (== global123 13)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 1)
					(= global123 13)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 1)
					(temp0 egoTold: 1)
					(= global123 13)
					(= local0 1)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(= gNarrator global516)
			(proc0_5)
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
				(gMessager say: 7 1 11 0 self) ; "Hello. Who are you?"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
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
				(gMessager say: 7 1 12 0 self) ; "You still here? Please go find my wife. Bring her on home."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 13)
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
				(gMessager say: 7 1 13 0 self) ; "Well, have you seen my wife?"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
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
				(gMessager say: 7 1 14 0 self) ; "(Sigh). I really miss my wife. Please hurry up and find her."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
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
				(peter setLoop: 4 1 setCycle: CT 6 1 self)
			)
			(2
				(peterHead init: peter (- (CelHigh (peter view:) 4 6) 14))
				(global129 setMotion: MoveTo 146 147 self)
			)
			(3
				(global129 setMotion: MoveTo 146 142 self)
			)
			(4
				(peter cel: 255)
				(= cycles 2)
			)
			(5
				(gLongSong fade:)
				(gMessager say: 7 1 15 1 self) ; "Here's your wife, Mr. Pumpkin Eater!"
			)
			(6
				(self setScript: (ScriptID 312) self) ; rhymeScript
			)
			(7
				(self setScript: atEase2 self)
			)
			(8
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 169 159 169 150 216 150 201 128 156 121 155 111 131 109 104 123 37 125 40 146 107 146 109 159
							yourself:
						)
				)
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
				(self setScript: atten2 self)
			)
			(1
				(gMessager say: 7 1 16 0 self) ; "I want to thank you, youngster, for convincing my wife to come on home. I think I can keep her happy now."
			)
			(2
				(self setScript: atEase2 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wifeLips
					init:
						wifeBareFoot
						(-
							(CelHigh
								(wifeBareFoot view:)
								(wifeBareFoot loop:)
								(wifeBareFoot cel:)
							)
							11
						)
				)
				(self setScript: atten2 self)
			)
			(1
				(gMessager say: 7 1 17 0 self) ; "How is everything, Mr. and Mrs. Pumpkin Eater?"
			)
			(2
				(self setScript: atEase2 self)
			)
			(3
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
			(13
				(peterHead setCycle: ROsc 10000 0)
			)
			(14
				(wifeLips setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(13
				(peterHead cel: 0 setCycle: 0)
			)
			(14
				(wifeLips cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 133 (gEgo x:) 157))
				(= temp1 80)
			)
			(2
				(= temp0 219)
				(= temp1 (proc0_13 126 (gEgo y:) 148))
			)
			(3
				(= temp0 (proc0_13 108 (gEgo x:) 166))
				(= temp1 158)
			)
			(4
				(= temp0 30)
				(= temp1 (proc0_13 123 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

