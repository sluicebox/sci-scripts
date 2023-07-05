;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 231)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	kisscolo 0
)

(synonyms
	(fifi woman)
	(colonel man)
	(butt cigarette)
)

(local
	local0
	local1
	local2
)

(instance kisscolo of Rgn
	(properties)

	(method (init)
		(super init:)
		(LoadMany rsFONT 4 41)
		(Load rsSCRIPT 985)
		(LoadMany rsVIEW 470 642 909)
		(LoadMany rsSOUND 29 51 94 95 96)
		(LoadMany rsMESSAGE 243 225 406)
		(= global208 512)
		(= [global377 9] 225)
		(if (and (== gAct 0) (== [gCycleTimers 3] 0))
			(= [gCycleTimers 3] 1800)
			(LoadMany rsVIEW 304 464 904)
			(= global195 16)
			(Fifi view: 466 setAvoider: (Avoid new:) init: hide:)
			(Colonel view: 466 init: stopUpd:)
			(self setScript: kiss)
		else
			(if (and (!= [gCycleTimers 3] 1) (== global124 0))
				(= global195 16)
				(Fifi
					view: 464
					setAvoider: (Avoid new:)
					init:
					illegalBits: -32764
					setScript: fifiActions
				)
			)
			(Colonel view: 304 init: stopUpd: setScript: colonelActions)
		)
		(Glow posn: (+ (Colonel x:) 10) (Colonel y:) z: 29 init: hide:)
		(smoke1
			posn: (+ (Colonel x:) 6) (- (Colonel y:) 30)
			setPri: (CoordPri (Colonel y:))
			init:
			hide:
		)
		(smoke2
			posn: (+ (Colonel x:) 11) (- (Colonel y:) 24)
			setPri: (CoordPri (Colonel y:))
			init:
			hide:
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/butt')
					(SetFlag 13)
					(Print 231 0) ; "The Colonel smokes a small, nasty-smelling cigar."
				)
				((Said 'listen/fifi,colonel')
					(Print 231 1) ; "Currently, neither Fifi, nor the Colonel, are talking."
				)
				((Said 'get/butt')
					(Print 231 2) ; "It belongs to the Colonel!"
				)
				((and (Said 'talk>') (Said '/colonel,person'))
					(= global213 10)
					(switch local1
						(0
							(Say 1 231 3) ; "What are you doing in my room, young lady?!"
						)
						(1
							(Say 1 231 4) ; "You have no right to be in here!"
						)
						(2
							(Say 1 231 5) ; "Quit looking at my things! Get out of here!"
						)
						(3
							(Say 1 231 6) ; "Don't young people respect people's privacy anymore! Go on...scat!"
						)
						(4
							(Print 231 7) ; "The Colonel, ignoring you, sits sullenly in his wheelchair."
						)
					)
					(if (< local1 4)
						(++ local1)
					)
				)
			)
		)
	)
)

(instance kiss of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (== (Colonel cel:) 2))
			(Kiss number: 51 loop: 1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(Colonel cycleSpeed: 2 setCycle: End self)
			)
			(2
				(Print 231 8 #at 140 150 #font 4 #width 125 #mode 1 #dispose) ; "Pardon, Henri! I got zee lipstick on you!"
				(Colonel view: 304 posn: 185 140 loop: 0 cel: 0 cycleSpeed: 0)
				(Fifi
					show:
					view: 466
					loop: 1
					cycleSpeed: 2
					ignoreActors: 1
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(3
				(Fifi cel: 0 loop: 2 setCycle: End self)
			)
			(4
				(HandsOn)
				(cls)
				(Colonel setScript: colonelActions)
				(Fifi
					view: 470
					loop: 1
					cycleSpeed: 0
					illegalBits: -32764
					setScript: fifiActions
				)
				(client setScript: 0)
			)
		)
	)
)

