;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use MGRoom)
(use MoveProp)
(use PolyPath)
(use Polygon)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm029 0
)

(instance rm029 of MGRoom
	(properties
		picture 29
		north 22
		east 30
		edgeN 65
		edgeW -1
		edgeS 255
	)

	(method (init)
		(gGame handsOff:)
		(= global305 outCode)
		(super init:)
		(if (< (gEgo x:) 172)
			(self edgeN: 65)
		else
			(self edgeN: 57)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 262 57 230 57 223 70 162 79 122 65 86 65 52 87 86 108 262 100
					yourself:
				)
		)
		(proc0_1)
		(Load rsSCRIPT 106)
		((MoveProp new:) init: 176 0 189 121 13 yourself:)
		((MoveProp new:) init: 176 1 182 134 13 yourself:)
		((MoveProp new:) init: 176 2 162 149 13 yourself:)
		((MoveProp new:) init: 176 3 113 155 13 yourself:)
		(froggy init:)
		(switch gPrevRoomNum
			(north
				(if (> (gEgo x:) 160)
					(gEgo posn: 244 59)
				else
					(gEgo posn: 107 65)
				)
				(self setScript: gStdClimbIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 72 (gEgo y:) 98))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 150 100 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 153 97)
	)

	(method (doit &tmp temp0)
		(if (< (gEgo x:) 172)
			(self edgeN: 65)
		else
			(self edgeN: 57)
		)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) 1)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 106)
		(DisposeScript 401)
		(super dispose:)
	)
)

(instance froggy of Actor
	(properties
		x 31
		y 208
		priority 14
		view 804
		yStep 1
		signal 26641
		cycleSpeed 4
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(self setScript: frogScript)
	)
)

(instance frogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 12 25))
			)
			(1
				(froggy setMotion: MoveTo 31 155 self)
			)
			(2
				(= seconds (Random 2 4))
			)
			(3
				(froggy setCycle: End self)
			)
			(4
				(froggy setCycle: Beg self)
			)
			(5
				(= seconds (Random 1 3))
			)
			(6
				(froggy cel: 0 setCycle: End self)
			)
			(7
				(froggy setCycle: Beg self)
			)
			(8
				(= seconds (Random 1 3))
			)
			(9
				(if (and (not (gCurRoom script:)) (gUser controls:))
					(gSfx number: 39 play:)
				)
				(froggy cel: 0 setLoop: 1 setCycle: End self)
			)
			(10
				(froggy setCycle: Beg self)
			)
			(11
				(= seconds (Random 1 3))
			)
			(12
				(froggy cel: 0 setLoop: 2 cycleSpeed: 9 setCycle: CT 3 1 self)
			)
			(13
				(froggy yStep: 3 setMotion: MoveTo 61 111)
				(= ticks 26)
			)
			(14
				(froggy
					cel: 4
					cycleSpeed: 36
					setCycle: End
					posn: (+ (froggy x:) 21) (- (froggy y:) 38)
					yStep: 3
					setMotion: JumpTo 128 107 self
				)
			)
			(15
				(if (and (not (gCurRoom script:)) (gUser controls:))
					(gSfx number: 29 play:)
				)
				(froggy
					posn: 149 129
					setLoop: 3
					cel: 0
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(16
				(froggy dispose:)
				(DisposeScript 106)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 90 (gEgo x:) 242))
				(if (< (gEgo x:) 172)
					(= temp1 65)
				else
					(= temp1 57)
				)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 64 (gEgo y:) 103))
			)
			(3
				(= temp0 (proc0_13 90 (gEgo x:) 250))
				(= temp1 110)
			)
			(4
				(= temp0 45)
				(= temp1 (proc0_13 76 (gEgo y:) 98))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

