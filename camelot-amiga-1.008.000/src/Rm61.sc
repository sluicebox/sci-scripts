;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use n151)
(use Bazaar)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	Rm61 0
)

(synonyms
	(achmed achmed)
)

(local
	[local0 3]
	[local3 3]
	local6
	local7
	local8
	local9
	local10
	local11
)

(procedure (localproc_0)
	(gEgo loop: 3 setMotion: 0)
	(if (& (achHead signal:) $0080)
		(achHead posn: (ach x:) (ach y:) 37 show:)
	)
	(gTObj tWindow: achWindow actor: achHead tLoop: 4 cSpeed: 2)
	(Talk &rest)
)

(instance bird1 of Act
	(properties
		y 140
		x 28
		view 161
		loop 1
		priority 10
		signal 16400
		cycleSpeed 3
		illegalBits 0
	)
)

(instance bird2 of Act
	(properties
		y 138
		x 63
		view 161
		loop 2
		priority 10
		signal 16400
		cycleSpeed 4
		illegalBits 0
	)
)

(instance bird3 of Act
	(properties
		y 138
		x 14
		view 161
		loop 3
		priority 10
		signal 16400
		cycleSpeed 3
		illegalBits 0
	)
)

(instance bird1MoveTo of MoveTo
	(properties)
)

(instance bird2MoveTo of MoveTo
	(properties)
)

(instance bird3MoveTo of MoveTo
	(properties)
)

(instance bird1Forward of Fwd
	(properties)
)

(instance bird2Forward of Fwd
	(properties)
)

(instance bird3Forward of Fwd
	(properties)
)

(instance achHead of Prop
	(properties
		z 37
		view 364
		loop 4
		signal 16384
	)
)

(instance innDoor of Prop
	(properties
		y 132
		x 127
		view 161
	)

	(method (init)
		(super init:)
		(self setScript: doorScript)
	)

	(method (cue param1)
		(if (!= local9 param1)
			(= local9 param1)
			((self script:)
				changeState:
					(switch local9
						(0 1)
						(1 2)
						(2 3)
					)
			)
			(if (!= local9 0)
				(self setPri: 8)
			else
				(self setPri: -1)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(innDoor ignoreActors: 0 setCycle: Beg stopUpdDoor)
			)
			(2
				(innDoor setCycle: CT 2 1)
			)
			(3
				(innDoor ignoreActors: setCycle: CT 4 1)
			)
		)
	)
)

(instance stopUpdDoor of Script
	(properties)

	(method (cue)
		(innDoor stopUpd:)
	)
)

(instance achWindow of SysWindow
	(properties
		color 12
		back 1
		title {Achmed ibn Yahya}
		brTop 5
		brLeft 70
		brBottom 75
		brRight 300
	)
)

