;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Talker)
(use TargActor)
(use Flame)
(use Plaza)
(use Merchant)
(use MsgMerchant)
(use PlazaDoor)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rmSPlazaFightersE 0
)

(local
	saveView
	saveLoop
	saveCel
	saveCycler
	mirakThankable
	kiramThankable
	[kiramSpecList 8] = [161 '//cloth,clothes,veil,merchandise' 162 '//bag[<cloth,about]' 163 '//family,tiram,tashtari,toshar,sloree,sava,sashanan,nephew,kiram' 0 0]
	[mirakSpecList 8] = [152 '//leather,leatherwork,merchandise' 153 '//belt,boot' 154 '//waterbag' 0 0]
)

(instance rmSPlazaFightersE of Plaza
	(properties
		north 704
		south 320
		topExit 2
		bottomExit 4
	)

	(method (init)
		(self
			addObstacle:
				(poly1
					init: 0 178 0 0 319 0 319 188 284 132 239 132 201 105 199 94 173 93 170 8 146 8 146 93 87 100 54 118 63 140 44 167 20 178
					yourself:
				)
		)
		(super init:)
		(= gLevScript (= gRopeScript getBellows))
		(= gLevHighY 70)
		(= gRopeHighY 20)
		(if (and (<= 0 gTimeODay 4) (not (IsElementalInRoom)))
			(mirak init:)
			(kiram init:)
			(= saveIllegal -20480)
		)
		(weaponsShopDoor init:)
		(if (not (IsFlag 85)) ; fBellowsGone
			(bellows palette: (if gNight 2 else 1) init:)
		)
		(InitAddToPics mosaic rightWindow alleySign weaponsShopSign doorFrame)
	)

	(method (dispose)
		(= gLevScript (= gRopeScript 0))
		(super dispose: &rest)
	)
)

(instance weaponsShopDoor of PlazaDoor
	(properties
		x 67
		y 114
		noun '/door[<shop,weapon,issur]'
		description {the door to the Weapons Shop}
		lookStr {The sign above it indicates that the door leads to the Weapons Shop.}
		view 301
		loop 4
		priority 6
		signal 16400
		entranceTo 140
		exitDir 1
		xOut 37
		yOut 111
		xIn 84
		yIn 111
	)

	(method (init)
		(super init: &rest)
		(= barred (IsFlag 115)) ; fWeaponBarred
	)

	(method (cue)
		(if (and (IsFlag 115) (== state 1)) ; fWeaponBarred
			(HighPrint 330 0) ; "As the door closes, you hear the bar fall into place behind you. The door is now barred from the inside."
		)
		(super cue:)
	)

	(method (enter)
		(if (IsFlag 25) ; fIssurMad
			(gCurRoom inOut: 3)
			(= xIn 55)
			(= yIn 110)
			(self setScript: thrownIn gCurRoom)
		else
			(super enter:)
		)
	)
)

(instance kiram of MsgMerchant
	(properties
		x 239
		y 111
		description {a clothing merchant}
		lookStr {Kiram is the local clothing merchant.}
		loop 1
		cel 3
		priority 7
		signal 16400
		myName '//kiram,(merchant[<clothes,about]),catperson'
		title {Kiram:}
		isSeated 0
		isOnLeft 0
		clothesColor 5
		firstMsgNum 155
	)

	(method (init)
		(super init:)
		(InitAddToPics cloth clothes clothesStand)
		(self addWares: clothBag)
		(= lastMsgSaid gKiramMsgNum)
	)

	(method (dispose)
		(= gKiramMsgNum lastMsgSaid)
		(super dispose:)
	)

	(method (sell)
		(if (== curWare clothBag)
			(SolvePuzzle 625 7)
		)
		(super sell: &rest)
	)

	(method (has)
		(cond
			((or (Said '/clothes') (Said '//clothes'))
				(HighPrint 330 1) ; "You realize that they don't carry Hero sizes at this stand."
				(return -1)
			)
			((or (Said '/cloth,veil') (Said '//cloth,veil'))
				(HighPrint 330 2) ; "You really don't see anything you want."
				(return -1)
			)
			(else
				(return (super has:))
			)
		)
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//leather,leatherwork,waterbag')
				(Say self 330 3) ; "For that you must talk to Mirak, who is across the Plaza."
			)
			((Said 'ask//mirak')
				(Say self 330 4) ; "Mirak is across the plaza."
			)
			((Said 'ask//issur,weapon,blade,dagger,shield')
				(Say self 330 5) ; "The Weapon Shop of Issur is right here in this Plaza."
			)
			((Said 'tell>')
				(if (and (Said '//elemental<earth>') (not (IsFlag 84))) ; fToldKiram
					(Say self 330 6) ; "If this bag of cloth will but aid you, it shall be yours!"
					(TrySkill 13 100) ; communication
					(SolvePuzzle 625 7)
					(gEgo get: 38) ; ClothBag
					(SetFlag 84) ; fToldKiram
					(= kiramThankable 1)
				else
					(Say self 330 7) ; "You should become a storyteller like my sister Sava."
				)
				(event claimed: 1)
			)
			((and (Said 'thank>') kiramThankable)
				(SkillUsed 13 30) ; communication
				(SkillUsed 14 50) ; honor
				(SayThanks self 330 8)
				(= kiramThankable 0)
				(event claimed: 1)
			)
		)
		(if (not (event claimed:))
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (atIndividualSpec what)
		(return [kiramSpecList what])
	)

	(method (showSelf)
		(Say self 330 9) ; "I am Kiram."
	)

	(method (sayBargainSuccess)
		(Say self self 330 10) ; "My nephew Shameen the Innkeeper said you were smooth of tongue!  Very well, you may have the bag for only 20 centimes."
	)

	(method (sayBargainFailure)
		(Say self self 330 11) ; "With a family as large as mine, I must make what little profit I can. The bag sells for fifty centimes."
	)
)

