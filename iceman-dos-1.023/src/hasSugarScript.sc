;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 363)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use Sight)
(use System)

(public
	hasSugarScript 0
	hasFlourScript 1
	hasCoffeeScript 2
)

(synonyms
	(canister jar can)
)

(procedure (localproc_0)
	(Print 363 0) ; "You already did that."
)

(instance hasSugarScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'open/canister,lid,top,sugar')
					(Said 'detach/lid,top[/canister]')
				)
				(if (not (& (tunisia sugarStat:) $0001))
					(Print 363 1) ; "You open the large canister containing sugar."
					(tunisia sugarStat: (| (tunisia sugarStat:) $0001))
				else
					(localproc_0)
				)
			)
			((or (Said 'replace/lid,top') (Said 'close/canister,lid,top,sugar'))
				(if (& (tunisia sugarStat:) $0001)
					(Print 363 2) ; "Ok."
					(tunisia sugarStat: (& (tunisia sugarStat:) $fffe))
				else
					(localproc_0)
				)
			)
			((Said 'look<in/canister,sugar')
				(cond
					((not (& (tunisia sugarStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(Print 363 4) ; "You see the inside of the canister."
					)
					((& (tunisia sugarStat:) $0008)
						(Print 363 5) ; "You see the gun in the canister."
					)
					((& (tunisia sugarStat:) $0004)
						(Print 363 6) ; "You see foam rubber at the bottom."
					)
					((& (tunisia sugarStat:) $0002)
						(Print 363 7) ; "The canister seems to have a false bottom."
					)
					(else
						(Print 363 8) ; "You see sugar."
					)
				)
			)
			((Said 'examine/canister,sugar,(canister<sugar,big)')
				(cond
					((not (& (tunisia sugarStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(Print 363 9) ; "It's empty."
					)
					((& (tunisia sugarStat:) $0008)
						(Print 363 10) ; "You find the gun, which you already knew about."
					)
					((& (tunisia sugarStat:) $0004)
						(Print 363 11) ; "You find foam rubber, which you already knew about."
					)
					((& (tunisia sugarStat:) $0002)
						(Print 363 12) ; "You find a false bottom, which you already knew about."
					)
					(else
						(Print 363 13) ; "Making a mess, you search through the sugar, and..."
						(Print 363 7) ; "The canister seems to have a false bottom."
					)
				)
			)
			(
				(Said
					'empty,shit,pour[<out]/sugar,canister,(canister<sugar,big),content'
				)
				(cond
					((not (& (tunisia sugarStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((not (& (tunisia sugarStat:) $0002))
						(Print 363 14) ; "You pour out the sugar and see that the canister seems to have a false bottom."
						(tunisia sugarStat: (| (tunisia sugarStat:) $0002))
					)
					(else
						(localproc_0)
					)
				)
			)
			((Said 'open,detach/bottom[<false]')
				(cond
					((not (& (tunisia sugarStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((not (& (tunisia sugarStat:) $0002))
						(Print 363 15) ; "Empty the canister first."
					)
					((not (& (tunisia sugarStat:) $0004))
						(Print 363 16) ; "You remove the false bottom to reveal foam rubber underneath."
						(tunisia sugarStat: (| (tunisia sugarStat:) $0004))
					)
					(else
						(localproc_0)
					)
				)
			)
			((Said 'detach,get,(look<below)/foam,rubber[<foam]')
				(cond
					((not (& (tunisia sugarStat:) $0001))
						(Print 363 17) ; "Open the can first."
					)
					((not (& (tunisia sugarStat:) $0002))
						(Print 363 18) ; "Empty the can first."
					)
					((not (& (tunisia sugarStat:) $0004))
						(Print 363 19) ; "You'll have to remove the false bottom."
					)
					((not (& (tunisia sugarStat:) $0008))
						(Print 363 20) ; "You remove the foam rubber and BINGO!"
						(Print 363 21) ; "Concealed at the bottom of the canister between two pieces of foam rubber is the weapon."
						(tunisia sugarStat: (| (tunisia sugarStat:) $0008))
					)
					(else
						(localproc_0)
					)
				)
			)
			((Said 'get/gun')
				(cond
					((not (& (tunisia sugarStat:) $0008))
						(proc0_40) ; "You don't see that."
					)
					((not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(Print 363 22) ; "Carefully you remove the weapon."
						(gEgo get: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(gGame changeScore: 6)
					)
					(else
						(proc0_35) ; "You already took that."
					)
				)
			)
			((Said 'replace/(bottom[<false]),foam,(rubber[<foam])')
				(proc0_39) ; "You don't need to do that."
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (CantBeSeen client gEgo 180)
			(client cue:)
		)
	)
)

(instance hasFlourScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'open/canister,lid,top,flour') (Said 'detach/lid,top'))
				(if (not (& (tunisia flourStat:) $0001))
					(Print 363 23) ; "You open the medium-sized canister containing flour."
					(tunisia flourStat: (| (tunisia flourStat:) $0001))
				else
					(localproc_0)
				)
			)
			((or (Said 'replace/lid,top') (Said 'close/canister,lid,top,flour'))
				(if (& (tunisia flourStat:) $0001)
					(Print 363 2) ; "Ok."
					(tunisia flourStat: (& (tunisia flourStat:) $fffe))
				else
					(localproc_0)
				)
			)
			((Said 'look<in/canister,flour')
				(cond
					((not (& (tunisia flourStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((not (& (tunisia flourStat:) $0002))
						(Print 363 24) ; "You see flour."
					)
					(else
						(Print 363 4) ; "You see the inside of the canister."
					)
				)
			)
			((Said 'examine/canister,flour')
				(cond
					((not (& (tunisia flourStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((& (tunisia flourStat:) $0002)
						(Print 363 25) ; "You find nothing in the empty canister."
					)
					(else
						(Print 363 26) ; "Making a mess, you search through the flour, but find nothing."
					)
				)
			)
			(
				(Said
					'empty,shit,pour[<out]/flour,canister,(canister<flour),(canister<medium),content'
				)
				(cond
					((not (& (tunisia flourStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((not (& (tunisia flourStat:) $0002))
						(Print 363 27) ; "You empty the flour canister but find nothing."
						(tunisia flourStat: (| (tunisia flourStat:) $0002))
					)
					(else
						(localproc_0)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (CantBeSeen client gEgo 180)
			(client cue:)
		)
	)
)

(instance hasCoffeeScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'open/canister,lid,top,coffee') (Said 'detach/lid,top'))
				(if (not (& (tunisia coffeeStat:) $0001))
					(Print 363 28) ; "You open the small canister containing coffee."
					(tunisia coffeeStat: (| (tunisia coffeeStat:) $0001))
				else
					(localproc_0)
				)
			)
			(
				(or
					(Said 'replace/lid,top')
					(Said 'close/canister,lid,top,coffee')
				)
				(if (& (tunisia coffeeStat:) $0001)
					(Print 363 2) ; "Ok."
					(tunisia coffeeStat: (& (tunisia coffeeStat:) $fffe))
				else
					(localproc_0)
				)
			)
			((Said 'look<in/canister,coffee')
				(cond
					((not (& (tunisia coffeeStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((not (& (tunisia coffeeStat:) $0002))
						(Print 363 29) ; "You see coffee."
					)
					(else
						(Print 363 4) ; "You see the inside of the canister."
					)
				)
			)
			((Said 'examine/canister,coffee')
				(cond
					((not (& (tunisia coffeeStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((& (tunisia coffeeStat:) $0002)
						(Print 363 25) ; "You find nothing in the empty canister."
					)
					(else
						(Print 363 30) ; "Making a mess, you search through the coffee, but find nothing."
					)
				)
			)
			(
				(Said
					'empty,shit,pour[<out]/coffee,canister,(canister<coffee),(canister<little),content'
				)
				(cond
					((not (& (tunisia coffeeStat:) $0001))
						(Print 363 3) ; "Open the canister first."
					)
					((not (& (tunisia coffeeStat:) $0002))
						(Print 363 31) ; "You pour out the coffee and the only thing you see is a big pile of coffee!"
						(tunisia coffeeStat: (| (tunisia coffeeStat:) $0002))
					)
					(else
						(localproc_0)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (CantBeSeen client gEgo 180)
			(client cue:)
		)
	)
)

