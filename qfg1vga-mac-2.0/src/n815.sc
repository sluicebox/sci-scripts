;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 815)
(include sci.sh)
(use Main)
(use Print)

(public
	proc815_0 0
	proc815_1 1
	proc815_2 2
)

(procedure (proc815_0)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(Print addText: &rest mode: 1 init:)
	(DisposeScript 815)
)

(procedure (proc815_1 param1) ; UNUSED
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(Print addText: &rest mode: 1 ticks: (* param1 60) init:)
	(DisposeScript 815)
)

(procedure (proc815_2) ; UNUSED
	(proc815_0 &rest)
)

