;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use GloryWindow)
(use PseudoMouse)
(use IconBar)
(use GameControls)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	local0
	local1
	local2 = 71
	[local3 11]
	[local14 19]
	[local33 15] = [28 34 50 66 82 98 35 47 59 71 83 95 107 114 119]
	[local48 15] = [28 32 49 64 83 100 32 45 57 71 84 96 110 116 123]
	[local63 15] = [28 33 50 67 83 100 31 44 56 70 83 95 109 117 122]
	[local78 15] = [27 32 49 65 82 99 30 43 56 69 82 94 108 116 121]
	[local93 15] = [27 34 50 66 82 98 31 44 57 70 83 96 109 114 122]
	[local108 15] = [100 11 12 12 13 13 207 207 207 207 207 207 209 12 209]
	[local123 15] = [100 12 12 12 12 12 206 206 206 206 206 206 206 12 206]
	[local138 15] = [100 11 11 11 11 11 207 207 207 207 207 207 207 11 207]
	[local153 15] = [100 11 11 11 11 11 207 207 207 207 207 207 207 11 207]
	[local168 15] = [100 11 12 12 13 13 207 207 207 207 207 207 207 12 207]
	[local183 15] = [0 1 2 3 4 5 7 9 10 1 9 11 12 6 12]
	[local198 15] = [0 1 2 3 4 5 7 8 9 10 11 12 13 6 5]
	[local213 15] = [0 1 2 3 4 3 6 7 8 1 1 9 10 5 1]
	[local228 15] = [0 1 2 3 4 1 8 6 7 0 7 9 7 5 10]
	[local243 15] = [14 0 1 2 3 4 7 6 8 0 9 10 11 5 12]
	[local258 14] = [1 2 3 4 5 7 8 9 10 11 12 13 6 14]
	[local272 15] = [0 1 2 3 4 5 13 6 7 8 9 10 11 12 14]
	[local287 51] = [0 150 80 130 150 100 150 130 100 0 0 100 0 0 90 0 80 150 100 100 100 80 0 100 0 0 0 0 150 120 0 100 100 150 100 100 100 0 100 100 100 100 100 0 100 67 78 68 20 23 27]
	[local338 11] = [0 50 0 0 50 0 50 0 50 0 0]
	[local349 11] = [100 100 50 100 100 100 100 100 100 100 50]
	local360 = 1
	[local361 39]
	local400
	local401 = 50
	[local402 14]
	[local416 14]
	local430 = 1
	local431
	[local432 6] = [71 159 245 71 159 245]
	[local438 6] = [42 42 42 44 46 45]
	local444
	[local445 10]
	[local455 10]
	[local465 5]
)

(procedure (localproc_0 &tmp temp0)
	(cond
		((or (== gHeroType 3) (== gHeroType 0)) ; Paladin, Fighter
			(for ((= temp0 1)) (< temp0 15) ((++ temp0))
				(= [local287 temp0] [gEgoStats (- temp0 1)])
			)
			(if (not [gEgoStats 10]) ; throw
				(= [local287 11] 50)
			)
			(= local360 0)
		)
		((== gHeroType 1) ; Magic User
			(== temp0 16) ; UNINIT
			(while (< temp0 30) ; UNINIT
				(= [local287 temp0] [gEgoStats (- temp0 16)]) ; UNINIT
				(++ temp0) ; UNINIT
			)
			(= local360 1)
		)
		((== gHeroType 2) ; Thief
			(== temp0 31) ; UNINIT
			(while (< temp0 45) ; UNINIT
				(= [local287 temp0] [gEgoStats (- temp0 31)]) ; UNINIT
				(++ temp0) ; UNINIT
			)
			(= local360 2)
		)
	)
	(StrCpy @local361 @global157)
	(= local400 (StrLen @local361))
)

(procedure (localproc_1 param1 param2)
	(Display &rest dsCOORD (+ param2 5) (+ param1 1) dsCOLOR 58 dsWIDTH 30 dsALIGN alCENTER dsFONT 123)
	(Display &rest dsCOORD (+ param2 4) (+ param1 1) dsCOLOR 82 dsWIDTH 30 dsALIGN alCENTER dsFONT 123)
)

