;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use n117)
(use n150)
(use n151)
(use Bazaar)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm58 0
	proc58_1 1
)

(local
	[local0 2]
	[local2 2]
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
)

(procedure (localproc_0)
	(Face gEgo farabi)
	(gTObj tWindow: farabiWindow actor: farabi tLoop: 0 cSpeed: 2)
	(Talk &rest)
)

(procedure (proc58_1)
	(Face gEgo hay)
	(gTObj tWindow: hayWindow actor: hay tLoop: (hay loop:) cSpeed: 2)
	(Talk &rest)
)

(procedure (localproc_1)
	(Face gEgo ali)
	(gTObj tWindow: aliWindow actor: ali tLoop: 2 cSpeed: 4)
	(Talk &rest)
)

(instance hangingHerbs of View
	(properties
		y 94
		x 231
		view 358
		loop 3
	)
)

(instance farabiWindow of SysWindow
	(properties
		color 14
		back 3
		title {Farabi ibn Khalid}
		brTop 5
		brLeft 5
		brBottom 85
		brRight 170
	)
)

(instance cat of Prop
	(properties
		y 133
		x 152
		view 158
		loop 2
		cycleSpeed 3
	)
)

(instance hayWindow of SysWindow
	(properties
		color 8
		back 11
		title {Hayyam ibn Aziz}
		brTop 10
		brLeft 80
		brBottom 80
		brRight 250
	)
)

(instance aliWindow of SysWindow
	(properties
		color 15
		back 6
		title {Ali ibn Abdullah}
		brTop 5
		brLeft 160
		brBottom 85
	)
)

(instance bird1 of Act
	(properties
		y 142
		x 275
		view 161
		loop 2
		priority 10
		signal 16400
		cycleSpeed 3
		illegalBits 0
	)
)

(instance bird2 of Act
	(properties
		y 140
		x 303
		view 161
		loop 4
		priority 10
		signal 16400
		cycleSpeed 4
		illegalBits 0
	)
)

(instance bird1MoveTo of MoveTo
	(properties)
)

(instance bird2MoveTo of MoveTo
	(properties)
)

(instance bird1Forward of Fwd
	(properties)
)

(instance bird2Forward of Fwd
	(properties)
)

