;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use Interface)
(use Yoyo)
(use Rev)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm82 0
)

(synonyms
	(virgin face universe death growth birth crone mother)
	(scholar alsirat sirat al man)
	(brew drink)
	(boy hazm)
)

(local
	local0
	local1
	local2
	local3
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

(instance scholarWindow of SysWindow
	(properties
		color 8
		title {Al-Sirat}
		brLeft 140
		brBottom 85
		brRight 300
	)
)

(instance hazmWindow of SysWindow
	(properties
		color 8
		back 11
		title {Hazm ibn Salim}
		brLeft 75
		brBottom 85
		brRight 200
	)
)

(instance Rm82 of Rm
	(properties
		picture 82
		style 0
	)

	(method (init)
		(Load rsVIEW 391)
		(Load rsVIEW 390)
		(Load rsVIEW 182)
		(Load rsVIEW 528)
		(Load rsVIEW 84)
		(Load rsSCRIPT 960)
		(Load rsSCRIPT 969)
		(super init:)
		(= global112 3)
		(SetFlag 91)
		(proc0_13 65)
		(gAddToPics add: table leftRug rightRug doit:)
		(= local4 200)
		(= local6 1)
		(scholar init:)
		(carafe init:)
		(cup init:)
		(mouth init:)
		(blob init:)
		(gTObj
			tLoop: 3
			tWindow: scholarWindow
			cSpeed: 1
			actor: scholar
			init:
		)
		(gEgo
			view: 0
			loop: 1
			posn: 100 77
			ignoreActors: 1
			illegalBits: 0
			init:
			setScript: startUp
		)
		(gRmMusic number: 85 loop: -1 play:)
	)

	(method (doit)
		(cond
			((and (< (gEgo x:) 20) (not local0))
				(= local0 1)
				(gEgo setScript: bounce)
			)
			((and (< (gEgo y:) 84) (not (gEgo script:)))
				(gEgo setScript: outtaHere)
			)
			((and (not (scholar script:)) (not (gEgo script:)))
				(if (== local4 0)
					(= local4 (Random 100 250))
					(if local5
						(= local5 0)
						(scholar loop: 0 cel: 0 cycleSpeed: 2 setCycle: Yoyo 2)
					else
						(= local5 1)
						(scholar loop: 1 cel: 0 cycleSpeed: 2 setCycle: Yoyo 6)
					)
				else
					(-- local4)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and local12 (== (event message:) KEY_RETURN))
				(DrawSand cue:)
				(event claimed: 1)
			)
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
					(Said 'draw/blade')
					(Said 'kill,attack,annihilate/scholar,boy')
				)
				(if (== local6 0)
					(= global125 2)
				)
				(Print 82 0) ; "It seems I must warn you often that such violent urges against those who have done you no wrong will stain your soul and make you unworthy of the Grail."
			)
			((Said 'draw/design')
				(Print 82 1) ; "The scholar may know more about symbols than you."
			)
			((Said 'get,pick/olive')
				(Print 82 2) ; "There are no olives."
			)
			((Said 'talk,ask/boy')
				(Print 82 3) ; "Hazm is not here."
			)
			((or (Said 'go,follow/boy') (Said 'go//boy'))
				(Print 82 4) ; "Perhaps you should stay and seek knowledge from the old scholar."
			)
			(
				(or
					(Said 'look/scholar,(scholar<scholar)')
					(Said 'ask/merlin/scholar,(scholar<scholar)')
					(MouseClaimed scholar event)
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(Print 82 5) ; "His clothing and bearing are simple, yet his words reveal wisdom and complexity. There is no doubt that he is what he says he is."
				(Print 82 6) ; "Even his name, Al-Sirat, is a clue. It is a name for the knife-edged path of truth that one must tread to reach paradise or heaven."
				(Print 82 7) ; "Which means, Arthur, that he invited you here for a specific purpose, one which you must unravel for yourself."
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said '//purpose')
						(Print 82 8) ; "You must unravel his purpose for yourself."
					)
					((Said '<above/wall')
						(Print 82 9) ; "The walls are a bit too high for that."
					)
					((Said '<up')
						(Print 82 10) ; "Overhead, it is open sky."
					)
					((or (Said '<down') (Said '<below/carpet'))
						(Print 82 11) ; "Beneath the colourful mats there is pale, sandy earth."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/courtyard,courtyard')
							(Said '//courtyard,courtyard')
						)
						(Print 82 12) ; "I suspect this is a place of meditation and that Al-Sirat's home is elsewhere."
						(Print 82 13) ; "There is nothing here save four bare walls, plants, the two rugs and a small table with a carafe, cups and a bowl of figs."
					)
					(
						(or
							(Said '/door,portal,hill,mountain,desert')
							(Said '//door,portal,hill,mountain,desert')
						)
						(Print 82 14) ; "Through the open doorway one can see the hills and the high desert."
					)
					((or (Said '/port,gaza') (Said '//port,gaza'))
						(Print 82 15) ; "The serenity of the scholar's courtyard make the port and town of Gaza seem far away."
					)
					((or (Said '/shade,branch') (Said '//shade,branch'))
						(Print 82 16) ; "A tree branch gives some scant shade to this open yard."
					)
					(
						(or
							(MouseClaimed cup event)
							(OnButton event 148 112 153 116)
							(Said '/cup')
							(Said '//cup')
						)
						(Print 82 17) ; "It is a small cup. The carafe must contain a strong drink."
					)
					(
						(or
							(Said '/carafe,beaker,jar,pot,brew,coffee')
							(Said '//carafe,beaker,jar,pot,brew,coffee')
							(MouseClaimed carafe event)
						)
						(if (>= local9 5)
							(Print 82 18) ; "There is no more qahwah in the carafe."
						else
							(Print 82 19) ; "The elegant carafe holds the brew, qahwah, that he prepared for you. From the small size of the cups, it must be quite potent."
						)
					)
					(
						(or
							(Said '/bowl,fig,apple')
							(Said '//bowl,fig,apple')
							(OnButton event 135 116 145 120)
						)
						(if (== local7 5)
							(Print 82 20) ; "There are no more ripe figs in the bowl."
						else
							(Print 82 21) ; "There are ripe figs in the bowl."
						)
					)
					(
						(or
							(Said '/aloe')
							(Said '//aloe')
							(OnButton event 9 130 65 170)
						)
						(Print 82 22) ; "Aye, he has aloe vera growing here. It is a desert plant with a bitter, astringent sap."
					)
					(
						(or
							(Said '/table,stool,tray')
							(Said '//table,stool,tray')
							(OnButton event 125 112 154 127)
						)
						(Print 82 23) ; "It is a low, round, wooden table just large enough to hold the carafe, cups and one bowl."
					)
					(
						(or
							(Said '/tree,planter,olive')
							(Said '//tree,planter,olive')
							(OnButton event 106 41 142 88)
						)
						(Print 82 24) ; "It could be a young olive tree in the planter. Another tree gives some scant shade to this open yard."
					)
					(
						(or
							(Said '/plant,bush')
							(Said '//plant,bush')
							(OnButton event 260 115 310 155)
						)
						(Print 82 25) ; "They seem to be quite ordinary bushes. I believe that is a young tree in the planter."
					)
					(
						(or
							(Said '/carpet,decoration')
							(Said '//carpet,decoration')
							(OnButton event 68 100 126 154)
							(OnButton event 160 103 213 127)
							(OnButton event 180 128 239 155)
						)
						(Print 82 26) ; "The rugs are brightly decorated in abstract patterns."
					)
					(
						(or
							(Said '/wall')
							(Said '//wall')
							(OnButton event 57 23 310 85)
							(OnButton event 25 160 310 182)
							(OnButton event 231 86 310 128)
						)
						(Print 82 27) ; "There are four, plain walls forming this enclosed yard."
					)
					(
						(or
							(Said '/dirt,sand')
							(Said '//dirt,sand')
							(OnButton event 9 83 220 160)
						)
						(Print 82 28) ; "The ground is bone dry and covered with a pale sandy soil."
					)
				)
			)
			((Said 'smell')
				(Print 82 29) ; "The most powerful smell here is that of the qahwah, which is both bitter and oddly pleasant."
			)
			((Said 'stand,(get<up)')
				(if (== local6 0)
					(Print 82 30) ; "Can you not tell when you are on your own two feet?"
				else
					(gEgo setScript: standUp)
				)
			)
			((Said 'sleep,meditate')
				(Print 82 31) ; "It would be better to pay attention, Arthur."
			)
			((Said 'get,buy>')
				(cond
					((Said '/plant,bush')
						(Print 82 32) ; "That would be a silly thing to carry about with you in the desert."
					)
					((Said '/ass')
						(Print 82 33) ; "Al-Sirat has informed you that your mule is being cared for by Hazm. When you leave, she will be there, as usual."
					)
					((Said '/coin')
						(Print 82 34) ; "It should be obvious that this scholar has no money."
					)
					((Said '/grail')
						(Talk 82 35) ; "Only by passing the tests of the Six Guardians will you eventually find the Grail."
					)
					(else
						(event claimed: 1)
						(Print 82 36) ; "Why would you want to do that?"
					)
				)
			)
			((Said 'brew[/coffee,brew]')
				(cond
					((== local9 3)
						(++ local9)
						(Print 82 37) ; "Are you sure, Arthur? The qahwah is a bit TOO invigorating. I fear you may never sleep again."
					)
					((>= local9 5)
						(Talk 82 38) ; "I am sorry, my friend, there is no more."
					)
					(else
						(gEgo setScript: DrinkCup)
					)
				)
			)
			((Said 'give,pour,serve[/cup,coffee,brew,fig,food]/scholar')
				(Talk 82 39) ; "Thank you, I have had my fill."
			)
			((Said 'give,pour,serve/coffee,brew')
				(cond
					(local8
						(Print 82 40) ; "Your cup is full, Arthur."
					)
					((>= local9 5)
						(Talk 82 38) ; "I am sorry, my friend, there is no more."
					)
					(else
						(gEgo setScript: PourCup)
					)
				)
			)
			((Said 'eat[/fig,food]')
				(gEgo setScript: EatFigs)
			)
			((Said 'sat')
				(if (== local6 1)
					(Print 82 41) ; "You ARE sitting, Arthur."
				else
					(gEgo setScript: sitDown)
				)
			)
		)
	)
)

