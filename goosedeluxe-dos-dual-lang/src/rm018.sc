;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm018 0
)

(local
	local0
	local1
)

(instance rm018 of MGRoom
	(properties
		picture 18
		north 11
		east 19
		south 25
		west 17
		vanishingX 131
		vanishingY -90
		edgeN 41
	)

	(method (init)
		(= local1 0)
		(proc0_1)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 154 66 151 53 148 39 148 0 315 0 315 85 214 84 203 77 187 71 164 66
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 315 196 179 196 174 155 163 115 198 108 220 90 315 99
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 86 155 92 196 0 196 0 98 28 98 29 100 48 116 75 124 92 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 118 0 118 37 110 65 102 69 75 71 57 78 44 84 0 84
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 167 112 104 112 78 101 75 92 79 82 107 70 159 70 183 81 185 90 184 98 179 105
					yourself:
				)
		)
		(= global305 outCode)
		(= global301 converse)
		(if (!= (gGame printLang:) 33)
			(namePlate init: setPri: 1)
		)
		(petal1 init:)
		(petal2 init:)
		(petal3 init:)
		(petal4 init:)
		(fountainMan init: setPri: 110 1)
		(switch gPrevRoomNum
			(north
				(if (< (gEgo x:) 130)
					(gEgo posn: 130 60)
				else
					(gEgo posn: 150 60)
				)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: 130 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 89)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 87)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 150 120 init:)
					(self setScript: converse)
					(+= global114 300)
					(gEgo view: global114)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 150 120 init:)
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
		(DisposeScript 318)
		(super dispose:)
	)
)

(instance petal1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(reflection init: setPri: 0 setLoop: 0 1 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(= seconds (Random 4 14))
			)
			(3
				(petal1
					setLoop: 1 1
					posn: 54 10
					cel: 0
					setMotion: MoveTo 106 (Random 80 85) self
				)
			)
			(4
				(ring init: setLoop: 2 1 cel: 0 setCycle: End self)
				(petal1 posn: 54 -20)
			)
			(5
				(= seconds 3)
			)
			(6
				(ring setLoop: 2 1 cel: 255 setMotion: MoveTo (ring x:) 92 self)
			)
			(7
				(ring dispose:)
				(= seconds 2)
				(= state 1)
			)
		)
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
					setLoop: 1 1
					cel: (Random 0 9)
					posn: 89 106
					setMotion: MoveTo (Random 120 145) 159 self
				)
				(= state -1)
			)
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
					setLoop: 1 1
					cel: (Random 0 9)
					posn: 68 80
					setMotion: MoveTo (Random 120 130) 135 self
				)
			)
			(2
				(petal3 posn: -68 80)
				(= state -1)
				(= cycles 1)
			)
		)
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
					setLoop: 1 1
					cel: (Random 0 9)
					posn: 209 30
					setMotion: MoveTo 259 95 self
				)
				(= state -1)
			)
		)
	)
)

(instance fountainMan of Actor
	(properties
		x 130
		y 92
		z 10
		view 666
		loop 3
		illegalBits 0
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

(instance petal1 of Actor
	(properties
		x 54
		y -20
		view 666
		loop 1
		yStep 1
		cycleSpeed 9
		illegalBits 0
		xStep 1
		moveSpeed 9
	)

	(method (init)
		(super init:)
		(self
			setLoop: 1 1
			cel: (Random 0 9)
			setPri: 100
			setCycle: Fwd
			ignoreActors: 1
			setScript: petal1Script
		)
	)
)

(instance ring of Actor
	(properties
		view 666
		loop 2
		yStep 1
		cycleSpeed 12
		illegalBits 0
		xStep 1
		moveSpeed 15
	)

	(method (init)
		(super init:)
		(self setPri: 1 setLoop: 2 1 posn: (petal1 x:) (petal1 y:))
	)
)

(instance petal2 of Actor
	(properties
		x -89
		y 106
		view 666
		loop 1
		yStep 1
		cycleSpeed 9
		illegalBits 0
		xStep 1
		moveSpeed 9
	)

	(method (init)
		(super init:)
		(self setPri: 159 ignoreActors: 1 setCycle: Fwd setScript: petal2Script)
	)
)

(instance petal3 of Actor
	(properties
		x -28
		y 80
		view 666
		loop 1
		yStep 1
		cycleSpeed 9
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init:)
		(self
			setPri: 135
			ignoreActors: 1
			setCycle: Fwd
			moveSpeed: 9
			setScript: petal3Script
		)
	)
)

(instance petal4 of Actor
	(properties
		x 259
		y 30
		view 666
		loop 1
		yStep 1
		cycleSpeed 9
		illegalBits 0
		xStep 1
		moveSpeed 9
	)

	(method (init)
		(super init:)
		(self setPri: 95 ignoreActors: 1 setCycle: Fwd setScript: petal4Script)
	)
)

(instance reflection of Prop
	(properties
		x 129
		y 91
		view 666
		loop 6
		cycleSpeed 15
	)
)

(instance namePlate of View
	(properties
		x 130
		y 106
		view 666
		loop 5
	)
)

(instance attention of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 138 120 self)
			)
			(1
				(gEgo setLoop: 3)
				(= seconds 1)
			)
			(2
				(fountainMan setCycle: End self)
			)
			(3
				(fountainMan setLoop: 4 cel: 0)
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
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(= temp0 (gGoals at: 17))
			(proc0_7 gEgo fountainMan)
			(proc0_20)
			(cond
				(local1
					(switch local1
						(1
							(= local1 2)
							(self setScript: converse2 self)
						)
						(2
							(= local1 1)
							(self setScript: converse4 self)
						)
						(else
							(self setScript: converse6 self)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse6 self)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self)
					(temp0 egoReturned: 1)
					(= local1 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= local1 2)
				)
				(else
					(self setScript: converse1 self)
					(temp0 egoTold: 1)
					(= local1 1)
				)
			)
		else
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
				(self setScript: attention self)
			)
			(1
				(gMessager say: 10 1 8 0 self) ; "Aren't you forgetting something?"
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

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attention self)
			)
			(1
				(gMessager say: 10 1 9 0 self) ; "Hurry up! Go find that cockhorse!"
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
				(gMessager say: 10 1 10 0 self) ; "Why aren't you riding a cockhorse? That fine lady might be here any minute."
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

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attention self)
			)
			(1
				(gMessager say: 10 1 11 0 self) ; "The cockhorse isn't around here. Go look for it."
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

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attention self)
			)
			(1
				(gLongSong fade:)
				(gMessager say: 10 1 12 0 self) ; "Great! You've got the cockhorse! And just in time, too. Here comes the fine lady!"
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
				(gMessager say: 10 1 13 0 self) ; "Do you need anything else?"
			)
			(2
				(self setScript: atEase self 0)
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
			(22
				(fountainMan loop: 4 setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(22
				(fountainMan cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 118 (gEgo x:) 149))
				(= temp1 41)
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

