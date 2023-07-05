;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 936)
(include sci.sh)
(use Window)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13 &tmp temp0 temp1)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph grFILL_BOX param1 param2 (+ param3 1) (+ param4 1) param13 param5 param12)
	(-= param1 param10)
	(-= param2 param10)
	(+= param4 param10)
	(+= param3 param10)
	(Graph grFILL_BOX param1 param2 (+ param1 param10) param4 param13 param6 param12)
	(Graph grFILL_BOX (- param3 param10) param2 param3 param4 param13 param8 param12)
	(for ((= temp1 0)) (< temp1 param10) ((++ temp1))
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(+ param2 temp1)
			(- param3 (+ temp1 1))
			(+ param2 temp1)
			param7
			param12
			-1
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(- param4 (+ temp1 1))
			(- param3 (+ temp1 1))
			(- param4 (+ temp1 1))
			param9
			param12
			-1
		)
	)
	(if param11
		(Graph
			grFILL_BOX
			(+ param1 param11)
			param4
			(+ param3 param11)
			(+ param4 param11)
			param13
			0
			param12
		)
		(Graph
			grFILL_BOX
			param3
			(+ param2 param11)
			(+ param3 param11)
			param4
			param13
			0
			param12
		)
	)
	(SetPort temp0)
)

(class BorderWindow of SysWindow
	(properties
		sel_20 {BorderWindow}
		sel_26 5
		sel_337 7
		sel_338 6
		sel_339 4
		sel_340 3
		sel_341 3
		sel_342 2
	)

	(method (sel_183 &tmp temp0 temp1)
		(SetPort 0)
		(= temp1 1)
		(if (!= sel_60 -1)
			(|= temp1 $0002)
		)
		(= sel_10 (- sel_187 sel_341))
		(= sel_11 (- sel_188 sel_341))
		(= sel_13 (+ sel_190 sel_341 sel_342))
		(= sel_12 (+ sel_189 sel_341 sel_342))
		(|= sel_31 $0080)
		(super sel_183:)
		(localproc_0
			sel_187
			sel_188
			sel_189
			sel_190
			sel_26
			sel_337
			sel_338
			sel_340
			sel_339
			sel_341
			sel_342
			sel_60
			temp1
		)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX sel_10 sel_11 sel_12 sel_13 1)
		(SetPort temp0)
	)
)

(class InsetWindow of BorderWindow
	(properties
		sel_20 {InsetWindow}
		sel_337 5
		sel_338 4
		sel_339 2
		sel_340 1
		sel_343 3
		sel_344 2
		sel_345 0
		sel_346 1
		sel_347 5
		sel_348 4
		sel_349 10
		sel_350 24
		sel_351 2
		sel_352 0
		sel_353 2
		sel_354 0
		sel_355 0
	)

	(method (sel_183 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 1)
		(if (!= sel_60 -1)
			(|= temp0 $0002)
		)
		(= temp2 sel_187)
		(= temp3 sel_188)
		(= temp4 sel_189)
		(= temp5 sel_190)
		(-= sel_187 (+ sel_341 sel_349))
		(-= sel_188 (+ sel_341 sel_351))
		(+= sel_189 (+ sel_341 sel_350))
		(+= sel_190 (+ sel_341 sel_351))
		(= sel_354 (+ sel_341 sel_351))
		(= sel_355 (+ sel_341 sel_349))
		(super sel_183:)
		(localproc_0
			temp2
			temp3
			temp4
			temp5
			sel_344
			sel_345
			sel_346
			sel_347
			sel_348
			sel_353
			sel_352
			sel_60
			temp0
		)
		(= temp1 (GetPort))
		(SetPort 0)
		(Graph
			grUPDATE_BOX
			(- temp2 sel_353)
			(- temp3 sel_353)
			(+ temp4 sel_353)
			(+ temp5 sel_353)
			1
		)
		(SetPort temp1)
	)
)