(instance Rm58 of Rm
	(properties
		picture 58
	)

	(method (init)
		(super init:)
		(= [local0 0] bird1Forward)
		(= [local0 1] bird2Forward)
		(= [local2 0] bird1MoveTo)
		(= [local2 1] bird2MoveTo)
		(Load rsVIEW 357)
		(Load rsVIEW 358)
		(Load rsVIEW 359)
		(self setRegions: 152) ; Bazaar
		(switch gPrevRoomNum
			(61
				(gEgo posn: 300 (gEgo y:) loop: 1)
			)
			(59
				(gEgo posn: (- 320 (gEgo x:)) 180 loop: 3)
			)
			(56
				(gEgo posn: 20 (gEgo y:) loop: 0)
			)
			(else
				(gEgo posn: 150 170)
			)
		)
		(hay init:)
		(farabi init:)
		(ali init:)
		(bird1 init: setScript: (birdFlyUp new:))
		(bird2 init: setScript: (birdFlyUp new:))
		(cat init: setScript: catScript)
		(if (IsItemAt 9) ; herbs | bone
			(gAddToPics add: hangingHerbs)
		)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 61)
			)
			((< (gEgo x:) 20)
				(gCurRoom newRoom: 56)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 59)
			)
		)
		(if
			(and
				(gTObj tCount:)
				(or
					(and
						(== (gTObj actor:) hay)
						(not (gEgo inRect: 124 0 246 200))
					)
					(and
						(== (gTObj actor:) farabi)
						(not (gEgo inRect: 0 0 125 200))
					)
					(and
						(== (gTObj actor:) ali)
						(not (gEgo inRect: 246 0 320 200))
					)
				)
			)
			(gTObj endTalk: actor: 0)
		)
	)

	(method (notify)
		(cond
			((gEgo inRect: 0 0 125 200)
				(Face gEgo farabi)
				(gTObj tWindow: farabiWindow)
			)
			((gEgo inRect: 124 0 246 200)
				(Face gEgo hay)
				(gTObj tWindow: hayWindow)
			)
			((and local5 (gEgo inRect: 246 0 320 200))
				(Face gEgo ali)
				(gTObj tWindow: aliWindow)
			)
			(else
				(return 0)
			)
		)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'look,read/sign,lettering')
					(Said 'ask/merlin/sign,lettering')
				)
				(Print 58 0) ; "Of the Arab and Hebrew writing, I can tell you nothing, but the Latin is easy: "fictilia" refers to pottery, "cetarius" means fishmonger, and "horreum" is a granary."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said 'look<across/street')
						(Print 58 1) ; "Across the street are three merchants."
					)
					(
						(or
							(Said 'look[<around][/!*][/!*]')
							(Said 'look/room,bazaar,street,jerusalem')
							(Said 'ask[/merlin]/room,bazaar,street,jerusalem')
						)
						(Print 58 2) ; "There is a merchant selling pottery, a fishmonger and a grain merchant."
					)
					(
						(or
							(Said '/bird')
							(Said '//bird')
							(MouseClaimed bird1 event)
							(MouseClaimed bird2 event)
						)
						(cond
							((< (bird1 y:) 100)
								(Print 58 3) ; "The birds are perched upon the arch."
							)
							((> (bird1 y:) 135)
								(Print 58 4) ; "Aye, there are birds pecking at dropped grain. Nothing unusual about that."
							)
							(else
								(Print 58 5) ; "You have startled the birds and sent them flying."
							)
						)
					)
					(
						(or
							(Said '/fictilia')
							(Said '//fictilia')
							(OnButton event 26 6 118 41)
						)
						(Print 58 6) ; "It is a pottery shop, though he undoubtedly deals in more than mere ceramics."
					)
					(
						(or
							(Said '/cetarius')
							(Said '//cetarius')
							(OnButton event 153 54 209 66)
							(OnButton event 157 33 224 51)
						)
						(Print 58 7) ; "It is a fishmonger's shop."
					)
					(
						(or
							(Said '/horreum')
							(Said '//horreum')
							(OnButton event 254 18 310 54)
						)
						(Print 58 8) ; "It is a granary."
					)
					((or (Said '/design') (Said '//design'))
						(Print 58 9) ; "The only symbol I see is a stalk of grain on the horreum."
					)
					((or (Said '/cat') (Said '//cat') (MouseClaimed cat event))
						(Print 58 10) ; "Looks like a sleek, well-fed cat with a taste for fish."
					)
					(
						(or
							(Said '/carp')
							(Said '//carp')
							(OnButton event 137 90 170 109)
							(OnButton event 174 95 206 109)
						)
						(Print 58 11) ; "I cannot say what fish they are, but they smell bad enough."
					)
					(
						(and
							(== (event type:) evMOUSEBUTTON)
							(IsItemAt 9) ; herbs | bone
							(OnButton event 223 79 234 95)
						)
						(Print 58 12) ; "The fragrant herbs have certainly improved this part of the bazaar."
					)
					(
						(and
							(gEgo inRect: 246 0 320 200)
							(or
								(Said 'look/business,goods,building')
								(Said 'ask[/merlin]/business,goods,building')
							)
						)
						(Print 58 13) ; "The restless grain merchant has huge jars presumably filled with grain."
					)
					(
						(or
							(OnButton event 259 99 310 135)
							(OnButton event 259 89 273 99)
							(and
								(gEgo inRect: 246 0 320 200)
								(or (Said 'look/jar') (Said 'ask/merlin/jar'))
							)
						)
						(Print 58 14) ; "The huge clay jars are filled with grain."
					)
					(
						(or
							(Said 'look/ali')
							(Said 'ask[/merlin]/ali')
							(and
								(gEgo inRect: 246 0 320 200)
								(or
									(Said 'look/man,(merchant[<grain])')
									(Said 'ask/merlin/man,(merchant[<grain])')
								)
							)
						)
						(Print 58 15) ; "He is a most agitated man."
					)
				)
			)
			((Said '*/bird')
				(Print 58 16) ; "The birds are happy as they are. Leave them alone."
			)
			((Said 'smell')
				(if (IsItemAt 9) ; herbs | bone
					(Print 58 17) ; "The scents from the fishmonger's stall are vastly improved."
				else
					(Print 58 18) ; "The smell of the fishmonger's wares is an assault to the nose."
				)
			)
			(
				(and
					(not (gCast contains: ali))
					(gEgo inRect: 246 0 320 200)
					(or (Said 'get,buy/grain') (Said 'look/merchant,ali'))
				)
				(Print 58 19) ; "The grain merchant will not stop pacing. He is a most agitated man."
			)
		)
	)
)