(instance clothBag of Ware
	(properties
		invItem 38
		noun '//bag[<cloth,about,for]>'
		price 50
		lowPrice 20
	)
)

(instance clothesStand of PicView
	(properties
		x 247
		y 126
		noun '/stand,stall[<clothes]'
		description {a clothing stand}
		lookStr {It is the stand of Kiram, the local clothing merchant.}
		view 335
		loop 1
		signal 16384
	)
)

(instance cloth of PicView
	(properties
		x 249
		y 112
		noun '/cloth,good'
		description {cloth goods}
		lookStr {The cloth looks very well made, indeed.}
		view 330
		priority 8
		signal 16400
	)
)

(instance clothes of PicView
	(properties
		x 270
		y 98
		noun '/clothes'
		description {clothing}
		lookStr {The clothing looks very well made, indeed.}
		view 330
		cel 1
		priority 9
		signal 16400
	)
)

(instance mirak of MsgMerchant
	(properties
		x 11
		y 161
		description {Mirak, the leather merchant}
		lookStr {Mirak is the local leather merchant.}
		priority 11
		signal 16400
		myName '//mirak,(merchant[<leather]),catperson'
		title {Mirak:}
		clothesColor 2
		firstMsgNum 146
	)

	(method (init)
		(super init:)
		(InitAddToPics leather leatherGoods leatherStand)
		(self addWares: waterskin)
		(= lastMsgSaid gMirakMsgNum)
	)

	(method (dispose)
		(= gMirakMsgNum lastMsgSaid)
		(super dispose:)
	)

	(method (has)
		(if (or (Said '/belt,boot,leather') (Said '//belt,boot,leather'))
			(HighPrint 330 2) ; "You really don't see anything you want."
			(return -1)
		else
			(return (super has:))
		)
	)

	(method (atIndividualSpec what)
		(return [mirakSpecList what])
	)

	(method (showSelf)
		(Say self 330 12) ; "I am Mirak."
	)

	(method (sayBargainSuccess)
		(Say self self 330 13) ; "Since what you say is said so well, it must be that I will sell it for only fifty centimes."
	)

	(method (sayBargainFailure)
		(Say self self 330 14) ; "Alas, I can sell you a waterskin for no less than 1 dinar."
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//cloth,clothes,veil')
				(Say self 330 15) ; "For that you must talk to Kiram, who is across the Plaza."
			)
			((Said 'ask//kiram')
				(Say self 330 16) ; "Kiram is across the plaza."
			)
			((Said 'ask//issur,weapon,blade,dagger,shield')
				(Say self 330 5) ; "The Weapon Shop of Issur is right here in this Plaza."
			)
			((Said 'tell>')
				(if
					(and
						(Said '//plant,(elemental<fire),(elemental<water)>')
						(not (IsFlag 83)) ; fToldMirak
					)
					(Say self 330 17) ; "Since your need is great, this waterskin shall be a gift."
					(gEgo get: 37) ; Waterskin
					(SetFlag 83) ; fToldMirak
					(= mirakThankable 1)
				else
					(Say self 330 18) ; "We live in interesting times."
				)
				(event claimed: 1)
			)
			((and (Said 'thank>') mirakThankable)
				(SkillUsed 13 30) ; communication
				(SkillUsed 14 30) ; honor
				(SayThanks self 330 19)
				(= mirakThankable 0)
				(event claimed: 1)
			)
		)
		(if (not (event claimed:))
			(super handleEvent: event)
			(if
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 330 20) ; "The Plaza of the Fighters bustles with the activities of the local merchants."
			)
		)
		(event claimed:)
	)
)

(instance waterskin of Ware
	(properties
		invItem 37
		noun '//waterbag,skin>'
		price 100
		lowPrice 50
	)
)

(instance leatherStand of PicView
	(properties
		x 25
		y 166
		noun '/stand,stall[<leather]'
		description {the stand of Mirak, the leather merchant}
		lookStr {It is the stand of Mirak, the local leather merchant.}
		view 300
		loop 8
		priority 11
		signal 16400
	)
)

