;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Print)
(use IconBar)
(use Window)
(use Inventory)
(use System)

(public
	gloryInv 0
	pageCode 1
	invLook 2
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp1 -32768)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(if (& global200 temp1)
			(gTheIconBar disable: temp0)
		)
		(>>= temp1 $0001)
	)
)

(class NumInvItem of InvI
	(properties
		signal 2
		modNum 16
		amount 0
		realOwner 0
		mustKeep 0
	)

	(method (init)
		(super init: &rest)
		(= cursor Cursor)
	)

	(method (select)
		(if (== local1 gEgo)
			(if (super select: &rest)
				(Cursor view: view loop: loop cel: cel)
			)
		else
			(self doVerb: 73 (gInventory indexOf: self))
			(gInventory highlightedIcon: invSelect)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 [temp3 20] [temp23 60])
		(Message msgGET 16 noun 1 0 1 @temp3)
		(= temp2 (gInventory indexOf: self))
		(cond
			((== gCurRoomNum 310)
				(= temp0 0)
			)
			((== gCurRoomNum 430)
				(= temp0 14)
			)
			(else
				(= temp0 14)
			)
		)
		(= temp1 (and (>= temp2 10) (< temp2 24)))
		(switch theVerb
			(1 ; Look
				(cond
					((== local1 gEgo)
						(if (> amount 1)
							(Message msgGET 16 0 theVerb 1 1 @temp23)
							(Print addTextF: @temp23 @temp3 amount value)
						else
							(Message msgGET 16 0 theVerb 2 1 @temp23)
							(Print addTextF: @temp23 @temp3 value)
						)
					)
					(
						(or
							(not temp1)
							(and
								(== [global331 (+ (- temp2 10) temp0)] 1)
								(== gCurRoomNum 310)
							)
							(and
								(== [global331 (+ (- temp2 10) temp0)] 1)
								(== gCurRoomNum 430)
							)
						)
						(Message msgGET 16 0 theVerb 3 1 @temp23)
						(Print addTextF: @temp23 @temp3)
					)
					(else
						(Message msgGET 16 0 theVerb 4 1 @temp23)
						(Print
							addTextF:
								@temp23
								@temp3
								(if (not temp1)
									amount
								else
									[global331 (+ (- temp2 10) temp0)]
								)
						)
					)
				)
				(Print init:)
				(Print addText: noun theVerb 0 2 0 0 16 init:)
			)
			(73 ; invDrop
				(if mustKeep
					(if (== temp2 46)
						(Print addText: 0 theVerb 5 1 0 0 16 init:) ; "You'd better hold on to the magic drum, someone might steal it."
					else
						(Message msgGET 16 0 theVerb 6 1 @temp23)
						(Print addTextF: @temp23 @temp3 init:)
					)
				else
					(if (== local1 gEgo)
						(if (> amount 1)
							(-- amount)
							(Message msgGET 16 0 theVerb 7 1 @temp23)
							(Print addTextF: @temp23 @temp3 init:)
							(self roomGets:)
						else
							(if (== (gTheIconBar curInvIcon:) self)
								(gTheIconBar disable: 7 curInvIcon: 0)
							)
							(Message msgGET 16 0 theVerb 8 1 @temp23)
							(Print addTextF: @temp3 init:)
							(self
								realOwner: gCurRoomNum
								loseItem:
								roomGets:
								checkPage:
							)
						)
						(if
							(and
								(<
									(+ (gEgo wtCarried:) value)
									(gEgo maxLoad:)
								)
								(IsFlag 5)
							)
							(ClearFlag 5)
							(gEgo setMotion: 0 changeGait: -1 0)
						)
						(return 1)
					else
						(gEgo get: temp2 1)
						(gTheIconBar curInvIcon: self enable: 7)
						(gInventory curIcon: 0)
						(if (and (>= temp2 10) (< temp2 24))
							(if (== [global331 (+ (- temp2 10) temp0)] 1)
								(= [global331 (+ (- temp2 10) temp0)] 0)
								(Message msgGET 16 0 theVerb 9 1 @temp23)
								(Print addTextF: @temp3 init:)
							else
								(-- [global331 (+ (- temp2 10) temp0)])
								(Message msgGET 16 0 theVerb 10 1 @temp23)
								(Print addTextF: @temp3 init:)
							)
						else
							(Message msgGET 16 0 theVerb 9 1 @temp23)
							(Print addTextF: @temp3 init:)
						)
						(= owner 0)
						(self checkPage:)
					)
					(return 1)
				)
			)
			(else
				(if (== local1 gEgo)
					(Print addText: 0 0 11 1 0 0 16 init:) ; "Nothing much happens."
				else
					(self doVerb: 73 (gInventory indexOf: self))
				)
			)
		)
	)

	(method (loseItem)
		(self owner: gCurRoomNum realOwner: gCurRoomNum amount: 0)
	)

	(method (roomGets &tmp temp0)
		(if (not (OneOf gCurRoomNum 310 430))
			(return)
		)
		(cond
			((== gCurRoomNum 310)
				(= temp0 0)
			)
			((== gCurRoomNum 430)
				(= temp0 14)
			)
			(else
				(= temp0 14)
			)
		)
		(if (and (>= (gInventory indexOf: self) 10) (< (gInventory indexOf: self) 24))
			(++ [global331 (- (+ (gInventory indexOf: self) temp0) 10)])
		else
			(self loseItem:)
		)
	)

	(method (checkPage &tmp temp0 temp1)
		(if (== local5 2)
			(= temp1 0)
			(for ((= temp0 0)) (< temp0 47) ((++ temp0))
				(if (== ((gInventory at: temp0) owner:) local1)
					(= temp1 1)
					(= temp0 48)
				)
			)
			(gInventory hide:)
			(if temp1
				(if (> temp0 47)
					(gInventory show: local1 selectIcon: invSelect)
				else
					(= local0 1)
					(invPageUp select:)
				)
			)
		else
			(gInventory hide:)
			(pageCode init: local1)
		)
	)
)