(instance birdFlyUp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (gEgo inRect: 220 0 320 165))
			(self changeState: 1)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp1 (if (== client bird1) 0 else 1))
				(client
					cycleSpeed: 2
					cel: (Random 0 4)
					setCycle: [local0 temp1]
				)
				(if (gEgo inRect: 220 0 320 165)
					(client posn: (client x:) 54 setCycle: 0 setScript: 0)
				)
			)
			(1
				(= cycles (Random 1 8))
			)
			(2
				(= temp1 (if (== client bird1) 0 else 1))
				(client
					setLoop: 8
					yStep: (Random 3 4)
					cycleSpeed: 0
					setCycle: [local0 temp1]
					setMotion:
						[local2 temp1]
						(- (client x:) (Random 30 40))
						(Random 75 85)
						self
				)
			)
			(3
				(= temp1 (if (== client bird1) 0 else 1))
				(if (< (= temp0 (+ (client x:) (Random 30 40))) 245)
					(= temp0 245)
				)
				(client setLoop: 7 setMotion: [local2 temp1] temp0 46 self)
			)
			(4
				(= temp1 (if (== client bird1) 0 else 1))
				(client
					setLoop: (Random 7 8)
					setMotion: [local2 temp1] (client x:) 54 self
				)
			)
			(5
				(client setLoop: 3 setCel: 0 setCycle: 0 setScript: 0)
			)
		)
	)
)

(instance catEndLoop of End
	(properties)
)

(instance catScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cat setLoop: (Random 0 2) cel: 0 setCycle: catEndLoop self)
			)
			(1
				(cat stopUpd:)
				(= cycles (Random 10 30))
				(= state -1)
			)
		)
	)
)

