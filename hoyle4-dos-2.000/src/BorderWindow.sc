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
		back 5
		topBordColor 7
		lftBordColor 6
		rgtBordColor 4
		botBordColor 3
		bevelWid 3
		shadowWid 2
	)

	(method (open &tmp savePort wMap)
		(SetPort 0)
		(= wMap 1)
		(if (!= priority -1)
			(|= wMap $0002)
		)
		(= lsTop (- top bevelWid))
		(= lsLeft (- left bevelWid))
		(= lsRight (+ right bevelWid shadowWid))
		(= lsBottom (+ bottom bevelWid shadowWid))
		(= type 128)
		(super open:)
		(localproc_0
			top
			left
			bottom
			right
			back
			topBordColor
			lftBordColor
			botBordColor
			rgtBordColor
			bevelWid
			shadowWid
			priority
			wMap
		)
		(= savePort (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort savePort)
	)

	(method (dispose)
		(super dispose:)
		(SetPort 0)
	)
)

