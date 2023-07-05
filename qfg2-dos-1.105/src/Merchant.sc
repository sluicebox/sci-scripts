;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use Talker)
(use fred)
(use Interface)
(use System)

(local
	[talkStr 300]
	[merchPlaces 66] = [300 '//bouquet,lisha' {Lisha} {lovely flowers} {Gate} 310 '//plant,lasham' {Lasham} {hardy plants} {Fountain} 310 '//basket,reed,saba' {Saba} {sturdy baskets} {Fountain} 310 '//brass,lamp' {Tashtari} {brass and lamps} {Fountain} 310 '//keapon,keapon,(shop<magic)' {Keapon Laffin} {magical items} {Fountain} 315 '//food,sloree,nephew' {Sloree and Scoree} {delicious food} {Fountain} 315 '//pan,clay,toshur' {Toshur} {fine pottery} {Fountain} 315 '//attar,attar,drug,pill,potion,apothecary' {Harik Attar} {potions and pills} {Fountain} 330 '//cloth,clothes,veil,kiram' {Kiram} {sturdy clothing} {Fighters} 330 '//issur,weapon,blade,dagger,shield' {Issur} {weapons} {Fighters} 330 '//leather,leatherwork,waterbag,mirak' {Mirak} {leather goods} {Fighters} 335 '//carpet,tiram' {Tiram} {carpets} {Palace} 335 '//gem,gem,necklace,bracelet,gold,silver,sashanan' {Sashanan} {fine jewelry} {Palace} 0]
)

