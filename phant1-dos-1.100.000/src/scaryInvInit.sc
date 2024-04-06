;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Feature)
(use Actor)
(use System)

(public
	scaryInvInit 0
	proc28_1 1
	proc28_2 2
	proc28_3 3
)

(procedure (proc28_1 param1 &tmp temp0)
	(if
		(and
			(not (== (param1 owner:) -2))
			(!= (= temp0 (gPInvHoles firstTrue: #isNotOccupied)) 0)
		)
		(param1 x: (temp0 x:) y: (temp0 y:) owner: -2 init: show:)
	)
)

(procedure (proc28_2 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
		(= temp1 (gInventory at: temp0))
		(if (== (temp1 owner:) gEgo)
			(proc28_1 temp1)
		)
	)
)

(procedure (proc28_3 param1)
	(param1 dispose:)
)

(instance pInventory of List
	(properties)
)

(instance pInvHoles of Collect
	(properties)
)

(instance scaryInvInit of Code
	(properties)

	(method (doit)
		((= gInventory pInventory)
			add:
				(invLibKey owner: 30300)
				(invMoney owner: -1)
				(invNail owner: -1)
				(invNewspaper owner: -1)
				(invPoker owner: -1)
				(invHammer owner: 20200)
				(invStairKey owner: -1)
				(invVampBook owner: -1)
				(invMatch owner: -1)
				(invTarot owner: -1)
				(invBrooch owner: -1)
				(invPhoto owner: -1)
				(invLensPiece owner: -1)
				(invDrainCln owner: -1)
				(invCrucifix owner: -1)
				(invBeads owner: -1)
				(invSpellBook owner: -1)
				(invXmasOrn owner: -1)
				(invStone owner: -1)
				(invCutter owner: -1)
				(invDogBone owner: -1)
				(invFigurine owner: 5200)
		)
		((= gPInvHoles pInvHoles) add: inv1 inv2 inv3 inv4 inv5 inv6 inv7 inv8)
	)
)

(class ScaryInventory of View
	(properties
		sightAngle 360
		z 10
		signal 0
		verb 0
		owner 0
		hiliteState 0
		enabled 1
		hiliteView 0
		loliteView 0
	)

	(method (onMe)
		(if
			(or
				(and (not (gUser canInput:)) (not (gUser canControl:)))
				global161
			)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (init)
		(cond
			((!= owner -2) 0)
			((or (!= (gCurrentControl verb:) verb) (not (global116 contains: self)))
				(self setPri: 254 ignoreActors: 1 setHotspot: 4 3) ; Do, Move
				(global116 addToFront: self)
				(super init: global116)
				(if (== (gCurrentControl verb:) verb)
					(self hide:)
				)
			)
			(else
				(self setHotspot: 4 3) ; Do, Move
			)
		)
	)

	(method (doVerb theVerb)
		(if (and enabled (== theVerb 3)) ; Move
			(self setHotspot: 0)
			(gUser message: -1)
			(= global161 self)
			(gInvCursor view: loliteView setLoop: loop setCel: cel)
			(if (== global206 2)
				((ScriptID 26 1) state: 0) ; movieScr
			)
			(FrameOut)
			(gGame setCursor: gInvCursor 1)
			(gCurrentControl select: verb gInvCursor)
			(self hide:)
		else
			(super doVerb: theVerb)
		)
	)

	(method (isMyVerb param1)
		(return (== verb param1))
	)

	(method (enable param1)
		(if (and argc (not param1))
			(= enabled 0)
		else
			(= enabled 1)
		)
	)

	(method (moveTo param1)
		(= owner param1)
		(return self)
	)

	(method (ownedBy param1)
		(return (== owner param1))
	)

	(method (notFacing &tmp temp0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)

	(method (setHotspot)
		(super setHotspot: &rest)
		(global160 delete: self)
		(gInterfaceHotCast add: self)
	)
)

(instance invLibKey of ScaryInventory
	(properties
		noun 1
		modNum 1
		view 9671
		verb 8
		hiliteView 9671
		loliteView 9672
	)
)

(instance invMoney of ScaryInventory
	(properties
		noun 2
		modNum 1
		view 9631
		verb 6
		hiliteView 9631
		loliteView 9632
	)
)

(instance invNail of ScaryInventory
	(properties
		noun 3
		modNum 1
		view 9651
		verb 7
		hiliteView 9651
		loliteView 9652
	)
)

(instance invNewspaper of ScaryInventory
	(properties
		noun 4
		modNum 1
		view 9661
		verb 9
		hiliteView 9661
		loliteView 9662
	)
)

(instance invPoker of ScaryInventory
	(properties
		noun 5
		modNum 1
		view 9741
		verb 10
		hiliteView 9741
		loliteView 9742
	)
)

(instance invHammer of ScaryInventory
	(properties
		noun 6
		modNum 1
		view 9731
		verb 11
		hiliteView 9731
		loliteView 9732
	)
)

(instance invStairKey of ScaryInventory
	(properties
		noun 7
		modNum 1
		view 9681
		verb 12
		hiliteView 9681
		loliteView 9682
	)
)

(instance invVampBook of ScaryInventory
	(properties
		noun 8
		modNum 1
		view 9711
		verb 13
		hiliteView 9711
		loliteView 9712
	)
)

(instance invMatch of ScaryInventory
	(properties
		noun 9
		modNum 1
		view 9621
		verb 14
		hiliteView 9621
		loliteView 9622
	)
)

(instance invTarot of ScaryInventory
	(properties
		noun 10
		modNum 1
		view 9691
		verb 15
		hiliteView 9691
		loliteView 9692
	)
)

(instance invBrooch of ScaryInventory
	(properties
		noun 11
		modNum 1
		view 9721
		verb 16
		hiliteView 9721
		loliteView 9722
	)

	(method (init)
		(if (IsFlag 81)
			(= hiliteView (= view 9871))
			(= loliteView 9872)
			(= verb 37)
		else
			(= hiliteView (= view 9721))
			(= loliteView 9722)
			(= verb 16)
		)
		(super init: &rest)
	)
)

(instance invPhoto of ScaryInventory
	(properties
		noun 12
		modNum 1
		view 9761
		verb 17
		hiliteView 9761
		loliteView 9762
	)
)

(instance invLensPiece of ScaryInventory
	(properties
		noun 13
		modNum 1
		view 9811
		verb 18
		hiliteView 9811
		loliteView 9812
	)
)

(instance invDrainCln of ScaryInventory
	(properties
		noun 14
		modNum 1
		view 9641
		verb 19
		hiliteView 9641
		loliteView 9642
	)
)

(instance invCrucifix of ScaryInventory
	(properties
		noun 15
		modNum 1
		view 9701
		verb 20
		hiliteView 9701
		loliteView 9702
	)
)

(instance invBeads of ScaryInventory
	(properties
		noun 16
		modNum 1
		view 9751
		verb 22
		hiliteView 9751
		loliteView 9752
	)
)

(instance invSpellBook of ScaryInventory
	(properties
		noun 17
		modNum 1
		view 9771
		verb 23
		hiliteView 9771
		loliteView 9772
	)
)

(instance invXmasOrn of ScaryInventory
	(properties
		noun 18
		modNum 1
		view 9781
		verb 25
		hiliteView 9781
		loliteView 9782
	)
)

(instance invStone of ScaryInventory
	(properties
		noun 19
		modNum 1
		view 9791
		verb 26
		hiliteView 9791
		loliteView 9792
	)
)

(instance invCutter of ScaryInventory
	(properties
		noun 20
		modNum 1
		view 9841
		verb 27
		hiliteView 9841
		loliteView 9842
	)
)

(instance invDogBone of ScaryInventory
	(properties
		noun 21
		modNum 1
		view 9831
		verb 28
		hiliteView 9831
		loliteView 9832
	)
)

(instance invFigurine of ScaryInventory
	(properties
		noun 22
		modNum 1
		view 9821
		verb 34
		hiliteView 9821
		loliteView 9822
	)

	(method (init)
		(if (IsFlag 114)
			(= hiliteView (= view 9861))
			(= loliteView 9862)
			(= verb 35)
		else
			(= hiliteView (= view 9821))
			(= loliteView 9822)
			(= verb 34)
		)
		(super init: &rest)
	)
)

(class InventoryHole of Feature
	(properties
		sightAngle 360
	)

	(method (onMe)
		(cond
			((not global161)
				(return 0)
			)
			((self isNotOccupied:)
				(return (super onMe: &rest))
			)
			(else
				(return 0)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= nsTop (- (- y 7) 10))
		(= nsBottom (+ nsTop 10))
		(= nsLeft (- x 7))
		(= nsRight (+ nsLeft 24))
		(self
			setHotspot:
				0
				8 ; invLibKey
				6 ; invMoney
				7 ; invNail
				9 ; invNewspaper
				10 ; invPoker
				11 ; invHammer
				12 ; invStairKey
				13 ; invVampBook
				14 ; invMatch
				15 ; invTarot
				16 ; invBrooch
				17 ; invPhoto
				18 ; invLensPiece
				19 ; invDrainCln
				20 ; invCrucifix
				22 ; invBeads
				23 ; invSpellBook
				25 ; invXmasOrn
				26 ; invStone
				27 ; invCutter
				28 ; invDogBone
				34 ; invFigurine
				35 ; ???
				37 ; ???
		)
		(global116 add: self)
		(gFeatures delete: self)
	)

	(method (setHotspot)
		(super setHotspot: &rest)
		(global160 delete: self)
		(gInterfaceHotCast add: self)
	)

	(method (handleEvent event)
		(cond
			((or (not global161) (event claimed:))
				(return 1)
			)
			((and (not (gUser canInput:)) (not (gUser canControl:)))
				(return 0)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== global206 2)
			((ScriptID 26 1) state: 0) ; movieScr
		)
		(cond
			((not (= temp0 (gInventory firstTrue: #isMyVerb theVerb)))
				(gGame pragmaFail:)
			)
			((not (self isNotOccupied:))
				(gGame pragmaFail:)
			)
			(else
				(gUser message: (gUser dftMessage:))
				(= global161 0)
				(temp0 x: x y: y init: show:)
				(gGame setCursor: gNormalCursor 1)
				(gCurrentControl select: 3 gNormalCursor)
			)
		)
	)

	(method (isNotOccupied &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
			(= temp2 (gInventory at: temp0))
			(if
				(and
					(== (temp2 owner:) -2)
					(temp2 isNotHidden:)
					(== (temp2 x:) x)
					(== (temp2 y:) y)
				)
				(return 0)
			)
		)
		(return 1)
	)

	(method (notFacing &tmp temp0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)
)

(instance inv1 of InventoryHole
	(properties
		x 104
		y 170
	)
)

(instance inv2 of InventoryHole
	(properties
		x 130
		y 170
	)
)

(instance inv3 of InventoryHole
	(properties
		x 180
		y 170
	)
)

(instance inv4 of InventoryHole
	(properties
		x 206
		y 170
	)
)

(instance inv5 of InventoryHole
	(properties
		x 104
		y 191
	)
)

(instance inv6 of InventoryHole
	(properties
		x 130
		y 191
	)
)

(instance inv7 of InventoryHole
	(properties
		x 180
		y 191
	)
)

(instance inv8 of InventoryHole
	(properties
		x 206
		y 191
	)
)

