;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use HRView)
(use n013)
(use Plane)
(use Inventory)
(use System)

(local
	local0
)

(class GKInvItem of InvI
	(properties
		modNum 15
		cursorView 0
		cursorLoop 0
		cursorCel 0
		page 0
		visible 0
	)

	(method (init)
		(if (and (< mainView 10000) (IsHiRes))
			(= view (+ 10000 view))
			(= mainView (+ 10000 mainView))
		)
		(super init: &rest)
	)

	(method (highlight))

	(method (onMe param1)
		(return (and (not (& signal $0004)) visible (super onMe: param1)))
	)

	(method (setCursor param1 param2 param3)
		(= cursorView param1)
		(= cursorLoop param2)
		(= cursorCel param3)
	)

	(method (cue))

	(method (doVerb theVerb &tmp temp0)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if gMsgType
			(cond
				((Message msgGET modNum noun theVerb 0 1)
					(gMessager say: noun theVerb 0 0 0 modNum)
				)
				((Message msgGET modNum noun 0 0 1)
					(gMessager say: noun 0 0 0 0 modNum)
				)
				((Message msgGET modNum 0 theVerb 0 1)
					(gMessager say: 0 theVerb 0 0 0 modNum)
				)
				((Message msgGET modNum 0 0 0 1)
					(gMessager say: 0 0 0 0 0 modNum) ; "Those two objects would have no effect on each other."
				)
			)
		)
		(return 1)
	)
)

