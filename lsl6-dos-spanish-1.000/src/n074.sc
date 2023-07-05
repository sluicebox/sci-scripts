;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Print)

(public
	proc74_0 0
)

(procedure (proc74_0 param1)
	(if (or (< param1 1) (> param1 8))
		(Printf {xxx Error in Unmute %d} param1)
	)
	(if (== param1 1)
		(gGlobalSound1
			number: 337
			loop: -1
			play:
			mute: 1 3
			mute: 1 4
			mute: 1 5
			mute: 1 6
			mute: 1 7
			mute: 1 8
			mute: 1 9
		)
	else
		(gGlobalSound1
			mute:
				(if (> argc 1) 1 else 0)
				(switch param1
					(2 3)
					(3 8)
					(4 9)
					(5 6)
					(6 7)
					(7 6)
					(8 5)
				)
		)
	)
	(DisposeScript 74)
)

