;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Flame)
(use Full)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm100 0
	shameen 1
	shema 2
	standTimer 3
)

(local
	whatOrdered
	innAction
	haveOrdered
	hasTea
	mealDJour
	[tempStr 50]
	[shemaPts 12] = [100 142 149 142 169 129 161 116 95 123 92 137]
	[tablePts 16] = [21 157 89 158 93 165 91 174 80 177 61 179 41 179 18 171]
	[InnList 17] = [0 1 2 3 6 4 0 0 2 0 0 3 7 0 4 5 3]
	[shameenGenList 38] = [0 2 3 1 1 1 1 1 1 4 5 6 7 1 8 9 10 1 11 1 12 13 14 15 16 17 18 19 20 21 22 1 23 1 1 1 1 1]
	[shameenSpecList 32] = [24 '//shema,wife' 25 '//abdulla' 26 '//destiny' 27 '//foreshadow' 28 '//cousin' 29 '//spielburg,hero' 30 '//dance' 31 '//loot' 32 '//lion,lion,rakeesh' 33 '//nephew,nephew' 34 '//bazaar' 35 '//room,bed,nap' 36 '//breakfast,food,drink,tea,eat,eat' 37 '//guest,bandit' 39 '//fire,air,earth,water' 0 0]
	[shemaGenList 38] = [0 2 3 1 1 1 1 1 1 1 4 5 6 1 7 8 9 1 10 1 11 12 13 14 15 16 1 1 17 18 19 1 20 1 1 1 1 1]
	[shemaSpecList 40] = [21 '//cousin' 22 '//food,eat,eat,breakfast' 23 '//drink,tea' 24 '//hero' 25 '//spielburg' 26 '//family' 27 '//underground' 28 '//abdulla' 29 '//dance' 30 '//shameen' 31 '//relation,cousin,dad' 32 '//lamb,chicken,rabbit,curry' 33 '//saurii' 34 '//knockwurst,sauerkraut' 35 '//fire' 36 '//shop,bazaar' 37 '//worry' 15 '//freedom,home,(land<home)' 66 '//fire,air,earth,water' 0 0]
)

(procedure (EatDrink numMeals eatToo)
	(ClearFlag 3)
	(ClearFlag 137)
	(if eatToo
		(= gFreeMeals numMeals)
		(ClearFlag 4)
		(ClearFlag 5)
		(= gInnLastAte gNow)
	)
)

(procedure (MornMsg whoCares &tmp mealNum)
	(cond
		((OneOf gDay 2 4 5 8 11)
			(Say shema whoCares (shema msgFile:) (+ 50 gDay))
		)
		((and (== gDay 6) (== gElementalState 1))
			(Say shema whoCares (shema msgFile:) (+ 50 gDay))
		)
		((and (== gDay 10) (== gElementalState 3))
			(Say shema whoCares (shema msgFile:) (+ 50 gDay))
		)
		((and (== gDay 13) (== gElementalState 5))
			(Say shema whoCares (shema msgFile:) (+ 50 gDay))
		)
		((== gElementalState 7)
			(Say shema whoCares (shema msgFile:) 64)
		)
		((and (== gElementalState 8) (not (gEgo has: 27))) ; SapphPin
			(Say shema whoCares (shema msgFile:) 65)
		)
		(else
			(= mealNum (ChooseFromCycle gDay 1 5))
			(Say shema whoCares (shema msgFile:) (+ 45 (- mealNum 1)))
		)
	)
)

