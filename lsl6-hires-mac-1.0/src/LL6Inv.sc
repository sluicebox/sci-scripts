;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use fileScr)
(use Print)
(use IconBar)
(use Timer)
(use Sound)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	LL6Inv 0
	mTimer 1
	cTimer 2
	redXScr 3
	wTimer 4
	selectorRect 5
)

(local
	local0
)

(class LL6InvItem of InvI
	(properties
		modNum 85
		signal 4
		highlightColor 8
		lowlightColor 21
	)

	(method (cue)
		(return 0)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(Message msgGET modNum noun 0 14 1 (global186 data:))
		(cond
			((Message msgGET modNum noun theVerb 0 1)
				(gMessager say: noun theVerb 0 0 0 modNum)
			)
			((and (Message msgGET modNum noun 0 0 1) (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(gMessager say: noun 0 0 0 0 modNum)
			)
			(else
				(gGame setScript: redXScr)
			)
		)
	)

	(method (show param1 param2 param3 param4)
		(if argc
			(= nsRight (+ (= nsLeft param1) param3))
			(= nsBottom (+ (= nsTop param2) param4))
		)
		(self posn: nsLeft nsTop)
		(AddScreenItem self)
		(SetNowSeen self)
	)

	(method (highlight param1)
		(if (or (not argc) param1)
			(if (not (& (self signal:) $0004))
				(gInventory highlightedIcon: self)
				(SetNowSeen self)
				(selectorRect show: posn: nsLeft 0 doit:)
			)
		else
			(gInventory highlightedIcon: 0)
			(selectorRect hide:)
		)
	)
)

(class LL6Inv of Inv
	(properties
		normalHeading 9
		empty 27
		iconBottom -14
		iconRight 104
		planeTop 2
		planeBottom 11
		planeLeft 203
		planeRight 306
		itemWide 15
		itemHigh 12
		rightScroller 0
		leftScroller 0
		beforeCount 0
		afterCount 0
	)

	(method (init &tmp temp0)
		(= gInventory self)
		(= owner -2)
		(self
			add:
				(badge setCursor: 18 0 0 yourself:)
				(batteries setCursor: 28 0 0 yourself:)
				(beaver setCursor: 50 0 0 yourself:)
				(beer setCursor: 19 0 0 yourself:)
				(belt setCursor: 34 0 0 yourself:)
				(bracelet setCursor: 21 0 0 yourself:)
				(brochure setCursor: 52 0 0 yourself:)
				(champagne setCursor: 23 0 0 yourself:)
				(condom setCursor: 13 0 0 yourself:)
				(cord setCursor: 29 0 0 yourself:)
				(diamond setCursor: 26 0 0 yourself:)
				(collar setCursor: 25 0 0 yourself:)
				(bastardfile setCursor: 2 0 0 yourself:)
				(filter setCursor: 35 0 0 yourself:)
				(flashlight setCursor: 27 0 0 yourself:)
				(floss setCursor: 10 0 0 yourself:)
				(flowers setCursor: 16 0 0 yourself:)
				(gown setCursor: 22 0 0 yourself:)
				(handcuffs setCursor: 24 0 0 yourself:)
				(handcreme setCursor: 9 0 0 yourself:)
				(towerkey setCursor: 47 0 0 yourself:)
				(randomKey setCursor: 48 0 0 yourself:)
				(roomkey setCursor: 1 0 0 yourself:)
				(lamp setCursor: 38 0 0 yourself:)
				(lard setCursor: 33 0 0 yourself:)
				(match setCursor: 40 0 0 yourself:)
				(minwater setCursor: 15 0 0 yourself:)
				(orange setCursor: 37 0 0 yourself:)
				(orchid setCursor: 17 0 0 yourself:)
				(pearl setCursor: 32 0 0 yourself:)
				(glasscase setCursor: 43 0 0 yourself:)
				(sunglasses setCursor: 44 0 0 yourself:)
				(polishcloth setCursor: 45 0 0 yourself:)
				(sculpture setCursor: 31 0 0 yourself:)
				(soap setCursor: 7 0 0 yourself:)
				(swimsuit setCursor: 46 0 0 yourself:)
				(toiletcover setCursor: 12 0 0 yourself:)
				(toiletpaper setCursor: 11 0 0 yourself:)
				(towel setCursor: 3 0 0 yourself:)
				(washcloth setCursor: 4 0 0 yourself:)
				(wordsOWisdom setCursor: 53 0 0 yourself:)
				(wrench setCursor: 14 0 0 yourself:)
				selectorRect
			eachElementDo: #posn -100 0
		)
		(super init: &rest)
		(if (!= planeLeft planeRight)
			(plane
				setRect: planeLeft planeTop planeRight planeBottom
				back: (if temp0 40 else 0) ; UNINIT
			)
		)
		(= leftScroller lScroller)
		(= rightScroller rScroller)
	)

	(method (drawInvItems)
		(self setCountValues:)
		(cond
			(beforeCount
				(if (not ((ScriptID 0 1) contains: leftScroller)) ; controlSet
					(leftScroller init: (ScriptID 0 1) yourself:) ; controlSet
				)
			)
			(((ScriptID 0 1) contains: leftScroller) ; controlSet
				(leftScroller dispose:)
			)
		)
		(cond
			((> afterCount (- (if (IsHiRes) 7 else 9) 1))
				(if (not ((ScriptID 0 1) contains: rightScroller)) ; controlSet
					(rightScroller init: (ScriptID 0 1) yourself:) ; controlSet
				)
			)
			(((ScriptID 0 1) contains: rightScroller) ; controlSet
				(rightScroller dispose:)
			)
		)
		(if (selectorRect isNotHidden:)
			(selectorRect hide:)
		)
		(super drawInvItems: &rest)
		(if highlightedIcon
			(highlightedIcon highlight:)
		)
		(plane setRect: planeLeft planeTop planeRight planeBottom 1)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(event globalize:)
		(= temp1 0)
		(= temp2
			(if (& (event type:) $4001) ; evVERB | evMOUSEBUTTON
				(not (event modifiers:))
			)
		)
		(cond
			((and (plane onMe: event) temp2)
				(event localize: plane)
				(if (= temp0 (self firstTrue: #onMe event))
					(if (== (event message:) JOY_DOWN)
						(gGame setCursor: (temp0 getCursor:))
						(gTheIconBar curIcon: temp0)
						(self curIcon: temp0)
						(temp0 highlight: 1)
					else
						(temp0 doVerb: (event message:))
					)
				)
				(event claimed: 1 globalize:)
			)
			((gControlPlane onMe: event)
				(event localize: gControlPlane)
				(cond
					(
						(and
							((ScriptID 0 1) contains: rightScroller) ; controlSet
							(rightScroller onMe: event)
							(= temp1 1)
							temp2
							(rightScroller select: 1)
						)
						(event claimed: 1)
						(self
							setCountValues:
							setCurIndex: (if (IsHiRes) 7 else 9) 0
						)
						(self setCurIndexToItem: (self at: curIndex))
					)
					(
						(and
							((ScriptID 0 1) contains: leftScroller) ; controlSet
							(leftScroller onMe: event)
							(= temp1 1)
							temp2
							(leftScroller select: 1)
						)
						(event claimed: 1)
						(self
							setCountValues:
							setCurIndex:
								(if (< beforeCount (if (IsHiRes) 7 else 9))
									(* beforeCount -1)
								else
									(* (if (IsHiRes) 7 else 9) -1)
								)
								0
						)
						(self setCurIndexToItem: (self at: curIndex))
					)
					((!= (gTheIconBar curIcon:) (ScriptID 0 3)) ; icon0
						(event claimed: 1)
					)
				)
				(cond
					(temp1
						(if (not local0)
							(= local0 1)
							(gGame setCursor: gNormalCursor)
						)
					)
					(local0
						(= local0 0)
						(gGame setCursor: (gTheIconBar getCursor:))
					)
				)
				(event globalize:)
			)
		)
		(if (and (not temp1) local0)
			(= local0 0)
			(gGame setCursor: (gTheIconBar getCursor:))
		)
		(event claimed:)
	)

	(method (show &tmp temp0)
		(= temp0 gTheCursor)
		(super show: &rest)
		(gGame setCursor: temp0)
	)

	(method (drawIcons)
		(return 0)
	)

	(method (hide &tmp temp0)
		(= temp0 curIcon)
		(= curIcon 0)
		(super hide: &rest)
		(= curIcon temp0)
	)

	(method (dispose)
		(if ((ScriptID 0 1) contains: leftScroller) ; controlSet
			(leftScroller dispose:)
		)
		(if ((ScriptID 0 1) contains: rightScroller) ; controlSet
			(rightScroller dispose:)
		)
		(super dispose: &rest)
	)

	(method (setCurIndexToItem param1 &tmp temp0)
		(self setCurIndexTo: (self indexOf: param1) setCountValues:)
		(if (< afterCount (if (IsHiRes) 7 else 9))
			(= temp0 (- (if (IsHiRes) 7 else 9) afterCount))
			(if (< beforeCount temp0)
				(self setCurIndexTo: 0)
			else
				(self setCurIndex: (* (- temp0 1) -1))
			)
		)
	)

	(method (setCountValues &tmp temp0 temp1)
		(for
			((= temp0 (= afterCount (= beforeCount 0))))
			(< temp0 size)
			((++ temp0))
			
			(= temp1 (self at: temp0))
			(if (and (temp1 isKindOf: InvI) (temp1 ownedBy: owner))
				(cond
					((< temp0 curIndex)
						(++ beforeCount)
					)
					((> temp0 curIndex)
						(++ afterCount)
					)
				)
			)
		)
	)
)

(instance selectorRect of View
	(properties
		x -100
		y -100
		priority 200
		fixPriority 1
		view 957
	)

	(method (init)
		(if (IsHiRes)
			(= view 9602)
		)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance badge of LL6InvItem
	(properties
		noun 3
		message 10
		mainView 18
	)
)

(instance batteries of LL6InvItem
	(properties
		noun 7
		message 25
		mainView 28
	)
)

(instance beaver of LL6InvItem
	(properties
		noun 8
		message 48
		mainView 50
	)
)

(instance beer of LL6InvItem
	(properties
		noun 9
		message 9
		mainView 19
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; washcloth
				(washcloth doVerb: 9)
			)
			(4 ; Do
				(gEgo doVerb: 9)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance belt of LL6InvItem
	(properties
		noun 30
		message 11
		mainView 34
	)
)

(instance brochure of LL6InvItem
	(properties
		noun 10
		message 54
		mainView 52
	)
)

(instance collar of LL6InvItem
	(properties
		noun 12
		message 22
		mainView 25
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame changeScore: 10 155)
				(gEgo put: 11 get: 10) ; collar, diamond
				(Message msgGET 85 12 0 14 1 (global186 data:)) ; "Your Dog Collar"
				(gMessager say: 12 4 0 0 0 85) ; "You carefully remove the large diamond and discard the stupid dog collar."
				(return 1)
			)
			(1 ; Look
				(if (self state:)
					(Message msgGET 85 12 0 14 1 (global186 data:)) ; "Your Dog Collar"
					(gMessager say: 12 1 0 0 0 85) ; "Thunderbird may have been sadistic, but at least she has a generous side: your new dog collar came complete with a large diamond!"
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance condom of LL6InvItem
	(properties
		noun 31
		message 65
		mainView 13
	)
)

(instance cord of LL6InvItem
	(properties
		noun 11
		message 26
		mainView 29
		owner 580
	)

	(method (init)
		(= mainView 29)
		(= message 26)
		(= noun 11)
		(= owner 580)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 31)
						(gCurRoom cue:)
					)
					(
						(and
							(gCast contains: gEgo)
							(not (proc79_14))
							(!= (self message:) 27)
						)
						(gGame setScript: (ScriptID 77 2)) ; stripTWire
						(self
							view: 30
							message: 27
							noun: 4
							setCursor: 30 0 0
							yourself:
						)
						(if (not (& signal $0004))
							(|= signal $0004)
							(DeleteScreenItem self)
						)
						(gInventory show:)
						(return 1)
					)
					((!= (self message:) 27)
						(self
							view: 30
							message: 27
							noun: 4
							setCursor: 30 0 0
							yourself:
						)
						(if (not (& signal $0004))
							(|= signal $0004)
							(DeleteScreenItem self)
						)
						(gGame changeScore: 12 151)
						(Message msgGET 85 11 0 14 1 (global186 data:)) ; "Electrical Cord"
						(gMessager say: 11 4 0 0 0 85) ; "You carefully strip away approximately two centimeters of insulation from the end of the wire without the 3-pin grounded plug."
						(gInventory show:)
						(return 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance champagne of LL6InvItem
	(properties
		noun 32
		message 19
		mainView 23
		owner 860
	)

	(method (cue)
		(if (or argc (== message 19))
			((ScriptID 85 2) setReal: self 0 10) ; cTimer
			(self message: 20 noun: 54)
		else
			(self message: 19 noun: 32)
		)
	)
)

(instance diamond of LL6InvItem
	(properties
		noun 33
		message 23
		mainView 26
	)
)

(instance bastardfile of LL6InvItem
	(properties
		noun 5
		message 63
		mainView 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; randomKey
				(randomKey doVerb: 63)
			)
			(4 ; Do
				(if (not (proc79_14))
					(gGame setScript: (ScriptID 79 13)) ; fileScr
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance filter of LL6InvItem
	(properties
		noun 34
		message 32
		mainView 35
		owner 330
	)

	(method (init)
		(= mainView 35)
		(= message 32)
		(= noun 34)
		(= owner 330)
		(super init: &rest)
	)

	(method (cue)
		(self setCursor: 36 0 0 view: 36 message: 33 noun: 53)
	)
)

(instance flashlight of LL6InvItem
	(properties
		noun 14
		message 24
		mainView 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gEgo has: 1)) ; batteries
					(gEgo get: 1) ; batteries
					(gGame changeScore: 20 160)
					(super doVerb: theVerb)
				else
					(Message msgGET 85 14 0 14 1 (global186 data:)) ; "Big Flashlight"
					(gMessager say: 14 4 3 0 0 85) ; "You slyly turn the flashlight on, then off. Nothing happens. You hope Art doesn't notice his flashlight now weighs considerably less than it did when he gave it to you."
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance floss of LL6InvItem
	(properties
		noun 15
		message 60
		mainView 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; polishcloth
				(gGame changeScore: 20 156)
				(gEgo put: 15 put: 32) ; floss, polishcloth
				(gEgo get: 35) ; swimsuit
				(Message msgGET 85 15 0 14 1 (global186 data:)) ; "Dental Floss"
				(gMessager say: 15 46 0 0 0 85) ; "You deftly attach the dental floss to the sunglasses polishing cloth to form..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flowers of LL6InvItem
	(properties
		noun 35
		message 66
		mainView 16
	)
)

(instance glasscase of LL6InvItem
	(properties
		noun 17
		message 44
		mainView 43
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(switch state
					(0
						(++ state)
						(gGame changeScore: 4 152)
						(Message msgGET 85 17 0 14 1 (global186 data:)) ; "Sunglasses Case"
						(gMessager say: 17 4 7 0 0 85) ; "You open the sunglasses case."
						(return 1)
					)
					(1
						(++ state)
						(gEgo get: 31) ; sunglasses
						(gGame changeScore: 4 153)
						(Message msgGET 85 17 0 14 1 (global186 data:)) ; "Sunglasses Case"
						(gMessager say: 17 4 4 0 0 85) ; "Hey, nice pair of shades! Perfect for lounging around poolside!"
						(return 1)
					)
					(2
						(++ state)
						(gEgo put: 30 put: 31 get: 32) ; glasscase, sunglasses, polishcloth
						(gGame changeScore: 8 154)
						(Message msgGET 85 17 0 14 1 (global186 data:)) ; "Sunglasses Case"
						(gMessager say: 17 4 5 0 0 85) ; "These MUST be deluxe sunglasses; they come complete with their very own cute little white polishing cloth."
						(return 1)
					)
				)
			)
			(1 ; Look
				(switch state
					(0
						(= temp0 7)
					)
					(1
						(= temp0 4)
					)
					(2
						(= temp0 5)
					)
				)
				(Message msgGET 85 17 0 14 1 (global186 data:)) ; "Sunglasses Case"
				(gMessager say: 17 1 temp0 0 0 85)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gown of LL6InvItem
	(properties
		noun 36
		message 18
		mainView 22
	)

	(method (init)
		(= mainView 22)
		(= message 18)
		(= noun 36)
		(super init: &rest)
	)
)

(instance handcuffs of LL6InvItem
	(properties
		noun 37
		message 12
		mainView 24
		owner 850
	)

	(method (init)
		(= mainView 24)
		(= message 12)
		(= noun 37)
		(= owner 850)
		(super init: &rest)
	)
)

(instance handcreme of LL6InvItem
	(properties
		noun 38
		message 59
		mainView 9
	)
)

(instance lamp of LL6InvItem
	(properties
		noun 19
		message 39
		mainView 38
	)

	(method (cue)
		(if (not argc)
			(self message: 40 noun: 13 view: 39 setCursor: 39 0 0 show:)
		else
			(self message: 39 noun: 19 view: 38 setCursor: 38 0 0 show:)
		)
		(gInventory show:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; match [ lit ]
				(if (== (self message:) 40)
					(self
						message: 41
						noun: 20
						view: 42
						setCursor: 42 0 0
						yourself:
					)
					(match message: 42 noun: 22 view: 40 setCursor: 40 0 0)
					(gGame changeScore: 8 158)
					(gEgo put: 25) ; match
					((ScriptID 85 1) dispose:) ; mTimer
					(Message msgGET 85 13 0 14 1 (global186 data:)) ; "Filled Lamp"
					(gMessager say: 13 43 0 0 0 85) ; "Good idea! Your burning lamp bears a remarkable resemblance to the universal symbol of learning."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if (== (self message:) 17)
					(self
						message: 39
						noun: 19
						view: 38
						setCursor: 38 0 0
						yourself:
					)
					(gInventory show:)
					(Message msgGET 85 56 0 14 1 (global186 data:)) ; "Lubricant-Filled Lamp"
					(gMessager say: 56 4 0 0 0 85) ; "You dump all the lubricant out of your lamp and carefully wipe down the inside. There. All nice and clean again."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lard of LL6InvItem
	(properties
		noun 39
		message 30
		mainView 33
		owner 560
	)
)

(instance match of LL6InvItem
	(properties
		noun 22
		message 42
		mainView 40
		owner 510
	)

	(method (cue)
		(cond
			((IsFlag 110)
				(gCurRoom notify:)
			)
			(
				(or
					(gCurRoom inset:)
					(gCurRoom script:)
					(gTalkers size:)
					(Print dialog:)
				)
				((ScriptID 85 1) setReal: self 3) ; mTimer
			)
			(else
				(gEgo put: 25) ; match
				(self
					message: 42
					noun: 22
					owner: 510
					view: 40
					setCursor: 40 0 0
					yourself:
				)
				(Message msgGET 85 22 0 14 1 (global186 data:)) ; "Match"
				(gMessager say: 22 6 0 2 0 85) ; "You discard the burned out match before it burns your fingers."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Zipper
				(cond
					((IsFlag 110)
						(gCurRoom notify:)
					)
					((== (self message:) 43)
						(super doVerb: theVerb)
					)
					((IsFlag 74)
						(Message msgGET 85 22 0 14 1 (global186 data:)) ; "Match"
						(gMessager say: 22 6 13 0 0 85) ; "You have no zipper upon which to strike your match! But, if you did, that little sucker would light."
					)
					(
						(and
							(gCast contains: gEgo)
							(not (gCurRoom script:))
							(== (gEgo view:) 900)
						)
						(gCurRoom setScript: (ScriptID 77 1)) ; strikeMatch
						(self
							message: 43
							noun: 21
							view: 41
							setCursor: 41 0 0
							yourself:
						)
						((ScriptID 85 1) setReal: self 20) ; mTimer
						(gInventory show:)
						(return 1)
					)
					(else
						(gGame changeScore: 12 157)
						(self
							message: 43
							noun: 21
							view: 41
							setCursor: 41 0 0
							yourself:
						)
						((ScriptID 85 1) setReal: self 20) ; mTimer
						(Message msgGET 85 22 0 14 1 (global186 data:)) ; "Match"
						(gMessager say: 22 6 0 1 0 85) ; "(SOUND FX FIRST OF MATCH LIGHTING) You did it!"
						(gInventory show:)
						(return 1)
					)
				)
			)
			(4 ; Do
				(if (== (self message:) 43)
					((ScriptID 85 1) dispose:) ; mTimer
					(self
						message: 42
						noun: 22
						view: 40
						setCursor: 40 0 0
						yourself:
					)
					(Message msgGET 85 22 0 14 1 (global186 data:)) ; "Match"
					(gMessager say: 21 6 0 1 0 85) ; "Hey! That's hot!"
					(gEgo put: 25) ; match
					(return 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((OneOf theVerb 39 40 41) ; lamp, lamp [ filled ], lamp [ lit ]
				(if (== (self message:) 43)
					(gEgo put: 25) ; match
					((ScriptID 85 1) dispose:) ; mTimer
					(super doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance minwater of LL6InvItem
	(properties
		noun 40
		message 38
		mainView 15
		owner 660
	)

	(method (init)
		(= mainView 15)
		(= message 38)
		(= noun 40)
		(= owner 660)
		(super init: &rest)
	)
)

(instance orange of LL6InvItem
	(properties
		noun 41
		message 34
		mainView 37
		owner 530
	)

	(method (init)
		(= mainView 37)
		(= message 34)
		(= noun 41)
		(= owner 530)
		(super init: &rest)
	)
)

(instance pearl of LL6InvItem
	(properties
		noun 42
		message 29
		mainView 32
	)
)

(instance polishcloth of LL6InvItem
	(properties
		noun 23
		message 46
		mainView 45
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; floss
				(floss doVerb: 46)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance randomKey of LL6InvItem
	(properties
		noun 6
		message 51
		mainView 48
	)

	(method (doVerb theVerb)
		(switch theVerb
			(63 ; bastardfile
				(cond
					(
						(and
							(not (== gCurRoomNum 230))
							(gEgo has: 20) ; towerkey
							(not (IsFlag 173))
						)
						(gGame changeScore: 20 150 changeScore: 10 173)
						(gEgo put: 34 put: 12) ; soap, bastardfile
						(self noun: 55 message: 52)
						(Message msgGET 85 6 0 14 1 (global186 data:)) ; "Random Room Key"
						(gMessager say: 6 63 12 0 0 85) ; "YES! You carefully file this key with your bastard file, using the lifeguard's key as a pattern!"
						(return 1)
					)
					((and (gEgo has: 20) (== gCurRoomNum 230)) ; towerkey
						(gMessager say: 5 51 11 0 0 85) ; "Hey, you! What do you think you're doing with that key! You're not trying to make a copy of my tower key, are you? You'd better not be!"
						(return 1)
					)
					((gCurRoom script:)
						(super doVerb: theVerb)
					)
					(
						(and
							(gCast contains: gEgo)
							(IsFlag 173)
							(== (gEgo view:) 900)
						)
						(gCurRoom setScript: (ScriptID 77 0)) ; fileKey
						(return 1)
					)
					((IsFlag 173)
						(gEgo put: 34 put: 12) ; soap, bastardfile
						(self noun: 55 message: 52)
						(gGame changeScore: 20 150)
						(Message msgGET 85 6 0 14 1 (global186 data:)) ; "Random Room Key"
						(gMessager say: 6 63 1 0 0 85) ; "YES! You carefully file this key with your bastard file, using the "Impressed Soap" for a pattern."
						(return 1)
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
)

(instance bracelet of LL6InvItem
	(properties
		noun 51
		message 16
		mainView 21
	)
)

(instance roomkey of LL6InvItem
	(properties
		noun 26
		message 7
		mainView 1
	)
)

(instance orchid of LL6InvItem
	(properties
		noun 43
		message 13
		mainView 17
	)
)

(instance sculpture of LL6InvItem
	(properties
		noun 44
		message 28
		mainView 31
	)
)

(instance soap of LL6InvItem
	(properties
		noun 27
		message 57
		mainView 7
	)

	(method (cue)
		(self message: 58 noun: 18 view: 8 setCursor: 8 0 0 yourself:)
		(gInventory show:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; towerkey
				(cond
					((!= gCurRoomNum 270)
						(Message msgGET 85 27 0 14 1 (global186 data:)) ; "Impressive Soap"
						(gMessager say: 27 50 11 0 0 85) ; "Hey! You!! What in the hell do you think you're doing with my key?"
						(return 1)
					)
					((IsFlag 173)
						(Message msgGET 85 18 0 14 1 (global186 data:)) ; "Bar of Impressed Soap"
						(gMessager say: 18 0 0 0 0 85) ; "Don't mess up your good impression. You may need that for reference someday."
						(return 1)
					)
					(else
						(Message msgGET 85 18 0 14 1 (global186 data:)) ; "Bar of Impressed Soap"
						(gCurRoom setScript: (ScriptID 270 1) self) ; impressSoap
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sunglasses of LL6InvItem
	(properties
		noun 24
		message 45
		mainView 44
	)
)

(instance swimsuit of LL6InvItem
	(properties
		noun 45
		message 47
		mainView 46
	)
)

(instance toiletcover of LL6InvItem
	(properties
		noun 46
		message 61
		mainView 12
	)
)

(instance toiletpaper of LL6InvItem
	(properties
		noun 47
		message 62
		mainView 11
	)
)

(instance towel of LL6InvItem
	(properties
		noun 48
		message 56
		mainView 3
	)
)

(instance towerkey of LL6InvItem
	(properties
		noun 28
		message 50
		mainView 47
	)

	(method (doVerb theVerb)
		(switch theVerb
			(57 ; soap
				(soap doVerb: 50)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wrench of LL6InvItem
	(properties
		noun 49
		message 64
		mainView 14
	)
)

(instance washcloth of LL6InvItem
	(properties
		noun 25
		message 35
		mainView 4
	)

	(method (init)
		(= mainView 4)
		(= message 35)
		(= noun 25)
		(super init: &rest)
	)

	(method (cue)
		(if argc
			(return (== noun 52))
		else
			(self noun: 50 message: 36 view: 5 setCursor: 5 0 0 yourself:)
			(gInventory show:)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(9 ; beer
				(gGame changeScore: 6 250)
				(self cue:)
				(= global185 5)
				(Message msgGET 85 25 0 14 1 (global186 data:)) ; "Complimentary Washcloth"
				(gMessager say: 25 9 0 0 0 85) ; "Ah, there's nothing like an old-fashioned beer-soaked washcloth."
				(return 1)
			)
			(6 ; Zipper
				(if (== noun 25)
					(gGame changeScore: 6 250)
					(self cue:)
					(= global185 2)
					(Message msgGET 85 25 0 14 1 (global186 data:)) ; "Complimentary Washcloth"
					(gMessager say: 25 theVerb 0 0 0 85) ; "Now it's not only wet, but it's also warm!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(if (== noun 50)
					(switch global185
						(1
							(= temp0 2)
						)
						(2
							(= temp0 6)
						)
						(3
							(= temp0 16)
						)
						(4
							(= temp0 17)
						)
						(5
							(= temp0 19)
						)
						(6
							(= temp0 18)
						)
					)
					(Message msgGET 85 50 0 14 1 (global186 data:)) ; "Wet Washcloth"
					(gMessager say: 50 0 temp0 0 0 85)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance wordsOWisdom of LL6InvItem
	(properties
		noun 29
		message 53
		mainView 53
	)
)

(instance mTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (delete)
		(if (not client)
			(= client self)
		)
		(super delete:)
	)
)

(instance cTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (delete)
		(if (not client)
			(= client self)
		)
		(super delete:)
	)
)

(instance wTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (delete)
		(if (not client)
			(= client self)
		)
		(super delete:)
	)
)

(instance redXScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(SetCursor 998 0 9)
				(huhFX play: self)
				(= ticks 15)
			)
			(1 0)
			(2
				(huhFX dispose:)
				(gGame setCursor: (gTheIconBar getCursor:))
				(User canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance huhFX of Sound
	(properties
		number 1040
	)
)

(instance lScroller of IconI
	(properties
		x 196
		y 3
		mainView 9601
	)
)

(instance rScroller of IconI
	(properties
		x 310
		y 3
		mainView 9601
		mainLoop 1
	)
)

