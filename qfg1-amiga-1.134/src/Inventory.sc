;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use System)

(public
	SaidInv 0
	WtCarried 1
	SaidSpell 2
)

(local
	[local0 41] = ['/silver,alm,alm' '/gold' '/food,ration' '/mandrake' '/key' '/blade' '/dagger' '/leather,armor' '/shield' '/note,message,note,scroll' '/apple,apple' '/carrot,produce' '/gem[<magic,glowing]' '/vase' '/candelabra' '/box<music' '/candlestick' '/pearl,necklace,string' '/ring[<healer,gold]' '/seed' '/boulder' '/flower' '/lockpick[<hasp]' '/kit[<thief,implement]' '/certificate[<thief]' '/bottle[<empty,!*]' '/fur[<green]' '/dust<faerie,magic' '/water,(bottle<water)' '/mushroom[<magic]' '/claw[<cheetaur]' '/beard[<troll]' '/chainmail,chain,chainmail' '/healing,(potion<healing)' '/potion<mana,magic,power' '/potion<vigor,stamina' '/potion<hero,heroism' '/potion<disenchant,disenchant' '/grease,(potion,grease<ghost,ghoul)' '/mirror[<magic,hand]' '/acorn[<dryad,magic]']
	[local41 10] = ['/open,(spell<open)' '/detect,(spell,magic<detect),(spell<magic<detect)' '/trigger,(spell<trigger)' '/dazzle,(spell<dazzle)' '/zap,(spell<zap)' '/calm,(spell<calm)' '/flame,fire,dart,fireball,(spell<flame,fire,dart,fireball)' '/fetch,(spell<fetch)' '/slow,(spell<slow)' '/reversal,reflection,mirror,(spell<reversal,reflection,mirror)']
)

(procedure (SaidInv event &tmp index obj)
	(for ((= index 0)) (< index 41) ((++ index))
		(if (Said [local0 index])
			(return (+ index 1))
		)
	)
	(event claimed: 1)
	(return 0)
)

(procedure (WtCarried &tmp tot index)
	(= index 1)
	(= tot 0)
	(while (<= index 41)
		(+= tot (* [gInvNum index] [gInvWeight index]))
		(++ index)
	)
	(= tot (/ (+ tot 59) 60))
)

(procedure (SaidSpell event &tmp index obj)
	(for ((= index 0)) (< index 8) ((++ index))
		(if (Said [local41 index])
			(return (+ 17 index))
		)
	)
	(event claimed: 1)
	(return 0)
)

(class Inventory of Obj
	(properties)

	(method (init)
		(return 1)
	)
)

