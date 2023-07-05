;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use LoadMany)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm540 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
)

(class WaverCode of Code
	(properties
		origX 0
		origY 0
	)

	(method (init &tmp temp0 temp1)
		(= origX temp0) ; UNINIT
		(= origY temp1) ; UNINIT
	)

	(method (doit &tmp temp0 temp1)
		(if (> (GetDistance gMouseX (- gMouseY 10) origX origY) local4)
			(= origX gMouseX)
			(= origY (- gMouseY 10))
		)
		(= temp0 (if (<= (Random 5 10) 7) 1 else 0))
		(= temp1 (if (<= (Random 5 10) 7) 1 else 0))
		(cond
			((and temp0 temp1)
				(gGame
					setCursor:
						((gTheIconBar at: 5) cursor:)
						1
						(+ origX (Random 1 local4))
						origY
				)
			)
			((and (not temp0) (not temp1))
				(gGame
					setCursor:
						((gTheIconBar at: 5) cursor:)
						1
						(- origX (Random 1 local4))
						origY
				)
			)
			((and temp0 (not temp1))
				(gGame
					setCursor:
						((gTheIconBar at: 5) cursor:)
						1
						origX
						(- origY (Random 1 local4))
				)
			)
			((and (not temp0) temp1)
				(gGame
					setCursor:
						((gTheIconBar at: 5) cursor:)
						1
						origX
						(+ origY (Random 1 local4))
				)
			)
		)
	)
)

(instance rm540 of FPRoom
	(properties
		picture 780
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(gunSound play:)
				(return 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) $0040) ; direction
			(return 0)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((< gMouseY 10)
				(if (not local11)
					(= local10 local4)
					(= local4 0)
					(= local11 1)
				)
			)
			((and local11 (> gMouseY 26))
				(= local4 local10)
				(= local11 0)
			)
		)
		(if (and (> local4 0) (<= (- local6 gGameTime) 0))
			(WaverCode doit:)
			(= local6 (+ gGameTime 10))
		)
		(gEgo get: -1 44) ; Pistols
	)

	(method (init)
		(LoadMany rsSOUND 2546 2543 2541 2542 547 540)
		(LoadMany rsVIEW 543 545 541 544 542 540)
		(LoadMany rsSCRIPT 991)
		(super init:)
		(gWalkHandler addToFront: flyingBottle bottle hand)
		(self setScript: sStartRoom)
	)

	(method (dispose)
		(= gCurPuzzle 19)
		(gTheIconBar enable:)
		(DisposeScript 991)
		(gWalkHandler delete: flyingBottle bottle hand)
		(super dispose:)
	)
)

