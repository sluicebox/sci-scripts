;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GameControls)
(use System)

(public
	Teller 0
)

(procedure (localproc_0 param1 param2 param3)
	(Memory memPOKE (+ param1 (* 2 param2)) param3)
)

(class TellerIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 15
		signal 257
		maskView 361
		maskLoop 3
		myHandle 0
		value 0
		notEgo 0
		myTeller 0
	)

	(method (select)
		(myTeller iconValue: value)
		((myTeller theControls:)
			state: (& ((myTeller theControls:) state:) $ffdf)
		)
		(if
			(and
				(or
					(== self ((myTeller theControls:) at: 0))
					(== self ((myTeller theControls:) at: 1))
				)
				(not notEgo)
			)
			(gEgo addHonor: 1 useSkill: 13 10) ; communication
		else
			(gEgo useSkill: 13 5) ; communication
		)
	)

	(method (show &tmp [temp0 29])
		(= nsRight 160)
		(if notEgo
			(Message msgGET 23 0 0 1 1 @temp0) ; "Ask About:"
			(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
		)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
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
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(class Teller of Obj
	(properties
		query 0
		curArray 0
		arrays 0
		keys 0
		client 0
		iconValue 0
		theControls 0
	)

	(method (init param1 param2 param3 param4)
		(= client param1)
		(= curArray param2)
		(= arrays param3)
		(if (> argc 3)
			(= keys param4)
		)
		(client actions: self)
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(return
			(cond
				((and (IsObject client) (== theVerb 2)) ; Talk
					(= iconValue 0)
					(while 1
						(if (self respond:)
							(break)
						)
					)
				)
				((== client gEgo)
					(client doVerb: theVerb)
				)
				(else
					(if (IsObject client)
						(if (> (client modNum:) -1)
							(= temp0 (client modNum:))
						else
							(= temp0 gCurRoomNum)
						)
						(if (Message msgSIZE temp0 (client noun:) theVerb 0 1)
							(gMessager say: (client noun:) theVerb 0 0 temp0)
							(return 1)
						)
					)
					(cond
						((== theVerb 2) ; Talk
							(gMessager say: 1 2 0 0 0 23) ; "This person doesn't seem to be in a talkative mood."
						)
						((== theVerb 1) ; Look
							(gMessager say: 1 1 0 0 0 23) ; "You see a resident of Tarna."
						)
						((== theVerb 4) ; Do
							(gMessager say: 1 4 0 0 0 23) ; "Do not trouble yourself with such actions."
						)
						(
							(OneOf
								theVerb
								80 ; calmSpell
								78 ; dazzleSpell
								76 ; detectMagicSpell
								82 ; fetchSpell
								81 ; flameDartSpell
								83 ; forceBoltSpell
								66 ; healingSpell
								86 ; jugglingLightsSpell
								84 ; levitateSpell
								88 ; lightningBallSpell
								75 ; openSpell
								85 ; reversalSpell
								87 ; summonStaffSpell
								77 ; triggerSpell
								79 ; ???
							)
							(gMessager say: 2 6 7 0 0 23) ; "Casting any spell would seriously offend this person. You don't really want to lose the game this way, do you?"
						)
						((OneOf theVerb 30 59 47 49 54 45 39 51 10 31) ; theBeads, theRoyals, theGem, theHeartGift, theNote, theOpal, thePin, theRobe, Money, theSkins
							(gMessager say: 2 6 4 0 0 23) ; "This object, at this time, is an inappropriate offering."
						)
						((OneOf theVerb 11 20 12 13 56 33) ; theSword, theDaggers, theFineDagger, theFineSpear, theMagicSpear, theRocks
							(gMessager say: 2 6 6 0 0 23) ; "You better not, you might hurt someone."
						)
						(else
							(gMessager say: 2 6 5 0 0 23) ; "This person isn't interested in the object you offer."
						)
					)
				)
			)
		)
	)

	(method (respond)
		(= query 0)
		(self showDialog:)
		(if (and (!= query -999) iconValue)
			(= query iconValue)
		)
		(cond
			((or (not query) (== query -999))
				(return 1)
			)
			((== query 999)
				(self doParent:)
				(return 0)
			)
			((and (< query 0) (not (self doChild: query)))
				(return 1)
			)
		)
		(= query (Abs query))
		(if query
			(gMessager say: (client noun:) 5 query 0)
		)
		(return 1)
	)

	(method (showDialog)
		(self doDialog: (if (== (WordAt arrays 0) curArray) 1 else 0) &rest)
	)

	(method (getSeqNum)
		(return 1)
	)

	(method (doDialog param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 30] temp45)
		(= temp45 150)
		(= temp0 [param1 (= temp3 0)])
		(= temp5 5)
		(= temp8 0)
		(= temp4 0)
		(= temp9 (List new:))
		((= theControls (GameControls new:))
			window:
				((GloryWindow new:)
					top: 40
					left: (proc0_21 85 85 65 85 85)
					bottom: 140
					right: (proc0_21 235 235 255 235 235)
					priority: 15
					yourself:
				)
		)
		(if (!= client gEgo)
			(+= temp5 15)
		)
		(for ((= temp2 1)) (!= (WordAt curArray temp2) 999) ((++ temp2))
			(= temp6 1)
			(for ((= temp3 1)) (and temp6 (< temp3 argc)) ((+= temp3 2))
				(if
					(and
						(== (WordAt curArray temp2) [param1 temp3])
						(not [param1 (+ temp3 1)])
					)
					(= temp6 0)
				)
			)
			(if temp6
				(= temp7 (WordAt curArray temp2))
				(= temp14 (self getSeqNum: (Abs temp7)))
				(if
					(not
						(= temp13
							(Message
								msgSIZE
								gCurRoomNum
								(client noun:)
								2
								(Abs temp7)
								temp14
							)
						)
					)
					(break)
				)
				(= temp1 (Memory memALLOC_NONCRIT temp13))
				(if (> (= temp13 (+ (* temp13 7) 20)) temp45)
					(= temp45 temp13)
				)
				(temp9 add: temp1)
				(Message msgGET gCurRoomNum (client noun:) 2 (Abs temp7) temp14 temp1)
				((= temp4 (TellerIcon new:))
					myHandle: temp1
					value: temp7
					nsTop: temp5
					myTeller: self
				)
				(if (!= client gEgo)
					(temp4 notEgo: 1)
				)
				(theControls add: temp4)
				(++ temp8)
				(+= temp5 15)
			)
		)
		(if (not (IsObject temp4))
			(if (== client gEgo)
				(client doVerb: 2)
			else
				(gMessager say: 1 6 0 0 0 23) ; "They do not seem to speak your language."
			)
			((theControls window:) dispose:)
			(theControls dispose:)
			(temp9 dispose:)
			(return -999)
		)
		(= temp4 (TellerIcon new:))
		(if (not temp0)
			(Message msgGET 23 0 0 2 1 @temp15) ; "Something Else"
			(temp4 myHandle: @temp15 value: 999 nsTop: temp5 myTeller: self)
		else
			(Message msgGET 23 0 0 3 1 @temp15) ; "Enough Already"
			(temp4 myHandle: @temp15 value: -999 nsTop: temp5 myTeller: self)
		)
		(theControls add: temp4)
		((theControls window:)
			top: (- 60 (* 7 temp8))
			bottom: (- (+ temp5 80) (* 7 temp8))
			left: (- (- 160 (/ temp45 2)) (proc0_21 0 0 10 0 0))
			right: (+ 160 (/ temp45 2) (proc0_21 0 0 10 0 0))
		)
		(theControls init: show: dispose:)
		(for
			((= temp10 (FirstNode (temp9 elements:))))
			temp10
			((= temp10 temp11))
			
			(= temp11 (NextNode temp10))
			(if (not (= temp12 (NodeValue temp10)))
				(break)
			else
				(Memory memFREE temp12)
			)
		)
		(return (temp9 dispose:))
	)

	(method (doChild param1 &tmp temp0)
		(= temp0 0)
		(while (++ temp0)
			(if (== (WordAt keys temp0) param1)
				(self stuffArray: (WordAt arrays temp0) 1)
				(return 1)
			)
			(< (WordAt keys temp0) 999)
		)
		(return 1)
	)

	(method (doParent)
		(self stuffArray: (WordAt curArray 0) 0)
	)

	(method (stuffArray param1 param2)
		(if param2
			(localproc_0 param1 0 curArray)
		)
		(= curArray param1)
		(return param2)
	)

	(method (cue))
)

