;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 828)
(include sci.sh)
(use Main)

(public
	SetScore 0
)

(procedure (SetScore param1 param2 param3 param4)
	(if (not (& (param1 param2:) param3))
		(gGame changeScore: param4)
		(param1 param2: (| (param1 param2:) param3))
	)
	(DisposeScript 828)
)

