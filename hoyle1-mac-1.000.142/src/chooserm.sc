;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use CursorCoords)
(use DisplayBox)
(use Game)
(use Actor)
(use System)

(public
	chooserm 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4 = 1
	local5 = 1
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2) ; UNUSED
	(= temp1 (= temp0 (GetTime 1))) ; SysTime12
	(while param1
		(= temp2 (Event new:))
		(if (or (== (temp2 type:) evMOUSEBUTTON) (== (temp2 type:) evKEYBOARD))
			(temp2 dispose:)
			(return)
		)
		(temp2 dispose:)
		(= temp0 (GetTime 1)) ; SysTime12
		(if (!= temp1 temp0)
			(= temp1 temp0)
			(if (not (-- param1))
				(if (== argc 2)
					(param2 cue:)
					(continue)
				)
			else
				(continue)
			)
		else
			(continue)
		)
		(return)
	)
)

(class AltrEgo of Person
	(properties
		altrEgo 0
		playerNum 0
		altrEgoX 0
		altrEgoY 0
		speakFrom 0
		chosen 0
		frame 0
		frameCel 0
		portraitPri 14
		cursorX 0
		cursorY 0
	)

	(method (deleteCast)
		(gCast delete: frame)
	)

	(method (addCast)
		(gCast add: frame)
	)

	(method (init)
		(Load rsVIEW playerNum)
		(= view playerNum)
		(= altrEgo self)
		(altrEgo
			skill:
				(switch global503
					(1
						(altrEgo crazy8sSkill:)
					)
					(3
						(altrEgo heartsSkill:)
					)
					(4
						(altrEgo ginSkill:)
					)
					(5
						(altrEgo cribbageSkill:)
					)
					(else 0)
				)
		)
		(altrEgoList add: altrEgo)
		(super init: self 1)
		(iList add: self)
		(global517 add: self)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if
			(and
				(<= (- altrEgoX 16) (event x:) (+ altrEgoX 16))
				(<= (- altrEgoY 6) (event y:) (+ altrEgoY 35))
			)
			(gSysWindow setBack: 14 setColor: 4)
			(event claimed: 1)
			(cond
				((chosenList contains: self)
					(frame dispose:)
					(= frame 0)
					(chosenList delete: self)
					(proc0_5)
					(cond
						((< (= global264 (Random 0 15)) 10)
							(altrEgo upset:)
						)
						((< global264 15)
							(altrEgo anger:)
						)
						((== global264 15)
							(altrEgo shock:)
						)
					)
				)
				((< (chosenList size:) local3)
					((= frame (View new:))
						view: 600
						setLoop: 1
						setCel: frameCel
						posn: altrEgoX altrEgoY
						ignoreActors:
						setPri: 14
						init:
						stopUpd:
					)
					(chosenList add: self)
					((self altrEgo:) smile:)
					(gCast delete: hereInput)
					(chosenList eachElementDo: #deleteCast)
					(altrEgo clearExps: noExp: showExp:)
					(proc0_5)
					(altrEgo say: 1 1 (if (== global503 2) 0 else altrEgo))
				)
				(else
					(chosenList eachElementDo: #deleteCast)
					(altrEgo say: 2)
				)
			)
		)
	)

	(method (dispose)
		(altrEgo clearExps:)
		((altrEgo expressions:) dispose:)
		(super dispose:)
	)
)

(instance chooserm of Rm
	(properties
		picture 11
	)

	(method (init &tmp temp0)
		(= temp0 (Graph grGET_COLOURS))
		(if (== 2 temp0)
			(Load rsVIEW 801)
		else
			(Load rsVIEW 800)
		)
		((= global517 inList) add:)
		(super init:)
		(Load rsVIEW 600)
		(Load rsVIEW 161)
		(Format @global520 708 0) ; "The Kid's my name, the best card player this side of the Mississippi. I've been playing cards for years, against all the best players in the world, so I'm good at all of these games, of course. How 'bout a friendly little game?"
		(chosenList add:)
		(altrEgoList add:)
		(switch global503
			(1
				(= local3 3)
				(= local4 1)
				(= local0
					(Display ; "CHOOSE 1 TO 3 OPPONENTS FOR CRAZY EIGHTS."
						102
						0
						dsCOORD
						6
						5
						dsCOLOR
						(if (== (Graph grGET_COLOURS) 2) 15 else 0)
						dsWIDTH
						308
						dsALIGN
						alCENTER
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
			)
			(2
				(= local3 3)
				(= local4 3)
				(= local0
					(Display ; "CHOOSE 3 FRIENDS TO PLAY OLD MAID WITH."
						102
						1
						dsCOORD
						6
						5
						dsCOLOR
						(if (== (Graph grGET_COLOURS) 2) 15 else 0)
						dsWIDTH
						308
						dsALIGN
						alCENTER
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
			)
			(3
				(= local3 3)
				(= local4 2)
				(= local0
					(Display ; "CHOOSE 2 OR 3 OPPONENTS FOR HEARTS"
						102
						2
						dsCOORD
						6
						5
						dsCOLOR
						(if (== (Graph grGET_COLOURS) 2) 15 else 0)
						dsWIDTH
						308
						dsALIGN
						alCENTER
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
			)
			(4
				(= local3 1)
				(= local0
					(Display ; "CHOOSE 1 OPPONENT FOR GIN RUMMY"
						102
						3
						dsCOORD
						6
						5
						dsCOLOR
						(if (== (Graph grGET_COLOURS) 2) 15 else 0)
						dsWIDTH
						308
						dsALIGN
						alCENTER
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
			)
			(5
				(= local3 1)
				(= local0
					(Display ; "CHOOSE 1 OPPONENT FOR CRIBBAGE"
						102
						4
						dsCOORD
						6
						5
						dsCOLOR
						(if (== (Graph grGET_COLOURS) 2) 15 else 0)
						dsWIDTH
						308
						dsALIGN
						alCENTER
						dsFONT
						0
						dsSAVEPIXELS
					)
				)
			)
		)
		(= local1
			(Display ; "Then press      to play"
				102
				5
				dsCOORD
				6
				15
				dsCOLOR
				(if (== (Graph grGET_COLOURS) 2) 15 else 0)
				dsWIDTH
				308
				dsALIGN
				alCENTER
				dsFONT
				0
				dsSAVEPIXELS
			)
		)
		(proc0_2 600 2 0 77 31)
		(proc0_2 600 2 1 239 31)
		(hereInput init:)
		(iList add: hereInput)
		(theKidA init:)
		(dijonA init:)
		(jerryA init:)
		(warrenA init:)
		(larryA init:)
		(silvermanA init:)
		(sonnyA init:)
		(thelmaA init:)
		(rosellaA init:)
		(rogerA init:)
		(bullDogA init:)
		(lennyA init:)
		(shellyA init:)
		(grahamA init:)
		(dianeA init:)
		(devinA init:)
		(cassieA init:)
		(christinaA init:)
		(if (not (HaveMouse))
			(SetCursor 999 1 171 23)
		)
	)

	(method (doit)
		(if local5
			(-- local5)
			(if (not (HaveMouse))
				(SetCursor 999 1 171 23)
			)
		)
		(if local2
			(= gNormalCursor 999)
			(gGame setCursor: 999 (HaveMouse))
			(= global500 (= global501 (= global502 0)))
			(= global500 ((chosenList at: 0) playerNum:))
			(= global501
				(if (> (chosenList size:) 1)
					(= global501 ((chosenList at: 1) playerNum:))
				)
			)
			(= global502
				(if (> (chosenList size:) 2)
					(= global502 ((chosenList at: 2) playerNum:))
				)
			)
			(if (== (chosenList size:) 1)
				(= global501 global500)
				(= global500 0)
			)
			(gCurRoom newRoom: global503)
		)
		(if global504
			(global504 doit:)
		else
			(if
				(and
					(chosenList size:)
					(not (gCast contains: ((chosenList at: 0) frame:)))
				)
				(gCast add: hereInput)
				(chosenList eachElementDo: #addCast)
			)
			(altrEgoList eachElementDo: #doit)
		)
		(global300 doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if
			(or
				(== (event type:) evMOUSEBUTTON)
				(and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
			)
			(if global504
				(global300 dispose:)
			else
				(iList eachElementDo: #handleEvent event)
			)
		)
		(event claimed: 1)
	)

	(method (dispose)
		(altrEgoList empty: dispose:)
		(chosenList empty: dispose:)
		(iList empty: dispose:)
		(Display 102 6 dsRESTOREPIXELS local0)
		(Display 102 6 dsRESTOREPIXELS local1)
		(Display 102 7 dsCOORD 6 13 dsCOLOR 15 dsWIDTH 308 dsALIGN alCENTER dsFONT 0) ; "Just a moment..."
		(global517 eachElementDo: #dispose empty: dispose:)
		(DisposeScript 891)
		(DisposeScript 896)
		(super dispose:)
	)
)

(instance iList of WL
	(properties)
)

(instance altrEgoList of WL
	(properties)
)

(instance chosenList of WL
	(properties)
)

(instance hereInput of CView
	(properties
		y 15
		x 152
		view 600
		cursorX 171
		cursorY 23
	)

	(method (init)
		(self setPri: 8 posn: x y ignoreActors:)
		(global517 add: self)
		(super init:)
	)

	(method (handleEvent event)
		(if (and (<= x (event x:) (+ x 39)) (<= y (- (event y:) 10) (+ y 8)))
			(if (<= local4 (chosenList size:) local3)
				(self hide:)
				(= local2 self)
			else
				(gCast delete: self)
				(chosenList eachElementDo: #deleteCast)
				(gSysWindow setBack: 14 setColor: 4)
				((altrEgoList at: (Random 0 17)) say: 3)
			)
		)
	)
)

(instance theKidA of AltrEgo
	(properties
		crazy8sSkill 2
		heartsSkill 2
		ginSkill 2
		cribbageSkill 2
		playerNum 1
		altrEgoX 28
		altrEgoY 57
		portraitPri 12
		cursorX 38
		cursorY 70
	)
)

(instance thelmaA of AltrEgo
	(properties
		crazy8sSkill 2
		heartsSkill 2
		ginSkill 2
		cribbageSkill 2
		playerNum 9
		altrEgoX 28
		altrEgoY 109
		portraitPri 13
		cursorX 38
		cursorY 122
	)
)

(instance dijonA of AltrEgo
	(properties
		crazy8sSkill 1
		heartsSkill 1
		cribbageSkill 1
		playerNum 2
		altrEgoX 28
		altrEgoY 160
		cursorX 38
		cursorY 173
	)
)

(instance jerryA of AltrEgo
	(properties
		crazy8sSkill 1
		playerNum 3
		altrEgoX 190
		altrEgoY 109
		speakFrom 1
		portraitPri 13
		cursorX 200
		cursorY 122
	)
)

(instance warrenA of AltrEgo
	(properties
		crazy8sSkill 2
		heartsSkill 2
		ginSkill 2
		cribbageSkill 2
		playerNum 4
		altrEgoX 76
		altrEgoY 57
		portraitPri 12
		cursorX 86
		cursorY 70
	)
)

(instance silvermanA of AltrEgo
	(properties
		crazy8sSkill 2
		heartsSkill 2
		ginSkill 1
		cribbageSkill 2
		playerNum 6
		altrEgoX 76
		altrEgoY 109
		portraitPri 13
		cursorX 86
		cursorY 122
	)
)

(instance shellyA of AltrEgo
	(properties
		crazy8sSkill 2
		heartsSkill 1
		ginSkill 1
		cribbageSkill 1
		playerNum 14
		altrEgoX 76
		altrEgoY 160
		cursorX 86
		cursorY 173
	)
)

(instance dianeA of AltrEgo
	(properties
		crazy8sSkill 1
		heartsSkill 2
		ginSkill 2
		cribbageSkill 1
		playerNum 16
		altrEgoX 124
		altrEgoY 57
		portraitPri 12
		cursorX 134
		cursorY 70
	)
)

(instance lennyA of AltrEgo
	(properties
		crazy8sSkill 2
		heartsSkill 1
		ginSkill 1
		cribbageSkill 1
		playerNum 13
		altrEgoX 124
		altrEgoY 109
		portraitPri 13
		cursorX 134
		cursorY 122
	)
)

(instance sonnyA of AltrEgo
	(properties
		crazy8sSkill 1
		ginSkill 2
		cribbageSkill 2
		playerNum 8
		altrEgoX 124
		altrEgoY 160
		cursorX 134
		cursorY 173
	)
)

(instance larryA of AltrEgo
	(properties
		heartsSkill 1
		cribbageSkill 1
		playerNum 5
		altrEgoX 190
		altrEgoY 57
		speakFrom 1
		portraitPri 12
		cursorX 200
		cursorY 70
	)
)

(instance rogerA of AltrEgo
	(properties
		ginSkill 1
		playerNum 11
		altrEgoX 190
		altrEgoY 160
		speakFrom 1
		cursorX 200
		cursorY 173
	)
)

(instance bullDogA of AltrEgo
	(properties
		crazy8sSkill 2
		heartsSkill 1
		ginSkill 1
		playerNum 12
		altrEgoX 238
		altrEgoY 57
		speakFrom 1
		portraitPri 12
		cursorX 248
		cursorY 70
	)
)

(instance grahamA of AltrEgo
	(properties
		heartsSkill 1
		cribbageSkill 2
		playerNum 15
		altrEgoX 238
		altrEgoY 109
		speakFrom 1
		portraitPri 13
		cursorX 248
		cursorY 122
	)
)

(instance rosellaA of AltrEgo
	(properties
		crazy8sSkill 2
		ginSkill 1
		playerNum 10
		altrEgoX 238
		altrEgoY 160
		speakFrom 1
		cursorX 248
		cursorY 173
	)
)

(instance devinA of AltrEgo
	(properties
		crazy8sSkill 1
		playerNum 17
		altrEgoX 286
		altrEgoY 57
		speakFrom 1
		portraitPri 12
		cursorX 296
		cursorY 70
	)
)

(instance cassieA of AltrEgo
	(properties
		crazy8sSkill 1
		playerNum 18
		altrEgoX 286
		altrEgoY 109
		speakFrom 1
		portraitPri 13
		cursorX 296
		cursorY 122
	)
)

(instance christinaA of AltrEgo
	(properties
		crazy8sSkill 1
		playerNum 19
		altrEgoX 286
		altrEgoY 160
		speakFrom 1
		cursorX 296
		cursorY 173
	)
)

(instance inList of InputList
	(properties)
)