(instance farabi of Act
	(properties
		y 136
		x 30
		view 357
	)

	(method (init)
		(super init:)
		(farabi stopUpd:)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (gEgo inRect: 0 0 125 200))
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(MouseClaimed self event)
					(Said 'look/farabi')
					(Said 'ask/merlin/farabi')
					(and
						temp0
						(or
							(Said 'look/man,merchant')
							(Said 'ask/merlin/man,merchant')
						)
					)
				)
				(Print 58 20) ; "He is the fattest merchant I have ever seen."
			)
			(
				(or
					(Said 'look/plate,pot,goblet,pot,bowl')
					(OnButton event 65 74 113 140)
				)
				(Print 58 21) ; "The pottery he has on display outside his shop is really quite plain, more for function than pleasure, I would say."
			)
			((Said 'look/jar')
				(Print 58 22) ; "He has a number of earthenware jars on display."
			)
			((not temp0)
				(return)
			)
			((Said 'look/business,goods,building')
				(Print 58 23) ; "His shelves display plain, but well-made pieces of pottery. Probably only his least valuable wares, considering the problem with thieves."
			)
			((Said 'talk[/farabi,man,merchant]')
				(cond
					((IsFlag 137)
						(localproc_0 58 24) ; "Welcome back. Let me know if I may serve you."
					)
					((IsFlag 134)
						(switch local6
							(0
								(localproc_0 58 25 58 26) ; "I have but two wishes in the world. One is that the wind which blows down this street will not change, so that the smell of fish stays away from my shop."
							)
							(else
								(localproc_0 58 27) ; "Please speak if there is anything I might sell you."
							)
						)
						(++ local6)
					)
					(else
						(switch local6
							(0
								(localproc_0 58 28 58 29 58 30) ; "Be not misled by my sign, habib. True, I deal in earthenware -- bowls and plates and jugs and vases for everyday use, but I have richer wares which are not safe to display on this street."
							)
							(else
								(localproc_0 58 31) ; "I am at your service when you know what you want...and can show the coin for it."
							)
						)
					)
				)
				(++ local6)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(if (gEgo has: 3) ; purse
							(localproc_0 58 32) ; "No coin, no sale."
						else
							(event claimed: 0)
						)
					)
					((not local11)
						(localproc_0 58 33) ; "I am not sure what you wish to buy."
						(proc0_18)
					)
					((proc150_0 self self -6 12) 0)
					((< global132 8)
						(localproc_0 58 34) ; "Come, come. That is not enough."
						(proc0_18)
						(= global132 0)
					)
					(else
						(= global132 0)
						(SetScore 0 0 5)
						(gEgo setScript: getMirror)
					)
				)
			)
			(
				(or
					(Said 'get,buy/mirror')
					(Said 'ask[/farabi,merchant,man]/mirror')
				)
				(if (not (IsItemAt 11)) ; mirror | golden_apple
					(localproc_0 58 35) ; "I am most sorry. The mirrors I have left are all promised to ladies of the Sultan's harem."
				else
					(localproc_0 58 36) ; "Certainly! I have a nice mirror for only 2 dirhams."
					(= local11 1)
				)
			)
			((Said 'ask[/farabi,merchant,man]/*>')
				(cond
					((Said '//plate,pot,jar,pot,goblet,bowl')
						(localproc_0 58 37) ; "I have the finest pottery in the city. Nowhere else will you find such quality."
					)
					((Said '//fictilia,business')
						(Print 58 38) ; "I have the finest pottery anywhere."
					)
					((Said '//goods,item,business')
						(localproc_0 58 39) ; "I deal in earthenware -- bowls and plates and jugs and vases for everyday use, but I have richer wares which are not safe to display on this street."
					)
					((Said '//fishmonger,(merchant<carp),carp')
						(localproc_0 58 40) ; "It is strange, is it not, that fish taste fair but smell foul."
					)
					((Said '//ali,(merchant<grain)')
						(localproc_0 58 41) ; "Ali will always find something to complain about."
					)
					((Said '//fictilia')
						(localproc_0 58 42) ; "It is latin for pottery, more or less."
					)
					((Said '//bandit')
						(localproc_0 58 43) ; "A curse upon all thieves!"
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(localproc_0 58 44) ; "I have little to say about that."
					)
				)
			)
			((Said 'get,buy>')
				(cond
					((Said '/carp')
						(localproc_0 58 45) ; "You joke with me. I would not sully my hands with fish."
					)
					((Said '/grain')
						(localproc_0 58 46) ; "Two doors down you will find grain."
					)
					((Said '/(plate<dinar),goblet,(plate<dirham),(bowl<dirham)')
						(Print 58 47) ; "Why would you want to carry around expensive table wares? Concentrate on what you truly need."
					)
					((Said '/plate,pot,jar,pot,goblet,bowl,jug')
						(Print 58 48) ; "It would be a bulky thing to carry about and of no great use. Concentrate on what you truly need."
					)
					(global140
						(event claimed: 1)
						(localproc_0 58 49) ; "I sell only plates, jars, vases, jugs, bowls, goblets, mirrors, and such items."
					)
				)
			)
			((Said 'use,give,show/herb')
				(localproc_0 58 50) ; "Ummm...of what use are these to me?"
			)
			((Said 'give,sell,bargain,show/*>')
				(if
					(or
						(and global140 (gEgo has: global140))
						(and (IsFlag 20) (Said '/ass'))
					)
					(localproc_0 58 51) ; "If you wish to buy, I am at your service. If not, go away."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
				(event claimed: 1)
			)
		)
	)
)