(instance scholar of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 391 loop: 0 cel: 0 posn: 173 127)
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
					(Said 'ask[/scholar]/path<to,for,through<jerusalem,desert')
					(Said
						'ask[/scholar]/direction[<to,for,through<jerusalem,desert]'
					)
				)
				(Talk 82 42) ; "Jerusalem lies northeast of Gaza, but you must pass through the desert to reach it. And you cannot survive the heat of this desert unless you find water upon the way."
			)
			((Said 'thank')
				(Talk 82 43) ; "You are most welcome."
			)
			((Said '/bye')
				(if (== local6 0)
					(Talk 82 44) ; "Farewell."
				else
					(Print 82 45) ; "You must stand up before you can take your leave."
				)
			)
			((Said 'brew/water')
				(gTObj preLoop: 2 tLoop: 3 noWidth: 1)
				(Talk 82 46) ; "My pardons, I have only qahwah for you."
			)
			((Said 'greet')
				(gTObj tLoop: 3 noWidth: 1)
				(Talk 82 47) ; "In the name of the Goddess, I bid you welcome."
			)
			((Said 'talk[/scholar,guardian]')
				(gTObj tLoop: 3 noWidth: 1)
				(Talk 82 48) ; "I am ready to answer what inquiries you put to me. Think carefully and neglect nothing, for you will not see me again once you leave here."
			)
			((Said 'talk,get,call,yell/boy')
				(gTObj tLoop: 3 noWidth: 1)
				(Talk 82 49) ; "When you leave here, he will lead you by secret paths away from Gaza to the edge of the desert that you must cross."
			)
			((Said 'give/coin')
				(gTObj tLoop: 5 noWidth: 1)
				(Talk 82 50) ; "To walk the path that leads to truth and knowledge is all that I desire."
				(proc0_18)
			)
			((Said 'give/ass,lodestone,moneybag,blade,shield')
				(gTObj tLoop: 5 noWidth: 1)
				(Talk 82 51) ; "I cannot accept such a gift, nor do I desire it."
			)
			((Said 'sell,bargain/ass,lodestone,blade,shield')
				(gTObj tLoop: 5 noWidth: 1)
				(Talk 82 52) ; "I have no money, but there are merchants aplenty in Jerusalem."
			)
			((Said 'buy/*')
				(gTObj tLoop: 5 noWidth: 1)
				(Talk 82 53) ; "I have little, and nothing I choose to sell."
			)
			(
				(or
					(Said 'curse,fuck[/scholar,you,guardian]')
					(Said 'eat/shit,me')
				)
				(gTObj tLoop: 5 noWidth: 1)
				(Talk 82 54) ; "No words, however crude or foul, can affect me unless I allow it, which I shall not."
			)
			((Said 'get/direction')
				(gTObj tLoop: 5 noWidth: 1)
				(Talk 82 55) ; "I do not travel in the desert and cannot give you any directions, save that Jerusalem lies northeast of Gaza. But beware, the way through the desert is devious."
			)
			((Said 'get,buy>')
				(cond
					((Said '/water')
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 56) ; "Hazm will pass a well as he leads you from Gaza and there you may drink. Beyond that, I cannot help you."
					)
					((Said '/canteen')
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 57) ; "I have no waterskin to give you, I regret."
					)
					((Said '/goblet,carafe,pot')
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 58) ; "I will not part with my carafe, nor would it serve your purpose."
					)
					((Said '/cup')
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 59) ; "I will not part with my qahwah cups and, delicate as they are, they would not endure your journey."
					)
					((Said '/bowl')
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 60) ; "I will not part with my bowl. It is the only one I have."
					)
					((Said '/carpet')
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 61) ; "I will not part with my rugs. Indeed, what you see here is nearly all I possess."
					)
					((Said '/coffee,brew')
						(cond
							((== local9 3)
								(++ local9)
								(Print 82 37) ; "Are you sure, Arthur? The qahwah is a bit TOO invigorating. I fear you may never sleep again."
							)
							((>= local9 5)
								(Talk 82 38) ; "I am sorry, my friend, there is no more."
							)
							(else
								(gEgo setScript: DrinkCup)
							)
						)
					)
					((Said '/fig,food')
						(gEgo setScript: EatFigs)
					)
				)
			)
			((or (Said 'ask[/scholar,guardian]/*>') (Said 'are<where>'))
				(cond
					((Said '//christian,christ')
						(Talk 82 62) ; "Although many Muslims are tolerant of Christians, the mukhtar of Gaza delights in killing them, or anyone like them."
					)
					((Said '//cup,carafe')
						(if (>= local9 5)
							(Talk 82 63) ; "There is no more qahwah. You seem to have aquired a taste for it quite readily."
						else
							(Talk 82 64) ; "The carafe and the cups are for my qahwah. Please help yourself."
						)
					)
					((Said '//brew,brew,coffee,bean,(tree<coffee)')
						(gTObj preLoop: 2 tLoop: 3 noWidth: 1)
						(Talk 82 65 82 66) ; "Qahwah is a hot drink made from brewing the roasted, crushed beans of the qahwah tree."
					)
					((Said '//fig,food,bowl')
						(gTObj preLoop: 2 tLoop: 3 noWidth: 1)
						(if (== local7 5)
							(Talk 82 67) ; "You have eaten all the figs."
						else
							(Talk 82 68) ; "In the bowl on the table are sweet figs that Hazm picked for me. Please eat them, if you wish."
						)
					)
					((Said '//athena,(design<athena)')
						(= local2 1)
						(= local3 1)
						(self setScript: DrawSand self)
					)
					((Said '//vesta,(design<vesta)')
						(= local2 1)
						(= local3 2)
						(self setScript: DrawSand self)
					)
					((Said '//isis,(design<isis)')
						(= local2 1)
						(= local3 3)
						(self setScript: DrawSand self)
					)
					((Said '//astarte,(design<astarte)')
						(= local2 1)
						(= local3 4)
						(self setScript: DrawSand self)
					)
					((Said '//ceres,(design<ceres)')
						(= local2 1)
						(= local3 5)
						(self setScript: DrawSand self)
					)
					((Said '//venus,(design<venus)')
						(= local2 1)
						(= local3 6)
						(self setScript: DrawSand self)
					)
					((Said '//design')
						(if local1
							(gTObj tLoop: 3 noWidth: 1)
							(Talk 82 69) ; "I will show you the symbol again, if you will name the goddess whose symbol you wish to see."
						else
							(Talk 82 70) ; "There is no symbol to see......yet."
						)
					)
					((Said '//boy')
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 71) ; "He is a good boy and will be a fine scholar one day."
					)
					((or (Said '/ass') (Said '//ass'))
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 72) ; "You need not fear for your mule. Hazm loves animals and will take good care of her until you are ready to depart."
					)
					(
						(or
							(Said
								'//grail,test,regeneration,(cup<sacred,goddess)'
							)
							(Said
								'/grail,test,regeneration,(cup<sacred,goddess)'
							)
						)
						(SetScore 263 1 1)
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 73 82 74) ; "Six Guardians stand between you and this sacred cup. Six times you will be judged, weighed and tested. They will be tests of mind, spirit and body."
					)
					((or (Said '/guardian') (Said '//guardian'))
						(SetScore 271 1 1)
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 75) ; "There are six you must pass. I am the first."
					)
					((Said '//bandit')
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 76) ; "There are always bandits, for there are always men of greed."
					)
					((Said '//heaven,path')
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 77) ; "To reach paradise, one must walk the razor-edged path of truth and purity."
					)
					((Said '//galahad')
						(SetScore 270 1 1)
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 78 82 79) ; "He who came before you searched long and far, yet he did not come here, though I sent Hazm with an invitation."
					)
					((Said '//gawain,lancelot')
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 80) ; "He did not come to this land."
					)
					((Said '//goddess,aphrodite,virgin')
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 81 82 82) ; "The Goddess gave birth to the universe. By many names and faces she is known. As Virgin, Mother and Crone. As Birth, Growth and Death."
					)
					((Said '//6,number')
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 83) ; "Six is the sacred number of Aphrodite."
					)
					((Said '//goddesses,manifestation')
						(gEgo setScript: DrawAllSymbols)
					)
					((or (Said '/gaza') (Said '//gaza'))
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 84) ; "It is not safe for you. You will be wise to avoid it."
					)
					((or (Said '/guide') (Said '//guide'))
						(gTObj tLoop: 4 noWidth: 1)
						(Talk 82 85) ; "There are men who know the desert and where precious water may be found, but there are men who will guide you astray so they may kill and rob you. Be careful who you trust."
					)
					((or (Said '/desert') (Said '//desert'))
						(gTObj tLoop: 4 noWidth: 1)
						(Talk 82 86) ; "It is barren, treacherous and hot as a furnace. I have known of men who cooked eggs upon the rocks at midday."
					)
					((or (Said '/jerusalem') (Said '//jerusalem'))
						(SetScore 272 1 1)
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 42) ; "Jerusalem lies northeast of Gaza, but you must pass through the desert to reach it. And you cannot survive the heat of this desert unless you find water upon the way."
					)
					((or (Said '/zion,(gate<zion)') (Said '//zion,(gate<zion)'))
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 87) ; "The Zion gate is in the southern wall of Jerusalem."
					)
					((or (Said '/jaffa,gate') (Said '//jaffa,gate'))
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 88) ; "The Jaffa gate is in the western wall of Jerusalem and there is no fee to enter it."
					)
					((or (Said '/governer') (Said '//governer'))
						(gTObj tLoop: 4 noWidth: 1)
						(Talk 82 89) ; "He is the official who runs Gaza. He has just come to power and he hates foreigners, especially Christians. You have escaped his notice for now, but Gaza is very dangerous for you."
					)
					((or (Said '/olive') (Said '//olive'))
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 2) ; "There are no olives."
					)
					((or (Said '/water') (Said '//water'))
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 90 82 91) ; "There is water between here and Jerusalem, but I cannot help you to find it."
					)
					((Said '//truth,purity')
						(gTObj tLoop: 3 noWidth: 1)
						(Talk 82 92) ; "The path to truth is as narrow and dangerous as a razor's edge."
					)
					(else
						(event claimed: 1)
						(gTObj tLoop: 5 noWidth: 1)
						(Talk 82 93) ; "Though I am more than willing to answer questions, I will answer only those questions which I deem significant."
					)
				)
			)
		)
	)
)

