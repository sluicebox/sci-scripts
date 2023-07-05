;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Print)
(use Scaler)
(use System)

(public
	scalerCode 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(gEgo scaleSignal: 1 y: param1)
	(UpdateScreenItem gEgo)
	(FrameOut)
	(= temp4 (CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:)))
	(while (!= ((= temp3 (Event new:)) type:) evMOUSEBUTTON)
		(if
			(and
				(< (= temp1 (/ (* (= temp2 (- 200 (temp3 y:))) 100) temp4)) 253)
				(!= temp0 temp1) ; UNINIT
			)
			(= temp0 temp1)
			(gEgo
				scaleX: (Max (/ (* temp0 128) 100) 1)
				scaleY: (Max (/ (* temp0 128) 100) 1)
			)
		)
		(= temp6 (Str format: {%s scale= %d} param2 temp0))
		((= temp5 (DText new:))
			text: (KString 8 (temp6 data:)) ; StrDup
			fore: 255
			back: 0
			setSize: 240
			setPri: 255
			init:
		)
		(gEgo x: (temp3 x:))
		(UpdateScreenItem gEgo)
		(FrameOut)
		(temp5 dispose:)
		(temp6 dispose:)
		(temp3 dispose:)
	)
	(temp3 dispose:)
	(return temp0)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp1 0)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
		(temp0 y: (Max (+ param1 1) (- (temp0 y:) 10)))
		(= temp3 (Str format: {%s y= %d} param2 (temp0 y:)))
		((= temp2 (DText new:))
			text: (KString 8 (temp3 data:)) ; StrDup
			fore: 255
			back: 0
			setSize: 240
			setPri: 255
			init:
		)
		(UpdateLine
			param3
			(gCast plane:)
			0
			(temp0 y:)
			320
			(temp0 y:)
			100
			local0
			0
			0
			1
		)
		(FrameOut)
		(temp2 dispose:)
		(temp3 dispose:)
		(temp0 dispose:)
	)
	(= temp1 (Max (+ param1 1) (- (temp0 y:) 10)))
	(temp0 dispose:)
	(return temp1)
)

(instance scalerCode of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gEgo setScale: 0)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo y:))
		(= local0 (Palette 3 255 0 0)) ; PalMatch
		(= temp6
			(AddLine
				(gCast plane:)
				0
				(gEgo y:)
				320
				(gEgo y:)
				100
				local0
				0
				0
				1
			)
		)
		(= temp2
			(localproc_1 -1 (Str with: {back Y, click when done.   }) temp6)
		)
		(= temp4
			(localproc_0 temp2 (Str with: {Size object, click when done.   }))
		)
		(= temp7
			(AddLine
				(gCast plane:)
				0
				(gEgo y:)
				320
				(gEgo y:)
				100
				local0
				0
				0
				1
			)
		)
		(= temp3
			(localproc_1 temp2 (Str with: {front Y, click when done.   }) temp7)
		)
		(= temp5
			(localproc_0 temp3 (Str with: {Size object, click when done.   }))
		)
		(gEgo posn: temp0 temp1)
		(Printf {Scaler %d %d %d %d} temp5 temp4 temp3 temp2)
		(gEgo setScaler: Scaler temp5 temp4 temp3 temp2)
		(DeleteLine temp6 (gCast plane:))
		(DeleteLine temp7 (gCast plane:))
	)
)

