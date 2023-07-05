;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm95 0
)

(local
	work
)

(instance rm95 of Rm
	(properties
		picture 95
		horizon 1
	)

	(method (init)
		(Load rsVIEW 191)
		(Load rsVIEW 829)
		(Load rsVIEW 110)
		(Load rsVIEW 113)
		(Load rsSOUND 105)
		(super init:)
		(theSound play:)
		(gAddToPics add: aView1 aView2 aView3 aView4 doit:)
		(aBed setLoop: 9 setPri: 5 stopUpd: init:)
		(aBigEgo init:)
		(aBigEgoFace cycleSpeed: 5 setPri: 15 init:)
		(aAcid setLoop: 4 setPri: 1 cycleSpeed: 2 init: hide:)
		(aDoor setLoop: 6 illegalBits: 0 setStep: 1 1 setPri: 14 stopUpd: init:)
		(aChainWest
			setLoop: 0
			posn: 218 -5
			ignoreHorizon:
			illegalBits: 0
			setPri: 4
			setStep: 1 3
			init:
		)
		(aChainEast
			setLoop: 0
			posn: 250 -5
			ignoreHorizon:
			illegalBits: 0
			setPri: 4
			setStep: 1 3
			init:
		)
		(aLaser
			setLoop: 1
			ignoreHorizon:
			illegalBits: 0
			setPri: 13
			moveSpeed: 1
			setStep: 1 1
			init:
		)
		(aBeam
			setLoop: 3
			ignoreHorizon:
			illegalBits: 0
			setPri: 12
			setCycle: Walk
			moveSpeed: 1
			setStep: 1 1
			init:
			hide:
		)
		(if (== gCurrentHenchView 0)
			(= gCurrentHenchView 205)
		)
		(aHench
			view: gCurrentHenchView
			illegalBits: 0
			setCycle: Walk
			init:
			setScript: henchScript
		)
		(self setScript: rm95Script)
		(= gCurrentEgoView 100)
		(NormalEgo)
		(gEgo loop: 2 posn: 32 150 init:)
		(HandsOff)
	)
)

