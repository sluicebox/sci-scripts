;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use n804)
(use n819)
(use EcoFeature)
(use EcoDialog)
(use Talker)
(use BorderWindow)
(use Inventory)
(use System)

(public
	invCode 0
)

(instance invCode of Code
	(properties)

	(method (init)
		(invWin
			topBordHgt: 5
			botBordHgt: 26
			color: 0
			priority: -1
			back: global210
			topBordColor: global217
			lftBordColor: global217
			rgtBordColor: global216
			botBordColor: global213
			insideColor: global215
			topBordColor2: global213
			lftBordColor2: global216
			botBordColor2: global217
			rgtBordColor2: global217
		)
		(Inv
			init:
			add:
				bikeCage
				starFish
				goldMask
				healingPotion
				screws
				waterPump
				tweezers
				urchins
				sharpShell
				conchShell
				sodaCan
				certificate
				card
				beaker
				waterBottle
				frisbee
				mackeral
				scubaGear
				dishSoap
				airTanks
				trident
				spine
				hermetShell
				mirror
				boxKey
				scroll
				sawFishHead
				fishLure
				hackSaw
				transmitter
				float
				steelCable
				jar
				rag
				sixPackRing
			eachElementDo: #highlightColor global207
			eachElementDo: #lowlightColor (invWin insideColor:)
			add: invLook invHand invSelect invHelp ok
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
	)
)

(class RInvItem of InvI
	(properties
		view 900
		signal 2
		cursorLoop 0
		cursorCel 0
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(if (== theVerb 44) ; Inventory
			(= temp1
				(if (== (- temp0 9) (gInventory indexOf: self))
					220
				else
					(switch temp0
						(9 10)
						(10 14)
						(11 11)
						(12 27)
						(13 25)
						(14 30)
						(15 32)
						(16 35)
						(17 38)
						(18 28)
						(19 153)
						(20 173)
						(21 171)
						(22 152)
						(23 165)
						(24 160)
						(25 161)
						(26 164)
						(27 154)
						(28 163)
						(29 189)
						(30 193)
						(31 196)
						(32 197)
						(33 198)
						(34 212)
						(35 204)
						(36 205)
						(37 207)
						(38 209)
						(39
							(if (== (float cel:) 6) 203 else 215)
						)
						(40
							(if (== (steelCable cel:) 11) 219 else 51)
						)
						(41
							(switch global233
								(0 155)
								(1 156)
								(else 157)
							)
						)
						(42
							(switch global232
								(2 169)
								(0 167)
								(else 6)
							)
						)
						(else 42)
					)
				)
			)
			(= temp3 global251)
			(= global251 1)
			(cond
				((< temp1 100)
					(EcoNarrator init: 1 0 0 temp1 0 3)
				)
				((< temp1 200)
					(EcoNarrator init: 2 0 0 (- temp1 100) 0 4)
				)
				((< temp1 300)
					(EcoNarrator init: 3 0 0 (- temp1 200) 0 5)
				)
				(else
					(proc821_2 5 0 temp1)
				)
			)
			(= global251 temp3)
			(= temp3 0)
		else
			(super doVerb: theVerb temp0 &rest)
		)
	)

	(method (select)
		(if (super select: &rest)
			((ScriptID 0 7) cel: cursorCel) ; invC
			((ScriptID 0 7) loop: cursorLoop) ; invC
		)
	)

	(method (init)
		(= cursor (ScriptID 0 7)) ; invC
		(super init: &rest)
	)
)

(instance sodaCan of RInvItem
	(properties
		message 19
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 67 0 3) ; "Adam's picked up an empty soda can. It's made of aluminum and is recyclable."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 68 0 3) ; "Adam could be a he-man and crush the can, but that's a little bit silly, don't you think?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance certificate of RInvItem
	(properties
		cel 1
		message 20
		owner 400
		cursorLoop 1
		cursorCel 10
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 47 0 4)
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 72 0 4) ; "There's nothing on the back of the certificate."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance card of RInvItem
	(properties
		cel 2
		message 21
		cursorLoop 1
		cursorCel 11
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 46 0 4)
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 70 0 4) ; "There's nothing on the back of the membership card."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beaker of RInvItem
	(properties
		cel 4
		message 22
		owner 400
		cursorCel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 2 0 0 58 0 4)
			)
			(1 ; Look
				(if (IsFlag 8)
					(EcoNarrator init: 1 0 0 19 0 3) ; "The flask of fertilizer solution is empty."
				else
					(EcoNarrator init: 3 0 0 13 0 5) ; "Adam's carrying a flask of his father's experimental fertilizer solution. The solution helps create bacteria that eat oil. Unfortunately, it still has a long way to go before it can be used to really impact large spills."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rag of RInvItem
	(properties
		cel 6
		message 42
		owner 400
		cursorCel 2
	)

	(method (show)
		(switch global232
			(1
				(= loop 2)
				(= cel 3)
			)
			(2
				(= loop 0)
				(= cel 11)
			)
			(3
				(= loop 2)
				(= cel 9)
			)
			(4
				(= loop 2)
				(= cel 3)
			)
			(else
				(= loop 0)
				(= cel 6)
			)
		)
		(if (== global232 2)
			(= cursorLoop 2)
			(= cursorCel 4)
		else
			(= cursorLoop 0)
			(= cursorCel 2)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(switch theVerb
			(1 ; Look
				(cond
					(
						(<
							(= temp1
								(switch global232
									(1 3)
									(2 143)
									(3 142)
									(4 3)
									(else 142)
								)
							)
							100
						)
						(EcoNarrator init: 1 0 0 temp1 0 3)
					)
					((< temp1 200)
						(EcoNarrator init: 2 0 0 (- temp1 100) 0 4)
					)
					((< temp1 300)
						(EcoNarrator init: 3 0 0 (- temp1 200) 0 5)
					)
				)
			)
			(4 ; Do
				(switch global232
					(2
						(EcoNarrator init: 2 0 0 68 0 4) ; "Hmmm. Squdgy!"
					)
					(0
						(EcoNarrator init: 2 0 0 66 0 4) ; "The rag feels cool and soft."
					)
					(else
						(EcoNarrator init: 1 0 0 4 0 3) ; "If you want Adam to use the rag, click it on an object on the main screen."
					)
				)
			)
			(27 ; ???
				(if (== global232 0)
					(EcoNarrator init: 2 0 2 15 0 4) ; "Adam puts some of the dishsoap onto the clean rag."
					(Inv hide:)
					(= global232 2)
					(SetScore 5 202)
					(gEgo put: 18) ; dishSoap
					(Inv showSelf: gEgo)
				)
			)
			(31 ; ???
				(if (IsFlag 273)
					(EcoNarrator init: 2 0 0 41 0 4)
				else
					(EcoNarrator init: 1 0 0 5 0 3) ; "Adam uses the rag to clean the oil and tar off of the shell. He gets all the oil off the shell but, boy, that rag sure is oily now!"
					(Inv hide:)
					(= global232 4)
					(SetScore 5 273)
					(Inv showSelf: gEgo)
				)
			)
			(33 ; ???
				(EcoNarrator init: 1 0 0 57 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dishSoap of RInvItem
	(properties
		cel 7
		message 27
		cursorCel 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 44 0 4)
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 59 0 4)
			)
			(42 ; ???
				(SetScore 5 202)
				(if (== global232 0)
					(EcoNarrator init: 2 0 2 15 0 4) ; "Adam puts some of the dishsoap onto the clean rag."
					(Inv highlightedIcon: rag hide: gEgo)
					(= global232 2)
					(gEgo put: 18) ; dishSoap
					(Inv showSelf: gEgo)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frisbee of RInvItem
	(properties
		cel 8
		message 24
		cursorCel 4
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 70 0 3) ; "Adam is carrying a frisbee."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 71 0 3) ; "Adam would like to play frisbee, but who could he play with?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mackeral of RInvItem
	(properties
		cel 9
		message 25
		cursorCel 5
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 72 0 3) ; "Adam is carrying a fish. Holy mackerel!"
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 73 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scubaGear of RInvItem
	(properties
		loop 2
		message 26
		cursorLoop 3
		cursorCel 6
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 9 0 4) ; "Adam is carrying his scuba gear: swim fins, mask, diving gloves and flippers. They help him swim underwater."
			)
			(4 ; Do
				(if (== gCurRoomNum 381)
					(EcoNarrator init: 2 0 0 10 0 4) ; "Adam doesn't need to put on his scuba gear until he's ready to go in the water."
				else
					(EcoNarrator init: 2 0 0 11 0 4) ; "Adam will need to put on the scuba gear to swim, but you'll have to select the scuba gear, then click the gear on Adam on the main screen."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance airTanks of RInvItem
	(properties
		loop 2
		cel 1
		message 28
		cursorCel 8
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 78 0 3)
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 81 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bikeCage of RInvItem
	(properties
		loop 2
		cel 4
		message 9
		owner 180
		cursorCel 9
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 298)
					(EcoNarrator init: 1 0 0 15 0 5) ; "The steel cage looks as though it might have once been a bicycle basket. Although it was dumped as trash, Adam thinks he might be able to find a new use for the cage. There are four screws attached to the steel cage."
				else
					(EcoNarrator init: 1 0 0 15 0 3) ; "The steel cage looks as though it might have once been a bicycle basket. Although it was dumped as trash, Adam thinks he might be able to find a new use for the cage."
				)
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 13 0 3) ; "If you want Adam to use the steel cage, click it on an object on the main screen."
			)
			(13 ; ???
				(EcoNarrator init: 1 0 1 12 0 3) ; "Adam attaches the four screws to the steel cage."
				(gEgo put: 4) ; screws
				(SetFlag 42)
				(Inv hide:)
				(SetScore 5 298)
				(Inv showSelf: gEgo)
				(proc0_5 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance conchShell of RInvItem
	(properties
		loop 2
		cel 5
		message 18
		owner 140
		cursorCel 10
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 20 0 3) ; "Adam is carrying a large, bronze conch shell. Conch shells have been valued for centuries because of the deep, resonate sound they produce when blown."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 21 0 3) ; "Adam would like to blow the mighty conch, but he can't take out his regulator."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trident of RInvItem
	(properties
		loop 2
		cel 6
		message 29
		owner 120
		cursorCel 11
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 16 0 3) ; "The bronze trident has a long handle and three prongs on one end. The three prongs have pointed tips."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 17 0 3) ; "Adam turns the trident around and looks at the prongs from another direction. Hmmmm. The shape of the three tips looks kind of familiar."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sharpShell of RInvItem
	(properties
		loop 2
		cel 7
		message 17
		owner 222
		cursorCel 12
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 37 0 3)
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 39 0 3) ; "Watch out for the shell's sharp edge!"
			)
			(43 ; ???
				(EcoNarrator init: 2 0 2 20 0 4) ; "Major ecological sensitivity, man! Adam cuts apart the plastic circles of the six-pack rings and puts them in his garbage bag."
				(SetScore 5 289)
				(gEgo put: 34) ; sixPackRing
				(Inv hide:)
				(gInventory showSelf: gEgo)
				(proc0_5 8)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tweezers of RInvItem
	(properties
		loop 2
		cel 8
		message 15
		owner 223
		cursorCel 13
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 31 0 3) ; "Adam is carrying fish-bone tweezers that were given to him by Hippocrates in thanks for getting a set of six-pack rings off his snout."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance urchins of RInvItem
	(properties
		loop 4
		message 16
		owner 221
		cursorCel 14
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 34 0 3) ; "Adam is carrying sea urchins given to him by Narcissus in thanks for saving him from a plastic baggie. The sea urchins are small creatures that eat algae."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 36 0 3) ; "Watch out for those sea urchin's spines!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterPump of RInvItem
	(properties
		loop 4
		cel 1
		message 14
		owner 335
		cursorCel 15
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 29 0 3) ; "Adam is carrying a water pump."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 30 0 3) ; "If you want Adam to use the water pump, you'll need to click the pump on an object on the screen."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spine of RInvItem
	(properties
		loop 4
		cel 2
		message 30
		owner 226
		cursorLoop 1
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 40 0 3) ; "Adam's carrying one of Olympia's lionfish spines. The spines contain a powerful poison that will kill smaller fish but probably only stun large sea creatures."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 41 0 3) ; "Adam knows better than to play with that poisonous lionfish spine!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screws of RInvItem
	(properties
		loop 4
		cel 3
		message 13
		owner 224
		cursorLoop 1
		cursorCel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 24 0 3) ; "Adam is carrying four metal screws that Erroneous gave him for pulling the balloon from his throat."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 26 0 3) ; "Adam examines the screws but finds nothing unusual."
			)
			(9 ; ???
				(EcoNarrator init: 1 0 1 12 0 3) ; "Adam attaches the four screws to the steel cage."
				(gEgo put: 4 0) ; screws
				(SetFlag 42)
				(Inv highlightedIcon: bikeCage hide:)
				(SetScore 5 298)
				(Inv showSelf: gEgo)
				(proc0_5 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goldMask of RInvItem
	(properties
		loop 4
		cel 4
		message 11
		owner 160
		cursorLoop 1
		cursorCel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 9 0 3) ; "The beautiful gold mask was given to Adam by Superfluous, the Mayor. It's a sign of his gratitude for gathering the citizens of Eluria."
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 94 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance starFish of RInvItem
	(properties
		loop 4
		cel 5
		message 10
		owner 160
		cursorLoop 1
		cursorCel 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 12 0 3) ; "The starfish badge is a real, live starfish. Superfluous gave it to Adam as a kind of deputy badge."
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 95 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance healingPotion of RInvItem
	(properties
		loop 4
		cel 6
		message 12
		owner 180
		cursorLoop 1
		cursorCel 4
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 22 0 3) ; "Adam is carrying the healing potion that Demeter, the Guardian of the Greens, gave him. According to Demeter, this is the last dose of a miraculous potion that was made of now-extinct sea plants."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 23 0 3) ; "Adam doesn't need the healing potion himself. He should save it for someone who's in need of a miracle."
			)
			(else
				(super doVerb: theVerb temp0 &rest) ; UNINIT
			)
		)
	)
)

