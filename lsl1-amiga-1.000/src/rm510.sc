;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	lubberMaterial
	lubberTexture
	lubberColor
	lubberLubrication
	lubberPattern
	lubberFlavor
	lubberWeight
	lubberThickness
	lubberCoating
	lubberSize
	sprayPrice
	lubberPrice
	winePrice
	magazinePrice
	moneyOwed
	askedForBucks
	readyForMoney
	notPaid
	clerkTalk
	scopeRoom
	headCount
	readSign
	lookedAtMagRack
)

(procedure (OweMoney)
	(+= moneyOwed (+ lubberPrice sprayPrice winePrice magazinePrice))
	(= readyForMoney 1)
	(= notPaid 1)
)

(instance rm510 of LLRoom
	(properties
		lookStr {You are in a 24-hour convenience store. There is a magazine rack near the front door, with a sign reading "This no riblaly -- no leeding." Except for the clerk standing behind the counter, the store appears to be deserted. A small sign graces the counter.}
		picture 510
		south 500
		west 500
	)

	(method (init)
		(LoadMany rsVIEW 511 512 510 513)
		(LoadMany rsSOUND 510 514 513 511 512)
		(LoadMany rsFONT gGiantFont)
		(gTheMusic number: 510 vol: 127 loop: -1 flags: 1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 76 189 76 184 311 184 311 154 236 130 236 128 247 120 194 110 26 121 56 136 56 157 38 164 4 167 4 184 51 184 51 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 107 173 279 173 279 181 107 181
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 61 150 163 150 163 159 102 159 97 163 61 163
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 165 150 263 150 263 159 165 159
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 62 130 221 130 221 143 62 143
					yourself:
				)
		)
		(switch gPrevRoomNum
			(500
				(gEgo x: 60 init:)
			)
			(else
				(gEgo init: x: 60 y: 180)
			)
		)
		(cam1 setCycle: Osc init:)
		(cam2 setCycle: Osc init:)
		(cam3 setCycle: Osc init:)
		(cam4 setCycle: Osc init:)
		(cam5 setCycle: Osc init:)
		(cam6 setCycle: Osc init:)
		(cam7 setCycle: Osc init:)
		(cam8 setCycle: Osc init:)
		(cam9 setCycle: Osc init:)
		(cam10 setCycle: Osc init:)
		(cam11 setCycle: Osc init:)
		(cam12 setCycle: Osc init:)
		(lubberSign init: stopUpd: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(pClerk init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(sfxGunShot init:)
		(fShelves init:)
		(fShelves1 init:)
		(fMagazineStand init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(fWineShelves init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(fWineShelves1 init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(fWineShelves2 init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(fFreezer init:)
		(fBreathSpray init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(microwave init:)
		(checkoutCounter init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				readyForMoney
				notPaid
				(gEgo inRect: 45 180 81 190)
				(== (gCurRoom script:) 0)
			)
			(gCurRoom setScript: sShootLarry)
		)
	)

	(method (dispose)
		(if (and lubberFlavor (== notPaid 0))
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(Printf ; "Hey, Meester!!" yells the clerk. "I hope you enjoy your %s-weight, %s-gauge, %s-flavored, %s, %s, %s, %s, %s, %s small-sized lubber!!!"
				510
				0
				lubberWeight
				lubberThickness
				lubberFlavor
				lubberPattern
				lubberLubrication
				lubberColor
				lubberTexture
				lubberMaterial
				lubberCoating
			)
		)
		(gTheMusic fade:)
		(super dispose:)
	)
)

(instance sShootLarry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					cycleSpeed: 3
					setMotion: 0
					view: 511
					setLoop: 0
					setCel: 0
				)
				(pClerk
					cycleSpeed: 3
					setPri: 11
					setLoop: 2
					setCycle: CT 6 1 self
				)
				(Print 510 1 #font gBigFont #icon 512 2 0 #at -1 20) ; ""STOP! THIEF!" cries the clerk!"
			)
			(1
				(sfxGunShot play:)
				(pClerk setCycle: End self)
				(Print 510 2) ; ""Where?" you wonder."
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= seconds 4)
			)
			(4
				(gTheMusic fade:)
				(Death 511 2 1)
				(Format @gYourPart 510 3) ; "Caught you red-handed!"
				(GameOver 510 4)
			)
		)
	)
)

(instance sBuyLubber of Script
	(properties)

	(method (doit &tmp c)
		(super doit:)
		(if (and scopeRoom (== 4 (++ headCount)))
			(= headCount 0)
			(if (== (= c ((gEgo _head:) cel:)) 5)
				(= cycles 5)
			)
			((gEgo _head:)
				cel:
					(switch c
						(0 4)
						(1 7)
						(2 5)
						(3 6)
						(4 2)
						(5 1)
						(6 0)
						(7 3)
					)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== ((gInventory at: 8) owner:) gEgo) ; lubber
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 510 5) ; "You haven't used your old "lubber" yet!"
					(self dispose:)
				else
					(HandsOff)
					(gEgo setMotion: PolyPath 50 160 self)
				)
			)
			(1
				(Face gEgo pClerk)
				(gEgo moveHead: 0)
				(= seconds 3)
			)
			(2
				(= scopeRoom 1)
			)
			(3
				(= scopeRoom 0)
				((gEgo _head:) cel: 1)
				(= seconds 3)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 510 6) ; "After looking around to make certain you're alone, you quietly ask the clerk if he has any "lubbers" available."
				(= seconds 3)
			)
			(5
				(cam1 setCel: 6)
				(cam2 setCel: 0)
				(cam3 setCel: 0)
				(cam4 setCel: 1)
				(cam5 setCel: 4)
				(cam6 setCel: 0)
				(cam7 setCel: 2)
				(cam8 setCel: 0)
				(cam9 setCel: 0)
				(cam10 setCel: 2)
				(cam11 setCel: 0)
				(cam12 setCel: 4)
				(pClerk cycleSpeed: (+ 1 global101) setCycle: RandCycle 20 self)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(cam1 stopUpd:)
				(cam2 stopUpd:)
				(cam3 stopUpd:)
				(cam4 stopUpd:)
				(cam5 stopUpd:)
				(cam6 stopUpd:)
				(cam7 stopUpd:)
				(cam8 stopUpd:)
				(cam9 stopUpd:)
				(cam10 stopUpd:)
				(cam11 stopUpd:)
				(cam12 stopUpd:)
				(Print 510 7) ; "Sure, we got lubbers!"
				(Print 510 8 #at -1 140) ; "(Obviously you've hit his area of expertise!)"
				(pClerk setCycle: RandCycle 18 self)
			)
			(7
				(gGame setCursor: 999 1)
				(Animate (gCast elements:) 0)
				(if (Print 510 9 #button {Lambskin} 0 #button {Latex} 1) ; ""What kind lubbers you want?" he asks."
					(= lubberMaterial {latex})
				else
					(= lubberMaterial {lambskin})
				)
				(pClerk setCycle: RandCycle 16 self)
			)
			(8
				(if (Print 510 10 #button {Smooth} 0 #button {Ribbed} 1) ; ""What texture you want?" he asks."
					(= lubberTexture {libbed})
				else
					(= lubberTexture {smooth})
				)
				(pClerk setCycle: RandCycle 14 self)
			)
			(9
				(if (Print 510 11 #button {Colored} 0 #button {Plain} 1) ; ""What color you want?" he asks."
					(= lubberColor {plain})
				else
					(= lubberColor {colored})
				)
				(pClerk setCycle: RandCycle 12 self)
			)
			(10
				(if (Print 510 12 #button {Lubricated} 0 #button {Rough-cut} 1) ; ""What surface you want?" he asks."
					(= lubberLubrication {rough-cut})
				else
					(= lubberLubrication {lubricated})
				)
				(pClerk setCycle: RandCycle 10 self)
			)
			(11
				(if (Print 510 13 #button {Striped} 0 #button {Plaid} 1) ; ""What pattern you want?" he asks."
					(= lubberPattern {plaid})
				else
					(= lubberPattern {striped})
				)
				(pClerk setCycle: RandCycle 8 self)
			)
			(12
				(if (Print 510 14 #button {Peppermint} 0 #button {Spearmint} 1) ; ""What flavor you want?" he asks."
					(= lubberFlavor {spearmint})
				else
					(= lubberFlavor {peppermint})
				)
				(pClerk setCycle: RandCycle 6 self)
			)
			(13
				(if (Print 510 15 #button {Light} 0 #button {Heavy} 1) ; ""What weight you want?" he asks."
					(= lubberWeight {heavy})
				else
					(= lubberWeight {light})
				)
				(pClerk setCycle: RandCycle 4 self)
			)
			(14
				(if (Print 510 16 #button {Normal} 0 #button {Industrial} 1) ; ""What thickness you want?" he asks."
					(= lubberThickness {industrial})
				else
					(= lubberThickness {normal})
				)
				(pClerk setCycle: RandCycle 4 self)
			)
			(15
				(if (Print 510 17 #button {Plain} 0 #button {Spermicide} 1) ; ""What protection you want?" he asks."
					(= lubberCoating {spermicidal})
				else
					(= lubberCoating {non-spermicidal})
				)
				(pClerk setCycle: RandCycle 4 self)
			)
			(16
				(switch
					(Print 510 18 #button {Large} 0 #button {Giant} 1 #button {Gonzo} 2) ; ""What size you want?" he asks."
					(0
						(= lubberSize {large})
					)
					(1
						(= lubberSize {giant})
					)
					(2
						(= lubberSize {gonzo})
					)
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				(pClerk setCycle: RandCycle 4 self)
			)
			(17
				(Print 510 19) ; "Oakie, doakie Meester!"
				(pClerk setCycle: RandCycle 4 self)
			)
			(18
				(Printf ; "Hey, everybody!! This weirdo just bought a %s-weight, %s-gauge, %s-flavored, %s, %s, %s, %s, %s, %s small-sized lubber!!!"
					510
					20
					lubberWeight
					lubberThickness
					lubberFlavor
					lubberPattern
					lubberLubrication
					lubberColor
					lubberTexture
					lubberMaterial
					lubberCoating
					67
					15
					-1
					70
					280
				)
				(gTheMusic stop:)
				(= seconds 2)
			)
			(19
				(sfxHeadsOut init: play:)
				(pDudeLeft init:)
				(pKid init:)
				(pDudeUp init:)
				(pGranny init:)
				(pRabi init:)
				(= seconds 2)
			)
			(20
				(sfxPervert play:)
				(Print 510 21 #font gGiantFont #mode 1 #at -1 4 #width 250) ; "WHAT A PERVERT!!"
				(sfxHeadsIn init: play:)
				(gEgo get: 8) ; lubber
				(pDudeLeft dispose:)
				(pKid dispose:)
				(pDudeUp dispose:)
				(pGranny dispose:)
				(pRabi dispose:)
				(if (== (gGame detailLevel:) 3)
					(cam1 setCycle: Osc)
					(cam2 setCycle: Osc)
					(cam3 setCycle: Osc)
					(cam4 setCycle: Osc)
					(cam5 setCycle: Osc)
					(cam6 setCycle: Osc)
					(cam7 setCycle: Osc)
					(cam8 setCycle: Osc)
					(cam9 setCycle: Osc)
					(cam10 setCycle: Osc)
					(cam11 setCycle: Osc)
					(cam12 setCycle: Osc)
				)
				(= lubberPrice (Random 4 10))
				(OweMoney)
				(pClerk setCycle: RandCycle 4 self)
			)
			(21
				(Points 69 4)
				(Printf 510 22 moneyOwed) ; "He hands you the package, saying "All together, that will be $%d.00, prease.""
				(= askedForBucks 1)
				(gTheMusic play:)
				(HandsOn)
				(NormalEgo 1)
				(self dispose:)
			)
		)
	)
)

(instance sGrabWine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo fWineShelves)
				(= cycles 7)
			)
			(1
				(gEgo
					view: 511
					setLoop: 1
					setCel: 0
					cycleSpeed: (* 2 global101)
					setCycle: End self
				)
			)
			(2
				(gEgo get: 12) ; wine
				(Points 79 1)
				(= cycles 8)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 510 23) ; "You grab a lovely cardboard box of "fine" wine. You wonder how they can make a profit on this stuff, selling it for only a dollar a gallon!"
				(= cycles 3)
			)
			(4
				(HandsOn)
				(NormalEgo 3)
				(self dispose:)
			)
		)
	)
)

(instance sGrabBreathSpray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo fBreathSpray)
				(= cycles 1)
			)
			(1
				(pClerk setLoop: 0 setCycle: RandCycle 10 self)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 510 24) ; "Hey, Meester, eet smells like chur brand!"
				(gEgo get: 1) ; breathSpray
				(= cycles 3)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sfxPervert of Sound
	(properties
		flags 1
		number 512
	)
)

(instance sfxGunShot of Sound
	(properties
		number 514
	)
)

(instance sfxHeadsIn of Sound
	(properties
		number 513
	)
)

(instance sfxHeadsOut of Sound
	(properties
		number 511
	)
)

(instance pClerk of Person
	(properties
		x 8
		y 131
		description {the store clerk}
		approachX 50
		approachY 160
		lookStr {What law says that convenience store clerks must be non-English speaking?!}
		view 512
		priority 10
		signal 16
		detailLevel 3
	)

	(method (cue)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(pClerk setCycle: 0)
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(3 ; Do
				(Print 510 25) ; "You can't stand the idea of running your hand through THAT turban!"
			)
			(10 ; Zipper
				(gCurRoom setScript: sBuyLubber)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(cond
							((and readyForMoney notPaid (>= gLarryDollars moneyOwed))
								(if (== askedForBucks 0)
									(Printf 510 26 moneyOwed) ; "Oakie, doakie Meester! That'll be $%d.00."
								)
								(-= gLarryDollars moneyOwed)
								(= readyForMoney 0)
								(= notPaid 0)
								(= magazinePrice 0)
								(= winePrice 0)
								(= sprayPrice 0)
								(= lubberPrice 0)
								(= moneyOwed 0)
								(Print 510 27) ; "You give him the money, with a pleasant "Thanks a lot, Saddam!""
								(Print 510 28) ; "Have a nice day."
							)
							((< gLarryDollars moneyOwed)
								(Printf 510 29 gLarryDollars) ; "Unfortunately, you only have $%d.00."
								(Print 510 30 #at -1 140) ; "(Perhaps you can sneak out without paying.)"
							)
							(else
								(Print 510 31) ; "Ooooooh, Meester! Thank you for free money. What wonderful country thees is!!"
								(-= gLarryDollars 10)
							)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(5 ; Talk
				(if readSign
					(gCurRoom setScript: sBuyLubber)
				else
					(pClerk setLoop: 0 setCycle: ForwardCounter 5 self)
					(switch clerkTalk
						(0
							(Print 510 32 #dispose) ; "Fposwqa feinnzx. Ofewass gewyiu qfbva."
						)
						(1
							(Print 510 33 #dispose) ; "Poolskd asd woefpo lkjfq feps of foeps."
						)
						(2
							(Print 510 34 #dispose) ; "Owf wepa vpifk qpqwf? Qqwpp apifrp qp foiw!"
						)
						(3
							(Print 510 35 #dispose) ; "Qufe weax zxo zvp zvqiw vpozcvajpbnv wf, apoz. Wfipa?"
						)
						(4
							(Print 510 36 #dispose) ; "Tqp nbq bqopni ba ajpqoi fqyq. HA HA HA!!"
						)
						(5
							(Print 510 37 #dispose) ; "Pqwwo qfp qwfnbv qozdvie. Ppqow poqw fvzxc ioplhjk."
						)
						(6
							(Print 510 38 #dispose) ; "Zxzz pofqsoo afpoistr zxcv."
						)
					)
					(if (< clerkTalk 6)
						(++ clerkTalk)
					else
						(= clerkTalk 0)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cam1 of Prop
	(properties
		x 8
		y 55
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 3
		cel 6
		priority 15
		signal 16
		cycleSpeed 10
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(3 ; Do
				(Print 510 39) ; "You can't reach the cameras."
			)
			(10 ; Zipper
				(Print 510 40) ; "Larry! Don't expose yourself to the video camera!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cam2 of Prop
	(properties
		x 27
		y 55
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 1
		priority 15
		signal 16
		cycleSpeed 15
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam3 of Prop
	(properties
		x 46
		y 55
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 2
		priority 15
		signal 16
		cycleSpeed 5
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam4 of Prop
	(properties
		x 67
		y 40
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 1
		cel 1
		cycleSpeed 10
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam5 of Prop
	(properties
		x 93
		y 39
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 2
		cel 4
		cycleSpeed 25
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam6 of Prop
	(properties
		x 121
		y 38
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 3
		cycleSpeed 20
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam7 of Prop
	(properties
		x 150
		y 37
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 1
		cel 2
		cycleSpeed 30
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam8 of Prop
	(properties
		x 181
		y 36
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 3
		cycleSpeed 15
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam9 of Prop
	(properties
		x 209
		y 37
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		cycleSpeed 10
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam10 of Prop
	(properties
		x 238
		y 39
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 1
		cel 2
		cycleSpeed 20
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam11 of Prop
	(properties
		x 269
		y 41
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 3
		cycleSpeed 15
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance cam12 of Prop
	(properties
		x 299
		y 43
		description {the security camera}
		lookStr {Saddam is watching.}
		view 510
		loop 2
		cel 4
		cycleSpeed 10
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(cam1 doVerb: theVerb invItem)
	)
)

(instance pDudeLeft of Prop
	(properties
		x 64
		y 98
		view 513
		priority 12
		signal 16
	)
)

(instance pKid of Prop
	(properties
		x 106
		y 89
		view 513
		loop 1
		priority 5
		signal 16
	)
)

(instance pDudeUp of Prop
	(properties
		x 162
		y 145
		view 513
		loop 2
		priority 10
		signal 16
	)
)

(instance pGranny of Prop
	(properties
		x 204
		y 142
		view 513
		loop 3
		priority 12
		signal 16
	)
)

(instance pRabi of Prop
	(properties
		x 267
		y 159
		view 513
		loop 4
		priority 14
		signal 16
	)
)

(instance fShelves of Feature
	(properties
		x 97
		y 121
		nsTop 86
		nsLeft 74
		nsBottom 157
		nsRight 120
		description {the store shelves}
		sightAngle 40
		lookStr {The shelves are filled with all the necessities of life: "Dwinkies," "Wallo-Wars," "Loritos," various colas, cheap wine, and coffee. You don't see anything you really need in this part of the store.}
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(3 ; Do
				(Print 510 41) ; "These shelves don't contain the particular necessities you need right now."
			)
			(11 ; Taste/Smell
				(Print 510 42) ; "Ah, the aroma!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fShelves1 of Feature
	(properties
		x 180
		y 75
		nsTop 78
		nsLeft 120
		nsBottom 139
		nsRight 241
		description {the store shelves}
		sightAngle 40
		lookStr {The shelves are filled with all the necessities of life: "Dwinkies," "Wallo-Wars," "Loritos," various colas, cheap wine, and coffee. You don't see anything you really need in this part of the store.}
	)

	(method (doVerb theVerb invItem)
		(fShelves doVerb: theVerb invItem)
	)
)

(instance fMagazineStand of Feature
	(properties
		x 192
		y 160
		nsTop 140
		nsLeft 121
		nsBottom 181
		nsRight 263
		description {the magazine rack}
		sightAngle 40
		approachX 180
		approachY 185
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(= lookedAtMagRack 1)
				(Print 510 43) ; "There are many magazines on the rack, but your eyes immediately go to the ones with the naked girls on the cover."
			)
			(3 ; Do
				(cond
					((IsFlag 70) ; pGotMagazine
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 510 44) ; "Nah. That's enough reading material for one game."
					)
					((== lookedAtMagRack 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(= magazinePrice 4)
						(Print 510 45) ; "Suiting your discriminating tastes, you select the current issue of "JUGS.""
						(OweMoney)
						(gEgo get: 13) ; magazine
						(Points 70 1)
					)
					(else
						(Print 510 46) ; "There are many magazines on the convenience store's spacious magazine rack. How will you ever choose?"
					)
				)
			)
			(else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fWineShelves of Feature
	(properties
		x 81
		y 70
		nsTop 55
		nsLeft 48
		nsBottom 85
		nsRight 114
		description {the wine shelf}
		sightAngle 40
		approachX 49
		approachY 121
		lookStr {That extra large box of wine looks like a bargain.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (!= ((gInventory at: 12) owner:) gEgo) ; wine
					(= winePrice 1)
					(OweMoney)
					(gCurRoom setScript: sGrabWine)
				else
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 510 47) ; "Whew. One of those handsome boxes is about all a guy needs, Larry."
				)
			)
			(else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fWineShelves1 of Feature
	(properties
		x 36
		y 70
		nsTop 92
		nsBottom 115
		nsRight 72
		description {the wine shelf}
		sightAngle 40
		approachX 49
		approachY 121
		lookStr {That extra large box of wine looks like a bargain.}
	)

	(method (doVerb theVerb invItem)
		(fWineShelves doVerb: theVerb invItem)
	)
)

(instance fWineShelves2 of Feature
	(properties
		x 55
		y 70
		nsTop 86
		nsLeft 39
		nsBottom 92
		nsRight 72
		description {the wine shelf}
		sightAngle 40
		approachX 49
		approachY 121
		lookStr {That extra large box of wine looks like a bargain.}
	)

	(method (doVerb theVerb invItem)
		(fWineShelves doVerb: theVerb invItem)
	)
)

(instance fFreezer of Feature
	(properties
		x 284
		y 105
		nsTop 72
		nsLeft 250
		nsBottom 139
		nsRight 318
		description {the food freezer}
		sightAngle 40
		lookStr {There's nothing of interest inside the freezer.}
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(3 ; Do
				(Print 510 48) ; "There's nothing of interest inside."
			)
			(11 ; Taste/Smell
				(Print 510 49) ; "Chunks of your tongue are still frozen to your ice tray at home, Larry."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fBreathSpray of Feature
	(properties
		x 83
		y 136
		nsTop 119
		nsLeft 72
		nsBottom 153
		nsRight 94
		description {the rack filled with breath spray}
		sightAngle 40
		approachX 87
		approachY 165
		lookStr {The counter contains a lovely display rack filled with breath spray. And, it's your brand!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (!= ((gInventory at: 1) owner:) gEgo) ; breathSpray
					(= sprayPrice 3)
					(OweMoney)
					(gCurRoom setScript: sGrabBreathSpray)
				else
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 510 50) ; "Your current supply of breath spray is not yet depleted."
				)
			)
			(11 ; Taste/Smell
				(Print 510 51) ; "The breath spray display is filled with your favorite, Uvula Killer Brand, `Garlic and Cloves 24-hour Breath Freshener.'"
				(Print 510 52) ; "Tastes great, and drives the babes crazy too!"
			)
			(else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance microwave of Feature
	(properties
		x 131
		y 115
		z 47
		nsTop 57
		nsLeft 115
		nsBottom 79
		nsRight 147
		description {the microwave}
		sightAngle 40
		lookStr {You may want to warm something in this microwave oven, but you can't.}
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(3 ; Do
				(Print 510 53) ; "It's broken."
			)
			(4 ; Inventory
				(switch invItem
					(3 ; apple
						(Print 510 54) ; "Baked apples? Not really."
					)
					(9 ; candy
						(Print 510 55) ; "Yeah, good idea! Melted ice cream."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance checkoutCounter of Feature
	(properties
		x 22
		y 70
		z 32
		nsTop 132
		nsBottom 158
		nsRight 44
		description {the checkout counter}
		sightAngle 40
		approachX 50
		approachY 160
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(= readSign 1)
				(Print 510 56) ; "The sign reads, "Lubbers For Sale just ask clerk!""
			)
			(3 ; Do
				(gCurRoom setScript: sBuyLubber)
			)
			(10 ; Zipper
				(gCurRoom setScript: sBuyLubber)
			)
			(else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lubberSign of View
	(properties
		x 17
		y 136
		description {the small, lubber sign}
		approachX 50
		approachY 160
		view 510
		loop 4
		priority 10
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(= readSign 1)
				(Print 510 57) ; "The sign reads, "Lubbers For Sale -- just ask clerk!""
			)
			(3 ; Do
				(gCurRoom setScript: sBuyLubber)
			)
			(10 ; Zipper
				(gCurRoom setScript: sBuyLubber)
			)
			(else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

