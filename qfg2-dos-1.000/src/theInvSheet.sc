;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use n001)
(use Interface)
(use Window)
(use Save)

(public
	theInvSheet 0
)

(local
	nItems
	items
	itemNums
)

(procedure (showSpell spellNum xLoc yLoc &tmp index [str 8])
	(= index (- spellNum 19))
	(Display
		(Format @str 71 4 [gSpCostOpen index]) ; "%d"
		dsCOORD
		(+ xLoc 7)
		yLoc
		dsALIGN
		alLEFT
		dsFONT
		gSmallFont
		dsCOLOR
		1
		dsWIDTH
		20
	)
	(if
		(or
			(and (== spellNum 23) gZapPower)
			(and (== spellNum 28) (IsFlag 90)) ; fLevitating
			(and (== spellNum 29) (IsFlag 86)) ; fReversal
		)
		(Display 71 13 dsCOORD (+ xLoc 22) yLoc dsALIGN alLEFT dsFONT gSmallFont dsCOLOR 12) ; "*"
	)
	(Display 12 index dsCOORD (+ xLoc 33) yLoc dsALIGN alLEFT dsFONT gSmallFont dsCOLOR 1)
	(Display
		(Format @str 71 4 [gEgoStats spellNum]) ; "%d"
		dsCOORD
		(+ xLoc 105)
		yLoc
		dsALIGN
		alLEFT
		dsFONT
		gSmallFont
		dsCOLOR
		1
	)
)

(procedure (addItem str index &tmp num drinkRatio)
	(Format str 71 14 (= num [gInvNum index])) ; "%4d"
	(if (== index 37)
		(= drinkRatio (/ gDrinksLeft [gInvNum 37])) ; Waterskin
		(StrCat
			str
			(cond
				((<= gDrinksLeft 0) {Empty })
				((<= drinkRatio 3) {Almost empty })
				((<= drinkRatio 6) {Half Full })
				((< drinkRatio 10) {Mostly Full })
				(else {Full })
			)
		)
	)
	(if (and (== index 33) (> gElementalState 1))
		(StrCat str {Magic Lamp})
	else
		(Format
			(StrEnd str)
			11
			(+ index index)
			(if (> num 1) 115 else 0)
		)
	)
)

(instance printWindow of Window
	(properties)

	(method (dispose)
		(self restore:)
		(if window
			(DisposeWindow window 1)
			(= window 0)
		)
		(super dispose:)
	)
)

