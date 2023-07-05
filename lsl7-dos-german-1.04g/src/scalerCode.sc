;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64012)
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
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(local1 scaleSignal: 1 y: param1)
	(UpdateScreenItem local1)
	(FrameOut)
	(= temp4 (CelHigh (local1 view:) (local1 loop:) (local1 cel:)))
	(while (!= ((= temp3 (Event new:)) type:) evMOUSEBUTTON)
		(if
			(and
				(<
					(= temp1
						(/ (* (= temp2 (- gScreenHeight (temp3 y:))) 100) temp4)
					)
					253
				)
				(!= temp0 temp1) ; UNINIT
			)
			(= temp0 temp1)
			(local1
				scaleX: (Max (/ (* temp0 128) 100) 1)
				scaleY: (Max (/ (* temp0 128) 100) 1)
			)
		)
		(= temp6 (Str format: {%s scale= %d} param2 temp0))
		((= temp5 (DText new:))
			text: (KArray 8 (temp6 data:)) ; ArrayDup
			fore: 87
			back: 0
			skip: 255
			setSize: 240
			setPri: 255
			posn: local2 local3
			init: (local0 getMainCast:)
		)
		(temp3 localize: local0)
		(local1 x: (temp3 x:))
		(UpdateScreenItem local1)
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
		(temp0 localize: local0)
		(temp0 y: (Max param1 (temp0 y:)))
		(= temp3 (Str format: {%s y= %d} param2 (temp0 y:)))
		((= temp2 (DText new:))
			text: (KArray 8 (temp3 data:)) ; ArrayDup
			fore: 87
			back: 0
			skip: 255
			setSize: 240
			setPri: 255
			posn: local2 local3
			init: (local0 getMainCast:)
		)
		(UpdateLine
			param3
			local0
			0
			(temp0 y:)
			(local0 getWidth:)
			(temp0 y:)
			100
			local4
			0
			0
			1
		)
		(FrameOut)
		(temp2 dispose:)
		(temp3 dispose:)
		(temp0 dispose:)
	)
	(temp0 localize: local0)
	(= temp1 (Max param1 (temp0 y:)))
	(temp0 dispose:)
	(return temp1)
)

(instance scalerCode of Code
	(properties)

	(method (init param1 param2 &tmp temp0)
		(if (not (RespondsTo param1 #scaler))
			(Printf {scalerCode: object %s does not scale} (param1 name:))
			(return)
		)
		(= local1 param1)
		(= local0 param2)
		(= temp0 (Event new:))
		(temp0 x: 4)
		(temp0 y: 4)
		(temp0 localize: local0)
		(= local2 (temp0 x:))
		(= local3 (temp0 y:))
		(temp0 dispose:)
	)

	(method (dispose)
		(= local1 0)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (not local1)
			(Prints {scalerCode: please init with an object first})
			(return)
		)
		(local1 setScale: 0)
		(= temp0 (local1 x:))
		(= temp1 (local1 y:))
		(= local4 210)
		(= temp6
			(AddLine
				local0
				0
				(local1 y:)
				(local0 getWidth:)
				(local1 y:)
				100
				local4
				0
				0
				1
			)
		)
		(= temp2
			(localproc_1 0 (Str with: {back Y, click when done.   }) temp6)
		)
		(= temp4
			(localproc_0 temp2 (Str with: {Size object, click when done.   }))
		)
		(= temp7
			(AddLine
				local0
				0
				(local1 y:)
				(local0 getWidth:)
				(local1 y:)
				100
				local4
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
		(local1 posn: temp0 temp1)
		(Printf {Scaler %d %d %d %d} temp5 temp4 temp3 temp2)
		(local1 setScaler: Scaler temp5 temp4 temp3 temp2)
		(DeleteLine temp6 local0)
		(DeleteLine temp7 local0)
	)
)

