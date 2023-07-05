;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Plaza)
(use fountainWater)
(use Merchant)
(use MsgMerchant)
(use PlazaDoor)
(use Interface)
(use Polygon)
(use Extra)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	FPS 0
)

(local
	sloreeSaidMsg
	[alternatorMsgs 12] = [83 86 87 90 91 92 93 94 95 96 97 100]
	[foodMerchantSpecList 27] = [112 115 '//bread' 108 111 '//falafel,lamb,pita' 116 119 '//date,almond[<about,honeyed]' 120 123 '//honey' 124 129 '//saurii,paprika' 130 137 '//jerky,lizard,provision' 83 86 '//food,merchandise' -1 0 '//nephew,sloree,identity,lifemate,husband,wife,(merchant[<food,meat,about])' 0 0 0]
	[toshurSpecList 6] = [81 '//pan,merchandise' 82 '//clay' 0 0]
	[ojGenList 38] = [0 26 28 31 33 35 37 39 41 43 45 47 49 51 53 55 57 2 72 59 61 63 65 67 69 72 74 76 78 80 69 82 78 2 2 2 2 2]
	[ojSpecList 8] = [4 '//jaafar' 6 '//rakeesh' 8 '//paladin' 0 0]
)

(instance FPS of FountainPlaza
	(properties
		north 704
		south 310
		west 704
		topExit 3
		bottomExit 1
		leftExit 2
	)

	(method (init)
		(super init:)
		(self
			addObstacle:
				(poly1
					init: 0 161 0 0 319 0 319 170 313 169 290 138 286 140 237 140 174 102 173 94 169 6 150 6 150 95 140 108 115 127 107 131 78 148 23 157 14 159
					yourself:
				)
				(poly2
					init: 105 189 92 172 120 150 159 140 200 149 220 169 220 181 213 189
					yourself:
				)
		)
		(if (IsFlag 136)
			(purse init:)
		)
		(if (and (== gDay 7) (< gPlazaLastHere 700))
			(omar init: hide:)
			(jaAfar init: hide:)
			(InitAddToPics omarRug)
		)
		(if (and (<= 0 gTimeODay 4) (not (IsElementalInRoom)))
			(scoree init:)
			(sloree init:)
			(toshur init:)
			(= saveIllegal -18432)
			(if (== gDay 3)
				((ScriptID 302 0) init: posn: 116 97) ; beggar
				(= entranceScript (ScriptID 302 1)) ; beggarSpeech
			)
		)
		(apothDoor init:)
		(InitAddToPics rightWindow alleySign apothSign)
	)

	(method (dispose)
		(= gPlazaLastHere (+ (* gDay 100) gTimeODay))
		(DisposeScript 302)
		(super dispose:)
	)
)

(instance apothDoor of PlazaDoor
	(properties
		x 67
		y 116
		noun '/door'
		description {the door to the Apothecary Shop}
		lookStr {Judging by the sign of the Mortar and Pestle above the door, this must be the entrance to the Apothecary.}
		view 301
		loop 6
		priority 6
		signal 16400
		entranceTo 130
		exitDir 3
		xOut 39
		yOut 111
		xIn 87
		yIn 111
		barred 1
	)
)

(class AlternatingTalkerScript of HandsOffScript
	(properties
		lastMsg 0
		curMsg 0
		talker 0
	)

	(method (init theClient theCaller first last)
		(= curMsg first)
		(= lastMsg last)
		(= talker scoree)
		(super init: theClient theCaller)
	)

	(method (changeState)
		(if (> curMsg lastMsg)
			(self dispose:)
		else
			(Say talker self (client msgFile:) curMsg)
			(= talker (if (== talker sloree) scoree else sloree))
			(++ curMsg)
		)
	)
)