(procedure (localproc_2 &tmp [temp0 4] temp4)
	(for ((= temp4 1)) (< temp4 15) ((++ temp4))
		(= [gEgoStats (- temp4 1)] [local402 temp4])
	)
	(if (not [gEgoStats 14]) ; honor
		(= [gEgoStats 14] 50) ; honor
	)
	(= [global211 14] [gEgoStats 14]) ; honor
	(if (== gHeroType 3) ; Paladin
		(= global404 [gEgoStats 14]) ; honor
	)
	(DrawCel 145 6 0 92 134 15)
	(Message msgGET 140 8 0 5 1 @local465) ; "%d"
	(Format @temp0 @local465 local401)
	(Display
		@temp0
		dsCOORD
		(+ 92 (proc0_21 5 5 4 5 5))
		(+ 133 (proc0_21 0 0 2 0 0))
		dsCOLOR
		58
		dsWIDTH
		30
		dsALIGN
		alCENTER
		dsFONT
		(proc0_21 123 123 310 123 123)
	)
	(Display
		@temp0
		dsCOORD
		(+ 92 (proc0_21 4 4 3 4 4))
		(+ 133 (proc0_21 0 0 2 0 0))
		dsCOLOR
		43
		dsWIDTH
		30
		dsALIGN
		alCENTER
		dsFONT
		(proc0_21 123 123 310 123 123)
	)
	(DrawCel 145 6 0 89 172 15)
	(Message msgGET 140 8 0 5 1 @local465) ; "%d"
	(localproc_1
		170
		86
		(Format @temp0 @local465 (= [gEgoStats 16] (gEgo maxHealth:))) ; health
	)
	(DrawCel 145 6 0 287 159 15)
	(localproc_1
		157
		284
		(Format @temp0 @local465 (= [gEgoStats 17] (gEgo maxStamina:))) ; stamina
	)
	(DrawCel 145 6 0 287 172 15)
	(localproc_1
		170
		284
		(Format @temp0 @local465 (= [gEgoStats 18] (gEgo maxMana:))) ; mana
	)
	(DrawCel 145 6 0 285 (proc0_21 135 135 135 135 132) 15)
	(localproc_1
		(proc0_21 133 133 133 133 130)
		283
		(Format @temp0 @local465 [gEgoStats 14]) ; honor
	)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2)
	(for ((= temp0 (FirstNode (param1 elements:)))) temp0 ((= temp0 temp1))
		(= temp1 (NextNode temp0))
		(if (not (IsObject (= temp2 (NodeValue temp0))))
			(return)
		)
		(if (temp2 respondsTo: #owner)
			(temp2 owner: 0)
		)
	)
)

(procedure (localproc_4 &tmp temp0)
	(StrCpy @global157 @local361)
	(if (!= gPrevRoomNum 54) ; import
		(localproc_3 gInventory)
	)
	(gEgo get: 43) ; theNote
	(gEgo get: 15) ; theWaterskin
	(gEgo get: 14 20) ; theRations
	((gInventory at: 14) amount: 20) ; theRations
	(= global424 200)
	(switch local360
		(3
			((gInventory at: 1) state: 1) ; theSword
			(gEgo get: 1) ; theSword
			(gEgo get: 4) ; theChainmail
			(gEgo get: 5) ; theShield
			(if [gEgoStats 12] ; magic use
				(for ((= temp0 19)) (< temp0 30) ((++ temp0))
					(if (not [gEgoStats temp0])
						(= [gEgoStats temp0] [local338 (- temp0 19)])
					)
				)
			)
		)
		(0
			(gEgo get: 1) ; theSword
			(gEgo get: 4) ; theChainmail
			(gEgo get: 5) ; theShield
			(if [gEgoStats 12] ; magic use
				(for ((= temp0 19)) (< temp0 30) ((++ temp0))
					(if (not [gEgoStats temp0])
						(= [gEgoStats temp0] [local338 (- temp0 19)])
					)
				)
			)
		)
		(1
			(gEgo get: 27) ; theGagGift
			(gEgo get: 2) ; theFineDagger
			(if [gEgoStats 12] ; magic use
				(for ((= temp0 19)) (< temp0 30) ((++ temp0))
					(if (not [gEgoStats temp0])
						(= [gEgoStats temp0] [local349 (- temp0 19)])
					)
				)
			)
		)
		(else
			(gEgo get: 7) ; theToolkit
			(gEgo get: 6) ; theGrapnel
			(gEgo get: 2) ; theFineDagger
			(cond
				((not (gEgo has: 10)) ; theDaggers
					(gEgo get: 10 5) ; theDaggers
				)
				((< ((gInventory at: 10) amount:) 5) ; theDaggers
					((gInventory at: 10) amount: 5) ; theDaggers
				)
			)
			(if [gEgoStats 12] ; magic use
				(for ((= temp0 19)) (< temp0 30) ((++ temp0))
					(if (not [gEgoStats temp0])
						(= [gEgoStats temp0] [local338 (- temp0 19)])
					)
				)
			)
		)
	)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(fightChar setCycle: 0 stopUpd:)
	(mageChar setCycle: 0 stopUpd:)
	(thiefChar setCycle: 0 stopUpd:)
	(switch param1
		(0
			(= temp1 0)
		)
		(1
			(= temp1 1)
		)
		(2
			(= temp1 2)
		)
	)
	(theTitle
		setLoop: 0
		cel: temp1
		x: [local432 param1]
		y: [local438 param1]
		priority: 0
		signal: 21
	)
	(if
		(or
			(theTitle onMe: (= temp0 (Event new:)))
			(and (not (HaveMouse)) (not local431))
		)
		(gGame
			setCursor:
				999
				1
				(switch param1
					(0 50)
					(1 140)
					(else 235)
				)
				150
		)
	)
	(temp0 dispose:)
)