(instance rm100 of Rm
	(properties
		picture 100
		style 6
	)

	(method (init &tmp shadowPeople)
		(SetFlag 2)
		(SetFlag 16)
		(LoadMany rsVIEW 0 100 102 103 104 302)
		(LoadMany rsTEXT 104 102)
		(LoadMany rsSOUND 100 109)
		(= innAction [InnList gDay])
		(= gNow (+ (* gDay 100) gTimeODay))
		(if (not (OneOf gPrevRoomNum 112 118))
			(gCSound
				number: (if (or (== gTimeODay 4) (== gTimeODay 5)) 109 else 100)
				loop: 0
				priority: 0
				playBed:
			)
		)
		(if (and (or (== gTimeODay 4) (== gTimeODay 5)) (== innAction 3))
			(Load rsSCRIPT 116)
			(Load rsTEXT 116)
			(Load rsTEXT 106)
			(Load rsVIEW 106)
			(Load rsVIEW 108)
			((ScriptID 116 0) init:) ; omar
		)
		(if (and (or (== innAction 1) (== innAction 4)) (< gTimeODay 6))
			(Load rsSCRIPT 117)
			(Load rsTEXT 117)
			(Load rsTEXT 105)
			(Load rsVIEW 105)
			((ScriptID 117 0) init:) ; abdulla
		)
		(LoadMany rsSCRIPT 945 946)
		(= global76 1)
		(super init:)
		(if (or (== gTimeODay 4) (== gTimeODay 5))
			(flame1 init:)
			(flame2 init:)
			(InitAddToPics musician)
		)
		(shemaPoly points: @shemaPts size: 6)
		(tablePoly points: @tablePts size: 8)
		(self addObstacle: tablePoly shemaPoly)
		(shameen init:)
		(shema init: hide:)
		(NormalEgo)
		(gEgo init:)
		(if
			(>
				(mod
					(= shadowPeople
						(+
							(mod (+ gDay gTimeODay) 8)
							(or (== gTimeODay 4) (== gTimeODay 5))
						)
					)
					2
				)
				0
			)
			(gAddToPics add: shadow1)
		)
		(if (> (mod shadowPeople 3) 0)
			(gAddToPics add: shadow2)
		)
		(if (> (mod shadowPeople 4) 0)
			(gAddToPics add: shadow3)
		)
		(lamp init:)
		(InitAddToPics
			trim1
			trim2
			oilLamp
			rope
			tassle
			egoPillow
			pillow2
			pillow3
			pillow4
			detail1
			detail2
			brassBottle
			egoTable
			table1
			table2
			table3
			table4
		)
		(switch gPrevRoomNum
			(112
				(self setScript: beginScript)
			)
			(118
				(self setScript: beginScript)
			)
			(810 ; chAlloc
				(self setScript: beginScript)
			)
			(101 ; bedroom
				(self setScript: sleepScript)
			)
			(else
				(self setScript: enterScript)
			)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(= gInnLastHere gNow)
		(gCSound fade:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((gEgo script:))
			((& (gEgo onControl: 1) $4000)
				(self newRoom: 101) ; bedroom
			)
			((== (gEgo edgeHit:) 3)
				(self setScript: byeScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sat')
				(if (== (gEgo view:) 100)
					(HighPrint 100 0) ; "You're already seated."
				else
					(self setScript: egoSits)
				)
			)
			((Said 'stand,(get,get<up)')
				(if (== (gEgo view:) 100)
					(self setScript: egoStands)
				else
					(HighPrint 100 1) ; "You're already standing."
				)
			)
			((Said 'order,call>')
				(cond
					((Said '/tea')
						(= whatOrdered 2)
					)
					((Said '/food,breakfast,lamb,curry,chicken,rabbit')
						(= whatOrdered 0)
					)
					((Said '/hostess,shema,hostess')
						(= whatOrdered 1)
					)
					((Said '[/!*]')
						(if (not haveOrdered)
							(= whatOrdered 0)
						else
							(= whatOrdered 3)
						)
					)
					(else
						(event claimed: 1)
						(= whatOrdered 3)
					)
				)
				(cond
					((or (> gTimeODay 5) (< gTimeODay 0))
						(if (== whatOrdered 0)
							(Say shameen 100 2) ; "Forgive us, friend, but there are no meals prepared at present, nor will there be until morning."
						else
							(Say shameen 100 3) ; "Forgive us, friend, but Shema is asleep."
						)
					)
					((OneOf gTimeODay 2 3)
						(Say shameen 100 4 100 5) ; "Forgive us, friend, but Shema must prepare for the evening meal. Perhaps you could wait until later for Shema to serve you."
					)
					((not (== (gEgo view:) 100))
						(Say shameen 100 6) ; "If you will be seated, Shema will serve you."
					)
					((and (== (shema x:) 37) (== (shema y:) 163))
						(switch whatOrdered
							(0
								(if haveOrdered
									(Say shema 100 7) ; "Certainly you do not wish for more to eat!"
								else
									(shemaTimer dispose:)
									(shema setScript: shemaLeaves 0 1)
								)
							)
							(2
								(if hasTea
									(Say shema 100 8) ; "You have some tea, Hero."
								else
									(Say shema 100 9) ; "Here is some of our wonderful tea."
									(= hasTea 1)
								)
							)
							(else
								(Say shema 100 10) ; "I am here to serve you."
							)
						)
					)
					(else
						(if (and haveOrdered (== whatOrdered 0))
							(= whatOrdered 1)
						)
						(if (& (shema signal:) $0080)
							(Say
								shameen
								(Format ; "Shema will be with you shortly%s"
									@tempStr
									100
									11
									(cond
										((== whatOrdered 2) { with some of our wonderful tea.})
										((or haveOrdered (OneOf whatOrdered 1 3)) {. })
										(else { with one of her splendid meals.})
									)
								)
							)
						)
						(if (and (shema script:) (OneOf whatOrdered 0 2))
							(shema setScript: shemaLeaves 0 1)
						else
							(shema setScript: shemaServes)
						)
					)
				)
			)
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 100 12) ; "You are pleased at the delicious smells and delightful ambiance of the newly remodeled Katta's Tail Inn. You give it three and a half stars."
			)
			((Said 'thank')
				(if (and (== (shema x:) 37) (== (shema y:) 163))
					(SayThanks shema shemaTimer 100 13)
				else
					(event claimed: 0)
				)
			)
			((Said 'drink')
				(cond
					((not (== (gEgo view:) 100))
						(if hasTea
							(HighPrint 100 14) ; "Your tea is on the table."
						else
							(HighPrint 100 15) ; "Perhaps you should sit and ordered some."
						)
					)
					(hasTea
						(HighPrint 100 16) ; "The tea, as Abdulla has told you many times, is wonderful."
						(EatDrink 0 0)
						(= hasTea 0)
					)
					((> gDrinksLeft 0)
						(HighPrint 100 17) ; "Aside from your water, you have nothing to drink. You would no doubt receive tea with a meal."
					)
					(else
						(HighPrint 100 18) ; "You would undoubtedly receive tea with a meal, were you to order one."
					)
				)
			)
			((Said 'look,look/food,breakfast,lamb,curry,chicken,rabbit')
				(cond
					((not haveOrdered)
						(event claimed: 0)
					)
					((< gTimeODay 2)
						(HighPrint 100 19) ; "Your breakfast looks delicious."
					)
					(else
						(HighPrint 100 20) ; "It makes your mouth water."
					)
				)
			)
			((Said 'eat,eat[/food,breakfast,lamb,curry,chicken,rabbit]')
				(cond
					((== gInnLastAte gNow)
						(HighPrint 100 21) ; "You think twice about eating more than one meal at a sitting. Bicarbonate of soda hasn't been invented yet."
					)
					((not (== (gEgo view:) 100))
						(HighPrint 100 22) ; "It is most polite to eat restaurant meals while seated at a table."
					)
					((and haveOrdered (< gTimeODay 2))
						(if (< (shema x:) 240)
							(shemaTimer cue:)
						)
						(EatDrink 1 1)
						(HighPrint 100 23) ; "Your breakfast is delicious."
					)
					(haveOrdered
						(if (< (shema x:) 240)
							(shemaTimer cue:)
						)
						(EatDrink 2 1)
						(HighPrint 100 24) ; "You have a wonderful meal. There are numerous salads, the two main courses, fruit, hot mint tea, dessert, and all the bread you could want. You feel stuffed and content."
						(if (== mealDJour 6)
							(HighPrint 100 25) ; "Unfortunately, you never really cared for sauerkraut and knockwurst, but you are too polite to tell Shema that. You must admit the honey and lemons on the knockwurst aren't too bad, but the sauerkraut curry is a bit much."
						else
							(switch (umod gDay 3)
								(0
									(HighPrint 100 26) ; "Fortunately, Heroes never get bellyaches."
								)
								(1
									(HighPrint 100 27) ; "Fortunately, your strenuous regimen as a Hero prevents you from looking as round as Abdulla."
								)
								(2
									(HighPrint 100 28) ; "After a meal like that, you feel it will be a struggle even to make it to bed. But, what the hey, you're a Hero, you can do it!"
								)
							)
						)
					)
					(else
						(event claimed: 1)
						(if (gEgo has: 3) ; Food
							(HighPrint 100 29) ; "You should order a meal first. It would be rude to eat your travel rations in your friends' Inn."
						else
							(HighPrint 100 30) ; "You have no food."
						)
					)
				)
			)
			((Said 'give,replace/back,purse,alm')
				(Say shameen 100 31) ; "Perhaps it would be best, Effendi, if you returned it to Omar himself."
			)
			((or (Said 'rent,buy,get,get/room,bed') (Said 'nap,rest'))
				(shameen showText: 35)
			)
		)
	)
)

