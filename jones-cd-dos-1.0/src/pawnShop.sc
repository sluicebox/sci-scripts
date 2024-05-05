;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use WButton)
(use n109)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use DCIcon)
(use Motion)
(use User)
(use System)

(public
	pawnShop 0
)

(local
	local0
	local1
	local2
	local3
	[local4 300]
	[local304 60]
	[local364 60]
	local424
	local425 = 5
	local426
	local427
	local428
	local429 = -1
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 ((ScriptID 1 2) size:)) ((++ temp0)) ; players
		(for
			((= temp1 0))
			(< temp1 ((((ScriptID 1 2) at: temp0) durables:) size:)) ; players
			((++ temp1))
			
			(if
				(&
					(((((ScriptID 1 2) at: temp0) durables:) at: temp1) ; players
						attributes:
					)
					$0020
				)
				(return 1)
			)
		)
	)
	(return 0)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 ((global302 durables:) size:)) ((++ temp0))
		(if (& (((global302 durables:) at: temp0) attributes:) $0018)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_2 &tmp [temp0 31] temp31 temp32)
	(= temp32 (global302 durables:))
	(= local3 0)
	(for ((= temp31 0)) (< temp31 300) ((++ temp31))
		(= [local4 temp31] 0)
	)
	(Format @local4 212 0)
	(if (temp32 size:)
		(for ((= temp31 0)) (< temp31 (temp32 size:)) ((++ temp31))
			(if
				(or
					(and
						(not (& ((temp32 at: temp31) attributes:) $0038))
						(((global302 durables:) at: temp31) quantity:)
					)
					(> (((global302 durables:) at: temp31) quantity:) 1)
				)
				(Format ; "%-18s"
					(StrEnd @local4)
					212
					1
					700
					((temp32 at: temp31) indexNum:)
				)
				(++ local3)
			)
		)
	)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(for
		((= temp0 (= temp1 0)))
		(< temp0 ((global302 durables:) size:))
		((++ temp0))
		
		(if
			(or
				(not (& (((global302 durables:) at: temp0) attributes:) $0038))
				(> (((global302 durables:) at: temp0) quantity:) 1)
			)
			(if
				(==
					(pawnSelector indexOf: (pawnSelector cursor:))
					(- temp0 temp1)
				)
				(if (& (((global302 durables:) at: temp0) attributes:) $0038)
					(return -1)
				else
					(return ((global302 durables:) at: temp0))
				)
			)
		else
			(++ temp1)
		)
	)
	(return 0)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2)
	(for ((= temp1 (= temp0 0))) (< temp1 ((ScriptID 1 2) size:)) ((++ temp1)) ; players
		(if ((((ScriptID 1 2) at: temp1) durables:) size:) ; players
			(for
				((= temp2 0))
				(< temp2 ((((ScriptID 1 2) at: temp1) durables:) size:)) ; players
				((++ temp2))
				
				(if
					(&
						(((((ScriptID 1 2) at: temp1) durables:) at: temp2) ; players
							attributes:
						)
						$0038
					)
					(++ temp0)
				)
			)
		)
	)
	(return temp0)
)

(procedure (localproc_5)
	(pawnShop add: pawnButton redeemButton buyButton)
	(pawnButton init: setSize: draw:)
	(redeemButton init: setSize: draw:)
	(buyButton init: setSize: draw:)
	(proc0_9 pawnShop (pawnShop keyMouseList:) pawnButton)
	(KeyMouse setList: (pawnShop keyMouseList:))
)

(procedure (localproc_6)
	(pawnButton erase:)
	(redeemButton erase:)
	(buyButton erase:)
	((pawnShop keyMouseList:) release:)
	(pawnShop delete: pawnButton redeemButton buyButton)
)

(procedure (localproc_7)
	(pawnShop add: pawnMessage pawn pawnSelector donePawning)
	(localproc_2)
	(pawnSelector font: gSmallFont text: @local4 setSize: moveTo: 71 40)
	(pawnMessage init: setSize: draw:)
	(pawnSelector init: setSize: draw: 1)
	(pawn init: setSize: draw:)
	(donePawning init: setSize: draw:)
	(proc0_9 pawnShop (pawnShop keyMouseList:) pawn)
	(KeyMouse setList: (pawnShop keyMouseList:))
)