(procedure (localproc_6 &tmp [temp0 4])
	(Message msgGET 140 1 6 2 1 @local445) ; "Yes"
	(Message msgGET 140 1 6 3 1 @local455) ; "No"
	(quest init: show: dispose:)
	(Message msgGET 140 8 0 5 1 @temp0) ; "%d"
	(Format @temp0 @local465 local401)
	(Display
		@temp0
		dsCOORD
		(+ 92 (proc0_21 5 5 4 5 5))
		(+ 133 (proc0_21 0 0 2 0 0))
		dsCOLOR
		58
		dsWIDTH
		30
		dsALIGN
		alCENTER
		dsFONT
		(proc0_21 123 123 310 123 123)
	)
	(Display
		@temp0
		dsCOORD
		(+ 92 (proc0_21 4 4 3 4 4))
		(+ 133 (proc0_21 0 0 2 0 0))
		dsCOLOR
		43
		dsWIDTH
		30
		dsALIGN
		alCENTER
		dsFONT
		(proc0_21 123 123 310 123 123)
	)
	(return local0)
)

(procedure (localproc_7 param1)
	(return
		(switch (gGame printLang:)
			(34 [local93 param1])
			(33 [local48 param1])
			(49 [local63 param1])
			(39 [local78 param1])
			(else [local33 param1])
		)
	)
)

(procedure (localproc_8 param1)
	(return
		(switch (gGame printLang:)
			(34 [local168 param1])
			(33 [local123 param1])
			(49 [local138 param1])
			(39 [local153 param1])
			(else [local108 param1])
		)
	)
)

(procedure (localproc_9 param1)
	(return
		(switch (gGame printLang:)
			(34 [local243 param1])
			(33 [local198 param1])
			(49 [local213 param1])
			(39 [local228 param1])
			(else [local183 param1])
		)
	)
)

(instance rm140 of Rm
	(properties
		picture 140
		style 10
		vanishingY 40
	)

	(method (init)
		(gLongSong number: 3 play: hold:)
		(if (== gPrevRoomNum 54) ; import
			(gCurRoom picture: 145)
			(super init: &rest)
			(localproc_0)
			(selectChar start: 1)
			(gCurRoom setScript: selectChar)
		else
			(super init: &rest)
			(Load rsVIEW 145)
			(super init:)
			(HandsOff)
			(gTheIconBar disable:)
			(gGame setCursor: 999 1 153 155)
			(= gUseSortedFeatures 0)
			(= gPMouse 0)
			(gMouseDownHandler add: theTitle fightChar mageChar thiefChar self)
			(gKeyDownHandler add: self theTitle fightChar mageChar thiefChar)
			(gDirectionHandler add: self)
			(theTitle loop: 3 init:)
			(fightChar init:)
			(mageChar init:)
			(thiefChar init:)
			(roundRobin start: 0)
			(self setScript: roundRobin)
		)
	)

	(method (handleEvent event)
		(if local430
			(if (== (event type:) evKEYBOARD)
				(switch (event message:)
					(KEY_TAB
						(event type: $0040) ; direction
						(event message: JOY_RIGHT)
					)
					(KEY_SHIFTTAB
						(event type: $0040) ; direction
						(event message: JOY_LEFT)
					)
					(KEY_RETURN
						(= local430 0)
						(HandsOff)
						(switch (theTitle cel:)
							(0
								(= local360 0)
							)
							(1
								(= local360 1)
							)
							(2
								(= local360 2)
							)
						)
						(roundRobin state: 11 cue:)
					)
					(else
						(super handleEvent: event &rest)
					)
				)
			)
			(cond
				((or (event claimed:) (not local431)) 0)
				((& (event type:) $0040) ; direction
					(switch (event message:)
						(JOY_LEFT
							(event claimed: 1)
							(script
								state:
									(switch (theTitle cel:)
										(0 8)
										(1 1)
										(2 3)
										(else 7)
									)
								cue:
							)
						)
						(JOY_RIGHT
							(event claimed: 1)
							(script
								state:
									(switch (theTitle cel:)
										(0 3)
										(1 8)
										(2 1)
										(else 1)
									)
								cue:
							)
						)
					)
				)
				(else
					(super handleEvent: event &rest)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(DisposeScript 934)
		(UnLoad 128 145)
		(UnLoad 128 142)
		(= gUseSortedFeatures 1)
		(= gPMouse PseudoMouse)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance selectChar of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= gBaseHeroType (= gHeroType local360))
				(gCurRoom picture: 145)
				(DrawPic 145)
				(= global157 0)
				(= cycles 2)
			)
			(1
				(pointsAvail init:)
				(switch local360
					(2
						(= temp0 2)
					)
					(0
						(= temp0 1)
					)
					(1
						(= temp0 0)
					)
				)
				(theChar setLoop: temp0 init:)
				(DrawPic 145 9)
				(= ticks 60)
			)
			(2
				(switch gHeroType
					(0 ; Fighter
						(Message msgGET 140 2 0 0 1 @local3) ; "Fighter"
						(Display
							@local3
							dsCOORD
							62
							31
							dsALIGN
							alCENTER
							dsWIDTH
							200
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsCOLOR
							0
						)
						(Display
							@local3
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsALIGN
							alCENTER
							dsWIDTH
							200
							dsCOORD
							61
							30
							dsCOLOR
							30
						)
					)
					(1 ; Magic User
						(Message msgGET 140 6 0 0 1 @local3) ; "Magic User"
						(Display
							@local3
							dsCOORD
							62
							31
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsCOLOR
							0
							dsALIGN
							alCENTER
							dsWIDTH
							200
						)
						(Display
							@local3
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsCOORD
							61
							30
							dsCOLOR
							30
							dsALIGN
							alCENTER
							dsWIDTH
							200
						)
					)
					(2 ; Thief
						(Message msgGET 140 4 0 0 1 @local3) ; "Thief"
						(Display
							@local3
							dsCOORD
							62
							31
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsCOLOR
							0
							dsALIGN
							alCENTER
							dsWIDTH
							200
						)
						(Display
							@local3
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsCOORD
							61
							30
							dsCOLOR
							30
							dsALIGN
							alCENTER
							dsWIDTH
							200
						)
					)
					(3 ; Paladin
						(Message msgGET 140 5 0 0 1 @local3) ; "Paladin"
						(Display
							@local3
							dsCOORD
							137
							31
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsCOLOR
							0
						)
						(Display
							@local3
							dsFONT
							(proc0_21 123 123 310 123 123)
							dsCOORD
							136
							30
							dsCOLOR
							30
						)
					)
				)
				(startControls init: show: dispose:)
				(gLongSong fade: 0 2 5 1)
				(if local444
					(gCurRoom newRoom: 130)
				else
					(gCurRoom newRoom: 110)
				)
			)
		)
	)
)