(instance DrinkCup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local6 0)
					(self setScript: sitDown self)
				else
					(self cue:)
				)
			)
			(1
				(cond
					((== local6 0)
						(HandsOn)
						(self dispose:)
					)
					(local8
						(HandsOff)
						(gEgo loop: 2 cel: 0)
						(= cycles 2)
					)
					(else
						(self setScript: PourCup self)
					)
				)
			)
			(2
				(if (== local6 0)
					(HandsOn)
					(self dispose:)
				else
					(gEgo loop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
					(cup hide:)
				)
			)
			(3
				(= cycles 12)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(= cycles 3)
			)
			(6
				(= local8 0)
				(++ local9)
				(cup show:)
				(gEgo loop: 0 cel: 4)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance PourCup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local6 0)
					(self setScript: sitDown self)
				else
					(HandsOff)
					(= cycles 1)
				)
			)
			(1
				(if (== local6 0)
					(HandsOn)
					(self dispose:)
				else
					(gTObj tLoop: 5 noWidth: 1)
					(if (not local10)
						(= local10 1)
						(Talk 82 94) ; "None for me, thank you."
					)
					(carafe hide:)
					(gEgo loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(carafe show:)
				(= local8 1)
				(gEgo loop: 0 cel: 4)
				(if (== client gEgo)
					(HandsOn)
					(User canControl: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance EatFigs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local7 5)
					(gTObj tLoop: 3 noWidth: 1)
					(Talk 82 95) ; "I am so glad you enjoyed my figs. What a shame there are no more."
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== local6 0)
					(self setScript: sitDown self)
				else
					(HandsOff)
					(= cycles 1)
				)
			)
			(2
				(if (== local6 0)
					(HandsOn)
					(self dispose:)
				else
					(gEgo loop: 3 cel: 0 cycleSpeed: 1 setCycle: End self)
				)
			)
			(3
				(cond
					((== local7 4)
						(local11 setCel: 4)
					)
					((== local7 2)
						((= local11 (View new:))
							view: 182
							loop: 0
							cel: 3
							posn: 140 128
							z: 11
							init:
							stopUpd:
						)
					)
				)
				(gEgo setCycle: CT 1 -1 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo loop: 4 cel: 1)
				(= cycles 2)
			)
			(6
				(gEgo cel: 2)
				(= cycles 5)
			)
			(7
				(gEgo setCycle: Beg)
				(mouth show:)
				(= cycles 18)
			)
			(8
				(mouth hide:)
				(++ local7)
				(gEgo loop: 0 cel: 4)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance DrawAllSymbols of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local6 0)
					(self setScript: sitDown self)
				else
					(self cue:)
				)
			)
			(1
				(gTObj tLoop: 3 talkCue: self)
				(Talk 82 96 82 97) ; "These are the names of the Six Goddesses: Athene, Vesta, Isis, Astarte, Ceres, Venus."
			)
			(2
				(= local2 0)
				(= local3 0)
				(self setScript: DrawSand self)
			)
			(3
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance DrawSand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local6 0)
					(self setScript: sitDown self)
				else
					(self cue:)
				)
			)
			(1
				(scholar loop: 6 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(2
				(cond
					((== local3 0)
						(++ local3)
						(= cycles 1)
					)
					((and local2 (!= local3 7))
						(= cycles 1)
					)
					(else
						(sandSymbol dispose:)
						(scholar
							loop: 8
							cel: 0
							cycleSpeed: 0
							setCycle: Yoyo 6 self
						)
						(blob setCycle: Beg)
					)
				)
			)
			(3
				(if (== local3 7)
					(= cycles 1)
				else
					(scholar loop: 7 cel: 0 cycleSpeed: 1 setCycle: Yoyo 2 self)
					(blob setCycle: End)
				)
			)
			(4
				(scholar loop: 6 cel: 5 cycleSpeed: 0 setCycle: Beg self)
			)
			(5
				(if (== local3 7)
					(gTObj tLoop: 3)
					(= local1 1)
					(HandsOn)
					(User canControl: 0)
					(self dispose:)
				else
					(gTObj actor: 0 noWidth: 1 noTimer: 1)
					(scholar loop: 4 setCycle: Yoyo 2)
					(switch local3
						(1
							(SetScore 264 1 1)
							(Talk 82 98) ; "This is the symbol of Athene."
							(sandSymbol cel: 1 init:)
						)
						(2
							(SetScore 265 1 1)
							(Talk 82 99) ; "This is the symbol of Vesta."
							(sandSymbol cel: 4 init:)
						)
						(3
							(SetScore 266 1 1)
							(Talk 82 100) ; "This is the symbol of Isis."
							(sandSymbol cel: 2 init:)
						)
						(4
							(SetScore 267 1 1)
							(Talk 82 101) ; "This is the symbol of Astarte."
							(sandSymbol cel: 0 init:)
						)
						(5
							(SetScore 268 1 1)
							(Talk 82 102) ; "This is the symbol of Ceres."
							(sandSymbol cel: 5 init:)
						)
						(6
							(SetScore 269 1 1)
							(Talk 82 103) ; "This is the symbol of Venus."
							(sandSymbol cel: 3 init:)
						)
					)
					(= local12 1)
					(++ local3)
				)
			)
			(6
				(= local12 0)
				(User canInput: 0)
				(gTObj actor: scholar noTimer: 0 endTalk:)
				(if local2
					(= local3 7)
				)
				(self changeState: 1)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMenu 1283 112 0)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(if (> (gEgo x:) 112)
					(if (< (gEgo y:) 93)
						(gEgo setMotion: MoveTo (gEgo x:) 94 self)
					else
						(self cue:)
					)
				else
					(self changeState: 2)
				)
			)
			(1
				(if (or (< (gEgo y:) 111) (> (gEgo y:) 128))
					(self cue:)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 110 self)
				)
			)
			(2
				(if (!= (gEgo x:) 112)
					(gEgo setMotion: MoveTo 112 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(3
				(if (!= (gEgo y:) 125)
					(gEgo setMotion: MoveTo 112 125 self)
				else
					(self cue:)
				)
			)
			(4
				(gEgo
					view: 84
					loop: 0
					cel: 0
					priority: 11
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(if (== (self client:) gEgo)
					(HandsOn)
					(User canControl: 0)
				)
				(= local6 1)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 84
					loop: 0
					cel: 4
					cycleSpeed: 0
					setCycle: Beg self
				)
			)
			(1
				(gEgo
					view: 0
					ignoreActors: 0
					illegalBits: -32768
					setCycle: Walk
				)
				(= local6 0)
				(HandsOn)
				(SetMenu 1283 112 1)
				(client setScript: 0)
			)
		)
	)
)