(procedure (localproc_8)
	(pawnMessage erase:)
	(pawn erase:)
	(pawnSelector select: 0 erase:)
	(donePawning erase:)
	((pawnShop keyMouseList:) release:)
	(pawnShop delete: pawnMessage pawn pawnSelector donePawning)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(pawnShop add: redeemMessage)
	(= temp2 (pawnShop indexOf: exitButton))
	(pawnShop addAfter: (pawnShop at: (- temp2 1)) doneRedeeming)
	(redeemMessage init: setSize: draw:)
	(doneRedeeming init: setSize: draw:)
	(= temp5 0)
	(for
		((= temp0 (= temp3 0)))
		(< temp0 ((global302 durables:) size:))
		((++ temp0))
		
		(if (& (((global302 durables:) at: temp0) attributes:) $0018)
			(Format ; "%s"
				@[local364 (* temp3 10)]
				212
				2
				700
				(((global302 durables:) at: temp0) indexNum:)
			)
			(pawnShop
				add:
					(= temp4
						((aRedeemableItem new:)
							price:
								(((global302 durables:) at: temp0)
									redemptionPrice:
								)
							text: @[local364 (* temp3 10)]
							nsLeft: 78
							nsTop: (+ 40 (* 10 temp3))
							indexNum:
								(((global302 durables:) at: temp0) indexNum:)
							fixedPrice: 1
							theDurable: ((global302 durables:) at: temp0)
							key: 199
							celNum:
								(-
									(((global302 durables:) at: temp0)
										indexNum:
									)
									21
								)
							yourself:
						)
					)
			)
			(if (not temp5)
				(= temp5 temp4)
			)
			(temp4 init: setSize: draw:)
			(++ temp3)
		)
	)
	(proc0_9 pawnShop (pawnShop keyMouseList:) temp5)
	(KeyMouse setList: (pawnShop keyMouseList:))
	(= local424 0)
)

(procedure (localproc_10 &tmp temp0 temp1)
	(redeemMessage erase:)
	(doneRedeeming erase:)
	((pawnShop keyMouseList:) release:)
	(pawnShop delete: redeemMessage doneRedeeming)
	(for ((= temp0 (- (pawnShop size:) 1))) (>= temp0 0) ((-- temp0))
		(= temp1 (pawnShop at: temp0))
		(if (temp1 isMemberOf: CostDItem)
			(temp1 erase:)
			(pawnShop delete: temp1)
			(temp1 dispose:)
		)
	)
)

(procedure (localproc_11 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(pawnShop add: buyMessage)
	(= temp2 (pawnShop indexOf: exitButton))
	(pawnShop addAfter: (pawnShop at: (- temp2 1)) doneBuying)
	(buyMessage init: setSize: draw:)
	(doneBuying init: setSize: draw:)
	(= temp6 0)
	(for ((= temp3 (= temp4 0))) (< temp3 ((ScriptID 1 2) size:)) ((++ temp3)) ; players
		(for
			((= temp0 0))
			(< temp0 ((((ScriptID 1 2) at: temp3) durables:) size:)) ; players
			((++ temp0))
			
			(if
				(&
					(((((ScriptID 1 2) at: temp3) durables:) at: temp0) ; players
						attributes:
					)
					$0020
				)
				(Format ; "%s"
					@[local304 (* temp4 10)]
					212
					2
					700
					(((((ScriptID 1 2) at: temp3) durables:) at: temp0) ; players
						indexNum:
					)
				)
				(pawnShop
					add:
						(= temp5
							((aRedeemableItem new:)
								name: {redeemable}
								price:
									(((((ScriptID 1 2) at: temp3) durables:) ; players
											at: temp0
										)
										redemptionPrice:
									)
								text: @[local304 (* temp4 10)]
								nsLeft: 78
								nsTop: (+ 40 (* 10 temp4))
								indexNum:
									(((((ScriptID 1 2) at: temp3) durables:) ; players
											at: temp0
										)
										indexNum:
									)
								fixedPrice: 1
								theDurable:
									((((ScriptID 1 2) at: temp3) durables:) ; players
										at: temp0
									)
								celNum:
									(-
										(((((ScriptID 1 2) at: temp3) durables:) ; players
												at: temp0
											)
											indexNum:
										)
										21
									)
								yourself:
							)
						)
				)
				(if (not temp6)
					(= temp6 temp5)
				)
				(temp5 init: setSize: draw:)
				((temp5 theDurable:)
					attributes: (| ((temp5 theDurable:) attributes:) $0100)
				)
				(++ temp4)
			)
		)
	)
	(proc0_9 pawnShop (pawnShop keyMouseList:) temp6)
	(KeyMouse setList: (pawnShop keyMouseList:))
)

(procedure (localproc_12 &tmp temp0 temp1)
	(buyMessage erase:)
	(doneBuying erase:)
	((pawnShop keyMouseList:) release:)
	(pawnShop delete: buyMessage doneBuying)
	(for ((= temp0 (- (pawnShop size:) 1))) (>= temp0 0) ((-- temp0))
		(= temp1 (pawnShop at: temp0))
		(if (temp1 isMemberOf: CostDItem)
			(temp1 erase:)
			(pawnShop delete: temp1)
			(temp1 dispose:)
		)
	)
)

(procedure (localproc_13 &tmp temp0)) ; UNUSED

(instance boughtItem of Obj
	(properties)

	(method (doit &tmp temp0)
		(while (== local429 (= temp0 (Random 8 15)))
			1
		)
		(= local429 temp0)
		(proc0_18 (+ temp0 70) global413 computerScript)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 86 global413 computerScript)
	)
)

