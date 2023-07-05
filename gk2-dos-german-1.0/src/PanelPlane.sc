;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64940)
(include sci.sh)
(use Main)
(use Plane)
(use Str)
(use Print)
(use Actor)
(use System)

(class PanelPlane of Plane
	(properties
		doitList 0
		eventList 0
		oldPri 0
		iUseNulls 0
	)

	(method (init)
		(super init: &rest)
		(if (casts isEmpty:)
			(self addCast: (Cast new:))
		)
		(if (not doitList)
			(= doitList (List new:))
		)
		(if (not eventList)
			(= eventList (List new:))
		)
		(if (not gPanels)
			(= gPanels (List new:))
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
			(= doitList (List new:))
		)
		(if (or (< argc 2) param2)
			(doitList add: param1)
			(param1 plane: self)
		else
			(doitList delete: param1)
		)
	)

	(method (addToEvents param1 param2)
		(if (not eventList)
			(= eventList (List new:))
		)
		(if (or (< argc 2) param2)
			(eventList add: param1)
			(param1 plane: self)
		else
			(eventList delete: param1)
		)
	)

	(method (show)
		(self priority: oldPri)
		(UpdatePlane self)
	)

	(method (hide)
		(= oldPri (self priority:))
		(self priority: -1)
		(UpdatePlane self)
	)

	(method (doit)
		(doitList doit: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(if
			(or
				(and iUseNulls (self onMe: event))
				(and (== (event type:) evMOUSEBUTTON) (self onMe: event))
			)
			(event localize: self)
			(= temp0 (eventList firstTrue: #handleEvent event &rest))
		)
		(return (or temp0 (event claimed:)))
	)
)

(class PanelView of View
	(properties)

	(method (init param1 param2 param3)
		(&= signal $fff7)
		(((param1 casts:) at: 0) add: self)
		(= plane param1)
		(AddScreenItem self)
		(|= -info- $0010)
		(= useInsetRect 0)
		(SetNowSeen self)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self)
		)
	)

	(method (handleEvent)
		(return 0)
	)
)

(class PanelText of PanelView
	(properties
		text 0
		fore 255
		back 0
		skip 0
		font 1
		mode 0
		width -1
		height -1
		textLeft -1
		textTop -1
		textRight -1
		textBottom -1
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
			(KString 4 text) ; StrFree
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
				(KString 4 text) ; StrFree
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
				)
				(self doVerb: (gUser curVerb:))
			)
		)
		(event claimed:)
	)
)

(class CurrInvItem of PanelButton
	(properties
		itemNumber -1
		verb -1
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

