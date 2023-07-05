;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use HRView)
(use Print)
(use IconBar)
(use Tutorial)
(use System)

(public
	GKIconbar 0
	curInvView 1
)

(local
	local0
)

(class GKIconItem of IconI
	(properties
		topIcon 0
		leftIcon 0
		bottomIcon 0
		rightIcon 0
	)

	(method (init)
		(if (and (< mainView 10000) (IsHiRes))
			(= view (+ 10000 view))
			(= mainView (+ 10000 mainView))
			(= maskView (+ 10000 maskView))
		)
		(super init: &rest)
	)

	(method (highlight param1 &tmp [temp0 5])
		(if (or (& signal $0004) (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= cel (if argc param1))
		(UpdateScreenItem self)
	)
)

(class GKIconbar of IconBar
	(properties
		blink 0
	)

	(method (init)
		(super init: &rest)
		(= local0 (Cast new:))
		(plane addCast: local0)
		(cLion1 init: local0)
		(cBar1 init: local0)
		(cBorder init: local0)
		(cBar2 init: local0)
		(cBar3 init: local0)
		(cBar4 init: local0)
		(cBar5 init: local0)
		(cBar6 init: local0)
		(cLion2 init: local0)
		(cLion1Eyes init: local0)
		(cLion2Eyes init: local0)
		(cScore init: local0)
		(cOne init: local0)
		(cTwo init: local0)
		(cThree init: local0)
		(cFour init: local0)
		(cFive init: local0 hide:)
		(cSix init: local0 hide:)
		(curInvView init: local0 hide:)
		(plane setSize:)
	)

	(method (shouldOpen param1)
		(return
			(or
				(and (== (param1 type:) 0) (<= (param1 y:) (plane bottom:)))
				(and
					(== (param1 type:) 4)
					(OneOf (param1 message:) 27 21248)
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if (and (= temp4 (gGame script:)) (temp4 isKindOf: Tutorial))
				(temp4 doit:)
			)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize: plane)
			(if
				(and
					(or (== temp1 1) (and (== temp1 4) (== temp2 13)))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(temp0 type: 24576 message: (helpIconItem message:))
			)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (disableIcon param1 &tmp temp0)
		(if argc
			(super disableIcon: param1 &rest)
			(if (gGame barUp:)
				(for ((= temp0 0)) (< temp0 size) ((++ temp0))
					(if (& ((self at: temp0) signal:) $0004)
						((self at: temp0) mask:)
					)
				)
			)
		else
			(super disableIcon:)
		)
	)

	(method (enableIcon param1 &tmp temp0)
		(if argc
			(super enableIcon: param1 &rest)
			(if (gGame barUp:)
				(for ((= temp0 0)) (< temp0 size) ((++ temp0))
					(if (& ((self at: temp0) signal:) $fffb)
						((self at: temp0) show:)
					)
				)
			)
		else
			(super enableIcon:)
		)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (= temp2 (= temp3 0)))
		(while (not ((= temp0 ((gUser curEvent:) new:)) type:))
			(temp0 localize: plane)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if temp3
							(temp3 dispose:)
							(= temp3 0)
							(FrameOut)
						)
						(if
							(and
								(& (temp2 signal:) $0004)
								(!= temp2 (self at: 13))
							)
							(= temp4 0)
							(= temp5 87)
							(= temp6 142)
						else
							(= temp4 (temp2 noun:))
							(= temp5 (temp2 helpVerb:))
							(= temp6 250)
						)
						(Print
							font: gUserFont
							width: temp6
							addText: temp4 temp5 0 1 0 0 0
							modeless: 2
							init:
						)
						(= temp3 (Print dialog:))
						(FrameOut)
					)
				)
				(temp3
					(temp3 dispose:)
					(= temp3 0)
					(FrameOut)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(gGame setCursor: gNormalCursor 1)
		(if temp3
			(temp3 dispose:)
			(FrameOut)
		)
	)

	(method (show)
		(if (Print dialog:)
			((Print dialog:) dispose:)
		)
		(super show: &rest)
		(cond
			(curInvIcon
				(self showInvItem:)
			)
			((curInvView isNotHidden:)
				(curInvView hide:)
			)
		)
		(self drawScore:)
		(FrameOut)
	)

	(method (highlight param1 param2 param3 &tmp temp0)
		(if (not (& (param1 signal:) $0004))
			(if highlightedIcon
				(highlightedIcon highlight: 0)
			)
			(= highlightedIcon param1)
			(if (not (and (>= argc 3) param3))
				(param1 highlight: 1)
				(if (& state $0020)
					(cLion1Eyes cel: (gTheIconBar blink:))
					(gTheIconBar blink: (not (gTheIconBar blink:)))
					(cLion2Eyes cel: (gTheIconBar blink:))
					(UpdateScreenItem cLion1Eyes)
					(UpdateScreenItem cLion2Eyes)
				)
			)
		)
		(if (and (>= argc 2) param2)
			(gGame
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

	(method (hide &tmp temp0 temp1)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 nextNode))
				(= nextNode (NextNode temp0))
				(= temp1 (NodeValue temp0))
				(temp1 signal: (& (temp1 signal:) $ffdf))
			)
			(if
				(and
					(not (& state $0800))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
			(cond
				((not (gGame keepBar:))
					(plane priority: -1)
				)
				(highlightedIcon
					(highlightedIcon setCel: 0)
					(UpdateScreenItem highlightedIcon)
				)
			)
			(UpdatePlane plane)
		)
		(FrameOut)
	)

	(method (draw &tmp [temp0 2])
		(plane priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
	)

	(method (erase)
		(plane priority: -1)
		(UpdatePlane plane)
	)

	(method (showInvItem param1 &tmp temp0 temp1 temp2)
		(if
			(or
				param1
				(and
					(gEgo has: (gInventory indexOf: curInvIcon))
					(not (gGame keepBar:))
				)
			)
			(= temp0
				(+
					(/
						(-
							(- (useIconItem nsRight:) (useIconItem nsLeft:))
							(CelWide
								(curInvIcon view:)
								(curInvIcon loop:)
								(curInvIcon cel:)
							)
						)
						2
					)
					(useIconItem nsLeft:)
				)
			)
			(= temp1
				(+
					y
					(/
						(-
							(- (useIconItem nsBottom:) (useIconItem nsTop:))
							(CelHigh
								(curInvIcon view:)
								(curInvIcon loop:)
								(curInvIcon cel:)
							)
						)
						2
					)
					(useIconItem nsTop:)
				)
			)
			(curInvView
				view: (curInvIcon mainView:)
				loop: (curInvIcon mainLoop:)
				cel: (curInvIcon mainCel:)
				x: temp0
				y: temp1
				show:
			)
			(UpdateScreenItem curInvView)
			(if (& (useIconItem signal:) $0004)
				(useIconItem mask:)
			)
		else
			(= curInvIcon 0)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(or (== (event message:) KEY_ESCAPE) (== (event message:) KEY_DELETE))
			)
			(event claimed: 1)
			(return 0)
		)
		(super handleEvent: event)
	)

	(method (dispatchEvent event)
		(if (& (event type:) $0010) ; direction
			(switch (event message:)
				(JOY_UP
					(self goUp:)
				)
				(JOY_DOWN
					(self goDown:)
				)
			)
		)
		(super dispatchEvent: event)
	)

	(method (goUp &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (not (= temp0 highlightedIcon))
			(= temp0 (self at: 11))
		)
		(= temp1 (temp0 topIcon:))
		(while (& (temp1 signal:) $0004)
			(++ temp2)
			(= temp1 (temp1 topIcon:))
			(if (> temp2 13)
				(= temp1 (self at: 5))
			)
		)
		(self checkNewIcon: temp1)
	)

	(method (goDown &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (not (= temp0 highlightedIcon))
			(= temp0 (self at: 11))
		)
		(= temp1 (temp0 bottomIcon:))
		(while (& (temp1 signal:) $0004)
			(++ temp2)
			(= temp1 (temp1 bottomIcon:))
			(if (> temp2 13)
				(= temp1 (self at: 5))
			)
		)
		(self checkNewIcon: temp1)
	)

	(method (advance &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (not (= temp0 highlightedIcon))
			(= temp0 (self at: 11))
		)
		(= temp1 (temp0 rightIcon:))
		(while (& (temp1 signal:) $0004)
			(++ temp2)
			(= temp1 (temp1 rightIcon:))
			(if (> temp2 13)
				(= temp1 (self at: 5))
			)
		)
		(self checkNewIcon: temp1)
	)

	(method (retreat &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (not (= temp0 highlightedIcon))
			(= temp0 (self at: 11))
		)
		(= temp1 (temp0 leftIcon:))
		(while (& (temp1 signal:) $0004)
			(++ temp2)
			(= temp1 (temp1 leftIcon:))
			(if (> temp2 13)
				(= temp1 (self at: 5))
			)
		)
		(self checkNewIcon: temp1)
	)

	(method (checkNewIcon param1)
		(if (and (== param1 (self at: 12)) (not (self curInvIcon:)))
			(= param1 (self at: 5))
		)
		(if (gGame barUp:)
			(= highlightedIcon param1)
		else
			(self highlight: param1 (& state $0020))
		)
	)

	(method (drawScore)
		(cond
			((< gScore 10)
				(cFour setLoop: 4 cel: gScore posn: 233 3 show:)
				(UpdateScreenItem cFour)
			)
			((< gScore 100)
				(cFour setLoop: 4 cel: (/ gScore 10) posn: 231 3 show:)
				(UpdateScreenItem cFour)
				(cFive setLoop: 4 cel: (mod gScore 10) posn: 237 3 show:)
				(UpdateScreenItem cFive)
			)
			(else
				(cFour setLoop: 4 cel: (/ gScore 100) posn: 227 3 show:)
				(UpdateScreenItem cFour)
				(cFive
					setLoop: 4
					cel: (/ (mod gScore 100) 10)
					posn: 233 3
					show:
				)
				(UpdateScreenItem cFive)
				(cSix setLoop: 4 cel: (mod gScore 10) posn: 239 3 show:)
				(UpdateScreenItem cSix)
			)
		)
	)

	(method (updateScore &tmp temp0)
		(self drawScore:)
	)
)

(instance cScore of HRView
	(properties
		x 224
		view 959
		loop 3
	)
)

(instance cOne of HRView
	(properties
		x 227
		y 20
		view 959
		loop 4
		cel 3
	)
)

(instance cTwo of HRView
	(properties
		x 233
		y 20
		view 959
		loop 4
		cel 4
	)
)

(instance cThree of HRView
	(properties
		x 239
		y 20
		view 959
		loop 4
		cel 2
	)
)

(instance cFour of HRView
	(properties
		x 233
		y 3
		view 959
		loop 4
	)
)

(instance cFive of HRView
	(properties
		view 959
		loop 4
	)
)

(instance cSix of HRView
	(properties
		view 959
		loop 4
	)
)

(instance cLion1 of HRView
	(properties
		view 959
		loop 1
		cel 2
	)
)

(instance cBar1 of HRView
	(properties
		x 37
		view 959
		loop 1
	)
)

(instance cBorder of HRView
	(properties
		x 43
		view 959
		loop 5
	)
)

(instance cBar2 of HRView
	(properties
		x 138
		view 959
		loop 1
	)
)

(instance cBar3 of HRView
	(properties
		x 167
		view 959
		loop 1
	)
)

(instance cBar4 of HRView
	(properties
		x 218
		view 959
		loop 1
	)
)

(instance cBar5 of HRView
	(properties
		x 248
		view 959
		loop 1
	)
)

(instance cBar6 of HRView
	(properties
		x 277
		view 959
		loop 1
	)
)

(instance cLion2 of HRView
	(properties
		x 283
		view 959
		loop 1
		cel 1
	)
)

(instance cLion1Eyes of HRView
	(properties
		x 8
		y 8
		view 959
		loop 8
	)
)

(instance cLion2Eyes of HRView
	(properties
		x 292
		y 8
		view 959
		loop 7
	)
)

(instance curInvView of HRView
	(properties
		view 959
		loop 7
	)
)

