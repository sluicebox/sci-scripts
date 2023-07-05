;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Print)
(use BorderWindow)
(use IconBar)
(use Sound)
(use Inventory)
(use System)

(public
	fpInv 0
	invWin 1
	resetInv 2
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(class FPIconItem of IconI
	(properties)

	(method (ownedBy)
		(return 0)
	)
)

(class FPInvItem of InvI
	(properties
		realOwner 0
	)

	(method (ownedBy param1)
		(return (or (== owner param1) (== realOwner param1)))
	)

	(method (init)
		(= lowlightColor 19)
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if
			(not
				(OneOf
					name
					{Med 1}
					{Med 2}
					{Med 3}
					{Incorrect Med}
					{Incorrect Med2}
					{Correct Rx}
				)
			)
			(gNarrator name: name showTitle: 1)
		)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun 1 0 0 0 15)
			)
			((not (OneOf theVerb 3 4 2 7 8)) ; ???, Do, Talk, ???, icon10
				(sHuh play:)
				(Wait 5)
				(= temp0 (gGame setCursor: 5))
				(Wait 30)
				(gGame setCursor: temp0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(switch local1
			(1
				(Neckerchief view: 996)
				(gInventory hide:)
				(gInventory show:)
				(gMessager say: 58 4 25 0 self 15) ; "Now you don't!"
				(++ local1)
			)
			(2
				(gMessager say: 58 4 26 0 self 15) ; "Just kidding."
				(Neckerchief view: 92 loop: 1 cel: 0)
				(= local1 0)
			)
			(else
				(gInventory hide:)
				(gInventory show:)
			)
		)
	)
)

(instance resetInv of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(= local3 param1)
		(for ((= temp0 (= temp2 0))) (< temp0 61) ((++ temp0))
			(if
				(or
					(== ((= temp1 (gInventory at: temp0)) owner:) local3)
					(== (temp1 realOwner:) local3)
				)
				(++ temp3)
				(temp1 realOwner: local3 owner: 0)
				(if (<= (++ temp2) 8)
					(temp1 owner: local3)
					(= local2 temp0)
				)
			)
		)
		(if (<= temp3 8)
			(invMore loop: 6)
		else
			(invMore loop: 5)
		)
	)
)