(instance hermetShell of RInvItem
	(properties
		loop 4
		cel 8
		message 31
		owner 180
		cursorLoop 1
		cursorCel 6
	)

	(method (show)
		(switch global232
			(4
				(= loop 4)
				(= cel 7)
				(= cursorCel 5)
			)
			(else
				(= loop 4)
				(= cel 8)
			)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 273)
					(EcoNarrator store: 44 init: 1 0 0 43 0 3)
				else
					(EcoNarrator store: 45 init: 1 0 0 43 0 3)
				)
			)
			(4 ; Do
				(if (IsFlag 273)
					(EcoNarrator init: 1 0 0 47 0 3) ; "The shell is already clean."
				else
					(EcoNarrator init: 1 0 0 46 0 3)
				)
			)
			(42 ; ???
				(if (IsFlag 273)
					(EcoNarrator init: 2 0 0 41 0 4)
				else
					(EcoNarrator init: 1 0 0 5 0 3) ; "Adam uses the rag to clean the oil and tar off of the shell. He gets all the oil off the shell but, boy, that rag sure is oily now!"
					(Inv hide:)
					(= cel 7)
					(= global232 4)
					(SetScore 5 273)
					(Inv showSelf: gEgo)
				)
			)
			(22 ; ???
				(EcoNarrator init: 1 0 0 19 0 3) ; "The flask of fertilizer solution is empty."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jar of RInvItem
	(properties
		loop 4
		cel 9
		message 41
		owner 420
		cursorLoop 1
		cursorCel 7
	)

	(method (show)
		(switch global233
			(1
				(= loop 4)
				(= cel 11)
				(= cursorCel 8)
			)
			(2
				(= loop 6)
				(= cel 1)
				(= cursorCel 9)
			)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(switch global233
					(1
						(EcoNarrator init: 1 0 0 58 0 3)
					)
					(2
						(if (== gCurRoomNum 540)
							(EcoNarrator init: 3 0 0 45 0 5) ; "The glowfish sheds some light on the cave from inside the bottle. However, the glass dulls some of the brightness."
						else
							(EcoNarrator init: 1 0 0 60 0 3)
						)
					)
					(else
						(EcoNarrator init: 1 0 0 61 0 3)
					)
				)
			)
			(4 ; Do
				(switch global233
					(0
						(EcoNarrator init: 1 0 0 66 0 3) ; "Adam struggles to remove the lid of the jar but it's stuck on fast! It will take a stronger grip than Adam's to remove that lid."
					)
					(2
						(if (== gCurRoomNum 540)
							(Inv hide:)
							(gCurRoom notify:)
						else
							(EcoNarrator init: 3 0 0 14 0 5) ; "Adam decides to leave the flashlight fish in the jar until he can set it free in a nice, dark place."
						)
					)
					(else
						(EcoNarrator init: 1 0 0 62 0 3)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mirror of RInvItem
	(properties
		loop 6
		cel 2
		message 32
		owner 420
		cursorLoop 1
		cursorCel 13
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 85 0 3)
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 86 0 3)
			)
			(else
				(super doVerb: theVerb temp0) ; UNINIT
			)
		)
	)
)

