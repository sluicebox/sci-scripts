;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64895)
(include sci.sh)
(use Main)
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
		vInventory 0
		lInventory 0
		cInventory 2
		vCloseup 0
		oVerbs 0
		oMyHandler 0
	)

	(method (doVerb theVerb)
		(if (and noun gMsgType (Message msgGET 0 noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 0)
		)
	)

	(method (ownedBy who)
		(return (== owner who))
	)

	(method (moveTo who nSlot &tmp useSlot ioItem)
		(if (== owner who)
			(return)
		)
		(if (and (> argc 1) (< nSlot (oMyHandler invSlotsTot:)))
			(= useSlot nSlot)
		else
			(= useSlot (oMyHandler findFirstOpen:))
		)
		(if (== owner -2)
			(= global101 1)
			(= gInventItem 0)
		)
		(if (== who -2)
			(if gInventItem
				(gInventItem moveTo: -3)
			)
			(= global101 verb)
			(= gInventItem self)
		)
		(if (== owner -3)
			(oMyHandler removeItem: self)
		)
		(if (== who -3)
			(oMyHandler addItem: self useSlot)
		)
		(= owner who)
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

	(method (addSelfToCursorList cursorList)
		(cursorList add: verb vInventory)
	)

	(method (testHotspotVerb theVerb)
		(if oVerbs
			(return (oVerbs contains: theVerb))
		else
			(return 0)
		)
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
		ioMine 0
		curSlot 0
		oMyHandler 0
	)

	(method (testHotspotVerb theVerb)
		(if (and (!= ioMine 0) (== theVerb 1))
			(return 1)
		)
		(if (and (not ioMine) oMyHandler (oMyHandler getVerbItem: theVerb))
			(return 1)
		)
		(if ioMine
			(return (ioMine testHotspotVerb: theVerb &rest))
		else
			(return 0)
		)
	)

	(method (setCurItem ioSet theSlot)
		(if (> argc 0)
			(= ioMine ioSet)
			(if ioMine
				(= view (ioSet vInventory:))
				(= loop (ioSet lInventory:))
				(= cel (ioSet cInventory:))
				(= noun (ioSet noun:))
			else
				(= view (oMyHandler blankID:))
				(= noun (= cel (= loop 0)))
			)
			(if (> argc 1)
				(= curSlot theSlot)
			)
		)
	)

	(method (doVerb theVerb &tmp ioHeld)
		(cond
			(ioMine
				(if (== theVerb 1) ; Do
					(ioMine moveTo: -2)
				else
					(ioMine doVerb: theVerb &rest)
				)
			)
			(gInventItem
				(gInventItem moveTo: -3 curSlot)
			)
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

	(method (init oCastParm oPosParm &tmp oCast i j posX posY ioTemp nSize oPosArray)
		(if (not argc)
			(= oCast gCast)
		else
			(= oCast oCastParm)
		)
		(if (> argc 1)
			(= oPosArray oPosParm)
		else
			(= oPosArray 0)
		)
		(if oPosArray
			(= invSlotsTot (/ (oPosArray size:) 2))
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
		(if oPosArray
			(for ((= i 0)) (< i viewSlotsTot) ((++ i))
				(oScreenSlots
					addToEnd:
						((InvSlot new:)
							view: blankID
							oMyHandler: self
							posn:
								(oPosArray at: (* i 2))
								(oPosArray at: (+ (* i 2) 1))
							init: oCast
							curSlot: i
							yourself:
						)
				)
			)
		else
			(= posY screenLocY)
			(for ((= i 0)) (< i viewSlotsY) ((++ i))
				(= posX screenLocX)
				(for ((= j 0)) (< j viewSlotsX) ((++ j))
					(oScreenSlots
						addToEnd:
							((InvSlot new:)
								view: blankID
								oMyHandler: self
								posn: posX posY
								init: oCast
								curSlot: (+ j (* i invSlotsX))
								yourself:
							)
					)
					(+= posX slotIncX)
				)
				(+= posY slotIncY)
			)
		)
		(self initItems:)
		(if oAllHandledItems
			(= nSize (oAllHandledItems size:))
			(for ((= i 0)) (< i nSize) ((++ i))
				(if (= ioTemp (oAllHandledItems at: i))
					(ioTemp oMyHandler: self init:)
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

	(method (getVerbItem theVerb &tmp i nSize ioTemp)
		(if oAllHandledItems
			(= nSize (oAllHandledItems size:))
			(for ((= i 0)) (< i nSize) ((++ i))
				(if
					(and
						(= ioTemp (oAllHandledItems at: i))
						(== theVerb (ioTemp verb:))
					)
					(return ioTemp)
				)
			)
		)
		(return 0)
	)

	(method (findFirstOpen &tmp i)
		(if oInventItemSlots
			(for ((= i 0)) (< i invSlotsTot) ((++ i))
				(if (not (oInventItemSlots at: i))
					(return i)
				)
			)
		)
		(return -1)
	)

	(method (findNearestOpen nX nY &tmp i nDist nLowDist lowSlot bFound oSlot)
		(= nLowDist 30000)
		(= bFound 0)
		(if oScreenSlots
			(for ((= i 0)) (< i viewSlotsTot) ((++ i))
				(if
					(or
						(not (= oSlot (oScreenSlots at: i)))
						(not (oSlot ioMine:))
					)
					(= bFound 1)
					(if
						(<
							(= nDist
								(GetDistance
									nX
									nY
									(oSlot x:)
									(oSlot y:)
								)
							)
							nLowDist
						)
						(= nLowDist nDist)
						(= lowSlot i)
					)
				)
			)
		)
		(if bFound
			(return (oScreenSlots at: lowSlot))
		else
			(return 0)
		)
	)

	(method (scroll relX relY)
		(self scrollTo: (+ curULX relX) (+ curULY relY))
	)

	(method (scrollTo newX newY &tmp oldX oldY)
		(if (not bScrollable)
			(return)
		)
		(= oldX curULX)
		(= oldY curULY)
		(= curULX newX)
		(= curULY newY)
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
		(if (or (!= oldX curULX) (!= oldY curULY))
			(self update:)
		)
	)

	(method (update &tmp i j slotNum oSlot invSlotNum ioTemp)
		(if bScrollable
			(for ((= i 0)) (< i viewSlotsY) ((++ i))
				(for ((= j 0)) (< j viewSlotsX) ((++ j))
					(= slotNum (+ j (* i viewSlotsX)))
					(= oSlot (oScreenSlots at: slotNum))
					(= invSlotNum (+ j curULX (* (+ i curULY) invSlotsX)))
					(= ioTemp (oInventItemSlots at: invSlotNum))
					(oSlot setCurItem: ioTemp invSlotNum)
				)
			)
		else
			(for ((= i 0)) (< i viewSlotsTot) ((++ i))
				(= oSlot (oScreenSlots at: i))
				(= ioTemp (oInventItemSlots at: i))
				(oSlot setCurItem: ioTemp invSlotNum) ; UNINIT
			)
		)
	)

	(method (compress &tmp ioTemp i j)
		(for ((= i 0)) (< i invSlotsTot) ((++ i))
			(if (= ioTemp (oInventItemSlots at: i))
				(for ((= j 0)) (< j i) ((++ j))
					(if (not (oInventItemSlots at: j))
						(oInventItemSlots at: j ioTemp)
						(oInventItemSlots at: i 0)
					)
				)
			)
		)
	)

	(method (addItem ioWhich nSlot)
		(if (and (>= nSlot 0) (< nSlot invSlotsTot))
			(oInventItemSlots at: nSlot ioWhich)
			(self updateItemSlot: nSlot)
		)
	)

	(method (removeItem ioWhich &tmp i)
		(for ((= i 0)) (< i invSlotsTot) ((++ i))
			(if (== ioWhich (oInventItemSlots at: i))
				(oInventItemSlots at: i 0)
				(self updateItemSlot: i)
				(break)
			)
		)
	)

	(method (updateItemSlot invSlot &tmp x y nSlot)
		(if bScrollable
			(= y (- (/ invSlot invSlotsX) curULY))
			(= nSlot
				(+
					(= x (- (- invSlot (* y invSlotsX)) curULX))
					(* y viewSlotsX)
				)
			)
		else
			(= nSlot invSlot)
		)
		((oScreenSlots at: nSlot) setCurItem: (oInventItemSlots at: invSlot))
	)

	(method (get nItemID)
		(oAllHandledItems at: nItemID)
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

	(method (testHotspotVerb theVerb)
		(if (and oMyHandler (oMyHandler getVerbItem: theVerb))
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb &tmp oSlot)
		(if (not oMyHandler)
			(return)
		)
		(if
			(not
				(= oSlot
					(oMyHandler
						findNearestOpen:
							(- gMouseX (plane left:))
							(- gMouseY (plane top:))
					)
				)
			)
			(return)
		)
		(oSlot doVerb: theVerb &rest)
	)
)

