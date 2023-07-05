;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64940)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use Print)
(use Feature)
(use Actor)
(use System)

(class PanelPlane of Plane
	(properties
		picture -2
		disposeNotOnMe 1
		doitList 0
		eventList 0
		panelEvent 0
		allowArrows 0
	)

	(method (showTmpInv)
		(if argc
			(pvTmpInv dispose:)
		else
			(pvTmpInv x: (global108 x:) y: (global108 y:) init: (ScriptID 9 1)) ; PlInterface
		)
	)

	(method (removePanels param1 &tmp temp0)
		(if param1
			(PrintDebug {Hide Panels})
			(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
				(if (!= (gPanels at: temp0) (ScriptID 9 1)) ; PlInterface
					((gPanels at: temp0) hide:)
				)
			)
		else
			(PrintDebug {Show Panels})
			(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
				(if
					(not
						(OneOf
							(gPanels at: temp0)
							(ScriptID 9 1) ; PlInterface
							(ScriptID 9 3) ; PlCompass
						)
					)
					((gPanels at: temp0) show:)
				)
			)
			(cond
				((gPanels contains: (ScriptID 9 4)) ; InvInset
					((ScriptID 9 4) show:) ; InvInset
				)
				((gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(if (casts isEmpty:)
			(self addCast: (Cast new:))
		)
		(if (not doitList)
			(= doitList (Set new:))
		)
		(if (not eventList)
			(= eventList (Set new:))
		)
		(if (not gPanels)
			(= gPanels (Set new:))
		)
		(gPanels addToFront: self)
	)

	(method (dispose)
		(gPanels delete: self)
		(casts delete: doitList eventList)
		(doitList dispose:)
		(if (!= doitList eventList)
			(eventList dispose:)
		)
		(= doitList (= eventList 0))
		(super dispose: &rest)
	)

	(method (addToDoits param1 param2)
		(if (not doitList)
			(= doitList (Set new:))
		)
		(if (or (< argc 2) param2)
			(doitList add: param1)
			(param1 plane: self)
		else
			(doitList delete: param1)
		)
	)

	(method (hide)
		(= priority -1)
		(UpdatePlane self)
	)

	(method (show)
		(= priority (+ (GetHighPlanePri) 1))
		(UpdatePlane self)
	)

	(method (addToEvents param1 param2)
		(if (not eventList)
			(= eventList (Set new:))
		)
		(if (or (< argc 2) param2)
			(eventList addToFront: param1)
			(param1 plane: self)
		else
			(eventList delete: param1)
		)
	)

	(method (doit)
		(doitList doit: &rest)
	)

	(method (posn)
		(super posn: &rest)
		(UpdatePlane self)
	)

	(method (cue))

	(method (handleEvent event &tmp temp0 [temp1 5] temp6 temp7)
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(if (self onMe: event)
			(event localize: self)
			(= temp6 (event type:))
			(event type: (|= temp6 evVERB))
			(= temp7 global108)
			(cond
				((and (!= self (ScriptID 9 2)) (!= self (ScriptID 9 1)))) ; PlBagPlane, PlInterface
				(
					(and
						gPanels
						gInventory
						(= global108 (gInventory firstTrue: #onMe event))
					)
					(if (!= global108 temp7)
						(cond
							((not temp7))
							((gInventory disabled:))
							((< (temp7 view:) 3000)
								(temp7 view: (+ (temp7 view:) 1000))
							)
							(
								(or
									(gPanels contains: (ScriptID 9 4)) ; InvInset
									(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
									(gPanels contains: (ScriptID 19 1)) ; BombInset
								)
								(self showTmpInv: 0)
							)
						)
						(cond
							(
								(or
									(gPanels contains: (ScriptID 9 4)) ; InvInset
									(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
									(gPanels contains: (ScriptID 19 1)) ; BombInset
								)
								(self showTmpInv:)
							)
							((gInventory disabled:))
							((>= (global108 view:) 3000)
								(global108 view: (- (global108 view:) 1000))
							)
						)
					)
				)
				(else
					(if temp7
						(cond
							((not temp7))
							((gInventory disabled:))
							((< (temp7 view:) 3000)
								(temp7 view: (+ (temp7 view:) 1000))
							)
							(
								(or
									(gPanels contains: (ScriptID 9 4)) ; InvInset
									(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
									(gPanels contains: (ScriptID 19 1)) ; BombInset
								)
								(self showTmpInv: 0)
							)
						)
					)
					(= global108 0)
				)
			)
			(= temp0 (eventList firstTrue: #handleEvent event &rest))
			(event claimed: 1)
			(= temp0 1)
		)
		(return (or temp0 (event claimed:)))
	)
)

(class InsetPanelPlane of PanelPlane
	(properties
		disposeNotOnMe 0
		normalizeTheCursor 0
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(cond
			((gPanels contains: (ScriptID 9 2)) ; PlBagPlane
				(event claimed: 1)
				(return)
			)
			(((ScriptID 9 1) onMe: event) ; PlInterface
				(event claimed: 0)
				(return)
			)
			((and (& (event type:) evMOUSEBUTTON) (not (self onMe: event)))
				(event claimed: 1)
				(self dispose:)
			)
			((not (self onMe: event))
				(if (and (== normalizeTheCursor 1) (!= gTheCursor gNormalCursor))
					(gGame normalizeCursor:)
				)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(= gInsetPanelPlane self)
		(super init: 0 0 200 200)
	)

	(method (dispose)
		(= gInsetPanelPlane 0)
		(super dispose: &rest)
	)
)

(class PanelFeature of Feature
	(properties)

	(method (init param1)
		(gFeatures add: self)
		(((param1 casts:) at: 0) add: self)
		(= plane param1)
		(plane addToEvents: self)
		(if (not approachX)
			((= approachX (Hiliter new:)) client: self insetMember: 1)
			(if (not global105)
				(= global105 (Set new:))
			)
			(global105 add: approachX)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(gUser canInput:)
				)
				(= temp0 (event claimed: 1))
				(self doVerb: (gUser curVerb:))
			)
		)
		(return temp0)
	)

	(method (dispose param1 param2 param3)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self 0)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self 0)
		)
		(if (plane eventList:)
			((plane eventList:) delete: self)
		)
		(super dispose: &rest)
	)
)

(class PanelView of View
	(properties)

	(method (init param1 param2 param3)
		(&= signal $fff7)
		(((param1 casts:) at: 0) add: self)
		(= plane param1)
		(AddScreenItem self)
		(= useInsetRect 0)
		(SetNowSeen self)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self)
		)
		(if (not approachX)
			((= approachX (Hiliter new:)) client: self insetMember: 1)
			(if (not global105)
				(= global105 (Set new:))
			)
			(global105 add: approachX)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(self isNotHidden:)
					(gUser canInput:)
				)
				(= temp0 (event claimed: 1))
				(self doVerb: (gUser curVerb:))
			)
		)
		(return temp0)
	)

	(method (dispose param1 param2 param3)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self 0)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self 0)
		)
		(super dispose: &rest)
	)
)

(class PanelProp of Prop
	(properties)

	(method (init param1 param2 param3)
		(&= signal $fff7)
		(((param1 casts:) at: 0) add: self)
		(= plane param1)
		(AddScreenItem self)
		(= useInsetRect 0)
		(SetNowSeen self)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self)
		)
		(if (not approachX)
			((= approachX (Hiliter new:)) client: self insetMember: 1)
			(if (not global105)
				(= global105 (Set new:))
			)
			(global105 add: approachX)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(self isNotHidden:)
					(gUser canInput:)
				)
				(= temp0 (event claimed: 1))
				(self doVerb: (gUser curVerb:))
			)
		)
		(return temp0)
	)

	(method (dispose param1 param2 param3)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self 0)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self 0)
		)
		(super dispose: &rest)
	)
)

