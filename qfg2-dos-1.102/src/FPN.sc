;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use Talker)
(use Plaza)
(use fountainWater)
(use Merchant)
(use MsgMerchant)
(use PlazaDoor)
(use Polygon)
(use Feature)
(use LoadMany)
(use Actor)

(public
	FPN 0
)

(local
	[sabaSpecList 4] = [44 '//basket,reed,merchandise' 0 0]
	[tashtariSpecList 16] = [60 '//merchandise' 53 '//brass,merchandise,metal,mineral' 54 '//brazier' 55 '//((server,cup)[<tea,about]),teacup' 56 '//lamp,lamp' 57 '//bottle' 66 '//grease' 0 0]
	[lashamSpecList 6] = [67 '//bouquet,merchandise,plant,green' 68 '//earth,dirt' 0 0]
)

(instance FPN of FountainPlaza
	(properties
		north 704
		south 315
		west 704
	)

	(method (init &tmp i)
		(LoadMany rsVIEW 301 310 315)
		(super init:)
		(magicEye init:)
		(magicDoor init:)
		(InitFeatures flowerBox)
		(InitAddToPics northSign magicSign leftWindow)
		(self
			addObstacle:
				(poly1
					init: 0 161 48 150 99 116 125 117 150 96 147 6 169 6 171 95 179 96 219 94 236 102 259 116 251 137 266 162 276 170 319 169 319 0 309 0 0 0
					yourself:
				)
				(poly2
					init: 104 189 92 173 121 147 159 139 199 147 228 172 219 189
					yourself:
				)
		)
		(if (and (<= 0 gTimeODay 4) (not (IsElementalInRoom)))
			(tashtari init:)
			(saba init:)
			(lasham init:)
			(= saveIllegal -18432)
		)
	)
)