(class GKInventory of Inv
	(properties
		normalHeading {Gabriel is carrying}
		empty {nothing.}
		lastPage 0
		numLastPage 0
		curPage 0
		indicatorY 0
		tallestInv 0
		widestInv 0
		mode 0
		theCaller 0
	)

	(method (init)
		(= local0 (Cast new:))
		(= gInventory self)
		(self
			plane: inventWind
			helpIconItem: invHelp
			okButton: invExit
			add:
				(phoEnvelope setCursor: 942 0 5 yourself:)
				(murderPhoto setCursor: 942 0 8 yourself:)
				(gradPhoto setCursor: 942 0 7 yourself:)
				(tweezers setCursor: 942 0 2 yourself:)
				(magGlass setCursor: 942 0 1 yourself:)
				(giftCert setCursor: 942 1 1 yourself:)
				(sketchBook setCursor: 942 0 4 yourself:)
				(phonePage setCursor: 942 1 8 yourself:)
				(wolfPhone setCursor: 942 1 9 yourself:)
				(news1810 setCursor: 942 2 0 yourself:)
				(guntJournal setCursor: 942 2 3 yourself:)
				((ScriptID 24 31) setCursor: 942 2 2 yourself:) ; wolfLetter
				(ritLetter setCursor: 942 0 15 yourself:)
				(clay setCursor: 942 0 3 yourself:)
				(drumBook setCursor: 942 2 1 yourself:)
				(veveCopy setCursor: 942 0 13 yourself:)
				(policeVeve_ setCursor: 942 0 12 yourself:)
				(badge setCursor: 942 1 0 yourself:)
				(tracker setCursor: 942 2 6 yourself:)
				((ScriptID 24 27) setCursor: 942 2 7 yourself:) ; signalDev_
				((ScriptID 24 28) setCursor: 942 2 7 yourself:) ; signalDev2_
				(crocMask setCursor: 942 1 6 yourself:)
				(oil setCursor: 942 1 7 yourself:)
				(musScale setCursor: 942 0 0 yourself:)
				(lakeScale setCursor: 942 0 0 yourself:)
				(twoScales setCursor: 942 2 5 yourself:)
				(tatooTrace setCursor: 942 0 9 yourself:)
				(keyEnvelope setCursor: 942 2 9 yourself:)
				(mosKey setCursor: 942 2 11 yourself:)
				(mosLetter setCursor: 942 2 10 yourself:)
				(hundred setCursor: 942 1 5 yourself:)
				(sLakePatter setCursor: 942 0 6 yourself:)
				((ScriptID 24 45) setCursor: 942 0 10 yourself:) ; VoodooCode1
				((ScriptID 24 46) setCursor: 942 0 11 yourself:) ; sVoodooCode
				((ScriptID 24 47) setCursor: 942 0 14 yourself:) ; ritPhoto_
				((ScriptID 24 48) setCursor: 942 1 2 yourself:) ; lostDrawing
				((ScriptID 24 49) setCursor: 942 1 3 yourself:) ; luckyDog_
				((ScriptID 24 50) setCursor: 942 1 4 yourself:) ; snakeSkin_
				((ScriptID 24 51) setCursor: 942 1 10 yourself:) ; reconVeve_
				((ScriptID 24 42) setCursor: 942 1 11 yourself:) ; collar_
				((ScriptID 24 43) setCursor: 942 1 12 yourself:) ; braceMold_
				((ScriptID 24 44) setCursor: 942 1 13 yourself:) ; braceRep_
				(veil setCursor: 942 1 14 yourself:)
				((ScriptID 24 26) setCursor: 942 1 15 yourself:) ; fortScale_
				((ScriptID 24 29) setCursor: 942 2 8 yourself:) ; brick
				((ScriptID 24 30) setCursor: 942 2 4 yourself:) ; hartNotes
				((ScriptID 24 32) setCursor: 942 4 6 yourself:) ; hair_gel
				((ScriptID 24 33) setCursor: 942 4 4 yourself:) ; shirt
				((ScriptID 24 34) setCursor: 942 4 5 yourself:) ; disguise
				((ScriptID 24 0) setCursor: 942 2 13 yourself:) ; tile1
				((ScriptID 24 2) setCursor: 942 2 15 yourself:) ; tile3
				((ScriptID 24 1) setCursor: 942 2 14 yourself:) ; tile2
				((ScriptID 24 4) setCursor: 942 3 1 yourself:) ; tile5
				((ScriptID 24 3) setCursor: 942 3 0 yourself:) ; tile4
				((ScriptID 24 6) setCursor: 942 3 11 yourself:) ; records
				((ScriptID 24 5) setCursor: 942 3 2 yourself:) ; tile6
				((ScriptID 24 8) setCursor: 942 3 4 yourself:) ; tile9
				((ScriptID 24 7) setCursor: 942 3 3 yourself:) ; tile8
				((ScriptID 24 10) setCursor: 942 3 6 yourself:) ; tile11
				((ScriptID 24 9) setCursor: 942 3 5 yourself:) ; tile10
				((ScriptID 24 11) setCursor: 942 2 12 yourself:) ; rod
				((ScriptID 24 12) setCursor: 942 4 1 yourself:) ; chamPot
				((ScriptID 24 13) setCursor: 942 4 10 yourself:) ; lotsCash
				((ScriptID 24 14) setCursor: 942 4 2 yourself:) ; scroll
				((ScriptID 24 15) setCursor: 942 3 7 yourself:) ; knife
				((ScriptID 24 16) setCursor: 942 3 15 yourself:) ; salt
				((ScriptID 24 17) setCursor: 942 4 0 yourself:) ; scissors
				((ScriptID 24 18) setCursor: 942 4 3 yourself:) ; bookSnkMnd
				((ScriptID 24 20) setCursor: 942 4 7 yourself:) ; wolfKey
				((ScriptID 24 21) setCursor: 942 3 9 yourself:) ; talisman
				((ScriptID 24 22) setCursor: 942 3 8 yourself:) ; bones
				((ScriptID 24 23) setCursor: 942 3 13 yourself:) ; master_card
				((ScriptID 24 24) setCursor: 942 3 14 yourself:) ; wallet
				((ScriptID 24 25) setCursor: 942 4 9 yourself:) ; lit_flash
				((ScriptID 24 35) setCursor: 942 3 12 yourself:) ; BoarMask
				((ScriptID 24 36) setCursor: 942 4 11 yourself:) ; BoarRobe
				((ScriptID 24 37) setCursor: 942 4 12 yourself:) ; WolfMask
				((ScriptID 24 38) setCursor: 942 4 13 yourself:) ; WolfRobe
				((ScriptID 24 39) setCursor: 942 4 14 yourself:) ; BoarGuise
				((ScriptID 24 40) setCursor: 942 4 15 yourself:) ; WolfGuise
				((ScriptID 24 41) setCursor: 942 3 10 yourself:) ; hounfourKey
				invRead
				invOpen
				invLook
				invHelp
				invSelect
				invExit
				invUp
				invDown
			selectIcon: invSelect
			eachElementDo: #lowlightColor global214
			eachElementDo: #highlightColor global220
			eachElementDo: #modNum 15
			state: 2048
		)
		(super init:)
		(plane addCast: local0)
		(windowCel init: local0)
		(indicator init: local0)
		(= heading normalHeading)
	)

	(method (assignPages &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 0)
		(= numLastPage 0)
		(= temp1 1)
		(for ((= temp2 (self first:))) temp2 ((= temp2 (self next: temp2)))
			(if ((= temp3 (NodeValue temp2)) isKindOf: InvI)
				(temp3 visible: 0 page: 0)
				(if (temp3 ownedBy: gEgo)
					(if
						(>
							(= temp4
								(CelWide
									(temp3 view:)
									(temp3 loop:)
									(temp3 cel:)
								)
							)
							widestInv
						)
						(= widestInv temp4)
					)
					(if
						(>
							(= temp5
								(CelHigh
									(temp3 view:)
									(temp3 loop:)
									(temp3 cel:)
								)
							)
							tallestInv
						)
						(= tallestInv temp5)
					)
					(++ temp0)
					(++ numLastPage)
					(temp3 page: temp1)
					(= lastPage temp1)
					(if (not (mod temp0 9))
						(++ temp1)
						(= numLastPage 0)
					)
				)
			)
		)
		(return temp0)
	)

	(method (carryingNothing)
		(gMessager say: 0 0 22 1 0 15) ; "Gabriel is carrying nothing."
		(return 0)
	)

	(method (drawInvItems param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 5])
		(if (not (self assignPages:))
			(gMessager say: 0 0 22 1 0 15) ; "Gabriel is carrying nothing."
			(return 0)
		)
		(gNarrator modeless: 1)
		(= curPage (if argc param1 else 1))
		(self moveIndicator:)
		(= temp2 0)
		(if (!= curPage lastPage)
			(= temp0 (= temp1 3))
		else
			(= temp1
				(cond
					((< numLastPage 4) 1)
					((< numLastPage 7) 2)
					(else 3)
				)
			)
			(if (> (= temp0 numLastPage) 3)
				(= temp0 3)
			)
		)
		(= temp4 14)
		(= temp5 12)
		(for ((= temp3 (self first:))) temp3 ((= temp3 (self next: temp3)))
			(= temp8 (NodeValue temp3))
			(if (and (temp8 isKindOf: InvI) (== (temp8 page:) curPage))
				(++ temp2)
				(temp8 signal: (& (temp8 signal:) $fffb))
				(temp8
					visible: 1
					x:
						(+
							temp5
							(/
								(-
									widestInv
									(= temp6
										(CelWide
											(temp8 view:)
											(temp8 loop:)
											(temp8 cel:)
										)
									)
								)
								2
							)
						)
					y:
						(+
							temp4
							(/
								(-
									tallestInv
									(= temp7
										(CelHigh
											(temp8 view:)
											(temp8 loop:)
											(temp8 cel:)
										)
									)
								)
								2
							)
						)
				)
				(if (mod temp2 3)
					(+= temp5 (+ widestInv 3))
				else
					(+= temp4 (+ tallestInv 6))
					(= temp5 12)
				)
				(temp8
					nsTop: (temp8 x:)
					nsLeft: (temp8 y:)
					nsRight:
						(+
							(temp8 x:)
							(CelWide (temp8 view:) (temp8 loop:) (temp8 cel:))
						)
					nsBottom: (+ (temp8 y:) temp7)
				)
				(AddScreenItem temp8)
			)
		)
		(plane setSize: posn: -1 25)
		(return (UpdatePlane plane))
	)

	(method (eraseItems &tmp temp0 temp1)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(if
				(and
					((= temp1 (NodeValue temp0)) isKindOf: InvI)
					(== (temp1 page:) curPage)
				)
				(temp1 nsLeft: 0 nsTop: 0 nsRight: 0 nsBottom: 0 visible: 0)
				(DeleteScreenItem temp1)
			)
		)
	)

	(method (showSelf param1)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(= owner gEgo)
		(if (not (self ownedBy: owner))
			(self carryingNothing:)
			(return 0)
		)
		(return (self show: param1 doit: hide:))
	)

	(method (show param1)
		(|= state $0020)
		(gGame setCursor: (self getCursor:))
		(plane priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
		(self drawInvItems: param1)
		(return 1)
	)

	(method (hide &tmp temp0 temp1 temp2 temp3 temp4)
		(gNarrator modeless: 2)
		(= temp3 (gTheIconBar curInvIcon:))
		(for ((= temp1 (self first:))) temp1 ((= temp1 (self next: temp1)))
			(if
				(and
					((= temp2 (NodeValue temp1)) isKindOf: InvI)
					(not (temp2 visible:))
				)
				(temp2 signal: (| (temp2 signal:) $0004))
			)
		)
		(super hide:)
		(if
			(and
				(gTheIconBar curInvIcon:)
				(!= temp3 (gTheIconBar curInvIcon:))
				(gGame barUp:)
			)
			(gTheIconBar showInvItem: 1)
		)
		(if (and theCaller (not stifleCue))
			(theCaller cue:)
			(= theCaller 0)
		)
	)

	(method (moveIndicator &tmp temp0 temp1)
		(cond
			((== curPage 1)
				(= temp0 26)
			)
			((== curPage lastPage)
				(= temp0 86)
			)
			(else
				(= temp1 (/ 56 (- lastPage 1)))
				(= temp0 (+ 21 (* (- curPage 1) temp1)))
			)
		)
		(indicator x: 142 y: temp0)
		(UpdateScreenItem indicator)
	)

	(method (advance param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp2 (self indexOf: highlightedIcon))
		(= temp3 (+ temp1 temp2))
		(repeat
			(if
				(not
					(= temp0
						(self
							at:
								(if (<= temp3 size)
									temp3
								else
									(mod temp3 (- size 1))
								)
						)
					)
				)
				(= temp0 (NodeValue (self first:)))
			)
			(if
				(or
					(and (temp0 isKindOf: InvI) (temp0 visible:))
					(not (& (temp0 signal:) $0004))
				)
				(break)
			else
				(++ temp3)
			)
		)
		(self highlight: temp0 1)
	)

	(method (retreat param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if argc param1 else 1))
		(= temp3 (- (= temp2 (self indexOf: highlightedIcon)) temp1))
		(repeat
			(if (not (= temp0 (self at: temp3)))
				(= temp0 (NodeValue (self last:)))
			)
			(if
				(or
					(and (temp0 isKindOf: InvI) (temp0 visible:))
					(not (& (temp0 signal:) $0004))
				)
				(break)
			else
				(++ temp3)
			)
		)
		(self highlight: temp0 1)
	)
)