(instance rm95Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 95 0) ; "You are so impressed! You've never had a girl invite you to her pad before -- not to mention her landing pad!"
				(aDoor setMotion: MoveTo 9 138 self)
			)
			(2
				(aDoor stopUpd:)
				(henchScript cue:)
			)
			(3
				(gEgo setMotion: MoveTo 31 183 self)
			)
			(4
				(gEgo setMotion: MoveTo 163 183 self)
			)
			(5
				(gEgo setMotion: MoveTo 163 111 self)
			)
			(6
				(gEgo setMotion: MoveTo 209 111 self)
			)
			(7
				(gEgo
					view: 191
					setLoop: 1
					setPri: 11
					posn: 235 95
					cycleSpeed: 1
					cel: 0
					setCycle: End self
				)
			)
			(8
				(gEgo
					cycleSpeed: 2
					setLoop: 2
					cel: 0
					posn: 235 105
					setCycle: End self
				)
			)
			(9
				(Print 95 1 #draw) ; "Hey, baby," you say, "What a great, kinky bed!"
				(= seconds 3)
			)
			(10
				(gEgo cycleSpeed: 1 setLoop: 3 cel: 0 setCycle: End self)
			)
			(11
				(gEgo setLoop: 7 setCycle: Fwd)
				(= cycles 20)
			)
			(12
				(Print 95 2 #at -1 20 #draw) ; "Hey! What's going on here?" you shout. "Get these ankle cuffs off me! And, why the handcuffs?"
				(= seconds 3)
			)
			(13
				(Print 95 3 #at -1 20) ; "Oh, I'm just into mechanical devices," she replies with a smile. "Hold still, darling, this will only take a second."
				(= seconds 3)
			)
			(14
				(aChainWest setMotion: MoveTo 218 90 self)
				(aChainEast setMotion: MoveTo 250 90)
			)
			(15
				(= seconds 3)
			)
			(16
				(aBed hide:)
				(gEgo
					setLoop: 4
					cel: 0
					posn: 214 105
					cycleSpeed: 1
					setCycle: End self
				)
				(aChainWest setStep: 1 2 setMotion: MoveTo 218 45)
				(aChainEast setStep: 1 2 setMotion: MoveTo 250 45)
			)
			(17
				(gEgo setStep: 1 2 setMotion: MoveTo 214 89 self)
			)
			(18
				(gEgo stopUpd:)
				(aChainWest setMotion: 0 stopUpd:)
				(aChainWest setMotion: 0 stopUpd:)
				(aAcid show: setCycle: End self)
			)
			(19
				(aAcid setLoop: 2 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 15)
			)
			(20
				(Print 95 4 #at -1 20) ; ""Why does that look like hydrofluoric acid below me?" you shout in terror."
				(Print 95 5 #at -1 20) ; ""Because it is, silly," she responds."
				(= seconds 3)
			)
			(21
				(aLaser setMotion: MoveTo 234 29 self)
			)
			(22
				(aBigEgo posn: 172 38 stopUpd:)
				(aBigEgoFace posn: 172 38 setCycle: End)
				(aLaser setStep: 1 1 moveSpeed: 1 setMotion: MoveTo 234 -2)
				(aBeam
					posn: 234 27
					setStep: 1 1
					cycleSpeed: 0
					moveSpeed: 1
					show:
					setMotion: MoveTo 234 21 self
				)
			)
			(23
				(Print 95 6 #at -1 130) ; "Well, Larry; this brings a whole new meaning to the term "dismemberment!""
				(aBeam setMotion: MoveTo 234 0 self)
				(aBed view: 191 loop: 0 posn: 214 88 show:)
				(gEgo
					setLoop: 5
					posn: (+ (gEgo x:) 8) (- (gEgo y:) 5)
					cel: 0
					cycleSpeed: 6
					setCycle: End
				)
				(= cycles 10)
			)
			(24
				(aBigEgoFace dispose:)
				(aBigEgo dispose:)
			)
			(25
				(aLaser dispose:)
				(aBeam dispose:)
				(gEgo
					setLoop: 6
					setCel: 0
					setStep: 1 7
					posn: 235 90
					setMotion: MoveTo 235 134 self
				)
			)
			(26
				(gEgo setMotion: 0 cycleSpeed: 0 setCycle: End self)
			)
			(27
				(= seconds 3)
			)
			(28
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance henchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aHench setMotion: MoveTo 37 169 self)
			)
			(2
				(aHench setMotion: MoveTo 39 181 self)
				(rm95Script cue:)
			)
			(3
				(aHench setMotion: MoveTo 139 181 self)
			)
			(4
				(Print 95 7) ; ""You just wait over there on the bed, while I slip something," she says with a smile."
				(aHench setMotion: MoveTo 139 131 self)
			)
			(5
				(Print 95 8) ; "Perhaps if things go well tonight," you think to yourself, "I could give her a subscription to 'Popular Mechanics!'"
				(aHench setMotion: MoveTo 49 91 self)
			)
			(6
				(aHench setLoop: 3 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 105
	)
)

(instance aView1 of PV
	(properties
		y 175
		x 35
		view 829
		loop 8
		priority 9
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 137
		x 9
		view 829
		loop 5
		priority 13
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 68
		x 33
		view 829
		loop 7
		priority 1
		signal 16384
	)
)

(instance aView4 of PV
	(properties
		y 68
		x 58
		view 829
		loop 7
		signal 16384
	)
)

(instance aBed of View
	(properties
		y 105
		x 214
		view 829
		signal 16384
	)
)

(instance aBigEgo of View
	(properties
		y 1038
		x 172
		view 110
		priority 14
		signal 16384
	)
)

(instance aBigEgoFace of Prop
	(properties
		y 1038
		x 172
		view 113
		signal 16384
	)
)

(instance aAcid of Prop
	(properties
		y 136
		x 235
		view 829
		signal 16384
	)
)

(instance aDoor of Act
	(properties
		y 137
		x 35
		view 829
		signal 16384
	)
)

(instance aChainWest of Act
	(properties
		view 829
		signal 16384
	)
)

(instance aChainEast of Act
	(properties
		view 829
		signal 16384
	)
)

(instance aLaser of Act
	(properties
		y -5
		x 234
		view 829
		signal 16384
	)
)

(instance aBeam of Act
	(properties
		y 27
		x 234
		view 829
		signal 16384
	)
)

(instance aHench of Act
	(properties
		y 154
		x 36
		signal 16384
	)
)

