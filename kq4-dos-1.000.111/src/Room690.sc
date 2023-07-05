;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room690 0
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
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance fairyCage of Cage
	(properties
		top 52
		left 101
		bottom 92
		right 228
	)
)

(instance Room690 of Rm
	(properties
		picture 40
		horizon 98
	)

	(method (dispose)
		(DisposeScript 988)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= gUserFont gSmallFont)
		(wave1
			view: 664
			loop: 3
			cel: 0
			posn: 40 178
			setPri: 0
			ignoreActors:
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		(wave2
			view: 664
			loop: 4
			cel: 2
			posn: 280 178
			setPri: 0
			ignoreActors:
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		(= local6 (Prop new:))
		(local6
			view: 650
			loop: 2
			cel: 2
			posn: 61 85
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			init:
		)
		((View new:)
			view: 613
			loop: 1
			cel: 0
			posn: 156 78
			setPri: 2
			init:
			addToPic:
		)
		((Act new:)
			view: 114
			illegalBits: 0
			posn: 110 60
			setCycle: Walk
			setMotion: Wander
			setPri: 3
			observeBlocks: fairyCage
			moveSpeed: 2
			ignoreHorizon:
			init:
		)
		((Act new:)
			view: 110
			illegalBits: 0
			posn: 190 80
			setCycle: Walk
			setMotion: Wander
			setPri: 3
			observeBlocks: fairyCage
			moveSpeed: 2
			ignoreHorizon:
			init:
		)
		(gEgo
			view: 106
			posn: 158 130
			setLoop: 5
			cel: 0
			setScript: egoActions
			init:
		)
		(= global205 1)
	)
)

(instance egoActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo setCycle: End self)
				(cond
					((and (gEgo has: 25) (gEgo has: 33)) ; Magic_Fruit, Magic_Hen
						((Sound new:) number: 201 play:)
					)
					((gEgo has: 25) ; Magic_Fruit
						((Sound new:) number: 200 play:)
					)
					((gEgo has: 33) ; Magic_Hen
						((Sound new:) number: 203 play:)
					)
					(else
						((Sound new:) number: 202 play:)
					)
				)
			)
			(1
				(= local2 (Act new:))
				(local2
					posn: 185 130
					view: 106
					setLoop: 4
					cel: 0
					init:
					setCycle: End self
				)
			)
			(2
				(= global120 (Print 690 0 #at -1 10 #dispose)) ; "...suddenly, you find yourself outside."
				(= seconds 5)
			)
			(3
				(cls)
				(if (gEgo has: 33) ; Magic_Hen
					(self changeState: 10)
				else
					(self changeState: 4)
				)
			)
			(4
				(if (gEgo has: 25) ; Magic_Fruit
					(self changeState: 20)
				else
					(self changeState: 100)
				)
			)
			(10
				(= global120 (Print 690 1 #at -1 20 #title {Genesta} #draw #dispose)) ; "My little Hen!" Genesta suddenly exclaims. "Where ever did you find her?"
				(= seconds 6)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo
					view: 106
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(12
				(local2 setLoop: 0 cel: 0 setCycle: End self)
				(gEgo setLoop: 5 cel: 5)
				(gGame changeScore: 2)
			)
			(13
				(local2 loop: 2 cycleSpeed: 1 setCycle: Fwd)
				(= global120 (Print 690 2 #at -1 10 #dispose)) ; "You explain that the ogre had possession of her."
				(= seconds 8)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 3 #at -1 20 #title {Genesta} #dispose)) ; "Poor thing," she says. "Well, at least she's back home now."
				(= seconds 6)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local2 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(16
				(local2 setCycle: End)
				(= local4 (Act new:))
				(local4
					view: 360
					xStep: 1
					yStep: 1
					cycleSpeed: 3
					posn: (local2 x:) (+ (local2 y:) 6)
					moveSpeed: 3
					setCycle: Walk
					setMotion: Wander
					illegalBits: -2
					init:
				)
				(= seconds 4)
			)
			(17
				(local2 cycleSpeed: 0)
				(self changeState: 4)
			)
			(20
				(= global120 (Print 690 4 #at -1 20 #title {Genesta} #dispose)) ; "Now for you, Rosella," Genesta says. "It's my turn to help YOU out. I will return you to Daventry; and with the magic fruit you will be able to save your father's life. We'd better hurry, though, as he doesn't have much time left."
				(= seconds 15)
			)
			(21
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 5 #at -1 10 #dispose)) ; "Yes, you ARE anxious to get home again."
				(= seconds 6)
			)
			(22
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 6 #at -1 20 #title {Genesta} #dispose)) ; "But first," Genesta proclaims, "let's replace these peasant clothes with your royal gown."
				(= seconds 10)
			)
			(23
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local2 view: 755 loop: 2 cel: 0 setCycle: End self)
			)
			(24
				(= local5 (Prop new:))
				(local5
					view: 680
					cel: 0
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 5 1 self
					init:
				)
			)
			(25
				(gEgo view: 757 loop: 0 cel: 1)
				(local5 setCycle: End self)
			)
			(26
				(local5 hide:)
				(= global120 (Print 690 7 #at -1 20 #title {Genesta} #dispose)) ; "With a twinkle in her eye, Genesta announces, "There is someone else deserving of a reward for his kindness and heroism.""
				(local2 loop: 3 setCycle: Fwd)
				(= seconds 10)
			)
			(27
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local2 loop: 2 cel: 0 setCycle: End self)
			)
			(28
				(= local1 (Act new:))
				(local1
					view: 107
					posn: 136 131
					loop: 0
					cel: 0
					setCycle: End self
					init:
				)
			)
			(29
				(gEgo cel: 0)
				(local1 loop: 1 cel: 0 setCycle: End self)
			)
			(30
				(= global120 (Print 690 8 #at -1 20 #title {Genesta} #dispose)) ; "You have a beautiful soul, Edgar," the fairy says to the ugly, little man. "You should look like what you are."
				(= seconds 8)
				(local2 loop: 3 setCycle: Fwd)
			)
			(31
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local2 loop: 2 cel: 0 setCycle: End self)
			)
			(32
				(local1 loop: 2 cel: 0 setCycle: End self)
				(local2 setLoop: -1 loop: 3 setCycle: Fwd)
			)
			(33
				(= seconds 4)
			)
			(34
				(local1
					view: 108
					loop: 0
					cel: 0
					cycleSpeed: 3
					setCycle: CT 3 1 self
				)
			)
			(35
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 696)
				(= local7 (Prop new:))
				(local7
					view: 787
					loop: 0
					cel: 0
					posn: 84 128
					ignoreActors:
					init:
				)
				(= local9 (Prop new:))
				(= local10 (Prop new:))
				(local9
					view: 787
					loop: 4
					cel: 1
					posn: 17 112
					setPri: 0
					cycleSpeed: 4
					setCycle: Fwd
					init:
				)
				(local10
					view: 787
					loop: 5
					cel: 3
					posn: 126 95
					setPri: 0
					cycleSpeed: 4
					setCycle: Fwd
					init:
				)
				(= local0 (Extra new:))
				(local0
					view: 787
					loop: 3
					cel: 2
					posn: 180 55
					setPri: 13
					pauseCel: 0
					minPause: 30
					maxPause: 30
					minCycles: 4
					maxCycles: 4
					init:
				)
				(= global120 (Print 690 9 #at -1 10 #dispose)) ; "This handsome hunk is Edgar?!!"
				(= seconds 6)
			)
			(36
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local7 cycleSpeed: 5 setCycle: End self)
				(= global120 (Print 690 10 #at -1 20 #title {Edgar} #dispose)) ; "Rosella," he says, "I love you. Will you marry me?"
				(= local8 (View new:))
				(local8 view: 787 loop: 2 cel: 0 posn: 92 193 setPri: 14 init:)
			)
			(37
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 11 #at -1 10 #dispose)) ; "You think about it."
				(= seconds 5)
			)
			(38
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 12 #at -1 10 #dispose)) ; "You think about it some more."
				(= seconds 5)
			)
			(39
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 13 #at -1 10 #dispose)) ; "Then..."
				(= seconds 3)
			)
			(40
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 14 #at -1 20 #title {Rosella} #dispose)) ; "I'm sorry Edgar, "You're very sweet...but, I must immediately return home."
				(local7 view: 787 loop: 1 cel: 0 posn: 72 158 setPri: 14)
				(local8 dispose:)
				(= seconds 7)
			)
			(41
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local7 dispose:)
				(local0 dispose:)
				(= global120 (Print 690 15 #at -1 20 #title {Rosella} #dispose)) ; ""Perhaps, we'll meet again," you say."
				(= seconds 4)
			)
			(42
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local9 dispose:)
				(local10 dispose:)
				(Timer setCycle: self 2)
			)
			(43
				(gCurRoom drawPic: 40)
				(gCast eachElementDo: #show)
				((View new:)
					view: 613
					loop: 1
					cel: 0
					posn: 156 78
					setPri: 2
					init:
					addToPic:
				)
				(gEgo cel: 1)
				(local1 setCycle: End)
				(= global120 (Print 690 16 #at -1 20 #title {Genesta} #dispose)) ; "Well, Rosella, " Genesta announces. "It's time for you to go. Your father desperately needs you."
				(= seconds 6)
			)
			(44
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 17 #at -1 20 #title {Genesta} #dispose)) ; "Good-bye! We'll never forget you."
				(= seconds 5)
			)
			(45
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local2 loop: 2 cel: 0 setCycle: End self)
			)
			(46
				(= local5 (Prop new:))
				(local5
					view: 680
					loop: 0
					cel: 0
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 5 1 self
					init:
				)
			)
			(47
				(gEgo hide:)
				(local5 setCycle: End self)
			)
			(48
				(gCurRoom newRoom: 693)
			)
			(100
				(local2 view: 755 setLoop: 3 cel: 8)
				(= global120 (Print 690 18 #at -1 20 #title {Genesta} #dispose)) ; "Now for you, Rosella," Genesta says. "You performed so heroically for all of us here in Tamir...but you forgot one thing...you forgot the magic fruit for your father."
				(= seconds 15)
			)
			(101
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 19 #at -1 10 #dispose)) ; "Sadly, you realize this terrible error."
				(= seconds 8)
			)
			(102
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global120 (Print 690 20 #at -1 20 #title {Genesta} #dispose)) ; "The fairy continues, "Well, it's too late now. I must immediately return you to Daventry so you may at least bid him good-bye.""
				(= seconds 10)
			)
			(103
				(local2 setLoop: 2 cel: 0 setCycle: End self)
			)
			(104
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local5 (Prop new:))
				(local5
					view: 680
					cel: 0
					posn: (gEgo x:) (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 5 1 self
					init:
				)
			)
			(105
				(gEgo view: 757 loop: 0 cel: 1)
				(local5 setCycle: End self)
			)
			(106
				(local5 hide:)
				(= global120 (Print 690 21 #at -1 20 #title {Genesta} #dispose)) ; "You look like yourself again," assesses the fairy. "You'd best be off. We won't forget you here! Good luck!"
				(= seconds 10)
			)
			(107
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local5 cel: 0 show: setCycle: CT 5 1 self)
			)
			(108
				(gEgo hide:)
				(local5 setCycle: End self)
			)
			(109
				(local5 dispose:)
				(gCurRoom newRoom: 693)
			)
		)
	)
)