(instance invRead of HRIconItem
	(properties
		noun 85
		nsRight 184
		nsBottom 22
		x 165
		y 6
		signal 129
		message 58
		mainView 951
		mainLoop 1
		cursorView 958
		cursorLoop 9
		cursorCel 0
		helpVerb 68
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)
)

(instance invOpen of HRIconItem
	(properties
		noun 86
		nsRight 174
		nsBottom 36
		x 165
		y 22
		signal 129
		message 6
		mainView 951
		mainLoop 2
		cursorView 958
		cursorLoop 2
		cursorCel 0
		helpVerb 68
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)
)

(instance invLook of HRIconItem
	(properties
		noun 89
		nsRight 184
		nsBottom 51
		x 165
		y 37
		signal 129
		message 7
		mainView 951
		mainLoop 4
		cursorView 958
		cursorLoop 5
		cursorCel 0
		helpVerb 68
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)
)

(instance invHelp of HRIconItem
	(properties
		noun 88
		nsRight 184
		nsBottom 96
		x 165
		y 81
		signal 129
		message 68
		mainView 951
		mainLoop 5
		cursorView 958
		cursorLoop 8
		cursorCel 0
		helpVerb 68
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)
)

(instance invSelect of HRIconItem
	(properties
		noun 91
		nsRight 184
		nsBottom 81
		x 165
		y 66
		signal 129
		mainView 951
		mainLoop 9
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (init)
		(super init: &rest)
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)
)