(instance startControls of GameControls
	(properties)

	(method (init &tmp temp0)
		(if (!= gPrevRoomNum 54) ; import
			(= local361 0)
		)
		(self add: namePlate)
		(for ((= temp0 1)) (< temp0 6) ((++ temp0))
			(self
				add:
					((selectionIcon new:)
						nsLeft: (localproc_8 temp0)
						nsTop: (localproc_7 temp0)
						cel: (localproc_9 temp0)
						maskCel: (localproc_9 temp0)
						state: [local258 (- temp0 1)]
						yourself:
					)
			)
			(= [local416 temp0] [local287 (+ temp0 (* local360 15))])
			(= [local402 temp0] [local287 (+ temp0 (* local360 15))])
		)
		(self
			add:
				((selectionIcon new:)
					nsLeft: (localproc_8 13)
					nsTop: (localproc_7 13)
					cel: (localproc_9 13)
					maskCel: (localproc_9 13)
					state: [local258 12]
					yourself:
				)
		)
		(= [local416 13] [local287 (+ 13 (* local360 15))])
		(= [local402 13] [local287 (+ 13 (* local360 15))])
		(for ((= temp0 6)) (< temp0 13) ((++ temp0))
			(self
				add:
					((selectionIcon new:)
						nsLeft: (localproc_8 temp0)
						nsTop: (localproc_7 temp0)
						cel: (localproc_9 temp0)
						maskCel: (localproc_9 temp0)
						state: [local258 (- temp0 1)]
						yourself:
					)
			)
			(= [local416 temp0] [local287 (+ temp0 (* local360 15))])
			(= [local402 temp0] [local287 (+ temp0 (* local360 15))])
		)
		(self
			add:
				((selectionIcon new:)
					nsLeft: (localproc_8 14)
					nsTop: (localproc_7 14)
					cel: (localproc_9 14)
					maskCel: (localproc_9 14)
					state: [local258 13]
					yourself:
				)
		)
		(= [local416 14] [local287 (+ 14 (* local360 15))])
		(= [local402 14] [local287 (+ 14 (* local360 15))])
		(self add: startIcon cancelIcon dummyIcon)
		(super init: &rest)
	)

	(method (show)
		(|= state $0020)
		(DrawCel 145 5 0 118 154 15)
		(DrawCel 145 0 0 4 128 15)
		(self eachElementDo: #show)
		((= curIcon (= highlightedIcon (self at: 0))) highlight: 1)
		(localproc_2)
		(gGame
			setCursor: 999 1 (+ (curIcon nsLeft:) 5) (- (curIcon nsBottom:) 2)
		)
		(self doit: hide:)
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

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(cond
			(local400
				(if (& (startIcon signal:) $0004)
					(self enable: startIcon)
					(startIcon show:)
				)
			)
			((not (& (startIcon signal:) $0004))
				(self disable: startIcon)
				(startIcon show:)
			)
		)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp6 0)
		(= temp3 (event message:))
		(= temp4 (event modifiers:))
		(= temp5 (self firstTrue: #onMe event))
		(if (IsObject event)
			(event dispose:)
		)
		(if (IsObject temp5)
			(cond
				((& temp2 $0040) ; direction
					(switch temp3
						(JOY_RIGHT
							(if (and highlightedIcon (highlightedIcon state:))
								(self select: temp5 1)
							)
						)
						(JOY_LEFT
							(if (and highlightedIcon (highlightedIcon state:))
								(self select: temp5 0)
							)
						)
						(JOY_UP
							(if (not highlightedIcon)
								(= highlightedIcon (self at: (- size 1)))
							)
							(self retreat:)
						)
						(JOY_DOWN
							(if (not highlightedIcon)
								(= highlightedIcon (self at: 0))
							)
							(self advance:)
						)
						(JOY_UPRIGHT
							(if (temp5 state:)
								(self select: temp5 3)
							)
						)
						(JOY_DOWNRIGHT
							(if (temp5 state:)
								(self select: temp5 2)
							)
						)
					)
				)
				((== temp2 evNULL)
					(cond
						((not (IsObject temp5))
							(if (IsObject highlightedIcon)
								(highlightedIcon highlight: 0)
								(= highlightedIcon 0)
							)
						)
						((and temp5 (!= temp5 highlightedIcon))
							(= oldMouseY 0)
							(self highlight: temp5)
						)
					)
				)
				((not (IsObject highlightedIcon)) 0)
				((== temp2 evMOUSEBUTTON)
					(cond
						((== temp5 namePlate) 0)
						((not (temp5 state:))
							(self select: temp5 1)
						)
						((== temp4 emSHIFT)
							(self select: temp5 3)
						)
						(else
							(self select: temp5 2)
						)
					)
				)
				((== temp2 evKEYBOARD)
					(switch temp3
						(KEY_ESCAPE
							(= temp6 1)
							(return 0)
						)
						(KEY_RETURN
							(if
								(or
									(== highlightedIcon startIcon)
									(== highlightedIcon cancelIcon)
								)
								(self select: highlightedIcon 1)
							)
						)
						(KEY_TAB
							(cond
								((< (= temp7 (highlightedIcon state:)) 1) 0)
								((< (= temp7 (highlightedIcon state:)) 7)
									(highlightedIcon highlight: 0)
									(= highlightedIcon (self at: (+ temp7 5)))
									(self advance:)
								)
								((< temp7 13)
									(highlightedIcon highlight: 0)
									(= highlightedIcon (self at: (- temp7 5)))
									(self retreat:)
								)
							)
						)
						(else
							(cond
								((!= highlightedIcon namePlate) 0)
								(
									(or
										(<= KEY_a temp3 KEY_z)
										(<= KEY_A temp3 KEY_Z)
										(<= KEY_0 temp3 KEY_9)
									)
									(self select: namePlate temp3)
								)
								((== temp3 KEY_SPACE)
									(self select: namePlate temp3)
								)
								((== temp3 JOY_UPLEFT)
									(self select: namePlate temp3)
								)
							)
						)
					)
				)
			)
		)
		(return temp6)
	)
)

(instance selectionIcon of IconI
	(properties
		view 145
		loop 1
		maskView 145
		maskLoop 2
		highlightColor 9
		lowlightColor 91
	)

	(method (show)
		(self highlight: 0)
		(= nsRight (+ nsLeft (if (< state 7) 102 else 111)))
		(= nsBottom (+ nsTop 12))
	)

	(method (onMe)
		(if (super onMe: &rest)
			(return (= helpVerb 1))
		else
			(if helpVerb
				(self highlight: 0)
				(= helpVerb 0)
			)
			(return 0)
		)
	)

	(method (select param1)
		(switch param1
			(1
				(cond
					((not local401) 0)
					((and (< local401 5) [local402 [local272 state]])
						(= [local402 [local272 state]]
							(+ [local402 [local272 state]] local401)
						)
						(= local401 0)
					)
					((not [local402 [local272 state]])
						(if (>= local401 30)
							(= [local402 [local272 state]]
								(+ [local402 [local272 state]] 10)
							)
							(-= local401 30)
						)
					)
					(else
						(= [local402 [local272 state]]
							(+ [local402 [local272 state]] 5)
						)
						(-= local401 5)
					)
				)
			)
			(0
				(cond
					(
						(==
							[local402 [local272 state]]
							[local416 [local272 state]]
						)
						0
					)
					(
						(and
							(== [local402 [local272 state]] 10)
							(not [local416 [local272 state]])
						)
						(= [local402 [local272 state]] 0)
						(+= local401 30)
					)
					(
						(and
							(< [local402 [local272 state]] 10)
							(not [local416 [local272 state]])
						)
						(+= local401 (+ 20 [local402 [local272 state]]))
						(= [local402 [local272 state]] 0)
					)
					(
						(<
							(-
								[local402 [local272 state]]
								[local416 [local272 state]]
							)
							5
						)
						(+=
							local401
							(-
								[local402 [local272 state]]
								[local416 [local272 state]]
							)
						)
						(= [local402 [local272 state]]
							(-
								[local402 [local272 state]]
								(-
									[local402 [local272 state]]
									[local416 [local272 state]]
								)
							)
						)
					)
					(else
						(= [local402 [local272 state]]
							(- [local402 [local272 state]] 5)
						)
						(+= local401 5)
					)
				)
			)
			(3
				(cond
					((not local401) 0)
					((not [local402 [local272 state]])
						(if (>= local401 30)
							(= [local402 [local272 state]]
								(+ [local402 [local272 state]] 10)
							)
							(-= local401 30)
						else
							0
						)
					)
					(else
						(= [local402 [local272 state]]
							(+ [local402 [local272 state]] 1)
						)
						(-= local401 1)
					)
				)
			)
			(2
				(cond
					(
						(==
							[local402 [local272 state]]
							[local416 [local272 state]]
						)
						0
					)
					(
						(and
							(== [local402 [local272 state]] 10)
							(not [local416 [local272 state]])
						)
						(= [local402 [local272 state]] 0)
						(+= local401 30)
					)
					(else
						(= [local402 [local272 state]]
							(- [local402 [local272 state]] 1)
						)
						(+= local401 1)
					)
				)
			)
		)
		(self highlight: 1)
		(localproc_2)
	)

	(method (highlight param1 &tmp temp0 [temp1 4] temp5 temp6)
		(= temp0 (if (< state 7) 92 else 285))
		(DrawCel view 6 (if (< state 7) 0 else 1) temp0 (+ nsTop 1) 15)
		(if param1
			(DrawCel view loop cel nsLeft nsTop 15)
			(= temp5 43)
			(= temp6 58)
		else
			(DrawCel maskView maskLoop maskCel nsLeft nsTop 15)
			(= temp5 82)
			(= temp6 58)
		)
		(Message msgGET 140 8 0 5 1 @local465) ; "%d"
		(Display
			(Format @temp1 @local465 [local402 [local272 state]])
			dsCOORD
			(- (+ temp0 1) (proc0_21 0 0 1 0 0))
			(+ nsTop (proc0_21 0 0 2 0 0))
			dsCOLOR
			temp6
			dsWIDTH
			25
			dsALIGN
			alRIGHT
			dsFONT
			(proc0_21 123 123 310 123 123)
		)
		(Message msgGET 140 8 0 5 1 @local465) ; "%d"
		(Display
			(Format @temp1 @local465 [local402 [local272 state]])
			dsCOORD
			(- temp0 (proc0_21 0 0 1 0 0))
			(+ nsTop (proc0_21 0 0 2 0 0))
			dsCOLOR
			temp5
			dsWIDTH
			25
			dsALIGN
			alRIGHT
			dsFONT
			(proc0_21 123 123 310 123 123)
		)
	)
)

(instance dummyIcon of IconI
	(properties
		view 145
		loop 0
		cel 0
		nsTop 0
		nsRight 319
		nsBottom 189
	)

	(method (show))

	(method (highlight))

	(method (select))
)

(instance startIcon of IconI
	(properties
		view 145
		loop 3
		cel 0
		nsLeft 127
		nsTop 158
		maskView 145
		maskLoop 3
		maskCel 3
	)

	(method (select &tmp temp0 temp1)
		(if (& (startIcon signal:) $0004)
			(return 0)
		else
			(= local1 0)
			(if (and local401 (localproc_6))
				(return 0)
			else
				(HandsOff)
				(localproc_4)
				(for ((= temp0 1)) (< temp0 15) ((++ temp0))
					(= [global211 (- temp0 1)] [local402 temp0])
				)
				(startControls state: (& (startControls state:) $ffdf))
			)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop 15)
		else
			(DrawCel view loop 0 nsLeft nsTop 15)
		)
	)
)

(instance cancelIcon of IconI
	(properties
		view 145
		loop 4
		cel 0
		nsLeft 127
		nsTop 173
	)

	(method (select)
		(= local1 1)
		(if (localproc_6)
			(HandsOff)
			(ClearFlag 144)
			(= local444 1)
			(startControls state: (& (startControls state:) $ffdf))
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 2 nsLeft nsTop 15)
		else
			(DrawCel view loop 0 nsLeft nsTop 15)
		)
	)
)