(instance magicDoor of PlazaDoor
	(properties
		x 252
		y 117
		noun '/door[<magic]'
		description {the door to the Magic Shop}
		lookStr {The sign above the door is keeping an eye out for you.  Perhaps the door leads to the optometrist's office.}
		view 301
		loop 3
		priority 6
		signal 16400
		entranceTo 250
		exitDir 1
		xOut 278
		yOut 115
		xIn 230
		yIn 115
		barred 1
	)
)

(instance saba of MsgMerchant
	(properties
		x 117
		y 103
		description {Saba, the basket merchant}
		lookStr {It is Saba, the basket merchant.}
		priority 6
		signal 16
		myName '//(maker[<basket,about]),saba,weaver,basketmaker,identity,family,daughter,merchant,tasman,catperson'
		title {Saba:}
		clothesColor 1
		firstMsgNum 47
	)

	(method (init)
		(super init:)
		(InitFeatures baskets)
		(basketStand init:)
		(self addWares: basket)
		(= lastMsgSaid gSabaMsgNum)
	)

	(method (dispose)
		(= gSabaMsgNum lastMsgSaid)
		(super dispose:)
	)

	(method (egoCanBuy &tmp rc)
		(if (= rc (super egoCanBuy:))
			(HighPrint 310 0) ; "You pick out a basket large enough to contain a good deal of earth."
		)
		(return rc)
	)

	(method (sayBargainSuccess)
		(Say self self 350 45) ; "You bargain as a merchant born. It is well that you are a traveling adventurer, or we would all be soon out of business with your skill at haggling. It shall be but 75 centimes."
	)

	(method (sayBargainFailure)
		(Say self self 350 46) ; "Alas, if I listened to you, my children would starve. You are very good at bargaining, but I am very poor and cannot take any less than one small dinar."
	)

	(method (atIndividualSpec which)
		(return [sabaSpecList which])
	)

	(method (showSelf)
		(Say self 310 1) ; "I am Saba, and my husband Tasman and my three daughters help weave the baskets."
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//plant,bouquet')
				(Say self 310 2) ; "For that you must talk to Lasham, across the Plaza."
			)
			((Said 'ask//lasham')
				(Say self 310 3) ; "He is across the plaza."
			)
			((Said 'ask//brass,lamp')
				(Say self 310 4) ; "For that you must talk to Tashtari, right here next to me."
			)
			((Said 'ask//tashtari')
				(Say self 310 5) ; "He is next to me."
			)
			((Said 'ask//keapon,keapon,(shop<magic)')
				(Say self 310 6) ; "The Magic Shop is right here in this Plaza. As a matter of fact, it is looking at you right now."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance basket of Ware
	(properties
		invItem 34
		noun '//basket>'
		price 100
		lowPrice 75
		canBuyMultiple 0
	)

	(method (saidMe event)
		(if (super saidMe: event)
			(if (or (< gDay 12) (> gElementalState 5))
				(HighPrint 310 7) ; "As you look the baskets over, you realize that you have little need for a basket right now."
				(return -1)
			else
				(return 1)
			)
		else
			(return 0)
		)
	)
)

(instance basketStand of PicView
	(properties
		x 105
		y 108
		noun '/stand[<basket]'
		description {the basket merchant's stand}
		lookStr {The basket merchant's stand smells of wicker and straw.}
		view 315
		priority 6
		signal 16400
	)
)

(class GetEarth
	(properties)

	(method (doit)
		(Say lasham self 310 8) ; "If I may aid you by giving you some earth, I shall be more than happy to do so. Here, take this."
	)

	(method (cue)
		(gEgo get: 32) ; PotOfDirt
		(+= gClumpsLeft 6)
		(HighPrint 310 9) ; "You put away a small pot of earth."
	)
)

(instance lasham of MsgMerchant
	(properties
		x 293
		y 158
		description {Lasham, the plant merchant}
		lookStr {It is Lasham, the plant merchant.}
		priority 10
		signal 16
		myName '//lasham,(merchant[<bouquet,plant]),catperson'
		title {Lasham:}
		isSeated 0
		isOnLeft 0
		clothesColor 6
		firstMsgNum 69
	)

	(method (init)
		(super init:)
		(InitFeatures flowers)
		(self addWares: plant)
		(InitAddToPics plant1 plant2 flowerStand)
		(= lastMsgSaid gLashamMsgNum)
	)

	(method (dispose)
		(= gLashamMsgNum lastMsgSaid)
		(super dispose:)
	)

	(method (atIndividualSpec which)
		(return [lashamSpecList which])
	)

	(method (showSelf)
		(Say self 310 10) ; "Lasham I am called; sharing the living beauty of plants is my joy."
	)

	(method (handleEvent event &tmp rc moneyGiven)
		(cond
			((Said 'get,get,buy/earth,dirt')
				(GetEarth doit:)
			)
			((Said 'tell,talk,talk//elemental<air')
				(if (gEgo has: 32) ; PotOfDirt
					(event claimed: 0)
					(super handleEvent: event)
				else
					(GetEarth doit:)
				)
			)
			((Said 'give/dinar,cent,alm>')
				(if (Said '/dinar')
					(= rc (GiveMoney (= moneyGiven 100)))
				else
					(event claimed: 1)
					(= rc (GiveMoney (= moneyGiven 1)))
				)
				(if rc
					(Say self 310 11) ; "May fortune reward you."
					(SkillUsed 14 (/ (+ moneyGiven 4) 5)) ; honor
				else
					(HighPrint 310 12) ; "You don't have it to give."
				)
			)
			((Said 'ask//basket,reed')
				(Say self 310 13) ; "For that you must talk to Saba, across the Plaza."
			)
			((Said 'ask//lasham')
				(Say self 310 3) ; "He is across the plaza."
			)
			((Said 'ask//brass,lamp')
				(Say self 310 14) ; "For that you must talk to Tashtari, across the Plaza."
			)
			((Said 'ask//tashtari')
				(Say self 310 3) ; "He is across the plaza."
			)
			((Said 'ask//keapon,keapon,(shop<magic)')
				(Say self 310 6) ; "The Magic Shop is right here in this Plaza. As a matter of fact, it is looking at you right now."
			)
			(else
				(super handleEvent: event)
				(if
					(or
						(Said 'search,look,look[<at,around][/room,area][/!*]')
						(Said 'look,look/courtyard')
					)
					(HighPrint 310 15) ; "The Plaza of the Fountain bustles with the activities of the local merchants."
				)
			)
		)
		(event claimed:)
	)
)

(instance plant of Ware
	(properties
		noun '//plant,bouquet>'
		price 100
	)

	(method (saidMe)
		(if (super saidMe:)
			(HighPrint 310 16) ; "As you look the plants over, you realize that you don't have the time or place to keep a potted plant."
			(return -1)
		else
			(return 0)
		)
	)
)

(instance flowerStand of PicView
	(properties
		x 286
		y 161
		noun '/stand[<bouquet,plant]'
		description {the plant merchant's stand}
		lookStr {It is the stand of Lasham, the plant merchant.}
		view 300
		loop 7
		priority 10
		signal 16400
	)
)

(instance plant1 of PicView
	(properties
		x 279
		y 162
		noun '/plant'
		description {a plant}
		lookStr {It doesn't appear to have aphids.}
		view 300
		loop 8
		cel 2
		priority 11
		signal 16400
	)
)

(instance plant2 of PicView
	(properties
		x 303
		y 161
		noun '/plant'
		description {another plant}
		lookStr {It doesn't appear to have boreworms.}
		view 300
		loop 8
		cel 3
		priority 11
		signal 16400
	)
)

(instance tashtari of MsgMerchant
	(properties
		x 60
		y 120
		description {Tashtari, the lamp merchant}
		lookStr {It is Tashtari, the lamp merchant.}
		priority 6
		signal 16
		myName '//tashtari,(merchant[<lamp]),catperson'
		title {Tashtari:}
		isSeated 0
		clothesColor 5
		firstMsgNum 60
	)

	(method (init)
		(super init:)
		(InitFeatures lampTable hangingLamps)
		(InitAddToPics lampStand)
		(self addWares: lamp)
		(= lastMsgSaid gTashtariMsgNum)
	)

	(method (dispose)
		(= gTashtariMsgNum lastMsgSaid)
		(super dispose:)
	)

	(method (sayMsg whatMsg)
		(if (not (and (== whatMsg 61) (gEgo has: 33))) ; BrassLamp
			(super sayMsg: whatMsg)
		)
	)

	(method (sell)
		(if (== curWare lamp)
			(SolvePuzzle 624 7)
		)
		(super sell: &rest)
	)

	(method (saySoldBegin)
		(Say tashtari self 310 17) ; "May this lamp light your darkness."
	)

	(method (sayBargainSuccess)
		(Say self self 350 58) ; "Though it is far below the price I must pay for such an object, nevertheless I am out-bargained and you shall have it for a mere 10 dinars."
	)

	(method (sayBargainFailure)
		(Say self self 350 59) ; "It grieves me very much, but what can I do? It is impossible for me to charge any less than 15 dinars for such a beautiful and valuable object."
	)

	(method (atIndividualSpec which)
		(return [tashtariSpecList which])
	)

	(method (showSelf)
		(Say self 310 18) ; "I am called Tashtari, which means "Sunset Glow.""
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//plant,bouquet')
				(Say self 310 2) ; "For that you must talk to Lasham, across the Plaza."
			)
			((Said 'ask//lasham')
				(Say self 310 3) ; "He is across the plaza."
			)
			((Said 'ask//basket,reed')
				(Say self 310 19) ; "For that you must talk to Saba, right here next to me."
			)
			((Said 'ask//saba')
				(Say self 310 5) ; "He is next to me."
			)
			((Said 'ask//keapon,keapon,(shop<magic)')
				(Say self 310 6) ; "The Magic Shop is right here in this Plaza. As a matter of fact, it is looking at you right now."
			)
			((Said 'tell,talk,talk//elemental<fire')
				(if (gEgo has: 33) ; BrassLamp
					(event claimed: 0)
					(super handleEvent: event)
				else
					(SolvePuzzle 624 7)
					(gEgo get: 33) ; BrassLamp
					(Say self 310 20) ; "This lamp of brass should serve you against the thing of Fire. It is now your own."
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)
)

(instance lamp of Ware
	(properties
		invItem 33
		noun '//lamp>'
		price 1500
		lowPrice 1000
		canBuyMultiple 0
	)
)

(instance lampStand of PicView
	(properties
		x 52
		y 131
		noun '/stand[<lamp]'
		description {the lamp merchant's stand}
		lookStr {It is the stand of Tashtari, the lamp merchant.}
		view 310
		loop 3
		priority 7
		signal 16400
	)
)

(instance magicSign of PicView
	(properties
		x 251
		y 54
		noun '/eye,sign'
		description {the EYE}
		lookStr {The sign above the door is keeping an eye out for you.  Perhaps the door leads to the optometrist's office.}
		view 301
		cel 2
		priority 0
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance magicEye of Prop
	(properties
		x 250
		y 44
		noun '/eye,sign'
		description {the EYE}
		lookStr {QUIT STARING AT ME!!}
		view 301
		loop 1
		priority 6
		signal 16401
	)

	(method (doit &tmp angle theCel)
		(if gModelessDialog
			(return)
		)
		(= theCel
			(cond
				((< (gEgo y:) 110) 3)
				((< (= angle (GetAngle (gEgo x:) (gEgo y:) x y)) 20) 1)
				((< angle 55) 2)
				((< angle 320) 3)
				(else 0)
			)
		)
		(if (!= cel theCel)
			(= cel theCel)
			(self forceUpd:)
		)
		(super doit:)
	)
)

(instance northSign of PicView
	(properties
		x 160
		y 46
		noun '/sign[<alley,bearing,street]'
		description {the alley sign}
		view 310
		loop 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance leftWindow of PicView
	(properties
		x 69
		y 51
		noun '/window'
		description {It's a window}
		lookStr {The window has a lovely view of the Plaza.}
		view 300
		loop 1
		cel 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance lampTable of Feature
	(properties
		x 33
		y 123
		noun '/table[<little,lamp]'
		nsTop 116
		nsLeft 25
		nsBottom 131
		nsRight 42
		description {a small table with lamps on it}
		lookStr {The small table is used for display.}
	)
)

(instance hangingLamps of Feature
	(properties
		x 33
		y 90
		noun '/lamp[<hang]'
		nsTop 85
		nsLeft 25
		nsBottom 95
		nsRight 41
		description {hanging lamps}
		lookStr {Some of the lamps are intended to be hung.}
	)
)

(instance flowerBox of Feature
	(properties
		x 74
		y 40
		noun '/plant,box[<bouquet,plant]'
		nsTop 34
		nsLeft 62
		nsBottom 46
		nsRight 86
		description {a lovely planter box}
		lookStr {The planter box in the window is in full flower.}
	)
)

(instance flowers of Feature
	(properties
		x 278
		y 116
		noun '/pan,bouquet[<pan]'
		nsTop 105
		nsLeft 263
		nsBottom 128
		nsRight 294
		description {flowers in pots}
		lookStr {The flowering plants are truly beautiful to behold in this desert land.}
	)
)

(instance baskets of Feature
	(properties
		x 95
		y 95
		noun '/basket'
		nsTop 84
		nsLeft 79
		nsBottom 106
		nsRight 111
		description {the basket merchant's wares}
		lookStr {The snake charmer's snake wishes his basket was as fine as these.}
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

