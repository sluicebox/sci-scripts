;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Window)

(class Class_10_0 of SysWindow
	(properties
		sel_20 -1
	)

	(method (sel_183)
		(SetPort 0)
		(Graph grUPDATE_BOX (- sel_187 1) (- sel_188 1) (+ sel_189 1) (+ sel_190 1) 1)
		(= sel_10 sel_187)
		(= sel_12 sel_189)
		(= sel_13 sel_190)
		(= sel_11 (- sel_188 1))
		(|= sel_31 $0080)
		(super sel_183:)
	)
)