(instance sStartRoom of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 540 loop: -1 play:)
				(= cycles 5)
			)
			(1
				(gGame setCursor: 999 1)
				(switch
					(Print
						font: gUserFont
						mode: 1
						addTitle: 3 0 1 1 540
						addButton: 1 4 0 0 1 (proc0_16 0 0 28 0 0) 0 540 ; "I'm one bad hombre! Do your worst!"
						addButton: ; "I'm feelin' pretty tough. But don't bust my chops."
							2
							4
							0
							0
							2
							(proc0_16 0 0 28 0 0)
							(proc0_16 30 18 18 18 18)
							540
						addButton: ; "I had too much tequila last night! Go easy!"
							3
							4
							0
							0
							3
							(proc0_16 0 0 20 0 0)
							(proc0_16 72 48 48 48 48)
							540
						init:
					)
					(0
						(= local9 1)
						(= cycles 2)
					)
					(1
						(= local9 0)
						(= cycles 2)
					)
					(2
						(= local9 2)
						(= cycles 2)
					)
					(3
						(= local9 1)
						(= cycles 2)
					)
				)
			)
			(2
				(gGame handsOn:)
				(gEgo put: 18) ; Empty_Bottles
				(proc0_9 300)
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					curInvIcon: ((gInventory at: 44) cursor: 10 yourself:) ; Pistols
					enable: (gTheIconBar at: 5)
				)
				((gTheIconBar curIcon:) cursor: 10)
				(gGame setCursor: ((gTheIconBar at: 5) cursor:))
				(gTheIconBar select: (gTheIconBar at: 5))
				(gTheIconBar disable: 0 1 2 3 6)
				(gCurRoom drawPic: 540)
				(WaverCode init:)
				(= local7 1)
				(= local6 (+ gGameTime 10))
				(switch local9
					(0
						(= local1 6)
						(= local0 3)
						(= local3 5)
						(= local4 15)
						(= local5 1)
						(= local8 60)
					)
					(1
						(= local1 2)
						(= local0 7)
						(= local3 10)
						(= local4 5)
						(= local5 2)
						(= local8 140)
					)
					(2
						(= local1 4)
						(= local0 4)
						(= local3 7)
						(= local4 10)
						(= local5 2)
						(= local8 100)
					)
				)
				(for ((= temp0 1)) (<= temp0 local1) ((++ temp0))
					(switch temp0
						(1
							(= temp1 25)
							(= temp2 72)
						)
						(2
							(= temp1 64)
							(= temp2 68)
						)
						(3
							(= temp1 104)
							(= temp2 61)
						)
						(4
							(= temp1 130)
							(= temp2 67)
						)
						(5
							(= temp1 171)
							(= temp2 67)
						)
						(6
							(= temp1 214)
							(= temp2 71)
						)
					)
					((bottle new:)
						init:
						stopUpd:
						loop: (Random 0 2)
						posn: temp1 temp2
					)
				)
				(= cycles 10)
			)
			(3
				(gGame setCursor: 10 1)
				(gMessager say: 6 0 0 0 self) ; "Okee the dokee, Freddy Pharkas! First, we shall see if you can successfully strike the bottles from afar with the bullets of your pistol."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ gCurPuzzle)
				(gTheIconBar disable:)
				(gUser canControl: 0 canInput: 0)
				(srini init:)
				(gMessager say: 2 0 0 0 self) ; "I am applauding inside myself! Now for the big challenge of all-- six bottles at once!"
			)
			(1
				(gGameMusic2 number: 2543 loop: 1 flags: 1 play:)
				(srini dispose:)
				(gGame setCursor: ((gTheIconBar at: 5) cursor:) 1 147 26)
				(sixBottles
					init:
					setCycle: End self
					setMotion: JumpTo 113 40 self
				)
			)
			(2
				(sixBottles setLoop: 2 setCycle: Fwd)
			)
			(3
				(gGameMusic2 number: 2542 loop: 1 flags: 1 play:)
				(sixBottles setLoop: 1 cel: 0 setCycle: End self)
				(= local4 20)
			)
			(4
				(= local4 0)
				(gGame setCursor: 997 1)
				(gGameMusic1 number: 547 loop: 1 play: self)
				(sixBottles dispose:)
			)
			(5
				(gTheIconBar enable:)
				(gCurRoom newRoom: 300)
				(self dispose:)
			)
		)
	)
)

(instance sGotHand of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(++ local2)
				(= temp0 (if (== (hand loop:) 0) 2 else 3))
				(hand setLoop: temp0 setCel: 0 setCycle: End self)
				(gunSound play: self)
			)
			(1)
			(2
				(-= local4 local5)
				(hand dispose:)
				(if (< local2 local1)
					(gCurRoom setScript: sCardboardHand 0 0)
				else
					(= cycles 2)
				)
			)
			(3
				(gGame points: 5)
				(= local2 0)
				(gCurRoom setScript: sCartoon)
			)
		)
	)
)

(instance sGotFlyingBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ local2)
				(flyingBottle setMotion: 0 setLoop: 1 setCycle: End self)
			)
			(1
				(flyingBottle hide:)
				(gGameMusic2 number: 2542 loop: 1 flags: 1 play: self)
			)
			(2
				(-= local4 local5)
				(flyingBottle dispose:)
				(if (< local2 local1)
					(gCurRoom setScript: sSriniThrows)
				else
					(gGame points: 5)
					(= local2 0)
					(gCurRoom setScript: sCardboardHand 0 1)
				)
			)
		)
	)
)