(class Merchant of PlazaTalker
	(properties
		wares 0
		curWare 0
		cueMethod 0
	)

	(method (init)
		(super init:)
		(Load rsTEXT 11)
		(self ignoreActors: 1)
		((= wares (Collect new:)) add:)
		((gCurRoom merchants:) add: self)
	)

	(method (addWares theArgs &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			([theArgs i] init:)
			(wares add: [theArgs i])
		)
	)

	(method (givePriceList &tmp node [str 100])
		(if (wares isEmpty:)
			(HighPrint 84 0) ; "The merchant's prices are all too high."
		else
			(= talkStr 0)
			(for
				((= node (wares first:)))
				node
				((= node (wares next: node)))
				
				(Format ; "%s"
					(StrEnd @talkStr)
					84
					1
					((NodeValue node) priceStr: @str)
				)
			)
			(Say self @talkStr)
		)
	)

	(method (handleEvent event)
		(cond
			((or (Said 'ask/cost') (Said 'ask//cost'))
				(self givePriceList:)
			)
			((Said 'buy,bargain>')
				(cond
					((not (self egoCloseEnough:))
						(self sayNotCloseEnough:)
					)
					((self dontHave: event))
					((not (self egoCanBuy:))
						(self sayYouAlreadyHave:)
					)
					((Said 'buy')
						(curWare curPrice: (curWare price:))
						(self buy:)
					)
					(else
						(self bargain:)
					)
				)
				(event claimed: 1)
			)
			((Said 'grab')
				(HighPrint 84 2) ; "It is hard to steal when someone is watching you as carefully as the merchant is."
			)
			((Said 'sell')
				(HighPrint 84 3) ; "Merchants only sell; they don't buy things."
			)
			((Said 'tell')
				(Say self 84 4) ; "A most interesting tale."
			)
			((Said 'thank')
				(Say self 84 5) ; "My pleasure it is to serve you, Effendi."
			)
			((Said 'hello,greet')
				(Say self 84 6) ; "Greetings, Hero of Spielburg."
			)
			((self askAboutOthers: event))
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (askAboutOthers event &tmp i)
		(if (or (not (Said 'ask>')) (not (self saidMe: event)))
			(return 0)
		)
		(for ((= i 0)) [merchPlaces i] ((+= i 5))
			(if
				(and
					(!= gCurRoomNum [merchPlaces i])
					(Said [merchPlaces (+ i 1)])
				)
				(Say
					self
					(Format ; "%s sells %s in the Plaza of the %s."
						@talkStr
						84
						7
						[merchPlaces (+ i 2)]
						[merchPlaces (+ i 3)]
						[merchPlaces (+ i 4)]
					)
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (dontHave event)
		(if
			(or
				(and (Said '[/!*]>') (Said '/[/!*]'))
				(and (Said '/[/!*]>') (Said (+ myName 1)))
				(and (Said '[/!*]>') (Said myName))
			)
			(Say self 84 8) ; "Please be more specific, Effendi."
			(event claimed: 1)
			(return 1)
		)
		(if (or (not (= curWare (self has:))) (== curWare -1))
			(if (not curWare)
				(self sayDoesntHave:)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (has &tmp rc node obj)
		(for ((= node (wares first:))) node ((= node (wares next: node)))
			(= obj (NodeValue node))
			(if (= rc (obj saidMe:))
				(if (== rc -1)
					(return -1)
				else
					(return obj)
				)
			)
		)
		(return 0)
	)

	(method (egoCloseEnough)
		(return (< (self distanceTo: gEgo) 50))
	)

	(method (egoCanBuy)
		(return
			(or
				(not (gEgo has: (curWare invItem:)))
				(curWare canBuyMultiple:)
			)
		)
	)

	(method (buy &tmp rc)
		(switch (= rc (CheckFunds (curWare curPrice:)))
			(2
				(self sell:)
			)
			(3
				(self sell:)
			)
			(0
				(self sayNotEnoughMoney:)
			)
			(1
				(self sayMoneyNeedsChanging:)
			)
			(gDebugging
				(Printf 84 9 rc) ; "buy: unexpected CheckFunds result: %d"
			)
		)
	)

	(method (bargain)
		(if (TrySkill 13 (curWare bargainSkill:)) ; communication
			(curWare curPrice: (curWare lowPrice:))
			(= cueMethod 642)
			(self sayBargainSuccess:)
		else
			(curWare curPrice: (curWare highPrice:))
			(= cueMethod 642)
			(self sayBargainFailure:)
		)
	)

	(method (sell)
		(GiveMoney (curWare curPrice:))
		(if (curWare invItem:)
			(gEgo get: (curWare invItem:))
		)
		(= cueMethod 654)
		(self saySoldBegin:)
	)

	(method (sayYouAlreadyHave &tmp [wareName 20] [str 50])
		(HighPrint (Format @str 84 10 (curWare showStr: @wareName))) ; "You already have the %s."
	)

	(method (saySoldBegin)
		(self cue:)
	)

	(method (saySoldEnd &tmp [str 50] [wareName 25])
		(HighPrint (Format @str 84 11 (curWare showStr: @wareName))) ; "You pay for the %s and put it away."
	)

	(method (sayDoesntHave)
		(Say self 84 12) ; "I have none of those today, Effendi."
	)

	(method (sayNotEnoughMoney)
		(HighPrint 84 13) ; "You find you do not have enough money to buy it."
	)

	(method (sayMoneyNeedsChanging)
		(Say self 84 14) ; "Alas, you will need to visit the Money Changer before you can buy something here."
	)

	(method (sayNotCloseEnough)
		(Say self 84 15) ; "Please approach me if you wish to purchase my wares, Effendi."
	)

	(method (sayBargainSuccess))

	(method (sayBargainFailure))

	(method (cue &tmp theMethod)
		(cond
			((or (self script:) (== state -1) (> tCount 0))
				(super cue:)
			)
			(cueMethod
				(= theMethod cueMethod)
				(= cueMethod 0)
				(self theMethod:)
			)
			(gDebugging
				(Printf 84 16 name) ; "%s: unknown cue"
			)
		)
	)

	(method (dispose)
		(wares release: dispose:)
		(super dispose:)
	)
)

(class Ware
	(properties
		invItem 0
		noun 0
		price 0
		lowPrice 0
		highPrice 0
		bargainSkill 40
		canBuyMultiple 1
		curPrice 0
	)

	(method (init)
		(if (not highPrice)
			(= highPrice price)
		)
	)

	(method (saidMe)
		(return (or (Said noun) (Said (+ noun 1))))
	)

	(method (priceStr dest &tmp [str 50])
		(Format dest 84 17 (self showStr: @str) (self price:)) ; "The price of the %s is %d centimes."
	)

	(method (showStr dest &tmp [str 50])
		(if invItem
			(StrToLower @str 11 (* invItem 2))
			(Format dest @str {})
		else
			(StrCpy dest name)
		)
		(return dest)
	)
)