(instance theInvSheet of Dialog
	(properties)

	(method (doit &tmp index yPos theColor totalWeight [str 40] cp ip)
		(= index 3)
		(= nItems 0)
		(while (<= index 58)
			(if [gInvNum index]
				(++ nItems)
			)
			(++ index)
		)
		(= items 0)
		(= itemNums 0)
		(if (not nItems)
			(if (not (= items (Memory memALLOC_NONCRIT 38)))
				(HighPrint 71 0) ; "Not enough room to view inventory."
				(self dispose:)
				(return 0)
			)
			(StrCpy items {  Nothing})
			(= cp (+ items 37))
		else
			(if (not (= items (Memory memALLOC_NONCRIT (+ (* nItems 37) 1))))
				(HighPrint 71 0) ; "Not enough room to view inventory."
				(self dispose:)
				(return 0)
			)
			(if (not (= itemNums (Memory memALLOC_NONCRIT (* nItems 2))))
				(HighPrint 71 0) ; "Not enough room to view inventory."
				(self dispose:)
				(return 0)
			)
			(= index 3)
			(= cp items)
			(= ip 0)
			(while (<= index 58)
				(if [gInvNum index]
					(Memory memPOKE (+ itemNums (* ip 2)) index)
					(addItem cp index)
					(+= cp 37)
					(++ ip)
				)
				(++ index)
			)
		)
		(StrAt cp 0 0)
		(selectorItem text: items font: gSmallFont setSize: moveTo: 11 19)
		(exitButton setSize:)
		(self
			window: SysWindow
			nsTop: 0
			nsLeft: 0
			nsBottom: 189
			nsRight: 320
			add: selectorItem
			add: exitButton
			open: 0 -1
			setSize:
			center:
		)
		(Display ; "You Have:"
			71
			1
			dsCOORD
			(selectorItem nsLeft:)
			5
			dsWIDTH
			(- (selectorItem nsRight:) (selectorItem nsLeft:))
			dsALIGN
			alCENTER
			dsFONT
			300
			dsCOLOR
			0
		)
		(= totalWeight (WtCarried))
		(cond
			((== yPos 24) ; UNINIT
				(Display 71 2 dsCOORD 40 (+ yPos 5) dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "Nothing", UNINIT
			)
			((>= yPos 174) ; UNINIT
				(Display 71 3 dsCOORD 40 172 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; ". . . and more"
			)
		)
		(= theColor (if (< gNumColors 16) 4 else 12))
		(Display
			(Format @str 71 4 [gInvNum 2]) ; "%d", Dinar
			dsCOORD
			180
			6
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			theColor
			dsWIDTH
			25
		)
		(Display 71 5 dsCOORD 217 6 dsALIGN alLEFT dsFONT 300 dsCOLOR theColor) ; "Golden Dinars"
		(= theColor 6)
		(Display
			(Format @str 71 4 [gInvNum 1]) ; "%d", Centime
			dsCOORD
			180
			18
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			theColor
			dsWIDTH
			25
		)
		(Display 71 6 dsCOORD 217 18 dsALIGN alLEFT dsFONT 300 dsCOLOR theColor) ; "Brass Centimes"
		(= theColor
			(cond
				((< totalWeight (/ (* (MaxLoad) 90) 100)) 1)
				((< gNumColors 16) 4)
				(else 12)
			)
		)
		(Display
			(Format @str 71 7 totalWeight) ; "%d#"
			dsCOORD
			180
			30
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			theColor
			dsWIDTH
			25
		)
		(Display 71 8 dsCOORD 217 30 dsALIGN alLEFT dsFONT 300 dsCOLOR theColor) ; "Weight Carried"
		(Display
			(Format @str 71 7 (MaxLoad)) ; "%d#"
			dsCOORD
			180
			42
			dsALIGN
			alRIGHT
			dsFONT
			300
			dsCOLOR
			theColor
			dsWIDTH
			25
		)
		(Display 71 9 dsCOORD 217 42 dsALIGN alLEFT dsFONT 300 dsCOLOR theColor) ; "Max Weight"
		(if [gEgoStats 12] ; magic use
			(Display 71 10 dsCOORD 185 59 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "MP"
			(Display 71 11 dsCOORD 218 59 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "Spells:"
			(Display 71 12 dsCOORD 280 59 dsALIGN alLEFT dsFONT 300 dsCOLOR 1) ; "Skill"
			(= yPos 71)
			(= index 19)
			(= yPos 71)
			(while (< index 30)
				(if (> [gEgoStats index] 0)
					(showSpell index 185 yPos)
					(+= yPos 9)
				)
				(++ index)
			)
		)
		(super doit: exitButton)
		(return (self dispose:))
	)

	(method (dispose)
		(if items
			(Memory memFREE items)
		)
		(if itemNums
			(Memory memFREE itemNums)
		)
		(super dispose:)
	)
)

(instance exitButton of DButton
	(properties
		nsTop 173
		nsLeft 232
		text { Done }
	)
)

(instance selectorItem of DSelector
	(properties
		state 1
		x 37
		y 18
	)

	(method (handleEvent event &tmp rc)
		(switch (event type:)
			(evKEYBOARD
				(if (and (& state $0008) (== (event message:) KEY_RETURN))
					(self showSelf:)
					(return self)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						(self check: event)
						(< (+ nsTop 10) (event y:) (- nsBottom 10))
					)
					(= rc (super handleEvent: event))
					(self showSelf:)
					(return rc)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (showSelf &tmp ix itemNum [str 100])
		(if nItems
			(= ix (Memory memPEEK (+ itemNums (* (self indexOf: cursor) 2))))
			(Format
				@str
				11
				(* ix 2)
				(if (> [gInvNum ix] 1) 115 else 0)
			)
			(= itemNum (+ ix ix 1))
			(if (and (== ix 33) (>= gElementalState 2))
				(= itemNum 118)
			)
			(if (and (== ix 25) (<= 4 gElementalState 8))
				(= itemNum 119)
			)
			(Print 11 itemNum #title @str #window printWindow)
		else
			(Print {                          } #title {Nothing} #window printWindow)
		)
	)
)