(instance Rm61 of Rm
	(properties
		picture 61
	)

	(method (init)
		(super init:)
		(Load rsVIEW 161)
		(Load rsVIEW 62)
		(gEgo illegalBits: -16384)
		(self setRegions: 152) ; Bazaar
		(switch gPrevRoomNum
			(62
				(gEgo posn: (- 320 (gEgo x:)) 180 loop: 3)
			)
			(66
				(gEgo posn: 300 (gEgo y:) loop: 1)
			)
			(58
				(gEgo posn: 20 (gEgo y:) loop: 0)
			)
			(else
				(gEgo posn: 130 150 loop: 2)
			)
		)
		(innDoor init: stopUpd:)
		(= local9 0)
		(ach init:)
		(if (Random 0 1)
			(bird1 init: setScript: (birdFlyUp new:))
		)
		(if (Random 0 1)
			(bird2 init: setScript: (birdFlyUp new:))
		)
		(if
			(or
				(Random 0 1)
				(not (and (gCast contains: bird1) (gCast contains: bird2)))
			)
			(bird3 init: setScript: (birdFlyUp new:))
		)
		(= [local0 0] bird1Forward)
		(= [local0 1] bird2Forward)
		(= [local0 2] bird3Forward)
		(= [local3 0] bird1MoveTo)
		(= [local3 1] bird2MoveTo)
		(= [local3 2] bird3MoveTo)
		(if (not (IsItemAt 9 58)) ; herbs | bone
			(ali init:)
		)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo x:) 300)
				(gCurRoom newRoom: 66)
			)
			((< (gEgo x:) 20)
				(gCurRoom newRoom: 58)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 62)
			)
		)
	)

	(method (notify)
		(cond
			((and (!= local9 0) (gEgo inRect: 80 0 260 200))
				(Face gEgo ach)
				(gTObj tWindow: achWindow)
			)
			((gCast contains: ali)
				(return 0)
			)
			(else
				(return -1)
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
					(Said 'look,read/sign,lettering,design')
					(Said 'ask[/merlin]/sign,lettering,design')
					(OnButton event 118 27 181 63)
				)
				(Print 61 0) ; ""Caupona" is the Latin for "inn" or "tavern". If I interpret the symbol below correctly, this is the "Star of Allah Inn"."
			)
			(
				(or
					(and (gCast contains: ali) (MousedOn ali event))
					(Said '*/ali')
					(Said '//ali')
					(and
						(gEgo inRect: 0 0 80 200)
						(or
							(Said '*/merchant,man')
							(Said '*//merchant,man')
							(Said 'get,buy,bargain,sell,ask/*')
						)
					)
				)
				(Print 61 1) ; "The grain merchant's agitation is so great, he will not stand still long enough to speak or do business."
			)
			((or (== (event type:) evMOUSEBUTTON) (Said 'look,ask,(are<where)>'))
				(cond
					((Said 'look<across/street')
						(Print 61 2) ; "Across the street are two merchants."
					)
					(
						(or
							(Said 'look[<around][/!*][/!*]')
							(Said 'look/room,bazaar,street,jerusalem')
							(Said 'ask[/merlin]/room,bazaar,street,jerusalem')
						)
						(Print 61 3) ; "Next to the grain merchant's shop, there is an inn."
					)
					(
						(or
							(Said '/jar')
							(Said '//jar')
							(OnButton event 13 97 53 133)
						)
						(Print 61 4) ; "The huge clay jars are filled with grain."
					)
					(
						(and
							(gEgo inRect: 0 0 80 200)
							(or
								(Said 'look/business,goods,building')
								(Said 'ask[/merlin]/business,goods,building')
							)
						)
						(Print 61 5) ; "The restless grain merchant has huge jars presumably filled with grain."
					)
					(
						(or
							(Said '/caupona,star,allah,building')
							(Said '//caupona,star,allah,building')
						)
						(switch local9
							(0
								(Print 61 6) ; "It is a rather rundown place."
							)
							(1
								(Print 61 7) ; "You cannot see inside with Achmed blocking the door."
							)
							(else
								(Print 61 8) ; "Dare I say it? The inside does not look like an improvement on the outside. Still, he is offering his hospitality."
							)
						)
					)
					((OnButton event 124 14 174 25)
						(Print 61 9) ; "My Arabic is not quite good enough to translate that."
					)
					(
						(or
							(Said '/door')
							(Said '//door')
							(OnButton event 126 77 173 135)
						)
						(switch local9
							(0
								(Print 61 10) ; "The door is shut, to state the obvious."
							)
							(1
								(Print 61 11) ; "The door is partway open."
							)
							(else
								(Print 61 12) ; "The door is open. You should either enter or move on."
							)
						)
					)
					((OnButton event 217 13 269 40)
						(Print 61 13) ; "Nothing can be seen through these windows."
					)
					(
						(or
							(Said '<(in,through)/shutter,window')
							(OnButton event 204 105 226 108)
						)
						(Print 61 14) ; "It is too dim inside to make out much more than some crude tables and chairs."
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 195 80 265 120)
						)
						(Print 61 15) ; "The shutters are closed."
					)
					(
						(or
							(Said '/alley,jerusalem,crack')
							(Said '//alley,jerusalem,crack')
							(OnButton event 82 77 104 134)
						)
						(Print 61 16) ; "It is not so much an alley as a gap between the buildings that is walled off. You can glimpse more back streets of Jerusalem, but nothing that is of use to you."
					)
					((and (Said 'ask,where,what>') (not (Said '/merlin>')))
						(if (== local9 0)
							(event claimed: 1)
							(Print 61 17) ; "There is no one here to ask."
						)
					)
					(
						(or
							(Said '/bird')
							(and
								(== (event type:) evMOUSEBUTTON)
								(or
									(and
										(gCast contains: bird1)
										(MouseClaimed bird1 event)
									)
									(and
										(gCast contains: bird2)
										(MouseClaimed bird2 event)
									)
									(and
										(gCast contains: bird3)
										(MouseClaimed bird3 event)
									)
								)
							)
						)
						(switch local11
							(0
								(Print 61 18) ; "The birds peck at grain spilt over from the merchant's pots."
							)
							(1
								(Print 61 19) ; "You startled the birds into flight."
							)
							(else
								(Print 61 20) ; "The birds perch on the ledge, waiting for you to leave."
							)
						)
					)
				)
			)
			((Said '*/bird')
				(Print 61 21) ; "The birds are happy as they are. Leave them alone."
			)
			((Said '*/ali')
				(Print 61 22) ; "He stands on the other side of his shop."
			)
			((Said 'draw/blade')
				(if (!= local9 0)
					(gEgo setScript: slamDoor)
				else
					(event claimed: 0)
				)
			)
			((Said 'get,buy,give,bargain,sell,show/*')
				(Print 61 23) ; "Are you confused? There is no one here."
			)
			((Said 'smell')
				(if (!= local9 0)
					(Print 61 24) ; "It does not smell particularly inviting inside."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance birdFlyUp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (gEgo inRect: 0 0 120 165))
			(self changeState: 1)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local11 0)
				(= temp1
					(cond
						((== client bird1) 0)
						((== client bird2) 1)
						(else 2)
					)
				)
				(client cycleSpeed: 2 setCycle: [local0 temp1])
				(if (gEgo inRect: 0 0 120 165)
					(= local11 2)
					(client posn: (client x:) 54 stopUpd: setScript: 0)
				)
			)
			(1
				(= cycles (Random 1 8))
			)
			(2
				(= temp1
					(cond
						((== client bird1) 0)
						((== client bird2) 1)
						(else 2)
					)
				)
				(= local11 1)
				(client
					setLoop: 7
					yStep: (Random 3 4)
					cycleSpeed: 0
					setCycle: [local0 temp1]
					setMotion:
						[local3 temp1]
						(+ (client x:) (Random 30 40))
						(Random 75 85)
						self
				)
			)
			(3
				(= temp1
					(cond
						((== client bird1) 0)
						((== client bird2) 1)
						(else 2)
					)
				)
				(if (> (= temp0 (- (client x:) (Random 30 40))) 65)
					(= temp0 55)
				)
				(client setLoop: 8 setMotion: [local3 temp1] temp0 46 self)
			)
			(4
				(= temp1
					(cond
						((== client bird1) 0)
						((== client bird2) 1)
						(else 2)
					)
				)
				(client
					setLoop: (Random 7 8)
					setMotion: [local3 temp1] (client x:) 54 self
				)
			)
			(5
				(= local11 2)
				(client setLoop: 3 setCel: 0 setCycle: 0 stopUpd: setScript: 0)
			)
		)
	)
)

