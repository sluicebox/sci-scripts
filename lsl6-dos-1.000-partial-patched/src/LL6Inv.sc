;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use n079)
(use InvBar)
(use Timer)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	LL6Inv 0
	mTimer 1
	cTimer 2
	redXScr 3
	wTimer 4
)

(class LL6InvItem of BarInvI
	(properties
		highlightColor 8
		lowlightColor 21
		modNum 85
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(Message msgGET modNum noun 0 14 1 global186)
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
)

(class LL6Inv of InvBar
	(properties)

	(method (init)
		(super init: &rest)
		(self
			add:
				(badge setCursor: 18 0 0 yourself:)
				(batteries setCursor: 28 0 0 yourself:)
				(beaver setCursor: 50 0 0 yourself:)
				(beer setCursor: 19 0 0 yourself:)
				(belt setCursor: 34 5 0 yourself:)
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
			eachElementDo: #init
		)
		(= leftScroller lScroller)
		(= rightScroller rScroller)
	)
)

(instance badge of LL6InvItem
	(properties
		view 18
		message 10
		noun 3
	)
)

(instance batteries of LL6InvItem
	(properties
		view 28
		message 25
		noun 7
	)
)

(instance beaver of LL6InvItem
	(properties
		view 50
		message 48
		noun 8
	)
)

(instance beer of LL6InvItem
	(properties
		view 19
		message 9
		noun 9
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
		view 34
		message 11
		noun 30
	)
)

(instance brochure of LL6InvItem
	(properties
		view 52
		message 54
		noun 10
	)
)

(instance collar of LL6InvItem
	(properties
		view 25
		message 22
		noun 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame changeScore: 10 155)
				(gEgo put: 11 get: 10) ; collar, diamond
				(Message msgGET 85 12 0 14 1 global186) ; "Your Dog Collar"
				(gMessager say: 12 4 0 0 0 85) ; "You carefully remove the large diamond and discard the stupid dog collar."
				(return 1)
			)
			(1 ; Look
				(if (self state:)
					(Message msgGET 85 12 0 14 1 global186) ; "Your Dog Collar"
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
		view 13
		message 65
		noun 31
	)
)

(instance cord of LL6InvItem
	(properties
		owner 580
		view 29
		message 26
		noun 11
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
							(not (gCurRoom script:))
							(== (gEgo view:) 900)
							(!= (self message:) 27)
						)
						(gCurRoom setScript: (ScriptID 77 2)) ; stripTWire
						(self
							view: 30
							message: 27
							noun: 4
							setCursor: 30 0 0
							yourself:
						)
						(Message msgGET 85 11 0 14 1 global186) ; "Electrical Cord"
						(gMessager say: 11 4 0 0 0 85) ; "You carefully strip away approximately two centimeters of insulation from the end of the wire without the 3-pin grounded plug."
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
						(gGame changeScore: 12 151)
						(Message msgGET 85 11 0 14 1 global186) ; "Electrical Cord"
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
		owner 860
		view 23
		message 19
		noun 32
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
		view 26
		message 23
		noun 33
	)
)

