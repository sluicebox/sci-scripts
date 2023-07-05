;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64895)
(include sci.sh)
(use Main)
(use oInvHandler)
(use soFlashCyberSniff)
(use PArray)
(use Array)
(use Feature)
(use Actor)
(use System)

(class InventItem of Obj
	(properties
		owner -1
		verb 0
		noun 0
		case 0
		vInventory 0
		lInventory 0
		cInventory 2
		vCloseup 0
		oVerbs 0
		oMyHandler 0
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(if
			(and
				(!= theVerb 12) ; Other...
				(!= theVerb 112) ; Other...
				(!= theVerb 70) ; Huh?
				gMsgType
				(Message msgGET 11 noun theVerb case 1)
			)
			(gMessager say: noun theVerb case 0 0 11)
			(return)
		)
		(if
			(and
				(!= theVerb 12) ; Other...
				(!= theVerb 112) ; Other...
				(!= theVerb 70) ; Huh?
				gMsgType
				(proc64037_3 theVerb)
				(Message msgGET 11 noun 161 case 1)
			)
			(gMessager say: noun 161 case 0 0 11)
			(return)
		)
		(= temp2 (Abs (+ (* 7 verb) (* 23 noun) (* 43 vInventory))))
		(if (= temp0 (GetNumCases 16 0 theVerb))
			(= temp1 (+ (mod temp2 temp0) 1))
			(gMessager say: 0 theVerb temp1 0 0 16)
			(return)
		)
		(if (= temp0 (GetNumMessages 16 0 theVerb 0))
			(gMessager say: 0 theVerb 0 0 0 16)
			(return)
		)
		(if (and (proc64037_3 theVerb) (= temp0 (GetNumCases 16 0 161)))
			(= temp1 (+ (mod temp2 temp0) 1))
			(gMessager say: 0 161 temp1 0 0 16)
			(return)
		)
		(if (= temp0 (GetNumCases 16 0 69))
			(= temp1 (+ (mod temp2 temp0) 1))
			(gMessager say: 0 69 temp1 0 0 16)
			(return)
		)
	)

	(method (ownedBy param1)
		(return (== owner param1))
	)

	(method (moveTo param1 param2 &tmp temp0 temp1)
		(if (== owner param1)
			(return)
		)
		(if (and (> argc 1) (< param2 (oMyHandler invSlotsTot:)))
			(= temp0 param2)
		else
			(= temp0 (oMyHandler findFirstOpen:))
		)
		(if (== owner -2)
			(= global101 1)
			(= gInventItem 0)
		)
		(if (== param1 -2)
			(if gInventItem
				(gInventItem moveTo: -3)
			)
			(= global101 verb)
			(= gInventItem self)
		)
		(if (== owner -3)
			(oMyHandler removeItem: self)
		)
		(if (== param1 -3)
			(oMyHandler addItem: self temp0)
		)
		(= owner param1)
		(return self)
	)

	(method (addHotspotVerb)
		(if (not oVerbs)
			(= oVerbs (Set new:))
		)
		(oVerbs add: &rest)
	)

	(method (deleteHotspotVerb)
		(if oVerbs
			(oVerbs delete: &rest)
		)
	)

	(method (addSelfToCursorList param1)
		(param1 add: verb vInventory)
	)

	(method (testHotspotVerb param1)
		(if oVerbs
			(return (oVerbs contains: param1))
		else
			(return 0)
		)
	)

	(method (getHotspotVerbList)
		(return oVerbs)
	)

	(method (getName)
		(MakeMessageText 0 verb 0 1 11)
	)

	(method (dispose)
		(self moveTo: -1)
		(if oVerbs
			(oVerbs dispose:)
		)
		(super dispose: &rest)
	)
)

(class InvSlot of View
	(properties
		view 60005
		signal 0
		ioMine 0
		curSlot 0
		oMyHandler 0
	)

	(method (getHotspotVerbList)
		(if (not ioMine)
			(return 0)
		)
		(return (ioMine oVerbs:))
	)

	(method (testHotspotVerb param1)
		(if (and (!= ioMine 0) (== param1 1))
			(return 1)
		)
		(if (and (not ioMine) oMyHandler (oMyHandler getVerbItem: param1))
			(return 1)
		)
		(if ioMine
			(return (ioMine testHotspotVerb: param1 &rest))
		else
			(return 0)
		)
	)

	(method (setCurItem param1 param2)
		(if (> argc 0)
			(= ioMine param1)
			(if ioMine
				(= view (param1 vInventory:))
				(= loop (param1 lInventory:))
				(= cel (param1 cInventory:))
				(= noun (param1 noun:))
			else
				(= view (oMyHandler blankID:))
				(= noun (= cel (= loop 0)))
			)
			(if (> argc 1)
				(= curSlot param2)
			)
		)
	)

	(method (getName)
		(if ioMine
			(ioMine getName: &rest)
			(return)
		else
			(return)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if ioMine
			(ioMine doVerb: theVerb &rest)
			(return)
		else
			(return)
		)
	)
)

