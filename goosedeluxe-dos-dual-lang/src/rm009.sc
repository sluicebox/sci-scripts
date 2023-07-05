;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm009 0
)

(instance rm009 of MGRoom
	(properties
		picture 9
		north 2
		east 10
		south 16
		west 8
		edgeN 65
		edgeE 320
	)

	(method (init)
		(= global305 outCode)
		(= global109 curd)
		(Load rsVIEW 68)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 252 155 249 134 231 118 228 87 229 68 258 42 294 38 295 153
					yourself:
				)
		)
		(proc0_1)
		(if ((gGoals at: 0) egoReturned:)
			(muffet init: loop: 5)
			(muffetHead
				init:
					muffet
					(CelHigh (muffet view:) (muffet loop:) (muffet cel:))
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 84 97 82 128 94 133 98 177 98 177 122 138 122 127 103 93 106 94 113 88 116 54 112 14 112 17 98 0 101
						yourself:
					)
			)
		else
			(tuffet init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 84 97 82 128 94 133 98 177 98 177 115 138 115 127 103 93 106 94 113 88 116 54 112 14 112 17 98 0 101
						yourself:
					)
			)
		)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 167 57)
				(self setScript: gStdClimbIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 111 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo
					posn:
						(proc0_13
							(gCurRoom edgeW:)
							(gEgo x:)
							(gCurRoom edgeE:)
						)
						135
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 134 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 150 125 init:)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 150 125 init:)
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
		(DisposeScript 309)
		(if ((gGoals at: 0) egoReturned:)
			(DisposeScript 602)
		)
		(super dispose: &rest)
	)
)

(instance sGesture of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
				(client setCel: (- (Random 1 3) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client cel: 0)
		(super dispose:)
	)
)

(instance muffet of Actor
	(properties
		x 150
		y 107
		view 43
		loop 5
	)

	(method (init)
		(super init:)
		(= global301 converse4)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse4)
			)
		)
	)
)

(instance muffetHead of Head
	(properties
		view 43
		loop 3
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
						((< (gEgo x:) (- x 20)) 4)
						((> (gEgo x:) (+ x 20)) 2)
						(else 3)
					)
			)
		)
		(super doit:)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse4)
			)
		)
	)
)

(instance curd of Prop
	(properties
		view 68
		loop 7
	)

	(method (init)
		(self posn: 136 114 setPri: 102)
		(super init: &rest)
	)
)

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global516 gNarrator)
				(= gNarrator mgNarrator)
				(= ticks 1)
			)
			(1
				(muffet cycleSpeed: 6 loop: 5)
				(proc0_7 gEgo muffet)
				(self cue:)
			)
			(2
				(gMessager say: 6 1 9 0 self) ; "Where did that mean old spider go, Miss Muffet?"
			)
			(3
				(= gNarrator global516)
				(gGame handsOn:)
				(= global301 0)
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
			(12
				(muffetHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(12
				(muffetHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 190 (gEgo x:) 213))
				(= temp1 65)
			)
			(2
				(= temp0 252)
				(= temp1 (proc0_13 72 (gEgo y:) 147))
			)
			(3
				(= temp0 (proc0_13 2 (gEgo x:) 250))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 56 (proc0_14 83 (gEgo y:) 102) 151))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance tuffet of Feature
	(properties
		nsLeft 135
		nsTop 94
		nsRight 166
		nsBottom 109
		x 150
		y 101
	)

	(method (doVerb)
		(if ((gGoals at: 0) egoHas:)
			(gCurRoom setScript: global301)
		)
	)
)

