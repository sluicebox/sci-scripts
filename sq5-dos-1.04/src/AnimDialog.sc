;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use Talker)
(use RandCycle)
(use System)

(class AnimDialog of Dialog
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp2 0)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= eatTheMice gEatMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= temp1 0)
		(while (not temp1)
			(cond
				((IsObject gFastCast)
					(gFastCast eachElementDo: #doit)
				)
				((IsObject gTheDoits)
					(gTheDoits eachElementDo: #doit)
				)
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self eachElementDo: #cycle)
			(= temp0 ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (temp0 type:) 1)
					(temp0 type: 0)
				)
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(self eachElementDo: #perform checkHiliteCode self temp0)
			(= temp1 (self handleEvent: temp0))
			(temp0 dispose:)
			(if (self check:)
				(break)
			)
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(return temp1)
	)
)

(instance checkHiliteCode of Code
	(properties)

	(method (doit param1 param2 param3)
		(if
			(and
				(& (param1 state:) $0001)
				(param1 check: param3)
				(not (& (param1 state:) $0008))
			)
			((param2 theItem:) select: 0)
			(param2 theItem: param1)
			(param1 select: 1)
		)
	)
)

(class ChoiceNarrator of Narrator
	(properties
		back 5
		whichSelect 0
		normal 0
		curNoun 0
		curVerb 0
		curCase 0
	)

	(method (display param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if normal
			(super display: param1 &rest)
		else
			(if (> (+ x talkWidth) 318)
				(= temp0 (- 318 x))
			else
				(= temp0 talkWidth)
			)
			((= temp1 (gSystemWindow new:)) color: color back: back)
			(if (and (not (HaveMouse)) (!= gTheCursor 996))
				(= saveCursor gTheCursor)
				(gGame setCursor: 996)
			else
				(= saveCursor 0)
			)
			(if showTitle
				(Print addTitle: name)
			)
			((= temp6 (Print new:))
				dialog: (AnimDialog new:)
				window: temp1
				posn: x y
				font: font
				width: temp0
				addText: param1
				modeless: 0
			)
			(if (not normal)
				(= temp2 (NodeValue ((temp6 dialog:) last:)))
				(= temp3 (+ (- (temp2 nsBottom:) (temp2 nsTop:)) 4 y))
				(for
					((= temp4 2))
					(= temp5 (Message msgSIZE modNum curNoun curVerb curCase temp4))
					((++ temp4))
					
					(temp6
						addColorButton:
							(- temp4 1)
							curNoun
							curVerb
							curCase
							temp4
							x
							temp3
							modNum
					)
					(= temp2 (NodeValue ((temp6 dialog:) last:)))
					(+= temp3 (+ (- (temp2 nsBottom:) (temp2 nsTop:)) 4))
				)
				(= whichSelect (temp6 init:))
				(self dispose: 1)
			else
				(temp6 init:)
			)
		)
	)
)

(class ChoiceTalker of Talker
	(properties
		back 5
		verb 0
		case 0
		whichSelect 0
		normal 0
		curNoun 0
		curVerb 0
		curCase 0
	)

	(method (cycle param1 &tmp temp0 [temp1 100] temp101)
		(cond
			(normal
				(super cycle: param1 &rest)
			)
			((and param1 (param1 cycler:))
				(= temp101 (GetPort))
				(SetPort 0)
				(= temp0 (param1 cel:))
				((param1 cycler:) doit:)
				(if (!= temp0 (param1 cel:))
					(DrawCel
						(param1 view:)
						(param1 loop:)
						(param1 cel:)
						(+ (param1 nsLeft:) nsLeft)
						(+ (param1 nsTop:) nsTop)
						-1
					)
					(param1
						nsRight:
							(+
								(param1 nsLeft:)
								(CelWide
									(param1 view:)
									(param1 loop:)
									(param1 cel:)
								)
							)
					)
					(param1
						nsBottom:
							(+
								(param1 nsTop:)
								(CelHigh
									(param1 view:)
									(param1 loop:)
									(param1 cel:)
								)
							)
					)
					(Graph
						grUPDATE_BOX
						(+ (param1 nsTop:) nsTop)
						(+ (param1 nsLeft:) nsLeft)
						(+ (param1 nsBottom:) nsTop)
						(+ (param1 nsRight:) nsLeft)
						1
					)
				)
				(SetPort temp101)
			)
		)
	)

	(method (show &tmp temp0 temp1)
		(if normal
			(super show: &rest)
		else
			(= temp1 (GetPort))
			(SetPort 0)
			(if (not underBits)
				(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
			)
			(= temp0 (PicNotValid))
			(PicNotValid 1)
			(if bust
				(DrawCel
					(bust view:)
					(bust loop:)
					(bust cel:)
					(+ (bust nsLeft:) nsLeft)
					(+ (bust nsTop:) nsTop)
					-1
				)
			)
			(if eyes
				(DrawCel
					(eyes view:)
					(eyes loop:)
					(eyes cel:)
					(+ (eyes nsLeft:) nsLeft)
					(+ (eyes nsTop:) nsTop)
					-1
				)
			)
			(if mouth
				(DrawCel
					(mouth view:)
					(mouth loop:)
					(mouth cel:)
					(+ (mouth nsLeft:) nsLeft)
					(+ (mouth nsTop:) nsTop)
					-1
				)
			)
			(DrawCel view loop cel nsLeft nsTop -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(SetPort temp1)
			(PicNotValid temp0)
		)
	)

	(method (startText param1 &tmp temp0)
		(if normal
			(super startText: param1 &rest)
		else
			(if (not viewInPrint)
				(self show:)
			)
			(if (not (& gMsgType $0002))
				(= ticks (Max 240 (* 8 (= temp0 (StrLen param1)))))
			)
			(if mouth
				(mouth setCycle: RandCycle (* 4 temp0) 0 1)
			)
			(if (and eyes (not (eyes cycler:)))
				(eyes setCycle: Blink blinkSpeed)
			)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(self display: param1)
			(return temp0)
		)
	)

	(method (say param1 param2)
		(if normal
			(super say: param1 param2 &rest)
		else
			(if (and (> view 0) (not underBits))
				(self init:)
			)
			(if gTheIconBar
				(gTheIconBar disable:)
			)
			(if (not initialized)
				(self init:)
			)
			(= caller (if (and (> argc 1) param2) param2 else 0))
			(if (IsObject gFastCast)
				(gFastCast add: self)
			else
				((= gFastCast (EventHandler new:)) name: {fastCast} add: self)
			)
			(if (& gMsgType $0002)
				(self startAudio:)
			)
			(if (& gMsgType $0001)
				(self startText: param1)
			)
			(+= ticks (+ 60 gGameTime))
			(return 1)
		)
	)

	(method (display param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if normal
			(super display: param1 &rest)
		else
			((= temp3 (gSystemWindow new:)) color: color back: back)
			(if (and (not (HaveMouse)) (!= gTheCursor 996))
				(= saveCursor gTheCursor)
				(gGame setCursor: 996)
			else
				(= saveCursor 0)
			)
			(= temp8 (Print new:))
			(if viewInPrint
				(= temp0
					(if useFrame
						loop
					else
						(bust loop:)
					)
				)
				(if showTitle
					(temp8 addTitle: name)
				)
				(temp8
					window: temp3
					dialog: (AnimDialog new:)
					posn: x y
					modeless: 0
					font: font
					addIcon: view temp0 cel 0 0
					addText: param1 (+ x textX)
					width: temp1 ; UNINIT
				)
			else
				(if (not (+ textX textY))
					(= textX (+ (- nsRight nsLeft) 5))
				)
				(if (> (+ (= temp2 (+ nsLeft textX)) talkWidth) 318)
					(= temp1 (- 318 temp2))
				else
					(= temp1 talkWidth)
				)
				(if showTitle
					(temp8 addTitle: name)
				)
				(temp8
					window: temp3
					dialog: (AnimDialog new:)
					posn: (+ x textX) (+ y textY)
					modeless: 0
					font: font
					addText: param1 4
					width: temp1
				)
			)
			(if (not normal)
				(= temp4 (NodeValue ((temp8 dialog:) last:)))
				(= temp5 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 4))
				(for
					((= temp6 2))
					(= temp7 (Message msgSIZE modNum curNoun curVerb curCase temp6))
					((++ temp6))
					
					(temp8
						addColorButton:
							(- temp6 1)
							curNoun
							curVerb
							curCase
							temp6
							4
							temp5
							modNum
					)
					(= temp4 (NodeValue ((temp8 dialog:) last:)))
					(+= temp5 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 4))
				)
				(= whichSelect (temp8 init:))
				(self dispose: 1)
			else
				(temp8 width: temp1 init:)
			)
		)
	)
)

