;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use GloryIconItem)
(use Str)
(use Print)
(use IconBar)
(use StopWalk)
(use Sound)
(use Inventory)
(use Actor)
(use System)

(public
	glorySpells 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(return
		(switch param1
			(5 20)
			(6 21)
			(7 22)
			(8 23)
			(9 24)
			(10 25)
			(11 26)
			(12 27)
			(13 28)
			(14 29)
			(15 30)
			(16 31)
			(17 32)
			(18 33)
			(20 41)
			(24 34)
			(26 35)
			(27 36)
			(31 38)
			(29 37)
			(30 39)
			(28 40)
		)
	)
)

(class SpellItem of InvI
	(properties
		modNum 21
		signal 2
		helpVerb 9
	)

	(method (select)
		(self doVerb: 4)
		(return 0)
	)

	(method (highlight))

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(switch theVerb
			(1 ; Look
				(= temp0 (Str new:))
				(= temp1 (Str new:))
				(Message msgGET 21 noun 0 1 1 (temp0 data:))
				(Message msgGET 21 0 0 3 1 (temp1 data:)) ; "You have the %s. Casting it takes %d magic points. Your spell skill is %d."
				(Print
					addTextF:
						(temp1 data:)
						(temp0 data:)
						value
						[gEgoStats (+ 20 (glorySpells indexOf: self))]
					init:
				)
				(temp0 dispose:)
				(temp1 dispose:)
			)
			(4 ; Do
				(cond
					(
						(and
							(> (gEgo view:) 5)
							(not (<= 47 (gEgo view:) 49))
							(!= (gEgo view:) 52)
							(not
								(and
									(> (gEgo view:) 17)
									(< (gEgo view:) 21)
								)
							)
							(!= gCurRoomNum 670)
						)
						(gMessager say: 0 0 14 1 0 21) ; "This isn't a good place to use that spell."
						(return 0)
					)
					((gCurRoom script:)
						(gMessager say: 0 0 22 1 0 21) ; "You're too busy to cast a spell right now."
						(return 0)
					)
					(
						(OneOf
							(+ (glorySpells indexOf: self) 20)
							26
							33
							28
							34
							20
							22
							27
						)
						(if
							(<
								[gEgoStats 19] ; mana
								[global367 (glorySpells indexOf: self)]
							)
							(gEgo
								castSpell:
									(+ (glorySpells indexOf: self) 20)
									(and
										(> (gEgo view:) 17)
										(< (gEgo view:) 21)
									)
							)
							(return 0)
						else
							(return 1)
						)
					)
					(
						(gEgo
							castSpell:
								(+ (glorySpells indexOf: self) 20)
								(and
									(> (gEgo view:) 17)
									(< (gEgo view:) 21)
								)
						)
						(return 1)
					)
					(else
						(return 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glorySpells of QGInv
	(properties
		planeTop 29
		planeLeft 65
		numRow 3
		numCol 5
		rowMargin 1
		colMargin 8
		itemWide 23
		itemHigh 24
		iconMargin 5
		invLeft 26
	)

	(method (ownedBy &tmp [temp0 2])
		(return 1)
	)

	(method (init &tmp temp0)
		(self
			helpIconItem: spellsHelp
			selectIcon: spellsSelect
			theSlider: spellsSlider
			okButton: 1
		)
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
				frostSpell
				ritualSpell
				invisibleSpell
				auraSpell
				protectionSpell
				resistanceSpell
				glideSpell
				healingSpell
				spellDummy1
				spellsLook
				spellsSelect
				spellsHelp
				ok
				spellDummy2
				spellsSlider
				spellsUpArrow
				spellsDownArrow
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #modNum 21
			state: 2048
		)
		(super init: &rest)
	)

	(method (getInvNum &tmp temp0 temp1 temp2)
		(= temp1 0)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(if
				(and
					((= temp2 (NodeValue temp0)) isKindOf: InvI)
					(== (temp2 owner:) gEgo)
				)
				(++ temp1)
			)
		)
		(if (= totalRow (/ temp1 numCol))
			(= interval (/ 59 totalRow))
		else
			(= interval 60)
		)
	)

	(method (drawInvItems &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp4 0)
		(= temp0 invLeft)
		(= temp1 (+ iconBottom 15))
		(= temp9 (= temp8 0))
		(= temp3 (self first:))
		(= temp7 0)
		(while (< temp7 curIndex)
			(if
				(and
					((= temp2 (NodeValue temp3)) isKindOf: InvI)
					(not (& (temp2 signal:) $0004))
				)
				(DeleteScreenItem temp2)
				(temp2 signal: (| (temp2 signal:) $0004))
			)
			(++ temp7)
			(= temp3 (self next: temp3))
		)
		(for ((= temp3 temp3)) temp3 ((= temp3 (self next: temp3)))
			(if
				(and
					((= temp2 (NodeValue temp3)) isKindOf: InvI)
					(if
						(and
							(| (= temp10 (localproc_0 (temp2 noun:))) $0001)
							[gEgoStats temp10]
						)
						(if
							(and
								(== temp10 39)
								(not
									(and
										(> (gEgo view:) 17)
										(< (gEgo view:) 21)
									)
								)
							)
							0
						else
							1
						)
					else
						0
					)
				)
				(if
					(>
						(= temp5
							(CelHigh (temp2 view:) (temp2 loop:) (temp2 cel:))
						)
						temp4
					)
					(= temp4 temp5)
				)
				(temp2
					x: temp0
					y: temp1
					nsTop: temp1
					nsLeft: temp0
					nsRight:
						(+
							temp0
							(CelWide (temp2 view:) (temp2 loop:) (temp2 cel:))
						)
					nsBottom: (+ temp1 temp5)
				)
				(if (& (temp2 signal:) $0004)
					(temp2 signal: (& (temp2 signal:) $fffb))
					(AddScreenItem temp2)
				else
					(UpdateScreenItem temp2)
				)
				(if
					(or
						(>
							(+=
								temp0
								(+
									(CelWide
										(temp2 view:)
										(temp2 loop:)
										(temp2 cel:)
									)
									colMargin
								)
							)
							iconRight
						)
						(>= (++ temp9) numCol)
					)
					(= temp9 0)
					(= temp0 invLeft)
					(+= temp1 (+ itemHigh rowMargin))
					(if (>= (++ temp8) numRow)
						(break)
					)
				)
			)
		)
		(if temp3
			(for
				((= temp3 (self next: temp3)))
				temp3
				((= temp3 (self next: temp3)))
				
				(if
					(and
						((= temp2 (NodeValue temp3)) isKindOf: InvI)
						(not (& (temp2 signal:) $0004))
					)
					(DeleteScreenItem temp2)
					(temp2 signal: (| (temp2 signal:) $0004))
				)
			)
		)
	)

	(method (showSelf param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= owner param1)
		(for ((= temp6 0)) (< temp6 22) ((++ temp6))
			(if [gEgoStats (+ 20 temp6)]
				((self at: temp6) owner: gEgo)
			)
		)
		(if
			(>=
				(if global394
					(- (+ global394 [gEgoStats 14]) global361) ; honor
				else
					0
				)
				25
			)
			(healingSpell owner: gEgo)
		)
		(if (not (and (> (gEgo view:) 17) (< (gEgo view:) 21)))
			(resistanceSpell owner: 0)
		)
		(= temp1 (CelWide 932 8 0))
		(= temp0 (CelHigh 932 8 0))
		(= temp2 (/ (- 320 temp1) 2))
		(= temp4 (/ (- 153 temp0) 2))
		(= temp3 (+ temp2 temp1))
		(= temp5 (+ temp4 temp0))
		(plane back: 108)
		(gThePlane addCast: (= local1 (Cast new:)))
		((View new:)
			view: 932
			loop: 8
			cel: 0
			setPri: 255
			posn: temp2 temp4
			init: local1
		)
		((View new:)
			view: 932
			loop: 9
			cel: 0
			setPri: 255
			posn: 53 143
			init: local1
		)
		(self getInvNum:)
		(= currentRow (= curIndex 0))
		((spellsSlider theSlider:) y: 41)
		(UpdateScreenItem (spellsSlider theSlider:))
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(= owner (if argc param1 else gEgo))
		(if (not (self ownedBy: owner))
			(self carryingNothing:)
			(return 0)
		)
		(self show: doit:)
		(return (and local1 (self hide:)))
	)

	(method (drawIcons)
		(plane addCast: (= local0 (Cast new:)))
		((View new:) view: 932 loop: 10 cel: 2 posn: 0 26 init: local0)
		((View new:) view: 932 loop: 10 cel: 0 posn: 3 28 init: local0)
		((View new:) view: 932 loop: 10 cel: 1 posn: 170 28 init: local0)
		(spellsSlider
			theSlider:
				((View new:)
					x: 180
					y: 41
					view: 932
					loop: 12
					cel: 0
					init: local0
					yourself:
				)
		)
		(super drawIcons: &rest)
	)

	(method (hide)
		(gThePlane deleteCast: local1)
		(super hide: &rest)
		(local1 dispose:)
		(= local1 0)
	)
)

(instance spellsSlider of SliderIcon
	(properties
		noun 33
		nsLeft 180
		nsTop 39
		nsRight 191
		nsBottom 98
		x 180
		y 39
		signal 131
		message 4
		mainView 932
		mainLoop 15
		helpVerb 9
	)

	(method (select &tmp temp0 temp1 [temp2 4] temp6)
		(while
			(not
				(OneOf
					((= temp0 ((gUser curEvent:) new:)) type:)
					2
					8
					64
				)
			)
			(temp0 localize: (glorySpells plane:))
			(cond
				((< (temp0 y:) 41)
					(theSlider y: 41)
				)
				((> (temp0 y:) 92)
					(theSlider y: 92)
				)
				(else
					(theSlider y: (temp0 y:))
				)
			)
			(UpdateScreenItem theSlider)
			(FrameOut)
		)
		(temp0 localize: (glorySpells plane:))
		(cond
			(
				(or
					(not
						(= temp1
							(/ (+ (- (temp0 y:) 41) 8) (glorySpells interval:))
						)
					)
					(< (temp0 y:) 41)
				)
				(self updateSlider: 0 0)
				(while (> (glorySpells currentRow:) 0)
					(glorySpells currentRow: (- (glorySpells currentRow:) 1))
					(glorySpells setCurIndex: -5)
				)
			)
			((or (== temp1 (glorySpells totalRow:)) (> (temp0 y:) 92))
				(self updateSlider: 0 1)
				(while (< (glorySpells currentRow:) (glorySpells totalRow:))
					(glorySpells currentRow: (+ (glorySpells currentRow:) 1))
					(glorySpells setCurIndex: 5)
				)
			)
			(else
				(theSlider y: (+ 41 (* temp1 (glorySpells interval:))))
				(UpdateScreenItem theSlider)
				(cond
					((> (= temp6 (- temp1 (glorySpells currentRow:))) 0)
						(while temp6
							(glorySpells
								currentRow: (+ (glorySpells currentRow:) 1)
							)
							(glorySpells setCurIndex: 5)
							(-- temp6)
						)
					)
					((< temp6 0)
						(while temp6
							(glorySpells
								currentRow: (- (glorySpells currentRow:) 1)
							)
							(glorySpells setCurIndex: -5)
							(++ temp6)
						)
					)
				)
			)
		)
		(glorySpells drawInvItems:)
		(return 0)
	)

	(method (updateSlider param1 param2 &tmp temp0)
		(if (> argc 1)
			(if param2
				(theSlider y: 92)
			else
				(theSlider y: 41)
			)
		else
			(theSlider y: (+ (theSlider y:) param1))
		)
		(UpdateScreenItem theSlider)
	)
)

(instance spellsUpArrow of GloryIconItem
	(properties
		noun 34
		nsLeft 180
		nsTop 30
		nsRight 191
		nsBottom 38
		x 180
		y 30
		signal 131
		message 4
		mainView 932
		mainLoop 14
		helpVerb 9
	)

	(method (select)
		(if (>= (- (glorySpells currentRow:) 1) 0)
			(glorySpells currentRow: (- (glorySpells currentRow:) 1))
			(if (== (glorySpells currentRow:) 0)
				(spellsSlider updateSlider: 0 0)
			else
				(spellsSlider updateSlider: (- 0 (glorySpells interval:)))
			)
			(glorySpells setCurIndex: -5 drawInvItems:)
		)
		(return 0)
	)
)

(instance spellsDownArrow of GloryIconItem
	(properties
		noun 35
		nsLeft 180
		nsTop 100
		nsRight 191
		nsBottom 108
		x 180
		y 100
		signal 131
		message 4
		mainView 932
		mainLoop 13
		helpVerb 9
	)

	(method (select)
		(if (<= (+ (glorySpells currentRow:) 1) (glorySpells totalRow:))
			(glorySpells currentRow: (+ (glorySpells currentRow:) 1))
			(if (== (glorySpells currentRow:) (glorySpells totalRow:))
				(spellsSlider updateSlider: 0 1)
			else
				(spellsSlider updateSlider: (glorySpells interval:))
			)
			(glorySpells setCurIndex: 5 drawInvItems:)
		)
		(return 0)
	)
)

(instance spellDummy1 of GloryIconItem
	(properties
		signal 131
		mainView 932
		mainLoop 7
	)

	(method (onMe)
		(return 0)
	)

	(method (highlight))

	(method (select))
)

(instance spellDummy2 of GloryIconItem
	(properties
		signal 67
		mainView 932
		mainLoop 7
		mainCel 1
	)

	(method (onMe)
		(return 0)
	)

	(method (highlight))

	(method (select))
)

(instance spellsLook of IconI
	(properties
		noun 1
		modNum 21
		nsTop 10
		message 1
		mainView 932
		mainLoop 2
		cursorView 941
		cursorLoop 0
		cursorCel 0
		helpVerb 9
	)
)

(instance spellsSelect of IconI
	(properties
		noun 4
		modNum 21
		nsTop 10
		mainView 932
		cursorView 942
		cursorLoop 0
		cursorCel 0
		helpVerb 9
	)
)

(instance ok of IconI
	(properties
		noun 2
		modNum 21
		nsTop 10
		mainView 932
		mainLoop 3
		cursorView 942
		cursorLoop 0
		cursorCel 0
		helpVerb 9
	)

	(method (init)
		(self setCursor: 942 0 0)
		(super init: &rest)
	)

	(method (select)
		(glorySpells hide:)
		(return 1)
	)
)

(instance spellsHelp of IconI
	(properties
		noun 3
		modNum 21
		nsTop 10
		signal 3
		message 9
		mainView 932
		mainLoop 1
		cursorView 949
		cursorLoop 0
		cursorCel 0
		helpVerb 9
	)
)

(instance openSpell of SpellItem
	(properties
		noun 5
		mainView 906
		value 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 80)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 80
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(gMessager say: 0 0 23 1 0 21) ; "There is nothing here to open."
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
		noun 6
		mainView 906
		mainCel 1
		value 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 81)
					)
					((super doVerb: 4)
						(gCurRoom setScript: (ScriptID 12) 0 81) ; castAreaScript
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
		noun 7
		mainView 906
		mainCel 2
		value 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 82)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 82
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(gMessager say: 0 0 24 0 0 21) ; "Nothing spectacular happens."
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
		noun 8
		mainView 906
		mainCel 3
		value 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 83)
					)
					((super doVerb: 4)
						(cond
							(
								(OneOf
									gCurRoomNum
									551
									552
									553
									554
									555
									556
									557
									558
									559
									560
									561
									562
									563
									564
									565
									566
									567
									568
									569
									570
									571
									572
									573
									574
									575
									576
									577
									578
									579
									580
									581
									582
									583
									584
									585
									586
									587
									588
									589
									590
									591
									592
									593
									270
									340
									460
									520
									545
									600
									625
									650
									670
									710
									730
									750
									770
								)
								((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_S)
								(if (not (gMouseDownHandler handleEvent: temp0))
									(gRegions handleEvent: temp0)
								)
								(temp0 dispose:)
								(return 1)
							)
							((> (gEgo view:) 5)
								(gMessager say: 0 0 14 1 0 21) ; "This isn't a good place to use that spell."
							)
							(else
								(gEgo setScript: (ScriptID 12) 0 83) ; castAreaScript
							)
						)
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
		noun 9
		mainView 906
		mainCel 4
		value 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 84)
					)
					((super doVerb: 4)
						(cond
							((== gCurRoomNum 650)
								(gCurRoom doVerb: 84)
							)
							((or (gEgo has: 19) (gEgo has: 5)) ; theSword, theThrowdagger
								(soundFX number: 932 play:)
								(gMessager say: 0 0 8 1 0 21) ; "Your weapon is now magically charged."
								(= global142 (+ 5 (/ [gEgoStats 24] 10))) ; zapSpell
								((ScriptID 0 21) doit:) ; statusCode
							)
							(else
								(gMessager say: 0 0 9 1 0 21) ; "You don't have a weapon to charge."
							)
						)
					)
					(else
						(return 1)
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
		noun 10
		mainView 906
		mainCel 5
		value 4
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 85)
					)
					((super doVerb: 4)
						(gCurRoom setScript: (ScriptID 12) 0 85) ; castAreaScript
					)
					(else
						(return 1)
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
		noun 11
		mainView 906
		mainCel 6
		value 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 86)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 86
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fetchSpell of SpellItem
	(properties
		noun 12
		mainView 906
		mainCel 7
		value 5
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 87)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 87
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance forceBoltSpell of SpellItem
	(properties
		noun 13
		mainView 906
		mainCel 8
		value 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 88)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 88
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance levitateSpell of SpellItem
	(properties
		noun 14
		mainView 906
		mainCel 9
		value 7
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 89)
					)
					(
						(and
							(== gCurRoomNum 710)
							(== (gEgo script:) (ScriptID 710 1)) ; sLevitateOverPit
							(== ((gEgo script:) state:) 3)
						)
						((gEgo script:) register: 1)
						((gEgo script:) cue:)
					)
					((super doVerb: 4)
						(if
							(OneOf
								gCurRoomNum
								551
								552
								553
								554
								555
								556
								557
								558
								559
								560
								561
								562
								563
								564
								565
								566
								567
								568
								569
								570
								571
								572
								573
								574
								575
								576
								577
								578
								579
								580
								581
								582
								583
								584
								585
								586
								587
								588
								589
								590
								591
								592
								593
								250
								260
								270
								280
								290
								330
								340
								600
								710
								720
								800
								740
								750
								730
							)
							((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_Y)
							(if (not (gMouseDownHandler handleEvent: temp0))
								(gRegions handleEvent: temp0)
							)
							(temp0 dispose:)
							(return 1)
						else
							(= temp1 (Str new:))
							(cond
								((> (gEgo view:) 5)
									(Message msgGET 21 0 0 14 1 (temp1 data:)) ; "This isn't a good place to use that spell."
									(Print addText: (temp1 data:) init:)
								)
								(((ScriptID gCurRoomNum) script:)
									(Message msgGET 21 0 0 15 1 (temp1 data:)) ; "This is definitely not an appropriate time to cast your Levitate spell."
									(Print addText: (temp1 data:) init:)
								)
								(else
									(Message msgGET 21 21 6 21 1 (temp1 data:)) ; "Now is not a good time to cast your Levitate spell."
									(Print addText: (temp1 data:) init:)
								)
							)
							(temp1 dispose:)
						)
					)
					(else
						(return 1)
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
		noun 15
		mainView 906
		mainCel 10
		value 8
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 90)
					)
					((super doVerb: 4)
						(if (OneOf gCurRoomNum 270 340 460 750)
							(gCurRoom doVerb: 90)
						else
							(SetFlag 8)
							(= global440 (/ [gEgoStats 30] 2)) ; reversalSpell
							(gMessager say: 0 0 27 0 0 21) ; "You cast the Reversal spell."
							((ScriptID 0 21) doit:) ; statusCode
						)
					)
					(else
						(return 1)
					)
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
		noun 16
		mainView 906
		mainCel 11
		value 8
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 91)
					)
					((super doVerb: 4)
						(cond
							((and (> (gEgo view:) 17) (< (gEgo view:) 21))
								(gMessager say: 21 6 33 0 0 21) ; "You find that you are unable to cast that spell while holding Erana's Staff."
							)
							(
								(OneOf
									gCurRoomNum
									270
									340
									390
									520
									530
									535
									541 ; swamp1
									542 ; swamp2
									543 ; swamp3
									545
									600
									632
									630
									670
									680
									750
									770
									800
								)
								(gCurRoom doVerb: 91)
								(return 1)
							)
							(else
								(gCurRoom setScript: (ScriptID 62)) ; castJuggle
							)
						)
					)
					(else
						(return 1)
					)
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
		noun 17
		mainView 906
		mainCel 12
		value 5
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 92)
					)
					((or (IsFlag 450) gDebugging)
						(if (super doVerb: 4)
							(cond
								(
									(and
										(> (gEgo view:) 17)
										(< (gEgo view:) 21)
									)
									(gEgo
										normalize:
											(cond
												((== (gEgo view:) 18)
													(+ (gEgo loop:) 4)
												)
												((< (gEgo loop:) 4)
													(+ (gEgo loop:) 2)
												)
												(else
													(gEgo loop:)
												)
											)
									)
								)
								(
									(OneOf
										gCurRoomNum
										270
										340
										460
										670
										740
										750
										730
									)
									(gCurRoom doVerb: 92)
								)
								(else
									(gCurRoom setScript: (ScriptID 46)) ; staffScript
								)
							)
						else
							(return 1)
						)
					)
					(else
						(gMessager say: 17 92 31 0 0 21) ; "Your magical staff fails to appear; you are too far from where you created it. Perhaps you can find a new one here."
					)
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
		noun 18
		mainView 906
		mainCel 13
		value 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 93)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 93
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance healingSpell of SpellItem
	(properties
		noun 20
		mainView 906
		mainCel 14
		value 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Print addText: noun theVerb 0 1 0 0 21 init:) ; "You now have the Paladin ability to heal. With this spell you may heal yourself or others, but it will use some of your stamina."
			)
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 102)
					)
					((< [gEgoStats 18] 10) ; stamina
						(gMessager say: 21 6 20 0 0 21) ; "Your stamina is too low for you to cast this spell."
					)
					(else
						((gTheIconBar at: 5)
							message: 102
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frostSpell of SpellItem
	(properties
		noun 24
		mainView 906
		mainLoop 1
		mainCel 3
		value 15
	)

	(method (select)
		(self doVerb: 4)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 79)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 79
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ritualSpell of SpellItem
	(properties
		noun 26
		mainView 906
		mainLoop 1
		mainCel 1
		value 20
	)

	(method (select)
		(self doVerb: 4)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 94)
					)
					((super doVerb: 4)
						((gTheIconBar at: 5)
							message: 94
							cursorView: 948
							cursorLoop: 0
							cursorCel: 0
						)
						(gTheIconBar curIcon: (gTheIconBar at: 5))
					)
					(else
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invisibleSpell of SpellItem
	(properties
		noun 27
		mainView 906
		mainLoop 1
		mainCel 5
		value 6
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 95)
					)
					(
						(or
							(gEgo mover:)
							(and
								(gEgo cycler:)
								(not ((gEgo cycler:) isKindOf: StopWalk))
							)
						)
						(gMessager say: 0 0 32 1 0 21) ; "You have to stand still to use the Hide spell."
					)
					((super doVerb: 4)
						(if (OneOf gCurRoomNum 270 340 545 750 730 545)
							(gCurRoom doVerb: 95)
						else
							(soundFX number: 934 play:)
							(gEgo hide:)
						)
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance protectionSpell of SpellItem
	(properties
		noun 31
		mainView 906
		mainLoop 1
		mainCel 2
		value 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 97)
					)
					((super doVerb: 4)
						(if (OneOf gCurRoomNum 270 340 750)
							(gCurRoom doVerb: 97)
						else
							(= global453 (* [gEgoStats 38] 4)) ; protectionSpell
							(soundFX number: 934 play:)
							(gMessager say: 0 0 29 1 0 21) ; "You cast the Protection spell. It gives you a warm, safe feeling."
							((ScriptID 0 21) doit:) ; statusCode
						)
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance auraSpell of SpellItem
	(properties
		noun 29
		mainView 906
		mainLoop 1
		value 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 96)
					)
					((super doVerb: 4)
						(if (OneOf gCurRoomNum 270 340 750)
							(gCurRoom doVerb: 96)
						else
							(= global449 (* [gEgoStats 37] 4)) ; auraSpell
							(soundFX number: 934 play:)
							(gMessager say: 0 0 26 1 0 21) ; "You cast the Aura spell. A gentle glow suffuses your body."
							((ScriptID 0 21) doit:) ; statusCode
						)
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance resistanceSpell of SpellItem
	(properties
		noun 30
		mainView 906
		mainLoop 1
		mainCel 4
		value 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 98)
					)
					((super doVerb: 4)
						(if (OneOf gCurRoomNum 270 340 670 750)
							(gCurRoom doVerb: 98)
						else
							(= global454 30)
							(soundFX number: 934 play:)
							(gMessager say: 0 0 30 1 0 21) ; "You cast the Resistance to Elemental Forces spell."
							((ScriptID 0 21) doit:) ; statusCode
						)
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glideSpell of SpellItem
	(properties
		noun 28
		mainView 906
		mainCel 15
		value 10
	)

	(method (select)
		(self doVerb: 4)
		(return 0)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(glorySpells hide:)
				(cond
					((or (== gCurRoomNum 750) (== gCurRoomNum 340))
						(gCurRoom notify: 11)
					)
					((super doVerb: 4)
						(if
							(OneOf
								gCurRoomNum
								270
								340
								440
								530
								535
								541 ; swamp1
								542 ; swamp2
								543 ; swamp3
								545
								520
								561
								563
								564
								570
								571
								577
								581
								588
								593
								750
								790
							)
							(gCurRoom doVerb: 11)
						else
							(gMessager say: 28 0 25 0 0 21) ; "The Glide spell only works on liquid; you can't cast it here."
						)
					)
					(else
						(return 1)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

