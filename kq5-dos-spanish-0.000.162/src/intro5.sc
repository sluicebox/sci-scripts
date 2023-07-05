;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use DLetter)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro5 0
)

(local
	local0
	[local1 4]
)

(instance intro5 of Rm
	(properties
		picture 71
	)

	(method (init)
		(super init:)
		(= local0 1)
		(HandsOff)
		(gGame setCursor: 5 1)
		(egoHead init:)
		(gEgo
			view: 763
			loop: 1
			posn: 102 109
			normal: 0
			cycleSpeed: 2
			init:
			setPri: (+ (egoHead priority:) 1)
		)
		((gEgo head:) hide:)
		(owl view: 757 setPri: 10 ignoreActors: 1 setLoop: 1 init:)
		(intro_eyes
			setPri: (+ (owl priority:) 1)
			setLoop: 2
			posn: (+ (owl x:) 2) (- (owl y:) 34)
			setScript: blinkScript
			init:
		)
		(intro_mouth
			setPri: (+ (owl priority:) 1)
			setLoop: 3
			posn: (+ (owl x:) 3) (- (owl y:) 30)
			init:
		)
		(rWing
			view: 757
			setPri: (+ (owl priority:) 2)
			setLoop: 4
			posn: (- (owl x:) 5) (- (owl y:) 28)
			signal: 16384
			setScript: rWingScript
			init:
		)
		(lWing
			view: 757
			setPri: (+ (owl priority:) 2)
			setLoop: 5
			posn: (+ (owl x:) 7) (- (owl y:) 26)
			setScript: lWingScript
			signal: 16384
			init:
		)
		(self setRegions: 763) ; cartoonRegion
		(self setScript: sceneFiveScript)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(intro_eyes setPri: (+ (owl priority:) 1))
		(intro_mouth setPri: (+ (owl priority:) 1))
		(rWing setPri: (+ (owl priority:) 2))
		(lWing setPri: (+ (owl priority:) 2))
	)
)

(instance sceneFiveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGlobalSound number: 9 loop: -1 playBed:)
				(lWing setScript: lWingScript)
				(rWing setScript: rWingScript)
				(intro_mouth show: cycleSpeed: 2 setCycle: Fwd)
				(PrintDC 104 0 #at 140 100 #width 150 #dispose) ; "Fue el poderoso y malvado brujo Mordack quien lo hizo. Por casualidad me encontraba visitando a un viejo amigo, cuando le vi materializarse en el aire. \adGracias a Dios que no ME vi\a2!"
				(= seconds (LangSwitch 11 17))
			)
			(2
				(intro_mouth setCycle: End self)
			)
			(3
				(cls)
				(intro_mouth hide:)
				(= global380 1)
				(gEgo setCycle: Fwd)
				(PrintDC 104 1 #at 10 30 #dispose) ; "\adNo te pares ahora! \adAdelante!"
				(= seconds 11)
			)
			(4
				(gCurRoom newRoom: 105) ; intro6
			)
		)
	)
)

(instance lWingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(lWing cycleSpeed: 2 setLoop: 5 setCycle: End)
				(= seconds 4)
			)
			(2
				(lWing setLoop: 6 setCycle: End)
				(= seconds 3)
			)
			(3)
			(4
				(lWing setLoop: 5 setCycle: End)
				(= seconds 2)
			)
			(5
				(lWing setLoop: 6 setCycle: End)
				(= seconds 3)
			)
			(6)
			(7
				(lWing setLoop: 5 setCycle: End)
				(= seconds 2)
			)
			(8
				(lWing setLoop: 6 setCycle: End)
				(= seconds 4)
			)
			(9
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance rWingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(rWing cycleSpeed: 2 setCycle: End)
				(= seconds 2)
			)
			(2
				(rWing setCycle: Beg)
				(= seconds 3)
			)
			(3
				(= local0 0)
				(rWing setLoop: 7 setCycle: End)
				(= seconds 2)
			)
			(4
				(= local0 1)
				(rWing setLoop: 4 setCel: 0)
				(= cycles 1)
			)
			(5)
			(6
				(rWing setCycle: End)
				(= seconds 2)
			)
			(7
				(rWing setCycle: Beg)
				(= seconds 3)
			)
			(8)
			(9
				(rWing setCycle: End)
				(= seconds 4)
			)
			(10
				(rWing setCycle: Beg)
				(= seconds 2)
			)
			(11)
			(12
				(= local0 0)
				(rWing setLoop: 7 setCycle: End self)
			)
			(13
				(= local0 1)
				(rWing setLoop: 4 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(14
				(rWing setCycle: Beg)
				(= seconds 4)
			)
			(15
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance blinkScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== local0 0)
			(if (> (intro_eyes cel:) 0)
				(intro_eyes setCycle: Beg self)
			else
				(= cycles 1)
			)
			(= state 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(intro_eyes setCycle: End self)
			)
			(2
				(intro_eyes setCycle: Beg self)
				(= state -1)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance owl of Actor
	(properties
		x 189
		y 86
		view 757
	)
)

(instance intro_eyes of Prop
	(properties
		view 757
	)
)

(instance intro_mouth of Prop
	(properties
		view 757
	)
)

(instance rWing of Prop
	(properties
		view 757
	)
)

(instance lWing of Prop
	(properties
		view 757
	)
)

(instance egoHead of Prop
	(properties
		x 81
		y 118
		view 763
		cel 2
		priority 10
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (setCel)
		(super setCel: &rest)
		(self stopUpd:)
		(switch (self cel:)
			(0
				(gEgo hide:)
				(self posn: 101 105)
			)
			(1
				(gEgo hide:)
				(self posn: 103 108)
			)
			(2
				(gEgo show:)
				(self posn: 81 118)
			)
			(3
				(gEgo hide:)
				(self posn: 99 112)
			)
			(4
				(gEgo hide:)
				(self posn: 97 109)
			)
		)
	)
)

