;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 515)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use eRS)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use Motion)
(use System)

(public
	rm515 0
)

(instance rm515 of SQRoom
	(properties
		lookStr {This maze of cables, ducts, pipes, and glowing panels gives the super brain computer a sense of being alive...}
		picture 515
		style 30
		north 500
		east 520
		west 514
		vanishingX 530
		vanishingY -450
	)

	(method (init &tmp temp0)
		(Load rsVIEW 507)
		(switch gPrevRoomNum
			(north
				(self
					setScript: enterScript 0 1
					vanishingX: 540
					vanishingY: -400
				)
			)
			(west
				(self setScript: enterScript 0 4)
			)
			(else
				(HandsOn)
			)
		)
		(gEgo init:)
		(self setRegions: 704) ; brain
		(super init:)
		(if (== gPrevRoomNum 1)
			(brain level: 3)
			(gEgo setPri: -1 x: 300 y: 88)
			(= gPrevRoomNum 520)
		)
		(switch (brain level:)
			(1
				(brain
					makePolygon: 0 0 319 0 319 131 117 131 115 142 117 153 77 153 77 159 319 159 319 189 0 189
				)
			)
			(2
				(brain makePolygon: 0 189 0 176 180 176 215 130 319 130 319 188)
				(brain makePolygon: 0 153 0 0 319 0 319 110 197 110 153 153)
			)
			(3
				(brain
					makePolygon: 0 0 149 0 95 48 96 57 93 63 57 63 57 70 83 70 72 75 63 75 55 80 71 97 319 97 319 189 0 189
				)
				(brain makePolygon: 136 38 319 38 319 75 99 75)
				(brain makePolygon: 154 24 177 0 319 0 319 24)
			)
		)
		((ScriptID 704 3) ; terminal1
			x: 137
			y: 123
			nsLeft: 132
			nsTop: 119
			nsBottom: 127
			nsRight: 142
			sightAngle: 90
			init:
		)
		((ScriptID 704 4) ; terminal2
			x: 63
			y: 141
			nsLeft: 55
			nsTop: 135
			nsBottom: 147
			nsRight: 72
			sightAngle: 90
			init:
		)
		((ScriptID 704 5) ; terminal3
			x: 170
			y: 61
			nsLeft: 164
			nsTop: 56
			nsBottom: 66
			nsRight: 177
			sightAngle: 90
			init:
		)
		(tube init:)
	)

	(method (doit)
		(cond
			(script)
			((gEgo script:))
			((StepOn gEgo 16)
				(gEgo setScript: (elevatorScript new:) 0 0)
			)
			((and (== (brain level:) 1) (StepOn gEgo 32))
				(gEgo setScript: (elevatorScript new:) 0 1)
			)
			((StepOn gEgo 8)
				(if (< (gEgo y:) 100)
					(brain exitDir: 45)
				else
					(brain exitDir: 270)
				)
			)
		)
		(if
			(and
				(not ((ScriptID 704 1) script:)) ; droid1
				(not ((ScriptID 704 2) script:)) ; droid2
			)
			(super doit:)
			(if (== ((ScriptID 704 1) room:) 515) ; droid1
				(cond
					(((ScriptID 704 1) script:)) ; droid1
					((StepOn (ScriptID 704 1) 16) ; droid1
						((ScriptID 704 1) setScript: (elevatorScript new:) 0 0) ; droid1
					)
					(
						(and
							(StepOn (ScriptID 704 1) 32) ; droid1
							(== ((ScriptID 704 1) level:) 1) ; droid1
						)
						((ScriptID 704 1) setScript: (elevatorScript new:) 0 1) ; droid1
					)
				)
			)
			(if (== ((ScriptID 704 2) room:) 515) ; droid2
				(cond
					(((ScriptID 704 2) script:)) ; droid2
					((StepOn (ScriptID 704 2) 16) ; droid2
						((ScriptID 704 2) setScript: (elevatorScript new:) 0 0) ; droid2
					)
					(
						(and
							(StepOn (ScriptID 704 2) 32) ; droid2
							(== ((ScriptID 704 2) level:) 1) ; droid2
						)
						((ScriptID 704 2) setScript: (elevatorScript new:) 0 1) ; droid2
					)
				)
			)
			(if (== (brain level:) 2)
				(if (gEgo inRect: 60 150 110 180)
					(gEgo setPri: 5)
				else
					(gEgo setPri: 3)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(Print 515 0) ; "You'd better not. Something might answer."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch register
					(1
						(= temp2 172)
						(= temp3 -7)
						(= temp4 131)
						(= temp5 37)
					)
					(4
						(= temp2 5)
						(= temp3 170)
						(= temp4 30)
						(= temp5 170)
					)
				)
				(gEgo x: temp2 y: temp3 setMotion: PolyPath temp4 temp5 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance elevatorScript of Script
	(properties)

	(method (dispose)
		(if (!= client gEgo)
			((client path:) value: (if register 75 else 209))
			(client z: 44 setLoop: 0 setCycle: Fwd mover: (client path:))
			((client body:) doit:)
			((client path:) moveDone:)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (== client gEgo)
					(HandsOff)
				)
				(client setPri: 2)
				(if register
					(client setMotion: MoveTo 85 158 self)
				else
					(client setMotion: MoveTo 63 67 self)
				)
			)
			(1
				(client setHeading: 90 self)
			)
			(2
				(gLongSong2 number: 847 vol: 127 loop: 1 play:)
				(if (== client gEgo)
					(brain level: 0)
					(gEgo
						normal: 0
						view: 507
						setLoop: 0
						cycleSpeed: 1
						setCycle: End self
					)
				else
					((client body:) hide:)
					(client
						z: 0
						setLoop: 2
						setCel: 0
						cycleSpeed: 1
						setCycle: End self
					)
				)
			)
			(3
				(client hide:)
				(= cycles 10)
			)
			(4
				(gLongSong2 number: 847 vol: 127 loop: 1 play:)
				(if register
					(client posn: 63 67)
				else
					(client posn: 85 158)
				)
				(if (== client gEgo)
					(= temp0 10)
				else
					(= temp0 6)
				)
				(client show: setPri: 2 setCel: temp0 setCycle: Beg self)
			)
			(5
				(if (== client gEgo)
					((gCurRoom obstacles:) dispose:)
					(brain level: (if register 3 else 1))
					(switch (brain level:)
						(1
							(brain
								makePolygon: 0 0 319 0 319 131 117 131 115 142 117 153 77 153 77 159 319 159 319 189 0 189
							)
						)
						(3
							(brain
								makePolygon: 0 0 149 0 95 48 96 57 93 63 57 63 57 70 83 70 72 75 63 75 55 80 71 97 319 97 319 189 0 189
							)
							(brain makePolygon: 136 38 319 38 319 75 99 75)
							(brain makePolygon: 154 24 177 0 319 0 319 24)
						)
					)
					(NormalEgo 0 3 510)
					(gEgo setPri: 2)
				else
					(client z: 44 setLoop: 0 setCycle: Fwd)
				)
				(client setMotion: MoveFwd 30 self)
			)
			(6
				(if register
					(client setPri: -1)
				)
				(if (== client gEgo)
					(gCurRoom
						vanishingX: (if register 540 else 530)
						vanishingY: (if register -400 else -450)
					)
					(HandsOn)
				else
					(switch (client level:)
						(1
							(client setPri: 2)
						)
						(2
							(client setPri: 3)
						)
						(3
							(client setPri: -1)
						)
					)
					((client body:) doit:)
				)
				(self dispose:)
			)
		)
	)
)

(instance tube of Feature
	(properties
		description {elevator tube}
		lookStr {The glass tube reminds you of the old vacuum tubes in the drive-up aisles at banks.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1)
		(return (== (OnControl VISUAL (param1 x:) (param1 y:)) 16384))
	)
)