(instance fifiActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 (Random 0 4))
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: 0
					setMotion:
						MoveTo
						(switch local2
							(0 225)
							(1 244)
							(2 218)
							(3 130)
							(4 66)
						)
						(switch local2
							(0 126)
							(1 129)
							(2 90)
							(3 94)
							(4 137)
						)
						self
				)
			)
			(1
				(Fifi
					view: 470
					cel: 0
					loop:
						(switch local2
							(0 5)
							(1 0)
							(2 1)
							(3 1)
							(4 5)
						)
					setCycle: End self
				)
			)
			(2
				(Fifi
					loop:
						(switch local2
							(0 7)
							(1 2)
							(2 3)
							(3 3)
							(4 7)
						)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(3
				(Fifi cel: 2 setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance colonelActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke2 cel: 0 hide:)
				(Colonel loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(Glow show: loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 18)
			)
			(2
				(Glow hide:)
				(Colonel
					loop: 0
					cel: (- (NumCels Colonel) 1)
					setCycle: Beg self
				)
			)
			(3
				(smoke2 setCycle: Fwd show:)
				(smoke1 show: setCycle: End self)
			)
			(4
				(smoke1 cel: 0 hide:)
				(= cycles 1)
			)
			(5
				(if (< (Random 1 100) 30)
					(= state -1)
				else
					(= state 4)
				)
				(= seconds 5)
			)
		)
	)
)

(instance Colonel of Prop
	(properties
		y 140
		x 185
	)

	(method (handleEvent event)
		(cond
			((Said 'get,move,press/wheelchair')
				(Print 231 9) ; "The Colonel wouldn't like that."
			)
			((and (MousedOn self event 3) (not (& global207 $0200)))
				(event claimed: 1)
				(DoLook {colonel})
			)
			(
				(and
					(& global207 $0200)
					(or (MousedOn self event 3) (Said 'look/colonel'))
				)
				(event claimed: 1)
				(Print 231 10) ; "Colonel Dijon warily watches you from his wheelchair."
			)
		)
	)
)

(instance smoke1 of Prop
	(properties
		view 304
		loop 2
	)
)

(instance smoke2 of Prop
	(properties
		view 304
		loop 3
	)
)

(instance Glow of Prop
	(properties
		view 304
		loop 1
	)
)

(instance Fifi of Act
	(properties
		y 140
		x 206
	)

	(method (handleEvent event)
		(cond
			((Said 'talk,look/person')
				(Print 231 11) ; "Which person are you referring to?"
			)
			((Said 'talk/people')
				(Print 231 12) ; "You can only talk to one person at a time."
			)
			((Said 'look/people')
				(Print 231 13) ; "Fifi busily dusts while the Colonel keeps on eye on you."
			)
			(
				(or
					(Said 'ask,tell/fifi/*<about')
					(Said 'talk/fifi')
					(Said 'give,show/*<fifi')
					(Said 'give,show/*/fifi')
				)
				(event claimed: 0)
				(if (Said 'give,show')
					(if (and global219 global224)
						(Print 231 14) ; "Fifi doesn't acknowledge your presence. She's too busy cleaning the Colonel's room."
					else
						(DontHave) ; "You don't have it."
					)
				else
					(Print 231 14) ; "Fifi doesn't acknowledge your presence. She's too busy cleaning the Colonel's room."
					(event claimed: 1)
				)
			)
			((or (MousedOn self event 3) (Said 'look/fifi'))
				(if (& global207 $0010)
					(Print 231 15) ; "Currently, Fifi looks to be busily cleaning the Colonel's room."
				else
					(|= global207 $0010)
					(= global213 5)
					(Say 0 231 16) ; "Fifi is the Colonel's pretty French maid. You surmise that she is probably very apt in her duties...whatever they may be. Fifi is young, blonde, and sexy. She seems to have a vivacious personality, but you can sense a certain cunning underneath it all."
				)
				(event claimed: 1)
			)
			((Said '/fifi>')
				(cond
					((Said 'get')
						(Print 231 17) ; "You can't get her!"
					)
					((Said 'kill')
						(Print 231 18) ; "There's no need for THAT sort of thing!"
					)
					((Said 'kiss')
						(Print 231 19) ; "You don't feel like kissing her."
					)
					((Said 'embrace')
						(Print 231 20) ; "You don't feel like hugging her."
					)
				)
			)
		)
	)
)

(instance Kiss of Sound
	(properties)
)

