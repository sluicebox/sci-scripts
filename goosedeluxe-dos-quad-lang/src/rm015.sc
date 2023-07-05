;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm015 0
)

(local
	local0
	local1
)

(instance rm015 of MGRoom
	(properties
		picture 15
		north 8
		east 16
		south 22
		edgeN 62
		edgeW -1
		edgeS 145
	)

	(method (init)
		(Load rsVIEW 127)
		(proc0_1)
		(super init:)
		(if (not ((gGoals at: 15) egoReturned:))
			(man ignoreActors: 1 init:)
			(crookedHead init: man (CelHigh (man view:) (man loop:) (man cel:)))
			(gCurRoom
				addObstacle:
					((= local1 (Polygon new:))
						type: PBarredAccess
						init: 0 179 0 7 223 7 225 43 242 109 196 127 165 127 152 103 145 102 142 107 153 125 139 130 118 120 96 128 53 120 5 135 23 155 25 179
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 155 0 0 221 24 219 73 234 88 237 109 196 119 181 119 168 120 154 103 145 102 127 102 142 107 153 125 139 130 118 120 96 128 53 120 5 135 23 155
						yourself:
					)
			)
		)
		(= global305 outCode)
		(= global301 converse)
		(door init:)
		(switch gPrevRoomNum
			(40
				(gEgo loop: 0 cel: 1 x: 146 y: 107 edgeHit: 0 init:)
				(self setScript: sOutDoor)
			)
			(north
				(gEgo posn: 230 67)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 63 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (gEgo x:) 139 setPri: -1)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 190 132 init:)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 190 132 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8)
		(if (and global129 (== gPrevRoomNum 40))
			(global129 posn: 129 127)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) 1)
				(gCurRoom newRoom: north)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 315)
		(super dispose: &rest)
	)
)

(instance sInDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 20)
			)
			(1
				(gEgo setMotion: PolyPath 144 106 self)
			)
			(2
				(gSfx number: 38 play:)
				(= cycles 1)
			)
			(3
				(door setCycle: End self)
			)
			(4
				(gEgo illegalBits: 0 setMotion: MoveTo 143 104 self)
			)
			(5
				(gGame handsOn:)
				(gCurRoom setScript: 0)
				(gCurRoom newRoom: 40)
			)
		)
	)
)

(instance sOutDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 20)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gSfx number: 36 play:)
				(= cycles 10)
			)
			(3
				(gGame handsOn:)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance sGesture of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 8 30))
				(client cel: (- (Random 1 (NumCels client)) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client cel: 0)
		(super dispose:)
	)
)

(instance man of Actor
	(properties
		x 180
		y 124
		view 83
		loop 5
		yStep 1
		cycleSpeed 2
		illegalBits 0
		xStep 1
		moveSpeed 2
	)

	(method (init)
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

(instance crookedHead of Head
	(properties
		view 83
		loop 2
	)

	(method (init)
		(= global111 self)
		(super init: &rest)
	)

	(method (doit)
		(self setPri: (+ (client priority:) 1))
		(if (not script)
			(self setPri: (+ (client priority:) 1))
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
						((< (gEgo x:) (- (client x:) 30)) 4)
						((> (gEgo x:) (+ (client x:) 30)) 2)
						(else 3)
					)
			)
		)
		(super doit:)
	)
)

(instance door of Prop
	(properties
		x 127
		y 72
		view 127
	)

	(method (init)
		(super init:)
		(self setPri: 2)
		(if (== gPrevRoomNum 40)
			(= cel 3)
		)
		(= global110 self)
	)

	(method (doVerb)
		(if (not (gCurRoom script:))
			(self setScript: sInDoor)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(cond
				((not global172) 1)
				((not (gCast contains: man))
					(return)
				)
			)
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(= temp0 (gGoals at: 15))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(= global123 5)
							(self setScript: converse2 self)
						)
						(2
							(= global123 5)
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
					(if (== global123 5)
						(= global123 0)
					)
					(temp0 egoReturned: 1)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 5)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self)
					(temp0 egoTold: 1)
					(= local0 1)
					(= global123 5)
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
				(gEgo setMotion: PolyPath 205 136 self)
			)
			(1
				(proc0_7 gEgo man)
				(= cycles 2)
			)
			(2
				(gMessager say: 9 1 2 0 self) ; "Hey there, you young whippersnapper! Have you found my crooked sixpence?"
			)
			(3
				(= global131 (+ (man x:) -23))
				(= global132 (- (man y:) 66))
				(= global128 (+ 114 (* 100 gLanguage)))
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
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
				(gEgo setMotion: PolyPath 205 136 self)
			)
			(1
				(proc0_7 gEgo man)
				(= cycles 2)
			)
			(2
				(gMessager say: 9 1 3 0 self) ; "You still here? Go look for the sixpence somewhere else. I've already looked around here!"
			)
			(3
				(= global131 (+ (man x:) -23))
				(= global132 (- (man y:) 66))
				(= global128 (+ 114 (* 100 gLanguage)))
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 5)
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
				(gEgo observeControl: 16384 setMotion: PolyPath 205 136 self)
			)
			(1
				(proc0_7 gEgo man)
				(= cycles 2)
			)
			(2
				(gMessager say: 9 1 4 0 self) ; "I've been waiting for you to come back here, you little pea pod. Where is that crooked sixpence of mine?"
			)
			(3
				(= global131 (+ (man x:) -23))
				(= global132 (- (man y:) 66))
				(= global128 (+ 114 (* 100 gLanguage)))
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
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
				(gEgo setMotion: PolyPath 205 136 self)
			)
			(1
				(proc0_7 gEgo man)
				(= cycles 2)
			)
			(2
				(gMessager say: 9 1 5 0 self) ; "Skedaddle on out of here, youngster! Go find that sixpence!"
			)
			(3
				(= global131 (+ (man x:) -23))
				(= global132 (- (man y:) 66))
				(= global128 (+ 114 (* 100 gLanguage)))
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 5)
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
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 205 136 self)
			)
			(2
				(proc0_7 gEgo man)
				(= cycles 2)
			)
			(3
				(gLongSong fade:)
				(gMessager say: 9 1 6 1 self) ; "I found your sixpence, Mr. ...uh,"
			)
			(4
				(man ignoreActors: 1)
				(gGame handsOff:)
				(self setScript: (ScriptID 315) self) ; rhymeScript
			)
			(5
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 155 0 0 222 32 210 97 232 97 237 109 196 119 181 119 168 120 154 103 145 102 127 102 142 107 153 125 139 130 118 120 96 128 53 120 5 135 23 155
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
			(19
				(crookedHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(19
				(crookedHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 226 (gEgo x:) 252))
				(= temp1 62)
			)
			(2
				(= temp0 261)
				(= temp1 (proc0_13 67 (gEgo y:) 144))
			)
			(3
				(= temp0 (proc0_13 24 (gEgo x:) 257))
				(= temp1 158)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 128 (gEgo y:) 144))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