(instance fpInv of Inv
	(properties
		normalHeading 9
		empty 27
	)

	(method (init)
		(= gInventory self)
		(self
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add:
				Baking_Soda
				Beer
				Boots
				Bullets
				Candle_Wax
				Charcoal
				Church_Key
				Claim_Check
				Clay
				Cleaning_Kit
				Clothes
				Coffee
				Correct_Rx
				Deflatulizer
				Deposit_Key
				Desk_Key
				Door_Key
				Elixir
				Empty_Bottles
				Empty_Mold
				Filled_Sack
				Gas_Mask
				Helen_s_Rx
				Horse_Plop
				Ice_Pick
				Incorrect_Med
				Incorrect_Med2
				Knife
				Ladder
				Lasso
				Leather_Strap
				Letter
				Madame_s_Rx
				Medallion
				Med_1
				Med_2
				Med_3
				Money
				Neckerchief
				Nitrous_Oxide
				Open_Beer
				Paper_Sack
				Penelope_s_Rx
				Pie
				Pistols
				Post_Cards
				Prep_G
				Pure_Solution
				Rope
				Sharp_Ear
				Shot_Glass
				Shovel
				Silver_Ear
				Silver_Filled_Mold
				Snails
				Sword
				Tin_Can
				Tower_H20
				Under_Glass
				Wax_Ear
				Wax_Filled_Mold
				invLook
				invHand
				invSelect
				invHelp
				invMore
				ok
			eachElementDo: #highlightColor 37
			eachElementDo: #lowlightColor 33
			eachElementDo: #modNum 15
			eachElementDo: #init
			state: 2048
		)
	)

	(method (hide)
		(= highlightedIcon 0)
		(super hide:)
	)

	(method (drawInvWindow param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 [temp22 50])
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if ((= temp9 (NodeValue temp8)) isKindOf: InvI)
				(if (== (temp9 owner:) param1)
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
							temp2
						)
						(= temp2 temp6)
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
							temp1
						)
						(= temp1 temp7)
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
		(if (not temp0)
			(Print addTextF: {%s %s} normalHeading empty init:)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3)
			(= temp16 3)
		)
		(= local4 (/ temp0 temp16))
		(if (< (* temp16 local4) temp0)
			(++ local4)
		)
		(= temp10 (Max (+ 4 temp5) (* local4 (+ 4 temp2))))
		(= temp11 (* temp16 (+ 4 temp1)))
		(= temp12 (/ (- 190 temp11) 2))
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= temp21 (self window:))
			(temp21 top: temp12 left: temp13 right: temp15 bottom: temp14 open:)
		)
		(= temp20 local4)
		(if temp0
			(= temp18
				(+
					2
					(if (temp21 respondsTo: #yOffset)
						(temp21 yOffset:)
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if (temp21 respondsTo: #xOffset)
							(temp21 xOffset:)
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
									temp17
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
									temp18
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
						(if (-- temp20)
							(+= temp17 temp2)
						else
							(= temp20 local4)
							(+= temp18 temp1)
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 nsLeft:))
						(= temp18 (temp9 nsTop:))
					)
					(temp9 show:)
					(if (== temp9 param2)
						(temp9 highlight:)
					)
				)
			)
		)
		(= temp17 (/ (- (- (temp21 right:) (temp21 left:)) temp5) 2))
		(= temp11 (- (temp21 bottom:) (temp21 top:)))
		(= temp18 32767)
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if (not ((= temp9 (NodeValue temp8)) isKindOf: InvI))
				(temp9 nsTop: 0)
				(= temp6 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(if (not (& (temp9 signal:) $0080))
					(if (== temp18 32767)
						(= temp18 (- temp11 temp7))
					)
					(temp9
						nsLeft: temp17
						nsTop: temp18
						nsBottom: temp11
						nsRight: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 nsLeft:) temp6))
				(= temp18 (temp9 nsTop:))
				(temp9 signal: (& (temp9 signal:) $fffb) show:)
			)
		)
		(return 1)
	)
)

(instance invWin of InsetWindow
	(properties
		topBordHgt 28
		botBordHgt 5
	)

	(method (open &tmp temp0 temp1 temp2)
		(= temp0 0)
		(for
			((= temp1 (gInventory first:)))
			temp1
			((= temp1 (gInventory next: temp1)))
			
			(if (not ((= temp2 (NodeValue temp1)) isKindOf: InvI))
				(+= temp0 (CelWide (temp2 view:) (temp2 loop:) (temp2 cel:)))
			)
		)
		(super open:)
		(invLook nsLeft: (/ (- (- right left) temp0) 2))
	)
)

(instance ok of FPIconItem
	(properties
		view 991
		loop 3
		cel 0
		cursor 999
		signal 67
		noun 17
		helpVerb 7
	)
)

(instance invLook of FPIconItem
	(properties
		view 991
		loop 2
		cel 0
		cursor 1
		message 1
		signal 129
		noun 16
		helpVerb 7
	)
)

(instance invHand of FPIconItem
	(properties
		view 991
		loop 0
		cel 0
		cursor 2
		message 4
		noun 14
		helpVerb 7
	)
)

(instance invHelp of FPIconItem
	(properties
		view 991
		loop 1
		cel 0
		cursor 9
		message 7
		signal 3
		noun 15
		helpVerb 7
	)
)

(instance invSelect of FPIconItem
	(properties
		view 991
		loop 4
		cel 0
		cursor 999
		noun 18
		helpVerb 7
	)
)

