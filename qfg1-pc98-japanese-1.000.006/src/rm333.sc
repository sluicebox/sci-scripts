;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use RFeature)
(use Motion)
(use Game)
(use Actor)

(public
	rm333 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance beggarBlock of Blk
	(properties)
)

(instance beggar of PV
	(properties
		y 171
		x 178
		view 333
	)
)

(instance beggarArm of Prop
	(properties
		y 150
		x 184
		view 333
		loop 1
		priority 11
	)
)

(instance frontBarrel of PV
	(properties
		y 120
		x 119
		view 333
		loop 2
	)
)

(instance backBarrel of PV
	(properties
		y 97
		x 162
		view 333
		loop 2
	)
)

(instance rm333 of Rm
	(properties
		picture 333
		style 0
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 100)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 333)
		(super init:)
		(gMouseHandler add: self)
		(SL enable:)
		(self setLocales: 811 801)
		(NormalEgo)
		(gEgo
			posn: 120 187
			observeBlocks: beggarBlock
			init:
			setMotion: MoveTo 120 180
		)
		(gAddToPics add: beggar frontBarrel backBarrel eachElementDo: #init doit:)
		(beggarArm ignoreActors: 1 init: stopUpd:)
		(= local0 0)
	)

	(method (doit)
		(if (> (gEgo y:) 187)
			(if (and local1 (not (IsFlag 100)))
				(clr)
				(HighPrint 333 0) ; "A word of warning to you -- don't drink the Dragon's Breath!"
			)
			(gCurRoom newRoom: 330)
		)
		(cond
			((and (not local0) (gEgo inRect: 100 135 215 185))
				(beggarArm setCycle: End)
				(TimePrint 4 333 1) ; "Alms? Alms for the poor?"
				(= local0 1)
			)
			((and local0 (not (gEgo inRect: 100 135 215 185)))
				(beggarArm setCycle: Beg)
				(= local0 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (== (event type:) evSAID) (== (event type:) evMOUSEBUTTON))
			(clr)
		)
		(cond
			((and local2 (Said 'ask>'))
				(= local4 1)
				(cond
					((> (++ local3) 5)
						(= local4 0)
						(= local2 0)
						(event claimed: 1)
						(HighPrint 333 2) ; "About time I got back to work. Alms for the poor. Alms!"
					)
					((Said '//name,beggar')
						(HighPrint 333 3) ; "My name is Sam. I've lived here for five years now, and I think I'll be heading on once the pass clears of snow. There's supposed to be some good begging towns to the south."
					)
					((Said '//beg')
						(HighPrint 333 4) ; "A beggar gets cash only when others get cash, and nobody's got much money here right now."
					)
					((Said '//alm,alm')
						(HighPrint 333 5) ; "There's honest work up at the Baron's castle, I hear. But begging's my business."
					)
					((Said '//night,dark')
						(HighPrint 333 6) ; "I remember when people used to stroll around town at night. Now, the only people out late are the thieves. And outside of town, man, you don't dare go out there after dark. The Night Gaunts'll get you for sure."
					)
					((Said '//monster')
						(HighPrint 333 7) ; "The most dangerous monsters come out at night. I'd stay inside then if I were you."
					)
					((Said '//gaunt')
						(HighPrint 333 8) ; "Nobody's ever lived to tell what the Night Gaunts are. I sure don't want to find out."
					)
					((Said '//bandit,thief,thief')
						(HighPrint 333 9) ; "Thieves prowl the streets at night. They don't bother me because I have nothing to steal. The brigands are worse. They sure hurt business; no one's getting rich but them."
					)
					((Said '//baron,castle,labor,labor,job')
						(HighPrint 333 10) ; "You can get a job cleaning the Baron's stable, I understand. It's good work if you want to build up your muscles or have a place to spend the night, but you won't get rich. I'd rather beg, myself."
					)
					(else
						(= local4 0)
						(HighPrint 333 11) ; "I'm afraid I can't tell you much about that."
						(event claimed: 1)
					)
				)
				(if local4
					(SolvePuzzle 732 1)
				)
			)
			((Said 'get,get,grab/alm,silver')
				(HighPrint 333 12) ; "Stealing from a beggar is not a heroic action."
			)
			((Said 'read,look,look/mark')
				(if (<= (gEgo y:) 130)
					(HighPrint 333 13) ; "Some sharp object appears to have been thrown at these walls several times."
				else
					(HighPrint 333 14) ; "You can't make them out from here."
				)
			)
			((Said 'look,look[<at,around][/!*,street,alley]')
				(HighPrint 333 15) ; "This grubby place must be an alley. You feel a strange, cold feeling here. You see some discarded barrels, and a beggar holds out a bowl towards you."
			)
			((or (MouseClaimed onBeggar event 3) (Said 'look,look/beggar,man'))
				(if local1
					(HighPrint 333 16) ; "A thin man with very patched clothing holds out a bowl containing only your kind contribution."
				else
					(HighPrint 333 17) ; "A thin man with very patched clothing holds out an empty bowl."
				)
			)
			(
				(or
					(MouseClaimed onBowl event 3)
					(Said 'look,look/bowl,basket,hat,item')
				)
				(if local1
					(HighPrint 333 18) ; "The beggar's bowl contains your donation."
				else
					(HighPrint 333 19) ; "The beggar's bowl looks sadly empty."
				)
			)
			((MouseClaimed onBricks event 3)
				(HighPrint 333 20) ; "Nice place. How does this guy expect to make a living begging in this alley."
			)
			((MouseClaimed onFirstBarrel event 3)
				(HighPrint 333 21) ; "It's a vessel made of staves, headings and hoops. More commonly known as a barrel."
			)
			((MouseClaimed onSecondBarrel event 3)
				(HighPrint 333 22) ; "This barrel reeks of Troll's Sweat."
			)
			((Said 'look,look/wall')
				(HighPrint 333 23) ; "The walls seem pretty normal, but there are some curious marks at the north ends of the buildings."
			)
			((Said 'look,look/barrel')
				(HighPrint 333 24) ; "The barrels are empty, and smell of sour beer."
			)
			((Said 'look,look/bum')
				(HighPrint 333 25) ; "Although a beggar, the man in the alley appears to be sober."
			)
			((Said 'get,get,move,move,grab,(pick,lockpick<up)>')
				(cond
					((Said '/barrel')
						(HighPrint 333 26) ; "The barrels are too heavy to move."
					)
					((Said '/bowl,hat,basket,item')
						(HighPrint 333 27) ; "You can't. The beggar is holding onto it with an iron grip."
					)
				)
			)
			((Said 'pay,give,put,drop,throw[/alm,silver]')
				(if (Purchase 1)
					(SolvePuzzle 733 1)
					(HighPrint 333 28) ; "Thanks. You know, it's really tough trying to make a living begging in this town since the brigands started scaring all the trade away."
					(if (not local1)
						(HighPrint 333 29) ; "This used to be such a nice place to live. My advice to you is not to take up begging. It just doesn't pay. And don't go out at night."
					)
					(= local1 1)
					(= local2 1)
					(= local3 0)
				else
					(HighPrint 333 30) ; "You reach in your pocket, and suddenly realize that you have no money to give."
				)
			)
			((Said 'ask,talk,talk')
				(HighPrint 333 31) ; "Silver for the poor."
			)
		)
	)
)

(instance onBricks of RFeature
	(properties
		nsTop 66
		nsLeft 188
		nsBottom 93
		nsRight 201
	)
)

(instance onFirstBarrel of RFeature
	(properties
		nsTop 120
		nsLeft 111
		nsBottom 142
		nsRight 125
	)
)

(instance onSecondBarrel of RFeature
	(properties
		nsTop 97
		nsLeft 154
		nsBottom 121
		nsRight 171
	)
)

(instance onBeggar of RFeature
	(properties
		nsTop 139
		nsLeft 181
		nsBottom 165
		nsRight 194
	)
)

(instance onBowl of RFeature
	(properties
		nsTop 145
		nsLeft 164
		nsBottom 154
		nsRight 175
	)
)