(instance beginScript of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DontMove 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 100 loop: 4 cel: 4 posn: 25 183 setPri: -1)
				(= cycles 6)
			)
			(1
				(if (not gInnLastHere)
					((ScriptID 117 0) setScript: (ScriptID 117 1) self) ; abdulla, abdullaTalk
				else
					(self cue:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sleepScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 265 135 setMotion: MoveTo 195 135 self)
			)
			(1
				(Face gEgo shameen)
				(client setScript: greetingScript)
			)
		)
	)
)

(instance enterScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 158 250 setMotion: MoveTo 158 185 self)
			)
			(1
				(Face gEgo shameen)
				(= cycles 2)
			)
			(2
				(shameen setCycle: End)
				(= cycles 4)
			)
			(3
				(shameen loop: 1 cel: 0 cycleSpeed: 4 setCycle: Full 1)
				(= cycles 4)
			)
			(4
				(client setScript: greetingScript self)
			)
		)
	)
)

(instance greetingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((or (== gInnLastHere gNow) (IsFlag 161))
						(= cycles 1)
					)
					((and (or (== gTimeODay 4) (== gTimeODay 5)) (== innAction 1))
						(Say shameen self 100 32) ; "It is hoped you enjoyed your first sights of our beautiful city of Shapeir."
					)
					((and (or (== gTimeODay 4) (== gTimeODay 5)) (== innAction 2))
						(Say shameen self 100 33) ; "If you will be seated, then you will see my Shema dance."
					)
					(
						(and
							(== innAction 6)
							(< gInnLastHere 400)
							(or (== gElementalState 1) (== gDay 4))
						)
						(Say shameen self 100 34) ; "Hero-friend, a most strange fire has been seen outside the Inn. Take care as you leave."
					)
					((and (== innAction 7) (== gElementalState 5) (< gInnLastHere 1200))
						(Say shameen self 100 35) ; "I fear, Hero-friend of the Katta, that Shapeir again needs your aid. There is talk that an Elemental of the Earth is destroying the city."
					)
					((== innAction 3)
						(cond
							((== gDay 11)
								(Say shameen self 100 36) ; "The poet has personally asked that you be present tonight, for he wishes to speak with you after his reading."
							)
							((or (== gTimeODay 4) (== gTimeODay 5))
								(Say shameen self 100 37) ; "The poet will soon speak, if you will but be seated."
							)
							(else
								(Say shameen self 100 38) ; "Welcome, Hero."
							)
						)
					)
					((and (== innAction 5) (not (SetFlag 170)))
						(if (== gOrigHeroType 0)
							(Say shameen self (shameen msgFile:) 38 100 39)
						else
							(Say shameen self (shameen msgFile:) 38)
						)
					)
					(else
						(Say shameen self 100 38) ; "Welcome, Hero."
					)
				)
			)
			(1
				(if
					(and
						(or (== gTimeODay 4) (== gTimeODay 5))
						(not (IsFlag 161))
						(< gInnLastHere gNow)
						(or (== gDay 11) (== gDay 16))
					)
					(self setScript: (ScriptID 116 1) self) ; giveReward
				else
					(self dispose:)
				)
			)
			(2
				(gCurRoom setScript: egoSits)
			)
		)
	)
)

