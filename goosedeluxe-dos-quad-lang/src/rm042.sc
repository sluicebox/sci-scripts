;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use MoveProp)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm042 0
)

(local
	local0
	[local1 20] = [14 18 18 5 11 12 10 3 4 8 16 17 17 15 13 9 2 6 7 19]
	[local21 18] = [57 48 49 44 58 59 50 56 47 45 46 55 41 54 51 52 0 60]
	[local39 44] = [0 4 0 12 0 11 0 4 4 0 12 0 0 11 0 3 6 0 5 13 0 3 0 15 15 15 0 7 8 14 0 0 0 9 9 0 0 0 2 0 0 0 0 1]
)

(instance rm042 of MGRoom
	(properties
		picture 42
		south 32
		edgeN -1
		edgeE 300
		edgeW -1
		edgeS 138
	)

	(method (init)
		(super init:)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 146 170 142 128 152 123 154 113 184 111 203 116 213 110 192 95 188 105 140 105 141 93 89 92 77 88 62 100 81 107 57 124 116 127 114 170
					yourself:
				)
		)
		(gEgo init:)
		(if (== gPrevRoomNum 45) ; mapRoom
			0
			(gGame handsOn:)
		else
			(gEgo posn: 129 132)
			(= gPrevRoomNum 32)
			(self setScript: gStdWalkIn)
		)
		(mother init:)
		((MoveProp new:) init: 75 3 117 69 7 yourself:)
		(= global301 converse)
		(proc0_8 0 0 130 136)
		(fireSound play:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((> (gEgo y:) 140)
				(fireSound stop:)
				(self setScript: gStdWalkOut 0 3)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(if (< temp0 130)
					(= temp0 130)
				)
				(if (> temp1 110)
					(= temp1 110)
				)
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(proc0_7 gEgo mother)
				(if (mother cel:)
					(mother setCycle: End self)
				else
					(mother setCycle: 0)
					(= cycles 1)
				)
			)
			(2
				(mother
					setLoop:
						(cond
							((< (gEgo x:) (- (mother x:) 20)) 2)
							((> (gEgo x:) (+ (mother x:) 20)) 4)
							(else 3)
						)
						1
				)
				(= cycles 2)
			)
			(3
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
				(mother setLoop: 0 1 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mother of Actor
	(properties
		x 170
		y 100
		view 91
		cycleSpeed 15
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
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

(instance fireSound of Sound
	(properties
		flags 1
		number 590
		loop -1
	)

	(method (stop)
		(if handle
			(super stop: &rest)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState)
		(gGame handsOff:)
		(if (not (= state newState))
			(if (not global172)
				(proc0_7 gEgo mother)
			)
			(fireSound fade: 0 4 4 1)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_20)
			(cond
				(global130
					(self setScript: converse2 self 1)
				)
				(global123
					(self setScript: converse3 self 1)
				)
				(else
					(self setScript: converse1 self)
				)
			)
		else
			(fireSound play: setVol: 0 fade: 127 4 4 0)
			(= gNarrator global516)
			(gGame handsOn:)
			(client setScript: 0)
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
				(gMessager say: 1 1 1 (Random 1 6) self 0)
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(if (== global130 (+ 58 (* 100 gLanguage)))
					(= local0 17)
				else
					(= local0 (- global130 41))
				)
				(= register [local1 local0])
				(gMessager say: 1 1 register 0 self 0)
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

(instance converse3 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 1 1 21 global123 self 0)
			)
			(2
				(if (= temp0 [local21 (- global123 1)])
					(for ((= temp1 0)) (< temp1 45) ((++ temp1))
						(if (== [global200 temp1] temp0)
							(break)
						)
					)
				else
					(= temp1 9)
				)
				(cond
					((!= temp0 41)
						(gMessager say: 1 1 20 (+ 1 [local39 (-- temp1)]) self 0)
					)
					((< [local39 (- temp1 1)] 8)
						(gMessager say: 1 1 50 (+ 1 [local39 (-- temp1)]) self 0)
					)
					(else
						(gMessager say: 1 1 20 (+ 1 [local39 (-- temp1)]) self 0)
					)
				)
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
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
			(26
				(mother setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(26
				(mother cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 71 (gEgo x:) 142))
				(= temp1 83)
			)
			(2
				(= temp0 219)
				(= temp1 (proc0_13 87 (gEgo y:) 113))
			)
			(3
				(= temp0 (proc0_13 114 (gEgo x:) 151))
				(= temp1 151)
			)
			(4
				(= temp0 56)
				(= temp1 (proc0_13 87 (gEgo y:) 122))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

