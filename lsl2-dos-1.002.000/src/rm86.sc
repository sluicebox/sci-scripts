;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 86)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm86 0
)

(local
	work
	aVolcano
	aSmoke
	aLava
	aReflection
	aBigEgo
	aBigEgoEyes
	aBigEgoMouth
	aKalalau
)

(instance theSound of Sound
	(properties
		number 116
	)
)

(instance rm86 of Rm
	(properties
		picture 86
		style 16
		horizon 1
	)

	(method (init)
		(Load rsVIEW 116)
		(Load rsVIEW 718)
		(Load rsVIEW 824)
		(Load rsVIEW 825)
		(Load rsVIEW 827)
		(Load rsSOUND 116)
		(super init:)
		(theSound init:)
		((View new:)
			view: 718
			ignoreActors:
			loop: 3
			posn: 213 179
			setPri: 14
			addToPic:
		)
		((View new:) view: 825 posn: 257 47 addToPic:)
		((= aBigEgo (View new:))
			view: 116
			ignoreActors:
			setLoop: 0
			setPri: 14
			posn: 204 1095
			init:
		)
		((= aBigEgoEyes (Prop new:))
			view: 116
			setLoop: 2
			ignoreActors:
			setPri: 15
			posn: 202 1085
			init:
		)
		((= aBigEgoMouth (Prop new:))
			view: 116
			setLoop: 1
			ignoreActors:
			setPri: 15
			posn: 202 1107
			init:
		)
		((= aReflection (Prop new:))
			view: 825
			ignoreActors:
			setLoop: 1
			posn: 262 134
			setCycle: Fwd
			cycleSpeed: 5
			isExtra: 1
			init:
		)
		((= aVolcano (Prop new:))
			view: 827
			ignoreActors:
			setLoop: 0
			setPri: 2
			cel: 0
			posn: 147 29
			cycleSpeed: 1
			init:
			hide:
		)
		((= aSmoke (Prop new:))
			view: 827
			ignoreActors:
			setLoop: 2
			setPri: 1
			posn: 147 29
			cycleSpeed: 3
			init:
			hide:
		)
		((= aLava (Prop new:))
			view: 827
			ignoreActors:
			setLoop: 3
			setPri: 3
			cel: 0
			posn: 147 29
			cycleSpeed: 4
			init:
			hide:
		)
		((= aKalalau (Act new:))
			view: 718
			ignoreActors:
			illegalBits: 0
			setLoop: 2
			posn: 174 133
			setPri: 9
			setCycle: Walk
			setStep: 4 3
			cycleSpeed: 2
			moveSpeed: 2
			init:
			hide:
		)
		(gEgo
			view: 718
			illegalBits: 0
			ignoreActors:
			loop: 0
			cel: 0
			posn: 176 108
			setMotion: 0
			setCycle: Walk
			setStep: 4 3
			cycleSpeed: 2
			moveSpeed: 2
			init:
		)
		(HandsOff)
		(self setScript: rm86Script)
	)
)

(instance rm86Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (> state 3) (< state 7) (> 50 (Random 0 75)))
			(ShakeScreen 1 (Random 1 3))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(aKalalau show: setMotion: MoveTo 210 161 self)
				(gEgo
					setLoop: 1
					cel: 0
					posn: 156 135
					setCycle: Walk
					setMotion: MoveTo 200 169
				)
			)
			(3
				(theSound play:)
				(gEgo hide:)
				(aKalalau
					view: 824
					setLoop: 0
					cel: 0
					posn: 204 166
					setCycle: End self
				)
			)
			(4
				(aVolcano show: setCycle: End self)
			)
			(5
				(aVolcano setLoop: 1 cycleSpeed: 3 setCycle: Fwd)
				(aSmoke show: setCycle: Fwd)
				(= cycles 10)
			)
			(6
				(aLava show: setCycle: End self)
			)
			(7
				(aLava setLoop: 4 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(Print 86 0 #draw) ; "As we leave our hero, cavorting in the sand with his new love, we ask ourselves the burning question..."
				(Print 86 1) ; "Is women's lib really dead?"
				(Print 86 2) ; "Is there still a feminist movement?"
				(Print 86 3) ; "Is there a market for "Polyester Patty in Pursuit of the Pulsating Pectorals?""
				(Print 86 4) ; "...or will Al Lowe have to write yet another of these Silly Sin-phonies?"
				(= seconds 3)
			)
			(9
				(aKalalau setLoop: 1 cel: 0 setCycle: End self)
			)
			(10
				(aBigEgo posn: 204 94 stopUpd:)
				(aBigEgoEyes posn: 202 84)
				(aBigEgoMouth posn: 202 106)
				(= seconds 3)
			)
			(11
				(aBigEgoEyes setCycle: End self)
				(aBigEgoMouth setCycle: End)
			)
			(12
				(aKalalau setLoop: 2 setCycle: Fwd)
			)
		)
	)
)