(instance egoSits of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gEgo illegalBits: 0)
		(HandsOff)
	)

	(method (dispose)
		(super dispose:)
		(DontTalk 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 25 183 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo
					view: 100
					loop: 4
					cel: 0
					setPri: -1
					cycleSpeed: 1
					setCycle: End
				)
				(if (> (+ (shameen loop:) (shameen cel:)) 0)
					(standTimer dispose:)
					(shameen loop: 0 cel: 3 cycleSpeed: 0 setCycle: Beg)
				)
				(= cycles 20)
			)
			(3
				(cond
					((and (== innAction 4) (< gTimeODay 6))
						(cond
							((== gElementalState 1)
								(Say (ScriptID 117 0) self 100 40) ; "Soon Shapeir will be awash in flames. Hero, you must save us all again!", abdulla
							)
							((and (== gDay 14) (< gInnLastHere 1400))
								(Say (ScriptID 117 0) self 100 41) ; "Alas, again our great city is in peril! The most feared of all Elementals has been unleashed upon us -- the Water Elemental!", abdulla
							)
							((not (or (== gTimeODay 4) (== gTimeODay 5)))
								(= cycles 1)
							)
							((== gDay 1)
								(Say (ScriptID 117 0) self 100 42) ; "Did you have a chance to meet and speak with those in our fair bazaar? It is said there are many rumors in this city (but don't quote me on that).", abdulla
							)
							((== gDay 5)
								(Say (ScriptID 117 0) self 100 43) ; "I must be sure to consult the Astrologer about the Fire Elemental. It must certainly be a bad omen.", abdulla
							)
							((== gDay 14)
								(Say
									(ScriptID 117 0) ; abdulla
									self
									(Format @tempStr 100 44 @gUserName) ; "It is a good thing that you are around to save us, %s."
								)
							)
							(else
								(= cycles 1)
							)
						)
					)
					((and (or (== gTimeODay 4) (== gTimeODay 5)) (== innAction 2))
						(if (IsFlag 161)
							(= cycles 1)
						else
							(= gInnLastHere gNow)
							(gCurRoom newRoom: 112)
						)
					)
					((and (or (== gTimeODay 4) (== gTimeODay 5)) (== innAction 3))
						(if (IsFlag 161)
							(= cycles 1)
						else
							(= gInnLastHere gNow)
							(gCurRoom newRoom: 118)
						)
					)
					(
						(and
							(or
								(< gTimeODay 2)
								(== gTimeODay 4)
								(== gTimeODay 5)
							)
							(not haveOrdered)
						)
						(shema setScript: shemaServes self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(shameen stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance egoStands of Script
	(properties)

	(method (init)
		(super init: &rest)
		(DontTalk 1)
	)

	(method (dispose)
		(HandsOn 1)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cycleSpeed: 1 setCycle: CT 2 -1 self)
				(if (< (shema x:) 240)
					(shemaTimer cue:)
				)
			)
			(1
				(NormalEgo)
				(gEgo setMotion: MoveTo 100 188 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance shemaServes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 1)
				(shema
					view: (if (== whatOrdered 0) 103 else 102)
					setCycle: Walk
					setMotion: PolyPath 40 150 self
					show:
				)
			)
			(1
				(shema loop: 2 setMotion: MoveTo 37 163 self)
			)
			(2
				(= cycles 4)
			)
			(3
				(if (and (not haveOrdered) (== whatOrdered 0))
					(self setScript: putItDown self)
				else
					(shema loop: 5 cel: 0 cycleSpeed: 1 setCycle: End self)
				)
			)
			(4
				(shema cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(switch whatOrdered
					(1
						(Say shema self 100 45) ; "I am here to serve you, Hero."
					)
					(2
						(Say shema self 100 46) ; "Here is your tea."
						(= hasTea 1)
					)
					(3
						(= cycles 1)
					)
					(0
						(= haveOrdered 1)
						(= hasTea 1)
						(if (< gTimeODay 2)
							(MornMsg self)
						else
							(= mealDJour (ChooseFromCycle gDay 1 6))
							(Say
								shema
								self
								(shema msgFile:)
								(+ 38 (- mealDJour 1))
							)
						)
					)
				)
			)
			(6
				(DontTalk 0)
				(StartTimer shemaTimer 20)
				(self dispose:)
			)
		)
	)
)

(instance putItDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shema view: 102 loop: 5 cel: 0)
				(tray init:)
				(= cycles 2)
			)
			(1
				(shema cel: 1)
				(tray y: (+ (tray y:) 2))
				(= cycles 2)
			)
			(2
				(if (!= (shema cel:) 4)
					(= state 1)
					(shema cel: (+ (shema cel:) 1))
					(tray y: (+ (tray y:) 2))
				)
				(= cycles 2)
			)
			(3
				(tray y: (+ (tray y:) 1))
				(self dispose:)
			)
		)
	)
)

