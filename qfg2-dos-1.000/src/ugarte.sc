;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 364)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use Talker)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	ugarte 0
	ugarteTimer 1
)

(local
	[ugarteGenList 38] = [15 16 17 14 14 14 14 14 14 14 18 14 19 14 20 14 14 14 21 22 14 14 14 23 24 14 14 14 14 14 25 14 26 14 14 14 14 14]
	[ugarteSpecList 28] = [0 '//service' 1 '//water' 2 '//info' 3 '//customer' 4 '//khaveen' 6 '//lackey' 7 '//someone' 8 '//people' 9 '//due' 10 '//prediction' 11 '//dungeon' 12 '//ferrari' 13 '//ad[<ad]' 0 0]
)

(instance ugarteLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gEgo script:))
					(Say ugarte self 364 0) ; "If you have no further need of me, sir, there are thirsty customers in need of my wares."
				else
					(= cycles 1)
				)
			)
			(1
				(= global75 0)
				(ugarte
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 180 200 self
				)
			)
			(2
				(ugarte setMotion: MoveTo 160 250 self)
			)
			(3
				(ugarte dispose:)
				(ugarteMouth dispose:)
				(ugarteTimer dispose:)
				(self dispose:)
			)
		)
	)
)

(instance waterMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ugarte setLoop: 5 setCel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(ugarte setLoop: 4 setCel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(ugarte setCycle: Beg self)
			)
			(3
				(ugarte setLoop: 0)
				(Say ugarte self (ugarte msgFile:) 1)
			)
			(4
				(StartTimer ugarteTimer 15)
				(self dispose:)
			)
		)
	)
)

(instance buyWaterS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ugarte setLoop: 5 setCel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(ugarte setLoop: 0)
				(cond
					((not register)
						(Say ugarte self 364 1) ; "My water will cost you 20 dinars, Sir."
						(= register 20)
					)
					((TrySkill 13 100) ; communication
						(Say ugarte self 364 2) ; "Normally my water costs 20 dinars, Sir, but for you I will only require 15."
						(= register 15)
					)
					(else
						(Say ugarte self 364 3) ; "Surely, a man such as yourself can easily afford 20 dinars?"
						(= register 0)
					)
				)
			)
			(2
				(switch (CheckFunds (* register 100))
					(1
						(Say ugarte self 364 4) ; "I am sorry, Sir, but I do not accept foreign coin."
						(= register 0)
					)
					(0
						(Say ugarte self 364 5) ; "Surely, Sir, you did not intend to buy water with your good looks?"
						(= register 0)
					)
					(2
						(GiveMoney (* register 100))
						(= cycles 1)
					)
				)
			)
			(3
				(if (not register)
					(self changeState: 6)
				else
					(ugarte
						setLoop: 4
						setCel: 0
						cycleSpeed: 1
						setCycle: End self
					)
				)
			)
			(4
				(HighPrint 364 6) ; "Ugarte takes your money and pours some water from his supply into your waterskins."
				(+= gDrinksLeft 10)
				(= cycles 1)
			)
			(5
				(ugarte setLoop: 5 setCycle: Beg self)
			)
			(6
				(StartTimer ugarteTimer 15)
				(ugarte setLoop: 0)
				(self dispose:)
			)
		)
	)
)

(instance ugarte of Talker
	(properties
		description {Ugarte}
		lookStr {He smiles at you and you are reminded of a weasel.__He speaks, and you think of snakes.}
		view 362
		tLoop -1
		talkSpeed 1
		myName '//ugarte,man'
		title {Ugarte:}
		color 5
		msgFile 362
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 362)
		(Load rsTEXT 362)
		(ugarteMouth init: hide:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'buy/water') (Said 'bargain//water'))
				(self setScript: buyWaterS)
			)
		)
	)

	(method (respond event)
		(if (and (== gInnState 3) (not (IsFlag 111))) ; fUgartePaid
			(event claimed: 1)
			(Say self 364 7) ; "It seems before I give you what you want, you should give me what I want. It is only fair, no? My dinars, please."
		else
			(StartTimer ugarteTimer 15)
			(super respond: event &rest)
		)
	)

	(method (showText what)
		(if (== what 1)
			(self setScript: waterMsg)
		else
			(super showText: what &rest)
		)
	)

	(method (atSpec which)
		(return [ugarteSpecList which])
	)

	(method (atGen which)
		(return [ugarteGenList which])
	)

	(method (messages)
		(ugarteMouth
			x: (+ (ugarte x:) 4)
			y: (- (ugarte y:) 34)
			setCycle: Fwd
			show:
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(ugarteMouth hide:)
		(super endTalk: &rest)
	)
)

(instance ugarteMouth of Prop
	(properties
		view 362
		loop 6
		priority 15
		signal 16
		cycleSpeed 1
	)
)

(instance ugarteTimer of Timer
	(properties)

	(method (cue)
		(ugarte setScript: ugarteLeaves)
		(self dispose:)
	)
)