(instance boxKey of RInvItem
	(properties
		loop 6
		cel 4
		message 33
		owner 460
		cursorLoop 1
		cursorCel 14
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 89 0 3)
			)
			(42 ; ???
				(EcoNarrator init: 1 0 0 57 0 3)
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 90 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steelCable of RInvItem
	(properties
		loop 6
		cel 5
		message 40
		owner 480
		cursorLoop 1
		cursorCel 15
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (== cel 12) (!= theVerb 38)) ; ???
			(EcoNarrator init: 3 0 0 19 0 5) ; "There's no reason to attach that to the float and cable."
		else
			(switch theVerb
				(1 ; Look
					(switch cel
						(11
							(EcoNarrator init: 3 0 0 1 0 5) ; "The cable now has the 'float' and transmitter attached to it. The float will make one end of the cable rise to the surface while the other end can be attached to something on the ocean floor. The transmitter will produce a satellite signal."
						)
						(12
							(EcoNarrator init: 3 0 0 47 0 5) ; "The cable now has the 'float' attached to it. This will make one end of the cable rise to the surface while the other end can be attached to something on the ocean floor."
						)
						(else
							(EcoNarrator init: 1 0 0 91 0 3)
						)
					)
				)
				(4 ; Do
					(switch cel
						(11
							(EcoNarrator init: 3 0 0 16 0 5) ; "Adam checks the satellite buoy he devised. It looks ready to go."
						)
						(12
							(EcoNarrator init: 3 0 0 18 0 5) ; "Adam checks the float and cable. It looks ready to go."
						)
						(else
							(EcoNarrator init: 1 0 0 92 0 3)
						)
					)
				)
				(39 ; ???
					(if (== (float cel:) 10)
						(EcoNarrator init: 2 0 2 27 0 4) ; "Adam attaches the impromptu satellite buoy to the cable."
					else
						(EcoNarrator init: 1 0 1 14 0 3) ; "Adam attaches the float to the cable. He now has a working buoy."
					)
					(Inv hide:)
					(gEgo put: 30) ; float
					(SetScore 5 331)
					(if (== (float cel:) 10)
						(= cel 11)
					else
						(= cel 12)
					)
					(Inv showSelf: gEgo)
				)
				(38 ; ???
					(if (== cel 12)
						(EcoNarrator init: 3 0 0 10 0 5) ; "Adam attaches the transmitter to the float at the end of the cable."
						(Inv hide:)
						(= cel 11)
						(SetScore 5 330)
						(gEgo put: 29) ; transmitter
						(Inv showSelf: gEgo)
					else
						(EcoNarrator init: 1 0 0 49 0 3)
					)
				)
				(37 ; ???
					(EcoNarrator init: 2 0 0 3 0 4) ; "Adam doesn't want to cut up the cable!"
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance float of RInvItem
	(properties
		loop 6
		cel 6
		message 39
		owner 500
		cursorLoop 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if (== cel 10)
					(EcoNarrator init: 3 0 0 2 0 5) ; "Adam has attached the transmitter to the float. This will allow the transmitter to ride on the ocean's surface and transmit its signal."
				else
					(EcoNarrator init: 1 0 0 93 0 3)
				)
			)
			(4 ; Do
				(if (== cel 10)
					(EcoNarrator init: 3 0 0 17 0 5) ; "Adam checks the transmitter and float. They look ready to attach to a line of some sort."
				else
					(EcoNarrator init: 1 0 0 94 0 3)
				)
			)
			(40 ; ???
				(if (== cel 10)
					(EcoNarrator init: 2 0 2 27 0 4) ; "Adam attaches the impromptu satellite buoy to the cable."
					(steelCable cel: 11)
				else
					(steelCable cel: 12)
					(EcoNarrator init: 1 0 1 14 0 3) ; "Adam attaches the float to the cable. He now has a working buoy."
				)
				(Inv highlightedIcon: steelCable hide:)
				(gEgo put: 30) ; float
				(SetScore 5 331)
				(Inv showSelf: gEgo)
			)
			(38 ; ???
				(EcoNarrator init: 1 0 1 16 0 3) ; "Adam fixes the sonar transmitter to the float."
				(Inv hide:)
				(= cel 10)
				(SetScore 5 330)
				(gEgo put: 29) ; transmitter
				(Inv showSelf: gEgo)
			)
			(else
				(if (== (float cel:) 6)
					(EcoNarrator init: 3 0 0 3 0 5) ; "There's no reason to float that."
				else
					(EcoNarrator init: 1 0 0 53 0 3)
				)
			)
		)
	)
)