(instance shemaLeaves of Script
	(properties)

	(method (dispose)
		(if register
			(DontTalk 0)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(Say shema self 100 47) ; "I will return with a splendid meal for you."
					(shemaTimer dispose:)
					(= next shemaServes)
					(DontTalk 1)
				else
					(self cue:)
				)
			)
			(1
				(shema
					cycleSpeed: 0
					setCycle: Walk
					setMotion: PolyPath 240 117 self
				)
			)
			(2
				(= seconds (if next 5 else 1))
			)
			(3
				(shema hide:)
				(self dispose:)
			)
		)
	)
)

(instance byeScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== innAction 2) (not (IsFlag 161)))
						(gEgo setMotion: 0)
						(Face gEgo shameen)
						(Say shameen self 100 48) ; "Do not forget that Shema dances this night!"
					)
					((and (== innAction 3) (not (IsFlag 161)))
						(gEgo setMotion: 0)
						(Face gEgo shameen)
						(Say shameen self 100 49) ; "The Poet Omar will thrill all who hear with his words of song after the setting of the sun, in our own Inn!"
					)
					(else
						(self changeState: 2)
					)
				)
			)
			(1
				(= cycles 4)
			)
			(2
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 50) self
				)
			)
			(3
				(= gRoomExitDir 4)
				(gCurRoom newRoom: 300) ; rmSPlazaGates
			)
		)
	)
)

