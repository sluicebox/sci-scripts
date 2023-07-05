;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Print)
(use Inventory)
(use System)

(public
	doCode 0
	useCode 1
)

(procedure (localproc_0 param1)
	(return
		(switch param1
			(56 37)
			(34 17)
			(13 51)
			(48 30)
			(53 34)
			(69 53)
			(27 12)
			(67 52)
			(47 29)
			(14 48)
			(70 54)
			(58 39)
			(22 7)
			(23 8)
			(55 36)
			(54 35)
			(45 27)
			(31 14)
			(17 2)
			(37 5)
			(43 25)
			(52 33)
			(24 9)
			(39 21)
			(59 40)
			(40 22)
			(33 16)
			(26 11)
			(41 23)
			(57 38)
			(171 49)
			(44 26)
			(18 3)
			(74 56)
			(49 31)
			(77 45)
			(29 14)
			(78 46)
			(63 42)
			(28 13)
			(16 1)
			(32 15)
			(30 14)
			(46 28)
			(15 0)
			(19 4)
			(51 32)
			(21 6)
			(72 55)
			(35 18)
			(157 47)
			(170 50)
			(66 43)
			(36 19)
			(42 24)
			(76 44)
			(25 10)
			(60 41)
			(else
				(Printf {FROM Verb2Enum: %d NOT FOUND} param1)
				(SetDebug)
			)
		)
	)
)

(instance doCode of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 57) ((++ temp0))
			(if ((gInventory at: temp0) chestAmout:)
				(= temp1 1)
				(= temp0 57)
			)
		)
		(if temp1
			(gInventory showSelf: gCurRoom)
			(if (and (= temp2 (gInventory curIcon:)) (temp2 isKindOf: InvI))
				(temp2 chestAmout: (- (temp2 chestAmout:) 1))
				(temp2 amount: (+ (temp2 amount:) 1))
				(= temp3 (temp2 view:))
				(= temp4 (temp2 loop:))
				(= temp5 (temp2 cel:))
				(= temp6 (ScriptID 36 2)) ; iconUseIt
				(temp6 cursorView: temp3)
				(temp6 cursorLoop: temp4)
				(temp6 cursorCel: temp5)
				(= temp2 (ScriptID 36 1)) ; invItem
				(temp2 view: temp3 loop: temp4 cel: temp5 show:)
				(UpdateScreenItem temp2)
			)
		else
			(gMessager say: 1 6 1 1 0 29) ; "The chest is empty."
		)
	)
)

(instance useCode of Code
	(properties)

	(method (init param1 &tmp temp0)
		(= param1 (localproc_0 param1))
		(= temp0 (gInventory at: param1))
		(cond
			((== param1 0)
				(gMessager say: 1 6 2 1 0 29) ; "Don't tempt the maid service!"
			)
			((== param1 14)
				(gMessager say: 1 6 6 1 0 29) ; "One of those keys unlocks this chest, and you always have trouble remembering which. You'd better hold on to the keyring."
			)
			((== param1 25)
				(gMessager say: 1 6 7 1 0 29) ; "You realize with horror that you are totally unable to put down the Dark One Sign here. It seems to have a will of its own."
			)
			((== param1 16)
				(gMessager say: 1 6 9 1 0 29) ; "You might need that rope and grapnel at any time. Do yourself a favor, and hang on to them."
			)
			((OneOf param1 53 56 52 55 54)
				(gMessager say: 1 6 10 1 0 29) ; "It would be disastrous if one of the Rituals fell into the wrong hands. You'd better hold on to it for safekeeping."
			)
			((and (== param1 5) (== ((gInventory at: 5) amount:) 1)) ; theThrowdagger
				(gMessager say: 1 6 12 1 0 29) ; "That would be unwise; you never know when you may need a dagger around here."
			)
			((== param1 19)
				(gMessager say: 1 6 11 1 0 29) ; "You'll quickly wind up dead if you meet a monster without a weapon in your hand. You'd better hold on to this one!"
			)
			((== param1 18)
				(gMessager say: 1 6 13 1 0 29) ; "That would be unwise; you never know when you may need your shield around here."
			)
			((== param1 44)
				(gMessager say: 1 6 14 1 0 29) ; "Your magical torch might set the room on fire. It's really only safe when you're carrying it."
			)
			((== param1 45)
				(gMessager say: 1 6 15 1 0 29) ; "This chest is theoretically secure, but storing jewelry in it might prove too much temptation for someone."
			)
			((== param1 17)
				(gMessager say: 1 6 16 1 0 29) ; "Keep your armor on. You don't dare walk around this dangerous land without it."
			)
			(else
				(temp0 roomGets:)
				(gTheIconBar curInvIcon: 0)
				(if (> (temp0 amount:) 0)
					(gMessager say: 1 6 5 1 0 29) ; "You put one into the chest."
				else
					(gMessager say: 1 6 4 1 0 29) ; "You put it in the chest."
				)
			)
		)
	)
)