(instance getMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(proc151_0 2 self self)
			)
			(1
				(gTObj talkCue: self)
				(localproc_0 58 52) ; "One moment, habibi."
			)
			(2
				(farabi setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(farabi setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(proc151_0 2 self self)
			)
			(5
				(farabi setLoop: 0)
				(gTObj talkCue: self)
				(localproc_0 58 53) ; "Here you are, a very fine mirror."
			)
			(6
				(gEgo get: 11) ; mirror | golden_apple
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance hay of Act
	(properties
		y 138
		x 220
		view 358
	)

	(method (init)
		(super init:)
		(if (IsItemAt 9) ; herbs | bone
			(hay setLoop: 2)
		)
		(hay stopUpd:)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (gEgo inRect: 124 0 246 200))
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(MouseClaimed self event)
					(Said 'look/fishmonger')
					(Said 'ask/merlin/fishmonger')
					(and
						temp0
						(or
							(Said 'look/man,(merchant[<carp])')
							(Said 'ask/merlin/man,(merchant[<carp])')
						)
					)
				)
				(Print 58 54) ; "He is bent from a lifetime of toil at sea, and burdened with an injury."
			)
			((or (event claimed:) (not temp0))
				(return)
			)
			((or (Said 'look/*>') (Said 'ask/merlin/*>'))
				(cond
					((or (Said '/counter,basket') (Said '//counter,basket'))
						(Print 58 55) ; "The two baskets on his counter are full of fish."
					)
					(
						(or
							(Said '/business,goods,building')
							(Said '//business,goods,building')
						)
						(Print 58 56) ; "The fishmonger is selling fish, of course."
					)
					((or (Said '/jar') (Said '//jar'))
						(Print 58 57) ; "I see no jars in the fishmonger's shop."
					)
				)
			)
			((Said '/cat>')
				(cond
					((Said 'pet,talk,poke')
						(Print 58 58) ; "The cat, in typical cat fashion, ignores you."
					)
					((Said 'feed,give')
						(Print 58 59) ; "It is so well fed by the fishmonger that it utterly ignores you."
					)
					((Said 'hit,kill,attack,press')
						(Print 58 60) ; "That is not the behaviour of a king."
					)
					(else
						(event claimed: 1)
						(Print 58 61) ; "Forget the cat. You have things to do."
					)
				)
			)
			((Said 'talk[/fishmonger,man,merchant]')
				(cond
					((not (IsFlag 134))
						(proc58_1 58 62) ; "Fish for sale! St. Peter's Fish and carp."
					)
					((not (IsItemAt 9)) ; herbs | bone
						(switch local7
							(0
								(proc58_1 58 63 58 64) ; "I want only to sell my fish in peace without the snarls and threats of my neighbors, Ali and Fawaz. They complain that my fish stink, that the wind blows the smell into their shops."
							)
							(else
								(proc58_1 58 65) ; "I will be a happy man only when they leave me in peace."
							)
						)
					)
					(else
						(proc58_1 58 66) ; "Thank you for the herbs, habibi. You are not bad, for a foreigner."
					)
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(if (not (DoPurse))
					(if (gEgo has: 3) ; purse
						(proc58_1 58 67) ; "I can see you are not truly interested in buying fish."
					else
						(event claimed: 0)
					)
				else
					(Print 58 68) ; "Why on earth would you want to carry about a raw, smelly fish?"
					(proc0_18)
				)
			)
			((or (Said 'get,buy/>') (Said 'ask[/fishmonger,man,merchant]/*>'))
				(cond
					((or (Said '/mirror') (Said '//mirror'))
						(proc58_1 58 69) ; "Try Farabi next door."
					)
					((Said '//carp,goods,item,business')
						(proc58_1 58 62) ; "Fish for sale! St. Peter's Fish and carp."
					)
					((Said '/carp')
						(Print 58 68) ; "Why on earth would you want to carry about a raw, smelly fish?"
					)
					((or (Said '/grain') (Said '//grain,ali,(merchant<grain)'))
						(if local4
							(proc58_1 58 70) ; "Did you not notice Ali next door?"
						else
							(proc58_1 58 71) ; "I would direct you next door to Ali, but he is upset over the smell of my fish filling his shop, that he has virtually ceased to do business."
						)
					)
					((Said '/cat')
						(proc58_1 58 72) ; "No, no, my cat is not for sale."
					)
					((Said '//cat')
						(proc58_1 58 73) ; "He is useful enough and I always have scraps he can eat."
					)
					((Said '//cetarius,business')
						(proc58_1 58 74) ; "I have sold fish here all my life, and my father and his fathers before him."
					)
					((Said '//gash,shark,leg')
						(proc58_1 58 75) ; "Ah, it happened long ago. I wrestled with a shark and lost."
					)
					((Said '//farabi,(merchant<plate)')
						(proc58_1 58 76) ; "He sells good pots and is honest enough, as merchants go."
					)
					((Said '//ali,(merchant<grain)')
						(if local4
							(proc58_1 58 77) ; "As you can see, he sells grain."
						else
							(proc58_1 58 78) ; "Ali refuses to sell me grain any more! He does nothing but complain about the smell of my fish."
						)
					)
					((and (IsItemAt 9) (Said '//herb')) ; herbs | bone
						(proc58_1 58 79) ; "They make my neighbors more friendly and will surely improve my business."
					)
					((Said '//cetarius')
						(proc58_1 58 80) ; "The word has always been there above my door. It has something to do with fish, I suppose."
					)
					((Said '//bandit')
						(proc58_1 58 81) ; "I hate thieves. They prey upon me because of my injured leg."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(proc58_1 58 82) ; "I am sorry, habibi, but I cannot help you."
					)
				)
			)
			((and (gEgo has: 9) (Said 'show/herb')) ; herbs | bone
				(proc58_1 58 83) ; "So? What does this mean to me? They do smell fragrant, I must admit."
			)
			((Said 'use,give/herb')
				(if (gEgo has: 9) ; herbs | bone
					(= local12 1)
					(SetScore 0 0 5 2 5)
					(= global185 hay)
					(= global186 hangingHerbs)
					(hangingHerbs init: posn: 500 500)
					(SetFlag 152)
					(gEgo setScript: (ScriptID 206 0)) ; giveHerbs
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give,sell,bargain,show>')
				(cond
					((Said 'sell,bargain/herb')
						(if (gEgo has: 9) ; herbs | bone
							(SetScore 0 2 -5)
							(= global185 hay)
							(= global186 hangingHerbs)
							(SetFlag 136)
							(ClearFlag 152)
							(hangingHerbs init: posn: 500 500)
							(gEgo setScript: (ScriptID 206 0)) ; giveHerbs
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/ass')
						(if (IsFlag 20)
							(proc58_1 58 84) ; "No, no, I do not want it."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((or (not global140) (not (gEgo has: global140)))
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					(else
						(event claimed: 1)
						(proc58_1 58 84) ; "No, no, I do not want it."
					)
				)
			)
		)
	)
)

(instance ali of Act
	(properties
		y 101
		x 285
		view 359
		loop 2
		priority 7
		signal 16
		illegalBits 0
	)

	(method (init)
		(super init:)
		(if (not (= local4 (if (IsItemAt 9) 1 else 0))) ; herbs | bone
			(ali posn: 280 101)
			(ali setScript: pace)
		else
			(ali posn: 285 101 setLoop: 2)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (gEgo inRect: 246 0 320 200))
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(MouseClaimed self event)
					(Said 'look/ali')
					(Said 'ask/merlin/ali')
					(and
						(gEgo inRect: 246 0 320 200)
						(or
							(Said 'look/man,(merchant[<grain])')
							(Said 'ask/merlin/man,(merchant[<grain])')
						)
					)
				)
				(if local4
					(Print 58 85) ; "He looks like an ordinary Arab merchant."
				else
					(Print 58 15) ; "He is a most agitated man."
				)
			)
			((not temp0)
				(return)
			)
			((Said 'talk[/ali,man,merchant]')
				(if local4
					(localproc_1 58 86 58 87) ; "I am most grateful to you for giving Hayyam the herbs. That smell of fish was driving me mad!"
				else
					(Print 58 88) ; "This man is so agitated, he will not stand still long enough to talk to you."
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(cond
					((not (DoPurse))
						(event claimed: 0)
					)
					((not local4)
						(Print 58 89) ; "You cannot even speak to him, let alone give him money."
						(proc0_18)
					)
					((not local9)
						(localproc_1 58 90) ; "Return when you know what you want."
						(proc0_18)
					)
					((gEgo has: 8) ; boar_spear | grain | medallion
						(Print 58 91) ; "You are carrying around quite enough as it is."
						(proc0_18)
					)
					((proc150_0 self self -21 40) 0)
					((<= global132 2)
						(localproc_1 58 92) ; "I must have at least 3 fals, since the bag alone is worth 2 coins. The grain is 1 fals for 1 scoop."
						(proc0_18)
					)
					(else
						(= local9 0)
						(= local10 (- global132 2))
						(= global132 0)
						(SetScore 276 0 5)
						(gEgo setScript: buyGrain)
					)
				)
			)
			((or (Said 'get,buy/>') (Said 'ask[/ali,merchant,man]/>'))
				(cond
					((not local4)
						(event claimed: 1)
						(switch (Random 0 2)
							(0
								(Print 58 93) ; "He will not stop to talk."
							)
							(1
								(Print 58 94) ; "You will have no luck with him."
							)
							(else
								(Print 58 95) ; "If he would ever stand still, you might be able to do business with him."
							)
						)
					)
					((or (Said '/grain') (Said '//grain,goods'))
						(if (gEgo has: 8) ; boar_spear | grain | medallion
							(localproc_1 58 96) ; "One scoop of grain for 1 fals."
						else
							(localproc_1 58 97) ; "One scoop of grain for 1 fals, 2 fals for the bag to carry it in, since I see you have not brought a bag for grain."
						)
						(= local9 1)
					)
					((or (Said '/bag') (Said '//bag'))
						(localproc_1 58 98) ; "I only sell the bags with the grain. Grain is my business, not bags."
					)
					((Said '//fictilia,business')
						(localproc_1 58 99) ; "I bought these grain jars from the pottery merchant. Paid too much for them, that is what I think."
					)
					((Said '//fishmonger,(merchant<carp),carp')
						(localproc_1 58 100) ; "Those herbs had better work for a long time. I will go mad if I have to smell his fish again."
					)
					(global140
						(event claimed: 1)
						(localproc_1 58 101) ; "Eh? Why do you ask me this?"
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(localproc_1 58 102) ; "I cannot help you with that."
					)
				)
			)
			((and (not local4) (Said 'use,give/herb'))
				(Print 58 95) ; "If he would ever stand still, you might be able to do business with him."
			)
			((and local4 (Said 'give,sell,bargain/grain'))
				(localproc_1 58 103) ; "You are a most strange man. I have all these jars full of grain, why should I want grain from you?"
			)
			((Said 'give,sell,bargain,show/*>')
				(cond
					((Said '/ass')
						(cond
							((not (IsFlag 20))
								(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
							)
							(local4
								(localproc_1 58 104) ; "No, thank you."
							)
							(else
								(Print 58 95) ; "If he would ever stand still, you might be able to do business with him."
							)
						)
					)
					((or (not global140) (not (gEgo has: global140)))
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					(local4
						(localproc_1 58 104) ; "No, thank you."
					)
					(else
						(Print 58 95) ; "If he would ever stand still, you might be able to do business with him."
					)
				)
				(event claimed: 1)
			)
		)
	)
)

(instance pace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 61)
					(ali setLoop: 1 posn: 320 (ali y:))
				)
				(ali setLoop: 1 setMotion: MoveTo 270 (ali y:) self)
			)
			(1
				(= seconds 3)
			)
			(2
				(ali setLoop: 0 setMotion: MoveTo 330 (ali y:) self)
			)
			(3
				(ali dispose:)
			)
		)
	)
)

(instance buyGrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(ali
					setLoop: 0
					posn: (ali x:) 101
					setMotion: MoveTo 282 101 self
				)
			)
			(1
				(if local10
					(ali
						setLoop: 4
						cel: 0
						posn: 282 101
						cycleSpeed: 1
						setPri: 10
						setCycle: End self
					)
					(-- state)
					(-- local10)
				else
					(self changeState: 2)
				)
			)
			(2
				(ali setLoop: 5 setPri: -1 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(gEgo
					view: 70
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(4
				(gEgo setCycle: Beg self)
				(ali setCycle: End)
			)
			(5
				(gEgo view: 0 loop: 3 cycleSpeed: 0)
				(gTObj talkCue: self tWindow: aliWindow actor: 0)
				(Talk 58 105) ; "Here is your grain."
			)
			(6
				(ali setLoop: 2 cel: 0)
				(gEgo get: 8) ; boar_spear | grain | medallion
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