(class FCue of Cycle
	(properties
		cycleSpeed 0
	)

	(method (init param1 param2)
		(super init: param1)
		(= caller param2)
	)

	(method (doit)
		(if (!= (client cel:) (self nextCel:))
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(self motionCue:)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance pawnShop of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp [temp0 2] temp2 temp3)
		(if (not global518)
			(DoAudio audRATE 11025)
			(proc0_17 2)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(global38 color: 0 back: (if global535 82 else 3))
			(= global502 self)
			(= global440 7)
			(= global441 110)
			(= global442 78)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(if (< global534 2)
				(Load rsVIEW (items view:))
			)
			(= global424 notEnoughCash)
			(= gBoughtItem boughtItem)
			(= gItems items)
			(= local0 0)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 12)
			(= global413 theTalker)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
			)
			(self add: background theTalker exitButton)
			(self
				window: global38
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(self add: items)
			(localproc_5)
			(gASong playBed: 50)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= temp3 (Random 0 7))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ temp3 70) global413 computerScript)
			else
				(computerScript cue:)
			)
		else
			(KeyMouse setCursor: theItem)
		)
		(= global518 0)
		(= temp2 (self doit: 0 0))
		(if (IsObject temp2)
			(if (self contains: temp2)
				(= temp2 0)
			)
		else
			(= temp2 1)
		)
		(= global502 prevDialog)
		(proc0_15 self 294)
		(DoAudio audSTOP)
		(gASong fade:)
		(KeyMouse
			setList:
				(if prevDialog
					(prevDialog keyMouseList:)
				else
					gMainKeyMouseList
				)
		)
		(keyMouseList release: dispose:)
		(self dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp2
		(DisposeScript 212)
	)

	(method (draw)
		(super draw:)
		(if global518
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
		)
	)
)

(instance background of DIcon
	(properties
		view 712
	)
)

(instance pawnButton of DIcon
	(properties
		state 289
		nsTop 40
		nsLeft 76
		key 1
		view 712
		loop 1
		priority 14
	)

	(method (doit &tmp temp0 temp1 temp2)
		(gASoundEffect play: 23)
		(DoAudio audSTOP)
		(= temp1 0)
		(if ((global302 durables:) size:)
			(for
				((= temp2 0))
				(< temp2 ((global302 durables:) size:))
				((++ temp2))
				
				(if
					(or
						(not
							(&
								(((global302 durables:) at: temp2) attributes:)
								$0038
							)
						)
						(> (((global302 durables:) at: temp2) quantity:) 1)
					)
					(= temp1 1)
					(break)
				)
			)
		)
		(if temp1
			(self select: 0)
			(exitButton select: 1)
			(pawnShop theItem: exitButton)
			(localproc_6)
			(localproc_7)
			(= local0 1)
		else
			(proc0_18 87 global413 computerScript)
		)
		(super doit:)
	)
)

(instance redeemButton of DIcon
	(properties
		state 289
		nsTop 60
		nsLeft 76
		key 2
		view 712
		loop 1
		cel 1
		priority 14
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(if (localproc_1)
			(self select: 0)
			(exitButton select: 1)
			(pawnShop theItem: exitButton)
			(localproc_6)
			(localproc_9)
			(= local0 2)
		else
			(proc0_18 (if global602 global602 else 88) global413 computerScript)
		)
		(super doit:)
	)
)

