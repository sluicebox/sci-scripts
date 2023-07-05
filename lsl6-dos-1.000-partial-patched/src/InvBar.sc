;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use System)

(public
	InvBar 0
)

(local
	local0
)

(instance aCursor of Cursor
	(properties)
)

(class BarInvI of Obj
	(properties
		cursorView -1
		cursorLoop 0
		cursorCel 0
		owner 0
		view 0
		loop 0
		cel 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		state 0
		script 0
		signal 0
		value 0
		highlightColor 0
		lowlightColor 0
		cursor 0
		type 16384
		message 0
		noun 0
		modNum -1
		isVisible 0
	)

	(method (cue))

	(method (select)
		(gGame
			setCursor:
				(aCursor
					view: cursorView
					loop: cursorLoop
					cel: cursorCel
					yourself:
				)
		)
		(= cursor aCursor)
		(return 1)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		)
	)

	(method (highlight param1 &tmp [temp0 4] temp4)
		(if (or (== highlightColor -1) (not isVisible))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(Graph grDRAW_LINE (+ nsTop 1) nsLeft (+ nsTop 1) nsRight temp4 -1 -1)
		(Graph grDRAW_LINE (+ nsTop 1) nsRight (- nsBottom 1) nsRight temp4 -1 -1)
		(Graph grDRAW_LINE (- nsBottom 1) nsRight (- nsBottom 1) nsLeft temp4 -1 -1)
		(Graph grDRAW_LINE (- nsBottom 1) nsLeft (+ nsTop 1) nsLeft temp4 -1 -1)
		(Graph grUPDATE_BOX (+ nsTop 1) nsLeft nsBottom (+ nsRight 1) 1)
	)

	(method (setCursor param1 param2 param3)
		(= cursorView param1)
		(= cursorLoop param2)
		(= cursorCel param3)
	)

	(method (show param1 param2 param3 param4)
		(if argc
			(= nsRight (- (+ (= nsLeft param1) param3) 1))
			(= nsBottom (- (+ (= nsTop param2) param4) 1))
		)
		(DrawCel
			view
			loop
			cel
			nsLeft
			(+ nsTop (/ (- (- nsBottom nsTop) (CelHigh view loop cel)) 2))
			-1
			0
		)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
	)

	(method (onMe param1)
		(return
			(and
				(not (& signal $0004))
				(>= (param1 x:) nsLeft)
				(>= (param1 y:) nsTop)
				(<= (param1 x:) nsRight)
				(<= (param1 y:) nsBottom)
			)
		)
	)

	(method (ownedBy param1)
		(return (== owner param1))
	)

	(method (moveTo param1)
		(= owner param1)
		(if (and value (== param1 gEgo))
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)
)

(class InvBar of Set
	(properties
		stepSize -1
		hiResPort 0
		nsLeft 0
		nsRight 0
		nsTop 0
		nsBottom 0
		index 0
		state 0
		rightScroller 0
		leftScroller 0
		uBits 0
		owner 0
		numOwned 0
		numDisplayed 0
		curObj 0
	)

	(method (init param1 param2 param3 param4)
		(= gInventory self)
		(if (and argc (> argc 1))
			(= nsLeft param1)
			(= nsRight param3)
			(= nsTop param2)
			(= nsBottom param4)
		)
		(= index 0)
		(super init: &rest)
	)

	(method (show param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(SetPort 0 0 190 320 10 0)
		(if argc
			(= owner param1)
		)
		(if curObj
			(curObj highlight: 0)
		)
		(if uBits
			(Graph grRESTORE_BOX uBits)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(= uBits 0)
		)
		(= uBits (Graph grSAVE_BOX nsTop nsLeft (+ nsBottom 2) (+ nsRight 2) 1))
		(if index
			(leftScroller show:)
		else
			(leftScroller hide:)
		)
		(|= state $0020)
		(= numOwned (= temp6 (= numDisplayed 0)))
		(= temp2 3)
		(= temp3 (+ (- nsRight nsLeft) 1))
		(= temp8 (- nsBottom nsTop))
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (NodeValue temp0))
			(temp1 isVisible: 0)
			(temp1 signal: (| (temp1 signal:) $0004))
			(if (temp1 ownedBy: owner)
				(++ numOwned)
				(if (and (> numOwned index) (not temp6))
					(= temp4 (CelWide (temp1 view:) (temp1 loop:) (temp1 cel:)))
					(if (< (= temp5 (+ temp2 temp4 3)) temp3)
						(++ numDisplayed)
						(temp1
							show: (+ nsLeft temp2) (+ nsTop 1) temp4 temp8
							signal: (& (temp1 signal:) $fffb)
						)
						(temp1 isVisible: 1)
						(= temp2 temp5)
					else
						(= temp6 1)
					)
				)
			)
		)
		(if temp6
			(rightScroller show:)
		else
			(rightScroller hide:)
		)
		(if curObj
			(curObj highlight: 1)
		)
		(SetPort 0 0 139 320 10 0)
	)

	(method (onMe param1 &tmp temp0 temp1)
		(return
			(and
				(<= nsLeft (= temp0 (param1 x:)))
				(<= temp0 nsRight)
				(<= nsTop (= temp1 (param1 y:)))
				(<= temp1 nsBottom)
			)
		)
	)

	(method (hide &tmp temp0)
		(SetPort 0)
		(&= state $ffdf)
		(if uBits
			(Graph grRESTORE_BOX uBits 1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(= uBits 0)
		)
		(SetPort 0 0 139 320 10 0)
	)

	(method (scrollLeft &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(self hide:)
		(= temp3 (= temp0 0))
		(= temp4 (+ (- nsRight nsLeft) 1))
		(= temp2 index)
		(repeat
			(= temp8 temp3)
			(= temp6 0)
			(= temp5 0)
			(for
				((= temp7 (self first:)))
				(and temp7 (not temp6))
				((= temp7 (self next: temp7)))
				
				(= temp3 (NodeValue temp7))
				(if (and (temp3 ownedBy: owner) (>= (++ temp5) temp2))
					(= temp6 1)
				)
			)
			(if
				(<
					(+
						temp0
						(= temp1
							(+
								(CelWide
									(temp3 view:)
									(temp3 loop:)
									(temp3 cel:)
								)
								3
							)
						)
					)
					temp4
				)
				(+= temp0 temp1)
				(breakif (< (- temp2 1) 0))
				(-- temp2)
			else
				(break)
			)
		)
		(self display: (and temp8 (gInventory indexOf: temp8)) 1)
	)

	(method (scrollRight &tmp temp0 temp1 temp2 temp3)
		(self hide:)
		(if (!= stepSize -1)
			(+= index stepSize)
		else
			(+= index (+ numDisplayed 1))
		)
		(= temp2 (= temp3 0))
		(for
			((= temp0 (self first:)))
			(and temp0 (not temp3))
			((= temp0 (self next: temp0)))
			
			(= temp1 (NodeValue temp0))
			(if (and (temp1 ownedBy: owner) (>= (++ temp2) index))
				(= temp3 1)
			)
		)
		(self display: (gInventory indexOf: temp1) 1)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (= temp2 0))
		(if
			(and
				(not (event claimed:))
				(gUser canInput:)
				(& (event type:) evMOUSEBUTTON)
				(& state $0020)
				(not (event modifiers:))
				(or
					(self onMe: event)
					(and
						rightScroller
						(rightScroller underBits:)
						(rightScroller onMe: event)
						(or (event claimed: 1) 1)
						(rightScroller handleEvent:)
						(= temp1 1)
					)
					(and
						leftScroller
						(leftScroller underBits:)
						(leftScroller onMe: event)
						(or (event claimed: 1) 1)
						(leftScroller handleEvent:)
						(= temp2 1)
					)
				)
			)
			(cond
				(temp1
					(event claimed: 1)
					(if (< (+ index numDisplayed) numOwned)
						(self scrollRight:)
					)
				)
				(temp2
					(event claimed: 1)
					(if (> index 0)
						(self scrollLeft:)
					)
				)
				((== ((gTheIconBar curIcon:) message:) 3)
					(return 0)
				)
				((= temp0 (self firstTrue: #onMe event))
					(cond
						((not (== ((gTheIconBar curIcon:) message:) 5))
							(temp0 doVerb: ((gTheIconBar curIcon:) message:))
						)
						((temp0 select:)
							(self select: temp0)
						)
					)
				)
			)
			(event claimed: 1)
			(return)
		)
		(if (and (not (event claimed:)) (gUser canInput:))
			(event y: (- (event y:) 10))
			(cond
				(
					(and
						(> (event y:) 152)
						(or
							(and
								(leftScroller onMe: event)
								(leftScroller underBits:)
							)
							(and
								(rightScroller onMe: event)
								(rightScroller underBits:)
							)
						)
					)
					(if (not local0)
						(gGame setCursor: gNormalCursor)
						(= local0 1)
					)
				)
				(local0
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					(= local0 0)
				)
			)
			(event y: (+ (event y:) 10))
		)
	)

	(method (select param1)
		(SetPort 0 0 190 320 10 0)
		(if (and curObj (!= param1 curObj))
			(curObj highlight: 0)
		)
		(gTheIconBar curIcon: param1)
		(param1 highlight: 1)
		(= curObj param1)
		(SetPort 0 0 139 320 10 0)
	)

	(method (display param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(|= state $0020)
		(= temp6 (not (and (> argc 1) param2)))
		(= temp3 0)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (NodeValue temp0))
			(if (temp1 ownedBy: owner)
				(+=
					temp3
					(+ (CelWide (temp1 view:) (temp1 loop:) (temp1 cel:)) 3)
				)
			)
		)
		(if (> (= temp4 (+ (- nsRight nsLeft) 1)) (+ temp3 3))
			(= index 0)
			(if (not (& (gInventory state:) $0020))
				(return)
			)
			(self show: owner)
			(if temp6
				(if curObj
					(curObj highlight: 0)
				)
				((= curObj (gInventory at: param1)) highlight: 1)
			)
			(return)
		)
		(= temp2 (= index 0))
		(for
			((= temp0 (self first:)))
			(and temp0 (not index))
			((= temp0 (self next: temp0)))
			
			(= temp1 (NodeValue temp0))
			(if (== (temp1 owner:) owner)
				(if (< (self indexOf: temp1) param1)
					(++ temp2)
				else
					(= index temp2)
				)
			)
		)
		(= temp11 0)
		(repeat
			(= temp9 0)
			(= temp3 3)
			(= temp8 0)
			(for
				((= temp0 (self first:)))
				(and temp0 (not temp9))
				((= temp0 (self next: temp0)))
				
				(= temp1 (NodeValue temp0))
				(if (and (temp1 ownedBy: owner) (> (++ temp8) index))
					(= temp5 (CelWide (temp1 view:) (temp1 loop:) (temp1 cel:)))
					(if (< (= temp10 (+ temp3 temp5 3)) temp4)
						(= temp3 temp10)
					else
						(= temp9 1)
					)
				)
			)
			(if (not temp9)
				(= temp11 1)
				(-- index)
			else
				(if temp11
					(++ index)
				)
				(break)
			)
		)
		(self show: owner)
		(if temp6
			(if curObj
				(curObj highlight: 0)
			)
			((= curObj (gInventory at: param1)) highlight: 1)
		)
	)
)