(instance bastardfile of LL6InvItem
	(properties
		view 2
		message 63
		noun 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(51 ; randomKey
				(randomKey doVerb: 63)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance filter of LL6InvItem
	(properties
		owner 330
		view 35
		message 32
		noun 34
	)

	(method (cue)
		(self setCursor: 36 0 0 view: 36 message: 33 noun: 53)
	)
)

(instance flashlight of LL6InvItem
	(properties
		view 27
		message 24
		noun 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gEgo has: 1)) ; batteries
					(gEgo get: 1) ; batteries
					(gGame changeScore: 20 160)
					(super doVerb: theVerb)
				else
					(Message msgGET 85 14 0 14 1 global186) ; "Big Flashlight"
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
		view 10
		message 60
		noun 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; polishcloth
				(gGame changeScore: 20 156)
				(Message msgGET 85 15 0 14 1 global186) ; "Dental Floss"
				(gMessager say: 15 46 0 0 0 85) ; "You deftly attach the dental floss to the sunglasses polishing cloth to form..."
				(gEgo put: 15 put: 32 get: 35) ; floss, polishcloth, swimsuit
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flowers of LL6InvItem
	(properties
		view 16
		message 66
		noun 35
	)
)

(instance glasscase of LL6InvItem
	(properties
		view 43
		message 44
		noun 17
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(switch state
					(0
						(++ state)
						(gGame changeScore: 4 152)
						(Message msgGET 85 17 0 14 1 global186) ; "Sunglasses Case"
						(gMessager say: 17 4 7 0 0 85) ; "You open the sunglasses case."
						(return 1)
					)
					(1
						(++ state)
						(gEgo get: 31) ; sunglasses
						(gGame changeScore: 4 153)
						(Message msgGET 85 17 0 14 1 global186) ; "Sunglasses Case"
						(gMessager say: 17 4 4 0 0 85) ; "Hey, nice pair of shades! Perfect for lounging around poolside!"
						(return 1)
					)
					(2
						(++ state)
						(gEgo put: 30 get: 32) ; glasscase, polishcloth
						(gGame changeScore: 8 154)
						(Message msgGET 85 17 0 14 1 global186) ; "Sunglasses Case"
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
				(Message msgGET 85 17 0 14 1 global186) ; "Sunglasses Case"
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
		view 22
		message 18
		noun 36
	)
)

(instance handcuffs of LL6InvItem
	(properties
		owner 850
		view 24
		message 12
		noun 37
	)
)

(instance handcreme of LL6InvItem
	(properties
		view 9
		message 59
		noun 38
	)
)

(instance lamp of LL6InvItem
	(properties
		view 38
		message 39
		noun 19
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
					(Message msgGET 85 13 0 14 1 global186) ; "Filled Lamp"
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
					(Message msgGET 85 56 0 14 1 global186) ; "Lubricant-Filled Lamp"
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
		owner 560
		view 33
		message 30
		noun 39
	)
)

(instance match of LL6InvItem
	(properties
		owner 510
		view 40
		message 42
		noun 22
	)

	(method (cue)
		(gEgo put: 25) ; match
		(self
			message: 42
			noun: 22
			owner: 510
			view: 40
			setCursor: 40 0 0
			yourself:
		)
		(Message msgGET 85 22 0 14 1 global186) ; "Match"
		(gMessager say: 22 6 0 2 0 85) ; "You discard the burned out match before it burns your fingers."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Zipper
				(cond
					((== (self message:) 43)
						(super doVerb: theVerb)
					)
					((IsFlag 74)
						(Message msgGET 85 22 0 14 1 global186) ; "Match"
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
						(Message msgGET 85 22 0 14 1 global186) ; "Match"
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
					(Message msgGET 85 22 0 14 1 global186) ; "Match"
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
		owner 660
		view 15
		message 38
		noun 40
	)
)

(instance orange of LL6InvItem
	(properties
		owner 530
		view 37
		message 34
		noun 41
	)
)

(instance pearl of LL6InvItem
	(properties
		view 32
		message 29
		noun 42
	)
)

(instance polishcloth of LL6InvItem
	(properties
		view 45
		message 46
		noun 23
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
		view 48
		message 51
		noun 6
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
						(Message msgGET 85 6 0 14 1 global186) ; "Random Room Key"
						(gMessager say: 6 63 12 0 0 85) ; "YES! You carefully file this key with your bastard file, using the lifeguard's key as a pattern!"
						(return 1)
					)
					((IsFlag 173)
						(gEgo put: 34 put: 12) ; soap, bastardfile
						(self noun: 55 message: 52)
						(gGame changeScore: 20 150)
						(Message msgGET 85 6 0 14 1 global186) ; "Random Room Key"
						(gMessager say: 6 63 1 0 0 85) ; "YES! You carefully file this key with your bastard file, using the "Impressed Soap" for a pattern."
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
		view 21
		message 16
		noun 51
	)
)

(instance roomkey of LL6InvItem
	(properties
		view 1
		message 7
		noun 26
	)
)

(instance orchid of LL6InvItem
	(properties
		view 17
		message 13
		noun 43
	)
)

(instance sculpture of LL6InvItem
	(properties
		view 31
		message 28
		noun 44
	)
)

(instance soap of LL6InvItem
	(properties
		view 7
		message 57
		noun 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50 ; towerkey
				(cond
					((!= gCurRoomNum 270)
						(Message msgGET 85 27 0 14 1 global186) ; "Impressive Soap"
						(gMessager say: 27 50 11 0 0 85) ; "Hey! You!! What in the hell do you think you're doing with my key?"
						(return 1)
					)
					((IsFlag 173)
						(Message msgGET 85 18 0 14 1 global186) ; "Bar of Impressed Soap"
						(gMessager say: 18 0 0 0 0 85) ; "Don't mess up your good impression. You may need that for reference someday."
						(return 1)
					)
					(else
						(Message msgGET 85 18 0 14 1 global186) ; "Bar of Impressed Soap"
						(gCurRoom setScript: (ScriptID 270 1)) ; impressSoap
						(self
							message: 58
							noun: 18
							view: 8
							setCursor: 8 0 0
							yourself:
						)
						(gInventory show:)
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
		view 44
		message 45
		noun 24
	)
)

(instance swimsuit of LL6InvItem
	(properties
		view 46
		message 47
		noun 45
	)
)

(instance toiletcover of LL6InvItem
	(properties
		view 12
		message 61
		noun 46
	)
)

(instance toiletpaper of LL6InvItem
	(properties
		view 11
		message 62
		noun 47
	)
)

(instance towel of LL6InvItem
	(properties
		view 3
		message 56
		noun 48
	)
)

(instance towerkey of LL6InvItem
	(properties
		view 47
		message 50
		noun 28
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
		view 14
		message 64
		noun 49
	)
)

(instance washcloth of LL6InvItem
	(properties
		view 4
		message 35
		noun 25
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
				(Message msgGET 85 25 0 14 1 global186) ; "Complimentary Washcloth"
				(gMessager say: 25 9 0 0 0 85) ; "Ah, there's nothing like an old-fashioned beer-soaked washcloth."
				(return 1)
			)
			(6 ; Zipper
				(if (== noun 25)
					(gGame changeScore: 6 250)
					(self cue:)
					(= global185 2)
					(Message msgGET 85 25 0 14 1 global186) ; "Complimentary Washcloth"
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
					(Message msgGET 85 50 0 14 1 global186) ; "Wet Washcloth"
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
		view 53
		message 53
		noun 29
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
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(User canControl: 1 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance huhFX of Sound
	(properties
		number 40
	)
)

(instance lScroller of View
	(properties
		x 2
		y 163
		view 980
		loop 9
	)

	(method (onMe param1)
		(return
			(and
				(<= x (param1 x:))
				(<= (param1 x:) nsRight)
				(<= y (param1 y:))
				(<= (param1 y:) nsBottom)
			)
		)
	)

	(method (show param1 &tmp temp0)
		(if (or (not underBits) (and argc param1))
			(= nsRight (+ x (CelWide view loop cel)))
			(= nsBottom (+ y (CelHigh view loop cel)))
			(if (or (not argc) (not param1))
				(= underBits (Graph grSAVE_BOX y x nsBottom nsRight 1))
			)
		)
		(DrawCel view loop cel x y -1 0)
	)

	(method (handleEvent &tmp temp0 temp1)
		(SetPort 0 0 190 320 10 0)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 globalize:)
			(temp0 y: (- (temp0 y:) 10))
			(cond
				((self onMe: temp0)
					(if (not cel)
						(= cel 1)
						(self show: 1)
					)
				)
				(cel
					(= cel 0)
					(self show: 1)
				)
			)
			(temp0 dispose:)
		)
		(= temp1
			(if cel
				(= cel 0)
				(self show: 1)
				1
			)
		)
		(temp0 dispose:)
		(SetPort 0 0 139 320 10 0)
		(return temp1)
	)

	(method (hide)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX y x nsBottom nsRight 1)
			(= underBits 0)
		)
	)
)

(instance rScroller of View
	(properties
		x 300
		y 163
		view 980
		loop 10
	)

	(method (onMe param1)
		(return
			(and
				(<= x (param1 x:))
				(<= (param1 x:) nsRight)
				(<= y (param1 y:))
				(<= (param1 y:) nsBottom)
			)
		)
	)

	(method (show param1 &tmp temp0)
		(= nsRight (+ x (CelWide view loop cel)))
		(= nsBottom (+ y (CelHigh view loop cel)))
		(if
			(and
				(or (not underBits) (and argc param1))
				(or (not argc) (not param1))
			)
			(= underBits (Graph grSAVE_BOX y x nsBottom nsRight 1))
		)
		(DrawCel view loop cel x y -1 0)
	)

	(method (handleEvent &tmp temp0 temp1)
		(SetPort 0 0 190 320 10 0)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 globalize:)
			(temp0 y: (- (temp0 y:) 10))
			(cond
				((self onMe: temp0)
					(if (not cel)
						(= cel 1)
						(self show: 1)
					)
				)
				(cel
					(= cel 0)
					(self show: 1)
				)
			)
			(temp0 dispose:)
		)
		(= temp1
			(if cel
				(= cel 0)
				(self show: 1)
				1
			)
		)
		(temp0 dispose:)
		(SetPort 0 0 139 320 10 0)
		(return temp1)
	)

	(method (hide)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX y x nsBottom nsRight 1)
			(= underBits 0)
		)
	)
)

