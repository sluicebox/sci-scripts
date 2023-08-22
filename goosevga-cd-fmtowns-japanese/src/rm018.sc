;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm018 0
)

(local
	[local0 107] = [5 0 0 0 0 0 0 -6042 69 0 0 80 85 0 0 79 98 0 0 103 110 0 0 163 112 0 0 188 105 0 0 188 80 0 0 163 -32699 0 0 -14336 16 117 33 117 37 108 66 84 69 59 78 47 83 0 83 0 -32718 -14336 137 0 99 33 100 49 114 66 122 96 126 93 155 0 -32613 -14078 155 167 155 164 128 205 115 226 99 258 99 258 -32631 -14078 50 258 84 213 84 199 77 178 71 154 66 146 37 145 32 258 -32760 0 0]
	local107
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
		(super init:)
		(petal1 init:)
		(petal2 init:)
		(petal3 init:)
		(petal4 init:)
		(fountainMan init:)
		(gAddToPics add: namePlate doit:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: 137 37)
				(self setScript: global145)
			)
			(south
				(gEgo posn: 130 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 10 89)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 87)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8)
		(if global172
			(self setScript: converse)
			(+= global114 300)
			(gEgo view: global114)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((!= (event type:) evVERB)
				(return)
			)
			(script
				(return)
			)
			(else
				(event claimed: 1)
				(self setScript: converse)
			)
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
		y 92
		x 132
		z 10
		view 666
		loop 3
		signal 257
		cycleSpeed 3
		illegalBits 0
	)
)

(instance petal1 of Act
	(properties
		y -20
		x 54
		yStep 1
		view 666
		loop 1
		priority 7
		signal 26640
		cycleSpeed 3
		illegalBits 0
		xStep 1
		moveSpeed 3
	)

	(method (init)
		(super init:)
		(self cel: (Random 0 9) setCycle: Fwd setScript: petal1Script)
	)
)

(instance ring of Act
	(properties
		yStep 1
		view 666
		loop 2
		signal 2048
		cycleSpeed 4
		illegalBits 0
		xStep 1
		moveSpeed 5
	)

	(method (init)
		(super init:)
		(self setPri: 6 posn: (petal1 x:) (petal1 y:))
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
				(reflection signal: 0 setLoop: 0 init: setCycle: Fwd)
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

(instance petal2 of Act
	(properties
		y 106
		x -89
		yStep 1
		view 666
		loop 1
		priority 15
		signal 26640
		cycleSpeed 2
		illegalBits 0
		xStep 1
		moveSpeed 2
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

(instance petal3 of Act
	(properties
		y 80
		x -28
		yStep 1
		view 666
		loop 1
		cycleSpeed 2
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setPri: 12
			setLoop: 1
			setCycle: Fwd
			moveSpeed: 2
			setScript: petal3Script
		)
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

(instance petal4 of Act
	(properties
		y 30
		x 259
		yStep 1
		view 666
		loop 1
		priority 12
		signal 26640
		cycleSpeed 2
		illegalBits 0
		xStep 1
		moveSpeed 2
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
		y 91
		x 131
		view 666
		loop 6
		cycleSpeed 5
	)
)

(instance namePlate of PV
	(properties
		y 107
		x 132
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
				(fountainMan
					signal: (& (fountainMan signal:) $feff)
					startUpd:
					setCycle: End self
				)
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
				(fountainMan signal: (| (fountainMan signal:) $0100) stopUpd:)
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

	(method (cue)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
		(DisposeScript 976)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(HandsOn)
	)

	(method (init &tmp temp0)
		(proc0_7 gEgo fountainMan)
		(HandsOff)
		(super init: &rest)
		(= temp0 (gGoals at: 17))
		(proc0_20)
		(cond
			(local107
				(self setScript: converse2 self local107)
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
				(= local107 406)
			)
			(else
				(self setScript: converse1 self 394)
				(temp0 egoTold: 1)
				(= local107 402)
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

