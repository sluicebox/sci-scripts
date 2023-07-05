;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 164)
(include sci.sh)
(use Main)
(use Rm57)
(use Interface)
(use Motion)
(use System)

(public
	urchinSaids 0
)

(synonyms
	(joshua joshua child boy)
)

(instance urchinSaids of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(cond
			((or (Said 'talk/joshua') (Said 'ask[/joshua]/*'))
				(if (IsFlag 142)
					(proc57_3 164 0) ; "Poor thing probably cannot speak properly. Well, give him time. Sometimes silence is the greater virtue, eh?"
				else
					(proc57_3 164 1 164 2) ; "No good trying to talk him. He never says a word. Not a tooth left in his head, anyway. He has been there for days, begging for crumbs."
				)
			)
			(
				(and
					(gEgo has: 3) ; purse
					(or
						(Said 'pay')
						(Said 'give,count/coin,copper,dirham,dinar')
					)
					(or
						(and
							(gEgo inRect: 265 140 320 155)
							(== (gEgo loop:) 0)
						)
						(Said '//joshua')
					)
				)
				(event claimed: 1)
				(Face gEgo global185)
				(Print 164 3) ; "He is afraid to take money. It must remind him of some evil happening from his past."
				(proc0_18)
			)
			((Said 'give,feed/lamb,grain,apple[/joshua]')
				(Print 164 4) ; "He cannot eat it for he has lost most of his teeth, doubtless from starvation and hardship."
			)
			(
				(or
					(Said 'give,feed/falafel,food[/joshua]')
					(and global144 (Said 'feed/joshua'))
				)
				(cond
					((IsFlag 142)
						(proc57_3 164 5) ; "Do not worry about him. He will have all the felafels his heart desires."
					)
					(global144
						(= temp0 1)
						(SetScore 275 2 20)
						(gEgo setScript: giveFelafelToUrchin)
					)
					(else
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
				)
			)
			((Said 'show/falafel,food/joshua')
				(cond
					((not (gEgo has: 14)) ; felafel
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((IsFlag 142)
						(proc57_3 164 5) ; "Do not worry about him. He will have all the felafels his heart desires."
					)
					(else
						(Print 164 6) ; "Do not torment the boy, Arthur. You can see he is starving."
					)
				)
			)
			((Said 'feed/joshua')
				(if (or (gEgo has: 4) (gEgo has: 8) (gEgo has: 10)) ; rose | apple | green_apple, boar_spear | grain | medallion, lamb | dove
					(Print 164 7) ; "He cannot eat the it for he has lost most of his teeth, doubtless from starvation and hardship."
				else
					(Print 164 8) ; "You have nothing to feed him, Arthur, though it is a worthy thought."
				)
			)
			((Said 'give/*[/joshua]')
				(Print 164 9) ; "He is too afraid to take it."
			)
			((Said 'help/joshua')
				(Print 164 10) ; "A noble thought, but you must find a practical way to do this."
			)
			((or (Said 'get/joshua<along') (Said 'get,adopt/joshua'))
				(Print 164 11) ; "You cannot care for this boy yourself and still succeed in your mission, nor do I think he would go with you willingly."
			)
		)
		(if (not temp0)
			(DisposeScript 164)
		)
	)
)

(instance giveFelafelToUrchin of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp0 (- (global185 x:) 25))
				(= temp1 (+ (global185 y:) 5))
				(if (and (!= (gEgo x:) temp0) (!= (gEgo y:) temp1))
					(gEgo setMotion: MoveTo temp0 temp1 self)
				else
					(= cycles 2)
				)
			)
			(1
				(Face gEgo global185)
				(proc57_5)
				(gEgo
					view: 70
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: CT 1 1 self
				)
			)
			(2
				(global185
					loop: 6
					cel: (if (== (global185 loop:) 8) 2 else 0)
					setCycle: CT 3 1 self
				)
			)
			(3
				(global185 setCycle: End)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0 loop: 0 cycleSpeed: 0 setCycle: Walk)
				(global185 loop: 7 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(global185 loop: 8 cel: 0 setCycle: End self)
			)
			(6
				(Print 164 12) ; "That was a good deed, Arthur."
				(SetFlag 160)
				(HandsOn)
				(client setScript: 0)
				(= global185 0)
				(DisposeScript 164)
			)
		)
	)
)

