;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64913)
(include sci.sh)
(use Main)
(use DButton)
(use DText)
(use DItem)
(use Plane)
(use Str)
(use Array)
(use System)

(class DSelector of DItem
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
	)

	(method (init theList &tmp temp0 temp1 temp2 temp3)
		(if (== gCurRoomNum 100)
			(= temp3 151)
		else
			(= temp3 970)
		)
		(= temp0
			((DText new:)
				fore: 0
				back: 0
				skip: 0
				font: font
				text: { }
				setSize:
				yourself:
			)
		)
		(= bitmap
			(CreateTextBitmap
				0
				(+ (- (temp0 nsRight:) (temp0 nsLeft:)) 1)
				(+ (- (temp0 nsBottom:) (temp0 nsTop:)) 1)
				temp0
			)
		)
		(DisposeClone temp0)
		(= listPlane
			((Plane new:)
				name: {DSPlane}
				priority: (+ (GetHighPlanePri) 1)
				yourself:
			)
		)
		(= first 0)
		(super init: theList &rest)
		(listPlane
			init: 0 0 (+ (- nsRight nsLeft) 1) (+ (- nsBottom nsTop) 3)
			back: back
			posn: nsLeft nsTop plane
			addCast: textList
		)
		(textList eachElementDo: #init textList)
		(= upButton (DButton new:))
		(= temp2 (Str with: { }))
		(upButton
			text: (KString 8 (temp2 data:)) ; StrDup
			view: temp3
			loop: 5
			cel: 0
			object: self
			selector: #scrollUp
			state: 1
			setSize:
			init: theList
			yourself:
		)
		(= downButton
			((DButton new:)
				text: (KString 8 (temp2 data:)) ; StrDup
				view: temp3
				loop: 6
				cel: 0
				setSize:
				object: self
				selector: #scrollDown
				state: 1
				init: theList
				yourself:
			)
		)
		(self draw:)
		(temp2 dispose:)
	)

	(method (dispose)
		(textList dispose:)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(listPlane dispose:)
		(upButton dispose:)
		(downButton dispose:)
		(= textList (= listPlane (= upButton (= downButton (= bitmap 0)))))
		(super dispose:)
	)

	(method (scrollDown howMany &tmp num)
		(= num (if argc howMany else 1))
		(if (>= (+= current howMany) (textList size:))
			(= current (- (textList size:) 1))
		)
		(if (>= current (+ first length))
			(= first (- current (- length 1)))
		)
		(self draw:)
	)

	(method (scrollUp howMany &tmp num)
		(= num (if argc howMany else 1))
		(if (< (-= current howMany) 0)
			(= current 0)
		)
		(if (< current first)
			(= first current)
		)
		(self draw:)
	)

	(method (draw &tmp node nextNode obj cobj i)
		(if (textList size:)
			(= cobj (textList at: current))
			(= node (KList 3 (textList elements:))) ; FirstNode
			(for ((= i 0)) node ((++ i))
				(= nextNode (KList 6 node)) ; NextNode
				(= obj (KList 8 node)) ; NodeValue
				(obj
					moveTo: 2 (+ 1 (* (- first i) -1 textHeight))
					fore: (if (== cobj obj) back else fore)
					back: (if (== cobj obj) fore else back)
					draw:
				)
				(UpdateScreenItem obj)
				(= node nextNode)
			)
		)
		(if gSaveFileSelText
			(gSaveFileSelText dispose:)
			(= gSaveFileSelText 0)
		)
		(if (>= (- (textList size:) 1) current 0)
			(= gSaveFileSelText (Str with: ((textList at: current) text:)))
		)
	)

	(method (setText theText &tmp temp0 [temp1 2] temp3)
		(if (and (not theText) textList)
			(textList dispose:)
			(= textList 0)
		)
		(if (not textList)
			(= textList ((Cast new:) name: {DSList} add: yourself:))
		)
		(if theText
			(= temp3 (Str new:))
			(for
				((= temp0 0))
				(and (< temp0 argc) (< (textList size:) 250))
				((++ temp0))
				
				(temp3 copy: [theText temp0])
				(textList
					add:
						((SelectorDText new:)
							font: font
							text: (KString 8 (temp3 data:)) ; StrDup
							setSize: (- width 4)
							yourself:
						)
				)
			)
			(temp3 dispose:)
			(if (not length)
				(= length argc)
			)
			(if listPlane
				(listPlane addCast: textList)
				(textList eachElementDo: #init textList)
			)
		)
	)

	(method (getText)
		(KString 8 ((textList at: current) text:)) ; StrDup
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
				(Text 0 (r data:) (obj text:) font 0)
				(= widest (Max (r at: 2) widest))
			)
		)
		(Text 0 (r data:) {M} font 0)
		(= textHeight (+ (r at: 3) 2))
		(r dispose:)
		(= nsTop (= nsLeft 0))
		(= nsRight (Max width widest))
		(= nsBottom (- (* textHeight length) 4))
	)

	(method (updatePlane &tmp c l h)
		(listPlane posn: (listPlane left:) (listPlane top:) plane)
		(UpdatePlane listPlane)
		(= c
			(-
				(+
					(/ (- (listPlane bottom:) (listPlane top:)) 2)
					(listPlane top:)
				)
				(plane top:)
			)
		)
		(= l (+ (- (listPlane right:) (plane left:)) 4))
		(= h (CelHigh (upButton view:) (upButton loop:) (upButton cel:)))
		(upButton moveTo: 160 23)
		(UpdateScreenItem upButton)
		(downButton moveTo: 160 84)
		(UpdateScreenItem downButton)
	)

	(method (handleEvent event &tmp ret)
		(if (== (event type:) evMOUSEBUTTON)
			(event globalize:)
			(if (listPlane onMe: event)
				(event localize: listPlane)
				(if (= ret (textList firstTrue: #onMe event))
					(= current (textList indexOf: ret))
					(self draw:)
				)
			)
			(event localize: plane)
		)
		(if (event claimed:)
			(return self)
		)
	)
)

(class SelectorDText of DText
	(properties)

	(method (setSize w)
		(super setSize: w)
		(= textRight (- (= nsRight w) (- textLeft nsLeft)))
	)
)

