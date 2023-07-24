;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64865)
(include sci.sh)
(use Main)
(use PushButton)
(use soFlashCyberSniff)
(use Plane)
(use Str)
(use Array)
(use Actor)
(use System)

(class TPSelector of View
	(properties
		back 255
		font 0
		fore 0
		width 100
		first 0
		current 0
		downButton 0
		knob 0
		length 0
		listPlane 0
		slider 0
		textHeight 0
		textList 0
		upButton 0
		nWidth 0
		nHeight 0
		oSelectNotify 0
		nSelectMethod 813
		nSelectValue 0
		nItems 0
		oDataArray 0
		oDoubleNotify 0
		nDoubleMethod 0
		nDoubleValue 0
		nClickTime 0
	)

	(method (init &tmp [temp0 2] temp2)
		(= nClickTime (- gGameTime 30))
		(= bitmap (Bitmap 0 1 1 255 255 640 480)) ; Create
		(Bitmap 5 bitmap 0 0 0 0 255) ; AddRect
		(= listPlane
			((Plane new:)
				name: {DSPlane}
				priority: (+ (GetHighPlanePri) 1)
				picture: -2
				init: 0 0 1 1
				yourself:
			)
		)
		(= first 0)
		(super init: &rest)
		(self setSize:)
		(if textList
			(textList eachElementDo: #init listPlane)
		)
		(= temp2 0)
		(if (and upButton (!= upButton -1))
			(upButton init: plane)
		)
		(if (and downButton (!= downButton -1))
			(downButton init: plane)
		)
		(if temp2
			(temp2 dispose:)
			(= temp2 0)
		)
		(self draw:)
	)

	(method (dispose)
		(if textList
			(textList dispose:)
		)
		(if oDataArray
			(oDataArray dispose:)
		)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(if listPlane
			(listPlane dispose:)
		)
		(if upButton
			(upButton dispose:)
		)
		(if downButton
			(downButton dispose:)
		)
		(= nItems
			(= oDataArray
				(= textList
					(= listPlane (= upButton (= downButton (= bitmap 0))))
				)
			)
		)
		(super dispose:)
	)

	(method (posn)
		(super posn: &rest)
		(if listPlane
			(listPlane posn: x y plane)
			(UpdatePlane listPlane)
		)
	)

	(method (getWidth)
		(listPlane getWidth:)
	)

	(method (getHeight)
		(listPlane getHeight:)
	)

	(method (getSelectNum)
		(return current)
	)

	(method (getData param1)
		(if (or (not argc) (< param1 0) (> param1 (- nItems 1)))
			(PrintDebug {getData out of range in TPSelector})
			(return)
		)
		(oDataArray at: param1)
	)

	(method (setData param1 param2)
		(if (or (< argc 2) (< param1 0) (> param1 (- nItems 1)))
			(PrintDebug {setData out of range in TPSelector})
			(return)
		)
		(oDataArray at: param1 param2)
	)

	(method (addItem param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
		(if (or (not argc) (not param1))
			(PrintDebug {Invalid call of addItem in TPSelector})
		)
		(if (< argc 2)
			(= temp1 0)
		else
			(= temp1 param2)
		)
		(if (or (< argc 3) (== param3 -2))
			(= temp0 (- nItems 1))
		else
			(= temp0 param3)
		)
		(if (< argc 4)
			(= temp3 1)
		else
			(= temp3 param4)
		)
		(if (or (< temp0 -1) (> temp0 (- nItems 1)))
			(PrintDebug {addItem out of range in TPSelector})
			(return)
		)
		(if (not textList)
			(= textList ((Cast new:) name: {DSList} add: yourself:))
			(= oDataArray ((IntArray new:) name: {DataArray} yourself:))
		)
		(= temp2
			((TextItem new:)
				font: font
				text: (KArray 8 (KArray 9 param1)) ; ArrayDup, ArrayGetData
				nMinWidth: width
				maxWidth: 640
				mode: 0
				signal: 16385
				yourself:
			)
		)
		(if listPlane
			(temp2 init: listPlane)
		)
		(if (== temp0 -1)
			(textList addToFront: temp2)
		else
			(textList addAfter: (textList at: temp0) temp2)
		)
		(if (< (++ temp0) nItems)
			(oDataArray move: (+ temp0 1) temp0 (- nItems temp0))
		)
		(oDataArray at: temp0 temp1)
		(++ nItems)
		(if temp3
			(self draw:)
		)
	)

	(method (find param1 &tmp temp0 temp1 temp2 temp3)
		(if (or (not argc) (not param1))
			(PrintDebug {illegal call of find in TPSelector})
			(return -1)
		)
		(= temp3 -1)
		(if (and textList (textList size:))
			(= temp1 (Str with: param1))
			(for ((= temp0 0)) (< temp0 nItems) ((++ temp0))
				(if
					(and
						(= temp2 (textList at: temp0))
						(temp2 text:)
						(temp1 compare: (temp2 text:))
					)
					(= temp3 temp0)
					(break)
				)
			)
			(proc64896_7 temp1)
		)
		(return temp3)
	)

	(method (findData param1 &tmp temp0 [temp1 2] temp3)
		(if (not argc)
			(PrintDebug {illegal call of findData in TPSelector})
			(return -1)
		)
		(= temp3 -1)
		(if (and oDataArray (oDataArray size:))
			(for ((= temp0 0)) (< temp0 nItems) ((++ temp0))
				(if (== param1 (oDataArray at: temp0))
					(= temp3 temp0)
					(break)
				)
			)
		)
		(return temp3)
	)

	(method (doSelect param1 &tmp temp0 temp1)
		(if (== nItems 0)
			(return)
		)
		(if (not argc)
			(= temp0 current)
		else
			(= temp0 param1)
		)
		(if (or (< temp0 0) (> temp0 (- nItems 1)))
			(= temp0 current)
		)
		(= current temp0)
		(= temp1 (- (+ first (Min length nItems)) 1))
		(if (< current first)
			(= first current)
		)
		(if (> current temp1)
			(= first (+ (- current length) 1))
		)
		(self draw:)
		(if oSelectNotify
			(Eval oSelectNotify nSelectMethod self nSelectValue)
		)
	)

	(method (doDouble)
		(if oDoubleNotify
			(Eval oDoubleNotify nDoubleMethod self nDoubleValue)
		)
	)

	(method (delete param1 &tmp temp0)
		(if (or (not argc) (< param1 0) (> param1 (- nItems 1)))
			(PrintDebug {delete out of range in TPSelector})
			(return)
		)
		(= temp0 (textList at: param1))
		(textList delete: temp0)
		(temp0 dispose:)
		(if (> nItems (+ param1 1))
			(oDataArray move: param1 (+ param1 1) (- nItems (+ param1 1)))
		)
		(-- nItems)
		(if (== current nItems)
			(= first (Max 0 (- first 1)))
			(self doSelect: (- current 1))
		else
			(self doSelect: current)
		)
	)

	(method (scrollDown param1 &tmp temp0 temp1)
		(= temp0 (if argc param1 else 1))
		(+= first temp0)
		(if (> first (- nItems length))
			(= first (- nItems length))
		)
		(if (< current first)
			(self doSelect: first)
		else
			(self draw:)
		)
	)

	(method (scrollUp param1 &tmp temp0 temp1 temp2)
		(= temp0 (if argc param1 else 1))
		(-= first temp0)
		(if (< first 0)
			(= first 0)
		)
		(= temp2 (- (+ first (Min length nItems)) 1))
		(if (> current temp2)
			(self doSelect: temp2)
		else
			(self draw:)
		)
	)

	(method (canScrollUp)
		(if (and nItems (> first 0))
			(return 1)
		else
			(return 0)
		)
	)

	(method (canScrollDown)
		(if (and nItems (< first (- nItems length)))
			(return 1)
		else
			(return 0)
		)
	)

	(method (draw &tmp temp0 temp1 temp2 temp3 temp4)
		(if (and textList (textList size:))
			(= temp3 (textList at: current))
			(= temp0 (KList 3 (textList elements:))) ; FirstNode
			(for ((= temp4 0)) temp0 ((++ temp4))
				(= temp1 (KList 6 temp0)) ; NextNode
				(= temp2 (KList 8 temp0)) ; NodeValue
				(temp2
					posn: 0 (* (- temp4 first) textHeight)
					fore: (if (== temp3 temp2) back else fore)
					createBitmap:
				)
				(UpdateScreenItem temp2)
				(= temp0 temp1)
			)
		)
	)

	(method (setText param1 &tmp temp0 [temp1 2] temp3 temp4)
		(if (not param1)
			(if textList
				(textList dispose:)
				(= textList 0)
			)
			(if oDataArray
				(oDataArray dispose:)
				(= oDataArray 0)
			)
			(= nItems 0)
			(return)
		)
		(if param1
			(= temp3 (Str newWith: 200 {}))
			(for
				((= temp0 0))
				(and (< temp0 argc) (< (textList size:) 250))
				((++ temp0))
				
				(temp3 copy: [param1 temp0])
				(self addItem: temp3)
			)
			(temp3 dispose:)
			(if (not length)
				(= length argc)
			)
		)
	)

	(method (getText param1 &tmp temp0)
		(if (not argc)
			(= temp0 current)
		else
			(= temp0 param1)
		)
		(if (or (< temp0 0) (> temp0 (- nItems 1)))
			(PrintDebug {getText out of range in TPSelector})
			(return 0)
		)
		(return (Str with: ((textList at: temp0) text:)))
	)

	(method (setSize &tmp temp0 temp1 temp2 temp3)
		(= temp3 (IntArray new:))
		(= temp0 0)
		(if (not width)
			(for
				((= temp1 (KList 3 (textList elements:)))) ; FirstNode
				temp1
				((= temp1 (textList nextNode:)))
				
				(textList nextNode: (KList 6 temp1)) ; NextNode
				(= temp2 (KList 8 temp1)) ; NodeValue
				(Text 0 (temp3 data:) (temp2 text:) font 0) ; TextSize
				(= temp0 (Max (temp3 at: 2) temp0))
			)
		)
		(Text 0 (temp3 data:) {M} font 0) ; TextSize
		(= textHeight (+ (temp3 at: 3) 2))
		(temp3 dispose:)
		(= nWidth (Max width temp0))
		(= nHeight (* textHeight length))
		(if listPlane
			(listPlane setRect: x y (- (+ x nWidth) 1) (- (+ y nHeight) 1))
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event globalize:)
		(if (listPlane onMe: event)
			(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
			(event claimed: 1)
			(event localize: listPlane)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					textList
					(= temp0 (textList firstTrue: #onMe event))
				)
				(if
					(and
						(== (= temp1 (textList indexOf: temp0)) current)
						(< (- (GetTime) nClickTime) 30)
					)
					(self doDouble:)
				else
					(= nClickTime (GetTime))
					(self doSelect: temp1)
				)
			)
		else
			(self forceCursor: 0)
		)
		(event localize: plane)
		(event claimed:)
	)
)