(instance leatherGoods of PicView
	(properties
		x 33
		y 166
		z 21
		noun '/good,item[<leather]'
		description {leather goods}
		lookStr {Very fine saurus skin.}
		view 300
		loop 7
		cel 2
		priority 11
		signal 16400
	)
)

(instance leather of PicView
	(properties
		x 9
		y 120
		noun '/good,item[<leather]'
		description {leather goods}
		lookStr {Very fine saurus hide.}
		view 300
		loop 7
		cel 3
		priority 11
		signal 16400
	)
)

(instance weaponsShopSign of PicView
	(properties
		x 65
		y 56
		noun '/sign[<shop,weapon,issur]'
		description {the sign of the Weapons Shop}
		lookStr {According to the sign, the door below it must lead to the Weapons Shop.}
		view 301
		cel 4
		priority 6
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance alleySign of PicView
	(properties
		x 160
		y 46
		shiftClick 0
		view 310
		loop 2
		cel 1
		priority 6
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rightWindow of PicView
	(properties
		x 252
		y 51
		noun '/window'
		description {a window}
		lookStr {The window commands a view of the entire plaza.}
		view 300
		loop 2
		cel 1
		priority 6
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance bellows of TargActor
	(properties
		x 64
		y 35
		noun '/bellows'
		description {the bellows}
		lookStr {The emblem of the bellows above the door looks like the real thing.}
		view 330
		cel 2
		priority 7
		signal 16
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (fetchMe)
		(SolvePuzzle 609 7)
		(gEgo get: 25) ; Bellows
		(SkillUsed 14 -100) ; honor
		(SetFlag 85) ; fBellowsGone
		(return 1)
	)

	(method (hurtMe damage whatHurt)
		(if (OneOf (whatHurt type:) 25 27)
			(bellowsFlame init: (whatHurt x:) (whatHurt y:))
		)
		(return 0)
	)
)

(instance doorFrame of PicView
	(properties
		x 51
		y 116
		shiftClick 0
		view 301
		loop 7
		priority 6
		signal 16
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance mosaic of PicView
	(properties
		x 159
		y 189
		noun '/mosaic,tile'
		description {the tile mosaic}
		lookStr {The mosaic tile work is exceptionally well-crafted.}
		view 301
		loop 8
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance getBellows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gEgo inRect: 53 96 121 131))
					(HighPrint 330 21) ; "You're not in a good position to do that."
					(= caller 0)
					(client dispose:)
				else
					(gEgo setMotion: MoveTo 96 123 self)
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= caller 0)
				(client cue:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((< state 2))
			((Said 'get,get/bellows')
				(cond
					((IsFlag 85) ; fBellowsGone
						(HighPrint 330 22) ; "There are no bellows here to get."
					)
					((> (- (gEgo y:) (gEgo z:)) 75)
						(HighPrint 330 23) ; "You're not quite close enough to get the bellows."
					)
					(else
						(self setScript: grabBellows)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance grabBellows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= saveView (gEgo view:))
				(= saveLoop (gEgo loop:))
				(= saveCel (gEgo cel:))
				(= saveCycler (gEgo cycler:))
				(gEgo view: 6 setLoop: 7 cel: 0 cycler: 0 setCycle: End self)
			)
			(1
				(= cycles 5)
			)
			(2
				(gEgo setCycle: Beg self)
				(SolvePuzzle 609 7)
				(SkillUsed 14 -100) ; honor
				(gEgo get: 25) ; Bellows
				(SetFlag 85) ; fBellowsGone
				(bellows dispose:)
			)
			(3
				(gEgo
					view: saveView
					setLoop: saveLoop
					setCycle: saveCycler
					cel: saveCel
				)
				(self dispose:)
			)
		)
	)
)

(instance thrownIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom inOut: 1)
				(client savePri: (client priority:))
				(client setPri: 2)
				(gEgo
					setPri: 3
					illegalBits: 0
					view: 49
					loop: 0
					cel: 1
					illegalBits: 0
					posn: 55 110
					setCycle: End self
				)
			)
			(1
				(client close:)
			)
			(2
				(= cycles 10)
			)
			(3
				(gEgo loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(gEgo
					view: 4
					loop: 4
					cel: 0
					posn: (+ (gEgo x:) 34) (+ (gEgo y:) 19)
					cycleSpeed: 0
					heading: 135
				)
				(client setPri: (client savePri:))
				(NormalEgo)
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance bellowsFlame of Fire
	(properties)

	(method (init theX theY)
		(super init:)
		(HandsOff)
		(= x theX)
		(= y theY)
		(self setPri: 15)
		(= burnTime 60)
	)

	(method (dispose)
		(super dispose: delete:)
		(bellows hide:)
		(RedrawCast)
		(HighPrint 330 24) ; "Very nicely done, Hero. You've just destroyed the only bellows in the city. Too bad there's no bellows doctor here, because these need major healing."
		(= gDay 9)
		(gCurRoom newRoom: 340)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

