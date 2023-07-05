;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm018 0
)

(local
	local0
	local1
)

(instance rm018 of Rm
	(properties
		picture 18
		style 0
		north 11
		east 19
		south 25
		west 17
		vanishingX 131
		vanishingY -90
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 162 66 154 53 151 39 151 0 315 0 315 85 214 84 203 77 187 71 164 66
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 315 196 179 196 177 155 170 128 171 128 207 115 218 102 226 98 315 99
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 86 155 92 196 0 196 0 98 28 98 29 100 48 116 75 124 92 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 112 1 112 37 105 62 100 67 75 71 57 78 44 84 0 84
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 167 113 103 114 78 101 75 92 79 82 107 70 159 70 183 81 185 90 184 98 179 105
					yourself:
				)
		)
		(petal1 init:)
		(petal2 init:)
		(petal3 init:)
		(petal4 init:)
		(fountainMan init: stopUpd:)
		(namePlate init: stopUpd:)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 111 50)
				(self setScript: global145 0 17)
			)
			(south
				(gEgo posn: 130 139)
				(self setScript: gStdWalkIn 0 17)
			)
			(west
				(gEgo posn: 26 89)
				(self setScript: gStdWalkIn 0 17)
			)
			(east
				(gEgo posn: 231 87)
				(self setScript: gStdWalkIn 0 17)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(= global341 converse)
		(proc0_8)
		(if global172
			(self setScript: converse)
			(+= global114 300)
			(gEgo view: global114)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(gEgo setAvoider: 0)
		(super dispose:)
	)
)

(instance fountainMan of CDActor
	(properties
		x 132
		y 92
		z 10
		view 666
		loop 3
		signal 16384
		cycleSpeed 6
		illegalBits 0
	)
)

(instance petal1 of Actor
	(properties
		x 54
		y -20
		yStep 1
		view 666
		loop 1
		priority 7
		signal 26640
		cycleSpeed 9
		illegalBits 0
		xStep 1
		moveSpeed 9
	)

	(method (init)
		(super init:)
		(self cel: (Random 0 9) setCycle: Fwd setScript: petal1Script)
	)
)

(instance ring of Actor
	(properties
		yStep 1
		view 666
		loop 2
		priority 7
		signal 18448
		cycleSpeed 12
		illegalBits 0
		xStep 1
		moveSpeed 15
	)

	(method (init)
		(super init:)
		(self posn: (petal1 x:) (petal1 y:))
	)
)

(instance petal1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(reflection addToPic:)
				(= cycles 2)
			)
			(1
				(reflection signal: 16384 setLoop: 0 init: setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(= seconds (Random 4 14))
			)
			(3
				(petal1
					posn: 54 10
					cel: 0
					setMotion: MoveTo 106 (Random 80 85) self
				)
			)
			(4
				(ring init: setCycle: End self)
				(petal1 posn: 54 -20)
			)
			(5
				(= seconds 3)
			)
			(6
				(ring setCel: 255 setMotion: MoveTo (ring x:) 92 self)
			)
			(7
				(ring dispose:)
				(= seconds 2)
				(= state 1)
			)
		)
	)
)

(instance petal2 of Actor
	(properties
		x -89
		y 106
		yStep 1
		view 666
		loop 1
		priority 15
		signal 26640
		cycleSpeed 9
		illegalBits 0
		xStep 1
		moveSpeed 9
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setScript: petal2Script)
	)
)

(instance petal2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 12))
			)
			(1
				(petal2
					cel: (Random 0 9)
					posn: 89 106
					setMotion: MoveTo (Random 120 145) 159 self
				)
				(= state -1)
			)
		)
	)
)

(instance petal3 of Actor
	(properties
		x -28
		y 80
		yStep 1
		view 666
		loop 1
		priority 12
		signal 26640
		cycleSpeed 9
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd moveSpeed: 9 setScript: petal3Script)
	)
)