(instance invExit of HRIconItem
	(properties
		noun 90
		nsRight 184
		nsBottom 111
		x 165
		y 96
		signal 131
		mainView 951
		mainLoop 6
		helpVerb 68
	)

	(method (init)
		(super init: &rest)
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)
)

(instance invDown of HRIconItem
	(properties
		noun 94
		nsRight 157
		nsBottom 110
		x 141
		y 97
		signal 131
		mainView 951
		mainLoop 11
		helpVerb 68
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)

	(method (select &tmp [temp0 2])
		(if (!= (gInventory curPage:) (gInventory lastPage:))
			(gInventory eraseItems:)
			(gInventory drawInvItems: (+ (gInventory curPage:) 1))
		else
			(gMessager say: 0 0 17 1 0 15) ; "This is the last page of inventory."
		)
		(return 0)
	)
)

(instance invUp of HRIconItem
	(properties
		noun 94
		nsRight 156
		nsBottom 23
		x 142
		y 9
		signal 131
		mainView 951
		mainLoop 10
		helpVerb 68
	)

	(method (highlight param1 &tmp temp0)
		(if (== highlightColor -1)
			(return)
		)
		(= cel (if (and argc param1) 1 else 0))
		(UpdateScreenItem self)
	)

	(method (select &tmp [temp0 2])
		(if (!= (gInventory curPage:) 1)
			(gInventory eraseItems:)
			(gInventory drawInvItems: (- (gInventory curPage:) 1))
		else
			(gMessager say: 0 0 18 1 0 15) ; "This is the first page of inventory."
		)
		(return 0)
	)
)