(instance namePlate of IconI
	(properties
		view 145
		loop 1
		cel 0
		nsLeft 63
		nsTop 3
		nsRight 263
		nsBottom 15
		maskView 145
		maskLoop 7
	)

	(method (show))

	(method (select param1 &tmp [temp0 4])
		(TextSize @[temp0 0] @local361 3 0)
		(cond
			((== param1 8)
				(if local400
					(StrAt @local361 (-- local400) 0)
					(DrawCel
						maskView
						maskLoop
						maskCel
						(+ nsLeft (proc0_21 40 47 40 38 39))
						(- nsTop (proc0_21 2 1 3 1 1))
						15
					)
					(self highlight: 1)
				)
			)
			((<= [temp0 3] 150)
				(StrAt @local361 local400 param1)
				(StrAt @local361 (++ local400) 0)
				(self highlight: 1)
			)
			(else
				(return 1)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2)
		(= cel (proc0_21 0 14 0 0 0))
		(= nsLeft (proc0_21 62 60 62 62 63))
		(= nsTop (proc0_21 4 3 5 3 3))
		(if param1
			(= temp2 loop)
			(= temp0 43)
			(= temp1 58)
		else
			(= temp2 2)
			(= temp0 82)
			(= temp1 58)
		)
		(DrawCel view temp2 cel nsLeft nsTop 15)
		(Display
			@local361
			dsCOORD
			(+ nsLeft (proc0_21 41 50 41 41 41))
			(+ nsTop 3)
			dsCOLOR
			temp1
			dsWIDTH
			172
			dsALIGN
			alLEFT
			dsFONT
			3
		)
		(Display
			@local361
			dsCOORD
			(+ nsLeft (proc0_21 40 49 40 40 40))
			(+ nsTop 3)
			dsCOLOR
			temp0
			dsWIDTH
			172
			dsALIGN
			alLEFT
			dsFONT
			3
		)
	)
)

(instance theChar of View
	(properties
		x 162
		y 154
		view 140
		priority 14
		signal 16
	)
)

(instance pointsAvail of View
	(properties
		x 92
		y 130
		view 145
		loop 6
		priority 15
		signal 16
	)
)

(instance fightChar of Prop
	(properties
		x 78
		y 139
		view 140
		loop 1
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((not local431)
				(event claimed: 1)
				(return)
			)
			((self onMe: event)
				(= local430 0)
				(HandsOff)
				(= local360 0)
				(theTitle cel: 0)
				(roundRobin state: 11 cue:)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance mageChar of Prop
	(properties
		x 158
		y 139
		view 140
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((not local431)
				(event claimed: 1)
				(return)
			)
			((self onMe: event)
				(= local430 0)
				(HandsOff)
				(= local360 1)
				(theTitle cel: 1)
				(roundRobin state: 11 cue:)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance thiefChar of Prop
	(properties
		x 238
		y 140
		view 140
		loop 2
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((not local431)
				(event claimed: 1)
				(return)
			)
			((self onMe: event)
				(= local430 0)
				(HandsOff)
				(= local360 2)
				(theTitle cel: 2)
				(roundRobin state: 11 cue:)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance chooseTitle of View
	(properties
		x 159
		y 167
		view 141
		cel 3
	)

	(method (handleEvent))
)

(instance theTitle of View
	(properties
		x -10
		y -20
		view 141
		cel 2
		signal 21
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((not local431)
				(event claimed: 1)
				(roundRobin cue:)
				(return)
			)
			((self onMe: (event x:) (event y:))
				(roundRobin state: 11 cue:)
				(= local430 0)
				(HandsOff)
				(switch (self x:)
					(71
						(= temp0 0)
					)
					(159
						(= temp0 1)
					)
					(245
						(= temp0 2)
					)
				)
				(= local360 temp0)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance roundRobin of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(User canControl: 1)
				(User canInput: 1)
				(chooseTitle init: addToPic:)
				(= seconds 2)
			)
			(1
				(Message msgGET 140 7 0 0 1 @local14) ; "Choose a Character"
				(Display
					@local14
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsCOORD
					61
					(proc0_21 153 153 154 153 153)
					dsWIDTH
					200
					dsALIGN
					alCENTER
					dsCOLOR
					0
				)
				(Display
					@local14
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsCOORD
					60
					(proc0_21 152 152 153 152 152)
					dsWIDTH
					200
					dsALIGN
					alCENTER
					dsCOLOR
					30
				)
				(= ticks 1)
			)
			(2
				(= seconds 0)
				(if (gCast contains: fireBall)
					(fireBall dispose:)
				)
				(localproc_5 0)
				(gLongSong2 number: 946 play:)
				(fightChar setCycle: End self)
				(= local431 1)
			)
			(3
				(if (== (theTitle x:) 71)
					(Message msgGET 140 2 0 0 1 @local3) ; "Fighter"
					(Display
						@local3
						dsFONT
						(proc0_21 123 123 310 123 123)
						dsCOORD
						21
						(proc0_21 29 29 30 29 29)
						dsWIDTH
						100
						dsALIGN
						alCENTER
						dsCOLOR
						0
					)
					(Display
						@local3
						dsFONT
						(proc0_21 123 123 310 123 123)
						dsCOORD
						20
						(proc0_21 28 28 29 28 28)
						dsCOLOR
						30
						dsWIDTH
						100
						dsALIGN
						alCENTER
					)
				)
				(= seconds 3)
			)
			(4
				(fightChar setCycle: Beg self)
			)
			(5
				(Load rsVIEW 142)
				(= seconds 0)
				(if (gCast contains: fireBall)
					(fireBall dispose:)
				)
				(localproc_5 1)
				(gLongSong2 number: 948 play:)
				(mageChar setCycle: CT 4 1 self)
			)
			(6
				(if (== (theTitle x:) 159)
					(Message msgGET 140 6 0 0 1 @local3) ; "Magic User"
					(Display
						@local3
						dsFONT
						(proc0_21 123 123 310 123 123)
						dsCOORD
						108
						(proc0_21 29 29 30 29 29)
						dsCOLOR
						0
						dsWIDTH
						100
						dsALIGN
						alCENTER
					)
					(Display
						@local3
						dsFONT
						(proc0_21 123 123 310 123 123)
						dsCOORD
						107
						(proc0_21 28 28 29 28 28)
						dsCOLOR
						30
						dsWIDTH
						100
						dsALIGN
						alCENTER
					)
				)
				(gLongSong2 number: 947 play:)
				(fireBall loop: 0 x: 157 y: 94 init: setCycle: End self)
				(mageChar setCycle: End self)
			)
			(7)
			(8
				(mageChar setCycle: Beg self)
			)
			(9
				(if (gCast contains: fireBall)
					(fireBall dispose:)
				)
				(= seconds 0)
				(localproc_5 2)
				(thiefChar setCycle: End self)
			)
			(10
				(if (== (theTitle x:) 245)
					(Message msgGET 140 4 0 0 1 @local3) ; "Thief"
					(Display
						@local3
						dsFONT
						(proc0_21 123 123 310 123 123)
						dsCOORD
						195
						(proc0_21 29 29 30 29 29)
						dsCOLOR
						0
						dsWIDTH
						100
						dsALIGN
						alCENTER
					)
					(Display
						@local3
						dsFONT
						(proc0_21 123 123 310 123 123)
						dsCOORD
						194
						(proc0_21 28 28 29 28 28)
						dsCOLOR
						30
						dsWIDTH
						100
						dsALIGN
						alCENTER
					)
				)
				(gLongSong2 number: 949 play:)
				(thiefChar setCycle: Beg self)
			)
			(11
				(self changeState: (= state 1))
			)
			(12
				(gMouseDownHandler delete: fightChar mageChar thiefChar theTitle self)
				(gKeyDownHandler delete: self fightChar mageChar thiefChar theTitle)
				(switch (theTitle cel:)
					(0
						(fightChar hide:)
					)
					(1
						(mageChar hide:)
						(fireBall hide:)
					)
					(2
						(thiefChar hide:)
					)
				)
				(gGame setCursor: gTheCursor 0)
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(= cycles 5)
			)
			(14
				(gDirectionHandler delete: self)
				(gCast eachElementDo: #dispose)
				(Animate 0)
				(User canControl: 0)
				(User canInput: 0)
				(gCurRoom setScript: selectChar)
			)
		)
	)
)

(instance fireBall of Actor
	(properties
		y 139
		view 142
		priority 14
		signal 18448
	)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 60
			left: 77
			bottom: 135
			right: 243
			priority: 15
			yourself:
		)
		(self add: titleIcon yesIcon noIcon)
		(super init: &rest)
	)
)

(instance titleIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 50])
		(if local1
			(Message msgGET 140 1 6 4 1 @temp0) ; "Are you sure you want to cancel?"
		else
			(Message msgGET 140 1 6 1 1 @temp0) ; "You still have points available. Do you want to use them?"
		)
		(Display @temp0 dsWIDTH 155 dsCOORD 5 3 dsCOLOR 17)
	)
)

(instance yesIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 40
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local445 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local445 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance noIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 55
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local455 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local455 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

