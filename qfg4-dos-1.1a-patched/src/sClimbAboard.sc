;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use Main)
(use PolyPath)
(use Jump)
(use Motion)
(use System)

(public
	sClimbAboard 0
	sClimbDown 1
)

(instance sClimbAboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setStep: 3 2 setMotion: PolyPath 152 164 self)
			)
			(1
				(gEgo setMotion: MoveTo 177 161 self)
			)
			(2
				(gEgo
					view: 7
					setLoop: 4 1
					setCel: 0
					setPri: 160
					posn: 188 125
					setCycle: End self
				)
			)
			(3
				(gEgo
					posn: 187 127
					normalize:
					ignoreActors: 1
					setMotion: MoveTo 247 68 self
				)
			)
			(4
				(gEgo
					view: 56
					setLoop: 4 1
					setCel: 0
					posn: 248 69
					setCycle: Fwd
					setMotion: JumpTo 271 65 self
				)
			)
			(5
				(gEgo posn: 269 62 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 270 62 self)
			)
			(1
				(gEgo
					view: 56
					setLoop: 1 1
					setCel: 0
					posn: 264 60
					setCycle: Fwd
					setMotion: JumpTo 240 67 self
				)
			)
			(2
				(gEgo
					posn: 241 69
					normalize:
					ignoreActors: 1
					setMotion: MoveTo 187 127 self
				)
			)
			(3
				(gEgo
					view: 7
					setLoop: 4 1
					setPri: 160
					posn: 191 125
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					posn: 185 161
					normalize:
					setMotion: MoveTo 128 166 self
				)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

