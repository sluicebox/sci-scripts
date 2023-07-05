;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm53 0
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
)

(procedure (localproc_0 param1)
	(if (!= local4 param1)
		(= local4 param1)
		(head cel: param1 forceUpd:)
	)
)

(instance tail of Extra
	(properties
		view 54
		loop 2
		cycleType 1
		minPause 40
		maxPause 90
		minCycles 1
		maxCycles 1
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					(
						(or
							(Said 'ride,ride,attack,hit,cut,kill')
							(Said 'pull/tail')
						)
						(HighPrint 53 0) ; "Looking at the Centaur's muscles, his hoe, and his four gleaming hooves, you get the feeling that hostility is not the best of ideas."
					)
					((Said 'get,get/boulder')
						(HighPrint 53 1) ; "The farmer has painstakingly removed all the rocks from his fields."
					)
					((Said 'throw')
						(HighPrint 53 2) ; "Don't throw things here. The farmer wouldn't appreciate it."
					)
					((Said 'look,look>')
						(cond
							((Said '/centaur,farmer')
								(if local0
									(HighPrint 53 3) ; "The majestic Centaur watches you carefully."
								else
									(HighPrint 53 4) ; "The handsome Centaur has a look of pride and dignity as he rakes his field."
								)
							)
							((Said '/horse')
								(HighPrint 53 5) ; "There's a world of difference between a horse and a Centaur!"
							)
							((Said '/man')
								(HighPrint 53 6) ; "The Centaur is half man, half horse."
							)
							((Said '/hoe')
								(HighPrint 53 7) ; "It is a sturdy iron rake with a wooden handle."
							)
						)
					)
					((Said 'buy,get,get/apple,carrot,produce')
						(if (not local0)
							(centaur setScript: standStill)
							(= local1 1)
							(event claimed: 1)
						else
							(HighPrint 53 8) ; "You must go see my daughter, Hilde, who sells our fruits and vegetables on Market Street."
						)
					)
					((Said 'talk,talk/man,horse,centaur')
						(if (not local0)
							(centaur setScript: standStill)
							(= local1 1)
							(event claimed: 1)
						else
							(HighPrint 53 9) ; "Go ahead. Ask him something."
						)
					)
					((Said 'ask>')
						(if (not local0)
							(centaur setScript: standStill)
							(= local1 1)
							(event claimed: 1)
						else
							(= local7 1)
							(cond
								((Said '//farmer,name,heinrich')
									(HighPrint 53 10) ; "I am Heinrich Pferdefedern. I live in town with my daughter Hilde, who sells our produce on Market Street."
								)
								(
									(Said
										'//elsa,baron,barnard,(barnard,daughter[<baron,about])'
									)
									(HighPrint 53 11) ; "I'm sorry. I know little about the Baron and his family."
								)
								((Said '//filly,daughter')
									(HighPrint 53 12) ; "Hilde is a bright little filly. I'm very proud of her."
								)
								((Said '//centaur')
									(HighPrint 53 13) ; "We Centaurs are a very ancient and proud people."
								)
								((Said '//seed,pod')
									(HighPrint 53 14) ; "It is truly a sight to see."
								)
								((Said '//carrot,produce')
									(HighPrint 53 15) ; "There are a few carrots and potatoes left from last season, but I'm just starting to plant this year's crops."
								)
								(
									(or
										(Said
											'//farm,farm,field,field,harvest,crop,farming,job,labor,labor'
										)
										(Said '//time<harvest')
									)
									(HighPrint 53 16) ; "I can grow enough on this little plot to feed my family and the village. You should see this field at harvest time!"
								)
								((Said '//bandit,robbery,attack,attack')
									(HighPrint 53 17) ; "The brigands attacked me a few months ago. I am a strong fighter and my hooves are deadly, but there were too many of them."
									(HighPrint 53 18) ; "They nearly killed me. My right leg was broken, and there is no pride for a Centaur who cannot run."
									(HighPrint 53 19) ; "If it had not been for the unlikely intervention of their leader, I would be dead."
								)
								((Said '//leader,intervention,death')
									(SolvePuzzle 666 3)
									(HighPrint 53 20) ; "The leader came up while the brigands attacked me and forced them to stop, ordering them not to hurt people from the town."
									(HighPrint 53 21) ; "Then, to my amazement, the leader gave me a Healing Potion and had me carried to the Healer's house."
									(HighPrint 53 22) ; "It was hard to judge the leader, whose face was obscured by a large helm, but there was compassion unlike a brigand."
								)
								((Said '//heal,potion,healer')
									(HighPrint 53 23) ; "The Healer lives just east of here. She is very skilled with potions."
								)
								((Said '//weather,offseason')
									(HighPrint 53 24) ; "The late snow has made the mountains very pretty. Fortunately, our valley is sheltered, so the frost has not come to my fields."
								)
								((Said '//hoe,implement,broom')
									(HighPrint 53 25) ; "Fields must be carefully tended to produce the best crops."
								)
								((Said '//market,street,stand,stand,hamlet')
									(HighPrint 53 26) ; "Our stand is in the northeast corner of Spielburg. The produce is not of the finest this time of year, but you will not find better than Pferdefedern fruit come harvest time."
								)
								((Said '//tree,orchard,apple,beet')
									(HighPrint 53 27) ; "We grow fine fruit in our little orchard, and sell it at our stand in town. There you will find fresh cherries in the spring, peaches in summer, and apples in the fall."
								)
								(else
									(= local7 0)
									(event claimed: 1)
									(HighPrint 53 28) ; "I'm afraid I can't tell you much about that."
								)
							)
							(if (and local7 (event claimed:))
								(SolvePuzzle 665 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance head of View
	(properties
		view 54
		loop 5
	)
)

(instance centaur of Act
	(properties
		view 53
		cycleSpeed 2
		moveSpeed 2
	)
)

(instance rm53 of Rm
	(properties
		picture 53
		horizon 105
		north 36
		east 54
		west 52
	)

	(method (dispose)
		(SetFlag 43)
		(super dispose:)
	)

	(method (init)
		(if (not gNight)
			(Load rsVIEW 53)
			(Load rsVIEW 54)
		)
		(= style
			(switch gPrevRoomNum
				(52 3)
				(54 2)
				(36 5)
				(else 13)
			)
		)
		(super init:)
		(gContMusic fade:)
		(SL enable:)
		(if (IsFlag 323)
			(ClearFlag 323)
		else
			(SetFlag 323)
		)
		(if (not gNight)
			(if (IsFlag 323)
				(centaur posn: 250 135)
			else
				(centaur posn: 120 135)
			)
			(centaur illegalBits: 0 init: setStep: 1 2 setCycle: Walk)
			(if (IsFlag 323)
				(centaur setMotion: MoveTo 120 135)
			else
				(centaur setMotion: MoveTo 250 135)
			)
			(tail init: setPri: 9 ignoreActors: hide:)
			(head init: setPri: 9 ignoreActors: hide:)
		)
		(NormalEgo)
		(gEgo init:)
		(switch gPrevRoomNum
			(36
				(gEgo posn: 140 106 setMotion: MoveTo 140 110)
			)
			(52
				(gEgo posn: 1 140 setMotion: MoveTo 15 140)
			)
			(54
				(gEgo posn: 318 140 setMotion: MoveTo 300 140)
			)
			(else
				(gEgo posn: 160 188 setMotion: MoveTo 160 170)
			)
		)
	)

	(method (doit)
		(cond
			((and (not local6) (< (gEgo y:) 134))
				(= local6 1)
				(gEgo setPri: 8)
			)
			((and local6 (>= (gEgo y:) 134))
				(= local6 0)
				(gEgo setPri: -1)
			)
		)
		(if
			(or
				(and
					(> (centaur x:) 249)
					(not (IsFlag 323))
					(not local0)
					(not gNight)
				)
				(and
					(< (centaur x:) 121)
					(IsFlag 323)
					(not local0)
					(not gNight)
				)
				(and
					(< (gEgo distanceTo: centaur) 50)
					(< 130 (gEgo y:) 150)
					(not local0)
					(not gNight)
				)
			)
			(centaur setScript: standStill)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'japaneseclimbup,climb,climb,climb,climb[/wall]')
						(if gNight
							(if (> (gEgo y:) 150)
								(if (TrySkill 11 35 0) ; climbing
									(gCurRoom newRoom: 334)
								else
									(HighPrint 53 29) ; "Climbing this wall is too difficult for your level of skill. Keep practicing."
								)
							else
								(HighPrint 53 30) ; "You're not in a good spot for climbing the wall."
							)
						else
							(HighPrint 53 31) ; "The town gate is wide open during the day. You would look silly climbing the wall."
						)
					)
					((Said 'look,look>')
						(cond
							((Said '[<up][/sky,cloud,star,moon]')
								(if gNight
									(HighPrint 53 32) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
								else
									(HighPrint 53 33) ; "The sky is a piercing blue with scudding white clouds."
								)
							)
							(
								(or
									(Said '[<at,around][/field,garden]')
									(Said '[<down][/ground]')
								)
								(cond
									(local0
										(HighPrint 53 34) ; "The field is hoed and fertilized."
									)
									(gNight
										(HighPrint 53 35) ; "The garden's dark dirt awaits a new day's sunshine."
									)
									(else
										(HighPrint 53 36) ; "You see a nicely manicured field. A Centaur rakes the rows."
									)
								)
							)
							((Said '/boulder')
								(HighPrint 53 1) ; "The farmer has painstakingly removed all the rocks from his fields."
							)
							((Said '/tree,orchard,apple')
								(HighPrint 53 37) ; "The trees have tiny fruit forming."
							)
							((Said '/forest,birch')
								(HighPrint 53 38) ; "The forest surrounds the farmer's small fields and orchard."
							)
							((Said '/plant,grass')
								(HighPrint 53 39) ; "The crops have yet to be planted. There are only a few weeds and some grasses at edge of the forest."
							)
							((Said '/wall,south')
								(HighPrint 53 40) ; "You can see the roofs of Spielburg beyond the town wall."
							)
							((Said '/east')
								(HighPrint 53 41) ; "You can see a small house."
							)
							((Said '/west')
								(HighPrint 53 42) ; "You see the forest."
							)
							((Said '/north')
								(HighPrint 53 43) ; "Beyond the farmer's orchard, you see the forest."
							)
						)
					)
				)
			)
		)
	)
)

(instance standStill of Script
	(properties)

	(method (doit)
		(cond
			((<= (gEgo x:) (- (centaur x:) 50))
				(localproc_0 0)
			)
			((<= (gEgo x:) (- (centaur x:) 15))
				(localproc_0 1)
			)
			((<= (gEgo x:) (+ (centaur x:) 15))
				(localproc_0 2)
			)
			((<= (gEgo x:) (+ (centaur x:) 60))
				(localproc_0 3)
			)
			(else
				(localproc_0 4)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				(if (< (centaur cel:) 4)
					(centaur setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(centaur
					view: 54
					setLoop: (if (IsFlag 323) 1 else 0)
					cel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(2
				(centaur
					setLoop: 4
					setCel: (if (IsFlag 323) 1 else 0)
					stopUpd:
				)
				(tail
					setLoop: (if (IsFlag 323) 3 else 2)
					posn:
						(if (IsFlag 323)
							(+ (centaur x:) 14)
						else
							(- (centaur x:) 16)
						)
						(- (centaur y:) 30)
					show:
				)
				(head
					posn:
						(if (IsFlag 323)
							(- (centaur x:) 8)
						else
							(+ (centaur x:) 5)
						)
						(- (centaur y:) 39)
					show:
				)
				(= cycles 2)
			)
			(3
				(cond
					(local1
						(if (not local2)
							(= local2 1)
							(HighPrint 53 44) ; "Noticing that you are addressing him, the Centaur stops and gives you his attention."
						else
							(HighPrint 53 45) ; "The Centaur turns toward you."
						)
					)
					((not local3)
						(= local3 1)
						(HighPrint 53 46) ; "The Centaur stops raking as you approach."
					)
				)
				(HandsOn)
			)
		)
	)
)

