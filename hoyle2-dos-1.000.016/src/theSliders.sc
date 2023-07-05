;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 323)
(include sci.sh)
(use Main)
(use Column)
(use Stock)
(use Reserve)
(use WL)
(use System)

(public
	theSliders 0
	proc323_1 1
	proc323_2 2
	proc323_3 3
	proc323_4 4
	proc323_5 5
	proc323_6 6
)

(local
	local0
	local1
	local2
)

(procedure (proc323_1 param1 &tmp temp0 temp1)
	(if
		(or
			(param1 size:)
			(param1 isMemberOf: Reserve)
			(not ((gTheWastePiles at: 0) size:))
		)
		(proc0_5 (Format @global100 323 0)) ; "Not A Valid Move."
	else
		(= temp1 (param1 isThereADimmedObject: 1))
		(= temp0 (temp1 at: 0))
		(temp1 giveUpCards:)
		(gTheCardToss init: temp0 param1 418)
	)
)

(procedure (proc323_2 param1 &tmp temp0 temp1 temp2)
	(if (== (param1 size:) 1)
		(= global687 1)
		(return)
	else
		(= temp0 ((global423 at: (param1 rowNumber:)) indexOf: param1))
		(cond
			((== global319 1)
				(if (not temp0)
					(gTheTransferList empty: add: (param1 at: 0))
					(param1 delete: (param1 at: 0))
					(= temp1 0)
					(for ((= temp2 0)) (< temp2 6) ((++ temp2))
						(if
							(==
								((((global423 at: (param1 rowNumber:))
											at: temp2
										)
										at: 0
									)
									rank:
								)
								((gTheTransferList at: 0) rank:)
							)
							(= temp1 gTheStock)
							(break)
						)
					)
					(if (or (not temp1) (>= global337 400))
						(= temp1 (gTheReserves at: 0))
					)
					(gTheCardToss init: (gTheTransferList at: 0) temp1 418)
				else
					(gTheTransferList empty: add: (param1 at: 0))
					(param1 delete: (param1 at: 0))
					(gTheCardToss
						init:
							(gTheTransferList at: 0)
							((global423 at: (param1 rowNumber:))
								at: (- temp0 1)
							)
							418
					)
				)
			)
			((== temp0 5)
				(gTheTransferList empty: add: (param1 at: 0))
				(param1 delete: (param1 at: 0))
				(= temp1 0)
				(for ((= temp2 0)) (< temp2 6) ((++ temp2))
					(if
						(==
							((((global423 at: (param1 rowNumber:)) at: temp2)
									at: 0
								)
								rank:
							)
							((gTheTransferList at: 0) rank:)
						)
						(= temp1 gTheStock)
						(break)
					)
				)
				(if (or (not temp1) (>= global337 400))
					(= temp1 (gTheReserves at: 0))
				)
				(gTheCardToss init: (gTheTransferList at: 0) temp1 418)
			)
			(else
				(gTheTransferList empty: add: (param1 at: 0))
				(param1 delete: (param1 at: 0))
				(gTheCardToss
					init:
						(gTheTransferList at: 0)
						((global423 at: (param1 rowNumber:)) at: (+ temp0 1))
						418
				)
			)
		)
	)
)

(procedure (proc323_3 &tmp temp0 temp1)
	(= global412 24)
	((= global423 (WL new:)) add:)
	(global423 name: {Rows})
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		((= temp1 (WL new:)) add: name: {aRow})
		(global423 add: temp1)
	)
)