(class InvHandler of Obj
	(properties
		viewSlotsX 2
		viewSlotsY 2
		invSlotsX 2
		invSlotsY 2
		screenLocX 0
		screenLocY 0
		slotIncX 15
		slotIncY 15
		blankID -1
		oAllHandledItems 0
		oInventItemSlots 0
		oScreenSlots 0
		viewSlotsTot 0
		invSlotsTot 0
		curULX 0
		curULY 0
		bScrollable 1
	)

	(method (init param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (not argc)
			(= temp0 gCast)
		else
			(= temp0 param1)
		)
		(if (> argc 1)
			(= temp7 param2)
		else
			(= temp7 0)
		)
		(if temp7
			(= invSlotsTot (/ (temp7 size:) 2))
			(= viewSlotsTot invSlotsTot)
		else
			(= invSlotsTot (* invSlotsX invSlotsY))
			(= viewSlotsTot (* viewSlotsX viewSlotsY))
		)
		(if (== invSlotsTot viewSlotsTot)
			(= bScrollable 0)
		else
			(= bScrollable 1)
		)
		(= oInventItemSlots (IntArray new: invSlotsTot))
		(= oScreenSlots (List new:))
		(= oAllHandledItems (PArray new:))
		(if temp7
			(for ((= temp1 0)) (< temp1 viewSlotsTot) ((++ temp1))
				(oScreenSlots
					addToEnd:
						((InvSlot new:)
							view: blankID
							oMyHandler: self
							posn:
								(temp7 at: (* temp1 2))
								(temp7 at: (+ (* temp1 2) 1))
							init: temp0
							curSlot: temp1
							yourself:
						)
				)
			)
		else
			(= temp4 screenLocY)
			(for ((= temp1 0)) (< temp1 viewSlotsY) ((++ temp1))
				(= temp3 screenLocX)
				(for ((= temp2 0)) (< temp2 viewSlotsX) ((++ temp2))
					(oScreenSlots
						addToEnd:
							((InvSlot new:)
								view: blankID
								oMyHandler: self
								posn: temp3 temp4
								init: temp0
								curSlot: (+ temp2 (* temp1 invSlotsX))
								yourself:
							)
					)
					(+= temp3 slotIncX)
				)
				(+= temp4 slotIncY)
			)
		)
		(self initItems:)
		(if oAllHandledItems
			(= temp6 (oAllHandledItems size:))
			(for ((= temp1 0)) (< temp1 temp6) ((++ temp1))
				(if (= temp5 (oAllHandledItems at: temp1))
					(temp5 oMyHandler: self init:)
				)
			)
		)
	)

	(method (initItems))

	(method (add)
		(if oAllHandledItems
			(oAllHandledItems add: &rest)
		)
	)

	(method (getVerbItem param1 &tmp temp0 temp1 temp2)
		(if oAllHandledItems
			(= temp1 (oAllHandledItems size:))
			(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
				(if
					(and
						(= temp2 (oAllHandledItems at: temp0))
						(== param1 (temp2 verb:))
					)
					(return temp2)
				)
			)
		)
		(return 0)
	)

	(method (findFirstOpen &tmp temp0)
		(if oInventItemSlots
			(for ((= temp0 0)) (< temp0 invSlotsTot) ((++ temp0))
				(if (not (oInventItemSlots at: temp0))
					(return temp0)
				)
			)
		)
		(return -1)
	)

	(method (findNearestOpen param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp2 30000)
		(= temp4 0)
		(if oScreenSlots
			(for ((= temp0 0)) (< temp0 viewSlotsTot) ((++ temp0))
				(if
					(or
						(not (= temp5 (oScreenSlots at: temp0)))
						(not (temp5 ioMine:))
					)
					(= temp4 1)
					(if
						(<
							(= temp1
								(GetDistance
									param1
									param2
									(temp5 x:)
									(temp5 y:)
								)
							)
							temp2
						)
						(= temp2 temp1)
						(= temp3 temp0)
					)
				)
			)
		)
		(if temp4
			(return (oScreenSlots at: temp3))
		else
			(return 0)
		)
	)

	(method (scroll param1 param2)
		(self scrollTo: (+ curULX param1) (+ curULY param2))
	)

	(method (scrollTo param1 param2 &tmp temp0 temp1)
		(if (not bScrollable)
			(return)
		)
		(= temp0 curULX)
		(= temp1 curULY)
		(= curULX param1)
		(= curULY param2)
		(cond
			((> (+ curULX viewSlotsX) invSlotsX)
				(= curULX (- invSlotsX viewSlotsX))
			)
			((< curULX 0)
				(= curULX 0)
			)
			((> (+ curULY viewSlotsY) invSlotsY)
				(= curULY (- invSlotsY viewSlotsY))
			)
			((< curULY 0)
				(= curULY 0)
			)
		)
		(if (or (!= temp0 curULX) (!= temp1 curULY))
			(self update:)
		)
	)

	(method (update &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if bScrollable
			(for ((= temp0 0)) (< temp0 viewSlotsY) ((++ temp0))
				(for ((= temp1 0)) (< temp1 viewSlotsX) ((++ temp1))
					(= temp2 (+ temp1 (* temp0 viewSlotsX)))
					(= temp3 (oScreenSlots at: temp2))
					(= temp4 (+ temp1 curULX (* (+ temp0 curULY) invSlotsX)))
					(= temp5 (oInventItemSlots at: temp4))
					(temp3 setCurItem: temp5 temp4)
				)
			)
		else
			(for ((= temp0 0)) (< temp0 viewSlotsTot) ((++ temp0))
				(= temp3 (oScreenSlots at: temp0))
				(= temp5 (oInventItemSlots at: temp0))
				(temp3 setCurItem: temp5 temp4) ; UNINIT
			)
		)
	)

	(method (compress &tmp temp0 temp1 temp2)
		(for ((= temp1 0)) (< temp1 invSlotsTot) ((++ temp1))
			(if (= temp0 (oInventItemSlots at: temp1))
				(for ((= temp2 0)) (< temp2 temp1) ((++ temp2))
					(if (not (oInventItemSlots at: temp2))
						(oInventItemSlots at: temp2 temp0)
						(oInventItemSlots at: temp1 0)
						(self updateItemSlot: temp2)
						(self updateItemSlot: temp1)
					)
				)
			)
		)
	)

	(method (addItem param1 param2)
		(if (and (>= param2 0) (< param2 invSlotsTot))
			(oInventItemSlots at: param2 param1)
			(self updateItemSlot: param2)
		)
	)

	(method (removeItem param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 invSlotsTot) ((++ temp0))
			(if (== param1 (oInventItemSlots at: temp0))
				(oInventItemSlots at: temp0 0)
				(self updateItemSlot: temp0)
				(break)
			)
		)
	)

	(method (updateItemSlot param1 &tmp temp0 temp1 temp2)
		(if bScrollable
			(= temp1 (- (/ param1 invSlotsX) curULY))
			(= temp2
				(+
					(= temp0 (- (- param1 (* temp1 invSlotsX)) curULX))
					(* temp1 viewSlotsX)
				)
			)
		else
			(= temp2 param1)
		)
		((oScreenSlots at: temp2) setCurItem: (oInventItemSlots at: param1))
	)

	(method (get param1)
		(oAllHandledItems at: param1)
	)

	(method (dispose)
		(if oInventItemSlots
			(oInventItemSlots dispose:)
		)
		(if oScreenSlots
			(oScreenSlots dispose:)
		)
		(if oAllHandledItems
			(oAllHandledItems dispose:)
		)
		(super dispose: &rest)
	)
)

(class InventWellFeature of Feature
	(properties
		y -1
		oMyHandler 0
	)

	(method (testHotspotVerb param1)
		(if (and oMyHandler (oMyHandler getVerbItem: param1))
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not oMyHandler)
			(return)
		)
		(if
			(not
				(= temp0
					(oMyHandler
						findNearestOpen:
							(- gMouseX (plane left:))
							(- gMouseY (plane top:))
					)
				)
			)
			(return)
		)
		(temp0 doVerb: theVerb &rest)
	)
)