(instance shameen of Talker
	(properties
		x 247
		y 158
		description {Shameen}
		lookStr {It is your good friend, Shameen.}
		view 104
		signal 16384
		illegalBits 0
		tLoop 2
		talkSpeed 1
		myName '//shameen,catperson,owner,keeper,innkeeper'
		title {Shameen:}
		color 15
		back 6
		msgFile 104
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'hello,greet') (Said '/hello,greet'))
				(Say self 100 50) ; "We are most honored by your presence at our Inn, Hero of Spielburg."
			)
		)
	)

	(method (atSpec which)
		(return [shameenSpecList which])
	)

	(method (atGen which)
		(return [shameenGenList which])
	)

	(method (messages)
		(standTimer dispose:)
		(if (not (> (+ (shameen loop:) (shameen cel:)) 0))
			(= state -1)
			(self setCycle: End self)
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(super endTalk:)
		(if (> (+ (shameen loop:) (shameen cel:)) 0)
			(StartTimer standTimer 20)
		)
	)
)

(instance standTimer of Timer
	(properties)

	(method (cue)
		(shameen setCycle: Beg)
	)
)

(instance shema of Talker
	(properties
		x 240
		y 117
		description {Shema}
		lookStr {It is your good friend, Shema.}
		view 102
		signal 16384
		illegalBits 0
		tLoop 4
		talkSpeed 1
		myName '//shema,catperson'
		title {Shema:}
		color 14
		back 6
		msgFile 102
	)

	(method (handleEvent)
		(if (< (shema x:) 240)
			(cond
				((super handleEvent: &rest))
				((or (Said 'give/bouquet') (Said 'give//bouquet'))
					(GiveFlowers self 100 51)
				)
				((or (Said 'hello,greet') (Said '/hello,greet'))
					(Say self 100 52) ; "It is always a pleasure to see you, Great Hero."
				)
			)
		)
	)

	(method (atSpec which)
		(return [shemaSpecList which])
	)

	(method (atGen which)
		(return [shemaGenList which])
	)

	(method (showText what)
		(if (== what 0)
			(HighPrint 100 53) ; "Shema looks shyly down and shakes her head."
		else
			(super showText: what &rest)
		)
	)

	(method (messages)
		(if script
			(self setMotion: 0)
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(super endTalk:)
		(if script
			(self setMotion: PolyPath 240 117 script)
		else
			(StartTimer shemaTimer 20)
		)
	)
)

(instance shemaTimer of Timer
	(properties)

	(method (cue)
		(shema setScript: shemaLeaves 0 0)
		(= seconds 0)
	)
)

(instance musician of PicView
	(properties
		x 185
		y 109
		noun '/musician'
		description {the katta musician}
		lookStr {Lively, isn't he?}
		view 302
		loop 1
		signal 16384
	)
)

(instance trim1 of PicView
	(properties
		x 200
		y 34
		shiftClick 0
		view 100
		loop 1
	)
)

(instance trim2 of PicView
	(properties
		x 272
		y 18
		shiftClick 0
		view 100
		loop 1
		cel 1
		priority 12
	)
)

(instance detail1 of PicView
	(properties
		x 61
		y 41
		contClick 0
		view 100
		loop 1
		cel 2
	)
)

(instance detail2 of PicView
	(properties
		x 116
		y 43
		contClick 0
		view 100
		loop 1
		cel 3
	)
)

(instance egoPillow of PicView
	(properties
		x 26
		y 180
		noun '/cushion'
		description {a comfortable pillow}
		view 100
		loop 2
		cel 4
		priority 0
		signal 16400
	)
)

(instance pillow2 of PicView
	(properties
		x 108
		y 142
		noun '/cushion'
		description {a pillow}
		view 100
		loop 2
		cel 6
		priority 0
		signal 16400
	)
)

(instance pillow3 of PicView
	(properties
		x 95
		y 117
		noun '/cushion'
		description {a pillow}
		view 100
		loop 2
		cel 7
		priority 7
		signal 16
	)
)

(instance pillow4 of PicView
	(properties
		x 38
		y 128
		noun '/cushion'
		description {a pillow}
		view 100
		loop 2
		cel 8
		priority 9
		signal 16
	)
)

(instance tassle of PicView
	(properties
		x 92
		y 118
		z 50
		noun '/tassel'
		description {a tassel}
		view 100
		loop 2
		cel 3
	)
)

(instance rope of PicView
	(properties
		x 167
		y 165
		z 100
		noun '/rope,braid'
		description {braided rope}
		view 100
		loop 2
		cel 2
	)
)

(instance tray of View
	(properties
		x 37
		y 152
		noun '/tray'
		description {a tray}
		view 103
		loop 4
		priority 13
		signal 16400
	)
)

(instance shadow1 of PicView
	(properties
		x 8
		y 127
		noun '/customer,customer,customer,man'
		description {a patron of the Inn}
		lookStr {It is a patron of the Inn, drinking and dining, no doubt.}
		view 100
		loop 5
		priority 9
		signal 16
	)
)

(instance shadow2 of PicView
	(properties
		x 72
		y 119
		noun '/customer,dine,customer,man'
		description {a patron of the Inn}
		lookStr {It is a patron of the Inn, drinking and dining, no doubt.}
		view 100
		loop 5
		cel 1
		priority 8
		signal 16
	)
)

(instance shadow3 of PicView
	(properties
		x 126
		y 112
		noun '/customer,dine,customer,man'
		description {a patron of the Inn}
		lookStr {It is a patron of the Inn, drinking and dining, no doubt.}
		view 100
		loop 5
		cel 2
		priority 6
		signal 16
	)
)

(instance egoTable of PicView
	(properties
		x 54
		y 180
		noun '/table'
		description {a table}
		lookStr {It is a low, round table  There is a green pillow on the floor near it.}
		view 100
		priority 13
		signal 16400
	)
)

(instance table1 of PicView
	(properties
		x 132
		y 137
		noun '/table'
		description {a table}
		lookStr {It is one of several low, round tables.}
		view 100
		cel 1
		priority 9
		signal 16
	)
)

(instance table2 of PicView
	(properties
		x 76
		y 115
		noun '/table'
		description {a table}
		lookStr {It is one of several low, round tables.}
		view 100
		cel 3
		priority 8
		signal 16
	)
)

(instance table3 of PicView
	(properties
		x 128
		y 109
		noun '/table'
		description {a table}
		lookStr {It is one of several low, round tables.}
		view 100
		cel 4
		priority 6
		signal 16
	)
)

(instance table4 of PicView
	(properties
		x 17
		y 125
		noun '/table'
		description {a table}
		lookStr {It is one of several low, round tables.}
		view 100
		cel 1
		priority 9
		signal 16
	)
)

(instance oilLamp of PicView
	(properties
		x 280
		y 171
		z 50
		noun '/lamp,bottle[<clear,cup,grease]'
		description {an oil lamp}
		lookStr {It is an oil lamp (batteries not included...or even necessary).}
		view 100
		loop 2
	)
)

(instance brassBottle of PicView
	(properties
		x 297
		y 183
		noun '/bottle[<brass,gold]'
		description {a brass bottle}
		lookStr {It is a large brass bottle.  What a genie it could hold!}
		view 100
		loop 2
		cel 1
	)
)

(instance lamp of View
	(properties
		x 53
		y 182
		z 18
		noun '/lamp,candle'
		description {an oil lamp}
		lookStr {It is an oil lamp.}
		view 100
		loop 2
		cel 9
		priority 13
		signal 17
	)
)

(instance flame1 of Flame
	(properties
		x 53
		y 178
		z 25
		view 100
		loop 3
		signal 16384
	)
)

(instance flame2 of Flame
	(properties
		x 131
		y 137
		z 23
		view 100
		loop 3
		signal 16384
	)
)

(instance tablePoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance shemaPoly of Polygon
	(properties
		type PBarredAccess
	)
)