(class AlternatingTalker of MsgMerchant
	(properties
		firstMsg -1
		lastMsg 0
	)

	(method (init)
		(super init:)
		(self addWares: bread Saurus_On_A_Stick dates falafel lizard_jerky)
	)

	(method (has &tmp aWare)
		(cond
			((or (Said '/food') (Said '//food'))
				(Say self 315 0) ; "Please be more specific, Effendi."
				(return -1)
			)
			(
				(and
					(= aWare (super has: &rest))
					(!= aWare -1)
					(!= aWare lizard_jerky)
					gFreeMeals
				)
				(HighPrint 315 1) ; "You're not hungry right now."
				(return -1)
			)
			(else
				(return aWare)
			)
		)
	)

	(method (saySoldBegin)
		(self say: 142 143 self)
	)

	(method (saySoldEnd)
		(if (== curWare lizard_jerky)
			(gEgo get: 3 5) ; Food
			(HighPrint 315 2) ; "You put the rations away in your pack."
		else
			(HighPrint 315 3) ; "You try it and find that you like it. It is soon eaten."
			(= gFreeMeals 1)
			(ClearFlag 4)
			(ClearFlag 5)
		)
	)

	(method (sayBargainSuccess)
		(self say: 101 105 self)
	)

	(method (sayBargainFailure)
		(self say: 106 107 self)
	)

	(method (say first last aCaller &tmp theCaller)
		(= theCaller (if (>= argc 3) aCaller else 0))
		(self setScript: (AlternatingTalkerScript new:) theCaller first last)
	)

	(method (sayMsg whatMessage)
		(self say: [alternatorMsgs (* whatMessage 2)] [alternatorMsgs (+ (* whatMessage 2) 1)])
	)

	(method (showText what)
		(cond
			((== what -1)
				(self showSelf:)
			)
			((!= firstMsg -1)
				(self say: firstMsg lastMsg)
			)
			(else
				(super showText: what)
			)
		)
		(= firstMsg -1)
	)

	(method (showSelf)
		(AlternatingTalker say: 138 141)
	)

	(method (scanSaidSpecs atMethod &tmp i answer saidSpec)
		(if (!= atMethod 669)
			(return (super scanSaidSpecs: atMethod))
		)
		(= firstMsg -1)
		(= answer 32767)
		(for ((= i 0)) (= saidSpec (self atMethod: (+ i 2))) ((+= i 3))
			(if (Said saidSpec)
				(= firstMsg (= answer (self atMethod: i)))
				(= lastMsg (self atMethod: (+ i 1)))
				(break)
			)
		)
		(return answer)
	)

	(method (atIndividualSpec what)
		(return [foodMerchantSpecList what])
	)

	(method (handleEvent event)
		(if (Said 'tell')
			(self say: 144 145)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (getLastMsgSaid)
		(return gSloreeMsgNum)
	)

	(method (updLastMsgSaid msg)
		(= gSloreeMsgNum msg)
	)

	(method (getSaidMsg)
		(return sloreeSaidMsg)
	)

	(method (setSaidMsg)
		(= sloreeSaidMsg 1)
	)
)

(instance falafel of Ware
	(properties
		noun '//falafel,lamb,pita>'
		price 70
		lowPrice 60
	)
)

(instance Saurus_On_A_Stick of Ware
	(properties
		name {Saurus-On-A-Stick}
		noun '//saurii>'
		price 70
		lowPrice 60
	)
)

(instance lizard_jerky of Ware
	(properties
		name {lizard jerky}
		noun '//lizard,jerky,provision>'
		price 100
		lowPrice 90
	)
)

(instance bread of Ware
	(properties
		noun '//bread>'
		price 30
		lowPrice 20
	)
)

(instance dates of Ware
	(properties
		noun '//date>'
		price 30
		lowPrice 20
	)
)

(instance scoree of AlternatingTalker
	(properties
		x 240
		y 116
		description {Scoree}
		lookStr {Scoree is the local food merchant.}
		priority 7
		signal 16400
		myName '//nephew,(merchant[<food]),catperson'
		title {Scoree:}
		isSeated 0
		isOnLeft 0
		clothesColor 3
	)

	(method (init)
		(super init:)
		(= tWindow ScoreeWindow)
		(InitAddToPics foodShelf2 foodShelf foodStand)
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//pan,clay')
				(Say self 315 4) ; "For that you must talk to Toshur, across the Plaza."
			)
			((Said 'ask//toshur')
				(Say self 315 5) ; "He is across the plaza."
			)
			((Said 'ask//attar,attar,drug,pill,potion,apothecary')
				(Say self 315 6) ; "The apothecary shop is right here in this Plaza."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance foodStand of PicView
	(properties
		x 234
		y 117
		noun '/stand[<food]'
		description {the food stand of Scoree}
		lookStr {The stand contains mostly broiled meats.}
		view 315
		loop 1
		priority 8
		signal 16400
	)
)

(instance foodShelf of PicView
	(properties
		x 221
		y 103
		noun '/stand[<food]'
		description {the food stand of Scoree}
		lookStr {The stand contains mostly broiled meats.}
		view 315
		loop 1
		cel 1
		priority 7
		signal 16400
	)
)

(instance foodShelf2 of PicView
	(properties
		x 257
		y 118
		noun '/shelf[<food]'
		description {the food stand of Scoree}
		lookStr {The food smells delicious.}
		view 315
		loop 1
		cel 2
		priority 8
		signal 16400
	)
)

(instance sloree of AlternatingTalker
	(properties
		x 257
		y 130
		description {Sloree}
		lookStr {Sloree is the local meat merchant.}
		priority 9
		signal 16400
		myName '//sloree,(merchant[<meat]),catperson'
		title {Sloree:}
		isSeated 0
		isOnLeft 0
		clothesColor 4
	)

	(method (init)
		(super init:)
		(= tWindow SloreeWindow)
		(InitAddToPics brazier meatRug)
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//pan,clay')
				(Say self 315 4) ; "For that you must talk to Toshur, across the Plaza."
			)
			((Said 'ask//toshur')
				(Say self 315 5) ; "He is across the plaza."
			)
			((Said 'ask//attar,attar,drug,pill,potion,apothecary')
				(Say self 315 6) ; "The apothecary shop is right here in this Plaza."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance brazier of PicView
	(properties
		x 276
		y 132
		noun '/brazier'
		description {the brazier}
		lookStr {The brazier is merrily cooking saurus meat.}
		view 315
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(coals init:)
	)
)

(instance coals of Extra
	(properties
		view 315
		loop 6
		priority 9
		signal 16912
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(self posn: (- (brazier x:) 2) (- (brazier y:) 6))
	)

	(method (handleEvent)
		(brazier handleEvent: &rest)
	)
)

(instance meatRug of PicView
	(properties
		x 254
		y 136
		noun '/carpet'
		description {the rug}
		lookStr {You can't imagine carpeting a meat market, but the rug under this meat stand is immaculate.}
		view 315
		loop 3
		signal 16400
	)
)

(instance toshur of MsgMerchant
	(properties
		x 67
		y 138
		description {Toshur}
		lookStr {Toshur is the local pottery merchant.}
		priority 9
		signal 16400
		myName '//toshur,potter,catperson'
		title {Toshur:}
		clothesColor 2
		firstMsgNum 75
	)

	(method (init)
		(super init:)
		(InitAddToPics potterStand)
		(self addWares: pot)
		(= lastMsgSaid gToshurMsgNum)
	)

	(method (showSelf)
		(Say self 315 7) ; "May it please you, my name is Toshur."
	)

	(method (dispose)
		(= gToshurMsgNum lastMsgSaid)
		(super dispose:)
	)

	(method (saySoldBegin)
		(Say self self 315 8) ; "Here is a small but lovely pot."
	)

	(method (atIndividualSpec which)
		(return [toshurSpecList which])
	)

	(method (sayBargainSuccess)
		(Say self self 315 9) ; "You are blessed with a tongue of fortune. You need pay me but 200 centimes."
	)

	(method (sayBargainFailure)
		(Say self self 315 10) ; "Three dinars are the worth of the pot."
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//food')
				(Say self 315 11) ; "For that you must talk to Sloree and Scoree, across the Plaza."
			)
			((Said 'ask//sloree,nephew')
				(Say self 315 12) ; "Sloree and Scoree are across the plaza."
			)
			((Said 'ask//attar,attar,drug,pill,potion,apothecary')
				(Say self 315 6) ; "The apothecary shop is right here in this Plaza."
			)
			((Said 'tell,talk,talk//elemental<air')
				(Say self 315 13 315 14) ; "That is most terrifying. I do not know how I might be able to help you."
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)
)

(instance pot of Ware
	(properties
		invItem 35
		noun '//pan>'
		price 300
		lowPrice 200
	)
)

(instance potterStand of PicView
	(properties
		x 58
		y 139
		noun '/pan,stand[<toshur,potter]'
		description {the pottery stand of Toshur}
		lookStr {Toshur's stand contains some fine and sturdy specimens of pottery.}
		view 310
		loop 3
		cel 1
		priority 9
		signal 16400
	)
)

(instance apothSign of PicView
	(properties
		x 65
		y 43
		noun '/sign'
		description {the Apothecary sign}
		lookStr {The sign of the Mortar and Pestle usually indicates the entrance to the Apothecary.}
		view 301
		cel 3
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

(instance alleySign of PicView
	(properties
		x 160
		y 46
		noun '/sign[<alley,bearing,street]'
		description {the alley sign}
		shiftClick 0
		view 310
		loop 2
		cel 3
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

(instance rightWindow of PicView
	(properties
		x 252
		y 51
		noun '/window'
		description {the window}
		lookStr {From this window all the activity on the Plaza can be seen.}
		view 300
		loop 2
		cel 3
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

(class ScoreeWindow of SysWindow
	(properties
		brTop 10
		brLeft 10
		brBottom 60
		brRight 140
	)
)

(class SloreeWindow of SysWindow
	(properties
		brTop 40
		brLeft 30
		brBottom 90
		brRight 160
	)
)

(instance poemS of Script
	(properties
		seconds 2
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(Say omar self 315 15) ; "And they ask, "What is a Hero?",   though the answer's very clear, He's the one who faces danger   when the darkness hovers near."
			)
			(2
				(Say omar self 315 16) ; "He will face the fiercest foe  when another needs his aid, He will dare to defy Death  even though he is afraid, He works not just for glory  and he does it not for gain, But because he knows that others  will be spared a greater pain."
			)
			(3
				(Say omar self 315 17) ; "He won't always follow orders,  for he dares to answer, "Why?", And unless he likes the reason,  he refuses to comply, He will brave the battle boldly  even though he may not win, He will face his fate unflinching,  for he is a Paladin."
			)
			(4
				(Say omar self 315 18) ; "And they ask "What is a Hero?",  though the answer's evident, He's the one who faces death  knowing that his life's well spent."
			)
			(5
				(SetFlag 136)
				(SolvePuzzle 603 3)
				(self dispose:)
			)
		)
	)
)

(instance omarJaAfarTalk of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say omar self 106 register)
				(++ register)
			)
			(1
				(Say jaAfar self 106 register)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance getThePurse of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (+ (purse x:) 14) (+ (purse y:) 4) self
				)
			)
			(1
				(gEgo view: 47 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(purse dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(= cycles 2)
			)
			(4
				(HighPrint 315 19) ; "You pick up the purse and open it. It has 6 dinars and 25 centimes. It also has a small scrap of paper with the words, "Quelling Chaos from Shapeir, Driving Darkness from Raseir"."
				(ClearFlag 136)
				(gEgo get: 55) ; Purse
				(= cycles 1)
			)
			(5
				(gEgo setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance omarBody of Prop
	(properties
		x 104
		y 100
		noun '/omar,poet,man'
		description {Omar}
		view 316
	)
)

(instance omar of Talker
	(properties
		x 103
		y 78
		description {Omar}
		view 316
		loop 1
		priority 9
		signal 16
		illegalBits 0
		tLoop 1
		talkSpeed 1
		myName '//omar,poet,man'
		title {Omar:}
		color 5
		msgFile 106
	)

	(method (init)
		(super init: &rest)
		(= tWindow BotWindow)
		(omarBody init:)
		(self setScript: poemS)
	)

	(method (showText what)
		(self setScript: omarJaAfarTalk 0 what)
	)

	(method (atSpec which)
		(return [ojSpecList which])
	)

	(method (atGen which)
		(return [ojGenList which])
	)

	(method (talk &tmp len curStr1 curStr2 [buffer 500] [printRect 4] theWidth)
		(switch state
			(1
				(= curStr1 s1)
				(= curStr2 s2)
			)
			(2
				(= curStr1 s3)
				(= curStr2 s4)
			)
			(3
				(= curStr1 s5)
				(= curStr2 s6)
			)
			(4
				(= curStr1 s7)
				(= curStr2 s8)
			)
		)
		(cond
			((u< curStr1 1000)
				(GetFarText curStr1 curStr2 @buffer)
			)
			(curStr1
				(StrCpy @buffer curStr1)
			)
		)
		(if (< gNumColors 8)
			(tWindow color: 0 back: 15)
		else
			(tWindow color: color back: back)
		)
		(TextSize @[printRect 0] @buffer gUserFont 0)
		(= theWidth (+ [printRect 3] 30))
		(Print
			@buffer
			#font
			gUserFont
			#title
			title
			#window
			tWindow
			#at
			0
			0
			#width
			theWidth
			#mode
			0
			#dispose
		)
		(if (< (= len (/ (StrLen @buffer) 9)) 4)
			(= len 4)
		)
		(if gDebugging
			(= endCycles 0)
		else
			(= endCycles (+ 1 (* gHowFast 1)))
		)
		(= cycles 0)
		(= seconds len)
	)

	(method (messages)
		(self setPri: (+ (omarBody priority:) 1))
		((ScriptID 81 0) hide:) ; fountainWater
		(super messages: &rest)
	)

	(method (endTalk)
		(self setPri: 0)
		((ScriptID 81 0) show:) ; fountainWater
		(super endTalk: &rest)
	)
)

(instance jaAfarBody of View
	(properties
		x 128
		y 98
		noun '/jaafar,man'
		description {Ja'Afar}
		view 318
	)
)

(instance jaAfar of Talker
	(properties
		x 129
		y 59
		description {Ja'Afar}
		view 318
		loop 1
		priority 9
		signal 16
		illegalBits 0
		tLoop 1
		talkSpeed 1
		myName '//jaafar,man'
		title {Ja'Afar:}
		color 4
		msgFile 106
	)

	(method (init)
		(super init: &rest)
		(= tWindow BotWindow)
		(jaAfarBody init:)
	)

	(method (atSpec which)
		(return [ojSpecList which])
	)

	(method (atGen which)
		(return [ojGenList which])
	)

	(method (talk &tmp len curStr1 curStr2 [buffer 500] [printRect 4] theWidth)
		(switch state
			(1
				(= curStr1 s1)
				(= curStr2 s2)
			)
			(2
				(= curStr1 s3)
				(= curStr2 s4)
			)
			(3
				(= curStr1 s5)
				(= curStr2 s6)
			)
			(4
				(= curStr1 s7)
				(= curStr2 s8)
			)
		)
		(cond
			((u< curStr1 1000)
				(GetFarText curStr1 curStr2 @buffer)
			)
			(curStr1
				(StrCpy @buffer curStr1)
			)
		)
		(if (< gNumColors 8)
			(tWindow color: 0 back: 15)
		else
			(tWindow color: color back: back)
		)
		(TextSize @[printRect 0] @buffer gUserFont 0)
		(= theWidth (+ [printRect 3] 30))
		(Print
			@buffer
			#font
			gUserFont
			#title
			title
			#window
			tWindow
			#at
			(- 300 theWidth)
			0
			#width
			theWidth
			#mode
			1
			#dispose
		)
		(if (< (= len (/ (StrLen @buffer) 9)) 4)
			(= len 4)
		)
		(if gDebugging
			(= endCycles 0)
		else
			(= endCycles (+ 1 (* gHowFast 1)))
		)
		(= cycles 0)
		(= seconds len)
	)

	(method (messages)
		(self show:)
		(super messages: &rest)
	)

	(method (endTalk)
		(self hide:)
		(super endTalk: &rest)
	)
)

(instance purse of View
	(properties
		x 115
		y 97
		noun '/purse,bag,pouch'
		description {the purse}
		lookStr {You see a small leather purse on the plaza floor.}
		view 318
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(gEgo setScript: getThePurse)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance omarRug of PicView
	(properties
		x 115
		y 102
		noun '/carpet,carpet'
		description {the rug}
		lookStr {Omar's rug is, naturally, very ornate.}
		view 315
		loop 4
		priority 0
		signal 16400
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

