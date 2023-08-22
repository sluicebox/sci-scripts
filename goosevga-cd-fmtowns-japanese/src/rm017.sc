;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm017 0
)

(local
	[local0 63] = [4 0 0 0 0 0 -14336 123 31 82 85 82 160 84 235 94 258 -32676 -14245 0 32 81 96 80 166 79 163 55 144 -32768 -14124 0 199 49 174 58 176 79 259 -32679 -14309 155 27 126 57 126 78 122 99 108 98 97 146 102 205 114 168 121 147 146 153 -32613 0]
)

(instance rm017 of Rm
	(properties
		picture 17
		style 0
		north 10
		east 18
		south 24
		west 16
	)

	(method (init)
		(super init:)
		(bfly init: setScript: bflyWait)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: EDGE_NONE posn: 172 70)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 58 (gEgo x:) 149) 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 47 84)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 89)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 124 116 init:)
			)
		)
		(if (and global130 (<= global130 47))
			(switch gPrevRoomNum
				(south
					(global129 observeControl: 128)
				)
				(45 ; mapRoom
					(global129 observeControl: (~ (gEgo onControl: 0)))
				)
				(else
					(global129 observeControl: 256)
				)
			)
		)
		(proc0_8 92 152)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== gScore gPossibleScore)
				(++ gScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((& (gEgo onControl: 1) $0010)
				(gStdWalkOut register: 4)
				(self setScript: gStdWalkOut)
			)
			((gEgo inRect: 155 62 185 68)
				(self newRoom: 10)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance bfly of Act
	(properties
		y 64
		x 50
		yStep 1
		view 151
		priority 6
		signal 26640
		illegalBits 0
		xStep 1
	)
)

(instance bflyWait of Script
	(properties)

	(method (doit)
		(if (< (bfly distanceTo: gEgo) 60)
			(bfly setScript: bflyLand)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 4))
			)
			(1
				(bfly setCycle: End self)
			)
			(2
				(bfly setCycle: Beg self)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance bflyLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bfly
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (gEgo x:) 12)
						(- (gEgo y:) 40)
						self
				)
			)
			(1
				(bfly
					setMotion:
						MoveTo
						(+ (gEgo x:) 12)
						(- (gEgo y:) 35)
						self
				)
			)
			(2
				(bfly
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 26) self
				)
			)
			(3
				(bfly cycleSpeed: 5)
				(if
					(or
						(!= (bfly x:) (gEgo x:))
						(!= (bfly y:) (- (gEgo y:) 26))
					)
					(bfly cycleSpeed: 0 setMotion: MoveTo 5 45 self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(bfly setPri: 15 setMotion: MoveTo 30 70 self)
			)
			(5
				(bfly setMotion: MoveTo -4 80 self)
			)
			(6
				(= seconds 3)
			)
			(7
				(bfly
					x: 96
					y: 169
					cycleSpeed: 2
					setStep: 2 2
					setLoop: 1
					setCel: 7
					setCycle: Beg self
					setMotion: MoveTo 110 30
				)
			)
			(8
				(= cycles 1)
			)
			(9
				(bfly
					setLoop: 2
					setCel: 1
					setCycle: Fwd
					setMotion: MoveTo 130 -10 self
				)
			)
			(10
				(bfly dispose:)
			)
		)
	)
)

