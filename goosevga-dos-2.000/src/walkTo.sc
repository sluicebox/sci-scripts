;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use PAvoider)
(use PolyPath)
(use System)

(public
	walkTo 0
)

(local
	[local0 18] = [163 126 116 116 140 140 136 136 170 172 133 140 127 180 124 150 193 175]
	[local18 18] = [105 141 137 133 130 132 140 140 134 80 120 140 144 117 106 140 109 120]
	[local36 18] = [1 3 4 5 7 9 12 13 15 17 18 21 23 24 26 27 31 33]
	local54
	local55
)

(instance walkTo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(for ((= local54 0)) (<= local54 17) ((++ local54))
					(if (== gCurRoomNum [local36 local54])
						(break)
					)
				)
				(self
					setScript:
						(ScriptID 250) ; flyIn
						self
						[local0 local54]
						[local18 local54]
						1
				)
				(= cycles 10)
			)
			(1
				(if (!= gCurRoomNum 23)
					(gEgo setAvoider: PAvoider)
				)
				(gEgo
					setMotion:
						PolyPath
						(+ [local0 local54] 1)
						(- [local18 local54] 1)
						self
				)
			)
			(2
				(gEgo loop: 2)
				((gEgo head:) loop: 7)
			)
			(3
				(= gNewRoomNum 92) ; endScene
				(self dispose:)
				(= local55 1)
			)
		)
		(if local55
			(DisposeScript 205)
		)
	)
)