(instance gloryInv of Inv
	(properties
		normalHeading 9
		empty 27
	)

	(method (init)
		((= gInventory self)
			add:
				theRoyals
				theSword
				theFineDagger
				theFineSpear
				theChainmail
				theShield
				theGrapnel
				theToolkit
				theGuildCard
				theTinderbox
				theDaggers
				theCurePills
				theHealPills
				theManaPills
				theRations
				theWaterskin
				theDispell
				theFish
				theMeat
				theFruit
				theBeads
				theSkins
				theHorn
				theRocks
				theVine
				theOil
				theRope
				theGagGift
				thePin
				theHoney
				theFeather
				theAmulet
				theLeopard
				theBird
				theOpal
				theVineFruit
				theGem
				thePeaceWater
				theHeartGift
				theOrchid
				theRobe
				theBridge
				theEye
				theNote
				theWood
				theMagicSpear
				theMagicDrum
				invPageDown
				invPageUp
				invLook
				invSelect
				invDrop
				ok
				invHelp
				dummyIcon
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			state: 2048
		)
		(gEgo get: 0) ; theRoyals
		(gEgo get: 14) ; theRations
	)

	(method (hide)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
		(if window
			(window dispose:)
		)
	)

	(method (showSelf param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (gTheIconBar height:)
			(gTheIconBar hide:)
		)
		(if (not window)
			(= window (SysWindow new:))
		)
		(if (window window:)
			(window dispose:)
			(= window 0)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(if (not local5)
			(= curIcon 0)
		)
		(if (self show: (if argc param1 else gEgo))
			(if (not local5)
				(= temp2 (Cursor loop:))
				(= temp3 (Cursor cel:))
				(= local5 1)
				(self doit:)
				(= local5 0)
				(cond
					((and (IsObject curIcon) (curIcon isKindOf: NumInvItem))
						(if (not (gTheIconBar curInvIcon:))
							(gTheIconBar enable: (gTheIconBar useIconItem:))
						)
						(gTheIconBar
							curIcon:
								((gTheIconBar useIconItem:)
									cursor: (curIcon cursor:)
									yourself:
								)
							curInvIcon: curIcon
						)
						(if (= temp1 ((gTheIconBar curIcon:) cursor:))
							(gGame setCursor: temp1)
						)
					)
					((IsObject (gTheIconBar curInvIcon:))
						(= temp4 (gTheIconBar curInvIcon:))
						(Cursor
							view: (temp4 view:)
							loop: (temp4 loop:)
							cel: (temp4 cel:)
						)
					)
					(else
						(Cursor loop: temp2 cel: temp3)
					)
				)
				(= curIcon 0)
			else
				(while ((= temp0 ((gUser curEvent:) new:)) type:)
				)
			)
		)
	)

	(method (drawInvWindow param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 [temp23 50] [temp73 20])
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if ((= temp9 (NodeValue temp8)) isKindOf: InvI)
				(if (temp9 ownedBy: param1)
					(temp9 signal: (& (temp9 signal:) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							(+ 3 temp2)
						)
						(= temp2 (- temp6 3))
					)
					(if
						(>
							(= temp7
								(CelHigh
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							(+ 3 temp1)
						)
						(= temp1 (- temp7 3))
					)
				else
					(temp9 signal: (| (temp9 signal:) $0004))
				)
			else
				(++ temp3)
				(+= temp5 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(if
					(>
						(= temp7
							(CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:))
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
		)
		(if (== (dummyIcon owner:) param1)
			(-- temp0)
		)
		(if (not temp0)
			(return 0)
		)
		(if (<= temp0 6)
			(= temp17 1)
			(= temp11 temp0)
		else
			(if (and (> (= temp17 (Sqrt temp0)) 1) (>= (* temp17 temp17) temp0))
				(-- temp17)
			)
			(if (> temp17 3)
				(= temp17 3)
			)
			(= temp11 (/ temp0 temp17))
			(if (<= (* temp17 temp11) temp0)
				(++ temp11)
			)
			(if (> temp17 1)
				(cond
					((> temp11 8)
						(= temp11 8)
					)
					((< temp11 6)
						(= temp11 6)
					)
				)
			)
			(if (>= (* temp11 (- temp17 1)) temp0)
				(-- temp17)
			)
		)
		(= temp12 (Max (+ 4 temp5) (* temp11 (+ 1 temp2))))
		(= temp10 (* temp17 (+ 2 temp1)))
		(= temp13 (/ (- 190 temp10) 2))
		(= temp14 (/ (- 320 temp12) 2))
		(= temp15 (+ temp13 temp10))
		(= temp16 (+ temp14 temp12))
		(if (= temp22 (self window:))
			(temp22 top: temp13 left: temp14 right: temp16 bottom: temp15 open:)
		)
		(= temp21 temp11)
		(if temp0
			(= temp19
				(+
					2
					(if (temp22 respondsTo: #yOffset)
						(temp22 yOffset:)
					)
				)
			)
			(= temp20
				(= temp18
					(+
						2
						(if (temp22 respondsTo: #xOffset)
							(temp22 xOffset:)
						)
					)
				)
			)
			(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
				(if
					(and
						(not (& ((= temp9 (NodeValue temp8)) signal:) $0004))
						(temp9 isKindOf: InvI)
					)
					(if (not (& (temp9 signal:) $0080))
						(temp9
							nsLeft:
								(+
									temp18
									(/
										(-
											temp2
											(= temp6
												(CelWide
													(temp9 view:)
													(temp9 loop:)
													(temp9 cel:)
												)
											)
										)
										2
									)
								)
							nsTop:
								(+
									temp19
									(/
										(-
											temp1
											(= temp7
												(CelHigh
													(temp9 view:)
													(temp9 loop:)
													(temp9 cel:)
												)
											)
										)
										2
									)
								)
						)
						(temp9
							nsRight: (+ (temp9 nsLeft:) temp6)
							nsBottom: (+ (temp9 nsTop:) temp7)
						)
						(if (-- temp21)
							(+= temp18 temp2)
						else
							(= temp21 temp11)
							(+= temp19 temp1)
							(= temp18 temp20)
						)
					else
						(= temp18 (temp9 nsLeft:))
						(= temp19 (temp9 nsTop:))
					)
					(temp9 show:)
					(if (== temp9 param2)
						(temp9 highlight:)
					)
				)
			)
		)
		(= temp18 (/ (- (- (temp22 right:) (temp22 left:)) temp5) 2))
		(= temp10 (- (temp22 bottom:) (temp22 top:)))
		(= temp19 32767)
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if (not ((= temp9 (NodeValue temp8)) isKindOf: InvI))
				(= temp6 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(if (not (& (temp9 signal:) $0080))
					(if (== temp19 32767)
						(= temp19 (- temp10 temp7))
					)
					(temp9
						nsLeft: temp18
						nsTop: temp19
						nsBottom: temp10
						nsRight: (+ temp18 temp6)
					)
				)
				(= temp18 (+ (temp9 nsLeft:) temp6))
				(= temp19 (temp9 nsTop:))
				(temp9 signal: (& (temp9 signal:) $fffb) show:)
			)
		)
		(if (== param1 gEgo)
			(Message msgGET 16 0 0 25 1 @temp73) ; "Max Load: %d"
			(Display
				(Format @temp23 @temp73 (gEgo maxLoad:))
				dsFONT
				999
				dsCOORD
				(+ (/ temp12 2) 12)
				(- temp10 12)
				dsCOLOR
				(window color:)
			)
			(Message msgGET 16 0 0 26 1 @temp73) ; "Weight Carried: %d"
			(Display
				(Format @temp23 @temp73 (gEgo wtCarried:))
				dsFONT
				999
				dsCOORD
				2
				(- temp10 12)
				dsCOLOR
				(if (>= (gEgo wtCarried:) (gEgo maxLoad:))
					65
				else
					(window color:)
				)
			)
			(Graph
				grDRAW_LINE
				(- temp10 16)
				(+ (/ temp12 2) 10)
				(- temp10 6)
				(+ (/ temp12 2) 10)
				58
				-1
				-1
			)
			(Graph grDRAW_LINE (- temp10 16) 0 (- temp10 16) temp12 58 -1 -1)
			(Graph grUPDATE_BOX (- temp10 17) 0 temp10 temp12 1)
		)
		(dummyIcon
			nsTop: 0
			nsLeft: 0
			nsRight: (window right:)
			nsBottom: (window bottom:)
			owner: param1
			signal: 2
		)
		(return 1)
	)

	(method (advance &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
			(= temp0
				(self at: (mod (+ temp1 (self indexOf: highlightedIcon)) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self first:)))
			)
			(if (!= temp0 dummyIcon)
				(breakif (not (& (temp0 signal:) $0004)))
			)
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (retreat &tmp temp0 temp1)
		(for ((= temp1 1)) (<= temp1 size) ((= temp1 (mod (+ temp1 1) size)))
			(= temp0
				(self at: (mod (- (self indexOf: highlightedIcon) temp1) size))
			)
			(if (not (IsObject temp0))
				(= temp0 (NodeValue (self last:)))
			)
			(if (!= temp0 dummyIcon)
				(breakif (not (& (temp0 signal:) $0004)))
			)
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (noClickHelp)
		(super noClickHelp:)
		(gGame setCursor: 942 1)
	)
)

(instance invWin of GloryWindow
	(properties
		yOffset 28
	)

	(method (open)
		(invLook nsLeft: (- (/ (- (self right:) (self left:)) 2) 75))
		(+= bottom 15)
		(super open:)
	)
)

(instance pageCode of Code
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2)
		(if (not local5)
			(= local4 (gGame setCursor:))
		)
		(= local1 param1)
		(gInventory selectIcon: invSelect)
		(if (== local1 gEgo)
			(gInventory window: invWin)
			(invDrop noun: 5 loop: 6 signal: 1)
		else
			(if (== gCurRoomNum 310)
				(= temp2 0)
			else
				(= temp2 14)
			)
			(invDrop noun: 3 loop: 8 signal: 3)
		)
		(invSelect message: -1)
		(= global205 0)
		(invPageUp owner: 0)
		(invPageDown owner: 0)
		(for ((= temp0 0)) (< temp0 47) ((++ temp0))
			((gInventory at: temp0) owner: 0)
			(if
				(and
					(or
						(== ((gInventory at: temp0) realOwner:) local1)
						(and
							(!= local1 gEgo)
							(>= temp0 10)
							(< temp0 24)
							[global331 (+ (- temp0 10) temp2)]
						)
					)
					(< (++ global205) 25)
				)
				(if (== global205 24)
					(= temp1 temp0)
				)
				((gInventory at: temp0) owner: local1)
			)
		)
		(if (> global205 24)
			((gInventory at: temp1) owner: 0)
			(invPageDown highlightColor: -1 owner: local1)
		)
		(gInventory showSelf: local1)
	)
)

(instance dummyIcon of InvI
	(properties
		view 932
		loop 5
		cursor 942
		signal 2
	)

	(method (highlight))

	(method (show))

	(method (select)
		(return 0)
	)

	(method (onMe param1)
		(return
			(and
				(>= (param1 x:) nsLeft)
				(>= (param1 y:) nsTop)
				(<= (param1 x:) nsRight)
				(<= (param1 y:) nsBottom)
			)
		)
	)

	(method (doVerb)
		(return 0)
	)
)

(instance invPageDown of InvI
	(properties
		view 932
		loop 5
		cursor 942
		signal 3
		noun 1
		modNum 16
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 932 loop 2 (+ nsLeft (CelWide view loop cel)) nsTop -1)
	)

	(method (select &tmp temp0)
		(for ((= temp0 0)) (< temp0 47) ((++ temp0))
			(if (== ((gInventory at: temp0) realOwner:) local1)
				(if (== ((gInventory at: temp0) owner:) local1)
					((gInventory at: temp0) owner: 1)
				else
					((gInventory at: temp0) owner: local1)
				)
			)
		)
		(= local5 2)
		(invPageUp owner: local1 highlightColor: -1)
		(invPageDown owner: 0)
		(gInventory hide: showSelf: local1)
		(return 0)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 1) ; Look
			(self select:)
		else
			(Print addText: noun 1 0 1 0 0 16 init:) ; "Click here to see the rest of your stuff."
		)
	)
)

(instance invPageUp of InvI
	(properties
		view 932
		loop 5
		cursor 942
		signal 3
		noun 2
		modNum 16
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 932 loop 2 (+ nsLeft (CelWide view loop cel)) nsTop -1)
	)

	(method (select &tmp temp0)
		(for ((= temp0 0)) (< temp0 47) ((++ temp0))
			(if (== ((gInventory at: temp0) realOwner:) local1)
				(if (== ((gInventory at: temp0) owner:) 1)
					((gInventory at: temp0) owner: local1)
				else
					((gInventory at: temp0) owner: 0)
				)
			)
		)
		(= local5 1)
		(gInventory hide:)
		(invPageUp owner: 0)
		(if (not local0)
			(invPageDown owner: local1 highlightColor: -1)
		)
		(= local0 0)
		(gInventory showSelf: local1)
		(return 0)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 1) ; Look
			(self select:)
		else
			(Print addText: noun 1 0 1 0 0 16 init:) ; "Click here to see the rest of your stuff."
		)
	)
)

