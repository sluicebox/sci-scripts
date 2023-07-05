;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Print)
(use IconBar)
(use Inventory)
(use System)

(public
	glorySpells 0
)

(class SpellItem of InvI
	(properties
		signal 2
	)

	(method (select)
		(if
			(or
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
				)
				(< value [gEgoStats 18]) ; mana
			)
			(self doVerb: 4)
		else
			(Print addText: 0 0 2 1 0 0 21 init:) ; "You do not have enough magic points to cast that spell."
		)
		(return 0)
	)

	(method (doVerb theVerb &tmp [temp0 20] [temp20 80])
		(switch theVerb
			(1 ; Look
				(Message msgGET 21 noun 0 1 1 @temp0)
				(Message msgGET 21 0 0 3 1 @temp20) ; "You have the %s. Casting it takes %d magic points. Your spell skill is %d."
				(Print
					addTextF:
						@temp20
						@temp0
						value
						[gEgoStats (+ 19 (glorySpells indexOf: self))]
					init:
				)
			)
		)
	)
)

(instance spellsLook of IconI
	(properties
		view 932
		loop 2
		cel 0
		cursor 941
		message 1
		signal 129
		noun 1
		modNum 21
		helpVerb 9
	)
)

(instance spellsSelect of IconI
	(properties
		view 932
		loop 0
		cel 0
		cursor 942
		noun 4
		modNum 21
		helpVerb 9
	)
)

(instance ok of IconI
	(properties
		view 932
		loop 3
		cel 0
		cursor 999
		signal 67
		noun 2
		modNum 21
		helpVerb 9
	)
)

(instance spellsHelp of IconI
	(properties
		view 932
		loop 1
		cel 0
		cursor 949
		message 9
		noun 3
		modNum 21
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 932 7 0 (- (+ nsLeft (CelWide view loop cel)) 28) nsTop -1)
	)
)

(instance glorySpells of Inv
	(properties
		normalHeading 9
		empty 27
	)

	(method (init &tmp temp0)
		(self
			add:
				openSpell
				detectMagicSpell
				triggerSpell
				dazzleSpell
				zapSpell
				calmSpell
				flameDartSpell
				fetchSpell
				forceBoltSpell
				levitateSpell
				reversalSpell
				jugglingLightsSpell
				summonStaffSpell
				lightningBallSpell
				healingSpell
				spellsLook
				spellsSelect
				ok
				spellsHelp
				dummyIcon
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			window: spellWin
			helpIconItem: spellsHelp
			selectIcon: spellsSelect
			okButton: ok
			state: 2048
		)
		(for ((= temp0 0)) (< temp0 15) ((++ temp0))
			(if [gEgoStats (+ 19 temp0)]
				((self at: temp0) owner: gEgo)
			)
		)
		(if
			(>=
				(cond
					(
						(<
							(if global404
								(- [gEgoStats 14] global404) ; honor
							)
							0
						)
						0
					)
					(global404
						(- [gEgoStats 14] global404) ; honor
					)
				)
				25
			)
			(healingSpell owner: gEgo)
		)
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

	(method (drawInvWindow param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 [temp23 70])
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if ((= temp9 (NodeValue temp8)) isKindOf: SpellItem)
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
			(return 0)
		)
		(if (<= temp0 5)
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
					((< temp11 5)
						(= temp11 5)
					)
				)
			)
			(if (== (* temp11 (- temp17 1)) temp0)
				(-- temp17)
			)
		)
		(= temp12 (Max (+ 4 temp5) (* temp11 (+ 6 temp2))))
		(= temp10 (* temp17 (+ 4 temp1)))
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
						8
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
						(temp9 isKindOf: SpellItem)
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
							(+= temp18 (+ temp2 4))
						else
							(= temp21 temp11)
							(+= temp19 (+ temp1 2))
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
			(if (not ((= temp9 (NodeValue temp8)) isKindOf: SpellItem))
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

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (= temp2 0))
		(= temp3 (GetPort))
		(= temp4 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(while (not ((= temp0 ((gUser curEvent:) new:)) type:))
			(if (not (self isMemberOf: IconBar))
				(temp0 localize:)
			)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(temp2 modNum:)
							modeless: 1
							init:
						)
						(SetPort temp3)
					)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(gSystemWindow eraseOnly: temp4)
		(gGame setCursor: 942 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(SetPort temp3)
	)

	(method (hide)
		(dummyIcon owner: 0)
		(super hide:)
	)
)