(instance tweezers of GKInvItem
	(properties
		noun 12
		signal 2
		message 3
		mainView 940
		mainCel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 35) ; veil
			(cond
				((IsFlag 310)
					(gMessager say: 39 3 16 0 0 15) ; "Gabriel has already removed the scale from the veil."
				)
				((IsFlag 309)
					(gEgo getPoints: 196 2)
					(SetFlag 310)
					(gMessager say: 39 3 15 0 self 15) ; "Gabriel carefully uses the tweezers to remove the snake scale from the veil."
				)
				(else
					(gMessager say: 39 3 14 0 0 15) ; "Gabriel has no reason to use the tweezers on the veil at the moment."
				)
			)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance magGlass of GKInvItem
	(properties
		noun 11
		signal 2
		message 4
		mainView 940
		mainCel 1
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(26 ; musScale
				(if (not (IsFlag 201))
					(SetFlag 320)
					(gInventory hide:)
					(if (IsFlag 319)
						(gEgo getPoints: -999 3)
						(gEgo get: 25) ; twoScales
						(gEgo put: 23) ; musScale
						(gEgo put: 24) ; lakeScale
						(gMessager say: 5 4 4 0 self 15) ; "Gabriel magnifies the snake scale from the Voodoo Museum's python."
					else
						(gMessager say: 5 4 5 0 0 15) ; "Gabriel magnifies the snake scale from the Voodoo Museum's python."
					)
					((ScriptID 23 0) doit: 70 0 0 86 29 2 0 1) ; insetCode
				else
					(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
				)
				(return 1)
			)
			(20 ; lakeScale
				(if (not (IsFlag 201))
					(SetFlag 319)
					(gInventory hide:)
					(if (IsFlag 320)
						(gEgo getPoints: -999 3)
						(gEgo get: 25) ; twoScales
						(gEgo put: 23) ; musScale
						(gEgo put: 24) ; lakeScale
						(gMessager say: 1 4 1 0 self 15) ; "Gabriel magnifies the scale from the lake."
					else
						(gMessager say: 1 4 2 0 0 15) ; "Gabriel magnifies the scale from the lake."
					)
					((ScriptID 23 0) doit: 70 0 0 86 29 2 0 1) ; insetCode
				else
					(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
				)
				(return 1)
			)
			(51 ; twoScales
				(if (not (IsFlag 201))
					(gInventory hide:)
					((ScriptID 23 0) doit: 73 0 0 86 29 2 0 1) ; insetCode
				else
					(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
				)
				(return 1)
			)
			(21 ; snakeSkin_
				(gEgo getPoints: 195 1)
				(gInventory hide:)
				(cond
					((gEgo has: 24) ; lakeScale
						(= temp1 32)
					)
					((gEgo has: 25) ; twoScales
						(= temp1 35)
					)
					(else
						(= temp1 33)
					)
				)
				(gMessager say: 3 4 temp1 0 0 15)
				((ScriptID 23 0) doit: 98 0 0 86 29 3 0 1) ; insetCode
				(return 1)
			)
			(35 ; veil
				(gInventory hide:)
				(gMessager say: 39 4 0 0 0 15) ; "Gabriel examines the veil with the magnifying glass."
				((ScriptID 23 0) doit: 97 0 0 86 29 75 0 1) ; insetCode
				(return 1)
			)
			(22 ; fortScale_
				(gEgo getPoints: 197 1)
				(gInventory hide:)
				(cond
					((gEgo has: 24) ; lakeScale
						(= temp1 32)
					)
					((gEgo has: 25) ; twoScales
						(= temp1 35)
					)
					(else
						(= temp1 33)
					)
				)
				(gMessager say: 9 4 temp1 0 0 15)
				((ScriptID 23 0) doit: 72 0 0 86 29 10 0 1) ; insetCode
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		((ScriptID 23 1) dispose:) ; invInset
	)
)

(instance giftCert of GKInvItem
	(properties
		noun 28
		signal 2
		message 5
		mainView 940
		mainLoop 1
		mainCel 1
	)
)

(instance hundred of GKInvItem
	(properties
		noun 31
		signal 2
		message 32
		mainView 940
		mainLoop 1
		mainCel 5
	)
)

(instance phonePage of GKInvItem
	(properties
		noun 34
		signal 2
		message 49
		mainView 940
		mainLoop 1
		mainCel 8
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 58) ; invRead
			(gInventory hide:)
			((ScriptID 23 0) doit: 92 0 0 59 22 74 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wolfPhone of GKInvItem
	(properties
		noun 35
		signal 2
		message 38
		mainView 940
		mainLoop 1
		mainCel 9
	)
)

(instance news1810 of GKInvItem
	(properties
		noun 40
		signal 2
		message 41
		mainView 940
		mainLoop 2
	)
)

(instance guntJournal of GKInvItem
	(properties
		noun 43
		signal 2
		message 37
		mainView 940
		mainLoop 2
		mainCel 3
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 6) (== theVerb 58)) ; Open, invRead
			(gEgo getPoints: 199 1)
			(gInventory hide:)
			((ScriptID 23 0) doit: 50 0 0 42 24 79 0 0) ; insetCode
			(gMessager say: 79 7 0 0 self 15) ; "Gabriel reads through the pages Wolfgang marked. He reads of Gunter Ritter's journey to Charleston as Witch-hunter, hired by the townsmen to solve a series of ritualistic murders...."
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		((ScriptID 23 1) dispose:) ; invInset
	)
)

(instance ritLetter of GKInvItem
	(properties
		noun 26
		signal 2
		message 14
		mainView 940
		mainCel 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 282)
					(gMessager say: 26 7 11 0 0 15) ; "The letter is addressed to Heinz Ritter, Gabriel's grandfather."
				else
					(gMessager say: 26 7 12 0 0 15) ; "The letter is addressed to Heinz Ritter, whoever that is."
				)
				(return 1)
			)
			(58 ; invRead
				(gMessager say: 26 58 0 0 self 15) ; "The letter is written in German, but Gabriel determines what he can about it...."
				(SetFlag 50)
				(SetFlag 69)
			)
		)
		(return (super doVerb: theVerb &rest))
	)

	(method (cue)
		(gEgo getPoints: 194 1)
		(super cue: &rest)
	)
)