(instance sawFishHead of RInvItem
	(properties
		loop 6
		cel 8
		message 35
		owner 343
		cursorLoop 2
		cursorCel 1
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator store: 98 init: 97 0 3)
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 99 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fishLure of RInvItem
	(properties
		loop 8
		cel 10
		message 36
		owner 343
		cursorLoop 1
		cursorCel 12
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 3 0 0 1 0 4) ; "The brightly colored fishing lure has lost its hook and is now harmless. It still looks like dinner to fish, though!"
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 1 0 4) ; "Does that feel just exactly like a fishing lure, or what?!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hackSaw of RInvItem
	(properties
		loop 6
		cel 9
		message 37
		owner 500
		cursorLoop 2
		cursorCel 5
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 2 0 4) ; "The hacksaw is still surprisingly sharp and sturdy. It looks like it could cut through solid steel!"
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 4 0 4) ; "Adam handles the saw carefully. It's a useful tool, but it can be dangerous if not used properly."
			)
			(43 ; ???
				(EcoNarrator init: 3 0 0 8 0 5) ; "That's a bit of an overkill, isn't it?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sixPackRing of RInvItem
	(properties
		loop 8
		cel 5
		message 43
		cursorLoop 2
		cursorCel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 90 0 4)
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 91 0 4)
			)
			(17 ; ???
				(EcoNarrator init: 2 0 2 20 0 4) ; "Major ecological sensitivity, man! Adam cuts apart the plastic circles of the six-pack rings and puts them in his garbage bag."
				(SetScore 5 289)
				(Inv highlightedIcon: sharpShell hide:)
				(gEgo put: 34) ; sixPackRing
				(gInventory showSelf: gEgo)
			)
			(37 ; ???
				(EcoNarrator init: 3 0 0 8 0 5) ; "That's a bit of an overkill, isn't it?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance transmitter of RInvItem
	(properties
		loop 2
		cel 2
		message 38
		owner 400
		cursorCel 7
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 5 0 4) ; "Adam's carrying a transmitter from Dad's lab. This transmitter is the kind Dad uses with a buoy and cable to mark underwater hazards for clean-up by a salvage team."
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 6 0 4) ; "Adam tests the radio transmitter. It appears to be working just fine."
			)
			(40 ; ???
				(if (== (steelCable cel:) 12)
					(EcoNarrator init: 3 0 0 10 0 5) ; "Adam attaches the transmitter to the float at the end of the cable."
					(Inv highlightedIcon: steelCable hide:)
					(steelCable cel: 11)
					(SetScore 5 330)
					(gEgo put: 29) ; transmitter
					(Inv showSelf: gEgo)
				else
					(EcoNarrator init: 1 0 0 49 0 3)
				)
			)
			(39 ; ???
				(EcoNarrator init: 1 0 1 16 0 3) ; "Adam fixes the sonar transmitter to the float."
				(Inv highlightedIcon: steelCable hide:)
				(float cel: 10)
				(SetScore 5 330)
				(gEgo put: 29) ; transmitter
				(Inv showSelf: gEgo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll of RInvItem
	(properties
		loop 8
		cel 7
		message 34
		owner 140
		cursorLoop 2
		cursorCel 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(cond
					((or (== gCurRoomNum 345) (gCurRoom script:))
						(EcoNarrator init: 1 0 0 64 0 3) ; "Adam can't look at the scroll right now, he's busy. Try again later."
					)
					((proc804_1 370)
						(if (== gCurRoomNum 540)
							(PalVary pvUNINIT)
						)
						(Inv hide:)
						(gCurRoom setScript: (ScriptID 816 0)) ; scrollScript
					)
					(else
						(EcoNarrator init: 1 0 0 64 0 3) ; "Adam can't look at the scroll right now, he's busy. Try again later."
					)
				)
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 11 0 5) ; "To open the scroll and read it, just click the 'eye' on the scroll."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterBottle of RInvItem
	(properties
		loop 8
		cel 9
		message 23
		owner 620
		cursorCel 6
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 2 0 0 12 0 4) ; "Adam is carrying the gerbil's water bottle. Bet the gerbil doesn't like that!"
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 13 0 4) ; "Slurp, slurp. Adam has the sensation of begin a small, furry creature with webbed toes for a moment... then it passes."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ok of EcoIconItem
	(properties
		view 951
		loop 4
		cel 0
		nsLeft 40
		signal 67
		noun 1
		helpVerb 55
		helpStr 11
	)

	(method (init)
		(self cursor: (ScriptID 0 8) highlightColor: 0 lowlightColor: global216) ; arrowC
		(super init:)
	)
)