(procedure (proc323_4 &tmp temp0 temp1 temp2 temp3 temp4)
	(if (localproc_0)
		(switch local1
			(0
				(= temp0 1)
				(= temp1 2)
				(= temp2 3)
			)
			(1
				(= temp0 0)
				(= temp1 2)
				(= temp2 3)
			)
			(2
				(= temp0 0)
				(= temp1 1)
				(= temp2 3)
			)
			(3
				(= temp0 0)
				(= temp1 1)
				(= temp2 2)
			)
		)
		(= temp4 ((global423 at: temp0) at: local2))
		((= temp3 (temp4 at: 0)) dim: changed: 1)
		(temp4 giveUpCards:)
		(gTheCardToss init: temp3 (gTheReserves at: 1) 418)
		(= temp4 ((global423 at: temp1) at: local2))
		((= temp3 (temp4 at: 0)) dim: changed: 1)
		(temp4 giveUpCards: gTheTransferList2)
		(gTheAutoCardToss init: temp3 (gTheReserves at: 1) 418)
		(= temp4 ((global423 at: temp2) at: local2))
		((= temp3 (temp4 at: 0)) dim: changed: 1)
		(temp4 giveUpCards: gTheTransferList3)
		(gTheAutoCardToss2 init: temp3 (gTheReserves at: 1) 418)
	)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= local0 99)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= temp1 (= temp2 (= temp3 (= temp4 0))))
		(if (((global423 at: 0) at: temp0) size:)
			(= temp1 ((((global423 at: 0) at: temp0) at: 0) rank:))
		)
		(if (((global423 at: 1) at: temp0) size:)
			(= temp2 ((((global423 at: 1) at: temp0) at: 0) rank:))
		)
		(if (((global423 at: 2) at: temp0) size:)
			(= temp3 ((((global423 at: 2) at: temp0) at: 0) rank:))
		)
		(if (((global423 at: 3) at: temp0) size:)
			(= temp4 ((((global423 at: 3) at: temp0) at: 0) rank:))
		)
		(if
			(and
				temp1
				temp2
				temp3
				(== temp1 temp2)
				(== temp1 temp3)
				(< temp1 local0)
			)
			(= local0 temp1)
			(= local2 temp0)
			(= local1 3)
		)
		(if
			(and
				temp1
				temp2
				temp4
				(== temp1 temp2)
				(== temp1 temp4)
				(< temp1 local0)
			)
			(= local0 temp1)
			(= local2 temp0)
			(= local1 2)
		)
		(if
			(and
				temp1
				temp3
				temp4
				(== temp1 temp3)
				(== temp1 temp4)
				(< temp1 local0)
			)
			(= local0 temp1)
			(= local2 temp0)
			(= local1 1)
		)
		(if
			(and
				temp2
				temp3
				temp4
				(== temp2 temp3)
				(== temp2 temp4)
				(< temp2 local0)
			)
			(= local0 temp2)
			(= local2 temp0)
			(= local1 0)
		)
	)
	(return (if (< local0 99) 1 else 0))
)

(procedure (proc323_5 param1 param2)
	(if (param1 isMemberOf: Stock)
		(if ((gTheWastePiles at: 0) size:)
			((param2 at: 0) faceUp: 0)
			(param1 addToFront: (param2 at: 0))
			(if (== (param1 size:) 1)
				(proc0_1
					200
					0
					global300
					(param1 x:)
					(param1 y:)
					(param1 priority:)
				)
			)
			((param2 at: 0) x: (param1 x:) y: (param1 y:))
		else
			((gTheWastePiles at: 0) add: (param2 at: 0))
			(proc0_1
				((param2 at: 0) suit:)
				1
				((param2 at: 0) rank:)
				((gTheWastePiles at: 0) x:)
				((gTheWastePiles at: 0) y:)
				(param1 priority:)
			)
			((param2 at: 0)
				x: ((gTheWastePiles at: 0) x:)
				y: ((gTheWastePiles at: 0) y:)
				changed: 0
				dimmed: 1
			)
		)
	)
)

(procedure (proc323_6 param1 param2)
	(if (param1 isMemberOf: Column)
		(for ((= global301 0)) (< global301 (param2 size:)) ((++ global301))
			(param1 add: (param2 at: global301))
		)
		(param1 updateCoords: showUpdate:)
	)
	(param2 empty:)
	(if (not (param1 isKindOf: Column))
		(proc0_2)
		(proc323_4)
	)
)

(class Slider of Obj
	(properties
		x 0
		y 0
		view 12
		cel 0
		row 0
	)

	(method (init)
		(= gTheSliders theSliders)
		(gTheSliders add: self)
		(gMainKeyMouseList add: self)
	)

	(method (draw)
		(DrawCel 12 0 cel x y 8)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(and
				((gTheWastePiles at: 0) size:)
				(not (event claimed:))
				(<= x (event x:) (+ x (CelWide 12 0 cel)))
				(<= y (event y:) (+ y (CelHigh 12 0 cel)))
			)
			(event claimed: 1)
			(= global319 cel)
			(= temp0 ((gTheColumns at: 0) isThereADimmedObject: 1))
			(= temp1 (temp0 firstDimmed:))
			(temp0 giveUpCards:)
			(gTheCardToss init: temp1 ((global423 at: row) at: (* cel 5)) 418)
		)
	)
)

(instance slider1 of Slider
	(properties
		x 4
		y 2
	)
)

(instance slider2 of Slider
	(properties
		x 4
		y 46
		row 1
	)
)

(instance slider3 of Slider
	(properties
		x 4
		y 90
		row 2
	)
)

(instance slider4 of Slider
	(properties
		x 4
		y 134
		row 3
	)
)

(instance slider5 of Slider
	(properties
		x 240
		y 2
		cel 1
	)
)

(instance slider6 of Slider
	(properties
		x 240
		y 46
		cel 1
		row 1
	)
)

(instance slider7 of Slider
	(properties
		x 240
		y 90
		cel 1
		row 2
	)
)

(instance slider8 of Slider
	(properties
		x 240
		y 134
		cel 1
		row 3
	)
)

(instance theSliders of WL
	(properties)

	(method (init)
		(= gTheSliders self)
		(slider1 init:)
		(slider2 init:)
		(slider3 init:)
		(slider4 init:)
		(slider5 init:)
		(slider6 init:)
		(slider7 init:)
		(slider8 init:)
	)
)

