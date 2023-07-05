;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm72 0
)

(local
	usedStick
	aSnake
	aBurp
)

(instance rm72 of Rm
	(properties
		picture 72
		horizon 56
		north 71
		east 73
	)

	(method (init)
		(super init:)
		(if (== gSnakeState 0)
			(Load rsVIEW 701)
			(Load rsVIEW 174)
			(Load rsVIEW 172)
			(Load rsVIEW 28)
			((= aSnake (Act new:))
				view: 701
				illegalBits: 0
				ignoreActors:
				setLoop: 0
				setCel: 0
				setPri: 14
				cycleSpeed: 1
				posn: 168 97
				stopUpd:
				init:
			)
			((= aBurp (Prop new:))
				view: 172
				ignoreActors:
				setLoop: 4
				setCel: 0
				setPri: 15
				posn: 220 151
				init:
				hide:
			)
		)
		(if (== gPrevRoomNum 73)
			(gEgo posn: 316 159)
		else
			(gEgo posn: 23 57)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 700 setScript: rm72Script) ; rm700
	)
)

(instance rm72Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl:) $0002)
				(== gSnakeState 0)
				(== gCurrentStatus 0)
			)
			(self changeState: 1)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if
			(or
				(Said 'get/stick<off')
				(Said 'get/stick<ready')
				(Said '(get<off),apply,stick,carry,insert,drop/stick')
			)
			(cond
				((not (gEgo has: 28)) ; Stout_Stick
					(DontHave) ; "You don't have it."
				)
				((!= gCurrentStatus 1000)
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(Print 72 0 #at -1 20) ; "You carefully prepare yourself for the oncoming jaws with the stick. Will it work?"
					(= usedStick 1)
				)
			)
		)
		(if (Said 'apply,swing,get/landscape')
			(Print 72 1) ; "A good idea, but this is not the place."
		)
		(if (not gSnakeState)
			(if (Said 'hit/anaconda/stick')
				(if (gEgo has: 28) ; Stout_Stick
					(Print 72 2) ; "You're close, but the stick is not heavy enough to harm the anaconda."
				else
					(DontHave) ; "You don't have it."
				)
			)
			(if (Said 'hit/anaconda')
				(Print 72 3) ; "You are mad enough to do that, but that's not the solution to your predicament."
			)
			(if (Said 'crawl')
				(Print 72 4) ; "Good idea, but that would just give the snake even more advantage. Just stick to using your brain."
			)
		)
		(if (Said 'look>')
			(if (Said '/bush,palm,leaf')
				(if (== gSnakeState 3)
					(Print 72 5) ; "There are no more snakes around."
				else
					(Print 72 6) ; "There may be some movement in that center bush."
				)
			)
			(if (Said '/carpet,dirt,carpet')
				(Print 72 7) ; "This part of the jungle floor seems even more soft and mushy."
			)
			(if (Said '/ear,art,lip')
				(Print 72 8) ; "It looks like a prehistoric punk rocker!"
			)
			(if (Said '/anaconda')
				(if (== gSnakeState 3)
					(Print 72 9) ; "There are no more snakes in this area."
				else
					(Print 72 10) ; "A giant anaconda lies waiting for you, coiled around a branch directly above the only exit from this part of the jungle."
				)
			)
			(if (Said '[/airport,forest]')
				(Print 72 11) ; "The jungle is dense and dark. High above you, monkeys dance through the treetops."
				(if (== gSnakeState 1)
					(Print 72 12) ; "A snake is in the process of devouring you!"
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= gCurrentStatus 1000)
				(= gSnakeState 1)
				(Print 72 13 #at -1 20) ; "You just attracted the attention of that giant anaconda by walking beneath his waiting coils. Perhaps if you hold very still he won't notice you!"
				(User canControl: 0 canInput: 1)
				(gEgo setMotion: 0 posn: 142 152 setLoop: 2)
				(aSnake setCycle: End self)
			)
			(2
				(if (!= usedStick 1)
					(Print 72 14 #at -1 20 #draw) ; "Ok, so he DID notice you! Perhaps he just finished a big meal and couldn't eat another bite!"
				)
				(aSnake posn: 130 144 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo hide:)
				(User canInput: 0)
				(if usedStick
					(self changeState: 12)
				else
					(aSnake
						view: 172
						setLoop: 0
						posn: 138 152
						cycleSpeed: 2
						cel: 0
						setCycle: End self
					)
				)
			)
			(4
				(aSnake
					setLoop: 1
					posn: 140 152
					cel: 0
					cycleSpeed: 0
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(5
				(aSnake setLoop: 2 cycleSpeed: 3 cel: 0 setCycle: End self)
			)
			(6
				(aSnake cycleSpeed: 2 setLoop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(Print 72 15) ; "Then again, perhaps he relishes the taste of polyester!"
				(= seconds 3)
			)
			(8
				(aBurp show: setCycle: End self)
			)
			(9
				(= cycles 10)
			)
			(10
				(aBurp setCycle: Beg self)
			)
			(11
				(aBurp dispose:)
				(Print 72 16 #draw) ; "You feel you could have eventually escaped his coils if there was only some way to keep him from swallowing you."
				(= gCurrentStatus 1001)
			)
			(12
				(= gSnakeState 2)
				(aSnake
					view: 174
					setLoop: 0
					cycleSpeed: 2
					posn: 139 145
					cel: 0
					setCycle: End self
				)
				(Print 72 17 #at -1 20 #draw #icon 28 0 0) ; "As the snake dislocates its lower jaw in preparation for another hearty, cholesterol-laden dinner of red meat and polyester, you carefully insert your stick into the distended opening!"
			)
			(13
				(= seconds 3)
			)
			(14
				(aSnake
					view: 174
					setLoop: 1
					cycleSpeed: 3
					cel: 0
					setCycle: End self
				)
				(gGame changeScore: 10)
				(Print 72 18 #at -1 20 #draw) ; "The snake, unable to remove the stick from its jaws and embarrassed by being humiliated before the other jungle creatures, slithers away through the undergrowth to its lair (and an early retirement)."
			)
			(15
				(gEgo posn: 146 159 setLoop: 0 show: put: 28 -1) ; Stout_Stick
				(aSnake
					setPri: -1
					setLoop: 2
					posn: 142 114
					cel: 0
					setCycle: End self
				)
			)
			(16
				(aSnake dispose:)
				(= gSnakeState 3)
				(NormalEgo)
			)
		)
	)
)