(instance sGotBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 0)
				(++ local2)
				(= cycles 2)
			)
			(1
				(gGameMusic2 number: 2542 loop: 1 flags: 1 play: self)
				(client setCycle: End self)
			)
			(2
				(if (== (client cel:) (client lastCel:))
					(client hide:)
				)
			)
			(3
				(-= local4 local5)
				(if (== local2 local1)
					(gGame points: 5)
					(gCurRoom setScript: sSriniThrows)
					(= local2 0)
				else
					(= local7 1)
				)
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sSriniThrows of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(srini init: cel: 0)
				(= ticks (Random 30 240))
			)
			(1
				(srini setCycle: End self)
			)
			(2
				(gGameMusic2 number: 2543 loop: 1 flags: 1 play:)
				(srini dispose:)
				(flyingBottle
					init:
					setLoop: 0
					cel: 0
					posn: 45 13
					setCycle: Fwd
					setStep: 9 6
					setSpeed: local0
					ignoreHorizon:
					setMotion: MoveTo 60 -20 self
				)
				(= local7 1)
			)
			(3
				(flyingBottle
					posn: 285 -20
					setMotion: MoveTo (Random 266 320) 75 self
				)
			)
			(4
				(= local7 0)
				(flyingBottle dispose:)
				(if (< local2 local1)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance sCardboardHand of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if register
					(= local4 0)
					(srini view: 540 init:)
					(= ticks (Random 30 240))
				else
					(self changeState: 2)
				)
			)
			(1
				(gMessager say: 1 0 0 0 self) ; "Very good, Freddy Pharkas!. Let us try some quickdrawing. Just make sure you hit the target and not me!!"
			)
			(2
				(= ticks 60)
			)
			(3
				(gGame setCursor: ((gTheIconBar at: 5) cursor:) 1 160 180)
				(= temp0 (Random 1 6))
				(if register
					(srini dispose:)
				)
				(switch temp0
					(1
						(= temp1 30)
						(= temp2 107)
						(= temp3 0)
					)
					(2
						(= temp1 69)
						(= temp2 99)
						(= temp3 1)
					)
					(3
						(= temp1 108)
						(= temp2 95)
						(= temp3 0)
					)
					(4
						(= temp1 166)
						(= temp2 100)
						(= temp3 1)
					)
					(5
						(= temp1 213)
						(= temp2 102)
						(= temp3 1)
					)
					(6
						(= temp1 268)
						(= temp2 112)
						(= temp3 0)
					)
				)
				(gGameMusic2 number: 2541 loop: 1 flags: 1 play:)
				(hand
					init:
					show:
					setLoop: temp3
					cel: 0
					posn: temp1 temp2
					setCycle: End self
				)
				(= local7 1)
			)
			(4
				(hand stopUpd:)
				(if (not (HaveMouse))
					(= ticks (* local8 2))
				else
					(= ticks local8)
				)
			)
			(5
				(= local7 0)
				(hand setCycle: Beg self)
			)
			(6
				(hand dispose:)
				(if (< local2 local1)
					(= register 0)
					(self changeState: 2)
				)
			)
		)
	)
)

(instance srini of Prop
	(properties
		x 15
		y 84
		noun 5
		view 542
	)

	(method (doVerb)
		(gMessager say: noun 47) ; "Srini dodges the bullet!"
	)
)

(instance hand of Prop
	(properties
		view 544
	)

	(method (onMe)
		(if local7
			(= local7 0)
			(if (itsAHandHit doit: self gMouseX gMouseY)
				(gCurRoom setScript: sGotHand)
			)
		)
		(return (super onMe: &rest))
	)

	(method (handleEvent event)
		(event claimed: 1)
		(super handleEvent: event)
	)
)

(instance bottle of Prop
	(properties
		view 541
	)

	(method (onMe)
		(if (not (IsFlag 4))
			(self cue:)
		)
		(return
			(if (and local7 (itsAHit doit: self gMouseX gMouseY))
				(= local7 0)
				(self setScript: (sGotBottle new:))
			)
		)
	)

	(method (cue)
		(if local12
			(= global122 11)
			(gCurRoom newRoom: 99) ; deathRoom
		else
			(gGameMusic2 number: 2751 loop: 1 flags: 1 play: self)
			(ShakeScreen 24 ssLEFTRIGHT)
			(= local12 1)
		)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(super handleEvent: event)
	)
)

(instance sixBottles of Actor
	(properties
		x 7
		y 84
		view 545
	)
)

(instance flyingBottle of Actor
	(properties
		x 45
		y 13
		view 543
	)

	(method (onMe)
		(return
			(if local7
				(= local7 0)
				(if (super onMe: &rest)
					(gCurRoom setScript: sGotFlyingBottle)
				)
			)
		)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(super handleEvent: event)
	)
)

(instance itsAHit of Code
	(properties)

	(method (doit param1 param2 param3)
		(if (<= (GetDistance param2 param3 (param1 x:) (param1 y:)) local3)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance itsAHandHit of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1)
		(if (param1 loop:)
			(= temp0 (- (param1 x:) 20))
		else
			(= temp0 (+ (param1 x:) 20))
		)
		(= temp1 (- (param1 y:) 35))
		(if (<= (GetDistance param2 param3 temp0 temp1) local3)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance gunSound of FPSound
	(properties
		flags 1
		number 2101
	)
)

