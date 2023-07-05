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
	scalePlane
	scaleObj
	scaleCenterX
	scaleCenterY
	palNum
)

(procedure (SizeObject yCoordinate str &tmp actorSize percent deltaY1 evt objHeight tmpDlg tmpStr)
	(scaleObj scaleSignal: 1 y: yCoordinate)
	(UpdateScreenItem scaleObj)
	(FrameOut)
	(= objHeight (CelHigh (scaleObj view:) (scaleObj loop:) (scaleObj cel:)))
	(while (!= ((= evt (Event new:)) type:) evMOUSEBUTTON)
		(if
			(and
				(<
					(= percent
						(/ (* (= deltaY1 (- gScreenHeight (evt y:))) 100) objHeight)
					)
					253
				)
				(!= actorSize percent) ; UNINIT
			)
			(= actorSize percent)
			(scaleObj
				scaleX: (Max (/ (* actorSize 128) 100) 1)
				scaleY: (Max (/ (* actorSize 128) 100) 1)
			)
		)
		(= tmpStr (Str format: {%s scale= %d} str actorSize))
		((= tmpDlg (DText new:))
			text: (KString 8 (tmpStr data:)) ; StrDup
			fore: 235
			back: 227
			skip: 0
			setSize: 240
			setPri: 255
			posn: scaleCenterX scaleCenterY
			init: (scalePlane getMainCast:)
		)
		(evt localize: scalePlane)
		(scaleObj x: (evt x:))
		(UpdateScreenItem scaleObj)
		(FrameOut)
		(tmpDlg dispose:)
		(tmpStr dispose:)
		(evt dispose:)
	)
	(evt dispose:)
	(return actorSize)
)

(procedure (TrackCursor lowestPoint str linePointer &tmp evt oldY tmpDlg tmpStr)
	(= oldY 0)
	(while (!= ((= evt (Event new:)) type:) evMOUSEBUTTON)
		(evt localize: scalePlane)
		(evt y: (Max lowestPoint (evt y:)))
		(= tmpStr (Str format: {%s y= %d} str (evt y:)))
		((= tmpDlg (DText new:))
			text: (KString 8 (tmpStr data:)) ; StrDup
			fore: 235
			back: 227
			skip: 0
			setSize: 240
			setPri: 255
			posn: scaleCenterX scaleCenterY
			init: (scalePlane getMainCast:)
		)
		(UpdateLine
			linePointer
			scalePlane
			0
			(evt y:)
			(scalePlane getWidth:)
			(evt y:)
			100
			palNum
			0
			0
			1
		)
		(FrameOut)
		(tmpDlg dispose:)
		(tmpStr dispose:)
		(evt dispose:)
	)
	(evt localize: scalePlane)
	(= oldY (Max lowestPoint (evt y:)))
	(evt dispose:)
	(return oldY)
)

(instance scalerCode of Code
	(properties)

	(method (init theObj aPlane &tmp evt)
		(if (not (RespondsTo theObj #scaler))
			(Printf {scalerCode: object %s does not scale} (theObj name:))
			(return)
		)
		(= scaleObj theObj)
		(= scalePlane aPlane)
		(= evt (Event new:))
		(evt x: 4)
		(evt y: 4)
		(evt localize: scalePlane)
		(= scaleCenterX (evt x:))
		(= scaleCenterY (evt y:))
		(evt dispose:)
	)

	(method (dispose)
		(= scaleObj 0)
	)

	(method (doit &tmp oldObjX oldObjY backY frontY backSize frontSize backLine frontLine)
		(if (not scaleObj)
			(Prints {scalerCode: please init with an object first})
			(return)
		)
		(scaleObj setScale: 0)
		(= oldObjX (scaleObj x:))
		(= oldObjY (scaleObj y:))
		(= palNum 210)
		(= backLine
			(AddLine
				scalePlane
				0
				(scaleObj y:)
				(scalePlane getWidth:)
				(scaleObj y:)
				100
				palNum
				0
				0
				1
			)
		)
		(= backY
			(TrackCursor 0 (Str with: {back Y, click when done.   }) backLine)
		)
		(= backSize
			(SizeObject backY (Str with: {Size object, click when done.   }))
		)
		(= frontLine
			(AddLine
				scalePlane
				0
				(scaleObj y:)
				(scalePlane getWidth:)
				(scaleObj y:)
				100
				palNum
				0
				0
				1
			)
		)
		(= frontY
			(TrackCursor backY (Str with: {front Y, click when done.   }) frontLine)
		)
		(= frontSize
			(SizeObject frontY (Str with: {Size object, click when done.   }))
		)
		(scaleObj posn: oldObjX oldObjY)
		(Printf {Scaler %d %d %d %d} frontSize backSize frontY backY)
		(scaleObj setScaler: Scaler frontSize backSize frontY backY)
		(DeleteLine backLine scalePlane)
		(DeleteLine frontLine scalePlane)
	)
)