(instance buyButton of DIcon
	(properties
		state 289
		nsTop 80
		nsLeft 76
		key 3
		view 712
		loop 1
		cel 2
		priority 14
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(if (localproc_0)
			(self select: 0)
			(exitButton select: 1)
			(pawnShop theItem: exitButton)
			(localproc_6)
			(localproc_11)
			(= local0 3)
		else
			(proc0_18 89 global413 computerScript)
		)
		(super doit:)
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 143
		key 120
		view 250
		loop 13
		priority 15
	)
)

(instance theTalker of Talker
	(properties
		nsLeft 0
		view 362
	)
)

(instance pawnMessage of WButton
	(properties
		state 288
		nsTop 27
		nsLeft 95
		text {Pawnable Items}
		textColor 26
		shadowColor 65
	)
)

(instance pawn of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 77
		key 5
		view 250
		loop 6
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (super doit:))
		(if (>= (localproc_4) 6)
			(proc0_18 90 global413 computerScript)
			(return temp0)
		)
		(if (= local2 (localproc_3))
			(if (== local2 -1)
				(proc0_18 91 global413 computerScript)
				(return temp0)
			)
			(= local1 (/ (* (proc109_0 global309 (local2 pricePaid:)) 4) 10))
			(if (!= (global302 playing:) 29)
				(proc0_18 92 global413 computerScript)
			)
			(if
				(or
					(== (global302 playing:) 29)
					(Print
						(Format @global100 212 3 local1 700 (local2 indexNum:)) ; "Do you accept $%d for your %s?"
						81
						{Take It}
						1
						81
						{Leave It}
						0
						70
						107
						319
					)
				)
				(gASoundEffect play: 23)
				(proc0_13 -1)
				(local2
					attributes: (| (local2 attributes:) $0018)
					redemptionPrice: (/ (local2 pricePaid:) 2)
					quantity: (- (local2 quantity:) 1)
				)
				(if
					(and
						(== (local2 indexNum:) 21)
						(= temp1 ((global302 consumables:) objectAtIndex: 1))
					)
					(proc0_13 -1)
					(temp1 quantity: 0)
				)
				(localproc_2)
				(pawnSelector draw:)
				(proc0_10 local1)
				(gCalc doit:)
			else
				(gASoundEffect play: 23)
			)
			(if (!= (global302 playing:) 29)
				(DoAudio audSTOP)
			)
		)
		(return temp0)
	)
)

(instance pawnSelector of DSelector
	(properties
		state 288
		font 4
		x 18
		y 4
	)
)

(instance donePawning of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 110
		view 250
		loop 2
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(self select: 0)
		(exitButton select: 1)
		(pawnShop theItem: exitButton)
		(localproc_8)
		(localproc_5)
		(= local0 0)
		(return temp0)
	)
)

(instance doneRedeeming of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 110
		view 250
		loop 2
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(self select: 0)
		(exitButton select: 1)
		(pawnShop theItem: exitButton)
		(localproc_10)
		(localproc_5)
		(= local0 0)
		(return temp0)
	)
)

(instance doneBuying of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 110
		view 250
		loop 2
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(self select: 0)
		(exitButton select: 1)
		(pawnShop theItem: exitButton)
		(localproc_12)
		(localproc_5)
		(= local0 0)
		(return temp0)
	)
)

(instance buyMessage of WButton
	(properties
		state 288
		nsTop 25
		nsLeft 93
		text {Buyable Items}
		textColor 26
		shadowColor 65
	)
)

(instance redeemMessage of WButton
	(properties
		state 288
		nsTop 25
		nsLeft 91
		text {Redeemable Items}
		textColor 26
		shadowColor 65
	)
)