(instance ach of Act
	(properties
		y 130
		x 166
		view 364
		signal 16384
		illegalBits 0
	)

	(method (init)
		(super init:)
		(if (IsItemAt 6) ; iron_key | broom | grail
			(ach posn: 157 127)
		)
		(ach setPri: 8 stopUpd:)
		(achHead posn: (ach x:) (ach y:) setPri: 8 init:)
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
					(and (!= local9 0) (MouseClaimed self event))
					(Said 'look/achmed')
					(Said 'ask/merlin/achmed')
					(and
						(gEgo inRect: 80 0 260 200)
						(or (Said 'look/man') (Said 'ask/merlin/man'))
					)
				)
				(if (!= local9 0)
					(Print 61 25) ; "Achmed looks as rundown as his inn."
				else
					(Print 61 26) ; "I do not see him."
				)
			)
			((Said 'open/door')
				(switch local9
					(0
						(gEgo setScript: tryToOpenDoor)
					)
					(1
						(Print 61 27) ; "Achmed would let you in if he so desired."
					)
					(else
						(Print 61 28) ; "Well? Will you enter or not?"
					)
				)
			)
			((Said 'open/window,shutter')
				(Print 61 29) ; "These windows cannot be opened from the outside."
			)
			((Said 'knock[/door]')
				(if (== local9 0)
					(gCurRoom setScript: knockOnDoor)
				else
					(Print 61 30) ; "The door is already open."
				)
			)
			((not (gEgo inRect: 80 0 260 200))
				(return)
			)
			((Said 'talk[/achmed,man]')
				(switch local9
					(0
						(Print 61 31) ; "Talking to the door will not help."
					)
					(1
						(SetFlag 141)
						(localproc_0 61 32) ; "Believe me, I regret I cannot serve you. If only I had a broom."
					)
					(else
						(localproc_0 61 33) ; "Please enter, habibi. Allow me to show my gratitude by giving you food and drink while I clean up."
					)
				)
			)
			((Said 'call,yell[/achmed,man]')
				(Print 61 34) ; "Perhaps he cannot hear you call."
			)
			((Said 'ask[/achmed,man]/*>')
				(cond
					((== local9 0)
						(event claimed: 0)
					)
					((Said '//broom')
						(switch local9
							(1
								(localproc_0 61 35) ; "Ah, I am in desperate need of a broom!"
							)
							(2
								(localproc_0 61 36) ; "Thank you so very much for the broom, habibi!"
							)
						)
					)
					((Said '//tariq,cousin,(merchant<lamp)')
						(if (not (IsItemAt 6)) ; iron_key | broom | grail
							(localproc_0 61 37) ; "My cousin Tariq is angry with me and will not sell me a broom!"
						else
							(localproc_0 61 38) ; "I never believed my cousin would give me the broom. Allah be praised!"
						)
					)
					((Said '//caupona')
						(if (not (IsItemAt 6)) ; iron_key | broom | grail
							(localproc_0 61 39) ; "My inn is filthy. Only with a broom can I properly clean it."
						else
							(localproc_0 61 40) ; "Come in! Come in! I am still cleaning, but you are welcome."
						)
					)
					((Said '//sign,design')
						(localproc_0 61 41) ; "It is the name of my inn, the 'Star of Allah.'"
					)
					((Said '//caupona')
						(localproc_0 61 42) ; "The name of my inn is 'The Star of Allah.' Caupona means inn, habib."
					)
					((Said '//bandit')
						(localproc_0 61 43) ; "I do my best to keep them out of my inn."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(if (not (IsItemAt 6)) ; iron_key | broom | grail
							(localproc_0 61 44) ; "If I only had a broom, I would help you."
						else
							(localproc_0 61 45) ; "I cannot help you with that, but you can surely stay at my inn."
						)
					)
				)
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(if (gEgo has: 3) ; purse
					(switch local9
						(1
							(localproc_0 61 46) ; "As much as I would like to take your money, I cannot think of serving you until I can clean my inn."
							(proc0_18)
						)
						(2
							(localproc_0 61 47) ; "I could never take your money, habibi. I am in your debt."
							(proc0_18)
						)
						(else
							(event claimed: 0)
						)
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'give,show/broom')
				(switch local9
					(2
						(Print 61 48) ; "But he has the broom."
					)
					(1
						(SetScore 0 0 5 2 5)
						(= local8 1)
						(gEgo setScript: giveBroom)
					)
					(else
						(Print 61 49) ; "There is no one here."
					)
				)
			)
			((Said 'sell,bargain/broom')
				(switch local9
					(2
						(Print 61 48) ; "But he has the broom."
					)
					(1
						(SetScore 0 2 -5)
						(= local8 0)
						(SetFlag 148)
						(SetFlag 136)
						(gEgo setScript: giveBroom)
					)
					(else
						(Print 61 49) ; "There is no one here."
					)
				)
			)
			((Said 'get,buy/broom')
				(cond
					((== local9 0)
						(Print 61 49) ; "There is no one here."
					)
					((IsItemAt 6) ; iron_key | broom | grail
						(localproc_0 61 50) ; "I will never part with this broom!"
					)
					(else
						(localproc_0 61 51) ; "Would that I HAD a broom!"
					)
				)
			)
			((Said 'give,sell,bargain/ass')
				(cond
					((and (!= local9 1) (!= local9 2))
						(event claimed: 0)
					)
					((IsFlag 20)
						(localproc_0 61 52) ; "No, thank you."
					)
					(else
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
				)
			)
			((Said 'give,show')
				(if (or (not global140) (not (gEgo has: global140)))
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(switch local9
						(1
							(localproc_0 61 53) ; "Your generosity does you credit, but if I could have anything, I would only desire a broom."
						)
						(2
							(localproc_0 61 54) ; "I could not take another gift. I am in your debt already."
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
			((and (!= local9 0) (Said 'sell,bargain'))
				(if (or (not global140) (not (gEgo has: global140)))
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(localproc_0 61 55) ; "Perhaps later, when I recover my losses from being closed for so long."
				)
			)
			((and (!= local9 0) (Said 'get,buy/'))
				(if (or (not global140) (not (gEgo has: global140)))
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				else
					(localproc_0 61 56) ; "One of the merchants on this street could doubtless sell you that."
				)
			)
		)
	)
)

(instance tryToOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 150 140 self)
			)
			(1
				(gEgo loop: 3)
				(= seconds 2)
			)
			(2
				(if (not local6)
					(Print 61 57) ; "Odd that the inn should be locked."
					(= local6 1)
				else
					(Print 61 58) ; "It is still locked."
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance knockOnDoor of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((< state 7) 0)
			((not (gEgo inRect: 105 120 200 160))
				(HandsOff)
				(= cycles (= seconds 0))
				(self changeState: 5)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND (proc0_20 83))
				(if (not (gEgo inRect: 140 130 160 141))
					(gEgo setCycle: Walk setMotion: MoveTo 150 140 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 62
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(gSFX number: (proc0_20 83) loop: 1 play:)
			)
			(2
				(gEgo setCel: 0 setCycle: End self)
			)
			(3
				(gEgo view: 0 cycleSpeed: 0 loop: 3 setCycle: Walk)
				(if (not (IsFlag 148))
					(innDoor cue: 1)
				)
				(= cycles 1)
			)
			(4
				(cond
					((IsFlag 148)
						(Print 61 59) ; "Achmed is surely busy sweeping his floor. I doubt he will answer you."
						(self changeState: 6)
					)
					((IsItemAt 6) ; iron_key | broom | grail
						(client setScript: 0)
						(= local10 0)
						(HandsOn)
						(client setScript: enterInn)
					)
					((not (IsFlag 134))
						(gTObj talkCue: self)
						(localproc_0 61 60) ; "I am not open for business. Go away."
					)
					((not (gEgo has: 6)) ; iron_key | broom | grail
						(gTObj talkCue: self)
						(localproc_0 61 61 61 62) ; "I cannot open my shop. For weeks I have been without a broom and now I am overcome with filth. All because my cousin, Tariq, is angry with me and will not sell me a broom for any amount of coin. And I offered good money just for a broom!"
					)
					(else
						(self changeState: 7)
					)
				)
			)
			(5
				(innDoor cue: 0)
				(= seconds 2)
			)
			(6
				(HandsOn)
				(client setScript: 0)
			)
			(7
				(gTObj talkCue: self)
				(localproc_0 61 63) ; "I am sorry, but without a broom, I cannot open for business."
			)
			(8
				(HandsOn)
				(= seconds 15)
			)
			(9
				(gTObj talkCue: self)
				(localproc_0 61 64) ; "Did you want something else? I thought you did."
			)
			(10
				(= seconds 10)
			)
			(11
				(gTObj endTalk:)
				(self changeState: 5)
			)
		)
	)
)

(instance enterInn of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((> state 2) 0)
			((<= (gEgo y:) 135)
				(= cycles (= seconds 0))
				(self changeState: 5)
			)
			((not (gEgo inRect: 105 120 200 160))
				(HandsOff)
				(= cycles (= seconds 0))
				(self changeState: 3)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: -32768)
				(if (not local10)
					(localproc_0 61 65) ; "Welcome, habibi, welcome! Come in!"
				else
					(= local10 0)
					(localproc_0 61 66) ; "Until then, may I offer you the hospitality of my humble inn. Excuse the mess on the floor. I will clean it while you eat and drink at no charge."
				)
				(= cycles 2)
			)
			(1
				(if (and (!= (ach x:) 155) (!= (ach y:) 127))
					(achHead hide:)
					(ach
						setLoop: 5
						setCel: 0
						setCycle: Walk
						setMotion: MoveTo 155 127 self
					)
				else
					(= cycles 10)
				)
				(innDoor cue: 2)
			)
			(2
				(HandsOn)
				(ach setLoop: 2 cel: 0 setPri: 8)
				(= seconds 15)
			)
			(3
				(HandsOff)
				(innDoor cue: 0)
				(if (< (gEgo y:) 140)
					(gEgo setMotion: MoveTo (gEgo x:) 140)
				)
				(= seconds 2)
			)
			(4
				(self changeState: 15)
			)
			(5
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 183 128 self
				)
			)
			(6
				(innDoor cue: 0)
				(= cycles 8)
			)
			(7
				(gEgo hide:)
				(ach hide:)
				(achHead hide:)
				(= cycles 16)
			)
			(8
				(if (IsFlag 147)
					(self changeState: 11)
				else
					(= cycles 1)
				)
			)
			(9
				(if (gCast contains: bird1)
					(bird1 hide:)
				)
				(if (gCast contains: bird2)
					(bird2 hide:)
				)
				(if (gCast contains: bird3)
					(bird3 hide:)
				)
				(innDoor startUpd:)
				(MenuBar state: 0)
				(DrawPic 61 8 1 1)
				(proc0_13 81)
				(gAddToPics doit:)
				(= seconds 10)
			)
			(10
				(Print 61 67) ; "You have eaten well and spent a restless night being bitten by bedbugs and dreaming about Camelot, Gwenhyver, and the Grail."
				(Print 61 68) ; "A new sense of urgency fills you. The land and the people will not survive much longer unless you can find the Grail!"
				(DrawPic 61 8 1 0)
				(MenuBar state: 1)
				(proc0_13 81)
				(gAddToPics doit:)
				(if (gCast contains: bird1)
					(bird1 show:)
				)
				(if (gCast contains: bird2)
					(bird2 show:)
				)
				(if (gCast contains: bird3)
					(bird3 show:)
				)
				(self cue:)
			)
			(11
				(ach show:)
				(= local9 2)
				(innDoor setPri: 9 setCycle: CT 4 1)
				(gEgo
					show:
					loop: 2
					posn: 180 128
					setMotion: MoveTo 150 128 self
				)
			)
			(12
				(gEgo setMotion: MoveTo 145 140 self)
			)
			(13
				(innDoor cue: 0)
				(gEgo ignoreActors: 1 setMotion: MoveTo 140 150 self)
			)
			(14
				(innDoor stopUpd:)
				(ach posn: 166 130 show: stopUpd:)
				(if (IsFlag 147)
					(Print 61 69) ; "Good, I am glad you have the sense not to dally at an inn when your entire kingdom is at stake."
				else
					(Print 61 70) ; "I can see why you did not remain. You have gotten more flea bites from this brief visit than in all your years in Camelot."
					(SetFlag 147)
				)
				(= cycles 8)
			)
			(15
				(gEgo ignoreActors: 0 illegalBits: -16384)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance slamDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(innDoor cue: 0)
				(gCurRoom setScript: 0)
				(gEgo view: 4 setCel: 255 setCycle: Beg)
				(= seconds 3)
			)
			(1
				(gEgo view: 0 setCycle: Walk)
				(if (< (gEgo y:) 140)
					(gEgo setMotion: MoveTo (gEgo x:) 140 self)
				else
					(= cycles 2)
				)
			)
			(2
				(gEgo illegalBits: -16384)
				(= global124 0)
				(Print 61 71) ; "Do you think you could possibly stop blundering around terrifying the natives long enough to do what you are supposed to be doing?"
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance giveBroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom setScript: 0)
				(gEgo setMotion: MoveTo 148 140 self)
			)
			(1
				(gEgo loop: 3)
				(if local8
					(= cycles 8)
				else
					(gTObj talkCue: self)
					(localproc_0 61 72) ; "How clever of you to somehow convince Tariq to sell the broom. Here, I gladly give you a dirham for it."
				)
			)
			(2
				(proc151_0 2 self self)
			)
			(3
				(achHead hide:)
				(ach
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setPri: 9
					setCycle: End self
				)
			)
			(4
				(ach setLoop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(ach setLoop: 2 setCel: 0)
				(PutItem 6) ; iron_key | broom | grail
				(SetFlag 154)
				(++ global146)
				(if local8
					(= cycles 8)
				else
					(ach setPri: 8)
					(++ global121)
					(self changeState: 8)
				)
			)
			(6
				(gTObj talkCue: self)
				(localproc_0 61 73 61 74) ; "Ya'Allah! You have managed to part Tariq from his broom. And you give this to me? But surely...why, this can only mean it is an offering of peace from my cousin through you. He has forgiven me!"
			)
			(7
				(HandsOn)
				(= local10 1)
				(client setScript: 0)
				(gCurRoom setScript: enterInn)
			)
			(8
				(innDoor cue: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance ali of Act
	(properties
		y 108
		x 20
		view 359
		illegalBits 0
	)

	(method (init)
		(super init:)
		(ali setScript: leaveThisRoom)
	)
)

(instance leaveThisRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ali setCycle: Walk)
				(if (== gPrevRoomNum 58)
					(ali
						setLoop: 0
						posn: 10 (ali y:)
						setMotion: MoveTo 40 (ali y:) self
					)
				else
					(= cycles 8)
				)
			)
			(1
				(ali setLoop: 1 setMotion: MoveTo -10 (ali y:) self)
			)
			(2
				(ali setCycle: 0 setScript: 0 dispose:)
			)
		)
	)
)