(instance petal3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 13))
			)
			(1
				(petal3
					cel: (Random 0 9)
					posn: 68 80
					setMotion: MoveTo (Random 120 130) (Random 130 140) self
				)
			)
			(2
				(DrawCel 666 1 (petal3 cel:) (petal3 x:) (petal3 y:) 0)
				(petal3 posn: -68 80)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance petal4 of Actor
	(properties
		x 259
		y 30
		yStep 1
		view 666
		loop 1
		priority 12
		signal 26640
		cycleSpeed 9
		illegalBits 0
		xStep 1
		moveSpeed 9
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setScript: petal4Script)
	)
)

(instance petal4Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 11))
			)
			(1
				(petal4
					cel: (Random 0 9)
					posn: 209 30
					setMotion: MoveTo 259 119 self
				)
				(= state -1)
			)
		)
	)
)

(instance reflection of Prop
	(properties
		x 131
		y 91
		view 666
		loop 6
		signal 16384
		cycleSpeed 15
	)
)

(instance namePlate of View
	(properties
		x 132
		y 107
		view 666
		loop 5
		signal 16384
	)
)

(instance attention of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc411_0 (gEgo head:) fountainMan)
				(fountainMan startUpd: setCycle: End self)
			)
			(1
				(fountainMan setLoop: 4)
				(self dispose:)
			)
		)
	)
)

(instance atEase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fountainMan setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(1
				(proc411_1)
				(fountainMan stopUpd:)
				(if register
					(= global123 18)
					(= global131 (fountainMan x:))
					(= global132 (- (fountainMan y:) 60))
					(= global128 116)
					(self setScript: (ScriptID 400) self) ; envisionScript
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 138 120 self)
				(= cycles 10000)
			)
			(1
				(= cycles 0)
				(proc0_7 gEgo fountainMan)
				(= temp0 (gGoals at: 17))
				(proc0_20)
				(cond
					(local1
						(self setScript: converse2 self local1)
					)
					((temp0 egoReturned:)
						(self setScript: converse6 self 408)
					)
					((temp0 egoHas:)
						(self setScript: converse5 self 407)
						(temp0 egoReturned: 1)
					)
					((temp0 egoTold:)
						(self setScript: converse3 self 403)
						(= local1 406)
					)
					(else
						(self setScript: converse1 self 394)
						(temp0 egoTold: 1)
						(= local1 402)
					)
				)
			)
			(2
				(client setScript: 0)
				(DoSound sndMASTER_VOLUME global125)
				(if global172
					(gCurRoom newRoom: 45) ; mapRoom
				)
				(proc0_5)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(proc0_3)
				)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attention self)
			)
			(1
				(fountainMan say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(fountainMan say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(fountainMan say: (++ register) self)
			)
			(6
				(gEgo say: (++ register) self)
			)
			(7
				(fountainMan say: (++ register) self)
			)
			(8
				(gEgo say: (++ register) self)
			)
			(9
				(self setScript: atEase self 1)
			)
			(10
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
				(self setScript: attention self)
			)
			(1
				(fountainMan say: register self)
			)
			(2
				(self setScript: atEase self 1)
			)
			(3
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
				(self setScript: attention self)
			)
			(1
				(fountainMan say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(fountainMan say: (++ register) self)
			)
			(4
				(self setScript: atEase self 1)
			)
			(5
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
				(self setScript: attention self)
			)
			(1
				(fountainMan say: register self)
			)
			(2
				(self setScript: atEase self 0)
			)
			(3
				(self setScript: (ScriptID 318) self) ; rhymeScript
			)
			(4
				(if (== global123 18)
					(= global123 0)
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
				(self setScript: attention self)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(fountainMan say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(fountainMan say: (++ register) self)
			)
			(5
				(self setScript: atEase self 0)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 114 (gEgo x:) 149))
				(= temp1 12)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 84 (gEgo y:) 96))
			)
			(3
				(= temp0 (proc0_13 78 (gEgo x:) 176))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 85 (gEgo y:) 98))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