(instance invMore of FPIconItem
	(properties
		view 991
		loop 5
		cel 0
		cursor 999
		signal 3
		maskView 991
		noun 43
		helpVerb 7
	)

	(method (highlight)
		(if (== loop 5)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(if (and (super select: &rest) (== loop 5))
			(for ((= temp0 0)) (<= temp0 local2) ((++ temp0))
				(if (== ((= temp2 (gInventory at: temp0)) owner:) local3)
					(temp2 realOwner: local3 owner: 0)
				)
			)
			(= temp3 0)
			(= temp1 local2)
			(while (< temp0 61)
				(if
					(and
						(== ((= temp2 (gInventory at: temp0)) realOwner:) local3)
						(<= (++ temp3) 8)
					)
					(temp2 owner: local3)
					(= local2 temp0)
				)
				(++ temp0)
			)
			(if (== temp1 local2)
				(resetInv doit: local3)
			)
			(gInventory hide: highlightedIcon: 0 show: local3)
			(return 0)
		)
	)
)

(instance Door_Key of FPInvItem
	(properties
		name {Door Key}
		view 40
		loop 1
		cursor 40
		message 9
		signal 2
		noun 47
	)
)

(instance Penelope_s_Rx of FPInvItem
	(properties
		name {Penelope's Rx}
		view 41
		loop 1
		cursor 41
		message 10
		signal 2
		noun 1
	)
)

(instance Med_1 of FPInvItem
	(properties
		name {Med 1}
		view 42
		loop 1
		cursor 42
		message 11
		signal 2
		noun 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(gNarrator name: {Medication} showTitle: 1)
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Helen_s_Rx of FPInvItem
	(properties
		name {Helen's Rx}
		view 43
		loop 1
		cursor 43
		message 12
		signal 2
		noun 2
	)
)

(instance Med_2 of FPInvItem
	(properties
		name {Med 2}
		view 44
		loop 1
		cursor 44
		message 13
		signal 2
		noun 6
	)

	(method (doVerb theVerb)
		(gNarrator name: {Medication} showTitle: 1)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Madame_s_Rx of FPInvItem
	(properties
		name {Madame's Rx}
		view 45
		loop 1
		cursor 45
		message 14
		signal 2
		noun 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; Shot_Glass
				(gNarrator name: name showTitle: 1)
				(if (or (IsFlag 20) (IsFlag 21) (IsFlag 45))
					(gMessager say: 10 0 28 0 0 15) ; "You're too precariously balanced to juggle paper and glass. Get on solid ground first!"
				else
					(gInventory hide:)
					(gCurRoom newRoom: 680)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Shot_Glass of FPInvItem
	(properties
		name {Shot Glass}
		view 46
		loop 1
		cursor 46
		message 15
		signal 2
		noun 8
	)
)

(instance Under_Glass of FPInvItem
	(properties
		name {Under Glass}
		view 47
		loop 1
		cursor 47
		message 16
		signal 2
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator name: name showTitle: 1)
				(if (or (IsFlag 20) (IsFlag 21) (IsFlag 45))
					(gMessager say: 10 0 28 0 0 15) ; "You're too precariously balanced to juggle paper and glass. Get on solid ground first!"
				else
					(gInventory hide:)
					(gCurRoom newRoom: 680)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Correct_Rx of FPInvItem
	(properties
		name {Correct Rx}
		view 48
		loop 1
		cursor 48
		message 17
		signal 2
		noun 11
	)

	(method (doVerb theVerb)
		(gNarrator name: {Madame's Rx} showTitle: 1)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Med_3 of FPInvItem
	(properties
		name {Med 3}
		view 49
		loop 1
		cursor 49
		message 18
		signal 2
		noun 7
	)

	(method (doVerb theVerb)
		(gNarrator name: {Medication} showTitle: 1)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Incorrect_Med of FPInvItem
	(properties
		name {Incorrect Med}
		view 50
		loop 1
		cursor 50
		message 71
		signal 2
		noun 71
	)

	(method (doVerb theVerb)
		(gNarrator name: {Medication} showTitle: 1)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Incorrect_Med2 of FPInvItem
	(properties
		name {Incorrect Med2}
		view 99
		loop 1
		cursor 99
		message 83
		signal 2
		noun 70
	)

	(method (doVerb theVerb)
		(gNarrator name: {Medication} showTitle: 1)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Prep_G of FPInvItem
	(properties
		name {Prep G}
		view 51
		loop 1
		cursor 51
		message 20
		signal 2
		noun 13
	)
)

(instance Tower_H20 of FPInvItem
	(properties
		name {Tower H20}
		view 54
		loop 1
		cursor 54
		message 23
		signal 2
		noun 21
	)
)

(instance Tin_Can of FPInvItem
	(properties
		name {Tin Can}
		view 55
		loop 1
		cursor 55
		message 24
		signal 2
		noun 22
	)

	(method (doVerb theVerb)
		(= local5 0)
		(gNarrator name: name showTitle: 1)
		(switch theVerb
			(25 ; Ice_Pick
				((gInventory at: 24) owner: gEgo) ; Ice_Pick
				(gEgo put: 24) ; Ice_Pick
				(gInventory curIcon: 0)
				(SetFlag 55)
				(if (== (++ local0) 3)
					((gInventory at: 56) owner: gEgo) ; Tin_Can
					(gEgo put: 56) ; Tin_Can
					(gEgo get: -1 21) ; Gas_Mask
					((gInventory at: 21) owner: gEgo) ; Gas_Mask
					(= gCurPuzzle 9)
					((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
					(if
						(not
							(OneOf
								gCurRoomNum
								410
								600
								610
								620
								630
								640
								650
								660
								670
								690
								710
								720
								730
							)
						)
						((ScriptID 0 14) setReal: (ScriptID 0 14) 40) ; gasMaskTimer, gasMaskTimer
					)
				)
				(gMessager say: noun theVerb 0 0 self 15) ; "With all the precision of a serial killer, you deftly poke some holes in the tin can with the ice pick. Hah!"
				(= local5 1)
			)
			(26 ; Charcoal
				((gInventory at: 5) owner: gEgo) ; Charcoal
				(gEgo put: 5) ; Charcoal
				(SetFlag 17)
				(gInventory curIcon: 0)
				(SetFlag 57)
				(if (== (++ local0) 3)
					((gInventory at: 56) owner: gEgo) ; Tin_Can
					(gEgo put: 56) ; Tin_Can
					(gEgo get: -1 21) ; Gas_Mask
					((gInventory at: 21) owner: gEgo) ; Gas_Mask
					(= gCurPuzzle 9)
					((ScriptID 0 13) setReal: (ScriptID 0 13) 0 10) ; deathTimer, deathTimer
					(if
						(not
							(OneOf
								gCurRoomNum
								410
								600
								610
								620
								630
								640
								650
								660
								670
								690
								710
								720
								730
							)
						)
						((ScriptID 0 14) setReal: (ScriptID 0 14) 40) ; gasMaskTimer, gasMaskTimer
					)
				)
				(gMessager say: noun theVerb 0 0 self 15) ; "You drop the charcoal into tin can. Now we're gettin' somewhere!"
				(= local5 2)
			)
			(27 ; Leather_Strap
				(if (IsFlag 55)
					((gInventory at: 30) owner: gEgo) ; Leather_Strap
					(gEgo put: 30) ; Leather_Strap
					(SetFlag 56)
					(gInventory curIcon: 0)
					(= cursor (= view 59))
					(if (== (++ local0) 3)
						((gInventory at: 56) owner: gEgo) ; Tin_Can
						(gEgo put: 56) ; Tin_Can
						(gEgo get: -1 21) ; Gas_Mask
						((gInventory at: 21) owner: gEgo) ; Gas_Mask
						(= gCurPuzzle 9)
						((ScriptID 0 13) setReal: (ScriptID 0 13) 0 10) ; deathTimer, deathTimer
						(if
							(not
								(OneOf
									gCurRoomNum
									410
									600
									610
									620
									630
									640
									650
									660
									670
									690
									710
									720
									730
								)
							)
							((ScriptID 0 14) setReal: (ScriptID 0 14) 40) ; gasMaskTimer, gasMaskTimer
						)
					)
					(gInventory curIcon: 0)
					(gMessager say: noun theVerb 0 0 self 15) ; "You slip the leather strap through the holes in the tin can. They fit perfectly. Congrats! You've always wanted a tin feed bag!"
					(= local5 3)
				else
					(gMessager say: noun theVerb 21 0 0 15) ; "The leather strap just won't fit through the holes in the tin can... because there ARE no holes in the tin can!"
				)
			)
			(1 ; Look
				(cond
					((and (IsFlag 55) (IsFlag 56))
						(gMessager say: noun 1 16 0 0 15) ; "The tin can, riddled with holes from your trusty ice pick, has a leather strap threaded through two of the holes."
					)
					((and (IsFlag 57) (IsFlag 56))
						(gMessager say: noun 1 17 0 0 15) ; MISSING MESSAGE
					)
					((and (IsFlag 57) (IsFlag 55))
						(gMessager say: noun 1 18 0 0 15) ; "The hole-ridden tin can is now chock full of charcoal."
					)
					((IsFlag 55)
						(gMessager say: noun 1 14 0 0 15) ; "You've poked major holes in the tin can!"
					)
					((IsFlag 56)
						(gMessager say: noun 1 19 0 0 15) ; MISSING MESSAGE
					)
					((IsFlag 57)
						(gMessager say: noun 1 20 0 0 15) ; "This tin can is full'a charcoal."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(switch local5
			(1
				(gGame points: 5)
			)
			(2
				(gGame points: 3)
			)
			(3
				(gGame points: 5)
			)
		)
		(super cue:)
	)
)

(instance Ice_Pick of FPInvItem
	(properties
		name {Ice Pick}
		view 56
		loop 1
		cursor 56
		message 25
		signal 2
		noun 24
	)
)

(instance Charcoal of FPInvItem
	(properties
		view 57
		loop 1
		cursor 57
		message 26
		signal 2
		noun 4
	)
)

(instance Leather_Strap of FPInvItem
	(properties
		name {Leather Strap}
		view 58
		loop 1
		cursor 58
		message 27
		signal 2
		noun 25
	)
)

(instance Gas_Mask of FPInvItem
	(properties
		name {Gas Mask}
		view 59
		loop 1
		cursor 59
		message 28
		signal 2
		noun 26
	)
)

(instance Deflatulizer of FPInvItem
	(properties
		view 60
		loop 1
		cursor 60
		message 29
		signal 2
		noun 27
	)
)

(instance Snails of FPInvItem
	(properties
		view 61
		loop 1
		cursor 61
		message 30
		signal 2
		noun 28
	)

	(method (doVerb theVerb)
		(gNarrator name: name showTitle: 1)
		(switch theVerb
			(33 ; Open_Beer
				(gMessager say: noun theVerb 0 0 self 15) ; "You pour a small amount of beer on the snails. They quickly begin to weave around uncertainly, as if... as if they were DRUNK! How bizarre!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Money of FPInvItem
	(properties
		view 62
		loop 1
		cursor 62
		message 31
		signal 2
		noun 29
	)
)

(instance Beer of FPInvItem
	(properties
		view 63
		loop 1
		cursor 63
		message 32
		signal 2
		noun 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; Church_Key
				(gNarrator name: name showTitle: 1)
				((gInventory at: 1) owner: gEgo) ; Beer
				(gEgo put: 1 get: -1 40) ; Beer, Open_Beer
				(gInventory curIcon: 0)
				((gInventory at: 40) owner: gEgo) ; Open_Beer
				(gMessager say: noun theVerb 0 0 self 15) ; "With muscles bulging from years of grappling with childproof caps, you deftly wield the church key and wrench the tops from all the beer bottles."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gGame points: 2)
		(super cue:)
	)
)

(instance Open_Beer of FPInvItem
	(properties
		name {Open Beer}
		view 64
		loop 1
		cursor 64
		message 33
		signal 2
		noun 31
	)
)

(instance Empty_Bottles of FPInvItem
	(properties
		name {Empty Bottles}
		view 65
		loop 1
		cursor 65
		message 34
		signal 2
		noun 32
	)
)

(instance Church_Key of FPInvItem
	(properties
		name {Church Key}
		view 66
		loop 1
		cursor 66
		message 35
		signal 2
		noun 33
	)
)

(instance Ladder of FPInvItem
	(properties
		view 67
		loop 1
		cursor 67
		message 36
		signal 2
		noun 34
	)
)

(instance Rope of FPInvItem
	(properties
		view 68
		loop 1
		cursor 68
		message 37
		signal 2
		noun 35
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator name: name showTitle: 1)
				((gInventory at: 48) owner: gEgo) ; Rope
				(gEgo put: 48) ; Rope
				(gEgo get: -1 29) ; Lasso
				(gInventory curIcon: 0)
				((gInventory at: 29) owner: gEgo) ; Lasso
				(gMessager say: noun theVerb 0 0 self 15) ; "With a few quick movements, you make an authentic Western lasso out of the rope. It's like falling off a log... once you learn how, you never forget!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gGame points: 2)
		(super cue:)
	)
)

(instance Lasso of FPInvItem
	(properties
		view 69
		loop 1
		cursor 69
		message 38
		signal 2
		noun 36
	)
)

(instance Pure_Solution of FPInvItem
	(properties
		name {Pure Solution}
		view 70
		loop 1
		cursor 70
		message 39
		signal 2
		noun 37
	)
)

(instance Nitrous_Oxide of FPInvItem
	(properties
		name {Nitrous Oxide}
		view 71
		loop 1
		cursor 71
		message 40
		signal 2
		noun 38
	)
)

(instance Baking_Soda of FPInvItem
	(properties
		name {Baking Soda}
		view 72
		loop 1
		cursor 72
		message 41
		signal 2
		noun 39
	)
)

(instance Post_Cards of FPInvItem
	(properties
		name {Post Cards}
		view 73
		loop 1
		cursor 73
		message 42
		signal 2
		noun 40
	)
)

(instance Candle_Wax of FPInvItem
	(properties
		name {Candle Wax}
		view 74
		loop 1
		cursor 74
		message 43
		signal 2
		noun 41
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; Knife
				(gNarrator name: name showTitle: 1)
				((gInventory at: 4) owner: gEgo) ; Candle_Wax
				(gEgo put: 4) ; Candle_Wax
				((gInventory at: 27) owner: gEgo) ; Knife
				(gEgo put: 27) ; Knife
				(gEgo get: -1 59) ; Wax_Ear
				(gInventory curIcon: 0)
				((gInventory at: 59) owner: gEgo) ; Wax_Ear
				(gMessager say: noun theVerb 0 0 self 15) ; "With your newly-acquired whittlin' skills, you carve the candle wax into the shape of an ear, one that should theoretically attach snugly to the remains of your original ear. But now look at the gunk on Willy's knife!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Knife of FPInvItem
	(properties
		view 75
		loop 1
		cursor 75
		message 44
		signal 2
		noun 42
	)
)

(instance Desk_Key of FPInvItem
	(properties
		name {Desk Key}
		view 76
		loop 1
		cursor 76
		message 45
		signal 2
		noun 9
	)
)

(instance Letter of FPInvItem
	(properties
		view 77
		loop 1
		cursor 77
		message 62
		signal 2
		noun 62
	)
)

(instance Shovel of FPInvItem
	(properties
		view 78
		loop 1
		cursor 78
		message 63
		signal 2
		noun 63
	)
)

(instance Deposit_Key of FPInvItem
	(properties
		name {Deposit Key}
		view 79
		loop 1
		cursor 79
		message 46
		signal 2
		noun 45
	)
)

(instance Pistols of FPInvItem
	(properties
		view 80
		loop 1
		cursor 10
		message 47
		signal 2
		noun 46
	)

	(method (doVerb theVerb)
		(= local5 0)
		(gNarrator name: name showTitle: 1)
		(switch theVerb
			(51 ; Bullets
				(= gCurPuzzle 17)
				((gInventory at: 3) owner: gEgo) ; Bullets
				(gEgo put: 3) ; Bullets
				(SetFlag 54)
				(gInventory curIcon: 0)
				(gMessager say: noun theVerb 0 0 self 15) ; "You slip the bullets in the chamber as the old memories come rushing back (including a few featuring you and your first cousin out behind the barn, when you were both curious 8-year-olds!)."
			)
			(50 ; Cleaning_Kit
				((gInventory at: 9) owner: gEgo) ; Cleaning_Kit
				(gEgo put: 9) ; Cleaning_Kit
				(SetFlag 4)
				(gInventory curIcon: 0)
				(if (IsFlag 54)
					(gMessager say: noun theVerb 27 0 self 15) ; "After removing the bullets, you clean and polish your pistols 'til they shine like a Coarsegold kid with his first passing grade. Good thing you removed all that rust from your barrel -- the damn thing could'a exploded right in your face! When you're done, you replace the bullets in the chamber."
				else
					(gMessager say: noun theVerb 0 0 self 15) ; "With the Sheriff's cleaning kit, you lovingly clean and polish your old pistols 'til they're like new. Good thing you removed all that nasty rust from your barrel -- the damn thing could'a exploded right in your face!"
				)
				(= local5 1)
			)
			(4 ; Do
				(if (== gCurPuzzle 25)
					(gInventory curIcon: 0 hide:)
					(gCurRoom notify:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(cond
					((and (IsFlag 4) (IsFlag 54))
						(gMessager say: noun 1 22 0 0 15) ; "Your pistols are clean and loaded for bear! Now you're cookin'!"
					)
					((IsFlag 54)
						(gMessager say: noun 1 23 0 0 15) ; "Your old pistols are fully loaded with the Sheriff Chickenshift's surplus ammo."
					)
					((IsFlag 4)
						(gMessager say: noun 1 15 0 0 15) ; "Your old pistols, now cleaned and restored to their original working condition, bring back a flood of emotions, with memories of yesteryear!"
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (== local5 1)
			(gGame points: 5)
		)
		(super cue:)
	)
)

(instance Pie of FPInvItem
	(properties
		view 81
		loop 1
		cursor 81
		message 48
		signal 2
		noun 48
	)
)

(instance Coffee of FPInvItem
	(properties
		view 82
		loop 1
		cursor 82
		message 49
		signal 2
		noun 49
	)
)

(instance Cleaning_Kit of FPInvItem
	(properties
		name {Cleaning Kit}
		view 83
		loop 1
		cursor 83
		message 50
		signal 2
		noun 50
	)
)

(instance Bullets of FPInvItem
	(properties
		view 84
		loop 1
		cursor 84
		message 51
		signal 2
		noun 51
	)
)

(instance Clay of FPInvItem
	(properties
		view 85
		loop 1
		cursor 85
		message 52
		signal 2
		noun 52
	)
)

(instance Medallion of FPInvItem
	(properties
		view 86
		loop 1
		cursor 86
		message 53
		signal 2
		noun 23
	)
)

(instance Empty_Mold of FPInvItem
	(properties
		name {Empty Mold}
		view 53
		loop 1
		cursor 53
		message 69
		signal 2
		noun 68
	)
)

(instance Wax_Filled_Mold of FPInvItem
	(properties
		name {Wax Filled Mold}
		view 39
		loop 1
		cursor 39
		message 68
		signal 2
		noun 54
	)
)

(instance Silver_Filled_Mold of FPInvItem
	(properties
		name {Silver Filled Mold}
		view 87
		loop 1
		cursor 87
		message 67
		signal 2
		noun 53
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator name: name showTitle: 1)
				((gInventory at: 53) owner: gEgo) ; Silver_Filled_Mold
				(gEgo put: 53) ; Silver_Filled_Mold
				(gInventory curIcon: 0)
				(if
					(and
						(gEgo has: 38) ; Neckerchief
						(gEgo has: 10) ; Clothes
						(gEgo has: 2) ; Boots
						(gEgo has: 44) ; Pistols
					)
					(SetFlag 58)
				)
				(gEgo get: -1 52) ; Silver_Ear
				((gInventory at: 52) owner: gEgo) ; Silver_Ear
				(gMessager say: noun 4 0 0 self 15) ; "You scrape the clay off and discard it, leaving you with a gleaming silver ear! Beautifully done! With an ear like this, you could (dare I say it) RULE THE WORLD! Nyah-ha-ha-ha!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gGame points: 20)
		(super cue:)
	)
)

(instance Wax_Ear of FPInvItem
	(properties
		name {Wax Ear}
		view 38
		loop 1
		cursor 38
		message 70
		signal 2
		noun 69
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Clay
				(gNarrator name: name showTitle: 1)
				(gEgo get: -1 60) ; Wax_Filled_Mold
				((gInventory at: 59) owner: gEgo) ; Wax_Ear
				(gEgo put: 59) ; Wax_Ear
				((gInventory at: 8) owner: gEgo) ; Clay
				(gEgo put: 8) ; Clay
				(gInventory curIcon: 0)
				((gInventory at: 60) owner: gEgo) ; Wax_Filled_Mold
				(gMessager say: noun theVerb 0 0 self 15) ; "You carefully pack the clay in and around the wax ear, leaving a small opening so that you can pour out the molten wax later."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Silver_Ear of FPInvItem
	(properties
		name {Silver Ear}
		view 88
		loop 1
		cursor 88
		message 55
		signal 2
		noun 61
	)
)

(instance Clothes of FPInvItem
	(properties
		view 89
		loop 1
		cursor 89
		message 56
		signal 2
		noun 55
	)
)

(instance Claim_Check of FPInvItem
	(properties
		name {Claim Check}
		view 90
		loop 1
		cursor 90
		message 57
		signal 2
		noun 56
	)
)

(instance Boots of FPInvItem
	(properties
		view 91
		loop 1
		cursor 91
		message 58
		signal 2
		noun 57
	)
)

(instance Neckerchief of FPInvItem
	(properties
		view 92
		loop 1
		cursor 92
		message 59
		signal 2
		noun 58
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator name: name showTitle: 1)
				(++ local1)
				(gMessager say: 58 4 24 0 self 15) ; "Say, let me show you a little trick with a borrowed neckerchief... Now you see it..."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Sharp_Ear of FPInvItem
	(properties
		name {Sharp Ear}
		view 93
		loop 1
		cursor 93
		message 60
		signal 2
		noun 59
	)
)

(instance Sword of FPInvItem
	(properties
		view 94
		loop 1
		cursor 94
		message 61
		signal 2
		noun 60
	)
)

(instance Paper_Sack of FPInvItem
	(properties
		name {Paper Sack}
		view 96
		loop 1
		cursor 96
		message 65
		signal 2
		noun 65
	)
)

(instance Filled_Sack of FPInvItem
	(properties
		name {Filled Sack}
		view 98
		loop 1
		cursor 98
		message 64
		signal 2
		noun 64
	)
)

(instance Elixir of FPInvItem
	(properties
		view 97
		loop 1
		cursor 97
		message 5
		signal 2
		noun 66
	)
)

(instance Horse_Plop of FPInvItem
	(properties
		name {Horse Plop}
		view 95
		loop 1
		cursor 95
		message 66
		signal 2
		noun 67
	)
)

(instance sHuh of Sound
	(properties
		flags 1
		number 2990
	)
)