(instance aRedeemableItem of CostDItem
	(properties
		state 289
		text {_____________________________}
		textColor 26
		shadowColor 65
	)

	(method (doit &tmp temp0)
		(= celNum (- (theDurable indexNum:) 21))
		(if (= global416 (>= (proc0_11) price))
			(proc0_10 (* theSign price))
			(gCalc doit:)
			(if (and gItems (IsObject gItems) (< global534 2))
				(gItems doit: celNum)
			)
			(if (and gBoughtItem global427)
				(gBoughtItem doit: self)
			)
		else
			(if global413
				(global413 cel: 6)
			)
			(if global424
				(global424 doit:)
			)
		)
		(if global416
			(self erase:)
			(theDurable attributes: (& (theDurable attributes:) $ffc7))
			(if global447
				(self select: 0)
				(exitButton select: 1)
				(pawnShop theItem: exitButton)
				(KeyMouse setCursor: exitButton)
			else
				(pawnShop advance:)
			)
			((KeyMouse listOfCoords:) delete: self)
			(KeyMouse curItem: (pawnShop theItem:))
			(if (== local0 2)
				(pawnShop delete: self)
				(theDurable quantity: (+ (theDurable quantity:) 1))
			else
				(pawnShop delete: self)
				(for ((= temp0 0)) (< temp0 ((ScriptID 1 2) size:)) ((++ temp0)) ; players
					(if
						((((ScriptID 1 2) at: temp0) durables:) ; players
							contains: theDurable
						)
						(if (not (theDurable quantity:))
							((((ScriptID 1 2) at: temp0) durables:) ; players
								delete: theDurable
							)
						)
						(if
							(not
								((global302 durables:)
									hasType: (theDurable indexNum:) 1
								)
							)
							(if (== (theDurable quantity:) 0)
								(theDurable quantity: 1)
								((global302 durables:) add: theDurable)
								(break)
							)
							((global302 durables:)
								add: ((Clone theDurable) quantity: 1 yourself:)
							)
						)
						(break)
					)
				)
			)
			(self dispose:)
		)
		(return 0)
	)

	(method (doFormat param1)
		(if price
			(Format param1 212 4 text price) ; "%s $%d"
		else
			(super doFormat: param1)
		)
	)
)

(instance items of DCIcon
	(properties
		state 288
		nsTop 56
		view 708
		loop 1
		cel 13
		priority 14
		cycleSpeed 300
	)

	(method (cycle &tmp [temp0 2])
		(if (== (DoAudio audPOSITION) -1)
			(super cycle:)
		)
	)

	(method (doit param1)
		(if (and (< global534 2) global416)
			(self cel: param1 init: setSize: draw: setCycle: FCue self)
			(cycler cycleCnt: -100)
		)
	)

	(method (cue)
		(if (< global534 2)
			(self cel: 13 draw:)
		)
	)

	(method (setCycle)
		(if (< global534 2)
			(super setCycle: &rest)
		)
	)

	(method (draw)
		(if (< global534 2)
			(super draw: &rest)
		)
	)

	(method (setSize)
		(if (< global534 2)
			(super setSize: &rest)
		)
	)
)

(instance computerScript of DialogScript
	(properties)

	(method (handleEvent event &tmp temp0)
		(if register
			(= register 0)
			(event type: evKEYBOARD x: 160 y: 100)
			(= cycles 1)
			(switch local0
				(0
					(switch local426
						(2
							(if (proc0_6 9)
								(= cycles 60)
								(event message: (pawnButton key:))
							)
						)
						(3
							(if (proc0_6 10)
								(= cycles 60)
								(event message: (redeemButton key:))
							)
						)
						(else
							(= state local426)
							(super handleEvent: event 0)
						)
					)
				)
				(1
					(switch local427
						(2
							(= cycles 60)
						)
						(3
							(pawnSelector advance: local3)
							(= cycles 60)
						)
						(4
							(if (< (localproc_4) 6)
								(event message: (pawn key:))
								(= cycles 60)
								(if (> (-= global408 local1) 0)
									(-- state)
								)
							)
						)
						(else
							(= state local427)
							(super handleEvent: event 0)
						)
					)
				)
				(2
					(switch local428
						(2
							(= temp0
								(pawnShop
									at: (- (pawnShop size:) (+ 1 local424))
								)
							)
							(if (== (temp0 key:) 199)
								(-- state)
								(if (>= (proc0_11) (temp0 price:))
									(temp0 key: 12)
									(event message: KEY_CLEAR)
									(= cycles 60)
								)
							)
							(++ local424)
						)
						(else
							(= state local428)
							(super handleEvent: event 0)
						)
					)
				)
			)
		)
	)

	(method (cue)
		(switch local0
			(0
				(++ local426)
			)
			(1
				(++ local427)
			)
			(2
				(++ local428)
			)
		)
		(= register 1)
	)
)