(instance invLook of IconI
	(properties
		view 932
		loop 2
		cel 0
		cursor 941
		message 1
		signal 129
		noun 3
		modNum 16
		helpVerb 9
	)

	(method (highlight)
		(if (== (invDrop noun:) noun)
			(invDrop highlight: &rest)
		)
		(super highlight: &rest)
	)
)

(instance invSelect of IconI
	(properties
		view 932
		loop 0
		cel 0
		cursor 942
		noun 4
		modNum 16
		helpVerb 9
	)
)

(instance invDrop of IconI
	(properties
		view 932
		loop 6
		cel 0
		cursor 944
		message 73
		noun 5
		modNum 16
		helpVerb 9
	)

	(method (onMe)
		(if (== noun 3)
			(return 0)
		else
			(super onMe: &rest)
		)
	)
)

(instance invHelp of IconI
	(properties
		view 932
		loop 1
		cel 0
		cursor 949
		message 9
		signal 3
		noun 6
		modNum 16
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 932 7 0 (- (+ nsLeft (CelWide view loop cel)) 28) nsTop -1)
	)
)

(instance ok of IconI
	(properties
		view 932
		loop 3
		cel 0
		cursor 942
		signal 67
		noun 7
		modNum 16
		helpVerb 9
	)
)

(instance theRoyals of NumInvItem
	(properties
		view 905
		loop 4
		cel 3
		message 59
		value 2
		mustKeep 1
	)

	(method (doVerb theVerb &tmp [temp0 30] [temp30 20] [temp50 20] [temp70 20] temp90 [temp91 20])
		(switch theVerb
			(1 ; Look
				(Format @temp30 {Dinars: %d.} global424)
				(if (== message 59)
					(Print addText: @temp30)
				else
					(= temp90 0)
					(if global424
						(Message msgGET 16 0 0 14 1 @temp30) ; "Dinars: %d"
						(Format @temp0 @temp30 global424)
						(Print addText: @temp0)
					)
					(if amount
						(Message msgGET 16 0 0 13 1 @temp50) ; "Royals: %d"
						(Format @temp0 @temp50 amount)
						(Print addText: @temp0 0 (+= temp90 10))
					)
					(if global410
						(Message msgGET 16 0 0 15 1 @temp70) ; "Commons: %d"
						(Format @temp0 @temp70 global410)
						(Print addText: @temp0 0 (+= temp90 10))
					)
					(if (or global424 amount global410)
						(Message msgGET 16 0 0 17 1 @temp91) ; "Total Weight: %d"
						(Format @temp0 @temp91 (+ global424 amount global410))
						(Print addText: @temp0 0 (+= temp90 15))
					else
						(Print addText: 0 10 12 1 0 0 16) ; "You're flat broke."
					)
				)
				(Print init:)
				(Print addText: 0 theVerb 27 1 0 0 16 init:) ; "This simple money pouch contains all the money you have with you."
			)
			(73 ; invDrop
				(Print addText: 0 73 16 1 0 0 16 init:) ; "You need your money pouch."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSword of NumInvItem
	(properties
		view 905
		loop 2
		message 11
		noun 54
		value 420
		mustKeep 1
	)

	(method (doVerb theVerb &tmp [temp0 30] [temp30 160])
		(switch theVerb
			(1 ; Look
				(Message msgGET 16 0 theVerb 2 1 @temp30)
				(if state
					(Message msgGET 16 0 1 18 1 @temp0) ; "Magical Sword"
				else
					(Message msgGET 16 0 1 19 1 @temp0) ; "Sword"
				)
				(Print addTextF: @temp30 @temp0 value init:)
				(if state
					(Print addText: 0 theVerb 18 2 0 0 16 init:) ; "This magical sword has powerful combat and defensive abilities in the hands of a sufficiently honorable Paladin."
				else
					(Print addText: 0 theVerb 19 2 0 0 16 init:) ; "This is a fine weapon, well balanced and tempered and very, very sharp."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theFineDagger of NumInvItem
	(properties
		view 905
		loop 6
		cel 1
		message 12
		noun 8
		value 60
		mustKeep 1
	)
)

(instance theFineSpear of NumInvItem
	(properties
		view 905
		loop 10
		cel 4
		message 13
		noun 9
		value 240
	)
)

(instance theChainmail of NumInvItem
	(properties
		view 905
		loop 2
		cel 1
		message 14
		noun 10
		value 2100
		mustKeep 1
	)
)

(instance theShield of NumInvItem
	(properties
		view 905
		loop 2
		cel 2
		message 15
		noun 11
		value 720
		mustKeep 1
	)
)

(instance theGrapnel of NumInvItem
	(properties
		view 905
		loop 2
		cel 7
		message 16
		noun 12
		value 80
		mustKeep 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 36) ; theRope
			(theRope owner: 0 realOwner: 0)
			(= cel 8)
			(= state 1)
			(= noun 56)
			(gInventory curIcon: self)
			(self select: checkPage:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theToolkit of NumInvItem
	(properties
		view 905
		loop 4
		cel 2
		message 17
		noun 22
		value 30
	)
)

(instance theGuildCard of NumInvItem
	(properties
		view 905
		loop 4
		message 18
		noun 23
		value 2
	)
)

(instance theTinderbox of NumInvItem
	(properties
		view 905
		loop 6
		message 19
		noun 24
		value 5
		mustKeep 1
	)
)

(instance theDaggers of NumInvItem
	(properties
		view 905
		loop 4
		cel 1
		message 20
		noun 25
		value 90
	)
)

(instance theCurePills of NumInvItem
	(properties
		view 905
		cel 5
		message 21
		noun 26
		value 5
	)
)

(instance theHealPills of NumInvItem
	(properties
		view 905
		cel 6
		message 22
		noun 27
		value 5
	)
)

(instance theManaPills of NumInvItem
	(properties
		view 905
		cel 7
		message 23
		noun 28
		value 5
	)
)

(instance theRations of NumInvItem
	(properties
		view 905
		cel 1
		message 24
		noun 29
		value 20
	)
)

(instance theWaterskin of NumInvItem
	(properties
		view 905
		loop 6
		cel 5
		message 25
		noun 30
		value 20
	)
)

(instance theDispell of NumInvItem
	(properties
		view 905
		cel 8
		message 26
		noun 31
		value 40
	)
)

(instance theFish of NumInvItem
	(properties
		view 905
		loop 4
		cel 6
		message 27
		noun 32
		value 20
	)
)

(instance theMeat of NumInvItem
	(properties
		view 905
		loop 4
		cel 7
		message 28
		noun 33
		value 20
	)
)

(instance theFruit of NumInvItem
	(properties
		view 905
		loop 4
		cel 8
		message 29
		noun 34
		value 20
	)
)

(instance theBeads of NumInvItem
	(properties
		view 905
		loop 6
		cel 3
		message 30
		noun 35
		value 10
	)
)

(instance theSkins of NumInvItem
	(properties
		view 905
		loop 10
		cel 3
		message 31
		noun 36
		value 120
	)
)

(instance theHorn of NumInvItem
	(properties
		view 905
		loop 10
		cel 2
		message 32
		noun 37
		value 40
	)
)

(instance theRocks of NumInvItem
	(properties
		view 905
		cel 2
		message 33
		noun 38
		value 30
	)
)

(instance theVine of NumInvItem
	(properties
		view 905
		loop 10
		cel 8
		message 34
		noun 39
		value 30
	)
)

(instance theOil of NumInvItem
	(properties
		view 905
		loop 6
		cel 4
		message 35
		noun 40
		value 30
		mustKeep 1
	)
)

(instance theRope of NumInvItem
	(properties
		view 905
		loop 6
		cel 2
		message 36
		noun 41
		value 200
		mustKeep 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; theGrapnel
			(= realOwner (= owner 0))
			(gInventory curIcon: theGrapnel)
			(theGrapnel noun: 56 cel: 8 state: 1 select:)
			(self checkPage:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theGagGift of NumInvItem
	(properties
		view 905
		loop 2
		cel 4
		message 37
		noun 53
		value 30
		mustKeep 1
	)

	(method (select)
		(if (super select: &rest)
			(if (== cel 4)
				(cond
					(((ScriptID gCurRoomNum) script:)
						(Print addText: 51 0 22 0 0 0 16 init:) ; "You decide to wait until a quiet moment to open this gift."
						(return 0)
					)
					((> (gEgo view:) 5)
						(Print addText: 51 0 23 0 0 0 16 init:) ; "This is not the best place to use that."
						(return 0)
					)
					(else
						(= cel 6)
						(= value 5)
						(gInventory curIcon: ok)
						(if (== (gTheIconBar curInvIcon:) self)
							(gTheIconBar curInvIcon: 0 disable: 7)
						)
						(gInventory hide:)
						((ScriptID gCurRoomNum) setScript: (ScriptID 30)) ; giftScript
						(return 0)
					)
				)
			else
				(gInventory curIcon: ok)
				(gInventory hide:)
				(if (== (gTheIconBar curInvIcon:) self)
					(gTheIconBar curInvIcon: 0 disable: 7 advanceCurIcon:)
				)
				(HandsOff)
				(gEgo learn: 30 solvePuzzle: 206 4 2) ; jugglingLightsSpell
				(gMessager say: 51 0 24 0 0 16) ; "That's certainly an interesting wrapping paper design. In fact, as you look at it more carefully, you realize that a spell is written on it. You read the spell and the paper disappears. You now know the Juggling Lights spell."
				(self mustKeep: 0 loseItem: realOwner: 0 owner: 0)
				(HandsOn)
				(localproc_0)
			)
		)
	)

	(method (doVerb theVerb &tmp [temp0 30] [temp30 160])
		(switch theVerb
			(1 ; Look
				(Message msgGET 16 0 theVerb 2 1 @temp30)
				(if (== cel 4)
					(Message msgGET 16 53 1 29 1 @temp0) ; "Gift"
				else
					(Message msgGET 16 53 1 28 1 @temp0) ; "Wrapping Paper"
				)
				(Print addTextF: @temp30 @temp0 value init:)
				(if (== cel 4)
					(Print addText: 53 1 29 2 0 0 16 init:) ; "This is the gift you received from Keapon, the magic shop owner in Shapeir."
				else
					(Print addText: 53 1 28 2 0 0 16 init:) ; "The wrapping paper is all that remains of Keapon Laffin's gift. He certainly has a strange idea of humor."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePin of NumInvItem
	(properties
		view 905
		cel 3
		message 39
		noun 42
		value 2
	)
)

(instance theHoney of NumInvItem
	(properties
		view 905
		loop 4
		cel 4
		message 40
		noun 43
		value 20
		mustKeep 1
	)
)

(instance theFeather of NumInvItem
	(properties
		view 905
		loop 4
		cel 5
		message 41
		noun 44
		value 2
	)
)

(instance theAmulet of NumInvItem
	(properties
		view 905
		loop 6
		cel 6
		message 42
		noun 45
		value 10
	)
)

(instance theLeopard of NumInvItem
	(properties
		view 905
		loop 6
		cel 7
		message 43
		noun 46
		value 30
		mustKeep 1
	)
)

(instance theBird of NumInvItem
	(properties
		view 905
		loop 6
		cel 8
		message 44
		noun 47
		value 30
		mustKeep 1
	)
)

(instance theOpal of NumInvItem
	(properties
		view 905
		loop 8
		message 45
		noun 48
		value 6
		mustKeep 1
	)
)

(instance theVineFruit of NumInvItem
	(properties
		view 905
		loop 8
		cel 1
		message 46
		noun 49
		value 20
		mustKeep 1
	)
)

(instance theGem of NumInvItem
	(properties
		view 905
		loop 8
		cel 2
		message 47
		noun 50
		value 6
		mustKeep 1
	)
)

(instance thePeaceWater of NumInvItem
	(properties
		view 905
		loop 8
		cel 4
		message 48
		noun 13
		value 80
	)
)

(instance theHeartGift of NumInvItem
	(properties
		view 905
		loop 8
		cel 5
		message 49
		noun 14
		value 20
		mustKeep 1
	)
)

(instance theOrchid of NumInvItem
	(properties
		view 905
		loop 8
		cel 6
		message 50
		noun 55
		value 12
		mustKeep 1
	)

	(method (doVerb theVerb &tmp [temp0 30] [temp30 160])
		(switch theVerb
			(1 ; Look
				(Message msgGET 16 0 theVerb 2 1 @temp30)
				(if state
					(Message msgGET 16 0 1 21 1 @temp0) ; "Glowing Blue Orchid"
				else
					(Message msgGET 16 0 1 20 1 @temp0) ; "Blue Orchid"
				)
				(Print addTextF: @temp30 @temp0 value init:)
				(if state
					(Print addText: 0 theVerb 21 2 0 0 16 init:) ; "This orchid now glows with a magical aura."
				else
					(Print addText: 0 theVerb 20 2 0 0 16 init:) ; "This is a lovely flower which smells vaguely like vanilla."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRobe of NumInvItem
	(properties
		view 905
		loop 10
		cel 5
		message 51
		noun 15
		value 30
		mustKeep 1
	)
)

(instance theBridge of NumInvItem
	(properties
		view 905
		loop 10
		cel 6
		message 52
		noun 16
		value 300
	)
)

(instance theEye of NumInvItem
	(properties
		view 905
		loop 10
		cel 7
		message 53
		noun 17
		value 6
		mustKeep 1
	)
)

(instance theNote of NumInvItem
	(properties
		view 905
		message 54
		noun 18
		value 2
	)
)

(instance theWood of NumInvItem
	(properties
		view 905
		loop 8
		cel 8
		message 55
		noun 19
		value 60
		mustKeep 1
	)
)

(instance theMagicSpear of NumInvItem
	(properties
		view 905
		loop 10
		message 56
		noun 20
		value 240
		mustKeep 1
	)
)

(instance theMagicDrum of NumInvItem
	(properties
		view 905
		loop 10
		cel 1
		message 57
		noun 21
		value 180
		mustKeep 1
	)
)

