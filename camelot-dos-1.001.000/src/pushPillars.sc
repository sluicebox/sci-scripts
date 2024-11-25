;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 199)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	pushPillars 0
	cantLeave 1
)

(local
	[local0 64] = [9 140 128 189 126 133 233 189 207 76 309 146 225 7 311 70 262 78 400 135 132 38 203 95 8 40 80 85 74 46 148 83 231 39 310 85 56 55 148 98 -99 75 56 125 165 53 237 83 -99 7 74 55 88 124 196 189 196 149 313 189 19 106 117 139]
	[local64 32] = [71 196 181 167 250 109 288 43 304 99 172 60 36 53 121 64 281 59 98 74 15 100 0 0 22 30 142 161 249 176 0 0]
	local96
	local97
	local98
)

(instance pushPillars of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local98 (& (gEgo signal:) $0400))
			((gEgo mover:) x: (gEgo x:) y: (gEgo y:))
			(= local98 0)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local96 (* (- gCurRoomNum 75) 16))
				(= local97 -1)
				(for ((= temp0 0)) (!= temp0 4) ((++ temp0))
					(if
						(gEgo
							inRect:
								[local0 (+ local96 (* temp0 4))]
								[local0 (+ local96 (* temp0 4) 1)]
								[local0 (+ local96 (* temp0 4) 2)]
								[local0 (+ local96 (* temp0 4) 3)]
						)
						(= local97 (/ (+ local96 (* temp0 4)) 2))
					)
				)
				(cond
					((and (== local97 4) (IsFlag 208))
						(self dispose:)
						(gEgo setScript: (ScriptID 191 0)) ; pushPillar
					)
					((== local97 -1)
						(Print 199 0) ; "You cannot do that from here."
						(self dispose:)
					)
					((== [local64 local97] 0)
						(Print 199 1) ; "Nothing remains of the pillar here but the indentation where its base once rested."
						(self dispose:)
					)
					(else
						(= local98 1)
						(= global109 6)
						(gEgo signal: (& (gEgo signal:) $fbff))
						(gEgo
							setMotion:
								MoveTo
								[local64 local97]
								[local64 (+ local97 1)]
								self
						)
					)
				)
			)
			(1
				(HandsOff)
				(gEgo
					view: 95
					cycleSpeed: 1
					cel: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: (if (IsFlag 194) 57 else 0))
				(= cycles 2)
			)
			(5
				(if (IsFlag 208)
					(Print 199 2) ; "This pillar did not move. Pause and think before your next choice."
				else
					(Print 199 3) ; "The pillar did not move. I hope you do not intend to waste more of your valuable energy in such pointless exercise."
				)
				(gEgo
					setLoop: -1
					setPri: -1
					cycleSpeed: 0
					illegalBits: $8000
				)
				(= global109 0)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(SetFlag 221)
		(super dispose:)
	)
)

(instance cantLeave of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 199 4) ; "There is no where to go from here. High walls without windows or doors bar the way."
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(cond
					((> (gEgo x:) 300)
						(-= temp0 10)
					)
					((< (gEgo x:) 10)
						(+= temp0 10)
					)
					((> (gEgo y:) 150)
						(-= temp1 7)
					)
				)
				(gEgo setMotion: MoveTo temp0 temp1 self)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(SetFlag 221)
		(super dispose:)
	)
)

