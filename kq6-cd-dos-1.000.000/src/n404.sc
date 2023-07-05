;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 404)
(include sci.sh)
(use Main)
(use n913)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	proc404_0 0
	proc404_1 1
	proc404_2 2
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc404_0 param1)
	(gEgo setScript: holeOnWall 0 param1)
)

(procedure (proc404_1)
	((ScriptID 30 0) holeIsUp: 1) ; rLab
	(switch ((ScriptID 30 0) holeWall:) ; rLab
		(2
			(aHole posn: 281 222 setPri: 13 init:)
		)
		(1
			(aHole posn: 159 191 setLoop: 7 setPri: 10 init:)
		)
		(4
			(aHole posn: 36 223 setPri: 13 init:)
		)
	)
)

(procedure (proc404_2)
	(if (gCast contains: aHole)
		(aHole dispose: delete:)
	)
	(DisposeScript 404)
)

(instance aHole of Actor
	(properties
		z 100
		noun 17
		modNum 400
		sightAngle 45
		view 232
		loop 6
		signal 26640
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gEgo setScript: lookInHole)
			)
			(2 ; Talk
				(gMessager say: 17 2 0 1 0 400) ; "The hole-in-the-wall does not like the walls of the catacombs and is not in the mood for conversation."
			)
			(5 ; Do
				(gEgo setScript: getHole)
			)
			(else
				(gMessager say: 17 0 0 1 0 400) ; "There is no reason to put that into the hole-in-the-wall."
			)
		)
	)
)

(instance holeInset of View ; UNUSED
	(properties
		x 157
		y 105
		view 487
		priority 15
		signal 24592
	)
)

(instance wall1 of View ; UNUSED
	(properties
		x 160
		y 139
		view 414
		priority 12
		signal 24592
	)
)

(instance wall2 of View ; UNUSED
	(properties
		x 149
		y 139
		view 414
		priority 12
		signal 24592
	)
)

(instance wall3 of View ; UNUSED
	(properties
		x 139
		y 139
		view 414
		priority 12
		signal 24592
	)
)

(instance wall4 of View ; UNUSED
	(properties
		x 129
		y 139
		view 414
		priority 12
		signal 24592
	)
)

(instance sDoor of Prop ; UNUSED
	(properties
		x 205
		y 96
		view 414
		loop 4
		priority 13
		signal 24592
	)
)

(instance dirt of Prop ; UNUSED
	(properties
		x 159
		y 100
		view 490
		priority 13
		signal 24592
	)
)

(instance holeOnWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 18 gCurRoomNum) ; holeInTheWall
				(gGame handsOff:)
				((ScriptID 30 0) holeIsUp: 1 holeWall: register) ; rLab
				(if (== gCurRoomNum 400) ; LBRoom
					((ScriptID 30 0) holeCoords: ((ScriptID 30 0) labCoords:)) ; rLab, rLab
				else
					((ScriptID 30 0) holeCoords: gCurRoomNum) ; rLab
				)
				(switch register
					(2
						(= local1 259)
						(= local2 173)
					)
					(1
						(= local1 157)
						(= local2 144)
					)
					(4
						(= local1 59)
						(= local2 173)
					)
				)
				(gEgo setMotion: PolyPath local1 local2 self)
			)
			(1
				(switch register
					(2
						(gEgo setHeading: 45)
					)
					(1
						(gEgo setHeading: 0)
					)
					(4
						(gEgo setHeading: 270)
					)
				)
				(= cycles 10)
			)
			(2
				(switch register
					(2
						(= local1 271)
						(= local2 173)
						(gEgo setLoop: 0)
					)
					(1
						(= local1 157)
						(= local2 146)
						(gEgo setLoop: 2)
					)
					(4
						(= local1 48)
						(= local2 173)
						(gEgo setLoop: 1)
					)
				)
				(gEgo
					view: 232
					normal: 0
					cel: 0
					posn: local1 local2
					cycleSpeed: 6
				)
				(if (== register 1)
					(gEgo setCycle: CT 4 1 self)
				else
					(gEgo setCycle: CT 5 1 self)
				)
			)
			(3
				(switch register
					(2
						(aHole posn: 281 222 setPri: 13 init:)
					)
					(1
						(aHole posn: 159 191 setLoop: 7 setPri: 10 init:)
					)
					(4
						(aHole posn: 36 223 setPri: 13 init:)
					)
				)
				(gEgo cel: 6)
				(= seconds 1)
			)
			(4
				(if (and (== gCurRoomNum 409) (> (aHole x:) 250))
					(gMessager say: 19 25 55 1 self 400) ; "Alexander puts the hole-in-the-wall on the wall with the tapestry."
				else
					(gMessager say: 6 25 0 1 self 400) ; "Alexander puts the hole-in-the-wall on the wall."
				)
			)
			(5
				(if
					(and
						(== gCurRoomNum 409)
						(not (IsFlag 1))
						(> (aHole x:) 250)
					)
					(self cue:)
				else
					(gMessager say: 6 25 0 2 self 400) ; "It seems to shudder in revulsion at the mere touch of the cold stone."
				)
			)
			(6
				(switch register
					(2
						(gEgo posn: 259 173 reset: 6)
					)
					(1
						(gEgo posn: 157 144 reset: 3)
					)
					(4
						(gEgo posn: 59 173 reset: 1)
					)
				)
				(= cycles 6)
			)
			(7
				(switch register
					(2
						(= local1 236)
						(= local2 173)
					)
					(1
						(= local1 157)
						(= local2 158)
					)
					(4
						(= local1 79)
						(= local2 173)
					)
				)
				(gEgo
					setLoop: (gEgo cel:)
					setMotion: MoveTo local1 local2 self
				)
			)
			(8
				(= cycles 8)
			)
			(9
				(if
					(and
						(== gCurRoomNum 409)
						(not (IsFlag 1))
						(> (aHole x:) 250)
					)
					(gGlobalSound4 number: 483 setLoop: 1 play:)
					(aHole
						yStep: 6
						setCycle: Fwd
						setMotion: MoveTo (aHole x:) 5 self
					)
				else
					(self cue:)
				)
			)
			(10
				(if
					(and
						(== gCurRoomNum 409)
						(not (IsFlag 1))
						(> (aHole x:) 250)
					)
					(gMessager say: 19 25 55 2 self 400) ; "The hole-in-the-wall must not like something on the other side of the wall! He immediately runs away in terror!"
				else
					(self cue:)
				)
			)
			(11
				(if
					(and
						(== gCurRoomNum 409)
						(not (IsFlag 1))
						(> (aHole x:) 250)
					)
					(gMessager say: 19 25 55 3 self 400) ; "Alexander hopes he doesn't get into a situation where he really needs the hole-in-the-wall!"
				else
					(self cue:)
				)
			)
			(12
				(gGame handsOn:)
				(gEgo setLoop: -1)
				(self dispose:)
			)
		)
	)
)