(class PanelInv of PanelProp
	(properties
		myVerb 0
	)

	(method (init)
		(super init: &rest)
		(global105 delete: approachX)
		(approachX dispose:)
		(= approachX 0)
	)

	(method (handleEvent event)
		(if (or (gInventory disabled:) gPplFullLetterPlane)
			((ScriptID 9 91) handleEvent: event &rest) ; ppOptions
			(event claimed: 0)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb &tmp [temp0 2] temp2)
		(switch theVerb
			(5 ; Do
				(self setCursor:)
			)
			(39) ; ???
			(24) ; ???
			(else
				(if (!= (gUser curVerb:) myVerb)
					(placeHolder x: x y: y)
					(= x (global110 x:))
					(= y (global110 y:))
					(global110 x: (placeHolder x:))
					(global110 y: (placeHolder y:))
					(gInventory addAfter: self placeHolder)
					(gInventory delete: self)
					(gInventory addAfter: global110 self)
					(gInventory delete: global110)
					(gInventory addAfter: placeHolder global110)
					(gInventory delete: placeHolder)
					(if (not (gPanels contains: (ScriptID 9 2))) ; PlBagPlane
						(for
							((= temp2 0))
							(< temp2 (gInventory size:))
							((++ temp2))
							
							((gInventory at: temp2) dispose: (ScriptID 9 1) 1 1) ; PlInterface
						)
						(gInventory draw:)
					)
					(if (== global110 (ScriptID 9 5)) ; invLighter
						((ScriptID 9 5) state: 0 cel: 0) ; invLighter
					)
				)
				(self setCursor: 5)
			)
		)
	)

	(method (setCursor param1)
		(if argc
			(gUser curVerb: param1)
			(if (!= param1 5)
				(= global110 self)
			else
				(= global110 0)
			)
			(gNormalCursor view: 999 loop: 0 cel: 0)
		else
			(gUser curVerb: myVerb)
			(= global110 self)
			(if
				(or
					(gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
					(gPanels contains: (ScriptID 9 4)) ; InvInset
					(gPanels contains: (ScriptID 19 1)) ; BombInset
				)
				(if (>= (global108 view:) 3000)
					(gNormalCursor view: (- view 1000))
				else
					(gNormalCursor view: view)
				)
			else
				(if (>= (global108 view:) 3000)
					(global108 view: (- (global108 view:) 1000))
					((ScriptID 9 1) showTmpInv: 0) ; PlInterface
				)
				(gNormalCursor view: view)
			)
			(gNormalCursor loop: 1 cel: (global110 state:))
		)
		(gGame setCursor: gNormalCursor 1)
	)
)

(instance placeHolder of Feature
	(properties)
)

(class PanelText of PanelView
	(properties
		back 0
		text 0
		height -1
		font 1
		fore 255
		mode 0
		skip 0
		width -1
		textBottom -1
		textLeft -1
		textRight -1
		textTop -1
	)

	(method (init)
		(if (or (== -1 width) (== -1 height))
			(Printf {Error -- %s width/height not set} name)
			(= width (= height 0))
		)
		(self setText:)
		(self setBitmap:)
		(super init: &rest)
	)

	(method (dispose &tmp temp0)
		(= temp0 bitmap)
		(= bitmap 0)
		(if text
			(KArray 4 text) ; ArrayFree
			(= text 0)
		)
		(super dispose: &rest)
		(if temp0
			(Bitmap 1 temp0) ; Dispose
		)
	)

	(method (newText)
		(self setText: &rest)
		(self setBitmap: 1)
	)

	(method (setBitmap param1)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(= bitmap (Bitmap 0 width height skip back)) ; Create
		(if text
			(Bitmap
				4 ; AddText
				bitmap
				text
				textLeft
				textTop
				textRight
				textBottom
				fore
				back
				skip
				font
				0
				-1
				0
			)
		)
		(if (and argc param1)
			(UpdateScreenItem self)
		)
	)

	(method (setSize param1 param2)
		(= width param1)
		(= height param2)
	)

	(method (setText param1 param2 param3 param4 param5 &tmp temp0)
		(if argc
			(if text
				(KArray 4 text) ; ArrayFree
			)
			(if (== argc 1)
				(if (= text param1)
					(= temp0 (Str with: text))
					(= text (temp0 data:))
					(temp0 data: 0 dispose:)
				)
			else
				(= temp0 (Str new:))
				(Message
					msgGET
					param1
					param2
					param3
					(if (> argc 3) param4 else 0)
					(if (> argc 4) param5 else 1)
					(temp0 data:)
				)
				(= text (temp0 data:))
				(temp0 data: 0 dispose:)
			)
		else
			(if (== -1 textLeft)
				(= textLeft 0)
			)
			(if (== -1 textTop)
				(= textTop 0)
			)
			(if (== -1 textRight)
				(= textRight (- width 1))
			)
			(if (== -1 textBottom)
				(= textBottom (- height 1))
			)
		)
	)
)

(class PanelButton of PanelView
	(properties
		active 0
		relVerify 1
		highlit 0
		helpTime 0
	)

	(method (init)
		(super init: &rest)
		(= active 1)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= temp0 (self onMe: gMouseX gMouseY))
		(if (and active temp0)
			(self checkHelp:)
		)
		(cond
			(highlit
				(if (not temp0)
					(self highlight: 0)
				)
			)
			(temp0
				(self highlight: 1)
			)
		)
	)

	(method (highlight)
		(return 0)
	)

	(method (mask param1)
		(if (and argc (not param1))
			(= active 1)
		else
			(= active 0)
		)
		(return active)
	)

	(method (waitMouseUp &tmp temp0 temp1 temp2)
		(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
			(temp0 dispose:)
		)
		(temp0 localize: plane)
		(= temp1 (temp0 x:))
		(= temp2 (temp0 y:))
		(temp0 dispose:)
		(self onMe: temp1 temp2)
	)

	(method (checkHelp)
		(return 0)
	)

	(method (doHelp))

	(method (handleEvent event)
		(if (and active (self onMe: (event x:) (event y:)))
			(event claimed: 1)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					(or (not relVerify) (self waitMouseUp:))
					(gUser canInput:)
				)
				(self doVerb: (gUser curVerb:))
			)
		)
		(event claimed:)
	)
)

(class CurrInvItem of PanelButton
	(properties
		verb -1
		itemNumber -1
	)

	(method (update)
		(UpdateScreenItem self)
	)

	(method (select param1 &tmp temp0 temp1)
		(if argc
			(if (and (!= itemNumber -1) (!= itemNumber param1))
				((gInventory at: itemNumber) curItem: 0)
			)
			(= itemNumber param1)
			((= temp0 (gInventory at: itemNumber)) curItem: 1)
			(= verb (temp0 message:))
		else
			(= itemNumber -1)
			(= temp0 0)
			(= verb -1)
		)
		(gUser curVerb: verb)
		(gUser curInvNum: itemNumber)
		(if (= temp1 (gUser hotCursor:))
			(temp1 update:)
		)
		(self update: temp0)
	)
)

(instance pvTmpInv of PanelView
	(properties
		priority 200
		loop 2
		view 1200
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(global105 delete: approachX)
		(approachX dispose:)
		(= approachX 0)
	)
)