(instance outtaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(1
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:) self
				)
			)
			(2
				(SetFlag 93)
				(scholar setCycle: 0)
				(gRmMusic fade:)
				(gCurRoom newRoom: 36)
			)
		)
	)
)

(instance bounce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -10 (gEgo y:) self)
			)
			(1
				(= seconds 3)
			)
			(2
				(gEgo setMotion: MoveTo 20 (gEgo y:) self)
			)
			(3
				(Print 82 104) ; "There was nothing terribly interesting about that other wall."
				(= local0 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hazm posn: 23 79 setLoop: 7 cel: 0 init:)
				(gEgo setMotion: MoveTo 55 77 self)
			)
			(1
				(gEgo setMotion: MoveTo 45 77 self)
				(hazm setCycle: Rev setMotion: MoveTo 10 79)
			)
			(2
				(gEgo setMotion: MoveTo 44 100 self)
			)
			(3
				(self setScript: sitDown self)
			)
			(4
				(gTObj tLoop: 3 noWidth: 1 talkCue: self)
				(Talk 82 105 82 106 82 107) ; "It is good that you have come. The Captain sent word to me that you were here, though in truth I have been expecting you for some time."
			)
			(5
				(hazm setCycle: Walk setMotion: MoveTo 30 79 self)
			)
			(6
				(hazm setMotion: MoveTo 30 84 self)
			)
			(7
				(gTObj tWindow: hazmWindow actor: 0 talkCue: self)
				(hazm setLoop: 8 cel: 0 setCycle: End)
				(Talk 82 108) ; "Excuse me, Master. I have fed and watered the mule for your guest, as you said."
			)
			(8
				(hazm setCycle: Beg)
				(gTObj tWindow: scholarWindow actor: scholar talkCue: self)
				(Talk 82 109) ; "Thank you, Hazm. Wait with the mule until our guest is ready to leave. Then you will guide him in secret away from Gaza."
			)
			(9
				(hazm setLoop: 7 setCycle: Rev setMotion: MoveTo 30 79 self)
			)
			(10
				(hazm setMotion: MoveTo 10 79 self)
			)
			(11
				(hazm setCycle: 0 dispose:)
				(gTObj talkCue: self)
				(Talk 82 110) ; "I am a scholar. I have spent my life in study and meditation. I am at your disposal, to share what knowledge I may."
			)
			(12
				(DisposeScript 969)
				(gTObj actor: 0 talkCue: self)
				(Talk 82 111) ; "And please, allow me to offer you qahwah to drink and figs to eat. It is simple fare, but all that I have."
				(scholar loop: 2 cycleSpeed: 1 setCycle: Yoyo 2)
			)
			(13
				(scholar loop: 0)
				(gTObj actor: scholar)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sandSymbol of View
	(properties
		y 104
		x 219
		view 528
		priority 15
		signal 16
	)
)

(instance blob of Prop
	(properties
		y 127
		x 160
		view 391
		loop 9
		cycleSpeed 3
	)
)

(instance table of PV
	(properties
		y 128
		x 140
		view 182
		priority 8
		signal -32735
	)
)

(instance leftRug of PV
	(properties
		y 154
		x 94
		view 182
		loop 1
		priority 0
		signal 16384
	)
)

(instance rightRug of PV
	(properties
		y 155
		x 202
		view 182
		loop 1
		cel 1
		priority 0
		signal 16384
	)
)

(instance carafe of Prop
	(properties
		y 114
		x 138
		view 182
		cel 1
		priority 8
		signal 16
	)
)

(instance cup of Prop
	(properties
		y 117
		x 131
		view 182
		cel 2
		priority 8
		signal 16
	)
)

(instance mouth of Prop
	(properties
		y 125
		x 117
		z 21
		view 84
		loop 5
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd hide:)
	)
)

(instance hazm of Act
	(properties
		view 390
		signal 16384
		illegalBits 0
	)
)

