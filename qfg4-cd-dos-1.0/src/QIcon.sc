;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use DText)
(use Plane)
(use Str)
(use Array)
(use IconBar)
(use Actor)
(use System)

(public
	proc91_0 0
)

(local
	local0
	local1
)

(procedure (proc91_0 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
	(= local0 (gTheCursor view:))
	(= temp1 (gTheCursor loop:))
	(= temp2 (gTheCursor cel:))
	(gGlory
		setCursor: ((gTheIconBar getCursor:) view: 999 loop: 0 cel: 0 yourself:)
	)
	(QControls init: param1 param2 param3 param4 param5 show: dispose:)
	(gGlory
		setCursor:
			((gTheIconBar getCursor:)
				view: local0
				loop: temp1
				cel: temp2
				yourself:
			)
	)
	(QControls state: (& (QControls state:) $ffdf))
	(FrameOut)
	(return local1)
)

(class QIcon of IconI
	(properties
		nsTop 15
		view 935
		loop 5
		signal 257
		highlightColor 255
		text 0
		value 0
		text1 0
		text2 0
		hiText 0
	)

	(method (dispose)
		(text dispose:)
		(DeleteScreenItem self)
		(= hiText (= text2 (= text1 (= text 0))))
		(DisposeClone self)
	)

	(method (init &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(&= signal $fff7)
		((QControls qCast:) add: self)
		(= plane qPlane)
		(AddScreenItem self)
	)

	(method (onMe param1)
		(return
			(and (< nsLeft (param1 x:) nsRight) (< nsTop (param1 y:) nsBottom))
		)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(if
			(if (and argc param1 (& signal $0001))
				(= cel (= temp1 1))
				(UpdateScreenItem self)
				(FrameOut)
				(while (!= ((= temp0 ((gUser curEvent:) new:)) type:) 2)
					(temp0 localize: qPlane)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= cel (= temp1 1))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp1
							(= cel (= temp1 0))
							(UpdateScreenItem self)
							(FrameOut)
						)
					)
				)
				(if (== temp1 1)
					(= cel 0)
					(UpdateScreenItem self)
					(FrameOut)
				)
				temp1
			else
				1
			)
			(QControls state: (& (QControls state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (text data:) 300 0)
		(= nsRight (+ nsLeft (temp1 at: 2) 24))
		(= nsBottom (+ nsTop (temp1 at: 3) 10))
		(= x (+ nsLeft 17))
		(= y (+ nsTop 15))
		(= cel 0)
		(UpdateScreenItem self)
		(if (not text1)
			(= text1
				((myDText new:)
					posn: (+ nsLeft 27) (+ nsTop 9)
					text: (text data:)
					font: 300
					fore: 92
					back: 254
					skip: 254
					setSize:
					setPri: 253
					init: (QControls qCast:)
					yourself:
				)
			)
		)
		(if (not text2)
			(= text2
				((myDText new:)
					posn: (+ nsLeft 26) (+ nsTop 8)
					text: (text data:)
					font: 300
					fore: 86
					back: 254
					skip: 254
					setSize:
					setPri: 254
					init: (QControls qCast:)
					yourself:
				)
			)
		)
		(if (not hiText)
			(= hiText
				((myDText new:)
					posn: (+ nsLeft 26) (+ nsTop 8)
					text: (text data:)
					font: 300
					fore: 86
					back: 254
					skip: 254
					setSize:
					setPri: 0
					init: (QControls qCast:)
					yourself:
				)
			)
		)
		(temp1 dispose:)
	)

	(method (highlight param1)
		(text2 setPri: 0)
		(hiText setPri: 254)
		(= cel (if param1 2 else 0))
		(UpdateScreenItem self)
		(UpdateScreenItem text2)
		(UpdateScreenItem hiText)
		(FrameOut)
	)
)

(class QControls of IconBar
	(properties
		state 0
		qCast 0
	)

	(method (select param1 param2)
		(return
			(if (param1 select: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				1
			)
		)
	)

	(method (advanceCurIcon))

	(method (swapCurIcon))

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(= qCast (Cast new:))
		(qCast add:)
		(= plane qPlane)
		(qPlane
			priority: (+ (GetHighPlanePri) 1)
			picture: -2
			init: 60 60 260 140 60 60 260 140
			setBitmap: 935 0 0 1
			addCast: qCast
		)
		(qIconPrompt text: (Str new:))
		(Message
			msgGET
			param1
			param2
			param3
			param4
			param5
			((qIconPrompt text:) data:)
		)
		(self add: qIconPrompt)
		(qIconYes text: (Str new:))
		(Message msgGET 0 0 0 14 1 ((qIconYes text:) data:)) ; "Yes"
		(self add: qIconYes)
		(qIconNo text: (Str new:))
		(Message msgGET 0 0 0 15 1 ((qIconNo text:) data:)) ; "No"
		(self add: qIconNo)
		(self eachElementDo: #init self)
		(= temp1 (gTheIconBar getCursor:))
		(temp1 view: 999 loop: 0 cel: 0)
		(gGlory setCursor: temp1)
	)

	(method (dispatchEvent event &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp6 (temp4 signal:))
			(= temp7 (== temp4 helpIconItem))
		)
		(switch temp2
			(evNULL
				(if temp4
					(if (!= temp4 highlightedIcon)
						(= oldMouseY 0)
						(self highlight: temp4)
					)
				else
					(self highlight: 0)
				)
			)
			(evMOUSEBUTTON
				(if (and temp4 (self select: temp4 1))
					(= temp5 (& temp6 $0040))
				)
			)
		)
		(return temp5)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds pause:)
		(|= state $0020)
		(plane addCast: qCast)
		(UpdatePlane plane)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 nextNode))
			(= nextNode (NextNode temp2))
			(if (not (= temp3 (NodeValue temp2)))
				(return)
			)
			(if (and (not (& (temp3 signal:) $0080)) (<= (temp3 nsRight:) 0))
				(temp3 show: temp0 temp1)
				(= temp0 (+ 20 (temp3 nsRight:)))
			else
				(temp3 show:)
			)
		)
		(self doit: hide:)
		(= highlightedIcon (= curIcon 0))
	)

	(method (highlight param1 param2)
		(if highlightedIcon
			(highlightedIcon highlight: 0)
		)
		(cond
			((not (= highlightedIcon param1)) 0)
			((& (param1 signal:) $0004)
				(= highlightedIcon 0)
			)
			(else
				(param1 highlight: 1)
				(if (and (>= argc 2) param2)
					(gGlory
						setCursor:
							gTheCursor
							1
							(+
								(param1 nsLeft:)
								(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
							)
							(- (param1 nsBottom:) 3)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(temp0 localize: plane)
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (dispose)
		(plane deleteCast: self dispose:)
		(= plane 0)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(DisposeClone self)
	)
)

(instance qPlane of Plane
	(properties)

	(method (setBitmap param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (Cast new:))
		(self addCast: temp0)
		((= temp7 (View new:))
			view: param1
			loop: param2
			cel: param3
			posn: 0 0
			init: temp0
		)
		(= temp2 (CelWide param1 param2 param3))
		(= temp4 (CelHigh param1 param2 param3))
		(= temp1 (+ (- right left) 1))
		(= temp3 (+ (- bottom top) 1))
		(= temp5 (/ (* temp1 128) temp2))
		(= temp6 (/ (* temp3 128) temp4))
		(temp7 scaleSignal: 1 scaleX: temp5 scaleY: temp6)
		(UpdateScreenItem temp7)
	)
)

(instance qIconPrompt of QIcon
	(properties
		nsLeft 15
		nsTop 0
		x 8
		priority 255
	)

	(method (init)
		((QControls qCast:) add: self)
		(= plane qPlane)
	)

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (text data:) 300 0)
		(= nsRight (+ nsLeft (temp1 at: 2) 24))
		(= nsBottom (+ nsTop (temp1 at: 3) 10))
		(= x (+ nsLeft 17))
		(= y (+ nsTop 15))
		(= cel 0)
		(if (not text1)
			(= text1
				((myDText new:)
					posn: (+ nsLeft 1) (+ nsTop 9)
					text: (text data:)
					font: 300
					fore: 92
					back: 254
					skip: 254
					setSize: 160
					setPri: 254
					init: (QControls qCast:)
					yourself:
				)
			)
		)
		(if (not text2)
			(= text2
				((myDText new:)
					posn: nsLeft (+ nsTop 8)
					text: (text data:)
					font: 300
					fore: 86
					back: 254
					skip: 254
					setSize: 160
					setPri: 255
					init: (QControls qCast:)
					yourself:
				)
			)
		)
		(temp1 dispose:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance qIconYes of QIcon
	(properties
		nsLeft 5
		nsTop 40
		nsRight 50
		nsBottom 50
		x 5
		y 50
		priority 55
	)

	(method (select)
		(= local1 1)
		(QControls state: (& (QControls state:) $ffdf))
	)
)

(instance qIconNo of QIcon
	(properties
		nsLeft 80
		nsTop 40
		nsRight 100
		nsBottom 50
		x 80
		y 50
		priority 55
	)

	(method (select)
		(= local1 0)
		(QControls state: (& (QControls state:) $ffdf))
	)
)

(instance myDText of DText
	(properties)

	(method (dispose &tmp temp0 temp1)
		(= temp1 0)
		(if bitmap
			(= temp1 bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
		)
	)
)

