;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64865)
(include sci.sh)
(use Main)
(use PushButton)
(use n64896)
(use Plane)
(use Str)
(use Array)
(use Actor)
(use System)

(class TPSelector of View
	(properties
		font 0
		length 0
		width 100
		textHeight 0
		first 0
		current 0
		listPlane 0
		textList 0
		fore 0
		back 255
		slider 0
		knob 0
		upButton 0
		downButton 0
		nItems 0
		oDataArray 0
		nHeight 0
		nWidth 0
		oSelectNotify 0
		nSelectMethod 748
		nSelectValue 0
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
			(= textList (= listPlane (= upButton (= downButton (= bitmap 0)))))
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

	(method (getData nWhich)
		(if (or (not argc) (< nWhich 0) (> nWhich (- nItems 1)))
			(PrintDebug {getData out of range in TPSelector})
			(return)
		)
		(oDataArray at: nWhich)
	)

	(method (setData nWhich nData)
		(if (or (< argc 2) (< nWhich 0) (> nWhich (- nItems 1)))
			(PrintDebug {setData out of range in TPSelector})
			(return)
		)
		(oDataArray at: nWhich nData)
	)

	(method (addItem oString nDataParm nAfterParm bDrawParm &tmp nAfter nData oItemTmp bDraw)
		(if (or (not argc) (not oString))
			(PrintDebug {Invalid call of addItem in TPSelector})
		)
		(if (< argc 2)
			(= nData 0)
		else
			(= nData nDataParm)
		)
		(if (or (< argc 3) (== nAfterParm -2))
			(= nAfter (- nItems 1))
		else
			(= nAfter nAfterParm)
		)
		(if (< argc 4)
			(= bDraw 1)
		else
			(= bDraw bDrawParm)
		)
		(if (or (< nAfter -1) (> nAfter (- nItems 1)))
			(PrintDebug {addItem out of range in TPSelector})
			(return)
		)
		(if (not textList)
			(= textList ((Cast new:) name: {DSList} add: yourself:))
			(= oDataArray ((IntArray new:) name: {DataArray} yourself:))
		)
		(= oItemTmp
			((TextItem new:)
				font: font
				text: (KString 8 (KString 9 oString)) ; StrDup, StrGetData
				nMinWidth: width
				maxWidth: 640
				mode: 0
				yourself:
			)
		)
		(if listPlane
			(oItemTmp init: listPlane)
		)
		(if (== nAfter -1)
			(textList addToFront: oItemTmp)
		else
			(textList addAfter: (textList at: nAfter) oItemTmp)
		)
		(if (< (++ nAfter) nItems)
			(oDataArray move: (+ nAfter 1) nAfter (- nItems nAfter))
		)
		(oDataArray at: nAfter nData)
		(++ nItems)
		(if bDraw
			(self draw:)
		)
	)

	(method (find strWhich &tmp i strTmp oItem nRet)
		(if (or (not argc) (not strWhich))
			(PrintDebug {illegal call of find in TPSelector})
			(return -1)
		)
		(= nRet -1)
		(if (and textList (textList size:))
			(= strTmp (Str with: strWhich))
			(for ((= i 0)) (< i nItems) ((++ i))
				(if
					(and
						(= oItem (textList at: i))
						(oItem text:)
						(strTmp compare: (oItem text:))
					)
					(= nRet i)
					(break)
				)
			)
			(StringDispose strTmp)
		)
		(return nRet)
	)

	(method (findData nWhich &tmp temp0 [temp1 2] temp3)
		(if (not argc)
			(PrintDebug {illegal call of findData in TPSelector})
			(return -1)
		)
		(= temp3 -1)
		(if (and oDataArray (oDataArray size:))
			(for ((= temp0 0)) (< temp0 nItems) ((++ temp0))
				(if (== nWhich (oDataArray at: temp0))
					(= temp3 temp0)
					(break)
				)
			)
		)
		(return temp3)
	)

	(method (doSelect nWhichParm &tmp nWhich nLast)
		(if (not argc)
			(= nWhich current)
		else
			(= nWhich nWhichParm)
		)
		(if (or (< nWhich 0) (> nWhich (- nItems 1)))
			(= nWhich current)
		)
		(= current nWhich)
		(= nLast (- (+ first (Min length nItems)) 1))
		(if (< current first)
			(= first current)
		)
		(if (> current nLast)
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

	(method (delete nWhich &tmp oTmp)
		(if (or (not argc) (< nWhich 0) (> nWhich (- nItems 1)))
			(PrintDebug {delete out of range in TPSelector})
			(return)
		)
		(= oTmp (textList at: nWhich))
		(textList delete: oTmp)
		(oTmp dispose:)
		(if (> nItems (+ nWhich 1))
			(oDataArray move: nWhich (+ nWhich 1) (- nItems (+ nWhich 1)))
		)
		(-- nItems)
		(if (== current nItems)
			(= first (Max 0 (- first 1)))
			(self doSelect: (- current 1))
		else
			(self doSelect: current)
		)
	)

	(method (scrollDown howMany &tmp nMove nSelect)
		(= nMove (if argc howMany else 1))
		(+= first nMove)
		(if (> first (- nItems length))
			(= first (- nItems length))
		)
		(if (< current first)
			(self doSelect: first)
		else
			(self draw:)
		)
	)

	(method (scrollUp howMany &tmp nMove nSelect nLast)
		(= nMove (if argc howMany else 1))
		(-= first nMove)
		(if (< first 0)
			(= first 0)
		)
		(= nLast (- (+ first (Min length nItems)) 1))
		(if (> current nLast)
			(self doSelect: nLast)
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

	(method (draw &tmp node nextNode obj cobj i)
		(if (and textList (textList size:))
			(= cobj (textList at: current))
			(= node (KList 3 (textList elements:))) ; FirstNode
			(for ((= i 0)) node ((++ i))
				(= nextNode (KList 6 node)) ; NextNode
				(= obj (KList 8 node)) ; NodeValue
				(obj
					posn: 0 (* (- i first) textHeight)
					fore: (if (== cobj obj) back else fore)
					createBitmap:
				)
				(UpdateScreenItem obj)
				(= node nextNode)
			)
		)
	)

	(method (setText theText &tmp temp0 [temp1 2] temp3 temp4)
		(if (not theText)
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
		(if theText
			(= temp3 (Str newWith: 200 {}))
			(for
				((= temp0 0))
				(and (< temp0 argc) (< (textList size:) 250))
				((++ temp0))
				
				(temp3 copy: [theText temp0])
				(self addItem: temp3)
			)
			(temp3 dispose:)
			(if (not length)
				(= length argc)
			)
		)
	)

	(method (getText nWhichParm &tmp nWhich)
		(if (not argc)
			(= nWhich current)
		else
			(= nWhich nWhichParm)
		)
		(if (or (< nWhich 0) (> nWhich (- nItems 1)))
			(PrintDebug {getText out of range in TPSelector})
			(return 0)
		)
		(return (Str with: ((textList at: nWhich) text:)))
	)

	(method (setSize &tmp widest node obj r)
		(= r (IntArray new:))
		(= widest 0)
		(if (not width)
			(for
				((= node (KList 3 (textList elements:)))) ; FirstNode
				node
				((= node (textList nextNode:)))
				
				(textList nextNode: (KList 6 node)) ; NextNode
				(= obj (KList 8 node)) ; NodeValue
				(Text 0 (r data:) (obj text:) font 0) ; TextSize
				(= widest (Max (r at: 2) widest))
			)
		)
		(Text 0 (r data:) {M} font 0) ; TextSize
		(= textHeight (+ (r at: 3) 2))
		(r dispose:)
		(= nWidth (Max width widest))
		(= nHeight (* textHeight length))
		(if listPlane
			(listPlane setRect: x y (- (+ x nWidth) 1) (- (+ y nHeight) 1))
		)
	)

	(method (handleEvent event &tmp ret nSelect)
		(event globalize:)
		(if (listPlane onMe: event)
			(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
			(event claimed: 1)
			(event localize: listPlane)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					(= ret (textList firstTrue: #onMe event))
				)
				(if
					(and
						(== (= nSelect (textList indexOf: ret)) current)
						(< (- (GetTime) nClickTime) 30)
					)
					(self doDouble:)
				else
					(= nClickTime (GetTime))
					(self doSelect: nSelect)
				)
			)
		else
			(self forceCursor: 0)
		)
		(event localize: plane)
		(event claimed:)
	)
)

