;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 396)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc396_0 0
)

(procedure (proc396_0 param1 &tmp [temp0 4] [temp4 100])
	(proc0_3)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print
		@temp4
		#at
		-1
		-10
		#width
		(if (> [temp0 2] 24) 300 else 0)
		#mode
		1
		#font
		30
		#time
		param1
		#dispose
	)
)