(instance mosLetter of GKInvItem
	(properties
		noun 49
		signal 2
		message 61
		mainView 940
		mainLoop 2
		mainCel 10
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 58) ; invRead
			(gEgo getPoints: 386 1)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance mosKey of GKInvItem
	(properties
		noun 50
		signal 2
		message 44
		mainView 940
		mainLoop 2
		mainCel 11
	)
)

(instance drumBook of GKInvItem
	(properties
		noun 41
		signal 2
		message 18
		mainView 940
		mainLoop 2
		mainCel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(if (or (== theVerb 58) (== theVerb 6)) ; invRead, Open
			(gInventory hide:)
			((ScriptID 23 0) doit: 5 0 0 92 52 77 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance murderPhoto of GKInvItem
	(properties
		noun 18
		signal 2
		message 17
		mainView 940
		mainCel 8
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide:)
			((ScriptID 23 0) doit: 26 0 0 87 48 93 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance gradPhoto of GKInvItem
	(properties
		noun 17
		signal 2
		message 50
		mainView 940
		mainCel 7
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide:)
			((ScriptID 23 0) doit: 25 0 0 87 48 92 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance policeVeve_ of GKInvItem
	(properties
		name {policeVeve }
		noun 22
		signal 2
		message 48
		mainView 940
		mainCel 12
	)

	(method (doVerb theVerb &tmp temp0)
		(if (or (== theVerb 58) (== theVerb 6)) ; invRead, Open
			(gInventory hide:)
			((ScriptID 23 0) doit: 91 0 0 97 22 72 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance veveCopy of GKInvItem
	(properties
		noun 23
		signal 2
		message 24
		mainView 940
		mainCel 13
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 58) ; invRead
			(gInventory hide:)
			((ScriptID 23 0) doit: 91 0 0 97 22 72 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance badge of GKInvItem
	(properties
		noun 27
		signal 2
		message 79
		mainView 940
		mainLoop 1
	)
)

(instance tracker of GKInvItem
	(properties
		noun 45
		signal 2
		message 45
		mainView 940
		mainLoop 2
		mainCel 6
	)
)

(instance crocMask of GKInvItem
	(properties
		noun 32
		signal 2
		message 31
		mainView 940
		mainLoop 1
		mainCel 6
	)
)

(instance oil of GKInvItem
	(properties
		noun 33
		signal 2
		message 46
		mainView 940
		mainLoop 1
		mainCel 7
	)
)

(instance musScale of GKInvItem
	(properties
		noun 5
		signal 2
		message 26
		mainView 940
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; magGlass
			(if (not (IsFlag 201))
				(SetFlag 320)
				(gInventory hide:)
				(if (IsFlag 319)
					(gEgo getPoints: -999 3)
					(gEgo get: 25) ; twoScales
					(gEgo put: 23) ; musScale
					(gEgo put: 24) ; lakeScale
					(gMessager say: 5 4 4 0 self 15) ; "Gabriel magnifies the snake scale from the Voodoo Museum's python."
				else
					(gMessager say: 5 4 5 0 0 15) ; "Gabriel magnifies the snake scale from the Voodoo Museum's python."
				)
				((ScriptID 23 0) doit: 70 0 0 86 29 2 0 1) ; insetCode
			else
				(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
			)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		((ScriptID 23 1) dispose:) ; invInset
	)
)

(instance lakeScale of GKInvItem
	(properties
		noun 1
		signal 2
		message 20
		mainView 940
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; magGlass
			(if (not (IsFlag 201))
				(SetFlag 319)
				(gInventory hide:)
				(if (IsFlag 320)
					(gEgo getPoints: -999 3)
					(gEgo get: 25) ; twoScales
					(gEgo put: 23) ; musScale
					(gEgo put: 24) ; lakeScale
					(gMessager say: 1 4 1 0 self 15) ; "Gabriel magnifies the scale from the lake."
				else
					(gMessager say: 1 4 2 0 0 15) ; "Gabriel magnifies the scale from the lake."
				)
				((ScriptID 23 0) doit: 70 0 0 86 29 2 0 1) ; insetCode
			else
				(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
			)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		((ScriptID 23 1) dispose:) ; invInset
	)
)

(instance twoScales of GKInvItem
	(properties
		noun 7
		signal 2
		message 51
		mainView 940
		mainLoop 2
		mainCel 5
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4) ; magGlass
			(if (not (IsFlag 201))
				(gInventory hide:)
				(gMessager say: 7 4 0 0 self 15) ; "Gabriel magnifies the two scales."
			else
				(gMessager say: 0 4 21 0 0 15) ; "Gabriel is already using the magnifying glass."
			)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (cue)
		((ScriptID 23 0) doit: 73 0 0 86 29 8 0 1) ; insetCode
	)
)

(instance tatooTrace of GKInvItem
	(properties
		noun 19
		signal 2
		message 30
		mainView 940
		mainCel 9
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 7) ; Look
			(gInventory hide:)
			((ScriptID 23 0) doit: 36 0 0 85 48 19 0 0) ; insetCode
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance keyEnvelope of GKInvItem
	(properties
		noun 48
		signal 2
		message 56
		mainView 940
		mainLoop 2
		mainCel 9
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(6 ; Open
				(gEgo getPoints: -999 1)
				(gMessager say: 48 6 0 1 self 15) ; "Gabriel opens the envelope and finds...."
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue &tmp temp0)
		(gInventory eraseItems:)
		(gEgo put: 27) ; keyEnvelope
		(self owner: 0)
		(self signal: (| (self signal:) $0004))
		(gEgo get: 29) ; mosLetter
		(gEgo get: 28) ; mosKey
		(gInventory drawInvItems: (gInventory curPage:))
		(FrameOut)
		(gMessager say: 48 6 0 2 0 15) ; "A note from Mosely and a small brass key."
	)
)

(instance clay of GKInvItem
	(properties
		noun 13
		signal 2
		message 28
		mainView 940
		mainCel 3
	)
)

(instance sketchBook of GKInvItem
	(properties
		noun 14
		signal 2
		message 15
		mainView 940
		mainCel 4
	)

	(method (doVerb theVerb &tmp temp0)
		(if (or (== theVerb 58) (== theVerb 6)) ; invRead, Open
			(gEgo getPoints: 462 1)
			(gInventory hide:)
			((ScriptID 23 0) doit: 15 0 0 39 23 69 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance phoEnvelope of GKInvItem
	(properties
		noun 15
		signal 2
		message 67
		mainView 940
		mainCel 5
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(6 ; Open
				(gEgo getPoints: -999 1)
				(gMessager say: 15 6 0 1 self 15) ; "Gabriel opens the manila envelope and finds...."
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue &tmp temp0)
		(gInventory eraseItems:)
		(gEgo put: 0) ; phoEnvelope
		(self owner: 0)
		(self signal: (| (self signal:) $0004))
		(gEgo get: 2) ; gradPhoto
		(gEgo get: 1) ; murderPhoto
		(gInventory drawInvItems: (gInventory curPage:))
		(FrameOut)
		(gMessager say: 15 6 0 2 0 15) ; "Two photographs."
	)
)

(instance sLakePatter of GKInvItem
	(properties
		noun 16
		signal 2
		message 23
		mainView 940
		mainCel 6
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 58) ; invRead
			(gInventory hide:)
			((ScriptID 23 0) doit: 35 0 0 87 48 82 0 0) ; insetCode
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance veil of GKInvItem
	(properties
		noun 39
		signal 2
		message 35
		mainView 940
		mainLoop 1
		mainCel 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(gInventory hide:)
				(gMessager say: 39 4 0 0 0 15) ; "Gabriel examines the veil with the magnifying glass."
				((ScriptID 23 0) doit: 97 0 0 86 29 75 0 1) ; insetCode
				(return 1)
			)
			(3 ; tweezers
				(cond
					((IsFlag 310)
						(gMessager say: 39 3 16 0 0 15) ; "Gabriel has already removed the scale from the veil."
					)
					((IsFlag 309)
						(gEgo getPoints: 196 2)
						(SetFlag 310)
						(gMessager say: 39 3 15 0 self 15) ; "Gabriel carefully uses the tweezers to remove the snake scale from the veil."
					)
					(else
						(gMessager say: 39 3 14 0 0 15) ; "Gabriel has no reason to use the tweezers on the veil at the moment."
					)
				)
				(return 1)
			)
			(7 ; Look
				(if (and (not (IsFlag 310)) (IsFlag 309))
					(gMessager say: 39 7 41 0 0 15) ; "The veil belongs to the fortuneteller. It's covered with shiny, iridescent sequins."
				else
					(gMessager say: 39 7 0 0 0 15) ; "The veil belongs to the fortuneteller. It's covered with shiny, iridescent sequins."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue &tmp temp0)
		(gInventory eraseItems:)
		(gEgo get: 43) ; fortScale
		(gInventory drawInvItems: (gInventory curPage:))
		(FrameOut)
		(gInventory curIcon: invSelect)
		(gInventory highlightedIcon: invSelect)
		(gGame setCursor: ((gInventory curIcon:) getCursor:))
	)
)

(instance inventWind of Plane
	(properties)
)

(instance windowCel of HRView
	(properties
		view 951
		loop 8
	)
)

(instance indicator of HRView
	(properties
		x 142
		y 20
		view 951
		loop 7
	)
)