(instance lookInHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((< (aHole x:) 82)
						(= register 4)
						(= local1 58)
						(= local2 172)
					)
					((< (aHole x:) 233)
						(= register 1)
						(= local1 157)
						(= local2 144)
					)
					(else
						(= register 2)
						(= local1 259)
						(= local2 170)
					)
				)
				(gEgo setMotion: PolyPath local1 local2 self)
			)
			(1
				(switch register
					(4
						(gEgo setHeading: 270)
					)
					(1
						(gEgo setHeading: 0)
					)
					(2
						(gEgo setHeading: 90)
					)
				)
				(= cycles 12)
			)
			(2
				(switch register
					(4
						(= local1 47)
						(= local2 172)
						(gEgo setPri: 14 setLoop: 4)
					)
					(1
						(= local1 157)
						(= local2 146)
						(gEgo setPri: 11 setLoop: 5)
					)
					(2
						(= local1 268)
						(= local2 171)
						(gEgo setPri: 14 setLoop: 3)
					)
				)
				(gEgo
					view: 232
					cel: 0
					normal: 0
					posn: local1 local2
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(3
				(gMessager say: 17 1 0 0 self 400) ; "Alexander peers through the hole-in-the-wall and sees...."
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(switch register
					(4
						(gEgo posn: 58 172 reset: 1)
					)
					(1
						(gEgo posn: 157 144 reset: 3)
					)
					(2
						(gEgo posn: 259 170 reset: 0)
					)
				)
				(= cycles 6)
			)
			(6
				(switch register
					(4
						(= local1 78)
						(= local2 172)
					)
					(1
						(= local1 157)
						(= local2 159)
					)
					(2
						(= local1 239)
						(= local2 170)
					)
				)
				(gEgo
					setLoop: (gEgo cel:)
					setMotion: PolyPath local1 local2 self
				)
			)
			(7
				(gGame handsOn:)
				(gEgo reset:)
				(self dispose:)
			)
		)
	)
)

(instance getHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((< (aHole x:) 82)
						(= register 4)
						(= local1 59)
						(= local2 173)
					)
					((< (aHole x:) 233)
						(= register 1)
						(= local1 157)
						(= local2 144)
					)
					(else
						(= register 2)
						(= local1 256)
						(= local2 173)
					)
				)
				(gEgo setMotion: PolyPath local1 local2 self)
			)
			(1
				(switch register
					(4
						(gEgo setHeading: 270)
					)
					(1
						(gEgo setHeading: 0)
					)
					(2
						(gEgo setHeading: 45)
					)
				)
				(= cycles 10)
			)
			(2
				(gMessager say: 17 5 0 1 self 400) ; "Alexander takes the hole-in-the-wall off the wall."
			)
			(3
				(switch register
					(2
						(gEgo posn: 268 173 setLoop: 0)
					)
					(1
						(gEgo posn: 157 146 setLoop: 2)
					)
					(4
						(= local1 48)
						(= local2 173)
						(gEgo posn: 48 173 setLoop: 1)
					)
				)
				(gEgo view: 232 normal: 0 cel: 6)
				(= cycles 3)
			)
			(4
				(aHole dispose:)
				(gEgo cycleSpeed: 6 setCycle: Beg self)
			)
			(5
				(switch register
					(2
						(gEgo posn: 259 170 reset: 6)
					)
					(1
						(gEgo posn: 157 144 reset: 3)
					)
					(4
						(gEgo posn: 58 172 reset: 1)
					)
				)
				(= cycles 6)
			)
			(6
				(switch register
					(2
						(= local1 239)
						(= local2 170)
					)
					(1
						(= local1 157)
						(= local2 156)
					)
					(4
						(= local1 78)
						(= local2 172)
					)
				)
				(= ticks 6)
			)
			(7
				(gEgo
					setLoop: (gEgo cel:)
					setMotion: MoveTo local1 local2 self
				)
			)
			(8
				(gGame handsOn:)
				(gEgo setLoop: -1 get: 18) ; holeInTheWall
				((ScriptID 30 0) holeCoords: 0) ; rLab
				((ScriptID 30 0) holeWall: 0) ; rLab
				(self dispose:)
			)
		)
	)
)