(instance invLook of EcoIconItem
	(properties
		view 951
		loop 0
		cel 0
		message 1
		noun 1
		helpVerb 56
		helpStr 12
	)

	(method (init)
		(self cursor: (ScriptID 0 9) highlightColor: 0 lowlightColor: global216) ; eyeC
		(super init:)
	)
)

(instance invHand of EcoIconItem
	(properties
		view 951
		loop 1
		cel 0
		message 4
		noun 1
		helpVerb 57
		helpStr 13
	)

	(method (init)
		(self
			cursor: (ScriptID 0 11) ; handC
			highlightColor: 0
			lowlightColor: global216
		)
		(super init:)
	)
)

(instance invHelp of EcoIconItem
	(properties
		view 951
		loop 3
		cel 0
		message 8
		noun 1
		helpVerb 54
	)

	(method (init)
		(self
			cursor: (ScriptID 0 10) ; helpC
			highlightColor: 0
			lowlightColor: global216
		)
		(super init:)
	)
)

(instance invSelect of EcoIconItem
	(properties
		view 951
		loop 2
		cel 0
		noun 1
		helpVerb 58
		helpStr 14
	)

	(method (init)
		(self cursor: (ScriptID 0 8) highlightColor: 0 lowlightColor: global216) ; arrowC
		(super init:)
	)
)

(instance invWin of InsetWindow
	(properties
		priority -1
		topBordHgt 28
		botBordHgt 5
	)

	(method (open &tmp temp0 temp1 temp2)
		(EcoNarrator inInv: 1)
		(= temp0 0)
		(for
			((= temp1 (gInventory first:)))
			temp1
			((= temp1 (gInventory next: temp1)))
			
			(if (not ((= temp2 (NodeValue temp1)) isKindOf: InvI))
				(+= temp0 (CelWide (temp2 view:) (temp2 loop:) (temp2 cel:)))
			)
		)
		(super open:)
		(invLook nsLeft: (/ (- (- right left) temp0) 2))
	)

	(method (dispose)
		(EcoNarrator inInv: 0)
		(super dispose:)
	)
)