(instance spellWin of GloryWindow
	(properties
		yOffset 28
	)

	(method (open)
		(spellsLook nsLeft: (- (/ (- (self right:) (self left:)) 2) 60))
		(super open:)
	)
)

(instance dummyIcon of SpellItem
	(properties
		view 932
		cursor 942
	)

	(method (highlight))

	(method (show)
		(= owner gEgo)
	)

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

(instance openSpell of SpellItem
	(properties
		view 906
		cursor 938
		noun 5
		value 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					(
						(OneOf
							gCurRoomNum
							230
							310
							380
							430
							450
							640
							650
							700
							810
							820
							853
						)
						((gTheIconBar at: 6) message: 75 cursor: 948)
						(gTheIconBar curIcon: (gTheIconBar at: 6))
					)
					((> (gEgo view:) 5)
						(gMessager say: 0 0 14 1 0 21) ; "Don't waste that spell!"
					)
					(else
						(gEgo setScript: (ScriptID 13)) ; castOpenScript
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance detectMagicSpell of SpellItem
	(properties
		view 906
		cel 1
		cursor 938
		noun 6
		value 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					(
						(OneOf
							gCurRoomNum
							230
							280
							310
							390
							430
							650
							770
							780
							810
							853
						)
						((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_L)
						(if (not (gMouseDownHandler handleEvent: temp0))
							(gRegions handleEvent: temp0)
						)
						(temp0 dispose:)
						(return 1)
					)
					((> (gEgo view:) 5)
						(gMessager say: 0 0 14 1 0 21) ; "Don't waste that spell!"
					)
					(else
						(gEgo setScript: (ScriptID 12) 0 76) ; castAreaScript
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance triggerSpell of SpellItem
	(properties
		view 906
		cel 2
		cursor 938
		noun 7
		value 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					(
						(OneOf
							gCurRoomNum
							230
							280
							310
							400
							430
							650
							700
							850
							851
							852
							853
							854
						)
						((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_M)
						(if (not (gMouseDownHandler handleEvent: temp0))
							(gRegions handleEvent: temp0)
						)
						(temp0 dispose:)
						(return 1)
					)
					((> (gEgo view:) 5)
						(gMessager say: 0 0 14 1 0 21) ; "Don't waste that spell!"
					)
					(else
						(gEgo setScript: (ScriptID 12) 0 77) ; castAreaScript
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dazzleSpell of SpellItem
	(properties
		view 906
		cel 3
		cursor 938
		noun 8
		value 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					(
						(OneOf
							gCurRoomNum
							230
							280
							310
							400
							430
							650
							700
							851
							852
							853
							854
						)
						((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_N)
						(if (not (gMouseDownHandler handleEvent: temp0))
							(gRegions handleEvent: temp0)
						)
						(temp0 dispose:)
						(return 1)
					)
					((> (gEgo view:) 5)
						(gMessager say: 0 0 14 1 0 21) ; "Don't waste that spell!"
					)
					(else
						(gEgo setScript: (ScriptID 12) 0 78) ; castAreaScript
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance zapSpell of SpellItem
	(properties
		view 906
		cel 4
		cursor 938
		noun 9
		value 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(if (== gCurRoomNum 650)
					(gCurRoom doVerb: 79)
				else
					(= global142 (+ 5 (/ [gEgoStats 23] 10))) ; zapSpell
					(if (or (gEgo has: 1) (gEgo has: 2)) ; theSword, theFineDagger
						(gMessager say: 0 0 8 1 0 21) ; "Your weapon is now magically charged."
					else
						(gMessager say: 0 0 9 1 0 21) ; "You don't have a weapon to charge."
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance calmSpell of SpellItem
	(properties
		view 906
		cel 5
		cursor 938
		noun 10
		value 4
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					(
						(OneOf
							gCurRoomNum
							230
							280
							310
							390
							400
							430
							450
							630
							650
							700
							820
							850
							851
							852
							853
							854
						)
						((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_P)
						(if (not (gMouseDownHandler handleEvent: temp0))
							(gRegions handleEvent: temp0)
						)
						(temp0 dispose:)
						(return 1)
					)
					((> (gEgo view:) 5)
						(gMessager say: 0 0 14 1 0 21) ; "Don't waste that spell!"
					)
					(else
						(gEgo setScript: (ScriptID 12) 0 80) ; castAreaScript
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flameDartSpell of SpellItem
	(properties
		view 906
		cel 6
		cursor 938
		noun 11
		value 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				((gTheIconBar at: 6) message: 81 cursor: 948)
				(gTheIconBar curIcon: (gTheIconBar at: 6))
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fetchSpell of SpellItem
	(properties
		view 906
		cel 7
		cursor 938
		noun 12
		value 5
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				((gTheIconBar at: 6) message: 82 cursor: 948)
				(gTheIconBar curIcon: (gTheIconBar at: 6))
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance forceBoltSpell of SpellItem
	(properties
		view 906
		cel 8
		cursor 938
		noun 13
		value 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				((gTheIconBar at: 6) message: 83 cursor: 948)
				(gTheIconBar curIcon: (gTheIconBar at: 6))
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance levitateSpell of SpellItem
	(properties
		view 906
		cel 9
		cursor 938
		noun 14
		value 7
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					(
						(OneOf
							gCurRoomNum
							280
							310
							400
							430
							650
							700
							720
							740
							851
							852
							853
							854
						)
						((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_T)
						(if (not (gMouseDownHandler handleEvent: temp0))
							(gRegions handleEvent: temp0)
						)
						(temp0 dispose:)
						(return 1)
					)
					((> (gEgo view:) 5)
						(gMessager say: 0 0 14 1 0 21) ; "Don't waste that spell!"
					)
					(((ScriptID gCurRoomNum) script:)
						(gMessager say: 0 0 15 0 0 21) ; "This is definitely not an appropriate time to cast your Levitate spell."
					)
					(else
						(gMessager say: 21 6 21 0 0 21) ; "Now is not a good time to cast your Levitate spell."
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance reversalSpell of SpellItem
	(properties
		view 906
		cel 10
		cursor 938
		noun 15
		value 8
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(if (OneOf gCurRoomNum 280 310 400 430 650 700 850 853)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_U)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				else
					(Print addText: 0 0 13 1 0 0 21 init:) ; "There is no need to cast a Reversal spell here."
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jugglingLightsSpell of SpellItem
	(properties
		view 906
		cel 11
		cursor 938
		noun 16
		value 8
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(if (OneOf gCurRoomNum 230 280 310 400 430 650 700 853)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_V)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				else
					(gEgo setScript: (ScriptID 62 0)) ; castJuggle
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance summonStaffSpell of SpellItem
	(properties
		view 906
		cel 12
		cursor 938
		noun 17
		value 5
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(if (IsFlag 69)
					(if (OneOf gCurRoomNum 280 310 400 430 650 700 850 853)
						((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_W)
						(if (not (gMouseDownHandler handleEvent: temp0))
							(gRegions handleEvent: temp0)
						)
						(temp0 dispose:)
						(return 1)
					)
				else
					(gMessager say: 21 6 18 0 0 21) ; "This is not a good place to summon your staff."
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lightningBallSpell of SpellItem
	(properties
		view 906
		cel 13
		cursor 938
		noun 18
		value 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				((gTheIconBar at: 6) message: 88 cursor: 948)
				(gTheIconBar curIcon: (gTheIconBar at: 6))
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance healingSpell of SpellItem
	(properties
		view 906
		cel 14
		cursor 938
		noun 20
		value 10
	)

	(method (select)
		(if (< [gEgoStats 17] 10) ; stamina
			(Print addText: 21 6 20 1 0 0 21 init:) ; "Your stamina is too low for you to cast this spell."
		else
			(self doVerb: 4)
		)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Print addText: noun theVerb 0 1 0 0 21 init:) ; "You now have the Paladin ability to heal. With this spell you may heal yourself or others, but it will require some of your stamina."
			)
			(4 ; Do
				(glorySpells hide:)
				((gTheIconBar at: 6) message: 66 cursor: 948)
				(gTheIconBar curIcon: (gTheIconBar at: 6))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

